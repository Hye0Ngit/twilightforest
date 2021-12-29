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

public class DarkTowerRoofAntennaComponent extends DarkTowerRoofComponent
{
    public DarkTowerRoofAntennaComponent(final ServerLevel level, final CompoundTag nbt) {
        super(DarkTowerPieces.TFDTRA, nbt);
    }
    
    public DarkTowerRoofAntennaComponent(final TFFeature feature, final int i, final TowerWingComponent wing, final int x, final int y, final int z) {
        super(DarkTowerPieces.TFDTRA, feature, i, wing, x, y, z);
    }
    
    @Override
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        super.m_7832_(world, manager, generator, rand, sbb, chunkPosIn, blockPos);
        for (int y = 1; y < 10; ++y) {
            this.m_73434_(world, this.deco.accentState, this.size / 2, y, this.size / 2, sbb);
        }
        this.m_73434_(world, this.deco.accentState, this.size / 2 - 1, 1, this.size / 2, sbb);
        this.m_73434_(world, this.deco.accentState, this.size / 2 + 1, 1, this.size / 2, sbb);
        this.m_73434_(world, this.deco.accentState, this.size / 2, 1, this.size / 2 - 1, sbb);
        this.m_73434_(world, this.deco.accentState, this.size / 2, 1, this.size / 2 + 1, sbb);
        for (int y = 7; y < 10; ++y) {
            this.m_73434_(world, this.deco.accentState, this.size / 2 - 1, y, this.size / 2, sbb);
            this.m_73434_(world, this.deco.accentState, this.size / 2 + 1, y, this.size / 2, sbb);
            this.m_73434_(world, this.deco.accentState, this.size / 2, y, this.size / 2 - 1, sbb);
            this.m_73434_(world, this.deco.accentState, this.size / 2, y, this.size / 2 + 1, sbb);
        }
        this.m_73434_(world, this.deco.accentState, this.size / 2 - 1, 8, this.size / 2 - 1, sbb);
        this.m_73434_(world, this.deco.accentState, this.size / 2 - 1, 8, this.size / 2 + 1, sbb);
        this.m_73434_(world, this.deco.accentState, this.size / 2 + 1, 8, this.size / 2 - 1, sbb);
        this.m_73434_(world, this.deco.accentState, this.size / 2 + 1, 8, this.size / 2 + 1, sbb);
        return true;
    }
}
