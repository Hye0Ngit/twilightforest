// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.finalcastle;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.levelgen.structure.StructureStart;
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

public class FinalCastleEntranceBottomTowerComponent extends FinalCastleMazeTower13Component
{
    public FinalCastleEntranceBottomTowerComponent(final ServerLevel level, final CompoundTag nbt) {
        super(FinalCastlePieces.TFFCEnBoTo, nbt);
    }
    
    public FinalCastleEntranceBottomTowerComponent(final TFFeature feature, final Random rand, final int i, final int x, final int y, final int z, final int floors, final int entranceFloor, final Direction direction) {
        super(FinalCastlePieces.TFFCEnBoTo, feature, rand, i, x, y, z, floors, entranceFloor, ((Block)TFBlocks.PINK_CASTLE_RUNE_BRICK.get()).m_49966_(), direction);
    }
    
    @Override
    public void m_142537_(final StructurePiece parent, final StructurePieceAccessor list, final Random rand) {
        if (parent != null && parent instanceof TFStructureComponentOld) {
            this.deco = ((TFStructureComponentOld)parent).deco;
        }
        this.addStairs(list, rand, this.m_73548_() + 1, this.size - 1, 1, this.size / 2, Rotation.NONE);
        this.addStairs(list, rand, this.m_73548_() + 1, 0, 1, this.size / 2, Rotation.CLOCKWISE_180);
        this.addStairs(list, rand, this.m_73548_() + 1, this.size / 2, 1, 0, Rotation.COUNTERCLOCKWISE_90);
        this.addStairs(list, rand, this.m_73548_() + 1, this.size / 2, 1, this.size - 1, Rotation.CLOCKWISE_90);
    }
    
    private boolean addStairs(final StructurePieceAccessor list, final Random rand, final int index, final int x, final int y, final int z, final Rotation rotation) {
        this.addOpening(x, y, z, rotation);
        final Direction direction = this.getStructureRelativeRotation(rotation);
        final BlockPos dx = this.offsetTowerCCoords(x, y, z, 0, direction);
        final FinalCastleEntranceStairsComponent stairs = new FinalCastleEntranceStairsComponent(this.getFeatureType(), index, dx.m_123341_(), dx.m_123342_(), dx.m_123343_(), direction);
        list.m_142679_((StructurePiece)stairs);
        if (list instanceof StructureStart) {
            final StructureStart<?> start = (StructureStart<?>)list;
            stairs.m_142537_(start.m_73602_().get(0), list, rand);
        }
        return true;
    }
    
    @Override
    protected boolean hasAccessibleRoof() {
        return false;
    }
}
