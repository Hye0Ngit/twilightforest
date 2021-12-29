// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.enums;

import java.util.HashMap;
import net.minecraft.world.IWorldReader;
import net.minecraft.fluid.FluidState;
import net.minecraft.world.IBlockReader;
import net.minecraft.state.Property;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.block.ILiquidContainer;
import net.minecraft.block.IBucketPickupHandler;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.Fluids;
import java.util.Locale;
import net.minecraft.fluid.Fluid;
import net.minecraft.block.Block;
import net.minecraft.state.EnumProperty;
import net.minecraft.util.IStringSerializable;

public enum BlockLoggingEnum implements IStringSerializable
{
    AIR(Blocks.field_150350_a, Fluids.field_204541_a), 
    WATER(Blocks.field_150355_j, (Fluid)Fluids.field_204546_a), 
    LAVA(Blocks.field_150353_l, (Fluid)Fluids.field_204547_b), 
    OBSIDIAN(Blocks.field_150343_Z, Fluids.field_204541_a), 
    STONE(Blocks.field_150348_b, Fluids.field_204541_a), 
    BASALT(Blocks.field_235337_cO_, Fluids.field_204541_a);
    
    public static final EnumProperty<BlockLoggingEnum> MULTILOGGED;
    private final Block block;
    private final Fluid fluid;
    private final String name;
    
    private BlockLoggingEnum(final Block block, final Fluid fluid) {
        this.block = block;
        this.fluid = fluid;
        this.name = this.name().toLowerCase(Locale.ROOT);
        if (fluid != Fluids.field_204541_a) {
            Ref.FLUIDS.put(fluid, this);
        }
        if (fluid == Fluids.field_204541_a && block != Blocks.field_150350_a) {
            Ref.BLOCKS.put(block, this);
        }
    }
    
    public static BlockLoggingEnum getFromFluid(final Fluid fluid) {
        return Ref.FLUIDS.getOrDefault(fluid, BlockLoggingEnum.AIR);
    }
    
    public static BlockLoggingEnum getFromBlock(final Block block) {
        return Ref.BLOCKS.getOrDefault(block, BlockLoggingEnum.AIR);
    }
    
    public String func_176610_l() {
        return this.name;
    }
    
    public Fluid getFluid() {
        return this.fluid;
    }
    
    public Block getBlock() {
        return this.block;
    }
    
    static {
        MULTILOGGED = EnumProperty.func_177709_a("multilogged", (Class)BlockLoggingEnum.class);
    }
    
    public interface IMultiLoggable extends IBucketPickupHandler, ILiquidContainer
    {
        default Fluid func_204508_a(final IWorld world, final BlockPos pos, final BlockState state) {
            final Fluid stateFluid = ((BlockLoggingEnum)state.func_177229_b((Property)BlockLoggingEnum.MULTILOGGED)).fluid;
            if (stateFluid != Fluids.field_204541_a) {
                world.func_180501_a(pos, (BlockState)state.func_206870_a((Property)BlockLoggingEnum.MULTILOGGED, (Comparable)BlockLoggingEnum.AIR), 3);
            }
            return stateFluid;
        }
        
        default boolean func_204510_a(final IBlockReader world, final BlockPos pos, final BlockState state, final Fluid fluid) {
            return state.func_235901_b_((Property)BlockLoggingEnum.MULTILOGGED) && Ref.FLUIDS.containsKey(fluid) && !fluid.equals(((BlockLoggingEnum)state.func_177229_b((Property)BlockLoggingEnum.MULTILOGGED)).fluid);
        }
        
        default boolean func_204509_a(final IWorld world, final BlockPos pos, final BlockState state, final FluidState fluidState) {
            final Fluid stateFluid = ((BlockLoggingEnum)state.func_177229_b((Property)BlockLoggingEnum.MULTILOGGED)).fluid;
            if (stateFluid != fluidState.func_206886_c() && Ref.FLUIDS.containsKey(fluidState.func_206886_c())) {
                if (!world.func_201670_d()) {
                    if (stateFluid == Fluids.field_204541_a) {
                        world.func_180501_a(pos, (BlockState)state.func_206870_a((Property)BlockLoggingEnum.MULTILOGGED, (Comparable)Ref.FLUIDS.get(fluidState.func_206886_c())), 3);
                        world.func_205219_F_().func_205360_a(pos, (Object)fluidState.func_206886_c(), fluidState.func_206886_c().func_205569_a((IWorldReader)world));
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
