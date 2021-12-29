// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.Iterator;
import java.util.List;

public class HydraHeadContainer
{
    private static int FLAME_BURN_FACTOR;
    private static int FLAME_DAMAGE;
    private static int BITE_DAMAGE;
    private static double FLAME_BREATH_TRACKING_SPEED;
    private static boolean FLAME_BREATH_BREAKS_BLOCKS;
    public static final int NEXT_AUTOMATIC = -1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_BITE_BEGINNING = 1;
    public static final int STATE_BITE_READY = 2;
    public static final int STATE_BITE_BITING = 3;
    public static final int STATE_BITE_ENDING = 4;
    public static final int STATE_FLAME_BEGINNING = 5;
    public static final int STATE_FLAME_BREATHING = 6;
    public static final int STATE_FLAME_ENDING = 7;
    public static final int STATE_MORTAR_BEGINNING = 8;
    public static final int STATE_MORTAR_LAUNCH = 9;
    public static final int STATE_MORTAR_ENDING = 10;
    public static final int STATE_DYING = 11;
    public static final int STATE_DEAD = 12;
    public static final int STATE_ATTACK_COOLDOWN = 13;
    public static final int STATE_BORN = 14;
    public static final int STATE_ROAR_START = 15;
    public static final int STATE_ROAR_RAWR = 16;
    public static final int NUM_STATES = 17;
    public EntityTFHydraHead headEntity;
    public EntityTFHydraNeck necka;
    public EntityTFHydraNeck neckb;
    public EntityTFHydraNeck neckc;
    public EntityTFHydraNeck neckd;
    public EntityTFHydraNeck necke;
    public lq targetEntity;
    public double targetX;
    public double targetY;
    public double targetZ;
    public int prevState;
    public int currentState;
    public int nextState;
    public boolean didRoar;
    public boolean isSecondaryAttacking;
    public int ticksNeeded;
    public int ticksProgress;
    public final int headNum;
    public int damageTaken;
    public int respawnCounter;
    public final EntityTFHydra hydraObj;
    public int[] nextStates;
    public int[] stateDurations;
    public float[][] stateNeckLength;
    public float[][] stateXRotations;
    public float[][] stateYRotations;
    public float[][] stateMouthOpen;
    
    public HydraHeadContainer(final EntityTFHydra hydra, final int number, final boolean startActive) {
        this.nextState = -1;
        this.headNum = number;
        this.hydraObj = hydra;
        this.damageTaken = 0;
        this.respawnCounter = -1;
        this.didRoar = false;
        this.necka = new EntityTFHydraNeck(this.hydraObj, "neck" + this.headNum + "a", 2.0f, 2.0f);
        this.neckb = new EntityTFHydraNeck(this.hydraObj, "neck" + this.headNum + "b", 2.0f, 2.0f);
        this.neckc = new EntityTFHydraNeck(this.hydraObj, "neck" + this.headNum + "c", 2.0f, 2.0f);
        this.neckd = new EntityTFHydraNeck(this.hydraObj, "neck" + this.headNum + "d", 2.0f, 2.0f);
        this.necke = new EntityTFHydraNeck(this.hydraObj, "neck" + this.headNum + "e", 2.0f, 2.0f);
        (this.nextStates = new int[17])[0] = 0;
        this.nextStates[1] = 2;
        this.nextStates[2] = 3;
        this.nextStates[3] = 4;
        this.nextStates[4] = 13;
        this.nextStates[5] = 6;
        this.nextStates[6] = 7;
        this.nextStates[7] = 13;
        this.nextStates[8] = 9;
        this.nextStates[9] = 10;
        this.nextStates[10] = 13;
        this.nextStates[13] = 0;
        this.nextStates[11] = 12;
        this.nextStates[12] = 12;
        this.nextStates[14] = 15;
        this.nextStates[15] = 16;
        this.nextStates[16] = 0;
        this.stateDurations = new int[17];
        this.setupStateDurations();
        this.stateNeckLength = new float[this.hydraObj.numHeads][17];
        this.stateXRotations = new float[this.hydraObj.numHeads][17];
        this.stateYRotations = new float[this.hydraObj.numHeads][17];
        this.stateMouthOpen = new float[this.hydraObj.numHeads][17];
        this.setupStateRotations();
        if (startActive) {
            this.prevState = 0;
            this.currentState = 0;
            this.nextState = -1;
            this.ticksNeeded = 60;
            this.ticksProgress = 60;
        }
        else {
            this.prevState = 12;
            this.currentState = 12;
            this.nextState = -1;
            this.ticksNeeded = 20;
            this.ticksProgress = 20;
        }
    }
    
    protected void setupStateDurations() {
        this.stateDurations[0] = 10;
        this.stateDurations[1] = 40;
        this.stateDurations[2] = 80;
        this.stateDurations[3] = 7;
        this.stateDurations[4] = 40;
        this.stateDurations[5] = 40;
        this.stateDurations[6] = 100;
        this.stateDurations[7] = 30;
        this.stateDurations[8] = 40;
        this.stateDurations[9] = 25;
        this.stateDurations[10] = 30;
        this.stateDurations[13] = 80;
        this.stateDurations[11] = 70;
        this.stateDurations[12] = 20;
        this.stateDurations[14] = 20;
        this.stateDurations[15] = 10;
        this.stateDurations[16] = 50;
    }
    
    protected void setupStateRotations() {
        this.setAnimation(0, 0, 60.0f, 0.0f, 7.0f, 0.0f);
        this.setAnimation(1, 0, 10.0f, 60.0f, 9.0f, 0.0f);
        this.setAnimation(2, 0, 10.0f, -60.0f, 9.0f, 0.0f);
        this.setAnimation(3, 0, 50.0f, 90.0f, 8.0f, 0.0f);
        this.setAnimation(4, 0, 50.0f, -90.0f, 8.0f, 0.0f);
        this.setAnimation(5, 0, -10.0f, 90.0f, 9.0f, 0.0f);
        this.setAnimation(6, 0, -10.0f, -90.0f, 9.0f, 0.0f);
        this.setAnimation(0, 13, 60.0f, 0.0f, 7.0f, 0.0f);
        this.setAnimation(1, 13, 10.0f, 60.0f, 9.0f, 0.0f);
        this.setAnimation(2, 13, 10.0f, -60.0f, 9.0f, 0.0f);
        this.setAnimation(3, 13, 50.0f, 90.0f, 8.0f, 0.0f);
        this.setAnimation(4, 13, 50.0f, -90.0f, 8.0f, 0.0f);
        this.setAnimation(5, 13, -10.0f, 90.0f, 9.0f, 0.0f);
        this.setAnimation(6, 13, -10.0f, -90.0f, 9.0f, 0.0f);
        this.setAnimation(0, 5, 50.0f, 0.0f, 8.0f, 0.75f);
        this.setAnimation(1, 5, 30.0f, 45.0f, 9.0f, 0.75f);
        this.setAnimation(2, 5, 30.0f, -45.0f, 9.0f, 0.75f);
        this.setAnimation(3, 5, 50.0f, 90.0f, 8.0f, 0.75f);
        this.setAnimation(4, 5, 50.0f, -90.0f, 8.0f, 0.75f);
        this.setAnimation(5, 5, -10.0f, 90.0f, 9.0f, 0.75f);
        this.setAnimation(6, 5, -10.0f, -90.0f, 9.0f, 0.75f);
        this.setAnimation(0, 6, 45.0f, 0.0f, 8.0f, 1.0f);
        this.setAnimation(1, 6, 30.0f, 60.0f, 9.0f, 1.0f);
        this.setAnimation(2, 6, 30.0f, -60.0f, 9.0f, 1.0f);
        this.setAnimation(3, 6, 50.0f, 90.0f, 8.0f, 1.0f);
        this.setAnimation(4, 6, 50.0f, -90.0f, 8.0f, 1.0f);
        this.setAnimation(5, 6, -10.0f, 90.0f, 9.0f, 1.0f);
        this.setAnimation(6, 6, -10.0f, -90.0f, 9.0f, 1.0f);
        this.setAnimation(0, 7, 60.0f, 0.0f, 7.0f, 0.0f);
        this.setAnimation(1, 7, 10.0f, 45.0f, 9.0f, 0.0f);
        this.setAnimation(2, 7, 10.0f, -45.0f, 9.0f, 0.0f);
        this.setAnimation(3, 7, 50.0f, 90.0f, 8.0f, 0.0f);
        this.setAnimation(4, 7, 50.0f, -90.0f, 8.0f, 0.0f);
        this.setAnimation(5, 7, -10.0f, 90.0f, 9.0f, 0.0f);
        this.setAnimation(6, 7, -10.0f, -90.0f, 9.0f, 0.0f);
        this.setAnimation(0, 1, -5.0f, 60.0f, 5.0f, 0.25f);
        this.setAnimation(1, 1, -10.0f, 60.0f, 9.0f, 0.25f);
        this.setAnimation(2, 1, -10.0f, -60.0f, 9.0f, 0.25f);
        this.setAnimation(0, 2, -5.0f, 60.0f, 5.0f, 1.0f);
        this.setAnimation(1, 2, -10.0f, 60.0f, 9.0f, 1.0f);
        this.setAnimation(2, 2, -10.0f, -60.0f, 9.0f, 1.0f);
        this.setAnimation(0, 3, -5.0f, -30.0f, 5.0f, 0.2f);
        this.setAnimation(1, 3, -10.0f, -30.0f, 5.0f, 0.2f);
        this.setAnimation(2, 3, -10.0f, 30.0f, 5.0f, 0.2f);
        this.setAnimation(0, 4, 60.0f, 0.0f, 7.0f, 0.0f);
        this.setAnimation(1, 4, -10.0f, 60.0f, 9.0f, 0.0f);
        this.setAnimation(2, 4, -10.0f, -60.0f, 9.0f, 0.0f);
        this.setAnimation(0, 8, 50.0f, 0.0f, 8.0f, 0.75f);
        this.setAnimation(1, 8, 30.0f, 45.0f, 9.0f, 0.75f);
        this.setAnimation(2, 8, 30.0f, -45.0f, 9.0f, 0.75f);
        this.setAnimation(3, 8, 50.0f, 90.0f, 8.0f, 0.75f);
        this.setAnimation(4, 8, 50.0f, -90.0f, 8.0f, 0.75f);
        this.setAnimation(5, 8, -10.0f, 90.0f, 9.0f, 0.75f);
        this.setAnimation(6, 8, -10.0f, -90.0f, 9.0f, 0.75f);
        this.setAnimation(0, 9, 45.0f, 0.0f, 8.0f, 1.0f);
        this.setAnimation(1, 9, 30.0f, 60.0f, 9.0f, 1.0f);
        this.setAnimation(2, 9, 30.0f, -60.0f, 9.0f, 1.0f);
        this.setAnimation(3, 9, 50.0f, 90.0f, 8.0f, 1.0f);
        this.setAnimation(4, 9, 50.0f, -90.0f, 8.0f, 1.0f);
        this.setAnimation(5, 9, -10.0f, 90.0f, 9.0f, 1.0f);
        this.setAnimation(6, 9, -10.0f, -90.0f, 9.0f, 1.0f);
        this.setAnimation(0, 10, 60.0f, 0.0f, 7.0f, 0.0f);
        this.setAnimation(1, 10, 10.0f, 45.0f, 9.0f, 0.0f);
        this.setAnimation(2, 10, 10.0f, -45.0f, 9.0f, 0.0f);
        this.setAnimation(3, 10, 50.0f, 90.0f, 8.0f, 0.0f);
        this.setAnimation(4, 10, 50.0f, -90.0f, 8.0f, 0.0f);
        this.setAnimation(5, 10, -10.0f, 90.0f, 9.0f, 0.0f);
        this.setAnimation(6, 10, -10.0f, -90.0f, 9.0f, 0.0f);
        this.setAnimation(0, 11, -20.0f, 0.0f, 7.0f, 0.0f);
        this.setAnimation(1, 11, -20.0f, 60.0f, 9.0f, 0.0f);
        this.setAnimation(2, 11, -20.0f, -60.0f, 9.0f, 0.0f);
        this.setAnimation(3, 11, -20.0f, 90.0f, 8.0f, 0.0f);
        this.setAnimation(4, 11, -20.0f, -90.0f, 8.0f, 0.0f);
        this.setAnimation(5, 11, -10.0f, 90.0f, 9.0f, 0.0f);
        this.setAnimation(6, 11, -10.0f, -90.0f, 9.0f, 0.0f);
        this.setAnimation(0, 12, 0.0f, 179.0f, 4.0f, 0.0f);
        this.setAnimation(1, 12, 0.0f, 179.0f, 4.0f, 0.0f);
        this.setAnimation(2, 12, 0.0f, -180.0f, 4.0f, 0.0f);
        this.setAnimation(3, 12, 0.0f, 179.0f, 4.0f, 0.0f);
        this.setAnimation(4, 12, 0.0f, -180.0f, 4.0f, 0.0f);
        this.setAnimation(5, 12, 0.0f, 179.0f, 4.0f, 0.0f);
        this.setAnimation(6, 12, 0.0f, -180.0f, 4.0f, 0.0f);
        this.setAnimation(0, 14, 60.0f, 0.0f, 7.0f, 0.0f);
        this.setAnimation(1, 14, 10.0f, 60.0f, 9.0f, 0.0f);
        this.setAnimation(2, 14, 10.0f, -60.0f, 9.0f, 0.0f);
        this.setAnimation(3, 14, 50.0f, 90.0f, 8.0f, 0.0f);
        this.setAnimation(4, 14, 50.0f, -90.0f, 8.0f, 0.0f);
        this.setAnimation(5, 14, -10.0f, 90.0f, 9.0f, 0.0f);
        this.setAnimation(6, 14, -10.0f, -90.0f, 9.0f, 0.0f);
        this.setAnimation(0, 15, 60.0f, 0.0f, 7.0f, 0.25f);
        this.setAnimation(1, 15, 10.0f, 60.0f, 9.0f, 0.25f);
        this.setAnimation(2, 15, 10.0f, -60.0f, 9.0f, 0.25f);
        this.setAnimation(3, 15, 50.0f, 90.0f, 8.0f, 0.25f);
        this.setAnimation(4, 15, 50.0f, -90.0f, 8.0f, 0.25f);
        this.setAnimation(5, 15, -10.0f, 90.0f, 9.0f, 0.25f);
        this.setAnimation(6, 15, -10.0f, -90.0f, 9.0f, 0.25f);
        this.setAnimation(0, 16, 60.0f, 0.0f, 9.0f, 1.0f);
        this.setAnimation(1, 16, 10.0f, 60.0f, 11.0f, 1.0f);
        this.setAnimation(2, 16, 10.0f, -60.0f, 11.0f, 1.0f);
        this.setAnimation(3, 16, 50.0f, 90.0f, 10.0f, 1.0f);
        this.setAnimation(4, 16, 50.0f, -90.0f, 10.0f, 1.0f);
        this.setAnimation(5, 16, -10.0f, 90.0f, 11.0f, 1.0f);
        this.setAnimation(6, 16, -10.0f, -90.0f, 11.0f, 1.0f);
    }
    
    protected void setAnimation(final int head, final int state, final float xRotation, final float yRotation, final float neckLength, final float mouthOpen) {
        this.stateXRotations[head][state] = xRotation;
        this.stateYRotations[head][state] = yRotation;
        this.stateNeckLength[head][state] = neckLength;
        this.stateMouthOpen[head][state] = mouthOpen;
    }
    
    public EntityTFHydraNeck[] getNeckArray() {
        return new EntityTFHydraNeck[] { this.necka, this.neckb, this.neckc, this.neckd, this.necke };
    }
    
    public void onUpdate() {
        this.necka.j_();
        this.neckb.j_();
        this.neckc.j_();
        this.neckd.j_();
        this.necke.j_();
        if (this.headEntity == null) {
            this.headEntity = this.findNearbyHead("head" + this.headNum);
        }
        this.setDifficultyVariables();
        if (this.headEntity != null) {
            final EntityTFHydraHead headEntity = this.headEntity;
            final EntityTFHydraHead headEntity2 = this.headEntity;
            final float n = this.isActive() ? 4.0f : 1.0f;
            headEntity2.O = n;
            headEntity.N = n;
            if (!this.hydraObj.p.J) {
                this.advanceRespawnCounter();
                this.advanceHeadState();
                this.setHeadPosition();
                this.setHeadFacing();
                this.executeAttacks();
            }
            else {
                this.clientAnimateHeadDeath();
            }
            this.setNeckPosition();
            this.addMouthParticles();
            this.playSounds();
        }
    }
    
    protected void advanceRespawnCounter() {
        if (this.currentState == 12 && this.respawnCounter > -1 && --this.respawnCounter <= 0) {
            this.setNextState(14);
            this.damageTaken = 0;
            this.endCurrentAction();
            this.respawnCounter = -1;
        }
    }
    
    protected void clientAnimateHeadDeath() {
        if (this.headEntity.getState() == 11) {
            final EntityTFHydraHead headEntity = this.headEntity;
            ++headEntity.aX;
            if (this.headEntity.aX > 0) {
                if (this.headEntity.aX < 20) {
                    this.doExplosionOn(this.headEntity, true);
                }
                else if (this.headEntity.aX < 30) {
                    this.doExplosionOn(this.necka, false);
                }
                else if (this.headEntity.aX < 40) {
                    this.doExplosionOn(this.neckb, false);
                }
                else if (this.headEntity.aX < 50) {
                    this.doExplosionOn(this.neckc, false);
                }
                else if (this.headEntity.aX < 60) {
                    this.doExplosionOn(this.neckd, false);
                }
                else if (this.headEntity.aX < 70) {
                    this.doExplosionOn(this.necke, false);
                }
            }
            this.necka.aU = 20;
            this.neckb.aU = 20;
            this.neckc.aU = 20;
            this.neckd.aU = 20;
            this.necke.aU = 20;
        }
        else {
            this.headEntity.aX = 0;
            this.headEntity.j(this.headEntity.aT());
        }
    }
    
    private void doExplosionOn(final EntityTFHydraPart part, final boolean large) {
        for (int i = 0; i < 10; ++i) {
            final double var8 = part.aB().nextGaussian() * 0.02;
            final double var9 = part.aB().nextGaussian() * 0.02;
            final double var10 = part.aB().nextGaussian() * 0.02;
            final String particle = (large && part.aB().nextInt(5) == 0) ? "largeexplode" : "explode";
            part.p.a(particle, part.t + part.aB().nextFloat() * part.N * 2.0f - part.N, part.u + part.aB().nextFloat() * part.O, part.v + part.aB().nextFloat() * part.N * 2.0f - part.N, var8, var9, var10);
        }
    }
    
    protected void advanceHeadState() {
        if (++this.ticksProgress >= this.ticksNeeded) {
            int myNext;
            if (this.nextState == -1) {
                myNext = this.nextStates[this.currentState];
                if (myNext != this.currentState && this.isSecondaryAttacking && myNext == 13) {
                    this.isSecondaryAttacking = false;
                    myNext = 0;
                }
            }
            else {
                myNext = this.nextState;
                this.nextState = -1;
            }
            final int n = this.stateDurations[myNext];
            this.ticksProgress = n;
            this.ticksNeeded = n;
            this.ticksProgress = 0;
            this.prevState = this.currentState;
            this.currentState = myNext;
        }
        if (this.headEntity.getState() != this.currentState) {
            this.headEntity.setState(this.currentState);
        }
    }
    
    protected void setHeadFacing() {
        if (this.currentState == 2) {
            this.faceEntity(this.targetEntity, 5.0f, (float)this.hydraObj.bp());
            float biteMaxYaw = -60.0f;
            float biteMinYaw = -90.0f;
            if (this.headNum == 2) {
                biteMaxYaw = 60.0f;
                biteMinYaw = 90.0f;
            }
            final float yawOffOffset = ke.g(this.headEntity.z - this.hydraObj.aw);
            if (yawOffOffset > biteMaxYaw) {
                this.headEntity.z = this.hydraObj.aw + biteMaxYaw;
            }
            if (yawOffOffset < biteMinYaw) {
                this.headEntity.z = this.hydraObj.aw + biteMinYaw;
            }
            final aob look = this.headEntity.Z();
            final double distance = 16.0;
            this.targetX = this.headEntity.t + look.c * distance;
            this.targetY = this.headEntity.u + 1.5 + look.d * distance;
            this.targetZ = this.headEntity.v + look.e * distance;
        }
        else if (this.currentState == 3 || this.currentState == 4) {
            this.faceEntity(this.targetEntity, 5.0f, (float)this.hydraObj.bp());
            final EntityTFHydraHead headEntity = this.headEntity;
            headEntity.A += (float)0.7853981633974483;
        }
        else if (this.currentState == 16) {
            this.faceVec(this.targetX, this.targetY, this.targetZ, 10.0f, (float)this.hydraObj.bp());
        }
        else if (this.currentState == 6 || this.currentState == 5) {
            this.moveTargetCoordsTowardsTargetEntity(HydraHeadContainer.FLAME_BREATH_TRACKING_SPEED);
            this.faceVec(this.targetX, this.targetY, this.targetZ, 5.0f, (float)this.hydraObj.bp());
        }
        else if (this.isActive()) {
            if (this.targetEntity != null) {
                this.faceEntity(this.targetEntity, 5.0f, (float)this.hydraObj.bp());
            }
            else {
                this.faceIdle(1.5f, (float)this.hydraObj.bp());
            }
        }
    }
    
    protected void moveTargetCoordsTowardsTargetEntity(final double distance) {
        if (this.targetEntity != null) {
            final aob vect = this.headEntity.p.S().a(this.targetEntity.t - this.targetX, this.targetEntity.u - this.targetY, this.targetEntity.v - this.targetZ);
            vect.a();
            this.targetX += vect.c * distance;
            this.targetY += vect.d * distance;
            this.targetZ += vect.e * distance;
        }
    }
    
    protected void addMouthParticles() {
        final aob vector = this.headEntity.Z();
        final double dist = 3.5;
        final double px = this.headEntity.t + vector.c * dist;
        final double py = this.headEntity.u + 1.0 + vector.d * dist;
        final double pz = this.headEntity.v + vector.e * dist;
        if (this.headEntity.getState() == 5) {
            this.headEntity.p.a("flame", px + this.headEntity.aB().nextDouble() - 0.5, py + this.headEntity.aB().nextDouble() - 0.5, pz + this.headEntity.aB().nextDouble() - 0.5, 0.0, 0.0, 0.0);
            this.headEntity.p.a("smoke", px + this.headEntity.aB().nextDouble() - 0.5, py + this.headEntity.aB().nextDouble() - 0.5, pz + this.headEntity.aB().nextDouble() - 0.5, 0.0, 0.0, 0.0);
        }
        if (this.headEntity.getState() == 6) {
            final aob look = this.headEntity.Z();
            for (int i = 0; i < 5; ++i) {
                double dx = look.c;
                double dy = look.d;
                double dz = look.e;
                final double spread = 5.0 + this.headEntity.aB().nextDouble() * 2.5;
                final double velocity = 1.0 + this.headEntity.aB().nextDouble();
                dx += this.headEntity.aB().nextGaussian() * 0.007499999832361937 * spread;
                dy += this.headEntity.aB().nextGaussian() * 0.007499999832361937 * spread;
                dz += this.headEntity.aB().nextGaussian() * 0.007499999832361937 * spread;
                dx *= velocity;
                dy *= velocity;
                dz *= velocity;
                TwilightForestMod.proxy.spawnParticle("largeflame", px, py, pz, dx, dy, dz);
            }
        }
        if (this.headEntity.getState() == 1 || this.headEntity.getState() == 2) {
            this.headEntity.p.a("splash", px + this.headEntity.aB().nextDouble() - 0.5, py + this.headEntity.aB().nextDouble() - 0.5, pz + this.headEntity.aB().nextDouble() - 0.5, 0.0, 0.0, 0.0);
        }
        if (this.headEntity.getState() == 8) {
            this.headEntity.p.a("largesmoke", px + this.headEntity.aB().nextDouble() - 0.5, py + this.headEntity.aB().nextDouble() - 0.5, pz + this.headEntity.aB().nextDouble() - 0.5, 0.0, 0.0, 0.0);
        }
    }
    
    protected void playSounds() {
        if (this.headEntity.getState() == 6 && this.headEntity.ab % 5 == 0) {
            this.headEntity.p.a(this.headEntity.t + 0.5, this.headEntity.u + 0.5, this.headEntity.v + 0.5, "mob.ghast.fireball", 0.5f + this.headEntity.aB().nextFloat(), this.headEntity.aB().nextFloat() * 0.7f + 0.3f);
        }
        if (this.headEntity.getState() == 16) {
            this.headEntity.p.a(this.headEntity.t + 0.5, this.headEntity.u + 0.5, this.headEntity.v + 0.5, "mob.tf.hydra.roar", 1.25f, this.headEntity.aB().nextFloat() * 0.3f + 0.7f);
        }
        if (this.headEntity.getState() == 2 && this.ticksProgress == 60) {
            this.headEntity.p.a(this.headEntity.t + 0.5, this.headEntity.u + 0.5, this.headEntity.v + 0.5, "mob.tf.hydra.warn", 2.0f, this.headEntity.aB().nextFloat() * 0.3f + 0.7f);
        }
        if (this.headEntity.getState() == 0) {
            this.didRoar = false;
        }
    }
    
    protected void setNeckPosition() {
        aob vector = null;
        float neckRotation = 0.0f;
        if (this.headNum == 0) {
            vector = this.headEntity.p.S().a(0.0, 3.0, -1.0);
            neckRotation = 0.0f;
        }
        if (this.headNum == 1) {
            vector = this.headEntity.p.S().a(-1.0, 3.0, 3.0);
            neckRotation = 90.0f;
        }
        if (this.headNum == 2) {
            vector = this.headEntity.p.S().a(1.0, 3.0, 3.0);
            neckRotation = -90.0f;
        }
        if (this.headNum == 3) {
            vector = this.headEntity.p.S().a(-1.0, 3.0, 3.0);
            neckRotation = 135.0f;
        }
        if (this.headNum == 4) {
            vector = this.headEntity.p.S().a(1.0, 3.0, 3.0);
            neckRotation = -135.0f;
        }
        if (this.headNum == 5) {
            vector = this.headEntity.p.S().a(-1.0, 3.0, 5.0);
            neckRotation = 135.0f;
        }
        if (this.headNum == 6) {
            vector = this.headEntity.p.S().a(1.0, 3.0, 5.0);
            neckRotation = -135.0f;
        }
        vector.b(-(this.hydraObj.aw + neckRotation) * 3.141593f / 180.0f);
        this.setNeckPositon(this.hydraObj.t + vector.c, this.hydraObj.u + vector.d, this.hydraObj.v + vector.e, this.hydraObj.aw, 0.0f);
    }
    
    protected void setHeadPosition() {
        this.setupStateDurations();
        this.setupStateRotations();
        final float neckLength = this.getCurrentNeckLength();
        final float xRotation = this.getCurrentHeadXRotation();
        final float yRotation = this.getCurrentHeadYRotation();
        final float periodX = (this.headNum == 0 || this.headNum == 3) ? 20.0f : ((this.headNum == 1 || this.headNum == 4) ? 5.0f : 7.0f);
        final float periodY = (this.headNum == 0 || this.headNum == 4) ? 10.0f : ((this.headNum == 1 || this.headNum == 6) ? 6.0f : 5.0f);
        float xSwing = ke.a(this.hydraObj.ab / periodX) * 3.0f;
        float ySwing = ke.a(this.hydraObj.ab / periodY) * 5.0f;
        if (!this.isActive()) {
            ySwing = (xSwing = 0.0f);
        }
        final aob vector = this.headEntity.p.S().a(0.0, 0.0, (double)neckLength);
        vector.a((xRotation * 3.141593f + xSwing) / 180.0f);
        vector.b(-(this.hydraObj.aw + yRotation + ySwing) * 3.141593f / 180.0f);
        final double dx = this.hydraObj.t + vector.c;
        final double dy = this.hydraObj.u + vector.d + 3.0;
        final double dz = this.hydraObj.v + vector.e;
        this.headEntity.b(dx, dy, dz);
        this.headEntity.setMouthOpen(this.getCurrentMouthOpen());
    }
    
    protected void executeAttacks() {
        if (this.currentState == 9 && this.ticksProgress % 10 == 0) {
            final lq lookTarget = this.getHeadLookTarget();
            if (lookTarget != null && (lookTarget instanceof EntityTFHydraPart || lookTarget instanceof pn)) {
                this.endCurrentAction();
            }
            else {
                final EntityTFHydraMortar mortar = new EntityTFHydraMortar(this.headEntity.p, this.headEntity);
                final aob vector = this.headEntity.Z();
                final double dist = 3.5;
                final double px = this.headEntity.t + vector.c * dist;
                final double py = this.headEntity.u + 1.0 + vector.d * dist;
                final double pz = this.headEntity.v + vector.e * dist;
                mortar.b(px, py, pz, 0.0f, 0.0f);
                if (this.targetEntity != null && !this.headEntity.n(this.targetEntity)) {
                    mortar.setToBlasting();
                }
                this.headEntity.p.a((qx)null, 1008, (int)this.headEntity.t, (int)this.headEntity.u, (int)this.headEntity.v, 0);
                this.headEntity.p.d((lq)mortar);
            }
        }
        if (this.headEntity.getState() == 3) {
            final List nearbyList = this.headEntity.p.b((lq)this.headEntity, this.headEntity.D.b(0.0, 1.0, 0.0));
            for (final lq nearby : nearbyList) {
                if (nearby instanceof md && !(nearby instanceof EntityTFHydraPart) && !(nearby instanceof EntityTFHydra) && !(nearby instanceof pn)) {
                    nearby.a(lh.a((md)this.hydraObj), HydraHeadContainer.BITE_DAMAGE);
                }
            }
        }
        if (this.headEntity.getState() == 6) {
            final lq target = this.getHeadLookTarget();
            if (target != null) {
                if (target instanceof EntityTFHydraPart || target instanceof pn) {
                    this.endCurrentAction();
                }
                else if (!target.F() && target.a(lh.a, HydraHeadContainer.FLAME_DAMAGE)) {
                    target.c(HydraHeadContainer.FLAME_BURN_FACTOR);
                }
            }
        }
    }
    
    protected void setDifficultyVariables() {
        if (this.hydraObj.p.t < 3) {
            HydraHeadContainer.FLAME_BREATH_TRACKING_SPEED = 0.04;
            HydraHeadContainer.FLAME_BREATH_BREAKS_BLOCKS = false;
        }
        else {
            HydraHeadContainer.FLAME_BREATH_TRACKING_SPEED = 0.1;
            HydraHeadContainer.FLAME_BREATH_BREAKS_BLOCKS = true;
        }
    }
    
    private lq getHeadLookTarget() {
        lq pointedEntity = null;
        final double range = 30.0;
        final aob srcVec = this.headEntity.p.S().a(this.headEntity.t, this.headEntity.u + 1.0, this.headEntity.v);
        final aob lookVec = this.headEntity.i(1.0f);
        final aob destVec = srcVec.c(lookVec.c * range, lookVec.d * range, lookVec.e * range);
        final float var9 = 3.0f;
        final List possibleList = this.headEntity.p.b((lq)this.headEntity, this.headEntity.D.a(lookVec.c * range, lookVec.d * range, lookVec.e * range).b((double)var9, (double)var9, (double)var9));
        double hitDist = 0.0;
        for (final lq possibleEntity : possibleList) {
            if (possibleEntity.L() && possibleEntity != this.headEntity && possibleEntity != this.necka && possibleEntity != this.neckb && possibleEntity != this.neckc) {
                final float borderSize = possibleEntity.Y();
                final anw collisionBB = possibleEntity.D.b((double)borderSize, (double)borderSize, (double)borderSize);
                final anz interceptPos = collisionBB.a(srcVec, destVec);
                if (collisionBB.a(srcVec)) {
                    if (0.0 >= hitDist && hitDist != 0.0) {
                        continue;
                    }
                    pointedEntity = possibleEntity;
                    hitDist = 0.0;
                }
                else {
                    if (interceptPos == null) {
                        continue;
                    }
                    final double possibleDist = srcVec.d(interceptPos.f);
                    if (possibleDist >= hitDist && hitDist != 0.0) {
                        continue;
                    }
                    pointedEntity = possibleEntity;
                    hitDist = possibleDist;
                }
            }
        }
        return pointedEntity;
    }
    
    private float calcMortarVelocity() {
        final float dist = this.headEntity.d(this.targetEntity);
        return (dist > 20.0f) ? 1.0f : 0.75f;
    }
    
    public void setNextState(final int next) {
        this.nextState = next;
    }
    
    public void endCurrentAction() {
        this.ticksProgress = this.ticksNeeded;
    }
    
    private EntityTFHydraHead findNearbyHead(final String string) {
        final List nearbyHeads = this.hydraObj.p.a((Class)EntityTFHydraHead.class, anw.a().a(this.hydraObj.t, this.hydraObj.u, this.hydraObj.v, this.hydraObj.t + 1.0, this.hydraObj.u + 1.0, this.hydraObj.v + 1.0).b(16.0, 16.0, 16.0));
        for (final EntityTFHydraHead nearbyHead : nearbyHeads) {
            if (nearbyHead.getPartName().equals(string)) {
                nearbyHead.hydraObj = this.hydraObj;
                return nearbyHead;
            }
        }
        return null;
    }
    
    protected float getCurrentNeckLength() {
        final float prevLength = this.stateNeckLength[this.headNum][this.prevState];
        final float curLength = this.stateNeckLength[this.headNum][this.currentState];
        final float progress = this.ticksProgress / (float)this.ticksNeeded;
        return prevLength + (curLength - prevLength) * progress;
    }
    
    protected float getCurrentHeadXRotation() {
        final float prevRotation = this.stateXRotations[this.headNum][this.prevState];
        final float currentRotation = this.stateXRotations[this.headNum][this.currentState];
        final float progress = this.ticksProgress / (float)this.ticksNeeded;
        return prevRotation + (currentRotation - prevRotation) * progress;
    }
    
    protected float getCurrentHeadYRotation() {
        final float prevRotation = this.stateYRotations[this.headNum][this.prevState];
        final float currentRotation = this.stateYRotations[this.headNum][this.currentState];
        final float progress = this.ticksProgress / (float)this.ticksNeeded;
        return prevRotation + (currentRotation - prevRotation) * progress;
    }
    
    protected float getCurrentMouthOpen() {
        final float prevOpen = this.stateMouthOpen[this.headNum][this.prevState];
        final float curOpen = this.stateMouthOpen[this.headNum][this.currentState];
        final float progress = this.ticksProgress / (float)this.ticksNeeded;
        return prevOpen + (curOpen - prevOpen) * progress;
    }
    
    protected void setNeckPositon(final double startX, final double startY, final double startZ, final float startYaw, final float startPitch) {
        double endX = this.headEntity.t;
        double endY = this.headEntity.u;
        double endZ = this.headEntity.v;
        float endYaw = this.headEntity.z;
        float endPitch = this.headEntity.A;
        while (startYaw - endYaw < -180.0f) {
            endYaw -= 360.0f;
        }
        while (startYaw - endYaw >= 180.0f) {
            endYaw += 360.0f;
        }
        while (startPitch - endPitch < -180.0f) {
            endPitch -= 360.0f;
        }
        while (startPitch - endPitch >= 180.0f) {
            endPitch += 360.0f;
        }
        if (endPitch > 0.0f) {
            final aob vector = this.headEntity.p.S().a(0.0, 0.0, -1.0);
            vector.b(-endYaw * 3.141593f / 180.0f);
            endX += vector.c;
            endY += vector.d;
            endZ += vector.e;
        }
        else {
            final aob vector = this.headEntity.Z();
            final float dist = 1.0f;
            endX -= vector.c * dist;
            endY -= vector.d * dist;
            endZ -= vector.e * dist;
        }
        float factor = 0.0f;
        factor = 0.0f;
        this.necka.b(endX + (startX - endX) * factor, endY + (startY - endY) * factor, endZ + (startZ - endZ) * factor);
        this.necka.z = endYaw + (startYaw - endYaw) * factor;
        this.necka.A = endPitch + (startPitch - endPitch) * factor;
        factor = 0.25f;
        this.neckb.b(endX + (startX - endX) * factor, endY + (startY - endY) * factor, endZ + (startZ - endZ) * factor);
        this.neckb.z = endYaw + (startYaw - endYaw) * factor;
        this.neckb.A = endPitch + (startPitch - endPitch) * factor;
        factor = 0.5f;
        this.neckc.b(endX + (startX - endX) * factor, endY + (startY - endY) * factor, endZ + (startZ - endZ) * factor);
        this.neckc.z = endYaw + (startYaw - endYaw) * factor;
        this.neckc.A = endPitch + (startPitch - endPitch) * factor;
        factor = 0.75f;
        this.neckd.b(endX + (startX - endX) * factor, endY + (startY - endY) * factor, endZ + (startZ - endZ) * factor);
        this.neckd.z = endYaw + (startYaw - endYaw) * factor;
        this.neckd.A = endPitch + (startPitch - endPitch) * factor;
        factor = 1.0f;
        this.necke.b(endX + (startX - endX) * factor, endY + (startY - endY) * factor, endZ + (startZ - endZ) * factor);
        this.necke.z = endYaw + (startYaw - endYaw) * factor;
        this.necke.A = endPitch + (startPitch - endPitch) * factor;
    }
    
    protected void faceIdle(final float yawConstraint, final float pitchConstraint) {
        final float angle = this.hydraObj.z * 3.141593f / 180.0f;
        final float distance = 30.0f;
        final double dx = this.hydraObj.t - ke.a(angle) * distance;
        final double dy = this.hydraObj.u + 3.0;
        final double dz = this.hydraObj.v + ke.b(angle) * distance;
        this.faceVec(dx, dy, dz, yawConstraint, pitchConstraint);
    }
    
    public void faceEntity(final lq entity, final float yawConstraint, final float pitchConstraint) {
        double yTarget;
        if (entity instanceof md) {
            final md entityliving = (md)entity;
            yTarget = entityliving.u + entityliving.e();
        }
        else {
            yTarget = (entity.D.b + entity.D.e) / 2.0;
        }
        this.faceVec(entity.t, yTarget, entity.v, yawConstraint, pitchConstraint);
        this.targetX = entity.t;
        this.targetY = entity.u;
        this.targetZ = entity.v;
    }
    
    public void faceVec(final double xCoord, final double yCoord, final double zCoord, final float yawConstraint, final float pitchConstraint) {
        final double xOffset = xCoord - this.headEntity.t;
        final double zOffset = zCoord - this.headEntity.v;
        final double yOffset = this.headEntity.u + 1.0 - yCoord;
        final double distance = ke.a(xOffset * xOffset + zOffset * zOffset);
        final float xyAngle = (float)(Math.atan2(zOffset, xOffset) * 180.0 / 3.141592653589793) - 90.0f;
        final float zdAngle = (float)(-(Math.atan2(yOffset, distance) * 180.0 / 3.141592653589793));
        this.headEntity.A = -this.updateRotation(this.headEntity.A, zdAngle, pitchConstraint);
        this.headEntity.z = this.updateRotation(this.headEntity.z, xyAngle, yawConstraint);
    }
    
    private float updateRotation(final float current, final float intended, final float increment) {
        float delta = ke.g(intended - current);
        if (delta > increment) {
            delta = increment;
        }
        if (delta < -increment) {
            delta = -increment;
        }
        return ke.g(current + delta);
    }
    
    public lq getTargetEntity() {
        return this.targetEntity;
    }
    
    public void setTargetEntity(final lq targetEntity) {
        this.targetEntity = targetEntity;
    }
    
    public void setHurtTime(final int hurtTime) {
        if (this.headEntity != null) {
            this.headEntity.aU = hurtTime;
        }
        this.necka.aU = hurtTime;
        this.neckb.aU = hurtTime;
        this.neckc.aU = hurtTime;
        this.neckd.aU = hurtTime;
        this.necke.aU = hurtTime;
    }
    
    public boolean shouldRenderHead() {
        return this.headEntity.getState() != 12 && this.headEntity.aX < 20;
    }
    
    public boolean shouldRenderNeck(final int neckNum) {
        final int time = 30 + 10 * neckNum;
        return this.headEntity.getState() != 12 && this.headEntity.aX < time;
    }
    
    public boolean isActive() {
        return this.currentState != 11 && this.currentState != 12;
    }
    
    public void addDamage(final int damageAmount) {
        this.damageTaken += damageAmount;
    }
    
    public int getDamageTaken() {
        return this.damageTaken;
    }
    
    public void setRespawnCounter(final int count) {
        this.respawnCounter = count;
    }
    
    static {
        HydraHeadContainer.FLAME_BURN_FACTOR = 3;
        HydraHeadContainer.FLAME_DAMAGE = 19;
        HydraHeadContainer.BITE_DAMAGE = 48;
        HydraHeadContainer.FLAME_BREATH_TRACKING_SPEED = 0.04;
        HydraHeadContainer.FLAME_BREATH_BREAKS_BLOCKS = false;
    }
}
