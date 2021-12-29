// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.boss;

import com.google.common.collect.ImmutableMap;
import javax.annotation.Nullable;
import java.util.Optional;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.world.Difficulty;
import java.util.Iterator;
import java.util.List;
import twilightforest.util.TFDamageSources;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.EntityType;
import twilightforest.entity.TFEntities;
import twilightforest.TFSounds;
import twilightforest.client.particle.TFParticleType;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.MathHelper;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
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
    public final HydraHeadEntity headEntity;
    public final HydraNeckEntity necka;
    public final HydraNeckEntity neckb;
    public final HydraNeckEntity neckc;
    public final HydraNeckEntity neckd;
    public final HydraNeckEntity necke;
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
    private final HydraEntity hydra;
    private final Map<State, Float>[] stateNeckLength;
    private final Map<State, Float>[] stateXRotations;
    private final Map<State, Float>[] stateYRotations;
    private final Map<State, Float>[] stateMouthOpen;
    
    public HydraHeadContainer(final HydraEntity hydra, final int number, final boolean startActive) {
        this.headNum = number;
        this.hydra = hydra;
        this.damageTaken = 0;
        this.respawnCounter = -1;
        (this.headEntity = new HydraHeadEntity(hydra)).func_70107_b(hydra.func_226277_ct_(), hydra.func_226278_cu_(), hydra.func_226281_cx_());
        this.necka = new HydraNeckEntity(this.headEntity);
        this.neckb = new HydraNeckEntity(this.headEntity);
        this.neckc = new HydraNeckEntity(this.headEntity);
        this.neckd = new HydraNeckEntity(this.headEntity);
        this.necke = new HydraNeckEntity(this.headEntity);
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
        this.setHeadPosition();
        this.setNeckPosition();
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
    
    public HydraNeckEntity[] getNeckArray() {
        return new HydraNeckEntity[] { this.necka, this.neckb, this.neckc, this.neckd, this.necke };
    }
    
    public void tick() {
        this.headEntity.func_70071_h_();
        this.necka.func_70071_h_();
        this.neckb.func_70071_h_();
        this.neckc.func_70071_h_();
        this.neckd.func_70071_h_();
        this.necke.func_70071_h_();
        this.setDifficultyVariables();
        if (this.headEntity != null) {
            if (this.isActive() && this.headEntity.field_213325_aI.field_220315_a > 0.0f) {
                this.headEntity.activate();
            }
            else if (!this.isActive() && this.headEntity.field_213325_aI.field_220315_a != 0.0f) {
                this.headEntity.deactivate();
            }
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
            final HydraHeadEntity headEntity = this.headEntity;
            ++headEntity.deathTime;
            if (this.headEntity.deathTime > 0) {
                if (this.headEntity.deathTime < 20) {
                    this.doExplosionOn(this.headEntity, true);
                }
                else if (this.headEntity.deathTime < 30) {
                    this.doExplosionOn(this.necka, false);
                }
                else if (this.headEntity.deathTime < 40) {
                    this.doExplosionOn(this.neckb, false);
                }
                else if (this.headEntity.deathTime < 50) {
                    this.doExplosionOn(this.neckc, false);
                }
                else if (this.headEntity.deathTime < 60) {
                    this.doExplosionOn(this.neckd, false);
                }
                else if (this.headEntity.deathTime < 70) {
                    this.doExplosionOn(this.necke, false);
                }
            }
            this.necka.hurtTime = 20;
            this.neckb.hurtTime = 20;
            this.neckc.hurtTime = 20;
            this.neckd.hurtTime = 20;
            this.necke.hurtTime = 20;
        }
        else {
            this.headEntity.deathTime = 0;
            final HydraHeadEntity headEntity2 = this.headEntity;
            this.headEntity.getClass();
            headEntity2.health = 1000.0f;
        }
    }
    
    private void doExplosionOn(final HydraPartEntity part, final boolean large) {
        for (int i = 0; i < 10; ++i) {
            final double vx = part.field_70170_p.field_73012_v.nextGaussian() * 0.02;
            final double vy = part.field_70170_p.field_73012_v.nextGaussian() * 0.02;
            final double vz = part.field_70170_p.field_73012_v.nextGaussian() * 0.02;
            part.field_70170_p.func_195594_a((IParticleData)((part.field_70170_p.field_73012_v.nextInt(5) == 0 || large) ? ParticleTypes.field_197626_s : ParticleTypes.field_197627_t), part.func_226277_ct_() + part.field_70170_p.field_73012_v.nextFloat() * part.func_213311_cf() * 2.0f - part.func_213311_cf(), part.func_226278_cu_() + part.field_70170_p.field_73012_v.nextFloat() * part.func_213302_cg(), part.func_226281_cx_() + part.field_70170_p.field_73012_v.nextFloat() * part.func_213311_cf() * 2.0f - part.func_213311_cf(), vx, vy, vz);
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
            final Vector3d look = this.headEntity.func_70040_Z();
            final double distance = 16.0;
            this.targetX = this.headEntity.func_226277_ct_() + look.field_72450_a * distance;
            this.targetY = this.headEntity.func_226278_cu_() + 1.5 + look.field_72448_b * distance;
            this.targetZ = this.headEntity.func_226281_cx_() + look.field_72449_c * distance;
        }
        else if (this.currentState == State.BITING || this.currentState == State.BITE_ENDING) {
            this.faceEntity(this.targetEntity, 5.0f, (float)this.hydra.func_70646_bf());
            final HydraHeadEntity headEntity = this.headEntity;
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
            Vector3d vect = new Vector3d(this.targetEntity.func_226277_ct_() - this.targetX, this.targetEntity.func_226278_cu_() - this.targetY, this.targetEntity.func_226281_cx_() - this.targetZ);
            vect = vect.func_72432_b();
            this.targetX += vect.field_72450_a * distance;
            this.targetY += vect.field_72448_b * distance;
            this.targetZ += vect.field_72449_c * distance;
        }
    }
    
    private void addMouthParticles() {
        final Vector3d vector = this.headEntity.func_70040_Z();
        final double dist = 3.5;
        final double px = this.headEntity.func_226277_ct_() + vector.field_72450_a * dist;
        final double py = this.headEntity.func_226278_cu_() + 1.0 + vector.field_72448_b * dist;
        final double pz = this.headEntity.func_226281_cx_() + vector.field_72449_c * dist;
        if (this.headEntity.getState() == State.FLAME_BEGINNING) {
            this.headEntity.field_70170_p.func_195594_a((IParticleData)ParticleTypes.field_197631_x, px + this.headEntity.field_70170_p.field_73012_v.nextDouble() - 0.5, py + this.headEntity.field_70170_p.field_73012_v.nextDouble() - 0.5, pz + this.headEntity.field_70170_p.field_73012_v.nextDouble() - 0.5, 0.0, 0.0, 0.0);
            this.headEntity.field_70170_p.func_195594_a((IParticleData)ParticleTypes.field_197601_L, px + this.headEntity.field_70170_p.field_73012_v.nextDouble() - 0.5, py + this.headEntity.field_70170_p.field_73012_v.nextDouble() - 0.5, pz + this.headEntity.field_70170_p.field_73012_v.nextDouble() - 0.5, 0.0, 0.0, 0.0);
        }
        if (this.headEntity.getState() == State.FLAMING) {
            final Vector3d look = this.headEntity.func_70040_Z();
            for (int i = 0; i < 5; ++i) {
                double dx = look.field_72450_a;
                double dy = look.field_72448_b;
                double dz = look.field_72449_c;
                final double spread = 5.0 + this.headEntity.field_70170_p.field_73012_v.nextDouble() * 2.5;
                final double velocity = 1.0 + this.headEntity.field_70170_p.field_73012_v.nextDouble();
                dx += this.headEntity.field_70170_p.field_73012_v.nextGaussian() * 0.007499999832361937 * spread;
                dy += this.headEntity.field_70170_p.field_73012_v.nextGaussian() * 0.007499999832361937 * spread;
                dz += this.headEntity.field_70170_p.field_73012_v.nextGaussian() * 0.007499999832361937 * spread;
                dx *= velocity;
                dy *= velocity;
                dz *= velocity;
                this.headEntity.field_70170_p.func_195594_a((IParticleData)TFParticleType.LARGE_FLAME.get(), px, py, pz, dx, dy, dz);
            }
        }
        if (this.headEntity.getState() == State.BITE_BEGINNING || this.headEntity.getState() == State.BITE_READY) {
            this.headEntity.field_70170_p.func_195594_a((IParticleData)ParticleTypes.field_218422_X, px + this.headEntity.field_70170_p.field_73012_v.nextDouble() - 0.5, py + this.headEntity.field_70170_p.field_73012_v.nextDouble() - 0.5, pz + this.headEntity.field_70170_p.field_73012_v.nextDouble() - 0.5, 0.0, 0.0, 0.0);
        }
        if (this.headEntity.getState() == State.MORTAR_BEGINNING) {
            this.headEntity.field_70170_p.func_195594_a((IParticleData)ParticleTypes.field_197594_E, px + this.headEntity.field_70170_p.field_73012_v.nextDouble() - 0.5, py + this.headEntity.field_70170_p.field_73012_v.nextDouble() - 0.5, pz + this.headEntity.field_70170_p.field_73012_v.nextDouble() - 0.5, 0.0, 0.0, 0.0);
        }
    }
    
    private void playSounds() {
        if (this.headEntity.getState() == State.FLAMING && this.headEntity.field_70173_aa % 5 == 0) {
            this.headEntity.func_184185_a(TFSounds.HYDRA_SHOOT, 0.5f + this.headEntity.field_70170_p.field_73012_v.nextFloat(), this.headEntity.field_70170_p.field_73012_v.nextFloat() * 0.7f + 0.3f);
        }
        if (this.headEntity.getState() == State.ROAR_RAWR) {
            this.headEntity.func_184185_a(TFSounds.HYDRA_ROAR, 1.25f, this.headEntity.field_70170_p.field_73012_v.nextFloat() * 0.3f + 0.7f);
        }
        if (this.headEntity.getState() == State.BITE_READY && this.ticksProgress == 60) {
            this.headEntity.func_184185_a(TFSounds.HYDRA_WARN, 2.0f, this.headEntity.field_70170_p.field_73012_v.nextFloat() * 0.3f + 0.7f);
        }
    }
    
    protected void setNeckPosition() {
        Vector3d vector = null;
        float neckRotation = 0.0f;
        if (this.headNum == 0) {
            vector = new Vector3d(0.0, 3.0, -1.0);
            neckRotation = 0.0f;
        }
        if (this.headNum == 1) {
            vector = new Vector3d(-1.0, 3.0, 3.0);
            neckRotation = 90.0f;
        }
        if (this.headNum == 2) {
            vector = new Vector3d(1.0, 3.0, 3.0);
            neckRotation = -90.0f;
        }
        if (this.headNum == 3) {
            vector = new Vector3d(-1.0, 3.0, 3.0);
            neckRotation = 135.0f;
        }
        if (this.headNum == 4) {
            vector = new Vector3d(1.0, 3.0, 3.0);
            neckRotation = -135.0f;
        }
        if (this.headNum == 5) {
            vector = new Vector3d(-1.0, 3.0, 5.0);
            neckRotation = 135.0f;
        }
        if (this.headNum == 6) {
            vector = new Vector3d(1.0, 3.0, 5.0);
            neckRotation = -135.0f;
        }
        vector = vector.func_178785_b(-(this.hydra.field_70761_aq + neckRotation) * 3.141593f / 180.0f);
        this.setNeckPosition(this.hydra.func_226277_ct_() + vector.field_72450_a, this.hydra.func_226278_cu_() + vector.field_72448_b, this.hydra.func_226281_cx_() + vector.field_72449_c, this.hydra.field_70761_aq, 0.0f);
    }
    
    protected void setHeadPosition() {
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
        Vector3d vector = new Vector3d(0.0, 0.0, (double)neckLength);
        vector = vector.func_178789_a((xRotation * 3.141593f + xSwing) / 180.0f);
        vector = vector.func_178785_b(-(this.hydra.field_70761_aq + yRotation + ySwing) * 3.141593f / 180.0f);
        final double dx = this.hydra.func_226277_ct_() + vector.field_72450_a;
        final double dy = this.hydra.func_226278_cu_() + vector.field_72448_b + 3.0;
        final double dz = this.hydra.func_226281_cx_() + vector.field_72449_c;
        this.headEntity.func_70107_b(dx, dy, dz);
        this.headEntity.setMouthOpen(this.getCurrentMouthOpen());
    }
    
    private void executeAttacks() {
        if (this.currentState == State.MORTAR_SHOOTING && this.ticksProgress % 10 == 0) {
            final HydraMortarHead mortar = new HydraMortarHead(TFEntities.hydra_mortar, this.headEntity.field_70170_p, this.headEntity);
            if (this.targetEntity != null && !this.headEntity.canEntityBeSeen(this.targetEntity)) {
                mortar.setToBlasting();
            }
            this.headEntity.field_70170_p.func_217379_c(1016, new BlockPos((Vector3i)this.headEntity.func_233580_cy_()), 0);
            this.headEntity.field_70170_p.func_217376_c((Entity)mortar);
        }
        if (this.headEntity.getState() == State.BITING) {
            final List<Entity> nearbyList = this.headEntity.field_70170_p.func_72839_b((Entity)this.headEntity, this.headEntity.func_174813_aQ().func_72314_b(0.0, 1.0, 0.0));
            for (final Entity nearby : nearbyList) {
                if (nearby instanceof LivingEntity && nearby != this.hydra) {
                    nearby.func_70097_a(TFDamageSources.HYDRA_BITE, 48.0f);
                }
            }
        }
        if (this.headEntity.getState() == State.FLAMING) {
            final Entity target = this.getHeadLookTarget();
            if (target != null && target != this.headEntity.getParent() && (!(target instanceof HydraPartEntity) || ((HydraPartEntity)target).getParent() != this.headEntity.getParent()) && !target.func_230279_az_() && target.func_70097_a(TFDamageSources.HYDRA_FIRE, 19.0f)) {
                target.func_70015_d(3);
            }
        }
    }
    
    private void setDifficultyVariables() {
        if (this.hydra.field_70170_p.func_175659_aa() != Difficulty.HARD) {
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
        final Vector3d srcVec = new Vector3d(this.headEntity.func_226277_ct_(), this.headEntity.func_226278_cu_() + 1.0, this.headEntity.func_226281_cx_());
        final Vector3d lookVec = this.headEntity.func_70676_i(1.0f);
        final BlockRayTraceResult raytrace = this.headEntity.field_70170_p.func_217299_a(new RayTraceContext(srcVec, srcVec.func_72441_c(lookVec.field_72450_a * range, lookVec.field_72448_b * range, lookVec.field_72449_c * range), RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.ANY, (Entity)this.headEntity));
        final BlockPos hitpos = (raytrace != null) ? raytrace.func_216350_a() : null;
        final double rx = (hitpos == null) ? range : Math.min(range, Math.abs(this.headEntity.func_226277_ct_() - hitpos.func_177958_n()));
        final double ry = (hitpos == null) ? range : Math.min(range, Math.abs(this.headEntity.func_226278_cu_() - hitpos.func_177956_o()));
        final double rz = (hitpos == null) ? range : Math.min(range, Math.abs(this.headEntity.func_226281_cx_() - hitpos.func_177952_p()));
        final Vector3d destVec = srcVec.func_72441_c(lookVec.field_72450_a * range, lookVec.field_72448_b * range, lookVec.field_72449_c * range);
        final float var9 = 3.0f;
        final List<Entity> possibleList = this.headEntity.field_70170_p.func_72839_b((Entity)this.headEntity, this.headEntity.func_174813_aQ().func_72317_d(lookVec.field_72450_a * rx, lookVec.field_72448_b * ry, lookVec.field_72449_c * rz).func_72314_b((double)var9, (double)var9, (double)var9));
        double hitDist = 0.0;
        for (final Entity possibleEntity : possibleList) {
            if (possibleEntity.func_70067_L() && possibleEntity != this.headEntity && possibleEntity != this.necka && possibleEntity != this.neckb && possibleEntity != this.neckc) {
                final float borderSize = possibleEntity.func_70111_Y();
                final AxisAlignedBB collisionBB = possibleEntity.func_174813_aQ().func_72314_b((double)borderSize, (double)borderSize, (double)borderSize);
                final Optional<Vector3d> interceptPos = collisionBB.func_216365_b(srcVec, destVec);
                if (collisionBB.func_72318_a(srcVec)) {
                    if (0.0 >= hitDist && hitDist != 0.0) {
                        continue;
                    }
                    pointedEntity = possibleEntity;
                    hitDist = 0.0;
                }
                else {
                    if (!interceptPos.isPresent()) {
                        continue;
                    }
                    final double possibleDist = srcVec.func_72438_d((Vector3d)interceptPos.get());
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
        double endX = this.headEntity.func_226277_ct_();
        double endY = this.headEntity.func_226278_cu_();
        double endZ = this.headEntity.func_226281_cx_();
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
            final Vector3d vector = new Vector3d(0.0, 0.0, -1.0).func_178785_b(-endYaw * 3.141593f / 180.0f);
            endX += vector.field_72450_a;
            endY += vector.field_72448_b;
            endZ += vector.field_72449_c;
        }
        else {
            final Vector3d vector = this.headEntity.func_70040_Z();
            final float dist = 1.0f;
            endX -= vector.field_72450_a * dist;
            endY -= vector.field_72448_b * dist;
            endZ -= vector.field_72449_c * dist;
        }
        float factor = 0.0f;
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
        final double dx = this.hydra.func_226277_ct_() - MathHelper.func_76126_a(angle) * distance;
        final double dy = this.hydra.func_226278_cu_() + 3.0;
        final double dz = this.hydra.func_226281_cx_() + MathHelper.func_76134_b(angle) * distance;
        this.faceVec(dx, dy, dz, yawConstraint, pitchConstraint);
    }
    
    public void faceEntity(final Entity entity, final float yawConstraint, final float pitchConstraint) {
        double yTarget;
        if (entity instanceof LivingEntity) {
            final LivingEntity entityliving = (LivingEntity)entity;
            yTarget = entityliving.func_226278_cu_() + entityliving.func_70047_e();
        }
        else {
            yTarget = (entity.func_174813_aQ().field_72338_b + entity.func_174813_aQ().field_72337_e) / 2.0;
        }
        this.faceVec(entity.func_226277_ct_(), yTarget, entity.func_226281_cx_(), yawConstraint, pitchConstraint);
        this.targetX = entity.func_226277_ct_();
        this.targetY = entity.func_226278_cu_();
        this.targetZ = entity.func_226281_cx_();
    }
    
    private void faceVec(final double x, final double y, final double z, final float yawConstraint, final float pitchConstraint) {
        final double xOffset = x - this.headEntity.func_226277_ct_();
        final double zOffset = z - this.headEntity.func_226281_cx_();
        final double yOffset = this.headEntity.func_226278_cu_() + 1.0 - y;
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
    
    public void setTargetEntity(@Nullable final Entity targetEntity) {
        this.targetEntity = targetEntity;
    }
    
    public void setHurtTime(final int hurtTime) {
        if (this.headEntity != null) {
            this.headEntity.hurtTime = hurtTime;
        }
        this.necka.hurtTime = hurtTime;
        this.neckb.hurtTime = hurtTime;
        this.neckc.hurtTime = hurtTime;
        this.neckd.hurtTime = hurtTime;
        this.necke.hurtTime = hurtTime;
    }
    
    public boolean shouldRenderHead() {
        return this.headEntity.getState() != State.DEAD && this.headEntity.deathTime < 20;
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
