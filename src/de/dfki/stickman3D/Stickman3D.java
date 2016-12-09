package de.dfki.stickman3D;

import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Toolkit;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Semaphore;
import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import de.dfki.action.sequence.WordTimeMarkSequence;
import de.dfki.stickman3D.animation.environment.Breathing;
import de.dfki.stickman3D.animation.environment.IdleBehavior;
import de.dfki.stickman3D.animationlogic.Animation;
import de.dfki.stickman3D.animationlogic.AnimationLoader;
import de.dfki.stickman3D.animationlogic.AnimationScheduler;
import de.dfki.stickman3D.animationlogic.EventAnimation;
import de.dfki.stickman3D.animationlogic.listener.AnimationListener;
import de.dfki.stickman3D.body.DownBody;
import de.dfki.stickman3D.body.FaceWrinkle;
import de.dfki.stickman3D.body.FemaleHair;
import de.dfki.stickman3D.body.Head;
import de.dfki.stickman3D.body.LeftEye;
import de.dfki.stickman3D.body.LeftEyebrow;
import de.dfki.stickman3D.body.LeftFinger1;
import de.dfki.stickman3D.body.LeftFinger2;
import de.dfki.stickman3D.body.LeftFinger3;
import de.dfki.stickman3D.body.LeftFinger4;
import de.dfki.stickman3D.body.LeftFoot;
import de.dfki.stickman3D.body.LeftForeArm;
import de.dfki.stickman3D.body.LeftForeLeg;
import de.dfki.stickman3D.body.LeftUpperArm;
import de.dfki.stickman3D.body.LeftUpperLeg;
import de.dfki.stickman3D.body.LeftWrist;
import de.dfki.stickman3D.body.MaleHair;
import de.dfki.stickman3D.body.Mouth;
import de.dfki.stickman3D.body.Neck;
import de.dfki.stickman3D.body.Nose;
import de.dfki.stickman3D.body.RightEye;
import de.dfki.stickman3D.body.RightEyebrow;
import de.dfki.stickman3D.body.RightFinger1;
import de.dfki.stickman3D.body.RightFinger2;
import de.dfki.stickman3D.body.RightFinger3;
import de.dfki.stickman3D.body.RightFinger4;
import de.dfki.stickman3D.body.RightFoot;
import de.dfki.stickman3D.body.RightForeArm;
import de.dfki.stickman3D.body.RightForeLeg;
import de.dfki.stickman3D.body.RightUpperArm;
import de.dfki.stickman3D.body.RightUpperLeg;
import de.dfki.stickman3D.body.RightWrist;
import de.dfki.stickman3D.body.Stars;
import de.dfki.stickman3D.body.UpperBody;
import de.dfki.stickman3D.body.UpperBodyAndHead;
import de.dfki.stickman3D.environment.SpeechBubble;
import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.transform.Affine;

/**
 *
 * @author Beka Aptsiauri
 *
 *         This work is inspired by the stickmans drawn by Sarah Johnson
 *         (www.sarah-johnson.com) in the Valentine music video from Kina
 *         Grannis shot by Ross Ching in 2012
 *
 */
public class Stickman3D extends Pane {

	public static enum TYPE {
		FEMALE, MALE
	};

	static public final Color sFOREGROUND = Color.rgb(188, 188, 188, (128 * 100 / 255) / 100f);
	public TYPE mType = TYPE.FEMALE;
	public String mName = "Stickman";
	public float mScale = 1.0f;
	public boolean mShowBackground = true;
	public boolean mShowStage = true;
	public boolean mShowName = true;
	public float mGeneralXTranslation = 0;
	public float mGeneralYTranslation = 0;
	Text nameText = new Text();

	// public static Dimension mDefaultSize = new Dimension(400, 400); // 400
	public static Dimension mDefaultSize = new Dimension(300, 800); // 400
	public static Dimension mSize = new Dimension(mDefaultSize);
	FontMetrics mFontMetrics;
	Font mFont;

	// steuert leaveSpeed von GoDown und ComeUp und Stickman Position auf Y
	// Achse
	public double leaveSpeed = 0;
	// leaving
	public boolean starShowControler = false;
	public boolean starShowC = false;
	public boolean fadeControler = false;
	public boolean setCharacterInvisible = false;
	// True: visible False:invisible
	public double mWobble = 0;
	// the shared variable to decide the while loop in IdleBehavior break or not
	public Boolean mIdleRun = false;
	// BehaviorThred. Es wird in StartIdle-Klasse initializiert
	public IdleBehavior mIdleBehavior;
	public Breathing mBreathing;

	// amimation stuff
	public Semaphore mAnimationLaunchControl = new Semaphore(1);
	public AnimationScheduler mAnimationSchedulerFX;
	private final List<AnimationListener> mAnimationListeners = new CopyOnWriteArrayList<AnimationListener>();

	// body parts
	public Head mHeadFX;
	public Nose mNoseFX;
	public MaleHair mMaleHairFX;
	public FemaleHair mFemaleHairFX;
	public LeftEyebrow mLeftEyebrowFX;
	public LeftEye mLeftEyeFX;
	public RightEyebrow mRightEyebrowFX;
	public RightEye mRightEyeFX;
	public Mouth mMouthFX;
	public Neck mNeckFX;
	public FaceWrinkle mFaceWrinkleFX;
	public UpperBody mUpperBody;
	public DownBody mDownBody;
	public LeftUpperArm mLeftUpperArmFX;
	public LeftForeArm mLeftForeArmFX;
	public LeftWrist mLeftWrist;
	public LeftFinger1 mLeftFinger1;
	public LeftFinger2 mLeftFinger2;
	public LeftFinger3 mLeftFinger3;
	public LeftFinger4 mLeftFinger4;
	public RightUpperArm mRightUpperArmFX;
	public RightForeArm mRightForeArmFX;
	public RightWrist mRightWrist;
	public RightFinger1 mRightFinger1;
	public RightFinger2 mRightFinger2;
	public RightFinger3 mRightFinger3;
	public RightFinger4 mRightFinger4;
	public LeftUpperLeg mLeftUpperLegFX;
	public LeftForeLeg mLeftForeLegFX;
	public LeftFoot mLeftFootFX;
	public Stars mStarsFX;
	public RightUpperLeg mRightUpperLegFX;
	public RightForeLeg mRightForeLegFX;
	public RightFoot mRightFootFX;
	public UpperBodyAndHead mUpperBodyAndHand;
	// environment
	public SpeechBubble mSpeechBubbleFX;
	// logging
	public final Logger mLogger = Logger.getAnonymousLogger();
	// id
	private long mID = 0;

	public Stickman3D(String name, TYPE gender, float scale, Dimension size) {
		mSize = size;
		mScale = scale;

		mName = name;
		mType = gender;

		mHeadFX = new Head(this);
		mMaleHairFX = new MaleHair(this);
		mFemaleHairFX = new FemaleHair(this);
		mLeftEyebrowFX = new LeftEyebrow(mHeadFX);
		mLeftEyeFX = new LeftEye(mHeadFX);
		mRightEyebrowFX = new RightEyebrow(mHeadFX);
		mRightEyeFX = new RightEye(mHeadFX);
		mNoseFX = new Nose(mHeadFX);
		mMouthFX = new Mouth(mHeadFX);
		mFaceWrinkleFX = new FaceWrinkle(mHeadFX);
		mNeckFX = new Neck(mHeadFX);
		mUpperBody = new UpperBody(mNeckFX);
		mDownBody = new DownBody(mUpperBody);
		mLeftUpperArmFX = new LeftUpperArm(mUpperBody);
		mLeftForeArmFX = new LeftForeArm(mLeftUpperArmFX);
		mLeftWrist = new LeftWrist(mLeftForeArmFX);
		mLeftFinger1 = new LeftFinger1(mLeftWrist);
		mLeftFinger2 = new LeftFinger2(mLeftWrist);
		mLeftFinger3 = new LeftFinger3(mLeftWrist);
		mLeftFinger4 = new LeftFinger4(mLeftWrist);
		mRightUpperArmFX = new RightUpperArm(mUpperBody);
		mRightForeArmFX = new RightForeArm(mRightUpperArmFX);
		mRightWrist = new RightWrist(mRightForeArmFX);
		mRightFinger1 = new RightFinger1(mRightWrist);
		mRightFinger2 = new RightFinger2(mRightWrist);
		mRightFinger3 = new RightFinger3(mRightWrist);
		mRightFinger4 = new RightFinger4(mRightWrist);
		mLeftUpperLegFX = new LeftUpperLeg(mDownBody);
		mLeftForeLegFX = new LeftForeLeg(mLeftUpperLegFX);
		mLeftFootFX = new LeftFoot(mLeftForeLegFX);
		mStarsFX = new Stars(mUpperBody);
		mRightUpperLegFX = new RightUpperLeg(mDownBody);
		mRightForeLegFX = new RightForeLeg(mRightUpperLegFX);
		mRightFootFX = new RightFoot(mRightForeLegFX);

		mUpperBodyAndHand = new UpperBodyAndHead(mHeadFX, mUpperBody, mNeckFX);

		mSpeechBubbleFX = new SpeechBubble(mHeadFX);
		init();
		this.addAllParts();
		updateStickmanPosition();
	}

	public Stickman3D(String name, TYPE gender, float scale) {
		mScale = scale;

		mName = name;
		mType = gender;

		mHeadFX = new Head(this);
		mMaleHairFX = new MaleHair(this);
		mFemaleHairFX = new FemaleHair(this);
		mLeftEyebrowFX = new LeftEyebrow(mHeadFX);
		mLeftEyeFX = new LeftEye(mHeadFX);
		mRightEyebrowFX = new RightEyebrow(mHeadFX);
		mRightEyeFX = new RightEye(mHeadFX);
		mNoseFX = new Nose(mHeadFX);
		mMouthFX = new Mouth(mHeadFX);
		mFaceWrinkleFX = new FaceWrinkle(mHeadFX);
		mNeckFX = new Neck(mHeadFX);
		mUpperBody = new UpperBody(mNeckFX);
		mDownBody = new DownBody(mUpperBody);
		mLeftUpperArmFX = new LeftUpperArm(mUpperBody);
		mLeftForeArmFX = new LeftForeArm(mLeftUpperArmFX);
		mLeftWrist = new LeftWrist(mLeftForeArmFX);
		mLeftFinger1 = new LeftFinger1(mLeftWrist);
		mLeftFinger2 = new LeftFinger2(mLeftWrist);
		mLeftFinger3 = new LeftFinger3(mLeftWrist);
		mLeftFinger4 = new LeftFinger4(mLeftWrist);
		mRightUpperArmFX = new RightUpperArm(mUpperBody);
		mRightForeArmFX = new RightForeArm(mRightUpperArmFX);
		mRightWrist = new RightWrist(mRightForeArmFX);
		mRightFinger1 = new RightFinger1(mRightWrist);
		mRightFinger2 = new RightFinger2(mRightWrist);
		mRightFinger3 = new RightFinger3(mRightWrist);
		mRightFinger4 = new RightFinger4(mRightWrist);
		mLeftUpperLegFX = new LeftUpperLeg(mDownBody);
		mLeftForeLegFX = new LeftForeLeg(mLeftUpperLegFX);
		mLeftFootFX = new LeftFoot(mLeftForeLegFX);
		mStarsFX = new Stars(mUpperBody);
		mRightUpperLegFX = new RightUpperLeg(mDownBody);
		mRightForeLegFX = new RightForeLeg(mRightUpperLegFX);
		mRightFootFX = new RightFoot(mRightForeLegFX);

		mUpperBodyAndHand = new UpperBodyAndHead(mHeadFX, mUpperBody, mNeckFX);

		mSpeechBubbleFX = new SpeechBubble(mHeadFX);
		init();
		this.addAllParts();
		updateStickmanPosition();
	}

	public Stickman3D(String name, TYPE gender) {
		mName = name;
		mType = gender;

		mHeadFX = new Head(this);
		mMaleHairFX = new MaleHair(this);
		mFemaleHairFX = new FemaleHair(this);
		mLeftEyebrowFX = new LeftEyebrow(mHeadFX);
		mLeftEyeFX = new LeftEye(mHeadFX);
		mRightEyebrowFX = new RightEyebrow(mHeadFX);
		mRightEyeFX = new RightEye(mHeadFX);
		mNoseFX = new Nose(mHeadFX);
		mMouthFX = new Mouth(mHeadFX);
		mFaceWrinkleFX = new FaceWrinkle(mHeadFX);
		mNeckFX = new Neck(mHeadFX);
		mUpperBody = new UpperBody(mNeckFX);
		mDownBody = new DownBody(mUpperBody);
		mLeftUpperArmFX = new LeftUpperArm(mUpperBody);
		mLeftForeArmFX = new LeftForeArm(mLeftUpperArmFX);
		mLeftWrist = new LeftWrist(mLeftForeArmFX);
		mLeftFinger1 = new LeftFinger1(mLeftWrist);
		mLeftFinger2 = new LeftFinger2(mLeftWrist);
		mLeftFinger3 = new LeftFinger3(mLeftWrist);
		mLeftFinger4 = new LeftFinger4(mLeftWrist);
		mRightUpperArmFX = new RightUpperArm(mUpperBody);
		mRightForeArmFX = new RightForeArm(mRightUpperArmFX);
		mRightWrist = new RightWrist(mRightForeArmFX);
		mRightFinger1 = new RightFinger1(mRightWrist);
		mRightFinger2 = new RightFinger2(mRightWrist);
		mRightFinger3 = new RightFinger3(mRightWrist);
		mRightFinger4 = new RightFinger4(mRightWrist);
		mLeftUpperLegFX = new LeftUpperLeg(mDownBody);
		mLeftForeLegFX = new LeftForeLeg(mLeftUpperLegFX);
		mLeftFootFX = new LeftFoot(mLeftForeLegFX);
		mStarsFX = new Stars(mUpperBody);
		mRightUpperLegFX = new RightUpperLeg(mDownBody);
		mRightForeLegFX = new RightForeLeg(mRightUpperLegFX);
		mRightFootFX = new RightFoot(mRightForeLegFX);

		mUpperBodyAndHand = new UpperBodyAndHead(mHeadFX, mUpperBody, mNeckFX);

		mSpeechBubbleFX = new SpeechBubble(mHeadFX);
		init();
		this.addAllParts();
		updateStickmanPosition();
	}

	private void init() {
		this.setPrefHeight(mSize.height);
		this.setPrefWidth(mSize.width);
		this.setMinHeight(mSize.height);
		this.setMinWidth(mSize.width);

		InnerShadow is = new InnerShadow();
		is.setOffsetX(4.0f);
		is.setOffsetY(4.0f);

		nameText.setEffect(is);
		nameText.setX(20);
		nameText.setY(100);
		nameText.setText(mName);
		nameText.setFill(Color.YELLOW);
		nameText.setFont(Font.font(null, FontWeight.BOLD, 30));

		if (this.mType == Stickman3D.TYPE.MALE) {
			nameText.setTranslateX(-80);
			nameText.setTranslateY(350);
		} else {
			nameText.setTranslateX(-90);
			nameText.setTranslateY(350);
		}
		nameText.setTranslateZ(-120);

		ConsoleHandler ch = new ConsoleHandler();
		ch.setFormatter(new StickmanLogFormatter());

		mLogger.addHandler(ch);
		mLogger.setUseParentHandlers(false);

		mAnimationSchedulerFX = new AnimationScheduler(this);
		mAnimationSchedulerFX.start();
	}

	public void addListener(AnimationListener al) {
		mAnimationListeners.add(al);
	}

	public void removeListener(AnimationListener al) {
		synchronized (mAnimationListeners) {
			if (mAnimationListeners.contains(al)) {
				mAnimationListeners.remove(al);
			}
		}
	}

	public void notifyListeners(String animationId) {
		synchronized (mAnimationListeners) {
			mAnimationListeners.stream().forEach((al) -> {
				al.update(animationId);
			});
		}
	}

	public String getID() {
		return (new StringBuffer()).append(mName).append(" Animation ").append(mID++).toString();
	}

	public Animation doEventFeedbackAnimation(String name, int duration, WordTimeMarkSequence wts, boolean block) {
		EventAnimation a = AnimationLoader.getInstance().loadEventAnimation(this, name, duration, block);

		a.setParameter(wts);

		try {
			mAnimationLaunchControl.acquire();
			a.start();
		} catch (InterruptedException ex) {
			mLogger.severe(ex.getMessage());
		}

		return a;
	}

	public Animation doAnimation(String name, int duration, boolean block) {
		return doAnimation(name, duration, "", block);
	}
	
	public Animation doAnimation(String name, int frequent, int actionDuration, boolean block) {
        Animation a = AnimationLoader.getInstance().loadAnimation(this, name, frequent, actionDuration, block);
        
        try {
            mAnimationLaunchControl.acquire();
            a.start();
        } catch (InterruptedException ex) {
            mLogger.severe(ex.getMessage());
        }

        return a;
	}
	
	public Animation doAnimation(String name, Object param, boolean block) {
		return doAnimation(name, -1, param, block);
	}

	public Animation doAnimation(String name, boolean block) {
		return doAnimation(name, -1, "", block);
	}

	public Animation doAnimation(String name, int duration, Object param, boolean block) {
		Animation a = AnimationLoader.getInstance().loadAnimation(this, name, duration, block);

		// this is for now only used by the Speech Bubble
		a.setParameter(param);

		try {
			mAnimationLaunchControl.acquire();
			a.start();
		} catch (InterruptedException ex) {
			mLogger.severe(ex.getMessage());
		}

		return a;
	}

	public void playAnimation(Animation a) {
		try {
			mAnimationLaunchControl.acquire();
			a.start();
		} catch (InterruptedException ex) {
			mLogger.severe(ex.getMessage());
		}
	}

	public void updateStickmanPosition() {
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		double StickmanHeight = this.mHeadFX.mHeadMeshView.getBoundsInParent().getHeight() +
								this.mNeckFX.neckMeshView.getBoundsInParent().getHeight() +
								this.mUpperBody.mBodyMeshView.getBoundsInParent().getHeight() +
								this.mDownBody.mBodyMeshView.getBoundsInParent().getHeight() +
								this.mLeftUpperLegFX.mLeftUpperLegMesh.getBoundsInParent().getHeight() +
								this.mLeftForeLegFX.mLeftForeLegMesh.getBoundsInParent().getHeight() +
								this.mLeftFootFX.mLeftFootMeshView.getBoundsInParent().getHeight();
		
		Affine af = new Affine();
		//mGeneralXTranslation = mSize.width / 2 - mHeadFX.mSize.width * mScale;
		mGeneralYTranslation = (float) StickmanHeight;
		
		int shiftFactor = (int) (StickmanHeight - (StickmanHeight * mScale));
		
		int mGeneralYTranslation = (int) ( (dim.getHeight() - StickmanHeight) + shiftFactor + 40);
		
		af.appendTranslation(mGeneralXTranslation, mGeneralYTranslation);
		af.appendScale(mScale, mScale);
		af.appendTranslation(0, leaveSpeed);
		this.getTransforms().clear();
		this.getTransforms().add(af);
		
	}

	private static class StickmanLogFormatter extends Formatter {

		@Override
		public String format(LogRecord record) {
			return ((new StringBuffer()).append(record.getLevel()).append(": ").append(record.getMessage())
					.append("\n")).toString();
		}
	}

	private void addAllParts() {

		this.getChildren().addAll(mNeckFX, mHeadFX, mUpperBody, mDownBody, mRightUpperArmFX, mLeftUpperLegFX,
				mLeftForeLegFX, mLeftFootFX, mRightUpperLegFX, mRightForeLegFX, mRightFootFX, mFaceWrinkleFX, mStarsFX,
				mSpeechBubbleFX, nameText, mUpperBodyAndHand);

	}

	public void hideAllPartsWithout(Pane p) {
		this.getChildren().forEach(child -> {
			if (!child.equals(p)) {
				child.setVisible(false);
			}
		});
	}

	public void showAllParts() {
		this.getChildren().forEach(child -> {
			child.setVisible(true);
		});
	}
}
