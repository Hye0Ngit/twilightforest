// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.minotaurmaze;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.World;
import java.util.Random;

public class ComponentTFMazeMushRoom extends ComponentTFMazeRoom
{
    public ComponentTFMazeMushRoom() {
    }
    
    public ComponentTFMazeMushRoom(final int i, final Random rand, final int x, final int y, final int z) {
        super(i, rand, x, y, z);
        this.field_74885_f = 0;
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        super.func_74875_a(world, rand, sbb);
        for (int x = 1; x < 14; ++x) {
            for (int z = 1; z < 14; ++z) {
                final int dist = (int)Math.round(7.0 / Math.sqrt((7.5 - x) * (7.5 - x) + (7.5 - z) * (7.5 - z)));
                if (rand.nextInt(dist + 1) > 0) {
                    this.func_151550_a(world, (Block)Blocks.field_150391_bh, 0, x, 0, z, sbb);
                }
                if (rand.nextInt(dist) > 0) {
                    this.func_151550_a(world, (Block)(rand.nextBoolean() ? Blocks.field_150337_Q : Blocks.field_150338_P), 0, x, 1, z, sbb);
                }
            }
        }
        this.makeMediumMushroom(world, sbb, 5, 2, 9, Blocks.field_150419_aX);
        this.makeMediumMushroom(world, sbb, 5, 3, 9, Blocks.field_150419_aX);
        this.makeMediumMushroom(world, sbb, 9, 2, 5, Blocks.field_150419_aX);
        this.makeMediumMushroom(world, sbb, 6, 3, 4, Blocks.field_150420_aW);
        this.makeMediumMushroom(world, sbb, 10, 1, 9, Blocks.field_150420_aW);
        this.func_151550_a(world, Blocks.field_150419_aX, 15, 1, 2, 1, sbb);
        this.func_151550_a(world, Blocks.field_150419_aX, 5, 1, 3, 1, sbb);
        this.func_151550_a(world, Blocks.field_150419_aX, 9, 2, 3, 1, sbb);
        this.func_151550_a(world, Blocks.field_150419_aX, 9, 1, 3, 2, sbb);
        this.func_151550_a(world, Blocks.field_150420_aW, 15, 14, 3, 1, sbb);
        this.func_151550_a(world, Blocks.field_150420_aW, 5, 14, 4, 1, sbb);
        this.func_151550_a(world, Blocks.field_150420_aW, 7, 13, 4, 1, sbb);
        this.func_151550_a(world, Blocks.field_150420_aW, 7, 14, 4, 2, sbb);
        this.func_151550_a(world, Blocks.field_150420_aW, 15, 1, 1, 14, sbb);
        this.func_151550_a(world, Blocks.field_150420_aW, 5, 1, 2, 14, sbb);
        this.func_151550_a(world, Blocks.field_150420_aW, 3, 2, 2, 14, sbb);
        this.func_151550_a(world, Blocks.field_150420_aW, 3, 1, 2, 13, sbb);
        this.func_151550_a(world, Blocks.field_150420_aW, 5, 14, 1, 14, sbb);
        this.func_151550_a(world, Blocks.field_150420_aW, 1, 13, 1, 14, sbb);
        this.func_151550_a(world, Blocks.field_150420_aW, 1, 14, 1, 13, sbb);
        return true;
    }
    
    private void makeMediumMushroom(final World world, final StructureBoundingBox sbb, final int mx, final int my, final int mz, final Block redMushroomBlock) {
        this.func_151550_a(world, redMushroomBlock, 5, mx + 0, my, mz + 0, sbb);
        this.func_151550_a(world, redMushroomBlock, 6, mx + 1, my, mz + 0, sbb);
        this.func_151550_a(world, redMushroomBlock, 9, mx + 1, my, mz + 1, sbb);
        this.func_151550_a(world, redMushroomBlock, 8, mx + 0, my, mz + 1, sbb);
        this.func_151550_a(world, redMushroomBlock, 7, mx - 1, my, mz + 1, sbb);
        this.func_151550_a(world, redMushroomBlock, 4, mx - 1, my, mz + 0, sbb);
        this.func_151550_a(world, redMushroomBlock, 1, mx - 1, my, mz - 1, sbb);
        this.func_151550_a(world, redMushroomBlock, 2, mx + 0, my, mz - 1, sbb);
        this.func_151550_a(world, redMushroomBlock, 3, mx + 1, my, mz - 1, sbb);
        for (int y = 1; y < my; ++y) {
            this.func_151550_a(world, redMushroomBlock, 10, mx + 0, y, mz + 0, sbb);
        }
    }
}
