package de.dfki.stickmanfx.bodyfx;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import de.dfki.stickmanfx.StickmanFX;
import java.awt.Dimension;
import java.awt.Point;
import java.net.URL;

import com.interactivemesh.jfx.importer.col.ColModelImporter;

import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;
import javafx.scene.shape.Sphere;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Rotate;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class BodyFX extends BodyPartFX {

	NeckFX mNeckFX;

	Dimension mSize = new Dimension(120, 300);

	int mHalfSizeX = mSize.width / 2;
	int mHalfSizeY = mSize.height / 2;
	int mDrawOffset = 20;

	URL url;
	ColModelImporter importer;
	MeshView bodyMeshView;

	public Color mFemaleColor = Color.rgb(154, 83, 198, (240 * 100 / 255) / 100f);
	public Color mMaleColor = Color.rgb(14, 134, 122, (240 * 100 / 255) / 100f);
	public Color mColor = mFemaleColor;
	public Color currentColor = null;

	private Color mFemaleColorRecorder = mFemaleColor;
	private Color mMaleColorRecorder = mMaleColor;

	public BodyFX(NeckFX neck) {
		mNeckFX = neck;
		mStart = mNeckFX.getBodyStartPosition();
		mColor = (mNeckFX.mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.FEMALE) ? mFemaleColor : mMaleColor;

		 if(mNeckFX.mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.FEMALE)
			 url = getClass().getClassLoader().getResource("BodyParts/femaleBody.dae");
		 else
			 url = getClass().getClassLoader().getResource("BodyParts/MaleBody.dae");

		importer = new ColModelImporter();
		importer.read(url);
		bodyMeshView = (MeshView) importer.getImport()[0];

		init();
	}

	public void calculate(int step) {
		mStart = mNeckFX.getBodyStartPosition();
		clearChildren(this);
		bodyMeshView.setTranslateX(mStart.x);
		bodyMeshView.setTranslateY(mStart.y + 135);
		bodyMeshView.setTranslateZ(-100);

		Rotate rx = new Rotate(mRotation, Rotate.X_AXIS);
		Rotate ry = new Rotate(mYRotation, Rotate.Y_AXIS);
		Rotate rz = new Rotate(mZRotation, Rotate.Z_AXIS);

		bodyMeshView.getTransforms().clear();
		bodyMeshView.getTransforms().addAll(rx, ry, rz);
		
//		if (mNeckFX.mHeadFX.mStickmanFX.mLeftUpperArmFX != null) {
//			mNeckFX.mHeadFX.mStickmanFX.mLeftUpperArmFX.mRotation = this.mRotation;
//			mNeckFX.mHeadFX.mStickmanFX.mLeftUpperArmFX.mYRotation = this.mYRotation;
//			mNeckFX.mHeadFX.mStickmanFX.mLeftUpperArmFX.mZRotation = this.mZRotation;
//			mNeckFX.mHeadFX.mStickmanFX.mLeftUpperArmFX.calculate(step);
//		}

		this.getChildren().addAll(bodyMeshView);
		// update();
	}

	public Point getLeftArmStartPostion() {
		return new Point(mStart.x + 1, mStart.y);
	}

	public Point getRightArmStartPostion() {
		return new Point(mStart.x - 1, mStart.y);
	}

	public Point getLeftLegStartPostion() {
		if (mNeckFX.mHeadFX.mStickmanFX.mOrientation == StickmanFX.ORIENTATION.LEFT) {
			return new Point(mStart.x + mHalfSizeX - mDrawOffset, mSize.height);
		} else {
			return new Point(mStart.x + mHalfSizeX - mDrawOffset - 20,
					(mNeckFX.mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.FEMALE) ? mSize.height + 3 : mSize.height);
		}
	}

	public Point getRightLegStartPostion() {
		if (mNeckFX.mHeadFX.mStickmanFX.mOrientation == StickmanFX.ORIENTATION.RIGHT) {
			return new Point(mStart.x, mSize.height);
		} else {
			return new Point(mStart.x - mHalfSizeX + mDrawOffset + 20,
					(mNeckFX.mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.FEMALE) ? mSize.height + 5 : mSize.height);
		}
	}

	public void update() {
		if (mNeckFX.mHeadFX.mStickmanFX.setCharacterInvisible == false) {
			mFemaleColorRecorder = mFemaleColor;
			mMaleColorRecorder = mMaleColor;
		}
		if (mNeckFX.mHeadFX.mStickmanFX.setCharacterInvisible == true) {
			if (mNeckFX.mHeadFX.mStickmanFX.fadeControler == true) {
				int fadeFactor = mNeckFX.mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep * 12;
				if (fadeFactor <= 24) {
					fadeFactor = 0;
				}
				mFemaleColor = new Color(mFemaleColor.getRed(), mFemaleColor.getGreen(), mFemaleColor.getBlue(),
						(fadeFactor * 100 / 255) / 100f);
				mMaleColor = new Color(mMaleColor.getRed(), mMaleColor.getGreen(), mMaleColor.getBlue(),
						(fadeFactor * 100 / 255) / 100f);
			} else {
				int fadeFactor = (20 - mNeckFX.mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep) * 9;
				if (fadeFactor >= 160) {
					mFemaleColor = mFemaleColorRecorder;
					mMaleColor = mMaleColorRecorder;
				} else {
					mFemaleColor = new Color(mFemaleColor.getRed(), mFemaleColor.getGreen(), mFemaleColor.getBlue(),
							(fadeFactor * 100 / 255) / 100f);
					mMaleColor = new Color(mMaleColor.getRed(), mMaleColor.getGreen(), mMaleColor.getBlue(),
							(fadeFactor * 100 / 255) / 100f);
				}
			}
		}

		if (mNeckFX.mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.FEMALE) {
			currentColor = mFemaleColor;
		} else {
			currentColor = mMaleColor;
		}

	}

	public void rotatePerlinNoise(double mWobble, int x, int y) {
		Affine af = new Affine();
		// Out put perlin noise
		af.appendRotation(Math.toRadians(mWobble), x, y);
		this.getTransforms().clear();
		this.getTransforms().add(af);

	}

}
