// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.courtyard;

import java.util.function.Function;
import net.minecraft.block.BlockState;
import java.util.Random;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.block.StairsBlock;
import net.minecraft.state.Property;
import net.minecraft.block.Block;
import twilightforest.block.TFBlocks;
import javax.annotation.Nullable;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import twilightforest.structures.TFStructureProcessors;
import net.minecraft.world.gen.feature.template.IStructureProcessorType;
import com.mojang.serialization.Codec;
import twilightforest.structures.RandomizedTemplateProcessor;

public class CourtyardStairsTemplateProcessor extends RandomizedTemplateProcessor
{
    public static final Codec<CourtyardStairsTemplateProcessor> codecStairsProcessor;
    
    public CourtyardStairsTemplateProcessor(final float integrity) {
        super(integrity);
    }
    
    protected IStructureProcessorType<?> func_215192_a() {
        return TFStructureProcessors.COURTYARD_STAIRS;
    }
    
    @Nullable
    public Template.BlockInfo process(final IWorldReader worldReaderIn, final BlockPos pos, final BlockPos piecepos, final Template.BlockInfo oldInfo, final Template.BlockInfo newInfo, final PlacementSettings placementSettingsIn, @Nullable final Template template) {
        final Random random = placementSettingsIn.func_189947_a(newInfo.field_186242_a);
        if (!this.shouldPlaceBlock(random)) {
            return null;
        }
        final BlockState state = newInfo.field_186243_b;
        final Block block = state.func_177230_c();
        if (block == TFBlocks.nagastone_stairs_left.get()) {
            return random.nextBoolean() ? newInfo : new Template.BlockInfo(newInfo.field_186242_a, RandomizedTemplateProcessor.translateState(state, this.randomBlock(random, (Block)TFBlocks.nagastone_stairs_mossy_left.get(), (Block)TFBlocks.nagastone_stairs_weathered_left.get()), (Property)StairsBlock.field_176309_a, (Property)StairsBlock.field_176308_b, (Property)StairsBlock.field_176310_M), (CompoundNBT)null);
        }
        if (block == TFBlocks.nagastone_stairs_right.get()) {
            return random.nextBoolean() ? newInfo : new Template.BlockInfo(newInfo.field_186242_a, RandomizedTemplateProcessor.translateState(state, this.randomBlock(random, (Block)TFBlocks.nagastone_stairs_mossy_right.get(), (Block)TFBlocks.nagastone_stairs_weathered_right.get()), (Property)StairsBlock.field_176309_a, (Property)StairsBlock.field_176308_b, (Property)StairsBlock.field_176310_M), (CompoundNBT)null);
        }
        return newInfo;
    }
    
    static {
        codecStairsProcessor = Codec.FLOAT.fieldOf("integrity").orElse((Object)1.0f).xmap((Function)CourtyardStairsTemplateProcessor::new, obj -> obj.integrity).codec();
    }
}
