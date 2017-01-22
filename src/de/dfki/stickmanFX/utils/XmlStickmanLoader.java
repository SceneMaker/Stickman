package de.dfki.stickmanFX.utils;

import de.dfki.common.Gender;
import de.dfki.common.StickmansOnStage;
import de.dfki.stickmanFX.xmlsettings.StickmanDataFX;
import javafx.scene.paint.Color;
import de.dfki.stickmanFX.stage.StickmanStageFX;
import de.dfki.stickmanFX.stage.StickmansOnStageFX;
import de.dfki.stickmanFX.StickmanFX;

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
            file = new File(mFilePath + File.separator + "stickmanfx" + File.separator + "stickmanfx.xml");
        }

        if (file != null) {
            sStickmansOnStage.getmXmlTransform().loadStickmanDataFromFile(file);
        }
    }

    public void initialStickmanWithXml() {
        readXML();
        List<StickmanDataFX> mStickmanDataFX = ((StickmansOnStageFX) sStickmansOnStage).getmXmlTransform()
                .getStickmanDataFXList();
        if (!(mStickmanDataFX.isEmpty())) {
            for (StickmanDataFX mStick : mStickmanDataFX) {
                String name = mStick.getName();
                if (sStickmansOnStage.getStickmanNames().contains(name.toLowerCase())) {
                    String bodycolor = mStick.getbodyColor();
                    float bodyColorOpacity = mStick.getbodyColorOpacity();
                    if (bodycolor != null) {
                        Runnable bodyRunnable = () -> {
                            if (((StickmanFX) sStickmansOnStage.getStickman(name)).mType == Gender.TYPE.MALE) {
                                ((StickmanFX) sStickmansOnStage.getStickman(name)).mBodyFX.mMaleColor = Color
                                        .web(bodycolor, bodyColorOpacity);
                                ((StickmanFX) sStickmansOnStage
                                        .getStickman(name)).mBodyFX.mColoropacity = bodyColorOpacity;
                                ((StickmanFX) sStickmansOnStage.getStickman(name)).update();

                                ((StickmanFX) sStickmansOnStage.getStickman(name)).mBodyFX.mMaleColorRest = Color
                                        .web(bodycolor, bodyColorOpacity);
                                ((StickmanFX) sStickmansOnStage
                                        .getStickman(name)).mBodyFX.mColoropacityRest = bodyColorOpacity;
                            } else {
                                ((StickmanFX) sStickmansOnStage.getStickman(name)).mBodyFX.mFemaleColor = Color
                                        .web(bodycolor, bodyColorOpacity);
                                ((StickmanFX) sStickmansOnStage
                                        .getStickman(name)).mBodyFX.mColoropacity = bodyColorOpacity;
                                ((StickmanFX) sStickmansOnStage.getStickman(name)).update();
                                
                                ((StickmanFX) sStickmansOnStage.getStickman(name)).mBodyFX.mFemaleColorRest = Color
                                        .web(bodycolor, bodyColorOpacity);
                                ((StickmanFX) sStickmansOnStage
                                        .getStickman(name)).mBodyFX.mColoropacityRest = bodyColorOpacity;
                            }
                        };
                        StickmanStageFX.getInstance().runLater(bodyRunnable);
                    }

                    String haircolor = mStick.gethairColor();
                    float hairColorOpacity = mStick.gethairColorOpacity();
                    if ((haircolor != null)) {
                        Runnable hairColor = () -> {
                            if (((StickmanFX) sStickmansOnStage.getStickman(name)).mType == Gender.TYPE.MALE) {
                                ((StickmanFX) sStickmansOnStage.getStickman(name)).mMaleHairFX.mColor = Color
                                        .web(haircolor, hairColorOpacity);
                                ((StickmanFX) sStickmansOnStage
                                        .getStickman(name)).mMaleHairFX.mColoropacity = hairColorOpacity;
                                ((StickmanFX) sStickmansOnStage.getStickman(name)).update();
                                
                                ((StickmanFX) sStickmansOnStage.getStickman(name)).mMaleHairFX.mColorRest = Color
                                        .web(haircolor, hairColorOpacity);
                                ((StickmanFX) sStickmansOnStage
                                        .getStickman(name)).mMaleHairFX.mColoropacityRest = hairColorOpacity;
                            } else {
                                ((StickmanFX) sStickmansOnStage.getStickman(name)).mFemaleHairFX.mColor = Color
                                        .web(haircolor, hairColorOpacity);
                                ((StickmanFX) sStickmansOnStage
                                        .getStickman(name)).mFemaleHairFX.mColoropacity = hairColorOpacity;
                                ((StickmanFX) sStickmansOnStage.getStickman(name)).update();
                                
                                ((StickmanFX) sStickmansOnStage.getStickman(name)).mFemaleHairFX.mColorRest = Color
                                        .web(haircolor, hairColorOpacity);
                                ((StickmanFX) sStickmansOnStage
                                        .getStickman(name)).mFemaleHairFX.mColoropacityRest = hairColorOpacity;
                            }
                        };
                        StickmanStageFX.getInstance().runLater(hairColor);
                    }

                    String headcolor = mStick.getheadColor();
                    float headColorOpacity = mStick.getheadColorOpacity();
                    if (headcolor != null) {
                        Runnable headColor = () -> {
                            ((StickmanFX) sStickmansOnStage.getStickman(name)).mHeadFX.mColor = Color.web(headcolor,
                                    headColorOpacity);
                            ((StickmanFX) sStickmansOnStage.getStickman(name)).mHeadFX.mColoropacity = headColorOpacity;
                            if (((StickmanFX) sStickmansOnStage.getStickman(name)).mHeadFX.mColor != null) {
                                ((StickmanFX) sStickmansOnStage.getStickman(name)).update();
                            }
                            ((StickmanFX) sStickmansOnStage.getStickman(name)).mHeadFX.mColorRest = Color.web(headcolor,
                                    headColorOpacity);
                            ((StickmanFX) sStickmansOnStage.getStickman(name)).mHeadFX.mColoropacityRest = headColorOpacity;
                        };
                        StickmanStageFX.getInstance().runLater(headColor);
                    }

                    String limbscolor = mStick.getlimbsColor();
                    float limbsColorOpacity = mStick.getlimbsColorOpacity();
                    if (limbscolor != null) {
                        Runnable limbsColor = () -> {
                            ((StickmanFX) sStickmansOnStage.getStickman(name)).mLeftUpperLegFX.mColor = Color
                                    .web(limbscolor, limbsColorOpacity);
                            ((StickmanFX) sStickmansOnStage.getStickman(name)).mLeftForeLegFX.mColor = Color
                                    .web(limbscolor, limbsColorOpacity);
                            ((StickmanFX) sStickmansOnStage.getStickman(name)).mLeftFootFX.mColor = Color
                                    .web(limbscolor, limbsColorOpacity);
                            ((StickmanFX) sStickmansOnStage.getStickman(name)).mRightUpperLegFX.mColor = Color
                                    .web(limbscolor, limbsColorOpacity);
                            ((StickmanFX) sStickmansOnStage.getStickman(name)).mRightForeLegFX.mColor = Color
                                    .web(limbscolor, limbsColorOpacity);
                            ((StickmanFX) sStickmansOnStage.getStickman(name)).mRightFootFX.mColor = Color
                                    .web(limbscolor, limbsColorOpacity);
                            ((StickmanFX) sStickmansOnStage.getStickman(name)).mLeftHandFX.mColor = Color
                                    .web(limbscolor, limbsColorOpacity);
                            ((StickmanFX) sStickmansOnStage.getStickman(name)).mRightHandFX.mColor = Color
                                    .web(limbscolor, limbsColorOpacity);
                            ((StickmanFX) sStickmansOnStage.getStickman(name)).mLeftShoulderFX.mColor = Color
                                    .web(limbscolor, limbsColorOpacity);
                            ((StickmanFX) sStickmansOnStage.getStickman(name)).mRightShoulderFX.mColor = Color
                                    .web(limbscolor, limbsColorOpacity);
                            ((StickmanFX) sStickmansOnStage.getStickman(name)).mLeftUpperArmFX.mColor = Color
                                    .web(limbscolor, limbsColorOpacity);
                            ((StickmanFX) sStickmansOnStage.getStickman(name)).mLeftForeArmFX.mColor = Color
                                    .web(limbscolor, limbsColorOpacity);
                            ((StickmanFX) sStickmansOnStage.getStickman(name)).mRightUpperArmFX.mColor = Color
                                    .web(limbscolor, limbsColorOpacity);
                            ((StickmanFX) sStickmansOnStage.getStickman(name)).mRightForeArmFX.mColor = Color
                                    .web(limbscolor, limbsColorOpacity);
                            ((StickmanFX) sStickmansOnStage.getStickman(name)).mNeckFX.mColor = Color.web(limbscolor,
                                    limbsColorOpacity);
                            ((StickmanFX) sStickmansOnStage
                                    .getStickman(name)).mLeftUpperLegFX.mColoropacity = limbsColorOpacity;
                            ((StickmanFX) sStickmansOnStage.getStickman(name)).update();
                            
                            ((StickmanFX) sStickmansOnStage.getStickman(name)).mLeftUpperLegFX.mColorRest = Color
                                    .web(limbscolor, limbsColorOpacity);
                            ((StickmanFX) sStickmansOnStage
                                    .getStickman(name)).mLeftUpperLegFX.mColoropacityRest = limbsColorOpacity;                         
                        };
                        StickmanStageFX.getInstance().runLater(limbsColor);
                    }
                }
            }
        }
    }
}
