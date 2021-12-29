// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.Pose;

public class SpikeBlockEntity extends BlockChainGoblinEntity.MultipartGenericsAreDumb
{
    @Override
    public EntitySize func_213305_a(final Pose pos) {
        return EntitySize.func_220314_b(0.75f, 0.75f);
    }
    
    public SpikeBlockEntity(final Entity goblin) {
        super(goblin);
        this.realSize = EntitySize.func_220314_b(0.75f, 0.75f);
    }
    
    public boolean func_70097_a(final DamageSource source, final float amount) {
        return false;
    }
    
    @Override
    public boolean func_70067_L() {
        return false;
    }
    
    public boolean func_70104_M() {
        return false;
    }
    
    public boolean func_70028_i(final Entity entity) {
        return this == entity || this.getParent() == entity;
    }
    
    public IPacket<?> func_213297_N() {
        throw new UnsupportedOperationException();
    }
    
    protected void func_70088_a() {
    }
    
    protected boolean func_184228_n(final Entity entityIn) {
        return false;
    }
    
    protected void func_70037_a(final CompoundNBT compound) {
    }
    
    protected void func_213281_b(final CompoundNBT compound) {
    }
}
