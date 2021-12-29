// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.enums;

import java.util.Locale;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.util.StringRepresentable;

public enum Diagonals implements StringRepresentable
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
        return switch (axis) {
            case X -> mirrorOnX(diagonal, mirror);
            case Z -> mirrorOnZ(diagonal, mirror);
            default -> mirror(diagonal, mirror);
        };
    }
    
    public static Diagonals mirrorOnX(final Diagonals diagonal, final Mirror mirror) {
        if (mirror == Mirror.FRONT_BACK) {
            return switch (diagonal) {
                case TOP_RIGHT -> Diagonals.BOTTOM_RIGHT;
                case BOTTOM_RIGHT -> Diagonals.TOP_RIGHT;
                case BOTTOM_LEFT -> Diagonals.TOP_LEFT;
                case TOP_LEFT -> Diagonals.BOTTOM_LEFT;
                default -> throw new IncompatibleClassChangeError();
            };
        }
        return diagonal;
    }
    
    public static Diagonals mirrorLeftRight(final Diagonals diagonal) {
        return switch (diagonal) {
            case TOP_RIGHT -> Diagonals.TOP_LEFT;
            case BOTTOM_RIGHT -> Diagonals.BOTTOM_LEFT;
            case BOTTOM_LEFT -> Diagonals.BOTTOM_RIGHT;
            case TOP_LEFT -> Diagonals.TOP_RIGHT;
            default -> throw new IncompatibleClassChangeError();
        };
    }
    
    public static Diagonals mirrorUpDown(final Diagonals diagonal) {
        return switch (diagonal) {
            case TOP_RIGHT -> Diagonals.BOTTOM_RIGHT;
            case BOTTOM_RIGHT -> Diagonals.TOP_RIGHT;
            case BOTTOM_LEFT -> Diagonals.TOP_LEFT;
            case TOP_LEFT -> Diagonals.BOTTOM_LEFT;
            default -> throw new IncompatibleClassChangeError();
        };
    }
    
    public static Diagonals mirror(final Diagonals diagonal, final Mirror mirror) {
        return switch (mirror) {
            case LEFT_RIGHT -> mirrorLeftRight(diagonal);
            case FRONT_BACK -> mirrorUpDown(diagonal);
            default -> diagonal;
        };
    }
    
    public static Diagonals mirrorOnZ(final Diagonals diagonal, final Mirror mirror) {
        if (mirror == Mirror.LEFT_RIGHT) {
            return switch (diagonal) {
                case TOP_RIGHT -> Diagonals.TOP_LEFT;
                case BOTTOM_RIGHT -> Diagonals.BOTTOM_LEFT;
                case BOTTOM_LEFT -> Diagonals.BOTTOM_RIGHT;
                case TOP_LEFT -> Diagonals.TOP_RIGHT;
                default -> throw new IncompatibleClassChangeError();
            };
        }
        return diagonal;
    }
    
    public String m_7912_() {
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
