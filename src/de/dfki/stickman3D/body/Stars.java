package de.dfki.stickman3D.body;

import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Point;
import java.net.URL;

import com.interactivemesh.jfx.importer.col.ColModelImporter;

import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;

/**
 *
 * Autor Beka
 *
 */
public class Stars extends BodyPart {

	public static enum SHAPE {

		DEFAULT, SAYBYE, SAYHI, STARSDISAPPEAR, STARSFADEOUT, STARSFADEIN
	};

	UpperBody mBodyFX;

	URL url;
	ColModelImporter imorter;
	MeshView mStarBig;
	MeshView mStarMiddle;
	MeshView mStarSmall;
	PhongMaterial material;

	public Stars.SHAPE mShape = Stars.SHAPE.DEFAULT;

	public Stars(UpperBody body) {

		mBodyFX = body;
		mLength = 150;
		mSize = new Dimension(120, mLength);

		imorter = new ColModelImporter();
		mColor = Color.rgb(255, 255, 0, 0.0);

		url = getClass().getClassLoader().getResource("BodyParts/StarBig.dae");
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

		mBodyFX.mUpperBodyGroup.getChildren().addAll(mStarBig, mStarMiddle, mStarSmall);

		mStarBig.setVisible(false);
		mStarMiddle.setVisible(false);
		mStarSmall.setVisible(false);

		init();
	}

	@Override
	public void setShape(String s) {
		Stars.SHAPE shape = Stars.SHAPE.valueOf(s);
		mShape = (shape != null) ? shape : Stars.SHAPE.DEFAULT;
	}

	@Override
	public void resetShape() {
		mShape = Stars.SHAPE.DEFAULT;
	}

	@Override
	public void calculate(int step) {
		mStart = mBodyFX.getLeftLegStartPostion();

		mStarBig.setTranslateX(-50);
		mStarBig.setTranslateZ(-40);

		mStarMiddle.setTranslateX(50);
		mStarMiddle.setTranslateY(-100);
		mStarMiddle.setTranslateZ(-15);

		mStarSmall.setTranslateX(5);
		mStarSmall.setTranslateY(-145);
		mStarSmall.setTranslateZ(-40);

		switch (mShape) {
		case DEFAULT:
			break;

		case SAYBYE:
			break;

		case SAYHI:
			break;

		case STARSDISAPPEAR:
			break;

		case STARSFADEOUT:

			if (step == 2) {
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), 0.0);
				update();
				mStarBig.setVisible(false);
				mStarMiddle.setVisible(false);
				mStarSmall.setVisible(false);
			} else if (mColor.getOpacity() != 0.0) {
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), mColor.getOpacity() - 0.052);
				update();
			}
			break;

		case STARSFADEIN:
			mStarBig.setVisible(true);
			mStarMiddle.setVisible(true);
			mStarSmall.setVisible(true);

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

	public void update() {
		material.setDiffuseColor(mColor);
		mStarBig.setMaterial(material);
		mStarMiddle.setMaterial(material);
		mStarSmall.setMaterial(material);
	}

}
