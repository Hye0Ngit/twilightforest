// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.world.Container;
import net.minecraft.world.Containers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.world.level.block.Blocks;
import java.util.Random;
import net.minecraft.world.level.block.entity.FurnaceBlockEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import twilightforest.block.entity.TFBlockEntities;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.Level;
import javax.annotation.Nullable;
import twilightforest.block.entity.CinderFurnaceBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.BaseEntityBlock;

public class CinderFurnaceBlock extends BaseEntityBlock
{
    public static final BooleanProperty LIT;
    private static final DirectionProperty FACING;
    
    CinderFurnaceBlock() {
        super(BlockBehaviour.Properties.m_60939_(Material.f_76320_).m_60999_().m_60978_(7.0f).m_60953_(state -> 15));
        this.m_49959_((BlockState)((BlockState)((BlockState)this.f_49792_.m_61090_()).m_61124_((Property)CinderFurnaceBlock.FACING, (Comparable)Direction.NORTH)).m_61124_((Property)CinderFurnaceBlock.LIT, (Comparable)false));
    }
    
    public RenderShape m_7514_(final BlockState p_49232_) {
        return RenderShape.MODEL;
    }
    
    public int getLightEmission(final BlockState state, final BlockGetter world, final BlockPos pos) {
        return state.m_61143_((Property)CinderFurnaceBlock.LIT) ? 15 : 0;
    }
    
    protected void m_7926_(final StateDefinition.Builder<Block, BlockState> builder) {
        super.m_7926_((StateDefinition.Builder)builder);
        builder.m_61104_(new Property[] { (Property)CinderFurnaceBlock.LIT, (Property)CinderFurnaceBlock.FACING });
    }
    
    @Nullable
    public BlockEntity m_142194_(final BlockPos pos, final BlockState state) {
        return (BlockEntity)new CinderFurnaceBlockEntity(pos, state);
    }
    
    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> m_142354_(final Level level, final BlockState state, final BlockEntityType<T> type) {
        return (BlockEntityTicker<T>)m_152132_((BlockEntityType)type, (BlockEntityType)TFBlockEntities.CINDER_FURNACE.get(), CinderFurnaceBlockEntity::tick);
    }
    
    @Deprecated
    public boolean m_8133_(final BlockState state, final Level worldIn, final BlockPos pos, final int id, final int param) {
        super.m_8133_(state, worldIn, pos, id, param);
        final BlockEntity tileentity = worldIn.m_7702_(pos);
        return tileentity != null && tileentity.m_7531_(id, param);
    }
    
    @Deprecated
    public InteractionResult m_6227_(final BlockState state, final Level world, final BlockPos pos, final Player player, final InteractionHand handIn, final BlockHitResult hit) {
        if (!world.f_46443_ && world.m_7702_(pos) instanceof CinderFurnaceBlockEntity) {
            player.m_5893_((MenuProvider)world.m_7702_(pos));
        }
        return InteractionResult.PASS;
    }
    
    public void m_6402_(final Level world, final BlockPos pos, final BlockState state, @Nullable final LivingEntity placer, final ItemStack stack) {
        if (stack.m_41788_()) {
            ((FurnaceBlockEntity)world.m_7702_(pos)).m_58638_(stack.m_41786_());
        }
    }
    
    @OnlyIn(Dist.CLIENT)
    public void m_7100_(final BlockState state, final Level world, final BlockPos pos, final Random random) {
        if (state.m_61143_((Property)CinderFurnaceBlock.LIT)) {
            Blocks.f_50094_.m_7100_(state, world, pos, random);
        }
    }
    
    @Deprecated
    public void m_6810_(final BlockState state, final Level worldIn, final BlockPos pos, final BlockState newState, final boolean isMoving) {
        if (state.m_60734_() != newState.m_60734_()) {
            final BlockEntity tileentity = worldIn.m_7702_(pos);
            if (tileentity instanceof CinderFurnaceBlockEntity) {
                Containers.m_19002_(worldIn, pos, (Container)tileentity);
                worldIn.m_46717_(pos, (Block)this);
            }
            super.m_6810_(state, worldIn, pos, newState, isMoving);
        }
    }
    
    static {
        LIT = BooleanProperty.m_61465_("lit");
        FACING = TFHorizontalBlock.f_54117_;
    }
}
