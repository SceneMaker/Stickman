package de.dfki.stickman.view;

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
import javafx.scene.layout.GridPane;

/**
 *
 * @author Robbie
 */

public class StickmanEditController {
	
//    ObservableList<String> options = 
//    FXCollections.observableArrayList(
//        "Option 1",
//        "Option 2",
//        "Option 3"
//    );
	
	@FXML
	private Label BodyColour;
	@FXML
	private Label Gesture;
	@FXML
	private Label EmotionExpression;
	@FXML
	private Label Environment;
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
    private GridPane gridPaneControlColor;
	@FXML
    private GridPane gridPaneControlEmotion;
	@FXML
    private GridPane gridPaneControlEnvironment;
	@FXML
    private GridPane gridPaneControlGesture;
	@FXML
    private GridPane gridPaneControlPosture;

	@FXML
	public void initialize()
	{
	   
		HeadComboBoxColor.setValue("Beige");
		HeadComboBoxColor.getItems().addAll(
	              "Blue",
	              "Black"
	          );
		
		HairComboBoxColor.setValue("Yellow");
	    HairComboBoxColor.getItems().addAll(
	              "Beige",
	              "Blue",
	              "Black",
	              "Red",
	              "Blond"
	          );
	    
	    FaceComboBoxColor.setValue("Beige");
	    FaceComboBoxColor.getItems().addAll(
	              "Blue",
	              "Black",
	              "Red"
	          );
		
	    BodyComboBoxColor.setValue("Beige");
	    BodyComboBoxColor.getItems().addAll(
	              "Black",
	              "Yellow",
	              "White"
	          );
		
	    LegComboBoxColor.setValue("Black");
	    LegComboBoxColor.getItems().addAll(
	    		  "Black",
	              "Yellow",
	              "White"
	          );
	    gridPaneControlColor.setVisible(true);
    	gridPaneControlEmotion.setVisible(false);
    	gridPaneControlEnvironment.setVisible(false);
    	gridPaneControlGesture.setVisible(false);
    	gridPaneControlPosture.setVisible(false);
	    
	    BodyColour.setOnMouseClicked(new EventHandler<MouseEvent>() {
	        @Override
	        public void handle(MouseEvent e) {
	        	gridPaneControlColor.setVisible(true);
	        	gridPaneControlEmotion.setVisible(false);
	        	gridPaneControlEnvironment.setVisible(false);
	        	gridPaneControlGesture.setVisible(false);
	        	gridPaneControlPosture.setVisible(false);
	        }
	      });
	    
	    EmotionExpression.setOnMouseClicked(new EventHandler<MouseEvent>() {
	        @Override
	        public void handle(MouseEvent e) {
	        	gridPaneControlColor.setVisible(false);
	        	gridPaneControlEmotion.setVisible(true);
	        	gridPaneControlEnvironment.setVisible(false);
	        	gridPaneControlGesture.setVisible(false);
	        	gridPaneControlPosture.setVisible(false);
	        }
	      });
	    
	    Environment.setOnMouseClicked(new EventHandler<MouseEvent>() {
	        @Override
	        public void handle(MouseEvent e) {
	        	gridPaneControlColor.setVisible(false);
	        	gridPaneControlEmotion.setVisible(false);
	        	gridPaneControlEnvironment.setVisible(true);
	        	gridPaneControlGesture.setVisible(false);
	        	gridPaneControlPosture.setVisible(false);
	        }
	      });
	    
	    Gesture.setOnMouseClicked(new EventHandler<MouseEvent>() {
	        @Override
	        public void handle(MouseEvent e) {
	        	gridPaneControlColor.setVisible(false);
	        	gridPaneControlEmotion.setVisible(false);
	        	gridPaneControlEnvironment.setVisible(false);
	        	gridPaneControlGesture.setVisible(true);
	        	gridPaneControlPosture.setVisible(false);
	        }
	      });
	    
	    Posture.setOnMouseClicked(new EventHandler<MouseEvent>() {
	        @Override
	        public void handle(MouseEvent e) {
	        	gridPaneControlColor.setVisible(false);
	        	gridPaneControlEmotion.setVisible(false);
	        	gridPaneControlEnvironment.setVisible(false);
	        	gridPaneControlGesture.setVisible(false);
	        	gridPaneControlPosture.setVisible(true);
	        }
	      });
	} 
}