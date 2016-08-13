package de.dfki.stickmanfx;

import de.dfki.stickmanfx.client.ClientConnectionHandlerFX;
import de.dfki.stickman.util.Names;
import de.dfki.stickmanfx.animationlogic.AnimationFX;
import de.dfki.stickmanfx.animationlogic.AnimationLoaderFX;
import de.dfki.stickmanfx.animationlogic.EventAnimationFX;
import de.dfki.util.xml.XMLUtilities;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.ByteArrayInputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import javax.swing.SwingUtilities;

import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Robbie
 *
 */
public class StickmanStageFX extends Application {
	
    static private final HashMap<String, StickmanFX> sStickmansOnStage = new HashMap<>();
    static private HBox sStickmanPane;
    static private StickmanStageFX sInstance;
    ArrayList<String> mStickmanComboList = new ArrayList<>();
    //grahics
    private static float sScale = 1.0f;
    protected static boolean sFullScreen = false;
    protected static int mHeight = 0;
    protected static int mWidth = 0;
    // network interface
    public static ClientConnectionHandlerFX mConnection;
    public static boolean mUseNetwork = false;
    private static String sHost = "127.0.0.1";
    private static int sPort = 7777;
    // logging
    public static final Logger mLogger = Logger.getAnonymousLogger();

    public StickmanStageFX() {

        sStickmanPane = new HBox();

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
            mConnection = new ClientConnectionHandlerFX();
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
                                new Dimension(new Float(mHeight * 1 / 2 * sScale).intValue(), new Float(mHeight * sScale).intValue())
                                ));
//                getStickman(name).mShowBackground = false;
//                getStickman(name).mShowStage = false;
//                getStickman(name).mShowName = false;
            } else {
                sStickmansOnStage.put(name.toLowerCase(), new StickmanFX(name, gender, sScale));
            }
            
//            Pane p = new Pane();
//            p.setPrefHeight(600);
//            p.setPrefWidth(500);
//            p.getChildren().add(getStickmanFX(name));
//            sStickmanPane.getChildren().add(p);
//            StickmanFX S= getStickmanFX(name);
            
//            sStickmanPane.getChildren().add(getStickmanFX(name));
            
           
            //            sStickmanPane.revalidate();   
        }
        
//        sStickmanPane.getChildren().add(getStickmanFX(name));

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
            getStickmanFX(s).mAnimationSchedulerFX.end();
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
        AnimationFX a = (cmd.contains("StickmanEventAnimation")) ? new EventAnimationFX() : new AnimationFX();

        boolean r = XMLUtilities.parseFromXMLStream(a, new ByteArrayInputStream(cmd.getBytes(Charset.forName("UTF-8"))));

        String stickmanname = a.mStickmanName;
        String animationname = a.mName;
        String id = a.mID;
        int duration = a.mDuration;
        boolean blocking = a.mBlocking;
        Object parameter = a.mParameter;
        if(stickmanname != null){
            a = (a instanceof EventAnimationFX)
                    ? AnimationLoaderFX.getInstance().loadEventAnimation(getStickmanFX(stickmanname), animationname, duration, blocking)
                    : AnimationLoaderFX.getInstance().loadAnimation(getStickmanFX(stickmanname), animationname, duration, blocking);

            a.setID(id); // give the animation the same id (TODO - This is bad design and caused that the animation has to be "reloaded"
            a.mParameter = parameter;

            a.mStickmanFX.playAnimation(a);
        }
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
   
    
    public void start(Stage stage) throws Exception {  

    	FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/de/dfki/stickmanfx/StickmanStageView.fxml"));
        HBox root = loader.load();
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
        
        //Plan to make a menu there
//        FXMLLoader loader1 = new FXMLLoader();
//        loader1.setLocation(getClass().getResource("RootLayoutStickmanFX.fxml"));
//        BorderPane root1 = loader1.load();
        
        
        Scene scene = new Scene(root, width, height);
        
        sStickmanPane = (HBox) scene.lookup("#StickmanFlowPane"); //get StickmanFlowPane from Scene Builder
        sStickmanPane.prefWidthProperty().bind(root.widthProperty());
        
        for(String key : sStickmansOnStage.keySet())
        {
//        	System.out.println(key);
    		sStickmanPane.getChildren().add(sStickmansOnStage.get(key));
    		mStickmanComboList.add(key.substring(0, 1).toUpperCase() + key.substring(1));
        }
        
        StickmanStageController mStickmanStageController = loader.getController();
        mStickmanStageController.getStickmanStageFX(this);
        mStickmanStageController.setlePerlinNoiseOn();

        stage.setTitle("StickmanFX");
        stage.setScene(scene);
        scene.getStylesheets().add(this.getClass().getResource("StickmanCSS.css").toExternalForm());
        stage.show();

        stage.setFullScreen(true);
        
        scene.setOnMouseClicked(mouseHandler);
             
    }
    
    public static void lauchStickman()
    {
    	launch();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	addStickmanFX("Bob");
    	addStickmanFX("Anna");
    	addStickmanFX("character");

    	lauchStickman();
        
//        launch(args);
    }
    
//  emotion: Angry, AngrySmallMouth, Contempt, Disgusted, Embarrassed, Excited, Fear, Happy, Loved, Sad, Smile, Surprised
//  emotionStart: AngryStart, ContemptStart, DisgustedStart, FearStart, AngrySmallMouthStart,
//                HappyStart, LovedStart, SadStart, SmileStart, SurprisedStart, EmbarrassedStart, ExcitedStart
//  emotionEnd: AngryEnd, ContemptEnd, DisgustedEnd, FearEnd, HappyEnd, AngrySmallMouthEnd,
//              LovedEnd, SadEnd, SmileEnd, SurprisedEnd, EmbarrassedEnd, ExcitedEnd
//  action: HeadShake, Nod2   
    
    EventHandler<MouseEvent> mouseHandler = new EventHandler<MouseEvent>() {
   	 
        @Override
        public void handle(MouseEvent mouseEvent) {

    	//getStickmanFX("Anna").doAnimation("Muster", 1000, true);
//        	getStickmanFX("Bob").doAnimation("StopIdle", 1000, true);
//        	getStickmanFX("Bob").doAnimation("Speaking", 3000, "Stell Dir vor, Du kommst nach Hause, und ein Pferd steht in der Küche.", false);
        	if(mouseEvent.getButton().equals(MouseButton.SECONDARY)){
        		getStickmanFX("Bob").doAnimation("FadeIn", 1000, true);
        		getStickmanFX("Anna").doAnimation("FadeIn", 1000, true);
        	}else{
        		getStickmanFX("Bob").doAnimation("FadeOut", 1000, true);
        		getStickmanFX("Anna").doAnimation("FadeOut", 1000, true);
        	}
    
        }
     
    }; 

    private static class StickmanStageLogFormatter extends Formatter {

        @Override
        public String format(LogRecord record) {
            return ((new StringBuffer()).append(record.getLevel()).append(": ").append(record.getMessage()).append("\n")).toString();
        }
    }
}
