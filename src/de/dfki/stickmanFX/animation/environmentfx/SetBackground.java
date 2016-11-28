package de.dfki.stickmanFX.animation.environmentfx;

import de.dfki.stickmanFX.StickmanFX;
import de.dfki.stickmanFX.animationlogic.AnimationFX;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

/**
 *
 * @author Robbie
 *
 * Set background for Stickman3D
 */
public class SetBackground extends AnimationFX {

    public SetBackground(StickmanFX sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    private static List<String> list = new ArrayList<String>() {
        {
            add("grassland");
            add("office");
        }
    };

    @Override
    public void playAnimation() {

        String sParameter = (String) mParameter;
        sParameter = sParameter.toLowerCase().trim();
        String mStageIdentifier = mStickmanFX.getStickmanStageController().getStageIdentifier();
        HBox mStickmanPane;
        try {
            mStickmanPane = mStickmanFX.getStickmanStageController().getStickmanStage()
                    .getStickmanPane(mStageIdentifier);


            //Upload the picture
            if (list.contains(sParameter)) {
                mStickmanPane.setStyle("-fx-background-image: url('/de/dfki/stickmanFX/image/" + sParameter + ".jpg');"
                        + "-fx-background-repeat: repeat;-fx-background-position: center center; -fx-background-size: contain;");
            } else {
                // change the color of the background
                Color theColor = Color.valueOf(sParameter);
                String hex = toHexCode(theColor);
                mStickmanPane.setStyle("-fx-background-color: " + hex + ";");
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //convert color to hex
    private String toHexCode(Color color) {
        return String.format("#%02X%02X%02X",
                (int) (color.getRed() * 255),
                (int) (color.getGreen() * 255),
                (int) (color.getBlue() * 255));
    }
}
