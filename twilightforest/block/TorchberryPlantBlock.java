// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.server.level.ServerLevel;
import java.util.Random;
import twilightforest.util.TFStats;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import twilightforest.item.TFItems;
import net.minecraft.world.level.ItemLike;
import net.minecraft.sounds.SoundSource;
import twilightforest.TFSounds;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.BonemealableBlock;

public class TorchberryPlantBlock extends TFPlantBlock implements BonemealableBlock
{
    public static final BooleanProperty HAS_BERRIES;
    private static final VoxelShape TORCHBERRY_SHAPE;
    
    public TorchberryPlantBlock(final BlockBehaviour.Properties props) {
        super(props);
        this.m_49959_((BlockState)((BlockState)this.m_49965_().m_61090_()).m_61124_((Property)TorchberryPlantBlock.HAS_BERRIES, (Comparable)false));
    }
    
    @Override
    public boolean m_7898_(final BlockState state, final LevelReader world, final BlockPos pos) {
        return TFPlantBlock.canPlaceRootAt(world, pos);
    }
    
    public VoxelShape m_5940_(final BlockState state, final BlockGetter access, final BlockPos pos, final CollisionContext context) {
        return TorchberryPlantBlock.TORCHBERRY_SHAPE;
    }
    
    public InteractionResult m_6227_(final BlockState state, final Level level, final BlockPos pos, final Player player, final InteractionHand hand, final BlockHitResult result) {
        if (state.m_61143_((Property)TorchberryPlantBlock.HAS_BERRIES)) {
            level.m_46597_(pos, (BlockState)state.m_61124_((Property)TorchberryPlantBlock.HAS_BERRIES, (Comparable)false));
            level.m_5594_((Player)null, pos, TFSounds.PICKED_TORCHBERRIES, SoundSource.BLOCKS, 1.0f, 1.0f);
            final ItemEntity torchberries = new ItemEntity(level, (double)pos.m_123341_(), (double)pos.m_123342_(), (double)pos.m_123343_(), new ItemStack((ItemLike)TFItems.TORCHBERRIES.get()));
            level.m_7967_((Entity)torchberries);
            if (player instanceof ServerPlayer) {
                player.m_36220_(TFStats.TORCHBERRIES_HARVESTED);
            }
            return InteractionResult.m_19078_(level.f_46443_);
        }
        return super.m_6227_(state, level, pos, player, hand, result);
    }
    
    @Override
    public boolean m_7370_(final BlockGetter level, final BlockPos pos, final BlockState state, final boolean isClient) {
        return !(boolean)state.m_61143_((Property)TorchberryPlantBlock.HAS_BERRIES);
    }
    
    @Override
    public boolean m_5491_(final Level level, final Random rand, final BlockPos pos, final BlockState state) {
        return true;
    }
    
    @Override
    public void m_7719_(final ServerLevel level, final Random rand, final BlockPos pos, final BlockState state) {
        level.m_7731_(pos, (BlockState)state.m_61124_((Property)TorchberryPlantBlock.HAS_BERRIES, (Comparable)true), 2);
    }
    
    protected void m_7926_(final StateDefinition.Builder<Block, BlockState> builder) {
        builder.m_61104_(new Property[] { (Property)TorchberryPlantBlock.HAS_BERRIES });
    }
    
    static {
        HAS_BERRIES = BooleanProperty.m_61465_("has_torchberries");
        TORCHBERRY_SHAPE = m_49796_(1.0, 2.0, 1.0, 15.0, 16.0, 15.0);
    }
}
