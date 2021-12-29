// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.minotaurmaze;

import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockHugeMushroom;
import net.minecraft.init.Blocks;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.World;
import net.minecraft.util.EnumFacing;
import java.util.Random;
import twilightforest.TFFeature;

public class ComponentTFMazeMushRoom extends ComponentTFMazeRoom
{
    public ComponentTFMazeMushRoom() {
    }
    
    public ComponentTFMazeMushRoom(final TFFeature feature, final int i, final Random rand, final int x, final int y, final int z) {
        super(feature, i, rand, x, y, z);
        this.func_186164_a(EnumFacing.SOUTH);
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        super.func_74875_a(world, rand, sbb);
        for (int x = 1; x < 14; ++x) {
            for (int z = 1; z < 14; ++z) {
                final int dist = (int)Math.round(7.0 / Math.sqrt((7.5 - x) * (7.5 - x) + (7.5 - z) * (7.5 - z)));
                if (rand.nextInt(dist + 1) > 0) {
                    this.func_175811_a(world, Blocks.field_150391_bh.func_176223_P(), x, 0, z, sbb);
                }
                if (rand.nextInt(dist) > 0) {
                    this.func_175811_a(world, (rand.nextBoolean() ? Blocks.field_150337_Q : Blocks.field_150338_P).func_176223_P(), x, 1, z, sbb);
                }
            }
        }
        final IBlockState redMushroomBlock = Blocks.field_150419_aX.func_176223_P();
        final IBlockState brownMushroomBlock = Blocks.field_150420_aW.func_176223_P();
        this.makeMediumMushroom(world, sbb, 5, 2, 9, redMushroomBlock);
        this.makeMediumMushroom(world, sbb, 5, 3, 9, redMushroomBlock);
        this.makeMediumMushroom(world, sbb, 9, 2, 5, redMushroomBlock);
        this.makeMediumMushroom(world, sbb, 6, 3, 4, brownMushroomBlock);
        this.makeMediumMushroom(world, sbb, 10, 1, 9, brownMushroomBlock);
        this.func_175811_a(world, redMushroomBlock.func_177226_a((IProperty)BlockHugeMushroom.field_176380_a, (Comparable)BlockHugeMushroom.EnumType.ALL_STEM), 1, 2, 1, sbb);
        this.func_175811_a(world, redMushroomBlock.func_177226_a((IProperty)BlockHugeMushroom.field_176380_a, (Comparable)BlockHugeMushroom.EnumType.CENTER), 1, 3, 1, sbb);
        this.func_175811_a(world, redMushroomBlock.func_177226_a((IProperty)BlockHugeMushroom.field_176380_a, (Comparable)BlockHugeMushroom.EnumType.NORTH_WEST), 2, 3, 1, sbb);
        this.func_175811_a(world, redMushroomBlock.func_177226_a((IProperty)BlockHugeMushroom.field_176380_a, (Comparable)BlockHugeMushroom.EnumType.NORTH_WEST), 1, 3, 2, sbb);
        this.func_175811_a(world, brownMushroomBlock.func_177226_a((IProperty)BlockHugeMushroom.field_176380_a, (Comparable)BlockHugeMushroom.EnumType.ALL_STEM), 14, 3, 1, sbb);
        this.func_175811_a(world, brownMushroomBlock.func_177226_a((IProperty)BlockHugeMushroom.field_176380_a, (Comparable)BlockHugeMushroom.EnumType.CENTER), 14, 4, 1, sbb);
        this.func_175811_a(world, brownMushroomBlock.func_177226_a((IProperty)BlockHugeMushroom.field_176380_a, (Comparable)BlockHugeMushroom.EnumType.NORTH_EAST), 13, 4, 1, sbb);
        this.func_175811_a(world, brownMushroomBlock.func_177226_a((IProperty)BlockHugeMushroom.field_176380_a, (Comparable)BlockHugeMushroom.EnumType.NORTH_EAST), 14, 4, 2, sbb);
        this.func_175811_a(world, brownMushroomBlock.func_177226_a((IProperty)BlockHugeMushroom.field_176380_a, (Comparable)BlockHugeMushroom.EnumType.ALL_STEM), 1, 1, 14, sbb);
        this.func_175811_a(world, brownMushroomBlock.func_177226_a((IProperty)BlockHugeMushroom.field_176380_a, (Comparable)BlockHugeMushroom.EnumType.CENTER), 1, 2, 14, sbb);
        this.func_175811_a(world, brownMushroomBlock.func_177226_a((IProperty)BlockHugeMushroom.field_176380_a, (Comparable)BlockHugeMushroom.EnumType.SOUTH_WEST), 2, 2, 14, sbb);
        this.func_175811_a(world, brownMushroomBlock.func_177226_a((IProperty)BlockHugeMushroom.field_176380_a, (Comparable)BlockHugeMushroom.EnumType.SOUTH_WEST), 1, 2, 13, sbb);
        this.func_175811_a(world, brownMushroomBlock.func_177226_a((IProperty)BlockHugeMushroom.field_176380_a, (Comparable)BlockHugeMushroom.EnumType.CENTER), 14, 1, 14, sbb);
        this.func_175811_a(world, brownMushroomBlock.func_177226_a((IProperty)BlockHugeMushroom.field_176380_a, (Comparable)BlockHugeMushroom.EnumType.SOUTH_EAST), 13, 1, 14, sbb);
        this.func_175811_a(world, brownMushroomBlock.func_177226_a((IProperty)BlockHugeMushroom.field_176380_a, (Comparable)BlockHugeMushroom.EnumType.SOUTH_EAST), 14, 1, 13, sbb);
        return true;
    }
    
    private void makeMediumMushroom(final World world, final StructureBoundingBox sbb, final int mx, final int my, final int mz, final IBlockState redMushroomBlock) {
        this.func_175811_a(world, redMushroomBlock.func_177226_a((IProperty)BlockHugeMushroom.field_176380_a, (Comparable)BlockHugeMushroom.EnumType.CENTER), mx + 0, my, mz + 0, sbb);
        this.func_175811_a(world, redMushroomBlock.func_177226_a((IProperty)BlockHugeMushroom.field_176380_a, (Comparable)BlockHugeMushroom.EnumType.WEST), mx + 1, my, mz + 0, sbb);
        this.func_175811_a(world, redMushroomBlock.func_177226_a((IProperty)BlockHugeMushroom.field_176380_a, (Comparable)BlockHugeMushroom.EnumType.NORTH_WEST), mx + 1, my, mz + 1, sbb);
        this.func_175811_a(world, redMushroomBlock.func_177226_a((IProperty)BlockHugeMushroom.field_176380_a, (Comparable)BlockHugeMushroom.EnumType.NORTH), mx + 0, my, mz + 1, sbb);
        this.func_175811_a(world, redMushroomBlock.func_177226_a((IProperty)BlockHugeMushroom.field_176380_a, (Comparable)BlockHugeMushroom.EnumType.NORTH_EAST), mx - 1, my, mz + 1, sbb);
        this.func_175811_a(world, redMushroomBlock.func_177226_a((IProperty)BlockHugeMushroom.field_176380_a, (Comparable)BlockHugeMushroom.EnumType.EAST), mx - 1, my, mz + 0, sbb);
        this.func_175811_a(world, redMushroomBlock.func_177226_a((IProperty)BlockHugeMushroom.field_176380_a, (Comparable)BlockHugeMushroom.EnumType.SOUTH_EAST), mx - 1, my, mz - 1, sbb);
        this.func_175811_a(world, redMushroomBlock.func_177226_a((IProperty)BlockHugeMushroom.field_176380_a, (Comparable)BlockHugeMushroom.EnumType.SOUTH), mx + 0, my, mz - 1, sbb);
        this.func_175811_a(world, redMushroomBlock.func_177226_a((IProperty)BlockHugeMushroom.field_176380_a, (Comparable)BlockHugeMushroom.EnumType.SOUTH_WEST), mx + 1, my, mz - 1, sbb);
        for (int y = 1; y < my; ++y) {
            this.func_175811_a(world, redMushroomBlock.func_177226_a((IProperty)BlockHugeMushroom.field_176380_a, (Comparable)BlockHugeMushroom.EnumType.STEM), mx + 0, y, mz + 0, sbb);
        }
    }
}
