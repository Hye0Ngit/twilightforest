// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.minotaurmaze;

import net.minecraft.init.Blocks;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.util.EnumFacing;
import twilightforest.TFFeature;

public class ComponentTFMazeDeadEndFountainLava extends ComponentTFMazeDeadEndFountain
{
    public ComponentTFMazeDeadEndFountainLava() {
    }
    
    public ComponentTFMazeDeadEndFountainLava(final TFFeature feature, final int i, final int x, final int y, final int z, final EnumFacing rotation) {
        super(feature, i, x, y, z, rotation);
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        super.func_74875_a(world, rand, sbb);
        this.func_175811_a(world, ComponentTFMazeDeadEndFountainLava.AIR, 2, 3, 4, sbb);
        this.func_175811_a(world, ComponentTFMazeDeadEndFountainLava.AIR, 3, 3, 4, sbb);
        this.func_175811_a(world, Blocks.field_150356_k.func_176223_P(), 2, 3, 4, sbb);
        this.func_175811_a(world, Blocks.field_150356_k.func_176223_P(), 3, 3, 4, sbb);
        return true;
    }
}
