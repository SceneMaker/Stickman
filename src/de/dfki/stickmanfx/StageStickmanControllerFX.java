package de.dfki.stickmanfx;

import de.dfki.common.CommandParser;
import de.dfki.common.StageStickman;
import de.dfki.common.StageStickmanController;
import de.dfki.common.StickmansOnStage;
import de.dfki.stickmanfx.client.ClientConnectionHandlerFX;
import java.io.IOException;

/**
 * Created by alvaro on 9/12/16.
 */
public class StageStickmanControllerFX implements StageStickmanController {
    public static final String CONFIG_STAGE = "configStage";
    private StageStickman stickmanStageFX;
    private  ClientConnectionHandlerFX mConnection;
    private StickmansOnStage stickmansOnStage;
    private CommandParser commandParser;
    private boolean mNetwork;
    private String stageIdentifier;

    public StageStickmanControllerFX(){
        if(StickmanStageFX.isRunning){
            stickmanStageFX = (StageStickman) StickmanStageFX.getInstance();

        }else{
            launchStickmanAndWait();
        }
        createNewStickmanStage();

    }

    private void launchStickmanAndWait() {
        StickmanStageFX fx = new StickmanStageFX();
        (new Thread(){
            public void run(){
                fx.lauchStickman();
            }

        }).start();
        while (!StickmanStageFX.isRunning){
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void createNewStickmanStage() {
        stickmanStageFX = (StageStickman) StickmanStageFX.getInstance();
        init();
        try {
            stageIdentifier = ((StickmanStageFX)stickmanStageFX).createNewStage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void init() {
        stickmansOnStage = new StickmansOnStage(stickmanStageFX, this);
        commandParser = new CommandParser(stickmansOnStage);
        ((StickmanStageFX) stickmanStageFX).setStickamnsOnStage(stickmansOnStage);
        initConnectionToServer();
    }

    @Override
    public StageStickman createNewStage(String host, int port) {
        mNetwork = true;
        return null;
    }

    @Override
    public StageStickman createConfigStage() {
        return null;
    }

    @Override
    public  void clearStage() {
        stickmansOnStage.clearStage();
        /*if(configStage != null){
            configStage.close();
        }*/
        if(mConnection != null){
            mConnection.end();
            mConnection = null;
        }
    }

    public  void animate(String stickmanname,  String name, int duration, String text, boolean block) {
        StickmanFX sm = (StickmanFX) stickmansOnStage.getStickmanFX(stickmanname);
        sm.doAnimation(name, duration, text, block);
    }

    private  void initConnectionToServer(){
        if(mNetwork) {
            mConnection = new ClientConnectionHandlerFX(commandParser);
            mConnection.tryToConnect();
        }
    }

    public boolean ismNetwork() {
        return mNetwork;
    }

    public  void sendTimeMarkInformation(String timemark) {
        if (mConnection.ismConnected()) {
            mConnection.sendToServer(timemark);
        }
    }

    public  void sendAnimationUpdate(String state, String id) {
        if (mConnection.ismConnected()) {
            mConnection.sendToServer("#ANIM#" + state + "#" + id);
        }
    }

    public void launchStickmanConfiguration(){
        try {
            stickmanStageFX.addStickmanToStage(CONFIG_STAGE);
            ((StickmanStageFX)stickmanStageFX).showStage(CONFIG_STAGE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void launchStickmanStage(){
        try {
            stickmanStageFX.addStickmanToStage(stageIdentifier);
            ((StickmanStageFX)stickmanStageFX).showStage(stageIdentifier);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void launchStickmanConfiguration(String filepath){
    }

    public void launchStickmanStage(String filepath){

    }

    public void addStickman(String name){
        stickmansOnStage.addStickman(name, false);
    }
}
