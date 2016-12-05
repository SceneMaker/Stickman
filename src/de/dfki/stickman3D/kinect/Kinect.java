package de.dfki.stickman3D.kinect;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.animationlogic.Animation3D;
import edu.ufl.digitalworlds.j4k.J4KSDK;
import edu.ufl.digitalworlds.j4k.Skeleton;

public class Kinect extends Animation3D {

    Stickman3D currentStickman;

    class SkeletonTracker extends J4KSDK {

        @Override
        public void onSkeletonFrameEvent(boolean[] skeletonTracked, float[] positions,
                float[] orientations, byte[] jointStatus) {
            int skeletonId = 0;
            while (!skeletonTracked[skeletonId]) {
                skeletonId++;
            }

            Skeleton skeleton = Skeleton.getSkeleton(skeletonId, skeletonTracked, positions,
                    orientations, jointStatus, this);

            currentStickman.mUpperBody.mYRotation = (int) skeleton.getBodyOrientation();
            currentStickman.mUpperBody.calculate(0);
        }

        @Override
        public void onColorFrameEvent(byte[] colorData) {
        }

        @Override
        public void onDepthFrameEvent(short[] depthFrame, byte[] playerIndex, float[] xyz, float[] uv) {
        }
    }

    public Kinect(Stickman3D currentStickman) {
        this.currentStickman = currentStickman;
        new SkeletonTracker().start(J4KSDK.SKELETON);
    }
}
