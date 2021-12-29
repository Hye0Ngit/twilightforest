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
import java.util.Random;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.core.Direction;
import twilightforest.world.registration.TFFeature;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;

public class TowerRoofStairsOverhangComponent extends TowerRoofComponent
{
    public TowerRoofStairsOverhangComponent(final ServerLevel level, final CompoundTag nbt) {
        super(LichTowerPieces.TFLTRStO, nbt);
    }
    
    public TowerRoofStairsOverhangComponent(final TFFeature feature, final int i, final TowerWingComponent wing, final int x, final int y, final int z) {
        super(LichTowerPieces.TFLTRStO, feature, i, x, y, z);
        this.m_73519_(Direction.SOUTH);
        this.size = wing.size + 2;
        this.height = this.size / 2;
        this.f_73383_ = new BoundingBox(wing.m_73547_().m_162395_() - 1, wing.m_73547_().m_162400_(), wing.m_73547_().m_162398_() - 1, wing.m_73547_().m_162399_() + 1, wing.m_73547_().m_162400_() + this.height - 1, wing.m_73547_().m_162401_() + 1);
    }
    
    @Override
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        final BlockState woodenSlab = Blocks.f_50400_.m_49966_();
        final BlockState woodenPlanks = Blocks.f_50742_.m_49966_();
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
                            this.m_73434_(world, woodenSlab, x, y, z, sbb);
                        }
                        else {
                            this.m_73434_(world, birchStairsWest, x, y, z, sbb);
                        }
                    }
                    else if (x == max) {
                        if (z == min || z == max) {
                            this.m_73434_(world, woodenSlab, x, y, z, sbb);
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
                        this.m_73434_(world, woodenPlanks, x, y, z, sbb);
                    }
                }
            }
        }
        return true;
    }
}
