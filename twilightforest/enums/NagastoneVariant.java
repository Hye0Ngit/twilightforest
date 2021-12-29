// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.enums;

import net.minecraft.core.Direction;
import java.util.Locale;
import net.minecraft.util.StringRepresentable;

public enum NagastoneVariant implements StringRepresentable
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
    
    public String m_7912_() {
        return this.name().toLowerCase(Locale.ROOT);
    }
    
    public static NagastoneVariant getVariantFromAxis(final Direction.Axis axis) {
        return switch (axis) {
            case X -> NagastoneVariant.AXIS_X;
            case Y -> NagastoneVariant.AXIS_Y;
            case Z -> NagastoneVariant.AXIS_Z;
            default -> throw new IncompatibleClassChangeError();
        };
    }
    
    public static NagastoneVariant getVariantFromDoubleFacing(final Direction facing1, final Direction facing2) {
        if (facing1.m_122434_() == facing2.m_122434_()) {
            return getVariantFromAxis(facing1.m_122434_());
        }
        if (facing1.m_122434_() != Direction.Axis.Y && facing2.m_122434_() != Direction.Axis.Y) {
            return NagastoneVariant.SOLID;
        }
        final Direction facingYAxis = (facing1.m_122434_() == Direction.Axis.Y) ? facing1 : facing2;
        final Direction otherFace = (facing1.m_122434_() != Direction.Axis.Y) ? facing1 : facing2;
        if (facingYAxis == Direction.UP) {
            return switch (otherFace) {
                case NORTH -> NagastoneVariant.NORTH_UP;
                case SOUTH -> NagastoneVariant.SOUTH_UP;
                case WEST -> NagastoneVariant.WEST_UP;
                case EAST -> NagastoneVariant.EAST_UP;
                default -> NagastoneVariant.SOLID;
            };
        }
        return switch (otherFace) {
            case NORTH -> NagastoneVariant.NORTH_DOWN;
            case SOUTH -> NagastoneVariant.SOUTH_DOWN;
            case WEST -> NagastoneVariant.WEST_DOWN;
            case EAST -> NagastoneVariant.EAST_DOWN;
            default -> NagastoneVariant.SOLID;
        };
    }
}
