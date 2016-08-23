package de.dfki.stickmanfx;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import de.dfki.stickmanfx.xmlsettings.StickmanDataFX;
import de.dfki.util.HandleColor;
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
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;

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
                    	mStickmanstage.getStickmanFX(mStickmancombobox).mBodyFX.mMaleColor = HandleColor.switchColor(color);
                    	mStickmanstage.getStickmanFX(mStickmancombobox).update();
                    }
                    else
                    {
                    	mStickmanstage.getStickmanFX(mStickmancombobox).mBodyFX.mFemaleColor = HandleColor.switchColor(color); 
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
                    	mStickmanstage.getStickmanFX(mStickmancombobox).mMaleHairFX.mColor = HandleColor.switchColor(color);
                    	mStickmanstage.getStickmanFX(mStickmancombobox).update();
                    }
                 else
                    {
                    	mStickmanstage.getStickmanFX(mStickmancombobox).mFemaleHairFX.mColor = HandleColor.switchColor(color); 
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
            	mStickmanstage.getStickmanFX(mStickmancombobox).mHeadFX.mColor = HandleColor.switchColor(color);
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
            	mStickmanstage.getStickmanFX(mStickmancombobox).mLeftUpperLegFX.mColor = HandleColor.switchColor(color);
            	mStickmanstage.getStickmanFX(mStickmancombobox).mLeftForeLegFX.mColor = HandleColor.switchColor(color);
            	mStickmanstage.getStickmanFX(mStickmancombobox).mLeftFootFX.mColor = HandleColor.switchColor(color);
//            	mStickmanstage.getStickmanFX(mStickmancombobox).mRightLegFX.mColor = switchColor(color);
            	mStickmanstage.getStickmanFX(mStickmancombobox).mRightUpperLegFX.mColor = HandleColor.switchColor(color);
            	mStickmanstage.getStickmanFX(mStickmancombobox).mRightForeLegFX.mColor = HandleColor.switchColor(color);
            	mStickmanstage.getStickmanFX(mStickmancombobox).mRightFootFX.mColor = HandleColor.switchColor(color);
            	mStickmanstage.getStickmanFX(mStickmancombobox).mLeftHandFX.mColor = HandleColor.switchColor(color);
            	mStickmanstage.getStickmanFX(mStickmancombobox).mRightHandFX.mColor = HandleColor.switchColor(color);
            	mStickmanstage.getStickmanFX(mStickmancombobox).mLeftShoulderFX.mColor = HandleColor.switchColor(color);
            	mStickmanstage.getStickmanFX(mStickmancombobox).mRightShoulderFX.mColor = HandleColor.switchColor(color);
            	mStickmanstage.getStickmanFX(mStickmancombobox).mLeftUpperArmFX.mColor = HandleColor.switchColor(color);        	
            	mStickmanstage.getStickmanFX(mStickmancombobox).mLeftForeArmFX.mColor = HandleColor.switchColor(color);           	
            	mStickmanstage.getStickmanFX(mStickmancombobox).mRightUpperArmFX.mColor = HandleColor.switchColor(color);
            	mStickmanstage.getStickmanFX(mStickmancombobox).mRightForeArmFX.mColor = HandleColor.switchColor(color);
            	mStickmanstage.getStickmanFX(mStickmancombobox).mNeckFX.mColor = HandleColor.switchColor(color);
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
                    
                    if ((groupEnvironmentRadioButton.getSelectedToggle() != null))
                    {
                    	String action = groupEnvironmentRadioButton.getSelectedToggle().getUserData().toString();
                    	Platform.runLater(() -> 
                    	{
                    		switch(action)
                    		{
                    			case "FadeOut": 
                    				mStickmanstage.getStickmanFX(mStickmancombobox).doAnimation("FadeIn", 1000, true);
                    				break; 
                    			case "GoDown": 
                    				mStickmanstage.getStickmanFX(mStickmancombobox).doAnimation("ComeUp", 1000, true);
                    				break;
                    			case "DisappearToSmall": 
                    				mStickmanstage.getStickmanFX(mStickmancombobox).doAnimation("ComeBackFromSmall", 1000, true);
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
            	mStickmanstage.clearStage();
            }
        });
        
        saveToXml();
        
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
            	            		mStickmanstage.getStickmanFX(mStickmancombobox).doAnimation(action, 1000, true);  
            	            }
            	            );
            	  }
            	  else{
            		  Platform.runLater(() -> 
      	            {
      	            		mStickmanstage.getStickmanFX(mStickmancombobox).doAnimation(action,3000, "Stell Dir vor, Du kommst nach Hause, und ein Pferd steht in der Küche.", false);
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
            	if (((null != mStickmanstage.mStickmanComboList) && (!mStickmanstage.mStickmanComboList.isEmpty()))) {     	
              	            Platform.runLater(() -> 
              	            {
              	            	mStickmanDataFX.clear();
              	            	for(String key : mStickmanstage.mStickmanComboList)
              	            	{
              	            		String name = key;
              	            		String bodyColor;
              	            		String hairColor;
              	            		StickmanFX mStick = mStickmanstage.getStickmanFX(key);
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
              	            	mStickmanstage.getmXmlTransform().loadStickmanDataFXList(mStickmanDataFX);
//              	            	handleSave();
              	            	handleSaveAs();
              	            });           
              	  }
              }
        });
    }
    
    private void handleSave() {
        File personFile = mStickmanstage.getmXmlTransform().getPersonFilePath();
        if (personFile != null) {
        	mStickmanstage.getmXmlTransform().saveStickmanDataToFile(personFile);
        } else {
            handleSaveAs();
        }
    }

    /**
     * Opens a FileChooser to let the user select a file to save to.
     */
    private void handleSaveAs() {
        FileChooser fileChooser = new FileChooser();
        // Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);

        // Show save file dialog
        File file = fileChooser.showSaveDialog(mStickmanstage.getStage());
        
        if (file != null) {
            // Make sure it has the correct extension
            if (!file.getPath().endsWith(".xml")) {
                file = new File(file.getPath() + ".xml");
            }
            mStickmanstage.getmXmlTransform().saveStickmanDataToFile(file);
        }
    }
}
