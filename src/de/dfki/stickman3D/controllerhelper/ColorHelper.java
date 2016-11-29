package de.dfki.stickman3D.controllerhelper;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.input.MouseEvent;

public class ColorHelper {
	public static void headColorChanger(Stickman3D currentStickman, ColorPicker headColorPicker) {
		if (currentStickman != null) {
			currentStickman.mHeadFX.mColor = headColorPicker.getValue();
			currentStickman.mHeadFX.update();
		}
	}

	public static void hairColorChanger(Stickman3D currentStickman, ColorPicker hairColorPicker) {
		if (currentStickman != null) {
			if (currentStickman.mType == Stickman3D.TYPE.MALE) {
				currentStickman.mMaleHairFX.mColor = hairColorPicker.getValue();
				currentStickman.mMaleHairFX.update();
			} else {
				currentStickman.mFemaleHairFX.mColor = hairColorPicker.getValue();
				currentStickman.mFemaleHairFX.update();
			}
		}
	}

	public static void bodyColorChanger(Stickman3D currentStickman, ColorPicker bodyColorPicker) {
		if (currentStickman != null) {
			currentStickman.mUpperBody.mColor = bodyColorPicker.getValue();
			currentStickman.mUpperBody.update();
		}
	}

	public static void limbsColorChanger(Stickman3D currentStickman, ColorPicker limbsColorPicker) {
		if (currentStickman != null) {
			currentStickman.mNeckFX.mColor = limbsColorPicker.getValue();
			currentStickman.mLeftUpperArmFX.mColor = limbsColorPicker.getValue();
			currentStickman.mLeftForeArmFX.mColor = limbsColorPicker.getValue();
			currentStickman.mLeftWrist.mColor = limbsColorPicker.getValue();
			currentStickman.mLeftFinger1.mColor = limbsColorPicker.getValue();
			currentStickman.mLeftFinger2.mColor = limbsColorPicker.getValue();
			currentStickman.mLeftFinger3.mColor = limbsColorPicker.getValue();
			currentStickman.mLeftFinger4.mColor = limbsColorPicker.getValue();
			currentStickman.mLeftUpperLegFX.mColor = limbsColorPicker.getValue();
			currentStickman.mLeftForeLegFX.mColor = limbsColorPicker.getValue();

			currentStickman.mRightUpperArmFX.mColor = limbsColorPicker.getValue();
			currentStickman.mRightForeArmFX.mColor = limbsColorPicker.getValue();
			currentStickman.mRightWrist.mColor = limbsColorPicker.getValue();
			currentStickman.mRightFinger1.mColor = limbsColorPicker.getValue();
			currentStickman.mRightFinger2.mColor = limbsColorPicker.getValue();
			currentStickman.mRightFinger3.mColor = limbsColorPicker.getValue();
			currentStickman.mRightFinger4.mColor = limbsColorPicker.getValue();
			currentStickman.mRightUpperLegFX.mColor = limbsColorPicker.getValue();
			currentStickman.mRightForeLegFX.mColor = limbsColorPicker.getValue();

			currentStickman.mNeckFX.update();
			currentStickman.mLeftUpperArmFX.update();
			currentStickman.mLeftForeArmFX.update();
			currentStickman.mLeftWrist.update();
			currentStickman.mLeftFinger1.update();
			currentStickman.mLeftFinger2.update();
			currentStickman.mLeftFinger3.update();
			currentStickman.mLeftFinger4.update();
			currentStickman.mLeftUpperLegFX.update();
			currentStickman.mLeftForeLegFX.update();

			currentStickman.mRightUpperArmFX.update();
			currentStickman.mRightForeArmFX.update();
			currentStickman.mRightWrist.update();
			currentStickman.mRightFinger1.update();
			currentStickman.mRightFinger2.update();
			currentStickman.mRightFinger3.update();
			currentStickman.mRightFinger4.update();
			currentStickman.mRightUpperLegFX.update();
			currentStickman.mRightForeLegFX.update();
		}
	}

	public static void shoesColorChanger(Stickman3D currentStickman, ColorPicker shoesColorPicker) {
		if (currentStickman != null) {
			currentStickman.mLeftFootFX.mColor = shoesColorPicker.getValue();
			currentStickman.mRightFootFX.mColor = shoesColorPicker.getValue();
			currentStickman.mLeftFootFX.update();
			currentStickman.mRightFootFX.update();
		}
	}

	public static void lipsColorChanger(Stickman3D currentStickman, ColorPicker lipsColorPicker) {
		if (currentStickman != null) {
			currentStickman.mMouthFX.mColor = lipsColorPicker.getValue();
			currentStickman.mMouthFX.update();
		}
	}

	public static void eyeColorChanger(Stickman3D currentStickman, ColorPicker eyeColorPicker) {
		if (currentStickman != null) {
			currentStickman.mLeftEyeFX.mColor = eyeColorPicker.getValue();
			currentStickman.mRightEyeFX.mColor = eyeColorPicker.getValue();
			currentStickman.mLeftEyeFX.update();
			currentStickman.mRightEyeFX.update();
		}
	}

	public static void browColorChanger(Stickman3D currentStickman, ColorPicker browColorPicker) {
		if (currentStickman != null) {
			currentStickman.mLeftEyebrowFX.mColor = browColorPicker.getValue();
			currentStickman.mRightEyebrowFX.mColor = browColorPicker.getValue();
			currentStickman.mLeftEyebrowFX.update();
			currentStickman.mRightEyebrowFX.update();
		}
	}
	
	public static void noseColorChanger(Stickman3D currentStickman, ColorPicker noseColorPicker) {
		if (currentStickman != null) {
			currentStickman.mNoseFX.mColor = noseColorPicker.getValue();
			currentStickman.mNoseFX.update();
		}
	}

	public static void handleHeadColorButtons(Stickman3D currentStickman, MouseEvent ev, Button headColorBrighter,
			Button headColorDarker, Button headColorReset) {
		if (currentStickman != null) {
			if (ev.getSource().equals(headColorBrighter)) {
				currentStickman.mHeadFX.mColor = currentStickman.mHeadFX.mColor.brighter();
				currentStickman.mHeadFX.update();
			} else if (ev.getSource().equals(headColorDarker)) {
				currentStickman.mHeadFX.mColor = currentStickman.mHeadFX.mColor.darker();
				currentStickman.mHeadFX.update();
			} else if (ev.getSource().equals(headColorReset)) {
				currentStickman.mHeadFX.mColor = currentStickman.mHeadFX.mColorRecorder;
				currentStickman.mHeadFX.update();
			}
		}
	}

	public static void handleHairColorButtons(Stickman3D currentStickman, MouseEvent ev, Button hairColorBrighter,
			Button hairColorDarker, Button hairColorReset) {

		if (currentStickman != null) {
			if (ev.getSource().equals(hairColorBrighter)) {
				if (currentStickman.mType == Stickman3D.TYPE.MALE) {
					currentStickman.mMaleHairFX.mColor = currentStickman.mMaleHairFX.mColor.brighter();
					currentStickman.mMaleHairFX.update();
				} else {
					currentStickman.mFemaleHairFX.mColor = currentStickman.mFemaleHairFX.mColor.brighter();
					currentStickman.mFemaleHairFX.update();
				}
			} else if (ev.getSource().equals(hairColorDarker)) {
				if (currentStickman.mType == Stickman3D.TYPE.MALE) {
					currentStickman.mMaleHairFX.mColor = currentStickman.mMaleHairFX.mColor.darker();
					currentStickman.mMaleHairFX.update();
				} else {
					currentStickman.mFemaleHairFX.mColor = currentStickman.mFemaleHairFX.mColor.darker();
					currentStickman.mFemaleHairFX.update();
				}
			} else if (ev.getSource().equals(hairColorReset)) {
				if (currentStickman.mType == Stickman3D.TYPE.MALE) {
					currentStickman.mMaleHairFX.mColor = currentStickman.mMaleHairFX.mColorRecorder;
					currentStickman.mMaleHairFX.update();
				} else {
					currentStickman.mFemaleHairFX.mColor = currentStickman.mFemaleHairFX.mColorRecorder;
					currentStickman.mFemaleHairFX.update();
				}
			}
		}
	}

	public static void handleBodyColorButtons(Stickman3D currentStickman, MouseEvent ev, Button bodyColorBrighter,
			Button bodyColorDarker, Button bodyColorReset) {
		if (currentStickman != null) {
			if (ev.getSource().equals(bodyColorBrighter)) {
				currentStickman.mUpperBody.mColor = currentStickman.mUpperBody.mColor.brighter();
				currentStickman.mUpperBody.update();
			} else if (ev.getSource().equals(bodyColorDarker)) {
				currentStickman.mUpperBody.mColor = currentStickman.mUpperBody.mColor.darker();
				currentStickman.mUpperBody.update();
			} else if (ev.getSource().equals(bodyColorReset)) {
				currentStickman.mUpperBody.mColor = currentStickman.mUpperBody.mColorRecorder;
				currentStickman.mUpperBody.update();
			}
		}
	}

	public static void handlelimbsColorButtons(Stickman3D currentStickman, MouseEvent ev, Button limbsColorBrighter,
			Button limbsColorDarker, Button limbsColorReset) {
		if (currentStickman != null) {
			if (ev.getSource().equals(limbsColorBrighter)) {
				currentStickman.mNeckFX.mColor = currentStickman.mNeckFX.mColor.brighter();
				currentStickman.mLeftUpperArmFX.mColor = currentStickman.mLeftUpperArmFX.mColor.brighter();
				currentStickman.mLeftForeArmFX.mColor = currentStickman.mLeftForeArmFX.mColor.brighter();
				currentStickman.mLeftWrist.mColor = currentStickman.mLeftWrist.mColor.brighter();
				currentStickman.mLeftFinger1.mColor = currentStickman.mLeftFinger1.mColor.brighter();
				currentStickman.mLeftFinger2.mColor = currentStickman.mLeftFinger2.mColor.brighter();
				currentStickman.mLeftFinger3.mColor = currentStickman.mLeftFinger3.mColor.brighter();
				currentStickman.mLeftFinger4.mColor = currentStickman.mLeftFinger4.mColor.brighter();
				currentStickman.mLeftUpperLegFX.mColor = currentStickman.mLeftUpperLegFX.mColor.brighter();
				currentStickman.mLeftForeLegFX.mColor = currentStickman.mLeftForeLegFX.mColor.brighter();

				currentStickman.mRightUpperArmFX.mColor = currentStickman.mRightUpperArmFX.mColor.brighter();
				currentStickman.mRightForeArmFX.mColor = currentStickman.mRightForeArmFX.mColor.brighter();
				currentStickman.mRightWrist.mColor = currentStickman.mRightWrist.mColor.brighter();
				currentStickman.mRightFinger1.mColor = currentStickman.mRightFinger1.mColor.brighter();
				currentStickman.mRightFinger2.mColor = currentStickman.mRightFinger2.mColor.brighter();
				currentStickman.mRightFinger3.mColor = currentStickman.mRightFinger3.mColor.brighter();
				currentStickman.mRightFinger4.mColor = currentStickman.mRightFinger4.mColor.brighter();
				currentStickman.mRightUpperLegFX.mColor = currentStickman.mRightUpperLegFX.mColor.brighter();
				currentStickman.mRightForeLegFX.mColor = currentStickman.mRightForeLegFX.mColor.brighter();

				currentStickman.mNeckFX.update();
				currentStickman.mLeftUpperArmFX.update();
				currentStickman.mLeftForeArmFX.update();
				currentStickman.mLeftWrist.update();
				currentStickman.mLeftFinger1.update();
				currentStickman.mLeftFinger2.update();
				currentStickman.mLeftFinger3.update();
				currentStickman.mLeftFinger4.update();
				currentStickman.mLeftUpperLegFX.update();
				currentStickman.mLeftForeLegFX.update();

				currentStickman.mRightUpperArmFX.update();
				currentStickman.mRightForeArmFX.update();
				currentStickman.mRightWrist.update();
				currentStickman.mRightFinger1.update();
				currentStickman.mRightFinger2.update();
				currentStickman.mRightFinger3.update();
				currentStickman.mRightFinger4.update();
				currentStickman.mRightUpperLegFX.update();
				currentStickman.mRightForeLegFX.update();
			} else if (ev.getSource().equals(limbsColorDarker)) {
				currentStickman.mNeckFX.mColor = currentStickman.mNeckFX.mColor.darker();
				currentStickman.mLeftUpperArmFX.mColor = currentStickman.mLeftUpperArmFX.mColor.darker();
				currentStickman.mLeftForeArmFX.mColor = currentStickman.mLeftForeArmFX.mColor.darker();
				currentStickman.mLeftWrist.mColor = currentStickman.mLeftWrist.mColor.darker();
				currentStickman.mLeftFinger1.mColor = currentStickman.mLeftFinger1.mColor.darker();
				currentStickman.mLeftFinger2.mColor = currentStickman.mLeftFinger2.mColor.darker();
				currentStickman.mLeftFinger3.mColor = currentStickman.mLeftFinger3.mColor.darker();
				currentStickman.mLeftFinger4.mColor = currentStickman.mLeftFinger4.mColor.darker();
				currentStickman.mLeftUpperLegFX.mColor = currentStickman.mLeftUpperLegFX.mColor.darker();
				currentStickman.mLeftForeLegFX.mColor = currentStickman.mLeftForeLegFX.mColor.darker();

				currentStickman.mRightUpperArmFX.mColor = currentStickman.mRightUpperArmFX.mColor.darker();
				currentStickman.mRightForeArmFX.mColor = currentStickman.mRightForeArmFX.mColor.darker();
				currentStickman.mRightWrist.mColor = currentStickman.mRightWrist.mColor.darker();
				currentStickman.mRightFinger1.mColor = currentStickman.mRightFinger1.mColor.darker();
				currentStickman.mRightFinger2.mColor = currentStickman.mRightFinger2.mColor.darker();
				currentStickman.mRightFinger3.mColor = currentStickman.mRightFinger3.mColor.darker();
				currentStickman.mRightFinger4.mColor = currentStickman.mRightFinger4.mColor.darker();
				currentStickman.mRightUpperLegFX.mColor = currentStickman.mRightUpperLegFX.mColor.darker();
				currentStickman.mRightForeLegFX.mColor = currentStickman.mRightForeLegFX.mColor.darker();

				currentStickman.mNeckFX.update();
				currentStickman.mLeftUpperArmFX.update();
				currentStickman.mLeftForeArmFX.update();
				currentStickman.mLeftWrist.update();
				currentStickman.mLeftFinger1.update();
				currentStickman.mLeftFinger2.update();
				currentStickman.mLeftFinger3.update();
				currentStickman.mLeftFinger4.update();
				currentStickman.mLeftUpperLegFX.update();
				currentStickman.mLeftForeLegFX.update();

				currentStickman.mRightUpperArmFX.update();
				currentStickman.mRightForeArmFX.update();
				currentStickman.mRightWrist.update();
				currentStickman.mRightFinger1.update();
				currentStickman.mRightFinger2.update();
				currentStickman.mRightFinger3.update();
				currentStickman.mRightFinger4.update();
				currentStickman.mRightUpperLegFX.update();
				currentStickman.mRightForeLegFX.update();
			} else if (ev.getSource().equals(limbsColorReset)) {
				currentStickman.mNeckFX.mColor = currentStickman.mNeckFX.mColorRecorder;
				currentStickman.mLeftUpperArmFX.mColor = currentStickman.mLeftUpperArmFX.mColorRecorder;
				currentStickman.mLeftForeArmFX.mColor = currentStickman.mLeftForeArmFX.mColorRecorder;
				currentStickman.mLeftWrist.mColor = currentStickman.mLeftWrist.mColorRecorder;
				currentStickman.mLeftFinger1.mColor = currentStickman.mLeftFinger1.mColorRecorder;
				currentStickman.mLeftFinger2.mColor = currentStickman.mLeftFinger2.mColorRecorder;
				currentStickman.mLeftFinger3.mColor = currentStickman.mLeftFinger3.mColorRecorder;
				currentStickman.mLeftFinger4.mColor = currentStickman.mLeftFinger4.mColorRecorder;
				currentStickman.mLeftUpperLegFX.mColor = currentStickman.mLeftUpperLegFX.mColorRecorder;
				currentStickman.mLeftForeLegFX.mColor = currentStickman.mLeftForeLegFX.mColorRecorder;

				currentStickman.mRightUpperArmFX.mColor = currentStickman.mRightUpperArmFX.mColorRecorder;
				currentStickman.mRightForeArmFX.mColor = currentStickman.mRightForeArmFX.mColorRecorder;
				currentStickman.mRightWrist.mColor = currentStickman.mRightWrist.mColorRecorder;
				currentStickman.mRightFinger1.mColor = currentStickman.mRightFinger1.mColorRecorder;
				currentStickman.mRightFinger2.mColor = currentStickman.mRightFinger2.mColorRecorder;
				currentStickman.mRightFinger3.mColor = currentStickman.mRightFinger3.mColorRecorder;
				currentStickman.mRightFinger4.mColor = currentStickman.mRightFinger4.mColorRecorder;
				currentStickman.mRightUpperLegFX.mColor = currentStickman.mRightUpperLegFX.mColorRecorder;
				currentStickman.mRightForeLegFX.mColor = currentStickman.mRightForeLegFX.mColorRecorder;

				currentStickman.mNeckFX.update();
				currentStickman.mLeftUpperArmFX.update();
				currentStickman.mLeftForeArmFX.update();
				currentStickman.mLeftWrist.update();
				currentStickman.mLeftFinger1.update();
				currentStickman.mLeftFinger2.update();
				currentStickman.mLeftFinger3.update();
				currentStickman.mLeftFinger4.update();
				currentStickman.mLeftUpperLegFX.update();
				currentStickman.mLeftForeLegFX.update();

				currentStickman.mRightUpperArmFX.update();
				currentStickman.mRightForeArmFX.update();
				currentStickman.mRightWrist.update();
				currentStickman.mRightFinger1.update();
				currentStickman.mRightFinger2.update();
				currentStickman.mRightFinger3.update();
				currentStickman.mRightFinger4.update();
				currentStickman.mRightUpperLegFX.update();
				currentStickman.mRightForeLegFX.update();
			}
		}
	}

	public static void handleShoesColorButtons(Stickman3D currentStickman, MouseEvent ev, Button shoesColorBrighter,
			Button shoesColorDarker, Button shoesColorReset) {
		if (currentStickman != null) {
			if (ev.getSource().equals(shoesColorBrighter)) {
				currentStickman.mLeftFootFX.mColor = currentStickman.mLeftFootFX.mColor.brighter();
				currentStickman.mRightFootFX.mColor = currentStickman.mRightFootFX.mColor.brighter();
				currentStickman.mLeftFootFX.update();
				currentStickman.mRightFootFX.update();
			} else if (ev.getSource().equals(shoesColorDarker)) {
				currentStickman.mLeftFootFX.mColor = currentStickman.mLeftFootFX.mColor.darker();
				currentStickman.mRightFootFX.mColor = currentStickman.mRightFootFX.mColor.darker();
				currentStickman.mLeftFootFX.update();
				currentStickman.mRightFootFX.update();
			} else if (ev.getSource().equals(shoesColorReset)) {
				currentStickman.mLeftFootFX.mColor = currentStickman.mLeftFootFX.mColorRecorder;
				currentStickman.mRightFootFX.mColor = currentStickman.mRightFootFX.mColorRecorder;
				currentStickman.mLeftFootFX.update();
				currentStickman.mRightFootFX.update();
			}
		}
	}

	public static void handleLipsColorButtons(Stickman3D currentStickman, MouseEvent ev, Button lipsColorBrighter,
			Button lipsColorDarker, Button lipsColorReset) {
		if (currentStickman != null) {
			if (ev.getSource().equals(lipsColorBrighter)) {
				currentStickman.mMouthFX.mColor = currentStickman.mMouthFX.mColor.brighter();
				currentStickman.mMouthFX.update();
			} else if (ev.getSource().equals(lipsColorDarker)) {
				currentStickman.mMouthFX.mColor = currentStickman.mMouthFX.mColor.darker();
				currentStickman.mMouthFX.update();
			} else if (ev.getSource().equals(lipsColorReset)) {
				currentStickman.mMouthFX.mColor = currentStickman.mMouthFX.mColorRecorder;
				currentStickman.mMouthFX.update();
			}
		}
	}

	public static void handleEyeColorButtons(Stickman3D currentStickman, MouseEvent ev, Button eyeColorBrighter,
			Button eyeColorDarker, Button eyeColorReset) {
		if (currentStickman != null) {
			if (ev.getSource().equals(eyeColorBrighter)) {
				currentStickman.mLeftEyeFX.mColor = currentStickman.mLeftEyeFX.mColor.brighter();
				currentStickman.mRightEyeFX.mColor = currentStickman.mRightEyeFX.mColor.brighter();
				currentStickman.mLeftEyeFX.update();
				currentStickman.mRightEyeFX.update();
			} else if (ev.getSource().equals(eyeColorDarker)) {
				currentStickman.mLeftEyeFX.mColor = currentStickman.mLeftEyeFX.mColor.darker();
				currentStickman.mRightEyeFX.mColor = currentStickman.mRightEyeFX.mColor.darker();
				currentStickman.mLeftEyeFX.update();
				currentStickman.mRightEyeFX.update();
			} else if (ev.getSource().equals(eyeColorReset)) {
				currentStickman.mLeftEyeFX.mColor = currentStickman.mLeftEyeFX.mColorRecorder;
				currentStickman.mRightEyeFX.mColor = currentStickman.mRightEyeFX.mColorRecorder;
				currentStickman.mLeftEyeFX.update();
				currentStickman.mRightEyeFX.update();
			}
		}
	}

	public static void handleBrowColorButtons(Stickman3D currentStickman, MouseEvent ev, Button browColorBrighter,
			Button browColorDarker, Button browColorReset) {
		if (currentStickman != null) {
			if (ev.getSource().equals(browColorBrighter)) {
				currentStickman.mLeftEyebrowFX.mColor = currentStickman.mLeftEyebrowFX.mColor.brighter();
				currentStickman.mRightEyebrowFX.mColor = currentStickman.mRightEyebrowFX.mColor.brighter();
				currentStickman.mLeftEyebrowFX.update();
				currentStickman.mRightEyebrowFX.update();
			} else if (ev.getSource().equals(browColorDarker)) {
				currentStickman.mLeftEyebrowFX.mColor = currentStickman.mLeftEyebrowFX.mColor.darker();
				currentStickman.mRightEyebrowFX.mColor = currentStickman.mRightEyebrowFX.mColor.darker();
				currentStickman.mLeftEyebrowFX.update();
				currentStickman.mRightEyebrowFX.update();
			} else if (ev.getSource().equals(browColorReset)) {
				currentStickman.mLeftEyebrowFX.mColor = currentStickman.mLeftEyebrowFX.mColorRecorder;
				currentStickman.mRightEyebrowFX.mColor = currentStickman.mRightEyebrowFX.mColorRecorder;
				currentStickman.mLeftEyebrowFX.update();
				currentStickman.mRightEyebrowFX.update();
			}
		}
	}
	
	public static void handleNoseColorButtons(Stickman3D currentStickman, MouseEvent ev, Button noseColorBrighter,
			Button noseColorDarker, Button noseColorReset) {
		if (currentStickman != null) {
			if (ev.getSource().equals(noseColorBrighter)) {
				currentStickman.mNoseFX.mColor = currentStickman.mNoseFX.mColor.brighter();
				currentStickman.mNoseFX.update();
			} else if (ev.getSource().equals(noseColorDarker)) {
				currentStickman.mNoseFX.mColor = currentStickman.mNoseFX.mColor.darker();
				currentStickman.mNoseFX.update();
			} else if (ev.getSource().equals(noseColorReset)) {
				currentStickman.mNoseFX.mColor = currentStickman.mNoseFX.mColorRecorder;
				currentStickman.mNoseFX.update();
			}
		}
	}
}
