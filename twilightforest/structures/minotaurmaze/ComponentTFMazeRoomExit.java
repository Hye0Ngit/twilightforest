// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.minotaurmaze;

import net.minecraft.block.Block;
import twilightforest.block.TFBlocks;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.World;
import java.util.Random;

public class ComponentTFMazeRoomExit extends ComponentTFMazeRoom
{
    public ComponentTFMazeRoomExit() {
    }
    
    public ComponentTFMazeRoomExit(final int i, final Random rand, final int x, final int y, final int z) {
        super(i, rand, x, y, z);
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        super.func_74875_a(world, rand, sbb);
        this.func_74872_a(world, sbb, 5, -5, 5, 10, 0, 10, TFBlocks.mazestone.field_71990_ca, 1, 0, 0, false);
        this.func_74872_a(world, sbb, 5, 1, 5, 10, 1, 10, TFBlocks.mazestone.field_71990_ca, 3, 0, 0, false);
        this.func_74872_a(world, sbb, 5, 2, 5, 10, 3, 10, Block.field_72002_bp.field_71990_ca, 0, 0, 0, false);
        this.func_74872_a(world, sbb, 5, 4, 5, 10, 4, 10, TFBlocks.mazestone.field_71990_ca, 3, 0, 0, false);
        this.func_74878_a(world, sbb, 6, -5, 6, 9, 4, 9);
        return true;
    }
}
