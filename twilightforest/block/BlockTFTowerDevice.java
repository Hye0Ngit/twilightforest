// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import java.util.List;
import twilightforest.item.TFItems;

public class BlockTFTowerDevice extends amq
{
    private static final int TEX_SHUNT_INACTIVE = 144;
    private static final int TEX_SHUNT_ACTIVE = 145;
    private static final int TEX_VANISH_INACTIVE = 146;
    private static final int TEX_VANISH_ACTIVE = 147;
    private static final int TEX_VANISH_LOCKED = 148;
    private static final int TEX_VANISH_UNLOCKED = 149;
    public static final int META_SHUNT_INACTIVE = 0;
    public static final int META_SHUNT_ACTIVE = 1;
    public static final int META_VANISH_INACTIVE = 2;
    public static final int META_VANISH_ACTIVE = 3;
    public static final int META_VANISH_LOCKED = 4;
    public static final int META_VANISH_UNLOCKED = 5;
    
    public BlockTFTowerDevice(final int id) {
        super(id, 144, agi.d);
        this.c(10.0f);
        this.b(35.0f);
        this.a(amq.e);
        this.a((tj)TFItems.creativeTab);
        this.b(true);
    }
    
    public int r_() {
        return 15;
    }
    
    public int a(final int side, final int meta) {
        switch (meta) {
            default: {
                return 144;
            }
            case 1: {
                return 145;
            }
            case 2: {
                return 146;
            }
            case 3: {
                return 147;
            }
            case 4: {
                return 148;
            }
            case 5: {
                return 149;
            }
        }
    }
    
    public boolean i() {
        return true;
    }
    
    public void a(final int par1, final tj par2CreativeTabs, final List par3List) {
        par3List.add(new ur(par1, 1, 0));
        par3List.add(new ur(par1, 1, 2));
        par3List.add(new ur(par1, 1, 4));
        par3List.add(new ur(par1, 1, 5));
    }
    
    public void a(final yc par1World, final int par2, final int par3, final int par4, final qx par5EntityPlayer) {
    }
    
    public boolean a(final yc par1World, final int x, final int y, final int z, final qx par5EntityPlayer, final int par6, final float par7, final float par8, final float par9) {
        final int meta = par1World.h(x, y, z);
        if (meta == 0) {
            this.changeToBlockMeta(par1World, x, y, z, 1);
            par1World.a(x + 0.5, y + 0.5, z + 0.5, "random.click", 0.3f, 0.6f);
            par1World.a(x, y, z, this.cm, this.r_());
            return true;
        }
        if (meta == 2) {
            if (this.areNearbyLockBlocks(par1World, x, y, z)) {
                par1World.a(x + 0.5, y + 0.5, z + 0.5, "random.click", 1.0f, 0.3f);
            }
            else {
                this.changeToActiveVanishBlock(par1World, x, y, z);
            }
            return true;
        }
        if (meta == 4) {
            this.changeToBlockMeta(par1World, x, y, z, 5);
            par1World.a(x + 0.5, y + 0.5, z + 0.5, "random.click", 0.3f, 0.6f);
            return true;
        }
        if (meta == 5) {
            this.changeToBlockMeta(par1World, x, y, z, 4);
            par1World.a(x + 0.5, y + 0.5, z + 0.5, "random.click", 0.3f, 0.6f);
            return true;
        }
        return false;
    }
    
    public boolean areNearbyLockBlocks(final yc world, final int x, final int y, final int z) {
        boolean locked = false;
        for (int dx = x - 1; dx <= x + 1; ++dx) {
            for (int dy = y - 1; dy <= y + 1; ++dy) {
                for (int dz = z - 1; dz <= z + 1; ++dz) {
                    if (world.a(dx, dy, dz) == this.cm && world.h(dx, dy, dz) == 4) {
                        locked = true;
                    }
                }
            }
        }
        return locked;
    }
    
    private void changeToActiveVanishBlock(final yc par1World, final int x, final int y, final int z) {
        this.changeToBlockMeta(par1World, x, y, z, 3);
        par1World.a(x + 0.5, y + 0.5, z + 0.5, "random.pop", 0.3f, 0.6f);
        par1World.a(x, y, z, this.cm, 2 + par1World.t.nextInt(5));
    }
    
    private void changeToBlockMeta(final yc par1World, final int x, final int y, final int z, final int meta) {
        par1World.d(x, y, z, this.cm, meta);
        par1World.e(x, y, z, x, y, z);
        par1World.h(x, y, z, this.cm);
    }
    
    public void a(final yc par1World, final int x, final int y, final int z, final int myBlockID) {
        final int meta = par1World.h(x, y, z);
        if (!par1World.I && meta == 2 && par1World.B(x, y, z) && !this.areNearbyLockBlocks(par1World, x, y, z)) {
            this.changeToActiveVanishBlock(par1World, x, y, z);
        }
        super.a(par1World, x, y, z, myBlockID);
    }
    
    public boolean c(final ym world, final int x, final int y, final int z, final int side) {
        final int meta = world.h(x, y, z);
        return meta == 1;
    }
    
    public boolean b(final ym world, final int x, final int y, final int z, final int side) {
        final int meta = world.h(x, y, z);
        return meta == 1;
    }
    
    public void b(final yc par1World, final int x, final int y, final int z, final Random par5Random) {
        if (!par1World.I) {
            final int meta = par1World.h(x, y, z);
            if (meta == 1) {
                par1World.d(x, y, z, this.cm, 0);
                par1World.h(x, y, z, this.cm);
                par1World.a(x + 0.5, y + 0.5, z + 0.5, "random.click", 0.3f, 0.5f);
                par1World.e(x, y, z, x, y, z);
            }
            else if (meta == 3) {
                par1World.e(x, y, z, 0);
                par1World.h(x, y, z, this.cm);
                par1World.a(x + 0.5, y + 0.5, z + 0.5, "random.pop", 0.3f, 0.5f);
                par1World.e(x, y, z, x, y, z);
                this.checkAndActivateVanishBlock(par1World, x - 1, y, z);
                this.checkAndActivateVanishBlock(par1World, x + 1, y, z);
                this.checkAndActivateVanishBlock(par1World, x, y + 1, z);
                this.checkAndActivateVanishBlock(par1World, x, y - 1, z);
                this.checkAndActivateVanishBlock(par1World, x, y, z + 1);
                this.checkAndActivateVanishBlock(par1World, x, y, z - 1);
            }
        }
    }
    
    @SideOnly(Side.CLIENT)
    public void a(final yc par1World, final int x, final int y, final int z, final Random par5Random) {
        final int meta = par1World.h(x, y, z);
        if (meta == 3) {
            for (int i = 0; i < 1; ++i) {
                this.sparkle(par1World, x, y, z, par5Random);
            }
        }
    }
    
    private void sparkle(final yc world, final int x, final int y, final int z, final Random rand) {
        final double offset = 0.0625;
        for (int side = 0; side < 6; ++side) {
            double rx = x + rand.nextFloat();
            double ry = y + rand.nextFloat();
            double rz = z + rand.nextFloat();
            if (side == 0 && !world.s(x, y + 1, z)) {
                ry = y + 1 + offset;
            }
            if (side == 1 && !world.s(x, y - 1, z)) {
                ry = y + 0 - offset;
            }
            if (side == 2 && !world.s(x, y, z + 1)) {
                rz = z + 1 + offset;
            }
            if (side == 3 && !world.s(x, y, z - 1)) {
                rz = z + 0 - offset;
            }
            if (side == 4 && !world.s(x + 1, y, z)) {
                rx = x + 1 + offset;
            }
            if (side == 5 && !world.s(x - 1, y, z)) {
                rx = x + 0 - offset;
            }
            if (rx < x || rx > x + 1 || ry < 0.0 || ry > y + 1 || rz < z || rz > z + 1) {
                world.a("reddust", rx, ry, rz, 0.0, 0.0, 0.0);
            }
        }
    }
    
    private void checkAndActivateVanishBlock(final yc world, final int x, final int y, final int z) {
        final int thereID = world.a(x, y, z);
        final int thereMeta = world.h(x, y, z);
        if (thereID == this.cm && (thereMeta == 2 || thereMeta == 5) && !this.areNearbyLockBlocks(world, x, y, z)) {
            this.changeToActiveVanishBlock(world, x, y, z);
        }
    }
    
    public int getLightValue(final ym world, final int x, final int y, final int z) {
        final int blockID = world.a(x, y, z);
        final int meta = world.h(x, y, z);
        if (blockID != this.cm) {
            return 0;
        }
        switch (meta) {
            case 1:
            case 3: {
                return 4;
            }
            default: {
                return 0;
            }
        }
    }
    
    public int b(final int meta) {
        switch (meta) {
            case 1: {
                return 0;
            }
            case 3: {
                return 2;
            }
            default: {
                return meta;
            }
        }
    }
    
    public String getTextureFile() {
        return "/twilightforest/terrain.png";
    }
}
