package de.dfki.stickmanfx.bodyfx;

import java.awt.Dimension;
import java.awt.Point;
import java.net.URL;

import com.interactivemesh.jfx.importer.col.ColModelImporter;

import static de.dfki.stickman.animationlogic.util.Interpolator.linear;
import de.dfki.stickmanfx.StickmanFX;
import de.dfki.stickmanfx.animationlogic.AnimatorFX;
import java.awt.BasicStroke;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.ClosePath;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class RightEyeFX extends BodyPartFX {
	double xMovement;
	double yMovement1;
	double yMovement2;

	public static enum SHAPE {
		DEFAULT, BLINK, FADEIN, FADEOUT, BLINKEND, LOOKLEFT, LOOKLEFTEND, LOOKRIGHT, LOOKRIGHTEND, LOOKDOWN, LOOKDOWNEND, LOOKUP, LOOKUPEND, ANGRY, ANGRYEND, SURPRISED, SURPRISEDEND, HAPPY, HAPPYEND, DISGUSTED, DISGUSTEDEND, LOVED, LOVEDEND, LOVED1, CONTEMPT, CONTEMPTEND, EXCITED, EXCITEDEND, EMBARRASSED, EMBARRASSEDEND
	};

	HeadFX mHeadFX;
	Group rightEyeGroup;
	
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

	public RightEyeFX.SHAPE mShape = RightEyeFX.SHAPE.DEFAULT;

	public RightEyeFX(HeadFX head) {
		mHeadFX = head;

		if(mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.MALE)
			mColor = Color.rgb(0, 0, 0, 1);
		else
			mColor = Color.rgb(0, 0, 255, 1);

		smallPupileColor = Color.rgb(255, 255, 255, 1);
		borderColor = Color.rgb(255, 255, 255, 1);
		init();
	}

	@Override
	public void setShape(String s) {
		RightEyeFX.SHAPE shape = RightEyeFX.SHAPE.valueOf(s);
		mShape = (shape != null) ? shape : RightEyeFX.SHAPE.DEFAULT;
	}

	@Override
	public void resetShape() {
		mShape = RightEyeFX.SHAPE.DEFAULT;
	}

	@Override
	public void calculate(int step) {
		mStart = mHeadFX.getRightEyePostion();
		
		float xMovement;
		float yMovement;
		
		switch (mShape) {
		case DEFAULT:
			if (mHeadFX.mStickmanFX.setCharacterInvisible == true) {
				if (mHeadFX.mStickmanFX.fadeControler == true) 
				{
					int fadeFactor = mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep * 7;
					if (fadeFactor <= 14) {
						fadeFactor = 0;
					}
					mColor = Color.rgb(mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.FEMALE ? 22 : 0,
							mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.FEMALE ? 40 : 0,
							mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.FEMALE ? 65 : 0,
							(fadeFactor * 100 / 255) / 100f);
				} else {
					int fadeFactor = (20 - mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep) * 7;

					if (fadeFactor >= 119) {
						mColor = mColorRecorder;
					} else
						mColor = Color.rgb(mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.FEMALE ? 22 : 0,
								mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.FEMALE ? 40 : 0,
								mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.FEMALE ? 65 : 0,
								(fadeFactor * 100 / 255) / 100f);
				}
			}
			
			border = new Path();
			border.getElements().add(new MoveTo(mStart.x, mStart.y));
			border.getElements().add(new QuadCurveTo(mStart.x - 10, mStart.y - 13, mStart.x - 20, mStart.y));
			border.getElements().add(new QuadCurveTo(mStart.x - 10, mStart.y + 13, mStart.x, mStart.y));
			border.setStrokeWidth(1);
			border.setStroke(Color.BLACK);
			border.setFill(Color.WHITE);
			
			bigPupile = createEllipsePath(0, 0, 3.5, 3.5, 0, mColor, null);
			
			smallPupile = createEllipsePath(0, 0, 1.4, 1.4, 0, Color.WHITE, null);
			smallPupile.setStroke(null);
			
			bigPupile.setTranslateX(mStart.x - 7);
			bigPupile.setTranslateY(mStart.y);
			
			smallPupile.setTranslateX(mStart.x - 9);
			smallPupile.setTranslateY(mStart.y);
			
			borderYSize = 0;
			borderXSize = 0;
			bigPupileYSize = 0;
			smallPupileYSize = 0;

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
			//NOTHING
			break;

		case CONTEMPTEND:
			//NOTHING
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
		
		border.setTranslateZ(-17);
		bigPupile.setTranslateZ(-18);
		smallPupile.setTranslateZ(-19);
		
		rightEyeGroup = new Group();
		rightEyeGroup.setId("RightEye");
		rightEyeGroup.getChildren().add(border);
		rightEyeGroup.getChildren().add(bigPupile);
		rightEyeGroup.getChildren().add(smallPupile);
		
		if (step == 0) 
			mHeadFX.mHead.getChildren().add(rightEyeGroup);
		else
			mHeadFX.mHead.getChildren().set(5, rightEyeGroup);
	}

	public void update()
	{
		bigPupile.setFill(mColor);
	}
	protected void recordColor() {
		if (mHeadFX.mStickmanFX.setCharacterInvisible == false)
			mColorRecorder = mColor;
	}
	
	private Path createEllipsePath(double centerX, double centerY, double radiusX, double radiusY, double rotate, Color eyeColor, Color borderColor) {
        ArcTo arcTo = new ArcTo();
        arcTo.setX(centerX - radiusX + 1); // to simulate a full 360 degree celcius circle.
        arcTo.setY(centerY - radiusY);
        arcTo.setSweepFlag(false);
        arcTo.setLargeArcFlag(true);
        arcTo.setRadiusX(radiusX);
        arcTo.setRadiusY(radiusY);
        arcTo.setXAxisRotation(rotate);
        
        Path path = new Path();
        path.getElements().add(new MoveTo(centerX - radiusX, centerY - radiusY));
        path.getElements().add(arcTo);
        path.getElements().add(new ClosePath());

        if(borderColor != null)
        {
        	path.setStroke(Color.BLACK);
            path.setStrokeWidth(1);
        }
        
        path.setFill(eyeColor);
        return path;
    }
}
