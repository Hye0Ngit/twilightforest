// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import twilightforest.tileentity.TileEntityTFGhastTrapActive;
import twilightforest.tileentity.TileEntityTFReverter;
import twilightforest.tileentity.TileEntityTFGhastTrapInactive;
import twilightforest.tileentity.TileEntityTFTowerBuilder;
import java.util.Random;
import java.util.List;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import twilightforest.item.TFItems;

public class BlockTFTowerDevice extends aou
{
    private static lx TEX_REAPPEARING_INACTIVE;
    private static lx TEX_REAPPEARING_ACTIVE;
    private static lx TEX_VANISH_INACTIVE;
    private static lx TEX_VANISH_ACTIVE;
    private static lx TEX_VANISH_LOCKED;
    private static lx TEX_VANISH_UNLOCKED;
    private static lx TEX_BUILDER_INACTIVE;
    private static lx TEX_BUILDER_ACTIVE;
    private static lx TEX_ANTIBUILDER;
    private static lx TEX_BUILDER_TIMEOUT;
    private static lx TEX_GHASTTRAP_INACTIVE;
    private static lx TEX_GHASTTRAP_ACTIVE;
    private static lx TEX_REACTOR_INACTIVE;
    private static lx TEX_REACTOR_ACTIVE;
    private static lx TEX_GHASTTRAP_LID_INACTIVE;
    private static lx TEX_GHASTTRAP_LID_ACTIVE;
    public static final int META_REAPPEARING_INACTIVE = 0;
    public static final int META_REAPPEARING_ACTIVE = 1;
    public static final int META_VANISH_INACTIVE = 2;
    public static final int META_VANISH_ACTIVE = 3;
    public static final int META_VANISH_LOCKED = 4;
    public static final int META_VANISH_UNLOCKED = 5;
    public static final int META_BUILDER_INACTIVE = 6;
    public static final int META_BUILDER_ACTIVE = 7;
    public static final int META_BUILDER_TIMEOUT = 8;
    public static final int META_ANTIBUILDER = 9;
    public static final int META_GHASTTRAP_INACTIVE = 10;
    public static final int META_GHASTTRAP_ACTIVE = 11;
    public static final int META_REACTOR_INACTIVE = 12;
    public static final int META_REACTOR_ACTIVE = 13;
    
    public BlockTFTowerDevice(final int id) {
        super(id, ahz.d);
        this.c(10.0f);
        this.b(35.0f);
        this.a(aou.g);
        this.a((uy)TFItems.creativeTab);
    }
    
    public int tickRate() {
        return 15;
    }
    
    public lx a(final int side, final int meta) {
        switch (meta) {
            default: {
                return BlockTFTowerDevice.TEX_REAPPEARING_INACTIVE;
            }
            case 1: {
                return BlockTFTowerDevice.TEX_REAPPEARING_ACTIVE;
            }
            case 2: {
                return BlockTFTowerDevice.TEX_VANISH_INACTIVE;
            }
            case 3: {
                return BlockTFTowerDevice.TEX_VANISH_ACTIVE;
            }
            case 4: {
                return BlockTFTowerDevice.TEX_VANISH_LOCKED;
            }
            case 5: {
                return BlockTFTowerDevice.TEX_VANISH_UNLOCKED;
            }
            case 6: {
                return BlockTFTowerDevice.TEX_BUILDER_INACTIVE;
            }
            case 8: {
                return BlockTFTowerDevice.TEX_BUILDER_TIMEOUT;
            }
            case 7: {
                return BlockTFTowerDevice.TEX_BUILDER_ACTIVE;
            }
            case 9: {
                return BlockTFTowerDevice.TEX_ANTIBUILDER;
            }
            case 10: {
                if (side >= 2) {
                    return BlockTFTowerDevice.TEX_GHASTTRAP_INACTIVE;
                }
                if (side == 1) {
                    return BlockTFTowerDevice.TEX_GHASTTRAP_LID_INACTIVE;
                }
                return TFBlocks.towerWood.a(side, 1);
            }
            case 11: {
                if (side >= 2) {
                    return BlockTFTowerDevice.TEX_GHASTTRAP_ACTIVE;
                }
                if (side == 1) {
                    return BlockTFTowerDevice.TEX_GHASTTRAP_LID_ACTIVE;
                }
                return TFBlocks.towerWood.a(side, 1);
            }
            case 12: {
                return BlockTFTowerDevice.TEX_REACTOR_INACTIVE;
            }
            case 13: {
                return BlockTFTowerDevice.TEX_REACTOR_ACTIVE;
            }
        }
    }
    
    @SideOnly(Side.CLIENT)
    public void a(final ly par1IconRegister) {
        BlockTFTowerDevice.TEX_REAPPEARING_INACTIVE = par1IconRegister.a("twilightforest:towerdev_reappearing_off");
        BlockTFTowerDevice.TEX_REAPPEARING_ACTIVE = par1IconRegister.a("twilightforest:towerdev_reappearing_on");
        BlockTFTowerDevice.TEX_VANISH_INACTIVE = par1IconRegister.a("twilightforest:towerdev_vanish_off");
        BlockTFTowerDevice.TEX_VANISH_ACTIVE = par1IconRegister.a("twilightforest:towerdev_vanish_on");
        BlockTFTowerDevice.TEX_VANISH_LOCKED = par1IconRegister.a("twilightforest:towerdev_lock_on");
        BlockTFTowerDevice.TEX_VANISH_UNLOCKED = par1IconRegister.a("twilightforest:towerdev_lock_off");
        BlockTFTowerDevice.TEX_BUILDER_INACTIVE = par1IconRegister.a("twilightforest:towerdev_builder_off");
        BlockTFTowerDevice.TEX_BUILDER_ACTIVE = par1IconRegister.a("twilightforest:towerdev_builder_on");
        BlockTFTowerDevice.TEX_ANTIBUILDER = par1IconRegister.a("twilightforest:towerdev_antibuilder");
        BlockTFTowerDevice.TEX_BUILDER_TIMEOUT = par1IconRegister.a("twilightforest:towerdev_builder_timeout");
        BlockTFTowerDevice.TEX_GHASTTRAP_INACTIVE = par1IconRegister.a("twilightforest:towerdev_ghasttrap_off");
        BlockTFTowerDevice.TEX_GHASTTRAP_ACTIVE = par1IconRegister.a("twilightforest:towerdev_ghasttrap_on");
        BlockTFTowerDevice.TEX_REACTOR_INACTIVE = par1IconRegister.a("twilightforest:towerdev_reactor_off");
        BlockTFTowerDevice.TEX_REACTOR_ACTIVE = par1IconRegister.a("twilightforest:towerdev_reactor_on");
        BlockTFTowerDevice.TEX_GHASTTRAP_LID_INACTIVE = par1IconRegister.a("twilightforest:towerdev_ghasttraplid_off");
        BlockTFTowerDevice.TEX_GHASTTRAP_LID_ACTIVE = par1IconRegister.a("twilightforest:towerdev_ghasttraplid_on");
    }
    
    public void a(final int par1, final uy par2CreativeTabs, final List par3List) {
        par3List.add(new wg(par1, 1, 0));
        par3List.add(new wg(par1, 1, 2));
        par3List.add(new wg(par1, 1, 4));
        par3List.add(new wg(par1, 1, 5));
        par3List.add(new wg(par1, 1, 6));
        par3List.add(new wg(par1, 1, 9));
        par3List.add(new wg(par1, 1, 10));
        par3List.add(new wg(par1, 1, 12));
    }
    
    public boolean a(final zv par1World, final int x, final int y, final int z, final sk par5EntityPlayer, final int par6, final float par7, final float par8, final float par9) {
        final int meta = par1World.h(x, y, z);
        if (meta == 2) {
            if (areNearbyLockBlocks(par1World, x, y, z)) {
                par1World.a(x + 0.5, y + 0.5, z + 0.5, "random.click", 1.0f, 0.3f);
            }
            else {
                changeToActiveVanishBlock(par1World, x, y, z, 3);
            }
            return true;
        }
        if (meta == 0) {
            if (areNearbyLockBlocks(par1World, x, y, z)) {
                par1World.a(x + 0.5, y + 0.5, z + 0.5, "random.click", 1.0f, 0.3f);
            }
            else {
                changeToActiveVanishBlock(par1World, x, y, z, 1);
            }
            return true;
        }
        return false;
    }
    
    public float getExplosionResistance(final mp par1Entity, final zv world, final int x, final int y, final int z, final double explosionX, final double explosionY, final double explosionZ) {
        final int meta = world.h(x, y, z);
        if (meta == 2) {
            return 6000.0f;
        }
        if (meta == 4) {
            return 6000000.0f;
        }
        return this.a(par1Entity);
    }
    
    public float l(final zv world, final int x, final int y, final int z) {
        final int meta = world.h(x, y, z);
        switch (meta) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5: {
                return -1.0f;
            }
            default: {
                return super.l(world, x, y, z);
            }
        }
    }
    
    public static boolean areNearbyLockBlocks(final zv world, final int x, final int y, final int z) {
        boolean locked = false;
        for (int dx = x - 2; dx <= x + 2; ++dx) {
            for (int dy = y - 2; dy <= y + 2; ++dy) {
                for (int dz = z - 2; dz <= z + 2; ++dz) {
                    if (world.a(dx, dy, dz) == TFBlocks.towerDevice.cz && world.h(dx, dy, dz) == 4) {
                        locked = true;
                    }
                }
            }
        }
        return locked;
    }
    
    public static void unlockBlock(final zv par1World, final int x, final int y, final int z) {
        final int thereBlockID = par1World.a(x, y, z);
        final int thereBlockMeta = par1World.h(x, y, z);
        if (thereBlockID == TFBlocks.towerDevice.cz || thereBlockMeta == 4) {
            changeToBlockMeta(par1World, x, y, z, 5);
            par1World.a(x + 0.5, y + 0.5, z + 0.5, "random.click", 0.3f, 0.6f);
        }
    }
    
    private static void changeToBlockMeta(final zv par1World, final int x, final int y, final int z, final int meta) {
        final int thereBlockID = par1World.a(x, y, z);
        if (thereBlockID == TFBlocks.towerDevice.cz || thereBlockID == TFBlocks.towerTranslucent.cz) {
            par1World.f(x, y, z, thereBlockID, meta, 3);
            par1World.g(x, y, z, x, y, z);
            par1World.f(x, y, z, thereBlockID);
        }
    }
    
    public void a(final zv par1World, final int x, final int y, final int z) {
        final int meta = par1World.h(x, y, z);
        if (!par1World.I && meta == 6 && par1World.C(x, y, z)) {
            changeToBlockMeta(par1World, x, y, z, 7);
            par1World.a(x + 0.5, y + 0.5, z + 0.5, "random.click", 0.3f, 0.6f);
        }
    }
    
    public void a(final zv par1World, final int x, final int y, final int z, final int myBlockID) {
        final int meta = par1World.h(x, y, z);
        if (!par1World.I) {
            if (meta == 2 && par1World.C(x, y, z) && !areNearbyLockBlocks(par1World, x, y, z)) {
                changeToActiveVanishBlock(par1World, x, y, z, 3);
            }
            if (meta == 0 && par1World.C(x, y, z) && !areNearbyLockBlocks(par1World, x, y, z)) {
                changeToActiveVanishBlock(par1World, x, y, z, 1);
            }
            if (meta == 6 && par1World.C(x, y, z)) {
                changeToBlockMeta(par1World, x, y, z, 7);
                par1World.a(x + 0.5, y + 0.5, z + 0.5, "random.click", 0.3f, 0.6f);
                par1World.a(x, y, z, this.cz, 4);
            }
            if (meta == 7 && !par1World.C(x, y, z)) {
                changeToBlockMeta(par1World, x, y, z, 6);
                par1World.a(x + 0.5, y + 0.5, z + 0.5, "random.click", 0.3f, 0.6f);
                par1World.a(x, y, z, this.cz, 4);
            }
            if (meta == 8 && !par1World.C(x, y, z)) {
                changeToBlockMeta(par1World, x, y, z, 6);
            }
            if (meta == 10 && this.isInactiveTrapCharged(par1World, x, y, z) && par1World.C(x, y, z)) {
                changeToBlockMeta(par1World, x, y, z, 11);
                par1World.a(x + 0.5, y + 0.5, z + 0.5, "random.click", 0.3f, 0.6f);
                par1World.a(x, y, z, this.cz, 4);
            }
        }
    }
    
    public void a(final zv par1World, final int x, final int y, final int z, final Random par5Random) {
        if (!par1World.I) {
            final int meta = par1World.h(x, y, z);
            if (meta == 3 || meta == 1) {
                if (meta == 3) {
                    par1World.f(x, y, z, 0, 0, 3);
                }
                else {
                    par1World.f(x, y, z, TFBlocks.towerTranslucent.cz, 0, 3);
                    par1World.a(x, y, z, TFBlocks.towerTranslucent.cz, 80);
                }
                par1World.f(x, y, z, this.cz);
                par1World.a(x + 0.5, y + 0.5, z + 0.5, "random.pop", 0.3f, 0.5f);
                par1World.g(x, y, z, x, y, z);
                checkAndActivateVanishBlock(par1World, x - 1, y, z);
                checkAndActivateVanishBlock(par1World, x + 1, y, z);
                checkAndActivateVanishBlock(par1World, x, y + 1, z);
                checkAndActivateVanishBlock(par1World, x, y - 1, z);
                checkAndActivateVanishBlock(par1World, x, y, z + 1);
                checkAndActivateVanishBlock(par1World, x, y, z - 1);
            }
            if (meta == 7 && par1World.C(x, y, z)) {
                this.letsBuild(par1World, x, y, z);
            }
            if (meta == 6 || meta == 8) {
                checkAndActivateVanishBlock(par1World, x - 1, y, z);
                checkAndActivateVanishBlock(par1World, x + 1, y, z);
                checkAndActivateVanishBlock(par1World, x, y + 1, z);
                checkAndActivateVanishBlock(par1World, x, y - 1, z);
                checkAndActivateVanishBlock(par1World, x, y, z + 1);
                checkAndActivateVanishBlock(par1World, x, y, z - 1);
            }
        }
    }
    
    private void letsBuild(final zv par1World, final int x, final int y, final int z) {
        final ba blockSource = new ba(par1World, x, y, z);
        final TileEntityTFTowerBuilder tileEntity = (TileEntityTFTowerBuilder)blockSource.j();
        if (tileEntity != null && !tileEntity.makingBlocks) {
            tileEntity.startBuilding();
        }
    }
    
    private boolean isInactiveTrapCharged(final zv par1World, final int x, final int y, final int z) {
        final ba blockSource = new ba(par1World, x, y, z);
        final TileEntityTFGhastTrapInactive tileEntity = (TileEntityTFGhastTrapInactive)blockSource.j();
        return tileEntity != null && tileEntity.isCharged();
    }
    
    @SideOnly(Side.CLIENT)
    public void b(final zv par1World, final int x, final int y, final int z, final Random par5Random) {
        final int meta = par1World.h(x, y, z);
        if (meta == 3 || meta == 1 || meta == 7) {
            for (int i = 0; i < 1; ++i) {
                this.sparkle(par1World, x, y, z, par5Random);
            }
        }
    }
    
    public void sparkle(final zv world, final int x, final int y, final int z, final Random rand) {
        final double offset = 0.0625;
        for (int side = 0; side < 6; ++side) {
            double rx = x + rand.nextFloat();
            double ry = y + rand.nextFloat();
            double rz = z + rand.nextFloat();
            if (side == 0 && !world.t(x, y + 1, z)) {
                ry = y + 1 + offset;
            }
            if (side == 1 && !world.t(x, y - 1, z)) {
                ry = y + 0 - offset;
            }
            if (side == 2 && !world.t(x, y, z + 1)) {
                rz = z + 1 + offset;
            }
            if (side == 3 && !world.t(x, y, z - 1)) {
                rz = z + 0 - offset;
            }
            if (side == 4 && !world.t(x + 1, y, z)) {
                rx = x + 1 + offset;
            }
            if (side == 5 && !world.t(x - 1, y, z)) {
                rx = x + 0 - offset;
            }
            if (rx < x || rx > x + 1 || ry < 0.0 || ry > y + 1 || rz < z || rz > z + 1) {
                world.a("reddust", rx, ry, rz, 0.0, 0.0, 0.0);
            }
        }
    }
    
    public static void checkAndActivateVanishBlock(final zv world, final int x, final int y, final int z) {
        final int thereID = world.a(x, y, z);
        final int thereMeta = world.h(x, y, z);
        if (thereID == TFBlocks.towerDevice.cz && (thereMeta == 2 || thereMeta == 5) && !areNearbyLockBlocks(world, x, y, z)) {
            changeToActiveVanishBlock(world, x, y, z, 3);
        }
        else if (thereID == TFBlocks.towerDevice.cz && thereMeta == 0 && !areNearbyLockBlocks(world, x, y, z)) {
            changeToActiveVanishBlock(world, x, y, z, 1);
        }
        else if (thereID == TFBlocks.towerTranslucent.cz && thereMeta == 2) {
            changeToActiveVanishBlock(world, x, y, z, 3);
        }
    }
    
    public static void changeToActiveVanishBlock(final zv par1World, final int x, final int y, final int z, final int meta) {
        changeToBlockMeta(par1World, x, y, z, meta);
        par1World.a(x + 0.5, y + 0.5, z + 0.5, "random.pop", 0.3f, 0.6f);
        final int thereBlockID = par1World.a(x, y, z);
        par1World.a(x, y, z, thereBlockID, getTickRateFor(thereBlockID, meta, par1World.s));
    }
    
    private static int getTickRateFor(final int thereBlockID, final int meta, final Random rand) {
        if (thereBlockID == TFBlocks.towerDevice.cz && (meta == 3 || meta == 1)) {
            return 2 + rand.nextInt(5);
        }
        if (thereBlockID == TFBlocks.towerTranslucent.cz && meta == 3) {
            return 10;
        }
        return 15;
    }
    
    public int getLightValue(final aae world, final int x, final int y, final int z) {
        final int blockID = world.a(x, y, z);
        final int meta = world.h(x, y, z);
        if (blockID != this.cz) {
            return 0;
        }
        switch (meta) {
            case 1:
            case 3:
            case 7: {
                return 4;
            }
            case 9: {
                return 10;
            }
            case 11: {
                return 15;
            }
            default: {
                return 0;
            }
        }
    }
    
    public boolean hasTileEntity(final int metadata) {
        return metadata == 7 || metadata == 9 || metadata == 10 || metadata == 11;
    }
    
    public aqj createTileEntity(final zv world, final int metadata) {
        if (metadata == 7) {
            return new TileEntityTFTowerBuilder();
        }
        if (metadata == 9) {
            return new TileEntityTFReverter();
        }
        if (metadata == 10) {
            return new TileEntityTFGhastTrapInactive();
        }
        if (metadata == 11) {
            return new TileEntityTFGhastTrapActive();
        }
        return null;
    }
    
    public int a(final int meta, final Random par2Random, final int par3) {
        switch (meta) {
            case 9: {
                return 0;
            }
            default: {
                return this.cz;
            }
        }
    }
    
    public int a(final int meta) {
        switch (meta) {
            case 1: {
                return 0;
            }
            case 7:
            case 8: {
                return 6;
            }
            case 3: {
                return 2;
            }
            case 11: {
                return 10;
            }
            case 13: {
                return 12;
            }
            default: {
                return meta;
            }
        }
    }
}
