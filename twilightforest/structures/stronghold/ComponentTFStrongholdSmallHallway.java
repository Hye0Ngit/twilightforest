// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.stronghold;

import net.minecraft.world.World;
import net.minecraft.util.Rotation;
import java.util.Random;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.util.EnumFacing;
import twilightforest.TFFeature;

public class ComponentTFStrongholdSmallHallway extends StructureTFStrongholdComponent
{
    public ComponentTFStrongholdSmallHallway() {
    }
    
    public ComponentTFStrongholdSmallHallway(final TFFeature feature, final int i, final EnumFacing facing, final int x, final int y, final int z) {
        super(feature, i, facing, x, y, z);
    }
    
    @Override
    public StructureBoundingBox generateBoundingBox(final EnumFacing facing, final int x, final int y, final int z) {
        return StructureTFStrongholdComponent.getComponentToAddBoundingBox(x, y, z, -4, -1, 0, 9, 7, 18, facing);
    }
    
    @Override
    public void func_74861_a(final StructureComponent parent, final List<StructureComponent> list, final Random random) {
        super.func_74861_a(parent, list, random);
        this.addDoor(4, 1, 0);
        this.addNewComponent(parent, list, random, Rotation.NONE, 4, 1, 18);
    }
    
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        this.placeStrongholdWalls(world, sbb, 0, 0, 0, 8, 6, 17, rand, this.deco.randomBlocks);
        this.placeWallStatue(world, 1, 1, 9, Rotation.CLOCKWISE_90, sbb);
        this.placeWallStatue(world, 7, 1, 9, Rotation.COUNTERCLOCKWISE_90, sbb);
        this.placeDoors(world, rand, sbb);
        return true;
    }
}
