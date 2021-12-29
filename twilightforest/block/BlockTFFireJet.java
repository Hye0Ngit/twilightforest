// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.item.ItemStack;
import java.util.List;
import net.minecraft.item.Item;
import twilightforest.tileentity.TileEntityTFFlameJet;
import twilightforest.tileentity.TileEntityTFPoppingJet;
import twilightforest.tileentity.TileEntityTFSmoker;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.init.Blocks;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.material.Material;
import net.minecraft.util.IIcon;
import net.minecraft.block.Block;

public class BlockTFFireJet extends Block
{
    public static final int META_SMOKER = 0;
    public static final int META_ENCASED_SMOKER_OFF = 1;
    public static final int META_ENCASED_SMOKER_ON = 2;
    public static final int META_JET_IDLE = 8;
    public static final int META_JET_POPPING = 9;
    public static final int META_JET_FLAME = 10;
    public static final int META_ENCASED_JET_IDLE = 11;
    public static final int META_ENCASED_JET_POPPING = 12;
    public static final int META_ENCASED_JET_FLAME = 13;
    private IIcon iconJet;
    private IIcon iconSide;
    private IIcon iconSmokerInactive;
    private IIcon iconSmokerActive;
    private IIcon iconJetInactive;
    private IIcon iconJetActive;
    
    protected BlockTFFireJet() {
        super(Material.field_151576_e);
        this.func_149711_c(1.5f);
        this.func_149672_a(Block.field_149766_f);
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
        this.func_149675_a(true);
    }
    
    public int func_149692_a(final int meta) {
        switch (meta) {
            default: {
                return meta;
            }
            case 2: {
                return 1;
            }
            case 12:
            case 13: {
                return 11;
            }
            case 9:
            case 10: {
                return 8;
            }
        }
    }
    
    public IIcon func_149691_a(final int side, final int meta) {
        if (meta == 1) {
            if (side >= 2) {
                return this.iconSmokerInactive;
            }
            if (side == 1) {
                return TFBlocks.towerDevice.func_149691_a(side, 10);
            }
            return TFBlocks.towerWood.func_149691_a(side, 1);
        }
        else if (meta == 2) {
            if (side >= 2) {
                return this.iconSmokerActive;
            }
            if (side == 1) {
                return TFBlocks.towerDevice.func_149691_a(side, 11);
            }
            return TFBlocks.towerWood.func_149691_a(side, 1);
        }
        else if (meta == 11) {
            if (side >= 2) {
                return this.iconJetInactive;
            }
            if (side == 1) {
                return TFBlocks.towerDevice.func_149691_a(side, 10);
            }
            return TFBlocks.towerWood.func_149691_a(side, 1);
        }
        else if (meta == 12 || meta == 13) {
            if (side >= 2) {
                return this.iconJetActive;
            }
            if (side == 1) {
                return TFBlocks.towerDevice.func_149691_a(side, 11);
            }
            return TFBlocks.towerWood.func_149691_a(side, 1);
        }
        else {
            if (side == 1) {
                return this.iconJet;
            }
            return this.iconSide;
        }
    }
    
    @SideOnly(Side.CLIENT)
    public void func_149651_a(final IIconRegister par1IconRegister) {
        this.iconSide = par1IconRegister.func_94245_a("TwilightForest:firejet_side");
        this.iconJet = par1IconRegister.func_94245_a("TwilightForest:firejet_top");
        this.iconSmokerInactive = par1IconRegister.func_94245_a("TwilightForest:towerdev_smoker_off");
        this.iconSmokerActive = par1IconRegister.func_94245_a("TwilightForest:towerdev_smoker_on");
        this.iconJetInactive = par1IconRegister.func_94245_a("TwilightForest:towerdev_firejet_off");
        this.iconJetActive = par1IconRegister.func_94245_a("TwilightForest:towerdev_firejet_on");
    }
    
    @SideOnly(Side.CLIENT)
    public int func_149720_d(final IBlockAccess par1IBlockAccess, final int x, final int y, final int z) {
        final int meta = par1IBlockAccess.func_72805_g(x, y, z);
        if (meta == 1 || meta == 2 || meta == 11 || meta == 12 || meta == 13) {
            return super.func_149720_d(par1IBlockAccess, x, y, z);
        }
        int red = 0;
        int grn = 0;
        int blu = 0;
        for (int var8 = -1; var8 <= 1; ++var8) {
            for (int var9 = -1; var9 <= 1; ++var9) {
                final int biomeColor = par1IBlockAccess.func_72807_a(x + var9, z + var8).func_150558_b(x + var9, y, z + var8);
                red += (biomeColor & 0xFF0000) >> 16;
                grn += (biomeColor & 0xFF00) >> 8;
                blu += (biomeColor & 0xFF);
            }
        }
        return (red / 9 & 0xFF) << 16 | (grn / 9 & 0xFF) << 8 | (blu / 9 & 0xFF);
    }
    
    public int getLightValue(final IBlockAccess world, final int x, final int y, final int z) {
        if (world.func_147439_a(x, y, z) != this) {
            return 0;
        }
        final int meta = world.func_72805_g(x, y, z);
        switch (meta) {
            default: {
                return 0;
            }
            case 10:
            case 13: {
                return 15;
            }
        }
    }
    
    public void func_149674_a(final World world, final int x, final int y, final int z, final Random random) {
        if (!world.field_72995_K && world.func_72805_g(x, y, z) == 8) {
            final ChunkCoordinates lavaPos = this.findLavaAround(world, x, y - 1, z);
            if (this.isLava(world, lavaPos.field_71574_a, lavaPos.field_71572_b, lavaPos.field_71573_c)) {
                world.func_147465_d(lavaPos.field_71574_a, lavaPos.field_71572_b, lavaPos.field_71573_c, Blocks.field_150350_a, 0, 2);
                world.func_147465_d(x, y, z, (Block)this, 9, 0);
            }
        }
    }
    
    public void func_149695_a(final World par1World, final int x, final int y, final int z, final Block myBlockID) {
        final int meta = par1World.func_72805_g(x, y, z);
        if (!par1World.field_72995_K) {
            if (meta == 1 && par1World.func_72864_z(x, y, z)) {
                par1World.func_147465_d(x, y, z, (Block)this, 2, 3);
                par1World.func_72908_a(x + 0.5, y + 0.5, z + 0.5, "random.click", 0.3f, 0.6f);
            }
            if (meta == 2 && !par1World.func_72864_z(x, y, z)) {
                par1World.func_147465_d(x, y, z, (Block)this, 1, 3);
                par1World.func_72908_a(x + 0.5, y + 0.5, z + 0.5, "random.click", 0.3f, 0.6f);
            }
            if (meta == 11 && par1World.func_72864_z(x, y, z)) {
                par1World.func_147465_d(x, y, z, (Block)this, 12, 3);
                par1World.func_72908_a(x + 0.5, y + 0.5, z + 0.5, "random.click", 0.3f, 0.6f);
            }
        }
    }
    
    private ChunkCoordinates findLavaAround(final World world, final int x, final int y, final int z) {
        if (this.isLava(world, x, y, z)) {
            return new ChunkCoordinates(x, y, z);
        }
        int rx = x + world.field_73012_v.nextInt(3) - 1;
        int rz = z + world.field_73012_v.nextInt(3) - 1;
        if (this.isLava(world, rx, y, rz)) {
            return new ChunkCoordinates(rx, y, rz);
        }
        rx = x + world.field_73012_v.nextInt(3) - 1;
        rz = z + world.field_73012_v.nextInt(3) - 1;
        if (this.isLava(world, rx, y, rz)) {
            return new ChunkCoordinates(rx, y, rz);
        }
        rx = x + world.field_73012_v.nextInt(3) - 1;
        rz = z + world.field_73012_v.nextInt(3) - 1;
        if (this.isLava(world, rx, y, rz)) {
            return new ChunkCoordinates(rx, y, rz);
        }
        return new ChunkCoordinates(x, y, z);
    }
    
    private boolean isLava(final World world, final int x, final int y, final int z) {
        return world.func_147439_a(x, y, z).func_149688_o() == Material.field_151587_i && world.func_72805_g(x, y, z) == 0;
    }
    
    public boolean hasTileEntity(final int metadata) {
        return metadata == 0 || metadata == 9 || metadata == 10 || metadata == 2 || metadata == 12 || metadata == 13;
    }
    
    public TileEntity createTileEntity(final World world, final int metadata) {
        if (metadata == 0 || metadata == 2) {
            return new TileEntityTFSmoker();
        }
        if (metadata == 9) {
            return new TileEntityTFPoppingJet(10);
        }
        if (metadata == 10) {
            return new TileEntityTFFlameJet(8);
        }
        if (metadata == 12) {
            return new TileEntityTFPoppingJet(13);
        }
        if (metadata == 13) {
            return new TileEntityTFFlameJet(11);
        }
        return null;
    }
    
    public void func_149666_a(final Item par1, final CreativeTabs par2CreativeTabs, final List par3List) {
        par3List.add(new ItemStack(par1, 1, 0));
        par3List.add(new ItemStack(par1, 1, 8));
        par3List.add(new ItemStack(par1, 1, 1));
        par3List.add(new ItemStack(par1, 1, 11));
    }
}
