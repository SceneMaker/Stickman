/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.bodyfx;

import com.interactivemesh.jfx.importer.col.ColModelImporter;
import de.dfki.stickman3D.StickmanFX;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.MeshView;
import javafx.scene.transform.Rotate;

import java.net.URL;

/**
 *
 * @author Beka
 *
 */
public class LeftFootFX extends BodyPartFX {

	public static enum SHAPE {
		DEFAULT, FADEIN, FADEOUT
	};
	
	public LeftFootFX.SHAPE mShape = LeftFootFX.SHAPE.DEFAULT;

	LeftForeLegFX mLeftForeLegFX;

	MeshView mLeftFootMeshView;
	PhongMaterial material;

	URL url;
	ColModelImporter im;

	public LeftFootFX(LeftForeLegFX leftForeLeg) {
		mLeftForeLegFX = leftForeLeg;
		mLength = 20;
		if(mLeftForeLegFX.mUpperLegFX.mDownBody.mUpperBody.mNeckFX.mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.MALE)
			mColor = Color.rgb(80,80,80, 1);
		else
			mColor = Color.rgb(154, 83, 198, 1);
		setDefaulRotation(0);
		mYRotation = 50;
		mXRotation = 0;

		url = getClass().getClassLoader().getResource("BodyParts/foot.dae");
		im = new ColModelImporter();
		im.read(url);
		mLeftFootMeshView = (MeshView) im.getImport()[0];

		mLeftFootMeshView.setId("mLeftFootMeshView");
		material = new PhongMaterial();
		material.setDiffuseColor(mColor.darker());
		mLeftFootMeshView.setMaterial(material);

		mLeftForeLegFX.leftForeLegGroup.getChildren().add(mLeftFootMeshView);

        init();
	}

	@Override
	public void setShape(String s) {
		SHAPE shape = SHAPE.valueOf(s);
		mShape = (shape != null) ? shape : SHAPE.DEFAULT;
	}

	@Override
	public void resetShape() {
		mShape = LeftFootFX.SHAPE.DEFAULT;
	}
	
	@Override
	public void calculate(int step) {
		Rotate rx = new Rotate(mXRotation, 	Rotate.X_AXIS);
		Rotate ry = new Rotate(mYRotation,  Rotate.Y_AXIS);
		Rotate rz = new Rotate(mZRotation,  Rotate.Z_AXIS);
		
		if(mLeftForeLegFX.mUpperLegFX.mDownBody.mUpperBody.mNeckFX.mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.MALE)
		{
			mLeftFootMeshView.setTranslateX(mStart.x+3);
			mLeftFootMeshView.setTranslateY(mStart.y+85);
			mLeftFootMeshView.setTranslateZ(0);
		}
		else
		{
			mLeftFootMeshView.setTranslateX(mStart.x + 3);
			mLeftFootMeshView.setTranslateY(mStart.y + 79);
			mLeftFootMeshView.setTranslateZ(0);
		}
		
		mLeftFootMeshView.getTransforms().clear();
		mLeftFootMeshView.getTransforms().addAll(rx, ry, rz);

		switch(mShape)
		{
		case FADEIN:
			if(step == 2)
			{
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), 0.0);
				update();
				mLeftFootMeshView.setVisible(false);
			}
			else if(mColor.getOpacity() != 0.0)
			{
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), mColor.getOpacity() - 0.052);
				update();
			}
			break;
			
		case FADEOUT:
			mLeftFootMeshView.setVisible(true);
			
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
		mLeftFootMeshView.setMaterial(material);
	}
}
