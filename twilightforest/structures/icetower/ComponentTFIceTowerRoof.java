// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.icetower;

import net.minecraft.util.math.MathHelper;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import java.util.Random;
import net.minecraft.world.World;
import twilightforest.structures.lichtower.ComponentTFTowerWing;
import twilightforest.TFFeature;
import twilightforest.structures.lichtower.ComponentTFTowerRoof;

public class ComponentTFIceTowerRoof extends ComponentTFTowerRoof
{
    public ComponentTFIceTowerRoof() {
    }
    
    public ComponentTFIceTowerRoof(final TFFeature feature, final int i, final ComponentTFTowerWing wing) {
        super(feature, i, wing);
        this.func_186164_a(wing.func_186165_e());
        this.size = wing.size;
        this.height = 12;
        this.deco = wing.deco;
        this.makeCapBB(wing);
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        super.func_74875_a(world, rand, sbb);
        for (int x = 0; x < this.size; ++x) {
            for (int z = 0; z < this.size; ++z) {
                for (int rHeight = Math.round(MathHelper.func_76129_c((float)(x * x + z * z))), y = 0; y < rHeight; ++y) {
                    this.func_175811_a(world, this.deco.blockState, x, y, z, sbb);
                }
            }
        }
        return true;
    }
}
