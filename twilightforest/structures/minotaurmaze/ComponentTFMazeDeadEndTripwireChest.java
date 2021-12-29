// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.minotaurmaze;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.util.EnumFacing;
import twilightforest.TFFeature;

public class ComponentTFMazeDeadEndTripwireChest extends ComponentTFMazeDeadEndChest
{
    public ComponentTFMazeDeadEndTripwireChest() {
    }
    
    public ComponentTFMazeDeadEndTripwireChest(final TFFeature feature, final int i, final int x, final int y, final int z, final EnumFacing rotation) {
        super(feature, i, x, y, z, rotation);
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        super.func_74875_a(world, rand, sbb);
        this.placeTripwire(world, 1, 1, 2, 3, EnumFacing.EAST, sbb);
        final IBlockState tnt = Blocks.field_150335_W.func_176223_P();
        this.func_175811_a(world, tnt, 0, 0, 2, sbb);
        this.func_175811_a(world, ComponentTFMazeDeadEndTripwireChest.AIR, 0, -1, 2, sbb);
        this.func_175811_a(world, ComponentTFMazeDeadEndTripwireChest.AIR, 1, -1, 2, sbb);
        this.func_175811_a(world, tnt, 2, 0, 4, sbb);
        this.func_175811_a(world, tnt, 3, 0, 4, sbb);
        this.func_175811_a(world, tnt, 2, 0, 3, sbb);
        this.func_175811_a(world, tnt, 3, 0, 3, sbb);
        return true;
    }
}
