// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.world.phys.shapes.Shapes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.core.particles.ParticleTypes;
import twilightforest.client.particle.TFParticleType;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.client.Minecraft;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.sounds.SoundSource;
import twilightforest.TFSounds;
import net.minecraft.world.level.GameRules;
import twilightforest.TFConfig;
import java.util.Random;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.level.block.Block;

public class JarBlock extends Block
{
    private static final VoxelShape JAR;
    private static final VoxelShape LID;
    private static final VoxelShape AABB;
    
    protected JarBlock(final BlockBehaviour.Properties props) {
        super(props);
    }
    
    @Deprecated
    public VoxelShape m_5940_(final BlockState state, final BlockGetter worldIn, final BlockPos pos, final CollisionContext context) {
        return JarBlock.AABB;
    }
    
    public InteractionResult m_6227_(final BlockState state, final Level worldIn, final BlockPos pos, final Player player, final InteractionHand hand, final BlockHitResult hit) {
        final ItemEntity jarStuff = new ItemEntity(worldIn, (double)pos.m_123341_(), (double)pos.m_123342_(), (double)pos.m_123343_(), (this == TFBlocks.FIREFLY_JAR.get()) ? ((Block)TFBlocks.FIREFLY.get()).m_5456_().m_7968_() : ((Block)TFBlocks.CICADA.get()).m_5456_().m_7968_());
        if (player.m_6144_()) {
            worldIn.m_46597_(pos, Blocks.f_50016_.m_49966_());
            jarStuff.m_19983_(jarStuff.m_32055_());
            jarStuff.m_19998_((ItemLike)Items.f_42590_);
            return InteractionResult.SUCCESS;
        }
        if (player.m_21120_(hand).m_41720_() == Blocks.f_50112_.m_5456_() && this == TFBlocks.FIREFLY_JAR.get()) {
            worldIn.m_46597_(pos, (BlockState)((Block)TFBlocks.FIREFLY_SPAWNER.get()).m_49966_().m_61124_((Property)AbstractParticleSpawnerBlock.RADIUS, (Comparable)1));
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }
    
    public void m_7455_(final BlockState state, final ServerLevel worldIn, final BlockPos pos, final Random random) {
        super.m_7455_(state, worldIn, pos, random);
        if (!(boolean)TFConfig.CLIENT_CONFIG.silentCicadas.get() && random.nextInt(((GameRules.IntegerValue)worldIn.m_46469_().m_46170_(GameRules.f_46143_)).m_46288_()) <= 3) {
            worldIn.m_5594_((Player)null, pos, TFSounds.CICADA, SoundSource.BLOCKS, 1.0f, 1.0f);
        }
    }
    
    public void m_6786_(final LevelAccessor pLevel, final BlockPos pPos, final BlockState pState) {
        super.m_6786_(pLevel, pPos, pState);
        if (pLevel.m_5776_()) {
            Minecraft.m_91087_().m_91106_().m_120386_(TFSounds.CICADA.m_11660_(), SoundSource.NEUTRAL);
        }
    }
    
    @OnlyIn(Dist.CLIENT)
    public void m_7100_(final BlockState state, final Level world, final BlockPos pos, final Random rand) {
        if (this == TFBlocks.FIREFLY_JAR.get()) {
            for (int i = 0; i < 2; ++i) {
                final double dx = pos.m_123341_() + ((rand.nextFloat() - rand.nextFloat()) * 0.2f + 0.5f);
                final double dy = pos.m_123342_() + 0.4f + (rand.nextFloat() - rand.nextFloat()) * 0.3f;
                final double dz = pos.m_123343_() + ((rand.nextFloat() - rand.nextFloat()) * 0.2f + 0.5f);
                world.m_7106_((ParticleOptions)TFParticleType.FIREFLY.get(), dx, dy, dz, 0.0, 0.0, 0.0);
            }
        }
        else {
            final double dx2 = pos.m_123341_() + ((rand.nextFloat() - rand.nextFloat()) * 0.2f + 0.5f);
            final double dy2 = pos.m_123342_() + 0.4f + (rand.nextFloat() - rand.nextFloat()) * 0.2f;
            final double dz2 = pos.m_123343_() + ((rand.nextFloat() - rand.nextFloat()) * 0.2f + 0.5f);
            world.m_7106_((ParticleOptions)ParticleTypes.f_123758_, dx2, dy2, dz2, 0.0, 0.0, 0.0);
        }
    }
    
    static {
        JAR = Block.m_49796_(3.0, 0.0, 3.0, 13.0, 14.0, 13.0);
        LID = Block.m_49796_(4.0, 14.0, 4.0, 12.0, 16.0, 12.0);
        AABB = Shapes.m_83110_(JarBlock.JAR, JarBlock.LID);
    }
}
