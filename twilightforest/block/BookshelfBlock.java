// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

public class BookshelfBlock extends Block
{
    public BookshelfBlock(final BlockBehaviour.Properties properties) {
        super(properties);
    }
    
    public float getEnchantPowerBonus(final BlockState state, final LevelReader world, final BlockPos pos) {
        return 1.0f;
    }
    
    public int getFlammability(final BlockState state, final BlockGetter world, final BlockPos pos, final Direction face) {
        return 20;
    }
    
    public int getFireSpreadSpeed(final BlockState state, final BlockGetter world, final BlockPos pos, final Direction face) {
        return 30;
    }
}
