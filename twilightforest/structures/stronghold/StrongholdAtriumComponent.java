// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.stronghold;

import twilightforest.structures.TFStructureComponentOld;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import twilightforest.worldgen.ConfiguredFeatures;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.ISeedReader;
import net.minecraft.util.Rotation;
import java.util.Random;
import java.util.List;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.Direction;
import twilightforest.TFFeature;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class StrongholdAtriumComponent extends StructureTFStrongholdComponent
{
    private boolean enterBottom;
    
    public StrongholdAtriumComponent(final TemplateManager manager, final CompoundNBT nbt) {
        super(StrongholdPieces.TFSAt, nbt);
        this.enterBottom = nbt.func_74767_n("enterBottom");
    }
    
    public StrongholdAtriumComponent(final TFFeature feature, final int i, final Direction facing, final int x, final int y, final int z) {
        super(StrongholdPieces.TFSAt, feature, i, facing, x, y, z);
    }
    
    @Override
    protected void func_143011_b(final CompoundNBT tagCompound) {
        super.func_143011_b(tagCompound);
        tagCompound.func_74757_a("enterBottom", this.enterBottom);
    }
    
    @Override
    public MutableBoundingBox generateBoundingBox(final Direction facing, final int x, final int y, final int z) {
        if (y > 17) {
            this.enterBottom = false;
        }
        else if (y < 11) {
            this.enterBottom = true;
        }
        else {
            this.enterBottom = ((z & 0x1) == 0x0);
        }
        if (this.enterBottom) {
            return StructureTFStrongholdComponent.getComponentToAddBoundingBox(x, y, z, -4, -1, 0, 18, 14, 18, facing);
        }
        return StructureTFStrongholdComponent.getComponentToAddBoundingBox(x, y, z, -13, -8, 0, 18, 14, 18, facing);
    }
    
    @Override
    public void func_74861_a(final StructurePiece parent, final List<StructurePiece> list, final Random random) {
        super.func_74861_a(parent, list, random);
        if (this.enterBottom) {
            this.addDoor(4, 1, 0);
            this.addNewComponent(parent, list, random, Rotation.CLOCKWISE_180, 13, 8, -1);
        }
        else {
            this.addDoor(13, 8, 0);
            this.addNewComponent(parent, list, random, Rotation.CLOCKWISE_180, 4, 1, -1);
        }
        this.addNewComponent(parent, list, random, Rotation.NONE, 13, 1, 18);
        this.addNewComponent(parent, list, random, Rotation.NONE, 4, 8, 18);
    }
    
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random rand, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        this.placeStrongholdWalls(world, sbb, 0, 0, 0, 17, 13, 17, rand, this.deco.randomBlocks);
        this.func_74882_a(world, sbb, 1, 6, 1, 16, 7, 16, false, rand, this.deco.randomBlocks);
        this.func_175804_a(world, sbb, 5, 8, 5, 12, 8, 12, this.deco.fenceState, StrongholdAtriumComponent.AIR, false);
        this.func_74878_a(world, sbb, 6, 6, 6, 11, 8, 11);
        this.placeBalconyPillar(world, sbb, Rotation.NONE);
        this.placeBalconyPillar(world, sbb, Rotation.CLOCKWISE_90);
        this.placeBalconyPillar(world, sbb, Rotation.CLOCKWISE_180);
        this.placeBalconyPillar(world, sbb, Rotation.COUNTERCLOCKWISE_90);
        this.func_74882_a(world, sbb, 1, 1, 1, 1, 12, 2, false, rand, this.deco.randomBlocks);
        this.func_74882_a(world, sbb, 2, 1, 1, 2, 12, 1, false, rand, this.deco.randomBlocks);
        this.func_74882_a(world, sbb, 16, 1, 1, 16, 12, 2, false, rand, this.deco.randomBlocks);
        this.func_74882_a(world, sbb, 15, 1, 1, 15, 12, 1, false, rand, this.deco.randomBlocks);
        this.func_74882_a(world, sbb, 1, 1, 15, 1, 12, 16, false, rand, this.deco.randomBlocks);
        this.func_74882_a(world, sbb, 2, 1, 16, 2, 12, 16, false, rand, this.deco.randomBlocks);
        this.func_74882_a(world, sbb, 16, 1, 15, 16, 12, 16, false, rand, this.deco.randomBlocks);
        this.func_74882_a(world, sbb, 15, 1, 16, 15, 12, 16, false, rand, this.deco.randomBlocks);
        final BlockState grass = Blocks.field_196658_i.func_176223_P();
        this.func_189914_a(world, sbb, rand, 0.5f, 6, 0, 6, 11, 0, 11, grass, grass, false, false);
        this.func_175804_a(world, sbb, 7, 0, 7, 10, 0, 10, grass, StrongholdAtriumComponent.AIR, false);
        this.spawnATree(world, generator, rand.nextInt(5), 8, 1, 8, sbb);
        this.placeCornerStatue(world, 2, 8, 2, 0, sbb);
        this.placeCornerStatue(world, 2, 1, 15, 1, sbb);
        this.placeCornerStatue(world, 15, 1, 2, 2, sbb);
        this.placeCornerStatue(world, 15, 8, 15, 3, sbb);
        this.placeDoors(world, sbb);
        return true;
    }
    
    private void spawnATree(final ISeedReader world, final ChunkGenerator generator, final int treeNum, final int x, final int y, final int z, final MutableBoundingBox sbb) {
        final BlockPos pos = this.getBlockPosWithOffset(x, y, z);
        if (sbb.func_175898_b((Vector3i)pos)) {
            ConfiguredFeature<?, ?> treeGen = null;
            switch (treeNum) {
                default: {
                    treeGen = (ConfiguredFeature<?, ?>)Features.field_243862_bH;
                    break;
                }
                case 1: {
                    treeGen = (ConfiguredFeature<?, ?>)Features.field_243868_bN;
                    break;
                }
                case 2: {
                    treeGen = (ConfiguredFeature<?, ?>)Features.field_243864_bJ;
                    break;
                }
                case 3: {
                    treeGen = ConfiguredFeatures.TWILIGHT_OAK_BASE;
                    break;
                }
                case 4: {
                    treeGen = ConfiguredFeatures.RAINBOW_OAK_TREE_BASE;
                    break;
                }
            }
            for (int i = 0; i < 100; ++i) {
                if (treeGen.func_242765_a(world, generator, world.func_201674_k(), pos)) {
                    break;
                }
            }
        }
    }
    
    private void placeBalconyPillar(final ISeedReader world, final MutableBoundingBox sbb, final Rotation rotation) {
        this.fillBlocksRotated(world, sbb, 5, 1, 5, 5, 12, 5, this.deco.pillarState, rotation);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.COUNTERCLOCKWISE_90.func_185831_a(Direction.WEST), false), 5, 1, 6, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.CLOCKWISE_180.func_185831_a(Direction.WEST), false), 6, 1, 5, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.COUNTERCLOCKWISE_90.func_185831_a(Direction.WEST), true), 5, 5, 6, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.CLOCKWISE_180.func_185831_a(Direction.WEST), true), 6, 5, 5, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.COUNTERCLOCKWISE_90.func_185831_a(Direction.WEST), true), 5, 12, 6, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.CLOCKWISE_180.func_185831_a(Direction.WEST), true), 6, 12, 5, rotation, sbb);
    }
}
