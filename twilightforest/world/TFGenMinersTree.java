// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import net.minecraft.world.IBlockAccess;
import net.minecraft.block.material.Material;
import java.util.Random;
import net.minecraft.world.World;
import twilightforest.block.TFBlocks;

public class TFGenMinersTree extends TFGenerator
{
    protected int treeBlock;
    protected int treeMeta;
    protected int branchMeta;
    protected int leafBlock;
    protected int leafMeta;
    protected int rootBlock;
    protected int rootMeta;
    
    public TFGenMinersTree() {
        this(false);
    }
    
    public TFGenMinersTree(final boolean notify) {
        super(notify);
        this.treeBlock = TFBlocks.magicLog.field_71990_ca;
        this.treeMeta = 2;
        this.branchMeta = (this.treeMeta | 0xC);
        this.leafBlock = TFBlocks.magicLeaves.field_71990_ca;
        this.leafMeta = 2;
        this.rootBlock = TFBlocks.root.field_71990_ca;
        this.rootMeta = 0;
    }
    
    @Override
    public boolean func_76484_a(final World world, final Random rand, final int x, final int y, final int z) {
        final Material materialUnder = world.func_72803_f(x, y - 1, z);
        if ((materialUnder != Material.field_76247_b && materialUnder != Material.field_76248_c) || y >= TFWorld.MAXHEIGHT - 12) {
            return false;
        }
        for (int dy = 0; dy < 10; ++dy) {
            this.putBlockAndMetadata(world, x, y + dy, z, this.treeBlock, this.branchMeta, true);
        }
        this.putBranchWithLeaves(world, x, y + 9, z + 1, true);
        this.putBranchWithLeaves(world, x, y + 9, z + 2, false);
        this.putBranchWithLeaves(world, x, y + 8, z + 3, false);
        this.putBranchWithLeaves(world, x, y + 7, z + 4, false);
        this.putBranchWithLeaves(world, x, y + 6, z + 5, false);
        this.putBranchWithLeaves(world, x, y + 9, z - 1, true);
        this.putBranchWithLeaves(world, x, y + 9, z - 2, false);
        this.putBranchWithLeaves(world, x, y + 8, z - 3, false);
        this.putBranchWithLeaves(world, x, y + 7, z - 4, false);
        this.putBranchWithLeaves(world, x, y + 6, z - 5, false);
        this.putBlockAndMetadata(world, x, y + 1, z, TFBlocks.magicLogSpecial.field_71990_ca, 2, true);
        world.func_72836_a(x, y + 1, z, TFBlocks.magicLogSpecial.field_71990_ca, TFBlocks.magicLogSpecial.func_71859_p_(world));
        if (this.hasAirAround((IBlockAccess)world, x, y - 1, z)) {
            this.func_76485_a(world, x, y - 1, z, this.treeBlock, this.treeMeta);
        }
        else {
            this.func_76485_a(world, x, y - 1, z, this.rootBlock, this.rootMeta);
        }
        final int numRoots = 3 + rand.nextInt(2);
        final double offset = rand.nextDouble();
        for (int b = 0; b < numRoots; ++b) {
            this.buildRoot(world, offset, b, x, y, z);
        }
        return true;
    }
    
    protected void putBranchWithLeaves(final World world, final int bx, final int by, final int bz, final boolean bushy) {
        this.putBlockAndMetadata(world, bx, by, bz, this.treeBlock, this.branchMeta, true);
        for (int lx = -1; lx <= 1; ++lx) {
            for (int ly = -1; ly <= 1; ++ly) {
                for (int lz = -1; lz <= 1; ++lz) {
                    if (bushy || Math.abs(ly) <= 0 || Math.abs(lx) <= 0) {
                        this.putBlockAndMetadata(world, bx + lx, by + ly, bz + lz, this.leafBlock, this.leafMeta, false);
                    }
                }
            }
        }
    }
    
    private void buildRoot(final World world, final double offset, final int b, final int bx, final int by, final int bz) {
        final int[] dest = TFGenerator.translate(bx, by - b - 2, bz, 6.0, 0.3 * b + offset, 0.8);
        this.drawRoot(world, bx, by - b - 2, bz, dest[0], dest[1], dest[2]);
    }
    
    protected void drawRoot(final World world, final int sx, final int sy, final int sz, final int dx, final int dy, final int dz) {
        if (world.func_72803_f(dx, dy, dz).func_76220_a()) {
            this.drawBresehnam(world, sx, sy, sz, dx, dy, dz, this.rootBlock, this.rootMeta, true);
        }
        else {
            final int[] lineArray = TFGenerator.getBresehnamArray(sx, sy, sz, dx, dy, dz);
            for (int i = 0; i < lineArray.length; i += 3) {
                if (world.func_72798_a(lineArray[i + 0], lineArray[i + 1], lineArray[i + 2]) > 0 || TFGenerator.isNearSolid((IBlockAccess)world, lineArray[i + 0], lineArray[i + 1], lineArray[i + 2])) {
                    this.func_76485_a(world, lineArray[i + 0], lineArray[i + 1], lineArray[i + 2], this.rootBlock, this.rootMeta);
                }
            }
        }
    }
}
