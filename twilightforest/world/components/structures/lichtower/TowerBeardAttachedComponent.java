// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.lichtower;

import twilightforest.world.components.structures.TFStructureComponentOld;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import java.util.Random;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import twilightforest.world.registration.TFFeature;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;

public class TowerBeardAttachedComponent extends TowerBeardComponent
{
    public TowerBeardAttachedComponent(final ServerLevel level, final CompoundTag nbt) {
        super(LichTowerPieces.TFLTBA, nbt);
    }
    
    public TowerBeardAttachedComponent(final TFFeature feature, final int i, final TowerWingComponent wing, final int x, final int y, final int z) {
        super(LichTowerPieces.TFLTBA, feature, i, wing, x, y, z);
        this.f_73383_ = new BoundingBox(wing.m_73547_().m_162395_(), wing.m_73547_().m_162396_() - this.height - 1, wing.m_73547_().m_162398_(), wing.m_73547_().m_162399_(), wing.m_73547_().m_162400_() - 1, wing.m_73547_().m_162401_());
    }
    
    @Override
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        return this.makeAttachedBeard(world, rand, sbb);
    }
    
    private boolean makeAttachedBeard(final WorldGenLevel world, final Random rand, final BoundingBox sbb) {
        for (int y = 0; y <= this.height; ++y) {
            final int min = y + 1;
            final int max = this.size - y;
            this.m_73464_(world, sbb, 0, this.height - y, min, max, this.height - y, max, false, rand, TFStructureComponentOld.getStrongholdStones());
        }
        return true;
    }
}
