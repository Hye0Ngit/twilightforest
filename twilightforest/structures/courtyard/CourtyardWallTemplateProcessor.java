// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.courtyard;

import java.util.function.Function;
import net.minecraft.block.BlockState;
import java.util.Random;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.DirectionalBlock;
import net.minecraft.block.Block;
import twilightforest.block.TFBlocks;
import net.minecraft.state.Property;
import net.minecraft.block.SlabBlock;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.block.Blocks;
import javax.annotation.Nullable;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import twilightforest.structures.TFStructureProcessors;
import net.minecraft.world.gen.feature.template.IStructureProcessorType;
import com.mojang.serialization.Codec;
import twilightforest.structures.RandomizedTemplateProcessor;

public class CourtyardWallTemplateProcessor extends RandomizedTemplateProcessor
{
    public static final Codec<CourtyardWallTemplateProcessor> codecWallProcessor;
    
    public CourtyardWallTemplateProcessor(final float integrity) {
        super(integrity);
    }
    
    protected IStructureProcessorType<?> func_215192_a() {
        return TFStructureProcessors.COURTYARD_WALL;
    }
    
    @Nullable
    public Template.BlockInfo process(final IWorldReader worldIn, final BlockPos pos, final BlockPos piecepos, final Template.BlockInfo oldInfo, final Template.BlockInfo newInfo, final PlacementSettings placementSettingsIn, @Nullable final Template template) {
        final Random random = placementSettingsIn.func_189947_a(newInfo.field_186242_a);
        if (!this.shouldPlaceBlock(random)) {
            return null;
        }
        final BlockState state = newInfo.field_186243_b;
        final Block block = state.func_177230_c();
        if (state == Blocks.field_196696_di.func_176223_P()) {
            return random.nextBoolean() ? newInfo : new Template.BlockInfo(newInfo.field_186242_a, (random.nextInt(2) == 0) ? Blocks.field_196700_dk.func_176223_P() : Blocks.field_196698_dj.func_176223_P(), (CompoundNBT)null);
        }
        if (state == Blocks.field_222401_hJ.func_176223_P()) {
            return random.nextBoolean() ? newInfo : new Template.BlockInfo(newInfo.field_186242_a, RandomizedTemplateProcessor.translateState(state, Blocks.field_196646_bz, (net.minecraft.state.Property<Comparable>)SlabBlock.field_196505_a), (CompoundNBT)null);
        }
        if (block == TFBlocks.etched_nagastone.get()) {
            return random.nextBoolean() ? newInfo : new Template.BlockInfo(newInfo.field_186242_a, RandomizedTemplateProcessor.translateState(state, this.randomBlock(random, (Block)TFBlocks.etched_nagastone_mossy.get(), (Block)TFBlocks.etched_nagastone_weathered.get()), (net.minecraft.state.Property<Comparable>)DirectionalBlock.field_176387_N), (CompoundNBT)null);
        }
        if (block == TFBlocks.nagastone_pillar.get()) {
            return random.nextBoolean() ? newInfo : new Template.BlockInfo(newInfo.field_186242_a, RandomizedTemplateProcessor.translateState(state, this.randomBlock(random, (Block)TFBlocks.nagastone_pillar_mossy.get(), (Block)TFBlocks.nagastone_pillar_weathered.get()), (net.minecraft.state.Property<Comparable>)RotatedPillarBlock.field_176298_M), (CompoundNBT)null);
        }
        if (block == TFBlocks.nagastone_stairs_left.get()) {
            return random.nextBoolean() ? newInfo : new Template.BlockInfo(newInfo.field_186242_a, RandomizedTemplateProcessor.translateState(state, this.randomBlock(random, (Block)TFBlocks.nagastone_stairs_mossy_left.get(), (Block)TFBlocks.nagastone_stairs_weathered_left.get()), (Property)StairsBlock.field_176309_a, (Property)StairsBlock.field_176308_b, (Property)StairsBlock.field_176310_M), (CompoundNBT)null);
        }
        if (block == TFBlocks.nagastone_stairs_right.get()) {
            return random.nextBoolean() ? newInfo : new Template.BlockInfo(newInfo.field_186242_a, RandomizedTemplateProcessor.translateState(state, this.randomBlock(random, (Block)TFBlocks.nagastone_stairs_mossy_right.get(), (Block)TFBlocks.nagastone_stairs_weathered_right.get()), (Property)StairsBlock.field_176309_a, (Property)StairsBlock.field_176308_b, (Property)StairsBlock.field_176310_M), (CompoundNBT)null);
        }
        return newInfo;
    }
    
    static {
        codecWallProcessor = Codec.FLOAT.fieldOf("integrity").orElse((Object)1.0f).xmap((Function)CourtyardWallTemplateProcessor::new, obj -> obj.integrity).codec();
    }
}
