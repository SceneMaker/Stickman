package de.dfki.stickmanfx;

import de.dfki.stickmanfx.client.ClientConnectionHandlerFX;
import de.dfki.stickmanfx.xmlsettings.StickmanDataFX;
import de.dfki.stickmanfx.xmlsettings.XmlTransform;
import de.dfki.stickman.util.Names;
import de.dfki.stickmanfx.animationlogic.AnimationFX;
import de.dfki.stickmanfx.animationlogic.AnimationLoaderFX;
import de.dfki.stickmanfx.animationlogic.EventAnimationFX;
import de.dfki.util.HandleColor;
import de.dfki.util.xml.XMLUtilities;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.WindowEvent;

import java.awt.Dimension;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
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
    static private SplitPane mSplitPane;
    static private StickmanStageFX sInstance;
    static ArrayList<String> mStickmanComboList = new ArrayList<>();
    private static Boolean StageController = true;
    private static Stage primaryStage;
    private static XmlTransform mXmlTransform = new XmlTransform();
    private static Scene scene;
    private static HBox root;
    public static String mFilePath = null;
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
    private static boolean isRunning = false;
    private JFXPanel jfxPanel = new JFXPanel();
    // logging
    public static final Logger mLogger = Logger.getAnonymousLogger();
    
    private static int i =0;

    public StickmanStageFX() {
    	if(sFullScreen)
    		mLogger.info("Full Screen Mode ...");
        Dimension size = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        mWidth = size.width;
        mHeight = size.height;

        ConsoleHandler ch = new ConsoleHandler();
        ch.setFormatter(new StickmanStageLogFormatter());
    }
    
    private static void initConnectionToServer(){
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
    }

    public static StickmanStageFX getInstance() {
        if (sInstance == null) {
            sInstance = new StickmanStageFX();
            initConnectionToServer();
        }
        return sInstance;
    }

    public static void getFullScreen() {
        sFullScreen = true;
    }
    
    public static void getNonFullScreen() {
        sFullScreen = false;
    }
    
    public static StickmanStageFX getInstanceFullScreen() {
        sFullScreen = true;
        if (sInstance == null) {
            sInstance = new StickmanStageFX();
            initConnectionToServer();
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
            			new StickmanFX(name, gender,
            					mHeight / (float) StickmanFX.mDefaultSize.height * sScale * 1.15f,
	                            new Dimension(new Float(mHeight * 3 / 5 * sScale).intValue(), new Float(mHeight * sScale).intValue())
	                    ));
            	}else{
            		sScale = 0.8f;
            		sStickmansOnStage.put(name.toLowerCase(), new StickmanFX(name, gender, sScale));
            	} 
        getStickmanFX(name).mShowName = true;
        }       
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
        Platform.runLater(() ->{
            sStickmansOnStage.keySet().stream().map((s) -> {
                deleteStickman.add(s);
                return s;
            }).forEach((s) -> {
            	getStickmanFX(s).mIdleRun = false;
                getStickmanFX(s).mAnimationSchedulerFX.end();               
            });
            deleteStickman.stream().map((s) -> {
                sStickmanPane.getChildren().remove(getStickmanFX(s));
                return s;
            }).forEach((s) -> {
                sStickmansOnStage.remove(s);
            });
            mStickmanComboList.clear();
            
            if(primaryStage != null){
            	primaryStage.close();
            }
        });
        
        
        if (mUseNetwork && mConnection != null) {
            mConnection.end();
            mConnection = null;
        }  
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
    
    public XmlTransform getmXmlTransform(){
    	return this.mXmlTransform;
    }
    

    private static void addStickmanToStage() {
    	sStickmanPane.getChildren().clear();
        for(String key : sStickmansOnStage.keySet())
        {
            if (sFullScreen ) {
            	primaryStage.setFullScreen(true);                              
            }else{
            	primaryStage.setFullScreen(false);     		
          	} 
            sStickmanPane.getChildren().add(sStickmansOnStage.get(key));
            mStickmanComboList.add(key.substring(0, 1).toUpperCase() + key.substring(1));
        }
    }
    
    private static void readXML()
    {
    	File file = null;
//    	File file = new File("/Users/Robbie/Stickman" + File.separator+"stickman.xml");
    	if(mFilePath != null)
    		file = new File(mFilePath + File.separator + "stickman"+ File.separator+"stickman.xml");
    	
        if (file != null) {
        	mXmlTransform.loadStickmanDataFromFile(file);
        }
    }
    
    private static void initialStickmanWithXml()
    {
    	readXML();
    	List<StickmanDataFX> mStickmanDataFX = mXmlTransform.getStickmanDataFXList();
    	if(!(mStickmanDataFX.isEmpty()))
    	{
	    	for(StickmanDataFX mStick : mStickmanDataFX)	    		
	    	{
	    		String name = mStick.getName();
		    	if (sStickmansOnStage.containsKey(name.toLowerCase())){
		    		String bodycolor = mStick.getbodyColor();
		    		if(bodycolor != null)
		    		{
			            Platform.runLater(() -> 
			            {
			            	if(getStickmanFX(name).mType == StickmanFX.TYPE.MALE)
			                    {
			                    	getStickmanFX(name).mBodyFX.mMaleColor = HandleColor.switchColor(bodycolor);
			                    	getStickmanFX(name).update();
			                    }
			                    else
			                    {
			                    	getStickmanFX(name).mBodyFX.mFemaleColor = HandleColor.switchColor(bodycolor); 
			                    	getStickmanFX(name).update();
			                    }
			            });
		    		}
		            
		            String haircolor = mStick.gethairColor();
		            if((haircolor != null))
		            {
			            Platform.runLater(() -> 
			            {
			            	if(getStickmanFX(name).mType == StickmanFX.TYPE.MALE)
			                    {
			                    	getStickmanFX(name).mMaleHairFX.mColor = HandleColor.switchColor(haircolor);
			                    	getStickmanFX(name).update();
			                    }
			                 else
			                    {
			                    	getStickmanFX(name).mFemaleHairFX.mColor = HandleColor.switchColor(haircolor); 
			                    	getStickmanFX(name).update();
			                    }   
			            });
		            }
		            
		            String headcolor = mStick.getheadColor();
		            if(headcolor != null)
		            {
			            Platform.runLater(() -> 
			            {
			            	getStickmanFX(name).mHeadFX.mColor = HandleColor.switchColor(headcolor);
			            	if(getStickmanFX(name).mHeadFX.mColor != null)
			            		getStickmanFX(name).update();
			            });
		            }
		            
		            String limbscolor = mStick.getlimbsColor();
		            if(limbscolor != null)
		            {
			            Platform.runLater(() -> 
			            {
			            	getStickmanFX(name).mLeftUpperLegFX.mColor = HandleColor.switchColor(limbscolor);
			            	getStickmanFX(name).mLeftForeLegFX.mColor = HandleColor.switchColor(limbscolor);
			            	getStickmanFX(name).mLeftFootFX.mColor = HandleColor.switchColor(limbscolor);
			            	getStickmanFX(name).mRightUpperLegFX.mColor = HandleColor.switchColor(limbscolor);
			            	getStickmanFX(name).mRightForeLegFX.mColor = HandleColor.switchColor(limbscolor);
			            	getStickmanFX(name).mRightFootFX.mColor = HandleColor.switchColor(limbscolor);
			            	getStickmanFX(name).mLeftHandFX.mColor = HandleColor.switchColor(limbscolor);
			            	getStickmanFX(name).mRightHandFX.mColor = HandleColor.switchColor(limbscolor);
			            	getStickmanFX(name).mLeftShoulderFX.mColor = HandleColor.switchColor(limbscolor);
			            	getStickmanFX(name).mRightShoulderFX.mColor = HandleColor.switchColor(limbscolor);
			            	getStickmanFX(name).mLeftUpperArmFX.mColor = HandleColor.switchColor(limbscolor);        	
			            	getStickmanFX(name).mLeftForeArmFX.mColor = HandleColor.switchColor(limbscolor);           	
			            	getStickmanFX(name).mRightUpperArmFX.mColor = HandleColor.switchColor(limbscolor);
			            	getStickmanFX(name).mRightForeArmFX.mColor = HandleColor.switchColor(limbscolor);
			            	getStickmanFX(name).mNeckFX.mColor = HandleColor.switchColor(limbscolor);
			                getStickmanFX(name).update();
			            });
		            }
		    	}
	    	}
    	}
    }
    
    public void start(Stage stage) throws Exception {
    	StickmanStageFX.primaryStage = stage;
    	
	    FXMLLoader loader = new FXMLLoader();
	    loader.setLocation(getClass().getResource("/de/dfki/stickmanfx/StickmanStageView.fxml"));
	    root = loader.load();
	    
	  //get StickmanFlowPane from Scene Builder
	    sStickmanPane = (HBox) root.lookup("#StickmanFlowPane"); 
	 // get SplitPane from Scene Builder
        mSplitPane = (SplitPane)root.lookup("#mSplitPane");
        
        addStickmanToStage();
        
        initialStickmanWithXml();
	    
	    StickmanStageController mStickmanStageController = loader.getController();
        mStickmanStageController.getStickmanStageFX(this);
        mStickmanStageController.setlePerlinNoiseOn();
        
        sStickmanPane.prefWidthProperty().bind(root.widthProperty());
        sStickmanPane.setAlignment(Pos.CENTER);
        
	    if(!StageController){	    	
	        if(!root.getChildren().contains(mSplitPane)){
	        	root.getChildren().remove(sStickmanPane);
	        	root.getChildren().add(mSplitPane);
	        	root.getChildren().add(sStickmanPane);
	        }   
    	}else{
    		if(root.getChildren().contains(mSplitPane)){
	        	root.getChildren().remove(mSplitPane);
	        }
    	}

       scene = new Scene(root);
       scene.getStylesheets().add(this.getClass().getResource("StickmanCSS.css").toExternalForm());
 
       stage.setTitle("StickmanFX");
       stage.setScene(scene);   
       stage.show();
       
       stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
    	   @Override
           public void handle(WindowEvent event) {
    		   clearStage();
           }
       });
       
//     scene.setOnMouseClicked(mouseHandler);
    }
    
    public Stage getStage(){
    	return StickmanStageFX.primaryStage;
    }
    
    public static void lauchStickman(String filepath)
    {
    	mFilePath = filepath;
    	StageController = true;
    	
        if(!isRunning){
            isRunning = true;
            launch();
            
        }else{
        	initConnectionToServer();
            reLaunch();
        }
    }
    
    public static void lauchStickmanConfig(String filepath)
    {
    	mFilePath = filepath;
       	StageController = false;
    	
   	 	if(!isRunning){
           isRunning = true;
           launch();
   	 	}else{
           reLaunch();
       }

    }
    
    public static void lauchStickman()
    {
    	StageController = true;
        if(!isRunning){
            isRunning = true;
            launch();
            
        }else{
        	initConnectionToServer();
            reLaunch();
        }
    }
    
    public static void lauchStickmanConfig()
    {
       	StageController = false;
    	
   	 	if(!isRunning){
           isRunning = true;
           launch();
   	 	}else{
           reLaunch();
       }

    }

    private static void reLaunch() {
    	
//        initialStickmanWithXml();
        Platform.runLater(()->
        {
        	initialStickmanWithXml();
	        if(!StageController){
	        	if(!root.getChildren().contains(mSplitPane)){
		        	root.getChildren().remove(sStickmanPane);
		        	root.getChildren().add(mSplitPane);
		        	root.getChildren().add(sStickmanPane);
	        	}
	        }
	        else{
	        	if(root.getChildren().contains(mSplitPane)){
		        	root.getChildren().remove(mSplitPane);
	        	}
	        }
        });
        
        Platform.runLater(()->addStickmanToStage());
        Platform.runLater(()->{
        	primaryStage.show();
	        primaryStage.toFront();
        });
        
    }

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
//    	getInstanceFullScreen();
//    	addStickmanFX("Bob");
//    	addStickmanFX("Anna");
    	addStickmanFX("character");
    	addStickmanFX("abbey");   	
//    	lauchStickman();
    	lauchStickmanConfig("/Users/Robbie");
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
//        	getStickmanFX("Bob").doAnimation("BombeExplosion", 1000, true);
        	getStickmanFX("Bob").doAnimation("Speaking", 3000, "Stell Dir vor, Du kommst nach Hause, und ein Pferd steht in der Küche.", false);
//        	if(mouseEvent.getButton().equals(MouseButton.SECONDARY)){
//        		getStickmanFX("Bob").doAnimation("FadeIn", 1000, true);
//        	}else{
//        		getStickmanFX("Bob").doAnimation("FadeOut", 1000, true);
//        	}        	
//        	getStickmanFX("Bob").doAnimation("StopIdle", 1000, true);
//    
        }
     
    }; 

    private static class StickmanStageLogFormatter extends Formatter {

        @Override
        public String format(LogRecord record) {
            return ((new StringBuffer()).append(record.getLevel()).append(": ").append(record.getMessage()).append("\n")).toString();
        }
    }
      
}
