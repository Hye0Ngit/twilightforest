// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.Iterator;
import java.util.List;

public class CommandTFLocate extends x implements z
{
    public String c() {
        return "tflocate";
    }
    
    public void b(final ab var1, final String[] var2) {
        final jc player = c(var1);
        final abn provider = player.q.J();
        System.out.println("Got chunk provider " + provider);
        final int dx = kx.c(player.u);
        final int dy = kx.c(player.v);
        final int dz = kx.c(player.w);
        final List possibleMonsters = provider.a(nh.a, dx, dy, dz);
        if (possibleMonsters != null) {
            for (final aaq entry : possibleMonsters) {
                System.out.println("Finding monster " + entry.b);
            }
        }
        else {
            System.out.println("No monsters!");
        }
    }
}
