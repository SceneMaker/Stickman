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
public class MaleHair3D extends BodyPartFX
{
    public enum SHAPE
    {
        DEFAULT, FADEIN, FADEOUT
    }

    private int mHalfHeight;
    private int mHalfWidth;

    private MeshView maleHairMeshView;
    private PhongMaterial material;
    public MaleHair3D.SHAPE mShape = MaleHair3D.SHAPE.DEFAULT;

    public MaleHair3D(Stickman3D sm)
    {
        mColor = Color.rgb(97, 58, 0, 1);
        mSize = new Dimension(120, 100);
        mHalfHeight = mSize.height / 2;
        mHalfWidth = mSize.width / 2;

        URL url = getClass().getClassLoader().getResource("BodyParts/Stickman3D/maleHair.stl");
        StlMeshImporter importer = new StlMeshImporter();
        importer.read(url);
        TriangleMesh maleHairTriangleMesh = importer.getImport();
        maleHairMeshView = new MeshView(maleHairTriangleMesh);
        material = new PhongMaterial();
        material.setDiffuseColor(mColor);
        maleHairMeshView.setMaterial(material);
        maleHairMeshView.setRotationAxis(Rotate.X_AXIS);
        maleHairMeshView.setRotate(-90);

        sm.mHead.getChildren().add(maleHairMeshView);

        init();

        calculate(0);
    }

    @Override
    public void init()
    {
        super.init();
        int mZTranslate = 3;
        maleHairMeshView.setTranslateX(mHalfWidth - 60);
        maleHairMeshView.setTranslateY(mHalfHeight - 52);
        maleHairMeshView.setTranslateZ(mZTranslate);
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
        mShape = MaleHair3D.SHAPE.DEFAULT;
    }

    public void calculate(int step)
    {
        Rotate rx = new Rotate(mXRotation, Rotate.X_AXIS);
        Rotate ry = new Rotate(mYRotation, Rotate.Y_AXIS);
        Rotate rz = new Rotate(mZRotation, Rotate.Z_AXIS);

        maleHairMeshView.getTransforms().clear();
        maleHairMeshView.getTransforms().addAll(rx, ry, rz);

        switch (mShape)
        {
            case FADEIN:
                if (step == 2)
                {
                    mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), 0.0);
                    update();
                    maleHairMeshView.setVisible(false);
                } else if (mColor.getOpacity() != 0.0)
                {
                    mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), mColor.getOpacity() - 0.052);
                    update();
                }
                break;

            case FADEOUT:
                maleHairMeshView.setVisible(true);

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
        maleHairMeshView.setMaterial(material);
    }

    public MeshView getMaleHairMeshView()
    {
        return maleHairMeshView;
    }
}
