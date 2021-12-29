// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.enums;

import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.resources.ResourceLocation;
import twilightforest.util.FeaturePlacers;
import net.minecraft.world.level.block.state.BlockState;
import javax.annotation.Nullable;
import java.util.Locale;
import twilightforest.util.ArrayUtil;
import java.util.Random;
import java.util.Arrays;
import net.minecraft.world.level.block.StairBlock;
import java.util.function.Supplier;
import twilightforest.block.BanisterBlock;
import net.minecraft.world.level.block.Block;
import java.util.List;
import net.minecraft.util.StringRepresentable;

public enum StructureWoodVariant implements StringRepresentable
{
    OAK(Blocks.f_50705_, Blocks.f_50086_, Blocks.f_50398_, Blocks.f_50251_, Blocks.f_50132_, Blocks.f_50192_, Blocks.f_50167_, (BanisterBlock)TFBlocks.OAK_BANISTER.get()), 
    SPRUCE(Blocks.f_50741_, Blocks.f_50269_, Blocks.f_50399_, Blocks.f_50252_, Blocks.f_50479_, Blocks.f_50474_, Blocks.f_50168_, (BanisterBlock)TFBlocks.SPRUCE_BANISTER.get()), 
    BIRCH(Blocks.f_50742_, Blocks.f_50270_, Blocks.f_50400_, Blocks.f_50253_, Blocks.f_50480_, Blocks.f_50475_, Blocks.f_50169_, (BanisterBlock)TFBlocks.BIRCH_BANISTER.get()), 
    JUNGLE(Blocks.f_50743_, Blocks.f_50271_, Blocks.f_50401_, Blocks.f_50254_, Blocks.f_50481_, Blocks.f_50476_, Blocks.f_50170_, (BanisterBlock)TFBlocks.JUNGLE_BANISTER.get()), 
    ACACIA(Blocks.f_50744_, Blocks.f_50372_, Blocks.f_50402_, Blocks.f_50308_, Blocks.f_50482_, Blocks.f_50477_, Blocks.f_50171_, (BanisterBlock)TFBlocks.ACACIA_BANISTER.get()), 
    DARK_OAK(Blocks.f_50745_, Blocks.f_50373_, Blocks.f_50403_, Blocks.f_50309_, Blocks.f_50483_, Blocks.f_50478_, Blocks.f_50172_, (BanisterBlock)TFBlocks.DARK_OAK_BANISTER.get()), 
    CRIMSON(Blocks.f_50655_, Blocks.f_50667_, Blocks.f_50657_, Blocks.f_50669_, Blocks.f_50661_, Blocks.f_50665_, Blocks.f_50659_, (BanisterBlock)TFBlocks.CRIMSON_BANISTER.get()), 
    WARPED(Blocks.f_50656_, Blocks.f_50668_, Blocks.f_50658_, Blocks.f_50670_, Blocks.f_50662_, Blocks.f_50666_, Blocks.f_50660_, (BanisterBlock)TFBlocks.WARPED_BANISTER.get()), 
    TWILIGHT_OAK((Supplier<Block>)TFBlocks.TWILIGHT_OAK_PLANKS, (Supplier<StairBlock>)TFBlocks.TWILIGHT_OAK_STAIRS, (Supplier<Block>)TFBlocks.TWILIGHT_OAK_SLAB, (Supplier<Block>)TFBlocks.TWILIGHT_OAK_BUTTON, (Supplier<Block>)TFBlocks.TWILIGHT_OAK_FENCE, (Supplier<Block>)TFBlocks.TWILIGHT_OAK_GATE, (Supplier<Block>)TFBlocks.TWILIGHT_OAK_PLATE, (Supplier<BanisterBlock>)TFBlocks.TWILIGHT_OAK_BANISTER), 
    CANOPY((Supplier<Block>)TFBlocks.CANOPY_PLANKS, (Supplier<StairBlock>)TFBlocks.CANOPY_STAIRS, (Supplier<Block>)TFBlocks.CANOPY_SLAB, (Supplier<Block>)TFBlocks.CANOPY_BUTTON, (Supplier<Block>)TFBlocks.CANOPY_FENCE, (Supplier<Block>)TFBlocks.CANOPY_GATE, (Supplier<Block>)TFBlocks.CANOPY_PLATE, (Supplier<BanisterBlock>)TFBlocks.CANOPY_BANISTER), 
    MANGROVE((Supplier<Block>)TFBlocks.MANGROVE_PLANKS, (Supplier<StairBlock>)TFBlocks.MANGROVE_STAIRS, (Supplier<Block>)TFBlocks.MANGROVE_SLAB, (Supplier<Block>)TFBlocks.MANGROVE_BUTTON, (Supplier<Block>)TFBlocks.MANGROVE_FENCE, (Supplier<Block>)TFBlocks.MANGROVE_GATE, (Supplier<Block>)TFBlocks.MANGROVE_PLATE, (Supplier<BanisterBlock>)TFBlocks.MANGROVE_BANISTER), 
    DARK((Supplier<Block>)TFBlocks.DARK_PLANKS, (Supplier<StairBlock>)TFBlocks.DARK_STAIRS, (Supplier<Block>)TFBlocks.DARK_SLAB, (Supplier<Block>)TFBlocks.DARK_BUTTON, (Supplier<Block>)TFBlocks.DARK_FENCE, (Supplier<Block>)TFBlocks.DARK_GATE, (Supplier<Block>)TFBlocks.DARK_PLATE, (Supplier<BanisterBlock>)TFBlocks.DARKWOOD_BANISTER), 
    TIME((Supplier<Block>)TFBlocks.TIME_PLANKS, (Supplier<StairBlock>)TFBlocks.TIME_STAIRS, (Supplier<Block>)TFBlocks.TIME_SLAB, (Supplier<Block>)TFBlocks.TIME_BUTTON, (Supplier<Block>)TFBlocks.TIME_FENCE, (Supplier<Block>)TFBlocks.TIME_GATE, (Supplier<Block>)TFBlocks.TIME_PLATE, (Supplier<BanisterBlock>)TFBlocks.TIME_BANISTER), 
    TRANS((Supplier<Block>)TFBlocks.TRANSFORMATION_PLANKS, (Supplier<StairBlock>)TFBlocks.TRANSFORMATION_STAIRS, (Supplier<Block>)TFBlocks.TRANSFORMATION_SLAB, (Supplier<Block>)TFBlocks.TRANSFORMATION_BUTTON, (Supplier<Block>)TFBlocks.TRANSFORMATION_FENCE, (Supplier<Block>)TFBlocks.TRANSFORMATION_GATE, (Supplier<Block>)TFBlocks.TRANSFORMATION_PLATE, (Supplier<BanisterBlock>)TFBlocks.TRANSFORMATION_BANISTER), 
    MINE((Supplier<Block>)TFBlocks.MINING_PLANKS, (Supplier<StairBlock>)TFBlocks.MINING_STAIRS, (Supplier<Block>)TFBlocks.MINING_SLAB, (Supplier<Block>)TFBlocks.MINING_BUTTON, (Supplier<Block>)TFBlocks.MINING_FENCE, (Supplier<Block>)TFBlocks.MINING_GATE, (Supplier<Block>)TFBlocks.MINING_PLATE, (Supplier<BanisterBlock>)TFBlocks.MINING_BANISTER), 
    SORT((Supplier<Block>)TFBlocks.SORTING_PLANKS, (Supplier<StairBlock>)TFBlocks.SORTING_STAIRS, (Supplier<Block>)TFBlocks.SORTING_SLAB, (Supplier<Block>)TFBlocks.SORTING_BUTTON, (Supplier<Block>)TFBlocks.SORTING_FENCE, (Supplier<Block>)TFBlocks.SORTING_GATE, (Supplier<Block>)TFBlocks.SORTING_PLATE, (Supplier<BanisterBlock>)TFBlocks.SORTING_BANISTER);
    
    private final List<Block> blocks;
    private static final StructureWoodVariant[] COMMON;
    private static final StructureWoodVariant[] UNCOMMON;
    private static final StructureWoodVariant[] RARE;
    private static final StructureWoodVariant[] TREASURE;
    private final Block planks;
    private final Block stairs;
    private final Block slab;
    private final Block button;
    private final Block fence;
    private final Block gate;
    private final Block plate;
    private final BanisterBlock banister;
    
    private StructureWoodVariant(final Supplier<Block> planks, final Supplier<StairBlock> stairs, final Supplier<Block> slab, final Supplier<Block> button, final Supplier<Block> fence, final Supplier<Block> gate, final Supplier<Block> plate, final Supplier<BanisterBlock> banister) {
        this(planks.get(), (Block)stairs.get(), slab.get(), button.get(), fence.get(), gate.get(), plate.get(), banister.get());
    }
    
    private StructureWoodVariant(final Block planks, final Block stairs, final Block slab, final Block button, final Block fence, final Block gate, final Block plate, final BanisterBlock banister) {
        this.planks = planks;
        this.stairs = stairs;
        this.slab = slab;
        this.button = button;
        this.fence = fence;
        this.gate = gate;
        this.plate = plate;
        this.banister = banister;
        this.blocks = Arrays.asList(this.planks, this.stairs, this.slab, this.button, this.fence, this.gate, this.plate, (Block)this.banister);
    }
    
    public static StructureWoodVariant getRandomWeighted(final Random random) {
        final int randomVal = random.nextInt() & Integer.MAX_VALUE;
        if ((randomVal & 0x1) == 0x0) {
            return ArrayUtil.wrapped(StructureWoodVariant.COMMON, randomVal >> 1);
        }
        if ((randomVal & 0x2) == 0x0) {
            return ArrayUtil.wrapped(StructureWoodVariant.UNCOMMON, randomVal >> 2);
        }
        if ((randomVal & 0xC) != 0x0) {
            return ArrayUtil.wrapped(StructureWoodVariant.RARE, randomVal >> 4);
        }
        return ArrayUtil.wrapped(StructureWoodVariant.TREASURE, randomVal >> 4);
    }
    
    public String m_7912_() {
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
    
    public static boolean isPlanks(final Block block) {
        final StructureWoodVariant var = getVariantFromBlock(block);
        return var != null && var.planks == block;
    }
    
    public static BlockState modifyBlockWithType(final BlockState stateIn, final StructureWoodVariant target) {
        final Block block = stateIn.m_60734_();
        final WoodShapes shape = getWoodShapeFromBlock(block);
        final ResourceLocation blockRegName = block.getRegistryName();
        if (blockRegName == null) {
            return stateIn;
        }
        if (shape == WoodShapes.INVALID || (!"minecraft".equals(blockRegName.m_135827_()) && !"twilightforest".equals(blockRegName.m_135827_()))) {
            return stateIn;
        }
        return switch (shape) {
            case BLOCK -> target.planks.m_49966_();
            case STAIRS -> FeaturePlacers.transferAllStateKeys(stateIn, target.stairs);
            case SLAB -> FeaturePlacers.transferAllStateKeys(stateIn, target.slab);
            case FENCE -> FeaturePlacers.transferAllStateKeys(stateIn, target.fence);
            case GATE -> FeaturePlacers.transferAllStateKeys(stateIn, target.gate);
            case BUTTON -> FeaturePlacers.transferAllStateKeys(stateIn, target.button);
            case PLATE -> FeaturePlacers.transferAllStateKeys(stateIn, target.plate);
            case BANISTER -> FeaturePlacers.transferAllStateKeys(stateIn, (Block)target.banister);
            default -> stateIn;
        };
    }
    
    public static WoodShapes getWoodShapeFromBlock(final Block b) {
        if (isPlanks(b)) {
            return WoodShapes.BLOCK;
        }
        if (b instanceof StairBlock) {
            return WoodShapes.STAIRS;
        }
        if (b instanceof SlabBlock) {
            return WoodShapes.SLAB;
        }
        if (b instanceof ButtonBlock) {
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
        if (b instanceof BanisterBlock) {
            return WoodShapes.BANISTER;
        }
        return WoodShapes.INVALID;
    }
    
    static {
        COMMON = new StructureWoodVariant[] { StructureWoodVariant.SPRUCE, StructureWoodVariant.CANOPY };
        UNCOMMON = new StructureWoodVariant[] { StructureWoodVariant.OAK, StructureWoodVariant.DARK_OAK, StructureWoodVariant.TWILIGHT_OAK };
        RARE = new StructureWoodVariant[] { StructureWoodVariant.BIRCH, StructureWoodVariant.JUNGLE, StructureWoodVariant.MANGROVE };
        TREASURE = new StructureWoodVariant[] { StructureWoodVariant.TIME, StructureWoodVariant.TRANS, StructureWoodVariant.MINE, StructureWoodVariant.SORT };
    }
    
    public enum WoodShapes
    {
        BLOCK, 
        STAIRS, 
        SLAB, 
        BUTTON, 
        FENCE, 
        GATE, 
        PLATE, 
        BANISTER, 
        INVALID;
    }
}
