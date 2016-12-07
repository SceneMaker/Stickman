package de.dfki.common;

import de.dfki.common.interfaces.StageRoom;
import de.dfki.common.interfaces.Stickman;
import de.dfki.common.interfaces.StickmanStage;
import de.dfki.stickmanFX.xmlsettings.XmlTransform;
import de.dfki.stickmanSwing.StickmanSwing;
import de.dfki.stickmanSwing.util.Names;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by alvaro on 9/12/16. Manage StickmanSwing on the Stage
 */
public abstract class StickmansOnStage {

    public static final float DEFAULT_SCALE = 0.8f;
    protected StickmanStage stickmanStage;
    private Map<String, Stickman> sStickmansOnStage = new HashMap<>();
    private StageRoom stageRoom;
    private String mFilePath;

    public StickmansOnStage(StickmanStage stickmanStage) {
        this.stickmanStage = stickmanStage;
    }

    public StickmansOnStage(StickmanStage stickmanStageFX, StageRoom controllerFX) {
        stickmanStage = stickmanStageFX;
        stageRoom = controllerFX;
    }

    public StickmanStage getStageStickman() {
        return stickmanStage;
    }

    public StageRoom getStageRoom() {
        return stageRoom;
    }

    public void setStageRoom(StageRoom controllerFX) {
        stageRoom = controllerFX;
    }

    public void addStickman(String name, boolean fullScreen) {
        Gender.TYPE gender = getStickmanGender(name);
        addStickman(name, gender, fullScreen);
    }

    public Gender.TYPE getStickmanGender(String name) {
        Gender.TYPE gender = null;
        if (Names.sFemaleNames.contains(name.toLowerCase())) {
            gender = Gender.TYPE.FEMALE;
        } else {
            gender = Gender.TYPE.MALE;
        }
        return gender;
    }

    public void addStickman(String name, Gender.TYPE gender, boolean fullScreen) {
        if (!sStickmansOnStage.containsKey(name.toLowerCase())) {
            addStickmanToStage(name, fullScreen, gender, false);
        }
    }

    public void addStickman(String name, boolean fullScreen, boolean onlyFace) {
        Gender.TYPE gender = getStickmanGender(name);
        if (!sStickmansOnStage.containsKey(name.toLowerCase())) {
            addStickmanToStage(name, fullScreen, gender, onlyFace);
        }
    }

    public void showStickmanNameFX(boolean show) {
        for (Stickman s : sStickmansOnStage.values()) {
            s.setShowName(show);
        }
    }

    protected abstract void addStickmanToStage(String name, boolean fullScreen, Gender.TYPE gender);

    protected abstract void addStickmanToStage(String name, boolean fullScreen, Gender.TYPE gender, boolean onlyFace);

    public abstract XmlTransform getmXmlTransform();

    public Stickman getStickman(String name) {
        if (sStickmansOnStage.containsKey(name.toLowerCase())) {
            return sStickmansOnStage.get(name.toLowerCase());
        }
        throw new NullPointerException("No stickmanSwing with name " + name);

    }

    public void clearStage() {
        Set<String> deleteStickman = new HashSet<>();
        sStickmansOnStage.keySet().stream().map((s) -> {
            deleteStickman.add(s);
            return s;
        }).forEach((s) -> {
            getStickman(s).endAnimationScheduler();
        });
    }

    protected void putFullStickmanOnStage(String name, Stickman stickman) {
        sStickmansOnStage.put(name.toLowerCase(), stickman);
        stickman.setStickmanStageController(stageRoom);
    }

    public Set<String> getStickmanNames() {
        return sStickmansOnStage.keySet();
    }

    public Stickman getStickmanByKey(String key) {
        return sStickmansOnStage.get(key);
    }

    public String getmFilePath() {
        return mFilePath;
    }

    public void setmFilePath(String mFilePath) {
        this.mFilePath = mFilePath;
    }

}
