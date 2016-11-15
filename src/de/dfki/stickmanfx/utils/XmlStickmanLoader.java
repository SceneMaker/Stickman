package de.dfki.stickmanfx.utils;

import de.dfki.stickman.Stickman;
import de.dfki.stickman.stagecontroller.StickmansOnStage;
import de.dfki.stickmanfx.StickmanFX;
import de.dfki.stickmanfx.StickmanStageFX;
import de.dfki.stickmanfx.stagecontroller.StageStickmanControllerFX;
import de.dfki.stickmanfx.stagecontroller.StickmansOnStageFX;
import de.dfki.stickmanfx.xmlsettings.StickmanDataFX;
import de.dfki.stickmanfx.xmlsettings.XmlTransform;
import de.dfki.util.HandleColor;
import javafx.application.Platform;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

import java.io.File;
import java.util.List;

/**
 * Created by alvaro on 10/9/16.
 */
public class XmlStickmanLoader {
    private String mFilePath;
    private StickmansOnStageFX sStickmansOnStage;

    public XmlStickmanLoader(StickmansOnStageFX stickmansOnStage) {
	this.sStickmansOnStage = stickmansOnStage;
	mFilePath = stickmansOnStage.getmFilePath();
    }

    private void readXML() {
	File file = null;
	if (mFilePath != null)
	    file = new File(mFilePath + File.separator + "stickman" + File.separator + "stickman.xml");

	if (file != null) {
	    sStickmansOnStage.getmXmlTransform().loadStickmanDataFromFile(file);
	}
    }

    public void initialStickmanWithXml() {
	readXML();
	List<StickmanDataFX> mStickmanDataFX = sStickmansOnStage.getmXmlTransform().getStickmanDataFXList();
	if (!(mStickmanDataFX.isEmpty())) {
	    for (StickmanDataFX mStick : mStickmanDataFX) {
		String name = mStick.getName();
		if (sStickmansOnStage.getStickmanNames().contains(name.toLowerCase())) {
		    String bodycolor = mStick.getbodyColor();
		    StickmanFX mStickmanFX = (StickmanFX) sStickmansOnStage.getStickman(name);
		    if (bodycolor != null) {

			Runnable bodyRunnable = () -> {
			    if (mStickmanFX.mType == Stickman.TYPE.MALE) {
				mStickmanFX.mBodyFX.mMaleColor = HandleColor.switchColor(bodycolor);
				mStickmanFX.update();
			    } else {
				mStickmanFX.mBodyFX.mFemaleColor = HandleColor.switchColor(bodycolor);
				mStickmanFX.update();
			    }
			};
			StickmanStageFX.getInstance().runLater(bodyRunnable);
		    }

		    String haircolor = mStick.gethairColor();
		    if ((haircolor != null)) {
			Runnable hairColor = () -> {
			    if (mStickmanFX.mType == Stickman.TYPE.MALE) {
				mStickmanFX.mMaleHairFX.mColor = HandleColor.switchColor(haircolor);
				mStickmanFX.update();
			    } else {
				mStickmanFX.mFemaleHairFX.mColor = HandleColor.switchColor(haircolor);
				mStickmanFX.update();
			    }
			};
			StickmanStageFX.getInstance().runLater(hairColor);
		    }

		    String headcolor = mStick.getheadColor();
		    if (headcolor != null) {
			Runnable headColor = () -> {
			    mStickmanFX.mHeadFX.mColor = HandleColor.switchColor(headcolor);
			    if (mStickmanFX.mHeadFX.mColor != null)
				mStickmanFX.update();
			};
			StickmanStageFX.getInstance().runLater(headColor);
		    }

		    String limbscolor = mStick.getlimbsColor();
		    if (limbscolor != null) {
			Runnable limbsColor = () -> {
			    mStickmanFX.mLeftUpperLegFX.mColor = HandleColor.switchColor(limbscolor);
			    mStickmanFX.mLeftForeLegFX.mColor = HandleColor.switchColor(limbscolor);
			    mStickmanFX.mLeftFootFX.mColor = HandleColor.switchColor(limbscolor);
			    mStickmanFX.mRightUpperLegFX.mColor = HandleColor.switchColor(limbscolor);
			    mStickmanFX.mRightForeLegFX.mColor = HandleColor.switchColor(limbscolor);
			    mStickmanFX.mRightFootFX.mColor = HandleColor.switchColor(limbscolor);
			    mStickmanFX.mLeftHandFX.mColor = HandleColor.switchColor(limbscolor);
			    mStickmanFX.mRightHandFX.mColor = HandleColor.switchColor(limbscolor);
			    mStickmanFX.mLeftShoulderFX.mColor = HandleColor.switchColor(limbscolor);
			    mStickmanFX.mRightShoulderFX.mColor = HandleColor.switchColor(limbscolor);
			    mStickmanFX.mLeftUpperArmFX.mColor = HandleColor.switchColor(limbscolor);
			    mStickmanFX.mLeftForeArmFX.mColor = HandleColor.switchColor(limbscolor);
			    mStickmanFX.mRightUpperArmFX.mColor = HandleColor.switchColor(limbscolor);
			    mStickmanFX.mRightForeArmFX.mColor = HandleColor.switchColor(limbscolor);
			    mStickmanFX.mNeckFX.mColor = HandleColor.switchColor(limbscolor);
			    mStickmanFX.update();
			};
			StickmanStageFX.getInstance().runLater(limbsColor);
		    }
		}
	    }

	    String Stickname = mStickmanDataFX.get(0).getName();
	    if (sStickmansOnStage.getStickmanNames().contains(Stickname.toLowerCase())) {
		StickmanFX mStickmanFX = (StickmanFX) sStickmansOnStage.getStickman(Stickname);
		mStickmanFX.backgroundRecord = mStickmanDataFX.get(0).getbackgroundRecord();
		String backgroundrecord = mStickmanFX.backgroundRecord;
		if (backgroundrecord != null) {
		    String mStageIdentifier = mStickmanFX.getStickmanStageController().getStageIdentifier();
		    HBox mStickmanPane;
		    try {
			mStickmanPane = mStickmanFX.getStickmanStageController().getStickmanStage()
				.getStickmanPane(mStageIdentifier);

			// Upload the picture
			if (StickmanFX.backgroundList.contains(backgroundrecord)) {
			    mStickmanPane.setStyle("-fx-background-image: url('/de/dfki/stickmanfx/image/"
				    + backgroundrecord + ".jpg');"
				    + "-fx-background-repeat: repeat;-fx-background-position: center center; -fx-background-size: contain;");
			} else {
			    // change the color of the background
			    mStickmanPane.setStyle("-fx-background-color: " + backgroundrecord + ";");
			}
		    } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		    }
		}
	    }
	}
    }
}
