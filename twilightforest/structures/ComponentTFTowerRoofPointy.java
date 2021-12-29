// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import net.minecraft.block.Block;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import java.util.Random;
import net.minecraft.world.World;

public class ComponentTFTowerRoofPointy extends ComponentTFTowerRoof
{
    public ComponentTFTowerRoofPointy(final int i, final ComponentTFTowerWing wing) {
        super(i, wing);
        this.setCoordBaseMode(wing.getCoordBaseMode());
        this.size = wing.size;
        this.height = this.size;
        this.makeCapBB(wing);
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        final int slabMeta = 2;
        for (int y = 0; y <= this.height; ++y) {
            final int slopeChange = this.slopeChangeForSize(this.size);
            int min;
            int max;
            if (y < slopeChange) {
                min = y;
                max = this.size - y - 1;
            }
            else {
                min = (y + slopeChange) / 2;
                max = this.size - (y + slopeChange) / 2 - 1;
            }
            final int mid = min + (max - min) / 2;
            for (int x = min; x <= max; ++x) {
                for (int z = min; z <= max; ++z) {
                    this.func_74864_a(world, Block.field_71988_x.field_71990_ca, slabMeta, x, y, z, sbb);
                    if ((x == min && (z == min || z == max)) || (x == max && (z == min || z == max))) {
                        this.func_74864_a(world, Block.field_72092_bO.field_71990_ca, slabMeta, x, y + 1, z, sbb);
                    }
                    if ((((x == min || x == max) && z == mid && x % 2 == 0) || ((z == min || z == max) && x == mid && z % 2 == 0)) && mid != min + 1) {
                        this.func_74864_a(world, Block.field_72092_bO.field_71990_ca, slabMeta, x, y + 1, z, sbb);
                    }
                }
            }
        }
        return true;
    }
    
    public int slopeChangeForSize(final int pSize) {
        if (this.size > 10) {
            return 3;
        }
        if (this.size > 6) {
            return 2;
        }
        return 1;
    }
}
