// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.finalcastle;

import net.minecraft.util.math.MathHelper;
import net.minecraft.state.Property;
import net.minecraft.block.RotatedPillarBlock;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.ISeedReader;
import java.util.Random;
import java.util.List;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraft.util.Direction;
import twilightforest.TFFeature;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.gen.feature.template.TemplateManager;
import twilightforest.structures.TFStructureComponentOld;

public class FinalCastleBridgeComponent extends TFStructureComponentOld
{
    public FinalCastleBridgeComponent(final TemplateManager manager, final CompoundNBT nbt) {
        super(FinalCastlePieces.TFFCBri, nbt);
    }
    
    public FinalCastleBridgeComponent(final TFFeature feature, final int i, final int x, final int y, final int z, final int length, final Direction direction) {
        super(FinalCastlePieces.TFFCBri, feature, i);
        this.func_186164_a(direction);
        this.field_74887_e = TFStructureComponentOld.getComponentToAddBoundingBox2(x, y, z, 0, -1, -3, length - 1, 5, 6, direction);
    }
    
    public void func_74861_a(final StructurePiece parent, final List<StructurePiece> list, final Random rand) {
        if (parent != null && parent instanceof TFStructureComponentOld) {
            this.deco = ((TFStructureComponentOld)parent).deco;
        }
    }
    
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random rand, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        final int length = (this.func_186165_e() == Direction.SOUTH || this.func_186165_e() == Direction.NORTH) ? (this.field_74887_e.field_78893_d - this.field_74887_e.field_78897_a) : (this.field_74887_e.field_78892_f - this.field_74887_e.field_78896_c);
        this.func_74882_a(world, sbb, 0, 0, 0, length, 1, 6, false, rand, this.deco.randomBlocks);
        final BlockState castlePillar = (BlockState)((Block)TFBlocks.castle_pillar_bold.get()).func_176223_P().func_206870_a((Property)RotatedPillarBlock.field_176298_M, (Comparable)Direction.Axis.X);
        this.func_175804_a(world, sbb, 0, 2, 0, length, 2, 0, castlePillar, castlePillar, false);
        this.func_175804_a(world, sbb, 0, 2, 6, length, 2, 6, castlePillar, castlePillar, false);
        for (int l3 = length / 3, i = 0; i < l3; ++i) {
            final int sl = l3 - (int)(MathHelper.func_76134_b((l3 - i) / (float)l3 * 1.6f) * l3);
            this.func_74882_a(world, sbb, i, -sl, 0, i, 0, 0, false, rand, this.deco.randomBlocks);
            this.func_74882_a(world, sbb, i, -sl, 6, i, 0, 6, false, rand, this.deco.randomBlocks);
            this.func_74882_a(world, sbb, length - i, -sl, 0, length - i, 0, 0, false, rand, this.deco.randomBlocks);
            this.func_74882_a(world, sbb, length - i, -sl, 6, length - i, 0, 6, false, rand, this.deco.randomBlocks);
        }
        this.func_175804_a(world, sbb, 0, 2, 1, 0, 7, 1, this.deco.pillarState, this.deco.pillarState, false);
        this.func_175804_a(world, sbb, 0, 2, 5, 0, 7, 5, this.deco.pillarState, this.deco.pillarState, false);
        this.func_175804_a(world, sbb, 0, 6, 2, 0, 6, 4, this.deco.accentState, this.deco.accentState, false);
        this.func_175811_a(world, this.deco.pillarState, 0, 7, 3, sbb);
        this.func_175804_a(world, sbb, length, 2, 1, length, 7, 1, this.deco.pillarState, this.deco.pillarState, false);
        this.func_175804_a(world, sbb, length, 2, 5, length, 7, 5, this.deco.pillarState, this.deco.pillarState, false);
        this.func_175804_a(world, sbb, length, 6, 2, length, 6, 4, this.deco.accentState, this.deco.accentState, false);
        this.func_175811_a(world, this.deco.pillarState, length, 7, 3, sbb);
        return true;
    }
}
