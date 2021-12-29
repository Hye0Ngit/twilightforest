// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import net.minecraft.block.BlockState;
import net.minecraft.util.Rotation;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.ISeedReader;
import java.util.Random;
import twilightforest.TFFeature;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class YetiCaveComponent extends HollowHillComponent
{
    public YetiCaveComponent(final TemplateManager manager, final CompoundNBT nbt) {
        super(TFFeature.TFYeti, nbt);
    }
    
    public YetiCaveComponent(final TFFeature feature, final Random rand, final int i, final int x, final int y, final int z) {
        super(TFFeature.TFYeti, feature, i, 2, x, y, z);
    }
    
    @Override
    boolean isInHill(final int cx, final int cz) {
        return cx < this.radius * 2 && cx > 0 && cz < this.radius * 2 && cz > 0;
    }
    
    @Override
    boolean isInHill(final int mapX, final int mapY, final int mapZ) {
        return mapX < this.radius * 2 && mapX > 0 && mapZ < this.radius * 2 && mapZ > 0 && mapY > 31 && mapY < 51;
    }
    
    @Override
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random rand, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        final int sn = 128;
        for (int i = 0; i < sn; ++i) {
            final int[] dest = this.getCoordsInHill2D(rand);
            this.generateBlockStalactite(world, generator, manager, Blocks.field_150348_b, 1.0f, true, dest[0], 1, dest[1], sbb);
        }
        for (int i = 0; i < sn; ++i) {
            final int[] dest = this.getCoordsInHill2D(rand);
            this.generateBlockStalactite(world, generator, manager, Blocks.field_150432_aD, 1.0f, true, dest[0], 1, dest[1], sbb);
        }
        for (int i = 0; i < sn; ++i) {
            final int[] dest = this.getCoordsInHill2D(rand);
            this.generateBlockStalactite(world, generator, manager, Blocks.field_150403_cj, 0.9f, true, dest[0], 1, dest[1], sbb);
        }
        final BlockState yetiSpawner = ((Block)TFBlocks.boss_spawner_alpha_yeti.get()).func_176223_P();
        this.setBlockStateRotated(world, yetiSpawner, this.radius, 1, this.radius, Rotation.NONE, sbb);
        return true;
    }
}
