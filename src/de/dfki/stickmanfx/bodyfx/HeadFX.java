package de.dfki.stickmanfx.bodyfx;

import de.dfki.stickmanfx.StickmanFX;
import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Point;
import java.net.URL;

import com.interactivemesh.jfx.importer.col.ColModelImporter;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.scene.AmbientLight;
import javafx.scene.DepthTest;
import javafx.scene.PointLight;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class HeadFX extends BodyPartFX {
	public Dimension mSize = new Dimension(120, 100);
	public StickmanFX mStickmanFX;

	int mHalfHeight = mSize.height / 2;
	int mHalfWidth = mSize.width / 2;
	int mPivotOffset = 55;
	int mZTranslate = -100; // Bring shape in front, because of DepthTest
	
	int mEarWidth = 10;

	int mDrawOffset = 10;
	int mXCenterOffset = mEarWidth / 2;
	int mYCenterOffset = mEarWidth / 2;

	URL url;
	ColModelImporter imorter;
	MeshView headMeshView;

	int mHeadRadius = 60;
	int mHeadHeight = 30;

	public HeadFX(StickmanFX sm) 
	{
		mStickmanFX = sm;
		mDefaultRotationPoint = new Point(mSize.width / 2, mSize.height);

		url = getClass().getClassLoader().getResource("BodyParts/head.dae");
		imorter = new ColModelImporter();
		imorter.read(url);
		headMeshView = (MeshView) imorter.getImport()[0];

		mColor = Color.rgb(242, 227, 217, 1);
		
		mYRotation = -0;
		init();

		calculate(0);
	}

	public Point getLeftEyebrowPostion() 
	{
		return new Point(mHalfWidth + 1, mHalfHeight + 61);
	}

	public Point getRightEyebrowPostion() 
	{
		return new Point(mHalfWidth - 1, mHalfHeight + 61);
	}

	public Point getLeftEyePostion() 
	{
		return new Point(mHalfWidth + 2, mHalfHeight + 62);
	}

	public Point getRightEyePostion() 
	{
		return new Point(mHalfWidth, mHalfHeight + 62);
	}

	public Point getMouthPostion() 
	{
		return new Point(mHalfWidth + mEarWidth / 2 - 3, mHalfHeight + mDrawOffset * 3 + 25);
	}

	public Point getSpeechBubbleStartPosition() 
	{
		return new Point(mHalfWidth + 20, mHalfHeight + 30);
	}

	public Point getThinkhBubbleStartPosition() 
	{
		return new Point(mHalfWidth, mHalfHeight);
	}

	public Point getBombeStartPosition() 
	{
		return new Point(mHalfWidth + 100, mHalfHeight - 50);
	}

	public Point getBombeEndPosition() 
	{
		return new Point(mHalfWidth + 100, mStickmanFX.mRightForeLegFX.getLegStartPosition().y - 50);
	}

	public Point getNeckStartPosition() 
	{
		return new Point(mSize.width / 2 + mXCenterOffset, mSize.height + mYCenterOffset + 4);
	}

	public void calculate(int step) 
	{
		clearChildren(this);
		
		headMeshView.setTranslateX(mHalfWidth);
		headMeshView.setTranslateY(mHalfHeight + mPivotOffset);
		headMeshView.setTranslateZ(mZTranslate);

		Rotate rx = new Rotate(mRotation, Rotate.X_AXIS);
		Rotate ry = new Rotate(mYRotation, Rotate.Y_AXIS);
		Rotate rz = new Rotate(mZRotation, Rotate.Z_AXIS);

		headMeshView.getTransforms().clear();
		headMeshView.getTransforms().addAll(rx, ry, rz);

		if (mStickmanFX.mFemaleHairFX != null) {
			mStickmanFX.mFemaleHairFX.mRotation = this.mRotation;
			mStickmanFX.mFemaleHairFX.mYRotation = this.mYRotation;
			mStickmanFX.mFemaleHairFX.mZRotation = this.mZRotation;
			mStickmanFX.mFemaleHairFX.calculate(step);
		}

		if (mStickmanFX.mLeftEyeFX != null) {
			mStickmanFX.mLeftEyeFX.mRotation = this.mRotation;
			mStickmanFX.mLeftEyeFX.mYRotation = this.mYRotation;
			mStickmanFX.mLeftEyeFX.mZRotation = this.mZRotation;
			mStickmanFX.mLeftEyeFX.calculate(step);
		}

		if (mStickmanFX.mRightEyeFX != null) {
			mStickmanFX.mRightEyeFX.mRotation = this.mRotation;
			mStickmanFX.mRightEyeFX.mYRotation = this.mYRotation;
			mStickmanFX.mRightEyeFX.mZRotation = this.mZRotation;
			mStickmanFX.mRightEyeFX.calculate(step);
		}

		if (mStickmanFX.mLeftEyebrowFX != null) {
			mStickmanFX.mLeftEyebrowFX.mRotation = this.mRotation;
			mStickmanFX.mLeftEyebrowFX.mYRotation = this.mYRotation;
			mStickmanFX.mLeftEyebrowFX.mZRotation = this.mZRotation;
			mStickmanFX.mLeftEyebrowFX.calculate(step);
		}

		if (mStickmanFX.mRightEyebrowFX != null) {
			mStickmanFX.mRightEyebrowFX.mRotation = this.mRotation;
			mStickmanFX.mRightEyebrowFX.mYRotation = this.mYRotation;
			mStickmanFX.mRightEyebrowFX.mZRotation = this.mZRotation;
			mStickmanFX.mRightEyebrowFX.calculate(step);
		}

		if (mStickmanFX.mMouthFX != null) {
			mStickmanFX.mMouthFX.mRotation = this.mRotation;
			mStickmanFX.mMouthFX.mYRotation = this.mYRotation;
			mStickmanFX.mMouthFX.mZRotation = this.mZRotation;
			mStickmanFX.mMouthFX.calculate(step);
		}

		if (mStickmanFX.mMaleHairFX != null) {
			mStickmanFX.mMaleHairFX.mRotation = this.mRotation;
			mStickmanFX.mMaleHairFX.mYRotation = this.mYRotation;
			mStickmanFX.mMaleHairFX.mZRotation = this.mZRotation;
			mStickmanFX.mMaleHairFX.calculate(step);
		}

		this.getChildren().addAll(headMeshView);
		// update();

	}

	public void update() {
		if (mStickmanFX.setCharacterInvisible == false)
			mColorRecorder = mColor;
		
		if (mStickmanFX.setCharacterInvisible == true) 
		{
			if (mStickmanFX.fadeControler == true)
			{

				int fadeFactor = mStickmanFX.mMouthFX.mShapeAnimationStep * 10;
				if (fadeFactor <= 20)
				{
					fadeFactor = 0;
				}
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(),
						(fadeFactor * 100 / 255) / 100f);
			} 
			else 
			{
				int fadeFactor = (20 - mStickmanFX.mMouthFX.mShapeAnimationStep) * 9;
				if (fadeFactor >= 160) 
				{
					mColor = mColorRecorder;
				} 
				else
					mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(),
							(fadeFactor * 100 / 255) / 100f);
			}
		}
	}
}
