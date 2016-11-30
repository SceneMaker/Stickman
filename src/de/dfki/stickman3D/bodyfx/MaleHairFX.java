package de.dfki.stickman3D.bodyfx;

import com.interactivemesh.jfx.importer.stl.StlMeshImporter;
import de.dfki.common.Gender;
import de.dfki.stickman3D.Stickman3D;
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
public class MaleHairFX extends BodyPartFX 
{
	public static enum SHAPE {
		DEFAULT, FADEIN, FADEOUT
	};
	
	public Dimension mSize = new Dimension(120, 100);
	public Stickman3D mStickmanFX;

	int mHalfHeight = mSize.height / 2;
	int mHalfWidth = mSize.width / 2;
	int mPifotOffset = 55;
	int mZTranslate = 3;
	int mEarWidth = 10;

	URL url;
	StlMeshImporter importer;
	TriangleMesh maleHairTriangleMesh;
	MeshView maleHairMeshView;
	PhongMaterial material;

	public MaleHairFX.SHAPE mShape = MaleHairFX.SHAPE.DEFAULT;

	public MaleHairFX(Stickman3D sm)
	{
		mStickmanFX = sm;
		mColor = Color.rgb(97, 58, 0, 1);

		if (mStickmanFX.mHeadFX != null)
			mYRotation = mStickmanFX.mHeadFX.mYRotation;

		url = getClass().getClassLoader().getResource("BodyParts/maleHair1.stl");
		importer = new StlMeshImporter();
		importer.read(url);
		maleHairTriangleMesh = importer.getImport();
		maleHairMeshView = new MeshView(maleHairTriangleMesh);
		maleHairMeshView.setId("MaleHair");
		material = new PhongMaterial();
		material.setDiffuseColor(mColor);
		maleHairMeshView.setMaterial(material);
		maleHairMeshView.setRotationAxis(Rotate.X_AXIS);
		maleHairMeshView.setRotate(-90);

		if(mStickmanFX.mType == Gender.TYPE.MALE)
			mStickmanFX.mHeadFX.mHead.getChildren().add(maleHairMeshView);

		init();

		calculate(0);
	}

	@Override
	public void init()
	{
		super.init();
		maleHairMeshView.setTranslateX(mHalfWidth-60);
		maleHairMeshView.setTranslateY(mHalfHeight-52);
		maleHairMeshView.setTranslateZ(mZTranslate);
	}
	@Override
	public void setShape(String s) {
		SHAPE shape = SHAPE.valueOf(s);
		mShape = (shape != null) ? shape : SHAPE.DEFAULT;
	}

	@Override
	public void resetShape() {
		mShape = MaleHairFX.SHAPE.DEFAULT;
	}

	public void calculate(int step) 
	{
		Rotate rx = new Rotate(mXRotation, Rotate.X_AXIS);
		Rotate ry = new Rotate(mYRotation, Rotate.Y_AXIS);
		Rotate rz = new Rotate(mZRotation, Rotate.Z_AXIS);

		maleHairMeshView.getTransforms().clear();
		maleHairMeshView.getTransforms().addAll(rx, ry, rz);
		
		switch(mShape)
		{
		case FADEIN:
			if(step == 2)
			{
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), 0.0);
				update();
				maleHairMeshView.setVisible(false);
			}
			else if(mColor.getOpacity() != 0.0)
			{
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), mColor.getOpacity() - 0.052);
				update();
			}
			break;
			
		case FADEOUT:
			maleHairMeshView.setVisible(true);
			
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

	public void update() {
		material.setDiffuseColor(mColor);
		maleHairMeshView.setMaterial(material);
	}
}
