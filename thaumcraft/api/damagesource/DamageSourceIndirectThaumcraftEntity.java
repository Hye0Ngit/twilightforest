// 
// Decompiled by Procyon v0.6-prerelease
// 

package thaumcraft.api.damagesource;

import net.minecraft.util.DamageSource;
import net.minecraft.entity.Entity;
import net.minecraft.util.EntityDamageSourceIndirect;

public class DamageSourceIndirectThaumcraftEntity extends EntityDamageSourceIndirect
{
    private boolean fireDamage;
    private float hungerDamage;
    private boolean isUnblockable;
    
    public DamageSourceIndirectThaumcraftEntity(final String par1Str, final Entity par2Entity, final Entity par3Entity) {
        super(par1Str, par2Entity, par3Entity);
    }
    
    public DamageSource func_76361_j() {
        this.fireDamage = true;
        return (DamageSource)this;
    }
    
    public DamageSource func_76348_h() {
        this.isUnblockable = true;
        this.hungerDamage = 0.0f;
        return (DamageSource)this;
    }
}
