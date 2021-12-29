// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.item.ItemStack;
import java.util.List;
import net.minecraft.item.Item;
import net.minecraft.client.renderer.texture.IIconRegister;
import java.util.Random;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.Entity;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import twilightforest.TwilightForestMod;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.material.Material;
import net.minecraft.util.IIcon;
import net.minecraft.block.BlockRotatedPillar;

public class BlockTFThorns extends BlockRotatedPillar
{
    private static final float THORN_DAMAGE = 4.0f;
    private String[] names;
    private IIcon[] sideIcons;
    private IIcon[] topIcons;
    
    protected BlockTFThorns() {
        super(Material.field_151575_d);
        this.setNames(new String[] { "brown", "green" });
        this.func_149711_c(50.0f);
        this.func_149752_b(2000.0f);
        this.func_149672_a(BlockTFThorns.field_149766_f);
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
    }
    
    public int func_149645_b() {
        return TwilightForestMod.proxy.getThornsBlockRenderID();
    }
    
    public boolean func_149686_d() {
        return false;
    }
    
    public boolean func_149662_c() {
        return false;
    }
    
    public AxisAlignedBB func_149668_a(final World world, final int x, final int y, final int z) {
        final int meta = world.func_72805_g(x, y, z);
        final int rotation = meta & 0xC;
        final float pixel = 0.0625f;
        switch (rotation) {
            default: {
                return AxisAlignedBB.func_72330_a((double)(x + pixel * 3.0f), (double)y, (double)(z + pixel * 3.0f), (double)(x + 1.0f - pixel * 3.0f), (double)(y + 1.0f), (double)(z + 1.0f - pixel * 3.0f));
            }
            case 4: {
                return AxisAlignedBB.func_72330_a((double)x, (double)(y + pixel * 3.0f), (double)(z + pixel * 3.0f), (double)(x + 1.0f), (double)(y + 1.0f - pixel * 3.0f), (double)(z + 1.0f - pixel * 3.0f));
            }
            case 8: {
                return AxisAlignedBB.func_72330_a((double)(x + pixel * 3.0f), (double)(y + pixel * 3.0f), (double)z, (double)(x + 1.0f - pixel * 3.0f), (double)(y + 1.0f - pixel * 3.0f), (double)(z + 1.0f));
            }
        }
    }
    
    @SideOnly(Side.CLIENT)
    public AxisAlignedBB func_149633_g(final World world, final int x, final int y, final int z) {
        return this.func_149668_a(world, x, y, z);
    }
    
    public void func_149670_a(final World world, final int x, final int y, final int z, final Entity entity) {
        entity.func_70097_a(DamageSource.field_76367_g, 4.0f);
    }
    
    public boolean removedByPlayer(final World world, final EntityPlayer player, final int x, final int y, final int z) {
        final int meta = world.func_72805_g(x, y, z);
        if (!player.field_71075_bZ.field_75098_d) {
            if (!world.field_72995_K) {
                world.func_147465_d(x, y, z, (Block)this, (meta & 0xC) | 0x1, 2);
                this.doThornBurst(world, x, y, z, meta);
            }
        }
        else {
            world.func_147468_f(x, y, z);
        }
        return true;
    }
    
    public int func_149656_h() {
        return 2;
    }
    
    private void doThornBurst(final World world, final int x, final int y, final int z, final int meta) {
        final int rotation = meta & 0xC;
        switch (rotation) {
            case 0: {
                this.growThorns(world, x, y, z, ForgeDirection.UP);
                this.growThorns(world, x, y, z, ForgeDirection.DOWN);
                break;
            }
            case 4: {
                this.growThorns(world, x, y, z, ForgeDirection.EAST);
                this.growThorns(world, x, y, z, ForgeDirection.WEST);
                break;
            }
            case 8: {
                this.growThorns(world, x, y, z, ForgeDirection.NORTH);
                this.growThorns(world, x, y, z, ForgeDirection.SOUTH);
                break;
            }
        }
        this.growThorns(world, x, y, z, ForgeDirection.VALID_DIRECTIONS[world.field_73012_v.nextInt(ForgeDirection.VALID_DIRECTIONS.length)]);
        this.growThorns(world, x, y, z, ForgeDirection.VALID_DIRECTIONS[world.field_73012_v.nextInt(ForgeDirection.VALID_DIRECTIONS.length)]);
        this.growThorns(world, x, y, z, ForgeDirection.VALID_DIRECTIONS[world.field_73012_v.nextInt(ForgeDirection.VALID_DIRECTIONS.length)]);
    }
    
    private void growThorns(final World world, final int x, final int y, final int z, final ForgeDirection dir) {
        for (int length = 1 + world.field_73012_v.nextInt(3), i = 1; i < length; ++i) {
            final int dx = x + dir.offsetX * i;
            final int dy = y + dir.offsetY * i;
            final int dz = z + dir.offsetZ * i;
            if (!world.func_147437_c(dx, dy, dz)) {
                break;
            }
            world.func_147465_d(dx, dy, dz, (Block)this, getMetaFor(dir) | 0x1, 2);
        }
    }
    
    public static int getMetaFor(final ForgeDirection dir) {
        switch (dir) {
            default: {
                return 0;
            }
            case EAST:
            case WEST: {
                return 4;
            }
            case NORTH:
            case SOUTH: {
                return 8;
            }
        }
    }
    
    public void func_149749_a(final World world, final int x, final int y, final int z, final Block logBlock, final int metadata) {
        final byte range = 4;
        final int exRange = range + 1;
        if (world.func_72904_c(x - exRange, y - exRange, z - exRange, x + exRange, y + exRange, z + exRange)) {
            for (int dx = -range; dx <= range; ++dx) {
                for (int dy = -range; dy <= range; ++dy) {
                    for (int dz = -range; dz <= range; ++dz) {
                        final Block block = world.func_147439_a(x + dx, y + dy, z + dz);
                        if (block.isLeaves((IBlockAccess)world, x + dx, y + dy, z + dz)) {
                            block.beginLeavesDecay(world, x + dx, y + dy, z + dz);
                        }
                    }
                }
            }
        }
    }
    
    public int func_149745_a(final Random p_149745_1_) {
        return 0;
    }
    
    @SideOnly(Side.CLIENT)
    protected IIcon func_150163_b(final int meta) {
        return this.sideIcons[meta & 0x3];
    }
    
    @SideOnly(Side.CLIENT)
    protected IIcon func_150161_d(final int meta) {
        return this.topIcons[meta & 0x3];
    }
    
    @SideOnly(Side.CLIENT)
    public void func_149651_a(final IIconRegister iconRegister) {
        this.sideIcons = new IIcon[this.getNames().length];
        this.topIcons = new IIcon[this.getNames().length];
        for (int i = 0; i < this.getNames().length; ++i) {
            this.sideIcons[i] = iconRegister.func_94245_a("TwilightForest:" + this.getNames()[i] + "_thorns_side");
            this.topIcons[i] = iconRegister.func_94245_a("TwilightForest:" + this.getNames()[i] + "_thorns_top");
        }
    }
    
    public boolean canSustainLeaves(final IBlockAccess world, final int x, final int y, final int z) {
        return true;
    }
    
    public void func_149666_a(final Item par1, final CreativeTabs par2CreativeTabs, final List par3List) {
        for (int i = 0; i < this.getNames().length; ++i) {
            par3List.add(new ItemStack(par1, 1, i));
        }
    }
    
    public String[] getNames() {
        return this.names;
    }
    
    public void setNames(final String[] names) {
        this.names = names;
    }
}
