// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import twilightforest.client.particle.TFParticleType;
import net.minecraft.core.particles.ParticleOptions;
import java.util.Random;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.phys.shapes.VoxelShape;

public class FireflySpawnerBlock extends AbstractParticleSpawnerBlock
{
    private static final VoxelShape SHAPE;
    
    public FireflySpawnerBlock(final BlockBehaviour.Properties properties) {
        super(properties);
    }
    
    public VoxelShape m_5940_(final BlockState p_60555_, final BlockGetter p_60556_, final BlockPos p_60557_, final CollisionContext p_60558_) {
        return FireflySpawnerBlock.SHAPE;
    }
    
    @Override
    public void m_7100_(final BlockState state, final Level world, final BlockPos pos, final Random rand) {
        super.m_7100_(state, world, pos, rand);
        if (rand.nextInt(5) == 0) {
            final double dx = pos.m_123341_() + ((rand.nextFloat() - rand.nextFloat()) * 0.2f + 0.5f);
            final double dy = pos.m_123342_() + 0.4f + (rand.nextFloat() - rand.nextFloat()) * 0.3f;
            final double dz = pos.m_123343_() + ((rand.nextFloat() - rand.nextFloat()) * 0.2f + 0.5f);
            world.m_7106_((ParticleOptions)TFParticleType.FIREFLY.get(), dx, dy, dz, 0.0, 0.0, 0.0);
        }
    }
    
    public InteractionResult m_6227_(final BlockState state, final Level level, final BlockPos pos, final Player player, final InteractionHand hand, final BlockHitResult hitResult) {
        final ItemStack stack = player.m_21120_(hand);
        if (stack.m_41720_() == ((Block)TFBlocks.FIREFLY.get()).m_5456_() && !player.m_6144_() && (int)state.m_61143_((Property)FireflySpawnerBlock.RADIUS) < 10) {
            level.m_46597_(pos, (BlockState)state.m_61124_((Property)FireflySpawnerBlock.RADIUS, (Comparable)((int)state.m_61143_((Property)FireflySpawnerBlock.RADIUS) + 1)));
            if (!player.m_7500_()) {
                stack.m_41774_(1);
            }
            player.m_5661_((Component)new TranslatableComponent("block.twilightforest.firefly_spawner_radius", new Object[] { (int)state.m_61143_((Property)FireflySpawnerBlock.RADIUS) + 1 }), true);
            return InteractionResult.m_19078_(level.f_46443_);
        }
        if (player.m_6144_() && (int)state.m_61143_((Property)FireflySpawnerBlock.RADIUS) > 1) {
            level.m_46597_(pos, (BlockState)state.m_61124_((Property)FireflySpawnerBlock.RADIUS, (Comparable)((int)state.m_61143_((Property)FireflySpawnerBlock.RADIUS) - 1)));
            final ItemEntity bug = new ItemEntity(level, pos.m_123341_() + 0.5, (double)(pos.m_123342_() + 1), pos.m_123343_() + 0.5, new ItemStack((ItemLike)TFBlocks.FIREFLY.get()));
            level.m_7967_((Entity)bug);
            player.m_5661_((Component)new TranslatableComponent("block.twilightforest.firefly_spawner_radius", new Object[] { (int)state.m_61143_((Property)FireflySpawnerBlock.RADIUS) - 1 }), true);
            return InteractionResult.m_19078_(level.f_46443_);
        }
        return super.m_6227_(state, level, pos, player, hand, hitResult);
    }
    
    @Override
    public ParticleType<?> getParticlesToSpawn() {
        return (ParticleType<?>)TFParticleType.JAR_WANDERING_FIREFLY.get();
    }
    
    @Override
    public int getParticleCountPerSpawn(final BlockState state) {
        return (int)Math.ceil((int)state.m_61143_((Property)FireflySpawnerBlock.RADIUS) / 2.0);
    }
    
    static {
        SHAPE = Block.m_49796_(3.0, 0.0, 3.0, 13.0, 14.0, 13.0);
    }
}
