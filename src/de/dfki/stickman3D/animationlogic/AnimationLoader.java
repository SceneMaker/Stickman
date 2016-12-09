/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animationlogic;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import de.dfki.stickman3D.Stickman3D;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class AnimationLoader {
	private final static String sANIMATIONPATH = "de.dfki.stickman3D";
	private static final Set<String> sAnimationSubPackages = new HashSet<>(
			Arrays.asList("head", "face", "gesture", "environment", "posture"));
	private static AnimationLoader sInstance = null;
	private static long sID = 0;

	private AnimationLoader() {
	}

	public static AnimationLoader getInstance() {
		if (sInstance == null) {
			sInstance = new AnimationLoader();
		}

		return sInstance;
	}

	public String getNextID() {
		sID++;
		return "a" + sID;
	}

	private String getAnimationClasspath(Stickman3D.TYPE stickmantype, String name) {
		String classPath = "";

		for (String s : sAnimationSubPackages) {
			classPath = sANIMATIONPATH + ".animation." + s + "." + name;

			try {
				Class.forName(classPath);
				break;
			} catch (ClassNotFoundException ex) {
				// ex.printStackTrace();
			}
		}
		return classPath;
	}

	private String getEventAnimationClasspath(Stickman3D.TYPE stickmantype, String name) {
		String classPath = "";

		for (String s : sAnimationSubPackages) {
			classPath = sANIMATIONPATH + ".animation." + s + ".event." + name;

			try {
				Class.forName(classPath);
				break;
			} catch (ClassNotFoundException ex) {
				// ex.printStackTrace();
			}
		}
		return classPath;
	}

	public Animation loadAnimation(Stickman3D sm, String name, int duration, boolean block) {
		Animation a = null;

		String cp = getAnimationClasspath(sm.mType, name);
		try {
			Class c = Class.forName(cp);
			Constructor[] constructors = c.getConstructors();
			for (Constructor con : constructors) {
				Class[] params = con.getParameterTypes();

				if (params.length == 3) {
					if (params[0].getSimpleName().equalsIgnoreCase("stickman3D")
							&& params[1].getSimpleName().equalsIgnoreCase("int")
							&& params[2].getSimpleName().equalsIgnoreCase("boolean")) {
						a = (Animation) c.getDeclaredConstructor(params).newInstance(sm, duration, block);
					}
				}

			}
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
				| IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
			sm.mLogger.severe("Animation \"" + name + "\" cannot be found in " + cp);
		}

		if (a != null) {
			a.mID = getNextID();
		}
		return a;
	}
	
	public Animation loadAnimation(Stickman3D sm, String name, int frequent, int actionDuration, boolean block) {
        Animation a = null;

        String cp = getAnimationClasspath(((Stickman3D) sm).mType, name);
        try {
            Class c = Class.forName(cp);
            Constructor[] constructors = c.getConstructors();
            for (Constructor con : constructors) {
                Class[] params = con.getParameterTypes();

                if (params.length == 4) {
                    if (params[0].getSimpleName().equalsIgnoreCase("stickman3d")
                            && params[1].getSimpleName().equalsIgnoreCase("int")
                            && params[2].getSimpleName().equalsIgnoreCase("int")
                            && params[3].getSimpleName().equalsIgnoreCase("boolean")) {
                        a = (Animation) c.getDeclaredConstructor(params).newInstance(sm, frequent, actionDuration, block);
                    }
                }

            }
        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            ((Stickman3D) sm).mLogger.severe("Animation \"" + name + "\" cannot be found in " + cp);
        }

        if (a != null) {
            a.mID = getNextID();
        }
        return a;
    }

	public EventAnimation loadEventAnimation(Stickman3D sm, String name, int duration, boolean block) {
		EventAnimation a = null;

		String cp = getEventAnimationClasspath(sm.mType, name);

		try {
			Class c = Class.forName(cp);

			Constructor[] constructors = c.getConstructors();
			for (Constructor con : constructors) {
				Class[] params = con.getParameterTypes();

				if (params.length == 3) {
					if (params[0].getSimpleName().equalsIgnoreCase("stickman3D")
							&& params[1].getSimpleName().equalsIgnoreCase("int")
							&& params[2].getSimpleName().equalsIgnoreCase("boolean")) {
						a = (EventAnimation) c.getDeclaredConstructor(params).newInstance(sm, duration, block);
					}
				}
			}
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
				| IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
			sm.mLogger.severe("Animation \"" + name + "\" cannot be found in " + cp);
		}

		a.mID = getNextID();

		return a;
	}
}
