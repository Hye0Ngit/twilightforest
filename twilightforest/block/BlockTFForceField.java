// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraftforge.common.util.ForgeDirection;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import java.util.List;
import net.minecraft.item.Item;
import net.minecraft.world.IBlockAccess;
import net.minecraft.client.renderer.texture.IIconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.material.Material;
import net.minecraft.util.IIcon;
import net.minecraft.block.BlockPane;

public class BlockTFForceField extends BlockPane
{
    public static String[] names;
    public static IIcon[] sides;
    public static IIcon top;
    
    protected BlockTFForceField() {
        super("glass", "glass_pane_top", Material.field_151577_b, false);
        this.func_149715_a(0.13333334f);
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon func_149691_a(final int side, final int meta) {
        return BlockTFForceField.sides[meta % BlockTFForceField.names.length];
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon func_150097_e() {
        return BlockTFForceField.top;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_149651_a(final IIconRegister register) {
        super.func_149651_a(register);
        BlockTFForceField.sides = new IIcon[BlockTFForceField.names.length];
        for (int i = 0; i < BlockTFForceField.names.length; ++i) {
            BlockTFForceField.sides[i] = register.func_94245_a("TwilightForest:forcefield_" + BlockTFForceField.names[i]);
        }
        BlockTFForceField.top = register.func_94245_a("TwilightForest:forcefield_top");
    }
    
    @SideOnly(Side.CLIENT)
    public int func_149677_c(final IBlockAccess world, final int x, final int y, final int z) {
        return 15728880;
    }
    
    public int func_149692_a(final int meta) {
        return meta % BlockTFForceField.names.length;
    }
    
    public void func_149666_a(final Item par1, final CreativeTabs par2CreativeTabs, final List par3List) {
        for (int i = 0; i < BlockTFForceField.names.length; ++i) {
            par3List.add(new ItemStack(par1, 1, i));
        }
    }
    
    @SideOnly(Side.CLIENT)
    public int func_149701_w() {
        return 1;
    }
    
    public void func_149743_a(final World world, final int x, final int y, final int z, final AxisAlignedBB aabb, final List list, final Entity entity) {
        super.func_149743_a(world, x, y, z, aabb, list, entity);
        final boolean north = this.canPaneConnectTo((IBlockAccess)world, x, y, z - 1, ForgeDirection.NORTH);
        final boolean south = this.canPaneConnectTo((IBlockAccess)world, x, y, z + 1, ForgeDirection.SOUTH);
        final boolean east = this.canPaneConnectTo((IBlockAccess)world, x - 1, y, z, ForgeDirection.WEST);
        final boolean west = this.canPaneConnectTo((IBlockAccess)world, x + 1, y, z, ForgeDirection.EAST);
        if (north && south && east && west) {
            this.func_149676_a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        }
        final AxisAlignedBB myAABB = this.func_149668_a(world, x, y, z);
        if (myAABB != null && aabb.func_72326_a(myAABB)) {
            list.add(myAABB);
        }
    }
    
    static {
        BlockTFForceField.names = new String[] { "purple", "pink", "orange", "green", "blue" };
    }
}
