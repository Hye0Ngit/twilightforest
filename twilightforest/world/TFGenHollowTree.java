// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import twilightforest.TFTreasure;
import net.minecraft.util.Direction;
import twilightforest.entity.TFCreatures;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.IBlockAccess;
import net.minecraft.init.Blocks;
import java.util.Random;
import net.minecraft.world.World;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;

public class TFGenHollowTree extends TFGenerator
{
    private static final int LEAF_DUNGEON_CHANCE = 8;
    protected Block treeBlock;
    protected int treeMeta;
    protected int branchMeta;
    protected Block leafBlock;
    protected int leafMeta;
    protected Block rootBlock;
    protected int rootMeta;
    
    public TFGenHollowTree() {
        this(false);
    }
    
    public TFGenHollowTree(final boolean par1) {
        super(par1);
        this.treeBlock = TFBlocks.log;
        this.treeMeta = 0;
        this.branchMeta = 12;
        this.leafBlock = TFBlocks.leaves;
        this.leafMeta = 0;
        this.rootBlock = TFBlocks.root;
        this.rootMeta = 0;
    }
    
    public boolean func_76484_a(final World world, final Random random, final int x, final int y, final int z) {
        final int height = random.nextInt(64) + 32;
        final int diameter = random.nextInt(4) + 1;
        if (y < 1 || y + height + diameter > TFWorld.MAXHEIGHT) {
            return false;
        }
        for (int crownRadius = diameter * 4 + 8, dx = -crownRadius; dx <= crownRadius; ++dx) {
            for (int dz = -crownRadius; dz <= crownRadius; ++dz) {
                for (int dy = height - crownRadius; dy <= height + crownRadius; ++dy) {
                    final Block whatsThere = world.func_147439_a(dx + x, dy + y, dz + z);
                    if (whatsThere != Blocks.field_150350_a && whatsThere != Blocks.field_150362_t) {
                        return false;
                    }
                }
            }
        }
        final Block j1 = world.func_147439_a(x, y - 1, z);
        if (j1 != Blocks.field_150349_c && j1 != Blocks.field_150346_d) {
            return false;
        }
        this.buildTrunk(world, random, x, y, z, diameter, height);
        for (int numFireflies = random.nextInt(3 * diameter) + 5, i = 0; i <= numFireflies; ++i) {
            final int fHeight = (int)(height * random.nextDouble() * 0.9) + height / 10;
            final double fAngle = random.nextDouble();
            this.addFirefly(world, x, y, z, diameter, fHeight, fAngle);
        }
        for (int numFireflies = random.nextInt(3 * diameter) + 5, i = 0; i <= numFireflies; ++i) {
            final int fHeight = (int)(height * random.nextDouble() * 0.9) + height / 10;
            final double fAngle = random.nextDouble();
            this.addCicada(world, x, y, z, diameter, fHeight, fAngle);
        }
        this.buildFullCrown(world, random, x, y, z, diameter, height);
        for (int numBranches = random.nextInt(3) + 3, k = 0; k <= numBranches; ++k) {
            final int branchHeight = (int)(height * random.nextDouble() * 0.9) + height / 10;
            final double branchRotation = random.nextDouble();
            this.makeSmallBranch(world, random, x, y, z, diameter, branchHeight, 4.0, branchRotation, 0.35, true);
        }
        this.buildBranchRing(world, random, x, y, z, diameter, 3, 2, 6, 0, 0.75, 0.0, 3, 5, 3, false);
        this.buildBranchRing(world, random, x, y, z, diameter, 1, 2, 8, 0, 0.9, 0.0, 3, 5, 3, false);
        return true;
    }
    
    protected void buildFullCrown(final World world, final Random random, final int x, final int y, final int z, final int diameter, final int height) {
        final int crownRadius = diameter * 4 + 4;
        final int bvar = diameter + 2;
        this.buildBranchRing(world, random, x, y, z, diameter, height - crownRadius, 0, crownRadius, 0, 0.35, 0.0, bvar, bvar + 2, 2, true);
        this.buildBranchRing(world, random, x, y, z, diameter, height - crownRadius / 2, 0, crownRadius, 0, 0.28, 0.0, bvar, bvar + 2, 1, true);
        this.buildBranchRing(world, random, x, y, z, diameter, height, 0, crownRadius, 0, 0.15, 0.0, 2, 4, 2, true);
        this.buildBranchRing(world, random, x, y, z, diameter, height, 0, crownRadius / 2, 0, 0.05, 0.0, bvar, bvar + 2, 1, true);
    }
    
    protected void buildWeakCrown(final World world, final Random random, final int x, final int y, final int z, final int diameter, final int height) {
        final int crownRadius = 8;
        final int bvar = 2;
        this.buildBranchRing(world, random, x, y, z, diameter, height - crownRadius, 0, crownRadius, 0, 0.35, 0.0, bvar, bvar + 2, 1, true);
        this.buildBranchRing(world, random, x, y, z, diameter, height - crownRadius / 2, 0, crownRadius, 0, 0.28, 0.0, bvar, bvar + 2, 1, true);
        this.buildBranchRing(world, random, x, y, z, diameter, height, 0, crownRadius, 0, 0.15, 0.0, 2, 4, 1, true);
        this.buildBranchRing(world, random, x, y, z, diameter, height, 0, crownRadius / 2, 0, 0.05, 0.0, bvar, bvar + 2, 1, true);
    }
    
    protected void buildBranchRing(final World world, final Random random, final int x, final int y, final int z, final int diameter, final int branchHeight, final int heightVar, final int length, final int lengthVar, final double tilt, final double tiltVar, final int minBranches, final int maxBranches, final int size, final boolean leafy) {
        final int numBranches = random.nextInt(maxBranches - minBranches) + minBranches;
        final double branchRotation = 1.0 / (numBranches + 1);
        final double branchOffset = random.nextDouble();
        for (int i = 0; i <= numBranches; ++i) {
            int dHeight;
            if (heightVar > 0) {
                dHeight = branchHeight - heightVar + random.nextInt(2 * heightVar);
            }
            else {
                dHeight = branchHeight;
            }
            if (size == 2) {
                this.makeLargeBranch(world, random, x, y, z, diameter, dHeight, length, i * branchRotation + branchOffset, tilt, leafy);
            }
            else if (size == 1) {
                this.makeMedBranch(world, random, x, y, z, diameter, dHeight, length, i * branchRotation + branchOffset, tilt, leafy);
            }
            else if (size == 3) {
                this.makeRoot(world, random, x, y, z, diameter, dHeight, length, i * branchRotation + branchOffset, tilt);
            }
            else {
                this.makeSmallBranch(world, random, x, y, z, diameter, dHeight, length, i * branchRotation + branchOffset, tilt, leafy);
            }
        }
    }
    
    protected void buildTrunk(final World world, final Random random, final int x, final int y, final int z, final int diameter, final int height) {
        final int hollow = diameter / 2;
        for (int dx = -diameter; dx <= diameter; ++dx) {
            for (int dz = -diameter; dz <= diameter; ++dz) {
                for (int dy = -4; dy < 0; ++dy) {
                    final int ax = Math.abs(dx);
                    final int az = Math.abs(dz);
                    final int dist = (int)(Math.max(ax, az) + Math.min(ax, az) * 0.5);
                    if (dist <= diameter) {
                        if (TFGenerator.hasAirAround((IBlockAccess)world, dx + x, dy + y, dz + z)) {
                            this.setBlockAndMetadata(world, dx + x, dy + y, dz + z, this.treeBlock, (dist > hollow) ? this.treeMeta : this.branchMeta);
                        }
                        else {
                            this.setBlockAndMetadata(world, dx + x, dy + y, dz + z, this.rootBlock, this.rootMeta);
                        }
                    }
                }
            }
        }
        for (int dx = -diameter; dx <= diameter; ++dx) {
            for (int dz = -diameter; dz <= diameter; ++dz) {
                for (int dy = 0; dy <= height; ++dy) {
                    final int ax = Math.abs(dx);
                    final int az = Math.abs(dz);
                    final int dist = (int)(Math.max(ax, az) + Math.min(ax, az) * 0.5);
                    if (dist <= diameter && dist > hollow) {
                        this.setBlockAndMetadata(world, dx + x, dy + y, dz + z, this.treeBlock, this.treeMeta);
                    }
                    if (dist <= hollow) {}
                    if (dist == hollow && dx == hollow) {
                        this.setBlockAndMetadata(world, dx + x, dy + y, dz + z, Blocks.field_150395_bd, 8);
                    }
                }
            }
        }
    }
    
    protected void makeMedBranch(final World world, final Random random, final int x, final int y, final int z, final int diameter, final int branchHeight, final double length, final double angle, final double tilt, final boolean leafy) {
        final int sx = x;
        final int sy = y + branchHeight;
        final int sz = z;
        final int[] src = TFGenerator.translate(sx, sy, sz, diameter, angle, 0.5);
        this.makeMedBranch(world, random, src[0], src[1], src[2], length, angle, tilt, leafy);
    }
    
    protected void makeMedBranch(final World world, final Random random, final int sx, final int sy, final int sz, final double length, final double angle, final double tilt, final boolean leafy) {
        final int[] src = { sx, sy, sz };
        final int[] dest = TFGenerator.translate(src[0], src[1], src[2], length, angle, tilt);
        this.drawBresehnam(world, src[0], src[1], src[2], dest[0], dest[1], dest[2], this.treeBlock, this.branchMeta);
        if (leafy) {
            this.drawLeafBlob(world, dest[0], dest[1], dest[2], 2, this.leafBlock, this.leafMeta);
        }
        final int numShoots = random.nextInt(2) + 1;
        final double angleInc = 0.8 / numShoots;
        for (int i = 0; i <= numShoots; ++i) {
            final double angleVar = angleInc * i - 0.4;
            final double outVar = random.nextDouble() * 0.8 + 0.2;
            final double tiltVar = random.nextDouble() * 0.75 + 0.15;
            final int[] bsrc = TFGenerator.translate(src[0], src[1], src[2], length * outVar, angle, tilt);
            final double slength = length * 0.4;
            this.makeSmallBranch(world, random, bsrc[0], bsrc[1], bsrc[2], slength, angle + angleVar, tilt * tiltVar, leafy);
        }
    }
    
    protected void makeSmallBranch(final World world, final Random random, final int sx, final int sy, final int sz, final double length, final double angle, final double tilt, final boolean leafy) {
        final int[] src = { sx, sy, sz };
        final int[] dest = TFGenerator.translate(src[0], src[1], src[2], length, angle, tilt);
        this.drawBresehnam(world, src[0], src[1], src[2], dest[0], dest[1], dest[2], this.treeBlock, this.branchMeta);
        if (leafy) {
            final byte leafRad = (byte)(random.nextInt(2) + 1);
            this.drawLeafBlob(world, dest[0], dest[1], dest[2], leafRad, this.leafBlock, this.leafMeta);
        }
    }
    
    protected void makeSmallBranch(final World world, final Random random, final int x, final int y, final int z, final int diameter, final int branchHeight, final double length, final double angle, final double tilt, final boolean leafy) {
        final int sx = x;
        final int sy = y + branchHeight;
        final int sz = z;
        final int[] src = TFGenerator.translate(sx, sy, sz, diameter, angle, 0.5);
        this.makeSmallBranch(world, random, src[0], src[1], src[2], length, angle, tilt, leafy);
    }
    
    protected void makeRoot(final World world, final Random random, final int x, final int y, final int z, final int diameter, final int branchHeight, final double length, final double angle, final double tilt) {
        final ChunkCoordinates src = TFGenerator.translateCoords(x, y + branchHeight, z, diameter, angle, 0.5);
        final ChunkCoordinates dest = TFGenerator.translateCoords(src.field_71574_a, src.field_71572_b, src.field_71573_c, length, angle, tilt);
        final ChunkCoordinates[] lineArray = TFGenerator.getBresehnamArrayCoords(src, dest);
        boolean stillAboveGround = true;
        for (final ChunkCoordinates coord : lineArray) {
            if (stillAboveGround && TFGenerator.hasAirAround((IBlockAccess)world, coord.field_71574_a, coord.field_71572_b, coord.field_71573_c)) {
                this.setBlockAndMetadata(world, coord.field_71574_a, coord.field_71572_b, coord.field_71573_c, this.treeBlock, this.branchMeta);
                this.setBlockAndMetadata(world, coord.field_71574_a, coord.field_71572_b - 1, coord.field_71573_c, this.treeBlock, this.branchMeta);
            }
            else {
                this.setBlockAndMetadata(world, coord.field_71574_a, coord.field_71572_b, coord.field_71573_c, this.rootBlock, this.rootMeta);
                this.setBlockAndMetadata(world, coord.field_71574_a, coord.field_71572_b - 1, coord.field_71573_c, this.rootBlock, this.rootMeta);
                stillAboveGround = false;
            }
        }
    }
    
    protected void makeLargeBranch(final World world, final Random random, final int sx, final int sy, final int sz, final double length, final double angle, final double tilt, final boolean leafy) {
        final int[] src = { sx, sy, sz };
        final int[] dest = TFGenerator.translate(src[0], src[1], src[2], length, angle, tilt);
        this.drawBresehnam(world, src[0], src[1], src[2], dest[0], dest[1], dest[2], this.treeBlock, this.branchMeta);
        for (int reinforcements = random.nextInt(3), i = 0; i <= reinforcements; ++i) {
            final int vx = ((i & 0x2) == 0x0) ? 1 : 0;
            final int vy = ((i & 0x1) == 0x0) ? 1 : -1;
            final int vz = ((i & 0x2) != 0x0) ? 1 : 0;
            this.drawBresehnam(world, src[0] + vx, src[1] + vy, src[2] + vz, dest[0], dest[1], dest[2], this.treeBlock, this.branchMeta);
        }
        if (leafy) {
            this.drawLeafBlob(world, dest[0], dest[1] + 1, dest[2], 3, this.leafBlock, this.leafMeta);
        }
        for (int numMedBranches = random.nextInt((int)(length / 6.0)) + random.nextInt(2) + 1, j = 0; j <= numMedBranches; ++j) {
            final double outVar = random.nextDouble() * 0.3 + 0.3;
            final double angleVar = random.nextDouble() * 0.225 * (((j & 0x1) == 0x0) ? 1.0 : -1.0);
            final int[] bsrc = TFGenerator.translate(src[0], src[1], src[2], length * outVar, angle, tilt);
            this.makeMedBranch(world, random, bsrc[0], bsrc[1], bsrc[2], length * 0.6, angle + angleVar, tilt, leafy);
        }
        for (int numSmallBranches = random.nextInt(2) + 1, k = 0; k <= numSmallBranches; ++k) {
            final double outVar2 = random.nextDouble() * 0.25 + 0.25;
            final double angleVar2 = random.nextDouble() * 0.25 * (((k & 0x1) == 0x0) ? 1.0 : -1.0);
            final int[] bsrc2 = TFGenerator.translate(src[0], src[1], src[2], length * outVar2, angle, tilt);
            this.makeSmallBranch(world, random, bsrc2[0], bsrc2[1], bsrc2[2], Math.max(length * 0.3, 2.0), angle + angleVar2, tilt, leafy);
        }
        if (random.nextInt(8) == 0) {
            this.makeLeafDungeon(world, random, dest[0], dest[1] + 1, dest[2]);
        }
    }
    
    private void makeLeafDungeon(final World world, final Random random, final int x, final int y, final int z) {
        this.drawLeafBlob(world, x, y, z, 4, this.leafBlock, this.leafMeta);
        this.drawBlob(world, x, y, z, 3, this.treeBlock, this.branchMeta);
        this.drawBlob(world, x, y, z, 2, Blocks.field_150350_a, 0);
        world.func_147465_d(x + 0, y + 1, z + 0, Blocks.field_150474_ac, 0, 2);
        final TileEntityMobSpawner ms = (TileEntityMobSpawner)world.func_147438_o(x + 0, y + 1, z + 0);
        if (ms != null) {
            ms.func_145881_a().func_98272_a(TFCreatures.getSpawnerNameFor("Swarm Spider"));
        }
        this.makeLeafDungeonChest(world, random, x, y, z);
    }
    
    private void makeLeafDungeonChest(final World world, final Random random, int x, final int y, int z) {
        final int dir = random.nextInt(4);
        x += Direction.field_71583_a[dir];
        x += Direction.field_71583_a[dir];
        z += Direction.field_71581_b[dir];
        z += Direction.field_71581_b[dir];
        TFTreasure.tree_cache.generate(world, random, x, y - 1, z);
    }
    
    protected void makeLargeBranch(final World world, final Random random, final int x, final int y, final int z, final int diameter, final int branchHeight, final double length, final double angle, final double tilt, final boolean leafy) {
        final int sx = x;
        final int sy = y + branchHeight;
        final int sz = z;
        final int[] src = TFGenerator.translate(sx, sy, sz, diameter, angle, 0.5);
        this.makeLargeBranch(world, random, src[0], src[1], src[2], length, angle, tilt, leafy);
    }
    
    protected void addFirefly(final World world, final int x, final int y, final int z, final int diameter, final int fHeight, double fAngle) {
        final int[] src = TFGenerator.translate(x, y + fHeight, z, diameter + 1, fAngle, 0.5);
        fAngle %= 1.0;
        int tmeta = 0;
        if (fAngle > 0.875 || fAngle <= 0.125) {
            tmeta = 3;
        }
        else if (fAngle > 0.125 && fAngle <= 0.375) {
            tmeta = 1;
        }
        else if (fAngle > 0.375 && fAngle <= 0.625) {
            tmeta = 4;
        }
        else if (fAngle > 0.625 && fAngle <= 0.875) {
            tmeta = 2;
        }
        if (TFBlocks.firefly.func_149742_c(world, src[0], src[1], src[2])) {
            this.setBlockAndMetadata(world, src[0], src[1], src[2], TFBlocks.firefly, tmeta);
        }
    }
    
    protected void addCicada(final World world, final int x, final int y, final int z, final int diameter, final int fHeight, double fAngle) {
        final int[] src = TFGenerator.translate(x, y + fHeight, z, diameter + 1, fAngle, 0.5);
        fAngle %= 1.0;
        int tmeta = 1;
        if (fAngle > 0.875 || fAngle <= 0.125) {
            tmeta = 3;
        }
        else if (fAngle > 0.125 && fAngle <= 0.375) {
            tmeta = 1;
        }
        else if (fAngle > 0.375 && fAngle <= 0.625) {
            tmeta = 4;
        }
        else if (fAngle > 0.625 && fAngle <= 0.875) {
            tmeta = 2;
        }
        if (TFBlocks.cicada.func_149742_c(world, src[0], src[1], src[2])) {
            this.setBlockAndMetadata(world, src[0], src[1], src[2], TFBlocks.cicada, tmeta);
        }
    }
}
