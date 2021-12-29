// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.icetower;

import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Rotation;
import twilightforest.structures.StructureTFComponentOld;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import java.util.Random;
import net.minecraft.util.EnumFacing;
import twilightforest.TFFeature;

public class ComponentTFIceTowerEntrance extends ComponentTFIceTowerWing
{
    public ComponentTFIceTowerEntrance() {
    }
    
    public ComponentTFIceTowerEntrance(final TFFeature feature, final int i, final int x, final int y, final int z, final int pSize, final int pHeight, final EnumFacing direction) {
        super(feature, i, x, y, z, pSize, pHeight, direction);
    }
    
    @Override
    protected boolean shouldHaveBase(final Random rand) {
        return true;
    }
    
    @Override
    public void func_74861_a(final StructureComponent parent, final List<StructureComponent> list, final Random rand) {
        if (parent != null && parent instanceof StructureTFComponentOld) {
            this.deco = ((StructureTFComponentOld)parent).deco;
        }
        this.addOpening(0, 1, this.size / 2, Rotation.CLOCKWISE_180);
        this.addStairs(list, rand, this.func_74877_c() + 1, this.size - 1, 1, this.size / 2, Rotation.NONE);
        this.addStairs(list, rand, this.func_74877_c() + 1, this.size / 2, 1, 0, Rotation.COUNTERCLOCKWISE_90);
        this.addStairs(list, rand, this.func_74877_c() + 1, this.size / 2, 1, this.size - 1, Rotation.CLOCKWISE_90);
        this.hasBase = this.shouldHaveBase(rand);
        this.makeARoof(parent, list, rand);
    }
    
    private boolean addStairs(final List<StructureComponent> list, final Random rand, final int index, final int x, final int y, final int z, final Rotation rotation) {
        this.addOpening(x, y, z, rotation);
        final EnumFacing direction = this.getStructureRelativeRotation(rotation);
        final BlockPos dx = this.offsetTowerCCoords(x, y, z, this.size, direction);
        final ComponentTFIceTowerStairs entrance = new ComponentTFIceTowerStairs(this.getFeatureType(), index, dx.func_177958_n(), dx.func_177956_o(), dx.func_177952_p(), this.size, this.height, direction);
        list.add(entrance);
        entrance.func_74861_a(list.get(0), list, rand);
        return true;
    }
    
    @Override
    public boolean makeTowerWing(final List<StructureComponent> list, final Random rand, final int index, final int x, final int y, final int z, final int wingSize, final int wingHeight, final Rotation rotation) {
        return false;
    }
    
    @Override
    protected void makeFloorsForTower(final World world, final Random rand, final StructureBoundingBox sbb) {
        this.decoratePillarsCornersHigh(world, rand, 0, 11, Rotation.NONE, sbb);
    }
    
    protected void decoratePillarsCornersHigh(final World world, final Random rand, final int bottom, final int top, final Rotation rotation, final StructureBoundingBox sbb) {
        final IBlockState pillarXAxis = this.deco.pillarState.func_177226_a((IProperty)BlockRotatedPillar.field_176298_M, (Comparable)EnumFacing.Axis.X);
        final IBlockState pillarZAxis = this.deco.pillarState.func_177226_a((IProperty)BlockRotatedPillar.field_176298_M, (Comparable)EnumFacing.Axis.Z);
        this.fillBlocksRotated(world, sbb, 3, bottom + 5, 1, 3, bottom + 5, 9, pillarZAxis, rotation);
        this.fillBlocksRotated(world, sbb, 7, bottom + 5, 1, 7, bottom + 5, 9, pillarZAxis, rotation);
        this.fillBlocksRotated(world, sbb, 1, bottom + 5, 3, 9, bottom + 5, 3, pillarXAxis, rotation);
        this.fillBlocksRotated(world, sbb, 1, bottom + 5, 7, 9, bottom + 5, 7, pillarXAxis, rotation);
        this.fillAirRotated(world, sbb, 3, bottom + 5, 3, 7, bottom + 5, 7, rotation);
        this.fillBlocksRotated(world, sbb, 3, bottom + 5, 3, 3, top - 1, 3, this.deco.pillarState, rotation);
        this.fillBlocksRotated(world, sbb, 7, bottom + 5, 3, 7, top - 1, 3, this.deco.pillarState, rotation);
        this.fillBlocksRotated(world, sbb, 3, bottom + 5, 7, 3, top - 1, 7, this.deco.pillarState, rotation);
        this.fillBlocksRotated(world, sbb, 7, bottom + 5, 7, 7, top - 1, 7, this.deco.pillarState, rotation);
    }
}
