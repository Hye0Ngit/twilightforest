// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.minotaurmaze;

import net.minecraft.block.Block;
import twilightforest.block.TFBlocks;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import java.util.Random;
import net.minecraft.world.World;

public class ComponentTFMazeDeadEndFountain extends ComponentTFMazeDeadEnd
{
    public ComponentTFMazeDeadEndFountain() {
    }
    
    public ComponentTFMazeDeadEndFountain(final int i, final int x, final int y, final int z, final int rotation) {
        super(i, x, y, z, rotation);
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        super.func_74875_a(world, rand, sbb);
        this.func_74872_a(world, sbb, 1, 1, 4, 4, 4, 4, TFBlocks.mazestone.field_71990_ca, 1, 0, 0, false);
        this.func_74864_a(world, Block.field_71942_A.field_71990_ca, 0, 2, 3, 4, sbb);
        this.func_74864_a(world, Block.field_71942_A.field_71990_ca, 0, 3, 3, 4, sbb);
        this.func_74864_a(world, 0, 0, 2, 0, 3, sbb);
        this.func_74864_a(world, 0, 0, 3, 0, 3, sbb);
        return true;
    }
}
