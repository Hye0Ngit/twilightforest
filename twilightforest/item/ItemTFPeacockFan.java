// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.block.state.IBlockState;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.BlockFlower;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import twilightforest.util.WorldUtil;
import java.util.Iterator;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumAction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.EnumActionResult;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.PotionEffect;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import javax.annotation.Nonnull;
import net.minecraft.util.EnumHand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.item.EnumRarity;

public class ItemTFPeacockFan extends ItemTF
{
    ItemTFPeacockFan(final EnumRarity rarity) {
        super(rarity);
        this.field_77777_bU = 1;
        this.func_77656_e(1024);
    }
    
    @Nonnull
    public ActionResult<ItemStack> func_77659_a(final World world, final EntityPlayer player, @Nonnull final EnumHand hand) {
        if (!world.field_72995_K) {
            if (!player.field_70122_E) {
                player.func_70690_d(new PotionEffect(MobEffects.field_76430_j, 45, 0));
            }
            else {
                final int fanned = this.doFan(world, player);
                if (fanned > 0) {
                    player.func_184586_b(hand).func_77972_a(fanned, (EntityLivingBase)player);
                }
            }
        }
        else {
            if (!player.field_70122_E && !player.func_70644_a(MobEffects.field_76430_j)) {
                player.field_70159_w *= 3.0;
                player.field_70181_x = 1.5;
                player.field_70179_y *= 3.0;
                player.field_70143_R = 0.0f;
            }
            else {
                final AxisAlignedBB fanBox = this.getEffectAABB(player);
                final Vec3d lookVec = player.func_70040_Z();
                for (int i = 0; i < 30; ++i) {
                    world.func_175688_a(EnumParticleTypes.CLOUD, fanBox.field_72340_a + world.field_73012_v.nextFloat() * (fanBox.field_72336_d - fanBox.field_72340_a), fanBox.field_72338_b + world.field_73012_v.nextFloat() * (fanBox.field_72337_e - fanBox.field_72338_b), fanBox.field_72339_c + world.field_73012_v.nextFloat() * (fanBox.field_72334_f - fanBox.field_72339_c), lookVec.field_72450_a, lookVec.field_72448_b, lookVec.field_72449_c, new int[0]);
                }
            }
            player.func_184185_a(SoundEvents.field_189109_ed, 1.0f + ItemTFPeacockFan.field_77697_d.nextFloat(), ItemTFPeacockFan.field_77697_d.nextFloat() * 0.7f + 0.3f);
        }
        player.func_184598_c(hand);
        return (ActionResult<ItemStack>)ActionResult.newResult(EnumActionResult.SUCCESS, (Object)player.func_184586_b(hand));
    }
    
    @Nonnull
    public EnumAction func_77661_b(final ItemStack stack) {
        return EnumAction.BLOCK;
    }
    
    public int func_77626_a(final ItemStack stack) {
        return 20;
    }
    
    private int doFan(final World world, final EntityPlayer player) {
        final AxisAlignedBB fanBox = this.getEffectAABB(player);
        this.fanBlocksInAABB(world, player, fanBox);
        this.fanEntitiesInAABB(world, player, fanBox);
        return 1;
    }
    
    private void fanEntitiesInAABB(final World world, final EntityPlayer player, final AxisAlignedBB fanBox) {
        final Vec3d moveVec = player.func_70040_Z().func_186678_a(2.0);
        for (final Entity entity : world.func_72872_a((Class)Entity.class, fanBox)) {
            if (entity.func_70104_M() || entity instanceof EntityItem) {
                entity.field_70159_w = moveVec.field_72450_a;
                entity.field_70181_x = moveVec.field_72448_b;
                entity.field_70179_y = moveVec.field_72449_c;
            }
        }
    }
    
    private AxisAlignedBB getEffectAABB(final EntityPlayer player) {
        final double range = 3.0;
        final double radius = 2.0;
        final Vec3d srcVec = new Vec3d(player.field_70165_t, player.field_70163_u + player.func_70047_e(), player.field_70161_v);
        final Vec3d lookVec = player.func_70040_Z().func_186678_a(range);
        final Vec3d destVec = srcVec.func_72441_c(lookVec.field_72450_a, lookVec.field_72448_b, lookVec.field_72449_c);
        return new AxisAlignedBB(destVec.field_72450_a - radius, destVec.field_72448_b - radius, destVec.field_72449_c - radius, destVec.field_72450_a + radius, destVec.field_72448_b + radius, destVec.field_72449_c + radius);
    }
    
    private int fanBlocksInAABB(final World world, final EntityPlayer player, final AxisAlignedBB box) {
        int fan = 0;
        for (final BlockPos pos : WorldUtil.getAllInBB(box)) {
            fan += this.fanBlock(world, player, pos);
        }
        return fan;
    }
    
    private int fanBlock(final World world, final EntityPlayer player, final BlockPos pos) {
        final int cost = 0;
        final IBlockState state = world.func_180495_p(pos);
        if (state.func_177230_c() != Blocks.field_150350_a && state.func_177230_c() instanceof BlockFlower && state.func_177230_c().canHarvestBlock((IBlockAccess)world, pos, player) && ItemTFPeacockFan.field_77697_d.nextInt(3) == 0) {
            state.func_177230_c().func_180657_a(world, player, pos, state, world.func_175625_s(pos), ItemStack.field_190927_a);
            world.func_175655_b(pos, false);
        }
        return cost;
    }
}
