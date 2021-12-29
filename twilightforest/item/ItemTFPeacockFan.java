// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Iterator;
import java.util.List;

public class ItemTFPeacockFan extends ItemTF
{
    protected ItemTFPeacockFan(final int par1) {
        super(par1);
        this.a((uy)TFItems.creativeTab);
        this.cq = 1;
        this.e(1024);
    }
    
    public wg a(final wg par1ItemStack, final zv world, final sk player) {
        if (!world.I) {
            if (!player.F) {
                player.d(new ml(mk.j.H, 45, 0));
            }
            else {
                int fanned = 0;
                fanned = this.doFan(world, player);
                if (fanned > 0) {
                    par1ItemStack.a(fanned, (ng)player);
                }
            }
        }
        else {
            if (!player.F && !player.m(mk.j.H)) {
                player.x *= 3.0;
                player.y = 1.5;
                player.z *= 3.0;
                player.T = 0.0f;
            }
            else {
                final aqr fanBox = this.getEffectAABB(world, player);
                final aqw lookVec = player.Y();
                for (int i = 0; i < 30; ++i) {
                    world.a("cloud", fanBox.a + world.s.nextFloat() * (fanBox.d - fanBox.a), fanBox.b + world.s.nextFloat() * (fanBox.e - fanBox.b), fanBox.c + world.s.nextFloat() * (fanBox.f - fanBox.c), lookVec.c, lookVec.d, lookVec.e);
                }
            }
            world.a(player.u + 0.5, player.v + 0.5, player.w + 0.5, "random.breath", 1.0f + ItemTFPeacockFan.e.nextFloat(), ItemTFPeacockFan.e.nextFloat() * 0.7f + 0.3f, false);
        }
        player.a(par1ItemStack, this.c_(par1ItemStack));
        return par1ItemStack;
    }
    
    public xj b_(final wg par1ItemStack) {
        return xj.d;
    }
    
    public int c_(final wg par1ItemStack) {
        return 20;
    }
    
    public boolean n_() {
        return true;
    }
    
    private int doFan(final zv world, final sk player) {
        final aqr fanBox = this.getEffectAABB(world, player);
        this.fanBlocksInAABB(world, player, fanBox);
        this.fanEntitiesInAABB(world, player, fanBox);
        return 1;
    }
    
    private void fanEntitiesInAABB(final zv world, final sk player, final aqr fanBox) {
        final aqw moveVec = player.Y();
        final List inBox = world.a((Class)mp.class, fanBox);
        final float force = 2.0f;
        for (final mp entity : inBox) {
            if (entity.L() || entity instanceof rb) {
                entity.x = moveVec.c * force;
                entity.y = moveVec.d * force;
                entity.z = moveVec.e * force;
            }
        }
    }
    
    private aqr getEffectAABB(final zv world, final sk player) {
        final double range = 3.0;
        final double radius = 2.0;
        final aqw srcVec = world.T().a(player.u, player.v + player.e(), player.w);
        final aqw lookVec = player.Y();
        final aqw destVec = srcVec.c(lookVec.c * range, lookVec.d * range, lookVec.e * range);
        final aqr crumbleBox = aqr.a().a(destVec.c - radius, destVec.d - radius, destVec.e - radius, destVec.c + radius, destVec.d + radius, destVec.e + radius);
        return crumbleBox;
    }
    
    private int fanBlocksInAABB(final zv world, final sk player, final aqr par1AxisAlignedBB) {
        final int minX = kx.c(par1AxisAlignedBB.a);
        final int minY = kx.c(par1AxisAlignedBB.b);
        final int minZ = kx.c(par1AxisAlignedBB.c);
        final int maxX = kx.c(par1AxisAlignedBB.d);
        final int maxY = kx.c(par1AxisAlignedBB.e);
        final int maxZ = kx.c(par1AxisAlignedBB.f);
        int fan = 0;
        for (int dx = minX; dx <= maxX; ++dx) {
            for (int dy = minY; dy <= maxY; ++dy) {
                for (int dz = minZ; dz <= maxZ; ++dz) {
                    fan += this.fanBlock(world, player, dx, dy, dz);
                }
            }
        }
        return fan;
    }
    
    private int fanBlock(final zv world, final sk player, final int dx, final int dy, final int dz) {
        final int cost = 0;
        final int currentID = world.a(dx, dy, dz);
        if (currentID != 0) {
            final int currentMeta = world.h(dx, dy, dz);
            if (aou.r[currentID] instanceof alb && aou.r[currentID].canHarvestBlock(player, currentMeta) && ItemTFPeacockFan.e.nextInt(3) == 0) {
                aou.r[currentID].a(world, player, dx, dy, dz, currentMeta);
                world.f(dx, dy, dz, 0, 0, 3);
                world.e(2001, dx, dy, dz, currentID + (currentMeta << 12));
            }
        }
        return cost;
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void a(final ly par1IconRegister) {
        this.ct = par1IconRegister.a("twilightforest:" + this.a().substring(5));
    }
}
