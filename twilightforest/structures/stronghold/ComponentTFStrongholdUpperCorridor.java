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

public class ComponentTFStrongholdUpperCorridor extends StructureTFStrongholdComponent
{
    public ComponentTFStrongholdUpperCorridor() {
    }
    
    public ComponentTFStrongholdUpperCorridor(final TFFeature feature, final int i, final EnumFacing facing, final int x, final int y, final int z) {
        super(feature, i, facing, x, y, z);
    }
    
    @Override
    public StructureBoundingBox generateBoundingBox(final EnumFacing facing, final int x, final int y, final int z) {
        return StructureBoundingBox.func_175897_a(x, y, z, -2, -1, 0, 5, 5, 9, facing);
    }
    
    @Override
    public void func_74861_a(final StructureComponent parent, final List<StructureComponent> list, final Random random) {
        super.func_74861_a(parent, list, random);
        this.addNewUpperComponent(parent, list, random, Rotation.NONE, 2, 1, 9);
    }
    
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        if (this.func_74860_a(world, sbb)) {
            return false;
        }
        this.placeUpperStrongholdWalls(world, sbb, 0, 0, 0, 4, 4, 8, rand, this.deco.randomBlocks);
        this.placeSmallDoorwayAt(world, rand, 2, 2, 1, 0, sbb);
        this.placeSmallDoorwayAt(world, rand, 2, 2, 1, 8, sbb);
        return true;
    }
    
    @Override
    public boolean isComponentProtected() {
        return false;
    }
}
