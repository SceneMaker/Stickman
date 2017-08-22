package de.dfki.stickman3D.body;

import de.dfki.common.part.Part3D;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.MeshView;

/**
 * Created by EmpaT on 09.08.2017.
 */
public abstract class Ear extends PartStickman3D
{
    public SHAPE mShape = SHAPE.DEFAULT;
    protected Head3D mHead;
    protected MeshView earMesh;
    protected PhongMaterial material;

    public Ear(Part3D head)
    {
        mHead = (Head3D) head;
        material = new PhongMaterial();
        mColor = Color.rgb(242, 227, 217, 1);
    }

    @Override
    public void init()
    {
        super.init();
        this.setTranslateX(mStart.x);
        this.setTranslateY(mStart.y);
        this.setTranslateZ(-2);
    }

    @Override
    public void setShape(String s)
    {
        mShape = SHAPE.valueOf(s);
    }

    @Override
    public void resetShape()
    {
        mShape = SHAPE.DEFAULT;
    }

    @Override
    public void calculate(int step)
    {
        executeFadeInFadeOut(earMesh, mShape, step);
    }
}
