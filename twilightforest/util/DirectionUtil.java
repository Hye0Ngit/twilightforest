// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.util;

import net.minecraft.core.Direction;

public final class DirectionUtil
{
    public static Direction horizontalOrElse(final Direction horizontal, final Direction orElse) {
        return horizontal.m_122434_().m_122479_() ? horizontal : horizontalOrElse(orElse, Direction.NORTH);
    }
    
    private DirectionUtil() {
    }
}
