package de.dfki.stickman3D.body;

import com.interactivemesh.jfx.importer.col.ColModelImporter;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.MeshView;

import java.awt.*;
import java.net.URL;

/**
 * Autor Beka
 */
public class Stars3D extends BodyPartFX
{

    public enum SHAPE
    {

        DEFAULT, SAYBYE, SAYHI, STARSDISAPPEAR, STARSFADEOUT, STARSFADEIN
    }

    private MeshView mStarBig;
    private MeshView mStarMiddle;
    private MeshView mStarSmall;
    private PhongMaterial material;

    public Stars3D.SHAPE mShape = Stars3D.SHAPE.DEFAULT;

    public Stars3D(UpperBody3D body)
    {
        mLength = 150;
        mSize = new Dimension(120, mLength);
        mStart = body.getLeftLegStartPostion();
        mColor = Color.rgb(255, 255, 0, 0.0);

        ColModelImporter imorter = new ColModelImporter();
        URL url = getClass().getClassLoader().getResource("BodyParts/StarBig.dae");
        imorter.read(url);
        mStarBig = (MeshView) imorter.getImport()[0];

        url = getClass().getClassLoader().getResource("BodyParts/StarMiddle.dae");
        imorter.read(url);
        mStarMiddle = (MeshView) imorter.getImport()[0];

        url = getClass().getClassLoader().getResource("BodyParts/StarSmall.dae");
        imorter.read(url);
        mStarSmall = (MeshView) imorter.getImport()[0];

        material = new PhongMaterial();
        material.setDiffuseColor(mColor);
        mStarBig.setMaterial(material);
        mStarMiddle.setMaterial(material);
        mStarSmall.setMaterial(material);

        body.getChildren().addAll(mStarBig, mStarMiddle, mStarSmall);

        mStarBig.setVisible(false);
        mStarMiddle.setVisible(false);
        mStarSmall.setVisible(false);

        init();
    }

    @Override
    public void setShape(String s)
    {
        Stars3D.SHAPE shape = Stars3D.SHAPE.valueOf(s);
        mShape = (shape != null) ? shape : Stars3D.SHAPE.DEFAULT;
    }

    @Override
    public void resetShape()
    {
        mShape = Stars3D.SHAPE.DEFAULT;
    }

    @Override
    public void calculate(int step)
    {
        mStarBig.setTranslateX(-50);
        mStarBig.setTranslateZ(-40);

        mStarMiddle.setTranslateX(50);
        mStarMiddle.setTranslateY(-100);
        mStarMiddle.setTranslateZ(-15);

        mStarSmall.setTranslateX(5);
        mStarSmall.setTranslateY(-145);
        mStarSmall.setTranslateZ(-40);

        switch (mShape)
        {
            case DEFAULT:
                break;

            case SAYBYE:
                break;

            case SAYHI:
                break;

            case STARSDISAPPEAR:
                break;

            case STARSFADEOUT:

                if (step == 2)
                {
                    mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), 0.0);
                    update();
                    mStarBig.setVisible(false);
                    mStarMiddle.setVisible(false);
                    mStarSmall.setVisible(false);
                } else if (mColor.getOpacity() != 0.0)
                {
                    mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), mColor.getOpacity() - 0.052);
                    update();
                }
                break;

            case STARSFADEIN:
                mStarBig.setVisible(true);
                mStarMiddle.setVisible(true);
                mStarSmall.setVisible(true);

                if (step == 2)
                {
                    mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), 1.0);
                    update();
                } else if (mColor.getOpacity() != 1.0)
                {
                    mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), mColor.getOpacity() + 0.052);
                    update();
                }
                break;

        }
    }

    public void update()
    {
        material.setDiffuseColor(mColor);
        mStarBig.setMaterial(material);
        mStarMiddle.setMaterial(material);
        mStarSmall.setMaterial(material);
    }

}
