import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class StructureTFStrongholdStart extends oa
{
    public StructureTFStrongholdStart(final ry world, final Random random, final int i, final int j) {
        tc.a();
        final aeh css2 = new aeh(0, random, (i << 4) + 2, (j << 4) + 2);
        css2.a().a(0, -28, 0);
        System.out.println("Made a stronghold at " + css2.a().a + ", " + css2.a().b + ", " + css2.a().c);
        this.a.add(css2);
        css2.a((nk)css2, (List)this.a, random);
        final ArrayList arraylist = css2.c;
        while (!arraylist.isEmpty()) {
            final int k = random.nextInt(arraylist.size());
            final nk structurecomponent = arraylist.remove(k);
            structurecomponent.a((nk)css2, (List)this.a, random);
        }
        this.c();
        this.a(world, random, 1);
    }
    
    protected void a(final ry world, final Random random, final int i) {
        world.getClass();
        final int j = 35 - i;
        int k = this.b.c() + 1;
        if (k < j) {
            k += random.nextInt(j - k);
        }
        final int l = k - this.b.e;
        this.b.a(0, l, 0);
        for (final nk structurecomponent : this.a) {
            structurecomponent.a().a(0, l, 0);
        }
    }
}
