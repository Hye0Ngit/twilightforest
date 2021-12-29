// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.darktower;

import twilightforest.block.TFBlocks;
import twilightforest.block.GhastTrapBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.WorldGenLevel;
import twilightforest.util.RotationUtil;
import net.minecraft.world.level.block.Rotation;
import twilightforest.world.components.structures.TFStructureComponentOld;
import java.util.Random;
import net.minecraft.world.level.levelgen.structure.StructurePieceAccessor;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.core.Direction;
import twilightforest.world.registration.TFFeature;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;

public class DarkTowerBossTrapComponent extends DarkTowerWingComponent
{
    public DarkTowerBossTrapComponent(final ServerLevel level, final CompoundTag nbt) {
        super(DarkTowerPieces.TFDTBT, nbt);
    }
    
    protected DarkTowerBossTrapComponent(final TFFeature feature, final int i, final int x, final int y, final int z, final int pSize, final int pHeight, final Direction direction) {
        super(DarkTowerPieces.TFDTBT, feature, i, x, y, z, pSize, pHeight, direction);
        this.spawnListIndex = -1;
    }
    
    @Override
    public void m_142537_(final StructurePiece parent, final StructurePieceAccessor list, final Random rand) {
        if (parent != null && parent instanceof TFStructureComponentOld) {
            this.deco = ((TFStructureComponentOld)parent).deco;
        }
        this.addOpening(0, 1, this.size / 2, Rotation.CLOCKWISE_180);
        this.makeABeard(parent, list, rand);
        for (final Rotation i : RotationUtil.ROTATIONS) {
            if (i != Rotation.CLOCKWISE_180) {
                if (!rand.nextBoolean()) {
                    final int[] dest = this.getValidOpening(rand, i);
                    dest[1] = 1;
                    this.makeTowerBalcony(list, rand, this.m_73548_(), dest[0], dest[1], dest[2], i);
                }
            }
        }
    }
    
    @Override
    public void makeARoof(final StructurePiece parent, final StructurePieceAccessor list, final Random rand) {
    }
    
    @Override
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        final Random decoRNG = new Random(world.m_7328_() + this.f_73383_.m_162395_() * 321534781L ^ this.f_73383_.m_162398_() * 756839L);
        this.makeEncasedWalls(world, rand, sbb, 0, 0, 0, this.size - 1, this.height - 1, this.size - 1);
        this.m_73535_(world, sbb, 1, 1, 1, this.size - 2, this.height - 2, this.size - 2);
        this.makeOpenings(world, sbb);
        this.addBossTrapFloors(world, sbb);
        this.destroyTower(world, decoRNG, 5, this.height + 2, 5, 4, sbb);
        this.destroyTower(world, decoRNG, 0, this.height, 0, 3, sbb);
        this.destroyTower(world, decoRNG, 0, this.height, 8, 4, sbb);
        this.destroyTower(world, decoRNG, 5, 6, 5, 2, sbb);
        this.m_73441_(world, sbb, 1, 0, 1, this.size / 2, 0, this.size - 2, this.deco.blockState, Blocks.f_50016_.m_49966_(), false);
        this.m_73441_(world, sbb, 1, 1, 1, this.size / 2, 1, this.size - 2, Blocks.f_50016_.m_49966_(), Blocks.f_50016_.m_49966_(), false);
        this.m_73434_(world, ((GhastTrapBlock)TFBlocks.GHAST_TRAP.get()).m_49966_(), 5, 1, 5, sbb);
        this.m_73434_(world, Blocks.f_50088_.m_49966_(), 5, 1, 6, sbb);
        this.m_73434_(world, Blocks.f_50088_.m_49966_(), 5, 1, 7, sbb);
        this.m_73434_(world, Blocks.f_50088_.m_49966_(), 5, 1, 8, sbb);
        this.m_73434_(world, Blocks.f_50088_.m_49966_(), 4, 1, 8, sbb);
        this.m_73434_(world, Blocks.f_50088_.m_49966_(), 3, 1, 8, sbb);
        this.m_73434_(world, Blocks.f_50167_.m_49966_(), 2, 1, 8, sbb);
        return true;
    }
    
    protected void addBossTrapFloors(final WorldGenLevel world, final BoundingBox sbb) {
        this.makeFullFloor(world, sbb, 4);
        this.addStairsDown(world, sbb, Rotation.COUNTERCLOCKWISE_90, 4, this.size - 2, 4);
        this.addStairsDown(world, sbb, Rotation.COUNTERCLOCKWISE_90, 4, this.size - 3, 4);
        this.addStairsDown(world, sbb, Rotation.CLOCKWISE_90, this.height - 1, this.size - 2, 4);
        this.addStairsDown(world, sbb, Rotation.CLOCKWISE_90, this.height - 1, this.size - 3, 4);
    }
}
