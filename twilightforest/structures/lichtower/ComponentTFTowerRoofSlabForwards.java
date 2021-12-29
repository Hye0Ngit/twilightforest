// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.lichtower;

import net.minecraft.block.Block;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import java.util.Random;
import net.minecraft.world.World;

public class ComponentTFTowerRoofSlabForwards extends ComponentTFTowerRoofSlab
{
    public ComponentTFTowerRoofSlabForwards() {
    }
    
    public ComponentTFTowerRoofSlabForwards(final int i, final ComponentTFTowerWing wing) {
        super(i, wing);
        this.setCoordBaseMode(wing.getCoordBaseMode());
        this.size = wing.size + 2;
        this.height = this.size / 2;
        this.makeAttachedOverhangBB(wing);
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        for (int y = 0; y <= this.height; ++y) {
            final int min = 2 * y;
            for (int max = this.size - 2 * y - 1, x = 0; x <= max - 1; ++x) {
                for (int z = min; z <= max; ++z) {
                    if (x == max - 1 || z == min || z == max) {
                        this.func_74864_a(world, Block.field_72092_bO.field_71990_ca, 2, x, y, z, sbb);
                    }
                    else {
                        this.func_74864_a(world, Block.field_72090_bN.field_71990_ca, 2, x, y, z, sbb);
                    }
                }
            }
        }
        return true;
    }
}
