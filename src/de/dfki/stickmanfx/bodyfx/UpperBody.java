package de.dfki.stickmanfx.bodyfx;

import java.awt.Dimension;
import java.awt.Point;
import java.net.URL;

import com.interactivemesh.jfx.importer.col.ColModelImporter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import de.dfki.stickmanfx.StickmanFX;
import de.dfki.util.XMLParser;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.MeshView;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
/**
 *
 * @author Beka Aptsiauri
 *
 */
public class UpperBody extends BodyPartFX {

	public static enum SHAPE {
		DEFAULT, FADEIN, FADEOUT
	};
	
	public UpperBody.SHAPE mShape = UpperBody.SHAPE.DEFAULT;
	
	NeckFX mNeckFX;
	Rotate rx;
	Rotate ry;
	Rotate rz;

	Dimension mSize = new Dimension(120, 300);

	int mHalfSizeX = mSize.width / 2;
	int mHalfSizeY = mSize.height / 2;
	int mDrawOffset = 20;

	public Group mUpperBodyGroup;

	URL url;
	ColModelImporter imorter;
	MeshView mBodyMeshView;
	PhongMaterial material;

	public UpperBody(NeckFX neck) {
		mNeckFX = neck;
		mStart = mNeckFX.getBodyStartPosition();
		imorter = new ColModelImporter();

		if (mNeckFX.mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.FEMALE) {
			url = getClass().getClassLoader().getResource("BodyParts/UpperFemaleBody.dae");
			mColor = Color.rgb(154, 83, 198, 1);
		} else {
			url = getClass().getClassLoader().getResource("BodyParts/UpperMaleBody2.dae");
			mColor = Color.rgb(14, 134, 122, 1);
		}
		
		activateConfigColor();

		imorter.read(url);
		mUpperBodyGroup = new Group();
		mBodyMeshView = (MeshView) imorter.getImport()[0];
		mBodyMeshView.setId("uppeBody");
		material = new PhongMaterial();
		material.setDiffuseColor(mColor);
		mBodyMeshView.setMaterial(material);
		mUpperBodyGroup.getChildren().add(mBodyMeshView);
		
		mStart = mNeckFX.getBodyStartPosition();
		init();
		this.getChildren().addAll(mUpperBodyGroup);
	}
	
	@Override
	public void init()
	{
		super.init();
		mUpperBodyGroup.setTranslateX(mStart.x);
		if (mNeckFX.mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.MALE) {
			mUpperBodyGroup.setTranslateY(mStart.y + 155);
			mUpperBodyGroup.setTranslateZ(-105);
		} else {
			mUpperBodyGroup.setTranslateY(mStart.y + 135);
			mUpperBodyGroup.setTranslateZ(-105);
		}
	}

	private void activateConfigColor()
	{
		if(mNeckFX.mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.FEMALE)
		{
			if(!XMLParser.femaleColor.isEmpty())
			{
				if(XMLParser.femaleColor.containsKey("UpperBodyColor"))
					this.mColor = XMLParser.femaleColor.get("UpperBodyColor");
			}
		}
		else
		{
			if(!XMLParser.maleColor.isEmpty())
			{
				if(XMLParser.maleColor.containsKey("UpperBodyColor"))
					this.mColor = XMLParser.maleColor.get("UpperBodyColor");
			}
		}
	}
	
	public Point getUpperBodyPosition()
	{
		return new Point (mStart.x, mStart.y + 135);
	}
	@Override
	public void setShape(String s) {
		SHAPE shape = SHAPE.valueOf(s);
		mShape = (shape != null) ? shape : SHAPE.DEFAULT;
	}

	@Override
	public void resetShape() {
		mShape = UpperBody.SHAPE.DEFAULT;
	}
	
	@Override
	public void calculate(int step) {

		//Setze PivotElement entsprechend der Y-Translation
		rx = new Rotate(mXRotation, 0, mYTranslation, 0, Rotate.X_AXIS);
		ry = new Rotate(mYRotation, 0, mYTranslation, 0, Rotate.Y_AXIS);
		rz = new Rotate(mZRotation, 0, mYTranslation, 0,Rotate.Z_AXIS);
		
		Translate translation = new Translate(mXTranslation, mYTranslation, mZTranslation);

		mUpperBodyGroup.getTransforms().clear();
		mUpperBodyGroup.getTransforms().addAll(rx, ry, rz, translation);
		
		switch(mShape)
		{
		case FADEIN:
			if(step == 2)
			{
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), 0.0);
				update();
				mBodyMeshView.setVisible(false);
			}
			else if(mColor.getOpacity() != 0.0)
			{
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), mColor.getOpacity() - 0.052);
				update();
			}
			break;
			
		case FADEOUT:
			mBodyMeshView.setVisible(true);
			
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

	public Point getLeftArmStartPostion() {
		return new Point(mStart.x - 39, mStart.y - 178);
	}

	public Point getDownBodyPosition() {
		return new Point(mStart.x, mStart.y);
	}

	public Point getRightArmStartPostion() {
		return new Point(mStart.x - 90, mStart.y - 178);
	}

	public Point getLeftLegStartPostion() {
		if (mNeckFX.mHeadFX.mStickmanFX.mOrientation == StickmanFX.ORIENTATION.LEFT) {
			return new Point(mStart.x + mHalfSizeX - mDrawOffset, mSize.height);
		} else {
			return new Point(mStart.x + mHalfSizeX - mDrawOffset - 20,
					(mNeckFX.mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.FEMALE) ? mSize.height + 3 : mSize.height);
		}
	}

	public Point getRightLegStartPostion() {
		if (mNeckFX.mHeadFX.mStickmanFX.mOrientation == StickmanFX.ORIENTATION.RIGHT) {
			return new Point(mStart.x, mSize.height);
		} else {
			return new Point(mStart.x - mHalfSizeX + mDrawOffset + 20,
					(mNeckFX.mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.FEMALE) ? mSize.height + 5 : mSize.height);
		}
	}

	@Override
	public void update() {
		material.setDiffuseColor(mColor);
		mBodyMeshView.setMaterial(material);
	}

	@Override
	public void rotatePerlinNoise(double mWobble, int x, int y) {
		Affine af = new Affine();
		// Out put perlin noise
		af.appendRotation(Math.toRadians(mWobble), x, y);
		this.getTransforms().clear();
		this.getTransforms().add(af);

	}

}
