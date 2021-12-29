// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import net.minecraft.world.gen.structure.StructureBoundingBox;
import java.util.Random;
import net.minecraft.world.World;

public class ComponentTFTowerRoofAttachedSlab extends ComponentTFTowerRoofSlab
{
    public ComponentTFTowerRoofAttachedSlab(final int i, final ComponentTFTowerWing wing) {
        super(i, wing);
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        final int slabMeta = 2;
        return this.makeConnectedCap(world, slabMeta, sbb);
    }
}
