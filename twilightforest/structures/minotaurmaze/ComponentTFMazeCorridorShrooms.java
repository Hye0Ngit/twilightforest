// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.minotaurmaze;

import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockHugeMushroom;
import net.minecraft.init.Blocks;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.util.EnumFacing;
import twilightforest.TFFeature;

public class ComponentTFMazeCorridorShrooms extends ComponentTFMazeCorridor
{
    public ComponentTFMazeCorridorShrooms() {
    }
    
    public ComponentTFMazeCorridorShrooms(final TFFeature feature, final int i, final int x, final int y, final int z, final EnumFacing rotation) {
        super(feature, i, x, y, z, rotation);
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        for (int x = 1; x < 5; ++x) {
            for (int z = 0; z < 5; ++z) {
                if (rand.nextInt(2) > 0) {
                    this.func_175811_a(world, Blocks.field_150391_bh.func_176223_P(), x, 0, z, sbb);
                }
                if (rand.nextInt(2) > 0) {
                    this.func_175811_a(world, rand.nextBoolean() ? Blocks.field_150337_Q.func_176223_P() : Blocks.field_150338_P.func_176223_P(), x, 1, z, sbb);
                }
            }
        }
        final boolean mushFlag = rand.nextBoolean();
        IBlockState mushType = (mushFlag ? Blocks.field_150419_aX : Blocks.field_150420_aW).func_176223_P();
        int mushY = rand.nextInt(4) + 1;
        int mushZ = rand.nextInt(4) + 1;
        this.func_175811_a(world, mushType.func_177226_a((IProperty)BlockHugeMushroom.field_176380_a, (Comparable)BlockHugeMushroom.EnumType.ALL_STEM), 1, mushY - 1, mushZ, sbb);
        this.func_175804_a(world, sbb, 1, 1, mushZ, 1, mushY, mushZ, mushType.func_177226_a((IProperty)BlockHugeMushroom.field_176380_a, (Comparable)BlockHugeMushroom.EnumType.STEM), ComponentTFMazeCorridorShrooms.AIR, false);
        this.func_175804_a(world, sbb, 1, mushY, mushZ - 1, 2, mushY, mushZ + 1, mushType.func_177226_a((IProperty)BlockHugeMushroom.field_176380_a, (Comparable)BlockHugeMushroom.EnumType.ALL_OUTSIDE), ComponentTFMazeCorridorShrooms.AIR, false);
        mushType = (mushFlag ? Blocks.field_150420_aW : Blocks.field_150419_aX).func_176223_P();
        mushY = rand.nextInt(4) + 1;
        mushZ = rand.nextInt(4) + 1;
        this.func_175804_a(world, sbb, 4, 1, mushZ, 4, mushY, mushZ, mushType.func_177226_a((IProperty)BlockHugeMushroom.field_176380_a, (Comparable)BlockHugeMushroom.EnumType.STEM), ComponentTFMazeCorridorShrooms.AIR, false);
        this.func_175804_a(world, sbb, 3, mushY, mushZ - 1, 4, mushY, mushZ + 1, mushType.func_177226_a((IProperty)BlockHugeMushroom.field_176380_a, (Comparable)BlockHugeMushroom.EnumType.ALL_OUTSIDE), ComponentTFMazeCorridorShrooms.AIR, false);
        return true;
    }
}
