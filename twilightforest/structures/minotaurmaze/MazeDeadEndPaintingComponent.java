// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.minotaurmaze;

import net.minecraft.state.Property;
import net.minecraft.block.WallTorchBlock;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;
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

public class MazeDeadEndPaintingComponent extends MazeDeadEndComponent
{
    public MazeDeadEndPaintingComponent(final TemplateManager manager, final CompoundNBT nbt) {
        super(MinotaurMazePieces.TFMMDEP, nbt);
    }
    
    public MazeDeadEndPaintingComponent(final TFFeature feature, final int i, final int x, final int y, final int z, final Direction rotation) {
        super(MinotaurMazePieces.TFMMDEP, feature, i, x, y, z, rotation);
    }
    
    @Override
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random rand, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        super.func_230383_a_(world, manager, generator, rand, sbb, chunkPosIn, blockPos);
        this.func_175811_a(world, (BlockState)Blocks.field_196591_bQ.func_176223_P().func_206870_a((Property)WallTorchBlock.field_196532_a, (Comparable)Direction.WEST), 1, 3, 3, sbb);
        this.func_175811_a(world, (BlockState)Blocks.field_196591_bQ.func_176223_P().func_206870_a((Property)WallTorchBlock.field_196532_a, (Comparable)Direction.EAST), 4, 3, 3, sbb);
        return true;
    }
}
