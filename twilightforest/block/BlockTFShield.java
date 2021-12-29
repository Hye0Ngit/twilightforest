// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.util.Vec3;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.block.BlockPistonBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.world.World;
import java.util.Random;
import net.minecraft.item.ItemStack;
import java.util.List;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.material.Material;
import net.minecraft.util.Icon;
import net.minecraft.block.Block;

public class BlockTFShield extends Block
{
    public static Icon sprSide;
    private Icon sprInside;
    private Icon sprOutside;
    
    public BlockTFShield(final int id) {
        super(id, Material.field_76246_e);
        this.func_71894_b(2000.0f);
        this.func_71875_q();
        this.func_71884_a(Block.field_71977_i);
        this.func_71849_a((CreativeTabs)TFItems.creativeTab);
    }
    
    public Icon func_71858_a(final int side, final int meta) {
        if (side == meta) {
            return this.sprInside;
        }
        return this.sprOutside;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_94332_a(final IconRegister par1IconRegister) {
        this.sprInside = par1IconRegister.func_94245_a("twilightforest:shield_inside");
        this.sprOutside = par1IconRegister.func_94245_a("twilightforest:shield_outside");
    }
    
    public void func_71879_a(final int par1, final CreativeTabs par2CreativeTabs, final List par3List) {
        par3List.add(new ItemStack(par1, 1, 0));
    }
    
    public int func_71856_s_() {
        return 0;
    }
    
    public boolean func_71926_d() {
        return true;
    }
    
    public boolean func_71886_c() {
        return true;
    }
    
    public int func_71899_b(final int meta) {
        return 0;
    }
    
    public int func_71925_a(final Random par1Random) {
        return 0;
    }
    
    public void func_71860_a(final World par1World, final int par2, final int par3, final int par4, final EntityLiving par5EntityLiving, final ItemStack par6ItemStack) {
        final int l = BlockPistonBase.func_72116_b(par1World, par2, par3, par4, par5EntityLiving);
        par1World.func_72921_c(par2, par3, par4, l, 2);
    }
    
    public float func_71908_a(final EntityPlayer player, final World world, final int x, final int y, final int z) {
        final MovingObjectPosition mop = this.getPlayerPointVec(world, player, 6.0);
        final int facing = (mop != null) ? mop.field_72310_e : -1;
        final int meta = world.func_72805_g(x, y, z);
        if (facing == meta) {
            return player.getCurrentPlayerStrVsBlock(Block.field_71981_t, false, 0) / 1.5f / 100.0f;
        }
        return super.func_71908_a(player, world, x, y, z);
    }
    
    private MovingObjectPosition getPlayerPointVec(final World worldObj, final EntityPlayer player, final double range) {
        final Vec3 position = worldObj.func_82732_R().func_72345_a(player.field_70165_t, player.field_70163_u + player.func_70047_e(), player.field_70161_v);
        final Vec3 look = player.func_70676_i(1.0f);
        final Vec3 dest = position.func_72441_c(look.field_72450_a * range, look.field_72448_b * range, look.field_72449_c * range);
        return worldObj.func_72933_a(position, dest);
    }
}
