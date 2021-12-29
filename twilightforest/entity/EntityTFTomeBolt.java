// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.potion.PotionEffect;
import net.minecraft.init.MobEffects;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.item.Item;
import net.minecraft.init.Items;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;

public class EntityTFTomeBolt extends EntityTFThrowable
{
    public EntityTFTomeBolt(final World world, final EntityLivingBase thrower) {
        super(world, thrower);
    }
    
    public EntityTFTomeBolt(final World world) {
        super(world);
    }
    
    public void func_70071_h_() {
        super.func_70071_h_();
        this.makeTrail();
    }
    
    protected float func_70185_h() {
        return 0.003f;
    }
    
    private void makeTrail() {
        for (int i = 0; i < 5; ++i) {
            final double dx = this.field_70165_t + 0.5 * (this.field_70146_Z.nextDouble() - this.field_70146_Z.nextDouble());
            final double dy = this.field_70163_u + 0.5 * (this.field_70146_Z.nextDouble() - this.field_70146_Z.nextDouble());
            final double dz = this.field_70161_v + 0.5 * (this.field_70146_Z.nextDouble() - this.field_70146_Z.nextDouble());
            this.field_70170_p.func_175688_a(EnumParticleTypes.CRIT, dx, dy, dz, 0.0, 0.0, 0.0, new int[0]);
        }
    }
    
    @SideOnly(Side.CLIENT)
    public void func_70103_a(final byte id) {
        if (id == 3) {
            final int itemId = Item.func_150891_b(Items.field_151121_aF);
            for (int i = 0; i < 8; ++i) {
                this.field_70170_p.func_175688_a(EnumParticleTypes.ITEM_CRACK, this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70146_Z.nextGaussian() * 0.05, this.field_70146_Z.nextDouble() * 0.2, this.field_70146_Z.nextGaussian() * 0.05, new int[] { itemId });
            }
        }
        else {
            super.func_70103_a(id);
        }
    }
    
    protected void func_70184_a(final RayTraceResult result) {
        if (!this.field_70170_p.field_72995_K) {
            if (result.field_72308_g instanceof EntityLivingBase && result.field_72308_g.func_70097_a(DamageSource.func_76356_a((Entity)this, (Entity)this.func_85052_h()), 6.0f)) {
                final int duration = (this.field_70170_p.func_175659_aa() == EnumDifficulty.PEACEFUL) ? 3 : ((this.field_70170_p.func_175659_aa() == EnumDifficulty.NORMAL) ? 7 : 9);
                ((EntityLivingBase)result.field_72308_g).func_70690_d(new PotionEffect(MobEffects.field_76421_d, duration * 20, 1));
            }
            this.field_70170_p.func_72960_a((Entity)this, (byte)3);
            this.func_70106_y();
        }
    }
}
