// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.ComponentStrongholdStairs2;
import net.minecraft.world.gen.structure.StructureStrongholdPieces;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureStart;

public class StructureTFStrongholdStart extends StructureStart
{
    public StructureTFStrongholdStart(final World world, final Random random, final int i, final int j) {
        StructureStrongholdPieces.func_75198_a();
        final ComponentStrongholdStairs2 css2 = new ComponentStrongholdStairs2(0, random, (i << 4) + 2, (j << 4) + 2);
        css2.func_74874_b().func_78886_a(0, -28, 0);
        System.out.println("Made a stronghold at " + css2.func_74874_b().field_78897_a + ", " + css2.func_74874_b().field_78895_b + ", " + css2.func_74874_b().field_78896_c);
        this.field_75075_a.add(css2);
        css2.func_74861_a((StructureComponent)css2, (List)this.field_75075_a, random);
        final ArrayList arraylist = css2.field_75026_c;
        while (!arraylist.isEmpty()) {
            final int k = random.nextInt(arraylist.size());
            final StructureComponent structurecomponent = arraylist.remove(k);
            structurecomponent.func_74861_a((StructureComponent)css2, (List)this.field_75075_a, random);
        }
        this.func_75072_c();
        this.func_75067_a(world, random, 1);
    }
    
    protected void func_75067_a(final World world, final Random random, final int i) {
        final int j = 35 - i;
        int k = this.field_75074_b.func_78882_c() + 1;
        if (k < j) {
            k += random.nextInt(j - k);
        }
        final int l = k - this.field_75074_b.field_78894_e;
        this.field_75074_b.func_78886_a(0, l, 0);
        for (final StructureComponent structurecomponent : this.field_75075_a) {
            structurecomponent.func_74874_b().func_78886_a(0, l, 0);
        }
    }
}
