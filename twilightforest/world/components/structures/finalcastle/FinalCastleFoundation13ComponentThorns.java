// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.finalcastle;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Rotation;
import twilightforest.util.RotationUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import twilightforest.world.components.structures.TFStructureComponentOld;
import java.util.Random;
import twilightforest.world.registration.TFFeature;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;

public class FinalCastleFoundation13ComponentThorns extends FinalCastleFoundation13Component
{
    public FinalCastleFoundation13ComponentThorns(final ServerLevel level, final CompoundTag nbt) {
        super(FinalCastlePieces.TFFCFTh21, nbt);
    }
    
    public FinalCastleFoundation13ComponentThorns(final TFFeature feature, final Random rand, final int i, final TFStructureComponentOld sideTower, final int x, final int y, final int z) {
        super(FinalCastlePieces.TFFCFTh21, feature, rand, i, sideTower, x, y, z);
        this.f_73383_ = new BoundingBox(sideTower.m_73547_().m_162395_() - 5, sideTower.m_73547_().m_162400_() - 1, sideTower.m_73547_().m_162398_() - 5, sideTower.m_73547_().m_162399_() + 5, sideTower.m_73547_().m_162400_(), sideTower.m_73547_().m_162401_() + 5);
    }
    
    @Override
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        final Random decoRNG = new Random(world.m_7328_() + this.f_73383_.m_162395_() * 321534781L ^ this.f_73383_.m_162398_() * 756839L);
        for (final Rotation i : RotationUtil.ROTATIONS) {
            this.makeThornVine(world, decoRNG, i, sbb);
        }
        return true;
    }
    
    private void makeThornVine(final WorldGenLevel world, final Random decoRNG, final Rotation rotation, final BoundingBox sbb) {
        final int x = 3 + decoRNG.nextInt(13);
        final int z = 3 + decoRNG.nextInt(13);
        int y = this.f_73383_.m_71057_() + 5;
        int twist = decoRNG.nextInt(4);
        final int twistMod = 3 + decoRNG.nextInt(3);
        final BlockState thorns = ((Block)TFBlocks.BROWN_THORNS.get()).m_49966_();
        while (this.getBlockStateFromPosRotated(world, x, y, z, sbb, rotation).m_60734_() != TFBlocks.DEADROCK.get() && this.m_73544_(y) > 60) {
            this.setBlockStateRotated(world, thorns, x, y, z, rotation, sbb);
            switch (twist) {
                case 0: {
                    this.setBlockStateRotated(world, thorns, x + 1, y, z, rotation, sbb);
                    this.setBlockStateRotated(world, thorns, x, y, z + 1, rotation, sbb);
                    this.setBlockStateRotated(world, thorns, x + 1, y, z + 1, rotation, sbb);
                    break;
                }
                case 1: {
                    this.setBlockStateRotated(world, thorns, x + 1, y, z, rotation, sbb);
                    this.setBlockStateRotated(world, thorns, x, y, z - 1, rotation, sbb);
                    this.setBlockStateRotated(world, thorns, x + 1, y, z - 1, rotation, sbb);
                    break;
                }
                case 2: {
                    this.setBlockStateRotated(world, thorns, x - 1, y, z, rotation, sbb);
                    this.setBlockStateRotated(world, thorns, x, y, z - 1, rotation, sbb);
                    this.setBlockStateRotated(world, thorns, x - 1, y, z - 1, rotation, sbb);
                    break;
                }
                case 3: {
                    this.setBlockStateRotated(world, thorns, x - 1, y, z, rotation, sbb);
                    this.setBlockStateRotated(world, thorns, x, y, z + 1, rotation, sbb);
                    this.setBlockStateRotated(world, thorns, x - 1, y, z + 1, rotation, sbb);
                    break;
                }
            }
            if (Math.abs(y % twistMod) == 1) {
                this.makeThornBranch(world, x, y, z, rotation, sbb);
            }
            if (y % twistMod == 0) {
                twist = ++twist % 4;
            }
            --y;
        }
    }
    
    private void makeThornBranch(final WorldGenLevel world, final int x, final int y, final int z, final Rotation rotation, final BoundingBox sbb) {
        final Random rand = new Random(world.m_7328_() + x * 321534781 ^ (long)(y * 756839 + z));
        final Rotation dir = RotationUtil.getRandomRotation(rand);
        int dx = 0;
        int dz = 0;
        switch (dir) {
            case NONE: {
                dx = 1;
                break;
            }
            case CLOCKWISE_90: {
                dz = 1;
                break;
            }
            case CLOCKWISE_180: {
                dx = -1;
                break;
            }
            case COUNTERCLOCKWISE_90: {
                dz = -1;
                break;
            }
        }
        final int dist = 2 + rand.nextInt(3);
        final int destX = x + dist * dx;
        final int destZ = z + dist * dz;
        if (destX > 0 && destX < this.f_73383_.m_71056_() && destZ > 0 && destZ < this.f_73383_.m_71058_()) {
            for (int i = 0; i < dist; ++i) {
                final Rotation add = dir.m_55952_(rotation).m_55952_(this.f_73379_);
                final BlockState thorns = (BlockState)((Block)TFBlocks.GREEN_THORNS.get()).m_49966_().m_61124_((Property)RotatedPillarBlock.f_55923_, (Comparable)((add == Rotation.NONE || add == Rotation.CLOCKWISE_180) ? Direction.Axis.X : Direction.Axis.Z));
                if (i > 0) {
                    this.setBlockStateRotated(world, thorns, x + dx * i, y, z + dz * i, rotation, sbb);
                }
                this.setBlockStateRotated(world, (BlockState)thorns.m_61124_((Property)RotatedPillarBlock.f_55923_, (Comparable)Direction.Axis.Y), destX, y + i, destZ, rotation, sbb);
                if (i > dist / 2) {
                    this.setBlockStateRotated(world, thorns, x + dx * i, y + dist - 1, z + dz * i, rotation, sbb);
                }
            }
        }
    }
}
