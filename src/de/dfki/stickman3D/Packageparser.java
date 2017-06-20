package de.dfki.stickman3D;

import de.dfki.stickman3D.animation.face.Excited;
import de.dfki.stickman3D.animationlogic.Animation3D;
import de.dfki.stickman3D.animationlogic.Animation3D.ANIMTYPE;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class Packageparser
{

    private ArrayList<String> classNameList = new ArrayList<>();
    private String packName = "de.dfki.stickman3D.animation.facefx";
    private String packDir;
    private Enumeration<URL> dir;

    public Packageparser(String packName)
    {
        this.packName = packName;
        ScanPackage();
    }
    //de/dfki/stickman3D/animation/face/
    ///////////////////////7
    private void ScanPackage()
    {
        packDir = packName.replace(".", "/");
        try
        {
            dir = Thread.currentThread().getContextClassLoader().getResources(packDir);
            while (dir.hasMoreElements())
            {
                URL url = dir.nextElement();
                String protocol = url.getProtocol();
                if ("file".equals(protocol))
                {
                    String filePath = URLDecoder.decode(url.getFile(), "UTF-8");
                    File dir = new File(filePath);
                    File[] ff = dir.listFiles();
                    for(int i = 0; i<ff.length; i++)
                    {
                        String s = ff[i].getName();
                    }
                    findAndAddClassesInPackageByFile(packName, filePath);
                } else
                {
                    final File jarFile = new File(getClass().getProtectionDomain().getCodeSource().getLocation().getPath());
                    if (jarFile.isFile())
                    {  // Run with JAR file
                        final JarFile jar = new JarFile(jarFile);
                        final Enumeration<JarEntry> entries = jar.entries(); //gives ALL entries in jar
                        while (entries.hasMoreElements())
                        {
                            String name = entries.nextElement().getName();

                            if (name.contains(packDir))
                            {
                                String split[] = name.split("/");
                                //if name contains any className
                                if (split.length > 5)
                                {
                                    String className = split[split.length - 1];
                                    String packageDirectory = packDir.replace("/", ".");
                                    className = className.replace(".class", "");
                                    findAndAddClassesInList(className, packageDirectory);
                                }
                            }
                        }
                        jar.close();

//                        String filePath = "C:\\Users\\EmpaT\\Desktop\\Stickman3DNonStaticVersion\\Stickman\\classes\\artifacts\\Stickman_jar\\Stickman.jar\\de\\dfki\\stickman3D\\animation\\face";
//                        findAndAddClassesInPackageByFile(packName, filePath);
                    }

                }
            }
        } catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private void findAndAddClassesInList(String className, String packageDirectory)
    {
        try
        {
            Class<?> myClass = Thread.currentThread().getContextClassLoader()
                    .loadClass(packageDirectory + "." + className);

            Object object = myClass.newInstance();

            Animation3D class1 = null;
            if (object instanceof Animation3D)
            {
                class1 = (Animation3D) object;
            }

            if (class1 != null && class1.mAnimType == ANIMTYPE.ON)
            {
                classNameList.add(className);
            }
        } catch (Exception e)
        {
//						e.printStackTrace();
        }
    }

    private void findAndAddClassesInPackageByFile(String packName, String filePath)
    {
        File dir = new File(filePath);
        if (dir.exists() && dir.isDirectory())
        {
            File[] dirfiles = dir.listFiles(new FileFilter()
            {
                @Override
                public boolean accept(File pathname)
                {
                    return pathname.isDirectory() || pathname.getName().endsWith(".class");
                }
            });

            for (File file : dirfiles)
            {
                if (file.isDirectory())
                {
                    findAndAddClassesInPackageByFile(packName + "." + file.getName(), file.getAbsolutePath());
                } else
                {

                    String className = file.getName().substring(0, file.getName().length() - 6);
                    try
                    {
                        Class<?> myClass = Thread.currentThread().getContextClassLoader()
                                .loadClass(packName + "." + className);

                        Object object = myClass.newInstance();

                        Animation3D class1 = null;
                        if (object instanceof Animation3D)
                        {
                            class1 = (Animation3D) object;
                        }

                        if (class1 != null && class1.mAnimType == ANIMTYPE.ON)
                        {
                            classNameList.add(className);
                        }
                    } catch (Exception e)
                    {
//						e.printStackTrace();
                    }

                }
            }
        }
    }

    public ArrayList<String> getClassNameList()
    {
        return classNameList;
    }
}