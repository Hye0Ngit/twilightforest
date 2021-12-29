// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraftforge.common.ForgeDirection;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import twilightforest.item.TFItems;

public class BlockTFHedge extends are
{
    public int damageDone;
    public static mr sprHedge;
    public static mr sprDarkwoodLeaves;
    
    protected BlockTFHedge(final int i) {
        super(i, ajz.z, false);
        this.damageDone = 3;
        this.c(2.0f);
        this.b(10.0f);
        this.a(aqw.j);
        this.a((wv)TFItems.creativeTab);
    }
    
    public asu b(final abv world, final int x, final int y, final int z) {
        final int meta = world.h(x, y, z);
        switch (meta) {
            case 0: {
                final float f = 0.0625f;
                return asu.a().a((double)x, (double)y, (double)z, (double)(x + 1), (double)(y + 1 - f), (double)(z + 1));
            }
            default: {
                return asu.a().a((double)x, (double)y, (double)z, (double)(x + 1), (double)(y + 1), (double)(z + 1));
            }
        }
    }
    
    public boolean c() {
        return true;
    }
    
    @SideOnly(Side.CLIENT)
    public boolean a(final ace par1IBlockAccess, final int par2, final int par3, final int par4, final int par5) {
        final int i1 = par1IBlockAccess.a(par2, par3, par4);
        return (this.d || i1 != this.cF) && super.a(par1IBlockAccess, par2, par3, par4, par5);
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
    
    public mr a(final int side, final int meta) {
        switch (meta) {
            case 1: {
                return BlockTFHedge.sprDarkwoodLeaves;
            }
            default: {
                return BlockTFHedge.sprHedge;
            }
        }
    }
    
    public void a(final abv world, final int x, final int y, final int z, final nm entity) {
        int meta = world.h(x, y, z);
        if (meta == 2) {
            meta = 0;
        }
        if (meta == 0 && this.shouldDamage(entity)) {
            entity.a(na.g, (float)this.damageDone);
        }
    }
    
    public void b(final abv world, final int x, final int y, final int z, final nm entity) {
        int meta = world.h(x, y, z);
        if (meta == 2) {
            meta = 0;
        }
        if (meta == 0 && this.shouldDamage(entity)) {
            entity.a(na.g, (float)this.damageDone);
        }
    }
    
    public void a(final abv world, final int x, final int y, final int z, final ue entityplayer) {
        int meta = world.h(x, y, z);
        if (meta == 2) {
            meta = 0;
        }
        if (meta == 0 && !world.I) {
            world.a(x, y, z, this.cF, 10);
        }
    }
    
    public void a(final abv world, final ue entityplayer, final int i, final int j, final int k, int meta) {
        super.a(world, entityplayer, i, j, k, meta);
        if (meta == 2) {
            meta = 0;
        }
        if (meta == 0) {
            entityplayer.a(na.g, (float)this.damageDone);
        }
    }
    
    public void a(final abv world, final int x, final int y, final int z, final Random random) {
        final double range = 4.0;
        final List<ue> nearbyPlayers = world.a((Class)ue.class, asu.a().a((double)x, (double)y, (double)z, (double)(x + 1), (double)(y + 1), (double)(z + 1)).b(range, range, range));
        for (final ue player : nearbyPlayers) {
            if (player.au) {
                final asx mop = this.getPlayerPointVec(world, player, range);
                if (mop == null || world.a(mop.b, mop.c, mop.d) != this.cF) {
                    continue;
                }
                player.a(na.g, (float)this.damageDone);
                world.a(x, y, z, this.cF, 10);
            }
        }
    }
    
    private asx getPlayerPointVec(final abv worldObj, final ue player, final double range) {
        final asz position = worldObj.V().a(player.u, player.v + player.f(), player.w);
        final asz look = player.j(1.0f);
        final asz dest = position.c(look.c * range, look.d * range, look.e * range);
        return worldObj.a(position, dest);
    }
    
    private boolean shouldDamage(final nm entity) {
        return !(entity instanceof ts) && !(entity instanceof sr) && !entity.at();
    }
    
    public int getFlammability(final ace world, final int x, final int y, final int z, final int metadata, final ForgeDirection face) {
        return (metadata == 1) ? 1 : 0;
    }
    
    public int getFireSpreadSpeed(final abv world, final int x, final int y, final int z, final int metadata, final ForgeDirection face) {
        return 0;
    }
    
    public void a(final int par1, final wv par2CreativeTabs, final List par3List) {
        par3List.add(new yd(par1, 1, 0));
        par3List.add(new yd(par1, 1, 1));
    }
    
    public int a(final Random par1Random) {
        return (par1Random.nextInt(40) == 0) ? 1 : 0;
    }
    
    public int a(final int meta, final Random par2Random, final int par3) {
        if (meta == 1) {
            return TFBlocks.sapling.cF;
        }
        return -1;
    }
    
    public yd getPickBlock(final asx target, final abv world, final int x, final int y, final int z) {
        return new yd(this.cF, 1, world.h(x, y, z));
    }
    
    public void a(final abv par1World, final int par2, final int par3, final int par4, final int meta, final float par6, final int fortune) {
        if (!par1World.I && meta == 1 && par1World.s.nextInt(40) == 0) {
            final int var9 = this.a(meta, par1World.s, fortune);
            this.b(par1World, par2, par3, par4, new yd(var9, 1, this.a(meta)));
        }
    }
    
    @SideOnly(Side.CLIENT)
    public void a(final ms par1IconRegister) {
        BlockTFHedge.sprHedge = par1IconRegister.a("TwilightForest:hedge");
        BlockTFHedge.sprDarkwoodLeaves = par1IconRegister.a("TwilightForest:darkwood_leaves");
    }
}
