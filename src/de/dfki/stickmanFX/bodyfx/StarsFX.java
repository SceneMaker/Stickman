package de.dfki.stickmanFX.bodyfx;

import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Point;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;

/**
 *
 * @author Robbie
 * @modified Beka
 *
 */
public class StarsFX extends BodyPartFX {

    public static enum SHAPE {

        DEFAULT, SAYBYE, SAYHI, STARSDISAPPEAR, STARSFADEOUT, STARSFADEIN
    };

    BodyFX mBodyFX;
    public StarsFX.SHAPE mShape = StarsFX.SHAPE.DEFAULT;

    public StarsFX(BodyFX body) {

        mBodyFX = body;
        mLength = 150;
        mSize = new Dimension(120, mLength);
        mColor = Color.rgb(255, 0, 0, (255 * 100 / 255) / 100f);
        mStroke = new BasicStroke(5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);

        init();
    }

    @Override
    public void setShape(String s) {
        StarsFX.SHAPE shape = StarsFX.SHAPE.valueOf(s);
        mShape = (shape != null) ? shape : StarsFX.SHAPE.DEFAULT;
    }

    @Override
    public void resetShape() {
        mShape = StarsFX.SHAPE.DEFAULT;
    }

    private void creatStar(int radius, Point center, Path path) {
        clearChildren(this);
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

        path.getElements().add(new MoveTo(x1, y1));
        path.getElements().add(new LineTo(x4, y4));
        path.getElements().add(new LineTo(x3, y3));
        path.getElements().add(new LineTo(x2, y2));
        path.getElements().add(new LineTo(x5, y5));
        path.getElements().add(new LineTo(x1, y1));

        this.getChildren().add(path);
    }

    // Start.x left leg side
    @Override
    public void createShape() {

        mStart = mBodyFX.getLeftLegStartPostion();
        mEnd = new Point(mStart.x, mStart.y + mLength);

        clearDrawObjects();
        clearChildren(this);
        Path path = new Path();

        switch (mShape) {
            case DEFAULT:
                path.getElements().add(new MoveTo(mStart.x, mStart.y));
                mColor = Color.rgb(0, 0, 0, 0);

                break;

            case SAYBYE:
                mColor = Color.rgb(80, 80, 80, (128 * 100 / 255) / 100f);
                // B
                path.getElements().add(new MoveTo(mStart.x - 100, mStart.y));
                path.getElements().add(new LineTo(mEnd.x - 100, mEnd.y));
                path.getElements().add(new MoveTo(mStart.x - 100, mStart.y));
                path.getElements().add(new QuadCurveTo(mStart.x - 100 + 70, mStart.y + 30, mStart.x - 100, mStart.y + mLength / 2));
                path.getElements().add(new MoveTo(mStart.x - 100, mStart.y + mLength / 2));
                path.getElements().add(new QuadCurveTo(mStart.x - 100 + 70, mEnd.y - 40, mEnd.x - 100, mEnd.y));

                // Y
                path.getElements().add(new MoveTo(mStart.x - 60, mStart.y));
                path.getElements().add(new LineTo(mEnd.x - 40, mStart.y + mLength / 2));
                path.getElements().add(new MoveTo(mStart.x - 20, mStart.y));
                path.getElements().add(new LineTo(mEnd.x - 40, mStart.y + mLength / 2));
                path.getElements().add(new MoveTo(mEnd.x - 40, mStart.y + mLength / 2));
                path.getElements().add(new LineTo(mEnd.x - 40, mEnd.y));

                // E
                path.getElements().add(new MoveTo(mStart.x - 10, mStart.y));
                path.getElements().add(new LineTo(mEnd.x - 10, mEnd.y));
                path.getElements().add(new MoveTo(mStart.x - 10, mStart.y));
                path.getElements().add(new LineTo(mStart.x + 30, mStart.y));
                path.getElements().add(new MoveTo(mStart.x - 10, mStart.y + mLength / 2));
                path.getElements().add(new LineTo(mEnd.x + 30, mStart.y + mLength / 2));
                path.getElements().add(new MoveTo(mEnd.x - 10, mEnd.y));
                path.getElements().add(new LineTo(mEnd.x + 30, mEnd.y));

                break;

            case SAYHI:
                mColor = new Color(80, 80, 80, (128 * 100 / 255) / 100f);
                // H
                path.getElements().add(new MoveTo(mStart.x - 100, mStart.y));
                path.getElements().add(new LineTo(mEnd.x - 100, mEnd.y));
                path.getElements().add(new MoveTo(mStart.x - 50, mStart.y));
                path.getElements().add(new LineTo(mEnd.x - 50, mEnd.y));
                path.getElements().add(new MoveTo(mStart.x - 100, mStart.y + mLength / 2));
                path.getElements().add(new LineTo(mStart.x - 50, mStart.y + mLength / 2));

                // I
                path.getElements().add(new MoveTo(mStart.x - 15, mStart.y));
                path.getElements().add(new LineTo(mEnd.x - 5, mStart.y));
                path.getElements().add(new MoveTo(mStart.x - 10, mStart.y));
                path.getElements().add(new LineTo(mEnd.x - 10, mEnd.y));
                path.getElements().add(new MoveTo(mStart.x - 15, mEnd.y));
                path.getElements().add(new LineTo(mEnd.x - 5, mEnd.y));

                break;

            case STARSDISAPPEAR:
                int movement = mShapeAnimationStep - 1;
                int starColorChange = (int) (movement * 10);
                if (movement <= 1) {
                    mColor = new Color(0, 0, 0, 0);
                } else {
                    mColor = Color.rgb(240, 212, 0, (starColorChange * 100 / 255) / 100f);

                    // STAR 1
//					mStart = mBodyFX.getLeftLegStartPostion();
                    mStart = mBodyFX.mNeckFX.mHeadFX.getLeftEyePostion();
                    path.setFill(mColor);
                    creatStar(30, mStart, path);

                    // STAR 2 right side
//					mStart = mBodyFX.mNeck.mHead.mStickman.mLeftForeLegFX.getLegStartPosition();
                    mStart = mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mRightUpperArmFX.getRightUpperArmEndPosition();
                    creatStar(15, mStart, path);

                    // STAR 3 left side
//					mStart = mBodyFX.mNeck.mHead.mStickman.mRightUpperLegFX.getRightUpperLegEndPosition();
                    mStart = mBodyFX.mNeckFX.getBodyStartPosition();
                    creatStar(15, mStart, path);
                }
                break;

            case STARSFADEOUT:
                movement = mShapeAnimationStep - 1;
                starColorChange = (int) (movement * 10);
                if (movement <= 1) {
                    mColor = new Color(0, 0, 0, 0);
                } else {
                    mColor = Color.rgb(240, 212, 0, (starColorChange * 100 / 255) / 100f);

                    mStart = mBodyFX.getLeftLegStartPostion();
                    creatStar(15, mStart, path);
                    mStart = mBodyFX.mNeckFX.getBodyStartPosition();
                    creatStar(15, mStart, path);
                    mStart = mBodyFX.mNeckFX.mHeadFX.getLeftEyePostion();
                    creatStar(15, mStart, path);
                    mStart = mBodyFX.mNeckFX.mHeadFX.getRightEyebrowPostion();
                    creatStar(15, mStart, path);
                    mStart = mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mRightUpperArmFX.getRightUpperArmEndPosition();
                    creatStar(15, mStart, path);
                }
                break;

            case STARSFADEIN:
                movement = 21 - mShapeAnimationStep;
                starColorChange = (int) (movement * 10);
                if (movement >= 20) {
                    mColor = new Color(240, 212, 0, (255 * 100 / 255) / 100f);
                } else {
                    mColor = Color.rgb(240, 212, 0, (starColorChange * 100 / 255) / 100f);

                    mStart = mBodyFX.getLeftLegStartPostion();
                    creatStar(15, mStart, path);
                    mStart = mBodyFX.mNeckFX.getBodyStartPosition();
                    creatStar(15, mStart, path);
                    mStart = mBodyFX.mNeckFX.mHeadFX.getLeftEyePostion();
                    creatStar(15, mStart, path);
                    mStart = mBodyFX.mNeckFX.mHeadFX.getRightEyebrowPostion();
                    creatStar(15, mStart, path);
                    mStart = mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mRightUpperArmFX.getRightUpperArmEndPosition();
                    creatStar(15, mStart, path);
                }
                break;

        }

        addToDrawObjects(path);
        this.update();
    }

}
