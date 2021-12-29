// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.lichtower;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.level.block.SlabBlock;
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
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;

public class TowerRoofSlabForwardsComponent extends TowerRoofSlabComponent
{
    public TowerRoofSlabForwardsComponent(final ServerLevel level, final CompoundTag nbt) {
        super(LichTowerPieces.TFLTRSF, nbt);
    }
    
    public TowerRoofSlabForwardsComponent(final TFFeature feature, final int i, final TowerWingComponent wing, final int x, final int y, final int z) {
        super(LichTowerPieces.TFLTRSF, feature, i, wing, x, y, z);
        this.m_73519_(wing.m_73549_());
        this.size = wing.size + 2;
        this.height = this.size / 2;
        this.makeAttachedOverhangBB(wing);
    }
    
    @Override
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        final BlockState birchSlab = Blocks.f_50400_.m_49966_();
        final BlockState birchDoubleSlab = (BlockState)Blocks.f_50400_.m_49966_().m_61124_((Property)SlabBlock.f_56353_, (Comparable)SlabType.DOUBLE);
        for (int y = 0; y <= this.height; ++y) {
            final int min = 2 * y;
            for (int max = this.size - 2 * y - 1, x = 0; x <= max - 1; ++x) {
                for (int z = min; z <= max; ++z) {
                    if (x == max - 1 || z == min || z == max) {
                        this.m_73434_(world, birchSlab, x, y, z, sbb);
                    }
                    else {
                        this.m_73434_(world, birchDoubleSlab, x, y, z, sbb);
                    }
                }
            }
        }
        return true;
    }
}
