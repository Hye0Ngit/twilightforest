// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import java.util.Random;
import twilightforest.client.particle.TFParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.world.item.ItemStack;
import twilightforest.item.TFItems;
import net.minecraft.world.level.ItemLike;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import twilightforest.TFSounds;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.level.BlockGetter;
import twilightforest.block.entity.TFBlockEntities;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import javax.annotation.Nullable;
import twilightforest.block.entity.TrophyBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import twilightforest.enums.BossVariant;
import net.minecraft.world.level.block.BaseEntityBlock;

public abstract class AbstractTrophyBlock extends BaseEntityBlock
{
    private final BossVariant variant;
    private final int comparatorValue;
    public static final BooleanProperty POWERED;
    
    protected AbstractTrophyBlock(final BossVariant variant, final int value, final BlockBehaviour.Properties builder) {
        super(builder);
        this.variant = variant;
        this.comparatorValue = value;
        this.m_49959_((BlockState)((BlockState)this.f_49792_.m_61090_()).m_61124_((Property)AbstractTrophyBlock.POWERED, (Comparable)false));
    }
    
    public int getComparatorValue() {
        return this.comparatorValue;
    }
    
    public void m_6861_(final BlockState state, final Level worldIn, final BlockPos pos, final Block blockIn, final BlockPos fromPos, final boolean isMoving) {
        if (!worldIn.f_46443_) {
            final boolean flag = worldIn.m_46753_(pos);
            if (flag != (boolean)state.m_61143_((Property)AbstractTrophyBlock.POWERED)) {
                if (flag) {
                    this.playSound(worldIn, pos);
                }
                worldIn.m_46597_(pos, (BlockState)state.m_61124_((Property)AbstractTrophyBlock.POWERED, (Comparable)flag));
            }
        }
    }
    
    public InteractionResult m_6227_(final BlockState state, final Level worldIn, final BlockPos pos, final Player playerIn, final InteractionHand handIn, final BlockHitResult hit) {
        this.playSound(worldIn, pos);
        this.createParticle(worldIn, pos);
        return InteractionResult.SUCCESS;
    }
    
    @Nullable
    public BlockEntity m_142194_(final BlockPos pos, final BlockState state) {
        return new TrophyBlockEntity(pos, state);
    }
    
    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> m_142354_(final Level level, final BlockState state, final BlockEntityType<T> type) {
        return (BlockEntityTicker<T>)m_152132_((BlockEntityType)type, (BlockEntityType)TFBlockEntities.TROPHY.get(), TrophyBlockEntity::tick);
    }
    
    public BossVariant getVariant() {
        return this.variant;
    }
    
    public boolean m_7357_(final BlockState state, final BlockGetter worldIn, final BlockPos pos, final PathComputationType type) {
        return false;
    }
    
    protected void m_7926_(final StateDefinition.Builder<Block, BlockState> builder) {
        builder.m_61104_(new Property[] { (Property)AbstractTrophyBlock.POWERED });
    }
    
    public void playSound(final Level world, final BlockPos pos) {
        final BlockEntity te = world.m_7702_(pos);
        if (!world.f_46443_ && te instanceof TrophyBlockEntity) {
            SoundEvent sound = null;
            float volume = 1.0f;
            float pitch = 0.9f;
            switch (this.variant) {
                case NAGA: {
                    sound = TFSounds.NAGA_RATTLE;
                    volume = 1.25f;
                    pitch = 1.2f;
                    break;
                }
                case LICH: {
                    sound = TFSounds.LICH_AMBIENT;
                    volume = 0.35f;
                    pitch = 1.1f;
                    break;
                }
                case HYDRA: {
                    sound = TFSounds.HYDRA_GROWL;
                    pitch = 1.2f;
                    break;
                }
                case UR_GHAST: {
                    sound = TFSounds.URGHAST_AMBIENT;
                    pitch = 0.6f;
                    break;
                }
                case SNOW_QUEEN: {
                    sound = TFSounds.SNOW_QUEEN_AMBIENT;
                    break;
                }
                case KNIGHT_PHANTOM: {
                    sound = TFSounds.PHANTOM_AMBIENT;
                    pitch = 1.1f;
                    break;
                }
                case MINOSHROOM: {
                    sound = TFSounds.MINOSHROOM_AMBIENT;
                    volume = 0.75f;
                    pitch = 0.7f;
                    break;
                }
                case ALPHA_YETI: {
                    sound = ((world.f_46441_.nextInt(50) == 0) ? TFSounds.ALPHAYETI_ROAR : TFSounds.ALPHAYETI_GROWL);
                    volume = 0.75f;
                    pitch = 0.75f;
                    break;
                }
                case QUEST_RAM: {
                    sound = TFSounds.QUEST_RAM_AMBIENT;
                    pitch = 0.7f;
                    break;
                }
            }
            if (sound != null) {
                world.m_5594_((Player)null, pos, sound, SoundSource.BLOCKS, volume, world.f_46441_.nextFloat() * 0.1f + pitch);
            }
        }
    }
    
    public void createParticle(final Level world, final BlockPos pos) {
        final BlockEntity te = world.m_7702_(pos);
        if (te instanceof TrophyBlockEntity) {
            final Random rand = world.m_5822_();
            if (world instanceof final ServerLevel serverLevel) {
                switch (this.variant) {
                    case NAGA: {
                        for (int daze = 0; daze < 10; ++daze) {
                            serverLevel.m_8767_((ParticleOptions)ParticleTypes.f_123797_, pos.m_123341_() + rand.nextFloat() * 0.5 * 2.0, pos.m_123342_() + 0.25, pos.m_123343_() + rand.nextFloat() * 0.5 * 2.0, 1, 0.0, 0.0, 0.0, rand.nextGaussian() * 0.02);
                        }
                        break;
                    }
                    case LICH: {
                        for (int a = 0; a < 5; ++a) {
                            serverLevel.m_8767_((ParticleOptions)ParticleTypes.f_123792_, pos.m_123341_() + rand.nextFloat() * 0.5 * 2.0, pos.m_123342_() + 0.5 + rand.nextFloat() * 0.25, pos.m_123343_() + rand.nextFloat() * 0.5 * 2.0, 1, rand.nextGaussian() * 0.02, rand.nextGaussian() * 0.02, rand.nextGaussian() * 0.02, 0.0);
                        }
                        break;
                    }
                    case MINOSHROOM: {
                        for (int g = 0; g < 10; ++g) {
                            serverLevel.m_8767_((ParticleOptions)new BlockParticleOption(ParticleTypes.f_123794_, world.m_8055_(pos.m_7495_())), pos.m_123341_() + (double)(rand.nextFloat() * 10.0f) - 5.0, pos.m_123342_() + 0.10000000149011612 + rand.nextFloat() * 0.3f, pos.m_123343_() + (double)(rand.nextFloat() * 10.0f) - 5.0, 1, 0.0, 0.0, 0.0, 0.0);
                        }
                        break;
                    }
                    case KNIGHT_PHANTOM: {
                        for (int brek = 0; brek < 10; ++brek) {
                            serverLevel.m_8767_((ParticleOptions)new ItemParticleOption(ParticleTypes.f_123752_, new ItemStack((ItemLike)TFItems.KNIGHTMETAL_SWORD.get())), pos.m_123341_() + 0.5 + (rand.nextFloat() - 0.5), pos.m_123342_() + rand.nextFloat() + 0.5, pos.m_123343_() + 0.5 + (rand.nextFloat() - 0.5), 1, 0.0, 0.25, 0.0, 0.0);
                        }
                        break;
                    }
                    case UR_GHAST: {
                        for (int red = 0; red < 10; ++red) {
                            serverLevel.m_8767_((ParticleOptions)DustParticleOptions.f_123656_, pos.m_123341_() + rand.nextDouble() * 1.0 - 0.25, pos.m_123342_() + rand.nextDouble() * 0.5 + 0.5, pos.m_123343_() + rand.nextDouble() * 1.0, 1, 0.0, 0.0, 0.0, 0.0);
                        }
                        break;
                    }
                    case ALPHA_YETI: {
                        for (int sweat = 0; sweat < 10; ++sweat) {
                            serverLevel.m_8767_((ParticleOptions)ParticleTypes.f_123769_, pos.m_123341_() + rand.nextDouble() * 1.0 - 0.25, pos.m_123342_() + rand.nextDouble() * 0.5 + 0.5, pos.m_123343_() + rand.nextDouble() * 1.0, 1, 0.0, 0.0, 0.0, 0.0);
                        }
                        break;
                    }
                    case SNOW_QUEEN: {
                        for (int b = 0; b < 20; ++b) {
                            serverLevel.m_8767_((ParticleOptions)TFParticleType.SNOW_WARNING.get(), pos.m_123341_() - 1.0 + rand.nextDouble() * 3.25, pos.m_123342_() + 5.0, pos.m_123343_() - 1.0 + rand.nextDouble() * 3.25, 1, 0.0, 1.0, 0.0, 0.0);
                        }
                        break;
                    }
                    case QUEST_RAM: {
                        for (int p = 0; p < 10; ++p) {
                            serverLevel.m_8767_((ParticleOptions)ParticleTypes.f_123811_, pos.m_123341_() + 0.5 + (rand.nextDouble() - 0.5), pos.m_123342_() + (rand.nextDouble() - 0.5), pos.m_123343_() + 0.5 + (rand.nextDouble() - 0.5), 1, (double)rand.nextFloat(), (double)rand.nextFloat(), (double)rand.nextFloat(), 1.0);
                        }
                        break;
                    }
                }
            }
        }
    }
    
    static {
        POWERED = BlockStateProperties.f_61448_;
    }
}
