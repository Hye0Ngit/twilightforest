// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.stronghold;

import twilightforest.TFTreasure;
import net.minecraft.world.World;
import java.util.Random;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureBoundingBox;

public class ComponentTFStrongholdTreasureCorridor extends StructureTFStrongholdComponent
{
    public ComponentTFStrongholdTreasureCorridor() {
    }
    
    public ComponentTFStrongholdTreasureCorridor(final int i, final int facing, final int x, final int y, final int z) {
        super(i, facing, x, y, z);
    }
    
    @Override
    public StructureBoundingBox generateBoundingBox(final int facing, final int x, final int y, final int z) {
        return StructureTFStrongholdComponent.getComponentToAddBoundingBox(x, y, z, -4, -1, 0, 9, 7, 27, facing);
    }
    
    @Override
    public void func_74861_a(final StructureComponent parent, final List list, final Random random) {
        super.func_74861_a(parent, list, random);
        this.addDoor(4, 1, 0);
        this.addNewComponent(parent, list, random, 0, 4, 1, 27);
    }
    
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        this.placeStrongholdWalls(world, sbb, 0, 0, 0, 8, 6, 26, rand, this.deco.randomBlocks);
        this.placeWallStatue(world, 1, 1, 9, 1, sbb);
        this.placeWallStatue(world, 1, 1, 17, 1, sbb);
        this.placeWallStatue(world, 7, 1, 9, 3, sbb);
        this.placeWallStatue(world, 7, 1, 17, 3, sbb);
        final int rotation = ((this.field_74887_e.field_78897_a ^ this.field_74887_e.field_78896_c) % 2 == 0) ? 0 : 2;
        this.placeTreasureRotated(world, 8, 2, 13, rotation, TFTreasure.stronghold_cache, sbb);
        this.placeBlockRotated(world, this.deco.stairID, this.getStairMeta(3 + rotation) + 4, 8, 3, 12, rotation, sbb);
        this.placeBlockRotated(world, this.deco.stairID, this.getStairMeta(0 + rotation) + 4, 8, 3, 13, rotation, sbb);
        this.placeBlockRotated(world, this.deco.stairID, this.getStairMeta(1 + rotation) + 4, 8, 3, 14, rotation, sbb);
        this.placeBlockRotated(world, this.deco.fenceID, this.deco.fenceMeta, 8, 2, 12, rotation, sbb);
        this.placeBlockRotated(world, this.deco.fenceID, this.deco.fenceMeta, 8, 2, 14, rotation, sbb);
        this.placeBlockRotated(world, this.deco.stairID, this.getStairMeta(1 + rotation), 7, 1, 12, rotation, sbb);
        this.placeBlockRotated(world, this.deco.stairID, this.getStairMeta(0 + rotation), 7, 1, 13, rotation, sbb);
        this.placeBlockRotated(world, this.deco.stairID, this.getStairMeta(3 + rotation), 7, 1, 14, rotation, sbb);
        this.placeDoors(world, rand, sbb);
        return true;
    }
}
