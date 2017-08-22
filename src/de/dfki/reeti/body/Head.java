package de.dfki.reeti.body;

import com.interactivemesh.jfx.importer.stl.StlMeshImporter;
import de.dfki.common.agent.Agent3D;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.TriangleMesh;
import javafx.scene.transform.Rotate;

import java.awt.*;
import java.net.URL;

/**
 * @author Beka Aptsiauri
 */
public class Head extends PartReeti
{
    private static final int EARWITDH = 10;
    private Group mHeadGroup;
    private int mHalfHeight;
    private int mHalfWidth;

    public Head(Agent3D reeti)
    {
        mSize = new Dimension(120, 100);
        mHalfHeight = mSize.height / 2;
        mHalfWidth = mSize.width / 2;
        mDefaultRotationPoint = new Point(mSize.width / 2, mSize.height);
        mColor = Color.WHITE;

        URL url = getClass().getClassLoader().getResource("BodyParts/Reeti/v1.stl");
        StlMeshImporter im = new StlMeshImporter();
        im.read(url);

        mHeadGroup = new Group();
        TriangleMesh mHeadTriangleMesh = im.getImport();
        MeshView mHeadMeshView = new MeshView(mHeadTriangleMesh);

        mHeadMeshView.setMaterial(getMaterial());

        mHeadMeshView.setRotationAxis(Rotate.X_AXIS);
        mHeadMeshView.setRotate(-92);

        mHeadGroup.getChildren().add(mHeadMeshView);

        init();
        this.getChildren().add(mHeadGroup);
        calculate(0);
    }


    @Override
    public void init()
    {
        super.init();
        int mZTranslate = -105;
        mHeadGroup.setTranslateX(mHalfWidth + 6);
        mHeadGroup.setTranslateY(mHalfHeight - 200);
        mHeadGroup.setTranslateZ(mZTranslate + 28);
    }

    public Point getLeftEyebrowPostion()
    {
        return new Point(mHalfWidth - 60, mHalfHeight - 152);
    }

    public Point getRightEyebrowPostion()
    {
        return new Point(mHalfWidth - 60, mHalfHeight - 105);
    }

    public Point getMouthPostion()
    {
        return new Point(mHalfWidth - 60, mHalfHeight - 110);
    }

    public Point getNeckStartPosition()
    {
        int mYCenterOffset = EARWITDH / 2;
        int mXCenterOffset = EARWITDH / 2;
        return new Point(mSize.width / 2 + mXCenterOffset, mSize.height + mYCenterOffset + 4);
    }

    @Override
    public void calculate(int step)
    {

        Rotate rx = new Rotate(mXRotation, 0, 25, -25, Rotate.X_AXIS);
        Rotate ry = new Rotate(mYRotation, 0, 25, -25, Rotate.Y_AXIS);
        Rotate rz = new Rotate(mZRotation, 0, 25, -25, Rotate.Z_AXIS);

        mHeadGroup.getTransforms().clear();
        mHeadGroup.getTransforms().addAll(rz, ry, rx);
    }

    @Override
    public void setShape(String s)
    {

    }

    public Group getHeadGroup()
    {
        return mHeadGroup;
    }
}
