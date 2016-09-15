package de.dfki.stickmanfx;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import de.dfki.common.StickmansOnStage;
import de.dfki.stickmanfx.xmlsettings.StickmanDataFX;
import de.dfki.util.HandleColor;
import de.dfki.util.StickmanFillCombo;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

/**
 *
 * @author Robbie
 */
public class StickmanStageController {

    
    private static String packEmotionExpression = "de.dfki.stickmanfx.animation.facefx";
    private static String packGesture = "de.dfki.stickmanfx.animation.esturefx";
    private ArrayList<String> mStickmanComboList = new ArrayList<>();
    private static StickmanFX sStickman;
    private StickmansOnStage mStickmanOnstage;
    private String mStickmancombobox = null;
    final private ToggleGroup groupPerlin = new ToggleGroup();
    final private ToggleGroup groupEnvironmentRadioButton = new ToggleGroup();
    
    private List<StickmanDataFX> mStickmanDataFX = new ArrayList<StickmanDataFX>();
    
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
    private RadioButton FadeIn;
    @FXML
    private RadioButton FadeOut;
    @FXML
    private RadioButton GoDown;
    @FXML
    private RadioButton ComeUp;
    @FXML
    private RadioButton DisappearToSmall;
    @FXML
    private RadioButton ComeBackFromSmall;
    @FXML
    private RadioButton Speaking;
    
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
    private ScrollPane stickmanScrollPane;
    
    @FXML
    private Button RestButton;
    @FXML
    private Button ExitButton;
    @FXML
    private Button SaveButton;
    
    

    @FXML
    public void initialize() 
    {
        setIdForLabel();
        handleGroupForEnvironmentRadioButton();
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
        	setComboboxValue(mStickmanOnstage.getStickmanFX(mStickmancombobox));
        });
        
      //Show emotion
        EmotionExpressionComboBox.setOnAction((event) -> 
        {
            String mEmotion = EmotionExpressionComboBox.getSelectionModel().getSelectedItem();
            
            if ((mEmotion != null)&&(mStickmancombobox != null)){
            Platform.runLater(() -> 
            {
            	mStickmanOnstage.getStickmanFX(mStickmancombobox).doAnimation(mEmotion, 70, true);
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
            	if(mStickmanOnstage.getStickmanFX(mStickmancombobox).mType == StickmanFX.TYPE.MALE)
                    {
                    	mStickmanOnstage.getStickmanFX(mStickmancombobox).mBodyFX.mMaleColor = HandleColor.switchColor(color);
                    	mStickmanOnstage.getStickmanFX(mStickmancombobox).update();
                    }
                    else
                    {
                    	mStickmanOnstage.getStickmanFX(mStickmancombobox).mBodyFX.mFemaleColor = HandleColor.switchColor(color);
                    	mStickmanOnstage.getStickmanFX(mStickmancombobox).update();
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
            	if(mStickmanOnstage.getStickmanFX(mStickmancombobox).mType == StickmanFX.TYPE.MALE)
                    {
                    	mStickmanOnstage.getStickmanFX(mStickmancombobox).mMaleHairFX.mColor = HandleColor.switchColor(color);
                    	mStickmanOnstage.getStickmanFX(mStickmancombobox).update();
                    }
                 else
                    {
                    	mStickmanOnstage.getStickmanFX(mStickmancombobox).mFemaleHairFX.mColor = HandleColor.switchColor(color);
                    	mStickmanOnstage.getStickmanFX(mStickmancombobox).update();
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
            	mStickmanOnstage.getStickmanFX(mStickmancombobox).mHeadFX.mColor = HandleColor.switchColor(color);
            	if(mStickmanOnstage.getStickmanFX(mStickmancombobox).mHeadFX.mColor != null)
            		mStickmanOnstage.getStickmanFX(mStickmancombobox).update();
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
            	//mStickmanOnstage.getStickmanFX(mStickmancombobox).mLeftLegFX.mColor = switchColor(color);
            	mStickmanOnstage.getStickmanFX(mStickmancombobox).mLeftUpperLegFX.mColor = HandleColor.switchColor(color);
            	mStickmanOnstage.getStickmanFX(mStickmancombobox).mLeftForeLegFX.mColor = HandleColor.switchColor(color);
            	mStickmanOnstage.getStickmanFX(mStickmancombobox).mLeftFootFX.mColor = HandleColor.switchColor(color);
//            	mStickmanOnstage.getStickmanFX(mStickmancombobox).mRightLegFX.mColor = switchColor(color);
            	mStickmanOnstage.getStickmanFX(mStickmancombobox).mRightUpperLegFX.mColor = HandleColor.switchColor(color);
            	mStickmanOnstage.getStickmanFX(mStickmancombobox).mRightForeLegFX.mColor = HandleColor.switchColor(color);
            	mStickmanOnstage.getStickmanFX(mStickmancombobox).mRightFootFX.mColor = HandleColor.switchColor(color);
            	mStickmanOnstage.getStickmanFX(mStickmancombobox).mLeftHandFX.mColor = HandleColor.switchColor(color);
            	mStickmanOnstage.getStickmanFX(mStickmancombobox).mRightHandFX.mColor = HandleColor.switchColor(color);
            	mStickmanOnstage.getStickmanFX(mStickmancombobox).mLeftShoulderFX.mColor = HandleColor.switchColor(color);
            	mStickmanOnstage.getStickmanFX(mStickmancombobox).mRightShoulderFX.mColor = HandleColor.switchColor(color);
            	mStickmanOnstage.getStickmanFX(mStickmancombobox).mLeftUpperArmFX.mColor = HandleColor.switchColor(color);
            	mStickmanOnstage.getStickmanFX(mStickmancombobox).mLeftForeArmFX.mColor = HandleColor.switchColor(color);
            	mStickmanOnstage.getStickmanFX(mStickmancombobox).mRightUpperArmFX.mColor = HandleColor.switchColor(color);
            	mStickmanOnstage.getStickmanFX(mStickmancombobox).mRightForeArmFX.mColor = HandleColor.switchColor(color);
            	mStickmanOnstage.getStickmanFX(mStickmancombobox).mNeckFX.mColor = HandleColor.switchColor(color);
                mStickmanOnstage.getStickmanFX(mStickmancombobox).update();
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
                    	if(mStickmanOnstage.getStickmanFX(mStickmancombobox).mType == StickmanFX.TYPE.MALE)
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
                    
                    if ((groupEnvironmentRadioButton.getSelectedToggle() != null))
                    {
                    	String action = groupEnvironmentRadioButton.getSelectedToggle().getUserData().toString();
                    	Platform.runLater(() -> 
                    	{
                    		switch(action)
                    		{
                    			case "FadeOut": 
                    				mStickmanOnstage.getStickmanFX(mStickmancombobox).doAnimation("FadeIn", 1000, true);
                    				break; 
                    			case "GoDown": 
                    				mStickmanOnstage.getStickmanFX(mStickmancombobox).doAnimation("ComeUp", 1000, true);
                    				break;
                    			case "DisappearToSmall": 
                    				mStickmanOnstage.getStickmanFX(mStickmancombobox).doAnimation("ComeBackFromSmall", 1000, true);
                    				break;
                    			default:
                    				break;
                    		}
                    	
                    	});
                    }
                }
            	
            	EnvironmentRadioButtonNotSelected();
            	WithPerlinNoise.setSelected(true);
            }
        });
        
        ExitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	mStickmanOnstage.clearStage();
            }
        });
        
        saveToXml();
        
        handlePerlinNoise();
    }    
    
    public void setStickamnOnStage(StickmansOnStage stickmansOnStage)
    {
    	this.mStickmanOnstage = stickmansOnStage;
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
    
    public void fillComboForStickman()
    {
    	ObservableList<String> stickmanNames = FXCollections.observableArrayList();
        stickmanNames.addAll(StickmanStageFX.getInstance().getStickmanNames().stream().collect(Collectors.toList()));
    	StickmanComboBox.getItems().addAll(stickmanNames);
    }
    
    
 // set the setValue of combobox
    private void setComboboxValue(StickmanFX mStick)
    { 	
   	 if(mStick.mType == StickmanFX.TYPE.MALE)
       {
       	String sBodyComboBoxColor = HandleColor.switchColorToString(mStick.mBodyFX.mMaleColor);
       	if(sBodyComboBoxColor!=null)
       		BodyComboBoxColor.setValue(sBodyComboBoxColor);       		
       }
   	 else
   	 {
   		 String sBodyComboBoxColor = HandleColor.switchColorToString(mStick.mBodyFX.mFemaleColor );
   		 if(sBodyComboBoxColor!=null)
   			 BodyComboBoxColor.setValue(sBodyComboBoxColor);		
   	 }
   	 
   	 if(mStick.mType == StickmanFX.TYPE.MALE)
        {
        	String sHairComboBoxColor = HandleColor.switchColorToString(mStick.mMaleHairFX.mColor);
        	if(sHairComboBoxColor!=null)
        		HairComboBoxColor.setValue(sHairComboBoxColor);  		
        }
    	 else
    	 {
    		 String sHairComboBoxColor = HandleColor.switchColorToString(mStick.mFemaleHairFX.mColor);
    		 if(sHairComboBoxColor!=null)
    			HairComboBoxColor.setValue(sHairComboBoxColor);
     		
    	 }
   	 
   	 String sHeadComboBoxColor = HandleColor.switchColorToString(mStick.mHeadFX.mColor);
     		if(sHeadComboBoxColor!=null)
     			HeadComboBoxColor.setValue(sHeadComboBoxColor);  
     		
     	String sLimbsComboBoxColor = HandleColor.switchColorToString(mStick.mLeftUpperLegFX.mColor);
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
              if ((groupPerlin.getSelectedToggle() != null)&&((null != mStickmanComboList) && (!mStickmanComboList.isEmpty()))) {
            	  if(groupPerlin.getSelectedToggle().getUserData().toString() == "With Perlin Noise"){       	
            	            Platform.runLater(() -> 
            	            {
            	            	for(String key : mStickmanComboList)
            	            		mStickmanOnstage.getStickmanFX(key).doAnimation("StartIdle", 1000, true);
            	            }
            	            );
            	  }
            	  else{
            		  Platform.runLater(() -> 
      	            {
      	            	for(String key : mStickmanComboList)
      	            		mStickmanOnstage.getStickmanFX(key).doAnimation("StopIdle", 1000, true);
      	            }
      	            );
            	  }
              }
            }
          });
    }
    
    public void setlePerlinNoiseOn(){
    	WithPerlinNoise.setSelected(true);
    	WithoutPerlinNoise.setSelected(false);
    }
    
    public void setlePerlinNoiseOff(){
    	WithPerlinNoise.setSelected(false);
    	WithoutPerlinNoise.setSelected(true);
    	
    }
    
    private void handleGroupForEnvironmentRadioButton()
    {
    	FadeIn.setUserData("FadeIn");
    	FadeOut.setUserData("FadeOut");
    	GoDown.setUserData("GoDown");
    	ComeUp.setUserData("ComeUp");
    	DisappearToSmall.setUserData("DisappearToSmall");
    	ComeBackFromSmall.setUserData("ComeBackFromSmall");
    	Speaking.setUserData("Speaking");
    	
    	FadeIn.setToggleGroup(groupEnvironmentRadioButton);
    	FadeOut.setToggleGroup(groupEnvironmentRadioButton);
    	GoDown.setToggleGroup(groupEnvironmentRadioButton);
    	ComeUp.setToggleGroup(groupEnvironmentRadioButton);
    	DisappearToSmall.setToggleGroup(groupEnvironmentRadioButton);
    	ComeBackFromSmall.setToggleGroup(groupEnvironmentRadioButton);
    	Speaking.setToggleGroup(groupEnvironmentRadioButton);
    	
    	groupEnvironmentRadioButton.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {
              if ((groupEnvironmentRadioButton.getSelectedToggle() != null)&&(mStickmancombobox != null)) 
              {
            	  String action = groupEnvironmentRadioButton.getSelectedToggle().getUserData().toString();
            	   if(!action.equals("Speaking")){       	
            	            Platform.runLater(() -> 
            	            {
            	            		mStickmanOnstage.getStickmanFX(mStickmancombobox).doAnimation(action, 1000, true);
            	            }
            	            );
            	  }
            	  else{
            		  Platform.runLater(() -> 
      	            {
      	            		mStickmanOnstage.getStickmanFX(mStickmancombobox).doAnimation(action,3000, "Stell Dir vor, Du kommst nach Hause, und ein Pferd steht in der Küche.", false);
      	            		Speaking.setSelected(false);
      	            }
      	            );
            	  }
              }
              
              if ((groupEnvironmentRadioButton.getSelectedToggle() != null)&&(mStickmancombobox == null)) 
              {
            	  String action = groupEnvironmentRadioButton.getSelectedToggle().getUserData().toString();
            	  Platform.runLater(() -> 
    	            {
    	            	groupEnvironmentRadioButton.getSelectedToggle().setSelected(false);
    	            }
    	            );            	  
              }          
            }
          });
    }
    
    private void EnvironmentRadioButtonNotSelected()
    {
    	FadeIn.setSelected(false);
    	FadeOut.setSelected(false);
    	GoDown.setSelected(false);
    	ComeUp.setSelected(false);
    	DisappearToSmall.setSelected(false);
    	ComeBackFromSmall.setSelected(false);
    	Speaking.setSelected(false);
    }
    
    private void saveToXml()
    {
    	SaveButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	if (((null != mStickmanComboList) && (!mStickmanComboList.isEmpty()))) {
              	            Platform.runLater(() -> 
              	            {
              	            	mStickmanDataFX.clear();
              	            	for(String key : mStickmanComboList)
              	            	{
              	            		String name = key;
              	            		String bodyColor;
              	            		String hairColor;
              	            		StickmanFX mStick = mStickmanOnstage.getStickmanFX(key);
              	            		if(mStick.mType == StickmanFX.TYPE.MALE)
              	            		{
              	            			bodyColor = HandleColor.switchColorToString(mStick.mBodyFX.mMaleColor);      		
              	            		}
              	            		else
              	            		{
              	            			bodyColor = HandleColor.switchColorToString(mStick.mBodyFX.mFemaleColor );		
              	            		} 
              	            		
              	            		if(mStick.mType == StickmanFX.TYPE.MALE)
              	            		{
              	            			hairColor = HandleColor.switchColorToString(mStick.mMaleHairFX.mColor); 		
              	            		}
              	            		else
              	               	 	{
              	            			hairColor = HandleColor.switchColorToString(mStick.mFemaleHairFX.mColor);
              	               	 	}
              	              	 
              	            		String headColor = HandleColor.switchColorToString(mStick.mHeadFX.mColor);             	                		
              	                	String limbsColor = HandleColor.switchColorToString(mStick.mLeftUpperLegFX.mColor);
              	                	
              	                	mStickmanDataFX.add(new StickmanDataFX(name, hairColor, headColor, bodyColor, limbsColor));
              	            	}
              	            	//mStickmanOnstage.getmXmlTransform().loadStickmanDataFXList(mStickmanDataFX);
              	            	//handleSave();
              	            });           
              	  }
              }
        });
    }

    /*private void handleSave() {
    	
    	File filexml = null;
    	if(mStickmanOnstage.mFilePath != null)
    		filexml = new File(mStickmanOnstage.mFilePath + File.separator + "stickman"+ File.separator+"stickman.xml");
        
        if (!filexml.exists()) 
        	filexml.getParentFile().mkdir();
        
       // Make sure it has the correct extension
        if (!filexml.getPath().endsWith(".xml")) {
        	filexml = new File(filexml.getPath() + ".xml");
        }
        mStickmanOnstage.getmXmlTransform().saveStickmanDataToFile(filexml);
    }*/
}
