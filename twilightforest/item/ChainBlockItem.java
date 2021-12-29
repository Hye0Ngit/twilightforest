// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.world.item.Tier;
import net.minecraftforge.common.TierSortingRegistry;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.item.UseAnim;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import javax.annotation.Nullable;
import java.util.UUID;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import twilightforest.entity.ChainBlock;
import twilightforest.entity.TFEntities;
import twilightforest.TFSounds;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.Tag;
import net.minecraft.tags.BlockTags;
import twilightforest.util.TwilightItemTier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.DiggerItem;

public class ChainBlockItem extends DiggerItem
{
    private static final String THROWN_UUID_KEY = "chainEntity";
    
    protected ChainBlockItem(final Item.Properties props) {
        super(6.0f, -3.0f, TwilightItemTier.KNIGHTMETAL, (Tag)BlockTags.f_13061_, props);
    }
    
    public void m_6883_(final ItemStack stack, final Level world, final Entity holder, final int slot, final boolean isSelected) {
        if (!world.f_46443_ && getThrownUuid(stack) != null && getThrownEntity(world, stack) == null) {
            stack.m_41783_().m_128473_("chainEntity");
        }
    }
    
    public InteractionResultHolder<ItemStack> m_7203_(final Level world, final Player player, final InteractionHand hand) {
        final ItemStack stack = player.m_21120_(hand);
        if (getThrownUuid(stack) != null) {
            return (InteractionResultHolder<ItemStack>)new InteractionResultHolder(InteractionResult.PASS, (Object)stack);
        }
        player.m_5496_(TFSounds.BLOCKCHAIN_FIRED, 0.5f, 1.0f / (world.f_46441_.nextFloat() * 0.4f + 1.2f));
        if (!world.f_46443_) {
            final ChainBlock launchedBlock = new ChainBlock(TFEntities.CHAIN_BLOCK, world, (LivingEntity)player, hand, stack);
            world.m_7967_((Entity)launchedBlock);
            setThrownEntity(stack, launchedBlock);
            stack.m_41622_(1, (LivingEntity)player, user -> user.m_21190_(hand));
        }
        player.m_6672_(hand);
        return (InteractionResultHolder<ItemStack>)new InteractionResultHolder(InteractionResult.SUCCESS, (Object)stack);
    }
    
    @Nullable
    protected static UUID getThrownUuid(final ItemStack stack) {
        if (stack.m_41782_() && stack.m_41783_().m_128403_("chainEntity")) {
            return stack.m_41783_().m_128342_("chainEntity");
        }
        return null;
    }
    
    @Nullable
    private static ChainBlock getThrownEntity(final Level world, final ItemStack stack) {
        if (world instanceof ServerLevel) {
            final UUID id = getThrownUuid(stack);
            if (id != null) {
                final Entity e = ((ServerLevel)world).m_8791_(id);
                if (e instanceof final ChainBlock chainBlock) {
                    return chainBlock;
                }
            }
        }
        return null;
    }
    
    private static void setThrownEntity(final ItemStack stack, final ChainBlock cube) {
        if (!stack.m_41782_()) {
            stack.m_41751_(new CompoundTag());
        }
        stack.m_41783_().m_128362_("chainEntity", cube.m_142081_());
    }
    
    public int m_8105_(final ItemStack stack) {
        return 72000;
    }
    
    public UseAnim m_6164_(final ItemStack stack) {
        return UseAnim.BLOCK;
    }
    
    public boolean canDisableShield(final ItemStack stack, final ItemStack shield, final LivingEntity entity, final LivingEntity attacker) {
        return true;
    }
    
    public boolean isCorrectToolForDrops(final ItemStack stack, final BlockState state) {
        if (state.m_60620_((Tag)BlockTags.f_144282_) || state.m_60620_((Tag)BlockTags.f_144281_) || state.m_60620_((Tag)BlockTags.f_144283_) || state.m_60620_((Tag)BlockTags.f_144280_)) {
            return TierSortingRegistry.isCorrectTierForDrops((Tier)Tiers.IRON, state);
        }
        return super.isCorrectToolForDrops(stack, state);
    }
}
