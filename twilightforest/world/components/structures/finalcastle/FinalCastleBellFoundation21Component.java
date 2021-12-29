// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.finalcastle;

import net.minecraft.world.level.block.Rotation;
import twilightforest.util.RotationUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import twilightforest.world.components.structures.TFStructureComponentOld;
import java.util.Random;
import twilightforest.world.registration.TFFeature;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;

public class FinalCastleBellFoundation21Component extends FinalCastleFoundation13Component
{
    public FinalCastleBellFoundation21Component(final ServerLevel level, final CompoundTag nbt) {
        super(FinalCastlePieces.TFFCBeF21, nbt);
    }
    
    public FinalCastleBellFoundation21Component(final TFFeature feature, final Random rand, final int i, final TFStructureComponentOld sideTower, final int x, final int y, final int z) {
        super(FinalCastlePieces.TFFCBeF21, feature, rand, i, sideTower, x, y, z);
        this.f_73383_ = new BoundingBox(sideTower.m_73547_().m_162395_() - 2, sideTower.m_73547_().m_162400_() - 1, sideTower.m_73547_().m_162398_() - 2, sideTower.m_73547_().m_162395_() + 2, sideTower.m_73547_().m_162400_(), sideTower.m_73547_().m_162401_() + 2);
    }
    
    @Override
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        final int mid = 16;
        final int low = 32;
        final int size = this.f_73383_.m_162399_() - this.f_73383_.m_162395_();
        for (final Rotation rotation : RotationUtil.ROTATIONS) {
            this.replaceAirAndLiquidDownwardsRotated(world, this.deco.blockState, 2, -1, 1, rotation, sbb);
            this.replaceAirAndLiquidDownwardsRotated(world, this.deco.blockState, 2, -mid, 0, rotation, sbb);
            this.replaceAirAndLiquidDownwardsRotated(world, this.deco.blockState, 1, -1, 2, rotation, sbb);
            this.replaceAirAndLiquidDownwardsRotated(world, this.deco.blockState, 0, -mid, 2, rotation, sbb);
            this.replaceAirAndLiquidDownwardsRotated(world, this.deco.blockState, 1, -low, 1, rotation, sbb);
            this.replaceAirAndLiquidDownwardsRotated(world, this.deco.blockState, 0, -low, 1, rotation, sbb);
            this.replaceAirAndLiquidDownwardsRotated(world, this.deco.blockState, 1, -low, 0, rotation, sbb);
            this.replaceAirAndLiquidDownwardsRotated(world, this.deco.blockState, 0, -low, 0, rotation, sbb);
            for (int x = 6; x < size - 3; x += 4) {
                this.replaceAirAndLiquidDownwardsRotated(world, this.deco.blockState, x, -1, 1, rotation, sbb);
                this.replaceAirAndLiquidDownwardsRotated(world, this.deco.blockState, x, -mid, 0, rotation, sbb);
            }
        }
        return true;
    }
}
