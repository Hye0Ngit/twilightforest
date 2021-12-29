import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import forge.ITextureProvider;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class BlockTFHedge extends vz implements ITextureProvider
{
    public int damageDone;
    
    protected BlockTFHedge(final int i) {
        super(i, na.x);
        this.bN = 6;
        this.damageDone = 3;
    }
    
    public fp e(final ge world, final int i, final int j, final int k) {
        final float f = 0.0625f;
        return fp.b((double)(float)i, (double)j, (double)(float)k, (double)(float)(i + 1), (double)(j + 1 - f), (double)(float)(k + 1));
    }
    
    public void a(final ge world, final int i, final int j, final int k, final tv entity) {
        if (this.shouldDamage(entity)) {
            entity.a(rq.h, this.damageDone);
        }
    }
    
    public void b(final ge world, final int i, final int j, final int k, final tv entity) {
        if (this.shouldDamage(entity)) {
            entity.a(rq.h, this.damageDone);
        }
    }
    
    public void b(final ge world, final int i, final int j, final int k, final ih entityplayer) {
        if (!world.F) {
            world.c(i, j, k, this.bO, 10);
        }
    }
    
    public void a(final ge world, final ih entityplayer, final int i, final int j, final int k, final int l) {
        super.a(world, entityplayer, i, j, k, l);
        entityplayer.a(rq.h, this.damageDone);
    }
    
    public void a(final ge world, final int x, final int y, final int z, final Random random) {
        final double range = 4.0;
        final List nearbyPlayers = world.a((Class)ih.class, fp.b((double)x, (double)y, (double)z, (double)(x + 1), (double)(y + 1), (double)(z + 1)).b(range, range, range));
        for (final ih player : nearbyPlayers) {
            if (player.t) {
                final wu mop = this.getPlayerPointVec(world, player, range);
                if (mop == null || world.a(mop.b, mop.c, mop.d) != this.bO) {
                    continue;
                }
                player.a(rq.h, this.damageDone);
                world.c(x, y, z, this.bO, 10);
            }
        }
    }
    
    private wu getPlayerPointVec(final ge worldObj, final ih player, final double range) {
        final cj position = cj.b(player.bm, player.bn + player.B(), player.bo);
        final cj look = player.f(1.0f);
        final cj dest = position.c(look.a * range, look.b * range, look.c * range);
        return worldObj.a(position, dest);
    }
    
    private boolean shouldDamage(final tv entity) {
        return !(entity instanceof dg) && !(entity instanceof ja);
    }
    
    public void addCreativeItems(final ArrayList itemList) {
        itemList.add(new kp((vz)this));
    }
    
    public String getTextureFile() {
        return "/twilightforest/terrain.png";
    }
}
