// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.enums;

import java.util.Locale;
import net.minecraft.util.IStringSerializable;

public enum FireJetVariant implements IStringSerializable
{
    SMOKER(true), 
    ENCASED_SMOKER_OFF(false), 
    ENCASED_SMOKER_ON(false), 
    JET_IDLE(true), 
    JET_POPPING(true), 
    JET_FLAME(true), 
    ENCASED_JET_IDLE(false), 
    ENCASED_JET_POPPING(false), 
    ENCASED_JET_FLAME(false);
    
    public final boolean hasGrassColor;
    
    private FireJetVariant(final boolean hasGrassColor) {
        this.hasGrassColor = hasGrassColor;
    }
    
    public String func_176610_l() {
        return this.name().toLowerCase(Locale.ROOT);
    }
}
