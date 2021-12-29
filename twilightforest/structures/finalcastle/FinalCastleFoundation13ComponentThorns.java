// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.finalcastle;

import net.minecraft.state.Property;
import net.minecraft.util.Direction;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.BlockState;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import net.minecraft.util.Rotation;
import twilightforest.util.RotationUtil;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.ISeedReader;
import net.minecraft.util.math.MutableBoundingBox;
import twilightforest.structures.TFStructureComponentOld;
import java.util.Random;
import twilightforest.TFFeature;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class FinalCastleFoundation13ComponentThorns extends FinalCastleFoundation13Component
{
    public FinalCastleFoundation13ComponentThorns(final TemplateManager manager, final CompoundNBT nbt) {
        super(FinalCastlePieces.TFFCFTh21, nbt);
    }
    
    public FinalCastleFoundation13ComponentThorns(final TFFeature feature, final Random rand, final int i, final TFStructureComponentOld sideTower) {
        super(FinalCastlePieces.TFFCFTh21, feature, rand, i, sideTower);
        this.field_74887_e = new MutableBoundingBox(sideTower.func_74874_b().field_78897_a - 5, sideTower.func_74874_b().field_78894_e - 1, sideTower.func_74874_b().field_78896_c - 5, sideTower.func_74874_b().field_78893_d + 5, sideTower.func_74874_b().field_78894_e, sideTower.func_74874_b().field_78892_f + 5);
    }
    
    @Override
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random rand, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        final Random decoRNG = new Random(world.func_72905_C() + this.field_74887_e.field_78897_a * 321534781 ^ (long)(this.field_74887_e.field_78896_c * 756839));
        for (final Rotation i : RotationUtil.ROTATIONS) {
            this.makeThornVine(world, decoRNG, i, sbb);
        }
        return true;
    }
    
    private void makeThornVine(final ISeedReader world, final Random decoRNG, final Rotation rotation, final MutableBoundingBox sbb) {
        final int x = 3 + decoRNG.nextInt(13);
        final int z = 3 + decoRNG.nextInt(13);
        int y = this.field_74887_e.func_78882_c() + 5;
        int twist = decoRNG.nextInt(4);
        final int twistMod = 3 + decoRNG.nextInt(3);
        final BlockState thorns = ((Block)TFBlocks.brown_thorns.get()).func_176223_P();
        while (this.getBlockStateFromPosRotated(world, x, y, z, sbb, rotation).func_177230_c() != TFBlocks.deadrock.get() && this.func_74862_a(y) > 60) {
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
    
    private void makeThornBranch(final ISeedReader world, final int x, final int y, final int z, final Rotation rotation, final MutableBoundingBox sbb) {
        final Random rand = new Random(world.func_72905_C() + x * 321534781 ^ (long)(y * 756839 + z));
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
        if (destX > 0 && destX < this.field_74887_e.func_78883_b() && destZ > 0 && destZ < this.field_74887_e.func_78880_d()) {
            for (int i = 0; i < dist; ++i) {
                final Rotation add = dir.func_185830_a(rotation).func_185830_a(this.field_186169_c);
                final BlockState thorns = (BlockState)((Block)TFBlocks.green_thorns.get()).func_176223_P().func_206870_a((Property)RotatedPillarBlock.field_176298_M, (Comparable)((add == Rotation.NONE || add == Rotation.CLOCKWISE_180) ? Direction.Axis.X : Direction.Axis.Z));
                if (i > 0) {
                    this.setBlockStateRotated(world, thorns, x + dx * i, y, z + dz * i, rotation, sbb);
                }
                this.setBlockStateRotated(world, (BlockState)thorns.func_206870_a((Property)RotatedPillarBlock.field_176298_M, (Comparable)Direction.Axis.Y), destX, y + i, destZ, rotation, sbb);
                if (i > dist / 2) {
                    this.setBlockStateRotated(world, thorns, x + dx * i, y + dist - 1, z + dz * i, rotation, sbb);
                }
            }
        }
    }
}
