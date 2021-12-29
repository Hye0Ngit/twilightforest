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

public class ComponentTFStrongholdRightTurn extends StructureTFStrongholdComponent
{
    public ComponentTFStrongholdRightTurn() {
    }
    
    public ComponentTFStrongholdRightTurn(final TFFeature feature, final int i, final EnumFacing facing, final int x, final int y, final int z) {
        super(feature, i, facing, x, y, z);
    }
    
    @Override
    public StructureBoundingBox generateBoundingBox(final EnumFacing facing, final int x, final int y, final int z) {
        return StructureTFStrongholdComponent.getComponentToAddBoundingBox(x, y, z, -4, -1, 0, 9, 7, 9, facing);
    }
    
    @Override
    public void func_74861_a(final StructureComponent parent, final List<StructureComponent> list, final Random random) {
        super.func_74861_a(parent, list, random);
        this.addDoor(4, 1, 0);
        this.addNewComponent(parent, list, random, Rotation.CLOCKWISE_90, -1, 1, 4);
    }
    
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        this.placeStrongholdWalls(world, sbb, 0, 0, 0, 8, 6, 8, rand, this.deco.randomBlocks);
        this.func_74878_a(world, sbb, 1, 1, 1, 7, 5, 7);
        this.placeCornerStatue(world, 6, 1, 6, 3, sbb);
        this.placeDoors(world, rand, sbb);
        return true;
    }
}
