package de.dfki.stickman3D.utils;

import de.dfki.common.AgentsOnStage;
import de.dfki.common.enums.Gender;
import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.stage.StickmanStage3D;
import de.dfki.stickman3D.stage.StickmansOnStage3D;
import de.dfki.stickman3D.xmlsettings.StickmanData3D;
import javafx.scene.paint.Color;

import java.io.File;
import java.util.List;

//import de.dfki.stickmanFX.stage.StickmanStageFX;
//import de.dfki.stickmanFX.stage.StickmansOnStageFX;
//import de.dfki.stickmanFX.StickmanFX;

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
            file = new File(mFilePath + File.separator + "stickman3d" + File.separator + "stickman3d.xml");
        }

        if (file != null)
        {
            sStickmansOnStage.getXmlTransform().loadStickmanDataFromFile(file);
        }
    }

    public void initialStickmanWithXml()
    {
        readXML();
        List<StickmanData3D> mStickmanData3D = ((StickmansOnStage3D) sStickmansOnStage).getXmlTransform()
                .getStickmanData3DList();
        if (!(mStickmanData3D.isEmpty()))
        {
            for (StickmanData3D mStick : mStickmanData3D)
            {
                String name = mStick.getName();
                if (sStickmansOnStage.getAgentNames().contains(name.toLowerCase()))
                {
                    String bodycolor = mStick.getbodyColor().substring(0, 7);
                    String sbodycolorOpacity = mStick.getbodyColor().substring(7, 9);
                    double dbodycolorOpacity = (double) (Integer.valueOf(sbodycolorOpacity, 16)) / 100;
                    if (bodycolor != null)
                    {
                        Runnable bodyRunnable = () ->
                        {
                            ((Stickman3D) sStickmansOnStage.getAgent(name)).mUpperBody.mColor = Color.web(bodycolor, dbodycolorOpacity);
                            ((Stickman3D) sStickmansOnStage.getAgent(name)).mUpperBody.update();
                        };
                        StickmanStage3D.getInstance().runLater(bodyRunnable);
                    }

                    String haircolor = mStick.gethairColor().substring(0, 7);
                    String shaircolorOpacity = mStick.gethairColor().substring(7, 9);
                    double dhaircolorOpacity = (double) (Integer.valueOf(shaircolorOpacity, 16)) / 100;
                    if ((haircolor != null))
                    {
                        Runnable hairColor = () ->
                        {
                            if (((Stickman3D) sStickmansOnStage.getAgent(name)).mType == Gender.TYPE.MALE)
                            {
                                ((Stickman3D) sStickmansOnStage.getAgent(name)).mHair.mColor = Color.web(haircolor, dhaircolorOpacity);
                                ((Stickman3D) sStickmansOnStage.getAgent(name)).mHair.update();
                            } else
                            {
                                ((Stickman3D) sStickmansOnStage.getAgent(name)).mHair.mColor = Color.web(haircolor, dhaircolorOpacity);
                                ((Stickman3D) sStickmansOnStage.getAgent(name)).mHair.update();
                            }
                        };
                        StickmanStage3D.getInstance().runLater(hairColor);
                    }
//
                    String headcolor = mStick.getheadColor().substring(0, 7);
                    String sheadcolorOpacity = mStick.getheadColor().substring(7, 9);
                    double dheadcolorOpacity = (double) (Integer.valueOf(sheadcolorOpacity, 16)) / 100;
                    if (headcolor != null)
                    {
                        Runnable headColor = () ->
                        {
                            ((Stickman3D) sStickmansOnStage.getAgent(name)).mHead.mColor = Color.web(headcolor, dheadcolorOpacity);
                            if (((Stickman3D) sStickmansOnStage.getAgent(name)).mHead.mColor != null)
                            {
                                ((Stickman3D) sStickmansOnStage.getAgent(name)).mHead.update();
                            }
                        };
                        StickmanStage3D.getInstance().runLater(headColor);
                    }

                    String shoescolor = mStick.getshoesColor().substring(0, 7);
                    String sshoescolorOpacity = mStick.getshoesColor().substring(7, 9);
                    double dshoescolorOpacity = (double) (Integer.valueOf(sshoescolorOpacity, 16)) / 100;
                    if (shoescolor != null)
                    {
                        Runnable shoesColor = () ->
                        {
                            ((Stickman3D) sStickmansOnStage.getAgent(name)).mLeftFoot.mColor = Color.web(shoescolor, dshoescolorOpacity);
                            ((Stickman3D) sStickmansOnStage.getAgent(name)).mRightFoot.mColor = Color.web(shoescolor, dshoescolorOpacity);
                            ((Stickman3D) sStickmansOnStage.getAgent(name)).mLeftFoot.update();
                            ((Stickman3D) sStickmansOnStage.getAgent(name)).mRightFoot.update();
                        };
                        StickmanStage3D.getInstance().runLater(shoesColor);
                    }

                    String lipscolor = mStick.getlipsColor().substring(0, 7);
                    String slipscolorOpacity = mStick.getlipsColor().substring(7, 9);
                    double dlipscolorOpacity = (double) (Integer.valueOf(slipscolorOpacity, 16)) / 100;
                    if (lipscolor != null)
                    {
                        Runnable lipsColor = () ->
                        {
                            ((Stickman3D) sStickmansOnStage.getAgent(name)).mMouth.mColor = Color.web(lipscolor, dlipscolorOpacity);
                            ((Stickman3D) sStickmansOnStage.getAgent(name)).mMouth.update();
                        };
                        StickmanStage3D.getInstance().runLater(lipsColor);
                    }

                    String eyescolor = mStick.geteyesColor().substring(0, 7);
                    String seyescolorOpacity = mStick.geteyesColor().substring(7, 9);
                    double deyescolorOpacity = (double) (Integer.valueOf(seyescolorOpacity, 16)) / 100;
                    if (eyescolor != null)
                    {
                        Runnable eyesColor = () ->
                        {
                            ((Stickman3D) sStickmansOnStage.getAgent(name)).mLeftEye.mColor = Color.web(eyescolor, deyescolorOpacity);
                            ((Stickman3D) sStickmansOnStage.getAgent(name)).mRightEye.mColor = Color.web(eyescolor, deyescolorOpacity);
                            ((Stickman3D) sStickmansOnStage.getAgent(name)).mLeftEye.update();
                            ((Stickman3D) sStickmansOnStage.getAgent(name)).mRightEye.update();
                        };
                        StickmanStage3D.getInstance().runLater(eyesColor);
                    }

                    String browscolor = mStick.getbrowsColor().substring(0, 7);
                    String sbrowscolorOpacity = mStick.getbrowsColor().substring(7, 9);
                    double dbrowscolorOpacity = (double) (Integer.valueOf(sbrowscolorOpacity, 16)) / 100;
                    if (browscolor != null)
                    {
                        Runnable browsColor = () ->
                        {
                            ((Stickman3D) sStickmansOnStage.getAgent(name)).mLeftEyebrow.mColor = Color.web(browscolor, dbrowscolorOpacity);
                            ((Stickman3D) sStickmansOnStage.getAgent(name)).mRightEyebrow.mColor = Color.web(browscolor, dbrowscolorOpacity);
                            ((Stickman3D) sStickmansOnStage.getAgent(name)).mLeftEyebrow.update();
                            ((Stickman3D) sStickmansOnStage.getAgent(name)).mRightEyebrow.update();
                        };
                        StickmanStage3D.getInstance().runLater(browsColor);
                    }

                    String nosecolor = mStick.getnoseColor().substring(0, 7);
                    String snosecolorOpacity = mStick.getnoseColor().substring(7, 9);
                    double dnosecolorOpacity = (double) (Integer.valueOf(snosecolorOpacity, 16)) / 100;
                    if (nosecolor != null)
                    {
                        Runnable noseColor = () ->
                        {
                            ((Stickman3D) sStickmansOnStage.getAgent(name)).mNose.mColor = Color.web(nosecolor, dnosecolorOpacity);
                            ((Stickman3D) sStickmansOnStage.getAgent(name)).mNose.update();
                        };
                        StickmanStage3D.getInstance().runLater(noseColor);
                    }

                    String limbscolor = mStick.getlimbsColor().substring(0, 7);
                    String slimbscolorOpacity = mStick.getlimbsColor().substring(7, 9);
                    double dlimbscolorOpacity = (double) (Integer.valueOf(slimbscolorOpacity, 16)) / 100;
                    if (limbscolor != null)
                    {
                        Runnable limbsColor = () ->
                        {
                            ((Stickman3D) sStickmansOnStage.getAgent(name)).mLeftUpperLeg.mColor = Color.web(limbscolor, dlimbscolorOpacity);
                            ((Stickman3D) sStickmansOnStage.getAgent(name)).mNeck.mColor = Color.web(limbscolor, dlimbscolorOpacity);
                            ((Stickman3D) sStickmansOnStage.getAgent(name)).mLeftUpperArm.mColor = Color.web(limbscolor, dlimbscolorOpacity);
                            ((Stickman3D) sStickmansOnStage.getAgent(name)).mLeftForeArm.mColor = Color.web(limbscolor, dlimbscolorOpacity);
                            ((Stickman3D) sStickmansOnStage.getAgent(name)).mLeftWrist.mColor = Color.web(limbscolor, dlimbscolorOpacity);
                            ((Stickman3D) sStickmansOnStage.getAgent(name)).mLeftFinger1.mColor = Color.web(limbscolor, dlimbscolorOpacity);
                            ((Stickman3D) sStickmansOnStage.getAgent(name)).mLeftFinger2.mColor = Color.web(limbscolor, dlimbscolorOpacity);
                            ((Stickman3D) sStickmansOnStage.getAgent(name)).mLeftFinger3.mColor = Color.web(limbscolor, dlimbscolorOpacity);
                            ((Stickman3D) sStickmansOnStage.getAgent(name)).mLeftFinger4.mColor = Color.web(limbscolor, dlimbscolorOpacity);
                            ((Stickman3D) sStickmansOnStage.getAgent(name)).mLeftUpperLeg.mColor = Color.web(limbscolor, dlimbscolorOpacity);
                            ((Stickman3D) sStickmansOnStage.getAgent(name)).mLeftForeLeg.mColor = Color.web(limbscolor, dlimbscolorOpacity);
                            ((Stickman3D) sStickmansOnStage.getAgent(name)).mRightUpperArm.mColor = Color.web(limbscolor, dlimbscolorOpacity);
                            ((Stickman3D) sStickmansOnStage.getAgent(name)).mRightForeArm.mColor = Color.web(limbscolor, dlimbscolorOpacity);
                            ((Stickman3D) sStickmansOnStage.getAgent(name)).mRightWrist.mColor = Color.web(limbscolor, dlimbscolorOpacity);
                            ((Stickman3D) sStickmansOnStage.getAgent(name)).mRightFinger1.mColor = Color.web(limbscolor, dlimbscolorOpacity);
                            ((Stickman3D) sStickmansOnStage.getAgent(name)).mRightFinger2.mColor = Color.web(limbscolor, dlimbscolorOpacity);
                            ((Stickman3D) sStickmansOnStage.getAgent(name)).mRightFinger3.mColor = Color.web(limbscolor, dlimbscolorOpacity);
                            ((Stickman3D) sStickmansOnStage.getAgent(name)).mRightFinger4.mColor = Color.web(limbscolor, dlimbscolorOpacity);
                            ((Stickman3D) sStickmansOnStage.getAgent(name)).mRightUpperLeg.mColor = Color.web(limbscolor, dlimbscolorOpacity);
                            ((Stickman3D) sStickmansOnStage.getAgent(name)).mRightForeLeg.mColor = Color.web(limbscolor, dlimbscolorOpacity);

                            ((Stickman3D) sStickmansOnStage.getAgent(name)).mNeck.update();
                            ((Stickman3D) sStickmansOnStage.getAgent(name)).mLeftUpperArm.update();
                            ((Stickman3D) sStickmansOnStage.getAgent(name)).mLeftForeArm.update();
                            ((Stickman3D) sStickmansOnStage.getAgent(name)).mLeftWrist.update();
                            ((Stickman3D) sStickmansOnStage.getAgent(name)).mLeftFinger1.update();
                            ((Stickman3D) sStickmansOnStage.getAgent(name)).mLeftFinger2.update();
                            ((Stickman3D) sStickmansOnStage.getAgent(name)).mLeftFinger3.update();
                            ((Stickman3D) sStickmansOnStage.getAgent(name)).mLeftFinger4.update();
                            ((Stickman3D) sStickmansOnStage.getAgent(name)).mLeftUpperLeg.update();
                            ((Stickman3D) sStickmansOnStage.getAgent(name)).mLeftForeLeg.update();

                            ((Stickman3D) sStickmansOnStage.getAgent(name)).mRightUpperArm.update();
                            ((Stickman3D) sStickmansOnStage.getAgent(name)).mRightForeArm.update();
                            ((Stickman3D) sStickmansOnStage.getAgent(name)).mRightWrist.update();
                            ((Stickman3D) sStickmansOnStage.getAgent(name)).mRightFinger1.update();
                            ((Stickman3D) sStickmansOnStage.getAgent(name)).mRightFinger2.update();
                            ((Stickman3D) sStickmansOnStage.getAgent(name)).mRightFinger3.update();
                            ((Stickman3D) sStickmansOnStage.getAgent(name)).mRightFinger4.update();
                            ((Stickman3D) sStickmansOnStage.getAgent(name)).mRightUpperLeg.update();
                            ((Stickman3D) sStickmansOnStage.getAgent(name)).mRightForeLeg.update();
                        };
                        StickmanStage3D.getInstance().runLater(limbsColor);
                    }
                    if (mStick.getbackgroundRecord() != null)
                    {
                        Stickman3D.sbackground = mStick.getbackgroundRecord();
                    } else
                    {
                        Stickman3D.sbackground = null;
                    }

                }
            }
        }
    }
}

