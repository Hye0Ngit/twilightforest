// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.item.EnumAction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockRotatedPillar;
import twilightforest.block.TFBlocks;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.init.SoundEvents;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.EnumActionResult;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import javax.annotation.Nonnull;
import net.minecraft.util.EnumHand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;

public class ItemTFLampOfCinders extends ItemTF
{
    private static final int FIRING_TIME = 12;
    
    ItemTFLampOfCinders(final EnumRarity rarity) {
        super(rarity);
        this.func_77637_a((CreativeTabs)TFItems.creativeTab);
        this.field_77777_bU = 1;
        this.func_77656_e(1024);
    }
    
    @Nonnull
    public ActionResult<ItemStack> func_77659_a(final World world, final EntityPlayer player, @Nonnull final EnumHand hand) {
        player.func_184598_c(hand);
        return (ActionResult<ItemStack>)ActionResult.newResult(EnumActionResult.SUCCESS, (Object)player.func_184586_b(hand));
    }
    
    @Nonnull
    public EnumActionResult func_180614_a(final EntityPlayer player, final World world, final BlockPos pos, final EnumHand hand, final EnumFacing side, final float hitX, final float hitY, final float hitZ) {
        if (this.burnBlock(world, pos)) {
            if (player instanceof EntityPlayerMP) {
                CriteriaTriggers.field_193137_x.func_193173_a((EntityPlayerMP)player, pos, player.func_184586_b(hand));
            }
            player.func_184185_a(SoundEvents.field_187557_bK, 0.5f, 1.5f);
            for (int i = 0; i < 10; ++i) {
                final float dx = pos.func_177958_n() + 0.5f + (ItemTFLampOfCinders.field_77697_d.nextFloat() - ItemTFLampOfCinders.field_77697_d.nextFloat()) * 0.75f;
                final float dy = pos.func_177956_o() + 0.5f + (ItemTFLampOfCinders.field_77697_d.nextFloat() - ItemTFLampOfCinders.field_77697_d.nextFloat()) * 0.75f;
                final float dz = pos.func_177952_p() + 0.5f + (ItemTFLampOfCinders.field_77697_d.nextFloat() - ItemTFLampOfCinders.field_77697_d.nextFloat()) * 0.75f;
                world.func_175688_a(EnumParticleTypes.SMOKE_NORMAL, (double)dx, (double)dy, (double)dz, 0.0, 0.0, 0.0, new int[0]);
                world.func_175688_a(EnumParticleTypes.FLAME, (double)dx, (double)dy, (double)dz, 0.0, 0.0, 0.0, new int[0]);
            }
            return EnumActionResult.SUCCESS;
        }
        return EnumActionResult.PASS;
    }
    
    private boolean burnBlock(final World world, final BlockPos pos) {
        final IBlockState state = world.func_180495_p(pos);
        if (state.func_177230_c() == TFBlocks.thorns) {
            world.func_175656_a(pos, TFBlocks.burnt_thorns.func_176223_P().func_177226_a((IProperty)BlockRotatedPillar.field_176298_M, state.func_177229_b((IProperty)BlockRotatedPillar.field_176298_M)));
            return true;
        }
        return false;
    }
    
    public void func_77615_a(final ItemStack stack, final World world, final EntityLivingBase living, final int useRemaining) {
        final int useTime = this.func_77626_a(stack) - useRemaining;
        if (useTime > 12 && stack.func_77952_i() + 1 < this.getMaxDamage(stack)) {
            this.doBurnEffect(world, living);
        }
    }
    
    private void doBurnEffect(final World world, final EntityLivingBase living) {
        final BlockPos pos = new BlockPos(MathHelper.func_76128_c(living.field_70142_S), MathHelper.func_76128_c(living.field_70137_T + living.func_70047_e()), MathHelper.func_76128_c(living.field_70136_U));
        final int range = 4;
        if (!world.field_72995_K) {
            world.func_184148_a((EntityPlayer)null, living.field_70165_t, living.field_70163_u, living.field_70161_v, SoundEvents.field_187557_bK, living.func_184176_by(), 1.5f, 0.8f);
            for (int dx = -range; dx <= range; ++dx) {
                for (int dy = -range; dy <= range; ++dy) {
                    for (int dz = -range; dz <= range; ++dz) {
                        this.burnBlock(world, pos.func_177982_a(dx, dy, dz));
                    }
                }
            }
        }
        if (living instanceof EntityPlayer) {
            for (int i = 0; i < 6; ++i) {
                final BlockPos rPos = pos.func_177982_a(ItemTFLampOfCinders.field_77697_d.nextInt(range) - ItemTFLampOfCinders.field_77697_d.nextInt(range), ItemTFLampOfCinders.field_77697_d.nextInt(2), ItemTFLampOfCinders.field_77697_d.nextInt(range) - ItemTFLampOfCinders.field_77697_d.nextInt(range));
                world.func_180498_a((EntityPlayer)living, 2004, rPos, 0);
            }
        }
    }
    
    public EnumAction func_77661_b(final ItemStack stack) {
        return EnumAction.BOW;
    }
    
    public int func_77626_a(final ItemStack stack) {
        return 72000;
    }
}
