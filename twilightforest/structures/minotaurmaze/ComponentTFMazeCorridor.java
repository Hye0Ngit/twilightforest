// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.minotaurmaze;

import net.minecraft.init.Blocks;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.util.EnumFacing;
import twilightforest.TFFeature;
import twilightforest.structures.StructureTFComponentOld;

public class ComponentTFMazeCorridor extends StructureTFComponentOld
{
    public ComponentTFMazeCorridor() {
    }
    
    public ComponentTFMazeCorridor(final TFFeature feature, final int i, final int x, final int y, final int z, final EnumFacing rotation) {
        super(feature, i);
        this.func_186164_a(rotation);
        this.field_74887_e = new StructureBoundingBox(x, y, z, x + 5, y + 5, z + 5);
    }
    
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        this.func_175804_a(world, sbb, 1, 1, 2, 4, 4, 3, Blocks.field_180407_aO.func_176223_P(), ComponentTFMazeCorridor.AIR, false);
        this.func_74878_a(world, sbb, 2, 1, 2, 3, 3, 3);
        return true;
    }
}
