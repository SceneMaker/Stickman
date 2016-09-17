package de.dfki.stickman;

import de.dfki.common.CommonStickmanStage;
import de.dfki.common.StageStickman;
import de.dfki.stickman.animationlogic.Animation;
import de.dfki.stickman.animationlogic.AnimationLoader;
import de.dfki.stickman.animationlogic.EventAnimation;
import de.dfki.stickman.client.ClientConnectionHandler;
import de.dfki.stickman.util.Names;
import de.dfki.stickman.util.StickmanStageLayout;
import de.dfki.util.xml.XMLUtilities;
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
import javax.swing.WindowConstants;

/**
 *
 * @author Patrick Gebhard
 *
 */
public class StickmanStage extends JFrame implements MouseListener , StageStickman, CommonStickmanStage {

    static private final HashMap<String, Stickman> sStickmansOnStage = new HashMap<>();
    static private JPanel sStickmanPanel;
    static private StickmanStage sInstance;
    //grahics
    private static float sScale = 1.0f;
    protected  boolean sFullScreen = false;
    protected  int mHeight = 0;
    protected  int mWidth = 0;
    // network interface
    public  ClientConnectionHandler mConnection;
    public  boolean mUseNetwork = false;
    private  String sHost = "127.0.0.1";
    private  int sPort = 7777;
    // logging
    public static final Logger mLogger = Logger.getAnonymousLogger();

    private StickmanStage() {
        super("Stickman Stage");

        sStickmanPanel = new JPanel();
        sStickmanPanel.setLayout(new StickmanStageLayout());
        sStickmanPanel.setOpaque(false);
        add(sStickmanPanel);

        if (sFullScreen) {
            mLogger.info("Full Screen Mode ...");
            Dimension size = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
            mWidth = size.width;
            mHeight = size.height;
            setUndecorated(true);
            setBackground(new Color(128, 128, 128, 255));
            setMinimumSize(size);
            setPreferredSize(size);
        }

        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE); // This one is needed by SceneMaker

        ConsoleHandler ch = new ConsoleHandler();
        ch.setFormatter(new StickmanStageLogFormatter());

        if (mUseNetwork) {
            mConnection = new ClientConnectionHandler(this);
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

        addMouseListener(this);
    }

    public static StickmanStage getInstance() {
        if (sInstance == null) {
            sInstance = new StickmanStage();
        }
        return sInstance;
    }

    public  StickmanStage getInstanceFullScreen() {
        sFullScreen = true;

        if (sInstance == null) {
            sInstance = new StickmanStage();
        }

        return sInstance;
    }

    public  StickmanStage getNetworkInstance() {
        mUseNetwork = true;

        return getInstance();
    }

    public  StickmanStage getNetworkInstanceFullScreen() {
        sFullScreen = true;

        mUseNetwork = true;

        return getInstance();
    }

    public  StickmanStage getNetworkInstance(String host, int port) {
        sHost = host;
        sPort = port;

        mUseNetwork = true;

        return getInstance();
    }

    public  StickmanStage getNetworkInstanceFullScreen(String host, int port) {
        sHost = host;
        sPort = port;

        mUseNetwork = true;

        sFullScreen = true;

        return getInstance();
    }

    public  void addStickman(String name) {
        Stickman.TYPE gender = null;
        if (Names.sFemaleNames.contains(name.toLowerCase())) {
            gender = Stickman.TYPE.FEMALE;
        }

        if (Names.sMaleNames.contains(name.toLowerCase())) {
            gender = (gender == null) ? Stickman.TYPE.MALE : gender;
        }

        addStickman(name, gender);
    }

    public  void addStickman(String name, Stickman.TYPE gender) {
        if (!sStickmansOnStage.containsKey(name.toLowerCase())) {
            if (sFullScreen) {
                sStickmansOnStage.put(name.toLowerCase(),
                        new Stickman(name,
                                gender,
                                mHeight / (float) Stickman.mDefaultSize.height * sScale,
                                new Dimension(new Float(mHeight * 2 / 3 * sScale).intValue(), new Float(mHeight * sScale).intValue())));
                getStickman(name).mShowBackground = false;
                getStickman(name).mShowStage = false;
                getStickman(name).mShowName = false;
            } else {
                sStickmansOnStage.put(name.toLowerCase(), new Stickman(name, gender, sScale));
            }
            sStickmanPanel.add(getStickman(name));
            sStickmanPanel.revalidate();   
        }

        // resize the stuff ...
        StickmanStage.getInstance().pack();
        StickmanStage.getInstance().setVisible(true);
    }

    public  Stickman getStickman(String name) {
        Stickman sm;
        if (sStickmansOnStage.containsKey(name.toLowerCase())) {
            return sStickmansOnStage.get(name.toLowerCase());
        } else {
            return null;
        }
    }

    @Override
    public void lauchStickman(String filepath) {

    }

    public  void clearStage() {
        Set<String> deleteStickman = new HashSet<>();
        sStickmansOnStage.keySet().stream().map((s) -> {
            deleteStickman.add(s);
            return s;
        }).forEach((s) -> {
            getStickman(s).mAnimationScheduler.end();
        });
        deleteStickman.stream().map((s) -> {
            sStickmanPanel.remove(getStickman(s));
            return s;
        }).forEach((s) -> {
            sStickmansOnStage.remove(s);
        });

        // resize the stuff ...
        StickmanStage.getInstance().pack();
        StickmanStage.getInstance().setVisible(false);

        if (mUseNetwork) {
            mConnection.end();
        }

        sInstance = null;
    }

    public  void showStickmanName(boolean show) {
        for (Stickman s : sStickmansOnStage.values()) {
            s.mShowName = show;
        }
    }

    public  void animate(String stickmanname, String type, String name, int duration, String text, boolean block) {
        Stickman sm = getStickman(stickmanname);
        sm.doAnimation(name, duration, text, block);
    }

    public  void parseStickmanMLCmd(String cmd) {
        // TODO cut the crap with the two animation types ...
        Animation a = (cmd.contains("StickmanEventAnimation")) ? new EventAnimation() : new Animation();

        boolean r = XMLUtilities.parseFromXMLStream(a, new ByteArrayInputStream(cmd.getBytes(Charset.forName("UTF-8"))));

        String stickmanname = a.mStickmanName;
        String animationname = a.mName;
        String id = a.mID;
        int duration = a.mDuration;
        boolean blocking = a.mBlocking;
        Object parameter = a.mParameter;
        if(stickmanname != null){
            a = (a instanceof EventAnimation)
                    ? AnimationLoader.getInstance().loadEventAnimation(getStickman(stickmanname), animationname, duration, blocking)
                    : AnimationLoader.getInstance().loadAnimation(getStickman(stickmanname), animationname, duration, blocking);

            a.setID(id); // give the animation the same id (TODO - This is bad design and caused that the animation has to be "reloaded"
            a.mParameter = parameter;

            a.mStickman.playAnimation(a);
        }
    }

    public static void sendTimeMarkInformation(String timemark) {
        if (sInstance.mConnection.mConnected) {
            sInstance.mConnection.sendToServer(timemark);
        }
    }

    public static void sendAnimationUpdate(String state, String id) {
        if (sInstance.mConnection.mConnected) {
            sInstance.mConnection.sendToServer("#ANIM#" + state + "#" + id);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        ExtensionsFromJar e = new ExtensionsFromJar("de.dfki.stickman.animation.face",false);
//		e.loadClass();
        StickmanStage stage = StickmanStage.getInstance();
        //stage.getInstanceFullScreen();
        //StickmanStage.getInstance();
        stage.addStickman("Anna");
        stage.addStickman("character");
        stage.addStickman("Bob");
    }

//  emotion: Angry, AngrySmallMouth, Contempt, Disgusted, Embarrassed, Excited, Fear, Happy, Loved, Sad, Smile, Surprised
//  emotionStart: AngryStart, ContemptStart, DisgustedStart, FearStart, AngrySmallMouthStart,
//                HappyStart, LovedStart, SadStart, SmileStart, SurprisedStart, EmbarrassedStart, ExcitedStart
//  emotionEnd: AngryEnd, ContemptEnd, DisgustedEnd, FearEnd, HappyEnd, AngrySmallMouthEnd,
//              LovedEnd, SadEnd, SmileEnd, SurprisedEnd, EmbarrassedEnd, ExcitedEnd
//  action: HeadShake, Nod2
    
    @Override
    public void mouseClicked(MouseEvent e) {
        //getStickman("Anna").mLogger.info("mouse clicked");
        //getStickman("Bob").mLogger.info("mouse clicked");
//       getStickman("Anna").doAnimation("Speaking", 3000, "Stell Dir vor, Du kommst nach Hause, und ein Pferd steht in der Küche.", false);
        //getStickman("Anna").doAnimation("Speaking", 3000, "Stell Dir vor, Du kommst nach Hause, und ein Pferd steht in der Küche.", false);
        //////		//smM.doAnimation("gesture", "waveleft", false);
//       getStickman("Anna").doAnimation("gesture", 70, "waveleft",  false);	
    	
//    	if(SwingUtilities.isLeftMouseButton(e)){
    		getStickman("Anna").doAnimation("TouchHead", 70, true);
//    	}else{
//    		getStickman("Bob").doAnimation("FadeIn", 70, true);
//    	}
    	    	
//    	if(SwingUtilities.isLeftMouseButton(e)){
//    		getStickman("Bob").doAnimation("StartIdle", 70, true);
//    	}else{
//    		getStickman("Bob").doAnimation("StopIdle", 70, true);
//    	}
    	  
//      getStickman("Bob").doAnimation("Angry", 70, true);

    
    

//		getStickman("Anna").doAnimation("head", "lookright", 300, true);
//		getStickman("Anna").doAnimation("gesture", "CoverMouth", true);
    	getStickman("Anna").doAnimation("WaveLeft", 300, true); 
//        getStickman("Anna").doAnimation("WaveLeft", 50, true);//
	//getStickman("Anna").doAnimation("head", "Blink", true);
// getStickman("Anna").doAnimation("head", "lookleft", 300, true);
        //getStickman("Anna").doAnimation("gesture", "WaveLeft", 50, true);
        //getStickman("Anna").doAnimation("head", "Blink", true);
////		//smM.doAnimation("environment", "speak", "Stell Dir vor, Du kommst nach Hause, und ein Pferd steht in der Küche.", false);
//		getStickman("Anna").doAnimation("environment", "speak", 300, "Stell Dir vor, Du kommst nach Hause, und ein Pferd steht in der Küche.", false);
//////		//smM.doAnimation("face", "Mouth_O", true);
//////		smF.doAnimation("face", "Mouth_O", true);
//////		//smM.doAnimation("head", "TiltLeft", true);
//////		smF.doAnimation("head", "TiltLeft", true);
//////		//smM.doAnimation("head", "Blink", false);
//////		smF.doAnimation("head", "Blink", false);
//////		//smM.doAnimation("face", "Mouth_Default", false);
//////		smF.doAnimation("face", "Mouth_Default", false);
        //getStickman("Bob").doAnimation("Sad", " ", false);  ///
        //getStickman("Anna").doAnimation("TiltLeftBack", " ", false);
        //
//////		//smM.doAnimation("head", "TiltLeftBack", true);
//////		smF.doAnimation("head", "TiltLeftBack", true);
//
//		getStickman("Anna").doAnimation("face", "Smile", 2000, false);
//		getStickman("Anna").doAnimation("head", "TiltLeft", true);
//		getStickman("Anna").doAnimation("head", "Blink", false);
//		getStickman("Anna").doAnimation("gesture", "WaveLeft", 2000, false);
//
//		getStickman("Anna").doAnimation("head", "TiltLeftBack", true);
//		getStickman("Anna").doAnimation("head", "TiltLeft", true);
//		getStickman("Anna").doAnimation("head", "TiltLeftBack", true);
//		//smF.doAnimation("gesture", "CoverMouth", true);
//////		smF.doAnimation("gesture", "waveleft", false);
//////		smF.doAnimation("head", "TiltLeft", true);
//////		smF.doAnimation("head", "TiltLeftBack", false);
////		smF.doAnimation("gesture", "waveleft", false);
////		smF.doAnimation("head", "TiltLeft", true);
//		getStickman("Anna").doAnimation("head", "Blink", true);
//
//		smF.doAnimation("face", "smile", true);
//		smF.doAnimation("head", "TiltLeftBack", true);
        //smF.doAnimation("face", "smile", true);
//		smF.doAnimation("head", "Blink", false);
//		smF.doAnimation("head", "Nod", true);
//
//		smF.doAnimation("head", "TiltLeft", true);
//
//		smF.doAnimation("head", "Blink", false);
////
//		smF.doAnimation("head", "TiltLeftBack", true);
//		smF.doAnimation("head", "nod", true);
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

    @Override
    public float getFullScreenScale() {
        return 0;
    }

    @Override
    public Dimension getFullScreenDimension() {
        return null;
    }

    @Override
    public void addStickmanToStage(String stageIdentifier) {

    }

    @Override
    public void setStageFullScreen(String stageIdentifier) {

    }

    @Override
    public void setStageNonFullScreen(String stageIdentifier) {

    }

    private static class StickmanStageLogFormatter extends Formatter {

        @Override
        public String format(LogRecord record) {
            return ((new StringBuffer()).append(record.getLevel()).append(": ").append(record.getMessage()).append("\n")).toString();
        }
    }
}
