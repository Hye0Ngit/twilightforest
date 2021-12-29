// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.world.level.BlockGetter;
import twilightforest.block.entity.TFBlockEntities;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundSource;
import twilightforest.TFSounds;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.tags.Tag;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.server.level.ServerLevel;
import twilightforest.block.entity.TomeSpawnerBlockEntity;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.LivingEntity;
import javax.annotation.Nullable;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.BaseEntityBlock;

public class TomeSpawnerBlock extends BaseEntityBlock
{
    public static IntegerProperty BOOK_STAGES;
    public static BooleanProperty SPAWNER;
    
    protected TomeSpawnerBlock(final BlockBehaviour.Properties properties) {
        super(properties);
        this.m_49959_((BlockState)((BlockState)((BlockState)this.m_49965_().m_61090_()).m_61124_((Property)TomeSpawnerBlock.BOOK_STAGES, (Comparable)10)).m_61124_((Property)TomeSpawnerBlock.SPAWNER, (Comparable)true));
    }
    
    protected void m_7926_(final StateDefinition.Builder<Block, BlockState> builder) {
        builder.m_61104_(new Property[] { (Property)TomeSpawnerBlock.BOOK_STAGES, (Property)TomeSpawnerBlock.SPAWNER });
    }
    
    public void catchFire(final BlockState state, final Level world, final BlockPos pos, @Nullable final Direction face, @Nullable final LivingEntity igniter) {
        if (world.m_46791_() != Difficulty.PEACEFUL && (boolean)world.m_8055_(pos).m_61143_((Property)TomeSpawnerBlock.SPAWNER)) {
            final BlockEntity 7702_ = world.m_7702_(pos);
            if (7702_ instanceof final TomeSpawnerBlockEntity ts) {
                if (world instanceof final ServerLevel level) {
                    for (int i = 0; i < (int)state.m_61143_((Property)TomeSpawnerBlock.BOOK_STAGES); ++i) {
                        ts.attemptSpawnTome(level, pos, true);
                    }
                    world.m_46961_(pos, false);
                }
            }
        }
        super.catchFire(state, world, pos, face, igniter);
    }
    
    public void m_6861_(final BlockState state, final Level level, final BlockPos pos, final Block block, final BlockPos fromPos, final boolean isMoving) {
        for (final Direction direction : Direction.values()) {
            if (level.m_8055_(pos.m_142300_(direction)).m_60620_((Tag)BlockTags.f_13076_)) {
                this.catchFire(state, level, pos, direction, null);
                break;
            }
        }
    }
    
    public void m_6240_(final Level level, final Player player, final BlockPos pos, final BlockState state, @Nullable final BlockEntity entity, final ItemStack stack) {
        if (!level.f_46443_ && (boolean)state.m_61143_((Property)TomeSpawnerBlock.SPAWNER)) {
            level.m_5594_((Player)null, pos, TFSounds.TOME_DEATH, SoundSource.BLOCKS, 1.0f, 1.0f);
            for (int i = 0; i < 20; ++i) {
                final double d3 = level.f_46441_.nextGaussian() * 0.02;
                final double d4 = level.f_46441_.nextGaussian() * 0.02;
                final double d5 = level.f_46441_.nextGaussian() * 0.02;
                ((ServerLevel)level).m_8767_((ParticleOptions)ParticleTypes.f_123759_, pos.m_123341_() + 0.5, (double)pos.m_123342_(), pos.m_123343_() + 0.5, 1, d3, d4, d5, 0.15000000596046448);
            }
        }
        super.m_6240_(level, player, pos, state, entity, stack);
    }
    
    public RenderShape m_7514_(final BlockState state) {
        return RenderShape.MODEL;
    }
    
    public float getEnchantPowerBonus(final BlockState state, final LevelReader world, final BlockPos pos) {
        return (int)state.m_61143_((Property)TomeSpawnerBlock.BOOK_STAGES) * 0.1f;
    }
    
    @Nullable
    public BlockEntity m_142194_(final BlockPos blockPos, final BlockState blockState) {
        return blockState.m_61143_((Property)TomeSpawnerBlock.SPAWNER) ? new TomeSpawnerBlockEntity(blockPos, blockState) : null;
    }
    
    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> m_142354_(final Level level, final BlockState state, final BlockEntityType<T> type) {
        return (BlockEntityTicker<T>)(state.m_61143_((Property)TomeSpawnerBlock.SPAWNER) ? m_152132_((BlockEntityType)type, (BlockEntityType)TFBlockEntities.TOME_SPAWNER.get(), TomeSpawnerBlockEntity::tick) : null);
    }
    
    public int getFlammability(final BlockState state, final BlockGetter world, final BlockPos pos, final Direction face) {
        return 20;
    }
    
    public int getFireSpreadSpeed(final BlockState state, final BlockGetter world, final BlockPos pos, final Direction face) {
        return 30;
    }
    
    static {
        TomeSpawnerBlock.BOOK_STAGES = IntegerProperty.m_61631_("book_stages", 1, 10);
        TomeSpawnerBlock.SPAWNER = BooleanProperty.m_61465_("spawner");
    }
}
