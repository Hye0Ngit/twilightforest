// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.util.Mth;
import java.util.Random;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.Block;

public abstract class AbstractParticleSpawnerBlock extends Block
{
    public static final IntegerProperty RADIUS;
    
    public AbstractParticleSpawnerBlock(final BlockBehaviour.Properties p_49795_) {
        super(p_49795_);
        this.m_49959_((BlockState)((BlockState)this.m_49965_().m_61090_()).m_61124_((Property)AbstractParticleSpawnerBlock.RADIUS, (Comparable)1));
    }
    
    public void m_7100_(final BlockState state, final Level world, final BlockPos pos, final Random rand) {
        final int x = pos.m_123341_();
        final int y = pos.m_123342_();
        final int z = pos.m_123343_();
        final int radius = (int)state.m_61143_((Property)AbstractParticleSpawnerBlock.RADIUS);
        final BlockPos.MutableBlockPos mutablePos = new BlockPos.MutableBlockPos();
        for (int partCount = 0; partCount < this.getParticleCountPerSpawn(state); ++partCount) {
            mutablePos.m_122178_(x + Mth.m_14072_(rand, -radius, radius), y + Mth.m_14072_(rand, -radius, radius), z + Mth.m_14072_(rand, -radius, radius));
            final BlockState var16 = world.m_8055_((BlockPos)mutablePos);
            if (!var16.m_60838_((BlockGetter)world, (BlockPos)mutablePos)) {
                world.m_7106_((ParticleOptions)this.getParticlesToSpawn(), mutablePos.m_123341_() + rand.nextDouble(), mutablePos.m_123342_() + rand.nextDouble(), mutablePos.m_123343_() + rand.nextDouble(), 0.0, 0.0, 0.0);
            }
        }
    }
    
    public abstract ParticleType<?> getParticlesToSpawn();
    
    public abstract int getParticleCountPerSpawn(final BlockState p0);
    
    protected void m_7926_(final StateDefinition.Builder<Block, BlockState> builder) {
        builder.m_61104_(new Property[] { (Property)AbstractParticleSpawnerBlock.RADIUS });
    }
    
    static {
        RADIUS = IntegerProperty.m_61631_("particle_radius", 1, 10);
    }
}
