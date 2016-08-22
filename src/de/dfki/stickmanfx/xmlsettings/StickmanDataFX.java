package de.dfki.stickmanfx.xmlsettings;


public class StickmanDataFX
{
	private String name;
    private String hairColor;
    private String headColor;
    private String bodyColor;
    private String limbsColor;
    
    /**
     * Default constructor.
     */
    public StickmanDataFX() { 
    	name = null;
    	hairColor = null;
    	headColor = null;
    	bodyColor = null;
    	limbsColor = null;
    	
    }
    
    public StickmanDataFX(String name, String hairColor,String headColor, String bodyColor, String limbsColor) {
        this.name = name;
        this.hairColor = hairColor;
        this.headColor = headColor;
        this.bodyColor = bodyColor;
        this.limbsColor = limbsColor;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void sethairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public String getheadColor() {
        return headColor;
    }
    
    public void setheadColor(String headColor) {
        this.headColor = headColor;
    }
    
    public String getbodyColor() {
        return bodyColor;
    }
    
    public void setbodyColor(String bodyColor) {
        this.bodyColor = bodyColor;
    }
    
    public String getlimbsColor() {
        return limbsColor;
    }
    
    public void setlimbsColor(String limbsColor) {
        this.limbsColor = limbsColor;
    }   
}
