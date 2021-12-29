// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraftforge.common.ForgeDirection;
import twilightforest.TwilightForestMod;
import twilightforest.item.TFItems;

public abstract class BlockTFCritter extends aqw
{
    protected BlockTFCritter(final int index) {
        super(index, ajz.q);
        this.c(0.0f);
        this.a((wv)TFItems.creativeTab);
        this.cS = new StepSoundTFInsect("squish", 0.25f, 0.6f);
    }
    
    public void a(final ace world, final int x, final int y, final int z) {
        final int facing = world.h(x, y, z) & 0x7;
        final float wide = 0.15f;
        if (facing == 1) {
            this.a(0.0f, 0.2f, 0.5f - wide, wide * 2.0f, 0.8f, 0.5f + wide);
        }
        else if (facing == 2) {
            this.a(1.0f - wide * 2.0f, 0.2f, 0.5f - wide, 1.0f, 0.8f, 0.5f + wide);
        }
        else if (facing == 3) {
            this.a(0.5f - wide, 0.2f, 0.0f, 0.5f + wide, 0.8f, wide * 2.0f);
        }
        else if (facing == 4) {
            this.a(0.5f - wide, 0.2f, 1.0f - wide * 2.0f, 0.5f + wide, 0.8f, 1.0f);
        }
        else if (facing == 5) {
            this.a(0.5f - wide, 0.0f, 0.2f, 0.5f + wide, wide * 2.0f, 0.8f);
        }
        else if (facing == 6) {
            this.a(0.5f - wide, 1.0f - wide * 2.0f, 0.2f, 0.5f + wide, 1.0f, 0.8f);
        }
        else {
            final float f1 = 0.1f;
            this.a(0.5f - f1, 0.0f, 0.5f - f1, 0.5f + f1, 0.6f, 0.5f + f1);
        }
    }
    
    public asu b(final abv world, final int i, final int j, final int k) {
        return null;
    }
    
    public boolean c() {
        return false;
    }
    
    public boolean b() {
        return false;
    }
    
    public int d() {
        return TwilightForestMod.proxy.getCritterBlockRenderID();
    }
    
    public boolean c(final abv world, final int i, final int j, final int k) {
        return this.canPlaceAt(world, i - 1, j, k) || this.canPlaceAt(world, i + 1, j, k) || this.canPlaceAt(world, i, j, k - 1) || this.canPlaceAt(world, i, j, k + 1) || this.canPlaceAt(world, i, j - 1, k) || this.canPlaceAt(world, i, j + 1, k);
    }
    
    public int a(final abv par1World, final int x, final int y, final int z, final int placementFacing, final float par6, final float par7, final float par8, int meta) {
        if (placementFacing == 1 && this.canPlaceAt(par1World, x, y - 1, z)) {
            meta = 5;
        }
        if (placementFacing == 0 && this.canPlaceAt(par1World, x, y + 1, z)) {
            meta = 6;
        }
        if (placementFacing == 2 && par1World.isBlockSolidOnSide(x, y, z + 1, ForgeDirection.NORTH, true)) {
            meta = 4;
        }
        if (placementFacing == 3 && par1World.isBlockSolidOnSide(x, y, z - 1, ForgeDirection.SOUTH, true)) {
            meta = 3;
        }
        if (placementFacing == 4 && par1World.isBlockSolidOnSide(x + 1, y, z, ForgeDirection.WEST, true)) {
            meta = 2;
        }
        if (placementFacing == 5 && par1World.isBlockSolidOnSide(x - 1, y, z, ForgeDirection.EAST, true)) {
            meta = 1;
        }
        return meta;
    }
    
    public void a(final abv world, final int x, final int y, final int z) {
        if (world.h(x, y, z) == 0) {
            if (this.canPlaceAt(world, x - 1, y, z)) {
                world.b(x, y, z, 1, 2);
            }
            else if (this.canPlaceAt(world, x + 1, y, z)) {
                world.b(x, y, z, 2, 2);
            }
            else if (this.canPlaceAt(world, x, y, z - 1)) {
                world.b(x, y, z, 3, 2);
            }
            else if (this.canPlaceAt(world, x, y, z + 1)) {
                world.b(x, y, z, 4, 2);
            }
            else if (this.canPlaceAt(world, x, y - 1, z)) {
                world.b(x, y, z, 5, 2);
            }
            else if (this.canPlaceAt(world, x, y + 1, z)) {
                world.b(x, y, z, 6, 2);
            }
        }
        this.dropCritterIfCantStay(world, x, y, z);
        final int meta = world.h(x, y, z);
        if (meta == 0) {
            world.a(x, y, z, this.cF, this.a(world));
        }
    }
    
    public boolean dropCritterIfCantStay(final abv world, final int x, final int y, final int z) {
        if (!this.c(world, x, y, z)) {
            this.c(world, x, y, z, world.h(x, y, z), 0);
            world.i(x, y, z);
            return false;
        }
        return true;
    }
    
    public void a(final abv world, final int x, final int y, final int z, final int blockID) {
        if (this.dropCritterIfCantStay(world, x, y, z)) {
            final int facing = world.h(x, y, z) & 0x7;
            boolean flag = false;
            if (!this.canPlaceAt(world, x - 1, y, z) && facing == 1) {
                flag = true;
            }
            if (!this.canPlaceAt(world, x + 1, y, z) && facing == 2) {
                flag = true;
            }
            if (!this.canPlaceAt(world, x, y, z - 1) && facing == 3) {
                flag = true;
            }
            if (!this.canPlaceAt(world, x, y, z + 1) && facing == 4) {
                flag = true;
            }
            if (!this.canPlaceAt(world, x, y - 1, z) && facing == 5) {
                flag = true;
            }
            if (!this.canPlaceAt(world, x, y + 1, z) && facing == 6) {
                flag = true;
            }
            if (flag) {
                this.c(world, x, y, z, 0, 0);
                world.i(x, y, z);
            }
        }
    }
    
    public boolean canPlaceAt(final abv world, final int x, final int y, final int z) {
        return world.u(x, y, z) || world.g(x, y, z) == ajz.j || world.g(x, y, z) == ajz.z;
    }
    
    public boolean hasTileEntity(final int metadata) {
        return true;
    }
    
    public abstract asm createTileEntity(final abv p0, final int p1);
    
    public void a(final int par1, final wv par2CreativeTabs, final List par3List) {
        par3List.add(new yd(par1, 1, 0));
    }
    
    @SideOnly(Side.CLIENT)
    public void a(final ms par1IconRegister) {
        this.cW = par1IconRegister.a("TwilightForest:" + this.a().substring(5));
    }
}
