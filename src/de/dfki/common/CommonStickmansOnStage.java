package de.dfki.common;

import de.dfki.stickman.Stickman;
import de.dfki.stickman.util.Names;
import de.dfki.stickmanfx.StickmanFX;
import de.dfki.stickmanfx.xmlsettings.XmlTransform;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by alvaro on 9/12/16.
 * Manage Stickman on the Stage
 */
public abstract class CommonStickmansOnStage {
    public static final float DEFAULT_SCALE = 0.8f;
    private Map<String, CommonStickman> sStickmansOnStage = new HashMap<>();
    protected StageStickman stickmanStage;
    private StageStickmanController stageStickmanController;
    private String mFilePath;

    public CommonStickmansOnStage(StageStickman stageStickman){
        stickmanStage = stageStickman;
    }

    public CommonStickmansOnStage(StageStickman stickmanStageFX, StageStickmanController controllerFX) {
        stickmanStage = stickmanStageFX;
        stageStickmanController = controllerFX;
    }

    public void setStageStickmanController(StageStickmanController controllerFX){
        stageStickmanController = controllerFX;
    }

    public void addStickman(String name, boolean fullScreen) {
        Stickman.TYPE gender = getStickmanGender(name);
        addStickman(name, gender, fullScreen);
    }

    public Stickman.TYPE getStickmanGender(String name) {
        Stickman.TYPE gender = null;
        if (Names.sFemaleNames.contains(name.toLowerCase())) {
            gender = Stickman.TYPE.FEMALE;
        }
        if (Names.sMaleNames.contains(name.toLowerCase())) {
            gender = (gender == null) ? Stickman.TYPE.MALE : gender;
        }
        return gender;
    }

    public  void addStickman(String name, Stickman.TYPE gender, boolean fullScreen) {
        if (!sStickmansOnStage.containsKey(name.toLowerCase())) {
            addStickmanToStage(name, fullScreen, gender, false);
        }
    }

    public  void addStickman(String name, boolean fullScreen, boolean onlyFace) {
        Stickman.TYPE gender = getStickmanGender(name);
        if (!sStickmansOnStage.containsKey(name.toLowerCase())) {
            addStickmanToStage(name, fullScreen, gender, onlyFace);
        }
    }

    public  void showStickmanNameFX(boolean show) {
        for (CommonStickman s : sStickmansOnStage.values()) {
            s.setShowName(show);
        }
    }

    protected abstract void addStickmanToStage(String name, boolean fullScreen, Stickman.TYPE gender);

    protected abstract void addStickmanToStage(String name, boolean fullScreen, Stickman.TYPE gender, boolean onlyFace);

    public CommonStickman getStickman(String name) {
        if (sStickmansOnStage.containsKey(name.toLowerCase())) {
            return sStickmansOnStage.get(name.toLowerCase());
        }
        throw new NullPointerException("No stickman with name " + name);

    }

    public void clearStage(){
        Set<String> deleteStickman = new HashSet<>();
        sStickmansOnStage.keySet().stream().map((s) -> {
            deleteStickman.add(s);
            return s;
        }).forEach((s) -> {
            getStickman(s).endAnimationScheduler();
        });

    }

    protected void putFullStickmanOnStage(String name, CommonStickman stickman) {
        sStickmansOnStage.put(name.toLowerCase(),stickman );
        stickman.setStickmanStageController(stageStickmanController);
    }

    public Set<String> getStickmanNames(){
        return sStickmansOnStage.keySet();
    }

    public CommonStickman getStickmanByKey(String key){
        return  sStickmansOnStage.get(key);
    }

    public String getmFilePath() {
        return mFilePath;
    }

    public void setmFilePath(String mFilePath) {
        this.mFilePath = mFilePath;
    }


}
