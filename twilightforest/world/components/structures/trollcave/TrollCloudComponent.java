// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.trollcave;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import java.util.Random;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import twilightforest.world.components.structures.TFStructureComponentOld;

public class TrollCloudComponent extends TFStructureComponentOld
{
    private int size;
    private int height;
    
    public TrollCloudComponent(final ServerLevel level, final CompoundTag nbt) {
        super(TrollCavePieces.TFTCloud, nbt);
        this.size = nbt.m_128451_("size");
        this.height = nbt.m_128451_("height");
    }
    
    @Override
    protected void m_142347_(final ServerLevel level, final CompoundTag tagCompound) {
        super.m_142347_(level, tagCompound);
        tagCompound.m_128405_("size", this.size);
        tagCompound.m_128405_("height", this.height);
    }
    
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        this.placeCloud(world, sbb, 0, 0, 0, this.size - 1, 6, this.size - 1);
        return true;
    }
    
    protected void placeCloud(final WorldGenLevel world, final BoundingBox sbb, final int minX, final int minY, final int minZ, final int maxX, final int maxY, final int maxZ) {
        this.m_73441_(world, sbb, minX, minY, minZ, maxX, maxY, maxZ, Blocks.f_50147_.m_49966_(), Blocks.f_50147_.m_49966_(), false);
        this.m_73441_(world, sbb, minX + 2, minY + 2, minZ + 2, maxX - 2, maxY - 1, maxZ - 2, Blocks.f_50333_.m_49966_(), Blocks.f_50333_.m_49966_(), false);
    }
}
