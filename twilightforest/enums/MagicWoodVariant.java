// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.enums;

import java.util.Locale;
import net.minecraft.util.IStringSerializable;

public enum MagicWoodVariant implements IStringSerializable
{
    TIME, 
    TRANS, 
    MINE, 
    SORT;
    
    public String func_176610_l() {
        return this.name().toLowerCase(Locale.ROOT);
    }
}
