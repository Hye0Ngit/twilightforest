// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.block.BlockState;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraft.block.FlowerBlock;
import net.minecraft.util.math.BlockPos;
import twilightforest.util.WorldUtil;
import java.util.Iterator;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.UseAction;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.AxisAlignedBB;
import twilightforest.TFSounds;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.ActionResultType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import javax.annotation.Nonnull;
import net.minecraft.util.Hand;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraft.item.Item;

public class PeacockFanItem extends Item
{
    boolean launched;
    
    PeacockFanItem(final Item.Properties props) {
        super(props);
        this.launched = false;
    }
    
    @Nonnull
    public ActionResult<ItemStack> func_77659_a(final World world, final PlayerEntity player, @Nonnull final Hand hand) {
        if (!world.field_72995_K && !player.func_184811_cZ().func_185141_a((Item)this)) {
            if (!player.func_233570_aj_() && !player.func_203007_ba() && !player.func_184812_l_() && !player.func_184613_cA()) {
                player.func_195064_c(new EffectInstance(Effects.field_76430_j, 200, 0, false, false));
                player.func_184586_b(hand).func_222118_a(1, (LivingEntity)player, user -> user.func_213334_d(hand));
            }
            else {
                final int fanned = this.doFan(world, player);
                if (fanned > 0) {
                    player.func_184586_b(hand).func_222118_a(fanned, (LivingEntity)player, user -> user.func_213334_d(hand));
                }
            }
            player.func_184598_c(hand);
            return (ActionResult<ItemStack>)new ActionResult(ActionResultType.PASS, (Object)player.func_184586_b(hand));
        }
        if (player.func_184613_cA()) {
            player.func_213317_d(new Vector3d(player.func_213322_ci().func_82615_a() * 3.0, 1.5, player.func_213322_ci().func_82616_c() * 3.0));
            player.func_184811_cZ().func_185145_a((Item)this, 60);
        }
        if (!player.func_233570_aj_() && !player.func_70644_a(Effects.field_76430_j) && !player.func_203007_ba() && !this.launched) {
            player.func_213317_d(new Vector3d(player.func_213322_ci().func_82615_a() * 1.0499999523162842, 1.5, player.func_213322_ci().func_82616_c() * 1.0499999523162842));
            this.launched = true;
        }
        else {
            final AxisAlignedBB fanBox = this.getEffectAABB(player);
            final Vector3d lookVec = player.func_70040_Z();
            for (int i = 0; i < 30; ++i) {
                world.func_195594_a((IParticleData)ParticleTypes.field_197613_f, fanBox.field_72340_a + world.field_73012_v.nextFloat() * (fanBox.field_72336_d - fanBox.field_72340_a), fanBox.field_72338_b + world.field_73012_v.nextFloat() * (fanBox.field_72337_e - fanBox.field_72338_b), fanBox.field_72339_c + world.field_73012_v.nextFloat() * (fanBox.field_72334_f - fanBox.field_72339_c), lookVec.field_72450_a, lookVec.field_72448_b, lookVec.field_72449_c);
            }
        }
        player.func_184185_a(TFSounds.FAN_WOOSH, 1.0f + PeacockFanItem.field_77697_d.nextFloat(), PeacockFanItem.field_77697_d.nextFloat() * 0.7f + 0.3f);
        return (ActionResult<ItemStack>)new ActionResult(ActionResultType.SUCCESS, (Object)player.func_184586_b(hand));
    }
    
    public void func_77663_a(final ItemStack stack, final World worldIn, final Entity entityIn, final int itemSlot, final boolean isSelected) {
        if (entityIn instanceof PlayerEntity && ((PlayerEntity)entityIn).func_184613_cA() && isSelected) {
            entityIn.field_70143_R = 0.0f;
        }
        if (entityIn instanceof PlayerEntity && ((PlayerEntity)entityIn).func_70644_a(Effects.field_76430_j)) {
            entityIn.field_70143_R = 0.0f;
        }
        if (entityIn instanceof PlayerEntity && entityIn.func_233570_aj_() && this.launched) {
            ((PlayerEntity)entityIn).func_195063_d(Effects.field_76430_j);
            this.launched = false;
        }
        super.func_77663_a(stack, worldIn, entityIn, itemSlot, isSelected);
    }
    
    @Nonnull
    public UseAction func_77661_b(final ItemStack stack) {
        return UseAction.BLOCK;
    }
    
    public int func_77626_a(final ItemStack stack) {
        return 20;
    }
    
    private int doFan(final World world, final PlayerEntity player) {
        final AxisAlignedBB fanBox = this.getEffectAABB(player);
        this.fanBlocksInAABB(world, fanBox, player);
        this.fanEntitiesInAABB(world, player, fanBox);
        return 1;
    }
    
    private void fanEntitiesInAABB(final World world, final PlayerEntity player, final AxisAlignedBB fanBox) {
        final Vector3d moveVec = player.func_70040_Z().func_186678_a(2.0);
        final Item fan = player.func_184607_cu().func_77973_b();
        for (final Entity entity : world.func_217357_a((Class)Entity.class, fanBox)) {
            if (entity.func_70104_M() || entity instanceof ItemEntity || entity instanceof ProjectileEntity) {
                entity.func_213293_j(moveVec.field_72450_a, moveVec.field_72448_b, moveVec.field_72449_c);
            }
            if (entity instanceof PlayerEntity && !entity.func_225608_bj_()) {
                entity.func_213293_j(moveVec.field_72450_a, moveVec.field_72448_b, moveVec.field_72449_c);
                player.func_184811_cZ().func_185145_a(fan, 40);
            }
        }
    }
    
    private AxisAlignedBB getEffectAABB(final PlayerEntity player) {
        final double range = 3.0;
        final double radius = 2.0;
        final Vector3d srcVec = new Vector3d(player.func_226277_ct_(), player.func_226278_cu_() + player.func_70047_e(), player.func_226281_cx_());
        final Vector3d lookVec = player.func_70040_Z().func_186678_a(range);
        final Vector3d destVec = srcVec.func_72441_c(lookVec.field_72450_a, lookVec.field_72448_b, lookVec.field_72449_c);
        return new AxisAlignedBB(destVec.field_72450_a - radius, destVec.field_72448_b - radius, destVec.field_72449_c - radius, destVec.field_72450_a + radius, destVec.field_72448_b + radius, destVec.field_72449_c + radius);
    }
    
    private int fanBlocksInAABB(final World world, final AxisAlignedBB box, final PlayerEntity player) {
        int fan = 0;
        for (final BlockPos pos : WorldUtil.getAllInBB(box)) {
            fan += this.fanBlock(world, pos, player);
        }
        return fan;
    }
    
    private int fanBlock(final World world, final BlockPos pos, final PlayerEntity player) {
        final int cost = 0;
        final BlockState state = world.func_180495_p(pos);
        if (state.func_177230_c() instanceof FlowerBlock && PeacockFanItem.field_77697_d.nextInt(3) == 0 && !MinecraftForge.EVENT_BUS.post((Event)new BlockEvent.BreakEvent(world, pos, state, player))) {
            world.func_175655_b(pos, true);
        }
        return cost;
    }
}
