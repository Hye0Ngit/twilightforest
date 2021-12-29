// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.util;

import java.util.Random;
import net.minecraft.util.Direction;
import net.minecraft.util.Rotation;

public final class RotationUtil
{
    public static final Rotation[] ROTATIONS;
    public static final Direction[] CARDINALS;
    
    private RotationUtil() {
    }
    
    public static Rotation getRandomRotation(final Random random) {
        return RotationUtil.ROTATIONS[random.nextInt(RotationUtil.ROTATIONS.length)];
    }
    
    public static Rotation add(final Rotation original, final int rotations) {
        return original.func_185830_a(RotationUtil.ROTATIONS[rotations + 4 & 0x3]);
    }
    
    public static Rotation subtract(final Rotation original, final Rotation rotation) {
        switch (rotation) {
            case CLOCKWISE_180: {
                switch (original) {
                    case NONE: {
                        return Rotation.CLOCKWISE_180;
                    }
                    case CLOCKWISE_90: {
                        return Rotation.COUNTERCLOCKWISE_90;
                    }
                    case CLOCKWISE_180: {
                        return Rotation.NONE;
                    }
                    case COUNTERCLOCKWISE_90: {
                        return Rotation.CLOCKWISE_90;
                    }
                    default: {
                        return original;
                    }
                }
                break;
            }
            case COUNTERCLOCKWISE_90: {
                switch (original) {
                    case NONE: {
                        return Rotation.CLOCKWISE_90;
                    }
                    case CLOCKWISE_90: {
                        return Rotation.CLOCKWISE_180;
                    }
                    case CLOCKWISE_180: {
                        return Rotation.COUNTERCLOCKWISE_90;
                    }
                    case COUNTERCLOCKWISE_90: {
                        return Rotation.NONE;
                    }
                    default: {
                        return original;
                    }
                }
                break;
            }
            case CLOCKWISE_90: {
                switch (original) {
                    case NONE: {
                        return Rotation.COUNTERCLOCKWISE_90;
                    }
                    case CLOCKWISE_90: {
                        return Rotation.NONE;
                    }
                    case CLOCKWISE_180: {
                        return Rotation.CLOCKWISE_90;
                    }
                    case COUNTERCLOCKWISE_90: {
                        return Rotation.CLOCKWISE_180;
                    }
                    default: {
                        return original;
                    }
                }
                break;
            }
            default: {
                return original;
            }
        }
    }
    
    public static Rotation getRelativeRotation(final Direction original, final Direction destination) {
        switch (original) {
            default: {
                switch (destination) {
                    default: {
                        return Rotation.NONE;
                    }
                    case SOUTH: {
                        return Rotation.CLOCKWISE_180;
                    }
                    case EAST: {
                        return Rotation.CLOCKWISE_90;
                    }
                    case WEST: {
                        return Rotation.COUNTERCLOCKWISE_90;
                    }
                }
                break;
            }
            case SOUTH: {
                switch (destination) {
                    default: {
                        return Rotation.NONE;
                    }
                    case NORTH: {
                        return Rotation.CLOCKWISE_180;
                    }
                    case WEST: {
                        return Rotation.CLOCKWISE_90;
                    }
                    case EAST: {
                        return Rotation.COUNTERCLOCKWISE_90;
                    }
                }
                break;
            }
            case EAST: {
                switch (destination) {
                    default: {
                        return Rotation.NONE;
                    }
                    case WEST: {
                        return Rotation.CLOCKWISE_180;
                    }
                    case SOUTH: {
                        return Rotation.CLOCKWISE_90;
                    }
                    case NORTH: {
                        return Rotation.COUNTERCLOCKWISE_90;
                    }
                }
                break;
            }
            case WEST: {
                switch (destination) {
                    default: {
                        return Rotation.NONE;
                    }
                    case EAST: {
                        return Rotation.CLOCKWISE_180;
                    }
                    case NORTH: {
                        return Rotation.CLOCKWISE_90;
                    }
                    case SOUTH: {
                        return Rotation.COUNTERCLOCKWISE_90;
                    }
                }
                break;
            }
        }
    }
    
    public static Direction getRandomFacing(final Random random) {
        return RotationUtil.CARDINALS[random.nextInt(RotationUtil.CARDINALS.length)];
    }
    
    static {
        ROTATIONS = Rotation.values();
        CARDINALS = new Direction[] { Direction.NORTH, Direction.SOUTH, Direction.EAST, Direction.WEST };
    }
}
