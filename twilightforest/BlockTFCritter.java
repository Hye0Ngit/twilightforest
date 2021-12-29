// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.ArrayList;
import java.util.Random;
import forge.ITextureProvider;

public class BlockTFCritter extends pb implements ITextureProvider
{
    public static int sprFirefly;
    public static int sprCicada;
    
    protected BlockTFCritter(final int index) {
        super(index, acn.p);
        this.c(0.0f);
        this.bN = BlockTFCritter.sprFirefly;
    }
    
    protected BlockTFCritter(final int index, final acn material) {
        super(index, material);
    }
    
    public void b_(final xd world, final int i, final int j, final int k) {
        super.b_(world, i, j, k);
    }
    
    public int a(final int side, final int meta) {
        switch (meta) {
            case 0: {
                return BlockTFCritter.sprFirefly;
            }
            default: {
                return BlockTFCritter.sprCicada;
            }
        }
    }
    
    public int getLightValue(final ali world, final int x, final int y, final int z) {
        final int meta = world.e(x, y, z);
        return (meta == 0) ? 15 : 0;
    }
    
    public int e() {
        return 50;
    }
    
    public pl a(final xd world, final int i, final int j, final int k, final bo vec3d, final bo vec3d1) {
        final int facing = getCritterFacing((ali)world, i, j, k);
        final float f = 0.15f;
        if (facing == 1) {
            this.a(0.0f, 0.2f, 0.5f - f, f * 2.0f, 0.8f, 0.5f + f);
        }
        else if (facing == 2) {
            this.a(1.0f - f * 2.0f, 0.2f, 0.5f - f, 1.0f, 0.8f, 0.5f + f);
        }
        else if (facing == 3) {
            this.a(0.5f - f, 0.2f, 0.0f, 0.5f + f, 0.8f, f * 2.0f);
        }
        else if (facing == 4) {
            this.a(0.5f - f, 0.2f, 1.0f - f * 2.0f, 0.5f + f, 0.8f, 1.0f);
        }
        else if (facing == 5) {
            this.a(0.5f - f, 0.0f, 0.2f, 0.5f + f, f * 2.0f, 0.8f);
        }
        else if (facing == 6) {
            this.a(0.5f - f, 1.0f - f * 2.0f, 0.2f, 0.5f + f, 1.0f, 0.8f);
        }
        else {
            final float f2 = 0.1f;
            this.a(0.5f - f2, 0.0f, 0.5f - f2, 0.5f + f2, 0.6f, 0.5f + f2);
        }
        return super.a(world, i, j, k, vec3d, vec3d1);
    }
    
    public wu c(final xd world, final int i, final int j, final int k) {
        return null;
    }
    
    public boolean a() {
        return false;
    }
    
    public boolean b() {
        return false;
    }
    
    public int d() {
        return mod_TwilightForest.critterRenderID;
    }
    
    public boolean e(final xd world, final int i, final int j, final int k) {
        return this.canPlaceAt(world, i - 1, j, k) || this.canPlaceAt(world, i + 1, j, k) || this.canPlaceAt(world, i, j, k - 1) || this.canPlaceAt(world, i, j, k + 1) || this.canPlaceAt(world, i, j - 1, k) || this.canPlaceAt(world, i, j + 1, k);
    }
    
    public void c(final xd world, final int i, final int j, final int k, final int placementFacing) {
        int critterFacing = 0;
        if (placementFacing == 1 && this.canPlaceAt(world, i, j - 1, k)) {
            critterFacing = 5;
        }
        if (placementFacing == 0 && this.canPlaceAt(world, i, j + 1, k)) {
            critterFacing = 6;
        }
        if (placementFacing == 2 && this.canPlaceAt(world, i, j, k + 1)) {
            critterFacing = 4;
        }
        if (placementFacing == 3 && this.canPlaceAt(world, i, j, k - 1)) {
            critterFacing = 3;
        }
        if (placementFacing == 4 && this.canPlaceAt(world, i + 1, j, k)) {
            critterFacing = 2;
        }
        if (placementFacing == 5 && this.canPlaceAt(world, i - 1, j, k)) {
            critterFacing = 1;
        }
        setCritterFacing((ali)world, i, j, k, critterFacing);
        final int meta = world.e(i, j, k);
        if (meta == 0) {
            world.a(i, j, k, this.bO, this.e());
        }
    }
    
    public void a(final xd world, final int x, final int y, final int z) {
        if (this.canPlaceAt(world, x - 1, y, z)) {
            setCritterFacing((ali)world, x, y, z, 1);
        }
        else if (this.canPlaceAt(world, x + 1, y, z)) {
            setCritterFacing((ali)world, x, y, z, 2);
        }
        else if (this.canPlaceAt(world, x, y, z - 1)) {
            setCritterFacing((ali)world, x, y, z, 3);
        }
        else if (this.canPlaceAt(world, x, y, z + 1)) {
            setCritterFacing((ali)world, x, y, z, 4);
        }
        else if (this.canPlaceAt(world, x, y - 1, z)) {
            setCritterFacing((ali)world, x, y, z, 5);
        }
        super.a(world, x, y, z);
        this.dropCritterIfCantStay(world, x, y, z);
        final int meta = world.e(x, y, z);
        if (meta == 0) {
            world.a(x, y, z, this.bO, this.e());
        }
    }
    
    private boolean dropCritterIfCantStay(final xd world, final int x, final int y, final int z) {
        if (!this.e(world, x, y, z)) {
            this.a(world, x, y, z, world.e(x, y, z), 0);
            world.g(x, y, z, 0);
            return false;
        }
        return true;
    }
    
    public void a(final xd world, final int x, final int y, final int z, final int blockID) {
        if (this.dropCritterIfCantStay(world, x, y, z)) {
            final int facing = getCritterFacing((ali)world, x, y, z);
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
                this.a(world, x, y, z, world.e(x, y, z), 0);
                world.g(x, y, z, 0);
            }
        }
    }
    
    public void a(final xd world, final int x, final int y, final int z, final Random random) {
        if (world.e(x, y, z) == 0 && world.o(x, y, z) < 12) {
            world.c(wl.b, x, y, z);
            world.a(x, y, z, this.bO, this.e());
        }
    }
    
    public void b(final xd world, final int x, final int y, final int z, final Random random) {
        if (world.e(x, y, z) == 0 && world.o(x, y, z) < 12) {
            world.c(wl.b, x, y, z);
            world.a(x, y, z, this.bO, this.e());
        }
    }
    
    public static int getCritterFacing(final ali world, final int x, final int y, final int z) {
        final kw tileEntity = world.b(x, y, z);
        if (tileEntity instanceof TileEntityTFCritter) {
            return ((TileEntityTFCritter)tileEntity).getFacing();
        }
        return -1;
    }
    
    public static void setCritterFacing(final ali world, final int x, final int y, final int z, final int facing) {
        final kw tileEntity = world.b(x, y, z);
        if (tileEntity instanceof TileEntityTFCritter) {
            ((TileEntityTFCritter)tileEntity).setFacing(facing);
        }
    }
    
    public boolean canPlaceAt(final xd world, final int x, final int y, final int z) {
        return world.h(x, y, z) || world.f(x, y, z) == acn.i || world.f(x, y, z) == acn.x;
    }
    
    public boolean hasTileEntity(final int metadata) {
        return true;
    }
    
    public kw getTileEntity(final int metadata) {
        if (metadata == 0) {
            return new TileEntityTFFirefly();
        }
        if (metadata == 1) {
            return new TileEntityTFCicada();
        }
        return null;
    }
    
    public void addCreativeItems(final ArrayList itemList) {
        itemList.add(new aan((pb)this, 1, 0));
        itemList.add(new aan((pb)this, 1, 1));
    }
    
    public String getTextureFile() {
        return "/twilightforest/terrain.png";
    }
    
    public static boolean renderFirefly(final vl renderblocks, final ali blockAccess, final int x, final int y, final int z, final pb block) {
        final adz tessellator = adz.a;
        final int spr = BlockTFCritter.sprFirefly;
        final float brightness = block.e(blockAccess, x, y, z);
        tessellator.a(brightness, brightness, brightness);
        final int spr2 = (spr & 0xF) << 4;
        final int spr3 = spr & 0xF0;
        final double d = spr2 / 256.0f;
        final double d2 = (spr2 + 15.99f) / 256.0f;
        final double d3 = spr3 / 256.0f;
        final double d4 = (spr3 + 15.99f) / 256.0f;
        final int facing = getCritterFacing(blockAccess, x, y, z);
        final float f1 = 0.0f;
        final float f2 = 0.01f;
        if (facing == 1) {
            tessellator.a((double)(x + f2), (double)(y + 1 + f1), (double)(z + 1 + f1), d, d3);
            tessellator.a((double)(x + f2), (double)(y + 0 - f1), (double)(z + 1 + f1), d, d4);
            tessellator.a((double)(x + f2), (double)(y + 0 - f1), (double)(z + 0 - f1), d2, d4);
            tessellator.a((double)(x + f2), (double)(y + 1 + f1), (double)(z + 0 - f1), d2, d3);
        }
        if (facing == 2) {
            tessellator.a((double)(x + 1 - f2), (double)(y + 0 - f1), (double)(z + 1 + f1), d2, d4);
            tessellator.a((double)(x + 1 - f2), (double)(y + 1 + f1), (double)(z + 1 + f1), d2, d3);
            tessellator.a((double)(x + 1 - f2), (double)(y + 1 + f1), (double)(z + 0 - f1), d, d3);
            tessellator.a((double)(x + 1 - f2), (double)(y + 0 - f1), (double)(z + 0 - f1), d, d4);
        }
        if (facing == 3) {
            tessellator.a((double)(x + 1 + f1), (double)(y + 0 - f1), (double)(z + f2), d2, d4);
            tessellator.a((double)(x + 1 + f1), (double)(y + 1 + f1), (double)(z + f2), d2, d3);
            tessellator.a((double)(x + 0 - f1), (double)(y + 1 + f1), (double)(z + f2), d, d3);
            tessellator.a((double)(x + 0 - f1), (double)(y + 0 - f1), (double)(z + f2), d, d4);
        }
        if (facing == 4) {
            tessellator.a((double)(x + 1 + f1), (double)(y + 1 + f1), (double)(z + 1 - f2), d, d3);
            tessellator.a((double)(x + 1 + f1), (double)(y + 0 - f1), (double)(z + 1 - f2), d, d4);
            tessellator.a((double)(x + 0 - f1), (double)(y + 0 - f1), (double)(z + 1 - f2), d2, d4);
            tessellator.a((double)(x + 0 - f1), (double)(y + 1 + f1), (double)(z + 1 - f2), d2, d3);
        }
        return true;
    }
    
    static {
        BlockTFCritter.sprFirefly = 4;
        BlockTFCritter.sprCicada = 5;
    }
}
