// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import net.minecraft.world.IBlockAccess;
import net.minecraft.block.Block;
import java.util.Random;
import net.minecraft.world.World;
import twilightforest.block.TFBlocks;

public class TFGenHugeCanopyTree extends TFGenerator
{
    private int treeBlock;
    private int treeMeta;
    private int branchMeta;
    private int leafBlock;
    private int leafMeta;
    private int rootBlock;
    private int rootMeta;
    
    public TFGenHugeCanopyTree() {
        this.treeBlock = TFBlocks.log.field_71990_ca;
        this.treeMeta = 1;
        this.branchMeta = 13;
        this.leafBlock = TFBlocks.leaves.field_71990_ca;
        this.leafMeta = 1;
        this.rootBlock = TFBlocks.root.field_71990_ca;
        this.rootMeta = 0;
    }
    
    @Override
    public boolean func_76484_a(final World world, final Random random, final int x, final int y, final int z) {
        int treeHeight = 35;
        if (random.nextInt(3) == 0) {
            treeHeight += random.nextInt(10);
            if (random.nextInt(8) == 0) {
                treeHeight += random.nextInt(10);
            }
        }
        final int blockUnder = world.func_72798_a(x, y - 1, z);
        if ((blockUnder != Block.field_71980_u.field_71990_ca && blockUnder != Block.field_71979_v.field_71990_ca) || y >= TFWorld.MAXHEIGHT - treeHeight) {
            return false;
        }
        this.buildTrunk(world, x, y, z, 0, treeHeight, 0.0, 0.0, true);
        final int numBranches = 5 + random.nextInt(3);
        double offset = random.nextDouble();
        for (int b = 0; b < numBranches; ++b) {
            this.buildBranch(world, x, y, z, treeHeight - 23 + (int)(b * 1.5), 17.0, 0.3 * b + offset, 0.25);
        }
        final int numRoots = 4 + random.nextInt(3);
        offset = random.nextDouble();
        for (int b2 = 0; b2 < numRoots; ++b2) {
            this.buildRoot(world, x, y, z, offset, b2);
        }
        return true;
    }
    
    void buildBranch(final World world, final int x, final int y, final int z, final int height, final double length, final double angle, final double tilt) {
        final int[] src = { x, y + height, z };
        final int[] dest = TFGenerator.translate(src[0], src[1], src[2], length, angle, tilt);
        this.drawBresehnam(world, src[0], src[1], src[2], dest[0], dest[1], dest[2], this.treeBlock, this.branchMeta, true);
        this.drawBresehnam(world, src[0], src[1] - 1, src[2], dest[0], dest[1] - 1, dest[2], this.treeBlock, this.branchMeta, true);
        this.makeLeafNode(world, dest);
    }
    
    protected void makeLeafNode(final World world, final int[] dest) {
        this.drawBresehnam(world, dest[0], dest[1], dest[2], dest[0] + 4, dest[1], dest[2] + 0, this.treeBlock, this.branchMeta, true);
        this.drawBresehnam(world, dest[0], dest[1], dest[2], dest[0] - 4, dest[1], dest[2] + 0, this.treeBlock, this.branchMeta, true);
        this.drawBresehnam(world, dest[0], dest[1], dest[2], dest[0] + 0, dest[1], dest[2] + 4, this.treeBlock, this.branchMeta, true);
        this.drawBresehnam(world, dest[0], dest[1], dest[2], dest[0] + 0, dest[1], dest[2] - 4, this.treeBlock, this.branchMeta, true);
        this.putBlockAndMetadata(world, dest[0] + 5, dest[1], dest[2] + 1, this.treeBlock, this.branchMeta, true);
        this.putBlockAndMetadata(world, dest[0] + 5, dest[1], dest[2] - 1, this.treeBlock, this.branchMeta, true);
        this.putBlockAndMetadata(world, dest[0] - 5, dest[1], dest[2] + 1, this.treeBlock, this.branchMeta, true);
        this.putBlockAndMetadata(world, dest[0] - 5, dest[1], dest[2] - 1, this.treeBlock, this.branchMeta, true);
        this.putBlockAndMetadata(world, dest[0] + 1, dest[1], dest[2] + 5, this.treeBlock, this.branchMeta, true);
        this.putBlockAndMetadata(world, dest[0] - 1, dest[1], dest[2] + 5, this.treeBlock, this.branchMeta, true);
        this.putBlockAndMetadata(world, dest[0] + 1, dest[1], dest[2] - 5, this.treeBlock, this.branchMeta, true);
        this.putBlockAndMetadata(world, dest[0] - 1, dest[1], dest[2] - 5, this.treeBlock, this.branchMeta, true);
        this.drawBresehnam(world, dest[0] + 1, dest[1], dest[2] + 0, dest[0] + 4, dest[1], dest[2] + 3, this.treeBlock, this.branchMeta, true);
        this.drawBresehnam(world, dest[0] - 1, dest[1], dest[2] + 0, dest[0] - 4, dest[1], dest[2] - 3, this.treeBlock, this.branchMeta, true);
        this.drawBresehnam(world, dest[0] + 0, dest[1], dest[2] + 1, dest[0] - 3, dest[1], dest[2] + 4, this.treeBlock, this.branchMeta, true);
        this.drawBresehnam(world, dest[0] + 0, dest[1], dest[2] - 1, dest[0] + 3, dest[1], dest[2] - 4, this.treeBlock, this.branchMeta, true);
        this.drawCircle(world, dest[0], dest[1] - 2, dest[2], 4, this.leafBlock, this.leafMeta, false);
        this.drawCircle(world, dest[0], dest[1] - 1, dest[2], 7, this.leafBlock, this.leafMeta, false);
        this.drawCircle(world, dest[0], dest[1], dest[2], 8, this.leafBlock, this.leafMeta, false);
        this.drawCircle(world, dest[0], dest[1] + 1, dest[2], 6, this.leafBlock, this.leafMeta, false);
        this.drawCircle(world, dest[0], dest[1] + 2, dest[2], 3, this.leafBlock, this.leafMeta, false);
    }
    
    void buildTrunk(final World world, final int x, final int y, final int z, final int height, final double length, final double angle, final double tilt, final boolean firefly) {
        final int[] src = { x, y + height, z };
        final int[] dest = TFGenerator.translate(src[0], src[1], src[2], length, angle, tilt);
        for (int dy = -6; dy < 0; ++dy) {
            this.drawRootBlock(world, x, y + dy, z);
            this.drawRootBlock(world, x + 1, y + dy, z);
            this.drawRootBlock(world, x, y + dy, z + 1);
            this.drawRootBlock(world, x + 1, y + dy, z + 1);
        }
        this.drawBresehnam(world, src[0], src[1], src[2], dest[0], dest[1], dest[2], this.treeBlock, this.treeMeta, true);
        this.drawBresehnam(world, src[0] + 1, src[1], src[2], dest[0] + 1, dest[1], dest[2], this.treeBlock, this.treeMeta, true);
        this.drawBresehnam(world, src[0] + 1, src[1], src[2] + 1, dest[0] + 1, dest[1], dest[2] + 1, this.treeBlock, this.treeMeta, true);
        this.drawBresehnam(world, src[0], src[1], src[2] + 1, dest[0], dest[1], dest[2] + 1, this.treeBlock, this.treeMeta, true);
        this.makeLeafNode(world, dest);
    }
    
    private void drawRootBlock(final World world, final int dx, final int dy, final int dz) {
        if (this.hasAirAround((IBlockAccess)world, dx, dy, dz)) {
            this.func_76485_a(world, dx, dy, dz, this.treeBlock, this.branchMeta);
        }
        else {
            this.func_76485_a(world, dx, dy, dz, this.rootBlock, this.rootMeta);
        }
    }
    
    private void buildRoot(final World world, final int x, final int y, final int z, final double offset, final int b) {
        final int[] dest = TFGenerator.translate(x, y - b - 2, z, 8.0, 0.278 * b + offset, 0.8);
        this.drawRoot(world, x, y - b - 2, z, dest[0], dest[1], dest[2]);
    }
    
    protected void drawRoot(final World world, final int sx, final int sy, final int sz, final int dx, final int dy, final int dz) {
        if (world.func_72803_f(dx, dy, dz).func_76220_a()) {
            this.drawBresehnam(world, sx, sy, sz, dx, dy, dz, this.rootBlock, this.rootMeta, true);
        }
        else {
            final int[] lineArray = TFGenerator.getBresehnamArray(sx, sy, sz, dx, dy, dz);
            for (int i = 0; i < lineArray.length; i += 3) {
                if (world.func_72798_a(lineArray[i + 0], lineArray[i + 1], lineArray[i + 2]) > 0 || this.isNearSolid((IBlockAccess)world, lineArray[i + 0], lineArray[i + 1], lineArray[i + 2])) {
                    this.func_76485_a(world, lineArray[i + 0], lineArray[i + 1], lineArray[i + 2], this.rootBlock, this.rootMeta);
                }
            }
        }
    }
}
