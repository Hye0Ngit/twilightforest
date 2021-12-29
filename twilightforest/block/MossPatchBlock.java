// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import java.util.Random;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.PlantType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class MossPatchBlock extends PatchBlock
{
    public MossPatchBlock(final BlockBehaviour.Properties props) {
        super(props);
    }
    
    @Override
    public boolean m_7898_(final BlockState state, final LevelReader world, final BlockPos pos) {
        return world.m_8055_(pos.m_7495_()).m_60783_((BlockGetter)world, pos, Direction.UP);
    }
    
    @Override
    public PlantType getPlantType(final BlockGetter world, final BlockPos pos) {
        return PlantType.CAVE;
    }
    
    public void m_7100_(final BlockState state, final Level world, final BlockPos pos, final Random random) {
        if (random.nextInt(10) == 0) {
            world.m_7106_((ParticleOptions)ParticleTypes.f_123757_, (double)(pos.m_123341_() + random.nextFloat()), (double)(pos.m_123342_() + 0.1f), (double)(pos.m_123343_() + random.nextFloat()), 0.0, 0.0, 0.0);
        }
    }
}
