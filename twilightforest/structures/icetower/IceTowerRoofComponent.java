// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.icetower;

import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import java.util.Random;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.ISeedReader;
import twilightforest.structures.lichtower.TowerWingComponent;
import twilightforest.TFFeature;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.gen.feature.template.TemplateManager;
import twilightforest.structures.lichtower.TowerRoofComponent;

public class IceTowerRoofComponent extends TowerRoofComponent
{
    public IceTowerRoofComponent(final TemplateManager manager, final CompoundNBT nbt) {
        super(IceTowerPieces.TFITRoof, nbt);
    }
    
    public IceTowerRoofComponent(final TFFeature feature, final int i, final TowerWingComponent wing) {
        super(IceTowerPieces.TFITRoof, feature, i);
        this.func_186164_a(wing.func_186165_e());
        this.size = wing.size;
        this.height = 12;
        this.deco = wing.deco;
        this.makeCapBB(wing);
    }
    
    @Override
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random rand, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        super.func_230383_a_(world, manager, generator, rand, sbb, chunkPosIn, blockPos);
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
