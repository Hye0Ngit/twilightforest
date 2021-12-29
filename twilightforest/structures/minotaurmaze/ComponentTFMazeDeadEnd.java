// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.minotaurmaze;

import net.minecraft.init.Blocks;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import twilightforest.structures.StructureTFComponent;

public class ComponentTFMazeDeadEnd extends StructureTFComponent
{
    public ComponentTFMazeDeadEnd() {
    }
    
    public ComponentTFMazeDeadEnd(final int i, final int x, final int y, final int z, final int rotation) {
        super(i);
        this.field_74885_f = rotation;
        this.field_74887_e = new StructureBoundingBox(x, y, z, x + 5, y + 5, z + 5);
    }
    
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        this.func_151556_a(world, sbb, 1, 1, 0, 4, 4, 0, Blocks.field_150422_aJ, 0, Blocks.field_150350_a, 0, false);
        this.func_74878_a(world, sbb, 2, 1, 0, 3, 3, 0);
        return true;
    }
}
