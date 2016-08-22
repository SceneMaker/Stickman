/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanfx.bodyfx;

import de.dfki.stickman.body.*;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.geom.GeneralPath;
import java.net.URL;

import com.interactivemesh.jfx.importer.col.ColModelImporter;

import de.dfki.stickman.Stickman;
import javafx.scene.paint.Color;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.transform.Rotate;

/**
 *
 * @author Patrick Gebhard
 *
 */
public class NeckFX extends BodyPartFX {

	HeadFX mHeadFX;
	
	URL url;
    ColModelImporter imorter;
    MeshView neckMeshView;

	public NeckFX(HeadFX head) {
		mHeadFX = head;
		mLength = 8;
		
		url  = getClass().getClassLoader().getResource("neck1.dae");
        imorter = new ColModelImporter();
        imorter.read(url);
        neckMeshView=  (MeshView) imorter.getImport()[0];
		
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

		clearChildren(this);
		
		if(mHeadFX.mStickmanFX.setCharacterInvisible == true)
		{
			if(mHeadFX.mStickmanFX.fadeControler==true)             //Added by Robbie
			{
				int fadeFactor = mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep*12;
				if(fadeFactor<=24) fadeFactor=0;
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), (fadeFactor * 100 / 255) / 100f);
			}
			else
			{
				int fadeFactor = (20-mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep)*12;
				if(fadeFactor >= 216) mColor = mColorRecorder;
				else
					mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), (fadeFactor * 100 / 255) / 100f);
			}
		}
		
		neckMeshView.setTranslateX(mStart.x);
		neckMeshView.setTranslateY(mStart.y + 5);
		neckMeshView.setTranslateZ(-100);
        
		Rotate rx = new Rotate(mRotation,  Rotate.X_AXIS);
		Rotate ry = new Rotate(mYRotation, Rotate.Y_AXIS);
		Rotate rz = new Rotate(mZRotation, Rotate.Z_AXIS);
		
		neckMeshView.getTransforms().clear();
		neckMeshView.getTransforms().addAll(rx, ry, rz);
		
		this.getChildren().add(neckMeshView);
//		addToDrawObjects(mPath);
//		this.update();
	}
	protected void recordColor(){
		if(mHeadFX.mStickmanFX.setCharacterInvisible == false)
			mColorRecorder = mColor;
    }
}
