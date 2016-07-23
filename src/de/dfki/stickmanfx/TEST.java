package de.dfki.stickmanfx;

//import de.dfki.stickman.view.StickmanLaunch;

import de.dfki.stickman.bodyfx.BodyFX;
import de.dfki.stickman.bodyfx.HeadFX;
import de.dfki.stickman.bodyfx.LeftEyeFX;
import de.dfki.stickman.bodyfx.LeftEyebrowFX;
import de.dfki.stickman.bodyfx.LeftForeArmFX;
import de.dfki.stickman.bodyfx.LeftHandFX;
import de.dfki.stickman.bodyfx.LeftLegFX;
import de.dfki.stickman.bodyfx.LeftShoulderFX;
import de.dfki.stickman.bodyfx.LeftUpperArmFX;
import de.dfki.stickman.bodyfx.MouthFX;
import de.dfki.stickman.bodyfx.NeckFX;
import de.dfki.stickman.bodyfx.RightEyeFX;
import de.dfki.stickman.bodyfx.RightEyebrowFX;
import de.dfki.stickman.bodyfx.RightForeArmFX;
import de.dfki.stickman.bodyfx.RightHandFX;
import de.dfki.stickman.bodyfx.RightLegFX;
import de.dfki.stickman.bodyfx.RightShoulderFX;
import de.dfki.stickman.bodyfx.RightUpperArmFX;
import de.dfki.stickman.view.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
//import de.dfki.stickman.view.StickmanLaunch;

public class TEST extends Application
{
    private static FlowPane sFlowPane;
    public static StickmanFX sMale = new StickmanFX("Bob", StickmanFX.TYPE.MALE);
    public static StickmanFX sFemale = new StickmanFX("Anna", StickmanFX.TYPE.FEMALE);

    @Override
    public void start(Stage stage) throws Exception 
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/de/dfki/stickmanfx/StickmanStageView.fxml"));
        Parent root = loader.load();
        
        
        Scene scene = new Scene(root);
        sFlowPane = (FlowPane) scene.lookup("#StickmanFlowPane"); //get StickmanFlowPane from Scene Builder
        //******************************TEST********************************//
        
        sFlowPane.getChildren().addAll(sMale, sFemale);
        //****************************END TEST*****************************//
        stage.setScene(scene);
        stage.setResizable(false);
        scene.getStylesheets().add(this.getClass().getResource("StickmanCSS.css").toExternalForm());
        stage.show();
    }
    
    public static void main(String[] args)
    {
        launch(args);
    }
	
}
