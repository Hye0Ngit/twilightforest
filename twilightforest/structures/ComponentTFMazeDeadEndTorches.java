// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import net.minecraft.block.Block;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import java.util.Random;
import net.minecraft.world.World;

public class ComponentTFMazeDeadEndTorches extends ComponentTFMazeDeadEnd
{
    public ComponentTFMazeDeadEndTorches(final int i, final int x, final int y, final int z, final int rotation) {
        super(i, x, y, z, rotation);
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        super.func_74875_a(world, rand, sbb);
        this.func_74872_a(world, sbb, 2, 1, 4, 3, 4, 4, Block.field_72069_aq.field_71990_ca, 0, 0, 0, false);
        this.func_74872_a(world, sbb, 1, 1, 1, 1, 4, 4, Block.field_72069_aq.field_71990_ca, 0, 0, 0, false);
        this.func_74872_a(world, sbb, 4, 1, 1, 4, 4, 4, Block.field_72069_aq.field_71990_ca, 0, 0, 0, false);
        return true;
    }
}
