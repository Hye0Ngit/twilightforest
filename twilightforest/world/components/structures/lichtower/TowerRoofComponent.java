// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.lichtower;

import net.minecraft.world.level.levelgen.structure.StructurePieceAccessor;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import java.util.Random;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import twilightforest.world.registration.TFFeature;
import net.minecraft.world.level.levelgen.feature.StructurePieceType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import twilightforest.world.components.structures.TFStructureComponentOld;

public class TowerRoofComponent extends TFStructureComponentOld
{
    protected int size;
    protected int height;
    
    public TowerRoofComponent(final ServerLevel level, final CompoundTag nbt) {
        this(LichTowerPieces.TFLTRoo, nbt);
    }
    
    public TowerRoofComponent(final StructurePieceType piece, final CompoundTag nbt) {
        super(piece, nbt);
        this.size = nbt.m_128451_("roofSize");
        this.height = nbt.m_128451_("roofHeight");
    }
    
    public TowerRoofComponent(final StructurePieceType type, final TFFeature feature, final int i, final int x, final int y, final int z) {
        super(type, feature, i, x, y, z);
        this.spawnListIndex = -1;
    }
    
    @Override
    protected void m_142347_(final ServerLevel level, final CompoundTag tagCompound) {
        super.m_142347_(level, tagCompound);
        tagCompound.m_128405_("roofSize", this.size);
        tagCompound.m_128405_("roofHeight", this.height);
    }
    
    protected void makeAttachedOverhangBB(final TowerWingComponent wing) {
        switch (this.m_73549_()) {
            case SOUTH: {
                this.f_73383_ = new BoundingBox(wing.m_73547_().m_162395_(), wing.m_73547_().m_162400_(), wing.m_73547_().m_162398_() - 1, wing.m_73547_().m_162399_() + 1, wing.m_73547_().m_162400_() + this.height - 1, wing.m_73547_().m_162401_() + 1);
                break;
            }
            case WEST: {
                this.f_73383_ = new BoundingBox(wing.m_73547_().m_162395_() - 1, wing.m_73547_().m_162400_(), wing.m_73547_().m_162398_(), wing.m_73547_().m_162399_() + 1, wing.m_73547_().m_162400_() + this.height - 1, wing.m_73547_().m_162401_() + 1);
                break;
            }
            case EAST: {
                this.f_73383_ = new BoundingBox(wing.m_73547_().m_162395_() - 1, wing.m_73547_().m_162400_(), wing.m_73547_().m_162398_() - 1, wing.m_73547_().m_162399_(), wing.m_73547_().m_162400_() + this.height - 1, wing.m_73547_().m_162401_() + 1);
                break;
            }
            case NORTH: {
                this.f_73383_ = new BoundingBox(wing.m_73547_().m_162395_() - 1, wing.m_73547_().m_162400_(), wing.m_73547_().m_162398_() - 1, wing.m_73547_().m_162399_() + 1, wing.m_73547_().m_162400_() + this.height - 1, wing.m_73547_().m_162401_());
                break;
            }
        }
    }
    
    protected void makeCapBB(final TowerWingComponent wing) {
        this.f_73383_ = new BoundingBox(wing.m_73547_().m_162395_(), wing.m_73547_().m_162400_(), wing.m_73547_().m_162398_(), wing.m_73547_().m_162399_(), wing.m_73547_().m_162400_() + this.height, wing.m_73547_().m_162401_());
    }
    
    protected void makeOverhangBB(final TowerWingComponent wing) {
        this.f_73383_ = new BoundingBox(wing.m_73547_().m_162395_() - 1, wing.m_73547_().m_162400_(), wing.m_73547_().m_162398_() - 1, wing.m_73547_().m_162399_() + 1, wing.m_73547_().m_162400_() + this.height - 1, wing.m_73547_().m_162401_() + 1);
    }
    
    public boolean m_7832_(final WorldGenLevel worldIn, final StructureFeatureManager manager, final ChunkGenerator generator, final Random randomIn, final BoundingBox structureBoundingBoxIn, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        return false;
    }
    
    public boolean fits(final TowerWingComponent parent, final StructurePieceAccessor list) {
        return list.m_141921_(this.f_73383_) == parent;
    }
}
