package de.dfki.stickman3D.utils;

import de.dfki.common.Gender;
import de.dfki.common.StickmansOnStage;

import de.dfki.stickman3D.xmlsettings.StickmanData3D;
import de.dfki.stickman3D.stage.StickmanStage3D;
import de.dfki.stickman3D.stage.StickmansOnStage3D;
import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import javafx.scene.paint.Color;

//import de.dfki.stickmanFX.stage.StickmanStageFX;
//import de.dfki.stickmanFX.stage.StickmansOnStageFX;
//import de.dfki.stickmanFX.StickmanFX;

import java.io.File;
import java.util.List;

/**
 * Created by alvaro on 10/9/16.
 */
public class XmlStickmanLoader {

    private String mFilePath;
    private StickmansOnStage sStickmansOnStage;

    public XmlStickmanLoader(StickmansOnStage stickmansOnStage) {
        this.sStickmansOnStage = stickmansOnStage;
        mFilePath = stickmansOnStage.getmFilePath();
    }

    private void readXML() {
        File file = null;
        if (mFilePath != null) {
            file = new File(mFilePath + File.separator + "stickman3d" + File.separator + "stickman3d.xml");
        }

        if (file != null) {
            sStickmansOnStage.getmXmlTransform().loadStickmanDataFromFile(file);
        }
    }

    public void initialStickmanWithXml() {
        readXML();
        List<StickmanData3D> mStickmanData3D = ((StickmansOnStage3D) sStickmansOnStage).getmXmlTransform()
                .getStickmanData3DList();
        if (!(mStickmanData3D.isEmpty())) {
            for (StickmanData3D mStick : mStickmanData3D) {
                String name = mStick.getName();
                if (sStickmansOnStage.getStickmanNames().contains(name.toLowerCase())) {
                    String bodycolor = mStick.getbodyColor();
                    if (bodycolor != null) {
                        Runnable bodyRunnable = () -> {
                                ((Stickman3D) sStickmansOnStage.getStickman(name)).mUpperBody.mColor = Color.web(bodycolor);
                                ((Stickman3D) sStickmansOnStage.getStickman(name)).mUpperBody.update();                  
                        };
                        StickmanStage3D.getInstance().runLater(bodyRunnable);
                    }

                    String haircolor = mStick.gethairColor();
                    if ((haircolor != null)) {
                        Runnable hairColor = () -> {
                            if (((Stickman3D) sStickmansOnStage.getStickman(name)).mType == Gender.TYPE.MALE) {
                                ((Stickman3D) sStickmansOnStage.getStickman(name)).mMaleHairFX.mColor = Color.web(haircolor);
                                ((Stickman3D) sStickmansOnStage.getStickman(name)).mMaleHairFX.update();
                            } else {
                                ((Stickman3D) sStickmansOnStage.getStickman(name)).mFemaleHairFX.mColor = Color.web(haircolor);
                                ((Stickman3D) sStickmansOnStage.getStickman(name)).mFemaleHairFX.update();                         
                            }
                        };
                        StickmanStage3D.getInstance().runLater(hairColor);
                    }
//
                    String headcolor = mStick.getheadColor();
                    if (headcolor != null) {
                        Runnable headColor = () -> {
                            ((Stickman3D) sStickmansOnStage.getStickman(name)).mHeadFX.mColor = Color.web(headcolor);
                            if (((Stickman3D) sStickmansOnStage.getStickman(name)).mHeadFX.mColor != null) {
                                ((Stickman3D) sStickmansOnStage.getStickman(name)).mHeadFX.update();
                            }
                        };
                        StickmanStage3D.getInstance().runLater(headColor);
                    }
                    
                    String shoescolor = mStick.getshoesColor();
                    if (shoescolor != null) {
                        Runnable shoesColor = () -> {
                            ((Stickman3D) sStickmansOnStage.getStickman(name)).mLeftFootFX.mColor = Color.web(shoescolor);
                            ((Stickman3D) sStickmansOnStage.getStickman(name)).mRightFootFX.mColor = Color.web(shoescolor);
                                ((Stickman3D) sStickmansOnStage.getStickman(name)).mLeftFootFX.update();
                                ((Stickman3D) sStickmansOnStage.getStickman(name)).mRightFootFX.update();
                        };
                        StickmanStage3D.getInstance().runLater(shoesColor);
                    }
                    
                    String lipscolor = mStick.getlipsColor();
                    if (lipscolor != null) {
                        Runnable lipsColor = () -> {
                            ((Stickman3D) sStickmansOnStage.getStickman(name)).mMouthFX.mColor = Color.web(lipscolor);
                                ((Stickman3D) sStickmansOnStage.getStickman(name)).mMouthFX.update();
                        };
                        StickmanStage3D.getInstance().runLater(lipsColor);
                    }
                    
                    String eyescolor = mStick.geteyesColor();
                    if (eyescolor != null) {
                        Runnable eyesColor = () -> {
                            ((Stickman3D) sStickmansOnStage.getStickman(name)).mLeftEyeFX.mColor = Color.web(eyescolor);
                            ((Stickman3D) sStickmansOnStage.getStickman(name)).mRightEyeFX.mColor = Color.web(eyescolor);
                                ((Stickman3D) sStickmansOnStage.getStickman(name)).mLeftEyeFX.update();
                                ((Stickman3D) sStickmansOnStage.getStickman(name)).mRightEyeFX.update();
                        };
                        StickmanStage3D.getInstance().runLater(eyesColor);
                    }
                    
                    String browscolor = mStick.getbrowsColor();
                    if (browscolor != null) {
                        Runnable browsColor = () -> {
                            ((Stickman3D) sStickmansOnStage.getStickman(name)).mLeftEyebrowFX.mColor = Color.web(browscolor);
                            ((Stickman3D) sStickmansOnStage.getStickman(name)).mRightEyebrowFX.mColor = Color.web(browscolor);
                                ((Stickman3D) sStickmansOnStage.getStickman(name)).mLeftEyebrowFX.update();
                                ((Stickman3D) sStickmansOnStage.getStickman(name)).mRightEyebrowFX.update();
                        };
                        StickmanStage3D.getInstance().runLater(browsColor);
                    }
                    
                    String nosecolor = mStick.getnoseColor();
                    if (nosecolor != null) {
                        Runnable noseColor = () -> {
                            ((Stickman3D) sStickmansOnStage.getStickman(name)).mNoseFX.mColor = Color.web(nosecolor);
                                ((Stickman3D) sStickmansOnStage.getStickman(name)).mNoseFX.update();
                        };
                        StickmanStage3D.getInstance().runLater(noseColor);
                    }                 

                    String limbscolor = mStick.getlimbsColor();
                    if (limbscolor != null) {
                        Runnable limbsColor = () -> {
                            ((Stickman3D) sStickmansOnStage.getStickman(name)).mLeftUpperLegFX.mColor = Color.web(limbscolor);
                            ((Stickman3D) sStickmansOnStage.getStickman(name)).mNeckFX.mColor = Color.web(limbscolor);
                            ((Stickman3D) sStickmansOnStage.getStickman(name)).mLeftUpperArmFX.mColor = Color.web(limbscolor);
                            ((Stickman3D) sStickmansOnStage.getStickman(name)).mLeftForeArmFX.mColor = Color.web(limbscolor);
                            ((Stickman3D) sStickmansOnStage.getStickman(name)).mLeftWrist.mColor = Color.web(limbscolor);
                            ((Stickman3D) sStickmansOnStage.getStickman(name)).mLeftFinger1.mColor = Color.web(limbscolor);
                            ((Stickman3D) sStickmansOnStage.getStickman(name)).mLeftFinger2.mColor = Color.web(limbscolor);
                            ((Stickman3D) sStickmansOnStage.getStickman(name)).mLeftFinger3.mColor = Color.web(limbscolor);
                            ((Stickman3D) sStickmansOnStage.getStickman(name)).mLeftFinger4.mColor = Color.web(limbscolor);
                            ((Stickman3D) sStickmansOnStage.getStickman(name)).mLeftUpperLegFX.mColor = Color.web(limbscolor);
                            ((Stickman3D) sStickmansOnStage.getStickman(name)).mLeftForeLegFX.mColor = Color.web(limbscolor);
                            ((Stickman3D) sStickmansOnStage.getStickman(name)).mRightUpperArmFX.mColor = Color.web(limbscolor);
                            ((Stickman3D) sStickmansOnStage.getStickman(name)).mRightForeArmFX.mColor = Color.web(limbscolor);
                            ((Stickman3D) sStickmansOnStage.getStickman(name)).mRightWrist.mColor = Color.web(limbscolor);
                            ((Stickman3D) sStickmansOnStage.getStickman(name)).mRightFinger1.mColor = Color.web(limbscolor);
                            ((Stickman3D) sStickmansOnStage.getStickman(name)).mRightFinger2.mColor = Color.web(limbscolor);
                            ((Stickman3D) sStickmansOnStage.getStickman(name)).mRightFinger3.mColor = Color.web(limbscolor);
                            ((Stickman3D) sStickmansOnStage.getStickman(name)).mRightFinger4.mColor = Color.web(limbscolor);
                            ((Stickman3D) sStickmansOnStage.getStickman(name)).mRightUpperLegFX.mColor = Color.web(limbscolor);
                            ((Stickman3D) sStickmansOnStage.getStickman(name)).mRightForeLegFX.mColor = Color.web(limbscolor);                        

                            ((Stickman3D) sStickmansOnStage.getStickman(name)).mNeckFX.update();
                            ((Stickman3D) sStickmansOnStage.getStickman(name)).mLeftUpperArmFX.update();
                            ((Stickman3D) sStickmansOnStage.getStickman(name)).mLeftForeArmFX.update();
                            ((Stickman3D) sStickmansOnStage.getStickman(name)).mLeftWrist.update();
                            ((Stickman3D) sStickmansOnStage.getStickman(name)).mLeftFinger1.update();
                            ((Stickman3D) sStickmansOnStage.getStickman(name)).mLeftFinger2.update();
                            ((Stickman3D) sStickmansOnStage.getStickman(name)).mLeftFinger3.update();
                            ((Stickman3D) sStickmansOnStage.getStickman(name)).mLeftFinger4.update();
                            ((Stickman3D) sStickmansOnStage.getStickman(name)).mLeftUpperLegFX.update();
                            ((Stickman3D) sStickmansOnStage.getStickman(name)).mLeftForeLegFX.update();

                            ((Stickman3D) sStickmansOnStage.getStickman(name)).mRightUpperArmFX.update();
                            ((Stickman3D) sStickmansOnStage.getStickman(name)).mRightForeArmFX.update();
                            ((Stickman3D) sStickmansOnStage.getStickman(name)).mRightWrist.update();
                            ((Stickman3D) sStickmansOnStage.getStickman(name)).mRightFinger1.update();
                            ((Stickman3D) sStickmansOnStage.getStickman(name)).mRightFinger2.update();
                            ((Stickman3D) sStickmansOnStage.getStickman(name)).mRightFinger3.update();
                            ((Stickman3D) sStickmansOnStage.getStickman(name)).mRightFinger4.update();
                            ((Stickman3D) sStickmansOnStage.getStickman(name)).mRightUpperLegFX.update();
                            ((Stickman3D) sStickmansOnStage.getStickman(name)).mRightForeLegFX.update();                     
                        };
                        StickmanStage3D.getInstance().runLater(limbsColor);
                    }
                }
            }
        }
    }
}

