package de.dfki.stickmanfx.bodyfx;

import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Point;

import de.dfki.stickmanfx.animationlogic.AnimatorFX;
import de.dfki.stickmanfx.mimic.util.FaceWrinkleANGRY;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Polygon;

/**
 *
 * @author Beka
 *
 */
public class FaceWrinkleFX extends BodyPartFX 
{

	public static enum SHAPE 
	{

		DEFAULT, ANGRY, ANGRYEND, DISGUSTED, DISGUSTEDEND, SURPRISED, SURPRISEDEND, EXCITED, EXCITEDEND, EMBARRASSED, EMBARRASSEDEND
	};

	HeadFX mHeadFX;
	
	Polygon currentLeftPolygon;
	Polygon currentRightPolygon;
	
	public FaceWrinkleFX.SHAPE mShape = FaceWrinkleFX.SHAPE.DEFAULT;

	public FaceWrinkleFX(HeadFX head) 
	{
		mHeadFX = head;
		mColor = Color.rgb(80, 80, 80, 0);
		mSize = new Dimension(mLength, 5);
		mDefaultRotationPoint = mHeadFX.mDefaultRotationPoint;
		
		currentLeftPolygon = new Polygon();
		currentRightPolygon = new Polygon();
		
		currentLeftPolygon.setFill(mColor);
		currentLeftPolygon.setTranslateZ(-18);
		currentRightPolygon.setTranslateZ(-18);
		
		mHeadFX.mHead.getChildren().addAll(currentLeftPolygon, currentRightPolygon);
		
		init();
	}

	@Override
	public void setShape(String s) 
	{
		FaceWrinkleFX.SHAPE shape = FaceWrinkleFX.SHAPE.valueOf(s);
		mShape = (shape != null) ? shape : FaceWrinkleFX.SHAPE.DEFAULT;
	}

	@Override
	public void resetShape() 
	{
		mShape = FaceWrinkleFX.SHAPE.DEFAULT;
	}

	@Override
	public void calculate(int step) 
	{
		mStart = mHeadFX.getRightEyebrowPostion();

		double colorOpacity = 0;
		
		switch (mShape) 
		{
			case DEFAULT:
				break;

		case ANGRY:
			currentLeftPolygon = FaceWrinkleANGRY.getLeftANGRY(currentLeftPolygon);
			currentRightPolygon = FaceWrinkleANGRY.getRightANGRY(currentRightPolygon);
			
			currentLeftPolygon.setTranslateX(3);
			currentLeftPolygon.setTranslateY(-10);
			currentRightPolygon.setTranslateX(-3);
			currentRightPolygon.setTranslateY(-10);
			
			colorOpacity = AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep;
			mColor = Color.rgb(80, 80, 80, colorOpacity/19);
			currentLeftPolygon.setFill(mColor);
			currentRightPolygon.setFill(mColor);
			
			break;
			
		case ANGRYEND:
			colorOpacity = AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep;
			
			mColor = Color.rgb(80, 80, 80, 1 - colorOpacity/19);
			currentLeftPolygon.setFill(mColor);
			currentRightPolygon.setFill(mColor);
			break;

		case DISGUSTED:
			break;

		case SURPRISED:
			break;

		case EXCITED:
			break;

		case EMBARRASSED:
			break;

		case EMBARRASSEDEND:
			break;
		}
//		this.update();
	}
	
	private Polygon createWrinkle()
	{
		Polygon wrinkle = new Polygon();
		
		wrinkle.getPoints().addAll(
				
				0.0,	0.0,
				3.0,	0.0,
				3.0,	-2.0,
				3.0,	-4.0,
				3.0,	-6.0,
				3.0,	-8.0,
				3.0,	-10.0,
				3.0,	-12.0,
				3.0,	-14.0,
				3.0, 	-16.0,
				0.0,	-16.0,
				0.0,	-14.0,
				0.0,	-12.0,
				0.0,	-10.0,	
				0.0,	-8.0,
				0.0,	-6.0,
				0.0,	-4.0,
				0.0,	-2.0
				);
		
		return wrinkle;
	}

}
