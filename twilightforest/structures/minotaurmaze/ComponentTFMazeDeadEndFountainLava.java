// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.minotaurmaze;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import java.util.Random;
import net.minecraft.world.World;

public class ComponentTFMazeDeadEndFountainLava extends ComponentTFMazeDeadEndFountain
{
    public ComponentTFMazeDeadEndFountainLava() {
    }
    
    public ComponentTFMazeDeadEndFountainLava(final int i, final int x, final int y, final int z, final int rotation) {
        super(i, x, y, z, rotation);
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        super.func_74875_a(world, rand, sbb);
        this.func_151550_a(world, Blocks.field_150350_a, 0, 2, 3, 4, sbb);
        this.func_151550_a(world, Blocks.field_150350_a, 0, 3, 3, 4, sbb);
        this.func_151550_a(world, (Block)Blocks.field_150356_k, 0, 2, 3, 4, sbb);
        this.func_151550_a(world, (Block)Blocks.field_150356_k, 0, 3, 3, 4, sbb);
        return true;
    }
}
