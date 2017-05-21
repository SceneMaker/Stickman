package de.dfki.stickman3D.stage;

import de.dfki.common.Gender;
import de.dfki.common.interfaces.StageRoom;
import de.dfki.common.interfaces.Stickman;
import de.dfki.common.StickmansOnStage;
import de.dfki.common.interfaces.StickmanStage;
import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickmanSwing.StickmanSwing;
import de.dfki.stickman3D.xmlsettings.XmlTransform3D;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.layout.HBox;
import de.dfki.stickman3D.xmlsettings.XmlTransform3D;;

/**
 * Created by alvaro on 9/19/16.
 */
public class StickmansOnStage3D extends StickmansOnStage {

    private String identifier;

    public StickmansOnStage3D(StickmanStage stickmanStage) {
        super(stickmanStage);
    }
    private XmlTransform3D mXmlTransform = new XmlTransform3D();

    public StickmansOnStage3D(StickmanStage stickmanStageFX, StageRoom controllerFX) {
        super(stickmanStageFX, controllerFX);
    }

    public StickmansOnStage3D(StickmanStage stickmanStageFX, StageRoom controllerFX, String identifier) {
        super(stickmanStageFX, controllerFX);
        this.identifier = identifier;
    }

    @Override
    protected void addStickmanToStage(String name, boolean fullScreen, Gender.TYPE gender) {
        if (fullScreen) {
            Stickman stickman = new Stickman3D(name, gender, stickmanStage.getFullScreenScale(), stickmanStage.getFullScreenDimension());
            putFullStickmanOnStage(name, stickman);
        } else {

            createNonFullStickman(name, gender, DEFAULT_SCALE);
        }
    }

    @Override
    protected void addStickmanToStage(String name, boolean fullScreen, Gender.TYPE gender, boolean onlyFace) {
        if (fullScreen) {
            Stickman stickman = new Stickman3D(name, gender, stickmanStage.getFullScreenScale(), stickmanStage.getFullScreenDimension());
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

                Stickman stickman = new Stickman3D(name, gender, scale, h.getPrefHeight());
                putFullStickmanOnStage(name, stickman);
            } catch (Exception ex) {
                Logger.getLogger(StickmansOnStage3D.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public XmlTransform3D getmXmlTransform() {
        return this.mXmlTransform;
    }
}
