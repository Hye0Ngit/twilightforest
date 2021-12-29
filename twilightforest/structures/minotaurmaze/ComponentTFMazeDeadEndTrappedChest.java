// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.minotaurmaze;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import java.util.Random;
import net.minecraft.world.World;

public class ComponentTFMazeDeadEndTrappedChest extends ComponentTFMazeDeadEndChest
{
    public ComponentTFMazeDeadEndTrappedChest() {
    }
    
    public ComponentTFMazeDeadEndTrappedChest(final int i, final int x, final int y, final int z, final int rotation) {
        super(i, x, y, z, rotation);
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        super.func_74875_a(world, rand, sbb);
        this.func_151550_a(world, (Block)Blocks.field_150479_bC, this.getHookMeta(3), 1, 1, 2, sbb);
        this.func_151550_a(world, (Block)Blocks.field_150479_bC, this.getHookMeta(1), 4, 1, 2, sbb);
        this.func_151550_a(world, Blocks.field_150473_bD, 0, 2, 1, 2, sbb);
        this.func_151550_a(world, Blocks.field_150473_bD, 0, 3, 1, 2, sbb);
        this.func_151550_a(world, Blocks.field_150335_W, 0, 0, 0, 2, sbb);
        this.func_151550_a(world, Blocks.field_150350_a, 0, 0, -1, 2, sbb);
        this.func_151550_a(world, Blocks.field_150350_a, 0, 1, -1, 2, sbb);
        this.func_151550_a(world, Blocks.field_150335_W, 0, 2, 0, 4, sbb);
        this.func_151550_a(world, Blocks.field_150335_W, 0, 3, 0, 4, sbb);
        this.func_151550_a(world, Blocks.field_150335_W, 0, 2, 0, 3, sbb);
        this.func_151550_a(world, Blocks.field_150335_W, 0, 3, 0, 3, sbb);
        return true;
    }
    
    protected int getHookMeta(final int dir) {
        return (this.getCoordBaseMode() + dir) % 4;
    }
}
