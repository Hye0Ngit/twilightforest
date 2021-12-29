// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.util;

import net.minecraft.world.level.block.Blocks;
import java.util.Random;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.DyeColor;
import java.util.function.Function;

public final class ColorUtil extends Record
{
    private final Function<DyeColor, Block> function;
    public static final ColorUtil WOOL;
    public static final ColorUtil TERRACOTTA;
    public static final ColorUtil STAINED_GLASS;
    
    public ColorUtil(final Function<DyeColor, Block> function) {
        this.function = function;
    }
    
    public BlockState getColor(final DyeColor color) {
        return this.function.apply(color).m_49966_();
    }
    
    public Block getRandomColor(final Random rand) {
        final DyeColor color = DyeColor.m_41053_(rand.nextInt(16));
        return this.getColor(color).m_60734_();
    }
    
    @Override
    public final String toString() {
        return invokedynamic(invokestatic java/lang/runtime/ObjectMethods.bootstrap:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/TypeDescriptor;Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/invoke/MethodHandle;)Ljava/lang/Object;, toString:(Ltwilightforest/util/ColorUtil;)Ljava/lang/String;twilightforest.util.ColorUtil.class, "function", getfield twilightforest/util/ColorUtil.function:()Ljava/util/function/Function;)(this);
    }
    
    @Override
    public final int hashCode() {
        return invokedynamic(invokestatic java/lang/runtime/ObjectMethods.bootstrap:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/TypeDescriptor;Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/invoke/MethodHandle;)Ljava/lang/Object;, hashCode:(Ltwilightforest/util/ColorUtil;)Itwilightforest.util.ColorUtil.class, "function", getfield twilightforest/util/ColorUtil.function:()Ljava/util/function/Function;)(this);
    }
    
    @Override
    public final boolean equals(final Object o) {
        return invokedynamic(invokestatic java/lang/runtime/ObjectMethods.bootstrap:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/TypeDescriptor;Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/invoke/MethodHandle;)Ljava/lang/Object;, equals:(Ltwilightforest/util/ColorUtil;Ljava/lang/Object;)Ztwilightforest.util.ColorUtil.class, "function", getfield twilightforest/util/ColorUtil.function:()Ljava/util/function/Function;)(this, o);
    }
    
    public Function<DyeColor, Block> function() {
        return this.function;
    }
    
    static {
        WOOL = new ColorUtil(color -> {
            return switch (color) {
                case WHITE -> Blocks.f_50041_;
                case ORANGE -> Blocks.f_50042_;
                case MAGENTA -> Blocks.f_50096_;
                case LIGHT_BLUE -> Blocks.f_50097_;
                case YELLOW -> Blocks.f_50098_;
                case LIME -> Blocks.f_50099_;
                case PINK -> Blocks.f_50100_;
                case GRAY -> Blocks.f_50101_;
                case LIGHT_GRAY -> Blocks.f_50102_;
                case CYAN -> Blocks.f_50103_;
                case PURPLE -> Blocks.f_50104_;
                case BLUE -> Blocks.f_50105_;
                case BROWN -> Blocks.f_50106_;
                case GREEN -> Blocks.f_50107_;
                case RED -> Blocks.f_50108_;
                case BLACK -> Blocks.f_50109_;
                default -> throw new IncompatibleClassChangeError();
            };
        });
        TERRACOTTA = new ColorUtil(color -> {
            return switch (color) {
                case WHITE -> Blocks.f_50287_;
                case ORANGE -> Blocks.f_50288_;
                case MAGENTA -> Blocks.f_50289_;
                case LIGHT_BLUE -> Blocks.f_50290_;
                case YELLOW -> Blocks.f_50291_;
                case LIME -> Blocks.f_50292_;
                case PINK -> Blocks.f_50293_;
                case GRAY -> Blocks.f_50294_;
                case LIGHT_GRAY -> Blocks.f_50295_;
                case CYAN -> Blocks.f_50296_;
                case PURPLE -> Blocks.f_50297_;
                case BLUE -> Blocks.f_50298_;
                case BROWN -> Blocks.f_50299_;
                case GREEN -> Blocks.f_50300_;
                case RED -> Blocks.f_50301_;
                case BLACK -> Blocks.f_50302_;
                default -> throw new IncompatibleClassChangeError();
            };
        });
        STAINED_GLASS = new ColorUtil(color -> {
            return switch (color) {
                case WHITE -> Blocks.f_50147_;
                case ORANGE -> Blocks.f_50148_;
                case MAGENTA -> Blocks.f_50202_;
                case LIGHT_BLUE -> Blocks.f_50203_;
                case YELLOW -> Blocks.f_50204_;
                case LIME -> Blocks.f_50205_;
                case PINK -> Blocks.f_50206_;
                case GRAY -> Blocks.f_50207_;
                case LIGHT_GRAY -> Blocks.f_50208_;
                case CYAN -> Blocks.f_50209_;
                case PURPLE -> Blocks.f_50210_;
                case BLUE -> Blocks.f_50211_;
                case BROWN -> Blocks.f_50212_;
                case GREEN -> Blocks.f_50213_;
                case RED -> Blocks.f_50214_;
                case BLACK -> Blocks.f_50215_;
                default -> throw new IncompatibleClassChangeError();
            };
        });
    }
}
