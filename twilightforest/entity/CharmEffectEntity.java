// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.IItemProvider;
import javax.annotation.Nullable;
import javax.annotation.Nonnull;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraft.network.IPacket;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ItemParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.item.Item;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemStack;
import net.minecraft.network.datasync.DataParameter;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.entity.IRendersAsItem;
import net.minecraft.entity.Entity;

@OnlyIn(value = Dist.CLIENT, _interface = IRendersAsItem.class)
public class CharmEffectEntity extends Entity implements IRendersAsItem
{
    private static final DataParameter<Integer> DATA_OWNER;
    private static final DataParameter<ItemStack> DATA_ITEMID;
    private static final double DISTANCE = 0.75;
    private double interpTargetX;
    private double interpTargetY;
    private double interpTargetZ;
    private double interpTargetYaw;
    private double interpTargetPitch;
    private int newPosRotationIncrements;
    public float offset;
    
    public CharmEffectEntity(final EntityType<? extends CharmEffectEntity> type, final World world) {
        super((EntityType)type, world);
    }
    
    public CharmEffectEntity(final EntityType<? extends CharmEffectEntity> type, final World world, final LivingEntity owner, final Item item) {
        this(type, world);
        this.setOwner(owner);
        this.setItemID(item);
        this.func_70012_b(owner.func_226277_ct_(), owner.func_226278_cu_() + owner.func_70047_e(), owner.func_226281_cx_(), owner.field_70177_z, owner.field_70125_A);
        final Vector3d look = new Vector3d(0.75, 0.0, 0.0);
        final double x = this.func_226277_ct_() + look.field_72450_a * 0.75;
        final double z = this.func_226281_cx_() + look.field_72449_c * 0.75;
        this.func_70107_b(x, this.func_226278_cu_(), z);
    }
    
    public void func_70071_h_() {
        this.field_70142_S = this.func_226277_ct_();
        this.field_70137_T = this.func_226278_cu_();
        this.field_70136_U = this.func_226281_cx_();
        super.func_70071_h_();
        if (this.newPosRotationIncrements > 0) {
            final double d0 = this.func_226277_ct_() + (this.interpTargetX - this.func_226277_ct_()) / this.newPosRotationIncrements;
            final double d2 = this.func_226278_cu_() + (this.interpTargetY - this.func_226278_cu_()) / this.newPosRotationIncrements;
            final double d3 = this.func_226281_cx_() + (this.interpTargetZ - this.func_226281_cx_()) / this.newPosRotationIncrements;
            final double d4 = MathHelper.func_76138_g(this.interpTargetYaw - this.field_70177_z);
            this.field_70177_z += (float)(d4 / this.newPosRotationIncrements);
            this.field_70125_A += (float)((this.interpTargetPitch - this.field_70125_A) / this.newPosRotationIncrements);
            --this.newPosRotationIncrements;
            this.func_70107_b(d0, d2, d3);
            this.func_70101_b(this.field_70177_z, this.field_70125_A);
        }
        final LivingEntity orbiting = this.getOwner();
        if (orbiting != null) {
            final float rotation = this.field_70173_aa / 10.0f + this.offset;
            final Vector3d look = new Vector3d(0.75, 0.0, 0.0).func_178785_b(rotation);
            this.func_70012_b(orbiting.func_226277_ct_() + look.field_72450_a, orbiting.func_226278_cu_() + orbiting.func_70047_e(), orbiting.func_226281_cx_() + look.field_72449_c, orbiting.field_70177_z, orbiting.field_70125_A);
        }
        if (!this.getItemID().func_190926_b()) {
            for (int i = 0; i < 2; ++i) {
                final double dx = this.func_226277_ct_() + 0.5 * (this.field_70146_Z.nextDouble() - this.field_70146_Z.nextDouble());
                final double dy = this.func_226278_cu_() + 0.5 * (this.field_70146_Z.nextDouble() - this.field_70146_Z.nextDouble());
                final double dz = this.func_226281_cx_() + 0.5 * (this.field_70146_Z.nextDouble() - this.field_70146_Z.nextDouble());
                this.field_70170_p.func_195594_a((IParticleData)new ItemParticleData(ParticleTypes.field_197591_B, this.getItemID()), dx, dy, dz, 0.0, 0.2, 0.0);
            }
        }
        if (!this.field_70170_p.field_72995_K && (this.field_70173_aa > 200 || (orbiting != null && !orbiting.func_70089_S()))) {
            this.func_70106_y();
        }
    }
    
    public void func_180426_a(final double x, final double y, final double z, final float yaw, final float pitch, final int posRotationIncrements, final boolean teleport) {
        this.interpTargetX = x;
        this.interpTargetY = y;
        this.interpTargetZ = z;
        this.interpTargetYaw = yaw;
        this.interpTargetPitch = pitch;
        this.newPosRotationIncrements = posRotationIncrements;
    }
    
    @Nonnull
    public IPacket<?> func_213297_N() {
        return (IPacket<?>)NetworkHooks.getEntitySpawningPacket((Entity)this);
    }
    
    protected void func_70088_a() {
        this.field_70180_af.func_187214_a((DataParameter)CharmEffectEntity.DATA_ITEMID, (Object)ItemStack.field_190927_a);
        this.field_70180_af.func_187214_a((DataParameter)CharmEffectEntity.DATA_OWNER, (Object)(-1));
    }
    
    public void setOwner(final LivingEntity owner) {
        this.field_70180_af.func_187227_b((DataParameter)CharmEffectEntity.DATA_OWNER, (Object)owner.func_145782_y());
    }
    
    @Nullable
    public LivingEntity getOwner() {
        final Entity e = this.field_70170_p.func_73045_a((int)this.field_70180_af.func_187225_a((DataParameter)CharmEffectEntity.DATA_OWNER));
        if (e instanceof LivingEntity) {
            return (LivingEntity)e;
        }
        return null;
    }
    
    public ItemStack getItemID() {
        return (ItemStack)this.field_70180_af.func_187225_a((DataParameter)CharmEffectEntity.DATA_ITEMID);
    }
    
    public void setItemID(final Item item) {
        this.field_70180_af.func_187227_b((DataParameter)CharmEffectEntity.DATA_ITEMID, (Object)new ItemStack((IItemProvider)item));
    }
    
    protected void func_70037_a(final CompoundNBT cmp) {
    }
    
    protected void func_213281_b(final CompoundNBT cmp) {
    }
    
    @Nonnull
    public ItemStack func_184543_l() {
        return this.getItemID();
    }
    
    static {
        DATA_OWNER = EntityDataManager.func_187226_a((Class)CharmEffectEntity.class, DataSerializers.field_187192_b);
        DATA_ITEMID = EntityDataManager.func_187226_a((Class)CharmEffectEntity.class, DataSerializers.field_187196_f);
    }
}
