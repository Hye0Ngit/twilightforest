// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.stronghold;

import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockDirectional;
import twilightforest.block.TFBlocks;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.util.EnumFacing;
import twilightforest.TFFeature;

public class StructureTFStrongholdShield extends StructureTFStrongholdComponent
{
    public StructureTFStrongholdShield() {
    }
    
    public StructureTFStrongholdShield(final TFFeature feature, final int minX, final int minY, final int minZ, final int maxX, final int maxY, final int maxZ) {
        super(feature, 0, EnumFacing.SOUTH, minX, minY, minZ);
        this.field_74887_e = new StructureBoundingBox(minX, minY, minZ, maxX, maxY, maxZ);
        this.spawnListIndex = -1;
    }
    
    @Override
    public StructureBoundingBox generateBoundingBox(final EnumFacing facing, final int x, final int y, final int z) {
        return null;
    }
    
    public boolean func_74875_a(final World world, final Random random, final StructureBoundingBox sbb) {
        final IBlockState down = TFBlocks.stronghold_shield.func_176223_P().func_177226_a((IProperty)BlockDirectional.field_176387_N, (Comparable)EnumFacing.DOWN);
        final IBlockState up = TFBlocks.stronghold_shield.func_176223_P().func_177226_a((IProperty)BlockDirectional.field_176387_N, (Comparable)EnumFacing.UP);
        final IBlockState north = TFBlocks.stronghold_shield.func_176223_P().func_177226_a((IProperty)BlockDirectional.field_176387_N, (Comparable)EnumFacing.NORTH);
        final IBlockState south = TFBlocks.stronghold_shield.func_176223_P().func_177226_a((IProperty)BlockDirectional.field_176387_N, (Comparable)EnumFacing.SOUTH);
        final IBlockState west = TFBlocks.stronghold_shield.func_176223_P().func_177226_a((IProperty)BlockDirectional.field_176387_N, (Comparable)EnumFacing.WEST);
        final IBlockState east = TFBlocks.stronghold_shield.func_176223_P().func_177226_a((IProperty)BlockDirectional.field_176387_N, (Comparable)EnumFacing.EAST);
        this.func_175804_a(world, sbb, this.field_74887_e.func_78883_b(), 0, 0, this.field_74887_e.func_78883_b(), this.field_74887_e.func_78882_c(), this.field_74887_e.func_78880_d(), west, west, false);
        this.func_175804_a(world, sbb, 0, 0, 0, 0, this.field_74887_e.func_78882_c(), this.field_74887_e.func_78880_d(), east, east, false);
        this.func_175804_a(world, sbb, 0, 0, this.field_74887_e.func_78880_d(), this.field_74887_e.func_78883_b(), this.field_74887_e.func_78882_c(), this.field_74887_e.func_78880_d(), north, north, false);
        this.func_175804_a(world, sbb, 0, 0, 0, this.field_74887_e.func_78883_b(), this.field_74887_e.func_78882_c(), 0, south, south, false);
        this.func_175804_a(world, sbb, 0, 0, 0, this.field_74887_e.func_78883_b(), 0, this.field_74887_e.func_78880_d(), up, up, false);
        this.func_175804_a(world, sbb, 0, this.field_74887_e.func_78882_c(), 0, this.field_74887_e.func_78883_b(), this.field_74887_e.func_78882_c(), this.field_74887_e.func_78880_d(), down, down, false);
        return true;
    }
}
