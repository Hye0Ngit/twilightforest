// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.enums;

import java.util.Locale;
import net.minecraft.util.StringRepresentable;

public enum FireJetVariant implements StringRepresentable
{
    IDLE, 
    POPPING, 
    FLAME, 
    TIMEOUT;
    
    @Override
    public String toString() {
        return this.m_7912_();
    }
    
    public String m_7912_() {
        return this.name().toLowerCase(Locale.ROOT);
    }
}
