// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import twilightforest.block.TFBlocks;
import twilightforest.TFTreasure;
import net.minecraft.block.Block;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import java.util.Random;
import net.minecraft.world.World;

public class ComponentTFMazeDeadEndChest extends ComponentTFMazeDeadEnd
{
    public ComponentTFMazeDeadEndChest(final int i, final int x, final int y, final int z, final int rotation) {
        super(i, x, y, z, rotation);
        this.spawnListIndex = Integer.MAX_VALUE;
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        this.func_74864_a(world, Block.field_71988_x.field_71990_ca, 0, 2, 1, 4, sbb);
        this.func_74864_a(world, Block.field_71988_x.field_71990_ca, 0, 3, 1, 4, sbb);
        this.func_74864_a(world, Block.field_72063_at.field_71990_ca, this.getStairMeta(1), 2, 1, 3, sbb);
        this.func_74864_a(world, Block.field_72063_at.field_71990_ca, this.getStairMeta(1), 3, 1, 3, sbb);
        this.func_74864_a(world, Block.field_72077_au.field_71990_ca, 0, 2, 2, 4, sbb);
        this.placeTreasureAtCurrentPosition(world, rand, 3, 2, 4, TFTreasure.labyrinth_deadend, sbb);
        this.func_74872_a(world, sbb, 1, 1, 0, 4, 3, 1, TFBlocks.mazestone.field_71990_ca, 2, 0, 0, false);
        this.func_74872_a(world, sbb, 1, 4, 0, 4, 4, 1, TFBlocks.mazestone.field_71990_ca, 3, 0, 0, false);
        this.func_74884_a(world, sbb, 2, 1, 0, 3, 3, 1, Block.field_72002_bp.field_71990_ca, 0, false);
        return true;
    }
}
