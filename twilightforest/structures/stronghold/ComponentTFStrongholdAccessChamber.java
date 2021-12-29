// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.stronghold;

import net.minecraft.block.state.IBlockState;
import twilightforest.block.BlockTFTrophyPedestal;
import twilightforest.block.TFBlocks;
import twilightforest.structures.StructureTFComponentOld;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockStoneBrick;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.util.Rotation;
import java.util.Random;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.util.EnumFacing;
import twilightforest.TFFeature;

public class ComponentTFStrongholdAccessChamber extends StructureTFStrongholdComponent
{
    public ComponentTFStrongholdAccessChamber() {
    }
    
    public ComponentTFStrongholdAccessChamber(final TFFeature feature, final int i, final EnumFacing facing, final int x, final int y, final int z) {
        super(feature, i, facing, x, y, z);
    }
    
    @Override
    public StructureBoundingBox generateBoundingBox(final EnumFacing facing, final int x, final int y, final int z) {
        return StructureBoundingBox.func_175897_a(x, y, z, -4, 1, 0, 9, 5, 9, facing);
    }
    
    @Override
    public void func_74861_a(final StructureComponent parent, final List<StructureComponent> list, final Random random) {
        super.func_74861_a(parent, list, random);
        this.addNewUpperComponent(parent, list, random, Rotation.NONE, 4, 1, 9);
        this.addNewUpperComponent(parent, list, random, Rotation.CLOCKWISE_90, -1, 1, 4);
        this.addNewUpperComponent(parent, list, random, Rotation.CLOCKWISE_180, 4, 1, -1);
        this.addNewUpperComponent(parent, list, random, Rotation.COUNTERCLOCKWISE_90, 9, 1, 4);
    }
    
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        this.func_74882_a(world, sbb, 0, 0, 0, 8, 4, 8, true, rand, this.deco.randomBlocks);
        this.placeSmallDoorwayAt(world, rand, 0, 4, 1, 8, sbb);
        this.placeSmallDoorwayAt(world, rand, 1, 0, 1, 4, sbb);
        this.placeSmallDoorwayAt(world, rand, 2, 4, 1, 0, sbb);
        this.placeSmallDoorwayAt(world, rand, 3, 8, 1, 4, sbb);
        final IBlockState defaultState = Blocks.field_150417_aV.func_176223_P().func_177226_a((IProperty)BlockStoneBrick.field_176249_a, (Comparable)BlockStoneBrick.EnumType.MOSSY);
        this.func_175804_a(world, sbb, 2, -2, 2, 6, 0, 6, defaultState, ComponentTFStrongholdAccessChamber.AIR, false);
        this.func_74878_a(world, sbb, 3, -2, 3, 5, 2, 5);
        this.func_175804_a(world, sbb, 2, 0, 3, 2, 0, 6, StructureTFComponentOld.getStairState(this.deco.stairState, Rotation.CLOCKWISE_180.func_185831_a(EnumFacing.WEST), this.field_186169_c, false), ComponentTFStrongholdAccessChamber.AIR, false);
        this.func_175804_a(world, sbb, 6, 0, 2, 6, 0, 6, StructureTFComponentOld.getStairState(this.deco.stairState, Rotation.NONE.func_185831_a(EnumFacing.WEST), this.field_186169_c, false), ComponentTFStrongholdAccessChamber.AIR, false);
        this.func_175804_a(world, sbb, 3, 0, 2, 5, 0, 2, StructureTFComponentOld.getStairState(this.deco.stairState, Rotation.COUNTERCLOCKWISE_90.func_185831_a(EnumFacing.WEST), this.field_186169_c, false), ComponentTFStrongholdAccessChamber.AIR, false);
        this.func_175804_a(world, sbb, 3, 0, 6, 5, 0, 6, StructureTFComponentOld.getStairState(this.deco.stairState, Rotation.CLOCKWISE_90.func_185831_a(EnumFacing.WEST), this.field_186169_c, false), ComponentTFStrongholdAccessChamber.AIR, false);
        this.func_175811_a(world, this.deco.pillarState, 2, 0, 2, sbb);
        final IBlockState blockstateIn = TFBlocks.trophy_pedestal.func_176223_P().func_177226_a((IProperty)BlockTFTrophyPedestal.LATENT, (Comparable)true).func_177226_a((IProperty)BlockTFTrophyPedestal.FACING, (Comparable)EnumFacing.EAST);
        this.func_175811_a(world, blockstateIn, 2, 1, 2, sbb);
        this.func_175804_a(world, sbb, 2, -1, 2, 6, -1, 6, TFBlocks.stronghold_shield.func_176223_P(), ComponentTFStrongholdAccessChamber.AIR, false);
        return true;
    }
    
    @Override
    public boolean isComponentProtected() {
        return false;
    }
}
