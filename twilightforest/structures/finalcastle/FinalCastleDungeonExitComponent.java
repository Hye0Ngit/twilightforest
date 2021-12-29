// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.finalcastle;

import net.minecraft.util.math.vector.Vector3i;
import twilightforest.util.StructureBoundingBoxUtils;
import net.minecraft.block.BlockState;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.ISeedReader;
import net.minecraft.util.Rotation;
import twilightforest.structures.TFStructureComponentOld;
import java.util.List;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraft.util.Direction;
import java.util.Random;
import twilightforest.TFFeature;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class FinalCastleDungeonExitComponent extends FinalCastleDungeonRoom31Component
{
    public FinalCastleDungeonExitComponent(final TemplateManager manager, final CompoundNBT nbt) {
        super(FinalCastlePieces.TFFCDunEx, nbt);
    }
    
    public FinalCastleDungeonExitComponent(final TFFeature feature, final Random rand, final int i, final int x, final int y, final int z, final Direction direction, final int level) {
        super(FinalCastlePieces.TFFCDunEx, feature, rand, i, x, y, z, direction, level);
    }
    
    @Override
    public void func_74861_a(final StructurePiece parent, final List<StructurePiece> list, final Random rand) {
        if (parent instanceof TFStructureComponentOld) {
            this.deco = ((TFStructureComponentOld)parent).deco;
        }
        final Rotation bestDir = this.findStairDirectionTowards(parent.func_74874_b().field_78897_a, parent.func_74874_b().field_78896_c);
        final FinalCastleDungeonStepsComponent steps0 = new FinalCastleDungeonStepsComponent(this.getFeatureType(), rand, 5, this.field_74887_e.field_78897_a + 15, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c + 15, bestDir.func_185831_a(Direction.SOUTH));
        list.add(steps0);
        steps0.func_74861_a(this, list, rand);
        if (this.level == 1) {
            steps0.buildLevelUnder(parent, list, rand, this.level + 1);
        }
        else {
            steps0.buildBossRoomUnder(parent, list, rand);
        }
    }
    
    @Override
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random rand, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        if (!super.func_230383_a_(world, manager, generator, rand, sbb, chunkPosIn, blockPos)) {
            return false;
        }
        final BlockState castleDoor = ((Block)TFBlocks.castle_door_pink.get()).func_176223_P();
        this.func_175804_a(world, sbb, 7, 0, 16, 7, 3, 18, castleDoor, FinalCastleDungeonExitComponent.AIR, false);
        this.func_175804_a(world, sbb, 7, 4, 16, 7, 4, 18, this.deco.blockState, this.deco.blockState, false);
        return true;
    }
    
    public Rotation findStairDirectionTowards(final int x, final int z) {
        final Vector3i center = StructureBoundingBoxUtils.getCenter(this.field_74887_e);
        final int dx = center.func_177958_n() - x;
        final int dz = center.func_177952_p() - z;
        Rotation absoluteDir;
        if (Math.abs(dz) >= Math.abs(dx)) {
            absoluteDir = ((dz >= 0) ? Rotation.CLOCKWISE_180 : Rotation.NONE);
        }
        else {
            absoluteDir = ((dx >= 0) ? Rotation.COUNTERCLOCKWISE_90 : Rotation.CLOCKWISE_90);
        }
        return absoluteDir;
    }
    
    @Override
    protected BlockState getForceFieldColor(final Random decoRNG) {
        return ((Block)TFBlocks.force_field_pink.get()).func_176223_P();
    }
    
    @Override
    protected BlockState getRuneColor(final BlockState fieldColor) {
        return ((Block)TFBlocks.castle_rune_brick_pink.get()).func_176223_P();
    }
}
