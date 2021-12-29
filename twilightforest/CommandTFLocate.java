// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.Iterator;
import java.util.List;

public class CommandTFLocate extends z implements ab
{
    public String c() {
        return "tflocate";
    }
    
    public void b(final ad var1, final String[] var2) {
        final ju player = b(var1);
        final adn provider = player.q.L();
        System.out.println("Got chunk provider " + provider);
        final int dx = lr.c(player.u);
        final int dy = lr.c(player.v);
        final int dz = lr.c(player.w);
        final List<acq> possibleMonsters = provider.a(og.a, dx, dy, dz);
        if (possibleMonsters != null) {
            for (final acq entry : possibleMonsters) {
                System.out.println("Finding monster " + entry.b);
            }
        }
        else {
            System.out.println("No monsters!");
        }
    }
    
    public String c(final ad icommandsender) {
        return null;
    }
}
