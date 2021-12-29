// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.stronghold;

import net.minecraft.state.Property;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.IBlockReader;
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

public class StrongholdUpperAscenderComponent extends StructureTFStrongholdComponent
{
    boolean exitTop;
    
    public StrongholdUpperAscenderComponent(final TemplateManager manager, final CompoundNBT nbt) {
        super(StrongholdPieces.TFSUA, nbt);
        this.exitTop = nbt.func_74767_n("exitTop");
    }
    
    public StrongholdUpperAscenderComponent(final TFFeature feature, final int i, final Direction facing, final int x, final int y, final int z) {
        super(StrongholdPieces.TFSUA, feature, i, facing, x, y, z);
    }
    
    @Override
    protected void func_143011_b(final CompoundNBT tagCompound) {
        super.func_143011_b(tagCompound);
        tagCompound.func_74757_a("exitTop", this.exitTop);
    }
    
    @Override
    public MutableBoundingBox generateBoundingBox(final Direction facing, final int x, final int y, final int z) {
        if (y < 36) {
            this.exitTop = true;
            return MutableBoundingBox.func_175897_a(x, y, z, -2, -1, 0, 5, 10, 10, facing);
        }
        this.exitTop = false;
        return MutableBoundingBox.func_175897_a(x, y, z, -2, -6, 0, 5, 10, 10, facing);
    }
    
    @Override
    public void func_74861_a(final StructurePiece parent, final List<StructurePiece> list, final Random random) {
        super.func_74861_a(parent, list, random);
        this.addNewUpperComponent(parent, list, random, Rotation.NONE, 2, this.exitTop ? 6 : 1, 10);
    }
    
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random rand, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        if (this.func_74860_a((IBlockReader)world, sbb)) {
            return false;
        }
        this.placeUpperStrongholdWalls(world, sbb, 0, 0, 0, 4, 9, 9, rand, this.deco.randomBlocks);
        this.placeSmallDoorwayAt(world, 2, 2, this.exitTop ? 1 : 6, 0, sbb);
        this.placeSmallDoorwayAt(world, 0, 2, this.exitTop ? 6 : 1, 9, sbb);
        if (this.exitTop) {
            this.makeStairsAt(world, 1, 3, Direction.NORTH, sbb);
            this.makeStairsAt(world, 2, 4, Direction.NORTH, sbb);
            this.makeStairsAt(world, 3, 5, Direction.NORTH, sbb);
            this.makeStairsAt(world, 4, 6, Direction.NORTH, sbb);
            this.makeStairsAt(world, 5, 7, Direction.NORTH, sbb);
            this.makePlatformAt(world, 5, 8, sbb);
        }
        else {
            this.makeStairsAt(world, 1, 6, Direction.NORTH, sbb);
            this.makeStairsAt(world, 2, 5, Direction.NORTH, sbb);
            this.makeStairsAt(world, 3, 4, Direction.NORTH, sbb);
            this.makeStairsAt(world, 4, 3, Direction.NORTH, sbb);
            this.makeStairsAt(world, 5, 2, Direction.NORTH, sbb);
            this.makePlatformAt(world, 5, 1, sbb);
        }
        return true;
    }
    
    private void makeStairsAt(final ISeedReader world, final int y, final int z, final Direction facing, final MutableBoundingBox sbb) {
        if (this.func_175807_a((IBlockReader)world, 0, y, z, sbb).func_177230_c() != Blocks.field_150350_a || this.func_175807_a((IBlockReader)world, 4, y, z, sbb).func_177230_c() != Blocks.field_150350_a) {
            for (int x = 1; x < 4; ++x) {
                this.func_175811_a(world, (BlockState)Blocks.field_150390_bg.func_176223_P().func_206870_a((Property)StairsBlock.field_176309_a, (Comparable)facing), x, y, z, sbb);
            }
        }
    }
    
    private void makePlatformAt(final ISeedReader world, final int y, final int z, final MutableBoundingBox sbb) {
        if (this.func_175807_a((IBlockReader)world, 0, y, z, sbb).func_177230_c() != Blocks.field_150350_a || this.func_175807_a((IBlockReader)world, 4, y, z, sbb).func_177230_c() != Blocks.field_150350_a) {
            for (int x = 1; x < 4; ++x) {
                this.func_175811_a(world, Blocks.field_196696_di.func_176223_P(), x, y, z, sbb);
            }
        }
    }
    
    @Override
    public boolean isComponentProtected() {
        return false;
    }
}
