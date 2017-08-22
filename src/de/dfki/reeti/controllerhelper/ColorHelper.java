package de.dfki.reeti.controllerhelper;

import de.dfki.common.enums.Led;
import de.dfki.reeti.ReetiStageController;
import javafx.scene.paint.Color;

public class ColorHelper
{

    public static void leftLedColorChanger(ReetiStageController controller)
    {
        if (controller.currentReeti != null)
        {
            Color color = controller.leftLedColorPicker.getValue();
            controller.currentReeti.setLedColor(color, Led.LEFTLED);
        }
    }

    public static void rightLedColorChanger(ReetiStageController controller)
    {
        if (controller.currentReeti != null)
        {
            Color color = controller.rightLedColorPicker.getValue();
            controller.currentReeti.setLedColor(color, Led.RIGHTLED);
        }
    }

    public static void bothLedColorChanger(ReetiStageController controller)
    {
        if (controller.currentReeti != null)
        {
            Color color = controller.bothLedColorPicker.getValue();
            controller.currentReeti.setLedColor(color, Led.BOTHLED);
        }
    }
}
