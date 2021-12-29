// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.stronghold;

import net.minecraft.block.BlockState;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import twilightforest.structures.TFStructureComponentOld;
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

public class StrongholdAccessChamberComponent extends StructureTFStrongholdComponent
{
    public StrongholdAccessChamberComponent(final TemplateManager manager, final CompoundNBT nbt) {
        super(StrongholdPieces.TFSAC, nbt);
    }
    
    public StrongholdAccessChamberComponent(final TFFeature feature, final int i, final Direction facing, final int x, final int y, final int z) {
        super(StrongholdPieces.TFSAC, feature, i, facing, x, y, z);
    }
    
    @Override
    public MutableBoundingBox generateBoundingBox(final Direction facing, final int x, final int y, final int z) {
        return MutableBoundingBox.func_175897_a(x, y, z, -4, 1, 0, 9, 5, 9, facing);
    }
    
    @Override
    public void func_74861_a(final StructurePiece parent, final List<StructurePiece> list, final Random random) {
        super.func_74861_a(parent, list, random);
        this.addNewUpperComponent(parent, list, random, Rotation.NONE, 4, 1, 9);
        this.addNewUpperComponent(parent, list, random, Rotation.CLOCKWISE_90, -1, 1, 4);
        this.addNewUpperComponent(parent, list, random, Rotation.CLOCKWISE_180, 4, 1, -1);
        this.addNewUpperComponent(parent, list, random, Rotation.COUNTERCLOCKWISE_90, 9, 1, 4);
    }
    
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random rand, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        this.func_74882_a(world, sbb, 0, 0, 0, 8, 4, 8, true, rand, this.deco.randomBlocks);
        this.placeSmallDoorwayAt(world, 0, 4, 1, 8, sbb);
        this.placeSmallDoorwayAt(world, 1, 0, 1, 4, sbb);
        this.placeSmallDoorwayAt(world, 2, 4, 1, 0, sbb);
        this.placeSmallDoorwayAt(world, 3, 8, 1, 4, sbb);
        final BlockState defaultState = Blocks.field_196698_dj.func_176223_P();
        this.func_175804_a(world, sbb, 2, -2, 2, 6, 0, 6, defaultState, StrongholdAccessChamberComponent.AIR, false);
        this.func_74878_a(world, sbb, 3, -2, 3, 5, 2, 5);
        this.func_175804_a(world, sbb, 2, 0, 3, 2, 0, 6, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.CLOCKWISE_180.func_185831_a(Direction.WEST), false), StrongholdAccessChamberComponent.AIR, false);
        this.func_175804_a(world, sbb, 6, 0, 2, 6, 0, 6, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.NONE.func_185831_a(Direction.WEST), false), StrongholdAccessChamberComponent.AIR, false);
        this.func_175804_a(world, sbb, 3, 0, 2, 5, 0, 2, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.COUNTERCLOCKWISE_90.func_185831_a(Direction.WEST), false), StrongholdAccessChamberComponent.AIR, false);
        this.func_175804_a(world, sbb, 3, 0, 6, 5, 0, 6, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.CLOCKWISE_90.func_185831_a(Direction.WEST), false), StrongholdAccessChamberComponent.AIR, false);
        this.func_175811_a(world, this.deco.pillarState, 2, 0, 2, sbb);
        this.func_175811_a(world, ((Block)TFBlocks.trophy_pedestal.get()).func_176223_P(), 2, 1, 2, sbb);
        this.func_175804_a(world, sbb, 2, -1, 2, 6, -1, 6, ((Block)TFBlocks.stronghold_shield.get()).func_176223_P(), StrongholdAccessChamberComponent.AIR, false);
        return true;
    }
    
    @Override
    public boolean isComponentProtected() {
        return false;
    }
}
