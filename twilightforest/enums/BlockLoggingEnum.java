// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.enums;

import java.util.HashMap;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.LiquidBlockContainer;
import net.minecraft.world.level.block.BucketPickup;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Fluids;
import java.util.Locale;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.util.StringRepresentable;

public enum BlockLoggingEnum implements StringRepresentable
{
    AIR(Blocks.f_50016_, Fluids.f_76191_), 
    WATER(Blocks.f_49990_, (Fluid)Fluids.f_76193_), 
    LAVA(Blocks.f_49991_, (Fluid)Fluids.f_76195_), 
    OBSIDIAN(Blocks.f_50080_, Fluids.f_76191_), 
    STONE(Blocks.f_50069_, Fluids.f_76191_), 
    BASALT(Blocks.f_50137_, Fluids.f_76191_);
    
    public static final EnumProperty<BlockLoggingEnum> MULTILOGGED;
    private final Block block;
    private final Fluid fluid;
    private final String name;
    
    private BlockLoggingEnum(final Block block, final Fluid fluid) {
        this.block = block;
        this.fluid = fluid;
        this.name = this.name().toLowerCase(Locale.ROOT);
        if (fluid != Fluids.f_76191_) {
            Ref.FLUIDS.put(fluid, this);
        }
        if (fluid == Fluids.f_76191_ && block != Blocks.f_50016_) {
            Ref.BLOCKS.put(block, this);
        }
    }
    
    public static BlockLoggingEnum getFromFluid(final Fluid fluid) {
        return Ref.FLUIDS.getOrDefault(fluid, BlockLoggingEnum.AIR);
    }
    
    public static BlockLoggingEnum getFromBlock(final Block block) {
        return Ref.BLOCKS.getOrDefault(block, BlockLoggingEnum.AIR);
    }
    
    public String m_7912_() {
        return this.name;
    }
    
    public Fluid getFluid() {
        return this.fluid;
    }
    
    public Block getBlock() {
        return this.block;
    }
    
    static {
        MULTILOGGED = EnumProperty.m_61587_("multilogged", (Class)BlockLoggingEnum.class);
    }
    
    public interface IMultiLoggable extends BucketPickup, LiquidBlockContainer
    {
        default ItemStack m_142598_(final LevelAccessor world, final BlockPos pos, final BlockState state) {
            final Fluid stateFluid = ((BlockLoggingEnum)state.m_61143_((Property)BlockLoggingEnum.MULTILOGGED)).fluid;
            if (stateFluid != Fluids.f_76191_) {
                world.m_7731_(pos, (BlockState)state.m_61124_((Property)BlockLoggingEnum.MULTILOGGED, (Comparable)BlockLoggingEnum.AIR), 3);
            }
            return new ItemStack((ItemLike)stateFluid.m_6859_());
        }
        
        default boolean m_6044_(final BlockGetter world, final BlockPos pos, final BlockState state, final Fluid fluid) {
            return state.m_61138_((Property)BlockLoggingEnum.MULTILOGGED) && Ref.FLUIDS.containsKey(fluid) && !fluid.equals(((BlockLoggingEnum)state.m_61143_((Property)BlockLoggingEnum.MULTILOGGED)).fluid);
        }
        
        default boolean m_7361_(final LevelAccessor world, final BlockPos pos, final BlockState state, final FluidState fluidState) {
            final Fluid stateFluid = ((BlockLoggingEnum)state.m_61143_((Property)BlockLoggingEnum.MULTILOGGED)).fluid;
            if (stateFluid != fluidState.m_76152_() && Ref.FLUIDS.containsKey(fluidState.m_76152_())) {
                if (!world.m_5776_()) {
                    if (stateFluid == Fluids.f_76191_) {
                        world.m_7731_(pos, (BlockState)state.m_61124_((Property)BlockLoggingEnum.MULTILOGGED, (Comparable)Ref.FLUIDS.get(fluidState.m_76152_())), 3);
                        world.m_6217_().m_5945_(pos, (Object)fluidState.m_76152_(), fluidState.m_76152_().m_6718_((LevelReader)world));
                    }
                }
                return true;
            }
            return false;
        }
    }
    
    private static class Ref
    {
        private static final HashMap<Fluid, BlockLoggingEnum> FLUIDS;
        private static final HashMap<Block, BlockLoggingEnum> BLOCKS;
        
        static {
            FLUIDS = new HashMap<Fluid, BlockLoggingEnum>();
            BLOCKS = new HashMap<Block, BlockLoggingEnum>();
        }
    }
}
