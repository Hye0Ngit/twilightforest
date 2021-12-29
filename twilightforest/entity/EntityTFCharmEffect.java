// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.nbt.NBTTagCompound;
import javax.annotation.Nullable;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.item.Item;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.entity.Entity;

public class EntityTFCharmEffect extends Entity
{
    private static final DataParameter<Integer> DATA_OWNER;
    private static final DataParameter<Integer> DATA_ITEMID;
    private static final double DISTANCE = 1.75;
    private double interpTargetX;
    private double interpTargetY;
    private double interpTargetZ;
    private double interpTargetYaw;
    private double interpTargetPitch;
    private int newPosRotationIncrements;
    public float offset;
    
    public EntityTFCharmEffect(final World world) {
        super(world);
        this.func_70105_a(0.25f, 0.25f);
    }
    
    public EntityTFCharmEffect(final World world, final EntityLivingBase owner, final Item item) {
        this(world);
        this.setOwner(owner);
        this.setItemID(item);
        final Vec3d look = new Vec3d(1.75, 0.0, 0.0);
        this.func_70012_b(owner.field_70165_t, owner.field_70163_u + owner.func_70047_e(), owner.field_70161_v, owner.field_70177_z, owner.field_70125_A);
        this.field_70165_t += look.field_72450_a * 1.75;
        this.field_70161_v += look.field_72449_c * 1.75;
        this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
    }
    
    public void func_70071_h_() {
        this.field_70142_S = this.field_70165_t;
        this.field_70137_T = this.field_70163_u;
        this.field_70136_U = this.field_70161_v;
        super.func_70071_h_();
        if (this.newPosRotationIncrements > 0) {
            final double d0 = this.field_70165_t + (this.interpTargetX - this.field_70165_t) / this.newPosRotationIncrements;
            final double d2 = this.field_70163_u + (this.interpTargetY - this.field_70163_u) / this.newPosRotationIncrements;
            final double d3 = this.field_70161_v + (this.interpTargetZ - this.field_70161_v) / this.newPosRotationIncrements;
            final double d4 = MathHelper.func_76138_g(this.interpTargetYaw - this.field_70177_z);
            this.field_70177_z += (float)(d4 / this.newPosRotationIncrements);
            this.field_70125_A += (float)((this.interpTargetPitch - this.field_70125_A) / this.newPosRotationIncrements);
            --this.newPosRotationIncrements;
            this.func_70107_b(d0, d2, d3);
            this.func_70101_b(this.field_70177_z, this.field_70125_A);
        }
        final EntityLivingBase orbiting = this.getOwner();
        if (orbiting != null) {
            this.func_70012_b(orbiting.field_70165_t, orbiting.field_70163_u + orbiting.func_70047_e(), orbiting.field_70161_v, orbiting.field_70177_z, orbiting.field_70125_A);
            final float rotation = this.field_70173_aa / 5.0f + this.offset;
            final Vec3d look = new Vec3d(1.75, 0.0, 0.0).func_178785_b(rotation);
            this.field_70165_t += look.field_72450_a;
            this.field_70161_v += look.field_72449_c;
            this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
        }
        if (this.getItemID() > -1) {
            for (int i = 0; i < 3; ++i) {
                final double dx = this.field_70165_t + 0.5 * (this.field_70146_Z.nextDouble() - this.field_70146_Z.nextDouble());
                final double dy = this.field_70163_u + 0.5 * (this.field_70146_Z.nextDouble() - this.field_70146_Z.nextDouble());
                final double dz = this.field_70161_v + 0.5 * (this.field_70146_Z.nextDouble() - this.field_70146_Z.nextDouble());
                this.field_70170_p.func_175688_a(EnumParticleTypes.ITEM_CRACK, dx, dy, dz, 0.0, 0.2, 0.0, new int[] { this.getItemID() });
            }
        }
        if (!this.field_70170_p.field_72995_K && (this.field_70173_aa > 200 || (orbiting != null && orbiting.field_70128_L))) {
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
    
    protected void func_70088_a() {
        this.field_70180_af.func_187214_a((DataParameter)EntityTFCharmEffect.DATA_ITEMID, (Object)(-1));
        this.field_70180_af.func_187214_a((DataParameter)EntityTFCharmEffect.DATA_OWNER, (Object)(-1));
    }
    
    public void setOwner(final EntityLivingBase owner) {
        this.field_70180_af.func_187227_b((DataParameter)EntityTFCharmEffect.DATA_OWNER, (Object)owner.func_145782_y());
    }
    
    @Nullable
    public EntityLivingBase getOwner() {
        final Entity e = this.field_70170_p.func_73045_a((int)this.field_70180_af.func_187225_a((DataParameter)EntityTFCharmEffect.DATA_OWNER));
        if (e instanceof EntityLivingBase) {
            return (EntityLivingBase)e;
        }
        return null;
    }
    
    public int getItemID() {
        return (int)this.field_70180_af.func_187225_a((DataParameter)EntityTFCharmEffect.DATA_ITEMID);
    }
    
    public void setItemID(final Item item) {
        this.field_70180_af.func_187227_b((DataParameter)EntityTFCharmEffect.DATA_ITEMID, (Object)Item.func_150891_b(item));
    }
    
    protected void func_70037_a(final NBTTagCompound cmp) {
    }
    
    protected void func_70014_b(final NBTTagCompound cmp) {
    }
    
    static {
        DATA_OWNER = EntityDataManager.func_187226_a((Class)EntityTFCharmEffect.class, DataSerializers.field_187192_b);
        DATA_ITEMID = EntityDataManager.func_187226_a((Class)EntityTFCharmEffect.class, DataSerializers.field_187192_b);
    }
}
