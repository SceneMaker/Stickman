package de.dfki.stickman.view;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import de.dfki.stickman.animationlogic.Animation;


public class StickmanFillCombo
{

	ArrayList <String> mComboList = new ArrayList <>();  
	String packName = "de.dfki.stickman.animation.face";
	String packDir;
	Enumeration<URL> dir;
	public 	StickmanFillCombo(String packName)
	{
		this.packName = packName;
		ScanPackage();
	}
		
	private void ScanPackage()
	{
		packDir = packName.replace(".", "/");
		try {  
			dir = Thread.currentThread().getContextClassLoader().getResources(packDir);  
			while(dir.hasMoreElements()){  
				URL url = dir.nextElement();    
				String protocol = url.getProtocol();  
				if("file".equals(protocol)){   
					String filePath = URLDecoder.decode(url.getFile(), "UTF-8");  
					findAndAddClassesInPackageByFile(packName, filePath);
				}
			}
		}catch (IOException e) {  
	    	   e.printStackTrace();  
	    }
	}
	
	private void findAndAddClassesInPackageByFile(String packName, String filePath) {  
		 File dir = new File(filePath);  
		 if( dir.exists() && dir.isDirectory()){
			 File[] dirfiles = dir.listFiles(new FileFilter(){  
				 @Override  
				 public boolean accept(File pathname) {  
					 return pathname.isDirectory() || pathname.getName().endsWith(".class");  
				 }  
			 });  
		 for (File file : dirfiles) {  
			 if(file.isDirectory()){  
				 findAndAddClassesInPackageByFile(packName + "." + file.getName(),file.getAbsolutePath());  
			 }else{ 
				 String className = file.getName().substring(0,file.getName().length() - 6);
				 mComboList.add(className);
			 }  
		 	}  
		}  
	}
	
	public ArrayList getComboList(){
        return mComboList;
    }
}


