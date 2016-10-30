package de.dfki.stickmanfx.bodyfx;

import java.awt.Point;
import java.net.URL;
import java.util.ArrayList;

import com.interactivemesh.jfx.importer.col.ColModelImporter;
import com.interactivemesh.jfx.importer.stl.StlMeshImporter;
import com.sun.scenario.effect.ColorAdjust;

import static de.dfki.stickman.animationlogic.util.Interpolator.linear;
import de.dfki.stickmanfx.StickmanFX;
import de.dfki.stickmanfx.animationlogic.AnimatorFX;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.scene.DepthTest;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.Circle;
import javafx.scene.shape.ClosePath;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.DrawMode;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.Mesh;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.PathBuilder;
import javafx.scene.shape.QuadCurveTo;
import javafx.scene.shape.Shape;
import javafx.scene.shape.TriangleMesh;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.util.Duration;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class LeftEyeFX extends BodyPartFX {


	public static enum SHAPE {
		DEFAULT, FADEIN, FADEOUT, BLINK, BLINKEND, LOOKLEFT, LOOKLEFTEND, LOOKRIGHT, LOOKRIGHTEND, LOOKDOWN, LOOKDOWNEND, LOOKUP, LOOKUPEND, ANGRY, ANGRYEND, SURPRISED, SURPRISEDEND, HAPPY, HAPPYEND, DISGUSTED, DISGUSTEDEND, LOVED, LOVEDEND, LOVED1, CONTEMPT, CONTEMPTEND, EXCITED, EXCITEDEND, EMBARRASSED, EMBARRASSEDEND
	};

	HeadFX mHeadFX;
	Group leftEyeGroup;
	
	Path border;
	Path bigPupile;
	Path smallPupile;
	
	double borderXSize = 0;
	float borderYSize = 0;
	double bigPupileYSize = 0;
	double smallPupileYSize = 0;
	
	QuadCurveTo quadCurve_1;
	QuadCurveTo quadCurve_2;
	
	Color smallPupileColor;
	Color borderColor;
	
	public LeftEyeFX.SHAPE mShape = LeftEyeFX.SHAPE.DEFAULT;

	public LeftEyeFX(HeadFX head) {
		mHeadFX = head;
		
		if(mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.MALE)
			mColor = Color.rgb(0, 0, 0, 1);
		else
			mColor = Color.rgb(0, 0, 255, 1);
		
		smallPupileColor = Color.rgb(255, 255, 255, 1);
		borderColor = Color.rgb(255, 255, 255, 1);
		
		mStart = mHeadFX.getLeftEyePostion();
		
		border = new Path();
		bigPupile = new Path();
		smallPupile = new Path();
		
		leftEyeGroup = new Group();
		leftEyeGroup.getChildren().add(border);
		leftEyeGroup.getChildren().add(bigPupile);
		leftEyeGroup.getChildren().add(smallPupile);
		mHeadFX.mHead.getChildren().add(leftEyeGroup);
		
		init();
	}

	@Override
	public void init()
	{
		super.init();
		bigPupile.setTranslateX(mStart.x + 13);
		bigPupile.setTranslateY(mStart.y);
		smallPupile.setTranslateX(mStart.x + 11);
		smallPupile.setTranslateY(mStart.y);
		border.setTranslateZ(-17);
		bigPupile.setTranslateZ(-18);
		smallPupile.setTranslateZ(-19);
	}
	@Override
	public void setShape(String s) {
		SHAPE shape = SHAPE.valueOf(s);
		mShape = (shape != null) ? shape : SHAPE.DEFAULT;
	}

	@Override
	public void resetShape() {
		mShape = LeftEyeFX.SHAPE.DEFAULT;
	}

	@Override
	public void calculate(int step) {
		
		float xMovement;
		float yMovement;
		
		switch (mShape) {
		case DEFAULT:
			if(step == 20 || step == 0)
			{
				border = createBorder(border);
				bigPupile = createEllipsePath(bigPupile, 0, 0, 3.5, 3.5, 0, mColor, null);
				smallPupile = createEllipsePath(smallPupile, 0, 0, 1.4, 1.4, 0, smallPupileColor, null);
				smallPupile.setStroke(null);
				
				borderYSize = 0;
				borderXSize = 0;
				bigPupileYSize = 0;
				smallPupileYSize = 0;
			}
			break;
			
		case FADEIN:
			if(step == 2)
			{
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), 0.0);
				smallPupileColor = new Color(smallPupileColor.getRed(), smallPupileColor.getGreen(), smallPupileColor.getBlue(), 0.0);
				borderColor = new Color(borderColor.getRed(), borderColor.getGreen(), borderColor.getBlue(), 0.0);
			}
			else if(mColor.getOpacity() != 0.0)
			{
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), mColor.getOpacity() - 0.052);
				smallPupileColor = new Color(smallPupileColor.getRed(), smallPupileColor.getGreen(), smallPupileColor.getBlue(), smallPupileColor.getOpacity() - 0.052);
				borderColor = new Color(borderColor.getRed(), borderColor.getGreen(), borderColor.getBlue(), borderColor.getOpacity() - 0.052);
			}
			border.setFill(borderColor);
			bigPupile.setFill(mColor);
			smallPupile.setFill(smallPupileColor);
			border.setStroke(borderColor);
			bigPupile.setStroke(mColor);
			break;

		case FADEOUT:
			if(step == 2)
			{
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), 1.0);
				smallPupileColor = new Color(smallPupileColor.getRed(), smallPupileColor.getGreen(), smallPupileColor.getBlue(), 1.0);
				borderColor = new Color(borderColor.getRed(), borderColor.getGreen(), borderColor.getBlue(), 1.0);
			}
			else if(mColor.getOpacity() != 1.0)
			{
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), mColor.getOpacity() + 0.052);
				smallPupileColor = new Color(smallPupileColor.getRed(), smallPupileColor.getGreen(), smallPupileColor.getBlue(), smallPupileColor.getOpacity() + 0.052);
				borderColor = new Color(borderColor.getRed(), borderColor.getGreen(), borderColor.getBlue(), borderColor.getOpacity() + 0.052);
			}
			border.setFill(borderColor);
			bigPupile.setFill(mColor);
			smallPupile.setFill(smallPupileColor);
			border.setStroke(Color.BLACK);
			bigPupile.setStroke(mColor);
			break;
		case BLINK:
			borderYSize += 0.0450;
			bigPupileYSize += 0.050;
			smallPupileYSize += 0.050;
			
			border.setScaleY(1 - borderYSize);
			bigPupile.setScaleY(1 - bigPupileYSize);
			smallPupile.setScaleY(1 - smallPupileYSize);
			break;
		case BLINKEND:
			borderYSize -= 0.0450;
			bigPupileYSize -= 0.050;
			smallPupileYSize -= 0.050;
			
			border.setScaleY(1 - borderYSize);
			bigPupile.setScaleY(1 - bigPupileYSize);
			smallPupile.setScaleY(1 - smallPupileYSize);
			break;
		case LOOKLEFT:
			xMovement =  0.131f;
			yMovement = 0.184f;
			
			bigPupile.setTranslateX(bigPupile.getTranslateX() + xMovement);
			smallPupile.setTranslateX(smallPupile.getTranslateX() + yMovement);
			break;
			
		case LOOKLEFTEND:
			xMovement =  -0.131f;
			yMovement = -0.182f;
			
			bigPupile.setTranslateX(bigPupile.getTranslateX() + xMovement);
			smallPupile.setTranslateX(smallPupile.getTranslateX() + yMovement);
			break;

		case LOOKRIGHT:
			xMovement =  0.131f;
			yMovement = 0.184f;
			
			bigPupile.setTranslateX(bigPupile.getTranslateX() - xMovement);
			smallPupile.setTranslateX(smallPupile.getTranslateX() - yMovement);
			break;
			
		case LOOKRIGHTEND:
			xMovement =  -0.131f;
			yMovement = -0.184f;
			
			bigPupile.setTranslateX(bigPupile.getTranslateX() - xMovement);
			smallPupile.setTranslateX(smallPupile.getTranslateX() - yMovement);
			break;

		case LOOKDOWN:
			xMovement =  0.100f;
			yMovement = 0.184f;
			
			bigPupile.setTranslateY(bigPupile.getTranslateY() + xMovement);	
			smallPupile.setTranslateY(smallPupile.getTranslateY() + yMovement);
			break;
			
		case LOOKDOWNEND:
			xMovement =  -0.100f;
			yMovement = -0.184f;
			
			bigPupile.setTranslateY(bigPupile.getTranslateY() + xMovement);	
			smallPupile.setTranslateY(smallPupile.getTranslateY() + yMovement);
			break;
			
		case LOOKUP:
			xMovement =  -0.100f;
			yMovement = -0.184f;
			
			bigPupile.setTranslateY(bigPupile.getTranslateY() + xMovement);	
			smallPupile.setTranslateY(smallPupile.getTranslateY() + yMovement);
			break;
			
		case LOOKUPEND:
			xMovement =  0.100f;
			yMovement = 0.184f;
			
			bigPupile.setTranslateY(bigPupile.getTranslateY() + xMovement);	
			smallPupile.setTranslateY(smallPupile.getTranslateY() + yMovement);
			break;
		case ANGRY:
			borderYSize += 0.0210;
			bigPupileYSize += 0.010;
			
			border.setScaleY(1 - borderYSize);
			bigPupile.setScaleY(1 - bigPupileYSize);
			break;
			
		case ANGRYEND:
			borderYSize -= 0.0210f;
			bigPupileYSize -= 0.010;
			
			border.setScaleY(1 - borderYSize);
			bigPupile.setScaleY(1 - bigPupileYSize);
			break;

		case SURPRISED:
			borderYSize -= 0.0158;
			border.setScaleY(1 - borderYSize);
			break;
			
		case SURPRISEDEND:
			borderYSize += 0.0158;
			border.setScaleY(1 - borderYSize);
		break;

		case HAPPY:
			borderYSize += 0.0105;
			borderXSize += 0.0052;
			border.setScaleY(1 - borderYSize);
			border.setScaleX(1 + borderXSize);
			break;
			
		case HAPPYEND:
			borderYSize -= 0.0105;
			borderXSize -= 0.0052;
			border.setScaleY(1 - borderYSize);
			border.setScaleX(1 + borderXSize);
			break;

		case DISGUSTED:
			borderYSize += 0.0105;
			
			quadCurve_1 = (QuadCurveTo) border.getElements().get(1);
			quadCurve_1.setY(quadCurve_1.getY() + 0.105);
			border.getElements().set(1, quadCurve_1);
			
			border.setScaleY(1 - borderYSize);
			break;
			
		case DISGUSTEDEND:
			borderYSize -= 0.0105;
			
			quadCurve_1 = (QuadCurveTo) border.getElements().get(1);
			quadCurve_1.setY(quadCurve_1.getY() - 0.105);
			border.getElements().set(1, quadCurve_1);
			
			border.setScaleY(1 - borderYSize);
			break;

		case CONTEMPT:
			//NOTE: marjvena tvalze araferi ar gaaketo datove carieli
			borderYSize += 0.0105;
			borderXSize += 0.0052;
			border.setScaleY(1 - borderYSize);
			border.setScaleX(1 + borderXSize);
			break;

		case CONTEMPTEND:
			borderYSize -= 0.0105;
			borderXSize -= 0.0052;
			border.setScaleY(1 - borderYSize);
			border.setScaleX(1 + borderXSize);
			break;

		case EXCITED:
			borderYSize -= 0.0105;
			borderXSize -= 0.0052;
			border.setScaleY(1 - borderYSize);
			border.setScaleX(1 + borderXSize);
			break;
			
		case EXCITEDEND:
			borderYSize += 0.0105;
			borderXSize += 0.0052;
			border.setScaleY(1 - borderYSize);
			border.setScaleX(1 + borderXSize);
			break;

		case EMBARRASSED:
			xMovement =  0.100f;
			yMovement = 0.184f;
			
			bigPupile.setTranslateY(bigPupile.getTranslateY() + xMovement);		//LOOKDOWN
			smallPupile.setTranslateY(smallPupile.getTranslateY() + yMovement);
			break;
			
		case EMBARRASSEDEND:
			xMovement =  -0.100f;
			yMovement = -0.184f;
			
			bigPupile.setTranslateY(bigPupile.getTranslateY() + xMovement);
			smallPupile.setTranslateY(smallPupile.getTranslateY() + yMovement);
			break;

		}
	}
	
	public void update()
	{
		bigPupile.setFill(mColor);
	}

	protected void recordColor() {
		if (mHeadFX.mStickmanFX.setCharacterInvisible == false)
			mColorRecorder = mColor;
	}
	
	private Path createEllipsePath(Path startElipse, double centerX, double centerY, double radiusX, double radiusY, double rotate, Color eyeColor, Color borderColor) {
        ArcTo arcTo = new ArcTo();
        arcTo.setX(centerX - radiusX + 1); // to simulate a full 360 degree celcius circle.
        arcTo.setY(centerY - radiusY);
        arcTo.setSweepFlag(false);
        arcTo.setLargeArcFlag(true);
        arcTo.setRadiusX(radiusX);
        arcTo.setRadiusY(radiusY);
        arcTo.setXAxisRotation(rotate);
        
        startElipse.getElements().add(new MoveTo(centerX - radiusX, centerY - radiusY));
        startElipse.getElements().add(arcTo);
        startElipse.getElements().add(new ClosePath());

        if(borderColor != null)
        {
        	startElipse.setStroke(Color.BLACK);
        	startElipse.setStrokeWidth(1);
        }
        
        startElipse.setFill(eyeColor);
        return startElipse;
    }
	
	private Path createBorder(Path startBorder)
	{
		startBorder.getElements().add(new MoveTo(mStart.x, mStart.y));
		startBorder.getElements().add(new QuadCurveTo(mStart.x + 10, mStart.y - 13, mStart.x + 20, mStart.y));
		startBorder.getElements().add(new QuadCurveTo(mStart.x + 10, mStart.y + 13, mStart.x, mStart.y));
		startBorder.setStrokeWidth(1);
		startBorder.setStroke(Color.BLACK);
		startBorder.setFill(borderColor);
		
		return startBorder;
	}


}
