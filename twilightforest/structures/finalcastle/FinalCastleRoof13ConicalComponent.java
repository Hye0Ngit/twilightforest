// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.finalcastle;

import net.minecraft.util.Rotation;
import twilightforest.util.RotationUtil;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.ISeedReader;
import java.util.List;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraft.util.math.MutableBoundingBox;
import java.util.Random;
import twilightforest.TFFeature;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.gen.feature.template.TemplateManager;
import twilightforest.structures.TFStructureComponentOld;

public class FinalCastleRoof13ConicalComponent extends TFStructureComponentOld
{
    public int slope;
    
    public FinalCastleRoof13ConicalComponent(final TemplateManager manager, final CompoundNBT nbt) {
        super(FinalCastlePieces.TFFCRo13Con, nbt);
        this.slope = nbt.func_74762_e("slope");
    }
    
    public FinalCastleRoof13ConicalComponent(final TFFeature feature, final Random rand, final int i, final TFStructureComponentOld sideTower) {
        super(FinalCastlePieces.TFFCRo13Con, feature, i);
        this.slope = 2 + rand.nextInt(3) + rand.nextInt(3);
        final int height = this.slope * 4;
        this.func_186164_a(sideTower.func_186165_e());
        this.field_74887_e = new MutableBoundingBox(sideTower.func_74874_b().field_78897_a - 2, sideTower.func_74874_b().field_78894_e - 1, sideTower.func_74874_b().field_78896_c - 2, sideTower.func_74874_b().field_78893_d + 2, sideTower.func_74874_b().field_78894_e + height - 1, sideTower.func_74874_b().field_78892_f + 2);
    }
    
    @Override
    protected void func_143011_b(final CompoundNBT tagCompound) {
        super.func_143011_b(tagCompound);
        tagCompound.func_74768_a("slope", this.slope);
    }
    
    public void func_74861_a(final StructurePiece parent, final List<StructurePiece> list, final Random rand) {
        if (parent != null && parent instanceof TFStructureComponentOld) {
            this.deco = ((TFStructureComponentOld)parent).deco;
        }
    }
    
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random randomIn, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        for (final Rotation rotation : RotationUtil.ROTATIONS) {
            this.fillBlocksRotated(world, sbb, 0, -1, 0, 3, 2, 3, this.deco.blockState, rotation);
            this.setBlockStateRotated(world, this.deco.blockState, 1, -2, 2, rotation, sbb);
            this.setBlockStateRotated(world, this.deco.blockState, 1, -2, 1, rotation, sbb);
            this.setBlockStateRotated(world, this.deco.blockState, 2, -2, 1, rotation, sbb);
            this.fillBlocksRotated(world, sbb, 4, 0, 1, 12, 1, 1, this.deco.blockState, rotation);
            for (int i = 3; i < 13; i += 2) {
                this.fillBlocksRotated(world, sbb, i, -1, 1, i, 2, 1, this.deco.blockState, rotation);
            }
            for (int i = 2; i < 9; ++i) {
                final int base = 2 - this.slope;
                if (i < 7) {
                    this.fillBlocksRotated(world, sbb, i - 1, (i - 1) * this.slope + base, i - 1, i, i * this.slope + base - 1, i, this.deco.blockState, rotation);
                }
                else {
                    this.fillBlocksRotated(world, sbb, 16 - i, (i - 1) * this.slope + base, i, 16 - i, i * this.slope + base - 1, i, this.deco.roofState, rotation);
                }
                this.fillBlocksRotated(world, sbb, i + 1, (i - 1) * this.slope + base, i, 15 - i, i * this.slope + base - 1, i, this.deco.roofState, rotation);
            }
            this.fillBlocksRotated(world, sbb, 8, this.slope * 6 + 2, 8, 8, this.slope * 7 + 2, 8, this.deco.roofState, rotation);
        }
        return true;
    }
}
