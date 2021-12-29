// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.enums;

import java.util.Locale;
import net.minecraft.util.IStringSerializable;

public enum TowerTranslucentVariant implements IStringSerializable
{
    REAPPEARING_INACTIVE, 
    REAPPEARING_ACTIVE, 
    BUILT_INACTIVE, 
    BUILT_ACTIVE, 
    REVERTER_REPLACEMENT, 
    REACTOR_DEBRIS, 
    FAKE_GOLD, 
    FAKE_DIAMOND;
    
    public String func_176610_l() {
        return this.name().toLowerCase(Locale.ROOT);
    }
}
