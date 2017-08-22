package de.dfki.stickman3D.body;

import de.dfki.common.agent.Agent3D;
import de.dfki.common.util.Preferences;
import javafx.scene.paint.Color;

import java.net.URL;

/**
 * @author Beka Aptsiauri
 */
public class FemaleHair3D extends Hair3D
{


    public FemaleHair3D(Agent3D agent3D)
    {
        mColor = Color.rgb(240, 212, 0, 1);
        URL url = getClass().getClassLoader().getResource("BodyParts/Stickman3D/femaleHair.dae");

        initializeHair(url);
        this.getChildren().add(hairMeshView);
        agent3D.mHead.getChildren().add(this);
        init();
    }

    @Override
    public void init()
    {
        super.init();
        this.setTranslateX(Preferences.FEMALE_HAIR_X_POS);
        this.setTranslateY(Preferences.FEMALE_HAIR_Y_POS);
        this.setTranslateZ(Preferences.FEMALE_HAIR_Z_POS);
    }
}
