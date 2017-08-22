package de.dfki.stickman3D.body;

import de.dfki.common.part.Part3D;
import de.dfki.common.util.Preferences;
import javafx.scene.shape.*;

/**
 * @author Beka Aptsiauri
 */
public class LeftEye3D extends Eye
{
    public LeftEye3D(Part3D head)
    {
        super(head);
        mStart = mHead.getLeftEyePosition();

        this.setTranslateX(mStart.x);
        this.setTranslateY(mStart.y);
        this.setTranslateZ(Preferences.FACE_PARTS_Z_POS);
        mHead.getChildren().add(this);

        init();
    }

    @Override
    public void setShape(String s)
    {
        mShape = SHAPE.valueOf(s);
    }

    @Override
    public void resetShape()
    {
        mShape = LeftEye3D.SHAPE.DEFAULT;
    }

    @Override
    public void calculate(int step)
    {

        float xMovement;
        float yMovement;

        switch (mShape)
        {
            case DEFAULT:
                if (step == 20 || step == 0)
                {
                    createDefaultEye();
                }
                break;

            case FADEIN:
                executeFadeInFadeOut(null, SHAPE.FADEIN, step);
                break;

            case FADEOUT:
                executeFadeInFadeOut(null, SHAPE.FADEOUT, step);
                break;
            case BLINK:
                borderYSize += 0.0450;
                bigPupileYSize += 0.050;
                smallPupileYSize += 0.050;

                if (borderYSize > 0.8550001)
                {
                    borderYSize = 0.8550001f;
                }
                if (bigPupileYSize > 0.9500000000000003)
                {
                    bigPupileYSize = 0.9500000000000003;
                }
                if (smallPupileYSize > 0.9500000000000003)
                {
                    smallPupileYSize = 0.9500000000000003;
                }

                border.setScaleY(1 - borderYSize);
                bigPupile.setScaleY(1 - bigPupileYSize);
                smallPupile.setScaleY(1 - smallPupileYSize);
                break;
            case BLINKEND:
                borderYSize -= 0.0450;
                bigPupileYSize -= 0.050;
                smallPupileYSize -= 0.050;

                if (step == 2)
                {
                    createDefaultEye();
                } else
                {
                    border.setScaleY(1 - borderYSize);
                    bigPupile.setScaleY(1 - bigPupileYSize);
                    smallPupile.setScaleY(1 - smallPupileYSize);
                }
                break;
            case LOOKLEFT:
                xMovement = 0.131f;
                yMovement = 0.184f;

                bigPupile.setTranslateX(bigPupile.getTranslateX() + xMovement);
                smallPupile.setTranslateX(smallPupile.getTranslateX() + yMovement);
                break;

            case LOOKLEFTEND:
                xMovement = -0.131f;
                yMovement = -0.182f;

                if (step == 2)
                {
                    createDefaultEye();
                } else
                {
                    bigPupile.setTranslateX(bigPupile.getTranslateX() + xMovement);
                    smallPupile.setTranslateX(smallPupile.getTranslateX() + yMovement);
                }
                break;

            case LOOKRIGHT:
                xMovement = 0.131f;
                yMovement = 0.184f;

                bigPupile.setTranslateX(bigPupile.getTranslateX() - xMovement);
                smallPupile.setTranslateX(smallPupile.getTranslateX() - yMovement);
                break;

            case LOOKRIGHTEND:
                xMovement = -0.131f;
                yMovement = -0.184f;

                if (step == 2)
                {
                    createDefaultEye();
                } else
                {
                    bigPupile.setTranslateX(bigPupile.getTranslateX() - xMovement);
                    smallPupile.setTranslateX(smallPupile.getTranslateX() - yMovement);
                }
                break;

            case LOOKDOWN:
                xMovement = 0.100f;
                yMovement = 0.184f;

                bigPupile.setTranslateY(bigPupile.getTranslateY() + xMovement);
                smallPupile.setTranslateY(smallPupile.getTranslateY() + yMovement);
                break;

            case LOOKDOWNEND:
                xMovement = -0.100f;
                yMovement = -0.184f;

                if (step == 2)
                {
                    createDefaultEye();
                } else
                {
                    bigPupile.setTranslateY(bigPupile.getTranslateY() + xMovement);
                    smallPupile.setTranslateY(smallPupile.getTranslateY() + yMovement);
                }
                break;

            case LOOKUP:
                xMovement = -0.100f;
                yMovement = -0.184f;

                bigPupile.setTranslateY(bigPupile.getTranslateY() + xMovement);
                smallPupile.setTranslateY(smallPupile.getTranslateY() + yMovement);
                break;

            case LOOKUPEND:
                xMovement = 0.100f;
                yMovement = 0.184f;

                if (step == 2)
                {
                    createDefaultEye();
                } else
                {
                    bigPupile.setTranslateY(bigPupile.getTranslateY() + xMovement);
                    smallPupile.setTranslateY(smallPupile.getTranslateY() + yMovement);
                }
                break;
            case ANGRY:
                if (step == 20)
                {
                    createDefaultEye();
                }
                borderYSize += 0.0210;
                bigPupileYSize += 0.010;

                border.setScaleY(1 - borderYSize);
                bigPupile.setScaleY(1 - bigPupileYSize);
                break;

            case ANGRYEND:
                borderYSize -= 0.0210f;
                bigPupileYSize -= 0.010;

                if (step == 2)
                {
                    createDefaultEye();
                } else
                {
                    border.setScaleY(1 - borderYSize);
                    bigPupile.setScaleY(1 - bigPupileYSize);
                }
                break;

            case SURPRISED:
                if (step == 20)
                {
                    createDefaultEye();
                }
                borderYSize -= 0.0158;
                border.setScaleY(1 - borderYSize);
                break;

            case SURPRISEDEND:
                borderYSize += 0.0158;

                if (step == 2)
                {
                    createDefaultEye();
                } else
                {
                    border.setScaleY(1 - borderYSize);
                }
                break;

            case HAPPY:
                if (step == 20)
                {
                    createDefaultEye();
                }
                borderYSize += 0.0105;
                borderXSize += 0.0052;
                border.setScaleY(1 - borderYSize);
                border.setScaleX(1 + borderXSize);
                break;

            case HAPPYEND:
                borderYSize -= 0.0105;
                borderXSize -= 0.0052;

                if (step == 2)
                {
                    createDefaultEye();
                } else
                {
                    border.setScaleY(1 - borderYSize);
                    border.setScaleX(1 + borderXSize);
                }
                break;

            case DISGUSTED:
                if (step == 20)
                {
                    createDefaultEye();
                }
                borderYSize += 0.0105;

                QuadCurveTo quadCurve_1 = (QuadCurveTo) border.getElements().get(1);
                quadCurve_1.setY(quadCurve_1.getY() + 0.105);
                border.getElements().set(1, quadCurve_1);

                border.setScaleY(1 - borderYSize);
                break;

            case DISGUSTEDEND:
                borderYSize -= 0.0105;

                if (step == 2)
                {
                    createDefaultEye();
                } else
                {
                    quadCurve_1 = (QuadCurveTo) border.getElements().get(1);
                    quadCurve_1.setY(quadCurve_1.getY() - 0.105);
                    border.getElements().set(1, quadCurve_1);

                    border.setScaleY(1 - borderYSize);
                }
                break;

            case CONTEMPT:
                if (step == 20)
                {
                    createDefaultEye();
                }
                // NOTE: marjvena tvalze araferi ar gaaketo datove carieli
                borderYSize += 0.0105;
                borderXSize += 0.0052;
                border.setScaleY(1 - borderYSize);
                border.setScaleX(1 + borderXSize);
                break;

            case CONTEMPTEND:
                borderYSize -= 0.0105;
                borderXSize -= 0.0052;

                if (step == 2)
                {
                    createDefaultEye();
                } else
                {
                    border.setScaleY(1 - borderYSize);
                    border.setScaleX(1 + borderXSize);
                }
                break;

            case EXCITED:
                if (step == 20)
                {
                    createDefaultEye();
                }
                borderYSize -= 0.0105;
                borderXSize -= 0.0052;
                border.setScaleY(1 - borderYSize);
                border.setScaleX(1 + borderXSize);
                break;

            case EXCITEDEND:
                borderYSize += 0.0105;
                borderXSize += 0.0052;

                if (step == 2)
                {
                    createDefaultEye();
                } else
                {
                    border.setScaleY(1 - borderYSize);
                    border.setScaleX(1 + borderXSize);
                }
                break;

            case EMBARRASSED:
                if (step == 20)
                {
                    createDefaultEye();
                }
                xMovement = 0.100f;
                yMovement = 0.184f;

                bigPupile.setTranslateY(bigPupile.getTranslateY() + xMovement); // LOOKDOWN
                smallPupile.setTranslateY(smallPupile.getTranslateY() + yMovement);
                break;

            case EMBARRASSEDEND:
                xMovement = -0.100f;
                yMovement = -0.184f;

                if (step == 2)
                {
                    createDefaultEye();
                } else
                {
                    bigPupile.setTranslateY(bigPupile.getTranslateY() + xMovement);
                    smallPupile.setTranslateY(smallPupile.getTranslateY() + yMovement);
                }
                break;

        }
    }

    public void update()
    {
        bigPupile.setFill(mColor);
    }

    protected void recordColor()
    {
        if (!mHead.getStickman().setCharacterInvisible)
        {
            mColorRecorder = mColor;
        }
    }
}
