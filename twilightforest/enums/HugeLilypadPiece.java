// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.enums;

import java.util.Locale;
import net.minecraft.util.StringRepresentable;

public enum HugeLilypadPiece implements StringRepresentable
{
    NW, 
    NE, 
    SE, 
    SW;
    
    public String m_7912_() {
        return this.name().toLowerCase(Locale.ROOT);
    }
}
