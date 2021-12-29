// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.Pose;
import twilightforest.entity.monster.BlockChainGoblin;

public class SpikeBlock extends BlockChainGoblin.MultipartGenericsAreDumb
{
    @Override
    public EntityDimensions m_6972_(final Pose pos) {
        return EntityDimensions.m_20395_(0.75f, 0.75f);
    }
    
    public SpikeBlock(final Entity goblin) {
        super(goblin);
        this.realSize = EntityDimensions.m_20395_(0.75f, 0.75f);
    }
    
    public boolean m_6469_(final DamageSource source, final float amount) {
        return false;
    }
    
    @Override
    public boolean m_6087_() {
        return false;
    }
    
    public boolean m_6094_() {
        return false;
    }
    
    public boolean m_7306_(final Entity entity) {
        return this == entity || this.getParent() == entity;
    }
    
    public Packet<?> m_5654_() {
        throw new UnsupportedOperationException();
    }
    
    protected void m_8097_() {
    }
    
    protected boolean m_7341_(final Entity entityIn) {
        return false;
    }
    
    protected void m_7378_(final CompoundTag compound) {
    }
    
    protected void m_7380_(final CompoundTag compound) {
    }
}
