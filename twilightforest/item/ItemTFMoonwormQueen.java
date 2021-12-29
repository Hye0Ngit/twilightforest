// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.item.EnumAction;
import net.minecraft.init.SoundEvents;
import twilightforest.entity.EntityTFMoonwormShot;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.block.SoundType;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.SoundCategory;
import net.minecraft.entity.Entity;
import twilightforest.block.TFBlocks;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.entity.EntityLivingBase;
import javax.annotation.Nullable;
import net.minecraft.world.World;
import javax.annotation.Nonnull;
import net.minecraft.item.ItemStack;
import net.minecraft.item.IItemPropertyGetter;
import twilightforest.TwilightForestMod;
import net.minecraft.item.EnumRarity;

public class ItemTFMoonwormQueen extends ItemTF
{
    private static final int FIRING_TIME = 12;
    
    protected ItemTFMoonwormQueen(final EnumRarity rarity) {
        super(rarity);
        this.field_77777_bU = 1;
        this.func_77656_e(256);
        this.func_185043_a(TwilightForestMod.prefix("alt"), (IItemPropertyGetter)new IItemPropertyGetter() {
            @SideOnly(Side.CLIENT)
            public float func_185085_a(@Nonnull final ItemStack stack, @Nullable final World worldIn, @Nullable final EntityLivingBase entityIn) {
                if (entityIn != null && entityIn.func_184607_cu() == stack) {
                    final int useTime = stack.func_77988_m() - entityIn.func_184605_cv();
                    if (useTime >= 12 && (useTime >>> 1) % 2 == 0) {
                        return 1.0f;
                    }
                }
                return 0.0f;
            }
        });
    }
    
    public ActionResult<ItemStack> func_77659_a(final World world, final EntityPlayer player, final EnumHand hand) {
        final ItemStack stack = player.func_184586_b(hand);
        if (stack.func_77952_i() >= stack.func_77958_k() - 1) {
            return (ActionResult<ItemStack>)ActionResult.newResult(EnumActionResult.FAIL, (Object)stack);
        }
        player.func_184598_c(hand);
        return (ActionResult<ItemStack>)ActionResult.newResult(EnumActionResult.SUCCESS, (Object)player.func_184586_b(hand));
    }
    
    public EnumActionResult func_180614_a(final EntityPlayer player, final World worldIn, BlockPos pos, final EnumHand hand, final EnumFacing facing, final float hitX, final float hitY, final float hitZ) {
        final IBlockState iblockstate = worldIn.func_180495_p(pos);
        final Block block = iblockstate.func_177230_c();
        if (!block.func_176200_f((IBlockAccess)worldIn, pos)) {
            pos = pos.func_177972_a(facing);
        }
        final ItemStack itemstack = player.func_184586_b(hand);
        if (itemstack.func_77952_i() < itemstack.func_77958_k() && player.func_175151_a(pos, facing, itemstack) && worldIn.func_190527_a(TFBlocks.moonworm, pos, false, facing, (Entity)null)) {
            final int i = this.func_77647_b(itemstack.func_77960_j());
            final IBlockState iblockstate2 = TFBlocks.moonworm.getStateForPlacement(worldIn, pos, facing, hitX, hitY, hitZ, i, (EntityLivingBase)player, hand);
            if (this.placeMoonwormAt(itemstack, player, worldIn, pos, facing, hitX, hitY, hitZ, iblockstate2)) {
                final SoundType soundtype = worldIn.func_180495_p(pos).func_177230_c().getSoundType(worldIn.func_180495_p(pos), worldIn, pos, (Entity)player);
                worldIn.func_184133_a(player, pos, soundtype.func_185841_e(), SoundCategory.BLOCKS, (soundtype.func_185843_a() + 1.0f) / 2.0f, soundtype.func_185847_b() * 0.8f);
                itemstack.func_77972_a(1, (EntityLivingBase)player);
                player.func_184602_cy();
            }
            return EnumActionResult.SUCCESS;
        }
        return EnumActionResult.FAIL;
    }
    
    private boolean placeMoonwormAt(final ItemStack stack, final EntityPlayer player, final World world, final BlockPos pos, final EnumFacing side, final float hitX, final float hitY, final float hitZ, final IBlockState state) {
        if (!world.func_180501_a(pos, state, 11)) {
            return false;
        }
        final IBlockState real = world.func_180495_p(pos);
        if (real.func_177230_c() == TFBlocks.moonworm) {
            TFBlocks.moonworm.func_180633_a(world, pos, state, (EntityLivingBase)player, stack);
            if (player instanceof EntityPlayerMP) {
                CriteriaTriggers.field_193137_x.func_193173_a((EntityPlayerMP)player, pos, stack);
            }
        }
        return true;
    }
    
    public void func_77615_a(final ItemStack stack, final World world, final EntityLivingBase living, final int useRemaining) {
        final int useTime = this.func_77626_a(stack) - useRemaining;
        if (!world.field_72995_K && useTime > 12 && stack.func_77952_i() + 1 < stack.func_77958_k()) {
            final boolean fired = world.func_72838_d((Entity)new EntityTFMoonwormShot(world, living));
            if (fired) {
                stack.func_77972_a(2, living);
                world.func_184148_a((EntityPlayer)null, living.field_70165_t, living.field_70163_u, living.field_70161_v, SoundEvents.field_187878_fo, (living instanceof EntityPlayer) ? SoundCategory.PLAYERS : SoundCategory.NEUTRAL, 1.0f, 1.0f);
            }
        }
    }
    
    @Nonnull
    public EnumAction func_77661_b(final ItemStack stack) {
        return EnumAction.BOW;
    }
    
    public int func_77626_a(final ItemStack stack) {
        return 72000;
    }
}
