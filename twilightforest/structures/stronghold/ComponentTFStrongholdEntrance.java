// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.stronghold;

import twilightforest.structures.StructureTFComponent;
import java.util.Iterator;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import java.util.Random;
import net.minecraft.world.World;

public class ComponentTFStrongholdEntrance extends StructureTFStrongholdComponent
{
    public TFStrongholdPieces lowerPieces;
    
    public ComponentTFStrongholdEntrance(final World world, final Random rand, final int i, final int x, final int y, final int z) {
        super(i, 0, x, y - 10, z);
        this.deco = new StructureTFDecoratorStronghold();
        this.lowerPieces = new TFStrongholdPieces();
    }
    
    @Override
    public void func_74861_a(final StructureComponent parent, final List list, final Random random) {
        super.func_74861_a(parent, list, random);
        this.lowerPieces.prepareStructurePieces();
        this.addNewComponent(parent, list, random, 0, 4, 1, 18);
        this.lowerPieces.prepareStructurePieces();
        if (this.listContainsBossRoom(list)) {
            this.lowerPieces.markBossRoomUsed();
        }
        this.addNewComponent(parent, list, random, 1, -1, 1, 13);
        this.lowerPieces.prepareStructurePieces();
        if (this.listContainsBossRoom(list)) {
            this.lowerPieces.markBossRoomUsed();
        }
        this.addNewComponent(parent, list, random, 2, 13, 1, -1);
        this.lowerPieces.prepareStructurePieces();
        if (this.listContainsBossRoom(list)) {
            this.lowerPieces.markBossRoomUsed();
        }
        this.addNewComponent(parent, list, random, 3, 18, 1, 4);
        if (!this.listContainsBossRoom(list)) {
            System.out.println("Did not find boss room from exit 3 - EPIC FAIL");
        }
        final List pieceList = list;
        final StructureBoundingBox shieldBox = new StructureBoundingBox(this.field_74887_e);
        int tStairs = 0;
        int tCorridors = 0;
        int deadEnd = 0;
        int tRooms = 0;
        int bossRooms = 0;
        for (final StructureTFStrongholdComponent component : pieceList) {
            shieldBox.func_78888_b(component.func_74874_b());
            if (component instanceof ComponentTFStrongholdSmallStairs && ((ComponentTFStrongholdSmallStairs)component).hasTreasure) {
                ++tStairs;
            }
            if (component instanceof ComponentTFStrongholdTreasureCorridor) {
                ++tCorridors;
            }
            if (component instanceof ComponentTFStrongholdDeadEnd) {
                ++deadEnd;
            }
            if (component instanceof ComponentTFStrongholdTreasureRoom) {
                ++tRooms;
            }
            if (component instanceof ComponentTFStrongholdBossRoom) {
                ++bossRooms;
            }
        }
        final StructureTFStrongholdComponent accessChamber = new ComponentTFStrongholdAccessChamber(2, this.getCoordBaseMode(), this.field_74887_e.field_78897_a + 8, this.field_74887_e.field_78895_b + 7, this.field_74887_e.field_78896_c + 4);
        list.add(accessChamber);
        accessChamber.func_74861_a(this, list, random);
    }
    
    private boolean listContainsBossRoom(final List list) {
        for (final StructureTFStrongholdComponent component : list) {
            if (component instanceof ComponentTFStrongholdBossRoom) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public StructureBoundingBox generateBoundingBox(final int facing, final int x, final int y, final int z) {
        return StructureBoundingBox.func_78889_a(x, y, z, -1, -1, 0, 18, 7, 18, facing);
    }
    
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        this.func_74882_a(world, sbb, 0, 0, 0, 17, 6, 17, false, rand, StructureTFComponent.getStrongholdStones());
        final int var8 = this.func_74865_a(0, 0);
        final int var9 = this.func_74862_a(0);
        final int var10 = this.func_74873_b(0, 0);
        this.placeCornerStatue(world, 5, 1, 5, 0, sbb);
        this.placeCornerStatue(world, 5, 1, 12, 1, sbb);
        this.placeCornerStatue(world, 12, 1, 5, 2, sbb);
        this.placeCornerStatue(world, 12, 1, 12, 3, sbb);
        this.placeWallStatue(world, 9, 1, 16, 0, sbb);
        this.placeWallStatue(world, 1, 1, 9, 1, sbb);
        this.placeWallStatue(world, 8, 1, 1, 2, sbb);
        this.placeWallStatue(world, 16, 1, 8, 3, sbb);
        this.placeDoors(world, rand, sbb);
        return true;
    }
}
