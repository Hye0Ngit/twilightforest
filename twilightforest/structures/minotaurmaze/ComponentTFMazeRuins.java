// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.minotaurmaze;

import net.minecraft.world.gen.structure.StructureBoundingBox;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.util.EnumFacing;
import java.util.Random;
import net.minecraft.world.World;
import twilightforest.TFFeature;
import twilightforest.structures.StructureTFComponentOld;

public class ComponentTFMazeRuins extends StructureTFComponentOld
{
    public ComponentTFMazeRuins() {
    }
    
    public ComponentTFMazeRuins(final TFFeature feature, final World world, final Random rand, final int i, final int x, final int y, final int z) {
        super(feature, i);
        this.func_186164_a(EnumFacing.SOUTH);
        this.field_74887_e = StructureTFComponentOld.getComponentToAddBoundingBox(x, y, z, 0, 0, 0, 0, 0, 0, EnumFacing.SOUTH);
    }
    
    public void func_74861_a(final StructureComponent structurecomponent, final List<StructureComponent> list, final Random random) {
        super.func_74861_a(structurecomponent, (List)list, random);
        final ComponentTFMinotaurMaze maze = new ComponentTFMinotaurMaze(this.getFeatureType(), 1, this.field_74887_e.field_78897_a, this.field_74887_e.field_78895_b - 14, this.field_74887_e.field_78896_c, 1);
        list.add(maze);
        maze.func_74861_a(this, list, random);
        final ComponentTFMazeEntranceShaft mazeEnter = new ComponentTFMazeEntranceShaft(this.getFeatureType(), 2, random, this.field_74887_e.field_78897_a + 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c + 1);
        list.add(mazeEnter);
        mazeEnter.func_74861_a(this, list, random);
        final ComponentTFMazeMound mazeAbove = new ComponentTFMazeMound(this.getFeatureType(), 2, random, this.field_74887_e.field_78897_a - 14, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c - 14);
        list.add(mazeAbove);
        mazeAbove.func_74861_a(this, list, random);
    }
    
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        return true;
    }
}
