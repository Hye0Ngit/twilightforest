// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.BlockPos;
import twilightforest.entity.boss.EntityTFKnightPhantom;
import net.minecraft.entity.ai.EntityAIBase;

public class EntityAIPhantomAttackStart extends EntityAIBase
{
    private final EntityTFKnightPhantom boss;
    
    public EntityAIPhantomAttackStart(final EntityTFKnightPhantom entity) {
        this.boss = entity;
        this.func_75248_a(2);
    }
    
    public boolean func_75250_a() {
        return this.boss.func_70638_az() != null && this.boss.getCurrentFormation() == EntityTFKnightPhantom.Formation.ATTACK_PLAYER_START;
    }
    
    public void func_75246_d() {
        final EntityLivingBase target = this.boss.func_70638_az();
        if (target != null) {
            final BlockPos targetPos = new BlockPos(target.field_70142_S, target.field_70137_T, target.field_70136_U);
            if (this.boss.isWithinHomeDistanceFromPosition(targetPos)) {
                this.boss.setChargePos(targetPos);
            }
            else {
                this.boss.setChargePos(this.boss.getHomePosition());
            }
        }
    }
}
