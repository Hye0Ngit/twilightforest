// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import javax.annotation.Nullable;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockWall;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.init.Blocks;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.util.math.BlockPos;

public class MossyCobbleTemplateProcessor extends RandomizedTemplateProcessor
{
    public MossyCobbleTemplateProcessor(final BlockPos pos, final PlacementSettings settings) {
        super(pos, settings);
    }
    
    @Nullable
    public Template.BlockInfo func_189943_a(final World worldIn, final BlockPos pos, final Template.BlockInfo blockInfo) {
        if (!this.shouldPlaceBlock()) {
            return null;
        }
        final IBlockState state = blockInfo.field_186243_b;
        final Block block = state.func_177230_c();
        if (block == Blocks.field_150347_e) {
            return this.random.nextBoolean() ? blockInfo : new Template.BlockInfo(pos, Blocks.field_150341_Y.func_176223_P(), (NBTTagCompound)null);
        }
        if (block == Blocks.field_150463_bK) {
            return this.random.nextBoolean() ? blockInfo : new Template.BlockInfo(pos, state.func_177226_a((IProperty)BlockWall.field_176255_P, (Comparable)BlockWall.EnumType.MOSSY), (NBTTagCompound)null);
        }
        return blockInfo;
    }
}
