// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.lichtower;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import java.util.Random;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.ISeedReader;
import net.minecraft.util.math.MutableBoundingBox;
import twilightforest.TFFeature;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.gen.feature.template.TemplateManager;
import twilightforest.structures.TFStructureComponentOld;

public class TowerBeardComponent extends TFStructureComponentOld
{
    int size;
    int height;
    
    public TowerBeardComponent(final TemplateManager manager, final CompoundNBT nbt) {
        this(LichTowerPieces.TFLTBea, nbt);
    }
    
    public TowerBeardComponent(final IStructurePieceType piece, final CompoundNBT nbt) {
        super(piece, nbt);
        this.size = nbt.func_74762_e("beardSize");
        this.height = nbt.func_74762_e("beardHeight");
    }
    
    public TowerBeardComponent(final IStructurePieceType piece, final TFFeature feature, final int i, final TowerWingComponent wing) {
        super(piece, feature, i);
        this.func_186164_a(wing.func_186165_e());
        this.size = wing.size - 2;
        this.height = this.size / 2;
        this.field_74887_e = new MutableBoundingBox(wing.func_74874_b().field_78897_a + 1, wing.func_74874_b().field_78895_b - this.height - 1, wing.func_74874_b().field_78896_c + 1, wing.func_74874_b().field_78893_d - 1, wing.func_74874_b().field_78895_b - 1, wing.func_74874_b().field_78892_f - 1);
    }
    
    @Override
    protected void func_143011_b(final CompoundNBT tagCompound) {
        super.func_143011_b(tagCompound);
        tagCompound.func_74768_a("beardSize", this.size);
        tagCompound.func_74768_a("beardHeight", this.height);
    }
    
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random rand, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        return this.makePyramidBeard(world, rand, sbb);
    }
    
    private boolean makePyramidBeard(final ISeedReader world, final Random rand, final MutableBoundingBox sbb) {
        for (int y = 0; y <= this.height; ++y) {
            final int min = y;
            final int max = this.size - y - 1;
            this.func_74882_a(world, sbb, min, this.height - y, min, max, this.height - y, max, false, rand, TFStructureComponentOld.getStrongholdStones());
        }
        return true;
    }
}
