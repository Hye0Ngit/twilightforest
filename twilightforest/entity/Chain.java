// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.Entity;
import twilightforest.entity.monster.BlockChainGoblin;

public class Chain extends BlockChainGoblin.MultipartGenericsAreDumb
{
    public Chain(final Entity parent) {
        super(parent);
    }
    
    protected void m_8097_() {
        this.realSize = EntityDimensions.m_20395_(0.75f, 0.75f);
    }
    
    @Override
    public boolean m_6087_() {
        return false;
    }
    
    protected void m_7378_(final CompoundTag compound) {
    }
    
    protected void m_7380_(final CompoundTag compound) {
    }
}
