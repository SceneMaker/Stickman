package de.dfki.stickman3D.body;

import com.interactivemesh.jfx.importer.col.ColModelImporter;
import de.dfki.common.util.Preferences;
import de.dfki.stickman3D.Stickman3D;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.MeshView;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;

import java.awt.*;
import java.net.URL;

/**
 * @author Beka Aptsiauri
 */
public class Head3D extends PartStickman3D
{
    public SHAPE mShape = SHAPE.DEFAULT;
    private Stickman3D mStickman;
    private MeshView mHeadMeshView;
    private PhongMaterial material;

    public Head3D(Stickman3D sm)
    {
        mStickman = sm;
        mSize = new Dimension(Preferences.HEAD_WIDTH, Preferences.HEAD_HEIGHT);
        mDefaultRotationPoint = new Point(mSize.width / 2, mSize.height);
        mColor = Color.rgb(242, 227, 217, 1);

        init();
    }

    @Override
    public void init()
    {
        super.init();
        int mZTranslate = -105;
        this.setTranslateZ(mZTranslate);
        URL url = getClass().getClassLoader().getResource("BodyParts/Stickman3D/Head.dae");
        ColModelImporter im = new ColModelImporter();
        im.read(url);

        mHeadMeshView = (MeshView) im.getImport()[0];
        material = new PhongMaterial();
        material.setDiffuseColor(mColor);
        mHeadMeshView.setMaterial(material);
        this.getChildren().add(mHeadMeshView);
    }

    @Override
    public void setShape(String s)
    {
        mShape = SHAPE.valueOf(s);
    }

    @Override
    public void resetShape()
    {
        mShape = Head3D.SHAPE.DEFAULT;
    }

    public Point getNoseStartPosition()
    {
        int x = Preferences.HEAD_WIDTH/2 - Preferences.NOSE_WIDTH/2;
        int y = Preferences.HEAD_HEIGHT /2;
        return new Point(x,y);
    }

    public Point getRightEarStartPosition()
    {
        int x = -4;
        int y = Preferences.HEAD_HEIGHT /2 - Preferences.EAR_HEIGHT + 5;
        return new Point(x,y);
    }

    public Point getLeftEarStartPosition()
    {
        int x = Preferences.HEAD_WIDTH - 7;
        int y = Preferences.HEAD_HEIGHT /2 - Preferences.EAR_HEIGHT + 5;
        return new Point(x,y);
    }

    public Point getLeftEyebrowPosition()
    {
        int x = Preferences.HEAD_WIDTH/2 + 10;
        int y = Preferences.HEAD_HEIGHT /2 - 27;
        return new Point(x,y);
    }

    public Point getRightEyebrowPosition()
    {
        int x = Preferences.HEAD_WIDTH/2 - 40;
        int y = Preferences.HEAD_HEIGHT /2 - 27;
        return new Point(x,y);
    }

    public Point getLeftEyePosition()
    {
        int x = Preferences.HEAD_WIDTH/2 + 13;
        int y = Preferences.HEAD_HEIGHT /2 - 18;

        return new Point(x,y);
    }

    public Point getRightEyePosition()
    {
        int x = Preferences.HEAD_WIDTH/2 - 35;
        int y = Preferences.HEAD_HEIGHT /2 - 18;

        return new Point(x,y);
    }

    public Point getMouthPosition()
    {
        int x = Preferences.HEAD_WIDTH/2 - Preferences.MOUTH_WIDTH/2 + 1;
        int y = Preferences.HEAD_HEIGHT /2 + Preferences.HEAD_HEIGHT /4 + 2;
        return new Point(x,y);
    }

    public Point getSpeechBubbleStartPosition()
    {
        int x = Preferences.HEAD_WIDTH - 40;
        int y = Preferences.HEAD_HEIGHT /2 + 40;
        return new Point(x,y);
    }

    public Point getNeckStartPosition()
    {
        int x = Preferences.HEAD_WIDTH / 2 - Preferences.NECK_WIDTH / 2;
        int y = (int) (this.getTranslateY() + Preferences.HEAD_HEIGHT);
        return new Point(x, y);
    }

    public Point getFaceWrinkleStartPosition()
    {
        int x = (int) (Preferences.HEAD_WIDTH/2 - Preferences.FACEWRINKLE_BOX_SPACING/2 - 2);
        int y = Preferences.HEAD_HEIGHT/2 - 20;
        return new Point(x,y);
    }

    @Override
    public void calculate(int step)
    {
        Rotate rx = new Rotate(mXRotation, 0, 120, 0, Rotate.X_AXIS);
        Rotate ry = new Rotate(mYRotation, 60, 0, 0, Rotate.Y_AXIS);
        Rotate rz = new Rotate(mZRotation, 60, 120, 0, Rotate.Z_AXIS);

        Translate translation = new Translate(mXTranslation, mYTranslation, mZTranslation);

        this.getTransforms().clear();
        this.getTransforms().addAll(rz, ry, rx, translation);

        executeFadeInFadeOut(mHeadMeshView, mShape, step);
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

    @Override
    public MeshView getMeshView()
    {
        return mHeadMeshView;
    }
}
