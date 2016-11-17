package de.dfki.util;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javafx.scene.paint.Color;

public class XMLParser 
{
	
	private static File inputFile = new File("config.xml");
	
	private static DocumentBuilderFactory dbFactory;
	private static DocumentBuilder dBuilder;
	private static Document doc;
	
	private static HashMap<String, HashMap<String, Object>> nameToBehaviorAndColor = new HashMap<>();
	
	private static void initializePath()
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
	
	public static HashMap<String, HashMap<String, Object>> parse()
	{
		initializePath();
		
		NodeList nameList = doc.getElementsByTagName("Stickman"); 
		
		for(int i = 0; i<nameList.getLength(); i++)
		{
			ArrayList<String> behaviorList = new ArrayList<>();
			HashMap<String, Object> behaviorAndColorMap = new HashMap<>();
			HashMap<String, Color> colorMap = new HashMap<>();
			Node nNode = nameList.item(i);
			String name="";
			
			if(nNode.getNodeType() == Node.ELEMENT_NODE)
			{
				Element eElement = (Element) nNode;
				name = eElement.getAttribute("name");
	
				NodeList bList = eElement.getElementsByTagName("Behavior");
				NodeList cList = eElement.getElementsByTagName("Color");

				Node bNode = bList.item(0);
				Node cNode = cList.item(0);
				
				if(bNode.getNodeType() == Node.ELEMENT_NODE)
				{
					Element bElement = (Element) bNode;
					NodeList itemList = bElement.getElementsByTagName("item");
					//lese alle behaviors und fuege in behaviorList hinzu
					for(int j = 0; j<itemList.getLength(); j++)
					{
						behaviorList.add(itemList.item(j).getTextContent());
					}
				}
				if(cNode.getNodeType() == Node.ELEMENT_NODE)
				{
					Element cElement = (Element) cNode;
					NodeList colorList = cElement.getChildNodes();
					
					for(int j = 0; j<colorList.getLength(); j++)
					{
						Node n = colorList.item(j);
						if(n.getNodeType() == Node.ELEMENT_NODE)
						{
							String[] colorValue = n.getTextContent().split(",");
							int redValue = Integer.parseInt(colorValue[0].trim());
							int greenValue = Integer.parseInt(colorValue[1].trim());
							int blueValue = Integer.parseInt(colorValue[2].trim());
							Color c = Color.rgb(redValue, greenValue, blueValue);
							
							colorMap.put(n.getNodeName(), c);
							
						}
					}
				}
			}
			behaviorAndColorMap.put("Behavior", behaviorList);
			behaviorAndColorMap.put("Color", colorMap);
			nameToBehaviorAndColor.put(name, behaviorAndColorMap);
		}
		
		return nameToBehaviorAndColor;
	}
	
	public static ArrayList<String> getStickmanNames()
	{
		ArrayList<String> names = new ArrayList<>();
		if(!nameToBehaviorAndColor.isEmpty())
		{
			for(Entry<String, HashMap<String, Object>> e : nameToBehaviorAndColor.entrySet())
			{
				names.add(e.getKey());
			}
			return names;
		}
		return null;
	}
	
	public static HashMap<String, Color> getColorMap(String stickmanName)
	{
		if(!nameToBehaviorAndColor.isEmpty())
		{
			return (HashMap<String, Color>) nameToBehaviorAndColor.get(stickmanName).get("Color");
		}
		return null;
	}
	
	public static ArrayList<String> getBehaviorList(String stickmanName)
	{
		if(!nameToBehaviorAndColor.isEmpty())
		{
			return  (ArrayList<String>) nameToBehaviorAndColor.get(stickmanName).get("Behavior");
		}
		return null;
	}
}
