package de.dfki.stickmanfx;

import static de.dfki.stickman.animationlogic.util.Interpolator.linear;

import java.awt.geom.GeneralPath;
import java.util.ArrayList;
import java.util.stream.Collectors;
import de.dfki.stickman.*;

import de.dfki.stickman.view.*;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

/**
 *
 * @author Robbie
 */
public class StickmanStageController {

    
    private static String packEmotionExpression = "de.dfki.stickman.animation.face";
    private static String packGesture = "de.dfki.stickman.animation.gesture";
	
    private static StickmanFX sStickman;
    private StickmanStageFX2 mStickmanstage;
    private String mStickmancombobox = null;
    
    @FXML
    private Label Stickman;
    @FXML
    private Label BodyColour;
    @FXML
    private Label Environment;
    @FXML
    private Label EmotionExpression;
    @FXML
    private Label IdleSection;
    @FXML
    private Label Posture;

    @FXML
    private RadioButton CoverMouth;
    @FXML
    private RadioButton TouchHead;
    @FXML
    private RadioButton WaveLeft;
    @FXML
    private RadioButton WaveRight;

    @FXML
    private ComboBox<String> StickmanComboBox;
    @FXML
    private ComboBox<String> HeadComboBoxColor;
    @FXML
    private ComboBox<String> HairComboBoxColor;
    @FXML
    private ComboBox<String> FaceComboBoxColor;
    @FXML
    private ComboBox<String> BodyComboBoxColor;
    @FXML
    private ComboBox<String> LegComboBoxColor;
    @FXML
    private ComboBox<String> EmotionExpressionComboBox;
    
    @FXML
    private GridPane gridPaneControlStickman;
    @FXML
    private GridPane gridPaneControlColor;
    @FXML
    private GridPane gridPaneControlEmotion;
    @FXML
    private GridPane gridPaneControlIdleSection;
    @FXML
    private GridPane gridPaneControlEnvironment;
    @FXML
    private GridPane gridPaneControlPosture;
    @FXML
    private HBox StickmanFlowPane;
    
    

    @FXML
    public void initialize() 
    {
        sStickman = StickmanStageFX.sMale;
        setIdForLabel();
        HeadComboBoxColor.setValue("Beige");
        HeadComboBoxColor.getItems().addAll("Blue", "Black");

        HairComboBoxColor.setValue("Yellow");
        HairComboBoxColor.getItems().addAll("Beige","Blue","Black","Red","Blond");

        FaceComboBoxColor.setValue("Beige");
        FaceComboBoxColor.getItems().addAll("Blue","Black","Red");

        BodyComboBoxColor.setValue("Beige");
        BodyComboBoxColor.getItems().addAll("Black","Yellow","White");

        LegComboBoxColor.setValue("Black");
        LegComboBoxColor.getItems().addAll("Black","Yellow","White");
        
        //Default show
        handleStickman();
       
        
        fillComboForEmotionExpression();
        
      //Select a stickman
        StickmanComboBox.setOnAction((event) -> 
        {
        	mStickmancombobox = StickmanComboBox.getSelectionModel().getSelectedItem();         
        });
        
      //Show emotion
        EmotionExpressionComboBox.setOnAction((event) -> 
        {
            String mEmotion = EmotionExpressionComboBox.getSelectionModel().getSelectedItem();
            
            if (mStickmancombobox != null){
            Platform.runLater(() -> 
            {
            	mStickmanstage.getStickmanFX(mStickmancombobox).doAnimation(mEmotion, 70, true);
            }
            );
            }
        });

       
        //change bodyColor
        BodyComboBoxColor.setOnAction((event) -> 
        {
            String color = BodyComboBoxColor.getSelectionModel().getSelectedItem();
            if (mStickmancombobox != null){
            Platform.runLater(() -> 
            {
//                for(String key : StickmanStageFX.sStickmansOnStage.keySet())
//                {
//                    StickmanFX stickman =StickmanStageFX.sStickmansOnStage.get(key);
                    if(mStickmanstage.getStickmanFX(mStickmancombobox).mType == StickmanFX.TYPE.MALE)
                    {
                    	mStickmanstage.getStickmanFX(mStickmancombobox).mBodyFX.mMaleColor = switchColor(color);
                    	mStickmanstage.getStickmanFX(mStickmancombobox).update();
                    }
                    else
                    {
                    	mStickmanstage.getStickmanFX(mStickmancombobox).mBodyFX.mFemaleColor = switchColor(color); 
                    	mStickmanstage.getStickmanFX(mStickmancombobox).update();
                    }   
//                }
            });
            }
            
        });
    }
    
    public void getStickmanStageFX(StickmanStageFX2 Stickmanstage)
    {
    	this.mStickmanstage = Stickmanstage;
    	fillComboForStickman();
    	
    }
    private void fillComboForEmotionExpression()
    {
    	ArrayList<String> getClassesNames;
    	StickmanFillCombo mStickmanFillCombo = new StickmanFillCombo(packEmotionExpression);
    	getClassesNames = mStickmanFillCombo.getComboList();
    	ObservableList<String> classNames = FXCollections.observableArrayList();
    	classNames.addAll(getClassesNames.stream().collect(Collectors.toList()));
    	EmotionExpressionComboBox.getItems().addAll(classNames);
    }
    
    private void fillComboForStickman()
    {
    	ObservableList<String> stickmanNames = FXCollections.observableArrayList();
    	stickmanNames.addAll(mStickmanstage.mStickmanComboList.stream().collect(Collectors.toList()));
    	StickmanComboBox.getItems().addAll(stickmanNames);
    }
    
    private Color switchColor(String color)
    {
        Color c = null;
        switch(color)
        {
            case "Beige": 
                c = Color.BEIGE;
                break;
            case "Yellow":
                c = Color.YELLOW;
                break;
            case "White":
                c = Color.WHITE;
                break;
            case "Black":
                c = Color.BLACK;
                break;
        }
        return c;
    }
    
    @FXML
    private void handleStickman()
    { 	
    	gridPaneControlStickman.setVisible(true);
        gridPaneControlColor.setVisible(false);
        gridPaneControlEmotion.setVisible(false);
        gridPaneControlIdleSection.setVisible(false);
        gridPaneControlEnvironment.setVisible(false);
        gridPaneControlPosture.setVisible(false);
    }
    
    @FXML
    private void handleBodyColour()
    { 	
    	gridPaneControlStickman.setVisible(false);
        gridPaneControlColor.setVisible(true);
        gridPaneControlEmotion.setVisible(false);
        gridPaneControlIdleSection.setVisible(false);
        gridPaneControlEnvironment.setVisible(false);
        gridPaneControlPosture.setVisible(false);
    }
    
    @FXML
    private void handleEmotionExpression()
    {
    	gridPaneControlStickman.setVisible(false);
        gridPaneControlColor.setVisible(false);
        gridPaneControlEmotion.setVisible(true);
        gridPaneControlIdleSection.setVisible(false);
        gridPaneControlEnvironment.setVisible(false);
        gridPaneControlPosture.setVisible(false);
    }
    
    @FXML
    private void handleIdleSection()
    {
    	gridPaneControlStickman.setVisible(false);
        gridPaneControlColor.setVisible(false);
        gridPaneControlEmotion.setVisible(false);
        gridPaneControlIdleSection.setVisible(true);
        gridPaneControlEnvironment.setVisible(false);
        gridPaneControlPosture.setVisible(false);
    }
    
    @FXML
    private void handleEnvironment()
    {
    	gridPaneControlStickman.setVisible(false);
        gridPaneControlColor.setVisible(false);
        gridPaneControlEmotion.setVisible(false);
        gridPaneControlIdleSection.setVisible(false);
        gridPaneControlEnvironment.setVisible(true);
        gridPaneControlPosture.setVisible(false);
    }
    
    @FXML
    private void handlePosture()
    {
    	gridPaneControlStickman.setVisible(false);
        gridPaneControlColor.setVisible(false);
        gridPaneControlEmotion.setVisible(false);
        gridPaneControlIdleSection.setVisible(false);
        gridPaneControlEnvironment.setVisible(false);
        gridPaneControlPosture.setVisible(true);
    }

    private void setIdForLabel() 
    {
        BodyColour.setId("Menu");
        Environment.setId("Menu");
        EmotionExpression.setId("Menu");
        IdleSection.setId("Menu");
        Posture.setId("Menu");
        Stickman.setId("Menu");
    }
    
    
}
