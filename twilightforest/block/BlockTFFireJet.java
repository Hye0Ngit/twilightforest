// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import java.util.List;
import twilightforest.tileentity.TileEntityTFFlameJet;
import twilightforest.tileentity.TileEntityTFPoppingJet;
import twilightforest.tileentity.TileEntityTFSmoker;
import java.util.Random;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import twilightforest.item.TFItems;

public class BlockTFFireJet extends aqw
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
    private mr iconJet;
    private mr iconSide;
    private mr iconSmokerInactive;
    private mr iconSmokerActive;
    private mr iconJetInactive;
    private mr iconJetActive;
    
    protected BlockTFFireJet(final int par1) {
        super(par1, ajz.e);
        this.c(1.5f);
        this.b(10.0f);
        this.a(aqw.h);
        this.a((wv)TFItems.creativeTab);
        this.b(true);
    }
    
    public int a(final int meta) {
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
    
    public mr a(final int side, final int meta) {
        if (meta == 1) {
            if (side >= 2) {
                return this.iconSmokerInactive;
            }
            if (side == 1) {
                return TFBlocks.towerDevice.a(side, 10);
            }
            return TFBlocks.towerWood.a(side, 1);
        }
        else if (meta == 2) {
            if (side >= 2) {
                return this.iconSmokerActive;
            }
            if (side == 1) {
                return TFBlocks.towerDevice.a(side, 11);
            }
            return TFBlocks.towerWood.a(side, 1);
        }
        else if (meta == 11) {
            if (side >= 2) {
                return this.iconJetInactive;
            }
            if (side == 1) {
                return TFBlocks.towerDevice.a(side, 10);
            }
            return TFBlocks.towerWood.a(side, 1);
        }
        else if (meta == 12 || meta == 13) {
            if (side >= 2) {
                return this.iconJetActive;
            }
            if (side == 1) {
                return TFBlocks.towerDevice.a(side, 11);
            }
            return TFBlocks.towerWood.a(side, 1);
        }
        else {
            if (side == 1) {
                return this.iconJet;
            }
            return this.iconSide;
        }
    }
    
    @SideOnly(Side.CLIENT)
    public void a(final ms par1IconRegister) {
        this.iconSide = par1IconRegister.a("TwilightForest:firejet_side");
        this.iconJet = par1IconRegister.a("TwilightForest:firejet_top");
        this.iconSmokerInactive = par1IconRegister.a("TwilightForest:towerdev_smoker_off");
        this.iconSmokerActive = par1IconRegister.a("TwilightForest:towerdev_smoker_on");
        this.iconJetInactive = par1IconRegister.a("TwilightForest:towerdev_firejet_off");
        this.iconJetActive = par1IconRegister.a("TwilightForest:towerdev_firejet_on");
    }
    
    @SideOnly(Side.CLIENT)
    public int c(final ace par1IBlockAccess, final int x, final int y, final int z) {
        final int meta = par1IBlockAccess.h(x, y, z);
        if (meta == 1 || meta == 2 || meta == 11 || meta == 12 || meta == 13) {
            return super.c(par1IBlockAccess, x, y, z);
        }
        int red = 0;
        int grn = 0;
        int blu = 0;
        for (int var8 = -1; var8 <= 1; ++var8) {
            for (int var9 = -1; var9 <= 1; ++var9) {
                final int biomeColor = par1IBlockAccess.a(x + var9, z + var8).k();
                red += (biomeColor & 0xFF0000) >> 16;
                grn += (biomeColor & 0xFF00) >> 8;
                blu += (biomeColor & 0xFF);
            }
        }
        return (red / 9 & 0xFF) << 16 | (grn / 9 & 0xFF) << 8 | (blu / 9 & 0xFF);
    }
    
    public int getLightValue(final ace world, final int x, final int y, final int z) {
        if (world.a(x, y, z) != this.cF) {
            return 0;
        }
        final int meta = world.h(x, y, z);
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
    
    public void a(final abv world, final int x, final int y, final int z, final Random random) {
        if (!world.I && world.h(x, y, z) == 8) {
            final t lavaPos = this.findLavaAround(world, x, y - 1, z);
            if (this.isLava(world, lavaPos.a, lavaPos.b, lavaPos.c)) {
                world.f(lavaPos.a, lavaPos.b, lavaPos.c, 0, 0, 2);
                world.f(x, y, z, this.cF, 9, 0);
            }
        }
    }
    
    public void a(final abv par1World, final int x, final int y, final int z, final int myBlockID) {
        final int meta = par1World.h(x, y, z);
        if (!par1World.I) {
            if (meta == 1 && par1World.C(x, y, z)) {
                par1World.f(x, y, z, this.cF, 2, 3);
                par1World.a(x + 0.5, y + 0.5, z + 0.5, "random.click", 0.3f, 0.6f);
            }
            if (meta == 2 && !par1World.C(x, y, z)) {
                par1World.f(x, y, z, this.cF, 1, 3);
                par1World.a(x + 0.5, y + 0.5, z + 0.5, "random.click", 0.3f, 0.6f);
            }
            if (meta == 11 && par1World.C(x, y, z)) {
                par1World.f(x, y, z, this.cF, 12, 3);
                par1World.a(x + 0.5, y + 0.5, z + 0.5, "random.click", 0.3f, 0.6f);
            }
        }
    }
    
    private t findLavaAround(final abv world, final int x, final int y, final int z) {
        if (this.isLava(world, x, y, z)) {
            return new t(x, y, z);
        }
        int rx = x + world.s.nextInt(3) - 1;
        int rz = z + world.s.nextInt(3) - 1;
        if (this.isLava(world, rx, y, rz)) {
            return new t(rx, y, rz);
        }
        rx = x + world.s.nextInt(3) - 1;
        rz = z + world.s.nextInt(3) - 1;
        if (this.isLava(world, rx, y, rz)) {
            return new t(rx, y, rz);
        }
        rx = x + world.s.nextInt(3) - 1;
        rz = z + world.s.nextInt(3) - 1;
        if (this.isLava(world, rx, y, rz)) {
            return new t(rx, y, rz);
        }
        return new t(x, y, z);
    }
    
    private boolean isLava(final abv world, final int x, final int y, final int z) {
        return world.g(x, y, z) == ajz.i && world.h(x, y, z) == 0;
    }
    
    public boolean hasTileEntity(final int metadata) {
        return metadata == 0 || metadata == 9 || metadata == 10 || metadata == 2 || metadata == 12 || metadata == 13;
    }
    
    public asm createTileEntity(final abv world, final int metadata) {
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
    
    public void a(final int par1, final wv par2CreativeTabs, final List par3List) {
        par3List.add(new yd(par1, 1, 0));
        par3List.add(new yd(par1, 1, 8));
        par3List.add(new yd(par1, 1, 1));
        par3List.add(new yd(par1, 1, 11));
    }
}
