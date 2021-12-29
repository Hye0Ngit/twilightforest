// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.icetower;

import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.World;
import java.util.Random;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import twilightforest.structures.StructureTFComponent;

public class ComponentTFIceTowerBridge extends StructureTFComponent
{
    private int length;
    
    public ComponentTFIceTowerBridge() {
    }
    
    public ComponentTFIceTowerBridge(final int index, final int x, final int y, final int z, final int length, final int direction) {
        super(index);
        this.length = length;
        this.setCoordBaseMode(direction);
        this.field_74887_e = StructureTFComponent.getComponentToAddBoundingBox(x, y, z, 0, 0, 0, length, 6, 5, direction);
    }
    
    public void func_74861_a(final StructureComponent parent, final List list, final Random rand) {
        if (parent != null && parent instanceof StructureTFComponent) {
            this.deco = ((StructureTFComponent)parent).deco;
        }
    }
    
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        this.func_74878_a(world, sbb, 0, 1, 0, this.length, 5, 4);
        this.func_151549_a(world, sbb, 0, 0, 0, this.length, 0, 4, this.deco.blockID, this.deco.blockID, false);
        this.func_151549_a(world, sbb, 0, 6, 0, this.length, 6, 4, this.deco.blockID, this.deco.blockID, false);
        for (int x = 2; x < this.length; x += 3) {
            this.func_151556_a(world, sbb, x, 1, 0, x, 5, 0, this.deco.pillarID, this.deco.pillarMeta, this.deco.pillarID, this.deco.pillarMeta, false);
            this.func_151556_a(world, sbb, x, 1, 4, x, 5, 4, this.deco.pillarID, this.deco.pillarMeta, this.deco.pillarID, this.deco.pillarMeta, false);
        }
        return true;
    }
}
