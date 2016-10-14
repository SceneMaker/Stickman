package de.dfki.stickmanfx.bodyfx;

import de.dfki.stickmanfx.StickmanFX;
import de.dfki.stickmanfx.StickmanFX.TYPE;

import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Point;
import java.net.URL;

import com.interactivemesh.jfx.importer.col.ColModelImporter;
import com.interactivemesh.jfx.importer.stl.StlMeshImporter;
import com.sun.xml.internal.ws.resources.ManagementMessages;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.CubicCurveTo;
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
public class MaleHairFX extends BodyPartFX 
{
	public Dimension mSize = new Dimension(120, 100);
	public StickmanFX mStickmanFX;

	int mHalfHeight = mSize.height / 2;
	int mHalfWidth = mSize.width / 2;
	int mPifotOffset = 55;
	int mZTranslate = 3; //Bring shape in front, because of DepthTest
	int mEarWidth = 10;

	URL url;
	StlMeshImporter importer;
	TriangleMesh maleHairTriangleMesh;
	MeshView maleHairMeshView;
	PhongMaterial material;

	public MaleHairFX(StickmanFX sm) 
	{
		mStickmanFX = sm;
		mColor = Color.rgb(97, 58, 0, 1);

		if (mStickmanFX.mHeadFX != null)
			mYRotation = mStickmanFX.mHeadFX.mYRotation;

		url = getClass().getClassLoader().getResource("BodyParts/maleHair.stl");
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
		
		init();

		calculate(0);
	}

	public void calculate(int step) 
	{
		clearChildren(this);

		maleHairMeshView.setTranslateX(mHalfWidth-60);
		maleHairMeshView.setTranslateY(mHalfHeight-52);
		maleHairMeshView.setTranslateZ(mZTranslate);
		
		Rotate rx = new Rotate(mXRotation, Rotate.X_AXIS);
		Rotate ry = new Rotate(mYRotation, Rotate.Y_AXIS);
		Rotate rz = new Rotate(mZRotation, Rotate.Z_AXIS);

		maleHairMeshView.getTransforms().clear();
		maleHairMeshView.getTransforms().addAll(rx, ry, rz);
		
		if(mStickmanFX.mType == StickmanFX.TYPE.MALE)
		{
			if (!mStickmanFX.mHeadFX.mHead.getChildren().contains(maleHairMeshView)) {
				mStickmanFX.mHeadFX.mHead.getChildren().add(maleHairMeshView);
			}
			else
			{
				if (!mStickmanFX.mHeadFX.mHead.getChildren().get(1).equals(maleHairMeshView)) {
					mStickmanFX.mHeadFX.mHead.getChildren().set(1, maleHairMeshView);
				}
			}
		}
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
