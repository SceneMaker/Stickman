/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.reeti.body;

import java.awt.Dimension;

import javafx.scene.Group;
import javafx.scene.shape.Circle;
import javafx.scene.transform.Rotate;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class RightCheek extends BodyPartFX {

    Head mHeadFX;

    private final Circle mLed;
    private final Group mLedGroup;

    private final int size;

    public RightCheek(Head head) {
        size = 70;
        mLed = new Circle(size);
        mLedGroup = new Group();
        mHeadFX = head;
        mSize = new Dimension(mLength, mLength);
        mStart = mHeadFX.getLeftEyebrowPostion();
        
        mYRotation = 25;
        mXRotation = -10;
        Rotate ry = new Rotate(mYRotation,  Rotate.Y_AXIS);
        Rotate rx = new Rotate(mXRotation, Rotate.X_AXIS);
        mLedGroup.getTransforms().addAll(rx, ry);
        
        mLedGroup.getChildren().add(mLed);

        mLedGroup.setVisible(false);
        init();

        mHeadFX.mHead.getChildren().add(mLedGroup);
    }

    @Override
    public void init() {
        super.init();
        mLed.setTranslateX(mStart.x - 14);
        mLed.setTranslateY(mStart.y + 106.5);
        mLed.setTranslateZ(-133.6);
    }

    public int getSize() {
        return size;
    }

    public Circle getLed() {
        return mLed;
    }

    public Group getLedGroup() {
        return mLedGroup;
    }
}
