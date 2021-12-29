// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.minotaurmaze;

import net.minecraft.init.Blocks;
import twilightforest.block.TFBlocks;
import net.minecraft.world.World;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import java.util.Random;
import twilightforest.structures.StructureTFComponent;

public class ComponentTFMazeRoom extends StructureTFComponent
{
    public ComponentTFMazeRoom() {
    }
    
    public ComponentTFMazeRoom(final int i, final Random rand, final int x, final int y, final int z) {
        super(i);
        this.field_74885_f = rand.nextInt(4);
        this.field_74887_e = new StructureBoundingBox(x, y, z, x + 15, y + 4, z + 15);
    }
    
    public void func_74861_a(final StructureComponent structurecomponent, final List list, final Random random) {
    }
    
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        this.func_151556_a(world, sbb, 1, 0, 1, 14, 0, 14, TFBlocks.mazestone, 7, Blocks.field_150350_a, 0, true);
        this.func_151556_a(world, sbb, 2, 0, 2, 13, 0, 13, TFBlocks.mazestone, 6, Blocks.field_150350_a, 0, true);
        if (this.func_151548_a(world, 7, 1, 0, sbb) == Blocks.field_150350_a) {
            this.func_151549_a(world, sbb, 6, 1, 0, 9, 4, 0, Blocks.field_150422_aJ, Blocks.field_150350_a, false);
            this.func_74878_a(world, sbb, 7, 1, 0, 8, 3, 0);
        }
        if (this.func_151548_a(world, 7, 1, 15, sbb) == Blocks.field_150350_a) {
            this.func_151549_a(world, sbb, 6, 1, 15, 9, 4, 15, Blocks.field_150422_aJ, Blocks.field_150350_a, false);
            this.func_74878_a(world, sbb, 7, 1, 15, 8, 3, 15);
        }
        if (this.func_151548_a(world, 0, 1, 7, sbb) == Blocks.field_150350_a) {
            this.func_151549_a(world, sbb, 0, 1, 6, 0, 4, 9, Blocks.field_150422_aJ, Blocks.field_150350_a, false);
            this.func_74878_a(world, sbb, 0, 1, 7, 0, 3, 8);
        }
        if (this.func_151548_a(world, 15, 1, 7, sbb) == Blocks.field_150350_a) {
            this.func_151549_a(world, sbb, 15, 1, 6, 15, 4, 9, Blocks.field_150422_aJ, Blocks.field_150350_a, false);
            this.func_74878_a(world, sbb, 15, 1, 7, 15, 3, 8);
        }
        return true;
    }
}
