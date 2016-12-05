/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanSwing.body;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.geom.GeneralPath;

/**
 *
 * @author Patrick Gebhard
 *
 */
public class Neck extends BodyPart {

    Head mHead;

    public Neck(Head head) {
        mHead = head;
        mLength = 8;
        mSize = new Dimension(4, mLength);
        mColor = new Color(80, 80, 80);

        init();
    }

    public Point getBodyStartPosition() {
        return new Point(mEnd.x, mEnd.y);
    }

    @Override
    public void createShape() {
        mStart = mHead.getNeckStartPosition();
        mEnd = new Point(mStart.x, mStart.y + mLength);

        clearDrawObjects();

        if (mHead.mStickman.setCharacterInvisible == true) {
            if (mHead.mStickman.fadeControler == true) //Added by Robbie
            {
                int fadeFactor = mHead.mStickman.mMouth.mShapeAnimationStep * 12;
                if (fadeFactor <= 24) {
                    fadeFactor = 0;
                }
                mColor = new Color(80, 80, 80, fadeFactor);
            } else {
                int fadeFactor = (20 - mHead.mStickman.mMouth.mShapeAnimationStep) * 12;
                if (fadeFactor >= 216) {
                    fadeFactor = 255;
                }
                mColor = new Color(80, 80, 80, fadeFactor);
            }
        }

        GeneralPath gp = new GeneralPath();
        gp.moveTo(mStart.x, mStart.y);
        gp.lineTo(mEnd.x, mEnd.y);

        addToDrawObjects(gp);
    }
}
