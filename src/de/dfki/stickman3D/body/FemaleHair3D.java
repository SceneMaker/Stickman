package de.dfki.stickman3D.body;

import com.interactivemesh.jfx.importer.stl.StlMeshImporter;
import de.dfki.stickman3D.Stickman3D;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.TriangleMesh;
import javafx.scene.transform.Rotate;

import java.awt.*;
import java.net.URL;

/**
 * @author Beka Aptsiauri
 */
public class FemaleHair3D extends BodyPartFX
{
    public enum SHAPE
    {
        DEFAULT, FADEIN, FADEOUT
    }

    public FemaleHair3D.SHAPE mShape = FemaleHair3D.SHAPE.DEFAULT;

    private int mHalfHeight;
    private int mHalfWidth;

    private MeshView femaleHairMeshView;
    private PhongMaterial material;

    public FemaleHair3D(Stickman3D sm)
    {
        mSize = new Dimension(120, 100);
        mHalfHeight = mSize.height / 2;
        mHalfWidth = mSize.width / 2;
        mColor = Color.rgb(240, 212, 0, 1);

        URL url = getClass().getClassLoader().getResource("BodyParts/Stickman3D/femaleHair.stl");
        StlMeshImporter importer = new StlMeshImporter();
        importer.read(url);
        TriangleMesh femaleHairTriangleMesh = importer.getImport();
        femaleHairMeshView = new MeshView(femaleHairTriangleMesh);
        material = new PhongMaterial();
        material.setDiffuseColor(mColor);
        femaleHairMeshView.setMaterial(material);
        femaleHairMeshView.setRotationAxis(Rotate.X_AXIS);
        femaleHairMeshView.setRotate(-90);

        sm.mHead.getChildren().add(femaleHairMeshView);

        init();

        calculate(0);
    }

    @Override
    public void init()
    {
        super.init();
        int mZTranslate = 16;
        femaleHairMeshView.setTranslateX(mHalfWidth - 60);
        femaleHairMeshView.setTranslateY(mHalfHeight - 57);
        femaleHairMeshView.setTranslateZ(mZTranslate);
    }

    @Override
    public void setShape(String s)
    {
        SHAPE shape = SHAPE.valueOf(s);
        mShape = (shape != null) ? shape : SHAPE.DEFAULT;
    }

    @Override
    public void resetShape()
    {
        mShape = FemaleHair3D.SHAPE.DEFAULT;
    }

    public void calculate(int step)
    {
        Rotate rx = new Rotate(mXRotation, Rotate.X_AXIS);
        Rotate ry = new Rotate(mYRotation, Rotate.Y_AXIS);
        Rotate rz = new Rotate(mZRotation, Rotate.Z_AXIS);

        femaleHairMeshView.getTransforms().clear();
        femaleHairMeshView.getTransforms().addAll(rx, ry, rz);

        switch (mShape)
        {
            case FADEIN:
                if (step == 2)
                {
                    mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), 0.0);
                    update();
                    femaleHairMeshView.setVisible(false);
                } else if (mColor.getOpacity() != 0.0)
                {
                    mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), mColor.getOpacity() - 0.052);
                    update();
                }
                break;

            case FADEOUT:
                femaleHairMeshView.setVisible(true);

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
        femaleHairMeshView.setMaterial(material);
    }

    public MeshView getFemaleHairMeshView()
    {
        return femaleHairMeshView;
    }
}
