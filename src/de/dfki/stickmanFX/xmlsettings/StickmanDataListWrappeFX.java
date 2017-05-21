package de.dfki.stickmanFX.xmlsettings;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Stickman")
public class StickmanDataListWrappeFX {

    private List<StickmanDataFX> mStickmanDataFX;

    public StickmanDataListWrappeFX() {
    }

    @XmlElement(name = "StickmanFX")
    public List<StickmanDataFX> getStickmanDataFX() {
        return mStickmanDataFX;
    }

    public void setStickmanDataFX(List<StickmanDataFX> mStickmanDataFX) {
        this.mStickmanDataFX = mStickmanDataFX;
    }

}
