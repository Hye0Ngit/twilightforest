// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import java.util.function.Function;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import java.util.Random;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.block.Blocks;
import javax.annotation.Nullable;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.gen.feature.template.IStructureProcessorType;
import com.mojang.serialization.Codec;

public class MossyCobbleTemplateProcessor extends RandomizedTemplateProcessor
{
    public static final Codec<MossyCobbleTemplateProcessor> codecMossyProcessor;
    
    public MossyCobbleTemplateProcessor(final float integrity) {
        super(integrity);
    }
    
    protected IStructureProcessorType<?> func_215192_a() {
        return TFStructureProcessors.MOSSY_COBBLE;
    }
    
    @Nullable
    public Template.BlockInfo process(final IWorldReader worldReaderIn, final BlockPos pos, final BlockPos piecepos, final Template.BlockInfo p_215194_3_, final Template.BlockInfo blockInfo, final PlacementSettings placementSettingsIn, @Nullable final Template template) {
        final Random random = placementSettingsIn.func_189947_a(pos);
        if (!this.shouldPlaceBlock(random)) {
            return null;
        }
        final BlockState state = blockInfo.field_186243_b;
        final Block block = state.func_177230_c();
        if (block == Blocks.field_150347_e) {
            return random.nextBoolean() ? blockInfo : new Template.BlockInfo(pos, Blocks.field_150341_Y.func_176223_P(), (CompoundNBT)null);
        }
        if (block == Blocks.field_150463_bK) {
            return random.nextBoolean() ? blockInfo : new Template.BlockInfo(pos, Blocks.field_196723_eg.func_176223_P(), (CompoundNBT)null);
        }
        return blockInfo;
    }
    
    static {
        codecMossyProcessor = Codec.FLOAT.fieldOf("integrity").orElse((Object)1.0f).xmap((Function)MossyCobbleTemplateProcessor::new, obj -> obj.integrity).codec();
    }
}
