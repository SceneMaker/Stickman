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
		DEFAULT, BLINK, BLINKEND, LOOKLEFT, LOOKLEFTEND, LOOKRIGHT, LOOKRIGHTEND, ANGRY, ANGRYEND, SURPRISED, SURPRISEDEND, HAPPY, HAPPYEND, DISGUSTED, DISGUSTEDEND, LOVED, LOVEDEND, LOVED1, CONTEMPT, CONTEMPTEND, EXCITED, EXCITEDEND, EMBARRASSED, EMBARRASSEDEND
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

	public RightEyeFX.SHAPE mShape = RightEyeFX.SHAPE.DEFAULT;

	public RightEyeFX(HeadFX head) {
		mHeadFX = head;

		mColor = Color.rgb(mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.FEMALE ? 22 : 0,
				mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.FEMALE ? 40 : 0,
				mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.FEMALE ? 65 : 0, (144 * 100 / 255) / 100f);

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
			
			
			bigPupile = createEllipsePath(0, 0, 3.5, 3.5, 0, Color.BLACK, null);
			smallPupile = createEllipsePath(0, 0, 1.7, 1.7, 0, Color.WHITE, null);
			
			bigPupile.setTranslateX(mStart.x - 7);
			bigPupile.setTranslateY(mStart.y);
			
			smallPupile.setTranslateX(mStart.x - 9);
			smallPupile.setTranslateY(mStart.y);
			
			borderYSize = 0;
			borderXSize = 0;
			bigPupileYSize = 0;
			smallPupileYSize = 0;

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

		case ANGRY:
			break;

		case ANGRYEND:
			break;

		case SURPRISED:
			break;

		case SURPRISEDEND:
			break;

		case HAPPY:
			break;

		case HAPPYEND:
			break;

		case DISGUSTED:
			break;

		case DISGUSTEDEND:
			break;

		case CONTEMPT:
			break;

		case CONTEMPTEND:
			break;

		case EXCITED:
			break;

		case EXCITEDEND:
			break;

		case EMBARRASSED:
			break;

		case EMBARRASSEDEND:
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
