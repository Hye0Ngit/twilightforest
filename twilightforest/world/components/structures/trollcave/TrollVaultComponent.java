// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.trollcave;

import net.minecraft.world.level.levelgen.feature.NoiseEffect;
import twilightforest.loot.TFTreasure;
import net.minecraft.world.level.block.Blocks;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import java.util.Random;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.core.Direction;
import twilightforest.world.registration.TFFeature;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import twilightforest.world.components.structures.TFStructureComponentOld;

public class TrollVaultComponent extends TFStructureComponentOld
{
    public TrollVaultComponent(final ServerLevel level, final CompoundTag nbt) {
        super(TrollCavePieces.TFTCVa, nbt);
    }
    
    public TrollVaultComponent(final TFFeature feature, final int index, int x, int y, int z) {
        super(TrollCavePieces.TFTCVa, feature, index, x, y, z);
        this.m_73519_(Direction.SOUTH);
        x = x >> 2 << 2;
        y = y / 4 * 4;
        z = z >> 2 << 2;
        this.spawnListIndex = -1;
        this.f_73383_ = feature.getComponentToAddBoundingBox(x, y, z, -8, 0, -8, 12, 12, 12, Direction.SOUTH);
    }
    
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        this.m_73441_(world, sbb, 0, 0, 0, 11, 11, 11, ((Block)TFBlocks.GIANT_OBSIDIAN.get()).m_49966_(), ((Block)TFBlocks.GIANT_OBSIDIAN.get()).m_49966_(), false);
        this.m_73535_(world, sbb, 4, 4, 4, 7, 7, 7);
        this.m_73441_(world, sbb, 5, 5, 5, 6, 5, 6, Blocks.f_50652_.m_49966_(), Blocks.f_50652_.m_49966_(), false);
        this.setDoubleLootChest(world, 5, 6, 5, 5, 6, 6, this.m_73549_().m_122427_(), TFTreasure.TROLL_VAULT, sbb, false);
        this.setDoubleLootChest(world, 6, 6, 5, 6, 6, 6, this.m_73549_().m_122427_(), TFTreasure.TROLL_GARDEN, sbb, false);
        return true;
    }
    
    @Override
    public NoiseEffect m_142318_() {
        return NoiseEffect.BURY;
    }
}
