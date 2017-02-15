/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.reeti.dynamic.classes;

import de.dfki.reeti.Reeti;
import de.dfki.reeti.animationlogic.AnimationReeti;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.tools.Diagnostic;
import javax.tools.DiagnosticListener;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

/**
 *
 * @author EmpaT
 */
public class DynamicCompiler {

    private static int X;
    private static int Y;
    private static int Z;
    private static String bodypart;
    private static String className;
    public static Reeti currentStickman;
    public static StringBuilder methodContent = new StringBuilder();
    public static StringBuilder startClass;
    public static StringBuilder endClass = new StringBuilder();

    /**
     * where shall the compiled class be saved to (should exist already)
     */
    private static final String CLASSOUTPUTFOLDER = "src\\";

    public static class MyDiagnosticListener implements DiagnosticListener<JavaFileObject> {

        @Override
        public void report(Diagnostic<? extends JavaFileObject> diagnostic) {

            System.out.println("Line Number->" + diagnostic.getLineNumber());
            System.out.println("code->" + diagnostic.getCode());
            System.out.println("Message->"
                    + diagnostic.getMessage(Locale.ENGLISH));
            System.out.println("Source->" + diagnostic.getSource());
            System.out.println(" ");
        }
    }

    /**
     * java File Object represents an in-memory java source file <br>
     * so there is no need to put the source file on hard disk *
     */
    public static class InMemoryJavaFileObject extends SimpleJavaFileObject {

        private String contents = null;

        public InMemoryJavaFileObject(String className, String contents) throws Exception {
            super(URI.create("string:///" + className.replace('.', '/')
                    + JavaFileObject.Kind.SOURCE.extension), JavaFileObject.Kind.SOURCE);
            this.contents = contents;
        }

        @Override
        public CharSequence getCharContent(boolean ignoreEncodingErrors)
                throws IOException {
            return contents;
        }
    }

    /**
     * Get a simple Java File Object ,<br>
     * It is just for demo, content of the source code is dynamic in real use
     * case
     */
    private static JavaFileObject getJavaFileObject() throws IOException {
        startClass = new StringBuilder();
        startClass.append("package de.dfki.stickman3D.dynamic.classes; \n");
        startClass.append("import java.util.ArrayList;\n");
        startClass.append("import de.dfki.stickman3D.Stickman3D;\n");
        startClass.append("import de.dfki.stickman3D.StickmanStageController;\n");
        startClass.append("import de.dfki.stickman3D.animationlogic.AnimationContent3D;\n");
        startClass.append("import de.dfki.stickman3D.animationlogic.Animation3D;");
        startClass.append("public class ").append(className).append(" extends Animation3D{ \n");
        startClass.append("public ").append(className).append("(){ \n");
        startClass.append("mAnimType = ANIMTYPE.ON; \n");
        startClass.append("} \n");
        startClass.append("public ").append(className).append("(Stickman3D sm, int duration, boolean block) { \n");
        startClass.append("super(sm, duration, block); \n");
        startClass.append("} \n");
        startClass.append("@Override \n");
        startClass.append("public void playAnimation() { \n");

        startClass.append(methodContent);

        startClass.append("} \n");
        startClass.append("} \n");

//        File dFile = new File("build\\classes\\de\\dfki\\stickman3D\\dynamic\\classes\\" + className + ".class");
//        dFile.delete();
        createJavaFile();

        JavaFileObject so = null;
        try {
            so = new InMemoryJavaFileObject(className, startClass.toString());
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return so;
    }

    /**
     * compile your files by JavaCompiler
     */
    public static void compile(Iterable<? extends JavaFileObject> files) {
        //System.setProperty("java.home", "C:\\Program Files\\Java\\jdk1.8.0_111");
        //get system compiler:
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

        // for compilation diagnostic message processing on compilation WARNING/ERROR
        MyDiagnosticListener c = new MyDiagnosticListener();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(c,
                Locale.ENGLISH,
                null);
        //specify classes output folder
        //Iterable options = Arrays.asList("-d", CLASSOUTPUTFOLDER);
        Iterable options = Arrays.asList("-d", "build\\classes");
        JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager,
                c, options, null,
                files);
        Boolean result = task.call();
        if (result == true) {
            System.out.println("Succeeded");
        }

    }

    /**
     * run class from the compiled byte code file by URLClassloader
     */
    public static void runIt(String nameOfClass) {
        // Create a File object on the root of the directory
        // containing the class file
        File file = new File(CLASSOUTPUTFOLDER);

        try {
            // Convert File to a URL
            URL url = file.toURL(); // file:/classes/demo
            URL[] urls = new URL[]{url};

            // Create a new class loader with the directory
            ClassLoader loader = new URLClassLoader(urls);

            Class thisClass = loader.loadClass("de.dfki.stickman3D.dynamic.classes." + nameOfClass);
            Constructor[] constructors = thisClass.getConstructors();
            for (Constructor con : constructors) {
                Class[] params = con.getParameterTypes();

                if (params.length == 3) {
                    if (params[0].getSimpleName().equalsIgnoreCase("stickman3d")
                            && params[1].getSimpleName().equalsIgnoreCase("int")
                            && params[2].getSimpleName().equalsIgnoreCase("boolean")) {
                        AnimationReeti a = (AnimationReeti) thisClass.getDeclaredConstructor(params).newInstance(currentStickman, 500, true);
                        a.start();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void create() {
        //1.Construct an in-memory java source file from your dynamic code
        JavaFileObject file = null;
        try {
            file = getJavaFileObject();
        } catch (IOException ex) {
            Logger.getLogger(DynamicCompiler.class.getName()).log(Level.SEVERE, null, ex);
        }
        Iterable<? extends JavaFileObject> files = Arrays.asList(file);

        //2.Compile your files by JavaCompiler
        compile(files);

        //3.Load your class by URLClassLoader, then instantiate the instance, and call method by reflection
        //runIt();
    }

    public static void setClassName(String name) {
        className = name;
    }

    public static void setXYZ(int x, int y, int z) {
        X = x;
        Y = y;
        Z = z;
    }

    public static void setPodyPart(String part) {
        bodypart = part;
    }

    public static int getX() {
        return X;
    }

    public static int getY() {
        return Y;
    }

    public static int getZ() {
        return Z;
    }

    public static String getBodypart() {
        return bodypart;
    }

    public static void createJavaFile() {
        File f = new File(CLASSOUTPUTFOLDER + "de\\dfki\\Stickman3D\\dynamic\\classes\\" + className + ".java");
        FileWriter fw = null;
        try {
            fw = new FileWriter(f);
            fw.write(startClass.toString());
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(DynamicCompiler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
