// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.trollcave;

import twilightforest.block.TFBlocks;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.util.EnumFacing;
import twilightforest.structures.StructureTFComponentOld;

public class ComponentTFCloudTree extends StructureTFComponentOld
{
    public ComponentTFCloudTree() {
    }
    
    public ComponentTFCloudTree(final int index, int x, int y, int z) {
        this.func_186164_a(EnumFacing.SOUTH);
        x = x >> 2 << 2;
        y = y >> 2 << 2;
        z = z >> 2 << 2;
        this.field_74887_e = StructureTFComponentOld.getComponentToAddBoundingBox(x, y, z, -8, 0, -8, 20, 28, 20, EnumFacing.SOUTH);
        this.spawnListIndex = 1;
    }
    
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        this.func_175804_a(world, sbb, 0, 12, 0, 19, 19, 19, TFBlocks.giant_leaves.func_176223_P(), TFBlocks.giant_leaves.func_176223_P(), false);
        this.func_175804_a(world, sbb, 4, 20, 4, 15, 23, 15, TFBlocks.giant_leaves.func_176223_P(), TFBlocks.giant_leaves.func_176223_P(), false);
        this.func_175804_a(world, sbb, 8, 24, 4, 11, 27, 15, TFBlocks.giant_leaves.func_176223_P(), TFBlocks.giant_leaves.func_176223_P(), false);
        this.func_175804_a(world, sbb, 4, 24, 8, 15, 27, 11, TFBlocks.giant_leaves.func_176223_P(), TFBlocks.giant_leaves.func_176223_P(), false);
        this.func_175804_a(world, sbb, 8, 0, 8, 11, 23, 11, TFBlocks.giant_log.func_176223_P(), TFBlocks.giant_log.func_176223_P(), false);
        this.func_175804_a(world, sbb, 8, -4, 8, 11, -1, 11, TFBlocks.fluffy_cloud.func_176223_P(), TFBlocks.fluffy_cloud.func_176223_P(), false);
        return true;
    }
}
