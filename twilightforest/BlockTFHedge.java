// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import forge.ITextureProvider;

public class BlockTFHedge extends pb implements ITextureProvider
{
    public int damageDone;
    
    protected BlockTFHedge(final int i) {
        super(i, acn.x);
        this.bN = 6;
        this.damageDone = 3;
        this.c(2.0f);
        this.b(10.0f);
        this.a(pb.g);
    }
    
    public wu c(final xd world, final int x, final int y, final int z) {
        final int meta = world.e(x, y, z);
        switch (meta) {
            case 0: {
                final float f = 0.0625f;
                return wu.b((double)(float)x, (double)y, (double)(float)z, (double)(float)(x + 1), (double)(y + 1 - f), (double)(float)(z + 1));
            }
            default: {
                return wu.b((double)(float)x, (double)y, (double)(float)z, (double)(float)(x + 1), (double)(float)(y + 1), (double)(float)(z + 1));
            }
        }
    }
    
    protected int c(final int meta) {
        return meta;
    }
    
    public int a(final int side, final int meta) {
        switch (meta) {
            case 1: {
                return 10;
            }
            default: {
                return 6;
            }
        }
    }
    
    public void a(final xd world, final int x, final int y, final int z, final nn entity) {
        final int meta = world.e(x, y, z);
        if (meta == 0 && this.shouldDamage(entity)) {
            entity.a(md.h, this.damageDone);
        }
    }
    
    public void b(final xd world, final int x, final int y, final int z, final nn entity) {
        final int meta = world.e(x, y, z);
        if (meta == 0 && this.shouldDamage(entity)) {
            entity.a(md.h, this.damageDone);
        }
    }
    
    public void a(final xd world, final int x, final int y, final int z, final yw entityplayer) {
        final int meta = world.e(x, y, z);
        if (meta == 0 && !world.F) {
            world.a(x, y, z, this.bO, 10);
        }
    }
    
    public void a(final xd world, final yw entityplayer, final int i, final int j, final int k, final int meta) {
        super.a(world, entityplayer, i, j, k, meta);
        if (meta == 0) {
            entityplayer.a(md.h, this.damageDone);
        }
    }
    
    public void a(final xd world, final int x, final int y, final int z, final Random random) {
        final double range = 4.0;
        final List nearbyPlayers = world.a((Class)yw.class, wu.b((double)x, (double)y, (double)z, (double)(x + 1), (double)(y + 1), (double)(z + 1)).b(range, range, range));
        for (final yw player : nearbyPlayers) {
            if (player.ay) {
                final pl mop = this.getPlayerPointVec(world, player, range);
                if (mop == null || world.a(mop.b, mop.c, mop.d) != this.bO) {
                    continue;
                }
                player.a(md.h, this.damageDone);
                world.a(x, y, z, this.bO, 10);
            }
        }
    }
    
    private pl getPlayerPointVec(final xd worldObj, final yw player, final double range) {
        final bo position = bo.b(player.o, player.p + player.I(), player.q);
        final bo look = player.k(1.0f);
        final bo dest = position.c(look.a * range, look.b * range, look.c * range);
        return worldObj.a(position, dest);
    }
    
    private boolean shouldDamage(final nn entity) {
        return !(entity instanceof cb) && !(entity instanceof fq);
    }
    
    public void addCreativeItems(final ArrayList itemList) {
        itemList.add(new aan((pb)this, 1, 0));
        itemList.add(new aan((pb)this, 1, 1));
    }
    
    public String getTextureFile() {
        return "/twilightforest/terrain.png";
    }
}
