// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.finalcastle;

import twilightforest.structures.StructureTFComponentOld;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.util.Rotation;
import twilightforest.block.BlockTFCastleMagic;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.util.EnumFacing;
import java.util.Random;
import twilightforest.TFFeature;

public class ComponentTFFinalCastleEntranceSideTower extends ComponentTFFinalCastleMazeTower13
{
    public ComponentTFFinalCastleEntranceSideTower() {
    }
    
    public ComponentTFFinalCastleEntranceSideTower(final TFFeature feature, final Random rand, final int i, final int x, final int y, final int z, final int floors, final int entranceFloor, final EnumFacing direction) {
        super(feature, rand, i, x, y, z, floors, entranceFloor, BlockTFCastleMagic.VALID_COLORS.get(0), direction);
        this.addOpening(0, 1, this.size / 2, Rotation.CLOCKWISE_180);
    }
    
    @Override
    public void func_74861_a(final StructureComponent parent, final List<StructureComponent> list, final Random rand) {
        if (parent != null && parent instanceof StructureTFComponentOld) {
            this.deco = ((StructureTFComponentOld)parent).deco;
        }
        final ComponentTFFinalCastleFoundation13 foundation = new ComponentTFFinalCastleFoundation13(this.getFeatureType(), rand, 4, this);
        list.add(foundation);
        foundation.func_74861_a(this, list, rand);
        final StructureTFComponentOld roof = new ComponentTFFinalCastleRoof13Peaked(this.getFeatureType(), rand, 4, this);
        list.add(roof);
        roof.func_74861_a((StructureComponent)this, (List)list, rand);
    }
}
