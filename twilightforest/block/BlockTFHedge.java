// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraftforge.common.ForgeDirection;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import twilightforest.item.TFItems;

public class BlockTFHedge extends aou
{
    public int damageDone;
    public static lx sprHedge;
    public static lx sprDarkwoodLeaves;
    
    protected BlockTFHedge(final int i) {
        super(i, ahz.y);
        this.damageDone = 3;
        this.c(2.0f);
        this.b(10.0f);
        this.a(aou.i);
        this.a((uy)TFItems.creativeTab);
    }
    
    public aqr b(final zv world, final int x, final int y, final int z) {
        final int meta = world.h(x, y, z);
        switch (meta) {
            case 0: {
                final float f = 0.0625f;
                return aqr.a().a((double)x, (double)y, (double)z, (double)(x + 1), (double)(y + 1 - f), (double)(z + 1));
            }
            default: {
                return aqr.a().a((double)x, (double)y, (double)z, (double)(x + 1), (double)(y + 1), (double)(z + 1));
            }
        }
    }
    
    public int a(int meta) {
        if (meta == 2) {
            meta = 0;
        }
        if (meta == 1) {
            return 3;
        }
        return meta;
    }
    
    public lx a(final int side, final int meta) {
        switch (meta) {
            case 1: {
                return BlockTFHedge.sprDarkwoodLeaves;
            }
            default: {
                return BlockTFHedge.sprHedge;
            }
        }
    }
    
    public void a(final zv world, final int x, final int y, final int z, final mp entity) {
        int meta = world.h(x, y, z);
        if (meta == 2) {
            meta = 0;
        }
        if (meta == 0 && this.shouldDamage(entity)) {
            entity.a(mg.g, this.damageDone);
        }
    }
    
    public void b(final zv world, final int x, final int y, final int z, final mp entity) {
        int meta = world.h(x, y, z);
        if (meta == 2) {
            meta = 0;
        }
        if (meta == 0 && this.shouldDamage(entity)) {
            entity.a(mg.g, this.damageDone);
        }
    }
    
    public void a(final zv world, final int x, final int y, final int z, final sk entityplayer) {
        int meta = world.h(x, y, z);
        if (meta == 2) {
            meta = 0;
        }
        if (meta == 0 && !world.I) {
            world.a(x, y, z, this.cz, 10);
        }
    }
    
    public void a(final zv world, final sk entityplayer, final int i, final int j, final int k, int meta) {
        super.a(world, entityplayer, i, j, k, meta);
        if (meta == 2) {
            meta = 0;
        }
        if (meta == 0) {
            entityplayer.a(mg.g, this.damageDone);
        }
    }
    
    public void a(final zv world, final int x, final int y, final int z, final Random random) {
        final double range = 4.0;
        final List nearbyPlayers = world.a((Class)sk.class, aqr.a().a((double)x, (double)y, (double)z, (double)(x + 1), (double)(y + 1), (double)(z + 1)).b(range, range, range));
        for (final sk player : nearbyPlayers) {
            if (player.br) {
                final aqu mop = this.getPlayerPointVec(world, player, range);
                if (mop == null || world.a(mop.b, mop.c, mop.d) != this.cz) {
                    continue;
                }
                player.a(mg.g, this.damageDone);
                world.a(x, y, z, this.cz, 10);
            }
        }
    }
    
    private aqu getPlayerPointVec(final zv worldObj, final sk player, final double range) {
        final aqw position = worldObj.T().a(player.u, player.v + player.e(), player.w);
        final aqw look = player.i(1.0f);
        final aqw dest = position.c(look.c * range, look.d * range, look.e * range);
        return worldObj.a(position, dest);
    }
    
    private boolean shouldDamage(final mp entity) {
        return !(entity instanceof sb) && !(entity instanceof rb) && !entity.at();
    }
    
    public int getFlammability(final aae world, final int x, final int y, final int z, final int metadata, final ForgeDirection face) {
        return (metadata == 1) ? 1 : 0;
    }
    
    public int getFireSpreadSpeed(final zv world, final int x, final int y, final int z, final int metadata, final ForgeDirection face) {
        return 0;
    }
    
    public void a(final int par1, final uy par2CreativeTabs, final List par3List) {
        par3List.add(new wg(par1, 1, 0));
        par3List.add(new wg(par1, 1, 1));
    }
    
    public int a(final Random par1Random) {
        return (par1Random.nextInt(40) == 0) ? 1 : 0;
    }
    
    public int a(final int meta, final Random par2Random, final int par3) {
        if (meta == 1) {
            return TFBlocks.sapling.cz;
        }
        return -1;
    }
    
    public wg getPickBlock(final aqu target, final zv world, final int x, final int y, final int z) {
        return new wg(this.cz, 1, world.h(x, y, z));
    }
    
    public void a(final zv par1World, final int par2, final int par3, final int par4, final int meta, final float par6, final int fortune) {
        if (!par1World.I && meta == 1 && par1World.s.nextInt(40) == 0) {
            final int var9 = this.a(meta, par1World.s, fortune);
            this.b(par1World, par2, par3, par4, new wg(var9, 1, this.a(meta)));
        }
    }
    
    @SideOnly(Side.CLIENT)
    public void a(final ly par1IconRegister) {
        BlockTFHedge.sprHedge = par1IconRegister.a("twilightforest:hedge");
        BlockTFHedge.sprDarkwoodLeaves = par1IconRegister.a("twilightforest:darkwood_leaves");
    }
}
