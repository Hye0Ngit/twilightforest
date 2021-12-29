// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.darktower;

import net.minecraft.world.level.block.state.BlockState;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
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

public class DarkTowerBeardComponent extends TFStructureComponentOld
{
    protected int size;
    protected int height;
    
    public DarkTowerBeardComponent(final ServerLevel level, final CompoundTag nbt) {
        super(DarkTowerPieces.TFDTBea, nbt);
        this.size = nbt.m_128451_("beardSize");
        this.height = nbt.m_128451_("beardHeight");
    }
    
    public DarkTowerBeardComponent(final TFFeature feature, final int i, final TowerWingComponent wing, final int x, final int y, final int z) {
        super(DarkTowerPieces.TFDTBea, feature, i, x, y, z);
        this.m_73519_(wing.m_73549_());
        this.size = wing.size;
        this.height = this.size / 2;
        this.f_73383_ = new BoundingBox(wing.m_73547_().m_162395_(), wing.m_73547_().m_162396_() - this.height, wing.m_73547_().m_162398_(), wing.m_73547_().m_162399_(), wing.m_73547_().m_162400_(), wing.m_73547_().m_162401_());
    }
    
    @Override
    protected void m_142347_(final ServerLevel level, final CompoundTag tagCompound) {
        super.m_142347_(level, tagCompound);
        tagCompound.m_128405_("beardSize", this.size);
        tagCompound.m_128405_("beardHeight", this.height);
    }
    
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        this.makeDarkBeard(world, sbb, 0, 0, this.size - 1, this.height - 1, this.size - 1);
        return true;
    }
    
    protected void makeDarkBeard(final WorldGenLevel world, final BoundingBox sbb, final int minX, final int minZ, final int maxX, final int maxY, final int maxZ) {
        final BlockState frameState = ((Block)TFBlocks.ENCASED_TOWERWOOD.get()).m_49966_();
        for (int x = minX; x <= maxX; ++x) {
            for (int z = minZ; z <= maxZ; ++z) {
                if (x == minX || x == maxX || z == minZ || z == maxZ) {
                    int length = Math.min(Math.abs(x - this.height) - 1, Math.abs(z - this.height) - 1);
                    if (length == this.height - 1) {
                        ++length;
                    }
                    if (length == -1) {
                        length = 1;
                    }
                    for (int y = maxY; y >= this.height - length; --y) {
                        this.m_73434_(world, frameState, x, y, z, sbb);
                    }
                }
            }
        }
    }
}
