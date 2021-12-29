// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import net.minecraft.state.Property;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;
import java.util.Random;
import net.minecraft.world.gen.feature.template.StructureProcessor;

public abstract class RandomizedTemplateProcessor extends StructureProcessor
{
    protected final float integrity;
    
    public RandomizedTemplateProcessor(final float integrity) {
        this.integrity = integrity;
    }
    
    protected boolean shouldPlaceBlock(final Random random) {
        return this.integrity >= 1.0f || random.nextFloat() > this.integrity;
    }
    
    protected Block randomBlock(final Random random, final Block... blocks) {
        return blocks[random.nextInt(blocks.length)];
    }
    
    protected static <T extends Comparable<T>> BlockState translateState(final BlockState stateIn, final Block blockOut, final Property<T> property) {
        return (BlockState)blockOut.func_176223_P().func_206870_a((Property)property, stateIn.func_177229_b((Property)property));
    }
    
    protected static BlockState translateState(final BlockState stateIn, final Block blockOut, final Property<?>... properties) {
        BlockState stateOut = blockOut.func_176223_P();
        for (final Property<?> property : properties) {
            stateOut = copyValue(stateIn, stateOut, property);
        }
        return stateOut;
    }
    
    private static <T extends Comparable<T>> BlockState copyValue(final BlockState from, final BlockState to, final Property<T> property) {
        return (BlockState)to.func_206870_a((Property)property, from.func_177229_b((Property)property));
    }
}
