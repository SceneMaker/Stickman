/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.reeti.animationlogic;

import de.dfki.common.agent.IAgent;
import de.dfki.common.enums.Gender;
import de.dfki.reeti.Reeti;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Beka Aptsiauri
 */
public class AnimationLoaderReeti
{

    private final static String sANIMATIONPATH = "de.dfki.reeti";
    private static final Set<String> sAnimationSubPackages = new HashSet<>(Arrays.asList("head", "face", "gesture", "environment", "posture"));
    private static AnimationLoaderReeti sInstance = null;
    private static long sID = 0;

    private AnimationLoaderReeti()
    {
    }

    public static AnimationLoaderReeti getInstance()
    {
        if (sInstance == null)
        {
            sInstance = new AnimationLoaderReeti();
        }

        return sInstance;
    }

    public String getNextID()
    {
        sID++;
        return "a" + sID;
    }

    private String getAnimationClasspath(Gender.TYPE type, String name)
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
                //nothing
            }
        }
        return classPath;
    }

    private String getEventAnimationClasspath(Gender.TYPE type, String name)
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
                //nothing
            }
        }
        return classPath;
    }

    public AnimationReeti loadAnimation(IAgent sm, String name, int duration, boolean block, HashMap<String, String> extraParams)
    {
        AnimationReeti a = null;

        String cp = getAnimationClasspath(((Reeti) sm).mType, name);
        try
        {
            Class c = Class.forName(cp);
            Constructor[] constructors = c.getConstructors();
            for (Constructor con : constructors)
            {
                Class[] params = con.getParameterTypes();
                if (params.length == 3 && extraParams.size() == 0)
                {
                    if (params[0].getSimpleName().equalsIgnoreCase("reeti")
                            && params[1].getSimpleName().equalsIgnoreCase("int")
                            && params[2].getSimpleName().equalsIgnoreCase("boolean"))
                    {
                        a = (AnimationReeti) c.getDeclaredConstructor(params).newInstance(sm, duration, block);
                    }
                } else if (params.length == 4)
                {
                    if (params[0].getSimpleName().equalsIgnoreCase("reeti")
                            && params[1].getSimpleName().equalsIgnoreCase("int")
                            && params[2].getSimpleName().equalsIgnoreCase("boolean")
                            && params[3].getSimpleName().equalsIgnoreCase("hashMap"))
                    {
                        a = (AnimationReeti) c.getDeclaredConstructor(params).newInstance(sm, duration, block, extraParams);
                    }
                }

            }
        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex)
        {
            ((Reeti) sm).mLogger.severe("IAnimation \"" + name + "\" cannot be found in " + cp);
        }

        if (a != null)
        {
            a.mID = getNextID();
        }
        return a;
    }

    public AnimationReeti loadAnimation(IAgent sm, String name, int duration, boolean block)
    {
        AnimationReeti a = null;

        String cp = getAnimationClasspath(((Reeti) sm).mType, name);
        try
        {
            Class c = Class.forName(cp);
            Constructor[] constructors = c.getConstructors();
            for (Constructor con : constructors)
            {
                Class[] params = con.getParameterTypes();

                if (params.length == 3)
                {
                    if (params[0].getSimpleName().equalsIgnoreCase("reeti")
                            && params[1].getSimpleName().equalsIgnoreCase("int")
                            && params[2].getSimpleName().equalsIgnoreCase("boolean"))
                    {
                        a = (AnimationReeti) c.getDeclaredConstructor(params).newInstance(sm, duration, block);
                    }
                }

            }
        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex)
        {
            ((Reeti) sm).mLogger.severe("IAnimation \"" + name + "\" cannot be found in " + cp);
        }

        if (a != null)
        {
            a.mID = getNextID();
        }

        return a;
    }

    public AnimationReeti loadAnimation(IAgent sm, String name, int frequent, int pos, boolean block)
    {
        AnimationReeti a = null;

        String cp = getAnimationClasspath(((Reeti) sm).mType, name);
        try
        {
            Class c = Class.forName(cp);
            Constructor[] constructors = c.getConstructors();
            for (Constructor con : constructors)
            {
                Class[] params = con.getParameterTypes();

                if (params.length == 4)
                {
                    if (params[0].getSimpleName().equalsIgnoreCase("reeti")
                            && params[1].getSimpleName().equalsIgnoreCase("int")
                            && params[2].getSimpleName().equalsIgnoreCase("int")
                            && params[3].getSimpleName().equalsIgnoreCase("boolean"))
                    {
                        a = (AnimationReeti) c.getDeclaredConstructor(params).newInstance(sm, frequent, pos, block);
                    }
                }

            }
        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex)
        {
            ((Reeti) sm).mLogger.severe("IAnimation \"" + name + "\" cannot be found in " + cp);
        }

        if (a != null)
        {
            a.mID = getNextID();
        }
        return a;
    }

    public EventAnimationReeti loadEventAnimation(IAgent sm, String name, int duration, boolean block)
    {
        EventAnimationReeti a = null;

        String cp = getEventAnimationClasspath(((Reeti) sm).mType, name);

        try
        {
            Class c = Class.forName(cp);

            Constructor[] constructors = c.getConstructors();
            for (Constructor con : constructors)
            {
                Class[] params = con.getParameterTypes();

                if (params.length == 3)
                {
                    if (params[0].getSimpleName().equalsIgnoreCase("reeti")
                            && params[1].getSimpleName().equalsIgnoreCase("int")
                            && params[2].getSimpleName().equalsIgnoreCase("boolean"))
                    {
                        a = (EventAnimationReeti) c.getDeclaredConstructor(params).newInstance(sm, duration, block);
                    }
                }
            }
        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex)
        {
            ((Reeti) sm).mLogger.severe("IAnimation \"" + name + "\" cannot be found in " + cp);
        }

        a.mID = getNextID();

        return a;
    }
}
