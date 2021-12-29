// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.finalcastle;

import net.minecraft.world.level.block.state.BlockState;
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

public class FinalCastleLargeTowerComponent extends TowerWingComponent
{
    public FinalCastleLargeTowerComponent(final ServerLevel level, final CompoundTag nbt) {
        super(FinalCastlePieces.TFFCLaTo, nbt);
    }
    
    public FinalCastleLargeTowerComponent(final TFFeature feature, final Random rand, final int i, final int x, final int y, final int z, final Direction rotation) {
        super(FinalCastlePieces.TFFCLaTo, feature, i, x, y, z);
        this.m_73519_(rotation);
        this.size = 13;
        this.height = 61;
        this.f_73383_ = feature.getComponentToAddBoundingBox(x, y, z, -6, 0, -6, 12, 60, 12, Direction.SOUTH);
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
        this.m_73464_(world, sbb, 0, 0, 0, 12, 59, 12, false, rand, this.deco.randomBlocks);
        for (int numBranches = 6 + decoRNG.nextInt(4), i = 0; i < numBranches; ++i) {
            this.makeGlyphBranches(world, decoRNG, this.getGlyphMeta(), sbb);
        }
        for (int i = 1; i < 4; ++i) {
            this.m_73464_(world, sbb, i, -(i * 2), i, 8 - i, 1 - i * 2, 8 - i, false, rand, this.deco.randomBlocks);
        }
        this.m_73434_(world, this.deco.blockState, 4, -7, 4, sbb);
        final BlockState castleDoor = ((Block)TFBlocks.PINK_CASTLE_DOOR.get()).m_49966_();
        this.m_73441_(world, sbb, 0, 1, 1, 0, 4, 3, castleDoor, FinalCastleLargeTowerComponent.AIR, false);
        this.placeSignAtCurrentPosition(world, 6, 1, 6, "Parkour area 1", "Unique monster?", sbb);
        return true;
    }
    
    public BlockState getGlyphMeta() {
        return ((Block)TFBlocks.PINK_CASTLE_RUNE_BRICK.get()).m_49966_();
    }
}
