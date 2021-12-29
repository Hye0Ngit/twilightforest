// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.minotaurmaze;

import net.minecraft.block.Blocks;
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

public class MazeDeadEndFountainLavaComponent extends MazeDeadEndFountainComponent
{
    public MazeDeadEndFountainLavaComponent(final TemplateManager manager, final CompoundNBT nbt) {
        super(MinotaurMazePieces.TFMMDEFL, nbt);
    }
    
    public MazeDeadEndFountainLavaComponent(final TFFeature feature, final int i, final int x, final int y, final int z, final Direction rotation) {
        super(MinotaurMazePieces.TFMMDEFL, feature, i, x, y, z, rotation);
    }
    
    @Override
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random rand, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        super.func_230383_a_(world, manager, generator, rand, sbb, chunkPosIn, blockPos);
        this.func_175811_a(world, MazeDeadEndFountainLavaComponent.AIR, 2, 3, 4, sbb);
        this.func_175811_a(world, MazeDeadEndFountainLavaComponent.AIR, 3, 3, 4, sbb);
        this.func_175811_a(world, Blocks.field_150353_l.func_176223_P(), 2, 3, 4, sbb);
        this.func_175811_a(world, Blocks.field_150353_l.func_176223_P(), 3, 3, 4, sbb);
        return true;
    }
}
