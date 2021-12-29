// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.finalcastle;

import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockStairs;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.World;
import java.util.Random;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.util.EnumFacing;
import twilightforest.TFFeature;
import twilightforest.structures.StructureTFComponentOld;

public class ComponentTFFinalCastleEntranceStairs extends StructureTFComponentOld
{
    public ComponentTFFinalCastleEntranceStairs() {
    }
    
    public ComponentTFFinalCastleEntranceStairs(final TFFeature feature, final int index, final int x, final int y, final int z, final EnumFacing direction) {
        super(feature, index);
        this.func_186164_a(direction);
        this.field_74887_e = StructureTFComponentOld.getComponentToAddBoundingBox2(x, y, z, 0, -1, -5, 12, 0, 12, direction);
    }
    
    public void func_74861_a(final StructureComponent parent, final List<StructureComponent> list, final Random rand) {
        if (parent != null && parent instanceof StructureTFComponentOld) {
            this.deco = ((StructureTFComponentOld)parent).deco;
        }
    }
    
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        for (int size = 13, x = 1; x < size; ++x) {
            this.placeStairs(world, sbb, x, 1 - x, 5, EnumFacing.EAST);
            for (int z = 0; z <= x; ++z) {
                if (z > 0 && z <= size / 2) {
                    this.placeStairs(world, sbb, x, 1 - x, 5 - z, EnumFacing.EAST);
                    this.placeStairs(world, sbb, x, 1 - x, 5 + z, EnumFacing.EAST);
                }
                if (x <= size / 2) {
                    this.placeStairs(world, sbb, z, 1 - x, 5 - x, EnumFacing.NORTH);
                    this.placeStairs(world, sbb, z, 1 - x, 5 + x, EnumFacing.SOUTH);
                }
            }
        }
        this.func_175808_b(world, this.deco.blockState, 0, 0, 5, sbb);
        return true;
    }
    
    private void placeStairs(final World world, final StructureBoundingBox sbb, final int x, final int y, final int z, final EnumFacing facing) {
        if (this.func_175807_a(world, x, y, z, sbb).func_177230_c().func_176200_f((IBlockAccess)world, this.getBlockPosWithOffset(x, y, z))) {
            this.func_175811_a(world, this.deco.stairState.func_177226_a((IProperty)BlockStairs.field_176309_a, (Comparable)facing), x, y, z, sbb);
            this.func_175808_b(world, this.deco.blockState, x, y - 1, z, sbb);
        }
    }
}
