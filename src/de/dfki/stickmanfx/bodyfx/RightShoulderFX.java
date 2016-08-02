package de.dfki.stickmanfx.bodyfx;

import de.dfki.stickman.body.*;
import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import javafx.scene.paint.Color;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;
import javafx.scene.transform.Affine;

/**
 *
 * @author Patrick Gebhard
 *
 */
public class RightShoulderFX extends BodyPartFX 
{

	BodyFX mBodyFX;

	int mShoulderLength = 15;
	Dimension mSize = new Dimension(mShoulderLength, mShoulderLength);

	Point mStart;
	Point mEnd;

	Path mShoulder;

	public RightShoulderFX(BodyFX body) {
		mBodyFX = body;

		mDefaultRotation = 70;
		mRotation = mDefaultRotation;
		mToDegree = mDefaultRotation;
		mRotationStep = 0.0f;

		init();

		calculate(0);
	}

	public Point getRightShoulderEndPosition() 
        {
            //??????????????????
                return (mShoulder != null) ? new Point((int) (mShoulder.boundsInParentProperty().get().getMinX()+ 2), (int) mShoulder.boundsInParentProperty().get().getMaxY()-1) : new Point(0, 0);
		//return (mShoulder != null) ? new Point((int) mShoulder.getCurrentPoint().getX(), (int) mShoulder.getCurrentPoint().getY()) : new Point(0, 0);
	}

	@Override
	public void calculate(int step) 
        {
		mStart = mBodyFX.getRightArmStartPostion();
		mEnd = new Point(mStart.x, mStart.y + mShoulderLength);

		mShoulder = new Path();
		mShoulder.getElements().add(new MoveTo(mStart.x, mStart.y + 2));
		mShoulder.getElements().add(new QuadCurveTo(mStart.x, (mStart.y + mEnd.y) / 2, mEnd.x, mEnd.y));

                Affine af = new Affine();
                af.appendRotation(mRotation, mStart.x, mStart.y);
                mShoulder.getTransforms().add(af);
//		AffineTransform t = new AffineTransform();
//		t.rotate(Math.toRadians(mRotation), mStart.x, mStart.y);
//		mShoulder.transform(t);

                this.getChildren().add(mShoulder);
	}

	@Override
	public void update() 
        {
                Color curreColor = Color.rgb(80, 80, 80);
		// draw outlines		
		if(mBodyFX.mNeckFX.mHeadFX.mStickmanFX.setCharacterInvisible == true)
		{
			if(mBodyFX.mNeckFX.mHeadFX.mStickmanFX.fadeControler==true)             //Added by Robbie
			{
				int fadeFactor = mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep*12;
				if(fadeFactor<=24) fadeFactor=0;
                                curreColor = Color.rgb(80, 80, 80, (fadeFactor*100/255)/100f);
				//g2.setColor(new Color(80, 80, 80,fadeFactor));
			}
			else
			{
				int fadeFactor = (20-mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep)*12;
				if(fadeFactor >= 216) fadeFactor=255;
                                curreColor = Color.rgb(80, 80, 80, (fadeFactor*100/255)/100f);
				//g2.setColor(new Color(80, 80, 80,fadeFactor));
			}
		}
		
                mShoulder.setStroke(curreColor);
                mShoulder.setStrokeWidth(3);
                mShoulder.setStrokeLineCap(StrokeLineCap.ROUND);
                mShoulder.setStrokeLineJoin(StrokeLineJoin.ROUND);
//		g2.setStroke(new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
//
//		
//		g2.draw(mShoulder);
	}
}
