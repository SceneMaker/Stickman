package de.dfki.stickman3D.body;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.util.XMLParser;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.ClosePath;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class LeftEye extends BodyPart {

	public static enum SHAPE {
		DEFAULT, FADEIN, FADEOUT, BLINK, BLINKEND, LOOKLEFT, LOOKLEFTEND, LOOKRIGHT, LOOKRIGHTEND, LOOKDOWN, LOOKDOWNEND, LOOKUP, LOOKUPEND, ANGRY, ANGRYEND, SURPRISED, SURPRISEDEND, HAPPY, HAPPYEND, DISGUSTED, DISGUSTEDEND, LOVED, LOVEDEND, LOVED1, CONTEMPT, CONTEMPTEND, EXCITED, EXCITEDEND, EMBARRASSED, EMBARRASSEDEND
	};

	Head mHeadFX;
	Group leftEyeGroup;

	Path border;
	Path bigPupile;
	Path smallPupile;

	double borderXSize = 0;
	double borderYSize = 0;
	double bigPupileYSize = 0;
	double smallPupileYSize = 0;

	QuadCurveTo quadCurve_1;
	QuadCurveTo quadCurve_2;

	Color smallPupileColor;
	Color borderColor;

	public LeftEye.SHAPE mShape = LeftEye.SHAPE.DEFAULT;

	public LeftEye(Head head) {
		mHeadFX = head;

		if (mHeadFX.mStickmanFX.mType == Stickman3D.TYPE.MALE)
			mColor = Color.rgb(0, 0, 0, 1);
		else
			mColor = Color.rgb(0, 0, 255, 1);
		activateConfigColor();

		smallPupileColor = Color.rgb(255, 255, 255, 1);
		borderColor = Color.rgb(255, 255, 255, 1);

		mStart = mHeadFX.getLeftEyePostion();

		border = new Path();
		bigPupile = new Path();
		smallPupile = new Path();

		leftEyeGroup = new Group();
		leftEyeGroup.getChildren().add(border);
		leftEyeGroup.getChildren().add(bigPupile);
		leftEyeGroup.getChildren().add(smallPupile);
		mHeadFX.mHead.getChildren().add(leftEyeGroup);

		init();
	}

	private void activateConfigColor() {
		String stickmanName = mHeadFX.mStickmanFX.mName;

		if (XMLParser.getColorMap(stickmanName) != null) {
			if (XMLParser.getColorMap(stickmanName).containsKey("EyeColor"))
				this.mColor = XMLParser.getColorMap(stickmanName).get("EyeColor");
		}
	}

	@Override
	public void init() {
		super.init();
		bigPupile.setTranslateX(mStart.x + 13);
		bigPupile.setTranslateY(mStart.y);
		smallPupile.setTranslateX(mStart.x + 11);
		smallPupile.setTranslateY(mStart.y);
		border.setTranslateZ(-17);
		bigPupile.setTranslateZ(-18);
		smallPupile.setTranslateZ(-19);
	}

	@Override
	public void setShape(String s) {
		SHAPE shape = SHAPE.valueOf(s);
		mShape = (shape != null) ? shape : SHAPE.DEFAULT;
	}

	@Override
	public void resetShape() {
		mShape = LeftEye.SHAPE.DEFAULT;
	}

	private void createDefaultEye() {
		border = createBorder();
		bigPupile = createBigPupile(0, 0, 3.5, 3.5, 0, mColor, null);
		smallPupile = createSmallPupile(0, 0, 1.4, 1.4, 0, smallPupileColor, null);
		smallPupile.setStroke(null);

		borderYSize = 0;
		borderXSize = 0;
		bigPupileYSize = 0;
		smallPupileYSize = 0;
	}

	@Override
	public void calculate(int step) {

		float xMovement = 0;
		float yMovement = 0;

		switch (mShape) {
		case DEFAULT:
			if (step == 20 || step == 0) {
				createDefaultEye();
			}
			break;

		case FADEIN:
			if (step == 2) {
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), 0.0);
				smallPupileColor = new Color(smallPupileColor.getRed(), smallPupileColor.getGreen(),
						smallPupileColor.getBlue(), 0.0);
				borderColor = new Color(borderColor.getRed(), borderColor.getGreen(), borderColor.getBlue(), 0.0);
			} else if (mColor.getOpacity() != 0.0) {
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), mColor.getOpacity() - 0.052);
				smallPupileColor = new Color(smallPupileColor.getRed(), smallPupileColor.getGreen(),
						smallPupileColor.getBlue(), smallPupileColor.getOpacity() - 0.052);
				borderColor = new Color(borderColor.getRed(), borderColor.getGreen(), borderColor.getBlue(),
						borderColor.getOpacity() - 0.052);
			}
			border.setFill(borderColor);
			bigPupile.setFill(mColor);
			smallPupile.setFill(smallPupileColor);
			border.setStroke(borderColor);
			bigPupile.setStroke(mColor);
			break;

		case FADEOUT:
			if (step == 2) {
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), 1.0);
				smallPupileColor = new Color(smallPupileColor.getRed(), smallPupileColor.getGreen(),
						smallPupileColor.getBlue(), 1.0);
				borderColor = new Color(borderColor.getRed(), borderColor.getGreen(), borderColor.getBlue(), 1.0);
			} else if (mColor.getOpacity() != 1.0) {
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), mColor.getOpacity() + 0.052);
				smallPupileColor = new Color(smallPupileColor.getRed(), smallPupileColor.getGreen(),
						smallPupileColor.getBlue(), smallPupileColor.getOpacity() + 0.052);
				borderColor = new Color(borderColor.getRed(), borderColor.getGreen(), borderColor.getBlue(),
						borderColor.getOpacity() + 0.052);
			}
			border.setFill(borderColor);
			bigPupile.setFill(mColor);
			smallPupile.setFill(smallPupileColor);
			border.setStroke(Color.BLACK);
			bigPupile.setStroke(mColor);
			break;
		case BLINK:
			borderYSize += 0.0450;
			bigPupileYSize += 0.050;
			smallPupileYSize += 0.050;

			border.setScaleY(1 - borderYSize);
			bigPupile.setScaleY(1 - bigPupileYSize);
			smallPupile.setScaleY(1 - smallPupileYSize);
			break;
		case BLINKEND:
			borderYSize -= 0.0450;
			bigPupileYSize -= 0.050;
			smallPupileYSize -= 0.050;

			if (step == 2) {
				createDefaultEye();
			} else {
				border.setScaleY(1 - borderYSize);
				bigPupile.setScaleY(1 - bigPupileYSize);
				smallPupile.setScaleY(1 - smallPupileYSize);
			}
			break;
		case LOOKLEFT:
			xMovement = 0.131f;
			yMovement = 0.184f;

			bigPupile.setTranslateX(bigPupile.getTranslateX() + xMovement);
			smallPupile.setTranslateX(smallPupile.getTranslateX() + yMovement);
			break;

		case LOOKLEFTEND:
			xMovement = -0.131f;
			yMovement = -0.182f;

			if (step == 2) {
				createDefaultEye();
			} else {
				bigPupile.setTranslateX(bigPupile.getTranslateX() + xMovement);
				smallPupile.setTranslateX(smallPupile.getTranslateX() + yMovement);
			}
			break;

		case LOOKRIGHT:
			xMovement = 0.131f;
			yMovement = 0.184f;

			bigPupile.setTranslateX(bigPupile.getTranslateX() - xMovement);
			smallPupile.setTranslateX(smallPupile.getTranslateX() - yMovement);
			break;

		case LOOKRIGHTEND:
			xMovement = -0.131f;
			yMovement = -0.184f;

			if (step == 2) {
				createDefaultEye();
			} else {
				bigPupile.setTranslateX(bigPupile.getTranslateX() - xMovement);
				smallPupile.setTranslateX(smallPupile.getTranslateX() - yMovement);
			}
			break;

		case LOOKDOWN:
			xMovement = 0.100f;
			yMovement = 0.184f;

			bigPupile.setTranslateY(bigPupile.getTranslateY() + xMovement);
			smallPupile.setTranslateY(smallPupile.getTranslateY() + yMovement);
			break;

		case LOOKDOWNEND:
			xMovement = -0.100f;
			yMovement = -0.184f;

			if (step == 2) {
				createDefaultEye();
			} else {
				bigPupile.setTranslateY(bigPupile.getTranslateY() + xMovement);
				smallPupile.setTranslateY(smallPupile.getTranslateY() + yMovement);
			}
			break;

		case LOOKUP:
			xMovement = -0.100f;
			yMovement = -0.184f;

			bigPupile.setTranslateY(bigPupile.getTranslateY() + xMovement);
			smallPupile.setTranslateY(smallPupile.getTranslateY() + yMovement);
			break;

		case LOOKUPEND:
			xMovement = 0.100f;
			yMovement = 0.184f;

			if (step == 2) {
				createDefaultEye();
			} else {
				bigPupile.setTranslateY(bigPupile.getTranslateY() + xMovement);
				smallPupile.setTranslateY(smallPupile.getTranslateY() + yMovement);
			}
			break;
		case ANGRY:
			borderYSize += 0.0210;
			bigPupileYSize += 0.010;

			border.setScaleY(1 - borderYSize);
			bigPupile.setScaleY(1 - bigPupileYSize);
			break;

		case ANGRYEND:
			borderYSize -= 0.0210f;
			bigPupileYSize -= 0.010;

			if (step == 2) {
				createDefaultEye();
			} else {
				border.setScaleY(1 - borderYSize);
				bigPupile.setScaleY(1 - bigPupileYSize);
			}
			break;

		case SURPRISED:
			borderYSize -= 0.0158;
			border.setScaleY(1 - borderYSize);
			break;

		case SURPRISEDEND:
			borderYSize += 0.0158;

			if (step == 2) {
				createDefaultEye();
			} else {
				border.setScaleY(1 - borderYSize);
			}
			break;

		case HAPPY:
			borderYSize += 0.0105;
			borderXSize += 0.0052;
			border.setScaleY(1 - borderYSize);
			border.setScaleX(1 + borderXSize);
			break;

		case HAPPYEND:
			borderYSize -= 0.0105;
			borderXSize -= 0.0052;

			if (step == 2) {
				createDefaultEye();
			} else {
				border.setScaleY(1 - borderYSize);
				border.setScaleX(1 + borderXSize);
			}
			break;

		case DISGUSTED:
			borderYSize += 0.0105;

			quadCurve_1 = (QuadCurveTo) border.getElements().get(1);
			quadCurve_1.setY(quadCurve_1.getY() + 0.105);
			border.getElements().set(1, quadCurve_1);

			border.setScaleY(1 - borderYSize);
			break;

		case DISGUSTEDEND:
			borderYSize -= 0.0105;

			if (step == 2) {
				createDefaultEye();
			} else {
				quadCurve_1 = (QuadCurveTo) border.getElements().get(1);
				quadCurve_1.setY(quadCurve_1.getY() - 0.105);
				border.getElements().set(1, quadCurve_1);

				border.setScaleY(1 - borderYSize);
			}
			break;

		case CONTEMPT:
			// NOTE: marjvena tvalze araferi ar gaaketo datove carieli
			borderYSize += 0.0105;
			borderXSize += 0.0052;
			border.setScaleY(1 - borderYSize);
			border.setScaleX(1 + borderXSize);
			break;

		case CONTEMPTEND:
			borderYSize -= 0.0105;
			borderXSize -= 0.0052;

			if (step == 2) {
				createDefaultEye();
			} else {
				border.setScaleY(1 - borderYSize);
				border.setScaleX(1 + borderXSize);
			}
			break;

		case EXCITED:
			borderYSize -= 0.0105;
			borderXSize -= 0.0052;
			border.setScaleY(1 - borderYSize);
			border.setScaleX(1 + borderXSize);
			break;

		case EXCITEDEND:
			borderYSize += 0.0105;
			borderXSize += 0.0052;

			if (step == 2) {
				createDefaultEye();
			} else {
				border.setScaleY(1 - borderYSize);
				border.setScaleX(1 + borderXSize);
			}
			break;

		case EMBARRASSED:
			xMovement = 0.100f;
			yMovement = 0.184f;

			bigPupile.setTranslateY(bigPupile.getTranslateY() + xMovement); // LOOKDOWN
			smallPupile.setTranslateY(smallPupile.getTranslateY() + yMovement);
			break;

		case EMBARRASSEDEND:
			xMovement = -0.100f;
			yMovement = -0.184f;

			if (step == 2) {
				createDefaultEye();
			} else {
				bigPupile.setTranslateY(bigPupile.getTranslateY() + xMovement);
				smallPupile.setTranslateY(smallPupile.getTranslateY() + yMovement);
			}
			break;

		}
	}

	@Override
	public void update() {
		bigPupile.setFill(mColor);
	}

	@Override
	protected void recordColor() {
		if (mHeadFX.mStickmanFX.setCharacterInvisible == false)
			mColorRecorder = mColor;
	}

	private Path createBigPupile(double centerX, double centerY, double radiusX, double radiusY, double rotate,
			Color eyeColor, Color borderColor) {
		ArcTo arcTo = new ArcTo();
		arcTo.setX(centerX - radiusX + 1); // to simulate a full 360 degree
											// celcius circle.
		arcTo.setY(centerY - radiusY);
		arcTo.setSweepFlag(false);
		arcTo.setLargeArcFlag(true);
		arcTo.setRadiusX(radiusX);
		arcTo.setRadiusY(radiusY);
		arcTo.setXAxisRotation(rotate);

		Path bigPupile = new Path();
		bigPupile.getElements().add(new MoveTo(centerX - radiusX, centerY - radiusY));
		bigPupile.getElements().add(arcTo);
		bigPupile.getElements().add(new ClosePath());

		if (borderColor != null) {
			bigPupile.setStroke(Color.BLACK);
			bigPupile.setStrokeWidth(1);
		}

		bigPupile.setFill(eyeColor);

		bigPupile.setTranslateX(mStart.x + 13);
		bigPupile.setTranslateY(mStart.y);
		bigPupile.setTranslateZ(-18);

		leftEyeGroup.getChildren().set(1, bigPupile);
		return bigPupile;
	}

	private Path createSmallPupile(double centerX, double centerY, double radiusX, double radiusY, double rotate,
			Color eyeColor, Color borderColor) {
		ArcTo arcTo = new ArcTo();
		arcTo.setX(centerX - radiusX + 1); // to simulate a full 360 degree
											// celcius circle.
		arcTo.setY(centerY - radiusY);
		arcTo.setSweepFlag(false);
		arcTo.setLargeArcFlag(true);
		arcTo.setRadiusX(radiusX);
		arcTo.setRadiusY(radiusY);
		arcTo.setXAxisRotation(rotate);

		Path smallPupile = new Path();
		smallPupile.getElements().add(new MoveTo(centerX - radiusX, centerY - radiusY));
		smallPupile.getElements().add(arcTo);
		smallPupile.getElements().add(new ClosePath());

		if (borderColor != null) {
			smallPupile.setStroke(Color.BLACK);
			smallPupile.setStrokeWidth(1);
		}

		smallPupile.setFill(eyeColor);
		smallPupile.setTranslateX(mStart.x + 11);
		smallPupile.setTranslateY(mStart.y);
		smallPupile.setTranslateZ(-19);
		leftEyeGroup.getChildren().set(2, smallPupile);

		return smallPupile;
	}

	private Path createBorder() {
		Path startBorder = new Path();
		startBorder.getElements().clear();
		startBorder.getElements().add(new MoveTo(mStart.x, mStart.y));
		startBorder.getElements().add(new QuadCurveTo(mStart.x + 10, mStart.y - 13, mStart.x + 20, mStart.y));
		startBorder.getElements().add(new QuadCurveTo(mStart.x + 10, mStart.y + 13, mStart.x, mStart.y));
		startBorder.setStrokeWidth(1);
		startBorder.setStroke(Color.BLACK);
		startBorder.setFill(borderColor);
		startBorder.setTranslateZ(-17);

		leftEyeGroup.getChildren().set(0, startBorder);

		return startBorder;
	}

}
