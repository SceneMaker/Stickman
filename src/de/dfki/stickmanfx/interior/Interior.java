package de.dfki.stickmanfx.interior;

import java.net.URL;

import com.interactivemesh.jfx.importer.col.ColModelImporter;

import javafx.scene.Group;

public class Interior 
{
	private static URL url;
	private static ColModelImporter imorter;
	private static Group sTableMeshView;
	private static Group sLaptop;
	
	public static Group createTable()
	{
		imorter = new ColModelImporter();
		url = Interior.class.getClassLoader().getResource("BodyParts/table.dae");
		imorter.read(url);
		sTableMeshView = (Group) imorter.getImport()[0];
		
		return sTableMeshView;
	}
	
	public static Group createLaptop()
	{
		imorter = new ColModelImporter();
		url = Interior.class.getClassLoader().getResource("BodyParts/Laptop1.dae");
		imorter.read(url);
		sLaptop = (Group) imorter.getImport()[0];
		
		return sLaptop;
	}
}
