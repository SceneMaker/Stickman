/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanfx.bodyfx;

import java.net.URL;

import com.interactivemesh.jfx.importer.col.ColModelImporter;

import de.dfki.stickmanfx.StickmanFX;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.MeshView;
import javafx.scene.transform.Rotate;
/**
 *
 * @author Beka
 *
 */
public class RightFootFX extends BodyPartFX {

	public static enum SHAPE {
		DEFAULT, FADEIN, FADEOUT
	};
	
	public RightFootFX.SHAPE mShape = RightFootFX.SHAPE.DEFAULT;
	
	RightForeLegFX mRightForeLegFX;

	MeshView mRightFootMeshView;
	PhongMaterial material;
	
	URL url;
	ColModelImporter im;

	public RightFootFX(RightForeLegFX rightForeLeg) {
		mRightForeLegFX = rightForeLeg;
		mLength = 20;
		if(mRightForeLegFX.mUpperLegFX.mDownBody.mUpperBody.mNeckFX.mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.MALE)
			mColor = Color.rgb(80, 80, 80, 1);
		else
			mColor = Color.rgb(154, 83, 198, 1);
		setDefaulRotation(0);
		mYRotation = 130;
		mXRotation = 0;

		url = getClass().getClassLoader().getResource("BodyParts/foot.dae");
		im = new ColModelImporter();
		im.read(url);
		mRightFootMeshView = (MeshView) im.getImport()[0];
		
		mRightFootMeshView.setId("mRightFootMeshView");
		material = new PhongMaterial();
		material.setDiffuseColor(mColor.darker());
		mRightFootMeshView.setMaterial(material);
		
		mRightForeLegFX.rightForeLegGroup.getChildren().add(mRightFootMeshView);
        
        init();
	}

	@Override
	public void setShape(String s) {
		SHAPE shape = SHAPE.valueOf(s);
		mShape = (shape != null) ? shape : SHAPE.DEFAULT;
	}

	@Override
	public void resetShape() {
		mShape = RightFootFX.SHAPE.DEFAULT;
	}
	
	@Override
	public void calculate(int step) {

		Rotate rx = new Rotate(mXRotation, 	Rotate.X_AXIS);
		Rotate ry = new Rotate(mYRotation,  Rotate.Y_AXIS);
		Rotate rz = new Rotate(mZRotation,  Rotate.Z_AXIS);
		
		if(mRightForeLegFX.mUpperLegFX.mDownBody.mUpperBody.mNeckFX.mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.MALE)
		{
			mRightFootMeshView.setTranslateX(mStart.x);
			mRightFootMeshView.setTranslateY(mStart.y+85);
			mRightFootMeshView.setTranslateZ(0);
		}
		else
		{
			mRightFootMeshView.setTranslateX(mStart.x);
			mRightFootMeshView.setTranslateY(mStart.y + 80);
			mRightFootMeshView.setTranslateZ(0);
		}
		
		mRightFootMeshView.getTransforms().clear();
		mRightFootMeshView.getTransforms().addAll(rx, ry, rz);
		
		switch(mShape)
		{
		case FADEIN:
			if(step == 2)
			{
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), 0.0);
				update();
				mRightFootMeshView.setVisible(false);
			}
			else if(mColor.getOpacity() != 0.0)
			{
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), mColor.getOpacity() - 0.052);
				update();
			}
			break;
			
		case FADEOUT:
			mRightFootMeshView.setVisible(true);
			
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
		mRightFootMeshView.setMaterial(material);
	}
}
