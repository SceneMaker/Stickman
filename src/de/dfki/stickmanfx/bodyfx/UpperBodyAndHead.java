package de.dfki.stickmanfx.bodyfx;

import java.awt.Dimension;

import javafx.scene.Group;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class UpperBodyAndHead extends BodyPartFX {

	Rotate rx;
	Rotate ry;
	Rotate rz;

	Dimension mSize = new Dimension(120, 300);

	int mHalfSizeX = mSize.width / 2;
	int mHalfSizeY = mSize.height / 2;
	int mDrawOffset = 20;

	public Group mUpperBodyAndHead;
	UpperBody ub;

	double mPivotY;

	public UpperBodyAndHead(HeadFX head, UpperBody upperBody, NeckFX neck) {
		ub = upperBody;
		mUpperBodyAndHead = new Group();
		mUpperBodyAndHead.getChildren().addAll(head.mHead, upperBody.mUpperBodyGroup, neck.neckMeshView);
		mPivotY = upperBody.mYTranslation;

		this.getChildren().addAll(mUpperBodyAndHead);
	}

	@Override
	public void calculate(int step) {
		rx = new Rotate(mXRotation, 0, mYTranslation + 280, -105, Rotate.X_AXIS);
		ry = new Rotate(mYRotation, 0, mYTranslation + 280, -105, Rotate.Y_AXIS);
		rz = new Rotate(mZRotation, 0, mYTranslation + 280, -105, Rotate.Z_AXIS);

		Translate translation = new Translate(mXTranslation, mYTranslation, mZTranslation);
		mUpperBodyAndHead.getTransforms().clear();
		mUpperBodyAndHead.getTransforms().addAll(rx, ry, rz, translation);
	}
}
