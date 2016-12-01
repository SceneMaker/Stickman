package de.dfki.stickmanFX.utils;

import de.dfki.common.Gender;
import de.dfki.common.StickmansOnStage;
import de.dfki.stickmanFX.xmlsettings.StickmanDataFX;
import de.dfki.util.HandleColor;
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

    public XmlStickmanLoader( StickmansOnStage stickmansOnStage){
        this.sStickmansOnStage = stickmansOnStage;
        mFilePath = stickmansOnStage.getmFilePath();
    }

    private void readXML()
    {
        File file = null;
        if(mFilePath != null)
            file = new File(mFilePath + File.separator + "stickmanfx"+ File.separator+"stickmanfx.xml");

        if (file != null) {
            sStickmansOnStage.getmXmlTransform().loadStickmanDataFromFile(file);
        }
    }

    public   void initialStickmanWithXml()
    {
        /*
        readXML();
        List<StickmanDataFX> mStickmanDataFX = sStickmansOnStage.getmXmlTransform().getStickmanDataFXList();
        if(!(mStickmanDataFX.isEmpty()))
        {
            for(StickmanDataFX mStick : mStickmanDataFX)
            {
                String name = mStick.getName();
                if (sStickmansOnStage.getStickmanNames().contains(name.toLowerCase())){
                    String bodycolor = mStick.getbodyColor();
                    if(bodycolor != null)
                    {

                        Runnable bodyRunnable = () -> {
                            if(((Stickman3D)sStickmansOnStage.getStickman(name)).mType == Gender.TYPE.MALE)
                            {
                                ((Stickman3D)sStickmansOnStage.getStickman(name)).mBodyFX.mMaleColor = HandleColor.switchColor(bodycolor);
                                ((Stickman3D)sStickmansOnStage.getStickman(name)).update();
                            }
                            else
                            {
                                ((Stickman3D)sStickmansOnStage.getStickman(name)).mBodyFX.mFemaleColor = HandleColor.switchColor(bodycolor);
                                ((Stickman3D)sStickmansOnStage.getStickman(name)).update();
                            }
                        };
                        StickmanStageFX.getInstance().runLater(bodyRunnable);
                    }

                    String haircolor = mStick.gethairColor();
                    if((haircolor != null))
                    {
                        Runnable hairColor = () ->
                        {
                            if(((Stickman3D)sStickmansOnStage.getStickman(name)).mType == Gender.TYPE.MALE)
                            {
                                ((Stickman3D)sStickmansOnStage.getStickman(name)).mMaleHairFX.mColor = HandleColor.switchColor(haircolor);
                                ((Stickman3D)sStickmansOnStage.getStickman(name)).update();
                            }
                            else
                            {
                                ((Stickman3D)sStickmansOnStage.getStickman(name)).mFemaleHairFX.mColor = HandleColor.switchColor(haircolor);
                                ((Stickman3D)sStickmansOnStage.getStickman(name)).update();
                            }
                        };
                        StickmanStageFX.getInstance().runLater(hairColor);
                    }

                    String headcolor = mStick.getheadColor();
                    if(headcolor != null)
                    {
                        Runnable headColor =() ->
                        {
                            ((Stickman3D)sStickmansOnStage.getStickman(name)).mHeadFX.mColor = HandleColor.switchColor(headcolor);
                            if(((Stickman3D)sStickmansOnStage.getStickman(name)).mHeadFX.mColor != null)
                                ((Stickman3D)sStickmansOnStage.getStickman(name)).update();
                        };
                        StickmanStageFX.getInstance().runLater(headColor);
                    }

                    String limbscolor = mStick.getlimbsColor();
                    if(limbscolor != null)
                    {
                        Runnable limbsColor = () ->
                        {
                            ((Stickman3D)sStickmansOnStage.getStickman(name)).mLeftUpperLegFX.mColor = HandleColor.switchColor(limbscolor);
                            ((Stickman3D)sStickmansOnStage.getStickman(name)).mLeftForeLegFX.mColor = HandleColor.switchColor(limbscolor);
                            ((Stickman3D)sStickmansOnStage.getStickman(name)).mLeftFootFX.mColor = HandleColor.switchColor(limbscolor);
                            ((Stickman3D)sStickmansOnStage.getStickman(name)).mRightUpperLegFX.mColor = HandleColor.switchColor(limbscolor);
                            ((Stickman3D)sStickmansOnStage.getStickman(name)).mRightForeLegFX.mColor = HandleColor.switchColor(limbscolor);
                            ((Stickman3D)sStickmansOnStage.getStickman(name)).mRightFootFX.mColor = HandleColor.switchColor(limbscolor);
                            ((Stickman3D)sStickmansOnStage.getStickman(name)).mLeftHandFX.mColor = HandleColor.switchColor(limbscolor);
                            ((Stickman3D)sStickmansOnStage.getStickman(name)).mRightHandFX.mColor = HandleColor.switchColor(limbscolor);
                            ((Stickman3D)sStickmansOnStage.getStickman(name)).mLeftShoulderFX.mColor = HandleColor.switchColor(limbscolor);
                            ((Stickman3D)sStickmansOnStage.getStickman(name)).mRightShoulderFX.mColor = HandleColor.switchColor(limbscolor);
                            ((Stickman3D)sStickmansOnStage.getStickman(name)).mLeftUpperArmFX.mColor = HandleColor.switchColor(limbscolor);
                            ((Stickman3D)sStickmansOnStage.getStickman(name)).mLeftForeArmFX.mColor = HandleColor.switchColor(limbscolor);
                            ((Stickman3D)sStickmansOnStage.getStickman(name)).mRightUpperArmFX.mColor = HandleColor.switchColor(limbscolor);
                            ((Stickman3D)sStickmansOnStage.getStickman(name)).mRightForeArmFX.mColor = HandleColor.switchColor(limbscolor);
                            ((Stickman3D)sStickmansOnStage.getStickman(name)).mNeckFX.mColor = HandleColor.switchColor(limbscolor);
                            ((Stickman3D)sStickmansOnStage.getStickman(name)).update();
                        };
                        StickmanStageFX.getInstance().runLater(limbsColor);
                    }
                }
            }
        }*/
	
	readXML();
        List<StickmanDataFX> mStickmanDataFX = ((StickmansOnStageFX)sStickmansOnStage).getmXmlTransform().getStickmanDataFXList();
        if(!(mStickmanDataFX.isEmpty()))
        {
            for(StickmanDataFX mStick : mStickmanDataFX)
            {
                String name = mStick.getName();
                if (sStickmansOnStage.getStickmanNames().contains(name.toLowerCase())){
                    String bodycolor = mStick.getbodyColor();
                    if(bodycolor != null)
                    {

                        Runnable bodyRunnable = () -> {
                            if(((StickmanFX)sStickmansOnStage.getStickman(name)).mType == Gender.TYPE.MALE)
                            {
                                ((StickmanFX)sStickmansOnStage.getStickman(name)).mBodyFX.mMaleColor = HandleColor.switchColor(bodycolor);
                                ((StickmanFX)sStickmansOnStage.getStickman(name)).update();
                            }
                            else
                            {
                                ((StickmanFX)sStickmansOnStage.getStickman(name)).mBodyFX.mFemaleColor = HandleColor.switchColor(bodycolor);
                                ((StickmanFX)sStickmansOnStage.getStickman(name)).update();
                            }
                        };
                        StickmanStageFX.getInstance().runLater(bodyRunnable);
                    }

                    String haircolor = mStick.gethairColor();
                    if((haircolor != null))
                    {
                        Runnable hairColor = () ->
                        {
                            if(((StickmanFX)sStickmansOnStage.getStickman(name)).mType == Gender.TYPE.MALE)
                            {
                                ((StickmanFX)sStickmansOnStage.getStickman(name)).mMaleHairFX.mColor = HandleColor.switchColor(haircolor);
                                ((StickmanFX)sStickmansOnStage.getStickman(name)).update();
                            }
                            else
                            {
                                ((StickmanFX)sStickmansOnStage.getStickman(name)).mFemaleHairFX.mColor = HandleColor.switchColor(haircolor);
                                ((StickmanFX)sStickmansOnStage.getStickman(name)).update();
                            }
                        };
                        StickmanStageFX.getInstance().runLater(hairColor);
                    }

                    String headcolor = mStick.getheadColor();
                    if(headcolor != null)
                    {
                        Runnable headColor =() ->
                        {
                            ((StickmanFX)sStickmansOnStage.getStickman(name)).mHeadFX.mColor = HandleColor.switchColor(headcolor);
                            if(((StickmanFX)sStickmansOnStage.getStickman(name)).mHeadFX.mColor != null)
                                ((StickmanFX)sStickmansOnStage.getStickman(name)).update();
                        };
                        StickmanStageFX.getInstance().runLater(headColor);
                    }

                    String limbscolor = mStick.getlimbsColor();
                    if(limbscolor != null)
                    {
                        Runnable limbsColor = () ->
                        {
                            ((StickmanFX)sStickmansOnStage.getStickman(name)).mLeftUpperLegFX.mColor = HandleColor.switchColor(limbscolor);
                            ((StickmanFX)sStickmansOnStage.getStickman(name)).mLeftForeLegFX.mColor = HandleColor.switchColor(limbscolor);
                            ((StickmanFX)sStickmansOnStage.getStickman(name)).mLeftFootFX.mColor = HandleColor.switchColor(limbscolor);
                            ((StickmanFX)sStickmansOnStage.getStickman(name)).mRightUpperLegFX.mColor = HandleColor.switchColor(limbscolor);
                            ((StickmanFX)sStickmansOnStage.getStickman(name)).mRightForeLegFX.mColor = HandleColor.switchColor(limbscolor);
                            ((StickmanFX)sStickmansOnStage.getStickman(name)).mRightFootFX.mColor = HandleColor.switchColor(limbscolor);
                            ((StickmanFX)sStickmansOnStage.getStickman(name)).mLeftHandFX.mColor = HandleColor.switchColor(limbscolor);
                            ((StickmanFX)sStickmansOnStage.getStickman(name)).mRightHandFX.mColor = HandleColor.switchColor(limbscolor);
                            ((StickmanFX)sStickmansOnStage.getStickman(name)).mLeftShoulderFX.mColor = HandleColor.switchColor(limbscolor);
                            ((StickmanFX)sStickmansOnStage.getStickman(name)).mRightShoulderFX.mColor = HandleColor.switchColor(limbscolor);
                            ((StickmanFX)sStickmansOnStage.getStickman(name)).mLeftUpperArmFX.mColor = HandleColor.switchColor(limbscolor);
                            ((StickmanFX)sStickmansOnStage.getStickman(name)).mLeftForeArmFX.mColor = HandleColor.switchColor(limbscolor);
                            ((StickmanFX)sStickmansOnStage.getStickman(name)).mRightUpperArmFX.mColor = HandleColor.switchColor(limbscolor);
                            ((StickmanFX)sStickmansOnStage.getStickman(name)).mRightForeArmFX.mColor = HandleColor.switchColor(limbscolor);
                            ((StickmanFX)sStickmansOnStage.getStickman(name)).mNeckFX.mColor = HandleColor.switchColor(limbscolor);
                            ((StickmanFX)sStickmansOnStage.getStickman(name)).update();
                        };
                        StickmanStageFX.getInstance().runLater(limbsColor);
                    }
                }
            }
        }
    }
}
