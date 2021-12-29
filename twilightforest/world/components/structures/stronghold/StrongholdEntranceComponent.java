// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.stronghold;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.WorldGenLevel;
import java.util.Iterator;
import java.util.List;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import twilightforest.TwilightForestMod;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.structure.StructureStart;
import java.util.Random;
import net.minecraft.world.level.levelgen.structure.StructurePieceAccessor;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.core.Direction;
import twilightforest.world.registration.TFFeature;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;

public class StrongholdEntranceComponent extends StructureTFStrongholdComponent
{
    public StrongholdPieces lowerPieces;
    
    public StrongholdEntranceComponent(final ServerLevel level, final CompoundTag nbt) {
        super(StrongholdPieces.TFSEnter, nbt);
        this.deco = new StrongholdDecorator();
        this.lowerPieces = new StrongholdPieces();
    }
    
    public StrongholdEntranceComponent(final TFFeature feature, final int i, final int x, final int y, final int z) {
        super(StrongholdPieces.TFSEnter, feature, i, Direction.SOUTH, x, y - 10, z);
        this.deco = new StrongholdDecorator();
        this.lowerPieces = new StrongholdPieces();
    }
    
    @Override
    public void m_142537_(final StructurePiece parent, final StructurePieceAccessor old, final Random random) {
        super.m_142537_(parent, old, random);
        if (old instanceof StructureStart) {
            final StructureStart<?> start = (StructureStart<?>)old;
            final List<StructurePiece> list = start.m_73602_();
            this.lowerPieces.prepareStructurePieces();
            this.addNewComponent(parent, old, random, Rotation.NONE, 4, 1, 18);
            this.lowerPieces.prepareStructurePieces();
            if (this.listContainsBossRoom(list)) {
                this.lowerPieces.markBossRoomUsed();
            }
            this.addNewComponent(parent, old, random, Rotation.CLOCKWISE_90, -1, 1, 13);
            this.lowerPieces.prepareStructurePieces();
            if (this.listContainsBossRoom(list)) {
                this.lowerPieces.markBossRoomUsed();
            }
            this.addNewComponent(parent, old, random, Rotation.CLOCKWISE_180, 13, 1, -1);
            this.lowerPieces.prepareStructurePieces();
            if (this.listContainsBossRoom(list)) {
                this.lowerPieces.markBossRoomUsed();
            }
            this.addNewComponent(parent, old, random, Rotation.COUNTERCLOCKWISE_90, 18, 1, 4);
            if (!this.listContainsBossRoom(list)) {
                TwilightForestMod.LOGGER.warn("Did not find boss room from exit 3 - EPIC FAIL");
            }
            final BoundingBox shieldBox = new BoundingBox(this.f_73383_.m_162394_());
            int tStairs = 0;
            int tCorridors = 0;
            int deadEnd = 0;
            int tRooms = 0;
            int bossRooms = 0;
            for (final StructurePiece component : list) {
                shieldBox.m_162386_(component.m_73547_());
                if (component instanceof StrongholdSmallStairsComponent && ((StrongholdSmallStairsComponent)component).hasTreasure) {
                    ++tStairs;
                }
                if (component instanceof StrongholdTreasureCorridorComponent) {
                    ++tCorridors;
                }
                if (component instanceof StrongholdDeadEndComponent) {
                    ++deadEnd;
                }
                if (component instanceof StrongholdTreasureRoomComponent) {
                    ++tRooms;
                }
                if (component instanceof StrongholdBossRoomComponent) {
                    ++bossRooms;
                }
            }
            final StructureTFStrongholdComponent accessChamber = new StrongholdAccessChamberComponent(this.getFeatureType(), 2, this.m_73549_(), this.f_73383_.m_162395_() + 8, this.f_73383_.m_162396_() + 7, this.f_73383_.m_162398_() + 4);
            list.add(accessChamber);
            accessChamber.m_142537_(this, old, random);
        }
    }
    
    private boolean listContainsBossRoom(final List<StructurePiece> list) {
        for (final StructurePiece component : list) {
            if (component instanceof StrongholdBossRoomComponent) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public BoundingBox generateBoundingBox(final Direction facing, final int x, final int y, final int z) {
        return BoundingBox.m_71031_(x, y, z, -1, -1, 0, 18, 7, 18, facing);
    }
    
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        this.placeStrongholdWalls(world, sbb, 0, 0, 0, 17, 6, 17, rand, this.deco.randomBlocks);
        this.placeCornerStatue(world, 5, 1, 5, 0, sbb);
        this.placeCornerStatue(world, 5, 1, 12, 1, sbb);
        this.placeCornerStatue(world, 12, 1, 5, 2, sbb);
        this.placeCornerStatue(world, 12, 1, 12, 3, sbb);
        this.placeWallStatue(world, 9, 1, 16, Rotation.NONE, sbb);
        this.placeWallStatue(world, 1, 1, 9, Rotation.CLOCKWISE_90, sbb);
        this.placeWallStatue(world, 8, 1, 1, Rotation.CLOCKWISE_180, sbb);
        this.placeWallStatue(world, 16, 1, 8, Rotation.COUNTERCLOCKWISE_90, sbb);
        this.placeDoors(world, sbb);
        return true;
    }
}
