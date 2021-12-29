// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.boss;

import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.network.datasync.DataParameter;
import twilightforest.entity.EntityTFThrowable;

public class EntityTFThrownWep extends EntityTFThrowable
{
    private static final DataParameter<ItemStack> DATA_ITEMSTACK;
    private static final DataParameter<Float> DATA_VELOCITY;
    private float projectileDamage;
    
    public EntityTFThrownWep(final World world, final EntityLivingBase thrower) {
        super(world, thrower);
        this.projectileDamage = 6.0f;
        this.func_70105_a(0.5f, 0.5f);
    }
    
    public EntityTFThrownWep(final World world) {
        super(world);
        this.projectileDamage = 6.0f;
        this.func_70105_a(0.5f, 0.5f);
    }
    
    public EntityTFThrownWep setDamage(final float damage) {
        this.projectileDamage = damage;
        return this;
    }
    
    protected void func_70088_a() {
        this.field_70180_af.func_187214_a((DataParameter)EntityTFThrownWep.DATA_ITEMSTACK, (Object)ItemStack.field_190927_a);
        this.field_70180_af.func_187214_a((DataParameter)EntityTFThrownWep.DATA_VELOCITY, (Object)0.001f);
    }
    
    public EntityTFThrownWep setItem(final ItemStack stack) {
        this.field_70180_af.func_187227_b((DataParameter)EntityTFThrownWep.DATA_ITEMSTACK, (Object)stack);
        return this;
    }
    
    public ItemStack getItem() {
        return (ItemStack)this.field_70180_af.func_187225_a((DataParameter)EntityTFThrownWep.DATA_ITEMSTACK);
    }
    
    public EntityTFThrownWep setVelocity(final float velocity) {
        this.field_70180_af.func_187227_b((DataParameter)EntityTFThrownWep.DATA_VELOCITY, (Object)velocity);
        return this;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_70103_a(final byte id) {
        if (id == 3) {
            for (int i = 0; i < 8; ++i) {
                this.field_70170_p.func_175688_a(EnumParticleTypes.SMOKE_LARGE, this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0, 0.0, 0.0, new int[0]);
            }
        }
        else {
            super.func_70103_a(id);
        }
    }
    
    protected void func_70184_a(final RayTraceResult result) {
        if (result.field_72308_g instanceof EntityTFKnightPhantom || result.field_72308_g == this.func_85052_h()) {
            return;
        }
        if (!this.field_70170_p.field_72995_K) {
            if (result.field_72308_g != null) {
                result.field_72308_g.func_70097_a(DamageSource.func_76356_a((Entity)this, (Entity)this.func_85052_h()), this.projectileDamage);
            }
            this.field_70170_p.func_72960_a((Entity)this, (byte)3);
            this.func_70106_y();
        }
    }
    
    public boolean func_70067_L() {
        return true;
    }
    
    public float func_70111_Y() {
        return 1.0f;
    }
    
    protected float func_70185_h() {
        return (float)this.field_70180_af.func_187225_a((DataParameter)EntityTFThrownWep.DATA_VELOCITY);
    }
    
    static {
        DATA_ITEMSTACK = EntityDataManager.func_187226_a((Class)EntityTFThrownWep.class, DataSerializers.field_187196_f);
        DATA_VELOCITY = EntityDataManager.func_187226_a((Class)EntityTFThrownWep.class, DataSerializers.field_187193_c);
    }
}
