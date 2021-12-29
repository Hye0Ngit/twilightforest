// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StructureTFStrongholdStart extends pg
{
    public StructureTFStrongholdStart(final xd world, final Random random, final int i, final int j) {
        abb.a();
        final s css2 = new s(0, random, (i << 4) + 2, (j << 4) + 2);
        css2.b().a(0, -28, 0);
        System.out.println("Made a stronghold at " + css2.b().a + ", " + css2.b().b + ", " + css2.b().c);
        this.a.add(css2);
        css2.a((he)css2, (List)this.a, random);
        final ArrayList arraylist = css2.c;
        while (!arraylist.isEmpty()) {
            final int k = random.nextInt(arraylist.size());
            final he structurecomponent = arraylist.remove(k);
            structurecomponent.a((he)css2, (List)this.a, random);
        }
        this.c();
        this.a(world, random, 1);
    }
    
    protected void a(final xd world, final Random random, final int i) {
        world.getClass();
        final int j = 35 - i;
        int k = this.b.c() + 1;
        if (k < j) {
            k += random.nextInt(j - k);
        }
        final int l = k - this.b.e;
        this.b.a(0, l, 0);
        for (final he structurecomponent : this.a) {
            structurecomponent.b().a(0, l, 0);
        }
    }
}
