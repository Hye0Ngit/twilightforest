// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import java.util.Random;

public class BugModelAnimationHelper
{
    private static final Random rand;
    private static int yawDelay;
    public static int currentYaw;
    private static int desiredYaw;
    public static int yawWriggleDelay;
    public static int currentRotation;
    public static int desiredRotation;
    public static float glowIntensity;
    private static boolean glowing;
    private static int glowDelay;
    
    static void animate() {
        tickYaw();
        tickGlow();
        tickRotation();
    }
    
    private static void tickYaw() {
        if (BugModelAnimationHelper.yawDelay > 0) {
            --BugModelAnimationHelper.yawDelay;
            return;
        }
        if (BugModelAnimationHelper.currentYaw == 0 && BugModelAnimationHelper.desiredYaw == 0) {
            BugModelAnimationHelper.yawDelay = 200 + BugModelAnimationHelper.rand.nextInt(200);
            BugModelAnimationHelper.desiredYaw = BugModelAnimationHelper.rand.nextInt(15) - BugModelAnimationHelper.rand.nextInt(15);
        }
        if (BugModelAnimationHelper.currentYaw < BugModelAnimationHelper.desiredYaw) {
            ++BugModelAnimationHelper.currentYaw;
        }
        else if (BugModelAnimationHelper.currentYaw > BugModelAnimationHelper.desiredYaw) {
            --BugModelAnimationHelper.currentYaw;
        }
        else if (BugModelAnimationHelper.currentYaw == BugModelAnimationHelper.desiredYaw) {
            BugModelAnimationHelper.desiredYaw = 0;
        }
    }
    
    private static void tickGlow() {
        if (BugModelAnimationHelper.glowDelay > 0) {
            --BugModelAnimationHelper.glowDelay;
            return;
        }
        if (BugModelAnimationHelper.glowing && BugModelAnimationHelper.glowIntensity >= 1.0f) {
            BugModelAnimationHelper.glowing = false;
        }
        if (BugModelAnimationHelper.glowing && BugModelAnimationHelper.glowIntensity < 1.0f) {
            BugModelAnimationHelper.glowIntensity += 0.05f;
        }
        if (!BugModelAnimationHelper.glowing && BugModelAnimationHelper.glowIntensity > 0.0f) {
            BugModelAnimationHelper.glowIntensity -= 0.05f;
        }
        if (!BugModelAnimationHelper.glowing && BugModelAnimationHelper.glowIntensity <= 0.0f) {
            BugModelAnimationHelper.glowing = true;
            BugModelAnimationHelper.glowDelay = BugModelAnimationHelper.rand.nextInt(50);
        }
    }
    
    private static void tickRotation() {
        if (BugModelAnimationHelper.yawWriggleDelay > 0) {
            --BugModelAnimationHelper.yawWriggleDelay;
            return;
        }
        if (BugModelAnimationHelper.currentRotation == -1) {
            BugModelAnimationHelper.currentRotation = BugModelAnimationHelper.rand.nextInt(4) * 90;
        }
        if (BugModelAnimationHelper.desiredRotation == 0) {
            BugModelAnimationHelper.yawWriggleDelay = 200 + BugModelAnimationHelper.rand.nextInt(200);
            BugModelAnimationHelper.desiredRotation = BugModelAnimationHelper.rand.nextInt(4) * 90;
        }
        ++BugModelAnimationHelper.currentRotation;
        if (BugModelAnimationHelper.currentRotation > 360) {
            BugModelAnimationHelper.currentRotation = 0;
        }
        if (BugModelAnimationHelper.currentRotation == BugModelAnimationHelper.desiredRotation) {
            BugModelAnimationHelper.desiredRotation = 0;
        }
    }
    
    static {
        rand = new Random();
        BugModelAnimationHelper.currentRotation = -1;
    }
}
