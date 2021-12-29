// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import twilightforest.inventory.UncraftingContainer;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.level.block.state.StateDefinition;
import javax.annotation.Nullable;
import net.minecraft.network.chat.Component;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.MenuProvider;
import net.minecraft.sounds.SoundSource;
import twilightforest.TFSounds;
import net.minecraft.world.level.block.Blocks;
import twilightforest.util.TFStats;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.Block;

public class UncraftingTableBlock extends Block
{
    public static final BooleanProperty POWERED;
    
    protected UncraftingTableBlock() {
        super(BlockBehaviour.Properties.m_60939_(Material.f_76320_).m_60978_(2.5f).m_60918_(SoundType.f_56736_));
        this.m_49959_((BlockState)((BlockState)this.f_49792_.m_61090_()).m_61124_((Property)UncraftingTableBlock.POWERED, (Comparable)false));
    }
    
    @Deprecated
    public InteractionResult m_6227_(final BlockState state, final Level world, final BlockPos pos, final Player player, final InteractionHand handIn, final BlockHitResult hit) {
        if (!world.f_46443_) {
            player.m_5893_(state.m_60750_(world, pos));
            player.m_36220_(TFStats.UNCRAFTING_TABLE_INTERACTIONS);
        }
        return InteractionResult.SUCCESS;
    }
    
    public void m_6861_(final BlockState state, final Level worldIn, final BlockPos pos, final Block blockIn, final BlockPos fromPos, final boolean isMoving) {
        if (!worldIn.f_46443_) {
            final boolean flag = worldIn.m_46753_(pos);
            if (flag != (boolean)state.m_61143_((Property)UncraftingTableBlock.POWERED)) {
                if (flag && worldIn.m_8055_(pos.m_7495_()).m_60713_(Blocks.f_152490_)) {
                    worldIn.m_5594_((Player)null, pos, TFSounds.UNCRAFTING_TABLE_ACTIVATE, SoundSource.BLOCKS, 0.5f, 1.0f);
                }
                worldIn.m_46597_(pos, (BlockState)state.m_61124_((Property)UncraftingTableBlock.POWERED, (Comparable)flag));
            }
        }
    }
    
    @Nullable
    public MenuProvider m_7246_(final BlockState state, final Level world, final BlockPos pos) {
        return (MenuProvider)new SimpleMenuProvider((id, inv, player) -> new UncraftingContainer(id, inv, player.f_19853_, ContainerLevelAccess.m_39289_(world, pos)), (Component)new TranslatableComponent(this.m_7705_()));
    }
    
    protected void m_7926_(final StateDefinition.Builder<Block, BlockState> builder) {
        builder.m_61104_(new Property[] { (Property)UncraftingTableBlock.POWERED });
    }
    
    static {
        POWERED = BlockStateProperties.f_61448_;
    }
}
