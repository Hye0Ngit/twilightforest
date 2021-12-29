// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.potion.PotionEffect;
import twilightforest.potions.TFPotions;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;

public class EntityIceArrow extends EntityTFArrow
{
    public EntityIceArrow(final World world) {
        super(world);
    }
    
    public EntityIceArrow(final World world, final EntityLivingBase shooter) {
        super(world, shooter);
    }
    
    public void func_70071_h_() {
        super.func_70071_h_();
        if (this.field_70170_p.field_72995_K && !this.field_70254_i) {
            final int stateId = Block.func_176210_f(Blocks.field_150433_aE.func_176223_P());
            for (int i = 0; i < 4; ++i) {
                this.field_70170_p.func_175688_a(EnumParticleTypes.FALLING_DUST, this.field_70165_t + this.field_70159_w * i / 4.0, this.field_70163_u + this.field_70181_x * i / 4.0, this.field_70161_v + this.field_70179_y * i / 4.0, -this.field_70159_w, -this.field_70181_x + 0.2, -this.field_70179_y, new int[] { stateId });
            }
        }
    }
    
    protected void func_184549_a(final RayTraceResult ray) {
        super.func_184549_a(ray);
        if (!this.field_70170_p.field_72995_K && ray.field_72308_g instanceof EntityLivingBase) {
            final int chillLevel = 2;
            ((EntityLivingBase)ray.field_72308_g).func_70690_d(new PotionEffect(TFPotions.frosty, 200, chillLevel));
        }
    }
}
