// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.lichtower;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import java.util.Random;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.WorldGenLevel;
import twilightforest.world.registration.TFFeature;
import net.minecraft.world.level.levelgen.feature.StructurePieceType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;

public class TowerRoofSlabComponent extends TowerRoofComponent
{
    public TowerRoofSlabComponent(final ServerLevel level, final CompoundTag nbt) {
        super(LichTowerPieces.TFLTRS, nbt);
    }
    
    public TowerRoofSlabComponent(final StructurePieceType piece, final CompoundTag nbt) {
        super(piece, nbt);
    }
    
    public TowerRoofSlabComponent(final StructurePieceType piece, final TFFeature feature, final int i, final TowerWingComponent wing, final int x, final int y, final int z) {
        super(piece, feature, i, x, y, z);
        this.m_73519_(wing.m_73549_());
        this.size = wing.size;
        this.height = this.size / 2;
        this.makeCapBB(wing);
    }
    
    @Override
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        return this.makePyramidCap(world, Blocks.f_50400_.m_49966_(), Blocks.f_50742_.m_49966_(), sbb);
    }
    
    protected boolean makePyramidCap(final WorldGenLevel world, final BlockState slabType, final BlockState woodType, final BoundingBox sbb) {
        for (int y = 0; y <= this.height; ++y) {
            final int min = 2 * y;
            for (int max = this.size - 2 * y - 1, x = min; x <= max; ++x) {
                for (int z = min; z <= max; ++z) {
                    if (x == min || x == max || z == min || z == max) {
                        this.m_73434_(world, slabType, x, y, z, sbb);
                    }
                    else {
                        this.m_73434_(world, woodType, x, y, z, sbb);
                    }
                }
            }
        }
        return true;
    }
    
    protected boolean makeConnectedCap(final WorldGenLevel world, final BlockState slabType, final BlockState woodType, final BoundingBox sbb) {
        for (int y = 0; y < this.height; ++y) {
            final int min = 2 * y;
            for (int max = this.size - 2 * y - 1, x = 0; x <= max; ++x) {
                for (int z = min; z <= max; ++z) {
                    if (x == max || z == min || z == max) {
                        this.m_73434_(world, slabType, x, y, z, sbb);
                    }
                    else {
                        this.m_73434_(world, woodType, x, y, z, sbb);
                    }
                }
            }
        }
        return true;
    }
}
