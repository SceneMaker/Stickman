package de.dfki.common;

import java.io.File;
import java.util.List;
import de.dfki.stickman3D.xmlsettings.StickmanData3D;
import de.dfki.stickmanFX.xmlsettings.StickmanDataFX;

public abstract class XmlTransform {

//    private List<StickmanData3D> mStickmanData3D = new ArrayList<StickmanData3D>();

    public XmlTransform() {
    }

    public void loadStickmanData3DList(List<StickmanData3D> mStickmanData3D) {
    }
    
    public void loadStickmanDataFXList(List<StickmanDataFX> mStickmanData3D) {
    }

    public List<StickmanData3D> getStickmanData3DList(){
	return null;
    };
    
    public List<StickmanDataFX> getStickmanDataFXList(){
	return null;
    };

    public abstract void loadStickmanDataFromFile(File file);

    public abstract void saveStickmanDataToFile(File file);

    public abstract File getPersonFilePath();

    public abstract void setPersonFilePath(File file);
}
