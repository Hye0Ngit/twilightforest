// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.finalcastle;

import twilightforest.world.components.structures.TFStructureComponentOld;
import net.minecraft.world.level.levelgen.structure.StructurePieceAccessor;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.world.level.block.Rotation;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.Direction;
import java.util.Random;
import twilightforest.world.registration.TFFeature;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;

public class FinalCastleEntranceSideTowerComponent extends FinalCastleMazeTower13Component
{
    public FinalCastleEntranceSideTowerComponent(final ServerLevel level, final CompoundTag nbt) {
        super(FinalCastlePieces.TFFCEnSiTo, nbt);
    }
    
    public FinalCastleEntranceSideTowerComponent(final TFFeature feature, final Random rand, final int i, final int x, final int y, final int z, final int floors, final int entranceFloor, final Direction direction) {
        super(FinalCastlePieces.TFFCEnSiTo, feature, rand, i, x, y, z, floors, entranceFloor, ((Block)TFBlocks.PINK_CASTLE_RUNE_BRICK.get()).m_49966_(), direction);
        this.addOpening(0, 1, this.size / 2, Rotation.CLOCKWISE_180);
    }
    
    @Override
    public void m_142537_(final StructurePiece parent, final StructurePieceAccessor list, final Random rand) {
        if (parent != null && parent instanceof TFStructureComponentOld) {
            this.deco = ((TFStructureComponentOld)parent).deco;
        }
        final FinalCastleFoundation13Component foundation = new FinalCastleFoundation13Component(FinalCastlePieces.TFFCToF13, this.getFeatureType(), rand, 4, this, this.m_142171_().m_123341_(), this.m_142171_().m_123342_(), this.m_142171_().m_123343_());
        list.m_142679_((StructurePiece)foundation);
        foundation.m_142537_(this, list, rand);
        final TFStructureComponentOld roof = new FinalCastleRoof13PeakedComponent(this.getFeatureType(), rand, 4, this, this.m_142171_().m_123341_(), this.m_142171_().m_123342_(), this.m_142171_().m_123343_());
        list.m_142679_((StructurePiece)roof);
        roof.m_142537_((StructurePiece)this, list, rand);
    }
}
