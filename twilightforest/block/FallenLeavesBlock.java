// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import twilightforest.network.SpawnFallenLeafFromPacket;
import net.minecraftforge.fmllegacy.network.PacketDistributor;
import twilightforest.network.TFPacketHandler;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.core.particles.ParticleOptions;
import twilightforest.client.particle.data.LeafParticleData;
import net.minecraft.util.Mth;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.world.level.material.Material;
import java.util.Random;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.phys.shapes.VoxelShape;

public class FallenLeavesBlock extends TFPlantBlock
{
    private static final VoxelShape FALLEN_LEAVES_SHAPE;
    
    public FallenLeavesBlock(final BlockBehaviour.Properties props) {
        super(props);
    }
    
    @Override
    public boolean m_7898_(final BlockState state, final LevelReader world, final BlockPos pos) {
        return world.m_8055_(pos.m_7495_()).m_60783_((BlockGetter)world, pos, Direction.UP);
    }
    
    @Deprecated
    public VoxelShape m_5940_(final BlockState state, final BlockGetter access, final BlockPos pos, final CollisionContext context) {
        return FallenLeavesBlock.FALLEN_LEAVES_SHAPE;
    }
    
    @OnlyIn(Dist.CLIENT)
    public void m_7100_(final BlockState state, final Level world, final BlockPos pos, final Random random) {
        super.m_7100_(state, world, pos, random);
        if (random.nextInt(50) == 0) {
            float dist = 10.0f;
            if (!world.m_46861_(pos)) {
                for (int y = 0; y <= dist; ++y) {
                    if (world.m_8055_(pos.m_6630_(y)).m_60767_() == Material.f_76274_) {
                        dist = (float)y;
                        break;
                    }
                }
                if (dist > 10.0f) {
                    return;
                }
            }
            final int color = Minecraft.m_91087_().m_91298_().m_92577_(Blocks.f_50050_.m_49966_(), (BlockAndTintGetter)world, pos, 0);
            final int r = Mth.m_14045_((color >> 16 & 0xFF) + this.RANDOM.nextInt(34) - 17, 0, 255);
            final int g = Mth.m_14045_((color >> 8 & 0xFF) + this.RANDOM.nextInt(34) - 17, 0, 255);
            final int b = Mth.m_14045_((color & 0xFF) + this.RANDOM.nextInt(34) - 17, 0, 255);
            world.m_7106_((ParticleOptions)new LeafParticleData(r, g, b), (double)(pos.m_123341_() + random.nextFloat()), (double)(pos.m_123342_() + dist - 0.25f), (double)(pos.m_123343_() + random.nextFloat()), 0.0, 0.0, 0.0);
        }
    }
    
    @Deprecated
    public void m_7892_(final BlockState state, final Level world, final BlockPos pos, final Entity entityIn) {
        super.m_7892_(state, world, pos, entityIn);
        if (entityIn instanceof LivingEntity && (entityIn.m_20184_().m_7096_() != 0.0 || entityIn.m_20184_().m_7094_() != 0.0) && this.RANDOM.nextBoolean()) {
            if (world.f_46443_) {
                final int color = Minecraft.m_91087_().m_91298_().m_92577_(Blocks.f_50050_.m_49966_(), (BlockAndTintGetter)world, pos, 0);
                final int r = Mth.m_14045_((color >> 16 & 0xFF) + this.RANDOM.nextInt(34) - 17, 0, 255);
                final int g = Mth.m_14045_((color >> 8 & 0xFF) + this.RANDOM.nextInt(34) - 17, 0, 255);
                final int b = Mth.m_14045_((color & 0xFF) + this.RANDOM.nextInt(34) - 17, 0, 255);
                world.m_7106_((ParticleOptions)new LeafParticleData(r, g, b), (double)(pos.m_123341_() + world.f_46441_.nextFloat()), (double)pos.m_123342_(), (double)(pos.m_123343_() + world.f_46441_.nextFloat()), world.f_46441_.nextFloat() * -0.5f * entityIn.m_20184_().m_7096_(), (double)(world.f_46441_.nextFloat() * 0.5f + 0.25f), world.f_46441_.nextFloat() * -0.5f * entityIn.m_20184_().m_7094_());
            }
            else if (world instanceof ServerLevel) {
                TFPacketHandler.CHANNEL.send(PacketDistributor.TRACKING_ENTITY.with(() -> entityIn), (Object)new SpawnFallenLeafFromPacket(pos, entityIn.m_20184_()));
            }
        }
    }
    
    static {
        FALLEN_LEAVES_SHAPE = m_49796_(0.0, 0.0, 0.0, 16.0, 1.0, 16.0);
    }
}
