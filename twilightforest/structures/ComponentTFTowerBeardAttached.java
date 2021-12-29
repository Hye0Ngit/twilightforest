// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;

public class ComponentTFTowerBeardAttached extends ComponentTFTowerBeard
{
    public ComponentTFTowerBeardAttached(final int i, final ComponentTFTowerWing wing) {
        super(i, wing);
        this.field_74887_e = new StructureBoundingBox(wing.func_74874_b().field_78897_a, wing.func_74874_b().field_78895_b - this.height - 1, wing.func_74874_b().field_78896_c, wing.func_74874_b().field_78893_d, wing.func_74874_b().field_78895_b - 1, wing.func_74874_b().field_78892_f);
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        return this.makeAttachedBeard(world, rand, sbb);
    }
    
    private boolean makeAttachedBeard(final World world, final Random rand, final StructureBoundingBox sbb) {
        for (int y = 0; y <= this.height; ++y) {
            final int min = y + 1;
            final int max = this.size - y;
            this.func_74882_a(world, sbb, 0, this.height - y, min, max, this.height - y, max, false, rand, StructureTFComponent.getStrongholdStones());
        }
        return true;
    }
}
