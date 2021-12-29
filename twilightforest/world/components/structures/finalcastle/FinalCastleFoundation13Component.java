// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.finalcastle;

import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Rotation;
import twilightforest.util.RotationUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.structure.StructurePieceAccessor;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import java.util.Random;
import twilightforest.world.registration.TFFeature;
import net.minecraft.world.level.levelgen.feature.StructurePieceType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.state.BlockState;
import java.util.function.Predicate;
import twilightforest.world.components.structures.TFStructureComponentOld;

public class FinalCastleFoundation13Component extends TFStructureComponentOld
{
    protected int groundLevel;
    protected static final Predicate<BlockState> isDeadrock;
    
    public FinalCastleFoundation13Component(final ServerLevel level, final CompoundTag nbt) {
        this(FinalCastlePieces.TFFCToF13, nbt);
    }
    
    public FinalCastleFoundation13Component(final StructurePieceType piece, final CompoundTag nbt) {
        super(piece, nbt);
        this.groundLevel = -1;
    }
    
    public FinalCastleFoundation13Component(final StructurePieceType type, final TFFeature feature, final Random rand, final int i, final TFStructureComponentOld sideTower, final int x, final int y, final int z) {
        super(type, feature, i, x, y, z);
        this.groundLevel = -1;
        this.m_73519_(sideTower.m_73549_());
        this.f_73383_ = new BoundingBox(sideTower.m_73547_().m_162395_() - 2, sideTower.m_73547_().m_162396_() - 1, sideTower.m_73547_().m_162398_() - 2, sideTower.m_73547_().m_162395_() + 2, sideTower.m_73547_().m_162396_(), sideTower.m_73547_().m_162401_() + 2);
    }
    
    public void m_142537_(final StructurePiece parent, final StructurePieceAccessor list, final Random rand) {
        if (parent instanceof final TFStructureComponentOld tfStructureComponentOld) {
            this.deco = tfStructureComponentOld.deco;
        }
    }
    
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random randomIn, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        if (this.groundLevel < 0) {
            this.groundLevel = this.findGroundLevel(world, sbb, 150, FinalCastleFoundation13Component.isDeadrock);
            if (this.groundLevel < 0) {
                return true;
            }
        }
        final int height = this.f_73383_.m_162400_() - this.groundLevel;
        final int mid = height / 2;
        final int size = this.f_73383_.m_162399_() - this.f_73383_.m_162395_();
        for (final Rotation rotation : RotationUtil.ROTATIONS) {
            this.replaceAirAndLiquidDownwardsRotated(world, this.deco.blockState, 1, -1, 1, rotation, sbb);
            this.replaceAirAndLiquidDownwardsRotated(world, this.deco.blockState, 2, -1, 1, rotation, sbb);
            this.replaceAirAndLiquidDownwardsRotated(world, this.deco.blockState, 2, -mid, 0, rotation, sbb);
            this.replaceAirAndLiquidDownwardsRotated(world, this.deco.blockState, 1, -1, 2, rotation, sbb);
            this.replaceAirAndLiquidDownwardsRotated(world, this.deco.blockState, 0, -mid, 2, rotation, sbb);
            for (int x = 6; x < size - 3; x += 4) {
                this.replaceAirAndLiquidDownwardsRotated(world, this.deco.blockState, x, -1, 1, rotation, sbb);
                this.replaceAirAndLiquidDownwardsRotated(world, this.deco.blockState, x, -mid, 0, rotation, sbb);
            }
        }
        return true;
    }
    
    static {
        isDeadrock = (state -> state.m_60734_() == TFBlocks.DEADROCK.get());
    }
}
