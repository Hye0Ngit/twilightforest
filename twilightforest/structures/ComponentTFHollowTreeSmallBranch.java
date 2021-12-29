// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import java.util.Random;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;

public class ComponentTFHollowTreeSmallBranch extends ComponentTFHollowTreeMedBranch
{
    protected ComponentTFHollowTreeSmallBranch(final int i, final int sx, final int sy, final int sz, final double length, final double angle, final double tilt, final boolean leafy) {
        super(i, sx, sy, sz, length, angle, tilt, leafy);
    }
    
    @Override
    public void func_74861_a(final StructureComponent structurecomponent, final List list, final Random rand) {
        final int index = this.func_74877_c();
        if (this.leafy) {
            final int leafRad = rand.nextInt(2) + 1;
            final ComponentTFLeafSphere leafBlob = new ComponentTFLeafSphere(index + 1, this.dest[0], this.dest[1], this.dest[2], leafRad);
            list.add(leafBlob);
            leafBlob.func_74861_a((StructureComponent)this, list, rand);
        }
    }
}
