package de.dfki.stickman.view;

import de.dfki.stickman.Stickman;
import de.dfki.stickman.body.Head;
import de.dfki.stickman.body.RightEye;
import de.dfki.stickman.bodyfx.BodyFX;
import de.dfki.stickman.bodyfx.HeadFX;
import de.dfki.stickman.bodyfx.LeftEyeFX;
import de.dfki.stickman.bodyfx.LeftEyebrowFX;
import de.dfki.stickman.bodyfx.LeftForeArmFX;
import de.dfki.stickman.bodyfx.LeftHandFX;
import de.dfki.stickman.bodyfx.LeftShoulderFX;
import de.dfki.stickman.bodyfx.LeftUpperArmFX;
import de.dfki.stickman.bodyfx.MouthFX;
import de.dfki.stickman.bodyfx.NeckFX;
import de.dfki.stickman.bodyfx.RightEyeFX;
import de.dfki.stickman.bodyfx.RightEyebrowFX;
import de.dfki.stickman.bodyfx.RightShoulderFX;
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
            
            
            //Test//////////////////////////////////////////////////////
            StickmanFX s = new StickmanFX("Anna", StickmanFX.TYPE.MALE);
            HeadFX h = new HeadFX(s);
            RightEyeFX r = new RightEyeFX(h);
            MouthFX m = new MouthFX(h);
            LeftEyebrowFX l = new LeftEyebrowFX(h);
            LeftEyeFX le = new LeftEyeFX(h);
            RightEyebrowFX ri = new RightEyebrowFX(h);
            NeckFX neck = new NeckFX(h);
            BodyFX b = new BodyFX(neck);
            LeftShoulderFX ls = new LeftShoulderFX(b);
            LeftUpperArmFX lu = new LeftUpperArmFX(ls);
            LeftForeArmFX lf = new LeftForeArmFX(lu);
            LeftHandFX lh = new LeftHandFX(lf);
            RightShoulderFX rs = new RightShoulderFX(b);
            h.update();
            r.update();
            m.update();
            l.update();
            le.update();
            ri.update();
            neck.update();
            b.update();
            ls.update();
            lu.update();
            lf.update();
            lh.update();
            rs.update();
            rootLayout.getChildren().addAll(h, r, m, l, le, ri, neck, b, ls, lu, lf, lh, rs);
            //End Test/////////////////////////////////////////////////////////////
            
            
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