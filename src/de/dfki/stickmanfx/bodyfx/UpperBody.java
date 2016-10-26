package de.dfki.stickmanfx.bodyfx;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import de.dfki.stickmanfx.StickmanFX;
import de.dfki.stickmanfx.bodyfx.NeckFX.SHAPE;

import java.awt.Dimension;
import java.awt.Point;
import java.net.URL;
import com.interactivemesh.jfx.importer.col.ColModelImporter;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.MeshView;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Rotate;
/**
 *
 * @author Beka Aptsiauri
 *
 */
public class UpperBody extends BodyPartFX {

	public static enum SHAPE {
		DEFAULT, FADEIN, FADEOUT
	};
	
	public UpperBody.SHAPE mShape = UpperBody.SHAPE.DEFAULT;
	
	NeckFX mNeckFX;
	Rotate rx;
	Rotate ry;
	Rotate rz;

	Dimension mSize = new Dimension(120, 300);

	int mHalfSizeX = mSize.width / 2;
	int mHalfSizeY = mSize.height / 2;
	int mDrawOffset = 20;

	Group mUpperBodyGroup;

	URL url;
	ColModelImporter imorter;
	MeshView mBodyMeshView;
	PhongMaterial material;

	public UpperBody(NeckFX neck) {
		mNeckFX = neck;
		mStart = mNeckFX.getBodyStartPosition();
		imorter = new ColModelImporter();

		if (mNeckFX.mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.FEMALE) {
			url = getClass().getClassLoader().getResource("BodyParts/UpperFemaleBody.dae");
			mColor = Color.rgb(154, 83, 198, 1);
		} else {
			url = getClass().getClassLoader().getResource("BodyParts/UpperMaleBody1.dae");
			mColor = Color.rgb(14, 134, 122, 1);
		}

		imorter.read(url);
		mUpperBodyGroup = new Group();
		mBodyMeshView = (MeshView) imorter.getImport()[0];
		mBodyMeshView.setId("uppeBody");
		material = new PhongMaterial();
		material.setDiffuseColor(mColor);
		mBodyMeshView.setMaterial(material);
		mUpperBodyGroup.getChildren().add(mBodyMeshView);
		init();
	}

	@Override
	public void setShape(String s) {
		SHAPE shape = SHAPE.valueOf(s);
		mShape = (shape != null) ? shape : SHAPE.DEFAULT;
	}

	@Override
	public void resetShape() {
		mShape = UpperBody.SHAPE.DEFAULT;
	}
	
	public void calculate(int step) {
		mStart = mNeckFX.getBodyStartPosition();
		clearChildren(this);
		mUpperBodyGroup.setTranslateX(mStart.x);
		if (mNeckFX.mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.MALE) {
			mUpperBodyGroup.setTranslateY(mStart.y + 135);
			mUpperBodyGroup.setTranslateZ(-105);
		} else {
			mUpperBodyGroup.setTranslateY(mStart.y + 135);
			mUpperBodyGroup.setTranslateZ(-105);
		}

		rx = new Rotate(mXRotation, Rotate.X_AXIS);

		if (mNeckFX.mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.MALE)
		{
			rx = new Rotate(mXRotation, 0, 10, 0, Rotate.X_AXIS);
		}
		else
		{
			rx = new Rotate(mXRotation, Rotate.X_AXIS);
		}
		
		ry = new Rotate(mYRotation, Rotate.Y_AXIS);
		rz = new Rotate(mZRotation, Rotate.Z_AXIS);

		mUpperBodyGroup.getTransforms().clear();
		mUpperBodyGroup.getTransforms().addAll(rx, ry, rz);
		
		switch(mShape)
		{
		case FADEIN:
			if(step == 2)
			{
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), 0.0);
				update();
				mBodyMeshView.setVisible(false);
			}
			else if(mColor.getOpacity() != 0.0)
			{
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), mColor.getOpacity() - 0.052);
				update();
			}
			break;
			
		case FADEOUT:
			mBodyMeshView.setVisible(true);
			
			if(step == 2)
			{
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), 1.0);
				update();
			}
			else if(mColor.getOpacity() != 1.0)
			{
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), mColor.getOpacity() + 0.052);
				update();
			}
			break;
		}
		
		this.getChildren().addAll(mUpperBodyGroup);
	}

	public Point getLeftArmStartPostion() {
		return new Point(mStart.x - 39, mStart.y - 178);
	}

	public Point getDownBodyPosition() {
		return new Point(mStart.x, mStart.y);
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
		material.setDiffuseColor(mColor);
		mBodyMeshView.setMaterial(material);
	}

	public void rotatePerlinNoise(double mWobble, int x, int y) {
		Affine af = new Affine();
		// Out put perlin noise
		af.appendRotation(Math.toRadians(mWobble), x, y);
		this.getTransforms().clear();
		this.getTransforms().add(af);

	}

}
