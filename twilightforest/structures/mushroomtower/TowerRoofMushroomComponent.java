// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.mushroomtower;

import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.ISeedReader;
import twilightforest.structures.TFStructureComponentOld;
import java.util.Random;
import java.util.List;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.Direction;
import twilightforest.structures.lichtower.TowerWingComponent;
import twilightforest.TFFeature;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.gen.feature.template.TemplateManager;
import twilightforest.structures.lichtower.TowerRoofComponent;

public class TowerRoofMushroomComponent extends TowerRoofComponent
{
    public TowerRoofMushroomComponent(final TemplateManager manager, final CompoundNBT nbt) {
        super(MushroomTowerPieces.TFMTRoofMush, nbt);
    }
    
    public TowerRoofMushroomComponent(final TFFeature feature, final int i, final TowerWingComponent wing, final float pHang) {
        super(MushroomTowerPieces.TFMTRoofMush, feature, i);
        this.height = wing.size;
        final int overhang = (int)(this.height * pHang);
        this.size = this.height + overhang * 2;
        this.func_186164_a(Direction.SOUTH);
        this.field_74887_e = new MutableBoundingBox(wing.func_74874_b().field_78897_a - overhang, wing.func_74874_b().field_78894_e + 2, wing.func_74874_b().field_78896_c - overhang, wing.func_74874_b().field_78893_d + overhang, wing.func_74874_b().field_78894_e + this.height + 1, wing.func_74874_b().field_78892_f + overhang);
    }
    
    public void func_74861_a(final StructurePiece parent, final List<StructurePiece> list, final Random rand) {
        if (parent != null && parent instanceof TFStructureComponentOld) {
            this.deco = ((TFStructureComponentOld)parent).deco;
        }
    }
    
    @Override
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random rand, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
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
    
    private void makeCircle(final ISeedReader world, final int y, final int radius, final int hollow, final MutableBoundingBox sbb) {
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
