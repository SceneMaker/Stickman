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
import com.interactivemesh.jfx.importer.stl.StlMeshImporter;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.TriangleMesh;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Translate;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class BodyFX extends BodyPartFX {

	NeckFX mNeckFX;
	Rotate rx;
	Rotate ry;
	Rotate rz;

	Dimension mSize = new Dimension(120, 300);

	int mHalfSizeX = mSize.width / 2;
	int mHalfSizeY = mSize.height / 2;
	int mDrawOffset = 20;
	
	TriangleMesh mBodyTriangloangleMesh;;
	MeshView mBodyMeshView;
	PhongMaterial material;

	URL url;
	StlMeshImporter im;
	Group mBodyModel;

	public Color mFemaleColor = Color.rgb(154, 83, 198, (240 * 100 / 255) / 100f);
	public Color mMaleColor = Color.rgb(14, 134, 122, (240 * 100 / 255) / 100f);
	public Color mColor = mFemaleColor;
	public Color currentColor = null;

	private Color mFemaleColorRecorder = mFemaleColor;
	private Color mMaleColorRecorder = mMaleColor;

	public BodyFX(NeckFX neck) {
		mNeckFX = neck;
		mStart = mNeckFX.getBodyStartPosition();
		im = new StlMeshImporter();

		mColor = (mNeckFX.mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.FEMALE) ? mFemaleColor : mMaleColor;
		
		if (mNeckFX.mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.FEMALE) {
			url = getClass().getClassLoader().getResource("BodyParts/FemaleBody1.stl");
		} else {
			url = getClass().getClassLoader().getResource("BodyParts/MaleBody1.stl");
		}
		
		im.read(url);
		mBodyModel = new Group();
		mBodyTriangloangleMesh = im.getImport();
		
		mBodyMeshView = new MeshView(mBodyTriangloangleMesh);
		mBodyMeshView.setId("BodyMesh");
		material = new PhongMaterial();
		material.setDiffuseColor(mColor);
		mBodyMeshView.setMaterial(material);
		mBodyMeshView.setRotationAxis(Rotate.X_AXIS);
		mBodyMeshView.setRotate(-90);
		mBodyModel.getChildren().add(mBodyMeshView);
		init();
	}

	public void calculate(int step) {
		mStart = mNeckFX.getBodyStartPosition();
		clearChildren(this);
		mBodyModel.setTranslateX(mStart.x);
		if(mNeckFX.mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.MALE)
		{
			mBodyModel.setTranslateY(mStart.y + 82);
			mBodyModel.setTranslateZ(-52);
		}
		else
		{
			mBodyModel.setTranslateY(mStart.y + 95);
			mBodyModel.setTranslateZ(-60);
		}
		
		rx = new Rotate(mXRotation, 0, 35, -52, Rotate.X_AXIS);
		
		if(mNeckFX.mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.MALE)
			ry = new Rotate(mYRotation, 0, 35, -52, Rotate.Y_AXIS);
		else
			ry = new Rotate(mYRotation, 0, 35, -40, Rotate.Y_AXIS);
		
		rz = new Rotate(mZRotation, 0, 0, 0, Rotate.Z_AXIS);

		mBodyModel.getTransforms().clear();
		mBodyModel.getTransforms().addAll(rx, ry, rz);
		this.getChildren().addAll(mBodyModel);
		// update();
	}

	public void updateAfterRotation() {
//		mStart = mNeckFX.getBodyStartPosition();
//		clearChildren(this);
//
//		mBodyModel.setTranslateX(mStart.x);
//		mBodyModel.setTranslateY(mStart.y + 135);
//		mBodyModel.setTranslateZ(-100);
//
//		this.getChildren().addAll(mBodyModel);
	}

	public Point getLeftArmStartPostion() {
		return new Point(mStart.x - 39, mStart.y - 178);
	}

	public Point getRightArmStartPostion() {
		return new Point(mStart.x - 90, mStart.y - 178);
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
