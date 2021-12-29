// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.courtyard;

import javax.annotation.Nullable;
import net.minecraft.block.state.IBlockState;
import net.minecraft.nbt.NBTTagCompound;
import twilightforest.block.BlockTFNagastoneStairs;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.Block;
import twilightforest.block.TFBlocks;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.util.math.BlockPos;
import twilightforest.structures.RandomizedTemplateProcessor;

public class CourtyardStairsTemplateProcessor extends RandomizedTemplateProcessor
{
    public CourtyardStairsTemplateProcessor(final BlockPos pos, final PlacementSettings settings) {
        super(pos, settings);
    }
    
    @Nullable
    public Template.BlockInfo func_189943_a(final World worldIn, final BlockPos pos, final Template.BlockInfo blockInfo) {
        if (!this.shouldPlaceBlock()) {
            return null;
        }
        final IBlockState state = blockInfo.field_186243_b;
        final Block block = state.func_177230_c();
        if (block == TFBlocks.nagastone_stairs) {
            return this.random.nextBoolean() ? blockInfo : new Template.BlockInfo(pos, RandomizedTemplateProcessor.translateState(state, this.randomBlock(TFBlocks.nagastone_stairs_mossy, TFBlocks.nagastone_stairs_weathered), BlockTFNagastoneStairs.DIRECTION, (IProperty)BlockTFNagastoneStairs.field_176309_a, (IProperty)BlockTFNagastoneStairs.field_176308_b, (IProperty)BlockTFNagastoneStairs.field_176310_M), (NBTTagCompound)null);
        }
        return blockInfo;
    }
}
