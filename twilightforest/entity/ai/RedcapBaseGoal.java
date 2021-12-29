// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.entity.item.TNTEntity;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.LivingEntity;
import twilightforest.entity.RedcapEntity;
import net.minecraft.entity.ai.goal.Goal;

public abstract class RedcapBaseGoal extends Goal
{
    protected final RedcapEntity redcap;
    
    protected RedcapBaseGoal(final RedcapEntity entity) {
        this.redcap = entity;
    }
    
    public boolean isTargetLookingAtMe(final LivingEntity attackTarget) {
        final double dx = this.redcap.func_226277_ct_() - attackTarget.func_226277_ct_();
        final double dz = this.redcap.func_226281_cx_() - attackTarget.func_226281_cx_();
        final float angle = (float)(Math.atan2(dz, dx) * 180.0 / 3.141592653589793) - 90.0f;
        final float difference = MathHelper.func_76135_e((attackTarget.field_70177_z - angle) % 360.0f);
        return difference < 60.0f || difference > 300.0f;
    }
    
    public BlockPos findBlockTNTNearby(final int range) {
        final BlockPos entityPos = new BlockPos((Vector3i)this.redcap.func_233580_cy_());
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
        return !this.redcap.field_70170_p.func_217357_a((Class)TNTEntity.class, expandedBox).isEmpty();
    }
}
