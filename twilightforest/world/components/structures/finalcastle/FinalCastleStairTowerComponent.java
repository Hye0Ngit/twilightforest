// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.finalcastle;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Rotation;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.WorldGenLevel;
import twilightforest.world.components.structures.TFStructureComponentOld;
import net.minecraft.world.level.levelgen.structure.StructurePieceAccessor;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.core.Direction;
import java.util.Random;
import twilightforest.world.registration.TFFeature;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import twilightforest.world.components.structures.lichtower.TowerWingComponent;

public class FinalCastleStairTowerComponent extends TowerWingComponent
{
    public FinalCastleStairTowerComponent(final ServerLevel level, final CompoundTag nbt) {
        super(FinalCastlePieces.TFFCStTo, nbt);
    }
    
    public FinalCastleStairTowerComponent(final TFFeature feature, final Random rand, final int i, final int x, final int y, final int z, final Direction rotation) {
        super(FinalCastlePieces.TFFCStTo, feature, i, x, y, z);
        this.m_73519_(rotation);
        this.size = 9;
        this.height = 51;
        this.f_73383_ = feature.getComponentToAddBoundingBox(x, y, z, -4, 0, -4, 8, 50, 8, Direction.SOUTH);
    }
    
    @Override
    public void m_142537_(final StructurePiece parent, final StructurePieceAccessor list, final Random rand) {
        if (parent != null && parent instanceof TFStructureComponentOld) {
            this.deco = ((TFStructureComponentOld)parent).deco;
        }
        final FinalCastleRoof9CrenellatedComponent roof = new FinalCastleRoof9CrenellatedComponent(this.getFeatureType(), rand, 4, this, this.m_142171_().m_123341_(), this.m_142171_().m_123342_(), this.m_142171_().m_123343_());
        list.m_142679_((StructurePiece)roof);
        roof.m_142537_(this, list, rand);
    }
    
    @Override
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        final Random decoRNG = new Random(world.m_7328_() + this.f_73383_.m_162395_() * 321534781L ^ this.f_73383_.m_162398_() * 756839L);
        this.m_73464_(world, sbb, 0, 0, 0, 8, 49, 8, false, rand, this.deco.randomBlocks);
        for (int numBranches = 6 + decoRNG.nextInt(4), i = 0; i < numBranches; ++i) {
            this.makeGlyphBranches(world, decoRNG, this.getGlyphMeta(), sbb);
        }
        for (int i = 1; i < 4; ++i) {
            this.m_73464_(world, sbb, i, -(i * 2), i, 8 - i, 1 - i * 2, 8 - i, false, rand, this.deco.randomBlocks);
        }
        this.m_73434_(world, this.deco.blockState, 4, -7, 4, sbb);
        final BlockState castleDoor = ((Block)TFBlocks.BLUE_CASTLE_DOOR.get()).m_49966_();
        this.m_73441_(world, sbb, 0, 1, 1, 0, 3, 2, castleDoor, FinalCastleStairTowerComponent.AIR, false);
        Rotation rotation = Rotation.CLOCKWISE_90;
        for (int f = 0; f < 5; ++f) {
            rotation = rotation.m_55952_(Rotation.CLOCKWISE_90);
            final int y = f * 3 + 1;
            for (int j = 0; j < 3; ++j) {
                final int sx = 3 + j;
                final int sy = y + j;
                final int sz = 1;
                this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Direction.WEST, false), sx, sy, sz, rotation, sbb);
                this.setBlockStateRotated(world, this.deco.blockState, sx, sy - 1, sz, rotation, sbb);
                this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Direction.WEST, false), sx, sy, sz + 1, rotation, sbb);
                this.setBlockStateRotated(world, this.deco.blockState, sx, sy - 1, sz + 1, rotation, sbb);
            }
            this.fillBlocksRotated(world, sbb, 6, y + 2, 1, 7, y + 2, 2, this.deco.blockState, rotation);
        }
        this.m_73441_(world, sbb, 1, 18, 0, 2, 20, 0, castleDoor, FinalCastleStairTowerComponent.AIR, false);
        final BlockState stairState = TFStructureComponentOld.getStairState(this.deco.stairState, Direction.SOUTH, false);
        this.m_73441_(world, sbb, 1, 17, 1, 3, 17, 3, this.deco.blockState, this.deco.blockState, false);
        this.m_73441_(world, sbb, 1, 17, 4, 2, 17, 4, stairState, stairState, false);
        this.m_73441_(world, sbb, 1, 16, 4, 2, 16, 4, this.deco.blockState, this.deco.blockState, false);
        this.m_73441_(world, sbb, 1, 16, 5, 2, 16, 5, stairState, stairState, false);
        this.m_73441_(world, sbb, 1, 15, 5, 2, 15, 5, this.deco.blockState, this.deco.blockState, false);
        this.m_73441_(world, sbb, 1, 39, 0, 2, 41, 0, castleDoor, FinalCastleStairTowerComponent.AIR, false);
        rotation = Rotation.COUNTERCLOCKWISE_90;
        for (int f2 = 0; f2 < 7; ++f2) {
            rotation = rotation.m_55952_(Rotation.CLOCKWISE_90);
            final int y2 = f2 * 3 + 18;
            for (int k = 0; k < 3; ++k) {
                final int sx2 = 3 + k;
                final int sy2 = y2 + k;
                final int sz2 = 1;
                this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Direction.WEST, false), sx2, sy2, sz2, rotation, sbb);
                this.setBlockStateRotated(world, this.deco.blockState, sx2, sy2 - 1, sz2, rotation, sbb);
                this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Direction.WEST, false), sx2, sy2, sz2 + 1, rotation, sbb);
                this.setBlockStateRotated(world, this.deco.blockState, sx2, sy2 - 1, sz2 + 1, rotation, sbb);
            }
            this.fillBlocksRotated(world, sbb, 6, y2 + 2, 1, 7, y2 + 2, 2, this.deco.blockState, rotation);
        }
        this.m_73441_(world, sbb, 1, 38, 1, 3, 38, 5, this.deco.blockState, this.deco.blockState, false);
        this.m_73441_(world, sbb, 3, 39, 1, 3, 39, 5, this.deco.fenceState, this.deco.fenceState, false);
        return true;
    }
    
    public BlockState getGlyphMeta() {
        return ((Block)TFBlocks.BLUE_CASTLE_RUNE_BRICK.get()).m_49966_();
    }
}
