package de.dfki.stickman;

import de.dfki.common.StageStickman;
import de.dfki.common.CommonStickmansOnStage;
import de.dfki.stickman.util.StickmanStageLayout;
import javafx.stage.Stage;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author Patrick Gebhard
 *
 */
public class StickmanStage extends JFrame implements MouseListener , StageStickman {

    private final HashMap<String, Stickman> sStickmansOnStage = new HashMap<>();
    private JPanel sStickmanPanel;
    private static StickmanStage sInstance;
    private HashMap<String, Stage> stickmanFXStages = new HashMap<>();
    private CommonStickmansOnStage stickamnsOnStage;
    //grahics
    static float sScale = 1.0f;
    protected  boolean sFullScreen = false;
    // logging
    public static final Logger mLogger = Logger.getAnonymousLogger();

    private StickmanStage() {
        super("Stickman Stage");

        sStickmanPanel = new JPanel();
        sStickmanPanel.setLayout(new StickmanStageLayout());
        sStickmanPanel.setOpaque(false);
        add(sStickmanPanel);

        /*if (sFullScreen) {
            mLogger.info("Full Screen Mode ...");
            Dimension size = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
            mWidth = size.width;
            mHeight = size.height;
            setUndecorated(true);
            setBackground(new Color(128, 128, 128, 255));
            setMinimumSize(size);
            setPreferredSize(size);
        }*/
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE); // This one is needed by SceneMaker
        ConsoleHandler ch = new ConsoleHandler();
        ch.setFormatter(new StickmanStageLogFormatter());
        addMouseListener(this);
    }

    public static StickmanStage getInstance() {
        if (sInstance == null) {
            sInstance = new StickmanStage();
        }
        return sInstance;
    }


    /*public  void addStickman(String name, Stickman.TYPE gender) {
        if (!sStickmansOnStage.containsKey(name.toLowerCase())) {
            if (sFullScreen) {
                sStickmansOnStage.put(name.toLowerCase(),
                        new Stickman(name,
                                gender,
                                mHeight / (float) Stickman.mDefaultSize.height * sScale,
                                new Dimension(new Float(mHeight * 2 / 3 * sScale).intValue(), new Float(mHeight * sScale).intValue())));
                getStickman(name).mShowBackground = false;
                getStickman(name).mShowStage = false;
                getStickman(name).mShowName = false;
            } else {
                sStickmansOnStage.put(name.toLowerCase(), new Stickman(name, gender, sScale));
            }
            sStickmanPanel.add(getStickman(name));
            sStickmanPanel.revalidate();
        }

        // resize the stuff ...
        StickmanStage.getInstance().pack();
        StickmanStage.getInstance().setVisible(true);
    }*/

    public  Stickman getStickman(String name) {
        Stickman sm;
        if (sStickmansOnStage.containsKey(name.toLowerCase())) {
            return sStickmansOnStage.get(name.toLowerCase());
        } else {
            return null;
        }
    }



    public  void clearStage() {
        Set<String> deleteStickman = new HashSet<>();
        sStickmansOnStage.keySet().stream().map((s) -> {
            deleteStickman.add(s);
            return s;
        }).forEach((s) -> {
            getStickman(s).mAnimationScheduler.end();
        });
        deleteStickman.stream().map((s) -> {
            sStickmanPanel.remove(getStickman(s));
            return s;
        }).forEach((s) -> {
            sStickmansOnStage.remove(s);
        });

        // resize the stuff ...
        StickmanStage.getInstance().pack();
        StickmanStage.getInstance().setVisible(false);


        sInstance = null;
    }

    public  void showStickmanName(boolean show) {
        for (Stickman s : sStickmansOnStage.values()) {
            s.mShowName = show;
        }
    }


    /*public  void parseStickmanMLCmd(String cmd) {
        // TODO cut the crap with the two animation types ...
        Animation a = (cmd.contains("StickmanEventAnimation")) ? new EventAnimation() : new Animation();

        boolean r = XMLUtilities.parseFromXMLStream(a, new ByteArrayInputStream(cmd.getBytes(Charset.forName("UTF-8"))));

        String stickmanname = a.mStickmanName;
        String animationname = a.mName;
        String id = a.mID;
        int duration = a.mDuration;
        boolean blocking = a.mBlocking;
        Object parameter = a.mParameter;
        if(stickmanname != null){
            a = (a instanceof EventAnimation)
                    ? AnimationLoader.getInstance().loadEventAnimation(getStickman(stickmanname), animationname, duration, blocking)
                    : AnimationLoader.getInstance().loadAnimation(getStickman(stickmanname), animationname, duration, blocking);

            a.setID(id); // give the animation the same id (TODO - This is bad design and caused that the animation has to be "reloaded"
            a.mParameter = parameter;

            a.mStickman.playAnimation(a);
        }
    }*/

    public static void sendTimeMarkInformation(String timemark) {
    }

    public static void sendAnimationUpdate(String state, String id) {
    }




    @Override
    public void mouseClicked(MouseEvent e) {
        getStickman("Anna").doAnimation("TouchHead", 70, true);
    	getStickman("Anna").doAnimation("WaveLeft", 300, true); 

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public float getFullScreenScale() {
        return 0;
    }

    @Override
    public Dimension getFullScreenDimension() {
        return null;
    }

    @Override
    public void addStickmanToStage(String stageIdentifier) {

    }

    @Override
    public void setStageFullScreen(String stageIdentifier) {

    }

    @Override
    public void setStageNonFullScreen(String stageIdentifier) {

    }

    @Override
    public void setStickamnsOnStage(CommonStickmansOnStage stickamnsOnStage) {
        this.stickamnsOnStage = stickamnsOnStage;
    }

    private static class StickmanStageLogFormatter extends Formatter {

        @Override
        public String format(LogRecord record) {
            return ((new StringBuffer()).append(record.getLevel()).append(": ").append(record.getMessage()).append("\n")).toString();
        }
    }
}
