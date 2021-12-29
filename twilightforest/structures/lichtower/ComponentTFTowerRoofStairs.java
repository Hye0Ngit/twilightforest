// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.lichtower;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import java.util.Random;
import net.minecraft.world.World;

public class ComponentTFTowerRoofStairs extends ComponentTFTowerRoof
{
    public ComponentTFTowerRoofStairs() {
    }
    
    public ComponentTFTowerRoofStairs(final int i, final ComponentTFTowerWing wing) {
        super(i, wing);
        this.setCoordBaseMode(0);
        this.size = wing.size;
        this.height = this.size / 2;
        this.makeCapBB(wing);
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        for (int y = 0; y <= this.height; ++y) {
            final int min = y;
            for (int max = this.size - y - 1, x = min; x <= max; ++x) {
                for (int z = min; z <= max; ++z) {
                    if (x == min) {
                        if (z == min || z == max) {
                            this.func_151550_a(world, (Block)Blocks.field_150376_bx, 2, x, y, z, sbb);
                        }
                        else {
                            this.func_151550_a(world, Blocks.field_150487_bG, 0, x, y, z, sbb);
                        }
                    }
                    else if (x == max) {
                        if (z == min || z == max) {
                            this.func_151550_a(world, (Block)Blocks.field_150376_bx, 2, x, y, z, sbb);
                        }
                        else {
                            this.func_151550_a(world, Blocks.field_150487_bG, 1, x, y, z, sbb);
                        }
                    }
                    else if (z == max) {
                        this.func_151550_a(world, Blocks.field_150487_bG, 3, x, y, z, sbb);
                    }
                    else if (z == min) {
                        this.func_151550_a(world, Blocks.field_150487_bG, 2, x, y, z, sbb);
                    }
                    else {
                        this.func_151550_a(world, Blocks.field_150344_f, 2, x, y, z, sbb);
                    }
                }
            }
        }
        return true;
    }
}
