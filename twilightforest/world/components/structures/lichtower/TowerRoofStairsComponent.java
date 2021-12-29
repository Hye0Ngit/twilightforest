// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.lichtower;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import java.util.Random;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.core.Direction;
import twilightforest.world.registration.TFFeature;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;

public class TowerRoofStairsComponent extends TowerRoofComponent
{
    public TowerRoofStairsComponent(final ServerLevel level, final CompoundTag nbt) {
        super(LichTowerPieces.TFLTRSt, nbt);
    }
    
    public TowerRoofStairsComponent(final TFFeature feature, final int i, final TowerWingComponent wing, final int x, final int y, final int z) {
        super(LichTowerPieces.TFLTRSt, feature, i, x, y, z);
        this.m_73519_(Direction.SOUTH);
        this.size = wing.size;
        this.height = this.size / 2;
        this.makeCapBB(wing);
    }
    
    @Override
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        final BlockState birchSlab = Blocks.f_50400_.m_49966_();
        final BlockState birchPlanks = Blocks.f_50742_.m_49966_();
        final BlockState birchStairsNorth = (BlockState)Blocks.f_50270_.m_49966_().m_61124_((Property)StairBlock.f_56841_, (Comparable)Direction.NORTH);
        final BlockState birchStairsSouth = (BlockState)Blocks.f_50270_.m_49966_().m_61124_((Property)StairBlock.f_56841_, (Comparable)Direction.SOUTH);
        final BlockState birchStairsEast = (BlockState)Blocks.f_50270_.m_49966_().m_61124_((Property)StairBlock.f_56841_, (Comparable)Direction.EAST);
        final BlockState birchStairsWest = (BlockState)Blocks.f_50270_.m_49966_().m_61124_((Property)StairBlock.f_56841_, (Comparable)Direction.WEST);
        for (int y = 0; y <= this.height; ++y) {
            final int min = y;
            for (int max = this.size - y - 1, x = min; x <= max; ++x) {
                for (int z = min; z <= max; ++z) {
                    if (x == min) {
                        if (z == min || z == max) {
                            this.m_73434_(world, birchSlab, x, y, z, sbb);
                        }
                        else {
                            this.m_73434_(world, birchStairsWest, x, y, z, sbb);
                        }
                    }
                    else if (x == max) {
                        if (z == min || z == max) {
                            this.m_73434_(world, birchSlab, x, y, z, sbb);
                        }
                        else {
                            this.m_73434_(world, birchStairsEast, x, y, z, sbb);
                        }
                    }
                    else if (z == max) {
                        this.m_73434_(world, birchStairsSouth, x, y, z, sbb);
                    }
                    else if (z == min) {
                        this.m_73434_(world, birchStairsNorth, x, y, z, sbb);
                    }
                    else {
                        this.m_73434_(world, birchPlanks, x, y, z, sbb);
                    }
                }
            }
        }
        return true;
    }
}
