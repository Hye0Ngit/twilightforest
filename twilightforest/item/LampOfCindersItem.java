// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.item.UseAction;
import java.util.Iterator;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.state.Property;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import twilightforest.block.TFBlocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import twilightforest.TFSounds;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import javax.annotation.Nonnull;
import net.minecraft.util.Hand;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraft.item.Item;

public class LampOfCindersItem extends Item
{
    private static final int FIRING_TIME = 12;
    
    LampOfCindersItem(final Item.Properties props) {
        super(props);
    }
    
    @Nonnull
    public ActionResult<ItemStack> func_77659_a(final World world, final PlayerEntity player, @Nonnull final Hand hand) {
        player.func_184598_c(hand);
        return (ActionResult<ItemStack>)new ActionResult(ActionResultType.SUCCESS, (Object)player.func_184586_b(hand));
    }
    
    @Nonnull
    public ActionResultType func_195939_a(final ItemUseContext context) {
        final World world = context.func_195991_k();
        final BlockPos pos = context.func_195995_a();
        final PlayerEntity player = context.func_195999_j();
        if (this.burnBlock(world, pos)) {
            if (player instanceof ServerPlayerEntity) {
                CriteriaTriggers.field_193137_x.func_193173_a((ServerPlayerEntity)player, pos, player.func_184586_b(context.func_221531_n()));
            }
            player.func_184185_a(TFSounds.LAMP_BURN, 0.5f, 1.5f);
            for (int i = 0; i < 10; ++i) {
                final float dx = pos.func_177958_n() + 0.5f + (LampOfCindersItem.field_77697_d.nextFloat() - LampOfCindersItem.field_77697_d.nextFloat()) * 0.75f;
                final float dy = pos.func_177956_o() + 0.5f + (LampOfCindersItem.field_77697_d.nextFloat() - LampOfCindersItem.field_77697_d.nextFloat()) * 0.75f;
                final float dz = pos.func_177952_p() + 0.5f + (LampOfCindersItem.field_77697_d.nextFloat() - LampOfCindersItem.field_77697_d.nextFloat()) * 0.75f;
                world.func_195594_a((IParticleData)ParticleTypes.field_197601_L, (double)dx, (double)dy, (double)dz, 0.0, 0.0, 0.0);
                world.func_195594_a((IParticleData)ParticleTypes.field_197631_x, (double)dx, (double)dy, (double)dz, 0.0, 0.0, 0.0);
            }
            return ActionResultType.SUCCESS;
        }
        return ActionResultType.PASS;
    }
    
    private boolean burnBlock(final World world, final BlockPos pos) {
        final BlockState state = world.func_180495_p(pos);
        if (state.func_177230_c() == TFBlocks.brown_thorns.get() || state.func_177230_c() == TFBlocks.green_thorns.get()) {
            world.func_175656_a(pos, (BlockState)((Block)TFBlocks.burnt_thorns.get()).func_176223_P().func_206870_a((Property)RotatedPillarBlock.field_176298_M, state.func_177229_b((Property)RotatedPillarBlock.field_176298_M)));
            return true;
        }
        return false;
    }
    
    public void func_77615_a(final ItemStack stack, final World world, final LivingEntity living, final int useRemaining) {
        final int useTime = this.func_77626_a(stack) - useRemaining;
        if (useTime > 12 && stack.func_77952_i() + 1 < this.getMaxDamage(stack)) {
            this.doBurnEffect(world, living);
        }
    }
    
    private void doBurnEffect(final World world, final LivingEntity living) {
        final BlockPos pos = new BlockPos(MathHelper.func_76128_c(living.field_70142_S), MathHelper.func_76128_c(living.field_70137_T + living.func_70047_e()), MathHelper.func_76128_c(living.field_70136_U));
        final int range = 4;
        if (!world.field_72995_K) {
            world.func_184148_a((PlayerEntity)null, living.func_226277_ct_(), living.func_226278_cu_(), living.func_226281_cx_(), TFSounds.LAMP_BURN, living.func_184176_by(), 1.5f, 0.8f);
            for (int dx = -range; dx <= range; ++dx) {
                for (int dy = -range; dy <= range; ++dy) {
                    for (int dz = -range; dz <= range; ++dz) {
                        this.burnBlock(world, pos.func_177982_a(dx, dy, dz));
                    }
                }
            }
        }
        if (living instanceof PlayerEntity) {
            for (int i = 0; i < 6; ++i) {
                final BlockPos rPos = pos.func_177982_a(LampOfCindersItem.field_77697_d.nextInt(range) - LampOfCindersItem.field_77697_d.nextInt(range), LampOfCindersItem.field_77697_d.nextInt(2), LampOfCindersItem.field_77697_d.nextInt(range) - LampOfCindersItem.field_77697_d.nextInt(range));
                world.func_217378_a((PlayerEntity)living, 2004, rPos, 0);
            }
            for (final LivingEntity targets : world.func_217357_a((Class)LivingEntity.class, new AxisAlignedBB(new BlockPos(living.func_226277_ct_(), living.func_226280_cw_(), living.func_226281_cx_())).func_186662_g(4.0))) {
                if (!(targets instanceof PlayerEntity)) {
                    targets.func_70015_d(5);
                }
            }
        }
    }
    
    public UseAction func_77661_b(final ItemStack stack) {
        return UseAction.BOW;
    }
    
    public int func_77626_a(final ItemStack stack) {
        return 72000;
    }
}
