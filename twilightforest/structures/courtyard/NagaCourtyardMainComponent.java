// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.courtyard;

import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.ISeedReader;
import net.minecraft.util.Direction;
import java.util.Random;
import twilightforest.TFFeature;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class NagaCourtyardMainComponent extends StructureMazeGenerator
{
    static int ROW_OF_CELLS;
    static int RADIUS;
    static int DIAMETER;
    static final float HEDGE_FLOOF = 0.5f;
    static final float WALL_DECAY = 0.1f;
    static final float WALL_INTEGRITY = 0.95f;
    
    public NagaCourtyardMainComponent(final TemplateManager manager, final CompoundNBT nbt) {
        super(NagaCourtyardPieces.TFNCMn, nbt);
    }
    
    public NagaCourtyardMainComponent(final TFFeature feature, final Random rand, final int i, final int x, final int y, final int z) {
        super(NagaCourtyardPieces.TFNCMn, feature, rand, i, NagaCourtyardMainComponent.ROW_OF_CELLS, NagaCourtyardMainComponent.ROW_OF_CELLS);
        this.func_186164_a(Direction.NORTH);
        this.field_74887_e = feature.getComponentToAddBoundingBox(x, y, z, -NagaCourtyardMainComponent.RADIUS, -1, -NagaCourtyardMainComponent.RADIUS, NagaCourtyardMainComponent.RADIUS * 2, 10, NagaCourtyardMainComponent.RADIUS * 2, this.func_186165_e());
    }
    
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random rand, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        this.func_175811_a(world, ((Block)TFBlocks.boss_spawner_naga.get()).func_176223_P(), NagaCourtyardMainComponent.RADIUS, 2, NagaCourtyardMainComponent.RADIUS, sbb);
        return true;
    }
    
    static {
        NagaCourtyardMainComponent.ROW_OF_CELLS = 8;
        NagaCourtyardMainComponent.RADIUS = (int)((NagaCourtyardMainComponent.ROW_OF_CELLS - 2) / 2.0f * 12.0f + 8.0f);
        NagaCourtyardMainComponent.DIAMETER = 2 * NagaCourtyardMainComponent.RADIUS + 1;
    }
}
