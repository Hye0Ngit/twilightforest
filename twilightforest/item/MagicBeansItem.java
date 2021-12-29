// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.core.Direction;
import net.minecraft.tags.Tag;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.util.Mth;
import javax.annotation.Nonnull;
import net.minecraft.advancements.Advancement;
import net.minecraft.server.ServerAdvancementManager;
import net.minecraft.server.PlayerAdvancements;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.entity.player.Player;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import twilightforest.TwilightForestMod;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.stats.Stats;
import net.minecraft.server.level.ServerPlayer;
import twilightforest.block.TFBlocks;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.Item;

public class MagicBeansItem extends Item
{
    private int blocksSkipped;
    
    protected MagicBeansItem(final Item.Properties props) {
        super(props);
    }
    
    @Nonnull
    public InteractionResult m_6225_(final UseOnContext context) {
        final Level world = context.m_43725_();
        final BlockPos pos = context.m_8083_();
        final Player player = context.m_43723_();
        final Block blockAt = world.m_8055_(pos).m_60734_();
        final ItemStack stack = context.m_43722_();
        final int minY = pos.m_123342_() + 1;
        final int maxY = Math.max(pos.m_123342_() + 100, 175);
        if (pos.m_123342_() < maxY && blockAt == TFBlocks.UBEROUS_SOIL.get()) {
            if (!world.f_46443_) {
                stack.m_41774_(1);
                this.makeHugeStalk(world, pos, minY, maxY);
                if (player instanceof ServerPlayer) {
                    player.m_36246_(Stats.f_12982_.m_12902_((Object)this));
                    final PlayerAdvancements advancements = ((ServerPlayer)player).m_8960_();
                    final ServerAdvancementManager manager = ((ServerLevel)player.m_20193_()).m_142572_().m_129889_();
                    final Advancement advancement = manager.m_136041_(TwilightForestMod.prefix("beanstalk"));
                    if (advancement != null) {
                        advancements.m_135988_(advancement, "use_beans");
                    }
                }
            }
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }
    
    private void makeHugeStalk(final Level world, final BlockPos pos, final int minY, final int maxY) {
        float x = (float)pos.m_123341_();
        float z = (float)pos.m_123343_();
        final int yOffset = world.f_46441_.nextInt(100);
        final float cScale = world.f_46441_.nextFloat() * 0.25f + 0.125f;
        final float rScale = world.f_46441_.nextFloat() * 0.25f + 0.125f;
        float radius = 4.0f + Mth.m_14031_((minY + yOffset) * rScale) * 3.0f;
        x -= Mth.m_14031_((minY + yOffset) * cScale) * radius;
        z -= Mth.m_14089_((minY + yOffset) * cScale) * radius;
        int nextLeafY = minY + 10 + world.f_46441_.nextInt(20);
        boolean isClear = true;
        for (int dy = minY; dy < maxY && isClear; ++dy) {
            radius = 5.0f + Mth.m_14031_((dy + yOffset) * rScale) * 2.5f;
            final float cx = x + Mth.m_14031_((dy + yOffset) * cScale) * radius;
            final float cz = z + Mth.m_14089_((dy + yOffset) * cScale) * radius;
            float stalkThickness = 2.5f;
            if (maxY - dy < 5) {
                stalkThickness *= (maxY - dy) / 5.0f;
            }
            final int minX = Mth.m_14143_(x - radius - stalkThickness);
            final int maxX = Mth.m_14167_(x + radius + stalkThickness);
            final int minZ = Mth.m_14143_(z - radius - stalkThickness);
            final int maxZ = Mth.m_14167_(z + radius + stalkThickness);
            for (int dx = minX; dx < maxX && isClear; ++dx) {
                for (int dz = minZ; dz < maxZ && isClear; ++dz) {
                    if ((dx - cx) * (dx - cx) + (dz - cz) * (dz - cz) < stalkThickness * stalkThickness) {
                        isClear = this.tryToPlaceStalk(world, new BlockPos(dx, dy, dz));
                    }
                }
            }
            this.blocksSkipped = 0;
            if (dy == nextLeafY) {
                final int lx = (int)(x + Mth.m_14031_((dy + yOffset) * cScale) * (radius + stalkThickness));
                final int lz = (int)(z + Mth.m_14089_((dy + yOffset) * cScale) * (radius + stalkThickness));
                this.placeLeaves(world, new BlockPos(lx, dy, lz));
                nextLeafY = dy + 5 + world.f_46441_.nextInt(10);
            }
        }
    }
    
    private void placeLeaves(final Level world, final BlockPos pos) {
        world.m_46597_(pos, ((RotatedPillarBlock)TFBlocks.HUGE_STALK.get()).m_49966_());
        for (int dx = -1; dx <= 1; ++dx) {
            for (int dz = -1; dz <= 1; ++dz) {
                this.tryToPlaceLeaves(world, pos.m_142082_(dx, -1, dz));
                this.tryToPlaceLeaves(world, pos.m_142082_(dx, 1, dz));
            }
        }
        for (int dx = -2; dx <= 2; ++dx) {
            for (int dz = -2; dz <= 2; ++dz) {
                if ((dx != 2 && dx != -2) || (dz != 2 && dz != -2)) {
                    this.tryToPlaceLeaves(world, pos.m_142082_(dx, 0, dz));
                }
            }
        }
    }
    
    private boolean tryToPlaceStalk(final Level world, final BlockPos pos) {
        final BlockState state = world.m_8055_(pos);
        if (state.m_60795_() || state.m_60767_().m_76336_() || state.m_60795_() || state.m_60620_((Tag)BlockTags.f_13035_) || BlockTags.f_13035_.m_8110_((Object)state.m_60734_()) || state.m_60734_().equals(TFBlocks.FLUFFY_CLOUD.get())) {
            world.m_46597_(pos, ((RotatedPillarBlock)TFBlocks.HUGE_STALK.get()).m_49966_());
            if (pos.m_123342_() > 150) {
                for (int i = 0; i < 7; ++i) {
                    if (world.m_8055_(pos.m_5484_(Direction.UP, i)).equals(((Block)TFBlocks.WISPY_CLOUD.get()).m_49966_()) || world.m_8055_(pos.m_5484_(Direction.UP, i)).equals(((Block)TFBlocks.FLUFFY_CLOUD.get()).m_49966_())) {
                        world.m_46597_(pos.m_5484_(Direction.UP, i), Blocks.f_50016_.m_49966_());
                    }
                }
            }
            return true;
        }
        ++this.blocksSkipped;
        return this.blocksSkipped < 15;
    }
    
    private void tryToPlaceLeaves(final Level world, final BlockPos pos) {
        final BlockState state = world.m_8055_(pos);
        if (state.m_60795_() || state.m_60620_((Tag)BlockTags.f_13035_)) {
            world.m_7731_(pos, (BlockState)((Block)TFBlocks.BEANSTALK_LEAVES.get()).m_49966_().m_61124_((Property)LeavesBlock.f_54419_, (Comparable)true), 2);
        }
    }
}
