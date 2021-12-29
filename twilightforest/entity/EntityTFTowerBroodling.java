// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;

public class EntityTFTowerBroodling extends EntityTFSwarmSpider
{
    public EntityTFTowerBroodling(final World world) {
        this(world, true);
    }
    
    public EntityTFTowerBroodling(final World world, final boolean spawnMore) {
        super(world, spawnMore);
        this.field_70728_aV = 3;
    }
    
    @Override
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(7.0);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(4.0);
    }
    
    @Override
    protected boolean spawnAnother() {
        final EntityTFSwarmSpider another = new EntityTFTowerBroodling(this.field_70170_p, false);
        final double sx = this.field_70165_t + (this.field_70146_Z.nextBoolean() ? 0.9 : -0.9);
        final double sy = this.field_70163_u;
        final double sz = this.field_70161_v + (this.field_70146_Z.nextBoolean() ? 0.9 : -0.9);
        another.func_70012_b(sx, sy, sz, this.field_70146_Z.nextFloat() * 360.0f, 0.0f);
        if (!another.func_70601_bi()) {
            another.func_70106_y();
            return false;
        }
        this.field_70170_p.func_72838_d((Entity)another);
        return true;
    }
}
