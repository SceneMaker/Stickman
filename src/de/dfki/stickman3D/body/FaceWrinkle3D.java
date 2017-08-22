package de.dfki.stickman3D.body;

import de.dfki.common.part.Part3D;
import de.dfki.common.util.Preferences;
import de.dfki.stickman3D.animationlogic.AnimatorStickman3D;
import de.dfki.stickman3D.mimic.util.FaceWrinkleANGRY;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

import java.awt.*;

/**
 * @author Beka
 */
public class FaceWrinkle3D extends PartStickman3D
{
    public SHAPE mShape = SHAPE.DEFAULT;
    private Polygon currentLeftPolygon;
    private Polygon currentRightPolygon;

    public FaceWrinkle3D(Part3D head)
    {
        mStart = ((Head3D) head).getFaceWrinkleStartPosition();
        mColor = Color.rgb(80, 80, 80, 0);
        mSize = new Dimension(mLength, 5);
        mDefaultRotationPoint = head.mDefaultRotationPoint;

        HBox box = new HBox();
        currentLeftPolygon = new Polygon();
        currentRightPolygon = new Polygon();
        box.getChildren().addAll(currentRightPolygon, currentLeftPolygon);
        box.setSpacing(Preferences.FACEWRINKLE_BOX_SPACING);
        box.setTranslateX(mStart.x);
        box.setTranslateY(mStart.y);
        box.setTranslateZ(Preferences.FACE_PARTS_Z_POS);
        head.getChildren().addAll(box);

        init();
    }

    @Override
    public void init()
    {
        super.init();
    }

    @Override
    public void setShape(String s)
    {
        mShape = SHAPE.valueOf(s);
    }

    @Override
    public void resetShape()
    {
        mShape = FaceWrinkle3D.SHAPE.DEFAULT;
    }

    @Override
    public void calculate(int step)
    {
        double colorOpacity;

        switch (mShape)
        {
            case DEFAULT:
                break;

            case ANGRY:
                currentLeftPolygon = FaceWrinkleANGRY.getLeftANGRY(currentLeftPolygon, step);
                currentRightPolygon = FaceWrinkleANGRY.getRightANGRY(currentRightPolygon, step);

                colorOpacity = AnimatorStickman3D.sMAX_ANIM_STEPS - mShapeAnimationStep;
                mColor = Color.rgb(80, 80, 80, colorOpacity / 19);
                currentLeftPolygon.setFill(mColor);
                currentRightPolygon.setFill(mColor);

                break;

            case ANGRYEND:
                colorOpacity = AnimatorStickman3D.sMAX_ANIM_STEPS - mShapeAnimationStep;

                mColor = Color.rgb(80, 80, 80, 1 - colorOpacity / 19);
                currentLeftPolygon.setFill(mColor);
                currentRightPolygon.setFill(mColor);
                break;

            case DISGUSTED:
                break;

            case SURPRISED:
                break;

            case EXCITED:
                break;

            case EMBARRASSED:
                break;

            case EMBARRASSEDEND:
                break;
        }
    }
}
