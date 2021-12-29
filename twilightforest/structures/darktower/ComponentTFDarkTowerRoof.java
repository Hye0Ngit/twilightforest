// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.darktower;

import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.World;
import twilightforest.structures.StructureTFComponentOld;
import java.util.Random;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import twilightforest.structures.lichtower.ComponentTFTowerWing;
import twilightforest.TFFeature;
import twilightforest.structures.lichtower.ComponentTFTowerRoof;

public class ComponentTFDarkTowerRoof extends ComponentTFTowerRoof
{
    public ComponentTFDarkTowerRoof() {
    }
    
    public ComponentTFDarkTowerRoof(final TFFeature feature, final int i, final ComponentTFTowerWing wing) {
        super(feature, i, wing);
        this.func_186164_a(wing.func_186165_e());
        this.size = wing.size;
        this.height = 12;
        this.makeCapBB(wing);
        this.spawnListIndex = 1;
    }
    
    public void func_74861_a(final StructureComponent parent, final List<StructureComponent> list, final Random rand) {
        if (parent != null && parent instanceof StructureTFComponentOld) {
            this.deco = ((StructureTFComponentOld)parent).deco;
        }
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        for (int x = 0; x <= this.size - 1; ++x) {
            for (int z = 0; z <= this.size - 1; ++z) {
                if (x == 0 || x == this.size - 1 || z == 0 || z == this.size - 1) {
                    this.func_175811_a(world, this.deco.fenceState, x, 1, z, sbb);
                }
            }
        }
        this.func_175811_a(world, this.deco.accentState, 0, 1, 0, sbb);
        this.func_175811_a(world, this.deco.accentState, this.size - 1, 1, 0, sbb);
        this.func_175811_a(world, this.deco.accentState, 0, 1, this.size - 1, sbb);
        this.func_175811_a(world, this.deco.accentState, this.size - 1, 1, this.size - 1, sbb);
        return true;
    }
}
