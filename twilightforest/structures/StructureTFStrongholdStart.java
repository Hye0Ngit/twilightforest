// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StructureTFStrongholdStart extends afb
{
    public StructureTFStrongholdStart(final yc world, final Random random, final int i, final int j) {
        aea.a();
        final aeq css2 = new aeq(0, random, (i << 4) + 2, (j << 4) + 2);
        css2.b().a(0, -28, 0);
        System.out.println("Made a stronghold at " + css2.b().a + ", " + css2.b().b + ", " + css2.b().c);
        this.a.add(css2);
        css2.a((aez)css2, (List)this.a, random);
        final ArrayList arraylist = css2.c;
        while (!arraylist.isEmpty()) {
            final int k = random.nextInt(arraylist.size());
            final aez structurecomponent = arraylist.remove(k);
            structurecomponent.a((aez)css2, (List)this.a, random);
        }
        this.c();
        this.a(world, random, 1);
    }
    
    protected void a(final yc world, final Random random, final int i) {
        final int j = 35 - i;
        int k = this.b.c() + 1;
        if (k < j) {
            k += random.nextInt(j - k);
        }
        final int l = k - this.b.e;
        this.b.a(0, l, 0);
        for (final aez structurecomponent : this.a) {
            structurecomponent.b().a(0, l, 0);
        }
    }
}
