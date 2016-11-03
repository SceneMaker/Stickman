/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanfx.bodyfx;

import de.dfki.stickmanfx.StickmanFX;
import de.dfki.stickmanfx.animationlogic.AnimatorFX;
import de.dfki.stickmanfx.mimic.util.LeftBrowANGRY;
import de.dfki.stickmanfx.mimic.util.LeftBrowDEFAULT;
import de.dfki.stickmanfx.mimic.util.LeftBrowDISGUSTED;
import de.dfki.stickmanfx.mimic.util.LeftBrowEMBARRASSED;
import de.dfki.stickmanfx.mimic.util.LeftBrowEXCITED;
import de.dfki.stickmanfx.mimic.util.LeftBrowHAPPY;
import de.dfki.stickmanfx.mimic.util.LeftBrowSAD;
import de.dfki.stickmanfx.mimic.util.LeftBrowSURPRISED;
import java.awt.Dimension;
import java.net.URL;

import com.interactivemesh.jfx.importer.col.ColModelImporter;
import com.sun.scenario.effect.light.SpotLight;

import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.Polygon;

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
		
		url = getClass().getClassLoader().getResource("BodyParts/nose.dae");
		
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
	
	public void update()
	{
		material.setDiffuseColor(mColor);
		mNose.setMaterial(material);
	}

	protected void recordColor() {
		if (mHeadFX.mStickmanFX.setCharacterInvisible == false)
			mColorRecorder = mColor;
	}
}

