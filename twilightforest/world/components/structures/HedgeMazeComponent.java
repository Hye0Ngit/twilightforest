// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures;

import net.minecraft.world.level.levelgen.feature.NoiseEffect;
import twilightforest.loot.TFTreasure;
import net.minecraft.world.entity.EntityType;
import twilightforest.entity.TFEntities;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.CarvedPumpkinBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import java.util.Random;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.core.Direction;
import twilightforest.util.BoundingBoxUtils;
import twilightforest.world.registration.TFFeature;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;

public class HedgeMazeComponent extends TFStructureComponentOld
{
    private static final int MSIZE = 16;
    private static final int RADIUS = 25;
    private static final int DIAMETER = 50;
    private static final int FLOOR_LEVEL = 0;
    
    public HedgeMazeComponent(final ServerLevel level, final CompoundTag nbt) {
        super(TFFeature.TFHedge, nbt);
        this.f_73383_ = BoundingBoxUtils.NBTToBoundingBox(nbt);
    }
    
    public HedgeMazeComponent(final TFFeature feature, final int i, final int x, final int y, final int z) {
        super(TFFeature.TFHedge, feature, i, x, y, z);
        this.m_73519_(Direction.SOUTH);
        this.f_73383_ = feature.getComponentToAddBoundingBox(x, y, z, -25, -3, -25, 50, 10, 50, Direction.SOUTH);
    }
    
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        final TFMaze maze = new TFMaze(16, 16);
        maze.oddBias = 2;
        maze.torchBlockState = ((Block)TFBlocks.FIREFLY.get()).m_49966_();
        maze.wallBlockState = ((Block)TFBlocks.HEDGE.get()).m_49966_();
        maze.type = 4;
        maze.tall = 3;
        maze.roots = 3;
        maze.setSeed(world.m_7328_() + this.f_73383_.m_162395_() * (long)this.f_73383_.m_162398_());
        for (int fx = 0; fx <= 50; ++fx) {
            for (int fz = 0; fz <= 50; ++fz) {
                this.m_73434_(world, Blocks.f_50440_.m_49966_(), fx, -1, fz, sbb);
            }
        }
        final BlockState northJacko = (BlockState)Blocks.f_50144_.m_49966_().m_61124_((Property)CarvedPumpkinBlock.f_51367_, (Comparable)Direction.NORTH);
        final BlockState southJacko = (BlockState)Blocks.f_50144_.m_49966_().m_61124_((Property)CarvedPumpkinBlock.f_51367_, (Comparable)Direction.SOUTH);
        final BlockState westJacko = (BlockState)Blocks.f_50144_.m_49966_().m_61124_((Property)CarvedPumpkinBlock.f_51367_, (Comparable)Direction.WEST);
        final BlockState eastJacko = (BlockState)Blocks.f_50144_.m_49966_().m_61124_((Property)CarvedPumpkinBlock.f_51367_, (Comparable)Direction.EAST);
        this.m_73434_(world, westJacko, 0, 0, 24, sbb);
        this.m_73434_(world, westJacko, 0, 0, 29, sbb);
        this.m_73434_(world, eastJacko, 50, 0, 24, sbb);
        this.m_73434_(world, eastJacko, 50, 0, 29, sbb);
        this.m_73434_(world, northJacko, 24, 0, 0, sbb);
        this.m_73434_(world, northJacko, 29, 0, 0, sbb);
        this.m_73434_(world, southJacko, 24, 0, 50, sbb);
        this.m_73434_(world, southJacko, 29, 0, 50, sbb);
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
        maze.copyToStructure(world, manager, generator, 1, 0, 1, this, sbb);
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
    
    private void decorate3x3Rooms(final WorldGenLevel world, final int[] rcoords, final BoundingBox sbb) {
        for (int i = 0; i < rcoords.length / 2; ++i) {
            int dx = rcoords[i * 2];
            int dz = rcoords[i * 2 + 1];
            dx = dx * 3 + 3;
            dz = dz * 3 + 3;
            this.decorate3x3Room(world, dx, dz, sbb);
        }
    }
    
    private void decorate3x3Room(final WorldGenLevel world, final int x, final int z, final BoundingBox sbb) {
        final Random roomRNG = new Random(world.m_7328_() ^ (long)(x + z));
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
    
    private void roomSpawner(final WorldGenLevel world, final Random rand, final int x, final int z, final int diameter, final BoundingBox sbb) {
        final int rx = x + rand.nextInt(diameter) - diameter / 2;
        final int rz = z + rand.nextInt(diameter) - diameter / 2;
        Object o = switch (rand.nextInt(3)) {
            case 1 -> TFEntities.SWARM_SPIDER;
            case 2 -> TFEntities.HOSTILE_WOLF;
            default -> TFEntities.HEDGE_SPIDER;
        };
        final EntityType<?> mobID = (EntityType<?>)o;
        this.setSpawner(world, rx, 0, rz, sbb, mobID);
    }
    
    private void roomTreasure(final WorldGenLevel world, final Random rand, final int x, final int z, final int diameter, final BoundingBox sbb) {
        final int rx = x + rand.nextInt(diameter) - diameter / 2;
        final int rz = z + rand.nextInt(diameter) - diameter / 2;
        this.placeTreasureAtCurrentPosition(world, rx, 0, rz, TFTreasure.HEDGE_MAZE, sbb);
    }
    
    private void roomJackO(final WorldGenLevel world, final Random rand, final int x, final int z, final int diameter, final BoundingBox sbb) {
        final int rx = x + rand.nextInt(diameter) - diameter / 2;
        final int rz = z + rand.nextInt(diameter) - diameter / 2;
        this.m_73434_(world, (BlockState)Blocks.f_50144_.m_49966_().m_61124_((Property)CarvedPumpkinBlock.f_51367_, (Comparable)Direction.m_122407_(rand.nextInt(4))), rx, 0, rz, sbb);
    }
    
    @Override
    public NoiseEffect m_142318_() {
        return NoiseEffect.BEARD;
    }
    
    @Override
    protected void m_142347_(final ServerLevel level, final CompoundTag tagCompound) {
        super.m_142347_(level, tagCompound);
        BoundingBoxUtils.boundingBoxToExistingNBT(this.f_73383_, tagCompound);
    }
}
