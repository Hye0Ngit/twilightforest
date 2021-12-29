// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.trollcave;

import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import java.util.Random;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.ISeedReader;
import net.minecraft.util.Direction;
import twilightforest.TFFeature;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.gen.feature.template.TemplateManager;
import twilightforest.structures.TFStructureComponentOld;

public class CloudTreeComponent extends TFStructureComponentOld
{
    public CloudTreeComponent(final TemplateManager manager, final CompoundNBT nbt) {
        super(TrollCavePieces.TFClTr, nbt);
    }
    
    public CloudTreeComponent(final TFFeature feature, final int index, int x, int y, int z) {
        super(TrollCavePieces.TFClTr, feature, index);
        this.func_186164_a(Direction.SOUTH);
        x = x >> 2 << 2;
        y = y >> 2 << 2;
        z = z >> 2 << 2;
        this.field_74887_e = feature.getComponentToAddBoundingBox(x, y, z, -8, 0, -8, 20, 28, 20, Direction.SOUTH);
        this.spawnListIndex = 1;
    }
    
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random rand, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        this.func_175804_a(world, sbb, 0, 12, 0, 19, 19, 19, ((Block)TFBlocks.giant_leaves.get()).func_176223_P(), ((Block)TFBlocks.giant_leaves.get()).func_176223_P(), false);
        this.func_175804_a(world, sbb, 4, 20, 4, 15, 23, 15, ((Block)TFBlocks.giant_leaves.get()).func_176223_P(), ((Block)TFBlocks.giant_leaves.get()).func_176223_P(), false);
        this.func_175804_a(world, sbb, 8, 24, 4, 11, 27, 15, ((Block)TFBlocks.giant_leaves.get()).func_176223_P(), ((Block)TFBlocks.giant_leaves.get()).func_176223_P(), false);
        this.func_175804_a(world, sbb, 4, 24, 8, 15, 27, 11, ((Block)TFBlocks.giant_leaves.get()).func_176223_P(), ((Block)TFBlocks.giant_leaves.get()).func_176223_P(), false);
        this.func_175804_a(world, sbb, 8, 0, 8, 11, 23, 11, ((Block)TFBlocks.giant_log.get()).func_176223_P(), ((Block)TFBlocks.giant_log.get()).func_176223_P(), false);
        this.func_175804_a(world, sbb, 8, -4, 8, 11, -1, 11, ((Block)TFBlocks.fluffy_cloud.get()).func_176223_P(), ((Block)TFBlocks.fluffy_cloud.get()).func_176223_P(), false);
        return true;
    }
}
