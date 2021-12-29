// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.stats.StatBase;
import twilightforest.TFAchievementPage;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import twilightforest.TFFeature;
import net.minecraft.util.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraft.entity.monster.EntitySpider;

public class EntityTFHedgeSpider extends EntitySpider
{
    public EntityTFHedgeSpider(final World world) {
        super(world);
    }
    
    public EntityTFHedgeSpider(final World world, final double x, final double y, final double z) {
        this(world);
        this.func_70107_b(x, y, z);
    }
    
    protected Entity func_70782_k() {
        final double var2 = 16.0;
        return (Entity)this.field_70170_p.func_72856_b((Entity)this, var2);
    }
    
    protected boolean func_70814_o() {
        final int chunkX = MathHelper.func_76128_c(this.field_70165_t) >> 4;
        final int chunkZ = MathHelper.func_76128_c(this.field_70161_v) >> 4;
        return TFFeature.getNearestFeature(chunkX, chunkZ, this.field_70170_p) == TFFeature.hedgeMaze || super.func_70814_o();
    }
    
    public void func_70645_a(final DamageSource par1DamageSource) {
        super.func_70645_a(par1DamageSource);
        if (par1DamageSource.func_76364_f() instanceof EntityPlayer) {
            ((EntityPlayer)par1DamageSource.func_76364_f()).func_71029_a((StatBase)TFAchievementPage.twilightHunter);
            final int chunkX = MathHelper.func_76128_c(this.field_70165_t) >> 4;
            final int chunkZ = MathHelper.func_76128_c(this.field_70161_v) >> 4;
            if (TFFeature.getNearestFeature(chunkX, chunkZ, this.field_70170_p) == TFFeature.hedgeMaze) {
                ((EntityPlayer)par1DamageSource.func_76364_f()).func_71029_a((StatBase)TFAchievementPage.twilightHedge);
            }
        }
    }
}
