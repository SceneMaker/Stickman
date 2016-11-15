package de.dfki.util;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLParser 
{
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
	
	public static ArrayList<String> parseBehavior()
	{
		init();
		
		ArrayList<String> returnList = new ArrayList<String>();
		
		NodeList behaviorList = doc.getElementsByTagName("Behavior");
		
		for(int i = 0; i<behaviorList.getLength(); i++)
		{
			Node nNode = behaviorList.item(i);
			
			if (nNode.getNodeType() == Node.ELEMENT_NODE)
			{
				Element eElement = (Element) nNode;
				NodeList itemList = eElement.getElementsByTagName("item");
				
				for(int index = 0; index < itemList.getLength(); index++)
				{
					returnList.add(itemList.item(index).getTextContent());
				}
			}
		}
		
		return returnList;
	}
}
