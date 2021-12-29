// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.hollowtree;

import java.util.Iterator;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import twilightforest.structures.StructureTFComponent;
import net.minecraft.world.gen.structure.StructureComponent;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureStart;

public class StructureTFHollowTreeStart extends StructureStart
{
    public StructureTFHollowTreeStart() {
    }
    
    public StructureTFHollowTreeStart(final World world, final Random rand, final int chunkX, final int chunkZ) {
        final int x = (chunkX << 4) + 8;
        final int z = (chunkZ << 4) + 8;
        final int y = 32;
        final StructureTFComponent trunk = new ComponentTFHollowTreeTrunk(world, rand, 0, x, y, z);
        this.field_75075_a.add(trunk);
        trunk.func_74861_a((StructureComponent)trunk, this.field_75075_a, rand);
        this.func_75072_c();
    }
    
    public void func_75068_a(final World worldIn, final Random rand, final StructureBoundingBox sbb) {
        for (final StructureComponent sc : this.field_75075_a) {
            if (sc.func_74874_b().func_78884_a(sbb) && sc instanceof StructureTFTreeComponent) {
                ((StructureTFTreeComponent)sc).addComponentParts(worldIn, rand, sbb, false);
            }
        }
        for (final StructureComponent sc : this.field_75075_a) {
            if (sc.func_74874_b().func_78884_a(sbb) && sc instanceof StructureTFTreeComponent) {
                ((StructureTFTreeComponent)sc).addComponentParts(worldIn, rand, sbb, true);
            }
        }
    }
}
