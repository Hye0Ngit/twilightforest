// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.finalcastle;

import net.minecraft.state.Property;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.ISeedReader;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import java.util.List;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraft.util.Direction;
import java.util.Random;
import twilightforest.TFFeature;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class FinalCastleDungeonEntranceComponent extends FinalCastleDungeonRoom31Component
{
    public boolean hasExit;
    
    public FinalCastleDungeonEntranceComponent(final TemplateManager manager, final CompoundNBT nbt) {
        super(FinalCastlePieces.TFFCDunEn, nbt);
        this.hasExit = false;
    }
    
    public FinalCastleDungeonEntranceComponent(final TFFeature feature, final Random rand, final int i, final int x, final int y, final int z, final Direction direction, final int level) {
        super(FinalCastlePieces.TFFCDunEn, feature, rand, i, x, y, z, direction, level);
        this.hasExit = false;
    }
    
    @Override
    public void func_74861_a(final StructurePiece parent, final List<StructurePiece> list, final Random rand) {
        this.deco = new StructureTFDecoratorCastle();
        this.deco.blockState = ((Block)TFBlocks.castle_rune_brick_yellow.get()).func_176223_P();
        this.deco.fenceState = ((Block)TFBlocks.force_field_pink.get()).func_176223_P();
        super.func_74861_a(this, list, rand);
    }
    
    @Override
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random rand, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        if (!super.func_230383_a_(world, manager, generator, rand, sbb, chunkPosIn, blockPos)) {
            return false;
        }
        final BlockState stairs = (BlockState)this.deco.stairState.func_206870_a((Property)StairsBlock.field_176309_a, (Comparable)Direction.SOUTH);
        final BlockState deadRock = ((Block)TFBlocks.deadrock.get()).func_176223_P();
        for (int y = 0; y <= this.height; ++y) {
            final int x = this.size / 2 - 2;
            final int z = this.size / 2 - y + 2;
            this.func_175804_a(world, sbb, x, 0, z, x + 4, y - 1, z, deadRock, deadRock, false);
            this.func_175804_a(world, sbb, x, y, z, x + 4, y, z, stairs, stairs, false);
            this.func_74878_a(world, sbb, x, y + 1, z, x + 4, y + 6, z);
        }
        final BlockState castleDoor = ((Block)TFBlocks.castle_door_pink.get()).func_176223_P();
        this.func_175804_a(world, sbb, 23, 0, 12, 23, 3, 14, castleDoor, FinalCastleDungeonEntranceComponent.AIR, false);
        this.func_175804_a(world, sbb, 23, 4, 12, 23, 4, 14, this.deco.blockState, this.deco.blockState, false);
        return true;
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
