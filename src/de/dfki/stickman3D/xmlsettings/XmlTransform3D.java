package de.dfki.stickman3D.xmlsettings;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.prefs.Preferences;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import de.dfki.common.XmlTransform;
import de.dfki.stickman3D.stage.StickmanStage3D;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class XmlTransform3D extends XmlTransform{

    private List<StickmanData3D> mStickmanData3D = new ArrayList<StickmanData3D>();

    public XmlTransform3D() {
    }

    @Override
    public void loadStickmanData3DList(List<StickmanData3D> mStickmanData3D) {
	this.mStickmanData3D = mStickmanData3D;
    }

    @Override
    public List<StickmanData3D> getStickmanData3DList() {
	return this.mStickmanData3D;
    }

    @Override
    public void loadStickmanDataFromFile(File file) {
	try {

	    JAXBContext context = JAXBContext.newInstance(StickmanDataListWrappe3D.class);
	    Unmarshaller um = context.createUnmarshaller();

	    // Reading XML from the file and unmarshalling.
	    StickmanDataListWrappe3D wrapper = (StickmanDataListWrappe3D) um.unmarshal(file);

	    mStickmanData3D.clear();
	    mStickmanData3D.addAll(wrapper.getStickmanData3D());

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
	    JAXBContext context = JAXBContext.newInstance(StickmanDataListWrappe3D.class);
	    Marshaller m = context.createMarshaller();
	    m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

	    // Wrapping our person data.
	    StickmanDataListWrappe3D wrapper = new StickmanDataListWrappe3D();
	    wrapper.setStickmanData3D(mStickmanData3D);

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
	Preferences prefs = Preferences.userNodeForPackage(StickmanStage3D.class);
	String filePath = prefs.get("filePath", null);
	if (filePath != null) {
	    return new File(filePath);
	} else {
	    return null;
	}
    }

    @Override
    public void setPersonFilePath(File file) {
	Preferences prefs = Preferences.userNodeForPackage(StickmanStage3D.class);
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
