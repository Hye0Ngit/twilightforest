// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.darktower;

import net.minecraft.world.gen.structure.StructureBoundingBox;
import java.util.Random;
import net.minecraft.world.World;
import twilightforest.structures.lichtower.ComponentTFTowerWing;
import twilightforest.TFFeature;

public class ComponentTFDarkTowerRoofCactus extends ComponentTFDarkTowerRoof
{
    public ComponentTFDarkTowerRoofCactus() {
    }
    
    public ComponentTFDarkTowerRoofCactus(final TFFeature feature, final int i, final ComponentTFTowerWing wing) {
        super(feature, i, wing);
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        super.func_74875_a(world, rand, sbb);
        for (int y = 1; y < 10; ++y) {
            this.func_175811_a(world, this.deco.blockState, this.size / 2, y, this.size / 2, sbb);
        }
        this.func_175811_a(world, this.deco.accentState, this.size / 2, 10, this.size / 2, sbb);
        this.func_175811_a(world, this.deco.accentState, this.size / 2 - 1, 1, this.size / 2, sbb);
        this.func_175811_a(world, this.deco.accentState, this.size / 2 + 1, 1, this.size / 2, sbb);
        this.func_175811_a(world, this.deco.accentState, this.size / 2, 1, this.size / 2 - 1, sbb);
        this.func_175811_a(world, this.deco.accentState, this.size / 2, 1, this.size / 2 + 1, sbb);
        this.func_175811_a(world, this.deco.accentState, this.size / 2 + 1, 7, this.size / 2, sbb);
        this.func_175811_a(world, this.deco.accentState, this.size / 2 + 2, 7, this.size / 2, sbb);
        this.func_175811_a(world, this.deco.accentState, this.size / 2 + 2, 8, this.size / 2, sbb);
        this.func_175811_a(world, this.deco.accentState, this.size / 2 + 2, 9, this.size / 2, sbb);
        this.func_175811_a(world, this.deco.accentState, this.size / 2 + 3, 9, this.size / 2, sbb);
        this.func_175811_a(world, this.deco.accentState, this.size / 2, 6, this.size / 2 + 1, sbb);
        this.func_175811_a(world, this.deco.accentState, this.size / 2, 6, this.size / 2 + 2, sbb);
        this.func_175811_a(world, this.deco.accentState, this.size / 2, 7, this.size / 2 + 2, sbb);
        this.func_175811_a(world, this.deco.accentState, this.size / 2, 8, this.size / 2 + 2, sbb);
        this.func_175811_a(world, this.deco.accentState, this.size / 2, 8, this.size / 2 + 3, sbb);
        this.func_175811_a(world, this.deco.accentState, this.size / 2 - 1, 5, this.size / 2, sbb);
        this.func_175811_a(world, this.deco.accentState, this.size / 2 - 2, 5, this.size / 2, sbb);
        this.func_175811_a(world, this.deco.accentState, this.size / 2 - 2, 6, this.size / 2, sbb);
        this.func_175811_a(world, this.deco.accentState, this.size / 2 - 2, 7, this.size / 2, sbb);
        this.func_175811_a(world, this.deco.accentState, this.size / 2 - 3, 7, this.size / 2, sbb);
        this.func_175811_a(world, this.deco.accentState, this.size / 2, 4, this.size / 2 - 1, sbb);
        this.func_175811_a(world, this.deco.accentState, this.size / 2, 4, this.size / 2 - 2, sbb);
        this.func_175811_a(world, this.deco.accentState, this.size / 2, 5, this.size / 2 - 2, sbb);
        this.func_175811_a(world, this.deco.accentState, this.size / 2, 6, this.size / 2 - 2, sbb);
        this.func_175811_a(world, this.deco.accentState, this.size / 2, 6, this.size / 2 - 3, sbb);
        return true;
    }
}
