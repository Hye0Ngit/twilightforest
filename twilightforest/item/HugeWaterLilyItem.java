// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.fluid.FluidState;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraft.util.Direction;
import net.minecraft.world.IWorld;
import net.minecraftforge.common.util.BlockSnapshot;
import net.minecraft.block.material.Material;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraft.item.Item;
import net.minecraft.block.Block;
import net.minecraft.item.LilyPadItem;

public class HugeWaterLilyItem extends LilyPadItem
{
    public HugeWaterLilyItem(final Block block, final Item.Properties props) {
        super(block, props);
    }
    
    public ActionResult<ItemStack> func_77659_a(final World world, final PlayerEntity player, final Hand hand) {
        final ItemStack itemstack = player.func_184586_b(hand);
        final RayTraceResult raytraceresult = (RayTraceResult)func_219968_a(world, player, RayTraceContext.FluidMode.SOURCE_ONLY);
        if (raytraceresult.func_216346_c() == RayTraceResult.Type.MISS) {
            return (ActionResult<ItemStack>)ActionResult.func_226250_c_((Object)itemstack);
        }
        if (raytraceresult.func_216346_c() == RayTraceResult.Type.BLOCK) {
            final BlockRayTraceResult blockraytraceresult = (BlockRayTraceResult)raytraceresult;
            final BlockPos blockpos = blockraytraceresult.func_216350_a();
            final Direction direction = blockraytraceresult.func_216354_b();
            if (!world.func_175660_a(player, blockpos) || !player.func_175151_a(blockpos.func_177972_a(direction), direction, itemstack)) {
                return (ActionResult<ItemStack>)ActionResult.func_226251_d_((Object)itemstack);
            }
            final BlockPos blockpos2 = blockpos.func_177984_a();
            final BlockState blockstate = world.func_180495_p(blockpos);
            final Material material = blockstate.func_185904_a();
            final FluidState ifluidstate = world.func_204610_c(blockpos);
            if ((ifluidstate.func_206886_c() == Fluids.field_204546_a || material == Material.field_151588_w) && world.func_175623_d(blockpos2)) {
                final BlockSnapshot blocksnapshot = BlockSnapshot.create(world.func_234923_W_(), (IWorld)world, blockpos2);
                world.func_180501_a(blockpos2, this.func_179223_d().func_176223_P(), 11);
                if (ForgeEventFactory.onBlockPlace((Entity)player, blocksnapshot, Direction.UP)) {
                    blocksnapshot.restore(true, false);
                    return (ActionResult<ItemStack>)ActionResult.func_226251_d_((Object)itemstack);
                }
                if (player instanceof ServerPlayerEntity) {
                    CriteriaTriggers.field_193137_x.func_193173_a((ServerPlayerEntity)player, blockpos2, itemstack);
                }
                if (!player.field_71075_bZ.field_75098_d) {
                    itemstack.func_190918_g(1);
                }
                player.func_71029_a(Stats.field_75929_E.func_199076_b((Object)this));
                world.func_184133_a(player, blockpos, SoundEvents.field_187916_gp, SoundCategory.BLOCKS, 1.0f, 1.0f);
                return (ActionResult<ItemStack>)ActionResult.func_226248_a_((Object)itemstack);
            }
        }
        return (ActionResult<ItemStack>)ActionResult.func_226251_d_((Object)itemstack);
    }
}
