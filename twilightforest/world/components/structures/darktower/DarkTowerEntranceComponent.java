// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.darktower;

import net.minecraft.world.level.levelgen.feature.NoiseEffect;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Rotation;
import java.util.Random;
import net.minecraft.world.level.levelgen.structure.StructurePieceAccessor;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.core.Direction;
import twilightforest.world.registration.TFFeature;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;

public class DarkTowerEntranceComponent extends DarkTowerWingComponent
{
    public DarkTowerEntranceComponent(final ServerLevel level, final CompoundTag nbt) {
        super(DarkTowerPieces.TFDTEnt, nbt);
    }
    
    protected DarkTowerEntranceComponent(final TFFeature feature, final int i, final int x, final int y, final int z, final int pSize, final int pHeight, final Direction direction) {
        super(DarkTowerPieces.TFDTEnt, feature, i, x, y, z, pSize, pHeight, direction);
    }
    
    @Override
    public void m_142537_(final StructurePiece parent, final StructurePieceAccessor list, final Random rand) {
        super.m_142537_(parent, list, rand);
        this.addOpening(this.size / 2, 1, 0, Rotation.CLOCKWISE_90, EnumDarkTowerDoor.REAPPEARING);
        this.addOpening(this.size / 2, 1, this.size - 1, Rotation.COUNTERCLOCKWISE_90, EnumDarkTowerDoor.REAPPEARING);
    }
    
    @Override
    public void makeABeard(final StructurePiece parent, final StructurePieceAccessor list, final Random rand) {
    }
    
    @Override
    public void makeARoof(final StructurePiece parent, final StructurePieceAccessor list, final Random rand) {
    }
    
    @Override
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        this.makeEncasedWalls(world, rand, sbb, 0, 0, 0, this.size - 1, this.height - 1, this.size - 1);
        for (int x = 0; x < this.size; ++x) {
            for (int z = 0; z < this.size; ++z) {
                this.m_73434_(world, this.deco.accentState, x, -1, z, sbb);
            }
        }
        this.m_73535_(world, sbb, 1, 1, 1, this.size - 2, this.height - 2, this.size - 2);
        this.makeOpenings(world, sbb);
        return true;
    }
    
    @Override
    public NoiseEffect m_142318_() {
        return NoiseEffect.BEARD;
    }
}
