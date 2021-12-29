// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import net.minecraft.util.ChunkCoordinates;
import net.minecraft.block.material.Material;
import java.util.Random;
import net.minecraft.world.World;
import twilightforest.block.TFBlocks;

public class TFGenCanopyTree extends TFTreeGenerator
{
    protected int minHeight;
    protected int chanceAddFirstFive;
    protected int chanceAddSecondFive;
    
    public TFGenCanopyTree() {
        this(false);
    }
    
    public TFGenCanopyTree(final boolean par1) {
        super(par1);
        this.minHeight = 20;
        this.chanceAddFirstFive = 3;
        this.chanceAddSecondFive = 8;
        this.treeBlock = TFBlocks.log;
        this.treeMeta = 1;
        this.branchMeta = 13;
        this.leafBlock = TFBlocks.leaves;
        this.leafMeta = 1;
        this.rootBlock = TFBlocks.root;
        this.rootMeta = 0;
    }
    
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
        this.buildBranch(world, x, y, z, 0, treeHeight, 0.0, 0.0, true, random);
        final int numBranches = 3 + random.nextInt(2);
        float offset = random.nextFloat();
        for (int b = 0; b < numBranches; ++b) {
            this.buildBranch(world, x, y, z, treeHeight - 10 + b, 9.0, 0.3 * b + offset, 0.2, false, random);
        }
        if (TFTreeGenerator.hasAirAround(world, x, y - 1, z)) {
            this.setBlockAndMetadata(world, x, y - 1, z, this.treeBlock, this.treeMeta);
        }
        else {
            this.setBlockAndMetadata(world, x, y - 1, z, this.rootBlock, this.rootMeta);
        }
        final int numRoots = 3 + random.nextInt(2);
        offset = random.nextFloat();
        for (int b2 = 0; b2 < numRoots; ++b2) {
            this.buildRoot(world, x, y, z, offset, b2);
        }
        return true;
    }
    
    void buildBranch(final World world, final int x, final int y, final int z, final int height, final double length, final double angle, final double tilt, final boolean trunk, final Random treeRNG) {
        final ChunkCoordinates src = new ChunkCoordinates(x, y + height, z);
        final ChunkCoordinates dest = TFTreeGenerator.translateCoords(src.field_71574_a, src.field_71572_b, src.field_71573_c, length, angle, tilt);
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
        this.drawBresehnam(world, src.field_71574_a, src.field_71572_b, src.field_71573_c, dest.field_71574_a, dest.field_71572_b, dest.field_71573_c, this.treeBlock, trunk ? this.treeMeta : this.branchMeta);
        if (trunk) {
            this.addFirefly(world, x, y, z, 3 + treeRNG.nextInt(7), treeRNG.nextDouble());
        }
        this.makeLeafCircle(world, dest.field_71574_a, dest.field_71572_b - 1, dest.field_71573_c, 3, this.leafBlock, this.leafMeta, true);
        this.makeLeafCircle(world, dest.field_71574_a, dest.field_71572_b, dest.field_71573_c, 4, this.leafBlock, this.leafMeta, true);
        this.makeLeafCircle(world, dest.field_71574_a, dest.field_71572_b + 1, dest.field_71573_c, 2, this.leafBlock, this.leafMeta, true);
        this.setBlockAndMetadata(world, dest.field_71574_a + 1, dest.field_71572_b, dest.field_71573_c, this.treeBlock, this.branchMeta);
        this.setBlockAndMetadata(world, dest.field_71574_a - 1, dest.field_71572_b, dest.field_71573_c, this.treeBlock, this.branchMeta);
        this.setBlockAndMetadata(world, dest.field_71574_a, dest.field_71572_b, dest.field_71573_c + 1, this.treeBlock, this.branchMeta);
        this.setBlockAndMetadata(world, dest.field_71574_a, dest.field_71572_b, dest.field_71573_c - 1, this.treeBlock, this.branchMeta);
    }
    
    protected void addFirefly(final World world, final int x, final int y, final int z, final int height, final double angle) {
        final int iAngle = (int)(angle * 4.0);
        if (iAngle == 0) {
            this.setBlockAndMetadata(world, x + 1, y + height, z, TFBlocks.firefly, 0);
        }
        else if (iAngle == 1) {
            this.setBlockAndMetadata(world, x - 1, y + height, z, TFBlocks.firefly, 0);
        }
        else if (iAngle == 2) {
            this.setBlockAndMetadata(world, x, y + height, z + 1, TFBlocks.firefly, 0);
        }
        else if (iAngle == 3) {
            this.setBlockAndMetadata(world, x, y + height, z - 1, TFBlocks.firefly, 0);
        }
    }
}
