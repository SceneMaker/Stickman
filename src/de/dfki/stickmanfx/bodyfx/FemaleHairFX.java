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
import javafx.scene.DepthTest;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;
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
	int mZTranslate = -100;

	URL url;
	ColModelImporter importer;
	MeshView mFemaleHair;

	public FemaleHairFX(StickmanFX sm) {
		mStickmanFX = sm;
		mDefaultRotationPoint = new Point(mSize.width / 2, mSize.height);
		if (mStickmanFX.mHeadFX != null)
			mYRotation = mStickmanFX.mHeadFX.mYRotation;

		url = getClass().getClassLoader().getResource("BodyParts/femaleHair.dae");
		importer = new ColModelImporter();
		importer.read(url);
		mFemaleHair = (MeshView) importer.getImport()[0];

		mColor = Color.rgb(240, 212, 0, 1);

		init();

		calculate(0);
	}

	public void calculate(int step) {
		clearChildren(this);

		mFemaleHair.setTranslateX(mHalfWidth);
		mFemaleHair.setTranslateY(mHalfHeight + mPivotOffset);
		mFemaleHair.setTranslateZ(mZTranslate);

		Rotate rx = new Rotate(mXRotation, Rotate.X_AXIS);
		Rotate ry = new Rotate(mYRotation, Rotate.Y_AXIS);
		Rotate rz = new Rotate(mZRotation, Rotate.Z_AXIS);

		mFemaleHair.getTransforms().clear();
		mFemaleHair.getTransforms().addAll(rx, ry, rz);

		this.getChildren().add(mFemaleHair);

		// update();

	}

	public void update() {
		if (mStickmanFX.setCharacterInvisible == false)
			mColorRecorder = mColor;

		if (mStickmanFX.setCharacterInvisible == true) {
			if (mStickmanFX.fadeControler == true) // Added by Robbie
			{
				int fadeFactor = mStickmanFX.mMouthFX.mShapeAnimationStep * 10;
				if (fadeFactor <= 20) {
					fadeFactor = 0;
				}
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(),
						(fadeFactor * 100 / 255) / 100f);
				// mColor = Color.rgb(240, 212, 0, (fadeFactor * 100 / 255) /
				// 100f);
			} else {
				int fadeFactor = (20 - mStickmanFX.mMouthFX.mShapeAnimationStep) * 9;
				if (fadeFactor >= 160) {
					mColor = mColorRecorder;
				} else
					mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(),
							(fadeFactor * 100 / 255) / 100f);
				// mColor = Color.rgb(240, 212, 0, (fadeFactor * 100 / 255) /
				// 100f);
			}
		}

//		mFemaleHair.setFill(mColor);
//		// draw outlines
//		mFemaleHair.setStroke(mColor.darker());
//		mFemaleHair.setStrokeWidth(2);

	}
}
