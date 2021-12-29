// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.ItemLike;
import javax.annotation.Nullable;
import javax.annotation.Nonnull;
import net.minecraftforge.fmllegacy.network.NetworkHooks;
import net.minecraft.network.protocol.Packet;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.entity.Entity;

@OnlyIn(value = Dist.CLIENT, _interface = ItemSupplier.class)
public class CharmEffect extends Entity implements ItemSupplier
{
    private static final EntityDataAccessor<Integer> DATA_OWNER;
    private static final EntityDataAccessor<ItemStack> DATA_ITEMID;
    private static final double DISTANCE = 0.75;
    private double interpTargetX;
    private double interpTargetY;
    private double interpTargetZ;
    private double interpTargetYaw;
    private double interpTargetPitch;
    private int newPosRotationIncrements;
    public float offset;
    
    public CharmEffect(final EntityType<? extends CharmEffect> type, final Level world) {
        super((EntityType)type, world);
    }
    
    public CharmEffect(final EntityType<? extends CharmEffect> type, final Level world, final LivingEntity owner, final Item item) {
        this(type, world);
        this.setOwner(owner);
        this.setItemID(item);
        this.m_7678_(owner.m_20185_(), owner.m_20186_() + owner.m_20192_(), owner.m_20189_(), owner.m_146908_(), owner.m_146909_());
        final Vec3 look = new Vec3(0.75, 0.0, 0.0);
        final double x = this.m_20185_() + look.f_82479_ * 0.75;
        final double z = this.m_20189_() + look.f_82481_ * 0.75;
        this.m_6034_(x, this.m_20186_(), z);
    }
    
    public void m_8119_() {
        this.f_19790_ = this.m_20185_();
        this.f_19791_ = this.m_20186_();
        this.f_19792_ = this.m_20189_();
        super.m_8119_();
        if (this.newPosRotationIncrements > 0) {
            final double d0 = this.m_20185_() + (this.interpTargetX - this.m_20185_()) / this.newPosRotationIncrements;
            final double d2 = this.m_20186_() + (this.interpTargetY - this.m_20186_()) / this.newPosRotationIncrements;
            final double d3 = this.m_20189_() + (this.interpTargetZ - this.m_20189_()) / this.newPosRotationIncrements;
            final double d4 = Mth.m_14175_(this.interpTargetYaw - this.m_146908_());
            this.m_146922_((float)(this.m_146908_() + d4 / this.newPosRotationIncrements));
            this.m_146926_((float)(this.m_146909_() + (this.interpTargetPitch - this.m_146909_()) / this.newPosRotationIncrements));
            --this.newPosRotationIncrements;
            this.m_6034_(d0, d2, d3);
            this.m_19915_(this.m_146908_(), this.m_146909_());
        }
        final LivingEntity orbiting = this.getOwner();
        if (orbiting != null) {
            final float rotation = this.f_19797_ / 10.0f + this.offset;
            final Vec3 look = new Vec3(0.75, 0.0, 0.0).m_82524_(rotation);
            this.m_7678_(orbiting.m_20185_() + look.f_82479_, orbiting.m_20186_() + orbiting.m_20192_(), orbiting.m_20189_() + look.f_82481_, orbiting.m_146908_(), orbiting.m_146909_());
        }
        if (!this.getItemID().m_41619_()) {
            for (int i = 0; i < 2; ++i) {
                final double dx = this.m_20185_() + 0.5 * (this.f_19796_.nextDouble() - this.f_19796_.nextDouble());
                final double dy = this.m_20186_() + 0.5 * (this.f_19796_.nextDouble() - this.f_19796_.nextDouble());
                final double dz = this.m_20189_() + 0.5 * (this.f_19796_.nextDouble() - this.f_19796_.nextDouble());
                this.f_19853_.m_7106_((ParticleOptions)new ItemParticleOption(ParticleTypes.f_123752_, this.getItemID()), dx, dy, dz, 0.0, 0.2, 0.0);
            }
        }
        if (!this.f_19853_.f_46443_ && (this.f_19797_ > 200 || (orbiting != null && !orbiting.m_6084_()))) {
            this.m_146870_();
        }
    }
    
    public void m_6453_(final double x, final double y, final double z, final float yaw, final float pitch, final int posRotationIncrements, final boolean teleport) {
        this.interpTargetX = x;
        this.interpTargetY = y;
        this.interpTargetZ = z;
        this.interpTargetYaw = yaw;
        this.interpTargetPitch = pitch;
        this.newPosRotationIncrements = posRotationIncrements;
    }
    
    @Nonnull
    public Packet<?> m_5654_() {
        return (Packet<?>)NetworkHooks.getEntitySpawningPacket((Entity)this);
    }
    
    protected void m_8097_() {
        this.f_19804_.m_135372_((EntityDataAccessor)CharmEffect.DATA_ITEMID, (Object)ItemStack.f_41583_);
        this.f_19804_.m_135372_((EntityDataAccessor)CharmEffect.DATA_OWNER, (Object)(-1));
    }
    
    public void setOwner(final LivingEntity owner) {
        this.f_19804_.m_135381_((EntityDataAccessor)CharmEffect.DATA_OWNER, (Object)owner.m_142049_());
    }
    
    @Nullable
    public LivingEntity getOwner() {
        final Entity e = this.f_19853_.m_6815_((int)this.f_19804_.m_135370_((EntityDataAccessor)CharmEffect.DATA_OWNER));
        if (e instanceof final LivingEntity livingEntity) {
            return livingEntity;
        }
        return null;
    }
    
    public ItemStack getItemID() {
        return (ItemStack)this.f_19804_.m_135370_((EntityDataAccessor)CharmEffect.DATA_ITEMID);
    }
    
    public void setItemID(final Item item) {
        this.f_19804_.m_135381_((EntityDataAccessor)CharmEffect.DATA_ITEMID, (Object)new ItemStack((ItemLike)item));
    }
    
    protected void m_7378_(final CompoundTag cmp) {
    }
    
    protected void m_7380_(final CompoundTag cmp) {
    }
    
    @Nonnull
    public ItemStack m_7846_() {
        return this.getItemID();
    }
    
    static {
        DATA_OWNER = SynchedEntityData.m_135353_((Class)CharmEffect.class, EntityDataSerializers.f_135028_);
        DATA_ITEMID = SynchedEntityData.m_135353_((Class)CharmEffect.class, EntityDataSerializers.f_135033_);
    }
}
