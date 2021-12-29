// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import twilightforest.loot.TFTreasure;
import net.minecraft.entity.EntityType;
import twilightforest.entity.TFEntities;
import net.minecraft.state.Property;
import net.minecraft.block.CarvedPumpkinBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import java.util.Random;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.ISeedReader;
import net.minecraft.util.Direction;
import twilightforest.TFFeature;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class HedgeMazeComponent extends TFStructureComponentOld
{
    private static final int MSIZE = 16;
    private static final int RADIUS = 25;
    private static final int DIAMETER = 50;
    private static final int FLOOR_LEVEL = 3;
    
    public HedgeMazeComponent(final TemplateManager manager, final CompoundNBT nbt) {
        super(TFFeature.TFHedge, nbt);
    }
    
    public HedgeMazeComponent(final TFFeature feature, final int i, final int x, final int y, final int z) {
        super(TFFeature.TFHedge, feature, i);
        this.func_186164_a(Direction.SOUTH);
        this.field_74887_e = feature.getComponentToAddBoundingBox(x, y, z, -25, -3, -25, 50, 10, 50, Direction.SOUTH);
    }
    
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random rand, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        final TFMaze maze = new TFMaze(16, 16);
        maze.oddBias = 2;
        maze.torchBlockState = ((Block)TFBlocks.firefly.get()).func_176223_P();
        maze.wallBlockState = ((Block)TFBlocks.hedge.get()).func_176223_P();
        maze.type = 4;
        maze.tall = 3;
        maze.roots = 3;
        maze.setSeed(world.func_72905_C() + this.field_74887_e.field_78897_a * this.field_74887_e.field_78896_c);
        for (int fx = 0; fx <= 50; ++fx) {
            for (int fz = 0; fz <= 50; ++fz) {
                this.func_175811_a(world, Blocks.field_196658_i.func_176223_P(), fx, 2, fz, sbb);
            }
        }
        final BlockState northJacko = (BlockState)Blocks.field_196628_cT.func_176223_P().func_206870_a((Property)CarvedPumpkinBlock.field_196359_a, (Comparable)Direction.NORTH);
        final BlockState southJacko = (BlockState)Blocks.field_196628_cT.func_176223_P().func_206870_a((Property)CarvedPumpkinBlock.field_196359_a, (Comparable)Direction.SOUTH);
        final BlockState westJacko = (BlockState)Blocks.field_196628_cT.func_176223_P().func_206870_a((Property)CarvedPumpkinBlock.field_196359_a, (Comparable)Direction.WEST);
        final BlockState eastJacko = (BlockState)Blocks.field_196628_cT.func_176223_P().func_206870_a((Property)CarvedPumpkinBlock.field_196359_a, (Comparable)Direction.EAST);
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
        maze.copyToStructure(world, manager, generator, 1, 3, 1, this, sbb);
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
    
    private void decorate3x3Rooms(final ISeedReader world, final int[] rcoords, final MutableBoundingBox sbb) {
        for (int i = 0; i < rcoords.length / 2; ++i) {
            int dx = rcoords[i * 2];
            int dz = rcoords[i * 2 + 1];
            dx = dx * 3 + 3;
            dz = dz * 3 + 3;
            this.decorate3x3Room(world, dx, dz, sbb);
        }
    }
    
    private void decorate3x3Room(final ISeedReader world, final int x, final int z, final MutableBoundingBox sbb) {
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
    
    private void roomSpawner(final ISeedReader world, final Random rand, final int x, final int z, final int diameter, final MutableBoundingBox sbb) {
        final int rx = x + rand.nextInt(diameter) - diameter / 2;
        final int rz = z + rand.nextInt(diameter) - diameter / 2;
        EntityType<?> mobID = null;
        switch (rand.nextInt(3)) {
            case 1: {
                mobID = TFEntities.swarm_spider;
                break;
            }
            case 2: {
                mobID = TFEntities.hostile_wolf;
                break;
            }
            default: {
                mobID = TFEntities.hedge_spider;
                break;
            }
        }
        this.setSpawner(world, rx, 3, rz, sbb, mobID);
    }
    
    private void roomTreasure(final ISeedReader world, final Random rand, final int x, final int z, final int diameter, final MutableBoundingBox sbb) {
        final int rx = x + rand.nextInt(diameter) - diameter / 2;
        final int rz = z + rand.nextInt(diameter) - diameter / 2;
        this.placeTreasureAtCurrentPosition(world, rx, 3, rz, TFTreasure.hedgemaze, sbb);
    }
    
    private void roomJackO(final ISeedReader world, final Random rand, final int x, final int z, final int diameter, final MutableBoundingBox sbb) {
        final int rx = x + rand.nextInt(diameter) - diameter / 2;
        final int rz = z + rand.nextInt(diameter) - diameter / 2;
        this.func_175811_a(world, (BlockState)Blocks.field_196628_cT.func_176223_P().func_206870_a((Property)CarvedPumpkinBlock.field_196359_a, (Comparable)Direction.func_176731_b(rand.nextInt(4))), rx, 3, rz, sbb);
    }
}
