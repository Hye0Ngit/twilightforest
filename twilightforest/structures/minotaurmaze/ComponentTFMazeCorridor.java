// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.minotaurmaze;

import net.minecraft.block.Block;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import twilightforest.structures.StructureTFComponent;

public class ComponentTFMazeCorridor extends StructureTFComponent
{
    public ComponentTFMazeCorridor() {
    }
    
    public ComponentTFMazeCorridor(final int i, final int x, final int y, final int z, final int rotation) {
        super(i);
        this.field_74885_f = rotation;
        this.field_74887_e = new StructureBoundingBox(x, y, z, x + 5, y + 5, z + 5);
    }
    
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        this.func_74872_a(world, sbb, 1, 1, 2, 4, 4, 3, Block.field_72031_aZ.field_71990_ca, 0, 0, 0, false);
        this.func_74878_a(world, sbb, 2, 1, 2, 3, 3, 3);
        return true;
    }
}
