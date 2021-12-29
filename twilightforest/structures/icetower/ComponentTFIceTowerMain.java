// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.icetower;

import java.util.Random;
import net.minecraft.world.World;

public class ComponentTFIceTowerMain extends ComponentTFIceTowerWing
{
    public ComponentTFIceTowerMain() {
    }
    
    public ComponentTFIceTowerMain(final World world, final Random rand, final int index, final int x, final int y, final int z) {
        this(world, rand, index, x + 11, y + 40, z + 11, 2);
    }
    
    public ComponentTFIceTowerMain(final World world, final Random rand, final int index, final int x, final int y, final int z, final int rotation) {
        super(index, x, y, z, 11, 31 + rand.nextInt(3) * 10, rotation);
        if (this.deco == null) {
            this.deco = new StructureDecoratorIceTower();
        }
    }
    
    protected ComponentTFIceTowerMain(final int i, final int x, final int y, final int z, final int pSize, final int pHeight, final int direction) {
        super(i, x, y, z, pSize, pHeight, direction);
    }
}
