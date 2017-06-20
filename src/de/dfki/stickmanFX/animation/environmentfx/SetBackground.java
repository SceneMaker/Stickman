package de.dfki.stickmanFX.animation.environmentfx;

import de.dfki.stickmanFX.StickmanFX;
import de.dfki.stickmanFX.animationlogic.AnimationFX;
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

//    private static List<String> list = new ArrayList<String>() {
//        {
//            add("grassland");
//            add("office");
//            add("bully1");
//            add("bully2");
//            add("oldlivingroom");
//            add("oldkitchen");
//            add("door");
//            add("school");
//            add("road");
//            add("classroom");
//        }
//    };
    @Override
    public void playAnimation() {

        String sParameter = (String) mParameter;
        sParameter = sParameter.trim();
//        sParameter = sParameter.replace("\\", "\\\\");
        sParameter = sParameter.replace("\\", "/");
        String mStageIdentifier = mStickmanFX.getStageController().getStageIdentifier();
        HBox mStickmanPane;
        try {
            mStickmanPane = mStickmanFX.getStageController().getStickmanStage()
                    .getStickmanBox(mStageIdentifier);

            //Upload the picture
//            if (list.contains(sParameter)) {
            if (sParameter.contains(".")) {
//                mStickmanPane.setStyle("-fx-background-image: url('/de/dfki/stickmanFX/image/" + sParameter + ".jpg');"
//                        + "-fx-background-repeat: no-repeat;-fx-background-position: center center; -fx-background-size: contain;-fx-background-size:cover;");
//                contain;-fx-background-size:cover; auto
                mStickmanPane.setStyle("-fx-background-image: url('" + "file:///" + sParameter + "');"
                        + "-fx-background-repeat: no-repeat;-fx-background-position: center center; -fx-background-size: contain;-fx-background-size:cover;");
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
