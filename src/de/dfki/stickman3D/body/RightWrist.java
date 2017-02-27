/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.body;

import com.interactivemesh.jfx.importer.col.ColModelImporter;
import de.dfki.common.Gender;
import de.dfki.stickman3D.Stickman3D;
import javafx.scene.Group;
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
public class RightWrist extends BodyPartFX {

    public static enum SHAPE {
        DEFAULT, FADEIN, FADEOUT
    };

    public RightWrist.SHAPE mShape = RightWrist.SHAPE.DEFAULT;

    RightForeArmFX mRightForeArmFX;
    int mArmLength = 80;
    Dimension mSize = new Dimension(mArmLength, mArmLength);

    URL url;
    ColModelImporter imorter;
    public MeshView mRightWristMesh;
    PhongMaterial material;

    Group rightWristGroup;

    public RightWrist(RightForeArmFX rightForeArmFX) {
        mRightForeArmFX = rightForeArmFX;

        imorter = new ColModelImporter();
        mColor = Color.rgb(242, 227, 217, 1);

        url = getClass().getClassLoader().getResource("BodyParts/Stickman3D/RightWrist.dae");

        mToDegreeX = mDefaultRotation;
        mZRotation = 0;
        mYRotation = 50;

        imorter.read(url);
        mRightWristMesh = (MeshView) imorter.getImport()[0];

        material = new PhongMaterial();
        material.setDiffuseColor(mColor);
        mRightWristMesh.setMaterial(material);

        rightWristGroup = new Group();
        rightWristGroup.setId("RightWrist");

        rightWristGroup.getChildren().add(mRightWristMesh);

        mRightForeArmFX.rightForeArmGroup.getChildren().add(rightWristGroup);

        init();
    }

    @Override
    public void setShape(String s) {
        SHAPE shape = SHAPE.valueOf(s);
        mShape = (shape != null) ? shape : SHAPE.DEFAULT;
    }

    @Override
    public void resetShape() {
        mShape = RightWrist.SHAPE.DEFAULT;
    }

    @Override
    public void calculate(int step) {
        Rotate rx = new Rotate(mXRotation, Rotate.X_AXIS);
        Rotate ry = new Rotate(mYRotation, Rotate.Y_AXIS);
        Rotate rz = new Rotate(mZRotation, Rotate.Z_AXIS);

        if (mRightForeArmFX.mUpperArmFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mType == Gender.TYPE.MALE) {
            rightWristGroup.setTranslateX(mStart.x);
            rightWristGroup.setTranslateY(mStart.y + 70);
            rightWristGroup.setTranslateZ(0);
        } else {
            rightWristGroup.setTranslateX(mStart.x);
            rightWristGroup.setTranslateY(mStart.y + 70);
            rightWristGroup.setTranslateZ(0);
        }

        rightWristGroup.getTransforms().clear();
        rightWristGroup.getTransforms().addAll(rx, ry, rz);

        switch (mShape) {
            case FADEIN:
                if (step == 2) {
                    mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), 0.0);
                    update();
                    mRightWristMesh.setVisible(false);
                } else if (mColor.getOpacity() != 0.0) {
                    mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), mColor.getOpacity() - 0.052);
                    update();
                }
                break;

            case FADEOUT:
                mRightWristMesh.setVisible(true);

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
        mRightWristMesh.setMaterial(material);
    }

}
