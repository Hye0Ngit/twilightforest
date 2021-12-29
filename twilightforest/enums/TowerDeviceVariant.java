// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.enums;

import java.util.Locale;
import net.minecraft.util.IStringSerializable;

public enum TowerDeviceVariant implements IStringSerializable
{
    BUILDER_INACTIVE, 
    BUILDER_ACTIVE, 
    BUILDER_TIMEOUT;
    
    public String func_176610_l() {
        return this.name().toLowerCase(Locale.ROOT);
    }
}
