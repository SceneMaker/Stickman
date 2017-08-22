package de.dfki.common.part;

import de.dfki.common.enums.Axis;
import javafx.application.Platform;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.awt.*;

/**
 * Created by EmpaT on 27.07.2017.
 */
public abstract class Part extends Pane
{
    public Dimension mSize = new Dimension(10, 10);
    public Point mStart = new Point(0, 0);
    public Point mEnd = new Point(0, 0);
    public Point mDefaultRotationPoint = new Point(0, 0);
    public int mDefaultRotation = 0;
    public int mLength = 0;
    public int mShapeAnimationStep = 0;
    public Color mColor = Color.rgb(0, 0, 0);
    public Color mColorRecorder;
    public String mSpeechBubbleText = "";

    public void init()
    {
        this.setMaxSize(mSize.getWidth(), mSize.getHeight());
        this.setMinSize(mSize.getWidth(), mSize.getHeight());
        calculate(0);
    }

    public abstract void calculate(int step);

    public abstract void resetTranslation();

    public abstract void setTilt(int degree);

    public abstract void rotatePerlinNoise(double mWobble, int x, int y);

    public abstract void setShape(String s);

    public abstract void setTranslation(int length, Axis... axis);

    public abstract void calculateTranslation(int step, Axis... axis);

    public abstract void setRotation(int degree, Axis... axis);

    public abstract void calculateRotation(int step, Axis... axis);

    public abstract void resetRotation(Axis... axis);


    public synchronized void calculateShape(int step)
    {
        mShapeAnimationStep = step;
        Platform.runLater(() -> calculate(step));
    }

    public void resetShape()
    {
        mShapeAnimationStep = 0;
    }

    public void setDefaulRotation(int degree)
    {
        mDefaultRotation = degree;
    }
}
