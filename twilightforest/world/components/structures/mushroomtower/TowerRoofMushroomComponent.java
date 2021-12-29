// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.mushroomtower;

import net.minecraft.util.Mth;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.WorldGenLevel;
import twilightforest.world.components.structures.TFStructureComponentOld;
import java.util.Random;
import net.minecraft.world.level.levelgen.structure.StructurePieceAccessor;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.core.Direction;
import twilightforest.world.components.structures.lichtower.TowerWingComponent;
import twilightforest.world.registration.TFFeature;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import twilightforest.world.components.structures.lichtower.TowerRoofComponent;

public class TowerRoofMushroomComponent extends TowerRoofComponent
{
    public TowerRoofMushroomComponent(final ServerLevel level, final CompoundTag nbt) {
        super(MushroomTowerPieces.TFMTRoofMush, nbt);
    }
    
    public TowerRoofMushroomComponent(final TFFeature feature, final int i, final TowerWingComponent wing, final float pHang, final int x, final int y, final int z) {
        super(MushroomTowerPieces.TFMTRoofMush, feature, i, x, y, z);
        this.height = wing.size;
        final int overhang = (int)(this.height * pHang);
        this.size = this.height + overhang * 2;
        this.m_73519_(Direction.SOUTH);
        this.f_73383_ = new BoundingBox(wing.m_73547_().m_162395_() - overhang, wing.m_73547_().m_162400_() + 2, wing.m_73547_().m_162398_() - overhang, wing.m_73547_().m_162399_() + overhang, wing.m_73547_().m_162400_() + this.height + 1, wing.m_73547_().m_162401_() + overhang);
    }
    
    public void m_142537_(final StructurePiece parent, final StructurePieceAccessor list, final Random rand) {
        if (parent != null && parent instanceof TFStructureComponentOld) {
            this.deco = ((TFStructureComponentOld)parent).deco;
        }
    }
    
    @Override
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        for (int y = 0; y <= this.height; ++y) {
            final int radius = (int)(Mth.m_14031_((y + this.height / 1.2f) / (this.height * 2.05f) * 3.14f) * this.size / 2.0f);
            int hollow = Mth.m_14143_(radius * 0.9f);
            if (this.height - y < 3) {
                hollow = -1;
            }
            this.makeCircle(world, y, radius, hollow, sbb);
        }
        return true;
    }
    
    private void makeCircle(final WorldGenLevel world, final int y, final int radius, final int hollow, final BoundingBox sbb) {
        final int cx = this.size / 2;
        final int cz = this.size / 2;
        for (int dx = -radius; dx <= radius; ++dx) {
            for (int dz = -radius; dz <= radius; ++dz) {
                final float dist = Mth.m_14116_((float)(dx * dx + dz * dz));
                if (dist <= radius + 0.5f) {
                    if (dist > hollow) {
                        this.m_73434_(world, this.deco.accentState, dx + cx, y, dz + cz, sbb);
                    }
                    else {
                        this.m_73434_(world, this.deco.accentState.m_60734_().m_49966_(), dx + cx, y, dz + cz, sbb);
                    }
                }
            }
        }
    }
}
