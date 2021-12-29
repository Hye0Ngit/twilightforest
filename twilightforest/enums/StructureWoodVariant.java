// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.enums;

import twilightforest.block.TFBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.block.AbstractButtonBlock;
import net.minecraft.block.HorizontalFaceBlock;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.FenceBlock;
import net.minecraft.state.properties.SlabType;
import net.minecraft.block.SlabBlock;
import net.minecraft.state.Property;
import net.minecraft.block.BlockState;
import javax.annotation.Nullable;
import java.util.Locale;
import net.minecraft.block.StairsBlock;
import java.util.function.Supplier;
import java.util.Arrays;
import net.minecraft.block.Block;
import java.util.List;
import net.minecraft.util.IStringSerializable;

public enum StructureWoodVariant implements IStringSerializable
{
    OAK(Blocks.field_196662_n, Blocks.field_150476_ad, Blocks.field_196622_bq, Blocks.field_196689_eF, Blocks.field_180407_aO, Blocks.field_180390_bo, Blocks.field_196663_cq), 
    SPRUCE(Blocks.field_196664_o, Blocks.field_150485_bF, Blocks.field_196624_br, Blocks.field_196691_eG, Blocks.field_180408_aP, Blocks.field_180391_bp, Blocks.field_196665_cr), 
    BIRCH(Blocks.field_196666_p, Blocks.field_150487_bG, Blocks.field_196627_bs, Blocks.field_196693_eH, Blocks.field_180404_aQ, Blocks.field_180392_bq, Blocks.field_196667_cs), 
    JUNGLE(Blocks.field_196668_q, Blocks.field_150481_bH, Blocks.field_196630_bt, Blocks.field_196695_eI, Blocks.field_180403_aR, Blocks.field_180386_br, Blocks.field_196669_ct), 
    ACACIA(Blocks.field_196670_r, Blocks.field_150400_ck, Blocks.field_196632_bu, Blocks.field_196697_eJ, Blocks.field_180405_aT, Blocks.field_180387_bt, Blocks.field_196671_cu), 
    DARK_OAK(Blocks.field_196672_s, Blocks.field_150401_cl, Blocks.field_196635_bv, Blocks.field_196699_eK, Blocks.field_180406_aS, Blocks.field_180385_bs, Blocks.field_196673_cv), 
    TWILIGHT_OAK((Supplier<Block>)TFBlocks.twilight_oak_planks, (Supplier<StairsBlock>)TFBlocks.twilight_oak_stairs, (Supplier<Block>)TFBlocks.twilight_oak_slab, (Supplier<Block>)TFBlocks.twilight_oak_button, (Supplier<Block>)TFBlocks.twilight_oak_fence, (Supplier<Block>)TFBlocks.twilight_oak_gate, (Supplier<Block>)TFBlocks.twilight_oak_plate), 
    CANOPY((Supplier<Block>)TFBlocks.canopy_planks, (Supplier<StairsBlock>)TFBlocks.canopy_stairs, (Supplier<Block>)TFBlocks.canopy_slab, (Supplier<Block>)TFBlocks.canopy_button, (Supplier<Block>)TFBlocks.canopy_fence, (Supplier<Block>)TFBlocks.canopy_gate, (Supplier<Block>)TFBlocks.canopy_plate), 
    MANGROVE((Supplier<Block>)TFBlocks.mangrove_planks, (Supplier<StairsBlock>)TFBlocks.mangrove_stairs, (Supplier<Block>)TFBlocks.mangrove_slab, (Supplier<Block>)TFBlocks.mangrove_button, (Supplier<Block>)TFBlocks.mangrove_fence, (Supplier<Block>)TFBlocks.mangrove_gate, (Supplier<Block>)TFBlocks.mangrove_plate), 
    DARK((Supplier<Block>)TFBlocks.dark_planks, (Supplier<StairsBlock>)TFBlocks.dark_stairs, (Supplier<Block>)TFBlocks.dark_slab, (Supplier<Block>)TFBlocks.dark_button, (Supplier<Block>)TFBlocks.dark_fence, (Supplier<Block>)TFBlocks.dark_gate, (Supplier<Block>)TFBlocks.dark_plate), 
    TIME((Supplier<Block>)TFBlocks.time_planks, (Supplier<StairsBlock>)TFBlocks.time_stairs, (Supplier<Block>)TFBlocks.time_slab, (Supplier<Block>)TFBlocks.time_button, (Supplier<Block>)TFBlocks.time_fence, (Supplier<Block>)TFBlocks.time_gate, (Supplier<Block>)TFBlocks.time_plate), 
    TRANS((Supplier<Block>)TFBlocks.trans_planks, (Supplier<StairsBlock>)TFBlocks.trans_stairs, (Supplier<Block>)TFBlocks.trans_slab, (Supplier<Block>)TFBlocks.trans_button, (Supplier<Block>)TFBlocks.trans_fence, (Supplier<Block>)TFBlocks.trans_gate, (Supplier<Block>)TFBlocks.trans_plate), 
    MINE((Supplier<Block>)TFBlocks.mine_planks, (Supplier<StairsBlock>)TFBlocks.mine_stairs, (Supplier<Block>)TFBlocks.mine_slab, (Supplier<Block>)TFBlocks.mine_button, (Supplier<Block>)TFBlocks.mine_fence, (Supplier<Block>)TFBlocks.mine_gate, (Supplier<Block>)TFBlocks.mine_plate), 
    SORT((Supplier<Block>)TFBlocks.sort_planks, (Supplier<StairsBlock>)TFBlocks.sort_stairs, (Supplier<Block>)TFBlocks.sort_slab, (Supplier<Block>)TFBlocks.sort_button, (Supplier<Block>)TFBlocks.sort_fence, (Supplier<Block>)TFBlocks.sort_gate, (Supplier<Block>)TFBlocks.sort_plate);
    
    private final List<Block> blocks;
    private final Block planks;
    private final Block stairs;
    private final Block slab;
    private final Block button;
    private final Block fence;
    private final Block gate;
    private final Block plate;
    
    private StructureWoodVariant(final Block planks, final Block stairs, final Block slab, final Block button, final Block fence, final Block gate, final Block plate) {
        this.planks = planks;
        this.stairs = stairs;
        this.slab = slab;
        this.button = button;
        this.fence = fence;
        this.gate = gate;
        this.plate = plate;
        this.blocks = Arrays.asList(planks, stairs, slab, button, fence, gate, plate);
    }
    
    private StructureWoodVariant(final Supplier<Block> planks, final Supplier<StairsBlock> stairs, final Supplier<Block> slab, final Supplier<Block> button, final Supplier<Block> fence, final Supplier<Block> gate, final Supplier<Block> plate) {
        this.planks = planks.get();
        this.stairs = (Block)stairs.get();
        this.slab = slab.get();
        this.button = button.get();
        this.fence = fence.get();
        this.gate = gate.get();
        this.plate = plate.get();
        this.blocks = Arrays.asList(planks.get(), (Block)stairs.get(), slab.get(), button.get(), fence.get(), gate.get(), plate.get());
    }
    
    public String func_176610_l() {
        return this.name().toLowerCase(Locale.ROOT);
    }
    
    @Nullable
    public static StructureWoodVariant getVariantFromBlock(final Block block) {
        for (final StructureWoodVariant var : values()) {
            if (var.blocks.contains(block)) {
                return var;
            }
        }
        return null;
    }
    
    public static boolean isPlanks(final BlockState stateIn) {
        return isPlanks(stateIn.func_177230_c());
    }
    
    public static boolean isPlanks(final Block block) {
        final StructureWoodVariant var = getVariantFromBlock(block);
        return var != null && var.planks == block;
    }
    
    public static BlockState modifyBlockWithType(final BlockState stateIn, final StructureWoodVariant target) {
        final Block block = stateIn.func_177230_c();
        WoodShapes shape = getWoodShapeFromBlock(block);
        final ResourceLocation blockRegName = block.getRegistryName();
        if (blockRegName == null) {
            return stateIn;
        }
        if (isPlanks(stateIn)) {
            shape = WoodShapes.BLOCK;
        }
        if (shape == WoodShapes.INVALID || (!"minecraft".equals(blockRegName.func_110624_b()) && !"twilightforest".equals(blockRegName.func_110624_b()))) {
            return stateIn;
        }
        switch (shape) {
            case BLOCK: {
                return target.planks.func_176223_P();
            }
            case STAIRS: {
                return transferStateKeys(stateIn, target.stairs.func_176223_P(), (Property)StairsBlock.field_176309_a, (Property)StairsBlock.field_176308_b, (Property)StairsBlock.field_176310_M);
            }
            case SLAB: {
                return transferStateKey(stateIn, target.slab.func_176223_P(), (net.minecraft.state.Property<Comparable>)SlabBlock.field_196505_a);
            }
            case DOUBLESLAB: {
                return (BlockState)target.slab.func_176223_P().func_206870_a((Property)SlabBlock.field_196505_a, (Comparable)SlabType.DOUBLE);
            }
            case FENCE: {
                return transferStateKeys(stateIn, target.fence.func_176223_P(), (Property)FenceBlock.field_196409_a, (Property)FenceBlock.field_196411_b, (Property)FenceBlock.field_196414_y, (Property)FenceBlock.field_196413_c);
            }
            case GATE: {
                return transferStateKeys(stateIn, target.gate.func_176223_P(), (Property)FenceGateBlock.field_185512_D, (Property)FenceGateBlock.field_176466_a, (Property)FenceGateBlock.field_176465_b, (Property)FenceGateBlock.field_176467_M);
            }
            case BUTTON: {
                return transferStateKeys(stateIn, target.button.func_176223_P(), (Property)HorizontalFaceBlock.field_196366_M, (Property)AbstractButtonBlock.field_176584_b);
            }
            case PLATE: {
                return transferStateKey(stateIn, target.plate.func_176223_P(), (net.minecraft.state.Property<Comparable>)PressurePlateBlock.field_176580_a);
            }
            default: {
                return stateIn;
            }
        }
    }
    
    public static BlockState transferStateKeys(final BlockState stateIn, BlockState stateOut, final Property<?>... properties) {
        for (final Property<?> property : properties) {
            stateOut = transferStateKey(stateIn, stateOut, property);
        }
        return stateOut;
    }
    
    public static <T extends Comparable<T>> BlockState transferStateKey(final BlockState stateIn, final BlockState stateOut, final Property<T> property) {
        return (BlockState)stateOut.func_206870_a((Property)property, stateIn.func_177229_b((Property)property));
    }
    
    public static WoodShapes getWoodShapeFromBlock(final Block b) {
        if (isPlanks(b)) {
            return WoodShapes.BLOCK;
        }
        if (b instanceof StairsBlock) {
            return WoodShapes.STAIRS;
        }
        if (b instanceof SlabBlock) {
            if (b.func_176223_P().func_177229_b((Property)SlabBlock.field_196505_a) == SlabType.DOUBLE) {
                return WoodShapes.DOUBLESLAB;
            }
            return WoodShapes.SLAB;
        }
        else {
            if (b instanceof AbstractButtonBlock) {
                return WoodShapes.BUTTON;
            }
            if (b instanceof FenceBlock) {
                return WoodShapes.FENCE;
            }
            if (b instanceof FenceGateBlock) {
                return WoodShapes.GATE;
            }
            if (b instanceof PressurePlateBlock) {
                return WoodShapes.PLATE;
            }
            return WoodShapes.INVALID;
        }
    }
    
    public enum WoodShapes
    {
        BLOCK, 
        STAIRS, 
        SLAB, 
        DOUBLESLAB, 
        BUTTON, 
        FENCE, 
        GATE, 
        PLATE, 
        INVALID;
    }
}
