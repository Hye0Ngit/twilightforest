// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.mushroomtower;

import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import twilightforest.structures.StructureTFComponentOld;
import java.util.Random;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.util.EnumFacing;
import twilightforest.structures.lichtower.ComponentTFTowerWing;
import twilightforest.TFFeature;
import twilightforest.structures.lichtower.ComponentTFTowerRoof;

public class ComponentTFTowerRoofMushroom extends ComponentTFTowerRoof
{
    public ComponentTFTowerRoofMushroom(final TFFeature feature, final int i, final ComponentTFTowerWing wing, final float pHang) {
        super(feature, i, wing);
        this.height = wing.size;
        final int overhang = (int)(wing.size * pHang);
        this.size = wing.size + overhang * 2;
        this.func_186164_a(EnumFacing.SOUTH);
        this.field_74887_e = new StructureBoundingBox(wing.func_74874_b().field_78897_a - overhang, wing.func_74874_b().field_78894_e + 2, wing.func_74874_b().field_78896_c - overhang, wing.func_74874_b().field_78893_d + overhang, wing.func_74874_b().field_78894_e + this.height + 1, wing.func_74874_b().field_78892_f + overhang);
    }
    
    public void func_74861_a(final StructureComponent parent, final List<StructureComponent> list, final Random rand) {
        if (parent != null && parent instanceof StructureTFComponentOld) {
            this.deco = ((StructureTFComponentOld)parent).deco;
        }
    }
    
    public ComponentTFTowerRoofMushroom() {
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        for (int y = 0; y <= this.height; ++y) {
            final int radius = (int)(MathHelper.func_76126_a((y + this.height / 1.2f) / (this.height * 2.05f) * 3.14f) * this.size / 2.0f);
            int hollow = MathHelper.func_76141_d(radius * 0.9f);
            if (this.height - y < 3) {
                hollow = -1;
            }
            this.makeCircle(world, y, radius, hollow, sbb);
        }
        return true;
    }
    
    private void makeCircle(final World world, final int y, final int radius, final int hollow, final StructureBoundingBox sbb) {
        final int cx = this.size / 2;
        final int cz = this.size / 2;
        for (int dx = -radius; dx <= radius; ++dx) {
            for (int dz = -radius; dz <= radius; ++dz) {
                final float dist = MathHelper.func_76129_c((float)(dx * dx + dz * dz));
                if (dist <= radius + 0.5f) {
                    if (dist > hollow) {
                        this.func_175811_a(world, this.deco.accentState, dx + cx, y, dz + cz, sbb);
                    }
                    else {
                        this.func_175811_a(world, this.deco.accentState.func_177230_c().func_176223_P(), dx + cx, y, dz + cz, sbb);
                    }
                }
            }
        }
    }
}
