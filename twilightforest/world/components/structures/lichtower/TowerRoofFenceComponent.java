// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.lichtower;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import java.util.Random;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.WorldGenLevel;
import twilightforest.world.registration.TFFeature;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;

public class TowerRoofFenceComponent extends TowerRoofComponent
{
    public TowerRoofFenceComponent(final ServerLevel level, final CompoundTag nbt) {
        super(LichTowerPieces.TFLTRF, nbt);
    }
    
    public TowerRoofFenceComponent(final TFFeature feature, final int i, final TowerWingComponent wing, final int x, final int y, final int z) {
        super(LichTowerPieces.TFLTRF, feature, i, x, y, z);
        this.m_73519_(wing.m_73549_());
        this.size = wing.size;
        this.height = 0;
        this.makeCapBB(wing);
    }
    
    @Override
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        final int y = this.height + 1;
        for (int x = 0; x <= this.size - 1; ++x) {
            for (int z = 0; z <= this.size - 1; ++z) {
                if (x == 0 || x == this.size - 1 || z == 0 || z == this.size - 1) {
                    this.m_73434_(world, Blocks.f_50132_.m_49966_(), x, y, z, sbb);
                }
            }
        }
        return true;
    }
}
