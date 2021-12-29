// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.minotaurmaze;

import net.minecraft.state.Property;
import net.minecraft.block.HugeMushroomBlock;
import net.minecraft.block.BlockState;
import twilightforest.util.MushroomUtil;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.ISeedReader;
import net.minecraft.util.Direction;
import java.util.Random;
import twilightforest.TFFeature;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class MazeMushRoomComponent extends MazeRoomComponent
{
    public MazeMushRoomComponent(final TemplateManager manager, final CompoundNBT nbt) {
        super(MinotaurMazePieces.TFMMMR, nbt);
    }
    
    public MazeMushRoomComponent(final TFFeature feature, final int i, final Random rand, final int x, final int y, final int z) {
        super(MinotaurMazePieces.TFMMMR, feature, i, rand, x, y, z);
        this.func_186164_a(Direction.SOUTH);
    }
    
    @Override
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random rand, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        super.func_230383_a_(world, manager, generator, rand, sbb, chunkPosIn, blockPos);
        for (int x = 1; x < 14; ++x) {
            for (int z = 1; z < 14; ++z) {
                final int dist = (int)Math.round(7.0 / Math.sqrt((7.5 - x) * (7.5 - x) + (7.5 - z) * (7.5 - z)));
                if (rand.nextInt(dist + 1) > 0) {
                    this.func_175811_a(world, Blocks.field_150391_bh.func_176223_P(), x, 0, z, sbb);
                }
                if (rand.nextInt(dist) > 0) {
                    this.func_175811_a(world, (rand.nextBoolean() ? Blocks.field_150337_Q : Blocks.field_150338_P).func_176223_P(), x, 1, z, sbb);
                }
            }
        }
        final BlockState redMushroomBlock = Blocks.field_150419_aX.func_176223_P();
        final BlockState brownMushroomBlock = Blocks.field_150420_aW.func_176223_P();
        final BlockState stemMushroomBlock = Blocks.field_196706_do.func_176223_P();
        this.makeMediumMushroom(world, sbb, 5, 2, 9, redMushroomBlock);
        this.makeMediumMushroom(world, sbb, 5, 3, 9, redMushroomBlock);
        this.makeMediumMushroom(world, sbb, 9, 2, 5, redMushroomBlock);
        this.makeMediumMushroom(world, sbb, 6, 3, 4, brownMushroomBlock);
        this.makeMediumMushroom(world, sbb, 10, 1, 9, brownMushroomBlock);
        this.func_175811_a(world, stemMushroomBlock, 1, 2, 1, sbb);
        this.func_175811_a(world, MushroomUtil.getState(MushroomUtil.Type.CENTER, redMushroomBlock), 1, 3, 1, sbb);
        this.func_175811_a(world, MushroomUtil.getState(MushroomUtil.Type.NORTH_WEST, redMushroomBlock), 2, 3, 1, sbb);
        this.func_175811_a(world, MushroomUtil.getState(MushroomUtil.Type.NORTH_WEST, redMushroomBlock), 1, 3, 2, sbb);
        this.func_175811_a(world, stemMushroomBlock, 14, 3, 1, sbb);
        this.func_175811_a(world, MushroomUtil.getState(MushroomUtil.Type.CENTER, brownMushroomBlock), 14, 4, 1, sbb);
        this.func_175811_a(world, MushroomUtil.getState(MushroomUtil.Type.NORTH_EAST, brownMushroomBlock), 13, 4, 1, sbb);
        this.func_175811_a(world, MushroomUtil.getState(MushroomUtil.Type.NORTH_EAST, brownMushroomBlock), 14, 4, 2, sbb);
        this.func_175811_a(world, stemMushroomBlock, 1, 1, 14, sbb);
        this.func_175811_a(world, MushroomUtil.getState(MushroomUtil.Type.CENTER, brownMushroomBlock), 1, 2, 14, sbb);
        this.func_175811_a(world, MushroomUtil.getState(MushroomUtil.Type.SOUTH_WEST, brownMushroomBlock), 2, 2, 14, sbb);
        this.func_175811_a(world, MushroomUtil.getState(MushroomUtil.Type.SOUTH_WEST, brownMushroomBlock), 1, 2, 13, sbb);
        this.func_175811_a(world, MushroomUtil.getState(MushroomUtil.Type.CENTER, brownMushroomBlock), 14, 1, 14, sbb);
        this.func_175811_a(world, MushroomUtil.getState(MushroomUtil.Type.SOUTH_EAST, brownMushroomBlock), 13, 1, 14, sbb);
        this.func_175811_a(world, MushroomUtil.getState(MushroomUtil.Type.SOUTH_EAST, brownMushroomBlock), 14, 1, 13, sbb);
        return true;
    }
    
    private void makeMediumMushroom(final ISeedReader world, final MutableBoundingBox sbb, final int mx, final int my, final int mz, final BlockState redMushroomBlock) {
        final BlockState mushroomStem = (BlockState)((BlockState)Blocks.field_196706_do.func_176223_P().func_206870_a((Property)HugeMushroomBlock.field_196460_A, (Comparable)false)).func_206870_a((Property)HugeMushroomBlock.field_196465_z, (Comparable)false);
        this.func_175811_a(world, MushroomUtil.getState(MushroomUtil.Type.CENTER, redMushroomBlock), mx, my, mz, sbb);
        this.func_175811_a(world, MushroomUtil.getState(MushroomUtil.Type.WEST, redMushroomBlock), mx + 1, my, mz, sbb);
        this.func_175811_a(world, MushroomUtil.getState(MushroomUtil.Type.NORTH_WEST, redMushroomBlock), mx + 1, my, mz + 1, sbb);
        this.func_175811_a(world, MushroomUtil.getState(MushroomUtil.Type.NORTH, redMushroomBlock), mx, my, mz + 1, sbb);
        this.func_175811_a(world, MushroomUtil.getState(MushroomUtil.Type.NORTH_EAST, redMushroomBlock), mx - 1, my, mz + 1, sbb);
        this.func_175811_a(world, MushroomUtil.getState(MushroomUtil.Type.EAST, redMushroomBlock), mx - 1, my, mz, sbb);
        this.func_175811_a(world, MushroomUtil.getState(MushroomUtil.Type.SOUTH_EAST, redMushroomBlock), mx - 1, my, mz - 1, sbb);
        this.func_175811_a(world, MushroomUtil.getState(MushroomUtil.Type.SOUTH, redMushroomBlock), mx, my, mz - 1, sbb);
        this.func_175811_a(world, MushroomUtil.getState(MushroomUtil.Type.SOUTH_WEST, redMushroomBlock), mx + 1, my, mz - 1, sbb);
        for (int y = 1; y < my; ++y) {
            this.func_175811_a(world, mushroomStem, mx, y, mz, sbb);
        }
    }
}
