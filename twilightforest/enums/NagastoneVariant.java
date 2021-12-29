// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.enums;

import net.minecraft.util.Direction;
import java.util.Locale;
import net.minecraft.util.IStringSerializable;

public enum NagastoneVariant implements IStringSerializable
{
    NORTH_DOWN, 
    SOUTH_DOWN, 
    WEST_DOWN, 
    EAST_DOWN, 
    NORTH_UP, 
    SOUTH_UP, 
    EAST_UP, 
    WEST_UP, 
    AXIS_X, 
    AXIS_Y, 
    AXIS_Z, 
    SOLID;
    
    public String func_176610_l() {
        return this.name().toLowerCase(Locale.ROOT);
    }
    
    public static NagastoneVariant getVariantFromAxis(final Direction.Axis axis) {
        switch (axis) {
            case X: {
                return NagastoneVariant.AXIS_X;
            }
            case Y: {
                return NagastoneVariant.AXIS_Y;
            }
            case Z: {
                return NagastoneVariant.AXIS_Z;
            }
            default: {
                return NagastoneVariant.SOLID;
            }
        }
    }
    
    public static NagastoneVariant getVariantFromDoubleFacing(final Direction facing1, final Direction facing2) {
        if (facing1.func_176740_k() == facing2.func_176740_k()) {
            return getVariantFromAxis(facing1.func_176740_k());
        }
        if (facing1.func_176740_k() != Direction.Axis.Y && facing2.func_176740_k() != Direction.Axis.Y) {
            return NagastoneVariant.SOLID;
        }
        final Direction facingYAxis = (facing1.func_176740_k() == Direction.Axis.Y) ? facing1 : facing2;
        final Direction otherFace = (facing1.func_176740_k() != Direction.Axis.Y) ? facing1 : facing2;
        if (facingYAxis == Direction.UP) {
            switch (otherFace) {
                case NORTH: {
                    return NagastoneVariant.NORTH_UP;
                }
                case SOUTH: {
                    return NagastoneVariant.SOUTH_UP;
                }
                case WEST: {
                    return NagastoneVariant.WEST_UP;
                }
                case EAST: {
                    return NagastoneVariant.EAST_UP;
                }
                default: {
                    return NagastoneVariant.SOLID;
                }
            }
        }
        else {
            switch (otherFace) {
                case NORTH: {
                    return NagastoneVariant.NORTH_DOWN;
                }
                case SOUTH: {
                    return NagastoneVariant.SOUTH_DOWN;
                }
                case WEST: {
                    return NagastoneVariant.WEST_DOWN;
                }
                case EAST: {
                    return NagastoneVariant.EAST_DOWN;
                }
                default: {
                    return NagastoneVariant.SOLID;
                }
            }
        }
    }
}
