// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.lichtower;

import net.minecraft.init.Blocks;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import java.util.Random;
import net.minecraft.world.World;
import twilightforest.TFFeature;

public class ComponentTFTowerRoofFence extends ComponentTFTowerRoof
{
    public ComponentTFTowerRoofFence() {
    }
    
    public ComponentTFTowerRoofFence(final TFFeature feature, final int i, final ComponentTFTowerWing wing) {
        super(feature, i, wing);
        this.func_186164_a(wing.func_186165_e());
        this.size = wing.size;
        this.height = 0;
        this.makeCapBB(wing);
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        final int y = this.height + 1;
        for (int x = 0; x <= this.size - 1; ++x) {
            for (int z = 0; z <= this.size - 1; ++z) {
                if (x == 0 || x == this.size - 1 || z == 0 || z == this.size - 1) {
                    this.func_175811_a(world, Blocks.field_180407_aO.func_176223_P(), x, y, z, sbb);
                }
            }
        }
        return true;
    }
}
