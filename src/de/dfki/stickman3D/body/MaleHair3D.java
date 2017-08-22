package de.dfki.stickman3D.body;

import de.dfki.common.agent.Agent3D;
import de.dfki.common.util.Preferences;
import javafx.scene.paint.Color;

import java.net.URL;

/**
 * @author Beka Aptsiauri
 */
public class MaleHair3D extends Hair3D
{

    public MaleHair3D(Agent3D agent3D)
    {
        mColor = Color.rgb(97, 58, 0, 1);
        URL url = getClass().getClassLoader().getResource("BodyParts/Stickman3D/maleHair.dae");

        initializeHair(url);
        this.getChildren().add(hairMeshView);
        agent3D.mHead.getChildren().add(this);
        init();
    }

    @Override
    public void init()
    {
        super.init();
        this.setTranslateX(Preferences.MALE_HAIR_X_POS);
        this.setTranslateY(Preferences.MALE_HAIR_Y_POS);
        this.setTranslateZ(Preferences.MALE_HAIR_Z_POS);
    }
}
