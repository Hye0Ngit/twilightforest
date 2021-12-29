// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.entity.Entity;

public interface IBreathAttacker
{
    boolean isBreathing();
    
    void setBreathing(final boolean p0);
    
    void doBreathAttack(final Entity p0);
}
