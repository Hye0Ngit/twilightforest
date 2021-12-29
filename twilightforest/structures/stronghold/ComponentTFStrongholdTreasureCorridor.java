// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.stronghold;

import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockStairs;
import twilightforest.structures.StructureTFComponentOld;
import twilightforest.loot.TFTreasure;
import net.minecraft.world.World;
import net.minecraft.util.Rotation;
import java.util.Random;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.util.EnumFacing;
import twilightforest.TFFeature;

public class ComponentTFStrongholdTreasureCorridor extends StructureTFStrongholdComponent
{
    public ComponentTFStrongholdTreasureCorridor() {
    }
    
    public ComponentTFStrongholdTreasureCorridor(final TFFeature feature, final int i, final EnumFacing facing, final int x, final int y, final int z) {
        super(feature, i, facing, x, y, z);
    }
    
    @Override
    public StructureBoundingBox generateBoundingBox(final EnumFacing facing, final int x, final int y, final int z) {
        return StructureTFStrongholdComponent.getComponentToAddBoundingBox(x, y, z, -4, -1, 0, 9, 7, 27, facing);
    }
    
    @Override
    public void func_74861_a(final StructureComponent parent, final List<StructureComponent> list, final Random random) {
        super.func_74861_a(parent, list, random);
        this.addDoor(4, 1, 0);
        this.addNewComponent(parent, list, random, Rotation.NONE, 4, 1, 27);
    }
    
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        this.placeStrongholdWalls(world, sbb, 0, 0, 0, 8, 6, 26, rand, this.deco.randomBlocks);
        this.placeWallStatue(world, 1, 1, 9, Rotation.CLOCKWISE_90, sbb);
        this.placeWallStatue(world, 1, 1, 17, Rotation.CLOCKWISE_90, sbb);
        this.placeWallStatue(world, 7, 1, 9, Rotation.COUNTERCLOCKWISE_90, sbb);
        this.placeWallStatue(world, 7, 1, 17, Rotation.COUNTERCLOCKWISE_90, sbb);
        final Rotation rotation = ((this.field_74887_e.field_78897_a ^ this.field_74887_e.field_78896_c) % 2 == 0) ? Rotation.NONE : Rotation.CLOCKWISE_180;
        this.placeTreasureRotated(world, 8, 2, 13, rotation, TFTreasure.stronghold_cache, sbb);
        this.setBlockStateRotated(world, StructureTFComponentOld.getStairState(this.deco.stairState, EnumFacing.SOUTH, rotation, true), 8, 3, 12, rotation, sbb);
        this.setBlockStateRotated(world, StructureTFComponentOld.getStairState(this.deco.stairState, EnumFacing.WEST, rotation, true), 8, 3, 13, rotation, sbb);
        this.setBlockStateRotated(world, StructureTFComponentOld.getStairState(this.deco.stairState, EnumFacing.NORTH, rotation, true), 8, 3, 14, rotation, sbb);
        this.setBlockStateRotated(world, this.deco.fenceState, 8, 2, 12, rotation, sbb);
        this.setBlockStateRotated(world, this.deco.fenceState, 8, 2, 14, rotation, sbb);
        this.setBlockStateRotated(world, this.deco.stairState.func_177226_a((IProperty)BlockStairs.field_176309_a, (Comparable)EnumFacing.SOUTH), 7, 1, 12, rotation, sbb);
        this.setBlockStateRotated(world, this.deco.stairState.func_177226_a((IProperty)BlockStairs.field_176309_a, (Comparable)EnumFacing.WEST), 7, 1, 13, rotation, sbb);
        this.setBlockStateRotated(world, this.deco.stairState.func_177226_a((IProperty)BlockStairs.field_176309_a, (Comparable)EnumFacing.NORTH), 7, 1, 14, rotation, sbb);
        this.placeDoors(world, rand, sbb);
        return true;
    }
}
