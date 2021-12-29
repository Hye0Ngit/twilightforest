// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.icetower;

import net.minecraft.block.properties.IProperty;
import twilightforest.enums.BossVariant;
import twilightforest.block.BlockTFBossSpawner;
import twilightforest.block.TFBlocks;
import net.minecraft.util.Rotation;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.World;
import java.util.Random;
import net.minecraft.util.EnumFacing;
import twilightforest.TFFeature;

public class ComponentTFIceTowerBossWing extends ComponentTFIceTowerWing
{
    public ComponentTFIceTowerBossWing() {
        this.spawnListIndex = -1;
    }
    
    public ComponentTFIceTowerBossWing(final TFFeature feature, final int index, final int x, final int y, final int z, final int wingSize, final int wingHeight, final EnumFacing direction) {
        super(feature, index, x, y, z, wingSize, wingHeight, direction);
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
                final IBlockState ice = ((rand.nextInt(4) == 0) ? Blocks.field_150432_aD : Blocks.field_150403_cj).func_176223_P();
                for (int thickness = 1 + rand.nextInt(2) + rand.nextInt(2) + rand.nextInt(2), y = 0; y < thickness; ++y) {
                    this.func_175811_a(world, ice, x, floor * floorHeight + floorHeight - y, z, sbb);
                }
            }
        }
    }
    
    @Override
    protected void decorateFloor(final World world, final Random rand, final int floor, final int bottom, final int top, final Rotation ladderUpDir, final Rotation ladderDownDir, final StructureBoundingBox sbb) {
        Rotation r = ladderDownDir;
        for (int y = 0; y < 3; ++y) {
            this.placeIceStairs(world, sbb, rand, bottom + y * 3, r);
            this.placeIceStairs(world, sbb, rand, bottom + y * 3, r.func_185830_a(Rotation.CLOCKWISE_180));
            r = r.func_185830_a(Rotation.CLOCKWISE_90);
        }
    }
    
    private void placeIceStairs(final World world, final StructureBoundingBox sbb, final Random rand, final int y, final Rotation rotation) {
        final IBlockState packedIce = Blocks.field_150403_cj.func_176223_P();
        this.fillBlocksRotated(world, sbb, 8, y + 1, 1, 10, y + 1, 3, packedIce, rotation);
        if (y > 1) {
            this.randomlyFillBlocksRotated(world, sbb, rand, 0.5f, 8, y + 0, 1, 10, y + 0, 3, packedIce, ComponentTFIceTowerBossWing.AIR, rotation);
        }
        this.fillBlocksRotated(world, sbb, 11, y + 2, 1, 13, y + 2, 3, packedIce, rotation);
        this.randomlyFillBlocksRotated(world, sbb, rand, 0.5f, 11, y + 1, 1, 13, y + 1, 3, packedIce, ComponentTFIceTowerBossWing.AIR, rotation);
        this.fillBlocksRotated(world, sbb, 11, y + 3, 4, 13, y + 3, 6, packedIce, rotation);
        this.randomlyFillBlocksRotated(world, sbb, rand, 0.5f, 11, y + 2, 4, 13, y + 2, 6, packedIce, ComponentTFIceTowerBossWing.AIR, rotation);
    }
    
    @Override
    protected void decorateTopFloor(final World world, final Random rand, final int floor, final int bottom, final int top, final Rotation ladderUpDir, final Rotation ladderDownDir, final StructureBoundingBox sbb) {
        for (int x = 1; x < this.size - 1; ++x) {
            for (int z = 1; z < this.size - 1; ++z) {
                final IBlockState ice = ((rand.nextInt(10) == 0) ? Blocks.field_150426_aN : Blocks.field_150403_cj).func_176223_P();
                for (int thickness = rand.nextInt(2) + rand.nextInt(2), y = 0; y < thickness; ++y) {
                    this.func_175811_a(world, ice, x, top - 1 - y, z, sbb);
                }
            }
        }
        final IBlockState snowQueenSpawner = TFBlocks.boss_spawner.func_176223_P().func_177226_a((IProperty)BlockTFBossSpawner.VARIANT, (Comparable)BossVariant.SNOW_QUEEN);
        this.setBlockStateRotated(world, snowQueenSpawner, 7, top - 6, 7, Rotation.NONE, sbb);
        this.func_74878_a(world, sbb, 5, top - 3, 5, 9, top - 1, 9);
    }
}
