// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.courtyard;

import twilightforest.block.TFBlocks;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import twilightforest.structures.StructureTFComponentOld;
import net.minecraft.util.EnumFacing;
import java.util.Random;
import net.minecraft.world.World;
import twilightforest.TFFeature;

public class ComponentNagaCourtyardMain extends StructureMazeGenerator
{
    static int ROW_OF_CELLS;
    static int RADIUS;
    static int DIAMETER;
    static final float HEDGE_FLOOF = 0.5f;
    static final float WALL_DECAY = 0.1f;
    static final float WALL_INTEGRITY = 0.9f;
    
    public ComponentNagaCourtyardMain() {
    }
    
    public ComponentNagaCourtyardMain(final TFFeature feature, final World world, final Random rand, final int i, final int x, final int y, final int z) {
        super(feature, rand, i, ComponentNagaCourtyardMain.ROW_OF_CELLS, ComponentNagaCourtyardMain.ROW_OF_CELLS);
        this.func_186164_a(EnumFacing.NORTH);
        this.field_74887_e = StructureTFComponentOld.getComponentToAddBoundingBox(x, y, z, -ComponentNagaCourtyardMain.RADIUS, -1, -ComponentNagaCourtyardMain.RADIUS, ComponentNagaCourtyardMain.RADIUS * 2, 10, ComponentNagaCourtyardMain.RADIUS * 2, this.func_186165_e());
    }
    
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        this.func_175811_a(world, TFBlocks.boss_spawner.func_176223_P(), ComponentNagaCourtyardMain.RADIUS, 2, ComponentNagaCourtyardMain.RADIUS, sbb);
        return true;
    }
    
    static {
        ComponentNagaCourtyardMain.ROW_OF_CELLS = 8;
        ComponentNagaCourtyardMain.RADIUS = (int)((ComponentNagaCourtyardMain.ROW_OF_CELLS - 2) / 2.0f * 12.0f + 8.0f);
        ComponentNagaCourtyardMain.DIAMETER = 2 * ComponentNagaCourtyardMain.RADIUS + 1;
    }
}
