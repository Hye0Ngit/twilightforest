// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.finalcastle;

import java.util.Iterator;
import java.util.ArrayList;
import net.minecraft.core.Vec3i;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.core.BlockPos;
import twilightforest.world.components.structures.TFStructureComponentOld;
import net.minecraft.world.level.levelgen.structure.StructurePieceAccessor;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.Direction;
import java.util.Random;
import twilightforest.world.registration.TFFeature;
import net.minecraft.world.level.levelgen.feature.StructurePieceType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;

public class FinalCastleDamagedTowerComponent extends FinalCastleMazeTower13Component
{
    public FinalCastleDamagedTowerComponent(final ServerLevel level, final CompoundTag nbt) {
        this(FinalCastlePieces.TFFCDamT, nbt);
    }
    
    public FinalCastleDamagedTowerComponent(final StructurePieceType piece, final CompoundTag nbt) {
        super(piece, nbt);
    }
    
    public FinalCastleDamagedTowerComponent(final StructurePieceType piece, final TFFeature feature, final Random rand, final int i, final int x, final int y, final int z, final Direction direction) {
        super(piece, feature, rand, i, x, y, z, ((Block)TFBlocks.YELLOW_CASTLE_RUNE_BRICK.get()).m_49966_(), direction);
    }
    
    @Override
    public void m_142537_(final StructurePiece parent, final StructurePieceAccessor list, final Random rand) {
        if (parent != null && parent instanceof TFStructureComponentOld) {
            this.deco = ((TFStructureComponentOld)parent).deco;
        }
        final FinalCastleFoundation13Component foundation = new FinalCastleFoundation13Component(FinalCastlePieces.TFFCToF13, this.getFeatureType(), rand, 0, this, this.m_142171_().m_123341_(), this.m_142171_().m_123342_(), this.m_142171_().m_123343_());
        list.m_142679_((StructurePiece)foundation);
        foundation.m_142537_(this, list, rand);
        final FinalCastleFoundation13Component thorns = new FinalCastleFoundation13ComponentThorns(this.getFeatureType(), rand, 0, this, this.m_142171_().m_123341_(), this.m_142171_().m_123342_(), this.m_142171_().m_123343_());
        list.m_142679_((StructurePiece)thorns);
        thorns.m_142537_(this, list, rand);
        this.buildNonCriticalTowers(parent, list, rand);
    }
    
    @Override
    protected FinalCastleMazeTower13Component makeNewDamagedTower(final Random rand, final Direction facing, final BlockPos tc) {
        return new FinalCastleWreckedTowerComponent(this.getFeatureType(), rand, this.m_73548_() + 1, tc.m_123341_(), tc.m_123342_(), tc.m_123343_(), facing);
    }
    
    @Override
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        super.m_7832_(world, manager, generator, rand, sbb, chunkPosIn, blockPos);
        final Random decoRNG = new Random(world.m_7328_() + this.f_73383_.m_162395_() * 321534781L ^ this.f_73383_.m_162398_() * 756839L);
        this.destroyTower(world, decoRNG, sbb);
        return true;
    }
    
    public void destroyTower(final WorldGenLevel world, final Random rand, final BoundingBox sbb) {
        final ArrayList<DestroyArea> areas = this.makeInitialDestroyList(rand);
        boolean hitDeadRock = false;
        final BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
        for (int y = this.f_73383_.m_162400_(); !hitDeadRock && y > 64; --y) {
            for (int x = this.f_73383_.m_162395_() - 2; x <= this.f_73383_.m_162399_() + 2; ++x) {
                for (int z = this.f_73383_.m_162398_() - 2; z <= this.f_73383_.m_162401_() + 2; ++z) {
                    pos.m_122178_(x, y, z);
                    if (sbb.m_71051_((Vec3i)pos)) {
                        if (world.m_8055_((BlockPos)pos).m_60734_() == TFBlocks.DEADROCK.get()) {
                            hitDeadRock = true;
                        }
                        this.determineBlockDestroyed(world, areas, y, x, z);
                    }
                }
            }
            DestroyArea removeArea = null;
            for (final DestroyArea dArea : areas) {
                if (dArea == null || dArea.isEntirelyAbove(y)) {
                    removeArea = dArea;
                }
            }
            if (removeArea != null) {
                areas.remove(removeArea);
                areas.add(DestroyArea.createNonIntersecting(this.m_73547_(), rand, y, areas));
            }
        }
    }
    
    protected ArrayList<DestroyArea> makeInitialDestroyList(final Random rand) {
        final ArrayList<DestroyArea> areas = new ArrayList<DestroyArea>(2);
        areas.add(DestroyArea.createNonIntersecting(this.m_73547_(), rand, this.m_73547_().m_162400_() - 1, areas));
        areas.add(DestroyArea.createNonIntersecting(this.m_73547_(), rand, this.m_73547_().m_162400_() - 1, areas));
        areas.add(DestroyArea.createNonIntersecting(this.m_73547_(), rand, this.m_73547_().m_162400_() - 1, areas));
        return areas;
    }
    
    protected void determineBlockDestroyed(final WorldGenLevel world, final ArrayList<DestroyArea> areas, final int y, final int x, final int z) {
        final BlockPos pos = new BlockPos(x, y, z);
        for (final DestroyArea dArea : areas) {
            if (dArea != null && dArea.isVecInside(pos)) {
                world.m_7471_(pos, false);
            }
        }
    }
}
