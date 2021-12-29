// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.icetower;

import net.minecraft.world.IBlockAccess;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.World;
import twilightforest.structures.StructureTFComponentOld;
import java.util.Random;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.util.EnumFacing;
import twilightforest.TFFeature;
import twilightforest.structures.lichtower.ComponentTFTowerWing;

public class ComponentTFIceTowerStairs extends ComponentTFTowerWing
{
    public ComponentTFIceTowerStairs() {
    }
    
    public ComponentTFIceTowerStairs(final TFFeature feature, final int index, final int x, final int y, final int z, final int size, final int height, final EnumFacing direction) {
        super(feature, index, x, y, z, size, height, direction);
    }
    
    @Override
    public void func_74861_a(final StructureComponent parent, final List<StructureComponent> list, final Random rand) {
        if (parent != null && parent instanceof StructureTFComponentOld) {
            this.deco = ((StructureTFComponentOld)parent).deco;
        }
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        for (int x = 1; x < this.size; ++x) {
            this.placeStairs(world, sbb, x, 1 - x, 5, 2);
            for (int z = 0; z <= x; ++z) {
                if (z > 0 && z <= this.size / 2) {
                    this.placeStairs(world, sbb, x, 1 - x, 5 - z, 2);
                    this.placeStairs(world, sbb, x, 1 - x, 5 + z, 2);
                }
                if (x <= this.size / 2) {
                    this.placeStairs(world, sbb, z, 1 - x, 5 - x, 1);
                    this.placeStairs(world, sbb, z, 1 - x, 5 + x, 3);
                }
            }
        }
        this.func_175811_a(world, this.deco.blockState, 0, 0, 5, sbb);
        return true;
    }
    
    private void placeStairs(final World world, final StructureBoundingBox sbb, final int x, final int y, final int z, final int stairMeta) {
        final BlockPos pos = new BlockPos(x, y, z);
        if (this.func_175807_a(world, x, y, z, sbb).func_177230_c().func_176200_f((IBlockAccess)world, pos)) {
            this.func_175811_a(world, this.deco.blockState, x, y, z, sbb);
            this.func_175811_a(world, this.deco.blockState, x, y - 1, z, sbb);
        }
    }
}
