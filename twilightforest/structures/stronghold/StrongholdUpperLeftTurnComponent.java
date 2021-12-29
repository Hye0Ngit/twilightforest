// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.stronghold;

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

public class StrongholdUpperLeftTurnComponent extends StructureTFStrongholdComponent
{
    public StrongholdUpperLeftTurnComponent(final TemplateManager manager, final CompoundNBT nbt) {
        super(StrongholdPieces.TFSULT, nbt);
    }
    
    public StrongholdUpperLeftTurnComponent(final TFFeature feature, final int i, final Direction facing, final int x, final int y, final int z) {
        super(StrongholdPieces.TFSULT, feature, i, facing, x, y, z);
    }
    
    @Override
    public MutableBoundingBox generateBoundingBox(final Direction facing, final int x, final int y, final int z) {
        return MutableBoundingBox.func_175897_a(x, y, z, -2, -1, 0, 5, 5, 5, facing);
    }
    
    @Override
    public void func_74861_a(final StructurePiece parent, final List<StructurePiece> list, final Random random) {
        super.func_74861_a(parent, list, random);
        this.addNewUpperComponent(parent, list, random, Rotation.COUNTERCLOCKWISE_90, 5, 1, 2);
    }
    
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random rand, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        if (this.func_74860_a((IBlockReader)world, sbb)) {
            return false;
        }
        this.placeUpperStrongholdWalls(world, sbb, 0, 0, 0, 4, 4, 4, rand, this.deco.randomBlocks);
        this.placeSmallDoorwayAt(world, 2, 2, 1, 0, sbb);
        this.placeSmallDoorwayAt(world, 3, 4, 1, 2, sbb);
        return true;
    }
    
    @Override
    public boolean isComponentProtected() {
        return false;
    }
}
