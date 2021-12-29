// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.icetower;

import net.minecraft.state.Property;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Rotation;
import twilightforest.structures.TFStructureComponentOld;
import java.util.List;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import java.util.Random;
import net.minecraft.util.Direction;
import twilightforest.TFFeature;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class IceTowerEntranceComponent extends IceTowerWingComponent
{
    public IceTowerEntranceComponent(final TemplateManager manager, final CompoundNBT nbt) {
        super(IceTowerPieces.TFITEnt, nbt);
    }
    
    public IceTowerEntranceComponent(final TFFeature feature, final int i, final int x, final int y, final int z, final int pSize, final int pHeight, final Direction direction) {
        super(IceTowerPieces.TFITEnt, feature, i, x, y, z, pSize, pHeight, direction);
    }
    
    @Override
    protected boolean shouldHaveBase(final Random rand) {
        return true;
    }
    
    @Override
    public void func_74861_a(final StructurePiece parent, final List<StructurePiece> list, final Random rand) {
        if (parent != null && parent instanceof TFStructureComponentOld) {
            this.deco = ((TFStructureComponentOld)parent).deco;
        }
        this.addOpening(0, 1, this.size / 2, Rotation.CLOCKWISE_180);
        this.addStairs(list, rand, this.func_74877_c() + 1, this.size - 1, 1, this.size / 2, Rotation.NONE);
        this.addStairs(list, rand, this.func_74877_c() + 1, this.size / 2, 1, 0, Rotation.COUNTERCLOCKWISE_90);
        this.addStairs(list, rand, this.func_74877_c() + 1, this.size / 2, 1, this.size - 1, Rotation.CLOCKWISE_90);
        this.hasBase = this.shouldHaveBase(rand);
        this.makeARoof(parent, list, rand);
    }
    
    private boolean addStairs(final List<StructurePiece> list, final Random rand, final int index, final int x, final int y, final int z, final Rotation rotation) {
        this.addOpening(x, y, z, rotation);
        final Direction direction = this.getStructureRelativeRotation(rotation);
        final BlockPos dx = this.offsetTowerCCoords(x, y, z, this.size, direction);
        final IceTowerStairsComponent entrance = new IceTowerStairsComponent(this.getFeatureType(), index, dx.func_177958_n(), dx.func_177956_o(), dx.func_177952_p(), this.size, this.height, direction);
        list.add(entrance);
        entrance.func_74861_a(list.get(0), list, rand);
        return true;
    }
    
    @Override
    public boolean makeTowerWing(final List<StructurePiece> list, final Random rand, final int index, final int x, final int y, final int z, final int wingSize, final int wingHeight, final Rotation rotation) {
        return false;
    }
    
    @Override
    protected void makeFloorsForTower(final ISeedReader world, final Random rand, final MutableBoundingBox sbb) {
        this.decoratePillarsCornersHigh(world, 0, 11, Rotation.NONE, sbb);
    }
    
    protected void decoratePillarsCornersHigh(final ISeedReader world, final int bottom, final int top, final Rotation rotation, final MutableBoundingBox sbb) {
        final BlockState pillarXAxis = (BlockState)this.deco.pillarState.func_206870_a((Property)RotatedPillarBlock.field_176298_M, (Comparable)Direction.Axis.X);
        final BlockState pillarZAxis = (BlockState)this.deco.pillarState.func_206870_a((Property)RotatedPillarBlock.field_176298_M, (Comparable)Direction.Axis.Z);
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
