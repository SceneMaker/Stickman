package de.dfki.stickmanfx;


import de.dfki.stickman.client.ClientConnectionHandler;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.HashMap;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class StickmanStageFX extends Application
{
    private static HBox sHBox;
    public static StickmanFX sMale = new StickmanFX("Bob", StickmanFX.TYPE.MALE);
    public static StickmanFX sFemale = new StickmanFX("Anna", StickmanFX.TYPE.FEMALE);
    
    public static ClientConnectionHandler mConnection;
    public static boolean mUseNetwork = false;
    public static final Logger mLogger = Logger.getAnonymousLogger();
    
    static public final HashMap<String, StickmanFX> sStickmansOnStage = new HashMap<String, StickmanFX>();
    
    
    public static Stage primaryStage;

    @Override
    public void start(Stage stage) throws Exception 
    {
//    	this.primaryStage=stage;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/de/dfki/stickmanfx/StickmanStageView.fxml"));
        HBox root = loader.load();
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
        
        
        FXMLLoader loader1 = new FXMLLoader();
        loader1.setLocation(getClass().getResource("RootLayoutStickmanFX.fxml"));
        BorderPane root1 = loader1.load();
        
        
        Scene scene = new Scene(root, width, height);

//        Scene scene1 = new Scene(root1);
        sHBox = (HBox) scene.lookup("#StickmanFlowPane"); //get StickmanFlowPane from Scene Builder
        sHBox.prefWidthProperty().bind(root.widthProperty());
        //******************************Test********************************//
        getStickman("Bob").setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) 
            {

                 getStickman("Bob").doAnimation("Surprised", 300, true);
            }
        });
        
        //Add Stickmans in FlowPane
        for(String key : sStickmansOnStage.keySet())
        {
            sHBox.getChildren().add(sStickmansOnStage.get(key));
        }
        
        //****************************End Test*****************************//
        stage.setScene(scene);
        stage.setResizable(false);
        stage.initStyle(StageStyle.UNDECORATED);
        scene.getStylesheets().add(this.getClass().getResource("StickmanCSS.css").toExternalForm());
        stage.show();
//        stage.setFullScreen(true);
        
        
    }
    
    public static void main(String[] args)
    {
        //Add Stickmans in HashMap
        addStickman("Bob", StickmanFX.TYPE.MALE);
        addStickman("Anna", StickmanFX.TYPE.FEMALE);
        launch(args);
    }
    
    /**
     * 
     * @param name: name of Stickman
     * @param gender: gender of Stickman
     */
    public static void addStickman(String name, StickmanFX.TYPE gender) 
    {
        if (!sStickmansOnStage.containsKey(name.toLowerCase())) 
        {
            sStickmansOnStage.put(name.toLowerCase(), new StickmanFX(name, gender));
        }
    }
    
    /**
     * 
     * @param name: name of Stickman
     * @return  Stickman object.
     */
    public static StickmanFX getStickman(String name) 
    {
        if (sStickmansOnStage.containsKey(name.toLowerCase())) 
        {
            return sStickmansOnStage.get(name.toLowerCase());
        } 
        else 
        {
            return null;
        }
    }
    
    public static void sendTimeMarkInformation(String timemark) 
    {
        if (mConnection.mConnected) 
        {
            mConnection.sendToServer(timemark);
        }
    }
    
    public static void sendAnimationUpdate(String state, String id) 
    {
        if (mConnection.mConnected) 
        {
            mConnection.sendToServer("#ANIM#" + state + "#" + id);
        }
    }
	
}
