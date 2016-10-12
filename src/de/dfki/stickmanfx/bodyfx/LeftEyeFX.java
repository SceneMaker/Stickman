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
import javafx.util.Duration;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class LeftEyeFX extends BodyPartFX {


	public static enum SHAPE {
		DEFAULT, BLINK, BLINKEND, LOOKLEFT, LOOKLEFTEND, LOOKRIGHT, LOOKRIGHTEND, ANGRY, ANGRYEND, SURPRISED, SURPRISEDEND, HAPPY, HAPPYEND, DISGUSTED, DISGUSTEDEND, LOVED, LOVEDEND, LOVED1, CONTEMPT, CONTEMPTEND, EXCITED, EXCITEDEND, EMBARRASSED, EMBARRASSEDEND
	};

	HeadFX mHeadFX;
	Group leftEyeGroup;
	
	Path border;
	Path bigPupile;
	Path smallPupile;
	
	Point borderPoint;
	Point bigPupilePoint;
	Point smallPupilePoint;
	

	public LeftEyeFX.SHAPE mShape = LeftEyeFX.SHAPE.DEFAULT;

	public LeftEyeFX(HeadFX head) {
		mHeadFX = head;
		
		mColor = Color.rgb(mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.FEMALE ? 22 : 0,
				mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.FEMALE ? 40 : 0,
				mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.FEMALE ? 65 : 0, (144 * 100 / 255) / 100f);
		
		init();
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
		mStart = mHeadFX.getLeftEyePostion();
		
		float xMovement;
		float yMovement;
		
		switch (mShape) {
		case DEFAULT:
			if (mHeadFX.mStickmanFX.setCharacterInvisible == true) {
				if (mHeadFX.mStickmanFX.fadeControler == true) // Added by
																// Robbie
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

					if (fadeFactor >= 118) {
						mColor = mColorRecorder;
					} else
						mColor = Color.rgb(mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.FEMALE ? 22 : 0,
								mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.FEMALE ? 40 : 0,
								mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.FEMALE ? 65 : 0,
								(fadeFactor * 100 / 255) / 100f);
				}
			}
			
			border = createEllipsePath(0, 0, 9, 7, 0, Color.WHITE, Color.BLACK);
			bigPupile = createEllipsePath(0, 0, 3.5, 3.5, 0, Color.BLACK, null);
			smallPupile = createEllipsePath(0, 0, 1.7, 1.7, 0, Color.WHITE, null);
			
			borderPoint = new Point();
			bigPupilePoint = new Point();
			smallPupilePoint = new Point();
			
			borderPoint.x = mStart.x + 30;
			borderPoint.y = mStart.y + 45;
			bigPupilePoint.x = mStart.x + 24;
			bigPupilePoint.y = mStart.y + 45;
			smallPupilePoint.x = mStart.x + 22;
			smallPupilePoint.y = mStart.y + 45;
			
			border.setTranslateX(borderPoint.x);
			border.setTranslateY(borderPoint.y);
			
			bigPupile.setTranslateX(bigPupilePoint.x);
			bigPupile.setTranslateY(bigPupilePoint.y);
			
			smallPupile.setTranslateX(smallPupilePoint.x);
			smallPupile.setTranslateY(smallPupilePoint.y);
			System.out.println(bigPupilePoint.x);
			
			break;

		case BLINK:
			break;
		case BLINKEND:
			break;
		case LOOKLEFT:
			xMovement =  0.131f;
			yMovement = 0.184f;
			
			bigPupile.setTranslateX(bigPupile.getTranslateX() + xMovement);
			smallPupile.setTranslateX(smallPupile.getTranslateX() + yMovement);
			break;
			
		case LOOKLEFTEND:
			xMovement =  -0.131f;
			yMovement = -0.184f;
			
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

		case SURPRISED:
			break;

		case HAPPY:
			break;

		case DISGUSTED:
			break;

		case LOVED:
			break;
//		case LOVED1:
//			movement = AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep;
//			xMovement = movement / 10 * 6;
//			yMovement1 = movement / 10 * 6;
//			yMovement2 = movement / 10 * 3;
//
//			showHearts(mHeadFX, xMovement, yMovement1, yMovement2);
//
//			mPath.getElements().add(new MoveTo(mStart.x, mStart.y));
//			mPath.getElements()
//					.add(new QuadCurveTo(mStart.x - xMovement, mEnd.y - yMovement2, mStart.x, mEnd.y + yMovement1));
//			mPath.getElements().add(new MoveTo(mStart.x, mStart.y));
//			mPath.getElements()
//					.add(new QuadCurveTo(mStart.x + xMovement, mEnd.y - yMovement2, mStart.x, mEnd.y + yMovement1));
//
//			break;

		case CONTEMPT:
			break;

		case CONTEMPTEND:
			break;

		case EXCITED:
			break;

		case EMBARRASSED:
			break;

		}
		
		border.setTranslateZ(-17);
		bigPupile.setTranslateZ(-18);
		smallPupile.setTranslateZ(-19);
		
		leftEyeGroup = new Group();
		leftEyeGroup.getChildren().add(border);
		leftEyeGroup.getChildren().add(bigPupile);
		leftEyeGroup.getChildren().add(smallPupile);
		
		if (step == 0) 
			mHeadFX.mHead.getChildren().add(leftEyeGroup);
		else
			mHeadFX.mHead.getChildren().set(3, leftEyeGroup);
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
