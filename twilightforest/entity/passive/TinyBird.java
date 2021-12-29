// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.passive;

import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.Direction;
import net.minecraft.tags.Tag;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import net.minecraft.core.Vec3i;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.damagesource.DamageSource;
import twilightforest.TFSounds;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.animal.Ocelot;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.animal.Cat;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import twilightforest.entity.ai.TinyBirdFlyGoal;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;
import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;

public class TinyBird extends Bird
{
    private static final EntityDataAccessor<Byte> DATA_BIRDTYPE;
    private static final EntityDataAccessor<Byte> DATA_BIRDFLAGS;
    private BlockPos spawnPosition;
    private int currentFlightTime;
    
    public TinyBird(final EntityType<? extends TinyBird> type, final Level world) {
        super(type, world);
        this.setBirdType(this.f_19796_.nextInt(4));
        this.setIsBirdLanded(true);
        this.m_146762_(0);
    }
    
    protected void m_8099_() {
        this.f_21345_.m_25352_(0, (Goal)new FloatGoal((Mob)this));
        this.f_21345_.m_25352_(1, (Goal)new PanicGoal((PathfinderMob)this, 1.5));
        this.f_21345_.m_25352_(2, (Goal)new TinyBirdFlyGoal(this));
        this.f_21345_.m_25352_(3, (Goal)new TemptGoal((PathfinderMob)this, 1.0, TinyBird.SEEDS, true));
        this.f_21345_.m_25352_(4, (Goal)new AvoidEntityGoal((PathfinderMob)this, (Class)Cat.class, 8.0f, 1.0, 1.25));
        this.f_21345_.m_25352_(4, (Goal)new AvoidEntityGoal((PathfinderMob)this, (Class)Ocelot.class, 8.0f, 1.0, 1.25));
        this.f_21345_.m_25352_(5, (Goal)new WaterAvoidingRandomStrollGoal((PathfinderMob)this, 1.0));
        this.f_21345_.m_25352_(6, (Goal)new LookAtPlayerGoal((Mob)this, (Class)Player.class, 6.0f));
        this.f_21345_.m_25352_(7, (Goal)new RandomLookAroundGoal((Mob)this));
    }
    
    protected void m_8097_() {
        super.m_8097_();
        this.f_19804_.m_135372_((EntityDataAccessor)TinyBird.DATA_BIRDTYPE, (Object)0);
        this.f_19804_.m_135372_((EntityDataAccessor)TinyBird.DATA_BIRDFLAGS, (Object)0);
    }
    
    public static AttributeSupplier.Builder registerAttributes() {
        return Mob.m_21552_().m_22268_(Attributes.f_22276_, 1.0).m_22268_(Attributes.f_22279_, 0.20000001192092895);
    }
    
    public void m_7380_(final CompoundTag compound) {
        super.m_7380_(compound);
        compound.m_128405_("BirdType", this.getBirdType());
    }
    
    public void m_7378_(final CompoundTag compound) {
        super.m_7378_(compound);
        this.setBirdType(compound.m_128451_("BirdType"));
    }
    
    public int getBirdType() {
        return (byte)this.f_19804_.m_135370_((EntityDataAccessor)TinyBird.DATA_BIRDTYPE);
    }
    
    public void setBirdType(final int type) {
        this.f_19804_.m_135381_((EntityDataAccessor)TinyBird.DATA_BIRDTYPE, (Object)(byte)type);
    }
    
    protected SoundEvent m_7515_() {
        return TFSounds.TINYBIRD_CHIRP;
    }
    
    protected SoundEvent m_7975_(final DamageSource source) {
        return TFSounds.TINYBIRD_HURT;
    }
    
    protected SoundEvent m_5592_() {
        return TFSounds.TINYBIRD_HURT;
    }
    
    public float m_20236_(final Pose pose) {
        return this.m_20206_() * 0.7f;
    }
    
    public boolean m_6785_(final double p_213397_1_) {
        return false;
    }
    
    public float m_21692_(final BlockPos pos) {
        final Material underMaterial = this.f_19853_.m_8055_(pos.m_7495_()).m_60767_();
        if (underMaterial == Material.f_76274_) {
            return 200.0f;
        }
        if (underMaterial == Material.f_76320_) {
            return 15.0f;
        }
        if (underMaterial == Material.f_76315_) {
            return 9.0f;
        }
        return this.f_19853_.m_46803_(pos) - 0.5f;
    }
    
    public void m_8119_() {
        super.m_8119_();
        if (!this.isBirdLanded()) {
            this.m_20256_(this.m_20184_().m_82542_(1.0, 0.6000000238418579, 1.0));
        }
    }
    
    protected void m_8024_() {
        super.m_8024_();
        if (this.isBirdLanded()) {
            this.currentFlightTime = 0;
            if (this.isSpooked() || this.m_20069_() || this.f_19853_.m_46855_(this.m_142469_()) || (this.f_19796_.nextInt(200) == 0 && !this.isLandableBlock(new BlockPos(this.m_20185_(), this.m_20186_() - 1.0, this.m_20189_())))) {
                this.setIsBirdLanded(false);
                this.f_19853_.m_46796_(1025, new BlockPos((Vec3i)this.m_142538_()), 0);
                this.m_20334_(this.m_20184_().m_7096_(), 0.4000000059604645, this.m_20184_().m_7094_());
            }
        }
        else {
            ++this.currentFlightTime;
            if (this.spawnPosition != null && (!this.f_19853_.m_46859_(this.spawnPosition) || this.spawnPosition.m_123342_() < 1)) {
                this.spawnPosition = null;
            }
            if (this.m_20069_() || this.f_19853_.m_46855_(this.m_142469_())) {
                this.currentFlightTime = 0;
                this.m_20334_(this.m_20184_().m_7096_(), 0.10000000149011612, this.m_20184_().m_7094_());
            }
            if (this.spawnPosition == null || this.f_19796_.nextInt(30) == 0 || this.spawnPosition.m_123331_(new Vec3i((int)this.m_20185_(), (int)this.m_20186_(), (int)this.m_20189_())) < 4.0) {
                final int yTarget = (this.currentFlightTime < 100) ? 2 : 4;
                this.spawnPosition = new BlockPos((int)this.m_20185_() + this.f_19796_.nextInt(7) - this.f_19796_.nextInt(7), (int)this.m_20186_() + this.f_19796_.nextInt(6) - yTarget, (int)this.m_20189_() + this.f_19796_.nextInt(7) - this.f_19796_.nextInt(7));
            }
            final double d0 = this.spawnPosition.m_123341_() + 0.5 - this.m_20185_();
            final double d2 = this.spawnPosition.m_123342_() + 0.1 - this.m_20186_();
            final double d3 = this.spawnPosition.m_123343_() + 0.5 - this.m_20189_();
            this.m_20184_().m_82549_(new Vec3((Math.signum(d0) * 0.5 - this.m_20184_().m_7096_()) * 0.10000000149011612, (Math.signum(d2) * 0.699999988079071 - this.m_20184_().m_7098_()) * 0.10000000149011612, (Math.signum(d3) * 0.5 - this.m_20184_().m_7094_()) * 0.10000000149011612));
            final float f = (float)(Mth.m_14136_(this.m_20184_().m_7094_(), this.m_20184_().m_7096_()) * 57.29577951308232) - 90.0f;
            final float f2 = Mth.m_14177_(f - this.m_146908_());
            this.f_20902_ = 0.5f;
            this.m_146922_(this.m_146908_() + f2);
            if (this.f_19796_.nextInt(100) == 0 && this.isLandableBlock(new BlockPos(this.m_20185_(), this.m_20186_() - 1.0, this.m_20189_()))) {
                this.setIsBirdLanded(true);
                this.m_20334_(this.m_20184_().m_7096_(), 0.0, this.m_20184_().m_7094_());
            }
        }
    }
    
    public boolean isSpooked() {
        if (this.f_20916_ > 0) {
            return true;
        }
        final Player closestPlayer = this.f_19853_.m_45930_((Entity)this, 4.0);
        return closestPlayer != null && !TinyBird.SEEDS.test(closestPlayer.m_21205_()) && !TinyBird.SEEDS.test(closestPlayer.m_21206_());
    }
    
    public boolean isLandableBlock(final BlockPos pos) {
        final BlockState state = this.f_19853_.m_8055_(pos);
        return !state.m_60795_() && (state.m_60620_((Tag)BlockTags.f_13035_) || state.m_60783_((BlockGetter)this.f_19853_, pos, Direction.UP));
    }
    
    @Override
    public boolean isBirdLanded() {
        return ((byte)this.f_19804_.m_135370_((EntityDataAccessor)TinyBird.DATA_BIRDFLAGS) & 0x1) != 0x0;
    }
    
    public void setIsBirdLanded(final boolean landed) {
        final byte flags = (byte)this.f_19804_.m_135370_((EntityDataAccessor)TinyBird.DATA_BIRDFLAGS);
        this.f_19804_.m_135381_((EntityDataAccessor)TinyBird.DATA_BIRDFLAGS, (Object)(byte)(landed ? (flags | 0x1) : (flags & 0xFFFFFFFE)));
    }
    
    public boolean m_6094_() {
        return false;
    }
    
    protected void m_7324_(final Entity entity) {
    }
    
    protected boolean m_7341_(final Entity entityIn) {
        return false;
    }
    
    protected void m_6138_() {
    }
    
    public boolean m_6162_() {
        return false;
    }
    
    static {
        DATA_BIRDTYPE = SynchedEntityData.m_135353_((Class)TinyBird.class, EntityDataSerializers.f_135027_);
        DATA_BIRDFLAGS = SynchedEntityData.m_135353_((Class)TinyBird.class, EntityDataSerializers.f_135027_);
    }
}
