// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.darktower;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import java.util.Random;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.WorldGenLevel;
import twilightforest.world.components.structures.lichtower.TowerWingComponent;
import twilightforest.world.registration.TFFeature;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;

public class DarkTowerRoofFourPostComponent extends DarkTowerRoofComponent
{
    public DarkTowerRoofFourPostComponent(final ServerLevel level, final CompoundTag nbt) {
        super(DarkTowerPieces.TFDTRFP, nbt);
    }
    
    public DarkTowerRoofFourPostComponent(final TFFeature feature, final int i, final TowerWingComponent wing, final int x, final int y, final int z) {
        super(DarkTowerPieces.TFDTRFP, feature, i, wing, x, y, z);
    }
    
    @Override
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        super.m_7832_(world, manager, generator, rand, sbb, chunkPosIn, blockPos);
        this.makeSmallAntenna(world, sbb, 4, this.size - 2, this.size - 2);
        this.makeSmallAntenna(world, sbb, 5, 1, this.size - 2);
        this.makeSmallAntenna(world, sbb, 6, this.size - 2, 1);
        this.makeSmallAntenna(world, sbb, 7, 1, 1);
        return true;
    }
    
    private void makeSmallAntenna(final WorldGenLevel world, final BoundingBox sbb, final int height, final int x, final int z) {
        for (int y = 1; y < height; ++y) {
            this.m_73434_(world, this.deco.blockState, x, y, z, sbb);
        }
        this.m_73434_(world, this.deco.accentState, x, height, z, sbb);
        this.m_73434_(world, this.deco.accentState, x, height + 1, z, sbb);
        this.m_73434_(world, this.deco.accentState, x + 1, height + 1, z, sbb);
        this.m_73434_(world, this.deco.accentState, x - 1, height + 1, z, sbb);
        this.m_73434_(world, this.deco.accentState, x, height + 1, z + 1, sbb);
        this.m_73434_(world, this.deco.accentState, x, height + 1, z - 1, sbb);
        this.m_73434_(world, this.deco.accentState, x, height + 2, z, sbb);
    }
}
