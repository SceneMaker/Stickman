/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman.bodyfx;

import de.dfki.stickman.body.*;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.geom.GeneralPath;

import de.dfki.stickman.Stickman;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

/**
 *
 * @author Patrick Gebhard
 *
 */
public class NeckFX extends BodyPartFX {

	HeadFX mHeadFX;

	public NeckFX(HeadFX head) {
		mHeadFX = head;
		mLength = 8;
		mSize = new Dimension(4, mLength);
		mColor = Color.rgb(80, 80, 80);
		
		init();
	}

	public Point getBodyStartPosition() {
		return new Point(mEnd.x, mEnd.y);
	}

	@Override
	public void createShape() {
		mStart = mHeadFX.getNeckStartPosition();
		mEnd = new Point(mStart.x, mStart.y + mLength);

		clearDrawObjects();
		
		if(mHeadFX.mStickmanFX.setCharacterInvisible == true)
		{
			if(mHeadFX.mStickmanFX.fadeControler==true)             //Added by Robbie
			{
				int fadeFactor = mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep*12;
				if(fadeFactor<=24) fadeFactor=0;
				mColor = Color.rgb(80, 80, 80, (fadeFactor*100/255)/100f);
			}
			else
			{
				int fadeFactor = (20-mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep)*12;
				if(fadeFactor >= 216) fadeFactor=255;
				mColor = Color.rgb(80, 80, 80, (fadeFactor*100/255)/100f);
			}
		}
		
		Path gp = new Path();
		gp.getElements().add(new MoveTo(mStart.x, mStart.y));
		gp.getElements().add(new LineTo(mEnd.x, mEnd.y));
		
		addToDrawObjects(gp);
	}
}
