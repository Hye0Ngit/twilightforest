// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.minotaurmaze;

import net.minecraft.block.Blocks;
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

public class MazeCorridorIronFenceComponent extends MazeCorridorComponent
{
    public MazeCorridorIronFenceComponent(final TemplateManager manager, final CompoundNBT nbt) {
        super(MinotaurMazePieces.TFMMCIF, nbt);
    }
    
    public MazeCorridorIronFenceComponent(final TFFeature feature, final int i, final int x, final int y, final int z, final Direction rotation) {
        super(MinotaurMazePieces.TFMMCIF, feature, i, x, y, z, rotation);
    }
    
    @Override
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random rand, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        this.func_175804_a(world, sbb, 1, 4, 2, 4, 4, 3, ((Block)TFBlocks.maze_stone_decorative.get()).func_176223_P(), MazeCorridorIronFenceComponent.AIR, false);
        this.func_175804_a(world, sbb, 1, 1, 2, 4, 3, 3, ((Block)TFBlocks.maze_stone_chiseled.get()).func_176223_P(), MazeCorridorIronFenceComponent.AIR, false);
        this.func_175804_a(world, sbb, 2, 1, 2, 3, 3, 3, Blocks.field_150411_aY.func_176223_P(), Blocks.field_150350_a.func_176223_P(), false);
        return true;
    }
}
