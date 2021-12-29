// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.lichtower;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import java.util.Random;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.WorldGenLevel;
import twilightforest.world.registration.TFFeature;
import net.minecraft.world.level.levelgen.feature.StructurePieceType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;

public class TowerRoofPointyComponent extends TowerRoofComponent
{
    public TowerRoofPointyComponent(final ServerLevel level, final CompoundTag nbt) {
        super(LichTowerPieces.TFLTRP, nbt);
    }
    
    public TowerRoofPointyComponent(final StructurePieceType piece, final CompoundTag nbt) {
        super(piece, nbt);
    }
    
    public TowerRoofPointyComponent(final StructurePieceType piece, final TFFeature feature, final int i, final TowerWingComponent wing, final int x, final int y, final int z) {
        super(piece, feature, i, x, y, z);
        this.m_73519_(wing.m_73549_());
        this.size = wing.size;
        this.height = this.size;
        this.makeCapBB(wing);
    }
    
    @Override
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        final BlockState birchSlab = Blocks.f_50400_.m_49966_();
        final BlockState birchPlanks = Blocks.f_50742_.m_49966_();
        for (int y = 0; y <= this.height; ++y) {
            final int slopeChange = this.slopeChangeForSize();
            int min;
            int max;
            if (y < slopeChange) {
                min = y;
                max = this.size - y - 1;
            }
            else {
                min = (y + slopeChange) / 2;
                max = this.size - (y + slopeChange) / 2 - 1;
            }
            final int mid = min + (max - min) / 2;
            for (int x = min; x <= max; ++x) {
                for (int z = min; z <= max; ++z) {
                    this.m_73434_(world, birchPlanks, x, y, z, sbb);
                    if ((x == min && (z == min || z == max)) || (x == max && (z == min || z == max))) {
                        this.m_73434_(world, birchSlab, x, y + 1, z, sbb);
                    }
                    if ((((x == min || x == max) && z == mid && x % 2 == 0) || ((z == min || z == max) && x == mid && z % 2 == 0)) && mid != min + 1) {
                        this.m_73434_(world, birchSlab, x, y + 1, z, sbb);
                    }
                }
            }
        }
        return true;
    }
    
    public int slopeChangeForSize() {
        if (this.size > 10) {
            return 3;
        }
        if (this.size > 6) {
            return 2;
        }
        return 1;
    }
}
