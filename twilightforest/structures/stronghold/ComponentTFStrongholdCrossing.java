// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.stronghold;

import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockStairs;
import twilightforest.structures.StructureTFComponentOld;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.util.Rotation;
import java.util.Random;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.util.EnumFacing;
import twilightforest.TFFeature;

public class ComponentTFStrongholdCrossing extends StructureTFStrongholdComponent
{
    public ComponentTFStrongholdCrossing() {
    }
    
    public ComponentTFStrongholdCrossing(final TFFeature feature, final int i, final EnumFacing facing, final int x, final int y, final int z) {
        super(feature, i, facing, x, y, z);
    }
    
    @Override
    public StructureBoundingBox generateBoundingBox(final EnumFacing facing, final int x, final int y, final int z) {
        return StructureTFStrongholdComponent.getComponentToAddBoundingBox(x, y, z, -13, -1, 0, 18, 7, 18, facing);
    }
    
    @Override
    public void func_74861_a(final StructureComponent parent, final List<StructureComponent> list, final Random random) {
        super.func_74861_a(parent, list, random);
        this.addDoor(13, 1, 0);
        this.addNewComponent(parent, list, random, Rotation.NONE, 4, 1, 18);
        this.addNewComponent(parent, list, random, Rotation.CLOCKWISE_90, -1, 1, 13);
        this.addNewComponent(parent, list, random, Rotation.COUNTERCLOCKWISE_90, 18, 1, 4);
    }
    
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        this.placeStrongholdWalls(world, sbb, 0, 0, 0, 17, 6, 17, rand, this.deco.randomBlocks);
        this.placeCornerStatue(world, 2, 1, 2, 0, sbb);
        this.placeCornerStatue(world, 15, 1, 15, 3, sbb);
        this.fillBlocksRotated(world, sbb, 8, 1, 8, 9, 5, 9, this.deco.pillarState, Rotation.NONE);
        this.placeWallStatue(world, 8, 1, 7, Rotation.NONE, sbb);
        this.placeWallStatue(world, 7, 1, 9, Rotation.COUNTERCLOCKWISE_90, sbb);
        this.placeWallStatue(world, 9, 1, 10, Rotation.CLOCKWISE_180, sbb);
        this.placeWallStatue(world, 10, 1, 8, Rotation.CLOCKWISE_90, sbb);
        this.placeTableAndChairs(world, sbb, Rotation.NONE);
        this.placeTableAndChairs(world, sbb, Rotation.CLOCKWISE_90);
        this.placeTableAndChairs(world, sbb, Rotation.CLOCKWISE_180);
        this.placeTableAndChairs(world, sbb, Rotation.COUNTERCLOCKWISE_90);
        this.placeDoors(world, rand, sbb);
        return true;
    }
    
    private void placeTableAndChairs(final World world, final StructureBoundingBox sbb, final Rotation rotation) {
        final IBlockState oakStairs = Blocks.field_150476_ad.func_176223_P();
        this.setBlockStateRotated(world, StructureTFComponentOld.getStairState(oakStairs, Rotation.NONE.func_185831_a(EnumFacing.WEST), rotation, true), 5, 1, 3, rotation, sbb);
        this.setBlockStateRotated(world, StructureTFComponentOld.getStairState(oakStairs, Rotation.COUNTERCLOCKWISE_90.func_185831_a(EnumFacing.WEST), rotation, true), 5, 1, 4, rotation, sbb);
        this.setBlockStateRotated(world, StructureTFComponentOld.getStairState(oakStairs, Rotation.CLOCKWISE_90.func_185831_a(EnumFacing.WEST), rotation, true), 6, 1, 3, rotation, sbb);
        this.setBlockStateRotated(world, StructureTFComponentOld.getStairState(oakStairs, Rotation.CLOCKWISE_180.func_185831_a(EnumFacing.WEST), rotation, true), 6, 1, 4, rotation, sbb);
        this.setBlockStateRotated(world, Blocks.field_150485_bF.func_176223_P().func_177226_a((IProperty)BlockStairs.field_176309_a, (Comparable)Rotation.COUNTERCLOCKWISE_90.func_185831_a(EnumFacing.WEST)), 5, 1, 2, rotation, sbb);
        this.setBlockStateRotated(world, Blocks.field_150485_bF.func_176223_P().func_177226_a((IProperty)BlockStairs.field_176309_a, (Comparable)Rotation.NONE.func_185831_a(EnumFacing.WEST)), 7, 1, 3, rotation, sbb);
        this.setBlockStateRotated(world, Blocks.field_150485_bF.func_176223_P().func_177226_a((IProperty)BlockStairs.field_176309_a, (Comparable)Rotation.CLOCKWISE_90.func_185831_a(EnumFacing.WEST)), 6, 1, 5, rotation, sbb);
        this.setBlockStateRotated(world, Blocks.field_150485_bF.func_176223_P().func_177226_a((IProperty)BlockStairs.field_176309_a, (Comparable)Rotation.CLOCKWISE_180.func_185831_a(EnumFacing.WEST)), 4, 1, 4, rotation, sbb);
    }
}
