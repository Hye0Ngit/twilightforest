// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import net.minecraft.util.ChunkCoordinates;
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
        final int treeHeight = 6 + random.nextInt(5);
        this.drawBresehnam(world, x, y, z, x, y + treeHeight, z, this.treeBlock, this.treeMeta);
        this.leafAround(world, x, y + treeHeight, z);
        final int numBranches = 4;
        double offset = random.nextFloat();
        for (int b = 0; b < numBranches; ++b) {
            this.buildBranch(world, x, y, z, treeHeight - 3 - numBranches + b / 2, 10 + random.nextInt(4), 0.23 * b + offset, 0.23, random);
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
        final ChunkCoordinates src = new ChunkCoordinates(x, y + height, z);
        final ChunkCoordinates dest = TFGenerator.translateCoords(src.field_71574_a, src.field_71572_b, src.field_71573_c, length, angle, tilt);
        if (dest.field_71574_a - x < -4) {
            dest.field_71574_a = x - 4;
        }
        if (dest.field_71574_a - x > 4) {
            dest.field_71574_a = x + 4;
        }
        if (dest.field_71573_c - z < -4) {
            dest.field_71573_c = z - 4;
        }
        if (dest.field_71573_c - z > 4) {
            dest.field_71573_c = z + 4;
        }
        this.drawBresehnam(world, src.field_71574_a, src.field_71572_b, src.field_71573_c, dest.field_71574_a, dest.field_71572_b, dest.field_71573_c, this.treeBlock, this.branchMeta);
        if (Math.abs(x - dest.field_71574_a) + 2 > 7 || Math.abs(z - dest.field_71573_c) + 2 > 7) {
            System.out.println("getting branch too far.  x = " + (x - dest.field_71574_a + 2) + ", z = " + (z - dest.field_71573_c + 2));
        }
        this.leafAround(world, dest.field_71574_a, dest.field_71572_b, dest.field_71573_c);
    }
    
    private void leafAround(final World world, final int dx, final int dy, final int dz) {
        final int leafSize = 4;
        if (this.hasAirAround((IBlockAccess)world, dx, dy, dz)) {
            this.makeLeafCircle(world, dx, dy - 1, dz, leafSize, this.leafBlock, this.leafMeta);
            this.makeLeafCircle(world, dx, dy, dz, leafSize + 1, this.leafBlock, this.leafMeta);
            this.makeLeafCircle(world, dx, dy + 1, dz, leafSize, this.leafBlock, this.leafMeta);
            this.makeLeafCircle(world, dx, dy + 2, dz, leafSize - 2, this.leafBlock, this.leafMeta);
        }
    }
}
