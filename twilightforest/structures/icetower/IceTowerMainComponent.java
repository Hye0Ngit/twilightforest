// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.icetower;

import java.util.Iterator;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import java.util.List;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraft.util.Direction;
import java.util.Random;
import twilightforest.TFFeature;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class IceTowerMainComponent extends IceTowerWingComponent
{
    public boolean hasBossWing;
    
    public IceTowerMainComponent(final TemplateManager manager, final CompoundNBT nbt) {
        super(IceTowerPieces.TFITMai, nbt);
        this.hasBossWing = false;
        this.hasBossWing = nbt.func_74767_n("hasBossWing");
    }
    
    public IceTowerMainComponent(final TFFeature feature, final Random rand, final int index, final int x, final int y, final int z) {
        this(feature, rand, index, x + 11, y + 40, z + 11, Direction.NORTH);
    }
    
    public IceTowerMainComponent(final TFFeature feature, final Random rand, final int index, final int x, final int y, final int z, final Direction rotation) {
        super(IceTowerPieces.TFITMai, feature, index, x, y, z, 11, 31 + rand.nextInt(3) * 10, rotation);
        this.hasBossWing = false;
        if (this.deco == null) {
            this.deco = new IceTowerDecorator();
        }
    }
    
    @Override
    protected void func_143011_b(final CompoundNBT tagCompound) {
        super.func_143011_b(tagCompound);
        tagCompound.func_74757_a("hasBossWing", this.hasBossWing);
    }
    
    @Override
    public void func_74861_a(final StructurePiece parent, final List<StructurePiece> list, final Random rand) {
        super.func_74861_a(parent, list, rand);
        final MutableBoundingBox towerBB = MutableBoundingBox.func_78887_a();
        for (final StructurePiece structurecomponent : list) {
            towerBB.func_78888_b(structurecomponent.func_74874_b());
        }
        final BlockPos myDoor = this.openings.get(0);
        BlockPos entranceDoor = new BlockPos((Vector3i)myDoor);
        if (myDoor.func_177958_n() == 0) {
            final int length = this.func_74874_b().field_78897_a - towerBB.field_78897_a;
            if (length >= 0) {
                entranceDoor = entranceDoor.func_177985_f(length);
                this.makeEntranceBridge(list, rand, this.func_74877_c() + 1, myDoor.func_177958_n(), myDoor.func_177956_o(), myDoor.func_177952_p(), length, Rotation.CLOCKWISE_180);
            }
        }
        if (myDoor.func_177958_n() == this.size - 1) {
            entranceDoor = entranceDoor.func_177965_g(towerBB.field_78893_d - this.func_74874_b().field_78893_d);
        }
        if (myDoor.func_177952_p() == 0) {
            entranceDoor = entranceDoor.func_177970_e(towerBB.field_78896_c - this.func_74874_b().field_78896_c);
        }
        if (myDoor.func_177958_n() == this.size - 1) {
            entranceDoor = entranceDoor.func_177970_e(towerBB.field_78892_f - this.func_74874_b().field_78892_f);
        }
        this.makeEntranceTower(list, rand, this.func_74877_c() + 1, entranceDoor.func_177958_n(), entranceDoor.func_177956_o(), entranceDoor.func_177952_p(), 11, 11, this.field_186169_c);
    }
    
    private void makeEntranceBridge(final List<StructurePiece> list, final Random rand, final int index, final int x, final int y, final int z, final int length, final Rotation rotation) {
        final Direction direction = this.getStructureRelativeRotation(rotation);
        final BlockPos dest = this.offsetTowerCCoords(x, y, z, 5, direction);
        final IceTowerBridgeComponent bridge = new IceTowerBridgeComponent(this.getFeatureType(), index, dest.func_177958_n(), dest.func_177956_o(), dest.func_177952_p(), length, direction);
        list.add(bridge);
        bridge.func_74861_a(list.get(0), list, rand);
    }
    
    public boolean makeEntranceTower(final List<StructurePiece> list, final Random rand, final int index, final int x, final int y, final int z, final int wingSize, final int wingHeight, final Rotation rotation) {
        final Direction direction = this.getStructureRelativeRotation(rotation);
        final int[] dx = this.offsetTowerCoords(x, y, z, wingSize, direction);
        final IceTowerWingComponent entrance = new IceTowerEntranceComponent(this.getFeatureType(), index, dx[0], dx[1], dx[2], wingSize, wingHeight, direction);
        list.add(entrance);
        entrance.func_74861_a(list.get(0), list, rand);
        this.addOpening(x, y, z, rotation);
        return true;
    }
}
