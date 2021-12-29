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

public class TowerRoofGableForwardsComponent extends TowerRoofComponent
{
    public TowerRoofGableForwardsComponent(final ServerLevel level, final CompoundTag nbt) {
        super(LichTowerPieces.TFLTRGF, nbt);
    }
    
    public TowerRoofGableForwardsComponent(final TFFeature feature, final int i, final TowerWingComponent wing, final int x, final int y, final int z) {
        super(LichTowerPieces.TFLTRGF, feature, i, x, y, z);
        this.m_73519_(wing.m_73549_());
        this.size = wing.size + 2;
        this.height = this.size;
        this.makeAttachedOverhangBB(wing);
    }
    
    @Override
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        final BlockState birchSlab = Blocks.f_50400_.m_49966_();
        final BlockState birchPlanks = Blocks.f_50742_.m_49966_();
        final int slopeChange = this.slopeChangeForSize();
        for (int y = 0; y <= this.height; ++y) {
            int min;
            int max;
            if (y < slopeChange) {
                min = y;
                max = this.size - y - 1;
            }
            else {
                min = (y + slopeChange) / 2;
                max = this.size - (y + slopeChange) / 2 - 1;
            }
            for (int x = 0; x <= this.size - 2; ++x) {
                for (int z = min; z <= max; ++z) {
                    if (z == min || z == max) {
                        this.m_73434_(world, birchPlanks, x, y, z, sbb);
                    }
                    else if (x < this.size - 2) {
                        this.m_73434_(world, birchPlanks, x, y, z, sbb);
                    }
                }
            }
        }
        final int top = this.size + 1 - slopeChange;
        final int zMid = this.size / 2;
        this.m_73434_(world, (BlockState)birchSlab.m_61124_((Property)SlabBlock.f_56353_, (Comparable)SlabType.TOP), this.size - 1, top - 1, zMid, sbb);
        this.m_73434_(world, birchSlab, 0, top, zMid, sbb);
        this.m_73434_(world, birchSlab, this.size - 3, top, zMid, sbb);
        this.m_73434_(world, birchPlanks, this.size - 2, top, zMid, sbb);
        this.m_73434_(world, birchPlanks, this.size - 1, top, zMid, sbb);
        this.m_73434_(world, birchPlanks, this.size - 1, top + 1, zMid, sbb);
        return true;
    }
    
    public int slopeChangeForSize() {
        if (this.size > 10) {
            return 3;
        }
        if (this.size > 6) {
            return 2;
        }
        return 1;
    }
}
