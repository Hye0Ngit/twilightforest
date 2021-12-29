// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.server.level.ServerLevel;
import java.util.Random;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.PlantType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.IPlantable;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;

public abstract class TFPlantBlock extends BushBlock implements BonemealableBlock
{
    protected TFPlantBlock(final BlockBehaviour.Properties props) {
        super(props);
    }
    
    public boolean m_7898_(final BlockState state, final LevelReader world, final BlockPos pos) {
        final BlockState soil = world.m_8055_(pos.m_7495_());
        return (world.m_46803_(pos) >= 3 || world.m_46861_(pos)) && soil.canSustainPlant((BlockGetter)world, pos.m_7495_(), Direction.UP, (IPlantable)this);
    }
    
    public static boolean canPlaceRootAt(final LevelReader world, final BlockPos pos) {
        final BlockState state = world.m_8055_(pos.m_7494_());
        return state.m_60767_() == Material.f_76314_ || state.m_60767_() == Material.f_76315_ || state.m_60734_() == TFBlocks.ROOT_STRAND.get() || state.m_60713_((Block)TFBlocks.ROOT_BLOCK.get()) || state.m_60713_((Block)TFBlocks.LIVEROOT_BLOCK.get()) || state.m_60713_((Block)TFBlocks.MANGROVE_ROOT.get());
    }
    
    public PlantType getPlantType(final BlockGetter world, final BlockPos pos) {
        return PlantType.PLAINS;
    }
    
    public boolean m_7370_(final BlockGetter pLevel, final BlockPos pPos, final BlockState pState, final boolean pIsClient) {
        return false;
    }
    
    public boolean m_5491_(final Level pLevel, final Random pRandom, final BlockPos pPos, final BlockState pState) {
        return false;
    }
    
    public void m_7719_(final ServerLevel pLevel, final Random pRandom, final BlockPos pPos, final BlockState pState) {
    }
    
    public int getFlammability(final BlockState state, final BlockGetter world, final BlockPos pos, final Direction face) {
        return 100;
    }
    
    public int getFireSpreadSpeed(final BlockState state, final BlockGetter world, final BlockPos pos, final Direction face) {
        return 60;
    }
}
