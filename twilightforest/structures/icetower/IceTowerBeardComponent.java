// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.icetower;

import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import java.util.Random;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.ISeedReader;
import net.minecraft.util.math.MutableBoundingBox;
import twilightforest.structures.lichtower.TowerWingComponent;
import twilightforest.TFFeature;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.gen.feature.template.TemplateManager;
import twilightforest.structures.TFStructureComponentOld;

public class IceTowerBeardComponent extends TFStructureComponentOld
{
    protected int size;
    protected int height;
    
    public IceTowerBeardComponent(final TemplateManager manager, final CompoundNBT nbt) {
        super(IceTowerPieces.TFITBea, nbt);
        this.size = nbt.func_74762_e("beardSize");
        this.height = nbt.func_74762_e("beardHeight");
    }
    
    public IceTowerBeardComponent(final TFFeature feature, final int i, final TowerWingComponent wing) {
        super(IceTowerPieces.TFITBea, feature, i);
        this.func_186164_a(wing.func_186165_e());
        this.size = wing.size;
        this.height = Math.round(this.size * 1.414f);
        this.deco = wing.deco;
        this.field_74887_e = new MutableBoundingBox(wing.func_74874_b().field_78897_a, wing.func_74874_b().field_78895_b - this.height, wing.func_74874_b().field_78896_c, wing.func_74874_b().field_78893_d, wing.func_74874_b().field_78895_b, wing.func_74874_b().field_78892_f);
    }
    
    @Override
    protected void func_143011_b(final CompoundNBT tagCompound) {
        super.func_143011_b(tagCompound);
        tagCompound.func_74768_a("beardSize", this.size);
        tagCompound.func_74768_a("beardHeight", this.height);
    }
    
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random rand, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        for (int x = 0; x < this.size; ++x) {
            for (int z = 0; z < this.size; ++z) {
                for (int rHeight = Math.round(MathHelper.func_76129_c((float)(x * x + z * z))), y = 0; y < rHeight; ++y) {
                    this.func_175811_a(world, this.deco.blockState, x, this.height - y, z, sbb);
                }
            }
        }
        return true;
    }
}
