// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import java.util.Iterator;
import java.util.List;

public class ItemTFPeacockFan extends ItemTF
{
    protected ItemTFPeacockFan(final int par1) {
        super(par1);
        this.a((tj)TFItems.creativeTab);
        this.ck = 1;
        this.e(1024);
    }
    
    public ur a(final ur par1ItemStack, final yc world, final qx player) {
        if (!world.I) {
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
                final aoe fanBox = this.getEffectAABB(world, player);
                final aoj lookVec = player.Z();
                for (int i = 0; i < 30; ++i) {
                    world.a("cloud", fanBox.a + world.t.nextFloat() * (fanBox.d - fanBox.a), fanBox.b + world.t.nextFloat() * (fanBox.e - fanBox.b), fanBox.c + world.t.nextFloat() * (fanBox.f - fanBox.c), lookVec.c, lookVec.d, lookVec.e);
                }
            }
            world.a(player.t + 0.5, player.u + 0.5, player.v + 0.5, "random.breath", 1.0f + ItemTFPeacockFan.d.nextFloat(), ItemTFPeacockFan.d.nextFloat() * 0.7f + 0.3f, false);
        }
        player.a(par1ItemStack, this.c_(par1ItemStack));
        return par1ItemStack;
    }
    
    public vs b_(final ur par1ItemStack) {
        return vs.d;
    }
    
    public int c_(final ur par1ItemStack) {
        return 20;
    }
    
    public boolean n_() {
        return true;
    }
    
    private int doFan(final yc world, final qx player) {
        final aoe fanBox = this.getEffectAABB(world, player);
        this.fanBlocksInAABB(world, player, fanBox);
        this.fanEntitiesInAABB(world, player, fanBox);
        return 1;
    }
    
    private void fanEntitiesInAABB(final yc world, final qx player, final aoe fanBox) {
        final aoj moveVec = player.Z();
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
    
    private aoe getEffectAABB(final yc world, final qx player) {
        final double range = 3.0;
        final double radius = 2.0;
        final aoj srcVec = world.S().a(player.t, player.u + player.e(), player.v);
        final aoj lookVec = player.Z();
        final aoj destVec = srcVec.c(lookVec.c * range, lookVec.d * range, lookVec.e * range);
        final aoe crumbleBox = aoe.a().a(destVec.c - radius, destVec.d - radius, destVec.e - radius, destVec.c + radius, destVec.d + radius, destVec.e + radius);
        return crumbleBox;
    }
    
    private int fanBlocksInAABB(final yc world, final qx player, final aoe par1AxisAlignedBB) {
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
    
    private int fanBlock(final yc world, final qx player, final int dx, final int dy, final int dz) {
        final int cost = 0;
        final int currentID = world.a(dx, dy, dz);
        if (currentID != 0) {
            final int currentMeta = world.h(dx, dy, dz);
            if (amq.p[currentID] instanceof aje && amq.p[currentID].canHarvestBlock(player, currentMeta) && ItemTFPeacockFan.d.nextInt(3) == 0) {
                amq.p[currentID].a(world, player, dx, dy, dz, currentMeta);
                world.e(dx, dy, dz, 0);
                world.f(2001, dx, dy, dz, currentID + (currentMeta << 12));
            }
        }
        return cost;
    }
}
