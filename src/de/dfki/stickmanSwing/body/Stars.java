package de.dfki.stickmanSwing.body;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.geom.GeneralPath;

/**
 *
 * @author Patrick Gebhard
 *
 */
public class Stars extends BodyPart {

    public static enum SHAPE {

        DEFAULT, SAYBYE, SAYHI, STARSDISAPPEAR, STARSFADEOUT, STARSFADEIN
    };

    Body mBody;
    public Stars.SHAPE mShape = Stars.SHAPE.DEFAULT;

    public Stars(Body body) {

        mBody = body;
        mLength = 150;
        mSize = new Dimension(120, mLength);
        mColor = new Color(255, 0, 0, 255);
        mStroke = new BasicStroke(5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);

        init();
    }

    @Override
    public void setShape(String s) {
        Stars.SHAPE shape = Stars.SHAPE.valueOf(s);
        mShape = (shape != null) ? shape : Stars.SHAPE.DEFAULT;
    }

    @Override
    public void resetShape() {
        mShape = Stars.SHAPE.DEFAULT;
    }

    private void creatStar(int radius, Point center, GeneralPath gp) {
        int r = radius;
        double ch = 72 * Math.PI / 180;
        int x0 = center.x;
        int y0 = center.y;
        int x1 = x0;
        int x2 = (int) (x0 - Math.sin(ch) * r);
        int x3 = (int) (x0 + Math.sin(ch) * r);
        int x4 = (int) (x0 - Math.sin(ch / 2) * r);
        int x5 = (int) (x0 + Math.sin(ch / 2) * r);
        int y1 = y0 - r;
        int y2 = (int) (y0 - Math.cos(ch) * r);
        int y3 = y2;
        int y4 = (int) (y0 + Math.cos(ch / 2) * r);
        int y5 = y4;

        gp.moveTo(x1, y1);
        gp.lineTo(x4, y4);
        gp.lineTo(x3, y3);
        gp.lineTo(x2, y2);
        gp.lineTo(x5, y5);
        gp.lineTo(x1, y1);
    }

    // Start.x left leg side
    @Override
    public void createShape() {

        mStart = mBody.getLeftLegStartPostion();
        mEnd = new Point(mStart.x, mStart.y + mLength);

        clearDrawObjects();
        GeneralPath gp = new GeneralPath();

        switch (mShape) {
            case DEFAULT:
                gp.moveTo(mStart.x, mStart.y);
                mColor = new Color(0, 0, 0, 0);

                break;

            case SAYBYE:
                mColor = new Color(80, 80, 80, 128);
                // B
                gp.moveTo(mStart.x - 100, mStart.y);
                gp.lineTo(mEnd.x - 100, mEnd.y);
                gp.moveTo(mStart.x - 100, mStart.y);
                gp.quadTo(mStart.x - 100 + 70, mStart.y + 30, mStart.x - 100, mStart.y + mLength / 2);
                gp.moveTo(mStart.x - 100, mStart.y + mLength / 2);
                gp.quadTo(mStart.x - 100 + 70, mEnd.y - 40, mEnd.x - 100, mEnd.y);

                // Y
                gp.moveTo(mStart.x - 60, mStart.y);
                gp.lineTo(mEnd.x - 40, mStart.y + mLength / 2);
                gp.moveTo(mStart.x - 20, mStart.y);
                gp.lineTo(mEnd.x - 40, mStart.y + mLength / 2);
                gp.moveTo(mEnd.x - 40, mStart.y + mLength / 2);
                gp.lineTo(mEnd.x - 40, mEnd.y);

                // E
                gp.moveTo(mStart.x - 10, mStart.y);
                gp.lineTo(mEnd.x - 10, mEnd.y);
                gp.moveTo(mStart.x - 10, mStart.y);
                gp.lineTo(mStart.x + 30, mStart.y);
                gp.moveTo(mStart.x - 10, mStart.y + mLength / 2);
                gp.lineTo(mEnd.x + 30, mStart.y + mLength / 2);
                gp.moveTo(mEnd.x - 10, mEnd.y);
                gp.lineTo(mEnd.x + 30, mEnd.y);

                break;

            case SAYHI:
                mColor = new Color(80, 80, 80, 128);
                // H
                gp.moveTo(mStart.x - 100, mStart.y);
                gp.lineTo(mEnd.x - 100, mEnd.y);
                gp.moveTo(mStart.x - 50, mStart.y);
                gp.lineTo(mEnd.x - 50, mEnd.y);
                gp.moveTo(mStart.x - 100, mStart.y + mLength / 2);
                gp.lineTo(mStart.x - 50, mStart.y + mLength / 2);

                // I
                gp.moveTo(mStart.x - 15, mStart.y);
                gp.lineTo(mEnd.x - 5, mStart.y);
                gp.moveTo(mStart.x - 10, mStart.y);
                gp.lineTo(mEnd.x - 10, mEnd.y);
                gp.moveTo(mStart.x - 15, mEnd.y);
                gp.lineTo(mEnd.x - 5, mEnd.y);

                break;

            case STARSDISAPPEAR:
                int movement = mShapeAnimationStep - 1;
                int starColorChange = (int) (movement * 10);
                if (movement <= 1) {
                    mColor = new Color(0, 0, 0, 0);
                } else {
                    mColor = new Color(240, 212, 0, starColorChange);

                    // STAR 1
                    int r = 30;
                    double ch = 72 * Math.PI / 180;
                    int x0 = mEnd.x;
                    int y0 = mEnd.y - mLength / 6;
                    int x1 = x0;
                    int x2 = (int) (x0 - Math.sin(ch) * r);
                    int x3 = (int) (x0 + Math.sin(ch) * r);
                    int x4 = (int) (x0 - Math.sin(ch / 2) * r);
                    int x5 = (int) (x0 + Math.sin(ch / 2) * r);
                    int y1 = y0 - r;
                    int y2 = (int) (y0 - Math.cos(ch) * r);
                    int y3 = y2;
                    int y4 = (int) (y0 + Math.cos(ch / 2) * r);
                    int y5 = y4;

                    gp.moveTo(x1, y1);
                    gp.lineTo(x4, y4);
                    gp.lineTo(x3, y3);
                    gp.lineTo(x2, y2);
                    gp.lineTo(x5, y5);
                    gp.lineTo(x1, y1);

                    // STAR 2 right side
                    r = 15;
                    ch = 72 * Math.PI / 180;
                    x0 = x3 - 10;
                    y0 = y1 - mLength / 2;
                    x1 = x0;
                    x2 = (int) (x0 - Math.sin(ch) * r);
                    x3 = (int) (x0 + Math.sin(ch) * r);
                    x4 = (int) (x0 - Math.sin(ch / 2) * r);
                    x5 = (int) (x0 + Math.sin(ch / 2) * r);
                    y1 = y0 - r;
                    y2 = (int) (y0 - Math.cos(ch) * r);
                    y3 = y2;
                    y4 = (int) (y0 + Math.cos(ch / 2) * r);
                    y5 = y4;

                    gp.moveTo(x1, y1);
                    gp.lineTo(x4, y4);
                    gp.lineTo(x3, y3);
                    gp.lineTo(x2, y2);
                    gp.lineTo(x5, y5);
                    gp.lineTo(x1, y1);

                    // STAR 3 left side
                    r = 15;
                    ch = 72 * Math.PI / 180;
                    x0 = x0 - 60;
                    y0 = y0 + 50;
                    x1 = x0;
                    x2 = (int) (x0 - Math.sin(ch) * r);
                    x3 = (int) (x0 + Math.sin(ch) * r);
                    x4 = (int) (x0 - Math.sin(ch / 2) * r);
                    x5 = (int) (x0 + Math.sin(ch / 2) * r);
                    y1 = y0 - r;
                    y2 = (int) (y0 - Math.cos(ch) * r);
                    y3 = y2;
                    y4 = (int) (y0 + Math.cos(ch / 2) * r);
                    y5 = y4;

                    gp.moveTo(x1, y1);
                    gp.lineTo(x4, y4);
                    gp.lineTo(x3, y3);
                    gp.lineTo(x2, y2);
                    gp.lineTo(x5, y5);
                    gp.lineTo(x1, y1);
                }
                break;

            case STARSFADEOUT:
                movement = mShapeAnimationStep - 1;
                starColorChange = (int) (movement * 10);
                if (movement <= 1) {
                    mColor = new Color(0, 0, 0, 0);
                } else {
                    mColor = new Color(240, 212, 0, starColorChange);

                    mStart = mBody.getLeftLegStartPostion();
                    creatStar(15, mStart, gp);
                    mStart = mBody.mNeck.getBodyStartPosition();
                    creatStar(15, mStart, gp);
                    mStart = mBody.mNeck.mHead.getLeftEyePostion();
                    creatStar(15, mStart, gp);
                    mStart = mBody.mNeck.mHead.getRightEyebrowPostion();
                    creatStar(15, mStart, gp);
                    mStart = mBody.mNeck.mHead.mStickman.mRightUpperArm.getRightUpperArmEndPosition();
                    creatStar(15, mStart, gp);
                }
                break;

            case STARSFADEIN:
                movement = 21 - mShapeAnimationStep;
                starColorChange = (int) (movement * 10);
                if (movement >= 20) {
                    mColor = new Color(240, 212, 0, 255);
                } else {
                    mColor = new Color(240, 212, 0, starColorChange);

                    mStart = mBody.getLeftLegStartPostion();
                    creatStar(15, mStart, gp);
                    mStart = mBody.mNeck.getBodyStartPosition();
                    creatStar(15, mStart, gp);
                    mStart = mBody.mNeck.mHead.getLeftEyePostion();
                    creatStar(15, mStart, gp);
                    mStart = mBody.mNeck.mHead.getRightEyebrowPostion();
                    creatStar(15, mStart, gp);
                    mStart = mBody.mNeck.mHead.mStickman.mRightUpperArm.getRightUpperArmEndPosition();
                    creatStar(15, mStart, gp);
                }
                break;

        }
        addToDrawObjects(gp);
    }

}
