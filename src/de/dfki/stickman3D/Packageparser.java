package de.dfki.stickman3D;

import de.dfki.stickman3D.animationlogic.Animation3D;
import de.dfki.stickman3D.animationlogic.Animation3D.ANIMTYPE;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;

public class Packageparser {

    ArrayList<String> classNameList = new ArrayList<>();
    String packName = "de.dfki.stickman3D.animation.facefx";
    String packDir;
    Enumeration<URL> dir;

    public Packageparser(String packName) {
        this.packName = packName;
        ScanPackage();
    }

    private void ScanPackage() {
        packDir = packName.replace(".", "/");
        try {
            dir = Thread.currentThread().getContextClassLoader().getResources(packDir);
            while (dir.hasMoreElements()) {
                URL url = dir.nextElement();
                String protocol = url.getProtocol();
                if ("file".equals(protocol)) {
                    String filePath = URLDecoder.decode(url.getFile(), "UTF-8");
                    findAndAddClassesInPackageByFile(packName, filePath);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void findAndAddClassesInPackageByFile(String packName, String filePath) {
        File dir = new File(filePath);
        if (dir.exists() && dir.isDirectory()) {
            File[] dirfiles = dir.listFiles(new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    return pathname.isDirectory() || pathname.getName().endsWith(".class");
                }
            });

            for (File file : dirfiles) {
                if (file.isDirectory()) {
                    findAndAddClassesInPackageByFile(packName + "." + file.getName(), file.getAbsolutePath());
                } else {

                    String className = file.getName().substring(0, file.getName().length() - 6);
                    try {
                        Class<?> myClass = Thread.currentThread().getContextClassLoader()
                                .loadClass(packName + "." + className);

                        Object object = myClass.newInstance();

                        Animation3D class1 = null;
                        if (object instanceof Animation3D) {
                            class1 = (Animation3D) object;
                        }

                        if (class1 != null && class1.mAnimType == ANIMTYPE.ON) {
                            classNameList.add(className);
                        }
                    } catch (Exception e) {
//						e.printStackTrace();
                    }

                }
            }
        }
    }

    public ArrayList<String> getClassNameList() {
        return classNameList;
    }
}
