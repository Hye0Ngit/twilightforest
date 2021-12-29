// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.minotaurmaze;

import net.minecraft.block.Block;
import twilightforest.block.TFBlocks;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.World;
import java.util.Random;

public class ComponentTFMazeRoomFountain extends ComponentTFMazeRoom
{
    public ComponentTFMazeRoomFountain() {
    }
    
    public ComponentTFMazeRoomFountain(final int i, final Random rand, final int x, final int y, final int z) {
        super(i, rand, x, y, z);
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        super.func_74875_a(world, rand, sbb);
        this.func_74872_a(world, sbb, 5, 1, 5, 10, 1, 10, TFBlocks.mazestone.field_71990_ca, 3, 0, 0, false);
        this.func_74884_a(world, sbb, 6, 1, 6, 9, 1, 9, Block.field_71942_A.field_71990_ca, 0, false);
        return true;
    }
}
