/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animationlogic;

import de.dfki.common.Gender;
import de.dfki.common.interfaces.Stickman;
import de.dfki.stickman3D.Stickman3D;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class AnimationLoader3D
{
    private final static String sANIMATIONPATH = "de.dfki.stickman3D";
    private static final Set<String> sAnimationSubPackages = new HashSet<>(Arrays.asList("headfx", "facefx", "gesturefx", "environmentfx", "posturefx"));
    private static AnimationLoader3D sInstance = null;
    private static long sID = 0;

    private AnimationLoader3D() {
    }

    public static AnimationLoader3D getInstance()
    {
        if (sInstance == null) 
        {
            sInstance = new AnimationLoader3D();
        }

        return sInstance;
    }

    public String getNextID() 
    {
        sID++;
        return "a" + sID;
    }

    private String getAnimationClasspath(Gender.TYPE stickmantype, String name) {
        String classPath = "";

        for (String s : sAnimationSubPackages) 
        {
            classPath = sANIMATIONPATH  + ".animation." + s + "." + name;

            try 
            {
                Class.forName(classPath);
                break;
            } 
            catch (ClassNotFoundException ex) 
            {
                //ex.printStackTrace();
            }
        }
        return classPath;
    }

    private String getEventAnimationClasspath(Gender.TYPE stickmantype, String name)
    {
        String classPath = "";

        for (String s : sAnimationSubPackages) 
        {
            classPath = sANIMATIONPATH + ".animation." + s + ".event." + name;

            try 
            {
                Class.forName(classPath);
                break;
            } 
            catch (ClassNotFoundException ex) 
            {
                //ex.printStackTrace();
            }
        }
        return classPath;
    }

    public Animation3D loadAnimation(Stickman sm, String name, int duration, boolean block)
    {
        Animation3D a = null;

        String cp = getAnimationClasspath(((Stickman3D)sm).mType, name);
        try 
        {
            Class c = Class.forName(cp);
            Constructor[] constructors = c.getConstructors();
            for (Constructor con : constructors) 
            {
                Class[] params = con.getParameterTypes();

                if (params.length == 3) 
                {
                    if (params[0].getSimpleName().equalsIgnoreCase("stickman3d")
                            && params[1].getSimpleName().equalsIgnoreCase("int")
                            && params[2].getSimpleName().equalsIgnoreCase("boolean")) {
                        a = (Animation3D) c.getDeclaredConstructor(params).newInstance(sm, duration, block);
                    }
                }

            }
        } 
        catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) 
        {
            ((Stickman3D)sm).mLogger.severe("Animation \"" + name + "\" cannot be found in " + cp);
        }

        if (a != null) 
        {
            a.mID = getNextID();
        }
        return a;
    }

    public EventAnimation3D loadEventAnimation(Stickman sm, String name, int duration, boolean block)
    {
        EventAnimation3D a = null;

        String cp = getEventAnimationClasspath(((Stickman3D)sm).mType, name);

        try 
        {
            Class c = Class.forName(cp);

            Constructor[] constructors = c.getConstructors();
            for (Constructor con : constructors) 
            {
                Class[] params = con.getParameterTypes();

                if (params.length == 3) 
                {
                    if (params[0].getSimpleName().equalsIgnoreCase("stickman3d")
                            && params[1].getSimpleName().equalsIgnoreCase("int")
                            && params[2].getSimpleName().equalsIgnoreCase("boolean")) {
                        a = (EventAnimation3D) c.getDeclaredConstructor(params).newInstance(sm, duration, block);
                    }
                }
            }
        } 
        catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) 
        {
            ((Stickman3D)sm).mLogger.severe("Animation \"" + name + "\" cannot be found in " + cp);
        }

        a.mID = getNextID();

        return a;
    }
}
