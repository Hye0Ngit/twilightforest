// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import net.minecraft.block.Block;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;

public class ComponentTFTowerRoofStairsOverhang extends ComponentTFTowerRoof
{
    public ComponentTFTowerRoofStairsOverhang(final int i, final ComponentTFTowerWing wing) {
        super(i, wing);
        this.setCoordBaseMode(0);
        this.size = wing.size + 2;
        this.height = this.size / 2;
        this.field_74887_e = new StructureBoundingBox(wing.func_74874_b().field_78897_a - 1, wing.func_74874_b().field_78894_e, wing.func_74874_b().field_78896_c - 1, wing.func_74874_b().field_78893_d + 1, wing.func_74874_b().field_78894_e + this.height - 1, wing.func_74874_b().field_78892_f + 1);
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        for (int y = 0; y <= this.height; ++y) {
            final int min = y;
            for (int max = this.size - y - 1, x = min; x <= max; ++x) {
                for (int z = min; z <= max; ++z) {
                    if (x == min) {
                        if (z == min || z == max) {
                            this.func_74864_a(world, Block.field_72092_bO.field_71990_ca, 2, x, y, z, sbb);
                        }
                        else {
                            this.func_74864_a(world, Block.field_72072_bX.field_71990_ca, 0, x, y, z, sbb);
                        }
                    }
                    else if (x == max) {
                        if (z == min || z == max) {
                            this.func_74864_a(world, Block.field_72092_bO.field_71990_ca, 2, x, y, z, sbb);
                        }
                        else {
                            this.func_74864_a(world, Block.field_72072_bX.field_71990_ca, 1, x, y, z, sbb);
                        }
                    }
                    else if (z == max) {
                        this.func_74864_a(world, Block.field_72072_bX.field_71990_ca, 3, x, y, z, sbb);
                    }
                    else if (z == min) {
                        this.func_74864_a(world, Block.field_72072_bX.field_71990_ca, 2, x, y, z, sbb);
                    }
                    else {
                        this.func_74864_a(world, Block.field_71988_x.field_71990_ca, 2, x, y, z, sbb);
                    }
                }
            }
        }
        return true;
    }
}
