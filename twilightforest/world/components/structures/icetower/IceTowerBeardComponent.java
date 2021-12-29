// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.icetower;

import net.minecraft.util.Mth;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import java.util.Random;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import twilightforest.world.components.structures.lichtower.TowerWingComponent;
import twilightforest.world.registration.TFFeature;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import twilightforest.world.components.structures.TFStructureComponentOld;

public class IceTowerBeardComponent extends TFStructureComponentOld
{
    protected int size;
    protected int height;
    
    public IceTowerBeardComponent(final ServerLevel level, final CompoundTag nbt) {
        super(IceTowerPieces.TFITBea, nbt);
        this.size = nbt.m_128451_("beardSize");
        this.height = nbt.m_128451_("beardHeight");
    }
    
    public IceTowerBeardComponent(final TFFeature feature, final int i, final TowerWingComponent wing, final int x, final int y, final int z) {
        super(IceTowerPieces.TFITBea, feature, i, x, y, z);
        this.m_73519_(wing.m_73549_());
        this.size = wing.size;
        this.height = Math.round(this.size * 1.414f);
        this.deco = wing.deco;
        this.f_73383_ = new BoundingBox(wing.m_73547_().m_162395_(), wing.m_73547_().m_162396_() - this.height, wing.m_73547_().m_162398_(), wing.m_73547_().m_162399_(), wing.m_73547_().m_162396_(), wing.m_73547_().m_162401_());
    }
    
    @Override
    protected void m_142347_(final ServerLevel level, final CompoundTag tagCompound) {
        super.m_142347_(level, tagCompound);
        tagCompound.m_128405_("beardSize", this.size);
        tagCompound.m_128405_("beardHeight", this.height);
    }
    
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        for (int x = 0; x < this.size; ++x) {
            for (int z = 0; z < this.size; ++z) {
                for (int rHeight = Math.round(Mth.m_14116_((float)(x * x + z * z))), y = 0; y < rHeight; ++y) {
                    this.m_73434_(world, this.deco.blockState, x, this.height - y, z, sbb);
                }
            }
        }
        return true;
    }
}
