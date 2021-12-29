// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.icetower;

import net.minecraft.util.Mth;
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
import twilightforest.world.components.structures.lichtower.TowerRoofComponent;

public class IceTowerRoofComponent extends TowerRoofComponent
{
    public IceTowerRoofComponent(final ServerLevel level, final CompoundTag nbt) {
        super(IceTowerPieces.TFITRoof, nbt);
    }
    
    public IceTowerRoofComponent(final TFFeature feature, final int i, final TowerWingComponent wing, final int x, final int y, final int z) {
        super(IceTowerPieces.TFITRoof, feature, i, x, y, z);
        this.m_73519_(wing.m_73549_());
        this.size = wing.size;
        this.height = 12;
        this.deco = wing.deco;
        this.makeCapBB(wing);
    }
    
    @Override
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        super.m_7832_(world, manager, generator, rand, sbb, chunkPosIn, blockPos);
        for (int x = 0; x < this.size; ++x) {
            for (int z = 0; z < this.size; ++z) {
                for (int rHeight = Math.round(Mth.m_14116_((float)(x * x + z * z))), y = 0; y < rHeight; ++y) {
                    this.m_73434_(world, this.deco.blockState, x, y, z, sbb);
                }
            }
        }
        return true;
    }
}
