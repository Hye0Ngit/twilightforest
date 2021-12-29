// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.stronghold;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.ISeedReader;
import java.util.Iterator;
import net.minecraft.util.math.MutableBoundingBox;
import twilightforest.TwilightForestMod;
import net.minecraft.util.Rotation;
import java.util.Random;
import java.util.List;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraft.util.Direction;
import twilightforest.TFFeature;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class StrongholdEntranceComponent extends StructureTFStrongholdComponent
{
    public StrongholdPieces lowerPieces;
    
    public StrongholdEntranceComponent(final TemplateManager manager, final CompoundNBT nbt) {
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
    public void func_74861_a(final StructurePiece parent, final List<StructurePiece> list, final Random random) {
        super.func_74861_a(parent, list, random);
        this.lowerPieces.prepareStructurePieces();
        this.addNewComponent(parent, list, random, Rotation.NONE, 4, 1, 18);
        this.lowerPieces.prepareStructurePieces();
        if (this.listContainsBossRoom(list)) {
            this.lowerPieces.markBossRoomUsed();
        }
        this.addNewComponent(parent, list, random, Rotation.CLOCKWISE_90, -1, 1, 13);
        this.lowerPieces.prepareStructurePieces();
        if (this.listContainsBossRoom(list)) {
            this.lowerPieces.markBossRoomUsed();
        }
        this.addNewComponent(parent, list, random, Rotation.CLOCKWISE_180, 13, 1, -1);
        this.lowerPieces.prepareStructurePieces();
        if (this.listContainsBossRoom(list)) {
            this.lowerPieces.markBossRoomUsed();
        }
        this.addNewComponent(parent, list, random, Rotation.COUNTERCLOCKWISE_90, 18, 1, 4);
        if (!this.listContainsBossRoom(list)) {
            TwilightForestMod.LOGGER.warn("Did not find boss room from exit 3 - EPIC FAIL");
        }
        final MutableBoundingBox shieldBox = new MutableBoundingBox(this.field_74887_e);
        int tStairs = 0;
        int tCorridors = 0;
        int deadEnd = 0;
        int tRooms = 0;
        int bossRooms = 0;
        for (final StructurePiece component : list) {
            shieldBox.func_78888_b(component.func_74874_b());
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
        final StructureTFStrongholdComponent accessChamber = new StrongholdAccessChamberComponent(this.getFeatureType(), 2, this.func_186165_e(), this.field_74887_e.field_78897_a + 8, this.field_74887_e.field_78895_b + 7, this.field_74887_e.field_78896_c + 4);
        list.add(accessChamber);
        accessChamber.func_74861_a(this, list, random);
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
    public MutableBoundingBox generateBoundingBox(final Direction facing, final int x, final int y, final int z) {
        return MutableBoundingBox.func_175897_a(x, y, z, -1, -1, 0, 18, 7, 18, facing);
    }
    
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random rand, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
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
