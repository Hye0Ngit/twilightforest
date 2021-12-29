// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.minotaurmaze;

import net.minecraft.block.Block;
import twilightforest.block.TFBlocks;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import java.util.Random;
import net.minecraft.world.World;

public class ComponentTFMazeCorridorIronFence extends ComponentTFMazeCorridor
{
    public ComponentTFMazeCorridorIronFence() {
    }
    
    public ComponentTFMazeCorridorIronFence(final int i, final int x, final int y, final int z, final int rotation) {
        super(i, x, y, z, rotation);
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        this.func_74872_a(world, sbb, 1, 4, 2, 4, 4, 3, TFBlocks.mazestone.field_71990_ca, 3, 0, 0, false);
        this.func_74872_a(world, sbb, 1, 1, 2, 4, 3, 3, TFBlocks.mazestone.field_71990_ca, 2, 0, 0, false);
        this.func_74884_a(world, sbb, 2, 1, 2, 3, 3, 3, Block.field_72002_bp.field_71990_ca, 0, false);
        return true;
    }
}
