// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.dispenser;

import net.minecraft.world.item.Items;
import twilightforest.entity.projectile.IceBomb;
import net.minecraft.core.dispenser.AbstractProjectileDispenseBehavior;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundSource;
import twilightforest.TFSounds;
import twilightforest.entity.projectile.TwilightWandBolt;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import twilightforest.block.AbstractSkullCandleBlock;
import twilightforest.block.TFBlocks;
import twilightforest.block.TrophyBlock;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.core.BlockSource;
import net.minecraft.core.dispenser.OptionalDispenseItemBehavior;
import net.minecraft.core.dispenser.DispenseItemBehavior;
import net.minecraft.world.level.block.DispenserBlock;
import twilightforest.entity.projectile.MoonwormShot;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.Position;
import net.minecraft.world.level.Level;
import twilightforest.item.TFItems;
import net.minecraft.world.level.ItemLike;

public class TFDispenserBehaviors
{
    public static void init() {
        DispenserBlock.m_52672_((ItemLike)TFItems.MOONWORM_QUEEN.get(), (DispenseItemBehavior)new MoonwormDispenseBehavior() {
            @Override
            protected Projectile getProjectileEntity(final Level worldIn, final Position position, final ItemStack stackIn) {
                return (Projectile)new MoonwormShot(worldIn, position.m_7096_(), position.m_7098_(), position.m_7094_());
            }
        });
        final DispenseItemBehavior idispenseitembehavior = (DispenseItemBehavior)new OptionalDispenseItemBehavior() {
            protected ItemStack m_7498_(final BlockSource source, final ItemStack stack) {
                this.m_123573_(ArmorItem.m_40398_(source, stack));
                return stack;
            }
        };
        DispenserBlock.m_52672_((ItemLike)((TrophyBlock)TFBlocks.NAGA_TROPHY.get()).m_5456_(), idispenseitembehavior);
        DispenserBlock.m_52672_((ItemLike)((TrophyBlock)TFBlocks.LICH_TROPHY.get()).m_5456_(), idispenseitembehavior);
        DispenserBlock.m_52672_((ItemLike)((TrophyBlock)TFBlocks.MINOSHROOM_TROPHY.get()).m_5456_(), idispenseitembehavior);
        DispenserBlock.m_52672_((ItemLike)((TrophyBlock)TFBlocks.HYDRA_TROPHY.get()).m_5456_(), idispenseitembehavior);
        DispenserBlock.m_52672_((ItemLike)((TrophyBlock)TFBlocks.KNIGHT_PHANTOM_TROPHY.get()).m_5456_(), idispenseitembehavior);
        DispenserBlock.m_52672_((ItemLike)((TrophyBlock)TFBlocks.UR_GHAST_TROPHY.get()).m_5456_(), idispenseitembehavior);
        DispenserBlock.m_52672_((ItemLike)((TrophyBlock)TFBlocks.ALPHA_YETI_TROPHY.get()).m_5456_(), idispenseitembehavior);
        DispenserBlock.m_52672_((ItemLike)((TrophyBlock)TFBlocks.SNOW_QUEEN_TROPHY.get()).m_5456_(), idispenseitembehavior);
        DispenserBlock.m_52672_((ItemLike)((TrophyBlock)TFBlocks.QUEST_RAM_TROPHY.get()).m_5456_(), idispenseitembehavior);
        DispenserBlock.m_52672_((ItemLike)((AbstractSkullCandleBlock)TFBlocks.CREEPER_SKULL_CANDLE.get()).m_5456_(), idispenseitembehavior);
        DispenserBlock.m_52672_((ItemLike)((AbstractSkullCandleBlock)TFBlocks.PLAYER_SKULL_CANDLE.get()).m_5456_(), idispenseitembehavior);
        DispenserBlock.m_52672_((ItemLike)((AbstractSkullCandleBlock)TFBlocks.SKELETON_SKULL_CANDLE.get()).m_5456_(), idispenseitembehavior);
        DispenserBlock.m_52672_((ItemLike)((AbstractSkullCandleBlock)TFBlocks.WITHER_SKELE_SKULL_CANDLE.get()).m_5456_(), idispenseitembehavior);
        DispenserBlock.m_52672_((ItemLike)((AbstractSkullCandleBlock)TFBlocks.ZOMBIE_SKULL_CANDLE.get()).m_5456_(), idispenseitembehavior);
        DispenserBlock.m_52672_((ItemLike)((Block)TFBlocks.CICADA.get()).m_5456_(), idispenseitembehavior);
        DispenserBlock.m_52672_((ItemLike)((Block)TFBlocks.FIREFLY.get()).m_5456_(), idispenseitembehavior);
        DispenserBlock.m_52672_((ItemLike)((Block)TFBlocks.MOONWORM.get()).m_5456_(), idispenseitembehavior);
        final DispenseItemBehavior pushmobsbehavior = (DispenseItemBehavior)new FeatherFanDispenseBehavior();
        DispenserBlock.m_52672_((ItemLike)((Item)TFItems.PEACOCK_FEATHER_FAN.get()).m_5456_(), pushmobsbehavior);
        final DispenseItemBehavior crumblebehavior = (DispenseItemBehavior)new CrumbleDispenseBehavior();
        DispenserBlock.m_52672_((ItemLike)((Item)TFItems.CRUMBLE_HORN.get()).m_5456_(), crumblebehavior);
        final DispenseItemBehavior transformbehavior = (DispenseItemBehavior)new TransformationDispenseBehavior();
        DispenserBlock.m_52672_((ItemLike)((Item)TFItems.TRANSFORMATION_POWDER.get()).m_5456_(), transformbehavior);
        DispenserBlock.m_52672_((ItemLike)TFItems.TWILIGHT_SCEPTER.get(), (DispenseItemBehavior)new MoonwormDispenseBehavior() {
            @Override
            protected Projectile getProjectileEntity(final Level worldIn, final Position position, final ItemStack stackIn) {
                return (Projectile)new TwilightWandBolt(worldIn, position.m_7096_(), position.m_7098_(), position.m_7094_());
            }
            
            @Override
            protected void m_6823_(final BlockSource source) {
                final BlockPos pos = source.m_7961_();
                source.m_7727_().m_5594_((Player)null, pos, TFSounds.SCEPTER_PEARL, SoundSource.BLOCKS, 1.0f, 1.0f);
            }
        });
        DispenserBlock.m_52672_((ItemLike)TFItems.ICE_BOMB.get(), (DispenseItemBehavior)new AbstractProjectileDispenseBehavior() {
            protected Projectile m_6895_(final Level level, final Position pos, final ItemStack stack) {
                return (Projectile)new IceBomb(level, pos);
            }
        });
        DispenserBlock.m_52672_((ItemLike)Items.f_42409_, (DispenseItemBehavior)new IgniteLightableDispenseBehavior());
        DispenserBlock.m_52672_((ItemLike)Items.f_42613_, (DispenseItemBehavior)new IgniteLightableDispenseBehavior());
    }
}
