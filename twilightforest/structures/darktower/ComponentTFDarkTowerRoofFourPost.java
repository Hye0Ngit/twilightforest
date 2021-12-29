// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.darktower;

import net.minecraft.world.gen.structure.StructureBoundingBox;
import java.util.Random;
import net.minecraft.world.World;
import twilightforest.structures.lichtower.ComponentTFTowerWing;
import twilightforest.TFFeature;

public class ComponentTFDarkTowerRoofFourPost extends ComponentTFDarkTowerRoof
{
    public ComponentTFDarkTowerRoofFourPost() {
    }
    
    public ComponentTFDarkTowerRoofFourPost(final TFFeature feature, final int i, final ComponentTFTowerWing wing) {
        super(feature, i, wing);
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        super.func_74875_a(world, rand, sbb);
        this.makeSmallAntenna(world, sbb, 4, this.size - 2, this.size - 2);
        this.makeSmallAntenna(world, sbb, 5, 1, this.size - 2);
        this.makeSmallAntenna(world, sbb, 6, this.size - 2, 1);
        this.makeSmallAntenna(world, sbb, 7, 1, 1);
        return true;
    }
    
    private void makeSmallAntenna(final World world, final StructureBoundingBox sbb, final int height, final int x, final int z) {
        for (int y = 1; y < height; ++y) {
            this.func_175811_a(world, this.deco.blockState, x, y, z, sbb);
        }
        this.func_175811_a(world, this.deco.accentState, x, height + 0, z, sbb);
        this.func_175811_a(world, this.deco.accentState, x, height + 1, z, sbb);
        this.func_175811_a(world, this.deco.accentState, x + 1, height + 1, z, sbb);
        this.func_175811_a(world, this.deco.accentState, x - 1, height + 1, z, sbb);
        this.func_175811_a(world, this.deco.accentState, x, height + 1, z + 1, sbb);
        this.func_175811_a(world, this.deco.accentState, x, height + 1, z - 1, sbb);
        this.func_175811_a(world, this.deco.accentState, x, height + 2, z, sbb);
    }
}
