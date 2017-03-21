package de.dfki.reeti.body;

import com.interactivemesh.jfx.importer.col.ColModelImporter;
import com.interactivemesh.jfx.importer.stl.StlMeshImporter;
import de.dfki.reeti.Reeti;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.TriangleMesh;
import javafx.scene.transform.Rotate;
import javafx.scene.image.Image;

import java.awt.*;
import java.net.URL;
import javafx.scene.transform.Translate;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class Head extends BodyPartFX {

    public Dimension mSize = new Dimension(120, 100);
    public Reeti mReeti;
    TriangleMesh mHeadTriangleMesh;
    public MeshView mHeadMeshView;
    PhongMaterial material;

    URL imageUrl;
    Image image;

    URL url;
    StlMeshImporter im;
    public Group mHead;

    int mHalfHeight = mSize.height / 2;
    int mHalfWidth = mSize.width / 2;
    int mPivotOffset = 55;
    int mZTranslate = -105;

    int mEarWidth = 10;

    int mDrawOffset = 10;
    int mXCenterOffset = mEarWidth / 2;
    int mYCenterOffset = mEarWidth / 2;

    int mHeadRadius = 60;
    int mHeadHeight = 30;

    public Head(Reeti reeti) {
        mReeti = reeti;
        mDefaultRotationPoint = new Point(mSize.width / 2, mSize.height);
        mColor = Color.WHITE;

        url = getClass().getClassLoader().getResource("BodyParts/Reeti/v1.stl");
        imageUrl = getClass().getClassLoader().getResource("Images/difuseMap2.png");
        image = new Image(imageUrl.toExternalForm());
        im = new StlMeshImporter();
        im.read(url);

        mHead = new Group();
        mHeadTriangleMesh = im.getImport();

        mHeadMeshView = new MeshView(mHeadTriangleMesh);
        mHeadMeshView.setId("ReetiHead");

        material = new PhongMaterial();
        material.setDiffuseColor(mColor);
        material.setDiffuseMap(image);
        material.setSelfIlluminationMap(image);

        mHeadMeshView.setMaterial(material);

        mHeadMeshView.setRotationAxis(Rotate.X_AXIS);
        mHeadMeshView.setRotate(-92);

        mHead.getChildren().add(mHeadMeshView);

        init();
        this.getChildren().add(mHead);
        calculate(0);
    }

    @Override
    public void init() {
        super.init();
        mHead.setTranslateX(mHalfWidth + 6);
        mHead.setTranslateY(mHalfHeight - 200);
        mHead.setTranslateZ(mZTranslate + 28);
    }

    public Point getLeftEyebrowPostion() {
        return new Point(mHalfWidth - 60, mHalfHeight - 152);
    }

    public Point getRightEyebrowPostion() {
        return new Point(mHalfWidth - 60, mHalfHeight - 105);
    }

    public Point getLeftEyePostion() {
        return new Point(13, -12);
    }

    public Point getRightEyePostion() {
        return new Point(-13, -12);
    }

    public Point getMouthPostion() {
        return new Point(mHalfWidth - 60, mHalfHeight - 110);
    }

    public Point getSpeechBubbleStartPosition() {
        return new Point(mHalfWidth + 20, mHalfHeight + 30);
    }

    public Point getThinkhBubbleStartPosition() {
        return new Point(mHalfWidth, mHalfHeight);
    }

    public Point getBombeStartPosition() {
        return new Point(mHalfWidth + 100, mHalfHeight - 50);
    }

    public Point getBombeEndPosition() {
        return new Point(0, 0);
    }

    public Point getNeckStartPosition() {
        return new Point(mSize.width / 2 + mXCenterOffset, mSize.height + mYCenterOffset + 4);
    }

    @Override
    public void calculate(int step) {

        Rotate rx = new Rotate(mXRotation,  Rotate.X_AXIS);
        Rotate ry = new Rotate(mYRotation,  Rotate.Y_AXIS);
        Rotate rz = new Rotate(mZRotation,  Rotate.Z_AXIS);

        mHead.getTransforms().clear();
        mHead.getTransforms().addAll(rz, ry, rx);
    }

    @Override
    public void update() {
        material.setDiffuseColor(mColor);
        mHeadMeshView.setMaterial(material);
    }
}
