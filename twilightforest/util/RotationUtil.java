// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.util;

import java.util.Random;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Rotation;

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
        return original.m_55952_(RotationUtil.ROTATIONS[rotations + 4 & 0x3]);
    }
    
    public static Rotation subtract(final Rotation original, final Rotation rotation) {
        Rotation rotation2 = null;
        Label_0253: {
            switch (rotation) {
                case CLOCKWISE_180: {
                    switch (original) {
                        case NONE: {
                            rotation2 = Rotation.CLOCKWISE_180;
                            break Label_0253;
                        }
                        case CLOCKWISE_90: {
                            rotation2 = Rotation.COUNTERCLOCKWISE_90;
                            break Label_0253;
                        }
                        case CLOCKWISE_180: {
                            rotation2 = Rotation.NONE;
                            break Label_0253;
                        }
                        case COUNTERCLOCKWISE_90: {
                            rotation2 = Rotation.CLOCKWISE_90;
                            break Label_0253;
                        }
                        default: {
                            throw new IncompatibleClassChangeError();
                        }
                    }
                    break;
                }
                case COUNTERCLOCKWISE_90: {
                    switch (original) {
                        case NONE: {
                            rotation2 = Rotation.CLOCKWISE_90;
                            break Label_0253;
                        }
                        case CLOCKWISE_90: {
                            rotation2 = Rotation.CLOCKWISE_180;
                            break Label_0253;
                        }
                        case CLOCKWISE_180: {
                            rotation2 = Rotation.COUNTERCLOCKWISE_90;
                            break Label_0253;
                        }
                        case COUNTERCLOCKWISE_90: {
                            rotation2 = Rotation.NONE;
                            break Label_0253;
                        }
                        default: {
                            throw new IncompatibleClassChangeError();
                        }
                    }
                    break;
                }
                case CLOCKWISE_90: {
                    switch (original) {
                        case NONE: {
                            rotation2 = Rotation.COUNTERCLOCKWISE_90;
                            break Label_0253;
                        }
                        case CLOCKWISE_90: {
                            rotation2 = Rotation.NONE;
                            break Label_0253;
                        }
                        case CLOCKWISE_180: {
                            rotation2 = Rotation.CLOCKWISE_90;
                            break Label_0253;
                        }
                        case COUNTERCLOCKWISE_90: {
                            rotation2 = Rotation.CLOCKWISE_180;
                            break Label_0253;
                        }
                        default: {
                            throw new IncompatibleClassChangeError();
                        }
                    }
                    break;
                }
                default: {
                    rotation2 = original;
                    break;
                }
            }
        }
        return rotation2;
    }
    
    public static Rotation getRelativeRotation(final Direction original, final Direction destination) {
        Rotation rotation = null;
        Label_0281: {
            switch (original) {
                case SOUTH: {
                    switch (destination) {
                        case NORTH: {
                            rotation = Rotation.CLOCKWISE_180;
                            break Label_0281;
                        }
                        case WEST: {
                            rotation = Rotation.CLOCKWISE_90;
                            break Label_0281;
                        }
                        case EAST: {
                            rotation = Rotation.COUNTERCLOCKWISE_90;
                            break Label_0281;
                        }
                        default: {
                            rotation = Rotation.NONE;
                            break Label_0281;
                        }
                    }
                    break;
                }
                case EAST: {
                    switch (destination) {
                        case WEST: {
                            rotation = Rotation.CLOCKWISE_180;
                            break Label_0281;
                        }
                        case SOUTH: {
                            rotation = Rotation.CLOCKWISE_90;
                            break Label_0281;
                        }
                        case NORTH: {
                            rotation = Rotation.COUNTERCLOCKWISE_90;
                            break Label_0281;
                        }
                        default: {
                            rotation = Rotation.NONE;
                            break Label_0281;
                        }
                    }
                    break;
                }
                case WEST: {
                    switch (destination) {
                        case EAST: {
                            rotation = Rotation.CLOCKWISE_180;
                            break Label_0281;
                        }
                        case NORTH: {
                            rotation = Rotation.CLOCKWISE_90;
                            break Label_0281;
                        }
                        case SOUTH: {
                            rotation = Rotation.COUNTERCLOCKWISE_90;
                            break Label_0281;
                        }
                        default: {
                            rotation = Rotation.NONE;
                            break Label_0281;
                        }
                    }
                    break;
                }
                default: {
                    switch (destination) {
                        case SOUTH: {
                            rotation = Rotation.CLOCKWISE_180;
                            break Label_0281;
                        }
                        case EAST: {
                            rotation = Rotation.CLOCKWISE_90;
                            break Label_0281;
                        }
                        case WEST: {
                            rotation = Rotation.COUNTERCLOCKWISE_90;
                            break Label_0281;
                        }
                        default: {
                            rotation = Rotation.NONE;
                            break Label_0281;
                        }
                    }
                    break;
                }
            }
        }
        return rotation;
    }
    
    public static Direction getRandomFacing(final Random random) {
        return RotationUtil.CARDINALS[random.nextInt(RotationUtil.CARDINALS.length)];
    }
    
    static {
        ROTATIONS = Rotation.values();
        CARDINALS = new Direction[] { Direction.NORTH, Direction.SOUTH, Direction.EAST, Direction.WEST };
    }
}
