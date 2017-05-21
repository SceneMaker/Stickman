package de.dfki.util;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import de.dfki.stickmanFX.animationlogic.AnimationFX;
import de.dfki.stickmanFX.animationlogic.AnimationFX.ANIMTYPE;

public class StickmanFillCombo {

    ArrayList<String> mComboList = new ArrayList<>();
    String packName = "de.dfki.stickmanFX.animation.facefx";
    String packDir;
    Enumeration<URL> dir;
    ClassLoader loaderjar;

    public StickmanFillCombo(String packName) {
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
                } else if ("jar".equals(protocol)) {
                    URL urljar = new URL("file:" + packDir);
                    loaderjar = new URLClassLoader(new URL[]{urljar});
                    packageIsJar(url);
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

                        AnimationFX class1 = null;
                        if (object instanceof AnimationFX) {
                            class1 = (AnimationFX) object;
                        }

                        if (class1 != null && class1.mAnimType == ANIMTYPE.EmotionExpression) {
                            mComboList.add(className);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            }
        }
    }

    private void packageIsJar(URL packageURL) throws UnsupportedEncodingException {
        String jarFileName;
        // build jar file name, then loop through zipped entries
        jarFileName = URLDecoder.decode(packageURL.getFile(), "UTF-8");
        jarFileName = jarFileName.substring(5, jarFileName.indexOf("!"));
        System.out.println(">" + jarFileName);
        parseJar(jarFileName);
    }

    private void parseJar(String jarFileName) {
        JarFile jf;
        Enumeration<JarEntry> jarEntries = null;
        try {
            jf = new JarFile(jarFileName);
            jarEntries = jf.entries();
            ExtractExtensions(jarEntries);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void ExtractExtensions(Enumeration<JarEntry> jarEntries) {
        while (jarEntries.hasMoreElements()) {
            tryToAddActivityExecutor(jarEntries);
        }
    }

    private void tryToAddActivityExecutor(Enumeration<JarEntry> jarEntries) {
        String entryNameDir;
        entryNameDir = jarEntries.nextElement().getName();
        if ((entryNameDir.startsWith(packDir) && entryNameDir.length() > packDir.length() + 5)) {
            String entryName = entryNameDir.replace("/", ".");
            try {
                Class<?> myClass = loaderjar.loadClass(entryName.substring(0, entryName.length() - 6));
                Object object = myClass.newInstance();

                AnimationFX class1 = null;
                if (object instanceof AnimationFX) {
                    class1 = (AnimationFX) object;
                }
                if (class1 != null && class1.mAnimType == ANIMTYPE.EmotionExpression) {
                    String className = entryName.substring(0, entryName.length() - 6);
                    className = className.substring(className.lastIndexOf('.') + 1, className.length());
                    mComboList.add(className);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList getComboList() {
        return mComboList;
    }
}
