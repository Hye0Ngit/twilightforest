// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import net.minecraft.block.Block;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import java.util.Random;
import net.minecraft.world.World;

public class ComponentTFMazeDeadEndPainting extends ComponentTFMazeDeadEnd
{
    public ComponentTFMazeDeadEndPainting(final int i, final int x, final int y, final int z, final int rotation) {
        super(i, x, y, z, rotation);
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        super.func_74875_a(world, rand, sbb);
        this.func_74864_a(world, Block.field_72069_aq.field_71990_ca, 0, 1, 3, 3, sbb);
        this.func_74864_a(world, Block.field_72069_aq.field_71990_ca, 0, 4, 3, 3, sbb);
        return true;
    }
}
