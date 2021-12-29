// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.ISeedReader;
import java.util.List;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import java.util.Random;
import twilightforest.TFFeature;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class HydraLairComponent extends HollowHillComponent
{
    public HydraLairComponent(final TemplateManager manager, final CompoundNBT nbt) {
        super(TFFeature.TFHydra, nbt);
    }
    
    public HydraLairComponent(final TFFeature feature, final Random rand, final int i, final int x, final int y, final int z) {
        super(TFFeature.TFHydra, feature, i, 2, x, y + 2, z);
    }
    
    public void func_74861_a(final StructurePiece structurecomponent, final List<StructurePiece> list, final Random random) {
    }
    
    @Override
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random rand, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        final int stalacts = 64;
        final int stalags = 8;
        for (int i = 0; i < stalacts; ++i) {
            final int[] dest = this.getCoordsInHill2D(rand);
            this.generateOreStalactite(world, generator, manager, dest[0], 1, dest[1], sbb);
        }
        for (int i = 0; i < stalacts; ++i) {
            final int[] dest = this.getCoordsInHill2D(rand);
            this.generateBlockStalactite(world, generator, manager, Blocks.field_150348_b, 1.0f, true, dest[0], 1, dest[1], sbb);
        }
        for (int i = 0; i < stalags; ++i) {
            final int[] dest = this.getCoordsInHill2D(rand);
            this.generateBlockStalactite(world, generator, manager, Blocks.field_150348_b, 0.9f, false, dest[0], 1, dest[1], sbb);
        }
        this.func_175811_a(world, ((Block)TFBlocks.boss_spawner_hydra.get()).func_176223_P(), 27, 3, 27, sbb);
        return true;
    }
}
