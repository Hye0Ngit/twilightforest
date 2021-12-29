// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.util.Vec3;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.init.Blocks;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.block.BlockPistonBase;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import java.util.Random;
import net.minecraft.item.ItemStack;
import java.util.List;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.material.Material;
import net.minecraft.util.IIcon;
import net.minecraft.block.Block;

public class BlockTFShield extends Block
{
    public static IIcon sprSide;
    private IIcon sprInside;
    private IIcon sprOutside;
    
    public BlockTFShield() {
        super(Material.field_151576_e);
        this.func_149722_s();
        this.func_149752_b(6000000.0f);
        this.func_149672_a(Block.field_149777_j);
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
    }
    
    public IIcon func_149691_a(final int side, final int meta) {
        if (side == meta) {
            return this.sprInside;
        }
        return this.sprOutside;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_149651_a(final IIconRegister par1IconRegister) {
        this.sprInside = par1IconRegister.func_94245_a("TwilightForest:shield_inside");
        this.sprOutside = par1IconRegister.func_94245_a("TwilightForest:shield_outside");
    }
    
    public void func_149666_a(final Item par1, final CreativeTabs par2CreativeTabs, final List par3List) {
        par3List.add(new ItemStack(par1, 1, 0));
    }
    
    public int func_149701_w() {
        return 0;
    }
    
    public boolean func_149662_c() {
        return true;
    }
    
    public boolean func_149686_d() {
        return true;
    }
    
    public int func_149692_a(final int meta) {
        return 0;
    }
    
    public int func_149745_a(final Random par1Random) {
        return 0;
    }
    
    public void func_149689_a(final World par1World, final int par2, final int par3, final int par4, final EntityLivingBase par5EntityLiving, final ItemStack par6ItemStack) {
        final int l = BlockPistonBase.func_150071_a(par1World, par2, par3, par4, par5EntityLiving);
        par1World.func_72921_c(par2, par3, par4, l, 2);
    }
    
    public float func_149737_a(final EntityPlayer player, final World world, final int x, final int y, final int z) {
        final MovingObjectPosition mop = this.getPlayerPointVec(world, player, 6.0);
        final int facing = (mop != null) ? mop.field_72310_e : -1;
        final int meta = world.func_72805_g(x, y, z);
        if (facing == meta) {
            return player.getBreakSpeed(Blocks.field_150348_b, false, 0, x, y, z) / 1.5f / 100.0f;
        }
        return super.func_149737_a(player, world, x, y, z);
    }
    
    private MovingObjectPosition getPlayerPointVec(final World worldObj, final EntityPlayer player, final double range) {
        final Vec3 position = Vec3.func_72443_a(player.field_70165_t, player.field_70163_u + player.func_70047_e(), player.field_70161_v);
        final Vec3 look = player.func_70676_i(1.0f);
        final Vec3 dest = position.func_72441_c(look.field_72450_a * range, look.field_72448_b * range, look.field_72449_c * range);
        return worldObj.func_72933_a(position, dest);
    }
}
