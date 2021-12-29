// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.finalcastle;

import java.util.Iterator;
import net.minecraft.util.math.BlockPos;
import java.util.ArrayList;
import net.minecraft.world.World;
import twilightforest.block.BlockTFCastleMagic;
import net.minecraft.item.EnumDyeColor;
import twilightforest.structures.StructureTFComponentOld;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.util.EnumFacing;
import java.util.Random;
import twilightforest.TFFeature;

public class ComponentTFFinalCastleWreckedTower extends ComponentTFFinalCastleDamagedTower
{
    public ComponentTFFinalCastleWreckedTower() {
    }
    
    public ComponentTFFinalCastleWreckedTower(final TFFeature feature, final Random rand, final int i, final int x, final int y, final int z, final EnumFacing direction) {
        super(feature, rand, i, x, y, z, direction);
    }
    
    @Override
    public void func_74861_a(final StructureComponent parent, final List<StructureComponent> list, final Random rand) {
        if (parent != null && parent instanceof StructureTFComponentOld) {
            this.deco = ((StructureTFComponentOld)parent).deco;
        }
        final ComponentTFFinalCastleFoundation13 thorns = new ComponentTFFinalCastleFoundation13Thorns(this.getFeatureType(), rand, 0, this);
        list.add(thorns);
        thorns.func_74861_a(this, list, rand);
    }
    
    @Override
    public EnumDyeColor getGlyphColour() {
        return BlockTFCastleMagic.VALID_COLORS.get(1);
    }
    
    @Override
    protected void determineBlockDestroyed(final World world, final ArrayList<DestroyArea> areas, final int y, final int x, final int z) {
        boolean isInside = false;
        final BlockPos pos = new BlockPos(x, y, z);
        for (final DestroyArea dArea : areas) {
            if (dArea != null && dArea.isVecInside(pos)) {
                isInside = true;
            }
        }
        if (!isInside) {
            world.func_175698_g(pos);
        }
    }
    
    @Override
    protected ArrayList<DestroyArea> makeInitialDestroyList(final Random rand) {
        final ArrayList<DestroyArea> areas = new ArrayList<DestroyArea>(2);
        areas.add(DestroyArea.createNonIntersecting(this.func_74874_b(), rand, this.func_74874_b().field_78894_e - 1, areas));
        areas.add(DestroyArea.createNonIntersecting(this.func_74874_b(), rand, this.func_74874_b().field_78894_e - 1, areas));
        areas.add(DestroyArea.createNonIntersecting(this.func_74874_b(), rand, this.func_74874_b().field_78894_e - 1, areas));
        areas.add(DestroyArea.createNonIntersecting(this.func_74874_b(), rand, this.func_74874_b().field_78894_e - 1, areas));
        return areas;
    }
}
