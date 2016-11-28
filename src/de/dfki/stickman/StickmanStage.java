package de.dfki.stickman;

import de.dfki.common.CommonStickmansOnStage;
import de.dfki.common.interfaces.StageStickman;
import de.dfki.stickman.util.StickmanStageLayout;
import de.dfki.stickmanfx.StickmanFX;
import javafx.scene.layout.HBox;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/**
 *
 * @author Patrick Gebhard
 *
 */
public class StickmanStage extends JFrame implements  StageStickman {

    public static final float STICKMAN_SIZE_FACTOR = 0.8f;
    public static final float HEIGHT_ADJUSTMENT = 2 / 3.0f;
    public static final float STICKMAN_IN_BETWEEN_DISTANCE_FACTOR = 0.9f;


    private final HashMap<String, Stickman> sStickmansOnStage = new HashMap<>();
    static float sScale = 1.0f;
    protected  boolean sFullScreen = false;
    private JPanel sStickmanPanel;

    // logging
    public static final Logger mLogger = Logger.getAnonymousLogger();

    public StickmanStage() {
        super("Stickman Stage");
        sStickmanPanel = new JPanel();
        sStickmanPanel.setLayout(new StickmanStageLayout());
        sStickmanPanel.setOpaque(false);
        add(sStickmanPanel);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE); // This one is needed by SceneMaker
        ConsoleHandler ch = new ConsoleHandler();
        ch.setFormatter(new StickmanStageLogFormatter());
    }

    public void setFullScreenSize(){
        Dimension size = java.awt.Toolkit.getDefaultToolkit().getScreenSize();;
/*        setUndecorated(true);*/

        setBackground(new Color(128, 0, 5, 255));
        setMinimumSize(size);
        setPreferredSize(size);
        sStickmanPanel.revalidate();
        sStickmanPanel.repaint();
    }

    public void addStickmanToPanel(Stickman s){
        sStickmanPanel.add(s);
        sStickmanPanel.revalidate();
    }


    public  Stickman getStickman(String name) {
        if (sStickmansOnStage.containsKey(name.toLowerCase())) {
            return sStickmansOnStage.get(name.toLowerCase());
        } else {
            return null;
        }
    }

    public  void showStickmanName(boolean show) {
        for (Stickman s : sStickmansOnStage.values()) {
            s.mShowName = show;
        }
    }

    public static void sendTimeMarkInformation(String timemark) {
    }

    public static void sendAnimationUpdate(String state, String id) {
    }

    @Override
    public float getFullScreenScale() {
        Dimension size = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        float mHeight = (float) size.getHeight();
        return mHeight / (float) Stickman.mDefaultSize.height * sScale * STICKMAN_SIZE_FACTOR;
    }

    @Override
    public Dimension getFullScreenDimension() {
        Dimension size = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        float mHeight = (float) size.getHeight();
        return new Dimension(new Float(mHeight * HEIGHT_ADJUSTMENT * sScale).intValue(), new Float(mHeight * sScale * STICKMAN_IN_BETWEEN_DISTANCE_FACTOR).intValue());
    }

    @Override
    public void addStickmanToStage(String stageIdentifier) {

    }

    @Override
    public void setStageFullScreen(String stageIdentifier) {
        sFullScreen = true;
    }

    @Override
    public void setStageNonFullScreen(String stageIdentifier) {
        sFullScreen = false;
    }

    @Override
    public void setStickamnsOnStage(CommonStickmansOnStage stickamnsOnStage, String identifier) {
        CommonStickmansOnStage stickamnsOnStage1 = stickamnsOnStage;
    }

    @Override
    public HBox getStickmanPane(String stageIdentifier) throws Exception {
        return null;
    }

    public void clearStage(){
        dispose();
    }

    @Override
    public BufferedImage getStageAsImage(String stageIdentifier) {
        BufferedImage image = new BufferedImage(sStickmanPanel.getWidth(), sStickmanPanel.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics g = image.createGraphics();
        sStickmanPanel.paint(g);
        g.dispose();
        return image;
    }

    private static class StickmanStageLogFormatter extends Formatter {
        @Override
        public String format(LogRecord record) {
            return ((new StringBuffer()).append(record.getLevel()).append(": ").append(record.getMessage()).append("\n")).toString();
        }
    }



	@Override
	public void addStickmanToStage(String mStageIdentifier, StickmanFX mStickmanFX) throws Exception
	{
		// TODO Auto-generated method stub
		
	}

    @Override
    public void lauchStickman() {

    }

    @Override
    public void clearStage(String stageIdentifier) {

    }

    @Override
    public void showStage(String configStage) {

    }

    @Override
    public String createNewStage(int x, int y, boolean decoration) throws IOException {
        return null;
    }
}
