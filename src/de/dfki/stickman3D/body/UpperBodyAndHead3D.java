package de.dfki.stickman3D.body;

import de.dfki.common.enums.Gender;
import de.dfki.common.part.Part3D;
import de.dfki.common.util.Preferences;
import javafx.scene.layout.StackPane;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;

import java.awt.*;

/**
 * @author Beka Aptsiauri
 */
public class UpperBodyAndHead3D extends PartStickman3D
{
    private Head3D mHead;
    public UpperBodyAndHead3D(Part3D head, Part3D upperBody, Part3D neck)
    {
        mHead = (Head3D) head;
        mSize = new Dimension(120, Preferences.HEAD_HEIGHT + Preferences.NECK_HEIGHT + Preferences.MALE_UPPER_BODY_HEIGHT);
        this.getChildren().addAll(head, upperBody, neck);
    }

    @Override
    public void calculate(int step)
    {
        float pivotX;
        float pivotY;
        float pivotZ = -105;
        if(mHead.getStickman().mType == Gender.TYPE.MALE)
        {
            pivotX = Preferences.HEAD_WIDTH/2;
            pivotY = Preferences.HEAD_HEIGHT
                    + Preferences.NECK_HEIGHT
                    + Preferences.MALE_UPPER_BODY_HEIGHT;
        }
        else
        {
            pivotX = Preferences.HEAD_WIDTH/2;
            pivotY = Preferences.HEAD_HEIGHT
                    + Preferences.NECK_HEIGHT
                    + Preferences.FEMALE_UPPER_BODY_HEIGHT;
        }
        Rotate rx = new Rotate(mXRotation, pivotX, pivotY + mYTranslation, pivotZ, Rotate.X_AXIS);
        Rotate ry = new Rotate(mYRotation, pivotX, pivotY + mYTranslation, pivotZ, Rotate.Y_AXIS);
        Rotate rz = new Rotate(mZRotation, pivotX, pivotY + mYTranslation, pivotZ, Rotate.Z_AXIS);

        Translate translation = new Translate(mXTranslation, mYTranslation, mZTranslation);
        this.getTransforms().clear();
        this.getTransforms().addAll(rx, ry, rz, translation);
    }

    @Override
    public void setShape(String s)
    {

    }
}
