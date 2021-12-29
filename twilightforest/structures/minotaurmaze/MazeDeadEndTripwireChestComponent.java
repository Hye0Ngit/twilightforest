// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.minotaurmaze;

import net.minecraft.block.BlockState;
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

public class MazeDeadEndTripwireChestComponent extends MazeDeadEndChestComponent
{
    public MazeDeadEndTripwireChestComponent(final TemplateManager manager, final CompoundNBT nbt) {
        super(MinotaurMazePieces.TFMMDETC, nbt);
    }
    
    public MazeDeadEndTripwireChestComponent(final TFFeature feature, final int i, final int x, final int y, final int z, final Direction rotation) {
        super(MinotaurMazePieces.TFMMDETC, feature, i, x, y, z, rotation);
    }
    
    @Override
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random rand, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        super.func_230383_a_(world, manager, generator, rand, sbb, chunkPosIn, blockPos);
        this.placeTripwire(world, 1, 1, 2, 3, Direction.EAST, sbb);
        final BlockState tnt = Blocks.field_150335_W.func_176223_P();
        this.func_175811_a(world, tnt, 0, 0, 2, sbb);
        this.func_175811_a(world, MazeDeadEndTripwireChestComponent.AIR, 0, -1, 2, sbb);
        this.func_175811_a(world, MazeDeadEndTripwireChestComponent.AIR, 1, -1, 2, sbb);
        this.func_175811_a(world, tnt, 2, 0, 4, sbb);
        this.func_175811_a(world, tnt, 3, 0, 4, sbb);
        this.func_175811_a(world, tnt, 2, 0, 3, sbb);
        this.func_175811_a(world, tnt, 3, 0, 3, sbb);
        return true;
    }
}
