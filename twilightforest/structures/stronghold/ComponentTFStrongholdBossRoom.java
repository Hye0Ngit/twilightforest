// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.stronghold;

import twilightforest.structures.StructureTFComponentOld;
import net.minecraft.block.properties.IProperty;
import twilightforest.enums.BossVariant;
import twilightforest.block.BlockTFBossSpawner;
import twilightforest.block.TFBlocks;
import net.minecraft.util.Rotation;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import java.util.Random;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.util.EnumFacing;
import twilightforest.TFFeature;

public class ComponentTFStrongholdBossRoom extends StructureTFStrongholdComponent
{
    public ComponentTFStrongholdBossRoom() {
    }
    
    public ComponentTFStrongholdBossRoom(final TFFeature feature, final int i, final EnumFacing facing, final int x, final int y, final int z) {
        super(feature, i, facing, x, y, z);
        this.spawnListIndex = Integer.MAX_VALUE;
    }
    
    @Override
    public StructureBoundingBox generateBoundingBox(final EnumFacing facing, final int x, final int y, final int z) {
        return StructureTFStrongholdComponent.getComponentToAddBoundingBox(x, y, z, -13, -1, 0, 27, 7, 27, facing);
    }
    
    @Override
    public void func_74861_a(final StructureComponent parent, final List<StructureComponent> list, final Random random) {
        super.func_74861_a(parent, list, random);
        this.addDoor(13, 1, 0);
    }
    
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        this.placeStrongholdWalls(world, sbb, 0, 0, 0, 26, 6, 26, rand, this.deco.randomBlocks);
        this.func_74882_a(world, sbb, 1, 1, 1, 3, 5, 25, false, rand, this.deco.randomBlocks);
        this.func_74882_a(world, sbb, 23, 1, 1, 25, 5, 25, false, rand, this.deco.randomBlocks);
        this.func_74882_a(world, sbb, 4, 1, 1, 22, 5, 3, false, rand, this.deco.randomBlocks);
        this.func_74882_a(world, sbb, 4, 1, 23, 22, 5, 25, false, rand, this.deco.randomBlocks);
        this.func_175804_a(world, sbb, 1, 1, 1, 2, 5, 25, Blocks.field_150343_Z.func_176223_P(), Blocks.field_150343_Z.func_176223_P(), false);
        this.func_175804_a(world, sbb, 24, 1, 1, 25, 5, 25, Blocks.field_150343_Z.func_176223_P(), Blocks.field_150343_Z.func_176223_P(), false);
        this.func_175804_a(world, sbb, 4, 1, 1, 22, 5, 2, Blocks.field_150343_Z.func_176223_P(), Blocks.field_150343_Z.func_176223_P(), false);
        this.func_175804_a(world, sbb, 4, 1, 24, 22, 5, 25, Blocks.field_150343_Z.func_176223_P(), Blocks.field_150343_Z.func_176223_P(), false);
        this.func_74882_a(world, sbb, 4, 1, 4, 4, 5, 7, false, rand, this.deco.randomBlocks);
        this.func_74882_a(world, sbb, 5, 1, 4, 5, 5, 5, false, rand, this.deco.randomBlocks);
        this.func_74882_a(world, sbb, 6, 1, 4, 7, 5, 4, false, rand, this.deco.randomBlocks);
        this.func_74882_a(world, sbb, 4, 1, 19, 4, 5, 22, false, rand, this.deco.randomBlocks);
        this.func_74882_a(world, sbb, 5, 1, 21, 5, 5, 22, false, rand, this.deco.randomBlocks);
        this.func_74882_a(world, sbb, 6, 1, 22, 7, 5, 22, false, rand, this.deco.randomBlocks);
        this.func_74882_a(world, sbb, 22, 1, 4, 22, 5, 7, false, rand, this.deco.randomBlocks);
        this.func_74882_a(world, sbb, 21, 1, 4, 21, 5, 5, false, rand, this.deco.randomBlocks);
        this.func_74882_a(world, sbb, 19, 1, 4, 20, 5, 4, false, rand, this.deco.randomBlocks);
        this.func_74882_a(world, sbb, 22, 1, 19, 22, 5, 22, false, rand, this.deco.randomBlocks);
        this.func_74882_a(world, sbb, 21, 1, 21, 21, 5, 22, false, rand, this.deco.randomBlocks);
        this.func_74882_a(world, sbb, 19, 1, 22, 20, 5, 22, false, rand, this.deco.randomBlocks);
        this.placePillarDecorations(world, sbb, Rotation.NONE);
        this.placePillarDecorations(world, sbb, Rotation.CLOCKWISE_90);
        this.placePillarDecorations(world, sbb, Rotation.CLOCKWISE_180);
        this.placePillarDecorations(world, sbb, Rotation.COUNTERCLOCKWISE_90);
        this.placeSarcophagus(world, sbb, 8, 1, 8, Rotation.NONE);
        this.placeSarcophagus(world, sbb, 13, 1, 8, Rotation.NONE);
        this.placeSarcophagus(world, sbb, 18, 1, 8, Rotation.NONE);
        this.placeSarcophagus(world, sbb, 8, 1, 15, Rotation.NONE);
        this.placeSarcophagus(world, sbb, 13, 1, 15, Rotation.NONE);
        this.placeSarcophagus(world, sbb, 18, 1, 15, Rotation.NONE);
        this.func_74878_a(world, sbb, 12, 1, 1, 14, 4, 2);
        this.func_175804_a(world, sbb, 12, 1, 3, 14, 4, 3, Blocks.field_150411_aY.func_176223_P(), Blocks.field_150411_aY.func_176223_P(), false);
        this.func_175811_a(world, TFBlocks.boss_spawner.func_176223_P().func_177226_a((IProperty)BlockTFBossSpawner.VARIANT, (Comparable)BossVariant.KNIGHT_PHANTOM), 13, 2, 13, sbb);
        this.placeDoors(world, rand, sbb);
        return true;
    }
    
    private void placeSarcophagus(final World world, final StructureBoundingBox sbb, final int x, final int y, final int z, final Rotation rotation) {
        this.setBlockStateRotated(world, this.deco.pillarState, x - 1, y, z + 0, rotation, sbb);
        this.setBlockStateRotated(world, this.deco.pillarState, x + 1, y, z + 3, rotation, sbb);
        this.setBlockStateRotated(world, this.deco.pillarState, x + 1, y, z + 0, rotation, sbb);
        this.setBlockStateRotated(world, this.deco.pillarState, x - 1, y, z + 3, rotation, sbb);
        if (world.field_73012_v.nextInt(7) == 0) {
            this.setBlockStateRotated(world, Blocks.field_150478_aa.func_176223_P(), x + 1, y + 1, z + 0, rotation, sbb);
        }
        else {
            this.setBlockStateRotated(world, this.deco.fenceState, x + 1, y + 1, z + 0, rotation, sbb);
        }
        if (world.field_73012_v.nextInt(7) == 0) {
            this.setBlockStateRotated(world, Blocks.field_150478_aa.func_176223_P(), x - 1, y + 1, z + 0, rotation, sbb);
        }
        else {
            this.setBlockStateRotated(world, this.deco.fenceState, x - 1, y + 1, z + 0, rotation, sbb);
        }
        if (world.field_73012_v.nextInt(7) == 0) {
            this.setBlockStateRotated(world, Blocks.field_150478_aa.func_176223_P(), x + 1, y + 1, z + 3, rotation, sbb);
        }
        else {
            this.setBlockStateRotated(world, this.deco.fenceState, x + 1, y + 1, z + 3, rotation, sbb);
        }
        if (world.field_73012_v.nextInt(7) == 0) {
            this.setBlockStateRotated(world, Blocks.field_150478_aa.func_176223_P(), x - 1, y + 1, z + 3, rotation, sbb);
        }
        else {
            this.setBlockStateRotated(world, this.deco.fenceState, x - 1, y + 1, z + 3, rotation, sbb);
        }
        this.setBlockStateRotated(world, StructureTFComponentOld.getStairState(this.deco.stairState, Rotation.CLOCKWISE_90.func_185831_a(EnumFacing.WEST), rotation, false), x + 0, y, z + 0, rotation, sbb);
        this.setBlockStateRotated(world, StructureTFComponentOld.getStairState(this.deco.stairState, Rotation.COUNTERCLOCKWISE_90.func_185831_a(EnumFacing.WEST), rotation, false), x + 0, y, z + 3, rotation, sbb);
        this.setBlockStateRotated(world, StructureTFComponentOld.getStairState(this.deco.stairState, Rotation.CLOCKWISE_180.func_185831_a(EnumFacing.WEST), rotation, false), x + 1, y, z + 1, rotation, sbb);
        this.setBlockStateRotated(world, StructureTFComponentOld.getStairState(this.deco.stairState, Rotation.CLOCKWISE_180.func_185831_a(EnumFacing.WEST), rotation, false), x + 1, y, z + 2, rotation, sbb);
        this.setBlockStateRotated(world, StructureTFComponentOld.getStairState(this.deco.stairState, Rotation.NONE.func_185831_a(EnumFacing.WEST), rotation, false), x - 1, y, z + 1, rotation, sbb);
        this.setBlockStateRotated(world, StructureTFComponentOld.getStairState(this.deco.stairState, Rotation.NONE.func_185831_a(EnumFacing.WEST), rotation, false), x - 1, y, z + 2, rotation, sbb);
        this.setBlockStateRotated(world, Blocks.field_150333_U.func_176223_P(), x + 0, y + 1, z + 1, rotation, sbb);
        this.setBlockStateRotated(world, Blocks.field_150333_U.func_176223_P(), x + 0, y + 1, z + 2, rotation, sbb);
    }
    
    protected void placePillarDecorations(final World world, final StructureBoundingBox sbb, final Rotation rotation) {
        this.setBlockStateRotated(world, StructureTFComponentOld.getStairState(this.deco.stairState, Rotation.COUNTERCLOCKWISE_90.func_185831_a(EnumFacing.WEST), rotation, false), 4, 1, 8, rotation, sbb);
        this.setBlockStateRotated(world, StructureTFComponentOld.getStairState(this.deco.stairState, Rotation.CLOCKWISE_180.func_185831_a(EnumFacing.WEST), rotation, false), 8, 1, 4, rotation, sbb);
        this.setBlockStateRotated(world, StructureTFComponentOld.getStairState(this.deco.stairState, Rotation.COUNTERCLOCKWISE_90.func_185831_a(EnumFacing.WEST), rotation, true), 4, 5, 8, rotation, sbb);
        this.setBlockStateRotated(world, StructureTFComponentOld.getStairState(this.deco.stairState, Rotation.CLOCKWISE_180.func_185831_a(EnumFacing.WEST), rotation, true), 8, 5, 4, rotation, sbb);
        this.setBlockStateRotated(world, StructureTFComponentOld.getStairState(this.deco.stairState, Rotation.COUNTERCLOCKWISE_90.func_185831_a(EnumFacing.WEST), rotation, false), 5, 1, 6, rotation, sbb);
        this.setBlockStateRotated(world, StructureTFComponentOld.getStairState(this.deco.stairState, Rotation.CLOCKWISE_180.func_185831_a(EnumFacing.WEST), rotation, false), 6, 1, 6, rotation, sbb);
        this.setBlockStateRotated(world, StructureTFComponentOld.getStairState(this.deco.stairState, Rotation.CLOCKWISE_180.func_185831_a(EnumFacing.WEST), rotation, false), 6, 1, 5, rotation, sbb);
        this.setBlockStateRotated(world, StructureTFComponentOld.getStairState(this.deco.stairState, Rotation.COUNTERCLOCKWISE_90.func_185831_a(EnumFacing.WEST), rotation, true), 5, 5, 6, rotation, sbb);
        this.setBlockStateRotated(world, StructureTFComponentOld.getStairState(this.deco.stairState, Rotation.CLOCKWISE_180.func_185831_a(EnumFacing.WEST), rotation, true), 6, 5, 6, rotation, sbb);
        this.setBlockStateRotated(world, StructureTFComponentOld.getStairState(this.deco.stairState, Rotation.CLOCKWISE_180.func_185831_a(EnumFacing.WEST), rotation, true), 6, 5, 5, rotation, sbb);
    }
    
    @Override
    protected void placeDoorwayAt(final World world, final Random rand, final int x, final int y, final int z, final StructureBoundingBox sbb) {
        if (x == 0 || x == this.getXSize()) {
            this.func_175804_a(world, sbb, x, y, z - 1, x, y + 3, z + 1, Blocks.field_150411_aY.func_176223_P(), Blocks.field_150350_a.func_176223_P(), false);
        }
        else {
            this.func_175804_a(world, sbb, x - 1, y, z, x + 1, y + 3, z, Blocks.field_150411_aY.func_176223_P(), Blocks.field_150350_a.func_176223_P(), false);
        }
    }
    
    @Override
    protected boolean isValidBreakInPoint(final int wx, final int wy, final int wz) {
        return false;
    }
}
