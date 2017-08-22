package de.dfki.stickman3D.xmlsettings;

public class StickmanData3D
{

    private String name;
    private String hairColor;
    private String headColor;
    private String bodyColor;
    private String limbsColor;
    private String shoesColor;
    private String lipsColor;
    private String eyesColor;
    private String browsColor;
    private String nosesColor;

    private String backgroundRecord;

    /**
     * Default constructor.
     */
    public StickmanData3D()
    {
        name = null;
        hairColor = null;
        headColor = null;
        bodyColor = null;
        limbsColor = null;
        shoesColor = null;
        lipsColor = null;
        eyesColor = null;
        browsColor = null;
        nosesColor = null;

        backgroundRecord = null;
    }

    public StickmanData3D(String name, String hairColor, String headColor, String bodyColor, String limbsColor, String shoesColor, String lipsColor, String eyesColor, String browsColor, String nosesColor, String backgroundRecord)
    {
        this.name = name;
        this.hairColor = hairColor;
        this.headColor = headColor;
        this.bodyColor = bodyColor;
        this.limbsColor = limbsColor;

        this.shoesColor = shoesColor;
        this.lipsColor = lipsColor;
        this.eyesColor = eyesColor;
        this.browsColor = browsColor;
        this.nosesColor = nosesColor;
        this.backgroundRecord = backgroundRecord;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String gethairColor()
    {
        return hairColor;
    }

    public void sethairColor(String hairColor)
    {
        this.hairColor = hairColor;
    }

    public String getheadColor()
    {
        return headColor;
    }

    public void setheadColor(String headColor)
    {
        this.headColor = headColor;
    }

    public String getbodyColor()
    {
        return bodyColor;
    }

    public void setbodyColor(String bodyColor)
    {
        this.bodyColor = bodyColor;
    }

    public String getlimbsColor()
    {
        return limbsColor;
    }

    public void setlimbsColor(String limbsColor)
    {
        this.limbsColor = limbsColor;
    }

    public String getshoesColor()
    {
        return shoesColor;
    }

    public void setshoesColor(String shoesColor)
    {
        this.shoesColor = shoesColor;
    }

    public String getlipsColor()
    {
        return lipsColor;
    }

    public void setlipsColor(String lipsColor)
    {
        this.lipsColor = lipsColor;
    }

    public String geteyesColor()
    {
        return eyesColor;
    }

    public void seteyesColor(String eyesColor)
    {
        this.eyesColor = eyesColor;
    }

    public String getbrowsColor()
    {
        return browsColor;
    }

    public void setbrowsColor(String browsColor)
    {
        this.browsColor = browsColor;
    }

    public String getnoseColor()
    {
        return nosesColor;
    }

    public void setnoseColor(String nosesColor)
    {
        this.nosesColor = nosesColor;
    }

    public String getbackgroundRecord()
    {
        return backgroundRecord;
    }

    public void setbackgroundRecord(String backgroundRecord)
    {
        this.backgroundRecord = backgroundRecord;
    }
}


