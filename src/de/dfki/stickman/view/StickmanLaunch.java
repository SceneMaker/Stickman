package de.dfki.stickman.view;

import de.dfki.stickman.Stickman;
import de.dfki.stickman.body.Head;
import de.dfki.stickman.body.RightEye;
import de.dfki.stickmanfx.StickmanFX;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class StickmanLaunch extends Application {

    private Stage primaryStage;
    private AnchorPane rootLayout;
    
    public StickmanLaunch()
    {
        
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("StickEditDialog");

        initRootLayout();
    }

    public void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("StickmanEdit.fxml"));
            rootLayout = (AnchorPane) loader.load();
            
            
            
//            StickmanEditController controller = loader.getController();
            Scene scene = new Scene(rootLayout);
             
            primaryStage.setScene(scene);
            scene.getStylesheets().add(this.getClass().getResource("StickmanEdit.css").toExternalForm());
            primaryStage.show();
           
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

//    public static void main(String[] args) {
//        launch(args);
//    }
    
    public void tryLaunch() {
        launch();
    }
}