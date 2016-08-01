package de.dfki.stickmanfx;

import de.dfki.stickman.animationlogic.Animation;
import de.dfki.stickman.animationlogic.AnimationLoader;
import de.dfki.stickman.animationlogic.EventAnimation;
import de.dfki.stickman.client.ClientConnectionHandler;
import de.dfki.stickman.util.Names;
import de.dfki.stickman.util.StickmanStageLayout;
import de.dfki.stickmanfx.StickmanFX.TYPE;
import de.dfki.util.xml.XMLUtilities;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.ByteArrayInputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

/**
 *
 * @author Robbie
 *
 */
public class StickmanStageFX extends Application implements MouseListener {
	
    static private final HashMap<String, StickmanFX> sStickmansOnStage = new HashMap<>();
    static private HBox sStickmanPane;
    static private StickmanStageFX sInstance;
    //grahics
    private static float sScale = 1.0f;
    protected static boolean sFullScreen = false;
    protected static int mHeight = 0;
    protected static int mWidth = 0;
    // network interface
    public static ClientConnectionHandler mConnection;
    public static boolean mUseNetwork = false;
    private static String sHost = "127.0.0.1";
    private static int sPort = 7777;
    // logging
    public static final Logger mLogger = Logger.getAnonymousLogger();
    public static StickmanFX sMale = new StickmanFX("Bob", StickmanFX.TYPE.MALE);

    public StickmanStageFX() {

        sStickmanPane = new HBox();
//        sStickmanPane.setOpacity(0);

        if (sFullScreen) {
            mLogger.info("Full Screen Mode ...");
            Dimension size = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
            mWidth = size.width;
            mHeight = size.height;
//            setUndecorated(true);
//            setBackground(new Color(128, 128, 128, 255));
//            setMinimumSize(size);
//            setPreferredSize(size);
        }

//        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE); // This one is needed by SceneMaker

        ConsoleHandler ch = new ConsoleHandler();
        ch.setFormatter(new StickmanStageLogFormatter());

        if (mUseNetwork) {
            mConnection = new ClientConnectionHandler();
            mConnection.connect(sHost, sPort);

            while (!mConnection.mConnected) {
                try {
                    mLogger.info("Waiting for connection to control application ...");
                    Thread.sleep(250);
                } catch (InterruptedException ex) {
                    mLogger.severe(ex.getMessage());
                }
            }
        }

//        addMouseListener(this);
    }

    public static StickmanStageFX getInstance() {
        if (sInstance == null) {
            sInstance = new StickmanStageFX();
        }
        return sInstance;
    }

    public static StickmanStageFX getInstanceFullScreen() {
        sFullScreen = true;

        if (sInstance == null) {
            sInstance = new StickmanStageFX();
        }

        return sInstance;
    }

    public static StickmanStageFX getNetworkInstance() {
        mUseNetwork = true;

        return getInstance();
    }

    public static StickmanStageFX getNetworkInstanceFullScreen() {
        sFullScreen = true;

        mUseNetwork = true;

        return getInstance();
    }

    public static StickmanStageFX getNetworkInstance(String host, int port) {
        sHost = host;
        sPort = port;

        mUseNetwork = true;

        return getInstance();
    }

    public static StickmanStageFX getNetworkInstanceFullScreen(String host, int port) {
        sHost = host;
        sPort = port;

        mUseNetwork = true;

        sFullScreen = true;

        return getInstance();
    }

    public static void addStickmanFX(String name) {
        StickmanFX.TYPE gender = null;
        if (Names.sFemaleNames.contains(name.toLowerCase())) {
            gender = StickmanFX.TYPE.FEMALE;
        }

        if (Names.sMaleNames.contains(name.toLowerCase())) {
            gender = (gender == null) ? StickmanFX.TYPE.MALE : gender;
        }

        addStickmanFX(name, gender);
    }

    public static void addStickmanFX(String name, StickmanFX.TYPE gender) {
        if (!sStickmansOnStage.containsKey(name.toLowerCase())) {
            if (sFullScreen) {
                sStickmansOnStage.put(name.toLowerCase(),
                        new StickmanFX(name,
                                gender,
                                mHeight / (float) StickmanFX.mDefaultSize.height * sScale,
                                new Dimension(new Float(mHeight * 2 / 3 * sScale).intValue(), new Float(mHeight * sScale).intValue())
                                ));
//                getStickman(name).mShowBackground = false;
//                getStickman(name).mShowStage = false;
//                getStickman(name).mShowName = false;
            } else {
                sStickmansOnStage.put(name.toLowerCase(), new StickmanFX(name, gender, sScale));
            }
            
            Pane p = new Pane();
            p.setPrefHeight(600);
            p.setPrefWidth(500);
            p.getChildren().add(getStickmanFX(name));
            sStickmanPane.getChildren().add(p);
           
            //            sStickmanPane.revalidate();   
        }

        // resize the stuff ...
//        StickmanStageFX.getInstance().pack();
//        StickmanStageFX.getInstance().setVisible(true);
    }

    public static StickmanFX getStickmanFX(String name) {
        if (sStickmansOnStage.containsKey(name.toLowerCase())) {
            return sStickmansOnStage.get(name.toLowerCase());
        } else {
            return null;
        }
    }

    public static void clearStage() {
        Set<String> deleteStickman = new HashSet<>();
        sStickmansOnStage.keySet().stream().map((s) -> {
            deleteStickman.add(s);
            return s;
        }).forEach((s) -> {
            getStickmanFX(s).mAnimationScheduler.end();
        });
        deleteStickman.stream().map((s) -> {
            sStickmanPane.getChildren().remove(getStickmanFX(s).getParent());
            return s;
        }).forEach((s) -> {
            sStickmansOnStage.remove(s);
        });

        // resize the stuff ...
//        StickmanStageFX.getInstance().pack();
//        StickmanStageFX.getInstance().setVisible(false);

        if (mUseNetwork) {
            mConnection.end();
        }

        sInstance = null;
    }

    public static void showStickmanNameFX(boolean show) {
        for (StickmanFX s : sStickmansOnStage.values()) {
            s.mShowName = show;
        }
    }

    public static void animate(String stickmanname, String type, String name, int duration, String text, boolean block) {
        StickmanFX sm = getStickmanFX(stickmanname);
        sm.doAnimation(name, duration, text, block);
    }

    public static void parseStickmanMLCmd(String cmd) {
        // TODO cut the crap with the two animation types ...
//        Animation a = (cmd.contains("StickmanEventAnimation")) ? new EventAnimation() : new Animation();
//
//        boolean r = XMLUtilities.parseFromXMLStream(a, new ByteArrayInputStream(cmd.getBytes(Charset.forName("UTF-8"))));
//
//        String stickmanname = a.mStickmanName;
//        String animationname = a.mName;
//        String id = a.mID;
//        int duration = a.mDuration;
//        boolean blocking = a.mBlocking;
//        Object parameter = a.mParameter;
//        if(stickmanname != null){
//            a = (a instanceof EventAnimation)
//                    ? AnimationLoader.getInstance().loadEventAnimation(getStickmanFX(stickmanname), animationname, duration, blocking)
//                    : AnimationLoader.getInstance().loadAnimation(getStickmanFX(stickmanname), animationname, duration, blocking);
//
//            a.setID(id); // give the animation the same id (TODO - This is bad design and caused that the animation has to be "reloaded"
//            a.mParameter = parameter;
//
//            a.mStickman.playAnimation(a);
//        }
    }

    public static void sendTimeMarkInformation(String timemark) {
        if (mConnection.mConnected) {
            mConnection.sendToServer(timemark);
        }
    }

    public static void sendAnimationUpdate(String state, String id) {
        if (mConnection.mConnected) {
            mConnection.sendToServer("#ANIM#" + state + "#" + id);
        }
    }
    
    public void start(Stage primaryStage) {  
    	
    	getInstanceFullScreen();
        //StickmanStage.getInstance();
        addStickmanFX("Anna");
        addStickmanFX("character");
//        StickmanStageFX.addStickmanFX("Bob");
//        StickmanStageFX.addStickmanFX("aaron");
//        StickmanStageFX.addStickmanFX("aaliyah");
//        StickmanStageFX.addStickmanFX("abbie");
//        StickmanStageFX.addStickmanFX("abdiel");
        primaryStage.setTitle("StickmanFX");
        Scene scene = new Scene(sStickmanPane);
        primaryStage.setScene(scene);
        primaryStage.show(); 
        primaryStage.setFullScreen(true);
        
        getStickmanFX("character").doAnimation("Angry", 70, true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        ExtensionsFromJar e = new ExtensionsFromJar("de.dfki.stickman.animation.face",false);
//		e.loadClass();
    	
//    	launch(args);
    	
//        StickmanStageFX.getInstanceFullScreen();
//        //StickmanStage.getInstance();
//        StickmanStageFX.addStickmanFX("Anna");
//        StickmanStageFX.addStickmanFX("character");
//        StickmanStageFX.addStickmanFX("Bob");
        
        launch(args);
    }

//  emotion: Angry, AngrySmallMouth, Contempt, Disgusted, Embarrassed, Excited, Fear, Happy, Loved, Sad, Smile, Surprised
//  emotionStart: AngryStart, ContemptStart, DisgustedStart, FearStart, AngrySmallMouthStart,
//                HappyStart, LovedStart, SadStart, SmileStart, SurprisedStart, EmbarrassedStart, ExcitedStart
//  emotionEnd: AngryEnd, ContemptEnd, DisgustedEnd, FearEnd, HappyEnd, AngrySmallMouthEnd,
//              LovedEnd, SadEnd, SmileEnd, SurprisedEnd, EmbarrassedEnd, ExcitedEnd
//  action: HeadShake, Nod2
    
    @Override
    public void mouseClicked(MouseEvent e) {

//    	if(SwingUtilities.isLeftMouseButton(e)){
//    		getStickmanFX("Bob").doAnimation("StartIdle", 70, true);
//    	}else{
//    		getStickmanFX("Bob").doAnimation("StopIdle", 70, true);
//    	}
    	  
//      getStickmanFX("character").doAnimation("Angry", 70, true);

//		getStickman("Anna").doAnimation("gesture", "CoverMouth", true);
//    	getStickman("Anna").doAnimation("LookLeft", 300, true); //
//        getStickman("Anna").doAnimation("WaveLeft", 50, true);//

////		//smM.doAnimation("environment", "speak", "Stell Dir vor, Du kommst nach Hause, und ein Pferd steht in der Küche.", false);
//		getStickman("Anna").doAnimation("environment", "speak", 300, "Stell Dir vor, Du kommst nach Hause, und ein Pferd steht in der Küche.", false);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    private static class StickmanStageLogFormatter extends Formatter {

        @Override
        public String format(LogRecord record) {
            return ((new StringBuffer()).append(record.getLevel()).append(": ").append(record.getMessage()).append("\n")).toString();
        }
    }
}
