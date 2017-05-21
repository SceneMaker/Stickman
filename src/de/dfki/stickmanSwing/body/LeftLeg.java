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
 */
public class LeftLeg extends BodyPart {

    Body mBody;

    public LeftLeg(Body body) {
        mBody = body;
        mLength = 150;
        mSize = new Dimension(10, mLength);
        mColor = new Color(80, 80, 80);
        init();
    }

    @Override
    public void createShape() {
        mStart = mBody.getLeftLegStartPostion();
        mEnd = new Point(mStart.x, mStart.y + mLength);

        clearDrawObjects();

        if (mBody.mNeck.mHead.mStickman.setCharacterInvisible == true) {
            if (mBody.mNeck.mHead.mStickman.fadeControler == true) //Added by Robbie
            {
                int fadeFactor = mBody.mNeck.mHead.mStickman.mMouth.mShapeAnimationStep * 12;
                if (fadeFactor <= 24) {
                    fadeFactor = 0;
                }
                mColor = new Color(80, 80, 80, fadeFactor);
            } else {
                int fadeFactor = (20 - mBody.mNeck.mHead.mStickman.mMouth.mShapeAnimationStep) * 12;
                if (fadeFactor >= 216) {
                    fadeFactor = 255;
                }
                mColor = new Color(80, 80, 80, fadeFactor);
            }
        }

        GeneralPath gp = new GeneralPath();
        gp.moveTo(mStart.x, mStart.y + 2);
        gp.quadTo(mStart.x + 5, (mStart.y + mEnd.y) / 2, mEnd.x, mEnd.y);
        addToDrawObjects(gp);

        gp = new GeneralPath();
        gp.moveTo(mEnd.x - 5, mEnd.y + 4);
        gp.quadTo(mEnd.x, mEnd.y + 2, mEnd.x + 5, mEnd.y + 4);
        gp.quadTo(mEnd.x, mEnd.y + 2, mEnd.x + 5, mEnd.y + 4);
        addToDrawObjects(gp);
    }
}
