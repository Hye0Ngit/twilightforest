// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.enums;

import net.minecraft.util.EnumFacing;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import java.util.Locale;
import net.minecraft.util.IStringSerializable;

public enum NagastoneVariant implements IStringSerializable
{
    NORTH_HEAD, 
    SOUTH_HEAD, 
    WEST_HEAD, 
    EAST_HEAD, 
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
    
    public static boolean isHead(final NagastoneVariant variant) {
        return variant.ordinal() < 4;
    }
    
    public static NagastoneVariant rotate(final NagastoneVariant variant, final Rotation rotation) {
        if (!isHead(variant)) {
            return variant;
        }
        switch (rotation) {
            case CLOCKWISE_90: {
                switch (variant) {
                    case NORTH_HEAD: {
                        return NagastoneVariant.EAST_HEAD;
                    }
                    case SOUTH_HEAD: {
                        return NagastoneVariant.WEST_HEAD;
                    }
                    case WEST_HEAD: {
                        return NagastoneVariant.NORTH_HEAD;
                    }
                    case EAST_HEAD: {
                        return NagastoneVariant.SOUTH_HEAD;
                    }
                    default: {
                        return variant;
                    }
                }
                break;
            }
            case CLOCKWISE_180: {
                switch (variant) {
                    case NORTH_HEAD: {
                        return NagastoneVariant.SOUTH_HEAD;
                    }
                    case SOUTH_HEAD: {
                        return NagastoneVariant.NORTH_HEAD;
                    }
                    case WEST_HEAD: {
                        return NagastoneVariant.EAST_HEAD;
                    }
                    case EAST_HEAD: {
                        return NagastoneVariant.WEST_HEAD;
                    }
                    default: {
                        return variant;
                    }
                }
                break;
            }
            case COUNTERCLOCKWISE_90: {
                switch (variant) {
                    case NORTH_HEAD: {
                        return NagastoneVariant.WEST_HEAD;
                    }
                    case SOUTH_HEAD: {
                        return NagastoneVariant.EAST_HEAD;
                    }
                    case WEST_HEAD: {
                        return NagastoneVariant.SOUTH_HEAD;
                    }
                    case EAST_HEAD: {
                        return NagastoneVariant.NORTH_HEAD;
                    }
                    default: {
                        return variant;
                    }
                }
                break;
            }
            default: {
                return variant;
            }
        }
    }
    
    public static NagastoneVariant mirror(final NagastoneVariant variant, final Mirror mirror) {
        if (!isHead(variant)) {
            return variant;
        }
        switch (mirror) {
            case LEFT_RIGHT: {
                switch (variant) {
                    case WEST_HEAD: {
                        return NagastoneVariant.EAST_HEAD;
                    }
                    case EAST_HEAD: {
                        return NagastoneVariant.WEST_HEAD;
                    }
                    default: {
                        return variant;
                    }
                }
                break;
            }
            case FRONT_BACK: {
                switch (variant) {
                    case NORTH_HEAD: {
                        return NagastoneVariant.SOUTH_HEAD;
                    }
                    case SOUTH_HEAD: {
                        return NagastoneVariant.NORTH_HEAD;
                    }
                    default: {
                        return variant;
                    }
                }
                break;
            }
            default: {
                return variant;
            }
        }
    }
    
    public static NagastoneVariant getHeadFromFacing(final EnumFacing facing) {
        switch (facing) {
            case NORTH: {
                return NagastoneVariant.NORTH_HEAD;
            }
            case SOUTH: {
                return NagastoneVariant.SOUTH_HEAD;
            }
            case WEST: {
                return NagastoneVariant.WEST_HEAD;
            }
            case EAST: {
                return NagastoneVariant.EAST_HEAD;
            }
            default: {
                return NagastoneVariant.SOLID;
            }
        }
    }
    
    public static NagastoneVariant getVariantFromAxis(final EnumFacing.Axis axis) {
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
    
    public static NagastoneVariant getVariantFromDoubleFacing(final EnumFacing facing1, final EnumFacing facing2) {
        if (facing1.func_176740_k() == facing2.func_176740_k()) {
            return getVariantFromAxis(facing1.func_176740_k());
        }
        if (facing1.func_176740_k() != EnumFacing.Axis.Y && facing2.func_176740_k() != EnumFacing.Axis.Y) {
            return NagastoneVariant.SOLID;
        }
        final EnumFacing facingYAxis = (facing1.func_176740_k() == EnumFacing.Axis.Y) ? facing1 : facing2;
        final EnumFacing otherFace = (facing1.func_176740_k() != EnumFacing.Axis.Y) ? facing1 : facing2;
        if (facingYAxis == EnumFacing.UP) {
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
