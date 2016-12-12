/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.body;

import java.awt.Dimension;
import java.net.URL;

import com.interactivemesh.jfx.importer.col.ColModelImporter;

import de.dfki.util.XMLParser;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.MeshView;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class RightEar extends BodyPart {
	public static enum SHAPE {
		DEFAULT, FADEIN, FADEOUT
	};

	Head mHeadFX;

	URL url;
	ColModelImporter imorter;
	public MeshView mRightEarMesh;
	PhongMaterial material;

	URL imageUrl;
	Image im;

	double initOpacity = 0.85;

	public RightEar.SHAPE mShape = RightEar.SHAPE.DEFAULT;

	public RightEar(Head head) {
		mHeadFX = head;
		mSize = new Dimension(mLength, mLength);

		imorter = new ColModelImporter();
		mColor = Color.rgb(242, 227, 217, initOpacity);
		activateConfigColor();

		url = getClass().getClassLoader().getResource("BodyParts/rightEar.dae");

		imageUrl = getClass().getClassLoader().getResource("Images/difuseMap1.png");
		im = new Image(imageUrl.toExternalForm());

		imorter.read(url);
		mRightEarMesh = (MeshView) imorter.getImport()[0];

		material = new PhongMaterial();
		material.setDiffuseColor(mColor);
		material.setDiffuseMap(im);
		mRightEarMesh.setMaterial(material);

		mStart = mHeadFX.getLeftEyebrowPostion();

		init();

		mHeadFX.mHead.getChildren().add(mRightEarMesh);
	}

	@Override
	public void init() {
		super.init();
		mRightEarMesh.setTranslateX(mStart.x-61);
		mRightEarMesh.setTranslateY(mStart.y + 100);
		mRightEarMesh.setTranslateZ(-2);
	}

	private void activateConfigColor() {
		String stickmanName = mHeadFX.mStickmanFX.mName;
		if (XMLParser.getColorMap(stickmanName) != null) {
			if (XMLParser.getColorMap(stickmanName).containsKey("NoseColor"))
				this.mColor = XMLParser.getColorMap(stickmanName).get("NoseColor");
		}
	}

	@Override
	public void setShape(String s) {
		SHAPE shape = RightEar.SHAPE.valueOf(s);
		mShape = (shape != null) ? shape : RightEar.SHAPE.DEFAULT;
	}

	@Override
	public void resetShape() {
		mShape = RightEar.SHAPE.DEFAULT;
	}

	@Override
	public void calculate(int step) {

		switch (mShape) {
		case FADEIN:
			if (step == 2) {
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), 0.0);
				update();
				mRightEarMesh.setVisible(false);
			} else if (mColor.getOpacity() != 0.0) {
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(),
						mColor.getOpacity() - initOpacity / 19);
				update();
			}
			break;

		case FADEOUT:
			mRightEarMesh.setVisible(true);

			if (step == 2) {
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), initOpacity);
				update();
			} else if (mColor.getOpacity() <= initOpacity) {
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(),
						mColor.getOpacity() + initOpacity / 19);
				update();
			}
			break;
		}
	}

	@Override
	public void update() {
		material.setDiffuseColor(mColor);
		material.setDiffuseMap(im);
		mRightEarMesh.setMaterial(material);
	}

	@Override
	protected void recordColor() {
		if (mHeadFX.mStickmanFX.setCharacterInvisible == false)
			mColorRecorder = mColor;
	}
}
