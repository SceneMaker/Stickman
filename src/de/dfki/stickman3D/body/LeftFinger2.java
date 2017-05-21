/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.body;

import com.interactivemesh.jfx.importer.col.ColModelImporter;
import de.dfki.common.Gender;
import de.dfki.stickman3D.Stickman3D;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.MeshView;
import javafx.scene.transform.Rotate;

import java.awt.*;
import java.net.URL;

/**
 *
 * @author Beka
 *
 */
public class LeftFinger2 extends BodyPartFX {

    public static enum SHAPE {
        DEFAULT, FADEIN, FADEOUT
    };

    public LeftFinger2.SHAPE mShape = LeftFinger2.SHAPE.DEFAULT;

    LeftWrist mLeftWrist;
    int mArmLength = 80;
    Dimension mSize = new Dimension(mArmLength, mArmLength);

    URL url;
    ColModelImporter imorter;
    public MeshView mLeftFinger2;
    PhongMaterial material;

    public LeftFinger2(LeftWrist leftWrist) {
        mLeftWrist = leftWrist;

        imorter = new ColModelImporter();
        mColor = Color.rgb(242, 227, 217, 1);

        url = getClass().getClassLoader().getResource("BodyParts/Stickman3D/Finger2_3_4.dae");

        mDefaultRotation = -20;
        mZRotation = 0;
        mToDegreeX = mDefaultRotation;

        imorter.read(url);
        mLeftFinger2 = (MeshView) imorter.getImport()[0];

        material = new PhongMaterial();
        material.setDiffuseColor(mColor);
        mLeftFinger2.setMaterial(material);

        mLeftWrist.leftWristGroup.getChildren().add(mLeftFinger2);

        init();
    }

    @Override
    public void setShape(String s) {
        SHAPE shape = SHAPE.valueOf(s);
        mShape = (shape != null) ? shape : SHAPE.DEFAULT;
    }

    @Override
    public void resetShape() {
        mShape = LeftFinger2.SHAPE.DEFAULT;
    }

    @Override
    public void calculate(int step) {
        Rotate rx = new Rotate(mXRotation, Rotate.X_AXIS);
        Rotate ry = new Rotate(mYRotation, Rotate.Y_AXIS);
        Rotate rz = new Rotate(mZRotation, Rotate.Z_AXIS);

        if (mLeftWrist.mLeftForeArmFX.mUpperArmFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mType == Gender.TYPE.MALE) {
            mLeftFinger2.setTranslateX(mStart.x - 3);
            mLeftFinger2.setTranslateY(mStart.y + 17);
            mLeftFinger2.setTranslateZ(0);
        } else {
            mLeftFinger2.setTranslateX(mStart.x - 3);
            mLeftFinger2.setTranslateY(mStart.y + 17);
            mLeftFinger2.setTranslateZ(0);
        }

        mLeftFinger2.getTransforms().clear();
        mLeftFinger2.getTransforms().addAll(rx, ry, rz);

        switch (mShape) {
            case FADEIN:
                if (step == 2) {
                    mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), 0.0);
                    update();
                    mLeftFinger2.setVisible(false);
                } else if (mColor.getOpacity() != 0.0) {
                    mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), mColor.getOpacity() - 0.052);
                    update();
                }
                break;

            case FADEOUT:
                mLeftFinger2.setVisible(true);

                if (step == 2) {
                    mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), 1.0);
                    update();
                } else if (mColor.getOpacity() != 1.0) {
                    mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), mColor.getOpacity() + 0.052);
                    update();
                }
                break;
        }
    }

    @Override
    public void update() {
        material.setDiffuseColor(mColor);
        mLeftFinger2.setMaterial(material);
    }

}
