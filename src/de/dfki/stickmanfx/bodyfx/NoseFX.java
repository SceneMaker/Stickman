/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanfx.bodyfx;

import java.awt.Dimension;
import java.net.URL;

import com.interactivemesh.jfx.importer.col.ColModelImporter;

import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.MeshView;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class NoseFX extends BodyPartFX 
{
	public static enum SHAPE 
	{
		DEFAULT, FADEIN, FADEOUT
	};

	HeadFX mHeadFX;
	
	URL url;
	ColModelImporter imorter;
	MeshView mNose;
    PhongMaterial material;
	
	public NoseFX.SHAPE mShape = NoseFX.SHAPE.DEFAULT;

	public NoseFX(HeadFX head) 
	{
		mHeadFX = head;
		mSize = new Dimension(mLength, mLength);
		
		imorter = new ColModelImporter();
		mColor = Color.rgb(242, 227, 217, 1);
		
		url = getClass().getClassLoader().getResource("BodyParts/nose1.dae");
		
		imorter.read(url);
		mNose = (MeshView) imorter.getImport()[0];
		
		material = new PhongMaterial();
		material.setDiffuseColor(mColor);
		mNose.setMaterial(material);
		
		mStart = mHeadFX.getLeftEyebrowPostion();
		
		init();
		
		mHeadFX.mHead.getChildren().add(mNose);
	}

	@Override
	public void init()
	{
		super.init();
		mNose.setTranslateX(mStart.x);
		mNose.setTranslateY(mStart.y + 110);
		mNose.setTranslateZ(7);
	}
	@Override
	public void setShape(String s) {
		SHAPE shape = NoseFX.SHAPE.valueOf(s);
		mShape = (shape != null) ? shape : NoseFX.SHAPE.DEFAULT;
	}

	@Override
	public void resetShape() {
		mShape = NoseFX.SHAPE.DEFAULT;
	}

	@Override
	public void calculate(int step) {

		switch (mShape) 
		{
		case FADEIN:
			if(step == 2)
			{
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), 0.0);
				update();
				mNose.setVisible(false);
			}
			else if(mColor.getOpacity() != 0.0)
			{
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), mColor.getOpacity() - 0.052);
				update();
			}
			break;
			
		case FADEOUT:
			mNose.setVisible(true);
			
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
	public void update()
	{
		material.setDiffuseColor(mColor);
		mNose.setMaterial(material);
	}

	@Override
	protected void recordColor() {
		if (mHeadFX.mStickmanFX.setCharacterInvisible == false)
			mColorRecorder = mColor;
	}
}

