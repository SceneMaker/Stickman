/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanFX.animationlogic;

import de.dfki.common.agent.IAgent;
import de.dfki.common.enums.Gender;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Beka Aptsiauri
 */
public class AnimationLoaderFX
{

    private final static String sANIMATIONPATH = "de.dfki.stickmanFX";
    private static final Set<String> sAnimationSubPackages = new HashSet<>(Arrays.asList("headfx", "facefx", "gesturefx", "environmentfx"));
    private static AnimationLoaderFX sInstance = null;
    private static long sID = 0;

    private AnimationLoaderFX()
    {
    }

    public static AnimationLoaderFX getInstance()
    {
        if (sInstance == null)
        {
            sInstance = new AnimationLoaderFX();
        }

        return sInstance;
    }

    public String getNextID()
    {
        sID++;
        return "a" + sID;
    }

    private String getAnimationClasspath(Gender.TYPE stickmantype, String name)
    {
        String classPath = "";

        for (String s : sAnimationSubPackages)
        {
            classPath = sANIMATIONPATH + ".animation." + s + "." + name;

            try
            {
                Class.forName(classPath);
                break;
            } catch (ClassNotFoundException ex)
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
            } catch (ClassNotFoundException ex)
            {
                //ex.printStackTrace();
            }
        }
        return classPath;
    }

    public AnimationStickman2D loadAnimation(IAgent sm, String name, int duration, boolean block)
    {
        AnimationStickman2D a = null;

        String cp = getAnimationClasspath(sm.getType(), name);
        try
        {
            Class c = Class.forName(cp);
            Constructor[] constructors = c.getConstructors();
            for (Constructor con : constructors)
            {
                Class[] params = con.getParameterTypes();

                if (params.length == 3)
                {
                    if (params[0].getSimpleName().equalsIgnoreCase("stickmanFX")
                            && params[1].getSimpleName().equalsIgnoreCase("int")
                            && params[2].getSimpleName().equalsIgnoreCase("boolean"))
                    {
                        a = (AnimationStickman2D) c.getDeclaredConstructor(params).newInstance(sm, duration, block);
                    }
                }

            }
        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex)
        {
        }

        if (a != null)
        {
            a.mID = getNextID();
        }
        return a;
    }

    public EventAnimationFX loadEventAnimation(IAgent sm, String name, int duration, boolean block)
    {
        EventAnimationFX a = null;

        String cp = getEventAnimationClasspath(sm.getType(), name);

        try
        {
            Class c = Class.forName(cp);

            Constructor[] constructors = c.getConstructors();
            for (Constructor con : constructors)
            {
                Class[] params = con.getParameterTypes();

                if (params.length == 3)
                {
                    if (params[0].getSimpleName().equalsIgnoreCase("stickmanFX")
                            && params[1].getSimpleName().equalsIgnoreCase("int")
                            && params[2].getSimpleName().equalsIgnoreCase("boolean"))
                    {
                        a = (EventAnimationFX) c.getDeclaredConstructor(params).newInstance(sm, duration, block);
                    }
                }
            }
        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex)
        {
        }

        a.mID = getNextID();

        return a;
    }
}
