// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import java.util.List;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.block.Block;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.MathHelper;
import net.minecraft.entity.EntityLivingBase;
import twilightforest.entity.EntityTFRedcap;
import net.minecraft.entity.ai.EntityAIBase;

public abstract class EntityAITFRedcapBase extends EntityAIBase
{
    protected EntityTFRedcap me;
    
    public boolean isTargetLookingAtMe(final EntityLivingBase attackTarget) {
        final double dx = this.me.field_70165_t - attackTarget.field_70165_t;
        final double dz = this.me.field_70161_v - attackTarget.field_70161_v;
        final float angle = (float)(Math.atan2(dz, dx) * 180.0 / 3.141592653589793) - 90.0f;
        final float difference = MathHelper.func_76135_e((attackTarget.field_70177_z - angle) % 360.0f);
        return difference < 60.0f || difference > 300.0f;
    }
    
    public ChunkCoordinates findBlockTNTNearby(final int range) {
        final int entityPosX = MathHelper.func_76128_c(this.me.field_70165_t);
        final int entityPosY = MathHelper.func_76128_c(this.me.field_70163_u);
        final int entityPosZ = MathHelper.func_76128_c(this.me.field_70161_v);
        for (int x = -range; x <= range; ++x) {
            for (int y = -range; y <= range; ++y) {
                for (int z = -range; z <= range; ++z) {
                    if (this.me.field_70170_p.func_72798_a(entityPosX + x, entityPosY + y, entityPosZ + z) == Block.field_72091_am.field_71990_ca) {
                        return new ChunkCoordinates(entityPosX + x, entityPosY + y, entityPosZ + z);
                    }
                }
            }
        }
        return null;
    }
    
    public boolean isLitTNTNearby(final int range) {
        final AxisAlignedBB expandedBox = this.me.field_70121_D.func_72314_b((double)range, (double)range, (double)range);
        final List nearbyTNT = this.me.field_70170_p.func_72872_a((Class)EntityTNTPrimed.class, expandedBox);
        return nearbyTNT.size() > 0;
    }
}
