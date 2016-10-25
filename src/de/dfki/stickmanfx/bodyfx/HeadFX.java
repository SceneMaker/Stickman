package de.dfki.stickmanfx.bodyfx;

import de.dfki.stickmanfx.StickmanFX;
import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Point;
import java.net.URL;

import com.interactivemesh.jfx.importer.col.ColModelImporter;
import com.interactivemesh.jfx.importer.stl.StlMeshImporter;

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
import javafx.scene.shape.TriangleMesh;
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
	TriangleMesh mHeadTriangleMesh;
	MeshView mHeadMeshView;
	PhongMaterial material;

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
	StlMeshImporter im;
	Group mHead;

	int mHeadRadius = 60;
	int mHeadHeight = 30;

	public HeadFX(StickmanFX sm) {
		mStickmanFX = sm;
		mDefaultRotationPoint = new Point(mSize.width / 2, mSize.height);
		mColor = Color.rgb(242, 227, 217, 1);
		
			url = getClass().getClassLoader().getResource("BodyParts/maleHead.stl");
			im = new StlMeshImporter();
			im.read(url);
			mHead = new Group();
			mHeadTriangleMesh = im.getImport();
			
			mHeadMeshView = new MeshView(mHeadTriangleMesh);
			mHeadMeshView.setId("MaleHead");
			material = new PhongMaterial();
			material.setDiffuseColor(mColor);
			mHeadMeshView.setMaterial(material);
			mHeadMeshView.setRotationAxis(Rotate.X_AXIS);
			mHeadMeshView.setRotate(90);
			mHead.getChildren().add(mHeadMeshView);

		mYRotation = -0;
		init();
		calculate(0);
	}

	public Point getLeftEyebrowPostion() {
		return new Point(mHalfWidth - 60, mHalfHeight - 152);
	}

	public Point getRightEyebrowPostion() {
		return new Point(mHalfWidth - 60, mHalfHeight - 105);
	}

	public Point getLeftEyePostion() {
		return new Point(13, -12);
	}

	public Point getRightEyePostion() {
		return new Point(-13, -12);
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

		mHead.setTranslateX(mHalfWidth+2);
		mHead.setTranslateY(mHalfHeight - 3);
		mHead.setTranslateZ(mZTranslate);

		Rotate rx = new Rotate(mXRotation, 0, 60, 0, Rotate.X_AXIS);
		Rotate ry = new Rotate(mYRotation, 0, 60, 0, Rotate.Y_AXIS);
		Rotate rz = new Rotate(mZRotation, 0, 60, 0, Rotate.Z_AXIS);

		mHead.getTransforms().clear();
		mHead.getTransforms().addAll(rx, ry, rz);

		this.getChildren().addAll(mHead);
		// update();

	}

	public void update() {
		material.setDiffuseColor(mColor);
		mHeadMeshView.setMaterial(material);
//		if (mStickmanFX.setCharacterInvisible == false)
//			mColorRecorder = mColor;
//
//		if (mStickmanFX.setCharacterInvisible == true) {
//			if (mStickmanFX.fadeControler == true) {
//
//				int fadeFactor = mStickmanFX.mMouthFX.mShapeAnimationStep * 10;
//				if (fadeFactor <= 20) {
//					fadeFactor = 0;
//				}
//				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(),
//						(fadeFactor * 100 / 255) / 100f);
//			} else {
//				int fadeFactor = (20 - mStickmanFX.mMouthFX.mShapeAnimationStep) * 9;
//				if (fadeFactor >= 160) {
//					mColor = mColorRecorder;
//				} else
//					mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(),
//							(fadeFactor * 100 / 255) / 100f);
//			}
//		}
	}
}
