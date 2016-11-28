package de.dfki.StageFX;

import de.dfki.common.*;
import de.dfki.common.interfaces.ApplicationFXLauncher;
import de.dfki.common.interfaces.Stickman;
import de.dfki.common.interfaces.StageStickman;
import de.dfki.common.interfaces.StageStickmanController;
import de.dfki.stickmanfx.utils.XmlStickmanLoader;

import java.awt.image.BufferedImage;

/**
 * Created by alvaro on 11/13/16.
 */
public abstract class StageStickmanControllerImpl implements StageStickmanController {

    public static final String CONFIG_STAGE = "configStage";
    protected ApplicationFXLauncher applicationFXLauncher ;
    protected StageStickman stickmanStageFX;
    protected CommonStickmansOnStage commonStickmansOnStage;
    protected String stageIdentifier;
    private boolean fullScreen = false;
    private int x;
    private int y;

    public abstract void init(String stageIdentifier);
    protected abstract void getStickmanStageInstance();
    protected abstract  void createNewStickmanStage(int x, int y, boolean decoration);

    @Override
    public  void clearStage() {
        getCommonStickmansOnStage().clearStage();
        stickmanStageFX.clearStage(stageIdentifier);
    }

    @Override
    public  void animate(String stickmanname, String name, int duration, String text, boolean block) {
        Stickman sm = getCommonStickmansOnStage().getStickman(stickmanname);
        sm.doAnimation(name, duration, text, block);
    }

    @Override
    public boolean ismNetwork() {
        return false;
    }

    @Override
    public void launchStickmanConfiguration(){
        try {
            getStickmanStage().addStickmanToStage(CONFIG_STAGE);
            getStickmanStage().showStage(CONFIG_STAGE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void launchStickmanStage(boolean show){
        try {
            getStickmanStage().addStickmanToStage(getStageIdentifier());
            if(show){
                 getStickmanStage().showStage(getStageIdentifier());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void launchStickmanConfiguration(String filepath){
        commonStickmansOnStage.setmFilePath(filepath);
        XmlStickmanLoader loader = new XmlStickmanLoader( commonStickmansOnStage);
        launchStickmanConfiguration();
        loader.initialStickmanWithXml();
    }

    public void launchStickmanStage(boolean show, String filepath){
        commonStickmansOnStage.setmFilePath(filepath);
        XmlStickmanLoader loader = new XmlStickmanLoader(commonStickmansOnStage);
        launchStickmanStage(show);
        loader.initialStickmanWithXml();

    }

    @Override
    public void addStickman(String name){
        getCommonStickmansOnStage().addStickman(name, fullScreen);
    }

    @Override
    public void addStickman(String name, boolean onlyFace){
        getCommonStickmansOnStage().addStickman(name, fullScreen, onlyFace);
    }

    @Override
    public BufferedImage getStageAsImage() throws Exception {
        return  getStickmanStage().getStageAsImage(stageIdentifier);
    }

    @Override
    public Stickman getStickman(String name){
        return getCommonStickmansOnStage().getStickman(name);
    }

    @Override
    public CommonStickmansOnStage getCommonStickmansOnStage() {
        return commonStickmansOnStage;
    }

    @Override
    public StageStickman getStickmanStage() {
        return stickmanStageFX;
    }

    @Override
    public String getStageIdentifier() {
        return stageIdentifier;
    }

    @Override
    public void setFullScreen(boolean fullScreen) {
        this.fullScreen = fullScreen;
    }



}
