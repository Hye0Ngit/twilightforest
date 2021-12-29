// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.boss;

import com.google.common.collect.ImmutableMap;
import javax.annotation.Nullable;
import java.util.Optional;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.Difficulty;
import java.util.Iterator;
import java.util.List;
import twilightforest.util.TFDamageSources;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.core.Vec3i;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import twilightforest.entity.TFEntities;
import twilightforest.TFSounds;
import twilightforest.client.particle.TFParticleType;
import net.minecraft.world.phys.Vec3;
import net.minecraft.util.Mth;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import java.util.EnumMap;
import java.util.Objects;
import java.util.Map;
import net.minecraft.world.entity.Entity;

public class HydraHeadContainer
{
    private static final int FLAME_BURN_FACTOR = 3;
    private static final int FLAME_DAMAGE = 19;
    private static final int BITE_DAMAGE = 48;
    private static double FLAME_BREATH_TRACKING_SPEED;
    private static final State NEXT_AUTOMATIC;
    public final HydraHead headEntity;
    public final HydraNeck necka;
    public final HydraNeck neckb;
    public final HydraNeck neckc;
    public final HydraNeck neckd;
    public final HydraNeck necke;
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
    private final Hydra hydra;
    private final Map<State, Float>[] stateNeckLength;
    private final Map<State, Float>[] stateXRotations;
    private final Map<State, Float>[] stateYRotations;
    private final Map<State, Float>[] stateMouthOpen;
    
    public HydraHeadContainer(final Hydra hydra, final int number, final boolean startActive) {
        this.headNum = number;
        this.hydra = hydra;
        this.damageTaken = 0;
        this.respawnCounter = -1;
        (this.headEntity = new HydraHead(hydra)).m_6034_(hydra.m_20185_(), hydra.m_20186_(), hydra.m_20189_());
        this.necka = new HydraNeck(this.headEntity);
        this.neckb = new HydraNeck(this.headEntity);
        this.neckc = new HydraNeck(this.headEntity);
        this.neckd = new HydraNeck(this.headEntity);
        this.necke = new HydraNeck(this.headEntity);
        Objects.requireNonNull(this.hydra);
        this.stateNeckLength = new Map[7];
        Objects.requireNonNull(this.hydra);
        this.stateXRotations = new Map[7];
        Objects.requireNonNull(this.hydra);
        this.stateYRotations = new Map[7];
        Objects.requireNonNull(this.hydra);
        this.stateMouthOpen = new Map[7];
        int i = 0;
        while (true) {
            final int n = i;
            Objects.requireNonNull(this.hydra);
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
    
    public HydraNeck[] getNeckArray() {
        return new HydraNeck[] { this.necka, this.neckb, this.neckc, this.neckd, this.necke };
    }
    
    public void tick() {
        this.headEntity.m_8119_();
        this.necka.m_8119_();
        this.neckb.m_8119_();
        this.neckc.m_8119_();
        this.neckd.m_8119_();
        this.necke.m_8119_();
        this.setDifficultyVariables();
        if (!this.hydra.f_19853_.f_46443_) {
            if (this.isActive() && this.headEntity.f_19815_.f_20377_ == 0.0f) {
                this.headEntity.activate();
                this.necka.activate();
                this.neckb.activate();
                this.neckc.activate();
                this.neckd.activate();
                this.necke.activate();
            }
            else if (!this.isActive() && this.headEntity.f_19815_.f_20377_ > 0.0f) {
                this.headEntity.deactivate();
                this.necka.deactivate();
                this.neckb.deactivate();
                this.neckc.deactivate();
                this.neckd.deactivate();
                this.necke.deactivate();
            }
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
            final HydraHead headEntity = this.headEntity;
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
            final HydraHead headEntity2 = this.headEntity;
            Objects.requireNonNull(this.headEntity);
            headEntity2.health = 1000.0f;
        }
    }
    
    private void doExplosionOn(final HydraPart part, final boolean large) {
        for (int i = 0; i < 10; ++i) {
            final double vx = part.f_19853_.f_46441_.nextGaussian() * 0.02;
            final double vy = part.f_19853_.f_46441_.nextGaussian() * 0.02;
            final double vz = part.f_19853_.f_46441_.nextGaussian() * 0.02;
            part.f_19853_.m_7106_((ParticleOptions)((part.f_19853_.f_46441_.nextInt(5) == 0 || large) ? ParticleTypes.f_123812_ : ParticleTypes.f_123813_), part.m_20185_() + part.f_19853_.f_46441_.nextFloat() * part.m_20205_() * 2.0f - part.m_20205_(), part.m_20186_() + part.f_19853_.f_46441_.nextFloat() * part.m_20206_(), part.m_20189_() + part.f_19853_.f_46441_.nextFloat() * part.m_20205_() * 2.0f - part.m_20205_(), vx, vy, vz);
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
            this.faceEntity(this.targetEntity, 5.0f, (float)this.hydra.m_8132_());
            float biteMaxYaw = -60.0f;
            float biteMinYaw = -90.0f;
            if (this.headNum == 2) {
                biteMaxYaw = 60.0f;
                biteMinYaw = 90.0f;
            }
            final float yawOffOffset = Mth.m_14177_(this.headEntity.m_146908_() - this.hydra.f_20883_);
            if (yawOffOffset > biteMaxYaw) {
                this.headEntity.m_146922_(this.hydra.f_20883_ + biteMaxYaw);
            }
            if (yawOffOffset < biteMinYaw) {
                this.headEntity.m_146922_(this.hydra.f_20883_ + biteMinYaw);
            }
            final Vec3 look = this.headEntity.m_20154_();
            final double distance = 16.0;
            this.targetX = this.headEntity.m_20185_() + look.f_82479_ * distance;
            this.targetY = this.headEntity.m_20186_() + 1.5 + look.f_82480_ * distance;
            this.targetZ = this.headEntity.m_20189_() + look.f_82481_ * distance;
        }
        else if (this.currentState == State.BITING || this.currentState == State.BITE_ENDING) {
            this.faceEntity(this.targetEntity, 5.0f, (float)this.hydra.m_8132_());
            this.headEntity.m_146926_((float)(this.headEntity.m_146909_() + 0.7853981633974483));
        }
        else if (this.currentState == State.ROAR_RAWR) {
            this.faceVec(this.targetX, this.targetY, this.targetZ, 10.0f, (float)this.hydra.m_8132_());
        }
        else if (this.currentState == State.FLAMING || this.currentState == State.FLAME_BEGINNING) {
            this.moveTargetCoordsTowardsTargetEntity(HydraHeadContainer.FLAME_BREATH_TRACKING_SPEED);
            this.faceVec(this.targetX, this.targetY, this.targetZ, 5.0f, (float)this.hydra.m_8132_());
        }
        else if (this.isActive()) {
            if (this.targetEntity != null) {
                this.faceEntity(this.targetEntity, 5.0f, (float)this.hydra.m_8132_());
            }
            else {
                this.faceIdle(1.5f, (float)this.hydra.m_8132_());
            }
        }
    }
    
    private void moveTargetCoordsTowardsTargetEntity(final double distance) {
        if (this.targetEntity != null) {
            Vec3 vect = new Vec3(this.targetEntity.m_20185_() - this.targetX, this.targetEntity.m_20186_() - this.targetY, this.targetEntity.m_20189_() - this.targetZ);
            vect = vect.m_82541_();
            this.targetX += vect.f_82479_ * distance;
            this.targetY += vect.f_82480_ * distance;
            this.targetZ += vect.f_82481_ * distance;
        }
    }
    
    private void addMouthParticles() {
        final Vec3 vector = this.headEntity.m_20154_();
        final double dist = 3.5;
        final double px = this.headEntity.m_20185_() + vector.f_82479_ * dist;
        final double py = this.headEntity.m_20186_() + 1.0 + vector.f_82480_ * dist;
        final double pz = this.headEntity.m_20189_() + vector.f_82481_ * dist;
        if (this.headEntity.getState() == State.FLAME_BEGINNING) {
            this.headEntity.f_19853_.m_7106_((ParticleOptions)ParticleTypes.f_123744_, px + this.headEntity.f_19853_.f_46441_.nextDouble() - 0.5, py + this.headEntity.f_19853_.f_46441_.nextDouble() - 0.5, pz + this.headEntity.f_19853_.f_46441_.nextDouble() - 0.5, 0.0, 0.0, 0.0);
            this.headEntity.f_19853_.m_7106_((ParticleOptions)ParticleTypes.f_123762_, px + this.headEntity.f_19853_.f_46441_.nextDouble() - 0.5, py + this.headEntity.f_19853_.f_46441_.nextDouble() - 0.5, pz + this.headEntity.f_19853_.f_46441_.nextDouble() - 0.5, 0.0, 0.0, 0.0);
        }
        if (this.headEntity.getState() == State.FLAMING) {
            final Vec3 look = this.headEntity.m_20154_();
            for (int i = 0; i < 5; ++i) {
                double dx = look.f_82479_;
                double dy = look.f_82480_;
                double dz = look.f_82481_;
                final double spread = 5.0 + this.headEntity.f_19853_.f_46441_.nextDouble() * 2.5;
                final double velocity = 1.0 + this.headEntity.f_19853_.f_46441_.nextDouble();
                dx += this.headEntity.f_19853_.f_46441_.nextGaussian() * 0.007499999832361937 * spread;
                dy += this.headEntity.f_19853_.f_46441_.nextGaussian() * 0.007499999832361937 * spread;
                dz += this.headEntity.f_19853_.f_46441_.nextGaussian() * 0.007499999832361937 * spread;
                dx *= velocity;
                dy *= velocity;
                dz *= velocity;
                this.headEntity.f_19853_.m_7106_((ParticleOptions)TFParticleType.LARGE_FLAME.get(), px, py, pz, dx, dy, dz);
            }
        }
        if (this.headEntity.getState() == State.BITE_BEGINNING || this.headEntity.getState() == State.BITE_READY) {
            this.headEntity.f_19853_.m_7106_((ParticleOptions)ParticleTypes.f_123769_, px + this.headEntity.f_19853_.f_46441_.nextDouble() - 0.5, py + this.headEntity.f_19853_.f_46441_.nextDouble() - 0.5, pz + this.headEntity.f_19853_.f_46441_.nextDouble() - 0.5, 0.0, 0.0, 0.0);
        }
        if (this.headEntity.getState() == State.MORTAR_BEGINNING) {
            this.headEntity.f_19853_.m_7106_((ParticleOptions)ParticleTypes.f_123755_, px + this.headEntity.f_19853_.f_46441_.nextDouble() - 0.5, py + this.headEntity.f_19853_.f_46441_.nextDouble() - 0.5, pz + this.headEntity.f_19853_.f_46441_.nextDouble() - 0.5, 0.0, 0.0, 0.0);
        }
    }
    
    private void playSounds() {
        if (this.headEntity.getState() == State.FLAMING && this.headEntity.f_19797_ % 5 == 0) {
            this.headEntity.m_5496_(TFSounds.HYDRA_SHOOT, 0.5f + this.headEntity.f_19853_.f_46441_.nextFloat(), this.headEntity.f_19853_.f_46441_.nextFloat() * 0.7f + 0.3f);
        }
        if (this.headEntity.getState() == State.ROAR_RAWR) {
            this.headEntity.m_5496_(TFSounds.HYDRA_ROAR, 1.25f, this.headEntity.f_19853_.f_46441_.nextFloat() * 0.3f + 0.7f);
        }
        if (this.headEntity.getState() == State.BITE_READY && this.ticksProgress == 60) {
            this.headEntity.m_5496_(TFSounds.HYDRA_WARN, 2.0f, this.headEntity.f_19853_.f_46441_.nextFloat() * 0.3f + 0.7f);
        }
    }
    
    protected void setNeckPosition() {
        Vec3 vector = null;
        float neckRotation = 0.0f;
        if (this.headNum == 0) {
            vector = new Vec3(0.0, 3.0, -1.0);
            neckRotation = 0.0f;
        }
        if (this.headNum == 1) {
            vector = new Vec3(-1.0, 3.0, 3.0);
            neckRotation = 90.0f;
        }
        if (this.headNum == 2) {
            vector = new Vec3(1.0, 3.0, 3.0);
            neckRotation = -90.0f;
        }
        if (this.headNum == 3) {
            vector = new Vec3(-1.0, 3.0, 3.0);
            neckRotation = 135.0f;
        }
        if (this.headNum == 4) {
            vector = new Vec3(1.0, 3.0, 3.0);
            neckRotation = -135.0f;
        }
        if (this.headNum == 5) {
            vector = new Vec3(-1.0, 3.0, 5.0);
            neckRotation = 135.0f;
        }
        if (this.headNum == 6) {
            vector = new Vec3(1.0, 3.0, 5.0);
            neckRotation = -135.0f;
        }
        vector = vector.m_82524_(-(this.hydra.f_20883_ + neckRotation) * 3.141593f / 180.0f);
        this.setNeckPosition(this.hydra.m_20185_() + vector.f_82479_, this.hydra.m_20186_() + vector.f_82480_, this.hydra.m_20189_() + vector.f_82481_, this.hydra.f_20883_, 0.0f);
    }
    
    protected void setHeadPosition() {
        final float neckLength = this.getCurrentNeckLength();
        final float xRotation = this.getCurrentHeadXRotation();
        final float yRotation = this.getCurrentHeadYRotation();
        final float periodX = (this.headNum == 0 || this.headNum == 3) ? 20.0f : ((this.headNum == 1 || this.headNum == 4) ? 5.0f : 7.0f);
        final float periodY = (this.headNum == 0 || this.headNum == 4) ? 10.0f : ((this.headNum == 1 || this.headNum == 6) ? 6.0f : 5.0f);
        float xSwing = Mth.m_14031_(this.hydra.f_19797_ / periodX) * 3.0f;
        float ySwing = Mth.m_14031_(this.hydra.f_19797_ / periodY) * 5.0f;
        if (!this.isActive()) {
            ySwing = (xSwing = 0.0f);
        }
        Vec3 vector = new Vec3(0.0, 0.0, (double)neckLength);
        vector = vector.m_82496_((xRotation * 3.141593f + xSwing) / 180.0f);
        vector = vector.m_82524_(-(this.hydra.f_20883_ + yRotation + ySwing) * 3.141593f / 180.0f);
        final double dx = this.hydra.m_20185_() + vector.f_82479_;
        final double dy = this.hydra.m_20186_() + vector.f_82480_ + 3.0;
        final double dz = this.hydra.m_20189_() + vector.f_82481_;
        this.headEntity.m_6034_(dx, dy, dz);
        this.headEntity.setMouthOpen(this.getCurrentMouthOpen());
    }
    
    private void executeAttacks() {
        if (this.currentState == State.MORTAR_SHOOTING && this.ticksProgress % 10 == 0) {
            final HydraMortarHead mortar = new HydraMortarHead(TFEntities.HYDRA_MORTAR, this.headEntity.f_19853_, this.headEntity);
            if (this.targetEntity != null && !this.headEntity.canEntityBeSeen(this.targetEntity)) {
                mortar.setToBlasting();
            }
            this.headEntity.f_19853_.m_46796_(1016, new BlockPos((Vec3i)this.headEntity.m_142538_()), 0);
            this.headEntity.f_19853_.m_7967_((Entity)mortar);
        }
        if (this.headEntity.getState() == State.BITING) {
            final List<Entity> nearbyList = this.headEntity.f_19853_.m_45933_((Entity)this.headEntity, this.headEntity.m_142469_().m_82377_(0.0, 1.0, 0.0));
            for (final Entity nearby : nearbyList) {
                if (nearby instanceof LivingEntity && nearby != this.hydra) {
                    nearby.m_6469_(TFDamageSources.HYDRA_BITE, 48.0f);
                }
            }
        }
        if (this.headEntity.getState() == State.FLAMING) {
            final Entity target = this.getHeadLookTarget();
            if (target != null && target != this.headEntity.getParent() && (!(target instanceof HydraPart) || ((HydraPart)target).getParent() != this.headEntity.getParent()) && !target.m_5825_() && target.m_6469_(TFDamageSources.HYDRA_FIRE, 19.0f)) {
                target.m_20254_(3);
            }
        }
    }
    
    private void setDifficultyVariables() {
        if (this.hydra.f_19853_.m_46791_() != Difficulty.HARD) {
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
        final Vec3 srcVec = new Vec3(this.headEntity.m_20185_(), this.headEntity.m_20186_() + 1.0, this.headEntity.m_20189_());
        final Vec3 lookVec = this.headEntity.m_20252_(1.0f);
        final BlockHitResult raytrace = this.headEntity.f_19853_.m_45547_(new ClipContext(srcVec, srcVec.m_82520_(lookVec.f_82479_ * range, lookVec.f_82480_ * range, lookVec.f_82481_ * range), ClipContext.Block.OUTLINE, ClipContext.Fluid.ANY, (Entity)this.headEntity));
        final BlockPos hitpos = (raytrace != null) ? raytrace.m_82425_() : null;
        final double rx = (hitpos == null) ? range : Math.min(range, Math.abs(this.headEntity.m_20185_() - hitpos.m_123341_()));
        final double ry = (hitpos == null) ? range : Math.min(range, Math.abs(this.headEntity.m_20186_() - hitpos.m_123342_()));
        final double rz = (hitpos == null) ? range : Math.min(range, Math.abs(this.headEntity.m_20189_() - hitpos.m_123343_()));
        final Vec3 destVec = srcVec.m_82520_(lookVec.f_82479_ * range, lookVec.f_82480_ * range, lookVec.f_82481_ * range);
        final float var9 = 3.0f;
        final List<Entity> possibleList = this.headEntity.f_19853_.m_45933_((Entity)this.headEntity, this.headEntity.m_142469_().m_82386_(lookVec.f_82479_ * rx, lookVec.f_82480_ * ry, lookVec.f_82481_ * rz).m_82377_((double)var9, (double)var9, (double)var9));
        double hitDist = 0.0;
        for (final Entity possibleEntity : possibleList) {
            if (possibleEntity.m_6087_() && possibleEntity != this.headEntity && possibleEntity != this.necka && possibleEntity != this.neckb && possibleEntity != this.neckc) {
                final float borderSize = possibleEntity.m_6143_();
                final AABB collisionBB = possibleEntity.m_142469_().m_82377_((double)borderSize, (double)borderSize, (double)borderSize);
                final Optional<Vec3> interceptPos = collisionBB.m_82371_(srcVec, destVec);
                if (collisionBB.m_82390_(srcVec)) {
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
                    final double possibleDist = srcVec.m_82554_((Vec3)interceptPos.get());
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
        return Mth.m_144920_(prevLength, curLength, progress);
    }
    
    private float getCurrentHeadXRotation() {
        final float prevRotation = this.stateXRotations[this.headNum].get(this.prevState);
        final float currentRotation = this.stateXRotations[this.headNum].get(this.currentState);
        final float progress = this.ticksProgress / (float)this.ticksNeeded;
        return Mth.m_144920_(prevRotation, currentRotation, progress);
    }
    
    private float getCurrentHeadYRotation() {
        final float prevRotation = this.stateYRotations[this.headNum].get(this.prevState);
        final float currentRotation = this.stateYRotations[this.headNum].get(this.currentState);
        final float progress = this.ticksProgress / (float)this.ticksNeeded;
        return Mth.m_144920_(prevRotation, currentRotation, progress);
    }
    
    protected float getCurrentMouthOpen() {
        final float prevOpen = this.stateMouthOpen[this.headNum].get(this.prevState);
        final float curOpen = this.stateMouthOpen[this.headNum].get(this.currentState);
        final float progress = this.ticksProgress / (float)this.ticksNeeded;
        return Mth.m_144920_(prevOpen, curOpen, progress);
    }
    
    protected void setNeckPosition(final double startX, final double startY, final double startZ, final float startYaw, final float startPitch) {
        double endX = this.headEntity.m_20185_();
        double endY = this.headEntity.m_20186_();
        double endZ = this.headEntity.m_20189_();
        float endYaw = this.headEntity.m_146908_();
        float endPitch = this.headEntity.m_146909_();
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
            final Vec3 vector = new Vec3(0.0, 0.0, -1.0).m_82524_(-endYaw * 3.141593f / 180.0f);
            endX += vector.f_82479_;
            endY += vector.f_82480_;
            endZ += vector.f_82481_;
        }
        else {
            final Vec3 vector = this.headEntity.m_20154_();
            final float dist = 1.0f;
            endX -= vector.f_82479_ * dist;
            endY -= vector.f_82480_ * dist;
            endZ -= vector.f_82481_ * dist;
        }
        float factor = 0.0f;
        this.necka.m_6034_(endX + (startX - endX) * factor, endY + (startY - endY) * factor, endZ + (startZ - endZ) * factor);
        this.necka.m_146922_(endYaw + (startYaw - endYaw) * factor);
        this.necka.m_146926_(endPitch + (startPitch - endPitch) * factor);
        factor = 0.25f;
        this.neckb.m_6034_(endX + (startX - endX) * factor, endY + (startY - endY) * factor, endZ + (startZ - endZ) * factor);
        this.neckb.m_146922_(endYaw + (startYaw - endYaw) * factor);
        this.neckb.m_146926_(endPitch + (startPitch - endPitch) * factor);
        factor = 0.5f;
        this.neckc.m_6034_(endX + (startX - endX) * factor, endY + (startY - endY) * factor, endZ + (startZ - endZ) * factor);
        this.neckc.m_146922_(endYaw + (startYaw - endYaw) * factor);
        this.neckc.m_146926_(endPitch + (startPitch - endPitch) * factor);
        factor = 0.75f;
        this.neckd.m_6034_(endX + (startX - endX) * factor, endY + (startY - endY) * factor, endZ + (startZ - endZ) * factor);
        this.neckd.m_146922_(endYaw + (startYaw - endYaw) * factor);
        this.neckd.m_146926_(endPitch + (startPitch - endPitch) * factor);
        factor = 1.0f;
        this.necke.m_6034_(endX + (startX - endX) * factor, endY + (startY - endY) * factor, endZ + (startZ - endZ) * factor);
        this.necke.m_146922_(endYaw + (startYaw - endYaw) * factor);
        this.necke.m_146926_(endPitch + (startPitch - endPitch) * factor);
    }
    
    private void faceIdle(final float yawConstraint, final float pitchConstraint) {
        final float angle = this.hydra.m_146908_() * 3.141593f / 180.0f;
        final float distance = 30.0f;
        final double dx = this.hydra.m_20185_() - Mth.m_14031_(angle) * distance;
        final double dy = this.hydra.m_20186_() + 3.0;
        final double dz = this.hydra.m_20189_() + Mth.m_14089_(angle) * distance;
        this.faceVec(dx, dy, dz, yawConstraint, pitchConstraint);
    }
    
    public void faceEntity(final Entity entity, final float yawConstraint, final float pitchConstraint) {
        double yTarget;
        if (entity instanceof final LivingEntity entityliving) {
            yTarget = entityliving.m_20186_() + entityliving.m_20192_();
        }
        else {
            yTarget = (entity.m_142469_().f_82289_ + entity.m_142469_().f_82292_) / 2.0;
        }
        this.faceVec(entity.m_20185_(), yTarget, entity.m_20189_(), yawConstraint, pitchConstraint);
        this.targetX = entity.m_20185_();
        this.targetY = entity.m_20186_();
        this.targetZ = entity.m_20189_();
    }
    
    private void faceVec(final double x, final double y, final double z, final float yawConstraint, final float pitchConstraint) {
        final double xOffset = x - this.headEntity.m_20185_();
        final double zOffset = z - this.headEntity.m_20189_();
        final double yOffset = this.headEntity.m_20186_() + 1.0 - y;
        final double distance = Mth.m_14116_((float)(xOffset * xOffset + zOffset * zOffset));
        final float xyAngle = (float)(Math.atan2(zOffset, xOffset) * 180.0 / 3.141592653589793) - 90.0f;
        final float zdAngle = (float)(-(Math.atan2(yOffset, distance) * 180.0 / 3.141592653589793));
        this.headEntity.m_146926_(-this.updateRotation(this.headEntity.m_146909_(), zdAngle, pitchConstraint));
        this.headEntity.m_146922_(this.updateRotation(this.headEntity.m_146908_(), xyAngle, yawConstraint));
    }
    
    private float updateRotation(final float current, final float intended, final float increment) {
        float delta = Mth.m_14177_(intended - current);
        if (delta > increment) {
            delta = increment;
        }
        if (delta < -increment) {
            delta = -increment;
        }
        return Mth.m_14177_(current + delta);
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
