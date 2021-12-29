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
import net.minecraft.world.level.levelgen.structure.StructurePieceAccessor;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import java.util.Random;
import twilightforest.world.registration.TFFeature;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import twilightforest.world.components.structures.TFStructureComponentOld;

public class FinalCastleRoof13ConicalComponent extends TFStructureComponentOld
{
    public int slope;
    
    public FinalCastleRoof13ConicalComponent(final ServerLevel level, final CompoundTag nbt) {
        super(FinalCastlePieces.TFFCRo13Con, nbt);
        this.slope = nbt.m_128451_("slope");
    }
    
    public FinalCastleRoof13ConicalComponent(final TFFeature feature, final Random rand, final int i, final TFStructureComponentOld sideTower, final int x, final int y, final int z) {
        super(FinalCastlePieces.TFFCRo13Con, feature, i, x, y, z);
        this.slope = 2 + rand.nextInt(3) + rand.nextInt(3);
        final int height = this.slope * 4;
        this.m_73519_(sideTower.m_73549_());
        this.f_73383_ = new BoundingBox(sideTower.m_73547_().m_162395_() - 2, sideTower.m_73547_().m_162400_() - 1, sideTower.m_73547_().m_162398_() - 2, sideTower.m_73547_().m_162399_() + 2, sideTower.m_73547_().m_162400_() + height - 1, sideTower.m_73547_().m_162401_() + 2);
    }
    
    @Override
    protected void m_142347_(final ServerLevel level, final CompoundTag tagCompound) {
        super.m_142347_(level, tagCompound);
        tagCompound.m_128405_("slope", this.slope);
    }
    
    public void m_142537_(final StructurePiece parent, final StructurePieceAccessor list, final Random rand) {
        if (parent != null && parent instanceof TFStructureComponentOld) {
            this.deco = ((TFStructureComponentOld)parent).deco;
        }
    }
    
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random randomIn, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        for (final Rotation rotation : RotationUtil.ROTATIONS) {
            this.fillBlocksRotated(world, sbb, 0, -1, 0, 3, 2, 3, this.deco.blockState, rotation);
            this.setBlockStateRotated(world, this.deco.blockState, 1, -2, 2, rotation, sbb);
            this.setBlockStateRotated(world, this.deco.blockState, 1, -2, 1, rotation, sbb);
            this.setBlockStateRotated(world, this.deco.blockState, 2, -2, 1, rotation, sbb);
            this.fillBlocksRotated(world, sbb, 4, 0, 1, 12, 1, 1, this.deco.blockState, rotation);
            for (int i = 3; i < 13; i += 2) {
                this.fillBlocksRotated(world, sbb, i, -1, 1, i, 2, 1, this.deco.blockState, rotation);
            }
            for (int i = 2; i < 9; ++i) {
                final int base = 2 - this.slope;
                if (i < 7) {
                    this.fillBlocksRotated(world, sbb, i - 1, (i - 1) * this.slope + base, i - 1, i, i * this.slope + base - 1, i, this.deco.blockState, rotation);
                }
                else {
                    this.fillBlocksRotated(world, sbb, 16 - i, (i - 1) * this.slope + base, i, 16 - i, i * this.slope + base - 1, i, this.deco.roofState, rotation);
                }
                this.fillBlocksRotated(world, sbb, i + 1, (i - 1) * this.slope + base, i, 15 - i, i * this.slope + base - 1, i, this.deco.roofState, rotation);
            }
            this.fillBlocksRotated(world, sbb, 8, this.slope * 6 + 2, 8, 8, this.slope * 7 + 2, 8, this.deco.roofState, rotation);
        }
        return true;
    }
}
