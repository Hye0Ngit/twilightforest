// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.finalcastle;

import twilightforest.TwilightForestMod;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Rotation;
import twilightforest.world.components.structures.TFStructureComponentOld;
import net.minecraft.world.level.levelgen.structure.StructurePieceAccessor;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.Direction;
import java.util.Random;
import twilightforest.world.registration.TFFeature;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;

public class FinalCastleEntranceTowerComponent extends FinalCastleMazeTower13Component
{
    public FinalCastleEntranceTowerComponent(final ServerLevel level, final CompoundTag nbt) {
        super(FinalCastlePieces.TFFCEnTo, nbt);
    }
    
    public FinalCastleEntranceTowerComponent(final TFFeature feature, final Random rand, final int i, final int x, final int y, final int z, final Direction direction) {
        super(FinalCastlePieces.TFFCEnTo, feature, rand, i, x, y, z, 3, 2, ((Block)TFBlocks.PINK_CASTLE_RUNE_BRICK.get()).m_49966_(), direction);
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
        final int missingFloors = (this.f_73383_.m_162396_() - 127) / 8;
        final int bottomFloors = missingFloors / 2;
        final int middleFloors = missingFloors - bottomFloors;
        Direction facing = Rotation.CLOCKWISE_90.m_55954_(this.m_73549_());
        final int howFar = 20;
        if (!this.buildSideTower(list, rand, middleFloors + 1, facing, howFar)) {
            facing = Rotation.COUNTERCLOCKWISE_90.m_55954_(this.m_73549_());
            if (!this.buildSideTower(list, rand, middleFloors + 1, facing, howFar)) {
                facing = Rotation.NONE.m_55954_(this.m_73549_());
                if (!this.buildSideTower(list, rand, middleFloors + 1, facing, howFar)) {}
            }
        }
        final FinalCastleEntranceBottomTowerComponent eTower = new FinalCastleEntranceBottomTowerComponent(this.getFeatureType(), rand, this.m_73548_() + 1, this.f_73383_.m_162395_() + 6, this.f_73383_.m_162396_() - middleFloors * 8, this.f_73383_.m_162398_() + 6, bottomFloors + 1, bottomFloors, facing.m_122424_());
        list.m_142679_((StructurePiece)eTower);
        eTower.m_142537_(this, list, rand);
        BlockPos opening = this.getValidOpeningCC(rand, facing);
        opening = opening.m_6625_(middleFloors * 8);
        final BlockPos bc = this.offsetTowerCCoords(opening.m_123341_(), opening.m_123342_(), opening.m_123343_(), 1, facing);
        final FinalCastleBridgeComponent bridge = new FinalCastleBridgeComponent(this.getFeatureType(), this.m_73548_() + 1, bc.m_123341_(), bc.m_123342_(), bc.m_123343_(), howFar - 7, facing);
        list.m_142679_((StructurePiece)bridge);
        bridge.m_142537_(this, list, rand);
    }
    
    private boolean buildSideTower(final StructurePieceAccessor list, final Random rand, final int middleFloors, final Direction facing, final int howFar) {
        final BlockPos opening = this.getValidOpeningCC(rand, facing);
        final BlockPos tc = this.offsetTowerCCoords(opening.m_123341_(), opening.m_123342_(), opening.m_123343_(), howFar, facing);
        final FinalCastleEntranceSideTowerComponent eTower = new FinalCastleEntranceSideTowerComponent(this.getFeatureType(), rand, this.m_73548_() + 1, tc.m_123341_(), tc.m_123342_(), tc.m_123343_(), middleFloors, middleFloors - 1, facing);
        final BoundingBox largerBB = new BoundingBox(eTower.m_73547_().m_162394_());
        final StructurePiece intersect = list.m_141921_(largerBB);
        if (intersect == null) {
            list.m_142679_((StructurePiece)eTower);
            eTower.m_142537_(this, list, rand);
            final BlockPos bc = this.offsetTowerCCoords(opening.m_123341_(), opening.m_123342_(), opening.m_123343_(), 1, facing);
            final FinalCastleBridgeComponent bridge = new FinalCastleBridgeComponent(this.getFeatureType(), this.m_73548_() + 1, bc.m_123341_(), bc.m_123342_(), bc.m_123343_(), howFar - 7, facing);
            list.m_142679_((StructurePiece)bridge);
            bridge.m_142537_(this, list, rand);
            this.addOpening(opening.m_123341_(), opening.m_123342_() + 1, opening.m_123343_(), facing);
            return true;
        }
        TwilightForestMod.LOGGER.info("side entrance tower blocked");
        return false;
    }
    
    @Override
    public BlockPos getValidOpeningCC(final Random rand, final Direction facing) {
        final BlockPos opening = super.getValidOpeningCC(rand, facing);
        return new BlockPos(opening.m_123341_(), 0, opening.m_123343_());
    }
}
