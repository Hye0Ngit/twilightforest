// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.minotaurmaze;

import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import java.util.Random;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.ISeedReader;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.Direction;
import twilightforest.TFFeature;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.gen.feature.template.TemplateManager;
import twilightforest.structures.TFStructureComponentOld;

public class MazeCorridorComponent extends TFStructureComponentOld
{
    public MazeCorridorComponent(final TemplateManager manager, final CompoundNBT nbt) {
        this(MinotaurMazePieces.TFMMC, nbt);
    }
    
    public MazeCorridorComponent(final IStructurePieceType piece, final CompoundNBT nbt) {
        super(piece, nbt);
    }
    
    public MazeCorridorComponent(final IStructurePieceType type, final TFFeature feature, final int i, final int x, final int y, final int z, final Direction rotation) {
        super(type, feature, i);
        this.func_186164_a(rotation);
        this.field_74887_e = new MutableBoundingBox(x, y, z, x + 5, y + 5, z + 5);
    }
    
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random rand, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        this.func_175804_a(world, sbb, 1, 1, 2, 4, 4, 3, Blocks.field_180407_aO.func_176223_P(), MazeCorridorComponent.AIR, false);
        this.func_74878_a(world, sbb, 2, 1, 2, 3, 3, 3);
        return true;
    }
}
