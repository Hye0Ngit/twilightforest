// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.material.Material;
import java.util.Random;
import net.minecraft.world.World;
import twilightforest.block.TFBlocks;

public class TFGenDarkCanopyTree extends TFTreeGenerator
{
    public TFGenDarkCanopyTree() {
        this(false);
    }
    
    public TFGenDarkCanopyTree(final boolean par1) {
        super(par1);
        this.treeBlock = TFBlocks.log.field_71990_ca;
        this.treeMeta = 3;
        this.branchMeta = 15;
        this.leafBlock = TFBlocks.hedge.field_71990_ca;
        this.leafMeta = 1;
        this.rootBlock = TFBlocks.root.field_71990_ca;
        this.rootMeta = 0;
    }
    
    @Override
    public boolean func_76484_a(final World world, final Random random, final int x, int y, final int z) {
        boolean foundDirt = false;
        for (int dy = y; dy >= TFWorld.SEALEVEL; --dy) {
            final Material materialUnder = world.func_72803_f(x, dy - 1, z);
            if (materialUnder == Material.field_76247_b || materialUnder == Material.field_76248_c) {
                foundDirt = true;
                y = dy;
                break;
            }
            if (materialUnder == Material.field_76246_e) {
                break;
            }
            if (materialUnder == Material.field_76251_o) {
                break;
            }
        }
        if (!foundDirt) {
            return false;
        }
        if (world.func_72803_f(x + 1, y, z + 0) == Material.field_76245_d || world.func_72803_f(x - 1, y, z + 0) == Material.field_76245_d || world.func_72803_f(x + 0, y, z + 1) == Material.field_76245_d || world.func_72803_f(x + 0, y, z - 1) == Material.field_76245_d) {
            return false;
        }
        final int treeHeight = 4 + random.nextInt(3);
        this.drawBresehnam(world, x, y, z, x, y + treeHeight, z, this.treeBlock, this.treeMeta, true);
        final int numBranches = 4;
        double offset = random.nextFloat();
        for (int b = 0; b < numBranches; ++b) {
            this.buildBranch(world, x, y, z, treeHeight - numBranches + b / 2, 8.0, 0.23 * b + offset, 0.23, random);
        }
        if (this.hasAirAround((IBlockAccess)world, x, y - 1, z)) {
            this.func_76485_a(world, x, y - 1, z, this.treeBlock, this.treeMeta);
        }
        else {
            this.func_76485_a(world, x, y - 1, z, this.rootBlock, this.rootMeta);
        }
        final int numRoots = 3 + random.nextInt(2);
        offset = random.nextDouble();
        for (int b2 = 0; b2 < numRoots; ++b2) {
            this.buildRoot(world, x, y, z, offset, b2);
        }
        return true;
    }
    
    void buildBranch(final World world, final int x, final int y, final int z, final int height, final double length, final double angle, final double tilt, final Random random) {
        final int[] src = { x, y + height, z };
        final int[] dest = TFGenerator.translate(src[0], src[1], src[2], length, angle, tilt);
        this.drawBresehnam(world, src[0], src[1], src[2], dest[0], dest[1], dest[2], this.treeBlock, this.branchMeta, true);
        byte leafSize = 4;
        if (random.nextInt(3) == 0) {
            leafSize += (byte)(random.nextInt(3) - 1);
        }
        if (world.func_72798_a(dest[0], dest[1] - 1, dest[2]) == 0 || world.func_72798_a(dest[0], dest[1] + 1, dest[2]) == 0 || world.func_72798_a(dest[0] + 4, dest[1], dest[2]) == 0 || world.func_72798_a(dest[0] - 4, dest[1], dest[2]) == 0 || world.func_72798_a(dest[0], dest[1], dest[2] + 4) == 0 || world.func_72798_a(dest[0], dest[1], dest[2] - 4) == 0) {
            this.drawCircle(world, dest[0], dest[1] - 1, dest[2], leafSize, this.leafBlock, this.leafMeta, false);
            this.drawCircle(world, dest[0], dest[1], dest[2], leafSize + 1, this.leafBlock, this.leafMeta, false);
            this.drawCircle(world, dest[0], dest[1] + 1, dest[2], leafSize, this.leafBlock, this.leafMeta, false);
            this.drawCircle(world, dest[0], dest[1] + 2, dest[2], leafSize - 2, this.leafBlock, this.leafMeta, false);
        }
    }
    
    void nullifySkyLightUnderBranch(final World world, final int sx, final int sy, final int sz, final int rad) {
        for (byte dx = 0; dx <= rad; ++dx) {
            for (byte dz = 0; dz <= rad; ++dz) {
                final int dist = Math.max(dx, dz) + (Math.min(dx, dz) >> 1);
                if (dist <= rad) {
                    this.nullifySkyLightColumn(world, sx + dx, sy, sz + dz);
                    this.nullifySkyLightColumn(world, sx + dx, sy, sz - dz);
                    this.nullifySkyLightColumn(world, sx - dx, sy, sz + dz);
                    this.nullifySkyLightColumn(world, sx - dx, sy, sz - dz);
                }
            }
        }
    }
    
    void nullifySkyLightColumn(final World world, final int dx, final int dy, final int dz) {
        for (int y = dy; y >= 0; --y) {
            world.func_72915_b(EnumSkyBlock.Sky, dx, y, dz, 0);
        }
    }
}
