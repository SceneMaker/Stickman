package de.dfki.reeti.controllerhelper;

import de.dfki.common.Gender;
import de.dfki.reeti.Reeti;
import de.dfki.reeti.ReetiStageController;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class ColorHelper
{

    public static void leftLedColorChanger(ReetiStageController controller)
    {
        if (controller.currentReeti != null)
        {
            Color color = controller.leftLedColorPicker.getValue();
            controller.currentReeti.setLedColor(color, Reeti.LED.LEFTLED);
        }
    }

    public static void rightLedColorChanger(ReetiStageController controller)
    {
        if (controller.currentReeti != null)
        {
            Color color = controller.rightLedColorPicker.getValue();
            controller.currentReeti.setLedColor(color, Reeti.LED.RIGHTLED);
        }
    }
    
    public static void bothLedColorChanger(ReetiStageController controller)
    {
        if (controller.currentReeti != null)
        {
            Color color = controller.bothLedColorPicker.getValue();
            controller.currentReeti.setLedColor(color, Reeti.LED.BOTHLED);
        }
    }
}
