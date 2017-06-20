package de.dfki.stickman3D.decoration;

import java.net.URL;

import com.interactivemesh.jfx.importer.col.ColModelImporter;

import javafx.scene.Group;

public class Decorator {
	private static URL url;
	private static ColModelImporter imorter;
	private static Group sTableMeshView;
	private static Group sLaptop;
	private static Group sChair;

	public static Group createTable() {
		imorter = new ColModelImporter();
		url = Decorator.class.getClassLoader().getResource("BodyParts/Stickman3D/table.dae");
		imorter.read(url);
		sTableMeshView = (Group) imorter.getImport()[0];

		return sTableMeshView;
	}

	public static Group createLaptop() {
		imorter = new ColModelImporter();
		url = Decorator.class.getClassLoader().getResource("BodyParts/Stickman3D/Laptop.dae");
		imorter.read(url);
		sLaptop = (Group) imorter.getImport()[0];

		return sLaptop;
	}

	public static Group createChair() {
		imorter = new ColModelImporter();
		url = Decorator.class.getClassLoader().getResource("BodyParts/Stickman3D/chair.dae");
		imorter.read(url);
		sChair = (Group) imorter.getImport()[0];

		return sChair;
	}
}
