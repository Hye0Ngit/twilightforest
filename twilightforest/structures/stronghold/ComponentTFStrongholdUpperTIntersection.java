// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.stronghold;

import net.minecraft.world.World;
import java.util.Random;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureBoundingBox;

public class ComponentTFStrongholdUpperTIntersection extends StructureTFStrongholdComponent
{
    public ComponentTFStrongholdUpperTIntersection() {
    }
    
    public ComponentTFStrongholdUpperTIntersection(final int i, final int facing, final int x, final int y, final int z) {
        super(i, facing, x, y, z);
    }
    
    @Override
    public StructureBoundingBox generateBoundingBox(final int facing, final int x, final int y, final int z) {
        return StructureBoundingBox.func_78889_a(x, y, z, -2, -1, 0, 5, 5, 5, facing);
    }
    
    @Override
    public void func_74861_a(final StructureComponent parent, final List list, final Random random) {
        super.func_74861_a(parent, list, random);
        this.addNewUpperComponent(parent, list, random, 3, 5, 1, 2);
        this.addNewUpperComponent(parent, list, random, 1, -1, 1, 2);
    }
    
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        if (this.func_74860_a(world, sbb)) {
            return false;
        }
        this.placeUpperStrongholdWalls(world, sbb, 0, 0, 0, 4, 4, 4, rand, this.deco.randomBlocks);
        this.placeSmallDoorwayAt(world, rand, 2, 2, 1, 0, sbb);
        this.placeSmallDoorwayAt(world, rand, 3, 4, 1, 2, sbb);
        this.placeSmallDoorwayAt(world, rand, 1, 0, 1, 2, sbb);
        return true;
    }
    
    @Override
    public boolean isComponentProtected() {
        return false;
    }
}
