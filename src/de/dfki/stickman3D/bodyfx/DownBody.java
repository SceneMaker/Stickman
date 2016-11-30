package de.dfki.stickman3D.bodyfx;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.interactivemesh.jfx.importer.col.ColModelImporter;
import de.dfki.common.Gender;
import de.dfki.stickman3D.Stickman3D;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.MeshView;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Rotate;

import java.awt.*;
import java.net.URL;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class DownBody extends BodyPartFX {

	public static enum SHAPE {
		DEFAULT, FADEIN, FADEOUT
	};
	
	public DownBody.SHAPE mShape = DownBody.SHAPE.DEFAULT;

	UpperBody mUpperBody;
	Rotate rx;
	Rotate ry;
	Rotate rz;

	Dimension mSize = new Dimension(120, 300);

	int mHalfSizeX = mSize.width / 2;
	int mHalfSizeY = mSize.height / 2;
	int mDrawOffset = 20;

	Group mDownBodyGroup;

	URL url;
    ColModelImporter imorter;
    MeshView mBodyMeshView;
	PhongMaterial material;


	public DownBody(UpperBody upperBody) {
		mUpperBody = upperBody;
		mStart = mUpperBody.getDownBodyPosition();
		imorter = new ColModelImporter();

		if (mUpperBody.mNeckFX.mHeadFX.mStickmanFX.mType == Gender.TYPE.FEMALE) {
			url = getClass().getClassLoader().getResource("BodyParts/DownFemaleBody.dae");
			mColor = Color.rgb(154, 83, 198, 1);
		} else {
			url = getClass().getClassLoader().getResource("BodyParts/DownMaleBody1.dae");
			mColor = Color.rgb(14, 134, 122, 1);
		}

		imorter.read(url);
		mDownBodyGroup = new Group();
		mBodyMeshView = (MeshView) imorter.getImport()[0];
		mBodyMeshView.setId("downBody");
		material = new PhongMaterial();
		material.setDiffuseColor(mColor);
		mBodyMeshView.setMaterial(material);
		mDownBodyGroup.getChildren().add(mBodyMeshView);

		mStart = mUpperBody.getDownBodyPosition();
		init();
		this.getChildren().addAll(mDownBodyGroup);
	}

	@Override
	public void init()
	{
		super.init();
		mDownBodyGroup.setTranslateX(mStart.x);
		if(mUpperBody.mNeckFX.mHeadFX.mStickmanFX.mType == Gender.TYPE.MALE)
		{
			mDownBodyGroup.setTranslateY(mStart.y + 135);
			mDownBodyGroup.setTranslateZ(-105);
		}
		else
		{
			mDownBodyGroup.setTranslateY(mStart.y + 135);
			mDownBodyGroup.setTranslateZ(-105);
		}
	}

	@Override
	public void setShape(String s) {
		SHAPE shape = SHAPE.valueOf(s);
		mShape = (shape != null) ? shape : SHAPE.DEFAULT;
	}

	@Override
	public void resetShape() {
		mShape = DownBody.SHAPE.DEFAULT;
	}
	
	public void calculate(int step) {
		
		rx = new Rotate(mXRotation, Rotate.X_AXIS);
		if(mUpperBody.mNeckFX.mHeadFX.mStickmanFX.mType == Gender.TYPE.MALE)
			ry = new Rotate(mYRotation,  Rotate.Y_AXIS);
		else
			ry = new Rotate(mYRotation,  Rotate.Y_AXIS);
		
		rz = new Rotate(mZRotation, Rotate.Z_AXIS);

		mDownBodyGroup.getTransforms().clear();
		mDownBodyGroup.getTransforms().addAll(rx, ry, rz);
		
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
	}

	public Point getLeftArmStartPostion() {
		return new Point(mStart.x - 39, mStart.y - 178);
	}

	public Point getRightArmStartPostion() {
		return new Point(mStart.x - 90, mStart.y - 178);
	}

	public Point getLeftLegStartPostion() {
		if (mUpperBody.mNeckFX.mHeadFX.mStickmanFX.mOrientation == Stickman3D.ORIENTATION.LEFT) {
			return new Point(mStart.x + mHalfSizeX - mDrawOffset, mSize.height);
		} else {
			return new Point(mStart.x + mHalfSizeX - mDrawOffset - 20,
					(mUpperBody.mNeckFX.mHeadFX.mStickmanFX.mType == Gender.TYPE.FEMALE) ? mSize.height + 3 : mSize.height);
		}
	}

	public Point getRightLegStartPostion() {
		if (mUpperBody.mNeckFX.mHeadFX.mStickmanFX.mOrientation == Stickman3D.ORIENTATION.RIGHT) {
			return new Point(mStart.x, mSize.height);
		} else {
			return new Point(mStart.x - mHalfSizeX + mDrawOffset + 20,
					(mUpperBody.mNeckFX.mHeadFX.mStickmanFX.mType == Gender.TYPE.FEMALE) ? mSize.height + 5 : mSize.height);
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
