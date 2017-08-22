package de.dfki.stickman3D.body;

import de.dfki.common.enums.Gender;
import de.dfki.common.part.Part3D;
import de.dfki.common.util.Preferences;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

import java.awt.Dimension;

/**
 * Created by EmpaT on 08.08.2017.
 */
public abstract class Brow extends PartStickman3D
{
    public SHAPE mShape = SHAPE.DEFAULT;
    protected Head3D mHead;
    protected Polygon currentPolygon;

    public Brow(Part3D head)
    {
        mHead = (Head3D) head;
        if (mHead.getStickman().mType == Gender.TYPE.MALE)
        {
            mColor = Color.rgb(88, 44, 13, 1);
        }
        else
        {
            mColor = Color.rgb(204, 163, 0, 1);
        }

        currentPolygon = new Polygon();
        currentPolygon.setTranslateY(Preferences.BROW_HEIGHT);
    }

    @Override
    public void init()
    {
        super.init();
        this.setTranslateX(mStart.x);
        this.setTranslateY(mStart.y);
        this.setTranslateZ(Preferences.FACE_PARTS_Z_POS);
    }
}
