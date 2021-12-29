// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.finalcastle;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Rotation;
import twilightforest.structures.StructureTFComponentOld;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import twilightforest.block.BlockTFCastleMagic;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.util.EnumFacing;
import java.util.Random;
import twilightforest.TFFeature;

public class ComponentTFFinalCastleEntranceBottomTower extends ComponentTFFinalCastleMazeTower13
{
    public ComponentTFFinalCastleEntranceBottomTower() {
    }
    
    public ComponentTFFinalCastleEntranceBottomTower(final TFFeature feature, final Random rand, final int i, final int x, final int y, final int z, final int floors, final int entranceFloor, final EnumFacing direction) {
        super(feature, rand, i, x, y, z, floors, entranceFloor, BlockTFCastleMagic.VALID_COLORS.get(0), direction);
    }
    
    @Override
    public void func_74861_a(final StructureComponent parent, final List<StructureComponent> list, final Random rand) {
        if (parent != null && parent instanceof StructureTFComponentOld) {
            this.deco = ((StructureTFComponentOld)parent).deco;
        }
        this.addStairs(list, rand, this.func_74877_c() + 1, this.size - 1, 1, this.size / 2, Rotation.NONE);
        this.addStairs(list, rand, this.func_74877_c() + 1, 0, 1, this.size / 2, Rotation.CLOCKWISE_180);
        this.addStairs(list, rand, this.func_74877_c() + 1, this.size / 2, 1, 0, Rotation.COUNTERCLOCKWISE_90);
        this.addStairs(list, rand, this.func_74877_c() + 1, this.size / 2, 1, this.size - 1, Rotation.CLOCKWISE_90);
    }
    
    private boolean addStairs(final List<StructureComponent> list, final Random rand, final int index, final int x, final int y, final int z, final Rotation rotation) {
        this.addOpening(x, y, z, rotation);
        final EnumFacing direction = this.getStructureRelativeRotation(rotation);
        final BlockPos dx = this.offsetTowerCCoords(x, y, z, 0, direction);
        final ComponentTFFinalCastleEntranceStairs stairs = new ComponentTFFinalCastleEntranceStairs(this.getFeatureType(), index, dx.func_177958_n(), dx.func_177956_o(), dx.func_177952_p(), direction);
        list.add(stairs);
        stairs.func_74861_a(list.get(0), list, rand);
        return true;
    }
    
    @Override
    protected boolean hasAccessibleRoof() {
        return false;
    }
}
