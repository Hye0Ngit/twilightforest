// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.init.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.EntityLivingBase;
import twilightforest.entity.EntityTFRedcap;
import net.minecraft.entity.ai.EntityAIBase;

public abstract class EntityAITFRedcapBase extends EntityAIBase
{
    protected final EntityTFRedcap redcap;
    
    protected EntityAITFRedcapBase(final EntityTFRedcap entity) {
        this.redcap = entity;
    }
    
    public boolean isTargetLookingAtMe(final EntityLivingBase attackTarget) {
        final double dx = this.redcap.field_70165_t - attackTarget.field_70165_t;
        final double dz = this.redcap.field_70161_v - attackTarget.field_70161_v;
        final float angle = (float)(Math.atan2(dz, dx) * 180.0 / 3.141592653589793) - 90.0f;
        final float difference = MathHelper.func_76135_e((attackTarget.field_70177_z - angle) % 360.0f);
        return difference < 60.0f || difference > 300.0f;
    }
    
    public BlockPos findBlockTNTNearby(final int range) {
        final BlockPos entityPos = new BlockPos((Entity)this.redcap);
        for (int x = -range; x <= range; ++x) {
            for (int y = -range; y <= range; ++y) {
                for (int z = -range; z <= range; ++z) {
                    if (this.redcap.field_70170_p.func_180495_p(entityPos.func_177982_a(x, y, z)).func_177230_c() == Blocks.field_150335_W) {
                        return entityPos.func_177982_a(x, y, z);
                    }
                }
            }
        }
        return null;
    }
    
    public boolean isLitTNTNearby(final int range) {
        final AxisAlignedBB expandedBox = this.redcap.func_174813_aQ().func_72314_b((double)range, (double)range, (double)range);
        return !this.redcap.field_70170_p.func_72872_a((Class)EntityTNTPrimed.class, expandedBox).isEmpty();
    }
}
