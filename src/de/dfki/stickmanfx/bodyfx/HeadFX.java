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
import javafx.scene.Group;
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
	Group mHead;

	int mHeadRadius = 60;
	int mHeadHeight = 30;

	public HeadFX(StickmanFX sm) {
		mStickmanFX = sm;
		mDefaultRotationPoint = new Point(mSize.width / 2, mSize.height);

		if(mStickmanFX.mType == StickmanFX.TYPE.MALE)
			url = getClass().getClassLoader().getResource("BodyParts/maleHead.dae");
		else
			url = getClass().getClassLoader().getResource("BodyParts/femaleHead.dae");
		imorter = new ColModelImporter();
		imorter.read(url);
		mHead = (Group) imorter.getImport()[0];
		System.out.println(mHead.getChildren());

		mColor = Color.rgb(242, 227, 217, 1);

		mYRotation = -0;
		init();

		calculate(0);
	}

	public Point getLeftEyebrowPostion() {
		return new Point(mHalfWidth - 60, mHalfHeight - 105);
	}

	public Point getRightEyebrowPostion() {
		return new Point(mHalfWidth - 60, mHalfHeight - 105);
	}

	public Point getLeftEyePostion() {
		return new Point(mHalfWidth - 60, mHalfHeight - 105);
	}

	public Point getRightEyePostion() {
		return new Point(mHalfWidth, mHalfHeight + 62);
	}

	public Point getMouthPostion() {
		return new Point(mHalfWidth-60, mHalfHeight-110 );
	}

	public Point getSpeechBubbleStartPosition() {
		return new Point(mHalfWidth + 20, mHalfHeight + 30);
	}

	public Point getThinkhBubbleStartPosition() {
		return new Point(mHalfWidth, mHalfHeight);
	}

	public Point getBombeStartPosition() {
		return new Point(mHalfWidth + 100, mHalfHeight - 50);
	}

	public Point getBombeEndPosition() {
		return new Point(0, 0);
		// return new Point(mHalfWidth + 100,
		// mStickmanFX.mRightForeLegFX.getLegStartPosition().y - 50);
	}

	public Point getNeckStartPosition() {
		return new Point(mSize.width / 2 + mXCenterOffset, mSize.height + mYCenterOffset + 4);
	}

	public void calculate(int step) {
		clearChildren(this);

		mHead.setTranslateX(mHalfWidth);
		mHead.setTranslateY(mHalfHeight + mPivotOffset);
		mHead.setTranslateZ(mZTranslate);

		Rotate rx = new Rotate(mXRotation, Rotate.X_AXIS);
		Rotate ry = new Rotate(mYRotation, Rotate.Y_AXIS);
		Rotate rz = new Rotate(mZRotation, Rotate.Z_AXIS);

		mHead.getTransforms().clear();
		mHead.getTransforms().addAll(rx, ry, rz);

		this.getChildren().addAll(mHead);
		// update();

	}

	public void update() {
		if (mStickmanFX.setCharacterInvisible == false)
			mColorRecorder = mColor;

		if (mStickmanFX.setCharacterInvisible == true) {
			if (mStickmanFX.fadeControler == true) {

				int fadeFactor = mStickmanFX.mMouthFX.mShapeAnimationStep * 10;
				if (fadeFactor <= 20) {
					fadeFactor = 0;
				}
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(),
						(fadeFactor * 100 / 255) / 100f);
			} else {
				int fadeFactor = (20 - mStickmanFX.mMouthFX.mShapeAnimationStep) * 9;
				if (fadeFactor >= 160) {
					mColor = mColorRecorder;
				} else
					mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(),
							(fadeFactor * 100 / 255) / 100f);
			}
		}
	}
}
