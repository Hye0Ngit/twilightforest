// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.capabilities.shield;

import twilightforest.TwilightForestMod;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public interface IShieldCapability
{
    public static final ResourceLocation ID = TwilightForestMod.prefix("cap_shield");
    
    void setEntity(final EntityLivingBase p0);
    
    void update();
    
    int shieldsLeft();
    
    int temporaryShieldsLeft();
    
    int permanentShieldsLeft();
    
    void breakShield();
    
    void replenishShields();
    
    void setShields(final int p0, final boolean p1);
    
    void addShields(final int p0, final boolean p1);
}
