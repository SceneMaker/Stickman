package de.dfki.stickman3D.bodyfx;

import com.interactivemesh.jfx.importer.col.ColModelImporter;
import com.interactivemesh.jfx.importer.stl.StlMeshImporter;
import de.dfki.stickman3D.Stickman3D;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.TriangleMesh;
import javafx.scene.transform.Rotate;

import java.awt.*;
import java.net.URL;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class HeadFX extends BodyPartFX {
	
	public static enum SHAPE {
		DEFAULT, FADEIN, FADEOUT
	};
	
	public Dimension mSize = new Dimension(120, 100);
	public Stickman3D mStickmanFX;
	TriangleMesh mHeadTriangleMesh;
	MeshView mHeadMeshView;
	PhongMaterial material;

	int mHalfHeight = mSize.height / 2;
	int mHalfWidth = mSize.width / 2;
	int mPivotOffset = 55;
	int mZTranslate = -105;

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

	public HeadFX.SHAPE mShape = HeadFX.SHAPE.DEFAULT;

	public HeadFX(Stickman3D sm) {
		mStickmanFX = sm;
		mDefaultRotationPoint = new Point(mSize.width / 2, mSize.height);
		mColor = Color.rgb(242, 227, 217, 1);

		url = getClass().getClassLoader().getResource("BodyParts/Head.stl");
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

		init();
		this.getChildren().add(mHead);
		calculate(0);
	}

	@Override
	public void init()
	{
		super.init();
		mHead.setTranslateX(mHalfWidth+4);
		mHead.setTranslateY(mHalfHeight - 3);
		mHead.setTranslateZ(mZTranslate);
	}
	@Override
	public void setShape(String s) {
		SHAPE shape = SHAPE.valueOf(s);
		mShape = (shape != null) ? shape : SHAPE.DEFAULT;
	}

	@Override
	public void resetShape() {
		mShape = HeadFX.SHAPE.DEFAULT;
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

	@Override
	public void calculate(int step) {

		Rotate rx = new Rotate(mXRotation, 0, 60, 0, Rotate.X_AXIS);
		Rotate ry = new Rotate(mYRotation, 0, 60, 0, Rotate.Y_AXIS);
		Rotate rz = new Rotate(mZRotation, 0, 60, 0, Rotate.Z_AXIS);

		mHead.getTransforms().clear();
		mHead.getTransforms().addAll(rx, ry, rz);
		
		switch(mShape)
		{
		case FADEIN:
			if(step == 2)
			{
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), 0.0);
				update();
				mHeadMeshView.setVisible(false);
			}
			else if(mColor.getOpacity() != 0.0)
			{
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), mColor.getOpacity() - 0.052);
				update();
			}
			break;
			
		case FADEOUT:
			mHeadMeshView.setVisible(true);
			
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

	@Override
	public void update() {
		material.setDiffuseColor(mColor);
		mHeadMeshView.setMaterial(material);
	}
}
