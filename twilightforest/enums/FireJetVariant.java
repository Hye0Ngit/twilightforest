// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.enums;

import java.util.Locale;
import net.minecraft.util.IStringSerializable;

public enum FireJetVariant implements IStringSerializable
{
    IDLE, 
    POPPING, 
    FLAME;
    
    @Override
    public String toString() {
        return this.func_176610_l();
    }
    
    public String func_176610_l() {
        return this.name().toLowerCase(Locale.ROOT);
    }
}
