// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.Entity;

public class ChainEntity extends BlockChainGoblinEntity.MultipartGenericsAreDumb
{
    public ChainEntity(final Entity parent) {
        super(parent);
    }
    
    protected void func_70088_a() {
        this.realSize = EntitySize.func_220314_b(0.75f, 0.75f);
    }
    
    @Override
    public boolean func_70067_L() {
        return false;
    }
    
    protected void func_70037_a(final CompoundNBT compound) {
    }
    
    protected void func_213281_b(final CompoundNBT compound) {
    }
}
