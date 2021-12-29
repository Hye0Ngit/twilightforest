// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import java.util.Iterator;
import java.util.List;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumAction;
import net.minecraft.util.Vec3;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.Potion;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;

public class ItemTFPeacockFan extends ItemTF
{
    protected ItemTFPeacockFan() {
        this.func_77637_a((CreativeTabs)TFItems.creativeTab);
        this.field_77777_bU = 1;
        this.func_77656_e(1024);
    }
    
    public ItemStack func_77659_a(final ItemStack par1ItemStack, final World world, final EntityPlayer player) {
        if (!world.field_72995_K) {
            if (!player.field_70122_E) {
                player.func_70690_d(new PotionEffect(Potion.field_76430_j.field_76415_H, 45, 0));
            }
            else {
                int fanned = 0;
                fanned = this.doFan(world, player);
                if (fanned > 0) {
                    par1ItemStack.func_77972_a(fanned, (EntityLivingBase)player);
                }
            }
        }
        else {
            if (!player.field_70122_E && !player.func_82165_m(Potion.field_76430_j.field_76415_H)) {
                player.field_70159_w *= 3.0;
                player.field_70181_x = 1.5;
                player.field_70179_y *= 3.0;
                player.field_70143_R = 0.0f;
            }
            else {
                final AxisAlignedBB fanBox = this.getEffectAABB(world, player);
                final Vec3 lookVec = player.func_70040_Z();
                for (int i = 0; i < 30; ++i) {
                    world.func_72869_a("cloud", fanBox.field_72340_a + world.field_73012_v.nextFloat() * (fanBox.field_72336_d - fanBox.field_72340_a), fanBox.field_72338_b + world.field_73012_v.nextFloat() * (fanBox.field_72337_e - fanBox.field_72338_b), fanBox.field_72339_c + world.field_73012_v.nextFloat() * (fanBox.field_72334_f - fanBox.field_72339_c), lookVec.field_72450_a, lookVec.field_72448_b, lookVec.field_72449_c);
                }
            }
            world.func_72980_b(player.field_70165_t + 0.5, player.field_70163_u + 0.5, player.field_70161_v + 0.5, "random.breath", 1.0f + ItemTFPeacockFan.field_77697_d.nextFloat(), ItemTFPeacockFan.field_77697_d.nextFloat() * 0.7f + 0.3f, false);
        }
        player.func_71008_a(par1ItemStack, this.func_77626_a(par1ItemStack));
        return par1ItemStack;
    }
    
    public EnumAction func_77661_b(final ItemStack par1ItemStack) {
        return EnumAction.block;
    }
    
    public int func_77626_a(final ItemStack par1ItemStack) {
        return 20;
    }
    
    public boolean func_77662_d() {
        return true;
    }
    
    private int doFan(final World world, final EntityPlayer player) {
        final AxisAlignedBB fanBox = this.getEffectAABB(world, player);
        this.fanBlocksInAABB(world, player, fanBox);
        this.fanEntitiesInAABB(world, player, fanBox);
        return 1;
    }
    
    private void fanEntitiesInAABB(final World world, final EntityPlayer player, final AxisAlignedBB fanBox) {
        final Vec3 moveVec = player.func_70040_Z();
        final List<Entity> inBox = world.func_72872_a((Class)Entity.class, fanBox);
        final float force = 2.0f;
        for (final Entity entity : inBox) {
            if (entity.func_70104_M() || entity instanceof EntityItem) {
                entity.field_70159_w = moveVec.field_72450_a * force;
                entity.field_70181_x = moveVec.field_72448_b * force;
                entity.field_70179_y = moveVec.field_72449_c * force;
            }
        }
    }
    
    private AxisAlignedBB getEffectAABB(final World world, final EntityPlayer player) {
        final double range = 3.0;
        final double radius = 2.0;
        final Vec3 srcVec = Vec3.func_72443_a(player.field_70165_t, player.field_70163_u + player.func_70047_e(), player.field_70161_v);
        final Vec3 lookVec = player.func_70040_Z();
        final Vec3 destVec = srcVec.func_72441_c(lookVec.field_72450_a * range, lookVec.field_72448_b * range, lookVec.field_72449_c * range);
        final AxisAlignedBB crumbleBox = AxisAlignedBB.func_72330_a(destVec.field_72450_a - radius, destVec.field_72448_b - radius, destVec.field_72449_c - radius, destVec.field_72450_a + radius, destVec.field_72448_b + radius, destVec.field_72449_c + radius);
        return crumbleBox;
    }
    
    private int fanBlocksInAABB(final World world, final EntityPlayer player, final AxisAlignedBB par1AxisAlignedBB) {
        final int minX = MathHelper.func_76128_c(par1AxisAlignedBB.field_72340_a);
        final int minY = MathHelper.func_76128_c(par1AxisAlignedBB.field_72338_b);
        final int minZ = MathHelper.func_76128_c(par1AxisAlignedBB.field_72339_c);
        final int maxX = MathHelper.func_76128_c(par1AxisAlignedBB.field_72336_d);
        final int maxY = MathHelper.func_76128_c(par1AxisAlignedBB.field_72337_e);
        final int maxZ = MathHelper.func_76128_c(par1AxisAlignedBB.field_72334_f);
        int fan = 0;
        for (int dx = minX; dx <= maxX; ++dx) {
            for (int dy = minY; dy <= maxY; ++dy) {
                for (int dz = minZ; dz <= maxZ; ++dz) {
                    fan += this.fanBlock(world, player, dx, dy, dz);
                }
            }
        }
        return fan;
    }
    
    private int fanBlock(final World world, final EntityPlayer player, final int dx, final int dy, final int dz) {
        final int cost = 0;
        final Block currentID = world.func_147439_a(dx, dy, dz);
        if (currentID != Blocks.field_150350_a) {
            final int currentMeta = world.func_72805_g(dx, dy, dz);
            if (currentID instanceof BlockFlower && currentID.canHarvestBlock(player, currentMeta) && ItemTFPeacockFan.field_77697_d.nextInt(3) == 0) {
                currentID.func_149636_a(world, player, dx, dy, dz, currentMeta);
                world.func_147465_d(dx, dy, dz, Blocks.field_150350_a, 0, 3);
                world.func_72926_e(2001, dx, dy, dz, Block.func_149682_b(currentID) + (currentMeta << 12));
            }
        }
        return cost;
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void func_94581_a(final IIconRegister par1IconRegister) {
        this.field_77791_bV = par1IconRegister.func_94245_a("TwilightForest:" + this.func_77658_a().substring(5));
    }
}
