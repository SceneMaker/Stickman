package de.dfki.reeti.body;

import com.interactivemesh.jfx.importer.col.ColModelImporter;
import com.interactivemesh.jfx.importer.stl.StlMeshImporter;
import de.dfki.common.agent.Agent3D;
import de.dfki.common.util.Preferences;
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
    private int mHalfHeight;
    private int mHalfWidth;

    public Head(Agent3D reeti)
    {
        mHalfHeight = mSize.height / 2;
        mHalfWidth = mSize.width / 2;
        mDefaultRotationPoint = new Point(mSize.width / 2, mSize.height);
        mColor = Color.WHITE;

        URL url = getClass().getClassLoader().getResource("BodyParts/Reeti/head.dae");
        ColModelImporter im = new ColModelImporter();
        im.read(url);

        MeshView mHeadMeshView = (MeshView) im.getImport()[0];

        mHeadMeshView.setMaterial(getMaterial());

        init();
        this.getChildren().add(mHeadMeshView);
    }


    @Override
    public void init()
    {
        super.init();
        int mZTranslate = -105;
        this.setTranslateZ(mZTranslate + 28);
    }

    public Point getLeftEyeStartPosition()
    {
        int x = Preferences.REETI_HEAD_WIDTH/2  + 8;
        int y = Preferences.REETI_HEAD_HEIGHT/2 - 95;
        return new Point(x,y);
    }

    public Point getRightEyeStartPosition()
    {
        int x = (int) (Preferences.REETI_HEAD_WIDTH/2  - Preferences.REETI_EYE_WIDTH - 8);
        int y = Preferences.REETI_HEAD_HEIGHT/2 - 95;
        return new Point(x,y);
    }

    public Point getLeftEyeLidStartPosition()
    {
        Point p = new Point((int)(Preferences.REETI_HEAD_WIDTH/2 + 8),
                Preferences.REETI_HEAD_HEIGHT/2 - 100);
        return p;
    }

    public Point getRightEyeLidStartPosition()
    {
        Point p = new Point((int)(Preferences.REETI_HEAD_WIDTH/2  - Preferences.REETI_EYE_WIDTH - 12),
                Preferences.REETI_HEAD_HEIGHT/2 - 100);
        return p;
    }

    public Point getLeftEarStartPosition()
    {
        int x = Preferences.REETI_HEAD_WIDTH/2 + 80;
        int y = Preferences.REETI_HEAD_HEIGHT/2 - 50;

        return new Point(x,y);
    }

    public Point getRightEarStartPosition()
    {
        int x = Preferences.REETI_HEAD_WIDTH/2 - 80;
        int y = Preferences.REETI_HEAD_HEIGHT/2 - 50;

        return new Point(x,y);
    }

    public Point getMouthPostion()
    {
        int x = Preferences.REETI_HEAD_WIDTH/2 - 7;
        int y = Preferences.REETI_HEAD_HEIGHT/2 - 27;
        return new Point(x,y);
//        return new Point(mHalfWidth - 60, mHalfHeight - 110);
    }

    public Point getNeckStartPosition()
    {
        int mYCenterOffset = EARWITDH / 2;
        int mXCenterOffset = EARWITDH / 2;
        return new Point(mSize.width / 2 + mXCenterOffset, mSize.height + mYCenterOffset + 4);
    }

    public Point getBodyStartPosition()
    {
        int x = (int) (Preferences.REETI_HEAD_WIDTH/2 - Preferences.REETI_BODY_WIDTH/2);
        int y = Preferences.REETI_HEAD_HEIGHT - 30;

        return new Point(x,y);
    }

    @Override
    public void calculate(int step)
    {
        double pivotX = Preferences.REETI_HEAD_WIDTH/2;
        double pivotY = Preferences.REETI_HEAD_HEIGHT/2;

        Rotate rx = new Rotate(mXRotation,  pivotX, pivotY + 50, 0, Rotate.X_AXIS);
        Rotate ry = new Rotate(mYRotation,  pivotX, pivotY, 0, Rotate.Y_AXIS);
        Rotate rz = new Rotate(mZRotation,  pivotX, pivotY, 0, Rotate.Z_AXIS);

        this.getTransforms().clear();
        this.getTransforms().addAll(rz, ry, rx);
    }

    @Override
    public void setShape(String s)
    {

    }
}
