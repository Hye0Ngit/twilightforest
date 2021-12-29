// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.lichtower;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.block.Rotation;
import java.util.Random;
import net.minecraft.world.level.levelgen.structure.StructurePieceAccessor;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.core.Direction;
import twilightforest.world.registration.TFFeature;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;

public class TowerBridgeComponent extends TowerWingComponent
{
    int dSize;
    int dHeight;
    
    public TowerBridgeComponent(final ServerLevel level, final CompoundTag nbt) {
        super(LichTowerPieces.TFLTBri, nbt);
    }
    
    protected TowerBridgeComponent(final TFFeature feature, final int i, final int x, final int y, final int z, final int pSize, final int pHeight, final Direction direction) {
        super(LichTowerPieces.TFLTBri, feature, i, x, y, z, 3, 3, direction);
        this.dSize = pSize;
        this.dHeight = pHeight;
    }
    
    @Override
    public void m_142537_(final StructurePiece parent, final StructurePieceAccessor list, final Random rand) {
        final int[] dest = { 2, 1, 1 };
        this.makeTowerWing(list, rand, 1, dest[0], dest[1], dest[2], this.dSize, this.dHeight, Rotation.NONE);
    }
    
    public BoundingBox getWingBB() {
        final int[] dest = this.offsetTowerCoords(2, 1, 1, this.dSize, this.m_73549_());
        return this.getFeatureType().getComponentToAddBoundingBox(dest[0], dest[1], dest[2], 0, 0, 0, this.dSize - 1, this.dHeight - 1, this.dSize - 1, this.m_73549_());
    }
    
    @Override
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        for (int x = 0; x < 3; ++x) {
            this.m_73434_(world, Blocks.f_50132_.m_49966_(), x, 2, 0, sbb);
            this.m_73434_(world, Blocks.f_50132_.m_49966_(), x, 2, 2, sbb);
            this.m_73434_(world, Blocks.f_50222_.m_49966_(), x, 1, 0, sbb);
            this.m_73434_(world, Blocks.f_50222_.m_49966_(), x, 1, 2, sbb);
            this.m_73434_(world, Blocks.f_50222_.m_49966_(), x, 0, 0, sbb);
            this.m_73434_(world, Blocks.f_50222_.m_49966_(), x, 0, 1, sbb);
            this.m_73434_(world, Blocks.f_50222_.m_49966_(), x, 0, 2, sbb);
            this.m_73434_(world, Blocks.f_50222_.m_49966_(), x, -1, 1, sbb);
        }
        this.m_73434_(world, Blocks.f_50222_.m_49966_(), -1, -1, 1, sbb);
        this.m_73434_(world, Blocks.f_50222_.m_49966_(), 3, -1, 1, sbb);
        this.m_73535_(world, sbb, 0, 1, 1, 2, 2, 1);
        return true;
    }
}
