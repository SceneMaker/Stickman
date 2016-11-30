/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanSwing.animationlogic;

import de.dfki.common.Gender;
import de.dfki.common.interfaces.Stickman;
import de.dfki.stickmanSwing.StickmanSwing;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Patrick Gebhard
 *
 */
public class AnimationLoaderSwing {

    private final static String sANIMATIONPATH = "de.dfki.stickmanSwing";
    private static final Set<String> sAnimationSubPackages = new HashSet<>(Arrays.asList("head", "face", "gesture", "environment"));
    private static AnimationLoaderSwing sInstance = null;
    private static long sID = 0;

    private AnimationLoaderSwing() {
    }

    public static AnimationLoaderSwing getInstance() {
        if (sInstance == null) {
            sInstance = new AnimationLoaderSwing();
        }

        return sInstance;
    }

    public String getNextID() {
        sID++;
        return "a" + sID;
    }

    private String getAnimationClasspath(Gender.TYPE stickmantype, String name) {
        String classPath = "";

        for (String s : sAnimationSubPackages) {
            classPath = sANIMATIONPATH /*+ stickmantype.name().toLowerCase()*/ + ".animation." + s + "." + name;

            try {
                Class.forName(classPath);
                break;
            } catch (ClassNotFoundException ex) {
                // be silent
            }
        }
        return classPath;
    }

    private String getEventAnimationClasspath(Gender.TYPE stickmantype, String name) {
        String classPath = "";

        for (String s : sAnimationSubPackages) {
            classPath = sANIMATIONPATH /*+ stickmantype.name().toLowerCase()*/ + ".animation." + s + ".event." + name;

            try {
                Class.forName(classPath);
                break;
            } catch (ClassNotFoundException ex) {
                // be silent
            }
        }
        return classPath;
    }

    public AnimationSwing loadAnimation(Stickman sm, String name, int duration, boolean block) {
        AnimationSwing a = null;

        String cp = getAnimationClasspath(sm.getType(), name);

        try {
            Class c = Class.forName(cp);
            Constructor[] constructors = c.getConstructors();
            for (Constructor con : constructors) {
                Class[] params = con.getParameterTypes();

                if (params.length == 3) {
                    if (params[0].getSimpleName().equalsIgnoreCase("stickmanSwing")
                            && params[1].getSimpleName().equalsIgnoreCase("int")
                            && params[2].getSimpleName().equalsIgnoreCase("boolean")) {
                        a = (AnimationSwing) c.getDeclaredConstructor(params).newInstance(sm, duration, block);
                    }
                }

            }
        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            StickmanSwing.mLogger.severe("AnimationSwing \"" + name + "\" cannot be found in " + cp);
        }

        if (a != null) {
            a.mID = getNextID();
        }
        return a;
    }

    public EventAnimationSwing loadEventAnimation(Stickman sm, String name, int duration, boolean block) {
        EventAnimationSwing a = null;

        String cp = getEventAnimationClasspath(sm.getType(), name);

        try {
            Class c = Class.forName(cp);

            Constructor[] constructors = c.getConstructors();
            for (Constructor con : constructors) {
                Class[] params = con.getParameterTypes();

                if (params.length == 3) {
                    if (params[0].getSimpleName().equalsIgnoreCase("stickmanSwing")
                            && params[1].getSimpleName().equalsIgnoreCase("int")
                            && params[2].getSimpleName().equalsIgnoreCase("boolean")) {
                        a = (EventAnimationSwing) c.getDeclaredConstructor(params).newInstance(sm, duration, block);
                    }
                }

            }
        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            StickmanSwing.mLogger.severe("AnimationSwing \"" + name + "\" cannot be found in " + cp);
        }

        a.mID = getNextID();

        return a;
    }
}
