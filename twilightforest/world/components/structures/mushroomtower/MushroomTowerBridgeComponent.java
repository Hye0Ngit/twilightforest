// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.mushroomtower;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import twilightforest.TwilightForestMod;
import net.minecraft.world.level.block.Rotation;
import twilightforest.world.components.structures.TFStructureComponentOld;
import java.util.Random;
import net.minecraft.world.level.levelgen.structure.StructurePieceAccessor;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.core.Direction;
import twilightforest.world.registration.TFFeature;
import net.minecraft.world.level.levelgen.feature.StructurePieceType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;

public class MushroomTowerBridgeComponent extends MushroomTowerWingComponent
{
    int dSize;
    int dHeight;
    
    public MushroomTowerBridgeComponent(final ServerLevel level, final CompoundTag nbt) {
        this(MushroomTowerPieces.TFMTBri, nbt);
    }
    
    public MushroomTowerBridgeComponent(final StructurePieceType piece, final CompoundTag nbt) {
        super(piece, nbt);
        this.dSize = nbt.m_128451_("destSize");
        this.dHeight = nbt.m_128451_("destHeight");
    }
    
    protected MushroomTowerBridgeComponent(final StructurePieceType piece, final TFFeature feature, final int i, final int x, final int y, final int z, final int pSize, final int pHeight, final Direction direction) {
        super(piece, feature, i, x, y, z, pSize, pHeight, direction);
        this.f_73383_ = feature.getComponentToAddBoundingBox(x, y, z, 0, 0, 0, this.size - 1, this.height - 1, 3, direction);
        this.dSize = pSize;
        this.dHeight = pHeight;
    }
    
    @Override
    protected void m_142347_(final ServerLevel level, final CompoundTag tagCompound) {
        super.m_142347_(level, tagCompound);
        tagCompound.m_128405_("destSize", this.dSize);
        tagCompound.m_128405_("destHeight", this.dHeight);
    }
    
    @Override
    public void m_142537_(final StructurePiece parent, final StructurePieceAccessor list, final Random rand) {
        if (parent != null && parent instanceof TFStructureComponentOld) {
            this.deco = ((TFStructureComponentOld)parent).deco;
        }
        final int[] dest = { this.dSize - 1, 1, 1 };
        final boolean madeWing = this.makeTowerWing(list, rand, this.m_73548_(), dest[0], dest[1], dest[2], this.dSize, this.dHeight, Rotation.NONE);
        if (!madeWing) {
            final int[] dx = this.offsetTowerCoords(dest[0], dest[1], dest[2], this.dSize, Direction.SOUTH);
            TwilightForestMod.LOGGER.info("Making tower wing failed when bridge was already made.  Size = {}, x = {}, z = {}", (Object)this.dSize, (Object)dx[0], (Object)dx[2]);
        }
    }
    
    public BoundingBox getWingBB() {
        final int[] dest = this.offsetTowerCoords(this.dSize - 1, 1, 1, this.dSize, this.m_73549_());
        return this.getFeatureType().getComponentToAddBoundingBox(dest[0], dest[1], dest[2], 0, 0, 0, this.dSize - 1, this.dHeight - 1, this.dSize - 1, this.m_73549_());
    }
    
    @Override
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        for (int x = 0; x < this.dSize; ++x) {
            this.m_73434_(world, this.deco.fenceState, x, 1, 0, sbb);
            this.m_73434_(world, this.deco.fenceState, x, 1, 2, sbb);
            this.m_73434_(world, this.isAscender ? Blocks.f_50743_.m_49966_() : this.deco.floorState, x, 0, 1, sbb);
        }
        this.m_73535_(world, sbb, 0, 1, 1, 2, 2, 1);
        return true;
    }
}
