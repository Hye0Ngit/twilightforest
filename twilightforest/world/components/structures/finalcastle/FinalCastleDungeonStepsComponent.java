// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.finalcastle;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.structure.StructurePieceAccessor;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.core.Direction;
import java.util.Random;
import twilightforest.world.registration.TFFeature;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import twilightforest.world.components.structures.TFStructureComponentOld;

public class FinalCastleDungeonStepsComponent extends TFStructureComponentOld
{
    public FinalCastleDungeonStepsComponent(final ServerLevel level, final CompoundTag nbt) {
        super(FinalCastlePieces.TFFCDunSt, nbt);
    }
    
    public FinalCastleDungeonStepsComponent(final TFFeature feature, final Random rand, final int i, final int x, final int y, final int z, final Direction rotation) {
        super(FinalCastlePieces.TFFCDunSt, feature, i, x, y, z);
        this.spawnListIndex = 2;
        this.m_73519_(rotation);
        this.f_73383_ = TFStructureComponentOld.getComponentToAddBoundingBox2(x, y, z, -2, -15, -3, 5, 15, 20, rotation);
    }
    
    public void m_142537_(final StructurePiece parent, final StructurePieceAccessor list, final Random rand) {
        if (parent != null && parent instanceof TFStructureComponentOld) {
            this.deco = ((TFStructureComponentOld)parent).deco;
        }
    }
    
    public FinalCastleDungeonStepsComponent buildMoreStepsTowards(final StructurePiece parent, final StructurePieceAccessor list, final Random rand, final Rotation rotation) {
        final Direction direction = this.getStructureRelativeRotation(rotation);
        int sx = 2;
        final int sy = 0;
        int sz = 17;
        switch (rotation) {
            case NONE: {
                sz -= 5;
                break;
            }
            case CLOCKWISE_90: {
                sx -= 5;
                break;
            }
            case CLOCKWISE_180: {
                sz += 5;
                break;
            }
            case COUNTERCLOCKWISE_90: {
                sx += 6;
                break;
            }
        }
        final int dx = this.m_73392_(sx, sz);
        final int dy = this.m_73544_(sy);
        final int dz = this.m_73525_(sx, sz);
        final FinalCastleDungeonStepsComponent steps = new FinalCastleDungeonStepsComponent(this.getFeatureType(), rand, this.f_73384_ + 1, dx, dy, dz, direction);
        list.m_142679_((StructurePiece)steps);
        steps.m_142537_(this, list, rand);
        return steps;
    }
    
    public FinalCastleDungeonEntranceComponent buildLevelUnder(final StructurePiece parent, final StructurePieceAccessor list, final Random rand, final int level) {
        final int dx = this.m_73392_(2, 19);
        final int dy = this.m_73544_(-7);
        final int dz = this.m_73525_(2, 19);
        final FinalCastleDungeonEntranceComponent room = new FinalCastleDungeonEntranceComponent(this.getFeatureType(), rand, 8, dx, dy, dz, this.m_73549_(), level);
        list.m_142679_((StructurePiece)room);
        room.m_142537_(this, list, rand);
        return room;
    }
    
    public FinalCastleDungeonForgeRoomComponent buildBossRoomUnder(final StructurePiece parent, final StructurePieceAccessor list, final Random rand) {
        final int dx = this.m_73392_(2, 19);
        final int dy = this.m_73544_(-31);
        final int dz = this.m_73525_(2, 19);
        final FinalCastleDungeonForgeRoomComponent room = new FinalCastleDungeonForgeRoomComponent(this.getFeatureType(), rand, 8, dx, dy, dz, this.m_73549_());
        list.m_142679_((StructurePiece)room);
        room.m_142537_((StructurePiece)this, list, rand);
        return room;
    }
    
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        final BlockState stairState = (BlockState)this.deco.stairState.m_61124_((Property)StairBlock.f_56841_, (Comparable)Direction.SOUTH);
        for (int z = 0; z < 15; ++z) {
            final int y = 14 - z;
            this.m_73441_(world, sbb, 0, y, z, 4, y, z, stairState, stairState, false);
            this.m_73535_(world, sbb, 0, y + 1, z, 4, y + 6, z);
        }
        this.m_73535_(world, sbb, 0, 0, 15, 4, 5, 19);
        return true;
    }
}
