// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.util;

import net.minecraft.core.Direction;

public final class AxisUtil
{
    public static Direction getAxisDirectionPositive(final Direction.Axis axis) {
        return switch (axis) {
            case X -> Direction.EAST;
            case Y -> Direction.UP;
            case Z -> Direction.SOUTH;
            default -> throw new IncompatibleClassChangeError();
        };
    }
    
    public static Direction getAxisDirectionNegative(final Direction.Axis axis) {
        return switch (axis) {
            case X -> Direction.WEST;
            case Y -> Direction.DOWN;
            case Z -> Direction.NORTH;
            default -> throw new IncompatibleClassChangeError();
        };
    }
    
    private AxisUtil() {
    }
}
