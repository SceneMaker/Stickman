package de.dfki.stickmanfx;

import java.awt.geom.GeneralPath;
import java.util.ArrayList;
import java.util.stream.Collectors;
import de.dfki.stickman.*;

import de.dfki.stickmanfx.bodyfx.BodyFX;
import de.dfki.stickmanfx.bodyfx.FaceWrinkleFX;
import de.dfki.stickmanfx.bodyfx.FemaleHairFX;
import de.dfki.stickmanfx.bodyfx.HeadFX;
import de.dfki.stickmanfx.bodyfx.LeftEyeFX;
import de.dfki.stickmanfx.bodyfx.LeftEyebrowFX;
import de.dfki.stickmanfx.bodyfx.LeftForeArmFX;
import de.dfki.stickmanfx.bodyfx.LeftHandFX;
import de.dfki.stickmanfx.bodyfx.LeftLegFX;
import de.dfki.stickmanfx.bodyfx.LeftShoulderFX;
import de.dfki.stickmanfx.bodyfx.LeftUpperArmFX;
import de.dfki.stickmanfx.bodyfx.MaleHairFX;
import de.dfki.stickmanfx.bodyfx.MouthFX;
import de.dfki.stickmanfx.bodyfx.NeckFX;
import de.dfki.stickmanfx.bodyfx.RightEyeFX;
import de.dfki.stickmanfx.bodyfx.RightEyebrowFX;
import de.dfki.stickmanfx.bodyfx.RightForeArmFX;
import de.dfki.stickmanfx.bodyfx.RightHandFX;
import de.dfki.stickmanfx.bodyfx.RightLegFX;
import de.dfki.stickmanfx.bodyfx.RightShoulderFX;
import de.dfki.stickmanfx.bodyfx.RightUpperArmFX;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
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

    
    private static String packEmotionExpression = "de.dfki.stickmanfx.animation.facefx";
    private static String packGesture = "de.dfki.stickmanfx.animation.esturefx";
	
    private static StickmanFX sStickman;
    private StickmanStageFX mStickmanstage;
    private String mStickmancombobox = null;
    final private ToggleGroup groupPerlin = new ToggleGroup();;
    
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
    private Label ShowEmotionName;

    @FXML
    private RadioButton CoverMouth;
    @FXML
    private RadioButton TouchHead;
    @FXML
    private RadioButton WaveLeft;
    @FXML
    private RadioButton WaveRight;
    
    @FXML
    private RadioButton WithPerlinNoise;
    @FXML
    private RadioButton WithoutPerlinNoise;

    @FXML
    private ComboBox<String> StickmanComboBox;
    @FXML
    private ComboBox<String> HeadComboBoxColor;
    @FXML
    private ComboBox<String> HairComboBoxColor;
    @FXML
    private ComboBox<String> BodyComboBoxColor;
    @FXML
    private ComboBox<String> LimbsComboBoxColor;
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
    private Button RestButton;
    
    

    @FXML
    public void initialize() 
    {
        setIdForLabel();
        HeadComboBoxColor.getItems().addAll("Festucine","Beige","Blue", "Black","Red");
        HairComboBoxColor.getItems().addAll("Saffron Yellow","Brown", "Yellow","Beige","Blue","Black","Red","Gold");
        BodyComboBoxColor.getItems().addAll("Purple","Green","Beige","Black","Yellow","White");
        LimbsComboBoxColor.getItems().addAll("Black","Yellow","White");
        
        //Default show
        handleStickman();
            
        fillComboForEmotionExpression();
        
      //Select a stickman
        StickmanComboBox.setOnAction((event) -> 
        {
        	mStickmancombobox = StickmanComboBox.getSelectionModel().getSelectedItem();    	
        	// set the setValue of combobox
        	setComboboxValue(mStickmanstage.getStickmanFX(mStickmancombobox));
        });
        
      //Show emotion
        EmotionExpressionComboBox.setOnAction((event) -> 
        {
            String mEmotion = EmotionExpressionComboBox.getSelectionModel().getSelectedItem();
            
            if ((mEmotion != null)&&(mStickmancombobox != null)){
            Platform.runLater(() -> 
            {
            	mStickmanstage.getStickmanFX(mStickmancombobox).doAnimation(mEmotion, 70, true);
            	EmotionExpressionComboBox.getSelectionModel().clearSelection();
            	ShowEmotionName.setText(mEmotion);
            }
            );
            }
        });

        //change bodyColor
        BodyComboBoxColor.setOnAction((event) -> 
        {
            String color = BodyComboBoxColor.getSelectionModel().getSelectedItem();
            if ((color != null)&&(mStickmancombobox != null)){
            Platform.runLater(() -> 
            {
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
            });
            }
            
        });
        
        //change bodyColor
        HairComboBoxColor.setOnAction((event) -> 
        {
            String color = HairComboBoxColor.getSelectionModel().getSelectedItem();
            if ((color != null)&&(mStickmancombobox != null)){
            Platform.runLater(() -> 
            {
            	if(mStickmanstage.getStickmanFX(mStickmancombobox).mType == StickmanFX.TYPE.MALE)
                    {
                    	mStickmanstage.getStickmanFX(mStickmancombobox).mMaleHairFX.mColor = switchColor(color);
                    	mStickmanstage.getStickmanFX(mStickmancombobox).update();
                    }
                 else
                    {
                    	mStickmanstage.getStickmanFX(mStickmancombobox).mFemaleHairFX.mColor = switchColor(color); 
                    	mStickmanstage.getStickmanFX(mStickmancombobox).update();
                    }   
            });
            }
            
        });
        
        //change head Color
        HeadComboBoxColor.setOnAction((event) -> 
        {
            String color = HeadComboBoxColor.getSelectionModel().getSelectedItem();
            if ((color != null)&&(mStickmancombobox != null)){
            Platform.runLater(() -> 
            {
            	mStickmanstage.getStickmanFX(mStickmancombobox).mHeadFX.mColor = switchColor(color);
            	if(mStickmanstage.getStickmanFX(mStickmancombobox).mHeadFX.mColor != null)
            		mStickmanstage.getStickmanFX(mStickmancombobox).update();
            });
            }         
        });
        
      //change limbs Color
        LimbsComboBoxColor.setOnAction((event) -> 
        {
            String color = LimbsComboBoxColor.getSelectionModel().getSelectedItem();
            if ((color != null)&&(mStickmancombobox != null)){
            Platform.runLater(() -> 
            {
            	//mStickmanstage.getStickmanFX(mStickmancombobox).mLeftLegFX.mColor = switchColor(color);
            	mStickmanstage.getStickmanFX(mStickmancombobox).mLeftUpperLegFX.mColor = switchColor(color);
            	mStickmanstage.getStickmanFX(mStickmancombobox).mLeftForeLegFX.mColor = switchColor(color);
            	mStickmanstage.getStickmanFX(mStickmancombobox).mLeftFootFX.mColor = switchColor(color);
//            	mStickmanstage.getStickmanFX(mStickmancombobox).mRightLegFX.mColor = switchColor(color);
            	mStickmanstage.getStickmanFX(mStickmancombobox).mRightUpperLegFX.mColor = switchColor(color);
            	mStickmanstage.getStickmanFX(mStickmancombobox).mRightForeLegFX.mColor = switchColor(color);
            	mStickmanstage.getStickmanFX(mStickmancombobox).mRightFootFX.mColor = switchColor(color);
            	mStickmanstage.getStickmanFX(mStickmancombobox).mLeftHandFX.mColor = switchColor(color);
            	mStickmanstage.getStickmanFX(mStickmancombobox).mRightHandFX.mColor = switchColor(color);
            	mStickmanstage.getStickmanFX(mStickmancombobox).mLeftShoulderFX.mColor = switchColor(color);
            	mStickmanstage.getStickmanFX(mStickmancombobox).mRightShoulderFX.mColor = switchColor(color);
            	mStickmanstage.getStickmanFX(mStickmancombobox).mLeftUpperArmFX.mColor = switchColor(color);        	
            	mStickmanstage.getStickmanFX(mStickmancombobox).mLeftForeArmFX.mColor = switchColor(color);           	
            	mStickmanstage.getStickmanFX(mStickmancombobox).mRightUpperArmFX.mColor = switchColor(color);
            	mStickmanstage.getStickmanFX(mStickmancombobox).mRightForeArmFX.mColor = switchColor(color);
            	mStickmanstage.getStickmanFX(mStickmancombobox).mNeckFX.mColor = switchColor(color);
                mStickmanstage.getStickmanFX(mStickmancombobox).update();
            });
            }         
        });
        
        // set the color to default value
        RestButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	if ((mStickmancombobox != null)){
                    Platform.runLater(() -> 
                    {
                    	if(mStickmanstage.getStickmanFX(mStickmancombobox).mType == StickmanFX.TYPE.MALE)
                        {
                    		HeadComboBoxColor.setValue("Festucine");
                        	HairComboBoxColor.setValue("Brown");
                        	BodyComboBoxColor.setValue("Green");
                        	LimbsComboBoxColor.setValue("Black");
                        }
                    	else
                        {
                    	   HeadComboBoxColor.setValue("Festucine");
                     	   HairComboBoxColor.setValue("Saffron Yellow");
                     	   BodyComboBoxColor.setValue("Purple");
                     	   LimbsComboBoxColor.setValue("Black");
                        }              	
                    });
                    }
            	WithPerlinNoise.setSelected(true);
            }
        });
        
        handlePerlinNoise();
    }    
    
    public void getStickmanStageFX(StickmanStageFX Stickmanstage)
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
//                c = Color.BLACK;
            	c = Color.rgb(80, 80, 80);
                break;
            case "Blue":
                c = Color.BLUE;
                break;
            case "Red":
                c = Color.RED;
                break;
            case "Gold":
                c = Color.GOLD;
                break;
            case "Brown":
                c = Color.rgb(97, 58, 0, 1);
                break;   
            case "Saffron Yellow":
                c = Color.rgb(240, 212, 0, 1);
                break;
            case "Festucine":
                c = Color.rgb(242, 227, 217, 1);
                break;
            case "Green":
                c = Color.rgb(14, 134, 122, (240 * 100 / 255) / 100f);
                break;
            case "Purple":
                c = Color.rgb(154, 83, 198, (240 * 100 / 255) / 100f);
                break;
            default:
            	c = null;
            	break;
        }
        return c;
    }
    
    private String switchColorToString(Color color)
    {
        String s = null;
        if (color.equals(Color.BEIGE))
        	s= "Beige";
        if (color.equals(Color.YELLOW))
        	s= "Yellow";
        if (color.equals(Color.WHITE))
        	s= "White";
//        if (color.equals(Color.BLACK))
        if (color.equals(Color.rgb(80, 80, 80)))
        	s= "Black";
        if (color.equals(Color.BLUE))
        	s= "Blue";
        if (color.equals(Color.RED))
        	s= "Red";
        if (color.equals(Color.GOLD))
        	s= "Gold";
        if (color.equals(Color.rgb(97, 58, 0, 1)))
        	s= "Brown";
        if (color.equals(Color.rgb(240, 212, 0, 1)))
        	s= "Saffron Yellow";
        if (color.equals(Color.rgb(242, 227, 217, 1)))
        	s= "Festucine";
        if (color.equals(Color.rgb(14, 134, 122, (240 * 100 / 255) / 100f)))
        	s= "Green";
        if (color.equals(Color.rgb(154, 83, 198, (240 * 100 / 255) / 100f)))
        	s= "Purple";
        return s;
    }
    
 // set the setValue of combobox
    private void setComboboxValue(StickmanFX mStick)
    { 	
   	 if(mStick.mType == StickmanFX.TYPE.MALE)
       {
       	String sBodyComboBoxColor = switchColorToString(mStick.mBodyFX.mMaleColor);
       	if(sBodyComboBoxColor!=null)
       		BodyComboBoxColor.setValue(sBodyComboBoxColor);       		
       }
   	 else
   	 {
   		 String sBodyComboBoxColor = switchColorToString(mStick.mBodyFX.mFemaleColor );
   		 if(sBodyComboBoxColor!=null)
   			 BodyComboBoxColor.setValue(sBodyComboBoxColor);		
   	 }
   	 
   	 if(mStick.mType == StickmanFX.TYPE.MALE)
        {
        	String sHairComboBoxColor = switchColorToString(mStick.mMaleHairFX.mColor);
        	if(sHairComboBoxColor!=null)
        		HairComboBoxColor.setValue(sHairComboBoxColor);  		
        }
    	 else
    	 {
    		 String sHairComboBoxColor = switchColorToString(mStick.mFemaleHairFX.mColor);
    		 if(sHairComboBoxColor!=null)
    			HairComboBoxColor.setValue(sHairComboBoxColor);
     		
    	 }
   	 
   	 String sHeadComboBoxColor = switchColorToString(mStick.mHeadFX.mColor);
     		if(sHeadComboBoxColor!=null)
     			HeadComboBoxColor.setValue(sHeadComboBoxColor);  
     		
     	String sLimbsComboBoxColor = switchColorToString(mStick.mLeftUpperLegFX.mColor);
     		if(sLimbsComboBoxColor!=null)
     			LimbsComboBoxColor.setValue(sLimbsComboBoxColor);
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
        ShowEmotionName.setText("");
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
    
    private void handlePerlinNoise()
    {
    	WithPerlinNoise.setUserData("With Perlin Noise");
        WithoutPerlinNoise.setUserData("Without Perlin Noise");
    	WithPerlinNoise.setToggleGroup(groupPerlin);
        WithoutPerlinNoise.setToggleGroup(groupPerlin);
        
        groupPerlin.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {
              if ((groupPerlin.getSelectedToggle() != null)&&((null != mStickmanstage.mStickmanComboList) && (!mStickmanstage.mStickmanComboList.isEmpty()))) {
            	  if(groupPerlin.getSelectedToggle().getUserData().toString() == "With Perlin Noise"){       	
            	            Platform.runLater(() -> 
            	            {
            	            	for(String key : mStickmanstage.mStickmanComboList)
            	            		mStickmanstage.getStickmanFX(key).doAnimation("StartIdle", 1000, true);            
            	            }
            	            );
            	  }
            	  else{
            		  Platform.runLater(() -> 
      	            {
      	            	for(String key : mStickmanstage.mStickmanComboList)
      	            		mStickmanstage.getStickmanFX(key).doAnimation("StopIdle", 1000, true);            
      	            }
      	            );
            	  }
              }
            }
          });
    }
    
    public void setlePerlinNoiseOn(){
    	WithPerlinNoise.setSelected(true);
    }
    
}
