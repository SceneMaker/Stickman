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
import javafx.scene.DepthTest;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;
import javafx.scene.shape.TriangleMesh;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class FemaleHairFX extends BodyPartFX {
	public Dimension mSize = new Dimension(120, 100);
	public StickmanFX mStickmanFX;

	int mHalfHeight = mSize.height / 2;
	int mHalfWidth = mSize.width / 2;
	int mEarWidth = 10;

	int mDrawOffset = 10;
	int mXCenterOffset = mEarWidth / 2;
	int mYCenterOffset = mEarWidth / 2;

	int mPivotOffset = 55;
	int mZTranslate = 20;

	URL url;
	StlMeshImporter importer;
	TriangleMesh femaleHairTriangleMesh;
	MeshView femaleHairMeshView;
	PhongMaterial material;

	public FemaleHairFX(StickmanFX sm) {
		mStickmanFX = sm;
		mColor = Color.rgb(240, 212, 0, 1);
		
		if (mStickmanFX.mHeadFX != null)
			mYRotation = mStickmanFX.mHeadFX.mYRotation;

		url = getClass().getClassLoader().getResource("BodyParts/femaleHair.stl");
		importer = new StlMeshImporter();
		importer.read(url);
		femaleHairTriangleMesh = importer.getImport();
		femaleHairMeshView = new MeshView(femaleHairTriangleMesh);
		femaleHairMeshView.setId("FemaleHair");
		material = new PhongMaterial();
		material.setDiffuseColor(mColor);
		femaleHairMeshView.setMaterial(material);
		femaleHairMeshView.setRotationAxis(Rotate.X_AXIS);
		femaleHairMeshView.setRotate(-90);

		init();

		calculate(0);
	}

	public void calculate(int step) {
		clearChildren(this);

		femaleHairMeshView.setTranslateX(mHalfWidth-60);
		femaleHairMeshView.setTranslateY(mHalfHeight-52);
		femaleHairMeshView.setTranslateZ(mZTranslate);

		Rotate rx = new Rotate(mXRotation, Rotate.X_AXIS);
		Rotate ry = new Rotate(mYRotation, Rotate.Y_AXIS);
		Rotate rz = new Rotate(mZRotation, Rotate.Z_AXIS);

		femaleHairMeshView.getTransforms().clear();
		femaleHairMeshView.getTransforms().addAll(rx, ry, rz);

		if(mStickmanFX.mType == StickmanFX.TYPE.FEMALE)
		{
			if (!mStickmanFX.mHeadFX.mHead.getChildren().contains(femaleHairMeshView)) {
				mStickmanFX.mHeadFX.mHead.getChildren().add(femaleHairMeshView);
			}
			else
			{
				if (!mStickmanFX.mHeadFX.mHead.getChildren().get(1).equals(femaleHairMeshView)) {
					mStickmanFX.mHeadFX.mHead.getChildren().set(1, femaleHairMeshView);
				}
			}
		}
		// update();

	}

	public void update() {
		material.setDiffuseColor(mColor);
		femaleHairMeshView.setMaterial(material);
//		if (mStickmanFX.setCharacterInvisible == false)
//			mColorRecorder = mColor;
//
//		if (mStickmanFX.setCharacterInvisible == true) {
//			if (mStickmanFX.fadeControler == true) // Added by Robbie
//			{
//				int fadeFactor = mStickmanFX.mMouthFX.mShapeAnimationStep * 10;
//				if (fadeFactor <= 20) {
//					fadeFactor = 0;
//				}
//				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(),
//						(fadeFactor * 100 / 255) / 100f);
//				// mColor = Color.rgb(240, 212, 0, (fadeFactor * 100 / 255) /
//				// 100f);
//			} else {
//				int fadeFactor = (20 - mStickmanFX.mMouthFX.mShapeAnimationStep) * 9;
//				if (fadeFactor >= 160) {
//					mColor = mColorRecorder;
//				} else
//					mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(),
//							(fadeFactor * 100 / 255) / 100f);
//				// mColor = Color.rgb(240, 212, 0, (fadeFactor * 100 / 255) /
//				// 100f);
//			}
//		}

//		mFemaleHair.setFill(mColor);
//		// draw outlines
//		mFemaleHair.setStroke(mColor.darker());
//		mFemaleHair.setStrokeWidth(2);

	}
}
