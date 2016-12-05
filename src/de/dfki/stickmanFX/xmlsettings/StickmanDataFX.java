package de.dfki.stickmanFX.xmlsettings;

public class StickmanDataFX {

    private String name;
    private String hairColor;
    private String headColor;
    private String bodyColor;
    private String limbsColor;
    private float hairColorOpacity;
    private float headColorOpacity;
    private float bodyColorOpacity;
    private float limbsColorOpacity;
    private String backgroundRecord;

    /**
     * Default constructor.
     */
    public StickmanDataFX() {
        name = null;
        hairColor = null;
        headColor = null;
        bodyColor = null;
        limbsColor = null;
        hairColorOpacity = 1;
        headColorOpacity = 1;
        bodyColorOpacity = 1;
        limbsColorOpacity = 1;
        backgroundRecord = null;
    }

    public StickmanDataFX(String name, String hairColor, String headColor, String bodyColor, String limbsColor, float hairColorOpacity, float headColorOpacity, float bodyColorOpacity, float limbsColorOpacity, String backgroundRecord) {
        this.name = name;
        this.hairColor = hairColor;
        this.headColor = headColor;
        this.bodyColor = bodyColor;
        this.limbsColor = limbsColor;
        this.hairColorOpacity = hairColorOpacity;
        this.headColorOpacity = headColorOpacity;
        this.bodyColorOpacity = bodyColorOpacity;
        this.limbsColorOpacity = limbsColorOpacity;
        this.backgroundRecord = backgroundRecord;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String gethairColor() {
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

    public float gethairColorOpacity() {
        return hairColorOpacity;
    }

    public void sethairColorOpacity(float hairColorOpacity) {
        this.hairColorOpacity = hairColorOpacity;
    }

    public float getheadColorOpacity() {
        return headColorOpacity;
    }

    public void setheadColorOpacity(float headColorOpacity) {
        this.headColorOpacity = headColorOpacity;
    }

    public float getbodyColorOpacity() {
        return bodyColorOpacity;
    }

    public void setbodyColorOpacity(float bodyColorOpacity) {
        this.bodyColorOpacity = bodyColorOpacity;
    }

    public float getlimbsColorOpacity() {
        return limbsColorOpacity;
    }

    public void setlimbsColorOpacity(float limbsColorOpacity) {
        this.limbsColorOpacity = limbsColorOpacity;
    }

    public String getbackgroundRecord() {
        return backgroundRecord;
    }

    public void setbackgroundRecord(String backgroundRecord) {
        this.backgroundRecord = backgroundRecord;
    }
}
