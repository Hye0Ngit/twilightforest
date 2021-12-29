// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.lichtower;

import net.minecraft.block.BlockPlanks;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import java.util.Random;
import net.minecraft.world.World;
import twilightforest.TFFeature;

public class ComponentTFTowerRoofAttachedSlab extends ComponentTFTowerRoofSlab
{
    public ComponentTFTowerRoofAttachedSlab() {
    }
    
    public ComponentTFTowerRoofAttachedSlab(final TFFeature feature, final int i, final ComponentTFTowerWing wing) {
        super(feature, i, wing);
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        return this.makeConnectedCap(world, BlockPlanks.EnumType.BIRCH, sbb);
    }
}
