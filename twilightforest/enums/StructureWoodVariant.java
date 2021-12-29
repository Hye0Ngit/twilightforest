// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.enums;

import twilightforest.block.TFBlocks;
import twilightforest.block.BlockTF;
import net.minecraft.util.ResourceLocation;
import net.minecraft.block.BlockPressurePlate;
import net.minecraft.block.BlockButton;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockFence;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.BlockStairs;
import javax.annotation.Nullable;
import net.minecraft.init.Blocks;
import net.minecraft.block.BlockWoodSlab;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.state.IBlockState;
import java.util.Locale;
import net.minecraft.block.Block;
import net.minecraft.util.IStringSerializable;

public enum StructureWoodVariant implements IStringSerializable
{
    OAK(Blocks.field_150344_f, Blocks.field_150476_ad, (Block)Blocks.field_150376_bx, (Block)Blocks.field_150373_bw, Blocks.field_150471_bO, Blocks.field_180407_aO, Blocks.field_180390_bo, Blocks.field_150452_aw), 
    SPRUCE(Blocks.field_150344_f, Blocks.field_150485_bF, (Block)Blocks.field_150376_bx, (Block)Blocks.field_150373_bw, Blocks.field_150471_bO, Blocks.field_180408_aP, Blocks.field_180391_bp, Blocks.field_150452_aw), 
    BIRCH(Blocks.field_150344_f, Blocks.field_150487_bG, (Block)Blocks.field_150376_bx, (Block)Blocks.field_150373_bw, Blocks.field_150471_bO, Blocks.field_180404_aQ, Blocks.field_180392_bq, Blocks.field_150452_aw), 
    JUNGLE(Blocks.field_150344_f, Blocks.field_150481_bH, (Block)Blocks.field_150376_bx, (Block)Blocks.field_150373_bw, Blocks.field_150471_bO, Blocks.field_180403_aR, Blocks.field_180386_br, Blocks.field_150452_aw), 
    ACACIA(Blocks.field_150344_f, Blocks.field_150400_ck, (Block)Blocks.field_150376_bx, (Block)Blocks.field_150373_bw, Blocks.field_150471_bO, Blocks.field_180405_aT, Blocks.field_180387_bt, Blocks.field_150452_aw), 
    DARK_OAK(Blocks.field_150344_f, Blocks.field_150401_cl, (Block)Blocks.field_150376_bx, (Block)Blocks.field_150373_bw, Blocks.field_150471_bO, Blocks.field_180406_aS, Blocks.field_180385_bs, Blocks.field_150452_aw), 
    TWILIGHT_OAK((Block)TFBlocks.twilight_oak_planks, (Block)TFBlocks.twilight_oak_stairs, (Block)TFBlocks.twilight_oak_slab, (Block)TFBlocks.twilight_oak_doubleslab, (Block)TFBlocks.twilight_oak_button, (Block)TFBlocks.twilight_oak_fence, (Block)TFBlocks.twilight_oak_gate, (Block)TFBlocks.twilight_oak_plate), 
    CANOPY((Block)TFBlocks.canopy_planks, (Block)TFBlocks.canopy_stairs, (Block)TFBlocks.canopy_slab, (Block)TFBlocks.canopy_doubleslab, (Block)TFBlocks.canopy_button, (Block)TFBlocks.canopy_fence, (Block)TFBlocks.canopy_gate, (Block)TFBlocks.canopy_plate), 
    MANGROVE((Block)TFBlocks.mangrove_planks, (Block)TFBlocks.mangrove_stairs, (Block)TFBlocks.mangrove_slab, (Block)TFBlocks.mangrove_doubleslab, (Block)TFBlocks.mangrove_button, (Block)TFBlocks.mangrove_fence, (Block)TFBlocks.mangrove_gate, (Block)TFBlocks.mangrove_plate), 
    DARK((Block)TFBlocks.dark_planks, (Block)TFBlocks.dark_stairs, (Block)TFBlocks.dark_slab, (Block)TFBlocks.dark_doubleslab, (Block)TFBlocks.dark_button, (Block)TFBlocks.dark_fence, (Block)TFBlocks.dark_gate, (Block)TFBlocks.dark_plate), 
    TIME((Block)TFBlocks.time_planks, (Block)TFBlocks.time_stairs, (Block)TFBlocks.time_slab, (Block)TFBlocks.time_doubleslab, (Block)TFBlocks.time_button, (Block)TFBlocks.time_fence, (Block)TFBlocks.time_gate, (Block)TFBlocks.time_plate), 
    TRANS((Block)TFBlocks.trans_planks, (Block)TFBlocks.trans_stairs, (Block)TFBlocks.trans_slab, (Block)TFBlocks.trans_doubleslab, (Block)TFBlocks.trans_button, (Block)TFBlocks.trans_fence, (Block)TFBlocks.trans_gate, (Block)TFBlocks.trans_plate), 
    MINE((Block)TFBlocks.mine_planks, (Block)TFBlocks.mine_stairs, (Block)TFBlocks.mine_slab, (Block)TFBlocks.mine_doubleslab, (Block)TFBlocks.mine_button, (Block)TFBlocks.mine_fence, (Block)TFBlocks.mine_gate, (Block)TFBlocks.mine_plate), 
    SORT((Block)TFBlocks.sort_planks, (Block)TFBlocks.sort_stairs, (Block)TFBlocks.sort_slab, (Block)TFBlocks.sort_doubleslab, (Block)TFBlocks.sort_button, (Block)TFBlocks.sort_fence, (Block)TFBlocks.sort_gate, (Block)TFBlocks.sort_plate);
    
    private final Block planks;
    private final Block stairs;
    private final Block slab;
    private final Block doubleSlab;
    private final Block button;
    private final Block fence;
    private final Block gate;
    private final Block plate;
    
    private StructureWoodVariant(final Block planks, final Block stairs, final Block slab, final Block doubleSlab, final Block button, final Block fence, final Block gate, final Block plate) {
        this.planks = planks;
        this.stairs = stairs;
        this.slab = slab;
        this.doubleSlab = doubleSlab;
        this.button = button;
        this.fence = fence;
        this.gate = gate;
        this.plate = plate;
    }
    
    public String func_176610_l() {
        return this.name().toLowerCase(Locale.ROOT);
    }
    
    @Nullable
    public static BlockPlanks.EnumType getTypeFromBlockState(final IBlockState stateIn) {
        final Block block = stateIn.func_177230_c();
        if (!"minecraft".equals(block.getRegistryName().func_110624_b())) {
            return null;
        }
        switch (getWoodShapeFromBlock(block)) {
            case BLOCK: {
                if (stateIn.func_177230_c() instanceof BlockPlanks) {
                    return (BlockPlanks.EnumType)stateIn.func_177229_b((IProperty)BlockPlanks.field_176383_a);
                }
                return null;
            }
            case SLAB:
            case DOUBLESLAB: {
                if (stateIn.func_177230_c() instanceof BlockWoodSlab) {
                    return (BlockPlanks.EnumType)stateIn.func_177229_b((IProperty)BlockPlanks.field_176383_a);
                }
                return null;
            }
            case STAIRS: {
                if (block == Blocks.field_150476_ad) {
                    return BlockPlanks.EnumType.OAK;
                }
                if (block == Blocks.field_150485_bF) {
                    return BlockPlanks.EnumType.SPRUCE;
                }
                if (block == Blocks.field_150487_bG) {
                    return BlockPlanks.EnumType.BIRCH;
                }
                if (block == Blocks.field_150481_bH) {
                    return BlockPlanks.EnumType.JUNGLE;
                }
                if (block == Blocks.field_150400_ck) {
                    return BlockPlanks.EnumType.ACACIA;
                }
                if (block == Blocks.field_150401_cl) {
                    return BlockPlanks.EnumType.DARK_OAK;
                }
                return null;
            }
            case FENCE: {
                if (block == Blocks.field_180407_aO) {
                    return BlockPlanks.EnumType.OAK;
                }
                if (block == Blocks.field_180408_aP) {
                    return BlockPlanks.EnumType.SPRUCE;
                }
                if (block == Blocks.field_180404_aQ) {
                    return BlockPlanks.EnumType.BIRCH;
                }
                if (block == Blocks.field_180403_aR) {
                    return BlockPlanks.EnumType.JUNGLE;
                }
                if (block == Blocks.field_180405_aT) {
                    return BlockPlanks.EnumType.ACACIA;
                }
                if (block == Blocks.field_180406_aS) {
                    return BlockPlanks.EnumType.DARK_OAK;
                }
                return null;
            }
            case GATE: {
                if (block == Blocks.field_180390_bo) {
                    return BlockPlanks.EnumType.OAK;
                }
                if (block == Blocks.field_180391_bp) {
                    return BlockPlanks.EnumType.SPRUCE;
                }
                if (block == Blocks.field_180392_bq) {
                    return BlockPlanks.EnumType.BIRCH;
                }
                if (block == Blocks.field_180386_br) {
                    return BlockPlanks.EnumType.JUNGLE;
                }
                if (block == Blocks.field_180387_bt) {
                    return BlockPlanks.EnumType.ACACIA;
                }
                if (block == Blocks.field_180385_bs) {
                    return BlockPlanks.EnumType.DARK_OAK;
                }
                return null;
            }
            case BUTTON:
            case PLATE: {
                return BlockPlanks.EnumType.OAK;
            }
            default: {
                return null;
            }
        }
    }
    
    public static IBlockState modifyBlockWithType(final IBlockState stateIn, final StructureWoodVariant target) {
        final Block block = stateIn.func_177230_c();
        WoodShapes shape = getWoodShapeFromBlock(block);
        final ResourceLocation blockRegName = block.getRegistryName();
        if (blockRegName == null) {
            return stateIn;
        }
        if ("minecraft".equals(blockRegName.func_110624_b()) && block instanceof BlockPlanks) {
            shape = WoodShapes.BLOCK;
        }
        if (shape == WoodShapes.INVALID || (!"minecraft".equals(blockRegName.func_110624_b()) && !"twilightforest".equals(blockRegName.func_110624_b()))) {
            return stateIn;
        }
        switch (shape) {
            case BLOCK: {
                switch (target) {
                    case OAK: {
                        return target.planks.func_176223_P().func_177226_a((IProperty)BlockPlanks.field_176383_a, (Comparable)BlockPlanks.EnumType.OAK);
                    }
                    case SPRUCE: {
                        return target.planks.func_176223_P().func_177226_a((IProperty)BlockPlanks.field_176383_a, (Comparable)BlockPlanks.EnumType.SPRUCE);
                    }
                    case BIRCH: {
                        return target.planks.func_176223_P().func_177226_a((IProperty)BlockPlanks.field_176383_a, (Comparable)BlockPlanks.EnumType.BIRCH);
                    }
                    case JUNGLE: {
                        return target.planks.func_176223_P().func_177226_a((IProperty)BlockPlanks.field_176383_a, (Comparable)BlockPlanks.EnumType.JUNGLE);
                    }
                    case ACACIA: {
                        return target.planks.func_176223_P().func_177226_a((IProperty)BlockPlanks.field_176383_a, (Comparable)BlockPlanks.EnumType.ACACIA);
                    }
                    case DARK_OAK: {
                        return target.planks.func_176223_P().func_177226_a((IProperty)BlockPlanks.field_176383_a, (Comparable)BlockPlanks.EnumType.DARK_OAK);
                    }
                    default: {
                        return target.planks.func_176223_P();
                    }
                }
                break;
            }
            case STAIRS: {
                return transferStateKeys(stateIn, target.stairs.func_176223_P(), (IProperty)BlockStairs.field_176309_a, (IProperty)BlockStairs.field_176308_b, (IProperty)BlockStairs.field_176310_M);
            }
            case SLAB: {
                switch (target) {
                    case OAK: {
                        return transferStateKey(stateIn, target.slab.func_176223_P(), (net.minecraft.block.properties.IProperty<Comparable>)BlockSlab.field_176554_a).func_177226_a((IProperty)BlockWoodSlab.field_176557_b, (Comparable)BlockPlanks.EnumType.OAK);
                    }
                    case SPRUCE: {
                        return transferStateKey(stateIn, target.slab.func_176223_P(), (net.minecraft.block.properties.IProperty<Comparable>)BlockSlab.field_176554_a).func_177226_a((IProperty)BlockWoodSlab.field_176557_b, (Comparable)BlockPlanks.EnumType.SPRUCE);
                    }
                    case BIRCH: {
                        return transferStateKey(stateIn, target.slab.func_176223_P(), (net.minecraft.block.properties.IProperty<Comparable>)BlockSlab.field_176554_a).func_177226_a((IProperty)BlockWoodSlab.field_176557_b, (Comparable)BlockPlanks.EnumType.BIRCH);
                    }
                    case JUNGLE: {
                        return transferStateKey(stateIn, target.slab.func_176223_P(), (net.minecraft.block.properties.IProperty<Comparable>)BlockSlab.field_176554_a).func_177226_a((IProperty)BlockWoodSlab.field_176557_b, (Comparable)BlockPlanks.EnumType.JUNGLE);
                    }
                    case ACACIA: {
                        return transferStateKey(stateIn, target.slab.func_176223_P(), (net.minecraft.block.properties.IProperty<Comparable>)BlockSlab.field_176554_a).func_177226_a((IProperty)BlockWoodSlab.field_176557_b, (Comparable)BlockPlanks.EnumType.ACACIA);
                    }
                    case DARK_OAK: {
                        return transferStateKey(stateIn, target.slab.func_176223_P(), (net.minecraft.block.properties.IProperty<Comparable>)BlockSlab.field_176554_a).func_177226_a((IProperty)BlockWoodSlab.field_176557_b, (Comparable)BlockPlanks.EnumType.DARK_OAK);
                    }
                    default: {
                        return transferStateKey(stateIn, target.slab.func_176223_P(), (net.minecraft.block.properties.IProperty<Comparable>)BlockSlab.field_176554_a);
                    }
                }
                break;
            }
            case DOUBLESLAB: {
                switch (target) {
                    case OAK: {
                        return target.doubleSlab.func_176223_P().func_177226_a((IProperty)BlockWoodSlab.field_176557_b, (Comparable)BlockPlanks.EnumType.OAK);
                    }
                    case SPRUCE: {
                        return target.doubleSlab.func_176223_P().func_177226_a((IProperty)BlockWoodSlab.field_176557_b, (Comparable)BlockPlanks.EnumType.SPRUCE);
                    }
                    case BIRCH: {
                        return target.doubleSlab.func_176223_P().func_177226_a((IProperty)BlockWoodSlab.field_176557_b, (Comparable)BlockPlanks.EnumType.BIRCH);
                    }
                    case JUNGLE: {
                        return target.doubleSlab.func_176223_P().func_177226_a((IProperty)BlockWoodSlab.field_176557_b, (Comparable)BlockPlanks.EnumType.JUNGLE);
                    }
                    case ACACIA: {
                        return target.doubleSlab.func_176223_P().func_177226_a((IProperty)BlockWoodSlab.field_176557_b, (Comparable)BlockPlanks.EnumType.ACACIA);
                    }
                    case DARK_OAK: {
                        return target.doubleSlab.func_176223_P().func_177226_a((IProperty)BlockWoodSlab.field_176557_b, (Comparable)BlockPlanks.EnumType.DARK_OAK);
                    }
                    default: {
                        return target.doubleSlab.func_176223_P();
                    }
                }
                break;
            }
            case FENCE: {
                return transferStateKeys(stateIn, target.fence.func_176223_P(), (IProperty)BlockFence.field_176526_a, (IProperty)BlockFence.field_176525_b, (IProperty)BlockFence.field_176528_N, (IProperty)BlockFence.field_176527_M);
            }
            case GATE: {
                return transferStateKeys(stateIn, target.gate.func_176223_P(), (IProperty)BlockFenceGate.field_185512_D, (IProperty)BlockFenceGate.field_176466_a, (IProperty)BlockFenceGate.field_176465_b, (IProperty)BlockFenceGate.field_176467_M);
            }
            case BUTTON: {
                return transferStateKeys(stateIn, target.button.func_176223_P(), (IProperty)BlockButton.field_176387_N, (IProperty)BlockButton.field_176584_b);
            }
            case PLATE: {
                return transferStateKey(stateIn, target.plate.func_176223_P(), (net.minecraft.block.properties.IProperty<Comparable>)BlockPressurePlate.field_176580_a);
            }
            default: {
                return stateIn;
            }
        }
    }
    
    public static IBlockState transferStateKeys(final IBlockState stateIn, IBlockState stateOut, final IProperty<?>... properties) {
        for (final IProperty<?> property : properties) {
            stateOut = transferStateKey(stateIn, stateOut, property);
        }
        return stateOut;
    }
    
    public static <T extends Comparable<T>> IBlockState transferStateKey(final IBlockState stateIn, final IBlockState stateOut, final IProperty<T> property) {
        return stateOut.func_177226_a((IProperty)property, stateIn.func_177229_b((IProperty)property));
    }
    
    public static WoodShapes getWoodShapeFromBlock(final Block b) {
        if (b instanceof BlockTF || b instanceof BlockPlanks) {
            return WoodShapes.BLOCK;
        }
        if (b instanceof BlockStairs) {
            return WoodShapes.STAIRS;
        }
        if (b instanceof BlockSlab) {
            if (((BlockSlab)b).func_176552_j()) {
                return WoodShapes.DOUBLESLAB;
            }
            return WoodShapes.SLAB;
        }
        else {
            if (b instanceof BlockButton) {
                return WoodShapes.BUTTON;
            }
            if (b instanceof BlockFence) {
                return WoodShapes.FENCE;
            }
            if (b instanceof BlockFenceGate) {
                return WoodShapes.GATE;
            }
            if (b instanceof BlockPressurePlate) {
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
