// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import java.util.List;
import java.util.Random;

public class ComponentTFMazeRuins extends StructureTFComponent
{
    public ComponentTFMazeRuins(final yc world, final Random rand, final int i, final int x, final int y, final int z) {
        super(i);
        this.setCoordBaseMode(0);
        this.e = StructureTFComponent.getComponentToAddBoundingBox(x, y, z, 0, 0, 0, 0, 0, 0, 0);
    }
    
    public void a(final aez structurecomponent, final List list, final Random random) {
        super.a(structurecomponent, list, random);
        final ComponentTFMinotaurMaze maze = new ComponentTFMinotaurMaze(1, this.e.a, this.e.b - 14, this.e.c, 1);
        list.add(maze);
        maze.a(this, list, random);
        final ComponentTFMazeEntranceShaft mazeEnter = new ComponentTFMazeEntranceShaft(2, random, this.e.a + 1, this.e.b, this.e.c + 1);
        list.add(mazeEnter);
        mazeEnter.a(this, list, random);
        final ComponentTFMazeMound mazeAbove = new ComponentTFMazeMound(2, random, this.e.a - 14, this.e.b, this.e.c - 14);
        list.add(mazeAbove);
        mazeAbove.a(this, list, random);
    }
    
    public boolean a(final yc world, final Random rand, final acn sbb) {
        return true;
    }
}
