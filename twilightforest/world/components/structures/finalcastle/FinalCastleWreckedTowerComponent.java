// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.finalcastle;

import java.util.Iterator;
import net.minecraft.core.BlockPos;
import java.util.ArrayList;
import net.minecraft.world.level.WorldGenLevel;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import twilightforest.world.components.structures.TFStructureComponentOld;
import net.minecraft.world.level.levelgen.structure.StructurePieceAccessor;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.core.Direction;
import java.util.Random;
import twilightforest.world.registration.TFFeature;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;

public class FinalCastleWreckedTowerComponent extends FinalCastleDamagedTowerComponent
{
    public FinalCastleWreckedTowerComponent(final ServerLevel level, final CompoundTag nbt) {
        super(FinalCastlePieces.TFFCWrT, nbt);
    }
    
    public FinalCastleWreckedTowerComponent(final TFFeature feature, final Random rand, final int i, final int x, final int y, final int z, final Direction direction) {
        super(FinalCastlePieces.TFFCWrT, feature, rand, i, x, y, z, direction);
    }
    
    @Override
    public void m_142537_(final StructurePiece parent, final StructurePieceAccessor list, final Random rand) {
        if (parent != null && parent instanceof TFStructureComponentOld) {
            this.deco = ((TFStructureComponentOld)parent).deco;
        }
        final FinalCastleFoundation13Component thorns = new FinalCastleFoundation13ComponentThorns(this.getFeatureType(), rand, 0, this, this.m_142171_().m_123341_(), this.m_142171_().m_123342_(), this.m_142171_().m_123343_());
        list.m_142679_((StructurePiece)thorns);
        thorns.m_142537_(this, list, rand);
    }
    
    @Override
    public BlockState getGlyphColour() {
        return ((Block)TFBlocks.BLUE_CASTLE_RUNE_BRICK.get()).m_49966_();
    }
    
    @Override
    protected void determineBlockDestroyed(final WorldGenLevel world, final ArrayList<DestroyArea> areas, final int y, final int x, final int z) {
        boolean isInside = false;
        final BlockPos pos = new BlockPos(x, y, z);
        for (final DestroyArea dArea : areas) {
            if (dArea != null && dArea.isVecInside(pos)) {
                isInside = true;
            }
        }
        if (!isInside) {
            world.m_7471_(pos, false);
        }
    }
    
    @Override
    protected ArrayList<DestroyArea> makeInitialDestroyList(final Random rand) {
        final ArrayList<DestroyArea> areas = new ArrayList<DestroyArea>(2);
        areas.add(DestroyArea.createNonIntersecting(this.m_73547_(), rand, this.m_73547_().m_162400_() - 1, areas));
        areas.add(DestroyArea.createNonIntersecting(this.m_73547_(), rand, this.m_73547_().m_162400_() - 1, areas));
        areas.add(DestroyArea.createNonIntersecting(this.m_73547_(), rand, this.m_73547_().m_162400_() - 1, areas));
        areas.add(DestroyArea.createNonIntersecting(this.m_73547_(), rand, this.m_73547_().m_162400_() - 1, areas));
        return areas;
    }
}
