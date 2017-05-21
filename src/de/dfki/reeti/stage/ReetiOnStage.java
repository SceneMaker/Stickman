package de.dfki.reeti.stage;

import de.dfki.common.Gender;
import de.dfki.common.interfaces.StageRoom;
import de.dfki.common.interfaces.Stickman;
import de.dfki.common.StickmansOnStage;
import de.dfki.common.XmlTransform;
import de.dfki.common.interfaces.StickmanStage;
import de.dfki.reeti.Reeti;
import de.dfki.stickmanSwing.StickmanSwing;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.layout.HBox;

/**
 * Created by alvaro on 9/19/16.
 */
public class ReetiOnStage extends StickmansOnStage {

    private String identifier;

    public ReetiOnStage(StickmanStage stickmanStage) {
        super(stickmanStage);
    }

    public ReetiOnStage(StickmanStage stickmanStageFX, StageRoom controllerFX) {
        super(stickmanStageFX, controllerFX);
    }

    public ReetiOnStage(StickmanStage stickmanStageFX, StageRoom controllerFX, String identifier) {
        super(stickmanStageFX, controllerFX);
        this.identifier = identifier;
    }

    @Override
    protected void addStickmanToStage(String name, boolean fullScreen, Gender.TYPE gender) {
        if (fullScreen) {
            Stickman stickman = new Reeti(name, gender, stickmanStage.getFullScreenScale(), stickmanStage.getFullScreenDimension());
            putFullStickmanOnStage(name, stickman);
        } else {

            createNonFullStickman(name, gender, DEFAULT_SCALE);
        }
    }

    @Override
    protected void addStickmanToStage(String name, boolean fullScreen, Gender.TYPE gender, boolean onlyFace) {
        if (fullScreen) {
            Stickman stickman = new Reeti(name, gender, stickmanStage.getFullScreenScale(), stickmanStage.getFullScreenDimension());
            putFullStickmanOnStage(name, stickman);
        } else {
            float scale = DEFAULT_SCALE;
            if (onlyFace) {
                scale = 1.0f;
            }
            createNonFullStickman(name, gender, scale);

        }
    }

    private void createNonFullStickman(String name, Gender.TYPE gender, float scale) {
        if (!identifier.equals("")) {
            try {
                HBox h = stickmanStage.getStickmanBox(identifier);

                Stickman stickman = new Reeti(name, gender, scale, h.getPrefHeight());
                putFullStickmanOnStage(name, stickman);
            } catch (Exception ex) {
                Logger.getLogger(ReetiOnStage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public XmlTransform getmXmlTransform() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
