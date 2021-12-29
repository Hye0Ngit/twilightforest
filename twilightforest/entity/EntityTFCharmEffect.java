// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.item.Item;
import twilightforest.item.TFItems;
import net.minecraft.world.World;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

public class EntityTFCharmEffect extends Entity
{
    private static final int DATA_OWNER = 17;
    private static final int DATA_ITEMID = 16;
    private static final double DISTANCE = 1.75;
    private EntityLivingBase orbiting;
    private double newPosX;
    private double newPosY;
    private double newPosZ;
    private double newRotationYaw;
    private double newRotationPitch;
    private int newPosRotationIncrements;
    public float offset;
    
    public EntityTFCharmEffect(final World par1World) {
        super(par1World);
        this.func_70105_a(0.25f, 0.25f);
        this.setItemID(TFItems.charmOfLife1);
    }
    
    public EntityTFCharmEffect(final World par1World, final EntityLivingBase par2EntityLiving, final Item item) {
        super(par1World);
        this.func_70105_a(0.25f, 0.25f);
        this.orbiting = par2EntityLiving;
        this.setItemID(item);
        final Vec3 look = Vec3.func_72443_a(1.75, 0.0, 0.0);
        this.func_70012_b(par2EntityLiving.field_70165_t, par2EntityLiving.field_70163_u + par2EntityLiving.func_70047_e(), par2EntityLiving.field_70161_v, par2EntityLiving.field_70177_z, par2EntityLiving.field_70125_A);
        this.field_70165_t += look.field_72450_a * 1.75;
        this.field_70161_v += look.field_72449_c * 1.75;
        this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
        this.field_70129_M = 0.0f;
    }
    
    public void func_70071_h_() {
        this.field_70142_S = this.field_70165_t;
        this.field_70137_T = this.field_70163_u;
        this.field_70136_U = this.field_70161_v;
        super.func_70071_h_();
        if (this.newPosRotationIncrements > 0) {
            final double var1 = this.field_70165_t + (this.newPosX - this.field_70165_t) / this.newPosRotationIncrements;
            final double var2 = this.field_70163_u + (this.newPosY - this.field_70163_u) / this.newPosRotationIncrements;
            final double var3 = this.field_70161_v + (this.newPosZ - this.field_70161_v) / this.newPosRotationIncrements;
            final double var4 = MathHelper.func_76138_g(this.newRotationYaw - this.field_70177_z);
            this.field_70177_z += (float)(var4 / this.newPosRotationIncrements);
            this.field_70125_A += (float)((this.newRotationPitch - this.field_70125_A) / this.newPosRotationIncrements);
            --this.newPosRotationIncrements;
            this.func_70107_b(var1, var2, var3);
            this.func_70101_b(this.field_70177_z, this.field_70125_A);
        }
        final float rotation = this.field_70173_aa / 5.0f + this.offset;
        if (this.orbiting == null) {
            this.orbiting = this.getOwner();
        }
        if (this.orbiting != null && !this.field_70170_p.field_72995_K) {
            this.func_70012_b(this.orbiting.field_70165_t, this.orbiting.field_70163_u + this.orbiting.func_70047_e(), this.orbiting.field_70161_v, this.orbiting.field_70177_z, this.orbiting.field_70125_A);
            final Vec3 look = Vec3.func_72443_a(1.75, 0.0, 0.0);
            look.func_72442_b(rotation);
            this.field_70165_t += look.field_72450_a;
            this.field_70161_v += look.field_72449_c;
            this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
        }
        if (this.getItemID() > 0) {
            for (int i = 0; i < 3; ++i) {
                final double dx = this.field_70165_t + 0.5 * (this.field_70146_Z.nextDouble() - this.field_70146_Z.nextDouble());
                final double dy = this.field_70163_u + 0.5 * (this.field_70146_Z.nextDouble() - this.field_70146_Z.nextDouble());
                final double dz = this.field_70161_v + 0.5 * (this.field_70146_Z.nextDouble() - this.field_70146_Z.nextDouble());
                this.field_70170_p.func_72869_a("iconcrack_" + this.getItemID(), dx, dy, dz, 0.0, 0.2, 0.0);
            }
        }
        if (this.field_70173_aa > 200 || this.orbiting == null || this.orbiting.field_70128_L) {
            this.func_70106_y();
        }
    }
    
    public void func_70056_a(final double par1, final double par3, final double par5, final float par7, final float par8, final int par9) {
        this.field_70129_M = 0.0f;
        this.newPosX = par1;
        this.newPosY = par3;
        this.newPosZ = par5;
        this.newRotationYaw = par7;
        this.newRotationPitch = par8;
        this.newPosRotationIncrements = par9;
    }
    
    protected void func_70088_a() {
        this.field_70180_af.func_75682_a(16, (Object)0);
        this.field_70180_af.func_75682_a(17, (Object)"");
    }
    
    public String getOwnerName() {
        return this.field_70180_af.func_75681_e(17);
    }
    
    public void setOwner(final String par1Str) {
        this.field_70180_af.func_75692_b(17, (Object)par1Str);
    }
    
    public EntityLivingBase getOwner() {
        return (EntityLivingBase)this.field_70170_p.func_72924_a(this.getOwnerName());
    }
    
    public int getItemID() {
        return this.field_70180_af.func_75679_c(16);
    }
    
    public void setItemID(final Item charmOfLife1) {
    }
    
    protected void func_70037_a(final NBTTagCompound par1NBTTagCompound) {
        par1NBTTagCompound.func_74778_a("Owner", this.getOwnerName());
        par1NBTTagCompound.func_74777_a("ItemID", (short)this.getItemID());
    }
    
    protected void func_70014_b(final NBTTagCompound par1NBTTagCompound) {
        this.setOwner(par1NBTTagCompound.func_74779_i("Owner"));
    }
}
