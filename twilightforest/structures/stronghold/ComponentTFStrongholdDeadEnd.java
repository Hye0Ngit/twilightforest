// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.stronghold;

import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockStairs;
import net.minecraft.init.Blocks;
import twilightforest.loot.TFTreasure;
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

public class ComponentTFStrongholdDeadEnd extends StructureTFStrongholdComponent
{
    private boolean chestTrapped;
    
    public ComponentTFStrongholdDeadEnd() {
    }
    
    public ComponentTFStrongholdDeadEnd(final TFFeature feature, final int i, final EnumFacing facing, final int x, final int y, final int z) {
        super(feature, i, facing, x, y, z);
    }
    
    @Override
    protected void func_143012_a(final NBTTagCompound tagCompound) {
        super.func_143012_a(tagCompound);
        tagCompound.func_74757_a("chestTrapped", this.chestTrapped);
    }
    
    @Override
    protected void func_143011_b(final NBTTagCompound tagCompound, final TemplateManager templateManager) {
        super.func_143011_b(tagCompound, templateManager);
        this.chestTrapped = tagCompound.func_74767_n("chestTrapped");
    }
    
    @Override
    public StructureBoundingBox generateBoundingBox(final EnumFacing facing, final int x, final int y, final int z) {
        return StructureTFStrongholdComponent.getComponentToAddBoundingBox(x, y, z, -4, -1, 0, 9, 6, 9, facing);
    }
    
    @Override
    public void func_74861_a(final StructureComponent parent, final List<StructureComponent> list, final Random random) {
        super.func_74861_a(parent, list, random);
        this.addDoor(4, 1, 0);
        this.chestTrapped = (random.nextInt(3) == 0);
    }
    
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        this.placeStrongholdWalls(world, sbb, 0, 0, 0, 8, 6, 8, rand, this.deco.randomBlocks);
        this.placeWallStatue(world, 1, 1, 4, Rotation.CLOCKWISE_90, sbb);
        this.placeWallStatue(world, 7, 1, 4, Rotation.COUNTERCLOCKWISE_90, sbb);
        this.placeWallStatue(world, 4, 1, 7, Rotation.NONE, sbb);
        this.placeDoors(world, rand, sbb);
        this.placeTreasureAtCurrentPosition(world, rand, 4, 1, 3, TFTreasure.stronghold_cache, this.chestTrapped, sbb);
        if (this.chestTrapped) {
            this.func_175811_a(world, Blocks.field_150335_W.func_176223_P(), 4, 0, 3, sbb);
        }
        for (int z = 2; z < 5; ++z) {
            this.func_175811_a(world, this.deco.stairState.func_177226_a((IProperty)BlockStairs.field_176309_a, (Comparable)EnumFacing.WEST), 3, 1, z, sbb);
            this.func_175811_a(world, this.deco.stairState.func_177226_a((IProperty)BlockStairs.field_176309_a, (Comparable)EnumFacing.EAST), 5, 1, z, sbb);
        }
        this.func_175811_a(world, this.deco.stairState.func_177226_a((IProperty)BlockStairs.field_176309_a, (Comparable)EnumFacing.NORTH), 4, 1, 2, sbb);
        this.func_175811_a(world, this.deco.stairState.func_177226_a((IProperty)BlockStairs.field_176309_a, (Comparable)EnumFacing.SOUTH), 4, 1, 4, sbb);
        this.func_175811_a(world, this.deco.stairState.func_177226_a((IProperty)BlockStairs.field_176309_a, (Comparable)EnumFacing.NORTH), 4, 2, 3, sbb);
        return true;
    }
}
