package de.dfki.util;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javafx.scene.paint.Color;

public class XMLParser 
{
	public static ArrayList<String> femaleBehavior = new ArrayList<>();
	public static ArrayList<String> maleBehavior = new ArrayList<>();
	public static HashMap<String, Color> maleColor = new HashMap<>();
	public static HashMap<String, Color> femaleColor = new HashMap<>();
	
	private static File inputFile = new File("config.xml");
	
	private static DocumentBuilderFactory dbFactory;
	private static DocumentBuilder dBuilder;
	private static Document doc;
	
	private static void init()
	{
		try
		{
			dbFactory = DocumentBuilderFactory.newInstance();
			dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void parseBehavior()
	{
		init();
		
		NodeList behaviorList = doc.getElementsByTagName("Behavior");
		
		for(int i = 0; i<behaviorList.getLength(); i++)
		{
			Node nNode = behaviorList.item(i);
			
			if (nNode.getNodeType() == Node.ELEMENT_NODE)
			{
				Element eElement = (Element) nNode;
				String type =  eElement.getAttribute("type");
				NodeList itemList = eElement.getElementsByTagName("item");
				
				for(int index = 0; index < itemList.getLength(); index++)
				{
					if(type.equalsIgnoreCase("Male"))
						maleBehavior.add(itemList.item(index).getTextContent());
					else
						femaleBehavior.add(itemList.item(index).getTextContent());
				}
			}
		}
	}
	
	public static void parseColor()
	{
		init();
		
		NodeList colorList = doc.getElementsByTagName("Color");
		
		for(int i = 0; i<colorList.getLength(); i++)
		{
			Node nNode = colorList.item(i);
				
			if (nNode.getNodeType() == Node.ELEMENT_NODE) 
			{
				Element eElement = (Element) nNode;
				String type =  eElement.getAttribute("type");
				NodeList children = eElement.getChildNodes();
					
				for(int j = 0; j<eElement.getChildNodes().getLength(); j++)
				{
					Node n = children.item(j);
					if(n.getNodeType() == Node.ELEMENT_NODE)
					{
						String[] colorValue = n.getTextContent().split(",");
						int redValue = Integer.parseInt(colorValue[0].trim());
						int greenValue = Integer.parseInt(colorValue[1].trim());
						int blueValue = Integer.parseInt(colorValue[2].trim());
						double opacity = Double.parseDouble(colorValue[3].trim());
						Color c = Color.rgb(redValue, greenValue, blueValue, opacity);
						
						if(type.equalsIgnoreCase("male"))
							maleColor.put(n.getNodeName(), c);
						else
							femaleColor.put(n.getNodeName(), c);
					}
				}
			}
		}
	}
}
