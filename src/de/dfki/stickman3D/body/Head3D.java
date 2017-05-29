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

import javafx.scene.transform.Translate;

/**
 * @author Beka Aptsiauri
 */
public class Head3D extends BodyPartFX
{

    public enum SHAPE
    {
        DEFAULT, FADEIN, FADEOUT
    }

    private Stickman3D mStickman;

    private MeshView mHeadMeshView;
    private PhongMaterial material;

    private final static int EARWIDTH = 10;
    public int mHalfHeight;
    public int mHalfWidth;

    public Head3D.SHAPE mShape = Head3D.SHAPE.DEFAULT;

    public Head3D(Stickman3D sm)
    {
        mStickman = sm;
        mSize = new Dimension(120, 100);
        mHalfHeight = mSize.height / 2;
        mHalfWidth = mSize.width / 2;
        mDefaultRotationPoint = new Point(mSize.width / 2, mSize.height);
        mColor = Color.rgb(242, 227, 217, 1);


        init();
        calculate(0);
    }

    @Override
    public void init()
    {
        super.init();
        int mZTranslate = -105;
        this.setTranslateX(mHalfWidth + 4);
        this.setTranslateY(mHalfHeight - 3);
        this.setTranslateZ(mZTranslate);

        URL url = getClass().getClassLoader().getResource("BodyParts/Stickman3D/Head.stl");
        StlMeshImporter im = new StlMeshImporter();
        im.read(url);
        TriangleMesh mHeadTriangleMesh = im.getImport();

        mHeadMeshView = new MeshView(mHeadTriangleMesh);
        material = new PhongMaterial();
        material.setDiffuseColor(mColor);
        mHeadMeshView.setMaterial(material);
        mHeadMeshView.setRotationAxis(Rotate.X_AXIS);
        mHeadMeshView.setRotate(90);
        this.getChildren().add(mHeadMeshView);
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
        mShape = Head3D.SHAPE.DEFAULT;
    }

    public Point getLeftEyebrowPostion()
    {
        return new Point(mHalfWidth - 60, mHalfHeight - 152);
    }

    public Point getRightEyebrowPostion()
    {
        return new Point(mHalfWidth - 60, mHalfHeight - 105);
    }

    public Point getLeftEyePostion()
    {
        return new Point(13, -12);
    }

    public Point getRightEyePostion()
    {
        return new Point(-13, -12);
    }

    public Point getMouthPostion()
    {
        return new Point(mHalfWidth - 60, mHalfHeight - 110);
    }

    public Point getSpeechBubbleStartPosition()
    {
        return new Point(mHalfWidth + 20, mHalfHeight + 30);
    }

    public Point getNeckStartPosition()
    {
        int mXCenterOffset = EARWIDTH / 2;
        int mYCenterOffset = EARWIDTH / 2;
        return new Point(mSize.width / 2 + mXCenterOffset, mSize.height + mYCenterOffset + 4);
    }

    @Override
    public void calculate(int step)
    {

        Rotate rx = new Rotate(mXRotation, 0, 60, 0, Rotate.X_AXIS);
        Rotate ry = new Rotate(mYRotation, 0, 60, 0, Rotate.Y_AXIS);
        Rotate rz = new Rotate(mZRotation, 0, 60, 0, Rotate.Z_AXIS);

        Translate translation = new Translate(mXTranslation, mYTranslation, mZTranslation);

        this.getTransforms().clear();
        this.getTransforms().addAll(rz, ry, rx, translation);

        switch (mShape)
        {
            case FADEIN:
                if (step == 2)
                {
                    mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), 0.0);
                    update();
                    mHeadMeshView.setVisible(false);
                } else if (mColor.getOpacity() != 0.0)
                {
                    mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), mColor.getOpacity() - 0.052);
                    update();
                }
                break;

            case FADEOUT:
                mHeadMeshView.setVisible(true);

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

    @Override
    public void update()
    {
        material.setDiffuseColor(mColor);
        mHeadMeshView.setMaterial(material);
    }

    public Stickman3D getStickman()
    {
        return mStickman;
    }

    public MeshView getHeadMeshView()
    {
        return mHeadMeshView;
    }
}
