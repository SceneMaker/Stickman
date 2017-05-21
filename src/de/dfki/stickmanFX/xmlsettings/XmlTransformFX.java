package de.dfki.stickmanFX.xmlsettings;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.prefs.Preferences;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import de.dfki.common.XmlTransform;
import de.dfki.stickmanFX.stage.StickmanStageFX;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class XmlTransformFX extends XmlTransform {

    private List<StickmanDataFX> mStickmanDataFX = new ArrayList<StickmanDataFX>();

    public XmlTransformFX() {
    }

    @Override
    public void loadStickmanDataFXList(List<StickmanDataFX> mStickmanDataFX) {
	this.mStickmanDataFX = mStickmanDataFX;
    }

    @Override
    public List<StickmanDataFX> getStickmanDataFXList() {
	return this.mStickmanDataFX;
    }

    @Override
    public void loadStickmanDataFromFile(File file) {
	try {

	    JAXBContext context = JAXBContext.newInstance(StickmanDataListWrappeFX.class);
	    Unmarshaller um = context.createUnmarshaller();

	    // Reading XML from the file and unmarshalling.
	    StickmanDataListWrappeFX wrapper = (StickmanDataListWrappeFX) um.unmarshal(file);

	    mStickmanDataFX.clear();
	    mStickmanDataFX.addAll(wrapper.getStickmanDataFX());

	    // Save the file path to the registry.
	    setPersonFilePath(file);

	} catch (Exception e) { // catches ANY exception
	    // Alert alert = new Alert(AlertType.ERROR);
	    // alert.setTitle("Error");
	    // alert.setHeaderText("Could not load data");
	    // alert.setContentText("Could not load data from file:\n" +
	    // file.getPath());
	    // alert.showAndWait();
	}
    }

    @Override
    public void saveStickmanDataToFile(File file) {
	try {
	    JAXBContext context = JAXBContext.newInstance(StickmanDataListWrappeFX.class);
	    Marshaller m = context.createMarshaller();
	    m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

	    // Wrapping our person data.
	    StickmanDataListWrappeFX wrapper = new StickmanDataListWrappeFX();
	    wrapper.setStickmanDataFX(mStickmanDataFX);

	    // Marshalling and saving XML to the file.
	    m.marshal(wrapper, file);

	    // Save the file path to the registry.
	    setPersonFilePath(file);
	} catch (Exception e) { // catches ANY exception
	    Alert alert = new Alert(AlertType.ERROR);
	    alert.setTitle("Error");
	    alert.setHeaderText("Could not save data");
	    alert.setContentText("Could not save data to file:\n" + file.getPath());

	    alert.showAndWait();
	}
    }

    @Override
    public File getPersonFilePath() {
	Preferences prefs = Preferences.userNodeForPackage(StickmanStageFX.class);
	String filePath = prefs.get("filePath", null);
	if (filePath != null) {
	    return new File(filePath);
	} else {
	    return null;
	}
    }

    @Override
    public void setPersonFilePath(File file) {
	Preferences prefs = Preferences.userNodeForPackage(StickmanStageFX.class);
	if (file != null) {
	    prefs.put("filePath", file.getPath());

	    // Update the stage title.
	    // primaryStage.setTitle("AddressApp - " + file.getName());
	} else {
	    prefs.remove("filePath");

	    // Update the stage title.
	    // primaryStage.setTitle("AddressApp");
	}
    }
}
