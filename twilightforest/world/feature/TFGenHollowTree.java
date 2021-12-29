// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.feature;

import net.minecraft.block.BlockDirectional;
import twilightforest.loot.TFTreasure;
import net.minecraft.entity.EntityList;
import twilightforest.entity.EntityTFSwarmSpider;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.EnumFacing;
import net.minecraft.init.Blocks;
import java.util.Random;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.BlockVine;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockLog;
import twilightforest.block.BlockTFLog;
import twilightforest.block.TFBlocks;
import net.minecraftforge.common.IPlantable;
import net.minecraft.block.state.IBlockState;

public class TFGenHollowTree extends TFGenerator
{
    private static final int LEAF_DUNGEON_CHANCE = 8;
    protected IBlockState treeState;
    protected IBlockState branchState;
    protected IBlockState leafState;
    protected IBlockState rootState;
    protected IPlantable source;
    
    public TFGenHollowTree() {
        this(false);
    }
    
    public TFGenHollowTree(final boolean notify) {
        super(notify);
        this.treeState = TFBlocks.twilight_log.func_176223_P();
        this.branchState = this.treeState.func_177226_a((IProperty)BlockTFLog.field_176299_a, (Comparable)BlockLog.EnumAxis.NONE);
        this.leafState = TFBlocks.twilight_leaves.func_176223_P().func_177226_a((IProperty)BlockLeaves.field_176236_b, (Comparable)false);
        this.rootState = TFBlocks.root.func_176223_P();
        this.source = (IPlantable)TFBlocks.twilight_sapling;
    }
    
    public static boolean canGrowInto(final Block blockType) {
        final Material material = blockType.func_176223_P().func_185904_a();
        return material == Material.field_151579_a || material == Material.field_151584_j || material == Material.field_151586_h || material == Material.field_151587_i || blockType instanceof IGrowable || blockType instanceof BlockDirt || blockType instanceof BlockLog || blockType instanceof BlockBush || blockType instanceof BlockVine;
    }
    
    protected void func_175903_a(final World worldIn, final BlockPos pos, final IBlockState state) {
        if (canGrowInto(worldIn.func_180495_p(pos).func_177230_c())) {
            super.func_175903_a(worldIn, pos, state);
        }
    }
    
    public boolean func_180709_b(final World world, final Random random, final BlockPos pos) {
        final int height = random.nextInt(64) + 32;
        final int diameter = random.nextInt(4) + 1;
        if (pos.func_177956_o() < 1 || pos.func_177956_o() + height + diameter > 256) {
            return false;
        }
        for (int crownRadius = diameter * 4 + 8, dx = -crownRadius; dx <= crownRadius; ++dx) {
            for (int dz = -crownRadius; dz <= crownRadius; ++dz) {
                for (int dy = height - crownRadius; dy <= height + crownRadius; ++dy) {
                    final Block whatsThere = world.func_180495_p(pos.func_177982_a(dx, dy, dz)).func_177230_c();
                    if (whatsThere != Blocks.field_150350_a && whatsThere != Blocks.field_150362_t) {
                        return false;
                    }
                }
            }
        }
        final IBlockState state = world.func_180495_p(pos.func_177977_b());
        if (!state.func_177230_c().canSustainPlant(state, (IBlockAccess)world, pos.func_177977_b(), EnumFacing.UP, this.source)) {
            return false;
        }
        this.buildTrunk(world, random, pos, diameter, height);
        for (int numFireflies = random.nextInt(3 * diameter) + 5, i = 0; i <= numFireflies; ++i) {
            final int fHeight = (int)(height * random.nextDouble() * 0.9) + height / 10;
            final double fAngle = random.nextDouble();
            this.addFirefly(world, pos, diameter, fHeight, fAngle);
        }
        for (int numFireflies = random.nextInt(3 * diameter) + 5, i = 0; i <= numFireflies; ++i) {
            final int fHeight = (int)(height * random.nextDouble() * 0.9) + height / 10;
            final double fAngle = random.nextDouble();
            this.addCicada(world, pos, diameter, fHeight, fAngle);
        }
        this.buildFullCrown(world, random, pos, diameter, height);
        for (int numBranches = random.nextInt(3) + 3, j = 0; j <= numBranches; ++j) {
            final int branchHeight = (int)(height * random.nextDouble() * 0.9) + height / 10;
            final double branchRotation = random.nextDouble();
            this.makeSmallBranch(world, random, pos, diameter, branchHeight, 4.0, branchRotation, 0.35, true);
        }
        this.buildBranchRing(world, random, pos, diameter, 3, 2, 6, 0, 0.75, 0.0, 3, 5, 3, false);
        this.buildBranchRing(world, random, pos, diameter, 1, 2, 8, 0, 0.9, 0.0, 3, 5, 3, false);
        return true;
    }
    
    protected void buildFullCrown(final World world, final Random random, final BlockPos pos, final int diameter, final int height) {
        final int crownRadius = diameter * 4 + 4;
        final int bvar = diameter + 2;
        this.buildBranchRing(world, random, pos, diameter, height - crownRadius, 0, crownRadius, 0, 0.35, 0.0, bvar, bvar + 2, 2, true);
        this.buildBranchRing(world, random, pos, diameter, height - crownRadius / 2, 0, crownRadius, 0, 0.28, 0.0, bvar, bvar + 2, 1, true);
        this.buildBranchRing(world, random, pos, diameter, height, 0, crownRadius, 0, 0.15, 0.0, 2, 4, 2, true);
        this.buildBranchRing(world, random, pos, diameter, height, 0, crownRadius / 2, 0, 0.05, 0.0, bvar, bvar + 2, 1, true);
    }
    
    protected void buildWeakCrown(final World world, final Random random, final BlockPos pos, final int diameter, final int height) {
        final int crownRadius = 8;
        final int bvar = 2;
        this.buildBranchRing(world, random, pos, diameter, height - crownRadius, 0, crownRadius, 0, 0.35, 0.0, bvar, bvar + 2, 1, true);
        this.buildBranchRing(world, random, pos, diameter, height - crownRadius / 2, 0, crownRadius, 0, 0.28, 0.0, bvar, bvar + 2, 1, true);
        this.buildBranchRing(world, random, pos, diameter, height, 0, crownRadius, 0, 0.15, 0.0, 2, 4, 1, true);
        this.buildBranchRing(world, random, pos, diameter, height, 0, crownRadius / 2, 0, 0.05, 0.0, bvar, bvar + 2, 1, true);
    }
    
    protected void buildBranchRing(final World world, final Random random, final BlockPos pos, final int diameter, final int branchHeight, final int heightVar, final int length, final int lengthVar, final double tilt, final double tiltVar, final int minBranches, final int maxBranches, final int size, final boolean leafy) {
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
                this.makeLargeBranch(world, random, pos, diameter, dHeight, length, i * branchRotation + branchOffset, tilt, leafy);
            }
            else if (size == 1) {
                this.makeMedBranch(world, random, pos, diameter, dHeight, length, i * branchRotation + branchOffset, tilt, leafy);
            }
            else if (size == 3) {
                this.makeRoot(world, random, pos, diameter, dHeight, length, i * branchRotation + branchOffset, tilt);
            }
            else {
                this.makeSmallBranch(world, random, pos, diameter, dHeight, length, i * branchRotation + branchOffset, tilt, leafy);
            }
        }
    }
    
    protected void buildTrunk(final World world, final Random random, final BlockPos pos, final int diameter, final int height) {
        final int hollow = diameter / 2;
        for (int dx = -diameter; dx <= diameter; ++dx) {
            for (int dz = -diameter; dz <= diameter; ++dz) {
                for (int dy = -4; dy < 0; ++dy) {
                    final int ax = Math.abs(dx);
                    final int az = Math.abs(dz);
                    final int dist = (int)(Math.max(ax, az) + Math.min(ax, az) * 0.5);
                    if (dist <= diameter) {
                        final BlockPos dPos = pos.func_177982_a(dx, dy, dz);
                        if (TFGenerator.hasAirAround(world, dPos)) {
                            this.func_175903_a(world, dPos, (dist > hollow) ? this.treeState : this.branchState);
                        }
                        else {
                            this.func_175903_a(world, dPos, this.rootState);
                        }
                    }
                }
            }
        }
        for (int dx = -diameter; dx <= diameter; ++dx) {
            for (int dz = -diameter; dz <= diameter; ++dz) {
                for (int dy = 0; dy <= height; ++dy) {
                    final BlockPos dPos2 = pos.func_177982_a(dx, dy, dz);
                    final int ax2 = Math.abs(dx);
                    final int az2 = Math.abs(dz);
                    final int dist2 = (int)(Math.max(ax2, az2) + Math.min(ax2, az2) * 0.5);
                    if (dist2 <= diameter && dist2 > hollow) {
                        this.func_175903_a(world, dPos2, this.treeState);
                    }
                    if (dist2 <= hollow) {}
                    if (dist2 == hollow && dx == hollow) {
                        this.func_175903_a(world, dPos2, Blocks.field_150395_bd.func_176223_P().func_177226_a((IProperty)BlockVine.field_176278_M, (Comparable)true));
                    }
                }
            }
        }
    }
    
    protected void makeMedBranch(final World world, final Random random, final BlockPos pos, final int diameter, final int branchHeight, final double length, final double angle, final double tilt, final boolean leafy) {
        final BlockPos src = TFGenerator.translate(pos.func_177981_b(branchHeight), diameter, angle, 0.5);
        this.makeMedBranch(world, random, src, length, angle, tilt, leafy);
    }
    
    protected void makeMedBranch(final World world, final Random random, final BlockPos src, final double length, final double angle, final double tilt, final boolean leafy) {
        final BlockPos dest = TFGenerator.translate(src, length, angle, tilt);
        TFGenerator.drawBresehnam(this, world, src, dest, this.branchState);
        if (leafy) {
            TFGenerator.drawLeafBlob(this, world, dest, 2, this.leafState);
        }
        final int numShoots = random.nextInt(2) + 1;
        final double angleInc = 0.8 / numShoots;
        for (int i = 0; i <= numShoots; ++i) {
            final double angleVar = angleInc * i - 0.4;
            final double outVar = random.nextDouble() * 0.8 + 0.2;
            final double tiltVar = random.nextDouble() * 0.75 + 0.15;
            final BlockPos bsrc = TFGenerator.translate(src, length * outVar, angle, tilt);
            final double slength = length * 0.4;
            this.makeSmallBranch(world, random, bsrc, slength, angle + angleVar, tilt * tiltVar, leafy);
        }
    }
    
    protected void makeSmallBranch(final World world, final Random random, final BlockPos src, final double length, final double angle, final double tilt, final boolean leafy) {
        final BlockPos dest = TFGenerator.translate(src, length, angle, tilt);
        TFGenerator.drawBresehnam(this, world, src, dest, this.branchState);
        if (leafy) {
            final byte leafRad = (byte)(random.nextInt(2) + 1);
            TFGenerator.drawLeafBlob(this, world, dest, leafRad, this.leafState);
        }
    }
    
    protected void makeSmallBranch(final World world, final Random random, final BlockPos pos, final int diameter, final int branchHeight, final double length, final double angle, final double tilt, final boolean leafy) {
        final BlockPos src = TFGenerator.translate(pos.func_177981_b(branchHeight), diameter, angle, 0.5);
        this.makeSmallBranch(world, random, src, length, angle, tilt, leafy);
    }
    
    protected void makeRoot(final World world, final Random random, final BlockPos pos, final int diameter, final int branchHeight, final double length, final double angle, final double tilt) {
        final BlockPos src = TFGenerator.translate(pos.func_177981_b(branchHeight), diameter, angle, 0.5);
        final BlockPos dest = TFGenerator.translate(src, length, angle, tilt);
        final BlockPos[] lineArray = TFGenerator.getBresehnamArrays(src, dest);
        boolean stillAboveGround = true;
        for (final BlockPos coord : lineArray) {
            if (stillAboveGround && TFGenerator.hasAirAround(world, coord)) {
                this.func_175903_a(world, coord, this.branchState);
                this.func_175903_a(world, coord.func_177977_b(), this.branchState);
            }
            else {
                this.func_175903_a(world, coord, this.rootState);
                this.func_175903_a(world, coord.func_177977_b(), this.rootState);
                stillAboveGround = false;
            }
        }
    }
    
    protected void makeLargeBranch(final World world, final Random random, final BlockPos src, final double length, final double angle, final double tilt, final boolean leafy) {
        final BlockPos dest = TFGenerator.translate(src, length, angle, tilt);
        TFGenerator.drawBresehnam(this, world, src, dest, this.branchState);
        for (int reinforcements = random.nextInt(3), i = 0; i <= reinforcements; ++i) {
            final int vx = ((i & 0x2) == 0x0) ? 1 : 0;
            final int vy = ((i & 0x1) == 0x0) ? 1 : -1;
            final int vz = ((i & 0x2) != 0x0) ? 1 : 0;
            TFGenerator.drawBresehnam(this, world, src.func_177982_a(vx, vy, vz), dest, this.branchState);
        }
        if (leafy) {
            TFGenerator.drawLeafBlob(this, world, dest.func_177984_a(), 3, this.leafState);
        }
        for (int numMedBranches = random.nextInt((int)(length / 6.0)) + random.nextInt(2) + 1, j = 0; j <= numMedBranches; ++j) {
            final double outVar = random.nextDouble() * 0.3 + 0.3;
            final double angleVar = random.nextDouble() * 0.225 * (((j & 0x1) == 0x0) ? 1.0 : -1.0);
            final BlockPos bsrc = TFGenerator.translate(src, length * outVar, angle, tilt);
            this.makeMedBranch(world, random, bsrc, length * 0.6, angle + angleVar, tilt, leafy);
        }
        for (int numSmallBranches = random.nextInt(2) + 1, k = 0; k <= numSmallBranches; ++k) {
            final double outVar2 = random.nextDouble() * 0.25 + 0.25;
            final double angleVar2 = random.nextDouble() * 0.25 * (((k & 0x1) == 0x0) ? 1.0 : -1.0);
            final BlockPos bsrc2 = TFGenerator.translate(src, length * outVar2, angle, tilt);
            this.makeSmallBranch(world, random, bsrc2, Math.max(length * 0.3, 2.0), angle + angleVar2, tilt, leafy);
        }
        if (random.nextInt(8) == 0) {
            this.makeLeafDungeon(world, random, dest.func_177984_a());
        }
    }
    
    private void makeLeafDungeon(final World world, final Random random, final BlockPos pos) {
        TFGenerator.drawLeafBlob(this, world, pos, 4, this.leafState);
        TFGenerator.drawBlob(this, world, pos, 3, this.branchState);
        TFGenerator.drawBlob(this, world, pos, 2, Blocks.field_150350_a.func_176223_P());
        world.func_180501_a(pos.func_177984_a(), Blocks.field_150474_ac.func_176223_P(), 18);
        final TileEntityMobSpawner ms = (TileEntityMobSpawner)world.func_175625_s(pos.func_177984_a());
        if (ms != null) {
            ms.func_145881_a().func_190894_a(EntityList.func_191306_a((Class)EntityTFSwarmSpider.class));
        }
        this.makeLeafDungeonChest(world, random, pos);
    }
    
    private void makeLeafDungeonChest(final World world, final Random random, BlockPos pos) {
        pos = pos.func_177972_a(EnumFacing.field_176754_o[random.nextInt(4)]);
        TFTreasure.tree_cache.generateChest(world, pos.func_177977_b(), false);
    }
    
    protected void makeLargeBranch(final World world, final Random random, final BlockPos pos, final int diameter, final int branchHeight, final double length, final double angle, final double tilt, final boolean leafy) {
        final BlockPos src = TFGenerator.translate(pos.func_177981_b(branchHeight), diameter, angle, 0.5);
        this.makeLargeBranch(world, random, src, length, angle, tilt, leafy);
    }
    
    protected void addFirefly(final World world, final BlockPos pos, final int diameter, final int fHeight, double fAngle) {
        final BlockPos src = TFGenerator.translate(pos.func_177981_b(fHeight), diameter + 1, fAngle, 0.5);
        fAngle %= 1.0;
        EnumFacing facing = EnumFacing.EAST;
        if (fAngle > 0.875 || fAngle <= 0.125) {
            facing = EnumFacing.SOUTH;
        }
        else if (fAngle > 0.125 && fAngle <= 0.375) {
            facing = EnumFacing.EAST;
        }
        else if (fAngle > 0.375 && fAngle <= 0.625) {
            facing = EnumFacing.NORTH;
        }
        else if (fAngle > 0.625 && fAngle <= 0.875) {
            facing = EnumFacing.WEST;
        }
        if (TFBlocks.firefly.func_176196_c(world, src)) {
            this.func_175903_a(world, src, TFBlocks.firefly.func_176223_P().func_177226_a((IProperty)BlockDirectional.field_176387_N, (Comparable)facing));
        }
    }
    
    protected void addCicada(final World world, final BlockPos pos, final int diameter, final int fHeight, double fAngle) {
        final BlockPos src = TFGenerator.translate(pos.func_177981_b(fHeight), diameter + 1, fAngle, 0.5);
        fAngle %= 1.0;
        EnumFacing facing = EnumFacing.EAST;
        if (fAngle > 0.875 || fAngle <= 0.125) {
            facing = EnumFacing.SOUTH;
        }
        else if (fAngle > 0.125 && fAngle <= 0.375) {
            facing = EnumFacing.EAST;
        }
        else if (fAngle > 0.375 && fAngle <= 0.625) {
            facing = EnumFacing.NORTH;
        }
        else if (fAngle > 0.625 && fAngle <= 0.875) {
            facing = EnumFacing.WEST;
        }
        if (TFBlocks.cicada.func_176196_c(world, src)) {
            this.func_175903_a(world, src, TFBlocks.cicada.func_176223_P().func_177226_a((IProperty)BlockDirectional.field_176387_N, (Comparable)facing));
        }
    }
}
