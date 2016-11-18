package de.dfki.stickmanfx.bodyfx;

import java.awt.Dimension;
import java.net.URL;

import com.interactivemesh.jfx.importer.stl.StlMeshImporter;

import de.dfki.stickmanfx.StickmanFX;
import de.dfki.util.XMLParser;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.TriangleMesh;
import javafx.scene.transform.Rotate;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class FemaleHairFX extends BodyPartFX {

	public static enum SHAPE {
		DEFAULT, FADEIN, FADEOUT
	};

	public FemaleHairFX.SHAPE mShape = FemaleHairFX.SHAPE.DEFAULT;

	public Dimension mSize = new Dimension(120, 100);
	public StickmanFX mStickmanFX;

	int mHalfHeight = mSize.height / 2;
	int mHalfWidth = mSize.width / 2;
	int mEarWidth = 10;

	int mDrawOffset = 10;
	int mXCenterOffset = mEarWidth / 2;
	int mYCenterOffset = mEarWidth / 2;

	int mPivotOffset = 55;
	int mZTranslate = 20;

	URL url;
	StlMeshImporter importer;
	TriangleMesh femaleHairTriangleMesh;
	MeshView femaleHairMeshView;
	PhongMaterial material;

	public FemaleHairFX(StickmanFX sm) {
		mStickmanFX = sm;
		mColor = Color.rgb(240, 212, 0, 1);
		activateConfigColor();

		if (mStickmanFX.mHeadFX != null)
			mYRotation = mStickmanFX.mHeadFX.mYRotation;

		url = getClass().getClassLoader().getResource("BodyParts/femaleHair.stl");
		importer = new StlMeshImporter();
		importer.read(url);
		femaleHairTriangleMesh = importer.getImport();
		femaleHairMeshView = new MeshView(femaleHairTriangleMesh);
		femaleHairMeshView.setId("FemaleHair");
		material = new PhongMaterial();
		material.setDiffuseColor(mColor);
		femaleHairMeshView.setMaterial(material);
		femaleHairMeshView.setRotationAxis(Rotate.X_AXIS);
		femaleHairMeshView.setRotate(-90);

		if (mStickmanFX.mType == StickmanFX.TYPE.FEMALE)
			mStickmanFX.mHeadFX.mHead.getChildren().add(femaleHairMeshView);

		init();

		calculate(0);
	}

	@Override
	public void init() {
		super.init();
		femaleHairMeshView.setTranslateX(mHalfWidth - 60);
		femaleHairMeshView.setTranslateY(mHalfHeight - 52);
		femaleHairMeshView.setTranslateZ(mZTranslate);
	}

	/*
	 * es wird config-file geparst. Wenn Color-Block(in config-file) nicht leer
	 * => aendere mcolor
	 */
	private void activateConfigColor() {
		String stickmanName = mStickmanFX.mName;
		if (XMLParser.getColorMap(stickmanName) != null) {
			if (XMLParser.getColorMap(stickmanName).containsKey("HairColor")) {
				this.mColor = XMLParser.getColorMap(stickmanName).get("HairColor");
			}
		}
	}

	@Override
	public void setShape(String s) {
		SHAPE shape = SHAPE.valueOf(s);
		mShape = (shape != null) ? shape : SHAPE.DEFAULT;
	}

	@Override
	public void resetShape() {
		mShape = FemaleHairFX.SHAPE.DEFAULT;
	}

	@Override
	public void calculate(int step) {

		Rotate rx = new Rotate(mXRotation, Rotate.X_AXIS);
		Rotate ry = new Rotate(mYRotation, Rotate.Y_AXIS);
		Rotate rz = new Rotate(mZRotation, Rotate.Z_AXIS);

		femaleHairMeshView.getTransforms().clear();
		femaleHairMeshView.getTransforms().addAll(rx, ry, rz);

		switch (mShape) {
		case FADEIN:
			if (step == 2) {
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), 0.0);
				update();
				femaleHairMeshView.setVisible(false);
			} else if (mColor.getOpacity() != 0.0) {
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), mColor.getOpacity() - 0.052);
				update();
			}
			break;

		case FADEOUT:
			femaleHairMeshView.setVisible(true);

			if (step == 2) {
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), 1.0);
				update();
			} else if (mColor.getOpacity() != 1.0) {
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), mColor.getOpacity() + 0.052);
				update();
			}
			break;
		}
	}

	@Override
	public void update() {
		material.setDiffuseColor(mColor);
		femaleHairMeshView.setMaterial(material);
	}
}
