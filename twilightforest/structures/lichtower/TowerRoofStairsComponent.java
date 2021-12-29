// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.lichtower;

import net.minecraft.state.Property;
import net.minecraft.block.StairsBlock;
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

public class TowerRoofStairsComponent extends TowerRoofComponent
{
    public TowerRoofStairsComponent(final TemplateManager manager, final CompoundNBT nbt) {
        super(LichTowerPieces.TFLTRSt, nbt);
    }
    
    public TowerRoofStairsComponent(final TFFeature feature, final int i, final TowerWingComponent wing) {
        super(LichTowerPieces.TFLTRSt, feature, i);
        this.func_186164_a(Direction.SOUTH);
        this.size = wing.size;
        this.height = this.size / 2;
        this.makeCapBB(wing);
    }
    
    @Override
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random rand, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        final BlockState birchSlab = Blocks.field_196627_bs.func_176223_P();
        final BlockState birchPlanks = Blocks.field_196666_p.func_176223_P();
        final BlockState birchStairsNorth = (BlockState)Blocks.field_150487_bG.func_176223_P().func_206870_a((Property)StairsBlock.field_176309_a, (Comparable)Direction.NORTH);
        final BlockState birchStairsSouth = (BlockState)Blocks.field_150487_bG.func_176223_P().func_206870_a((Property)StairsBlock.field_176309_a, (Comparable)Direction.SOUTH);
        final BlockState birchStairsEast = (BlockState)Blocks.field_150487_bG.func_176223_P().func_206870_a((Property)StairsBlock.field_176309_a, (Comparable)Direction.EAST);
        final BlockState birchStairsWest = (BlockState)Blocks.field_150487_bG.func_176223_P().func_206870_a((Property)StairsBlock.field_176309_a, (Comparable)Direction.WEST);
        for (int y = 0; y <= this.height; ++y) {
            final int min = y;
            for (int max = this.size - y - 1, x = min; x <= max; ++x) {
                for (int z = min; z <= max; ++z) {
                    if (x == min) {
                        if (z == min || z == max) {
                            this.func_175811_a(world, birchSlab, x, y, z, sbb);
                        }
                        else {
                            this.func_175811_a(world, birchStairsWest, x, y, z, sbb);
                        }
                    }
                    else if (x == max) {
                        if (z == min || z == max) {
                            this.func_175811_a(world, birchSlab, x, y, z, sbb);
                        }
                        else {
                            this.func_175811_a(world, birchStairsEast, x, y, z, sbb);
                        }
                    }
                    else if (z == max) {
                        this.func_175811_a(world, birchStairsSouth, x, y, z, sbb);
                    }
                    else if (z == min) {
                        this.func_175811_a(world, birchStairsNorth, x, y, z, sbb);
                    }
                    else {
                        this.func_175811_a(world, birchPlanks, x, y, z, sbb);
                    }
                }
            }
        }
        return true;
    }
}
