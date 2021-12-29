// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.Iterator;
import java.util.List;

public class ItemTFPeacockFan extends ItemTF
{
    protected ItemTFPeacockFan(final int par1) {
        super(par1);
        this.a(th.i);
        this.ch = 1;
        this.e(1024);
    }
    
    public um a(final um par1ItemStack, final xv world, final qx player) {
        if (!world.J) {
            if (!player.E) {
                player.d(new lm(ll.j.H, 45, 0));
            }
            else {
                int fanned = 0;
                fanned = this.doFan(world, player);
                if (fanned > 0) {
                    par1ItemStack.a(fanned, (md)player);
                }
            }
        }
        else {
            if (!player.E && !player.m(ll.j.H)) {
                player.w *= 3.0;
                player.x = 1.5;
                player.y *= 3.0;
                player.S = 0.0f;
            }
            else {
                final anw fanBox = this.getEffectAABB(world, player);
                final aob lookVec = player.Z();
                for (int i = 0; i < 30; ++i) {
                    world.a("cloud", fanBox.a + world.u.nextFloat() * (fanBox.d - fanBox.a), fanBox.b + world.u.nextFloat() * (fanBox.e - fanBox.b), fanBox.c + world.u.nextFloat() * (fanBox.f - fanBox.c), lookVec.c, lookVec.d, lookVec.e);
                }
            }
            world.b(player.t + 0.5, player.u + 0.5, player.v + 0.5, "random.breath", 1.0f + ItemTFPeacockFan.d.nextFloat(), ItemTFPeacockFan.d.nextFloat() * 0.7f + 0.3f);
        }
        player.a(par1ItemStack, this.a(par1ItemStack));
        return par1ItemStack;
    }
    
    public vn d_(final um par1ItemStack) {
        return vn.d;
    }
    
    public int a(final um par1ItemStack) {
        return 20;
    }
    
    public boolean n_() {
        return true;
    }
    
    private int doFan(final xv world, final qx player) {
        final anw fanBox = this.getEffectAABB(world, player);
        this.fanBlocksInAABB(world, player, fanBox);
        this.fanEntitiesInAABB(world, player, fanBox);
        return 1;
    }
    
    private void fanEntitiesInAABB(final xv world, final qx player, final anw fanBox) {
        final aob moveVec = player.Z();
        final List inBox = world.a((Class)lq.class, fanBox);
        final float force = 2.0f;
        for (final lq entity : inBox) {
            if (entity.M() || entity instanceof px) {
                entity.w = moveVec.c * force;
                entity.x = moveVec.d * force;
                entity.y = moveVec.e * force;
            }
        }
    }
    
    private anw getEffectAABB(final xv world, final qx player) {
        final double range = 3.0;
        final double radius = 2.0;
        final aob srcVec = world.S().a(player.t, player.u + player.e(), player.v);
        final aob lookVec = player.Z();
        final aob destVec = srcVec.c(lookVec.c * range, lookVec.d * range, lookVec.e * range);
        final anw crumbleBox = anw.a().a(destVec.c - radius, destVec.d - radius, destVec.e - radius, destVec.c + radius, destVec.d + radius, destVec.e + radius);
        return crumbleBox;
    }
    
    private int fanBlocksInAABB(final xv world, final qx player, final anw par1AxisAlignedBB) {
        final int minX = ke.c(par1AxisAlignedBB.a);
        final int minY = ke.c(par1AxisAlignedBB.b);
        final int minZ = ke.c(par1AxisAlignedBB.c);
        final int maxX = ke.c(par1AxisAlignedBB.d);
        final int maxY = ke.c(par1AxisAlignedBB.e);
        final int maxZ = ke.c(par1AxisAlignedBB.f);
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
    
    private int fanBlock(final xv world, final qx player, final int dx, final int dy, final int dz) {
        final int cost = 0;
        final int currentID = world.a(dx, dy, dz);
        if (currentID != 0) {
            final int currentMeta = world.h(dx, dy, dz);
            if (amj.p[currentID] instanceof aix && amj.p[currentID].canHarvestBlock(player, currentMeta) && ItemTFPeacockFan.d.nextInt(3) == 0) {
                amj.p[currentID].a(world, player, dx, dy, dz, currentMeta);
                world.e(dx, dy, dz, 0);
                world.f(2001, dx, dy, dz, currentID + (currentMeta << 12));
            }
        }
        return cost;
    }
}
