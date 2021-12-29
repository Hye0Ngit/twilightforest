// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.minotaurmaze;

import net.minecraft.state.Property;
import net.minecraft.block.HugeMushroomBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import java.util.Random;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.ISeedReader;
import net.minecraft.util.Direction;
import twilightforest.TFFeature;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class MazeCorridorShroomsComponent extends MazeCorridorComponent
{
    public MazeCorridorShroomsComponent(final TemplateManager manager, final CompoundNBT nbt) {
        super(MinotaurMazePieces.TFMMCS, nbt);
    }
    
    public MazeCorridorShroomsComponent(final TFFeature feature, final int i, final int x, final int y, final int z, final Direction rotation) {
        super(MinotaurMazePieces.TFMMCS, feature, i, x, y, z, rotation);
    }
    
    @Override
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random rand, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        for (int x = 1; x < 5; ++x) {
            for (int z = 0; z < 5; ++z) {
                if (rand.nextInt(2) > 0) {
                    this.func_175811_a(world, Blocks.field_150391_bh.func_176223_P(), x, 0, z, sbb);
                }
                if (rand.nextInt(2) > 0) {
                    this.func_175811_a(world, rand.nextBoolean() ? Blocks.field_150337_Q.func_176223_P() : Blocks.field_150338_P.func_176223_P(), x, 1, z, sbb);
                }
            }
        }
        final boolean mushFlag = rand.nextBoolean();
        BlockState mushType = (mushFlag ? Blocks.field_150419_aX : Blocks.field_150420_aW).func_176223_P();
        final BlockState fullStem = Blocks.field_196706_do.func_176223_P();
        final BlockState stem = (BlockState)((BlockState)fullStem.func_206870_a((Property)HugeMushroomBlock.field_196465_z, (Comparable)false)).func_206870_a((Property)HugeMushroomBlock.field_196460_A, (Comparable)false);
        int mushY = rand.nextInt(4) + 1;
        int mushZ = rand.nextInt(4) + 1;
        this.func_175811_a(world, fullStem, 1, mushY - 1, mushZ, sbb);
        this.func_175804_a(world, sbb, 1, 1, mushZ, 1, mushY, mushZ, stem, MazeCorridorShroomsComponent.AIR, false);
        this.func_175804_a(world, sbb, 1, mushY, mushZ - 1, 2, mushY, mushZ + 1, mushType, MazeCorridorShroomsComponent.AIR, false);
        mushType = (mushFlag ? Blocks.field_150420_aW : Blocks.field_150419_aX).func_176223_P();
        mushY = rand.nextInt(4) + 1;
        mushZ = rand.nextInt(4) + 1;
        this.func_175804_a(world, sbb, 4, 1, mushZ, 4, mushY, mushZ, stem, MazeCorridorShroomsComponent.AIR, false);
        this.func_175804_a(world, sbb, 3, mushY, mushZ - 1, 4, mushY, mushZ + 1, mushType, MazeCorridorShroomsComponent.AIR, false);
        return true;
    }
}
