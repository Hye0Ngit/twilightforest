// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.icetower;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.World;
import java.util.Random;

public class ComponentTFIceTowerBossWing extends ComponentTFIceTowerWing
{
    public ComponentTFIceTowerBossWing() {
        this.spawnListIndex = -1;
    }
    
    public ComponentTFIceTowerBossWing(final int index, final int x, final int y, final int z, final int wingSize, final int wingHeight, final int direction) {
        super(index, x, y, z, wingSize, wingHeight, direction);
        this.spawnListIndex = -1;
    }
    
    @Override
    protected boolean shouldHaveBase(final Random rand) {
        return false;
    }
    
    @Override
    protected void placeFloor(final World world, final Random rand, final StructureBoundingBox sbb, final int floorHeight, final int floor) {
        for (int x = 1; x < this.size - 1; ++x) {
            for (int z = 1; z < this.size - 1; ++z) {
                final Block ice = (rand.nextInt(4) == 0) ? Blocks.field_150432_aD : Blocks.field_150403_cj;
                for (int thickness = 1 + rand.nextInt(2) + rand.nextInt(2) + rand.nextInt(2), y = 0; y < thickness; ++y) {
                    this.func_151550_a(world, ice, 0, x, floor * floorHeight + floorHeight - y, z, sbb);
                }
            }
        }
    }
    
    @Override
    protected void decorateFloor(final World world, final Random rand, final int floor, final int bottom, final int top, final int ladderUpDir, final int ladderDownDir, final StructureBoundingBox sbb) {
        for (int y = 0; y < 3; ++y) {
            final int rotation = (ladderDownDir + y) % 4;
            final int rotation2 = (ladderDownDir + y + 2) % 4;
            this.placeIceStairs(world, sbb, rand, bottom + y * 3, rotation);
            this.placeIceStairs(world, sbb, rand, bottom + y * 3, rotation2);
        }
    }
    
    private void placeIceStairs(final World world, final StructureBoundingBox sbb, final Random rand, final int y, final int rotation) {
        this.fillBlocksRotated(world, sbb, 8, y + 1, 1, 10, y + 1, 3, Blocks.field_150403_cj, 0, rotation);
        if (y > 1) {
            this.randomlyFillBlocksRotated(world, sbb, rand, 0.5f, 8, y + 0, 1, 10, y + 0, 3, Blocks.field_150403_cj, 0, Blocks.field_150350_a, 0, rotation);
        }
        this.fillBlocksRotated(world, sbb, 11, y + 2, 1, 13, y + 2, 3, Blocks.field_150403_cj, 0, rotation);
        this.randomlyFillBlocksRotated(world, sbb, rand, 0.5f, 11, y + 1, 1, 13, y + 1, 3, Blocks.field_150403_cj, 0, Blocks.field_150350_a, 0, rotation);
        this.fillBlocksRotated(world, sbb, 11, y + 3, 4, 13, y + 3, 6, Blocks.field_150403_cj, 0, rotation);
        this.randomlyFillBlocksRotated(world, sbb, rand, 0.5f, 11, y + 2, 4, 13, y + 2, 6, Blocks.field_150403_cj, 0, Blocks.field_150350_a, 0, rotation);
    }
    
    @Override
    protected void decorateTopFloor(final World world, final Random rand, final int floor, final int bottom, final int top, final int ladderUpDir, final int ladderDownDir, final StructureBoundingBox sbb) {
    }
}
