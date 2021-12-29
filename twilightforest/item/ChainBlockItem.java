// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.block.BlockState;
import net.minecraftforge.common.ToolType;
import net.minecraft.item.UseAction;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.server.ServerWorld;
import javax.annotation.Nullable;
import java.util.UUID;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.EntityType;
import twilightforest.entity.ChainBlockEntity;
import twilightforest.entity.TFEntities;
import twilightforest.TFSounds;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import java.util.Set;
import net.minecraft.item.IItemTier;
import com.google.common.collect.Sets;
import net.minecraft.block.Blocks;
import net.minecraft.block.Block;
import twilightforest.enums.TwilightItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ToolItem;

public class ChainBlockItem extends ToolItem
{
    private static final String THROWN_UUID_KEY = "chainEntity";
    
    protected ChainBlockItem(final Item.Properties props) {
        super(6.0f, -3.0f, (IItemTier)TwilightItemTier.TOOL_KNIGHTLY, (Set)Sets.newHashSet((Object[])new Block[] { Blocks.field_150348_b }), props);
    }
    
    public void func_77663_a(final ItemStack stack, final World world, final Entity holder, final int slot, final boolean isSelected) {
        if (!world.field_72995_K && getThrownUuid(stack) != null && getThrownEntity(world, stack) == null) {
            stack.func_77978_p().func_82580_o("chainEntity");
        }
    }
    
    public ActionResult<ItemStack> func_77659_a(final World world, final PlayerEntity player, final Hand hand) {
        final ItemStack stack = player.func_184586_b(hand);
        if (getThrownUuid(stack) != null) {
            return (ActionResult<ItemStack>)new ActionResult(ActionResultType.PASS, (Object)stack);
        }
        player.func_184185_a(TFSounds.BLOCKCHAIN_FIRED, 1.0f, 1.0f / (ChainBlockItem.field_77697_d.nextFloat() * 0.4f + 1.2f));
        if (!world.field_72995_K) {
            final ChainBlockEntity launchedBlock = new ChainBlockEntity(TFEntities.chain_block, world, (LivingEntity)player, hand);
            world.func_217376_c((Entity)launchedBlock);
            setThrownEntity(stack, launchedBlock);
            stack.func_222118_a(1, (LivingEntity)player, user -> user.func_213334_d(hand));
        }
        player.func_184598_c(hand);
        return (ActionResult<ItemStack>)new ActionResult(ActionResultType.SUCCESS, (Object)stack);
    }
    
    @Nullable
    protected static UUID getThrownUuid(final ItemStack stack) {
        if (stack.func_77942_o() && stack.func_77978_p().func_186855_b("chainEntity")) {
            return stack.func_77978_p().func_186857_a("chainEntity");
        }
        return null;
    }
    
    @Nullable
    private static ChainBlockEntity getThrownEntity(final World world, final ItemStack stack) {
        if (world instanceof ServerWorld) {
            final UUID id = getThrownUuid(stack);
            if (id != null) {
                final Entity e = ((ServerWorld)world).func_217461_a(id);
                if (e instanceof ChainBlockEntity) {
                    return (ChainBlockEntity)e;
                }
            }
        }
        return null;
    }
    
    private static void setThrownEntity(final ItemStack stack, final ChainBlockEntity cube) {
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundNBT());
        }
        stack.func_77978_p().func_186854_a("chainEntity", cube.func_110124_au());
    }
    
    public int func_77626_a(final ItemStack stack) {
        return 72000;
    }
    
    public UseAction func_77661_b(final ItemStack stack) {
        return UseAction.BLOCK;
    }
    
    public boolean canDisableShield(final ItemStack stack, final ItemStack shield, final LivingEntity entity, final LivingEntity attacker) {
        return true;
    }
    
    public int getHarvestLevel(final ItemStack stack, final ToolType tool, @Nullable final PlayerEntity player, @Nullable final BlockState blockState) {
        if (tool == ToolType.PICKAXE) {
            return 2;
        }
        return -1;
    }
}
