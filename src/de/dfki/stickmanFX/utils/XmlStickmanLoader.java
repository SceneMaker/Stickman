package de.dfki.stickmanFX.utils;

import de.dfki.common.AgentsOnStage;
import de.dfki.common.enums.Gender;
import de.dfki.stickmanFX.StickmanFX;
import de.dfki.stickmanFX.stage.StickmanStageFX;
import de.dfki.stickmanFX.stage.StickmansOnStageFX;
import de.dfki.stickmanFX.xmlsettings.StickmanDataFX;
import javafx.scene.paint.Color;

import java.io.File;
import java.util.List;

/**
 * Created by alvaro on 10/9/16.
 */
public class XmlStickmanLoader
{

    private String mFilePath;
    private AgentsOnStage sStickmansOnStage;

    public XmlStickmanLoader(AgentsOnStage stickmansOnStage)
    {
        this.sStickmansOnStage = stickmansOnStage;
        mFilePath = stickmansOnStage.getFilePath();
    }

    private void readXML()
    {
        File file = null;
        if (mFilePath != null)
        {
            file = new File(mFilePath + File.separator + "stickmanfx" + File.separator + "stickmanfx.xml");
        }

        if (file != null)
        {
            sStickmansOnStage.getXmlTransform().loadStickmanDataFromFile(file);
        }
    }

    public void initialStickmanWithXml()
    {
        readXML();
        List<StickmanDataFX> mStickmanDataFX = ((StickmansOnStageFX) sStickmansOnStage).getXmlTransform()
                .getStickmanDataFXList();
        if (!(mStickmanDataFX.isEmpty()))
        {
            for (StickmanDataFX mStick : mStickmanDataFX)
            {
                String name = mStick.getName();
                if (sStickmansOnStage.getAgentNames().contains(name.toLowerCase()))
                {
                    String bodycolor = mStick.getbodyColor();
                    float bodyColorOpacity = mStick.getbodyColorOpacity();
                    if (bodycolor != null)
                    {
                        Runnable bodyRunnable = () ->
                        {
                            if (((StickmanFX) sStickmansOnStage.getAgent(name)).mType == Gender.TYPE.MALE)
                            {
                                ((StickmanFX) sStickmansOnStage.getAgent(name)).mBodyFX.mMaleColor = Color
                                        .web(bodycolor, bodyColorOpacity);
                                ((StickmanFX) sStickmansOnStage
                                        .getAgent(name)).mBodyFX.mColoropacity = bodyColorOpacity;
                                ((StickmanFX) sStickmansOnStage.getAgent(name)).update();

                                ((StickmanFX) sStickmansOnStage.getAgent(name)).mBodyFX.mMaleColorRest = Color
                                        .web(bodycolor, bodyColorOpacity);
                                ((StickmanFX) sStickmansOnStage
                                        .getAgent(name)).mBodyFX.mColoropacityRest = bodyColorOpacity;
                            } else
                            {
                                ((StickmanFX) sStickmansOnStage.getAgent(name)).mBodyFX.mFemaleColor = Color
                                        .web(bodycolor, bodyColorOpacity);
                                ((StickmanFX) sStickmansOnStage
                                        .getAgent(name)).mBodyFX.mColoropacity = bodyColorOpacity;
                                ((StickmanFX) sStickmansOnStage.getAgent(name)).update();

                                ((StickmanFX) sStickmansOnStage.getAgent(name)).mBodyFX.mFemaleColorRest = Color
                                        .web(bodycolor, bodyColorOpacity);
                                ((StickmanFX) sStickmansOnStage
                                        .getAgent(name)).mBodyFX.mColoropacityRest = bodyColorOpacity;
                            }
                        };
                        StickmanStageFX.getInstance().runLater(bodyRunnable);
                    }

                    String haircolor = mStick.gethairColor();
                    float hairColorOpacity = mStick.gethairColorOpacity();
                    if ((haircolor != null))
                    {
                        Runnable hairColor = () ->
                        {
                            if (((StickmanFX) sStickmansOnStage.getAgent(name)).mType == Gender.TYPE.MALE)
                            {
                                ((StickmanFX) sStickmansOnStage.getAgent(name)).mMaleHairFX.mColor = Color
                                        .web(haircolor, hairColorOpacity);
                                ((StickmanFX) sStickmansOnStage
                                        .getAgent(name)).mMaleHairFX.mColoropacity = hairColorOpacity;
                                ((StickmanFX) sStickmansOnStage.getAgent(name)).update();

                                ((StickmanFX) sStickmansOnStage.getAgent(name)).mMaleHairFX.mColorRest = Color
                                        .web(haircolor, hairColorOpacity);
                                ((StickmanFX) sStickmansOnStage
                                        .getAgent(name)).mMaleHairFX.mColoropacityRest = hairColorOpacity;
                            } else
                            {
                                ((StickmanFX) sStickmansOnStage.getAgent(name)).mFemaleHairFX.mColor = Color
                                        .web(haircolor, hairColorOpacity);
                                ((StickmanFX) sStickmansOnStage
                                        .getAgent(name)).mFemaleHairFX.mColoropacity = hairColorOpacity;
                                ((StickmanFX) sStickmansOnStage.getAgent(name)).update();

                                ((StickmanFX) sStickmansOnStage.getAgent(name)).mFemaleHairFX.mColorRest = Color
                                        .web(haircolor, hairColorOpacity);
                                ((StickmanFX) sStickmansOnStage
                                        .getAgent(name)).mFemaleHairFX.mColoropacityRest = hairColorOpacity;
                            }
                        };
                        StickmanStageFX.getInstance().runLater(hairColor);
                    }

                    String headcolor = mStick.getheadColor();
                    float headColorOpacity = mStick.getheadColorOpacity();
                    if (headcolor != null)
                    {
                        Runnable headColor = () ->
                        {
                            ((StickmanFX) sStickmansOnStage.getAgent(name)).mHeadFX.mColor = Color.web(headcolor,
                                    headColorOpacity);
                            ((StickmanFX) sStickmansOnStage.getAgent(name)).mHeadFX.mColoropacity = headColorOpacity;
                            if (((StickmanFX) sStickmansOnStage.getAgent(name)).mHeadFX.mColor != null)
                            {
                                ((StickmanFX) sStickmansOnStage.getAgent(name)).update();
                            }
                            ((StickmanFX) sStickmansOnStage.getAgent(name)).mHeadFX.mColorRest = Color.web(headcolor,
                                    headColorOpacity);
                            ((StickmanFX) sStickmansOnStage.getAgent(name)).mHeadFX.mColoropacityRest = headColorOpacity;
                        };
                        StickmanStageFX.getInstance().runLater(headColor);
                    }

                    String limbscolor = mStick.getlimbsColor();
                    float limbsColorOpacity = mStick.getlimbsColorOpacity();
                    if (limbscolor != null)
                    {
                        Runnable limbsColor = () ->
                        {
                            ((StickmanFX) sStickmansOnStage.getAgent(name)).mLeftUpperLegFX.mColor = Color
                                    .web(limbscolor, limbsColorOpacity);
                            ((StickmanFX) sStickmansOnStage.getAgent(name)).mLeftForeLegFX.mColor = Color
                                    .web(limbscolor, limbsColorOpacity);
                            ((StickmanFX) sStickmansOnStage.getAgent(name)).mLeftFootFX.mColor = Color
                                    .web(limbscolor, limbsColorOpacity);
                            ((StickmanFX) sStickmansOnStage.getAgent(name)).mRightUpperLegFX.mColor = Color
                                    .web(limbscolor, limbsColorOpacity);
                            ((StickmanFX) sStickmansOnStage.getAgent(name)).mRightForeLegFX.mColor = Color
                                    .web(limbscolor, limbsColorOpacity);
                            ((StickmanFX) sStickmansOnStage.getAgent(name)).mRightFootFX.mColor = Color
                                    .web(limbscolor, limbsColorOpacity);
                            ((StickmanFX) sStickmansOnStage.getAgent(name)).mLeftHandFX.mColor = Color
                                    .web(limbscolor, limbsColorOpacity);
                            ((StickmanFX) sStickmansOnStage.getAgent(name)).mRightHandFX.mColor = Color
                                    .web(limbscolor, limbsColorOpacity);
                            ((StickmanFX) sStickmansOnStage.getAgent(name)).mLeftShoulderFX.mColor = Color
                                    .web(limbscolor, limbsColorOpacity);
                            ((StickmanFX) sStickmansOnStage.getAgent(name)).mRightShoulderFX.mColor = Color
                                    .web(limbscolor, limbsColorOpacity);
                            ((StickmanFX) sStickmansOnStage.getAgent(name)).mLeftUpperArmFX.mColor = Color
                                    .web(limbscolor, limbsColorOpacity);
                            ((StickmanFX) sStickmansOnStage.getAgent(name)).mLeftForeArmFX.mColor = Color
                                    .web(limbscolor, limbsColorOpacity);
                            ((StickmanFX) sStickmansOnStage.getAgent(name)).mRightUpperArmFX.mColor = Color
                                    .web(limbscolor, limbsColorOpacity);
                            ((StickmanFX) sStickmansOnStage.getAgent(name)).mRightForeArmFX.mColor = Color
                                    .web(limbscolor, limbsColorOpacity);
                            ((StickmanFX) sStickmansOnStage.getAgent(name)).mNeckFX.mColor = Color.web(limbscolor,
                                    limbsColorOpacity);
                            ((StickmanFX) sStickmansOnStage
                                    .getAgent(name)).mLeftUpperLegFX.mColoropacity = limbsColorOpacity;
                            ((StickmanFX) sStickmansOnStage.getAgent(name)).update();

                            ((StickmanFX) sStickmansOnStage.getAgent(name)).mLeftUpperLegFX.mColorRest = Color
                                    .web(limbscolor, limbsColorOpacity);
                            ((StickmanFX) sStickmansOnStage
                                    .getAgent(name)).mLeftUpperLegFX.mColoropacityRest = limbsColorOpacity;
                        };
                        StickmanStageFX.getInstance().runLater(limbsColor);
                    }
                }
            }
        }
    }
}
