// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraftforge.common.ForgeDirection;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import twilightforest.item.TFItems;

public class BlockTFHedge extends amq
{
    public int damageDone;
    
    protected BlockTFHedge(final int i) {
        super(i, agi.y);
        this.cl = 6;
        this.damageDone = 3;
        this.c(2.0f);
        this.b(10.0f);
        this.a(amq.g);
        this.a((tj)TFItems.creativeTab);
    }
    
    public aoe e(final yc world, final int x, final int y, final int z) {
        final int meta = world.h(x, y, z);
        switch (meta) {
            case 0: {
                final float f = 0.0625f;
                return aoe.a().a((double)x, (double)y, (double)z, (double)(x + 1), (double)(y + 1 - f), (double)(z + 1));
            }
            default: {
                return aoe.a().a((double)x, (double)y, (double)z, (double)(x + 1), (double)(y + 1), (double)(z + 1));
            }
        }
    }
    
    public int b(int meta) {
        if (meta == 2) {
            meta = 0;
        }
        if (meta == 1) {
            return 3;
        }
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
    
    public void a(final yc world, final int x, final int y, final int z, final lq entity) {
        int meta = world.h(x, y, z);
        if (meta == 2) {
            meta = 0;
        }
        if (meta == 0 && this.shouldDamage(entity)) {
            entity.a(lh.g, this.damageDone);
        }
    }
    
    public void b(final yc world, final int x, final int y, final int z, final lq entity) {
        int meta = world.h(x, y, z);
        if (meta == 2) {
            meta = 0;
        }
        if (meta == 0 && this.shouldDamage(entity)) {
            entity.a(lh.g, this.damageDone);
        }
    }
    
    public void a(final yc world, final int x, final int y, final int z, final qx entityplayer) {
        int meta = world.h(x, y, z);
        if (meta == 2) {
            meta = 0;
        }
        if (meta == 0 && !world.I) {
            world.a(x, y, z, this.cm, 10);
        }
    }
    
    public void a(final yc world, final qx entityplayer, final int i, final int j, final int k, int meta) {
        super.a(world, entityplayer, i, j, k, meta);
        if (meta == 2) {
            meta = 0;
        }
        if (meta == 0) {
            entityplayer.a(lh.g, this.damageDone);
        }
    }
    
    public void b(final yc world, final int x, final int y, final int z, final Random random) {
        final double range = 4.0;
        final List nearbyPlayers = world.a((Class)qx.class, aoe.a().a((double)x, (double)y, (double)z, (double)(x + 1), (double)(y + 1), (double)(z + 1)).b(range, range, range));
        for (final qx player : nearbyPlayers) {
            if (player.bq) {
                final aoh mop = this.getPlayerPointVec(world, player, range);
                if (mop == null || world.a(mop.b, mop.c, mop.d) != this.cm) {
                    continue;
                }
                player.a(lh.g, this.damageDone);
                world.a(x, y, z, this.cm, 10);
            }
        }
    }
    
    private aoh getPlayerPointVec(final yc worldObj, final qx player, final double range) {
        final aoj position = worldObj.S().a(player.t, player.u + player.e(), player.v);
        final aoj look = player.i(1.0f);
        final aoj dest = position.c(look.c * range, look.d * range, look.e * range);
        return worldObj.a(position, dest);
    }
    
    private boolean shouldDamage(final lq entity) {
        return !(entity instanceof qp) && !(entity instanceof px) && !entity.au();
    }
    
    public int getFlammability(final ym world, final int x, final int y, final int z, final int metadata, final ForgeDirection face) {
        return (metadata == 1) ? 1 : 0;
    }
    
    public int getFireSpreadSpeed(final yc world, final int x, final int y, final int z, final int metadata, final ForgeDirection face) {
        return 0;
    }
    
    public void a(final int par1, final tj par2CreativeTabs, final List par3List) {
        par3List.add(new ur(par1, 1, 0));
        par3List.add(new ur(par1, 1, 1));
    }
    
    public int a(final Random par1Random) {
        return (par1Random.nextInt(40) == 0) ? 1 : 0;
    }
    
    public int a(final int meta, final Random par2Random, final int par3) {
        if (meta == 1) {
            return TFBlocks.sapling.cm;
        }
        return -1;
    }
    
    public void a(final yc par1World, final int par2, final int par3, final int par4, final int meta, final float par6, final int fortune) {
        if (!par1World.I && meta == 1 && par1World.t.nextInt(40) == 0) {
            final int var9 = this.a(meta, par1World.t, fortune);
            this.b(par1World, par2, par3, par4, new ur(var9, 1, this.b(meta)));
        }
    }
    
    public String getTextureFile() {
        return "/twilightforest/terrain.png";
    }
}
