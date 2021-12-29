// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.Tag;
import net.minecraft.tags.BlockTags;
import java.util.Iterator;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import twilightforest.item.TFItems;
import net.minecraft.world.entity.player.Player;
import java.util.Random;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.FarmBlock;
import net.minecraft.world.level.block.StemBlock;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.item.BoneMealItem;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.PlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraft.core.Direction;
import javax.annotation.Nullable;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.Block;

public class UberousSoilBlock extends Block implements BonemealableBlock
{
    protected static final VoxelShape SHAPE;
    
    public UberousSoilBlock(final BlockBehaviour.Properties props) {
        super(props);
    }
    
    public VoxelShape m_5940_(final BlockState pState, final BlockGetter pLevel, final BlockPos pPos, final CollisionContext pContext) {
        return UberousSoilBlock.SHAPE;
    }
    
    @Nullable
    public BlockState m_5573_(final BlockPlaceContext ctx) {
        return ctx.m_43725_().m_8055_(ctx.m_8083_().m_7494_()).m_60767_().m_76333_() ? Blocks.f_50493_.m_49966_() : super.m_5573_(ctx);
    }
    
    public boolean canSustainPlant(final BlockState state, final BlockGetter world, final BlockPos pos, final Direction direction, final IPlantable plantable) {
        if (direction != Direction.UP) {
            return false;
        }
        final PlantType plantType = plantable.getPlantType(world, pos.m_142300_(direction));
        return plantType == PlantType.CROP || plantType == PlantType.PLAINS || plantType == PlantType.CAVE;
    }
    
    public void m_6861_(final BlockState state, final Level world, final BlockPos pos, final Block blockIn, final BlockPos fromPos, final boolean isMoving) {
        final BlockState above = world.m_8055_(pos.m_7494_());
        final Material aboveMaterial = above.m_60767_();
        if (aboveMaterial.m_76333_()) {
            world.m_46597_(pos, m_49897_(state, Blocks.f_50493_.m_49966_(), world, pos));
        }
        if (above.m_60734_() instanceof BonemealableBlock) {
            for (int i = 0; i < 15; ++i) {
                BoneMealItem.m_40627_(new ItemStack((ItemLike)Items.f_42499_), world, pos.m_7494_());
            }
            world.m_46796_(2005, pos.m_7494_(), 0);
            if (above.m_60734_() instanceof CropBlock || above.m_60734_() instanceof StemBlock) {
                world.m_46597_(pos, (BlockState)Blocks.f_50093_.m_49966_().m_61124_((Property)FarmBlock.f_53243_, (Comparable)7));
            }
        }
    }
    
    public void m_7100_(final BlockState state, final Level level, final BlockPos pos, final Random rand) {
        if (level.f_46443_ && rand.nextInt(5) == 0) {
            for (final Player player : level.m_6907_()) {
                if (player.m_21205_().m_41720_().equals(TFItems.MAGIC_BEANS.get()) || player.m_21206_().m_41720_().equals(TFItems.MAGIC_BEANS.get())) {
                    for (int i = 0; i < 2; ++i) {
                        level.m_7106_((ParticleOptions)ParticleTypes.f_123748_, pos.m_123341_() + rand.nextDouble(), pos.m_123342_() + 1.25, pos.m_123343_() + rand.nextDouble(), 0.0, 0.0, 0.0);
                    }
                    break;
                }
            }
        }
    }
    
    public boolean m_7370_(final BlockGetter world, final BlockPos pos, final BlockState state, final boolean isClient) {
        for (final Direction dir : Direction.values()) {
            if (dir != Direction.UP && dir != Direction.DOWN) {
                final BlockState blockAt = world.m_8055_(pos.m_142300_(dir));
                if (!world.m_8055_(pos.m_142300_(dir).m_7494_()).m_60767_().m_76333_() && (blockAt.m_60620_((Tag)BlockTags.f_144274_) || blockAt.m_60713_(Blocks.f_50093_)) && !blockAt.m_60713_((Block)TFBlocks.UBEROUS_SOIL.get())) {
                    return true;
                }
                if (!world.m_8055_(pos.m_142300_(dir).m_7494_().m_7494_()).m_60767_().m_76333_() && (world.m_8055_(pos.m_142300_(dir).m_7494_()).m_60620_((Tag)BlockTags.f_144274_) || world.m_8055_(pos.m_142300_(dir).m_7494_()).m_60713_(Blocks.f_50093_)) && !world.m_8055_(pos.m_142300_(dir).m_7494_()).m_60713_((Block)TFBlocks.UBEROUS_SOIL.get())) {
                    return true;
                }
                if (!world.m_8055_(pos.m_142300_(dir)).m_60767_().m_76333_() && (world.m_8055_(pos.m_142300_(dir).m_7495_()).m_60620_((Tag)BlockTags.f_144274_) || world.m_8055_(pos.m_142300_(dir).m_7495_()).m_60713_(Blocks.f_50093_)) && !world.m_8055_(pos.m_142300_(dir).m_7495_()).m_60713_((Block)TFBlocks.UBEROUS_SOIL.get())) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean m_5491_(final Level world, final Random rand, final BlockPos pos, final BlockState state) {
        return true;
    }
    
    public void m_7719_(final ServerLevel world, final Random rand, final BlockPos pos, final BlockState state) {
        for (final Direction dir : Direction.values()) {
            if (dir != Direction.UP && dir != Direction.DOWN) {
                final BlockState blockAt = world.m_8055_(pos.m_142300_(dir));
                if (!world.m_8055_(pos.m_142300_(dir).m_7494_()).m_60767_().m_76333_() && (blockAt.m_60620_((Tag)BlockTags.f_144274_) || blockAt.m_60713_(Blocks.f_50093_)) && !blockAt.m_60713_((Block)TFBlocks.UBEROUS_SOIL.get())) {
                    world.m_46597_(pos.m_142300_(dir), this.m_49966_());
                    break;
                }
                if (!world.m_8055_(pos.m_142300_(dir).m_7494_().m_7494_()).m_60767_().m_76333_() && (world.m_8055_(pos.m_142300_(dir).m_7494_()).m_60620_((Tag)BlockTags.f_144274_) || world.m_8055_(pos.m_142300_(dir).m_7494_()).m_60713_(Blocks.f_50093_)) && !world.m_8055_(pos.m_142300_(dir).m_7494_()).m_60713_((Block)TFBlocks.UBEROUS_SOIL.get())) {
                    world.m_46597_(pos.m_142300_(dir).m_7494_(), this.m_49966_());
                    break;
                }
                if (!world.m_8055_(pos.m_142300_(dir)).m_60767_().m_76333_() && (world.m_8055_(pos.m_142300_(dir).m_7495_()).m_60620_((Tag)BlockTags.f_144274_) || world.m_8055_(pos.m_142300_(dir).m_7495_()).m_60713_(Blocks.f_50093_)) && !world.m_8055_(pos.m_142300_(dir).m_7495_()).m_60713_((Block)TFBlocks.UBEROUS_SOIL.get())) {
                    world.m_46597_(pos.m_142300_(dir).m_7495_(), this.m_49966_());
                    break;
                }
            }
        }
    }
    
    static {
        SHAPE = Block.m_49796_(0.0, 0.0, 0.0, 16.0, 15.0, 16.0);
    }
}
