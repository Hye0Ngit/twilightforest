// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import twilightforest.tileentity.TileEntityTFCReactorActive;
import twilightforest.tileentity.TileEntityTFGhastTrapActive;
import twilightforest.tileentity.TileEntityTFReverter;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import twilightforest.tileentity.TileEntityTFGhastTrapInactive;
import twilightforest.tileentity.TileEntityTFTowerBuilder;
import net.minecraft.block.BlockSourceImpl;
import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
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

public class BlockTFTowerDevice extends Block
{
    private static Icon TEX_REAPPEARING_INACTIVE;
    private static Icon TEX_REAPPEARING_ACTIVE;
    private static Icon TEX_VANISH_INACTIVE;
    private static Icon TEX_VANISH_ACTIVE;
    private static Icon TEX_VANISH_LOCKED;
    private static Icon TEX_VANISH_UNLOCKED;
    private static Icon TEX_BUILDER_INACTIVE;
    private static Icon TEX_BUILDER_ACTIVE;
    private static Icon TEX_ANTIBUILDER;
    private static Icon TEX_BUILDER_TIMEOUT;
    private static Icon TEX_GHASTTRAP_INACTIVE;
    private static Icon TEX_GHASTTRAP_ACTIVE;
    private static Icon TEX_REACTOR_INACTIVE;
    private static Icon TEX_REACTOR_ACTIVE;
    private static Icon TEX_GHASTTRAP_LID_INACTIVE;
    private static Icon TEX_GHASTTRAP_LID_ACTIVE;
    private static Icon TEX_SMOKER_ACTIVE;
    private static Icon TEX_SMOKER_INACTIVE;
    private static Icon TEX_FIREJET_ACTIVE;
    private static Icon TEX_FIREJET_INACTIVE;
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
        super(id, Material.field_76245_d);
        this.func_71848_c(10.0f);
        this.func_71894_b(35.0f);
        this.func_71884_a(Block.field_71967_e);
        this.func_71849_a((CreativeTabs)TFItems.creativeTab);
    }
    
    public int tickRate() {
        return 15;
    }
    
    public Icon func_71858_a(final int side, final int meta) {
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
                return TFBlocks.towerWood.func_71858_a(side, 1);
            }
            case 11: {
                if (side >= 2) {
                    return BlockTFTowerDevice.TEX_GHASTTRAP_ACTIVE;
                }
                if (side == 1) {
                    return BlockTFTowerDevice.TEX_GHASTTRAP_LID_ACTIVE;
                }
                return TFBlocks.towerWood.func_71858_a(side, 1);
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
    public void func_94332_a(final IconRegister par1IconRegister) {
        BlockTFTowerDevice.TEX_REAPPEARING_INACTIVE = par1IconRegister.func_94245_a("twilightforest:towerdev_reappearing_off");
        BlockTFTowerDevice.TEX_REAPPEARING_ACTIVE = par1IconRegister.func_94245_a("twilightforest:towerdev_reappearing_on");
        BlockTFTowerDevice.TEX_VANISH_INACTIVE = par1IconRegister.func_94245_a("twilightforest:towerdev_vanish_off");
        BlockTFTowerDevice.TEX_VANISH_ACTIVE = par1IconRegister.func_94245_a("twilightforest:towerdev_vanish_on");
        BlockTFTowerDevice.TEX_VANISH_LOCKED = par1IconRegister.func_94245_a("twilightforest:towerdev_lock_on");
        BlockTFTowerDevice.TEX_VANISH_UNLOCKED = par1IconRegister.func_94245_a("twilightforest:towerdev_lock_off");
        BlockTFTowerDevice.TEX_BUILDER_INACTIVE = par1IconRegister.func_94245_a("twilightforest:towerdev_builder_off");
        BlockTFTowerDevice.TEX_BUILDER_ACTIVE = par1IconRegister.func_94245_a("twilightforest:towerdev_builder_on");
        BlockTFTowerDevice.TEX_ANTIBUILDER = par1IconRegister.func_94245_a("twilightforest:towerdev_antibuilder");
        BlockTFTowerDevice.TEX_BUILDER_TIMEOUT = par1IconRegister.func_94245_a("twilightforest:towerdev_builder_timeout");
        BlockTFTowerDevice.TEX_GHASTTRAP_INACTIVE = par1IconRegister.func_94245_a("twilightforest:towerdev_ghasttrap_off");
        BlockTFTowerDevice.TEX_GHASTTRAP_ACTIVE = par1IconRegister.func_94245_a("twilightforest:towerdev_ghasttrap_on");
        BlockTFTowerDevice.TEX_REACTOR_INACTIVE = par1IconRegister.func_94245_a("twilightforest:towerdev_reactor_off");
        BlockTFTowerDevice.TEX_REACTOR_ACTIVE = par1IconRegister.func_94245_a("twilightforest:towerdev_reactor_on");
        BlockTFTowerDevice.TEX_GHASTTRAP_LID_INACTIVE = par1IconRegister.func_94245_a("twilightforest:towerdev_ghasttraplid_off");
        BlockTFTowerDevice.TEX_GHASTTRAP_LID_ACTIVE = par1IconRegister.func_94245_a("twilightforest:towerdev_ghasttraplid_on");
        BlockTFTowerDevice.TEX_SMOKER_INACTIVE = par1IconRegister.func_94245_a("twilightforest:towerdev_smoker_off");
        BlockTFTowerDevice.TEX_SMOKER_ACTIVE = par1IconRegister.func_94245_a("twilightforest:towerdev_smoker_on");
        BlockTFTowerDevice.TEX_FIREJET_INACTIVE = par1IconRegister.func_94245_a("twilightforest:towerdev_firejet_off");
        BlockTFTowerDevice.TEX_FIREJET_ACTIVE = par1IconRegister.func_94245_a("twilightforest:towerdev_firejet_on");
    }
    
    public void func_71879_a(final int par1, final CreativeTabs par2CreativeTabs, final List par3List) {
        par3List.add(new ItemStack(par1, 1, 0));
        par3List.add(new ItemStack(par1, 1, 2));
        par3List.add(new ItemStack(par1, 1, 4));
        par3List.add(new ItemStack(par1, 1, 5));
        par3List.add(new ItemStack(par1, 1, 6));
        par3List.add(new ItemStack(par1, 1, 9));
        par3List.add(new ItemStack(par1, 1, 10));
        par3List.add(new ItemStack(par1, 1, 12));
    }
    
    public boolean func_71903_a(final World par1World, final int x, final int y, final int z, final EntityPlayer par5EntityPlayer, final int par6, final float par7, final float par8, final float par9) {
        final int meta = par1World.func_72805_g(x, y, z);
        if (meta == 2) {
            if (areNearbyLockBlocks(par1World, x, y, z)) {
                par1World.func_72908_a(x + 0.5, y + 0.5, z + 0.5, "random.click", 1.0f, 0.3f);
            }
            else {
                changeToActiveVanishBlock(par1World, x, y, z, 3);
            }
            return true;
        }
        if (meta == 0) {
            if (areNearbyLockBlocks(par1World, x, y, z)) {
                par1World.func_72908_a(x + 0.5, y + 0.5, z + 0.5, "random.click", 1.0f, 0.3f);
            }
            else {
                changeToActiveVanishBlock(par1World, x, y, z, 1);
            }
            return true;
        }
        return false;
    }
    
    public float getExplosionResistance(final Entity par1Entity, final World world, final int x, final int y, final int z, final double explosionX, final double explosionY, final double explosionZ) {
        final int meta = world.func_72805_g(x, y, z);
        if (meta == 2) {
            return 6000.0f;
        }
        if (meta == 4) {
            return 6000000.0f;
        }
        return this.func_71904_a(par1Entity);
    }
    
    public float func_71934_m(final World world, final int x, final int y, final int z) {
        final int meta = world.func_72805_g(x, y, z);
        switch (meta) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5: {
                return -1.0f;
            }
            default: {
                return super.func_71934_m(world, x, y, z);
            }
        }
    }
    
    public static boolean areNearbyLockBlocks(final World world, final int x, final int y, final int z) {
        boolean locked = false;
        for (int dx = x - 2; dx <= x + 2; ++dx) {
            for (int dy = y - 2; dy <= y + 2; ++dy) {
                for (int dz = z - 2; dz <= z + 2; ++dz) {
                    if (world.func_72798_a(dx, dy, dz) == TFBlocks.towerDevice.field_71990_ca && world.func_72805_g(dx, dy, dz) == 4) {
                        locked = true;
                    }
                }
            }
        }
        return locked;
    }
    
    public static void unlockBlock(final World par1World, final int x, final int y, final int z) {
        final int thereBlockID = par1World.func_72798_a(x, y, z);
        final int thereBlockMeta = par1World.func_72805_g(x, y, z);
        if (thereBlockID == TFBlocks.towerDevice.field_71990_ca || thereBlockMeta == 4) {
            changeToBlockMeta(par1World, x, y, z, 5);
            par1World.func_72908_a(x + 0.5, y + 0.5, z + 0.5, "random.click", 0.3f, 0.6f);
        }
    }
    
    private static void changeToBlockMeta(final World par1World, final int x, final int y, final int z, final int meta) {
        final int thereBlockID = par1World.func_72798_a(x, y, z);
        if (thereBlockID == TFBlocks.towerDevice.field_71990_ca || thereBlockID == TFBlocks.towerTranslucent.field_71990_ca) {
            par1World.func_72832_d(x, y, z, thereBlockID, meta, 3);
            par1World.func_72909_d(x, y, z, x, y, z);
            par1World.func_72898_h(x, y, z, thereBlockID);
        }
    }
    
    public void func_71861_g(final World par1World, final int x, final int y, final int z) {
        final int meta = par1World.func_72805_g(x, y, z);
        if (!par1World.field_72995_K && meta == 6 && par1World.func_72864_z(x, y, z)) {
            changeToBlockMeta(par1World, x, y, z, 7);
            par1World.func_72908_a(x + 0.5, y + 0.5, z + 0.5, "random.click", 0.3f, 0.6f);
        }
    }
    
    public void func_71863_a(final World par1World, final int x, final int y, final int z, final int myBlockID) {
        final int meta = par1World.func_72805_g(x, y, z);
        if (!par1World.field_72995_K) {
            if (meta == 2 && par1World.func_72864_z(x, y, z) && !areNearbyLockBlocks(par1World, x, y, z)) {
                changeToActiveVanishBlock(par1World, x, y, z, 3);
            }
            if (meta == 0 && par1World.func_72864_z(x, y, z) && !areNearbyLockBlocks(par1World, x, y, z)) {
                changeToActiveVanishBlock(par1World, x, y, z, 1);
            }
            if (meta == 6 && par1World.func_72864_z(x, y, z)) {
                changeToBlockMeta(par1World, x, y, z, 7);
                par1World.func_72908_a(x + 0.5, y + 0.5, z + 0.5, "random.click", 0.3f, 0.6f);
                par1World.func_72836_a(x, y, z, this.field_71990_ca, 4);
            }
            if (meta == 7 && !par1World.func_72864_z(x, y, z)) {
                changeToBlockMeta(par1World, x, y, z, 6);
                par1World.func_72908_a(x + 0.5, y + 0.5, z + 0.5, "random.click", 0.3f, 0.6f);
                par1World.func_72836_a(x, y, z, this.field_71990_ca, 4);
            }
            if (meta == 8 && !par1World.func_72864_z(x, y, z)) {
                changeToBlockMeta(par1World, x, y, z, 6);
            }
            if (meta == 10 && this.isInactiveTrapCharged(par1World, x, y, z) && par1World.func_72864_z(x, y, z)) {
                changeToBlockMeta(par1World, x, y, z, 11);
                par1World.func_72908_a(x + 0.5, y + 0.5, z + 0.5, "random.click", 0.3f, 0.6f);
                par1World.func_72836_a(x, y, z, this.field_71990_ca, 4);
            }
            if (meta == 12 && this.isReactorReady(par1World, x, y, z)) {
                changeToBlockMeta(par1World, x, y, z, 13);
            }
        }
    }
    
    public void func_71847_b(final World par1World, final int x, final int y, final int z, final Random par5Random) {
        if (!par1World.field_72995_K) {
            final int meta = par1World.func_72805_g(x, y, z);
            if (meta == 3 || meta == 1) {
                if (meta == 3) {
                    par1World.func_72832_d(x, y, z, 0, 0, 3);
                }
                else {
                    par1World.func_72832_d(x, y, z, TFBlocks.towerTranslucent.field_71990_ca, 0, 3);
                    par1World.func_72836_a(x, y, z, TFBlocks.towerTranslucent.field_71990_ca, 80);
                }
                par1World.func_72898_h(x, y, z, this.field_71990_ca);
                par1World.func_72908_a(x + 0.5, y + 0.5, z + 0.5, "random.pop", 0.3f, 0.5f);
                par1World.func_72909_d(x, y, z, x, y, z);
                checkAndActivateVanishBlock(par1World, x - 1, y, z);
                checkAndActivateVanishBlock(par1World, x + 1, y, z);
                checkAndActivateVanishBlock(par1World, x, y + 1, z);
                checkAndActivateVanishBlock(par1World, x, y - 1, z);
                checkAndActivateVanishBlock(par1World, x, y, z + 1);
                checkAndActivateVanishBlock(par1World, x, y, z - 1);
            }
            if (meta == 7 && par1World.func_72864_z(x, y, z)) {
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
    
    private void letsBuild(final World par1World, final int x, final int y, final int z) {
        final BlockSourceImpl blockSource = new BlockSourceImpl(par1World, x, y, z);
        final TileEntityTFTowerBuilder tileEntity = (TileEntityTFTowerBuilder)blockSource.func_82619_j();
        if (tileEntity != null && !tileEntity.makingBlocks) {
            tileEntity.startBuilding();
        }
    }
    
    private boolean isInactiveTrapCharged(final World par1World, final int x, final int y, final int z) {
        final BlockSourceImpl blockSource = new BlockSourceImpl(par1World, x, y, z);
        final TileEntityTFGhastTrapInactive tileEntity = (TileEntityTFGhastTrapInactive)blockSource.func_82619_j();
        return tileEntity != null && tileEntity.isCharged();
    }
    
    private boolean isReactorReady(final World world, final int x, final int y, final int z) {
        return world.func_72798_a(x, y + 1, z) == Block.field_94341_cq.field_71990_ca && world.func_72798_a(x, y - 1, z) == Block.field_94341_cq.field_71990_ca && world.func_72798_a(x + 1, y, z) == Block.field_94341_cq.field_71990_ca && world.func_72798_a(x - 1, y, z) == Block.field_94341_cq.field_71990_ca && world.func_72798_a(x, y, z + 1) == Block.field_94341_cq.field_71990_ca && world.func_72798_a(x, y, z - 1) == Block.field_94341_cq.field_71990_ca;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_71862_a(final World par1World, final int x, final int y, final int z, final Random par5Random) {
        final int meta = par1World.func_72805_g(x, y, z);
        if (meta == 3 || meta == 1 || meta == 7) {
            for (int i = 0; i < 1; ++i) {
                this.sparkle(par1World, x, y, z, par5Random);
            }
        }
    }
    
    public void sparkle(final World world, final int x, final int y, final int z, final Random rand) {
        final double offset = 0.0625;
        for (int side = 0; side < 6; ++side) {
            double rx = x + rand.nextFloat();
            double ry = y + rand.nextFloat();
            double rz = z + rand.nextFloat();
            if (side == 0 && !world.func_72804_r(x, y + 1, z)) {
                ry = y + 1 + offset;
            }
            if (side == 1 && !world.func_72804_r(x, y - 1, z)) {
                ry = y + 0 - offset;
            }
            if (side == 2 && !world.func_72804_r(x, y, z + 1)) {
                rz = z + 1 + offset;
            }
            if (side == 3 && !world.func_72804_r(x, y, z - 1)) {
                rz = z + 0 - offset;
            }
            if (side == 4 && !world.func_72804_r(x + 1, y, z)) {
                rx = x + 1 + offset;
            }
            if (side == 5 && !world.func_72804_r(x - 1, y, z)) {
                rx = x + 0 - offset;
            }
            if (rx < x || rx > x + 1 || ry < 0.0 || ry > y + 1 || rz < z || rz > z + 1) {
                world.func_72869_a("reddust", rx, ry, rz, 0.0, 0.0, 0.0);
            }
        }
    }
    
    public static void checkAndActivateVanishBlock(final World world, final int x, final int y, final int z) {
        final int thereID = world.func_72798_a(x, y, z);
        final int thereMeta = world.func_72805_g(x, y, z);
        if (thereID == TFBlocks.towerDevice.field_71990_ca && (thereMeta == 2 || thereMeta == 5) && !areNearbyLockBlocks(world, x, y, z)) {
            changeToActiveVanishBlock(world, x, y, z, 3);
        }
        else if (thereID == TFBlocks.towerDevice.field_71990_ca && thereMeta == 0 && !areNearbyLockBlocks(world, x, y, z)) {
            changeToActiveVanishBlock(world, x, y, z, 1);
        }
        else if (thereID == TFBlocks.towerTranslucent.field_71990_ca && thereMeta == 2) {
            changeToActiveVanishBlock(world, x, y, z, 3);
        }
    }
    
    public static void changeToActiveVanishBlock(final World par1World, final int x, final int y, final int z, final int meta) {
        changeToBlockMeta(par1World, x, y, z, meta);
        par1World.func_72908_a(x + 0.5, y + 0.5, z + 0.5, "random.pop", 0.3f, 0.6f);
        final int thereBlockID = par1World.func_72798_a(x, y, z);
        par1World.func_72836_a(x, y, z, thereBlockID, getTickRateFor(thereBlockID, meta, par1World.field_73012_v));
    }
    
    private static int getTickRateFor(final int thereBlockID, final int meta, final Random rand) {
        if (thereBlockID == TFBlocks.towerDevice.field_71990_ca && (meta == 3 || meta == 1)) {
            return 2 + rand.nextInt(5);
        }
        if (thereBlockID == TFBlocks.towerTranslucent.field_71990_ca && meta == 3) {
            return 10;
        }
        return 15;
    }
    
    public int getLightValue(final IBlockAccess world, final int x, final int y, final int z) {
        final int blockID = world.func_72798_a(x, y, z);
        final int meta = world.func_72805_g(x, y, z);
        if (blockID != this.field_71990_ca) {
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
            case 11:
            case 13: {
                return 15;
            }
            default: {
                return 0;
            }
        }
    }
    
    public boolean hasTileEntity(final int metadata) {
        return metadata == 7 || metadata == 9 || metadata == 13 || metadata == 10 || metadata == 11;
    }
    
    public TileEntity createTileEntity(final World world, final int metadata) {
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
        if (metadata == 13) {
            return new TileEntityTFCReactorActive();
        }
        return null;
    }
    
    public int func_71885_a(final int meta, final Random par2Random, final int par3) {
        switch (meta) {
            case 9: {
                return 0;
            }
            default: {
                return this.field_71990_ca;
            }
        }
    }
    
    public int func_71899_b(final int meta) {
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
    
    public void func_71852_a(final World par1World, final int x, final int y, final int z, final int par5, final int meta) {
        super.func_71852_a(par1World, x, y, z, par5, meta);
        if (meta == 7) {
            checkAndActivateVanishBlock(par1World, x - 1, y, z);
            checkAndActivateVanishBlock(par1World, x + 1, y, z);
            checkAndActivateVanishBlock(par1World, x, y + 1, z);
            checkAndActivateVanishBlock(par1World, x, y - 1, z);
            checkAndActivateVanishBlock(par1World, x, y, z + 1);
            checkAndActivateVanishBlock(par1World, x, y, z - 1);
        }
    }
}
