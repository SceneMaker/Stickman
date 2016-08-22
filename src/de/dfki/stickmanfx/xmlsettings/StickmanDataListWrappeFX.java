package de.dfki.stickmanfx.xmlsettings;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "StickmanFX")
public class StickmanDataListWrappeFX
{
	private List<StickmanDataFX> mStickmanDataFX;
	
	public StickmanDataListWrappeFX()
	{
	}
	@XmlElement(name = "Stickman")
	public List<StickmanDataFX> getStickmanDataFX() {
		return mStickmanDataFX;
	    }

	public void setStickmanDataFX(List<StickmanDataFX> mStickmanDataFX) {
		this.mStickmanDataFX = mStickmanDataFX;
	}

}
