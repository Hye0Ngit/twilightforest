// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.finalcastle;

import java.util.Iterator;
import java.util.ArrayList;
import twilightforest.block.TFBlocks;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import twilightforest.structures.StructureTFComponentOld;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import twilightforest.block.BlockTFCastleMagic;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.util.EnumFacing;
import java.util.Random;
import twilightforest.TFFeature;

public class ComponentTFFinalCastleDamagedTower extends ComponentTFFinalCastleMazeTower13
{
    public ComponentTFFinalCastleDamagedTower() {
    }
    
    public ComponentTFFinalCastleDamagedTower(final TFFeature feature, final Random rand, final int i, final int x, final int y, final int z, final EnumFacing direction) {
        super(feature, rand, i, x, y, z, BlockTFCastleMagic.VALID_COLORS.get(2), direction);
    }
    
    @Override
    public void func_74861_a(final StructureComponent parent, final List<StructureComponent> list, final Random rand) {
        if (parent != null && parent instanceof StructureTFComponentOld) {
            this.deco = ((StructureTFComponentOld)parent).deco;
        }
        final ComponentTFFinalCastleFoundation13 foundation = new ComponentTFFinalCastleFoundation13(this.getFeatureType(), rand, 0, this);
        list.add(foundation);
        foundation.func_74861_a(this, list, rand);
        final ComponentTFFinalCastleFoundation13 thorns = new ComponentTFFinalCastleFoundation13Thorns(this.getFeatureType(), rand, 0, this);
        list.add(thorns);
        thorns.func_74861_a(this, list, rand);
        this.buildNonCriticalTowers(parent, list, rand);
    }
    
    @Override
    protected ComponentTFFinalCastleMazeTower13 makeNewDamagedTower(final Random rand, final EnumFacing facing, final BlockPos tc) {
        return new ComponentTFFinalCastleWreckedTower(this.getFeatureType(), rand, this.func_74877_c() + 1, tc.func_177958_n(), tc.func_177956_o(), tc.func_177952_p(), facing);
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        super.func_74875_a(world, rand, sbb);
        final Random decoRNG = new Random(world.func_72905_C() + this.field_74887_e.field_78897_a * 321534781 ^ (long)(this.field_74887_e.field_78896_c * 756839));
        this.destroyTower(world, decoRNG, sbb);
        return true;
    }
    
    public void destroyTower(final World world, final Random rand, final StructureBoundingBox sbb) {
        final ArrayList<DestroyArea> areas = this.makeInitialDestroyList(rand);
        boolean hitDeadRock = false;
        final BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
        for (int y = this.field_74887_e.field_78894_e; !hitDeadRock && y > 64; --y) {
            for (int x = this.field_74887_e.field_78897_a - 2; x <= this.field_74887_e.field_78893_d + 2; ++x) {
                for (int z = this.field_74887_e.field_78896_c - 2; z <= this.field_74887_e.field_78892_f + 2; ++z) {
                    pos.func_181079_c(x, y, z);
                    if (sbb.func_175898_b((Vec3i)pos)) {
                        if (world.func_180495_p((BlockPos)pos).func_177230_c() == TFBlocks.deadrock) {
                            hitDeadRock = true;
                        }
                        this.determineBlockDestroyed(world, areas, y, x, z);
                    }
                }
            }
            DestroyArea removeArea = null;
            for (final DestroyArea dArea : areas) {
                if (dArea == null || dArea.isEntirelyAbove(y)) {
                    removeArea = dArea;
                }
            }
            if (removeArea != null) {
                areas.remove(removeArea);
                areas.add(DestroyArea.createNonIntersecting(this.func_74874_b(), rand, y, areas));
            }
        }
    }
    
    protected ArrayList<DestroyArea> makeInitialDestroyList(final Random rand) {
        final ArrayList<DestroyArea> areas = new ArrayList<DestroyArea>(2);
        areas.add(DestroyArea.createNonIntersecting(this.func_74874_b(), rand, this.func_74874_b().field_78894_e - 1, areas));
        areas.add(DestroyArea.createNonIntersecting(this.func_74874_b(), rand, this.func_74874_b().field_78894_e - 1, areas));
        areas.add(DestroyArea.createNonIntersecting(this.func_74874_b(), rand, this.func_74874_b().field_78894_e - 1, areas));
        return areas;
    }
    
    protected void determineBlockDestroyed(final World world, final ArrayList<DestroyArea> areas, final int y, final int x, final int z) {
        final BlockPos pos = new BlockPos(x, y, z);
        for (final DestroyArea dArea : areas) {
            if (dArea != null && dArea.isVecInside(pos)) {
                world.func_175698_g(pos);
            }
        }
    }
}
