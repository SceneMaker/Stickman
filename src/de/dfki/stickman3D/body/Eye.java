package de.dfki.stickman3D.body;

import de.dfki.common.enums.Gender;
import de.dfki.common.part.Part3D;
import de.dfki.common.util.Preferences;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;

import java.awt.*;

/**
 * Created by EmpaT on 08.08.2017.
 */
public abstract class Eye extends PartStickman3D
{
    public Path border;
    public Path bigPupile;
    public Path smallPupile;
    public SHAPE mShape = SHAPE.DEFAULT;

    protected Color smallPupileColor;
    protected Color borderColor;

    protected Head3D mHead;
    protected double borderXSize = 0;
    protected double borderYSize = 0;
    protected double bigPupileYSize = 0;
    protected double smallPupileYSize = 0;

    public Eye(Part3D head)
    {
        mHead = (Head3D) head;
        mSize = new Dimension(Preferences.EYE_WIDTH, Preferences.EYE_HEIGHT);

        if (mHead.getStickman().mType == Gender.TYPE.MALE)
        {
            mColor = Color.rgb(0, 0, 0, 1);
        }
        else
        {
            mColor = Color.rgb(0, 0, 255, 1);
        }

        smallPupileColor = Color.rgb(255, 255, 255, 1);
        borderColor = Color.rgb(255, 255, 255, 1);

        border = new Path();
        bigPupile = new Path();
        smallPupile = new Path();

        StackPane eyePane = new StackPane();
        eyePane.getChildren().add(border);
        eyePane.getChildren().add(bigPupile);
        eyePane.getChildren().add(smallPupile);
        smallPupile.setTranslateX(Preferences.SMALL_PUPILE_X_POS);
        this.getChildren().add(eyePane);
    }

    protected void createDefaultEye()
    {
        border = createBorder(border);
        bigPupile = createEllipsePath(bigPupile, 0, 0, 3.5, 3.5, 0, mColor, null);
        smallPupile = createEllipsePath(smallPupile, 0, 0, 1.4, 1.4, 0, smallPupileColor, null);
        smallPupile.setStroke(null);

        borderYSize = 0;
        borderXSize = 0;
        bigPupileYSize = 0;
        smallPupileYSize = 0;
    }

    private Path createBorder(Path startBorder)
    {
        startBorder.getElements().add(new MoveTo(mStart.x, mStart.y));
        startBorder.getElements().add(new QuadCurveTo(mStart.x + 10, mStart.y - 13, mStart.x + 20, mStart.y));
        startBorder.getElements().add(new QuadCurveTo(mStart.x + 10, mStart.y + 13, mStart.x, mStart.y));
        startBorder.setStrokeWidth(1);
        startBorder.setStroke(Color.BLACK);
        startBorder.setFill(Color.WHITE);

        return startBorder;
    }

    private Path createEllipsePath(Path startPath, double centerX, double centerY, double radiusX, double radiusY, double rotate, Color eyeColor, Color borderColor)
    {
        ArcTo arcTo = new ArcTo();
        arcTo.setX(centerX - radiusX + 1); // to simulate a full 360 degree celcius circle.
        arcTo.setY(centerY - radiusY);
        arcTo.setSweepFlag(false);
        arcTo.setLargeArcFlag(true);
        arcTo.setRadiusX(radiusX);
        arcTo.setRadiusY(radiusY);
        arcTo.setXAxisRotation(rotate);

        startPath.getElements().add(new MoveTo(centerX - radiusX, centerY - radiusY));
        startPath.getElements().add(arcTo);
        startPath.getElements().add(new ClosePath());

        if (borderColor != null)
        {
            startPath.setStroke(Color.BLACK);
            startPath.setStrokeWidth(1);
        }

        startPath.setFill(eyeColor);
        return startPath;
    }

    @Override
    protected void executeFadeInFadeOut(MeshView meshView, SHAPE shape, int step)
    {
        switch (shape)
        {
            case FADEIN:
                if (step == 2)
                {
                    mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), 0.0);
                    smallPupileColor = new Color(smallPupileColor.getRed(), smallPupileColor.getGreen(),
                            smallPupileColor.getBlue(), 0.0);
                    borderColor = new Color(borderColor.getRed(), borderColor.getGreen(), borderColor.getBlue(), 0.0);
                } else if (mColor.getOpacity() != 0.0)
                {
                    mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), mColor.getOpacity() - 0.052);
                    smallPupileColor = new Color(smallPupileColor.getRed(), smallPupileColor.getGreen(),
                            smallPupileColor.getBlue(), smallPupileColor.getOpacity() - 0.052);
                    borderColor = new Color(borderColor.getRed(), borderColor.getGreen(), borderColor.getBlue(),
                            borderColor.getOpacity() - 0.052);
                }
                border.setFill(borderColor);
                bigPupile.setFill(mColor);
                smallPupile.setFill(smallPupileColor);
                border.setStroke(borderColor);
                bigPupile.setStroke(mColor);
                break;
            case FADEOUT:
                if (step == 2)
                {
                    mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), 1.0);
                    smallPupileColor = new Color(smallPupileColor.getRed(), smallPupileColor.getGreen(),
                            smallPupileColor.getBlue(), 1.0);
                    borderColor = new Color(borderColor.getRed(), borderColor.getGreen(), borderColor.getBlue(), 1.0);
                } else if (mColor.getOpacity() != 1.0)
                {
                    mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), mColor.getOpacity() + 0.052);
                    smallPupileColor = new Color(smallPupileColor.getRed(), smallPupileColor.getGreen(),
                            smallPupileColor.getBlue(), smallPupileColor.getOpacity() + 0.052);
                    borderColor = new Color(borderColor.getRed(), borderColor.getGreen(), borderColor.getBlue(),
                            borderColor.getOpacity() + 0.052);
                }
                border.setFill(borderColor);
                bigPupile.setFill(mColor);
                smallPupile.setFill(smallPupileColor);
                border.setStroke(Color.BLACK);
                bigPupile.setStroke(mColor);
                break;
        }
    }
}
