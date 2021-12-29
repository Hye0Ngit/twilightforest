// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import twilightforest.loot.TFTreasure;
import net.minecraft.util.ResourceLocation;
import twilightforest.entity.EntityTFHedgeSpider;
import twilightforest.entity.EntityTFHostileWolf;
import net.minecraft.entity.EntityList;
import twilightforest.entity.EntityTFSwarmSpider;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockPumpkin;
import net.minecraft.init.Blocks;
import twilightforest.block.TFBlocks;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.util.EnumFacing;
import java.util.Random;
import net.minecraft.world.World;
import twilightforest.TFFeature;

public class ComponentTFHedgeMaze extends StructureTFComponentOld
{
    private static final int MSIZE = 16;
    private static final int RADIUS = 25;
    private static final int DIAMETER = 50;
    private static final int FLOOR_LEVEL = 3;
    
    public ComponentTFHedgeMaze() {
    }
    
    public ComponentTFHedgeMaze(final TFFeature feature, final World world, final Random rand, final int i, final int x, final int y, final int z) {
        super(feature, i);
        this.func_186164_a(EnumFacing.SOUTH);
        this.field_74887_e = StructureTFComponentOld.getComponentToAddBoundingBox(x, y, z, -25, -3, -25, 50, 10, 50, EnumFacing.SOUTH);
    }
    
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        final TFMaze maze = new TFMaze(16, 16);
        maze.oddBias = 2;
        maze.torchBlockState = TFBlocks.firefly.func_176223_P();
        maze.wallBlockState = TFBlocks.hedge.func_176223_P();
        maze.type = 4;
        maze.tall = 3;
        maze.roots = 3;
        maze.setSeed(world.func_72905_C() + this.field_74887_e.field_78897_a * this.field_74887_e.field_78896_c);
        for (int fx = 0; fx <= 50; ++fx) {
            for (int fz = 0; fz <= 50; ++fz) {
                this.func_175811_a(world, Blocks.field_150349_c.func_176223_P(), fx, 2, fz, sbb);
            }
        }
        final IBlockState northJacko = Blocks.field_150428_aP.func_176223_P().func_177226_a((IProperty)BlockPumpkin.field_185512_D, (Comparable)EnumFacing.NORTH);
        final IBlockState southJacko = Blocks.field_150428_aP.func_176223_P().func_177226_a((IProperty)BlockPumpkin.field_185512_D, (Comparable)EnumFacing.SOUTH);
        final IBlockState westJacko = Blocks.field_150428_aP.func_176223_P().func_177226_a((IProperty)BlockPumpkin.field_185512_D, (Comparable)EnumFacing.WEST);
        final IBlockState eastJacko = Blocks.field_150428_aP.func_176223_P().func_177226_a((IProperty)BlockPumpkin.field_185512_D, (Comparable)EnumFacing.EAST);
        this.func_175811_a(world, westJacko, 0, 3, 24, sbb);
        this.func_175811_a(world, westJacko, 0, 3, 29, sbb);
        this.func_175811_a(world, eastJacko, 50, 3, 24, sbb);
        this.func_175811_a(world, eastJacko, 50, 3, 29, sbb);
        this.func_175811_a(world, northJacko, 24, 3, 0, sbb);
        this.func_175811_a(world, northJacko, 29, 3, 0, sbb);
        this.func_175811_a(world, southJacko, 24, 3, 50, sbb);
        this.func_175811_a(world, southJacko, 29, 3, 50, sbb);
        final int nrooms = 5;
        final int[] rcoords = new int[nrooms * 2];
        for (int i = 0; i < nrooms; ++i) {
            int rx;
            int rz;
            do {
                rx = maze.rand.nextInt(14) + 1;
                rz = maze.rand.nextInt(14) + 1;
            } while (this.isNearRoom(rx, rz, rcoords));
            maze.carveRoom1(rx, rz);
            rcoords[i * 2] = rx;
            rcoords[i * 2 + 1] = rz;
        }
        maze.generateRecursiveBacktracker(0, 0);
        maze.add4Exits();
        maze.copyToStructure(world, 1, 3, 1, this, sbb);
        this.decorate3x3Rooms(world, rcoords, sbb);
        return true;
    }
    
    private boolean isNearRoom(final int dx, final int dz, final int[] rcoords) {
        if (dx == 1 && dz == 1) {
            return true;
        }
        for (int i = 0; i < rcoords.length / 2; ++i) {
            final int rx = rcoords[i * 2];
            final int rz = rcoords[i * 2 + 1];
            if (rx != 0 || rz != 0) {
                if (Math.abs(dx - rx) < 3 && Math.abs(dz - rz) < 3) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private void decorate3x3Rooms(final World world, final int[] rcoords, final StructureBoundingBox sbb) {
        for (int i = 0; i < rcoords.length / 2; ++i) {
            int dx = rcoords[i * 2];
            int dz = rcoords[i * 2 + 1];
            dx = dx * 3 + 3;
            dz = dz * 3 + 3;
            this.decorate3x3Room(world, dx, dz, sbb);
        }
    }
    
    private void decorate3x3Room(final World world, final int x, final int z, final StructureBoundingBox sbb) {
        final Random roomRNG = new Random(world.func_72905_C() ^ (long)(x + z));
        this.roomJackO(world, roomRNG, x, z, 8, sbb);
        if (roomRNG.nextInt(4) == 0) {
            this.roomJackO(world, roomRNG, x, z, 8, sbb);
        }
        this.roomSpawner(world, roomRNG, x, z, 8, sbb);
        this.roomTreasure(world, roomRNG, x, z, 8, sbb);
        if (roomRNG.nextInt(4) == 0) {
            this.roomTreasure(world, roomRNG, x, z, 8, sbb);
        }
    }
    
    private void roomSpawner(final World world, final Random rand, final int x, final int z, final int diameter, final StructureBoundingBox sbb) {
        final int rx = x + rand.nextInt(diameter) - diameter / 2;
        final int rz = z + rand.nextInt(diameter) - diameter / 2;
        ResourceLocation mobID = null;
        switch (rand.nextInt(3)) {
            case 1: {
                mobID = EntityList.func_191306_a((Class)EntityTFSwarmSpider.class);
                break;
            }
            case 2: {
                mobID = EntityList.func_191306_a((Class)EntityTFHostileWolf.class);
                break;
            }
            default: {
                mobID = EntityList.func_191306_a((Class)EntityTFHedgeSpider.class);
                break;
            }
        }
        this.setSpawner(world, rx, 3, rz, sbb, mobID);
    }
    
    private void roomTreasure(final World world, final Random rand, final int x, final int z, final int diameter, final StructureBoundingBox sbb) {
        final int rx = x + rand.nextInt(diameter) - diameter / 2;
        final int rz = z + rand.nextInt(diameter) - diameter / 2;
        this.placeTreasureAtCurrentPosition(world, rand, rx, 3, rz, TFTreasure.hedgemaze, sbb);
    }
    
    private void roomJackO(final World world, final Random rand, final int x, final int z, final int diameter, final StructureBoundingBox sbb) {
        final int rx = x + rand.nextInt(diameter) - diameter / 2;
        final int rz = z + rand.nextInt(diameter) - diameter / 2;
        this.func_175811_a(world, Blocks.field_150428_aP.func_176223_P().func_177226_a((IProperty)BlockPumpkin.field_185512_D, (Comparable)EnumFacing.func_176731_b(rand.nextInt(4))), rx, 3, rz, sbb);
    }
}
