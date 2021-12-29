// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.stronghold;

import net.minecraft.state.Property;
import net.minecraft.block.DirectionalBlock;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import java.util.Random;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.ISeedReader;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.Direction;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class StrongholdShieldStructure extends StructureTFStrongholdComponent
{
    public StrongholdShieldStructure(final TemplateManager manager, final CompoundNBT nbt) {
        super(StrongholdPieces.TFSShield, nbt);
        this.spawnListIndex = -1;
    }
    
    @Override
    public MutableBoundingBox generateBoundingBox(final Direction facing, final int x, final int y, final int z) {
        return null;
    }
    
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random randomIn, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        final BlockState down = (BlockState)((Block)TFBlocks.stronghold_shield.get()).func_176223_P().func_206870_a((Property)DirectionalBlock.field_176387_N, (Comparable)Direction.DOWN);
        final BlockState up = (BlockState)((Block)TFBlocks.stronghold_shield.get()).func_176223_P().func_206870_a((Property)DirectionalBlock.field_176387_N, (Comparable)Direction.UP);
        final BlockState north = (BlockState)((Block)TFBlocks.stronghold_shield.get()).func_176223_P().func_206870_a((Property)DirectionalBlock.field_176387_N, (Comparable)Direction.NORTH);
        final BlockState south = (BlockState)((Block)TFBlocks.stronghold_shield.get()).func_176223_P().func_206870_a((Property)DirectionalBlock.field_176387_N, (Comparable)Direction.SOUTH);
        final BlockState west = (BlockState)((Block)TFBlocks.stronghold_shield.get()).func_176223_P().func_206870_a((Property)DirectionalBlock.field_176387_N, (Comparable)Direction.WEST);
        final BlockState east = (BlockState)((Block)TFBlocks.stronghold_shield.get()).func_176223_P().func_206870_a((Property)DirectionalBlock.field_176387_N, (Comparable)Direction.EAST);
        this.func_175804_a(world, sbb, this.field_74887_e.func_78883_b(), 0, 0, this.field_74887_e.func_78883_b(), this.field_74887_e.func_78882_c(), this.field_74887_e.func_78880_d(), west, west, false);
        this.func_175804_a(world, sbb, 0, 0, 0, 0, this.field_74887_e.func_78882_c(), this.field_74887_e.func_78880_d(), east, east, false);
        this.func_175804_a(world, sbb, 0, 0, this.field_74887_e.func_78880_d(), this.field_74887_e.func_78883_b(), this.field_74887_e.func_78882_c(), this.field_74887_e.func_78880_d(), north, north, false);
        this.func_175804_a(world, sbb, 0, 0, 0, this.field_74887_e.func_78883_b(), this.field_74887_e.func_78882_c(), 0, south, south, false);
        this.func_175804_a(world, sbb, 0, 0, 0, this.field_74887_e.func_78883_b(), 0, this.field_74887_e.func_78880_d(), up, up, false);
        this.func_175804_a(world, sbb, 0, this.field_74887_e.func_78882_c(), 0, this.field_74887_e.func_78883_b(), this.field_74887_e.func_78882_c(), this.field_74887_e.func_78880_d(), down, down, false);
        return true;
    }
}
