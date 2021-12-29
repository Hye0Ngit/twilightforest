// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import twilightforest.entity.EntityTFSpikeBlock;
import twilightforest.entity.EntityTFBlockGoblin;
import net.minecraft.entity.ai.EntityAIBase;

public class EntityAIThrowSpikeBlock extends EntityAIBase
{
    protected EntityTFBlockGoblin attacker;
    protected EntityTFSpikeBlock spikeBlock;
    
    public EntityAIThrowSpikeBlock(final EntityTFBlockGoblin entityTFBlockGoblin, final EntityTFSpikeBlock entitySpikeBlock) {
        this.attacker = entityTFBlockGoblin;
        this.spikeBlock = entitySpikeBlock;
        this.func_75248_a(3);
    }
    
    public boolean func_75250_a() {
        final EntityLivingBase target = this.attacker.func_70638_az();
        return target != null && this.attacker.func_70068_e((Entity)target) <= 42.0 && this.attacker.func_70089_S() && this.attacker.func_70685_l((Entity)target) && this.attacker.field_70170_p.field_73012_v.nextInt(56) == 0;
    }
    
    public boolean func_75253_b() {
        return this.attacker.getChainMoveLength() > 0.0f;
    }
    
    public void func_75249_e() {
        this.attacker.setThrowing(true);
    }
}
