// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.boss;

import com.google.common.collect.ImmutableMap;
import javax.annotation.Nullable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.EnumDifficulty;
import java.util.Iterator;
import java.util.List;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.MultiPartEntityPart;
import twilightforest.TFSounds;
import net.minecraft.init.SoundEvents;
import twilightforest.client.particle.TFParticleType;
import twilightforest.TwilightForestMod;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.entity.SharedMonsterAttributes;
import java.util.EnumMap;
import java.util.Map;
import net.minecraft.entity.Entity;

public class HydraHeadContainer
{
    private static final int FLAME_BURN_FACTOR = 3;
    private static final int FLAME_DAMAGE = 19;
    private static final int BITE_DAMAGE = 48;
    private static double FLAME_BREATH_TRACKING_SPEED;
    private static final State NEXT_AUTOMATIC;
    public EntityTFHydraHead headEntity;
    public final EntityTFHydraNeck necka;
    public final EntityTFHydraNeck neckb;
    public final EntityTFHydraNeck neckc;
    public final EntityTFHydraNeck neckd;
    public final EntityTFHydraNeck necke;
    public Entity targetEntity;
    private double targetX;
    private double targetY;
    private double targetZ;
    private State prevState;
    private State currentState;
    private State nextState;
    public boolean isSecondaryAttacking;
    private int ticksNeeded;
    private int ticksProgress;
    private final int headNum;
    private int damageTaken;
    private int respawnCounter;
    private final EntityTFHydra hydra;
    private final Map<State, Float>[] stateNeckLength;
    private final Map<State, Float>[] stateXRotations;
    private final Map<State, Float>[] stateYRotations;
    private final Map<State, Float>[] stateMouthOpen;
    
    public HydraHeadContainer(final EntityTFHydra hydra, final int number, final boolean startActive) {
        this.nextState = HydraHeadContainer.NEXT_AUTOMATIC;
        this.headNum = number;
        this.hydra = hydra;
        this.damageTaken = 0;
        this.respawnCounter = -1;
        this.necka = new EntityTFHydraNeck(this.hydra, "neck" + this.headNum + "a", 2.0f, 2.0f);
        this.neckb = new EntityTFHydraNeck(this.hydra, "neck" + this.headNum + "b", 2.0f, 2.0f);
        this.neckc = new EntityTFHydraNeck(this.hydra, "neck" + this.headNum + "c", 2.0f, 2.0f);
        this.neckd = new EntityTFHydraNeck(this.hydra, "neck" + this.headNum + "d", 2.0f, 2.0f);
        this.necke = new EntityTFHydraNeck(this.hydra, "neck" + this.headNum + "e", 2.0f, 2.0f);
        this.hydra.getClass();
        this.stateNeckLength = new Map[7];
        this.hydra.getClass();
        this.stateXRotations = new Map[7];
        this.hydra.getClass();
        this.stateYRotations = new Map[7];
        this.hydra.getClass();
        this.stateMouthOpen = new Map[7];
        int i = 0;
        while (true) {
            final int n = i;
            this.hydra.getClass();
            if (n >= 7) {
                break;
            }
            this.stateNeckLength[i] = new EnumMap<State, Float>(State.class);
            this.stateXRotations[i] = new EnumMap<State, Float>(State.class);
            this.stateYRotations[i] = new EnumMap<State, Float>(State.class);
            this.stateMouthOpen[i] = new EnumMap<State, Float>(State.class);
            ++i;
        }
        this.setupStateRotations();
        if (startActive) {
            this.prevState = State.IDLE;
            this.currentState = State.IDLE;
            this.nextState = HydraHeadContainer.NEXT_AUTOMATIC;
            this.ticksNeeded = 60;
            this.ticksProgress = 60;
        }
        else {
            this.prevState = State.DEAD;
            this.currentState = State.DEAD;
            this.nextState = HydraHeadContainer.NEXT_AUTOMATIC;
            this.ticksNeeded = 20;
            this.ticksProgress = 20;
        }
    }
    
    protected void setupStateRotations() {
        this.setAnimation(0, State.IDLE, 60.0f, 0.0f, 7.0f, 0.0f);
        this.setAnimation(1, State.IDLE, 10.0f, 60.0f, 9.0f, 0.0f);
        this.setAnimation(2, State.IDLE, 10.0f, -60.0f, 9.0f, 0.0f);
        this.setAnimation(3, State.IDLE, 50.0f, 90.0f, 8.0f, 0.0f);
        this.setAnimation(4, State.IDLE, 50.0f, -90.0f, 8.0f, 0.0f);
        this.setAnimation(5, State.IDLE, -10.0f, 90.0f, 9.0f, 0.0f);
        this.setAnimation(6, State.IDLE, -10.0f, -90.0f, 9.0f, 0.0f);
        this.setAnimation(0, State.ATTACK_COOLDOWN, 60.0f, 0.0f, 7.0f, 0.0f);
        this.setAnimation(1, State.ATTACK_COOLDOWN, 10.0f, 60.0f, 9.0f, 0.0f);
        this.setAnimation(2, State.ATTACK_COOLDOWN, 10.0f, -60.0f, 9.0f, 0.0f);
        this.setAnimation(3, State.ATTACK_COOLDOWN, 50.0f, 90.0f, 8.0f, 0.0f);
        this.setAnimation(4, State.ATTACK_COOLDOWN, 50.0f, -90.0f, 8.0f, 0.0f);
        this.setAnimation(5, State.ATTACK_COOLDOWN, -10.0f, 90.0f, 9.0f, 0.0f);
        this.setAnimation(6, State.ATTACK_COOLDOWN, -10.0f, -90.0f, 9.0f, 0.0f);
        this.setAnimation(0, State.FLAME_BEGINNING, 50.0f, 0.0f, 8.0f, 0.75f);
        this.setAnimation(1, State.FLAME_BEGINNING, 30.0f, 45.0f, 9.0f, 0.75f);
        this.setAnimation(2, State.FLAME_BEGINNING, 30.0f, -45.0f, 9.0f, 0.75f);
        this.setAnimation(3, State.FLAME_BEGINNING, 50.0f, 90.0f, 8.0f, 0.75f);
        this.setAnimation(4, State.FLAME_BEGINNING, 50.0f, -90.0f, 8.0f, 0.75f);
        this.setAnimation(5, State.FLAME_BEGINNING, -10.0f, 90.0f, 9.0f, 0.75f);
        this.setAnimation(6, State.FLAME_BEGINNING, -10.0f, -90.0f, 9.0f, 0.75f);
        this.setAnimation(0, State.FLAMING, 45.0f, 0.0f, 8.0f, 1.0f);
        this.setAnimation(1, State.FLAMING, 30.0f, 60.0f, 9.0f, 1.0f);
        this.setAnimation(2, State.FLAMING, 30.0f, -60.0f, 9.0f, 1.0f);
        this.setAnimation(3, State.FLAMING, 50.0f, 90.0f, 8.0f, 1.0f);
        this.setAnimation(4, State.FLAMING, 50.0f, -90.0f, 8.0f, 1.0f);
        this.setAnimation(5, State.FLAMING, -10.0f, 90.0f, 9.0f, 1.0f);
        this.setAnimation(6, State.FLAMING, -10.0f, -90.0f, 9.0f, 1.0f);
        this.setAnimation(0, State.FLAME_ENDING, 60.0f, 0.0f, 7.0f, 0.0f);
        this.setAnimation(1, State.FLAME_ENDING, 10.0f, 45.0f, 9.0f, 0.0f);
        this.setAnimation(2, State.FLAME_ENDING, 10.0f, -45.0f, 9.0f, 0.0f);
        this.setAnimation(3, State.FLAME_ENDING, 50.0f, 90.0f, 8.0f, 0.0f);
        this.setAnimation(4, State.FLAME_ENDING, 50.0f, -90.0f, 8.0f, 0.0f);
        this.setAnimation(5, State.FLAME_ENDING, -10.0f, 90.0f, 9.0f, 0.0f);
        this.setAnimation(6, State.FLAME_ENDING, -10.0f, -90.0f, 9.0f, 0.0f);
        this.setAnimation(0, State.BITE_BEGINNING, -5.0f, 60.0f, 5.0f, 0.25f);
        this.setAnimation(1, State.BITE_BEGINNING, -10.0f, 60.0f, 9.0f, 0.25f);
        this.setAnimation(2, State.BITE_BEGINNING, -10.0f, -60.0f, 9.0f, 0.25f);
        this.setAnimation(0, State.BITE_READY, -5.0f, 60.0f, 5.0f, 1.0f);
        this.setAnimation(1, State.BITE_READY, -10.0f, 60.0f, 9.0f, 1.0f);
        this.setAnimation(2, State.BITE_READY, -10.0f, -60.0f, 9.0f, 1.0f);
        this.setAnimation(0, State.BITING, -5.0f, -30.0f, 5.0f, 0.2f);
        this.setAnimation(1, State.BITING, -10.0f, -30.0f, 5.0f, 0.2f);
        this.setAnimation(2, State.BITING, -10.0f, 30.0f, 5.0f, 0.2f);
        this.setAnimation(0, State.BITE_ENDING, 60.0f, 0.0f, 7.0f, 0.0f);
        this.setAnimation(1, State.BITE_ENDING, -10.0f, 60.0f, 9.0f, 0.0f);
        this.setAnimation(2, State.BITE_ENDING, -10.0f, -60.0f, 9.0f, 0.0f);
        this.setAnimation(0, State.MORTAR_BEGINNING, 50.0f, 0.0f, 8.0f, 0.75f);
        this.setAnimation(1, State.MORTAR_BEGINNING, 30.0f, 45.0f, 9.0f, 0.75f);
        this.setAnimation(2, State.MORTAR_BEGINNING, 30.0f, -45.0f, 9.0f, 0.75f);
        this.setAnimation(3, State.MORTAR_BEGINNING, 50.0f, 90.0f, 8.0f, 0.75f);
        this.setAnimation(4, State.MORTAR_BEGINNING, 50.0f, -90.0f, 8.0f, 0.75f);
        this.setAnimation(5, State.MORTAR_BEGINNING, -10.0f, 90.0f, 9.0f, 0.75f);
        this.setAnimation(6, State.MORTAR_BEGINNING, -10.0f, -90.0f, 9.0f, 0.75f);
        this.setAnimation(0, State.MORTAR_SHOOTING, 45.0f, 0.0f, 8.0f, 1.0f);
        this.setAnimation(1, State.MORTAR_SHOOTING, 30.0f, 60.0f, 9.0f, 1.0f);
        this.setAnimation(2, State.MORTAR_SHOOTING, 30.0f, -60.0f, 9.0f, 1.0f);
        this.setAnimation(3, State.MORTAR_SHOOTING, 50.0f, 90.0f, 8.0f, 1.0f);
        this.setAnimation(4, State.MORTAR_SHOOTING, 50.0f, -90.0f, 8.0f, 1.0f);
        this.setAnimation(5, State.MORTAR_SHOOTING, -10.0f, 90.0f, 9.0f, 1.0f);
        this.setAnimation(6, State.MORTAR_SHOOTING, -10.0f, -90.0f, 9.0f, 1.0f);
        this.setAnimation(0, State.MORTAR_ENDING, 60.0f, 0.0f, 7.0f, 0.0f);
        this.setAnimation(1, State.MORTAR_ENDING, 10.0f, 45.0f, 9.0f, 0.0f);
        this.setAnimation(2, State.MORTAR_ENDING, 10.0f, -45.0f, 9.0f, 0.0f);
        this.setAnimation(3, State.MORTAR_ENDING, 50.0f, 90.0f, 8.0f, 0.0f);
        this.setAnimation(4, State.MORTAR_ENDING, 50.0f, -90.0f, 8.0f, 0.0f);
        this.setAnimation(5, State.MORTAR_ENDING, -10.0f, 90.0f, 9.0f, 0.0f);
        this.setAnimation(6, State.MORTAR_ENDING, -10.0f, -90.0f, 9.0f, 0.0f);
        this.setAnimation(0, State.DYING, -20.0f, 0.0f, 7.0f, 0.0f);
        this.setAnimation(1, State.DYING, -20.0f, 60.0f, 9.0f, 0.0f);
        this.setAnimation(2, State.DYING, -20.0f, -60.0f, 9.0f, 0.0f);
        this.setAnimation(3, State.DYING, -20.0f, 90.0f, 8.0f, 0.0f);
        this.setAnimation(4, State.DYING, -20.0f, -90.0f, 8.0f, 0.0f);
        this.setAnimation(5, State.DYING, -10.0f, 90.0f, 9.0f, 0.0f);
        this.setAnimation(6, State.DYING, -10.0f, -90.0f, 9.0f, 0.0f);
        this.setAnimation(0, State.DEAD, 0.0f, 179.0f, 4.0f, 0.0f);
        this.setAnimation(1, State.DEAD, 0.0f, 179.0f, 4.0f, 0.0f);
        this.setAnimation(2, State.DEAD, 0.0f, -180.0f, 4.0f, 0.0f);
        this.setAnimation(3, State.DEAD, 0.0f, 179.0f, 4.0f, 0.0f);
        this.setAnimation(4, State.DEAD, 0.0f, -180.0f, 4.0f, 0.0f);
        this.setAnimation(5, State.DEAD, 0.0f, 179.0f, 4.0f, 0.0f);
        this.setAnimation(6, State.DEAD, 0.0f, -180.0f, 4.0f, 0.0f);
        this.setAnimation(0, State.BORN, 60.0f, 0.0f, 7.0f, 0.0f);
        this.setAnimation(1, State.BORN, 10.0f, 60.0f, 9.0f, 0.0f);
        this.setAnimation(2, State.BORN, 10.0f, -60.0f, 9.0f, 0.0f);
        this.setAnimation(3, State.BORN, 50.0f, 90.0f, 8.0f, 0.0f);
        this.setAnimation(4, State.BORN, 50.0f, -90.0f, 8.0f, 0.0f);
        this.setAnimation(5, State.BORN, -10.0f, 90.0f, 9.0f, 0.0f);
        this.setAnimation(6, State.BORN, -10.0f, -90.0f, 9.0f, 0.0f);
        this.setAnimation(0, State.ROAR_START, 60.0f, 0.0f, 7.0f, 0.25f);
        this.setAnimation(1, State.ROAR_START, 10.0f, 60.0f, 9.0f, 0.25f);
        this.setAnimation(2, State.ROAR_START, 10.0f, -60.0f, 9.0f, 0.25f);
        this.setAnimation(3, State.ROAR_START, 50.0f, 90.0f, 8.0f, 0.25f);
        this.setAnimation(4, State.ROAR_START, 50.0f, -90.0f, 8.0f, 0.25f);
        this.setAnimation(5, State.ROAR_START, -10.0f, 90.0f, 9.0f, 0.25f);
        this.setAnimation(6, State.ROAR_START, -10.0f, -90.0f, 9.0f, 0.25f);
        this.setAnimation(0, State.ROAR_RAWR, 60.0f, 0.0f, 9.0f, 1.0f);
        this.setAnimation(1, State.ROAR_RAWR, 10.0f, 60.0f, 11.0f, 1.0f);
        this.setAnimation(2, State.ROAR_RAWR, 10.0f, -60.0f, 11.0f, 1.0f);
        this.setAnimation(3, State.ROAR_RAWR, 50.0f, 90.0f, 10.0f, 1.0f);
        this.setAnimation(4, State.ROAR_RAWR, 50.0f, -90.0f, 10.0f, 1.0f);
        this.setAnimation(5, State.ROAR_RAWR, -10.0f, 90.0f, 11.0f, 1.0f);
        this.setAnimation(6, State.ROAR_RAWR, -10.0f, -90.0f, 11.0f, 1.0f);
    }
    
    private void setAnimation(final int head, final State state, final float xRotation, final float yRotation, final float neckLength, final float mouthOpen) {
        this.stateXRotations[head].put(state, xRotation);
        this.stateYRotations[head].put(state, yRotation);
        this.stateNeckLength[head].put(state, neckLength);
        this.stateMouthOpen[head].put(state, mouthOpen);
    }
    
    public EntityTFHydraNeck[] getNeckArray() {
        return new EntityTFHydraNeck[] { this.necka, this.neckb, this.neckc, this.neckd, this.necke };
    }
    
    public void onUpdate() {
        this.necka.func_70071_h_();
        this.neckb.func_70071_h_();
        this.neckc.func_70071_h_();
        this.neckd.func_70071_h_();
        this.necke.func_70071_h_();
        if (this.headEntity == null) {
            this.headEntity = this.findNearbyHead("head" + this.headNum);
        }
        this.setDifficultyVariables();
        if (this.headEntity != null) {
            final EntityTFHydraHead headEntity = this.headEntity;
            final EntityTFHydraHead headEntity2 = this.headEntity;
            final float n = this.isActive() ? 4.0f : 1.0f;
            headEntity2.field_70131_O = n;
            headEntity.field_70130_N = n;
            if (!this.hydra.field_70170_p.field_72995_K) {
                this.advanceRespawnCounter();
                this.advanceHeadState();
                this.setHeadPosition();
                this.setHeadFacing();
                this.executeAttacks();
                this.playSounds();
            }
            else {
                this.clientAnimateHeadDeath();
                this.addMouthParticles();
            }
            this.setNeckPosition();
        }
    }
    
    public boolean canRespawn() {
        return this.currentState == State.DEAD && this.respawnCounter == -1;
    }
    
    private void advanceRespawnCounter() {
        if (this.currentState == State.DEAD && this.respawnCounter > -1 && --this.respawnCounter <= 0) {
            this.setNextState(State.BORN);
            this.damageTaken = 0;
            this.endCurrentAction();
            this.respawnCounter = -1;
        }
    }
    
    private void clientAnimateHeadDeath() {
        if (this.headEntity.getState() == State.DYING) {
            final EntityTFHydraHead headEntity = this.headEntity;
            ++headEntity.field_70725_aQ;
            if (this.headEntity.field_70725_aQ > 0) {
                if (this.headEntity.field_70725_aQ < 20) {
                    this.doExplosionOn(this.headEntity, true);
                }
                else if (this.headEntity.field_70725_aQ < 30) {
                    this.doExplosionOn(this.necka, false);
                }
                else if (this.headEntity.field_70725_aQ < 40) {
                    this.doExplosionOn(this.neckb, false);
                }
                else if (this.headEntity.field_70725_aQ < 50) {
                    this.doExplosionOn(this.neckc, false);
                }
                else if (this.headEntity.field_70725_aQ < 60) {
                    this.doExplosionOn(this.neckd, false);
                }
                else if (this.headEntity.field_70725_aQ < 70) {
                    this.doExplosionOn(this.necke, false);
                }
            }
            this.necka.field_70737_aN = 20;
            this.neckb.field_70737_aN = 20;
            this.neckc.field_70737_aN = 20;
            this.neckd.field_70737_aN = 20;
            this.necke.field_70737_aN = 20;
        }
        else {
            this.headEntity.field_70725_aQ = 0;
            this.headEntity.func_70606_j((float)this.headEntity.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111125_b());
        }
    }
    
    private void doExplosionOn(final EntityTFHydraPart part, final boolean large) {
        for (int i = 0; i < 10; ++i) {
            final double vx = part.func_70681_au().nextGaussian() * 0.02;
            final double vy = part.func_70681_au().nextGaussian() * 0.02;
            final double vz = part.func_70681_au().nextGaussian() * 0.02;
            final EnumParticleTypes particle = (large && part.func_70681_au().nextInt(5) == 0) ? EnumParticleTypes.EXPLOSION_LARGE : EnumParticleTypes.EXPLOSION_NORMAL;
            part.field_70170_p.func_175688_a(particle, part.field_70165_t + part.func_70681_au().nextFloat() * part.field_70130_N * 2.0f - part.field_70130_N, part.field_70163_u + part.func_70681_au().nextFloat() * part.field_70131_O, part.field_70161_v + part.func_70681_au().nextFloat() * part.field_70130_N * 2.0f - part.field_70130_N, vx, vy, vz, new int[0]);
        }
    }
    
    private void advanceHeadState() {
        if (++this.ticksProgress >= this.ticksNeeded) {
            State myNext;
            if (this.nextState == HydraHeadContainer.NEXT_AUTOMATIC) {
                myNext = State.NEXT_STATE.get(this.currentState);
                if (myNext != this.currentState && this.isSecondaryAttacking && myNext == State.ATTACK_COOLDOWN) {
                    this.isSecondaryAttacking = false;
                    myNext = State.IDLE;
                }
            }
            else {
                myNext = this.nextState;
                this.nextState = HydraHeadContainer.NEXT_AUTOMATIC;
            }
            final int duration = myNext.duration;
            this.ticksProgress = duration;
            this.ticksNeeded = duration;
            this.ticksProgress = 0;
            this.prevState = this.currentState;
            this.currentState = myNext;
        }
        if (this.headEntity.getState() != this.currentState) {
            this.headEntity.setState(this.currentState);
        }
    }
    
    private void setHeadFacing() {
        if (this.currentState == State.BITE_READY) {
            this.faceEntity(this.targetEntity, 5.0f, (float)this.hydra.func_70646_bf());
            float biteMaxYaw = -60.0f;
            float biteMinYaw = -90.0f;
            if (this.headNum == 2) {
                biteMaxYaw = 60.0f;
                biteMinYaw = 90.0f;
            }
            final float yawOffOffset = MathHelper.func_76142_g(this.headEntity.field_70177_z - this.hydra.field_70761_aq);
            if (yawOffOffset > biteMaxYaw) {
                this.headEntity.field_70177_z = this.hydra.field_70761_aq + biteMaxYaw;
            }
            if (yawOffOffset < biteMinYaw) {
                this.headEntity.field_70177_z = this.hydra.field_70761_aq + biteMinYaw;
            }
            final Vec3d look = this.headEntity.func_70040_Z();
            final double distance = 16.0;
            this.targetX = this.headEntity.field_70165_t + look.field_72450_a * distance;
            this.targetY = this.headEntity.field_70163_u + 1.5 + look.field_72448_b * distance;
            this.targetZ = this.headEntity.field_70161_v + look.field_72449_c * distance;
        }
        else if (this.currentState == State.BITING || this.currentState == State.BITE_ENDING) {
            this.faceEntity(this.targetEntity, 5.0f, (float)this.hydra.func_70646_bf());
            final EntityTFHydraHead headEntity = this.headEntity;
            headEntity.field_70125_A += (float)0.7853981633974483;
        }
        else if (this.currentState == State.ROAR_RAWR) {
            this.faceVec(this.targetX, this.targetY, this.targetZ, 10.0f, (float)this.hydra.func_70646_bf());
        }
        else if (this.currentState == State.FLAMING || this.currentState == State.FLAME_BEGINNING) {
            this.moveTargetCoordsTowardsTargetEntity(HydraHeadContainer.FLAME_BREATH_TRACKING_SPEED);
            this.faceVec(this.targetX, this.targetY, this.targetZ, 5.0f, (float)this.hydra.func_70646_bf());
        }
        else if (this.isActive()) {
            if (this.targetEntity != null) {
                this.faceEntity(this.targetEntity, 5.0f, (float)this.hydra.func_70646_bf());
            }
            else {
                this.faceIdle(1.5f, (float)this.hydra.func_70646_bf());
            }
        }
    }
    
    private void moveTargetCoordsTowardsTargetEntity(final double distance) {
        if (this.targetEntity != null) {
            Vec3d vect = new Vec3d(this.targetEntity.field_70165_t - this.targetX, this.targetEntity.field_70163_u - this.targetY, this.targetEntity.field_70161_v - this.targetZ);
            vect = vect.func_72432_b();
            this.targetX += vect.field_72450_a * distance;
            this.targetY += vect.field_72448_b * distance;
            this.targetZ += vect.field_72449_c * distance;
        }
    }
    
    private void addMouthParticles() {
        final Vec3d vector = this.headEntity.func_70040_Z();
        final double dist = 3.5;
        final double px = this.headEntity.field_70165_t + vector.field_72450_a * dist;
        final double py = this.headEntity.field_70163_u + 1.0 + vector.field_72448_b * dist;
        final double pz = this.headEntity.field_70161_v + vector.field_72449_c * dist;
        if (this.headEntity.getState() == State.FLAME_BEGINNING) {
            this.headEntity.field_70170_p.func_175688_a(EnumParticleTypes.FLAME, px + this.headEntity.func_70681_au().nextDouble() - 0.5, py + this.headEntity.func_70681_au().nextDouble() - 0.5, pz + this.headEntity.func_70681_au().nextDouble() - 0.5, 0.0, 0.0, 0.0, new int[0]);
            this.headEntity.field_70170_p.func_175688_a(EnumParticleTypes.SMOKE_NORMAL, px + this.headEntity.func_70681_au().nextDouble() - 0.5, py + this.headEntity.func_70681_au().nextDouble() - 0.5, pz + this.headEntity.func_70681_au().nextDouble() - 0.5, 0.0, 0.0, 0.0, new int[0]);
        }
        if (this.headEntity.getState() == State.FLAMING) {
            final Vec3d look = this.headEntity.func_70040_Z();
            for (int i = 0; i < 5; ++i) {
                double dx = look.field_72450_a;
                double dy = look.field_72448_b;
                double dz = look.field_72449_c;
                final double spread = 5.0 + this.headEntity.func_70681_au().nextDouble() * 2.5;
                final double velocity = 1.0 + this.headEntity.func_70681_au().nextDouble();
                dx += this.headEntity.func_70681_au().nextGaussian() * 0.007499999832361937 * spread;
                dy += this.headEntity.func_70681_au().nextGaussian() * 0.007499999832361937 * spread;
                dz += this.headEntity.func_70681_au().nextGaussian() * 0.007499999832361937 * spread;
                dx *= velocity;
                dy *= velocity;
                dz *= velocity;
                TwilightForestMod.proxy.spawnParticle(TFParticleType.LARGE_FLAME, px, py, pz, dx, dy, dz);
            }
        }
        if (this.headEntity.getState() == State.BITE_BEGINNING || this.headEntity.getState() == State.BITE_READY) {
            this.headEntity.field_70170_p.func_175688_a(EnumParticleTypes.WATER_SPLASH, px + this.headEntity.func_70681_au().nextDouble() - 0.5, py + this.headEntity.func_70681_au().nextDouble() - 0.5, pz + this.headEntity.func_70681_au().nextDouble() - 0.5, 0.0, 0.0, 0.0, new int[0]);
        }
        if (this.headEntity.getState() == State.MORTAR_BEGINNING) {
            this.headEntity.field_70170_p.func_175688_a(EnumParticleTypes.SMOKE_LARGE, px + this.headEntity.func_70681_au().nextDouble() - 0.5, py + this.headEntity.func_70681_au().nextDouble() - 0.5, pz + this.headEntity.func_70681_au().nextDouble() - 0.5, 0.0, 0.0, 0.0, new int[0]);
        }
    }
    
    private void playSounds() {
        if (this.headEntity.getState() == State.FLAMING && this.headEntity.field_70173_aa % 5 == 0) {
            this.headEntity.func_184185_a(SoundEvents.field_187557_bK, 0.5f + this.headEntity.func_70681_au().nextFloat(), this.headEntity.func_70681_au().nextFloat() * 0.7f + 0.3f);
        }
        if (this.headEntity.getState() == State.ROAR_RAWR) {
            this.headEntity.func_184185_a(TFSounds.HYDRA_ROAR, 1.25f, this.headEntity.func_70681_au().nextFloat() * 0.3f + 0.7f);
        }
        if (this.headEntity.getState() == State.BITE_READY && this.ticksProgress == 60) {
            this.headEntity.func_184185_a(TFSounds.HYDRA_WARN, 2.0f, this.headEntity.func_70681_au().nextFloat() * 0.3f + 0.7f);
        }
    }
    
    private void setNeckPosition() {
        Vec3d vector = null;
        float neckRotation = 0.0f;
        if (this.headNum == 0) {
            vector = new Vec3d(0.0, 3.0, -1.0);
            neckRotation = 0.0f;
        }
        if (this.headNum == 1) {
            vector = new Vec3d(-1.0, 3.0, 3.0);
            neckRotation = 90.0f;
        }
        if (this.headNum == 2) {
            vector = new Vec3d(1.0, 3.0, 3.0);
            neckRotation = -90.0f;
        }
        if (this.headNum == 3) {
            vector = new Vec3d(-1.0, 3.0, 3.0);
            neckRotation = 135.0f;
        }
        if (this.headNum == 4) {
            vector = new Vec3d(1.0, 3.0, 3.0);
            neckRotation = -135.0f;
        }
        if (this.headNum == 5) {
            vector = new Vec3d(-1.0, 3.0, 5.0);
            neckRotation = 135.0f;
        }
        if (this.headNum == 6) {
            vector = new Vec3d(1.0, 3.0, 5.0);
            neckRotation = -135.0f;
        }
        vector = vector.func_178785_b(-(this.hydra.field_70761_aq + neckRotation) * 3.141593f / 180.0f);
        this.setNeckPosition(this.hydra.field_70165_t + vector.field_72450_a, this.hydra.field_70163_u + vector.field_72448_b, this.hydra.field_70161_v + vector.field_72449_c, this.hydra.field_70761_aq, 0.0f);
    }
    
    protected void setHeadPosition() {
        this.setupStateRotations();
        final float neckLength = this.getCurrentNeckLength();
        final float xRotation = this.getCurrentHeadXRotation();
        final float yRotation = this.getCurrentHeadYRotation();
        final float periodX = (this.headNum == 0 || this.headNum == 3) ? 20.0f : ((this.headNum == 1 || this.headNum == 4) ? 5.0f : 7.0f);
        final float periodY = (this.headNum == 0 || this.headNum == 4) ? 10.0f : ((this.headNum == 1 || this.headNum == 6) ? 6.0f : 5.0f);
        float xSwing = MathHelper.func_76126_a(this.hydra.field_70173_aa / periodX) * 3.0f;
        float ySwing = MathHelper.func_76126_a(this.hydra.field_70173_aa / periodY) * 5.0f;
        if (!this.isActive()) {
            ySwing = (xSwing = 0.0f);
        }
        Vec3d vector = new Vec3d(0.0, 0.0, (double)neckLength);
        vector = vector.func_178789_a((xRotation * 3.141593f + xSwing) / 180.0f);
        vector = vector.func_178785_b(-(this.hydra.field_70761_aq + yRotation + ySwing) * 3.141593f / 180.0f);
        final double dx = this.hydra.field_70165_t + vector.field_72450_a;
        final double dy = this.hydra.field_70163_u + vector.field_72448_b + 3.0;
        final double dz = this.hydra.field_70161_v + vector.field_72449_c;
        this.headEntity.func_70107_b(dx, dy, dz);
        this.headEntity.setMouthOpen(this.getCurrentMouthOpen());
    }
    
    private void executeAttacks() {
        if (this.currentState == State.MORTAR_SHOOTING && this.ticksProgress % 10 == 0) {
            final Entity lookTarget = this.getHeadLookTarget();
            if (lookTarget instanceof EntityTFHydraPart || lookTarget instanceof MultiPartEntityPart) {
                this.endCurrentAction();
            }
            else {
                final EntityTFHydraMortar mortar = new EntityTFHydraMortar(this.headEntity.field_70170_p, this.headEntity);
                if (this.targetEntity != null && !this.headEntity.func_70635_at().func_75522_a(this.targetEntity)) {
                    mortar.setToBlasting();
                }
                this.headEntity.field_70170_p.func_175718_b(1016, new BlockPos((Entity)this.headEntity), 0);
                this.headEntity.field_70170_p.func_72838_d((Entity)mortar);
            }
        }
        if (this.headEntity.getState() == State.BITING) {
            final List<Entity> nearbyList = this.headEntity.field_70170_p.func_72839_b((Entity)this.headEntity, this.headEntity.func_174813_aQ().func_72314_b(0.0, 1.0, 0.0));
            for (final Entity nearby : nearbyList) {
                if (nearby instanceof EntityLivingBase && !(nearby instanceof EntityTFHydraPart) && !(nearby instanceof EntityTFHydra) && !(nearby instanceof MultiPartEntityPart)) {
                    nearby.func_70097_a(DamageSource.func_76358_a((EntityLivingBase)this.hydra), 48.0f);
                }
            }
        }
        if (this.headEntity.getState() == State.FLAMING) {
            final Entity target = this.getHeadLookTarget();
            if (target != null) {
                if (target instanceof EntityTFHydraPart || target instanceof MultiPartEntityPart) {
                    this.endCurrentAction();
                }
                else if (!target.func_70045_F() && target.func_70097_a(DamageSource.field_76372_a, 19.0f)) {
                    target.func_70015_d(3);
                }
            }
        }
    }
    
    private void setDifficultyVariables() {
        if (this.hydra.field_70170_p.func_175659_aa() != EnumDifficulty.HARD) {
            HydraHeadContainer.FLAME_BREATH_TRACKING_SPEED = 0.04;
        }
        else {
            HydraHeadContainer.FLAME_BREATH_TRACKING_SPEED = 0.1;
        }
    }
    
    @Nullable
    private Entity getHeadLookTarget() {
        Entity pointedEntity = null;
        final double range = 30.0;
        final Vec3d srcVec = new Vec3d(this.headEntity.field_70165_t, this.headEntity.field_70163_u + 1.0, this.headEntity.field_70161_v);
        final Vec3d lookVec = this.headEntity.func_70676_i(1.0f);
        final RayTraceResult raytrace = this.headEntity.field_70170_p.func_72933_a(srcVec, srcVec.func_72441_c(lookVec.field_72450_a * range, lookVec.field_72448_b * range, lookVec.field_72449_c * range));
        final BlockPos hitpos = (raytrace != null) ? raytrace.func_178782_a() : null;
        final double rx = (hitpos == null) ? range : Math.min(range, Math.abs(this.headEntity.field_70165_t - hitpos.func_177958_n()));
        final double ry = (hitpos == null) ? range : Math.min(range, Math.abs(this.headEntity.field_70163_u - hitpos.func_177956_o()));
        final double rz = (hitpos == null) ? range : Math.min(range, Math.abs(this.headEntity.field_70161_v - hitpos.func_177952_p()));
        final Vec3d destVec = srcVec.func_72441_c(lookVec.field_72450_a * range, lookVec.field_72448_b * range, lookVec.field_72449_c * range);
        final float var9 = 3.0f;
        final List<Entity> possibleList = this.headEntity.field_70170_p.func_72839_b((Entity)this.headEntity, this.headEntity.func_174813_aQ().func_72317_d(lookVec.field_72450_a * rx, lookVec.field_72448_b * ry, lookVec.field_72449_c * rz).func_72314_b((double)var9, (double)var9, (double)var9));
        double hitDist = 0.0;
        for (final Entity possibleEntity : possibleList) {
            if (possibleEntity.func_70067_L() && possibleEntity != this.headEntity && possibleEntity != this.necka && possibleEntity != this.neckb && possibleEntity != this.neckc) {
                final float borderSize = possibleEntity.func_70111_Y();
                final AxisAlignedBB collisionBB = possibleEntity.func_174813_aQ().func_72314_b((double)borderSize, (double)borderSize, (double)borderSize);
                final RayTraceResult interceptPos = collisionBB.func_72327_a(srcVec, destVec);
                if (collisionBB.func_72318_a(srcVec)) {
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
                    final double possibleDist = srcVec.func_72438_d(interceptPos.field_72307_f);
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
    
    public void setNextState(final State next) {
        this.nextState = next;
    }
    
    public void endCurrentAction() {
        this.ticksProgress = this.ticksNeeded;
    }
    
    @Nullable
    private EntityTFHydraHead findNearbyHead(final String string) {
        final List<EntityTFHydraHead> nearbyHeads = this.hydra.field_70170_p.func_72872_a((Class)EntityTFHydraHead.class, new AxisAlignedBB(this.hydra.field_70165_t, this.hydra.field_70163_u, this.hydra.field_70161_v, this.hydra.field_70165_t + 1.0, this.hydra.field_70163_u + 1.0, this.hydra.field_70161_v + 1.0).func_72314_b(16.0, 16.0, 16.0));
        for (final EntityTFHydraHead nearbyHead : nearbyHeads) {
            if (nearbyHead.getPartName().equals(string)) {
                nearbyHead.hydra = this.hydra;
                return nearbyHead;
            }
        }
        return null;
    }
    
    private float getCurrentNeckLength() {
        final float prevLength = this.stateNeckLength[this.headNum].get(this.prevState);
        final float curLength = this.stateNeckLength[this.headNum].get(this.currentState);
        final float progress = this.ticksProgress / (float)this.ticksNeeded;
        return (float)MathHelper.func_151238_b((double)prevLength, (double)curLength, (double)progress);
    }
    
    private float getCurrentHeadXRotation() {
        final float prevRotation = this.stateXRotations[this.headNum].get(this.prevState);
        final float currentRotation = this.stateXRotations[this.headNum].get(this.currentState);
        final float progress = this.ticksProgress / (float)this.ticksNeeded;
        return (float)MathHelper.func_151238_b((double)prevRotation, (double)currentRotation, (double)progress);
    }
    
    private float getCurrentHeadYRotation() {
        final float prevRotation = this.stateYRotations[this.headNum].get(this.prevState);
        final float currentRotation = this.stateYRotations[this.headNum].get(this.currentState);
        final float progress = this.ticksProgress / (float)this.ticksNeeded;
        return (float)MathHelper.func_151238_b((double)prevRotation, (double)currentRotation, (double)progress);
    }
    
    protected float getCurrentMouthOpen() {
        final float prevOpen = this.stateMouthOpen[this.headNum].get(this.prevState);
        final float curOpen = this.stateMouthOpen[this.headNum].get(this.currentState);
        final float progress = this.ticksProgress / (float)this.ticksNeeded;
        return (float)MathHelper.func_151238_b((double)prevOpen, (double)curOpen, (double)progress);
    }
    
    protected void setNeckPosition(final double startX, final double startY, final double startZ, final float startYaw, final float startPitch) {
        double endX = this.headEntity.field_70165_t;
        double endY = this.headEntity.field_70163_u;
        double endZ = this.headEntity.field_70161_v;
        float endYaw = this.headEntity.field_70177_z;
        float endPitch = this.headEntity.field_70125_A;
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
            final Vec3d vector = new Vec3d(0.0, 0.0, -1.0).func_178785_b(-endYaw * 3.141593f / 180.0f);
            endX += vector.field_72450_a;
            endY += vector.field_72448_b;
            endZ += vector.field_72449_c;
        }
        else {
            final Vec3d vector = this.headEntity.func_70040_Z();
            final float dist = 1.0f;
            endX -= vector.field_72450_a * dist;
            endY -= vector.field_72448_b * dist;
            endZ -= vector.field_72449_c * dist;
        }
        float factor = 0.0f;
        factor = 0.0f;
        this.necka.func_70107_b(endX + (startX - endX) * factor, endY + (startY - endY) * factor, endZ + (startZ - endZ) * factor);
        this.necka.field_70177_z = endYaw + (startYaw - endYaw) * factor;
        this.necka.field_70125_A = endPitch + (startPitch - endPitch) * factor;
        factor = 0.25f;
        this.neckb.func_70107_b(endX + (startX - endX) * factor, endY + (startY - endY) * factor, endZ + (startZ - endZ) * factor);
        this.neckb.field_70177_z = endYaw + (startYaw - endYaw) * factor;
        this.neckb.field_70125_A = endPitch + (startPitch - endPitch) * factor;
        factor = 0.5f;
        this.neckc.func_70107_b(endX + (startX - endX) * factor, endY + (startY - endY) * factor, endZ + (startZ - endZ) * factor);
        this.neckc.field_70177_z = endYaw + (startYaw - endYaw) * factor;
        this.neckc.field_70125_A = endPitch + (startPitch - endPitch) * factor;
        factor = 0.75f;
        this.neckd.func_70107_b(endX + (startX - endX) * factor, endY + (startY - endY) * factor, endZ + (startZ - endZ) * factor);
        this.neckd.field_70177_z = endYaw + (startYaw - endYaw) * factor;
        this.neckd.field_70125_A = endPitch + (startPitch - endPitch) * factor;
        factor = 1.0f;
        this.necke.func_70107_b(endX + (startX - endX) * factor, endY + (startY - endY) * factor, endZ + (startZ - endZ) * factor);
        this.necke.field_70177_z = endYaw + (startYaw - endYaw) * factor;
        this.necke.field_70125_A = endPitch + (startPitch - endPitch) * factor;
    }
    
    private void faceIdle(final float yawConstraint, final float pitchConstraint) {
        final float angle = this.hydra.field_70177_z * 3.141593f / 180.0f;
        final float distance = 30.0f;
        final double dx = this.hydra.field_70165_t - MathHelper.func_76126_a(angle) * distance;
        final double dy = this.hydra.field_70163_u + 3.0;
        final double dz = this.hydra.field_70161_v + MathHelper.func_76134_b(angle) * distance;
        this.faceVec(dx, dy, dz, yawConstraint, pitchConstraint);
    }
    
    public void faceEntity(final Entity entity, final float yawConstraint, final float pitchConstraint) {
        double yTarget;
        if (entity instanceof EntityLivingBase) {
            final EntityLivingBase entityliving = (EntityLivingBase)entity;
            yTarget = entityliving.field_70163_u + entityliving.func_70047_e();
        }
        else {
            yTarget = (entity.func_174813_aQ().field_72338_b + entity.func_174813_aQ().field_72337_e) / 2.0;
        }
        this.faceVec(entity.field_70165_t, yTarget, entity.field_70161_v, yawConstraint, pitchConstraint);
        this.targetX = entity.field_70165_t;
        this.targetY = entity.field_70163_u;
        this.targetZ = entity.field_70161_v;
    }
    
    private void faceVec(final double x, final double y, final double z, final float yawConstraint, final float pitchConstraint) {
        final double xOffset = x - this.headEntity.field_70165_t;
        final double zOffset = z - this.headEntity.field_70161_v;
        final double yOffset = this.headEntity.field_70163_u + 1.0 - y;
        final double distance = MathHelper.func_76133_a(xOffset * xOffset + zOffset * zOffset);
        final float xyAngle = (float)(Math.atan2(zOffset, xOffset) * 180.0 / 3.141592653589793) - 90.0f;
        final float zdAngle = (float)(-(Math.atan2(yOffset, distance) * 180.0 / 3.141592653589793));
        this.headEntity.field_70125_A = -this.updateRotation(this.headEntity.field_70125_A, zdAngle, pitchConstraint);
        this.headEntity.field_70177_z = this.updateRotation(this.headEntity.field_70177_z, xyAngle, yawConstraint);
    }
    
    private float updateRotation(final float current, final float intended, final float increment) {
        float delta = MathHelper.func_76142_g(intended - current);
        if (delta > increment) {
            delta = increment;
        }
        if (delta < -increment) {
            delta = -increment;
        }
        return MathHelper.func_76142_g(current + delta);
    }
    
    @Nullable
    public Entity getTargetEntity() {
        return this.targetEntity;
    }
    
    public void setTargetEntity(@Nullable final Entity targetEntity) {
        this.targetEntity = targetEntity;
    }
    
    public void setHurtTime(final int hurtTime) {
        if (this.headEntity != null) {
            this.headEntity.field_70737_aN = hurtTime;
        }
        this.necka.field_70737_aN = hurtTime;
        this.neckb.field_70737_aN = hurtTime;
        this.neckc.field_70737_aN = hurtTime;
        this.neckd.field_70737_aN = hurtTime;
        this.necke.field_70737_aN = hurtTime;
    }
    
    public boolean shouldRenderHead() {
        return this.headEntity.getState() != State.DEAD && this.headEntity.field_70725_aQ < 20;
    }
    
    public boolean shouldRenderNeck(final int neckNum) {
        final int time = 30 + 10 * neckNum;
        return this.headEntity.getState() != State.DEAD && this.headEntity.field_70725_aQ < time;
    }
    
    public boolean isActive() {
        return this.currentState != State.DYING && this.currentState != State.DEAD;
    }
    
    public boolean isIdle() {
        return this.currentState == State.IDLE && (this.nextState == HydraHeadContainer.NEXT_AUTOMATIC || this.nextState == State.IDLE);
    }
    
    public boolean isAttacking() {
        return this.currentState == State.BITE_BEGINNING || this.currentState == State.BITE_READY || this.currentState == State.BITING || this.currentState == State.FLAME_BEGINNING || this.currentState == State.FLAMING || this.currentState == State.MORTAR_BEGINNING || this.currentState == State.MORTAR_SHOOTING;
    }
    
    public boolean isBiting() {
        return this.currentState == State.BITE_BEGINNING || this.currentState == State.BITE_READY || this.currentState == State.BITING || this.nextState == State.BITE_BEGINNING;
    }
    
    public void addDamage(final float damageAmount) {
        this.damageTaken += (int)damageAmount;
    }
    
    public int getDamageTaken() {
        return this.damageTaken;
    }
    
    public void setRespawnCounter(final int count) {
        this.respawnCounter = count;
    }
    
    static {
        HydraHeadContainer.FLAME_BREATH_TRACKING_SPEED = 0.04;
        NEXT_AUTOMATIC = null;
    }
    
    enum State
    {
        IDLE(10), 
        BITE_BEGINNING(40), 
        BITE_READY(80), 
        BITING(7), 
        BITE_ENDING(40), 
        FLAME_BEGINNING(40), 
        FLAMING(100), 
        FLAME_ENDING(30), 
        MORTAR_BEGINNING(40), 
        MORTAR_SHOOTING(25), 
        MORTAR_ENDING(30), 
        DYING(70), 
        DEAD(20), 
        ATTACK_COOLDOWN(80), 
        BORN(20), 
        ROAR_START(10), 
        ROAR_RAWR(50);
        
        private static final Map<State, State> NEXT_STATE;
        public final int duration;
        
        private State(final int duration) {
            this.duration = duration;
        }
        
        static {
            final EnumMap<State, State> b = new EnumMap<State, State>(State.class);
            b.put(State.IDLE, State.IDLE);
            b.put(State.BITE_BEGINNING, State.BITE_READY);
            b.put(State.BITE_READY, State.BITING);
            b.put(State.BITING, State.BITE_ENDING);
            b.put(State.BITE_ENDING, State.ATTACK_COOLDOWN);
            b.put(State.FLAME_BEGINNING, State.FLAMING);
            b.put(State.FLAMING, State.FLAME_ENDING);
            b.put(State.FLAME_ENDING, State.ATTACK_COOLDOWN);
            b.put(State.MORTAR_BEGINNING, State.MORTAR_SHOOTING);
            b.put(State.MORTAR_SHOOTING, State.MORTAR_ENDING);
            b.put(State.MORTAR_ENDING, State.ATTACK_COOLDOWN);
            b.put(State.ATTACK_COOLDOWN, State.IDLE);
            b.put(State.DYING, State.DEAD);
            b.put(State.DEAD, State.DEAD);
            b.put(State.BORN, State.ROAR_START);
            b.put(State.ROAR_START, State.ROAR_RAWR);
            b.put(State.ROAR_RAWR, State.IDLE);
            NEXT_STATE = (Map)ImmutableMap.copyOf((Map)b);
        }
    }
}
