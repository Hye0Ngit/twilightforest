// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.Block;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.gen.structure.template.ITemplateProcessor;

public abstract class RandomizedTemplateProcessor implements ITemplateProcessor
{
    protected final Random random;
    private final float integrity;
    
    public RandomizedTemplateProcessor(final BlockPos pos, final PlacementSettings settings) {
        this.integrity = settings.func_189948_f();
        this.random = settings.func_189947_a(pos);
    }
    
    protected boolean shouldPlaceBlock() {
        return this.integrity >= 1.0f || this.random.nextFloat() > this.integrity;
    }
    
    protected Block randomBlock(final Block... blocks) {
        return blocks[this.random.nextInt(blocks.length)];
    }
    
    protected static <T extends Comparable<T>> IBlockState translateState(final IBlockState stateIn, final Block blockOut, final IProperty<T> property) {
        return blockOut.func_176223_P().func_177226_a((IProperty)property, stateIn.func_177229_b((IProperty)property));
    }
    
    protected static IBlockState translateState(final IBlockState stateIn, final Block blockOut, final IProperty<?>... properties) {
        IBlockState stateOut = blockOut.func_176223_P();
        for (final IProperty<?> property : properties) {
            stateOut = copyValue(stateIn, stateOut, property);
        }
        return stateOut;
    }
    
    private static <T extends Comparable<T>> IBlockState copyValue(final IBlockState from, final IBlockState to, final IProperty<T> property) {
        return to.func_177226_a((IProperty)property, from.func_177229_b((IProperty)property));
    }
}
