package de.dfki.stickmanfx.bodyfx;

import de.dfki.stickmanfx.StickmanFX;
import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Point;
import java.net.URL;

import com.interactivemesh.jfx.importer.col.ColModelImporter;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.scene.AmbientLight;
import javafx.scene.DepthTest;
import javafx.scene.PointLight;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class HeadFX extends BodyPartFX 
{
    public Dimension mSize = new Dimension(120, 100);
    public StickmanFX mStickmanFX;

    int mHalfHeight = mSize.height / 2;
    int mHalfWidth = mSize.width / 2;
    int mEarWidth = 10;

    int mDrawOffset = 10;
    int mXCenterOffset = mEarWidth / 2;
    int mYCenterOffset = mEarWidth / 2;
    
    URL url;
    ColModelImporter imorter;
    MeshView headMeshView;
    
    int mHeadRadius = 60;
    int mHeadHeight = 30;
    
    public boolean translateRight = false;

    public HeadFX(StickmanFX sm) 
    {
        mStickmanFX = sm;
        mDefaultRotationPoint = new Point(mSize.width / 2, mSize.height);
        
        url  = getClass().getClassLoader().getResource("head.dae");
        imorter = new ColModelImporter();
        imorter.read(url);
        headMeshView=  (MeshView) imorter.getImport()[0];
        
        mColor = Color.rgb(242, 227, 217, 1);
        mRotation = 0;
        mYRotation = 20;
        init();

        calculate(0);
    }

    public Point getLeftEyebrowPostion() 
    {
        return new Point(mHalfWidth + 23, mHalfHeight - 16);
    }

    public Point getRightEyebrowPostion() 
    {
        return new Point(mHalfWidth - 11, mHalfHeight - 16);
    }

    public Point getLeftEyePostion() 
    {
        return new Point(mHalfWidth + 32, mHalfHeight - 8);
    }

    public Point getRightEyePostion() 
    {
        return new Point(mHalfWidth - 20, mHalfHeight - 8);
    }

    public Point getMouthPostion() 
    {
        return new Point(mHalfWidth + mEarWidth / 2, mHalfHeight + mDrawOffset * 3);
    }

    public Point getSpeechBubbleStartPosition() 
    {
        return new Point(mHalfWidth+20, mHalfHeight + 30);
    }
    
    public Point getThinkhBubbleStartPosition() 
    {
        return new Point(mHalfWidth, mHalfHeight);
    }
    
    public Point getBombeStartPosition() 
    {
        return new Point(mHalfWidth+100, mHalfHeight-50);
    }
    
    public Point getBombeEndPosition() 
    {
        return new Point(mHalfWidth+100, mStickmanFX.mRightForeLegFX.getLegStartPosition().y-50);
    }

    public Point getNeckStartPosition() 
    {
        return new Point(mSize.width / 2 + mXCenterOffset, mSize.height + mYCenterOffset + 4);
    }

    public void calculate(int step) 
    {
        Affine af = new Affine();
        clearChildren(this);
        
        headMeshView.setTranslateX(mHalfWidth);
        headMeshView.setTranslateY(mHalfHeight + 55);
        headMeshView.setTranslateZ(-100);
        
        Rotate rx = new Rotate(mRotation, Rotate.X_AXIS);
        Rotate ry = new Rotate(mYRotation, Rotate.Y_AXIS);
        Rotate rz = new Rotate(mZRotation, Rotate.Z_AXIS);
        
//        PhongMaterial material = new PhongMaterial();
//        material.setDiffuseColor(mColor);
//        material.setSpecularColor(mColor);
//        
//        AmbientLight ambient = new AmbientLight(new Color(0.2, 0.2, 0.2, 0.6));
//        ambient.setTranslateX(mHalfWidth);
//        ambient.setTranslateY(mHalfHeight + 55); 
//        ambient.setTranslateZ(-100);
//        
//        PointLight pointLight = new PointLight();
//        pointLight.setColor(mColor);
//        pointLight.setTranslateX(mHalfWidth - 80);
//        pointLight.setTranslateY(mHalfHeight + 55); 
//        pointLight.setTranslateZ(-100);
        
//        mHead.setMaterial(material);
        headMeshView.getTransforms().clear();
        headMeshView.getTransforms().addAll(rx, ry, rz);
        
        // head
//        mHead.getElements().add(new MoveTo(mEarWidth, mHalfHeight));
//        mHead.getElements().add(new CubicCurveTo(mEarWidth, -mHalfHeight / 5, mSize.width, -mHalfHeight / 5, mSize.width, mHalfHeight));
//        mHead.getElements().add(new CubicCurveTo(mSize.width, 120, mEarWidth, 120, mEarWidth, mHalfHeight));
//            
//        af.appendRotation(mRotation, mDefaultRotationPoint.x, mDefaultRotationPoint.y);
//        if(translateRight)
//        	af.appendTranslation(mTranslation-45, -45);
//        else
//        	af.appendTranslation(0, mTranslation);
//        mHead.getTransforms().clear();
//        mHead.getTransforms().add(af);

        if(mStickmanFX.mFemaleHairFX != null)
        {
        	mStickmanFX.mFemaleHairFX.mRotation = this.mRotation;
        	mStickmanFX.mFemaleHairFX.mYRotation = this.mYRotation;
        	mStickmanFX.mFemaleHairFX.mZRotation = this.mZRotation;
        	mStickmanFX.mFemaleHairFX.calculate(step);
        }
        
        if(mStickmanFX.mLeftEyeFX != null)
        {
        	mStickmanFX.mLeftEyeFX.mRotation = this.mRotation;
        	mStickmanFX.mLeftEyeFX.mYRotation = this.mYRotation;
        	mStickmanFX.mLeftEyeFX.mZRotation = this.mZRotation;
        	mStickmanFX.mLeftEyeFX.calculate(step);
        }
        
        if(mStickmanFX.mRightEyeFX != null)
        {
        	mStickmanFX.mRightEyeFX.mRotation = this.mRotation;
        	mStickmanFX.mRightEyeFX.mYRotation = this.mYRotation;
        	mStickmanFX.mRightEyeFX.mZRotation = this.mZRotation;
        	mStickmanFX.mRightEyeFX.calculate(step);
        }
        
        if(mStickmanFX.mLeftEyebrowFX != null)
        {
        	mStickmanFX.mLeftEyebrowFX.mRotation = this.mRotation;
        	mStickmanFX.mLeftEyebrowFX.mYRotation = this.mYRotation;
        	mStickmanFX.mLeftEyebrowFX.mZRotation = this.mZRotation;
        	mStickmanFX.mLeftEyebrowFX.calculate(step);
        }
        
        if(mStickmanFX.mRightEyebrowFX != null)
        {
        	mStickmanFX.mRightEyebrowFX.mRotation = this.mRotation;
        	mStickmanFX.mRightEyebrowFX.mYRotation = this.mYRotation;
        	mStickmanFX.mRightEyebrowFX.mZRotation = this.mZRotation;
        	mStickmanFX.mRightEyebrowFX.calculate(step);
        }
        
        this.getChildren().addAll(headMeshView);
        //update();

    }

    public void update() 
    {	
    	if (mStickmanFX.setCharacterInvisible == false) 
    		mColorRecorder = mColor;
        // fill
        if (mStickmanFX.setCharacterInvisible == true) 
        {
            if (mStickmanFX.fadeControler == true) //Added by Robbie
            {

                int fadeFactor = mStickmanFX.mMouthFX.mShapeAnimationStep * 10;
                if (fadeFactor <= 20) 
                {
                    fadeFactor = 0;
                }
                mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), (fadeFactor * 100 / 255) / 100f);
                //mColor = Color.rgb(242, 227, 217, (fadeFactor * 100 / 255) / 100f); //fadeFactor Interval [0 - 1]
            } 
            else 
            {
                int fadeFactor = (20 - mStickmanFX.mMouthFX.mShapeAnimationStep) * 9;
                if (fadeFactor >= 160) 
                {
                	mColor = mColorRecorder;
                }
                else
                mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), (fadeFactor * 100 / 255) / 100f);
                //mColor = Color.rgb(242, 227, 217, (fadeFactor * 100 / 255) / 100f); //fadeFactor Interval [0 - 1]
            }
            
            //not good. FixMe
            //update Body (FadeIn, FadeOut)
            mStickmanFX.mBodyFX.update();
        } 

//        // head
//        mHead.setFill(mColor);
//        // ears
//        mLeftEar.setFill(mColor);
//        mRightEar.setFill(mColor);
//        // draw outlines
//        //head
//        mHead.setStroke(mColor.darker());
//        mHead.setStrokeWidth(2);
//        // ears
//        mLeftEar.setStroke(mColor.darker());
//        mLeftEar.setStrokeWidth(2);
//        mRightEar.setStroke(mColor.darker());
//        mRightEar.setStrokeWidth(2);

    }
}
