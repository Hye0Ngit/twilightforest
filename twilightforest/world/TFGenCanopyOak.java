// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import net.minecraft.util.ChunkCoordinates;
import net.minecraft.block.material.Material;
import java.util.Random;
import net.minecraft.world.World;
import twilightforest.block.TFBlocks;

public class TFGenCanopyOak extends TFGenCanopyTree
{
    public TFGenCanopyOak() {
        this(false);
    }
    
    public TFGenCanopyOak(final boolean par1) {
        super(par1);
        this.treeBlock = TFBlocks.log;
        this.treeMeta = 0;
        this.branchMeta = 12;
        this.leafBlock = TFBlocks.leaves;
        this.leafMeta = 0;
        this.rootBlock = TFBlocks.root;
        this.rootMeta = 0;
    }
    
    @Override
    public boolean func_76484_a(final World world, final Random random, final int x, final int y, final int z) {
        final Material materialUnder = world.func_147439_a(x, y - 1, z).func_149688_o();
        if ((materialUnder != Material.field_151577_b && materialUnder != Material.field_151578_c) || y >= TFWorld.MAXHEIGHT - 12) {
            return false;
        }
        int treeHeight = this.minHeight;
        if (random.nextInt(this.chanceAddFirstFive) == 0) {
            treeHeight += random.nextInt(5);
            if (random.nextInt(this.chanceAddSecondFive) == 0) {
                treeHeight += random.nextInt(5);
            }
        }
        this.buildTrunk(world, x, y, z, treeHeight);
        final int numBranches = 12 + random.nextInt(9);
        float bangle = random.nextFloat();
        for (int b = 0; b < numBranches; ++b) {
            final float btilt = 0.15f + random.nextFloat() * 0.35f;
            this.buildBranch(world, x, y, z, treeHeight - 10 + b / 2, 5.0, bangle, btilt, false, random);
            bangle += random.nextFloat() * 0.4f;
            if (bangle > 1.0f) {
                --bangle;
            }
        }
        this.makeRoots(world, random, x + 0, y, z + 0);
        this.makeRoots(world, random, x + 1, y, z + 0);
        this.makeRoots(world, random, x + 0, y, z + 1);
        this.makeRoots(world, random, x + 1, y, z + 1);
        return true;
    }
    
    private void makeRoots(final World world, final Random random, final int x, final int y, final int z) {
        if (TFTreeGenerator.hasAirAround(world, x, y - 1, z)) {
            this.setBlockAndMetadata(world, x, y - 1, z, this.treeBlock, this.treeMeta);
        }
        else {
            this.setBlockAndMetadata(world, x, y - 1, z, this.rootBlock, this.rootMeta);
        }
        final int numRoots = 1 + random.nextInt(2);
        final float offset = random.nextFloat();
        for (int b = 0; b < numRoots; ++b) {
            this.buildRoot(world, x, y, z, offset, b);
        }
    }
    
    private void buildTrunk(final World world, final int sx, final int sy, final int sz, final int treeHeight) {
        for (int dy = 0; dy < treeHeight; ++dy) {
            this.setBlockAndMetadata(world, sx + 0, sy + dy, sz + 0, this.treeBlock, this.treeMeta);
            this.setBlockAndMetadata(world, sx + 1, sy + dy, sz + 0, this.treeBlock, this.treeMeta);
            this.setBlockAndMetadata(world, sx + 0, sy + dy, sz + 1, this.treeBlock, this.treeMeta);
            this.setBlockAndMetadata(world, sx + 1, sy + dy, sz + 1, this.treeBlock, this.treeMeta);
        }
        this.drawLeafBlob(world, sx + 0, sy + treeHeight, sz + 0, 3, this.leafBlock, this.leafMeta);
    }
    
    @Override
    void buildBranch(final World world, final int x, final int y, final int z, final int height, final double length, final double angle, final double tilt, final boolean trunk, final Random treeRNG) {
        final ChunkCoordinates src = new ChunkCoordinates(x, y + height, z);
        final ChunkCoordinates dest = TFTreeGenerator.translateCoords(src.field_71574_a, src.field_71572_b, src.field_71573_c, length, angle, tilt);
        final int limit = 5;
        if (dest.field_71574_a - x < -limit) {
            dest.field_71574_a = x - limit;
        }
        if (dest.field_71574_a - x > limit) {
            dest.field_71574_a = x + limit;
        }
        if (dest.field_71573_c - z < -limit) {
            dest.field_71573_c = z - limit;
        }
        if (dest.field_71573_c - z > limit) {
            dest.field_71573_c = z + limit;
        }
        this.drawBresehnam(world, src.field_71574_a, src.field_71572_b, src.field_71573_c, dest.field_71574_a, dest.field_71572_b, dest.field_71573_c, this.treeBlock, trunk ? this.treeMeta : this.branchMeta);
        if (trunk) {
            this.addFirefly(world, x, y, z, 3 + treeRNG.nextInt(7), treeRNG.nextDouble());
        }
        final int blobSize = 2;
        this.drawLeafBlob(world, dest.field_71574_a, dest.field_71572_b, dest.field_71573_c, blobSize, this.leafBlock, this.leafMeta);
        this.setBlockAndMetadata(world, dest.field_71574_a + 1, dest.field_71572_b, dest.field_71573_c, this.treeBlock, this.branchMeta);
        this.setBlockAndMetadata(world, dest.field_71574_a - 1, dest.field_71572_b, dest.field_71573_c, this.treeBlock, this.branchMeta);
        this.setBlockAndMetadata(world, dest.field_71574_a, dest.field_71572_b, dest.field_71573_c + 1, this.treeBlock, this.branchMeta);
        this.setBlockAndMetadata(world, dest.field_71574_a, dest.field_71572_b, dest.field_71573_c - 1, this.treeBlock, this.branchMeta);
    }
}
