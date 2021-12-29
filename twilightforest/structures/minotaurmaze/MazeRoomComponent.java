// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.minotaurmaze;

import net.minecraft.block.Blocks;
import net.minecraft.world.IBlockReader;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.ISeedReader;
import java.util.List;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.Direction;
import java.util.Random;
import twilightforest.TFFeature;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.gen.feature.template.TemplateManager;
import twilightforest.structures.TFStructureComponentOld;

public class MazeRoomComponent extends TFStructureComponentOld
{
    public MazeRoomComponent(final TemplateManager manager, final CompoundNBT nbt) {
        this(MinotaurMazePieces.TFMMR, nbt);
    }
    
    public MazeRoomComponent(final IStructurePieceType piece, final CompoundNBT nbt) {
        super(piece, nbt);
    }
    
    public MazeRoomComponent(final IStructurePieceType type, final TFFeature feature, final int i, final Random rand, final int x, final int y, final int z) {
        super(type, feature, i);
        this.func_186164_a(Direction.Plane.HORIZONTAL.func_179518_a(rand));
        this.field_74887_e = new MutableBoundingBox(x, y, z, x + 15, y + 4, z + 15);
    }
    
    public void func_74861_a(final StructurePiece structurecomponent, final List<StructurePiece> list, final Random random) {
    }
    
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random rand, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        this.func_175804_a(world, sbb, 1, 0, 1, 14, 0, 14, ((Block)TFBlocks.maze_stone_border.get()).func_176223_P(), MazeRoomComponent.AIR, true);
        this.func_175804_a(world, sbb, 2, 0, 2, 13, 0, 13, ((Block)TFBlocks.maze_stone_mosaic.get()).func_176223_P(), MazeRoomComponent.AIR, true);
        if (this.func_175807_a((IBlockReader)world, 7, 1, 0, sbb).func_177230_c() == Blocks.field_150350_a) {
            this.func_175804_a(world, sbb, 6, 1, 0, 9, 4, 0, Blocks.field_180407_aO.func_176223_P(), MazeRoomComponent.AIR, false);
            this.func_74878_a(world, sbb, 7, 1, 0, 8, 3, 0);
        }
        if (this.func_175807_a((IBlockReader)world, 7, 1, 15, sbb).func_177230_c() == Blocks.field_150350_a) {
            this.func_175804_a(world, sbb, 6, 1, 15, 9, 4, 15, Blocks.field_180407_aO.func_176223_P(), MazeRoomComponent.AIR, false);
            this.func_74878_a(world, sbb, 7, 1, 15, 8, 3, 15);
        }
        if (this.func_175807_a((IBlockReader)world, 0, 1, 7, sbb).func_177230_c() == Blocks.field_150350_a) {
            this.func_175804_a(world, sbb, 0, 1, 6, 0, 4, 9, Blocks.field_180407_aO.func_176223_P(), MazeRoomComponent.AIR, false);
            this.func_74878_a(world, sbb, 0, 1, 7, 0, 3, 8);
        }
        if (this.func_175807_a((IBlockReader)world, 15, 1, 7, sbb).func_177230_c() == Blocks.field_150350_a) {
            this.func_175804_a(world, sbb, 15, 1, 6, 15, 4, 9, Blocks.field_180407_aO.func_176223_P(), MazeRoomComponent.AIR, false);
            this.func_74878_a(world, sbb, 15, 1, 7, 15, 3, 8);
        }
        return true;
    }
}
