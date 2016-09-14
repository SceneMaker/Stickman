package de.dfki.common;

import de.dfki.stickman.Stickman;

/**
 * Created by alvaro on 9/4/16.
 */
public interface CommonStickmanStage {
    public StageStickman getInstanceFullScreen();
    //public StageStickman getInstance();
    public StageStickman getNetworkInstance(String host, int port);
    public StageStickman getNetworkInstanceFullScreen(String host, int port);
    public void addStickman(String name);
    public void clearStage();
    public CommonStickman getStickman(String name);
    public  void lauchStickman(String filepath);
}
