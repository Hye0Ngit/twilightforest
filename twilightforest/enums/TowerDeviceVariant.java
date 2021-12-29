// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.enums;

import java.util.Locale;
import net.minecraft.util.IStringSerializable;

public enum TowerDeviceVariant implements IStringSerializable
{
    REAPPEARING_INACTIVE, 
    REAPPEARING_ACTIVE, 
    VANISH_INACTIVE, 
    VANISH_ACTIVE, 
    VANISH_LOCKED, 
    VANISH_UNLOCKED, 
    BUILDER_INACTIVE, 
    BUILDER_ACTIVE, 
    BUILDER_TIMEOUT, 
    ANTIBUILDER, 
    GHASTTRAP_INACTIVE, 
    GHASTTRAP_ACTIVE, 
    REACTOR_INACTIVE, 
    REACTOR_ACTIVE;
    
    public String func_176610_l() {
        return this.name().toLowerCase(Locale.ROOT);
    }
}
