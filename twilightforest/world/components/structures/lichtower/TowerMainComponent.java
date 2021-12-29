// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.lichtower;

import net.minecraft.world.level.levelgen.feature.NoiseEffect;
import net.minecraft.world.level.block.PipeBlock;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.material.Material;
import java.util.Iterator;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import twilightforest.entity.TFEntities;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import twilightforest.world.components.structures.TFStructureComponentOld;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Rotation;
import twilightforest.util.RotationUtil;
import net.minecraft.world.level.levelgen.structure.StructurePieceAccessor;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.core.Direction;
import java.util.Random;
import twilightforest.world.registration.TFFeature;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;

public class TowerMainComponent extends TowerWingComponent
{
    public TowerMainComponent(final ServerLevel level, final CompoundTag nbt) {
        super(LichTowerPieces.TFLTMai, nbt);
    }
    
    public TowerMainComponent(final TFFeature feature, final Random rand, final int index, final int x, final int y, final int z) {
        super(LichTowerPieces.TFLTMai, feature, index, x, y + 6, z, 15, 55 + rand.nextInt(32), Direction.SOUTH);
    }
    
    @Override
    public void m_142537_(final StructurePiece parent, final StructurePieceAccessor list, final Random rand) {
        this.makeARoof(parent, list, rand);
        for (final Rotation rotation : RotationUtil.ROTATIONS) {
            final int[] dest = this.getValidOpening(rand, rotation);
            if (dest[1] < this.height / 2) {
                final int[] array = dest;
                final int n = 1;
                array[n] += 20;
            }
            final int childHeight = Math.min(21 + rand.nextInt(10), this.height - dest[1] - 3);
            if (!this.makeTowerWing(list, rand, 1, dest[0], dest[1], dest[2], 9, childHeight, rotation)) {
                this.makeTowerWing(list, rand, 1, dest[0], dest[1], dest[2], 7, childHeight, rotation);
            }
        }
        for (final Rotation rotation : RotationUtil.ROTATIONS) {
            final int[] dest = this.getValidOpening(rand, rotation);
            if (dest[1] < this.height / 2) {
                final int[] array2 = dest;
                final int n2 = 1;
                array2[n2] += 10;
            }
            final int childHeight = Math.min(21 + rand.nextInt(10), this.height - dest[1] - 3);
            if (!this.makeTowerWing(list, rand, 1, dest[0], dest[1], dest[2], 9, childHeight, rotation)) {
                this.makeTowerWing(list, rand, 1, dest[0], dest[1], dest[2], 7, childHeight, rotation);
            }
        }
        for (final Rotation rotation : RotationUtil.ROTATIONS) {
            final int[] dest = this.getValidOpening(rand, rotation);
            final int childHeight = Math.min(7 + rand.nextInt(6), this.height - dest[1] - 3);
            if (!this.makeTowerWing(list, rand, 1, dest[0], dest[1], dest[2], 5, childHeight, rotation)) {
                this.makeTowerWing(list, rand, 1, dest[0], dest[1], dest[2], 3, childHeight, rotation);
            }
        }
        for (final Rotation rotation : RotationUtil.ROTATIONS) {
            final int[] dest = this.getOutbuildingOpening(rand, rotation);
            final int childHeight = 11 + rand.nextInt(10);
            final int childSize = 7 + rand.nextInt(2) * 2;
            this.makeTowerOutbuilding(list, rand, 1, dest[0], dest[1], dest[2], childSize, childHeight, rotation);
        }
        for (int i = 0; i < 4; ++i) {
            for (final Rotation towerRotation : RotationUtil.ROTATIONS) {
                final int[] dest2 = this.getValidOpening(rand, towerRotation);
                final int childHeight2 = 6 + rand.nextInt(5);
                if (rand.nextInt(3) == 0 || !this.makeTowerWing(list, rand, 1, dest2[0], dest2[1], dest2[2], 5, childHeight2, towerRotation)) {
                    this.makeTowerWing(list, rand, 1, dest2[0], dest2[1], dest2[2], 3, childHeight2, towerRotation);
                }
            }
        }
    }
    
    public int[] getOutbuildingOpening(final Random rand, final Rotation rotation) {
        int rx = 0;
        final int ry = 1;
        int rz = 0;
        switch (rotation) {
            case NONE: {
                rx = this.size - 1;
                rz = 6 + rand.nextInt(8);
                break;
            }
            case CLOCKWISE_90: {
                rx = 1 + rand.nextInt(11);
                rz = this.size - 1;
                break;
            }
            case CLOCKWISE_180: {
                rx = 0;
                rz = 1 + rand.nextInt(8);
                break;
            }
            case COUNTERCLOCKWISE_90: {
                rx = 3 + rand.nextInt(11);
                rz = 0;
                break;
            }
        }
        return new int[] { rx, ry, rz };
    }
    
    public boolean makeTowerOutbuilding(final StructurePieceAccessor list, final Random rand, final int index, final int x, final int y, final int z, final int wingSize, final int wingHeight, final Rotation rotation) {
        final Direction direction = this.getStructureRelativeRotation(rotation);
        final int[] dx = this.offsetTowerCoords(x, y, z, wingSize, direction);
        final TowerOutbuildingComponent outbuilding = new TowerOutbuildingComponent(this.getFeatureType(), index, dx[0], dx[1], dx[2], wingSize, wingHeight, direction);
        final StructurePiece intersect = list.m_141921_(outbuilding.m_73547_());
        if (intersect == null) {
            list.m_142679_((StructurePiece)outbuilding);
            outbuilding.m_142537_(this, list, rand);
            this.addOpening(x, y, z, rotation);
            return true;
        }
        return false;
    }
    
    @Override
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        this.m_73464_(world, sbb, 0, 0, 0, this.size - 1, this.height - 1, this.size - 1, false, rand, TFStructureComponentOld.getStrongholdStones());
        this.m_73535_(world, sbb, 1, 1, 1, this.size - 2, this.height - 2, this.size - 2);
        final BlockState defaultState = Blocks.f_50652_.m_49966_();
        for (int x = 0; x < this.size; ++x) {
            for (int z = 0; z < this.size; ++z) {
                this.m_73528_(world, defaultState, x, -1, z, sbb);
            }
        }
        if (this.height - this.highestOpening > 15) {
            this.highestOpening = this.height - 15;
        }
        this.makeStairs(world, rand, sbb);
        this.makeOpenings(world, sbb);
        this.decorateStairFloor(world, rand, sbb);
        this.makeStairwayCrossings(world, rand, sbb);
        this.makeLichRoom(world, rand, sbb);
        this.makeTowerPaintings(world, rand, sbb);
        return true;
    }
    
    protected void makeStairwayCrossings(final WorldGenLevel world, final Random rand, final BoundingBox sbb) {
        for (int flights = this.highestOpening / 5 - 2, i = 2 + rand.nextInt(2); i < flights; i += 1 + rand.nextInt(5)) {
            this.makeStairCrossing(world, rand, i, sbb);
        }
    }
    
    protected void makeStairCrossing(final WorldGenLevel world, final Random rand, final int flight, final BoundingBox sbb) {
        final Direction temp = this.m_73549_();
        if (flight % 2 == 0) {
            this.m_73519_(this.getStructureRelativeRotation(Rotation.CLOCKWISE_90));
        }
        int floorLevel = flight * 5;
        final BlockState crossingfloor = (BlockState)(rand.nextBoolean() ? Blocks.f_50405_.m_49966_().m_61124_((Property)SlabBlock.f_56353_, (Comparable)SlabType.DOUBLE) : Blocks.f_50742_.m_49966_());
        for (int dx = 6; dx <= 8; ++dx) {
            for (int dz = 4; dz <= 10; ++dz) {
                this.m_73434_(world, crossingfloor, dx, floorLevel, dz, sbb);
            }
        }
        ++floorLevel;
        int dx = 6;
        for (int dz = 3; dz <= 11; ++dz) {
            this.m_73434_(world, Blocks.f_50132_.m_49966_(), dx, floorLevel, dz, sbb);
        }
        ++dx;
        for (int dz = 3; dz <= 11; ++dz) {
            this.m_73434_(world, TowerMainComponent.AIR, dx, floorLevel, dz, sbb);
        }
        ++dx;
        for (int dz = 3; dz <= 11; ++dz) {
            this.m_73434_(world, Blocks.f_50132_.m_49966_(), dx, floorLevel, dz, sbb);
        }
        this.m_73434_(world, crossingfloor, 6, floorLevel - 1, 11, sbb);
        this.m_73434_(world, crossingfloor, 8, floorLevel - 1, 3, sbb);
        this.m_73434_(world, Blocks.f_50132_.m_49966_(), 5, floorLevel, 11, sbb);
        this.m_73434_(world, Blocks.f_50132_.m_49966_(), 9, floorLevel, 3, sbb);
        EntityType entityType = switch (rand.nextInt(4)) {
            case 2 -> EntityType.f_20501_;
            case 3 -> TFEntities.SWARM_SPIDER;
            default -> EntityType.f_20524_;
        };
        final EntityType<?> mobID = (EntityType<?>)entityType;
        this.setSpawner(world, 7, floorLevel + 2, 7, sbb, mobID);
        this.m_73434_(world, Blocks.f_50132_.m_49966_(), 6, floorLevel + 1, 7, sbb);
        this.m_73434_(world, Blocks.f_50132_.m_49966_(), 8, floorLevel + 1, 7, sbb);
        this.m_73434_(world, Blocks.f_50132_.m_49966_(), 6, floorLevel + 2, 7, sbb);
        this.m_73434_(world, Blocks.f_50132_.m_49966_(), 8, floorLevel + 2, 7, sbb);
        this.m_73519_(temp);
    }
    
    protected void makeLichRoom(final WorldGenLevel world, final Random rand, final BoundingBox sbb) {
        final int floorLevel = 2 + this.highestOpening / 5 * 5;
        final Rotation i = (this.highestOpening / 5 % 2 == 0) ? Rotation.NONE : Rotation.CLOCKWISE_90;
        this.makeLichFloor(world, floorLevel, i, sbb);
        this.decorateLichChandelier(world, floorLevel, sbb);
        this.decoratePaintings(world, rand, floorLevel, sbb);
        this.decorateTorches(world, rand, floorLevel, sbb);
        this.m_73434_(world, ((Block)TFBlocks.LICH_BOSS_SPAWNER.get()).m_49966_(), this.size / 2, floorLevel + 2, this.size / 2, sbb);
    }
    
    protected void makeTowerPaintings(final WorldGenLevel world, final Random rand, final BoundingBox sbb) {
        final int howMany = 10;
        this.generatePaintingsOnWall(world, rand, howMany, 0, Direction.WEST, 48, sbb);
        this.generatePaintingsOnWall(world, rand, howMany, 0, Direction.WEST, 32, sbb);
        this.generatePaintingsOnWall(world, rand, howMany, 0, Direction.WEST, 0, sbb);
        this.generatePaintingsOnWall(world, rand, howMany, 0, Direction.EAST, 48, sbb);
        this.generatePaintingsOnWall(world, rand, howMany, 0, Direction.EAST, 32, sbb);
        this.generatePaintingsOnWall(world, rand, howMany, 0, Direction.EAST, 0, sbb);
        this.generatePaintingsOnWall(world, rand, howMany, 0, Direction.NORTH, 48, sbb);
        this.generatePaintingsOnWall(world, rand, howMany, 0, Direction.NORTH, 32, sbb);
        this.generatePaintingsOnWall(world, rand, howMany, 0, Direction.NORTH, 0, sbb);
        this.generatePaintingsOnWall(world, rand, howMany, 0, Direction.SOUTH, 48, sbb);
        this.generatePaintingsOnWall(world, rand, howMany, 0, Direction.SOUTH, 32, sbb);
        this.generatePaintingsOnWall(world, rand, howMany, 0, Direction.SOUTH, 0, sbb);
    }
    
    protected void makeLichFloor(final WorldGenLevel world, final int floorLevel, final Rotation rotation, final BoundingBox sbb) {
        final Direction temp = this.m_73549_();
        this.m_73519_(this.getStructureRelativeRotation(rotation));
        final BlockState birchSlab = (BlockState)Blocks.f_50400_.m_49966_().m_61124_((Property)SlabBlock.f_56353_, (Comparable)SlabType.TOP);
        final BlockState birchPlank = Blocks.f_50742_.m_49966_();
        for (int fx = 1; fx < 14; ++fx) {
            for (int fz = 1; fz < 14; ++fz) {
                if ((fx == 1 || fx == 2) && fz >= 6 && fz <= 12) {
                    if (fz == 6) {
                        this.m_73434_(world, birchSlab, fx, floorLevel, fz, sbb);
                    }
                }
                else if ((fx == 12 || fx == 13) && fz >= 3 && fz <= 8) {
                    if (fz == 8) {
                        this.m_73434_(world, birchSlab, fx, floorLevel, fz, sbb);
                    }
                }
                else if (fx >= 4 && fx <= 10 && fz >= 4 && fz <= 10) {
                    if ((fx == 4 && fz == 4) || (fx == 10 && fz == 10)) {
                        this.m_73434_(world, birchPlank, fx, floorLevel, fz, sbb);
                    }
                    else {
                        this.m_73434_(world, Blocks.f_50058_.m_49966_(), fx, floorLevel, fz, sbb);
                    }
                }
                else if ((fx == 2 || fx == 3) && (fz == 2 || fz == 3)) {
                    this.m_73434_(world, Blocks.f_50058_.m_49966_(), fx, floorLevel, fz, sbb);
                }
                else if ((fx == 11 || fx == 12) && (fz == 11 || fz == 12)) {
                    this.m_73434_(world, Blocks.f_50058_.m_49966_(), fx, floorLevel, fz, sbb);
                }
                else {
                    this.m_73434_(world, birchPlank, fx, floorLevel, fz, sbb);
                }
            }
        }
        this.m_73434_(world, TowerMainComponent.AIR, 3, floorLevel + 1, 11, sbb);
        this.m_73434_(world, TowerMainComponent.AIR, 3, floorLevel + 1, 10, sbb);
        this.m_73434_(world, TowerMainComponent.AIR, 3, floorLevel + 2, 11, sbb);
        this.m_73434_(world, TowerMainComponent.AIR, 11, floorLevel + 1, 3, sbb);
        this.m_73434_(world, TowerMainComponent.AIR, 11, floorLevel + 1, 4, sbb);
        this.m_73434_(world, TowerMainComponent.AIR, 11, floorLevel + 2, 3, sbb);
        this.m_73519_(temp);
    }
    
    protected void decorateLichChandelier(final WorldGenLevel world, final int floorLevel, final BoundingBox sbb) {
        final int cx = this.size / 2;
        int cy = floorLevel + 4;
        final int cz = this.size / 2;
        this.m_73434_(world, Blocks.f_50132_.m_49966_(), cx + 1, cy, cz, sbb);
        this.m_73434_(world, Blocks.f_50132_.m_49966_(), cx + 2, cy, cz, sbb);
        this.m_73434_(world, Blocks.f_50132_.m_49966_(), cx + 1, cy, cz + 1, sbb);
        this.m_73434_(world, Blocks.f_50132_.m_49966_(), cx, cy, cz + 1, sbb);
        this.m_73434_(world, Blocks.f_50132_.m_49966_(), cx, cy, cz + 2, sbb);
        this.m_73434_(world, Blocks.f_50132_.m_49966_(), cx - 1, cy, cz + 1, sbb);
        this.m_73434_(world, Blocks.f_50132_.m_49966_(), cx - 1, cy, cz, sbb);
        this.m_73434_(world, Blocks.f_50132_.m_49966_(), cx - 2, cy, cz, sbb);
        this.m_73434_(world, Blocks.f_50132_.m_49966_(), cx - 1, cy, cz - 1, sbb);
        this.m_73434_(world, Blocks.f_50132_.m_49966_(), cx, cy, cz - 1, sbb);
        this.m_73434_(world, Blocks.f_50132_.m_49966_(), cx, cy, cz - 2, sbb);
        this.m_73434_(world, Blocks.f_50132_.m_49966_(), cx + 1, cy, cz - 1, sbb);
        ++cy;
        this.m_73434_(world, Blocks.f_50132_.m_49966_(), cx + 1, cy, cz, sbb);
        this.m_73434_(world, Blocks.f_50081_.m_49966_(), cx + 2, cy, cz, sbb);
        this.m_73434_(world, Blocks.f_50081_.m_49966_(), cx + 1, cy, cz + 1, sbb);
        this.m_73434_(world, Blocks.f_50132_.m_49966_(), cx, cy, cz + 1, sbb);
        this.m_73434_(world, Blocks.f_50081_.m_49966_(), cx, cy, cz + 2, sbb);
        this.m_73434_(world, Blocks.f_50081_.m_49966_(), cx - 1, cy, cz + 1, sbb);
        this.m_73434_(world, Blocks.f_50132_.m_49966_(), cx - 1, cy, cz, sbb);
        this.m_73434_(world, Blocks.f_50081_.m_49966_(), cx - 2, cy, cz, sbb);
        this.m_73434_(world, Blocks.f_50081_.m_49966_(), cx - 1, cy, cz - 1, sbb);
        this.m_73434_(world, Blocks.f_50132_.m_49966_(), cx, cy, cz - 1, sbb);
        this.m_73434_(world, Blocks.f_50081_.m_49966_(), cx, cy, cz - 2, sbb);
        this.m_73434_(world, Blocks.f_50081_.m_49966_(), cx + 1, cy, cz - 1, sbb);
        ++cy;
        this.m_73434_(world, Blocks.f_50081_.m_49966_(), cx + 1, cy, cz, sbb);
        this.m_73434_(world, Blocks.f_50081_.m_49966_(), cx, cy, cz + 1, sbb);
        this.m_73434_(world, Blocks.f_50081_.m_49966_(), cx - 1, cy, cz, sbb);
        this.m_73434_(world, Blocks.f_50081_.m_49966_(), cx, cy, cz - 1, sbb);
        for (int y = floorLevel + 5; y < this.height - 1; ++y) {
            this.m_73434_(world, Blocks.f_50132_.m_49966_(), cx, y, cz, sbb);
        }
    }
    
    protected void decoratePaintings(final WorldGenLevel world, final Random rand, final int floorLevel, final BoundingBox sbb) {
        final int howMany = 25;
        for (final Direction horizontal : Direction.Plane.HORIZONTAL) {
            this.generatePaintingsOnWall(world, rand, howMany, floorLevel, horizontal, 48, sbb);
            this.generatePaintingsOnWall(world, rand, howMany, floorLevel, horizontal, 32, sbb);
            this.generatePaintingsOnWall(world, rand, howMany, floorLevel, horizontal, 0, sbb);
        }
    }
    
    protected void decorateTorches(final WorldGenLevel world, final Random rand, final int floorLevel, final BoundingBox sbb) {
        this.generateTorchesOnWall(world, rand, floorLevel, Direction.SOUTH, sbb);
        this.generateTorchesOnWall(world, rand, floorLevel, Direction.EAST, sbb);
        this.generateTorchesOnWall(world, rand, floorLevel, Direction.NORTH, sbb);
        this.generateTorchesOnWall(world, rand, floorLevel, Direction.WEST, sbb);
    }
    
    protected void generateTorchesOnWall(final WorldGenLevel world, final Random rand, final int floorLevel, final Direction direction, final BoundingBox sbb) {
        for (int i = 0; i < 5; ++i) {
            final BlockPos wCoords = this.getRandomWallSpot(rand, floorLevel, direction, sbb);
            if (wCoords != null) {
                final BlockPos.MutableBlockPos tCoords = new BlockPos.MutableBlockPos(wCoords.m_123341_(), wCoords.m_123342_(), wCoords.m_123343_());
                final BlockState blockState = world.m_8055_((BlockPos)tCoords);
                final BlockState aboveBlockState = world.m_8055_(tCoords.m_7494_());
                if (blockState.m_60767_() == Material.f_76296_ && aboveBlockState.m_60767_() == Material.f_76296_ && this.getEntitiesInAABB(world, new AABB((BlockPos)tCoords)).size() == 0) {
                    world.m_7731_((BlockPos)tCoords, (BlockState)Blocks.f_50132_.m_49966_().m_61124_((Property)PipeBlock.f_55154_.get(direction.m_122424_()), (Comparable)true), 2);
                    world.m_7731_(tCoords.m_7494_(), Blocks.f_50081_.m_49966_(), 2);
                }
            }
        }
    }
    
    @Override
    public NoiseEffect m_142318_() {
        return NoiseEffect.BEARD;
    }
}
