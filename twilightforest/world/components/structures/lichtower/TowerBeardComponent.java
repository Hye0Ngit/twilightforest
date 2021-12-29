// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.lichtower;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import java.util.Random;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import twilightforest.world.registration.TFFeature;
import net.minecraft.world.level.levelgen.feature.StructurePieceType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import twilightforest.world.components.structures.TFStructureComponentOld;

public class TowerBeardComponent extends TFStructureComponentOld
{
    int size;
    int height;
    
    public TowerBeardComponent(final ServerLevel level, final CompoundTag nbt) {
        this(LichTowerPieces.TFLTBea, nbt);
    }
    
    public TowerBeardComponent(final StructurePieceType piece, final CompoundTag nbt) {
        super(piece, nbt);
        this.size = nbt.m_128451_("beardSize");
        this.height = nbt.m_128451_("beardHeight");
    }
    
    public TowerBeardComponent(final StructurePieceType piece, final TFFeature feature, final int i, final TowerWingComponent wing, final int x, final int y, final int z) {
        super(piece, feature, i, x, y, z);
        this.m_73519_(wing.m_73549_());
        this.size = wing.size - 2;
        this.height = this.size / 2;
        this.f_73383_ = new BoundingBox(wing.m_73547_().m_162395_() + 1, wing.m_73547_().m_162396_() - this.height - 1, wing.m_73547_().m_162398_() + 1, wing.m_73547_().m_162399_() - 1, wing.m_73547_().m_162396_() - 1, wing.m_73547_().m_162401_() - 1);
    }
    
    @Override
    protected void m_142347_(final ServerLevel level, final CompoundTag tagCompound) {
        super.m_142347_(level, tagCompound);
        tagCompound.m_128405_("beardSize", this.size);
        tagCompound.m_128405_("beardHeight", this.height);
    }
    
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        return this.makePyramidBeard(world, rand, sbb);
    }
    
    private boolean makePyramidBeard(final WorldGenLevel world, final Random rand, final BoundingBox sbb) {
        for (int y = 0; y <= this.height; ++y) {
            final int min = y;
            final int max = this.size - y - 1;
            this.m_73464_(world, sbb, min, this.height - y, min, max, this.height - y, max, false, rand, TFStructureComponentOld.getStrongholdStones());
        }
        return true;
    }
}
