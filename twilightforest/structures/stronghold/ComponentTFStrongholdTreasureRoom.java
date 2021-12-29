// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.stronghold;

import twilightforest.loot.TFTreasure;
import twilightforest.util.TFEntityNames;
import net.minecraft.init.Blocks;
import net.minecraft.util.Rotation;
import net.minecraft.world.World;
import java.util.Random;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.template.TemplateManager;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import twilightforest.TFFeature;

public class ComponentTFStrongholdTreasureRoom extends StructureTFStrongholdComponent
{
    private boolean enterBottom;
    
    public ComponentTFStrongholdTreasureRoom() {
    }
    
    public ComponentTFStrongholdTreasureRoom(final TFFeature feature, final int i, final EnumFacing facing, final int x, final int y, final int z) {
        super(feature, i, facing, x, y, z);
    }
    
    @Override
    protected void func_143012_a(final NBTTagCompound tagCompound) {
        super.func_143012_a(tagCompound);
        tagCompound.func_74757_a("enterBottom", this.enterBottom);
    }
    
    @Override
    protected void func_143011_b(final NBTTagCompound tagCompound, final TemplateManager templateManager) {
        super.func_143011_b(tagCompound, templateManager);
        this.enterBottom = tagCompound.func_74767_n("enterBottom");
    }
    
    @Override
    public StructureBoundingBox generateBoundingBox(final EnumFacing facing, final int x, final int y, final int z) {
        return StructureBoundingBox.func_175897_a(x, y, z, -4, -1, 0, 9, 7, 18, facing);
    }
    
    @Override
    public void func_74861_a(final StructureComponent parent, final List<StructureComponent> list, final Random random) {
        super.func_74861_a(parent, list, random);
        this.addDoor(4, 1, 0);
    }
    
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        this.placeStrongholdWalls(world, sbb, 0, 0, 0, 8, 6, 17, rand, this.deco.randomBlocks);
        this.placeWallStatue(world, 1, 1, 4, Rotation.CLOCKWISE_90, sbb);
        this.placeWallStatue(world, 1, 1, 13, Rotation.CLOCKWISE_90, sbb);
        this.placeWallStatue(world, 7, 1, 4, Rotation.COUNTERCLOCKWISE_90, sbb);
        this.placeWallStatue(world, 7, 1, 13, Rotation.COUNTERCLOCKWISE_90, sbb);
        this.placeWallStatue(world, 4, 1, 16, Rotation.NONE, sbb);
        this.func_74882_a(world, sbb, 1, 1, 8, 7, 5, 9, false, rand, this.deco.randomBlocks);
        this.func_175804_a(world, sbb, 3, 1, 8, 5, 4, 9, Blocks.field_150411_aY.func_176223_P(), Blocks.field_150411_aY.func_176223_P(), false);
        this.setSpawner(world, 4, 1, 4, sbb, TFEntityNames.HELMET_CRAB);
        this.setSpawner(world, 4, 4, 15, sbb, TFEntityNames.HELMET_CRAB);
        this.placeTreasureAtCurrentPosition(world, rand, 2, 4, 13, TFTreasure.stronghold_room, sbb);
        this.placeTreasureAtCurrentPosition(world, rand, 6, 4, 13, TFTreasure.stronghold_room, sbb);
        this.placeDoors(world, rand, sbb);
        return true;
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
}
