// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.dispenser;

import twilightforest.block.WallSkullCandleBlock;
import com.mojang.authlib.GameProfile;
import twilightforest.block.SkullCandleBlock;
import twilightforest.block.AbstractLightableBlock;
import net.minecraft.world.level.block.entity.SkullBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WallSkullBlock;
import net.minecraft.world.level.block.SkullBlock;
import net.minecraft.world.level.block.AbstractSkullBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvents;
import twilightforest.block.AbstractSkullCandleBlock;
import twilightforest.block.entity.SkullCandleBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockSource;
import net.minecraft.world.item.Item;
import net.minecraft.core.dispenser.OptionalDispenseItemBehavior;

public class SkullCandleDispenseBehavior extends OptionalDispenseItemBehavior
{
    private static Item candle;
    
    public SkullCandleDispenseBehavior(final Item candleItem) {
        SkullCandleDispenseBehavior.candle = candleItem;
    }
    
    protected ItemStack m_7498_(final BlockSource source, final ItemStack stack) {
        final ServerLevel level = source.m_7727_();
        if (!level.m_5776_()) {
            final BlockPos blockpos = source.m_7961_().m_142300_((Direction)source.m_6414_().m_61143_((Property)DispenserBlock.f_52659_));
            this.m_123573_(tryAddCandle(level, blockpos) || tryCreateSkullCandle(level, blockpos));
            if (this.m_123570_()) {
                stack.m_41774_(1);
            }
        }
        return stack;
    }
    
    private static boolean tryAddCandle(final ServerLevel level, final BlockPos pos) {
        final BlockEntity 7702_ = level.m_7702_(pos);
        if (7702_ instanceof final SkullCandleBlockEntity sc) {
            if (SkullCandleDispenseBehavior.candle == AbstractSkullCandleBlock.candleColorToCandle(AbstractSkullCandleBlock.CandleColors.colorFromInt(sc.candleColor).m_7912_()).m_5456_() && sc.candleAmount < 4) {
                final SkullCandleBlockEntity skullCandleBlockEntity = sc;
                ++skullCandleBlockEntity.candleAmount;
                level.m_5594_((Player)null, pos, SoundEvents.f_144101_, SoundSource.BLOCKS, 1.0f, 1.0f);
                level.m_5518_().m_142202_(pos);
                level.m_151523_((BlockEntity)new SkullCandleBlockEntity(pos, level.m_8055_(pos), sc.candleColor, sc.candleAmount));
                return true;
            }
        }
        return false;
    }
    
    private static boolean tryCreateSkullCandle(final ServerLevel level, final BlockPos pos) {
        final BlockState blockstate = level.m_8055_(pos);
        final Block 60734_ = blockstate.m_60734_();
        if (60734_ instanceof final AbstractSkullBlock skull) {
            final SkullBlock.Types type = (SkullBlock.Types)skull.m_48754_();
            final boolean wall = blockstate.m_60734_() instanceof WallSkullBlock;
            switch (type) {
                case SKELETON: {
                    if (wall) {
                        makeWallSkull((Level)level, pos, (Block)TFBlocks.SKELETON_WALL_SKULL_CANDLE.get());
                        break;
                    }
                    makeFloorSkull((Level)level, pos, (Block)TFBlocks.SKELETON_SKULL_CANDLE.get());
                    break;
                }
                case WITHER_SKELETON: {
                    if (wall) {
                        makeWallSkull((Level)level, pos, (Block)TFBlocks.WITHER_SKELE_WALL_SKULL_CANDLE.get());
                        break;
                    }
                    makeFloorSkull((Level)level, pos, (Block)TFBlocks.WITHER_SKELE_SKULL_CANDLE.get());
                    break;
                }
                case PLAYER: {
                    if (wall) {
                        makeWallSkull((Level)level, pos, (Block)TFBlocks.PLAYER_WALL_SKULL_CANDLE.get());
                        break;
                    }
                    makeFloorSkull((Level)level, pos, (Block)TFBlocks.PLAYER_SKULL_CANDLE.get());
                    break;
                }
                case ZOMBIE: {
                    if (wall) {
                        makeWallSkull((Level)level, pos, (Block)TFBlocks.ZOMBIE_WALL_SKULL_CANDLE.get());
                        break;
                    }
                    makeFloorSkull((Level)level, pos, (Block)TFBlocks.ZOMBIE_SKULL_CANDLE.get());
                    break;
                }
                case CREEPER: {
                    if (wall) {
                        makeWallSkull((Level)level, pos, (Block)TFBlocks.CREEPER_WALL_SKULL_CANDLE.get());
                        break;
                    }
                    makeFloorSkull((Level)level, pos, (Block)TFBlocks.CREEPER_SKULL_CANDLE.get());
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    
    private static void makeFloorSkull(final Level level, final BlockPos pos, final Block newBlock) {
        GameProfile profile = null;
        final BlockEntity 7702_ = level.m_7702_(pos);
        if (7702_ instanceof final SkullBlockEntity skull) {
            profile = skull.m_59779_();
        }
        level.m_46597_(pos, (BlockState)((BlockState)newBlock.m_49966_().m_61124_((Property)AbstractSkullCandleBlock.LIGHTING, (Comparable)AbstractLightableBlock.Lighting.NONE)).m_61124_((Property)SkullCandleBlock.ROTATION, (Comparable)level.m_8055_(pos).m_61143_((Property)SkullBlock.f_56314_)));
        level.m_151523_((BlockEntity)new SkullCandleBlockEntity(pos, (BlockState)((BlockState)newBlock.m_49966_().m_61124_((Property)AbstractSkullCandleBlock.LIGHTING, (Comparable)AbstractLightableBlock.Lighting.NONE)).m_61124_((Property)SkullCandleBlock.ROTATION, (Comparable)level.m_8055_(pos).m_61143_((Property)SkullBlock.f_56314_)), AbstractSkullCandleBlock.candleToCandleColor(SkullCandleDispenseBehavior.candle).getValue(), 1));
        final BlockEntity 7702_2 = level.m_7702_(pos);
        if (7702_2 instanceof final SkullCandleBlockEntity sc) {
            sc.m_59769_(profile);
        }
    }
    
    private static void makeWallSkull(final Level level, final BlockPos pos, final Block newBlock) {
        GameProfile profile = null;
        final BlockEntity 7702_ = level.m_7702_(pos);
        if (7702_ instanceof final SkullBlockEntity skull) {
            profile = skull.m_59779_();
        }
        level.m_46597_(pos, (BlockState)((BlockState)newBlock.m_49966_().m_61124_((Property)AbstractSkullCandleBlock.LIGHTING, (Comparable)AbstractLightableBlock.Lighting.NONE)).m_61124_((Property)WallSkullCandleBlock.FACING, (Comparable)level.m_8055_(pos).m_61143_((Property)WallSkullBlock.f_58097_)));
        level.m_151523_((BlockEntity)new SkullCandleBlockEntity(pos, (BlockState)((BlockState)newBlock.m_49966_().m_61124_((Property)AbstractSkullCandleBlock.LIGHTING, (Comparable)AbstractLightableBlock.Lighting.NONE)).m_61124_((Property)WallSkullCandleBlock.FACING, (Comparable)level.m_8055_(pos).m_61143_((Property)WallSkullBlock.f_58097_)), AbstractSkullCandleBlock.candleToCandleColor(SkullCandleDispenseBehavior.candle).getValue(), 1));
        final BlockEntity 7702_2 = level.m_7702_(pos);
        if (7702_2 instanceof final SkullCandleBlockEntity sc) {
            sc.m_59769_(profile);
        }
    }
}
