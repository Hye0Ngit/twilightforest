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
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.structure.StructurePieceAccessor;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import java.util.Random;
import twilightforest.world.registration.TFFeature;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import twilightforest.world.components.structures.TFStructureComponentOld;

public class FinalCastleBossGazeboComponent extends TFStructureComponentOld
{
    public FinalCastleBossGazeboComponent(final ServerLevel level, final CompoundTag nbt) {
        super(FinalCastlePieces.TFFCBoGaz, nbt);
    }
    
    public FinalCastleBossGazeboComponent(final TFFeature feature, final Random rand, final int i, final TFStructureComponentOld keep, final int x, final int y, final int z) {
        super(FinalCastlePieces.TFFCBoGaz, feature, i, x, y, z);
        this.spawnListIndex = -1;
        this.m_73519_(keep.m_73549_());
        this.f_73383_ = new BoundingBox(keep.m_73547_().m_162395_() + 14, keep.m_73547_().m_162400_() + 2, keep.m_73547_().m_162398_() + 14, keep.m_73547_().m_162399_() - 14, keep.m_73547_().m_162400_() + 13, keep.m_73547_().m_162401_() - 14);
    }
    
    public void m_142537_(final StructurePiece parent, final StructurePieceAccessor list, final Random rand) {
        this.deco = new StructureTFDecoratorCastle();
        this.deco.blockState = ((Block)TFBlocks.BLUE_CASTLE_RUNE_BRICK.get()).m_49966_();
        this.deco.fenceState = ((Block)TFBlocks.VIOLET_FORCE_FIELD.get()).m_49966_();
    }
    
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random randomIn, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        for (final Rotation rotation : RotationUtil.ROTATIONS) {
            this.fillBlocksRotated(world, sbb, 0, 0, 0, 0, 10, 20, this.deco.fenceState, rotation);
        }
        this.m_73441_(world, sbb, 0, 11, 0, 20, 11, 20, this.deco.fenceState, this.deco.fenceState, false);
        this.setInvisibleTextEntity(world, 10, 0, 10, sbb, "Final Boss Here", true, 2.3f);
        this.setInvisibleTextEntity(world, 10, 0, 10, sbb, "You win!", true, 2.0f);
        this.setInvisibleTextEntity(world, 10, 0, 10, sbb, "You can join the Twilight Forest Discord server to follow", true, 1.0f);
        this.setInvisibleTextEntity(world, 10, 0, 10, sbb, "the latest updates on this castle and other content at:", true, 0.7f);
        this.setInvisibleTextEntity(world, 10, 0, 10, sbb, "discord.experiment115.com", true, 0.4f);
        return true;
    }
}
