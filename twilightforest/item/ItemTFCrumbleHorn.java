// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.item.EnumAction;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;

public class ItemTFCrumbleHorn extends ItemTF
{
    private static final int CHANCE_HARVEST = 20;
    private static final int CHANCE_CRUMBLE = 5;
    
    protected ItemTFCrumbleHorn(final int par1) {
        super(par1);
        this.func_77637_a((CreativeTabs)TFItems.creativeTab);
        this.field_77777_bU = 1;
        this.func_77656_e(1024);
    }
    
    public ItemStack func_77659_a(final ItemStack par1ItemStack, final World world, final EntityPlayer player) {
        player.func_71008_a(par1ItemStack, this.func_77626_a(par1ItemStack));
        world.func_72956_a((Entity)player, "mob.sheep.say", 1.0f, 0.8f);
        return par1ItemStack;
    }
    
    public void onUsingItemTick(final ItemStack stack, final EntityPlayer player, final int count) {
        if (count > 10 && count % 5 == 0 && !player.field_70170_p.field_72995_K) {
            final int crumbled = this.doCrumble(player.field_70170_p, player);
            if (crumbled > 0) {
                stack.func_77972_a(crumbled, (EntityLiving)player);
            }
            player.field_70170_p.func_72956_a((Entity)player, "mob.sheep.say", 1.0f, 0.8f);
        }
    }
    
    public EnumAction func_77661_b(final ItemStack par1ItemStack) {
        return EnumAction.bow;
    }
    
    public int func_77626_a(final ItemStack par1ItemStack) {
        return 72000;
    }
    
    private int doCrumble(final World world, final EntityPlayer player) {
        final double range = 3.0;
        final double radius = 2.0;
        final Vec3 srcVec = world.func_82732_R().func_72345_a(player.field_70165_t, player.field_70163_u + player.func_70047_e(), player.field_70161_v);
        final Vec3 lookVec = player.func_70040_Z();
        final Vec3 destVec = srcVec.func_72441_c(lookVec.field_72450_a * range, lookVec.field_72448_b * range, lookVec.field_72449_c * range);
        final AxisAlignedBB crumbleBox = AxisAlignedBB.func_72332_a().func_72299_a(destVec.field_72450_a - radius, destVec.field_72448_b - radius, destVec.field_72449_c - radius, destVec.field_72450_a + radius, destVec.field_72448_b + radius, destVec.field_72449_c + radius);
        return this.crumbleBlocksInAABB(world, player, crumbleBox);
    }
    
    private int crumbleBlocksInAABB(final World world, final EntityPlayer player, final AxisAlignedBB par1AxisAlignedBB) {
        final int minX = MathHelper.func_76128_c(par1AxisAlignedBB.field_72340_a);
        final int minY = MathHelper.func_76128_c(par1AxisAlignedBB.field_72338_b);
        final int minZ = MathHelper.func_76128_c(par1AxisAlignedBB.field_72339_c);
        final int maxX = MathHelper.func_76128_c(par1AxisAlignedBB.field_72336_d);
        final int maxY = MathHelper.func_76128_c(par1AxisAlignedBB.field_72337_e);
        final int maxZ = MathHelper.func_76128_c(par1AxisAlignedBB.field_72334_f);
        int crumbled = 0;
        for (int dx = minX; dx <= maxX; ++dx) {
            for (int dy = minY; dy <= maxY; ++dy) {
                for (int dz = minZ; dz <= maxZ; ++dz) {
                    crumbled += this.crumbleBlock(world, player, dx, dy, dz);
                }
            }
        }
        return crumbled;
    }
    
    private int crumbleBlock(final World world, final EntityPlayer player, final int dx, final int dy, final int dz) {
        int cost = 0;
        final int currentID = world.func_72798_a(dx, dy, dz);
        if (currentID != 0) {
            final int currentMeta = world.func_72805_g(dx, dy, dz);
            if (currentID == Block.field_71981_t.field_71990_ca && world.field_73012_v.nextInt(5) == 0) {
                world.func_72832_d(dx, dy, dz, Block.field_71978_w.field_71990_ca, 0, 3);
                world.func_72926_e(2001, dx, dy, dz, currentID + (currentMeta << 12));
                ++cost;
            }
            if (currentID == Block.field_72007_bm.field_71990_ca && currentMeta == 0 && world.field_73012_v.nextInt(5) == 0) {
                world.func_72832_d(dx, dy, dz, Block.field_72007_bm.field_71990_ca, 2, 3);
                world.func_72926_e(2001, dx, dy, dz, currentID + (currentMeta << 12));
                ++cost;
            }
            if (currentID == TFBlocks.mazestone.field_71990_ca && currentMeta == 1 && world.field_73012_v.nextInt(5) == 0) {
                world.func_72832_d(dx, dy, dz, TFBlocks.mazestone.field_71990_ca, 4, 3);
                world.func_72926_e(2001, dx, dy, dz, currentID + (currentMeta << 12));
                ++cost;
            }
            if (currentID == Block.field_71978_w.field_71990_ca && world.field_73012_v.nextInt(5) == 0) {
                world.func_72832_d(dx, dy, dz, Block.field_71940_F.field_71990_ca, 0, 3);
                world.func_72926_e(2001, dx, dy, dz, currentID + (currentMeta << 12));
                ++cost;
            }
            if ((currentID == Block.field_71940_F.field_71990_ca || currentID == Block.field_71979_v.field_71990_ca) && Block.field_71973_m[currentID].canHarvestBlock(player, currentMeta) && world.field_73012_v.nextInt(20) == 0) {
                world.func_72832_d(dx, dy, dz, 0, 0, 3);
                Block.field_71973_m[currentID].func_71893_a(world, player, dx, dy, dz, currentMeta);
                world.func_72926_e(2001, dx, dy, dz, currentID + (currentMeta << 12));
                ++cost;
            }
        }
        return cost;
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void func_94581_a(final IconRegister par1IconRegister) {
        this.field_77791_bV = par1IconRegister.func_94245_a("twilightforest:" + this.func_77658_a().substring(5));
    }
}
