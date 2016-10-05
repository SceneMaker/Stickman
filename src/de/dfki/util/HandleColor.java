package de.dfki.util;

import javafx.scene.paint.Color;

public class HandleColor
{
	public static String switchColorToString(Color color)
    {
        String s = null;
        if (color.equals(Color.BEIGE))
        	s= "Beige";
        if (color.equals(Color.YELLOW))
        	s= "Yellow";
        if (color.equals(Color.WHITE))
        	s= "White";
//        if (color.equals(Color.BLACK))
        if (color.equals(Color.rgb(80, 80, 80)))
        	s= "Black";
        if (color.equals(Color.BLUE))
        	s= "Blue";
        if (color.equals(Color.RED))
        	s= "Red";
        if (color.equals(Color.GOLD))
        	s= "Gold";
        if (color.equals(Color.rgb(97, 58, 0, 1)))
        	s= "Brown";
        if (color.equals(Color.rgb(240, 212, 0, 1)))
        	s= "Saffron Yellow";
        if (color.equals(Color.rgb(242, 227, 217, 1)))
        	s= "Festucine";
        if (color.equals(Color.rgb(14, 134, 122, (240 * 100 / 255) / 100f)))
        	s= "Green";
        if (color.equals(Color.rgb(154, 83, 198, (240 * 100 / 255) / 100f)))
        	s= "Purple";
        return s;
    }
	
	public static Color switchColor(String color)
    {
        Color c = null;
        switch(color)
        {
            case "Beige": 
                c = Color.BEIGE;
                break;
            case "Yellow":
                c = Color.YELLOW;
                break;
            case "White":
                c = Color.WHITE;
                break;
            case "Black":
//                c = Color.BLACK;
            	c = Color.rgb(80, 80, 80);
                break;
            case "Blue":
                c = Color.BLUE;
                break;
            case "Red":
                c = Color.RED;
                break;
            case "Gold":
                c = Color.GOLD;
                break;
            case "Brown":
                c = Color.rgb(97, 58, 0, 1);
                break;   
            case "Saffron Yellow":
                c = Color.rgb(240, 212, 0, 1);
                break;
            case "Festucine":
                c = Color.rgb(242, 227, 217, 1);
                break;
            case "Green":
                c = Color.rgb(14, 134, 122, (240 * 100 / 255) / 100f);
                break;
            case "Purple":
                c = Color.rgb(154, 83, 198, (240 * 100 / 255) / 100f);
                break;
            default:
            	c = null;
            	break;
        }
        return c;
    }
}
