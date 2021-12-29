// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.enums;

import java.util.Locale;
import net.minecraft.util.Mirror;
import net.minecraft.util.Direction;
import net.minecraft.util.Rotation;
import net.minecraft.util.IStringSerializable;

public enum Diagonals implements IStringSerializable
{
    TOP_RIGHT((x, rX) -> rX - x, (y, rY) -> y, true, false), 
    BOTTOM_RIGHT((x, rX) -> rX - x, (y, rY) -> rY - y, false, false), 
    BOTTOM_LEFT((x, rX) -> x, (y, rY) -> rY - y, false, true), 
    TOP_LEFT((x, rX) -> x, (y, rY) -> y, true, true);
    
    public final Inversion operationX;
    public final Inversion operationY;
    private final boolean isTop;
    private final boolean isLeft;
    
    private Diagonals(final Inversion operationX, final Inversion operationY, final boolean isTop, final boolean isLeft) {
        this.operationX = operationX;
        this.operationY = operationY;
        this.isTop = isTop;
        this.isLeft = isLeft;
    }
    
    public static Diagonals getDiagonalFromUpDownLeftRight(final boolean isLeft, final boolean isTop) {
        if (isLeft) {
            return isTop ? Diagonals.TOP_LEFT : Diagonals.BOTTOM_LEFT;
        }
        return isTop ? Diagonals.TOP_RIGHT : Diagonals.BOTTOM_RIGHT;
    }
    
    public static Diagonals rotate(final Diagonals diagonal, final Rotation rotation) {
        return values()[(diagonal.ordinal() + rotation.ordinal()) % 4];
    }
    
    public static Diagonals mirrorOn(final Direction.Axis axis, final Diagonals diagonal, final Mirror mirror) {
        switch (axis) {
            case X: {
                return mirrorOnX(diagonal, mirror);
            }
            case Z: {
                return mirrorOnZ(diagonal, mirror);
            }
            default: {
                return mirror(diagonal, mirror);
            }
        }
    }
    
    public static Diagonals mirrorOnX(final Diagonals diagonal, final Mirror mirror) {
        switch (mirror) {
            case FRONT_BACK: {
                switch (diagonal) {
                    case TOP_RIGHT: {
                        return Diagonals.BOTTOM_RIGHT;
                    }
                    case BOTTOM_RIGHT: {
                        return Diagonals.TOP_RIGHT;
                    }
                    case BOTTOM_LEFT: {
                        return Diagonals.TOP_LEFT;
                    }
                    case TOP_LEFT: {
                        return Diagonals.BOTTOM_LEFT;
                    }
                    default: {
                        return diagonal;
                    }
                }
                break;
            }
            default: {
                return diagonal;
            }
        }
    }
    
    public static Diagonals mirrorLeftRight(final Diagonals diagonal) {
        switch (diagonal) {
            case TOP_RIGHT: {
                return Diagonals.TOP_LEFT;
            }
            case BOTTOM_RIGHT: {
                return Diagonals.BOTTOM_LEFT;
            }
            case BOTTOM_LEFT: {
                return Diagonals.BOTTOM_RIGHT;
            }
            case TOP_LEFT: {
                return Diagonals.TOP_RIGHT;
            }
            default: {
                return diagonal;
            }
        }
    }
    
    public static Diagonals mirrorUpDown(final Diagonals diagonal) {
        switch (diagonal) {
            case TOP_RIGHT: {
                return Diagonals.BOTTOM_RIGHT;
            }
            case BOTTOM_RIGHT: {
                return Diagonals.TOP_RIGHT;
            }
            case BOTTOM_LEFT: {
                return Diagonals.TOP_LEFT;
            }
            case TOP_LEFT: {
                return Diagonals.BOTTOM_LEFT;
            }
            default: {
                return diagonal;
            }
        }
    }
    
    public static Diagonals mirror(final Diagonals diagonal, final Mirror mirror) {
        switch (mirror) {
            case LEFT_RIGHT: {
                return mirrorLeftRight(diagonal);
            }
            case FRONT_BACK: {
                return mirrorUpDown(diagonal);
            }
            default: {
                return diagonal;
            }
        }
    }
    
    public static Diagonals mirrorOnZ(final Diagonals diagonal, final Mirror mirror) {
        switch (mirror) {
            case LEFT_RIGHT: {
                switch (diagonal) {
                    case TOP_RIGHT: {
                        return Diagonals.TOP_LEFT;
                    }
                    case BOTTOM_RIGHT: {
                        return Diagonals.BOTTOM_LEFT;
                    }
                    case BOTTOM_LEFT: {
                        return Diagonals.BOTTOM_RIGHT;
                    }
                    case TOP_LEFT: {
                        return Diagonals.TOP_RIGHT;
                    }
                    default: {
                        return diagonal;
                    }
                }
                break;
            }
            default: {
                return diagonal;
            }
        }
    }
    
    public String func_176610_l() {
        return this.name().toLowerCase(Locale.ROOT);
    }
    
    public boolean isTop() {
        return this.isTop;
    }
    
    public boolean isLeft() {
        return this.isLeft;
    }
    
    public interface Inversion
    {
        int convert(final int p0, final int p1);
    }
}
