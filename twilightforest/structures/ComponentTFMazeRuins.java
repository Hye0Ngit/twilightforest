// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import net.minecraft.world.gen.structure.StructureBoundingBox;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import java.util.Random;
import net.minecraft.world.World;

public class ComponentTFMazeRuins extends StructureTFComponent
{
    public ComponentTFMazeRuins(final World world, final Random rand, final int i, final int x, final int y, final int z) {
        super(i);
        this.setCoordBaseMode(0);
        this.field_74887_e = StructureTFComponent.getComponentToAddBoundingBox(x, y, z, 0, 0, 0, 0, 0, 0, 0);
    }
    
    public void func_74861_a(final StructureComponent structurecomponent, final List list, final Random random) {
        super.func_74861_a(structurecomponent, list, random);
        final ComponentTFMinotaurMaze maze = new ComponentTFMinotaurMaze(1, this.field_74887_e.field_78897_a, this.field_74887_e.field_78895_b - 14, this.field_74887_e.field_78896_c, 1);
        list.add(maze);
        maze.func_74861_a(this, list, random);
        final ComponentTFMazeEntranceShaft mazeEnter = new ComponentTFMazeEntranceShaft(2, random, this.field_74887_e.field_78897_a + 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c + 1);
        list.add(mazeEnter);
        mazeEnter.func_74861_a(this, list, random);
        final ComponentTFMazeMound mazeAbove = new ComponentTFMazeMound(2, random, this.field_74887_e.field_78897_a - 14, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c - 14);
        list.add(mazeAbove);
        mazeAbove.func_74861_a(this, list, random);
    }
    
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        return true;
    }
}
