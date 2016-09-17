package de.dfki.common;

import de.dfki.stickman.util.Names;
import de.dfki.stickmanfx.stagecontroller.StageStickmanControllerFX;
import de.dfki.stickmanfx.StickmanFX;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by alvaro on 9/12/16.
 * Manage Stickman on the Stage
 */
public class StickmansOnStage {
    public static final float DEFAULT_SCALE = 0.8f;
    private Map<String, CommonStickman> sStickmansOnStage = new HashMap<>();
    private StageStickman stickmanStage;
    private StageStickmanController stageStickmanController;
    public StickmansOnStage( StageStickman stageStickman){
        stickmanStage = stageStickman;
    }

    public StickmansOnStage(StageStickman stickmanStageFX, StageStickmanControllerFX controllerFX) {
        stickmanStage = stickmanStageFX;
        stageStickmanController = controllerFX;
    }

    public void setStageStickmanController(StageStickmanController controllerFX){
        stageStickmanController = controllerFX;
    }

    public void addStickman(String name, boolean fullScreen) {
        StickmanFX.TYPE gender = null;
        if (Names.sFemaleNames.contains(name.toLowerCase())) {
            gender = StickmanFX.TYPE.FEMALE;
        }
        if (Names.sMaleNames.contains(name.toLowerCase())) {
            gender = (gender == null) ? StickmanFX.TYPE.MALE : gender;
        }
        addStickman(name, gender, fullScreen);
    }

    public  void addStickman(String name, StickmanFX.TYPE gender, boolean fullScreen) {
        if (!sStickmansOnStage.containsKey(name.toLowerCase())) {
            addStickmanToStage(name, fullScreen, gender);
            //getStickmanFX(name).mShowName = true;
        }
    }

    public  void showStickmanNameFX(boolean show) {
        for (CommonStickman s : sStickmansOnStage.values()) {
            s.setShowName(show);
        }
    }

    private void addStickmanToStage(String name, boolean fullScreen, StickmanFX.TYPE gender) {
        if (fullScreen) {
            CommonStickman stickman = new StickmanFX(name, gender, stickmanStage.getFullScreenScale(), stickmanStage.getFullScreenDimension());
            putFullStickmanOnStage(name, stickman);
        }else{
            CommonStickman stickman = new StickmanFX(name, gender, DEFAULT_SCALE);
            putFullStickmanOnStage(name, stickman);
        }
    }

    public StickmanFX getStickmanFX(String name) {
        if (sStickmansOnStage.containsKey(name.toLowerCase())) {
            return (StickmanFX) sStickmansOnStage.get(name.toLowerCase());
        }
        throw new NullPointerException("No stickman with name " + name);

    }

    public void clearStage(){
        Set<String> deleteStickman = new HashSet<>();
        sStickmansOnStage.keySet().stream().map((s) -> {
            deleteStickman.add(s);
            return s;
        }).forEach((s) -> {
            getStickmanFX(s).endAnimationScheduler();
        });
    }

    private void putFullStickmanOnStage(String name, CommonStickman stickman) {
        sStickmansOnStage.put(name.toLowerCase(),stickman );
        stickman.setStickmanStageController(stageStickmanController);
    }

    public Set<String> getStickmanNames(){
        return sStickmansOnStage.keySet();
    }

    public StickmanFX getStickmanByKey(String key){
        return (StickmanFX) sStickmansOnStage.get(key);
    }
}
