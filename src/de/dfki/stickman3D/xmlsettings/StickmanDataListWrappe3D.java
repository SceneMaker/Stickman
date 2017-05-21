package de.dfki.stickman3D.xmlsettings;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Stickman")
public class StickmanDataListWrappe3D {

    private List<StickmanData3D> mStickmanData3D;

    public StickmanDataListWrappe3D() {
    }

    @XmlElement(name = "Stickman3D")
    public List<StickmanData3D> getStickmanData3D() {
        return mStickmanData3D;
    }

    public void setStickmanData3D(List<StickmanData3D> mStickmanData3D) {
        this.mStickmanData3D = mStickmanData3D;
    }

}
