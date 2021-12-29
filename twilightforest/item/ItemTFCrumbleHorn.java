// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import twilightforest.block.TFBlocks;

public class ItemTFCrumbleHorn extends ItemTF
{
    private static final int CHANCE_HARVEST = 20;
    private static final int CHANCE_CRUMBLE = 5;
    
    protected ItemTFCrumbleHorn(final int par1) {
        super(par1);
        this.a((tj)TFItems.creativeTab);
        this.ck = 1;
        this.e(1024);
    }
    
    public ur a(final ur par1ItemStack, final yc world, final qx player) {
        player.a(par1ItemStack, this.c_(par1ItemStack));
        world.a((lq)player, "mob.sheep.say", 1.0f, 0.8f);
        return par1ItemStack;
    }
    
    public void onUsingItemTick(final ur stack, final qx player, final int count) {
        if (count > 10 && count % 5 == 0 && !player.p.I) {
            final int crumbled = this.doCrumble(player.p, player);
            if (crumbled > 0) {
                stack.a(crumbled, (md)player);
            }
            player.p.a((lq)player, "mob.sheep.say", 1.0f, 0.8f);
        }
    }
    
    public vs b_(final ur par1ItemStack) {
        return vs.e;
    }
    
    public int c_(final ur par1ItemStack) {
        return 72000;
    }
    
    private int doCrumble(final yc world, final qx player) {
        final double range = 3.0;
        final double radius = 2.0;
        final aoj srcVec = world.S().a(player.t, player.u + player.e(), player.v);
        final aoj lookVec = player.Z();
        final aoj destVec = srcVec.c(lookVec.c * range, lookVec.d * range, lookVec.e * range);
        final aoe crumbleBox = aoe.a().a(destVec.c - radius, destVec.d - radius, destVec.e - radius, destVec.c + radius, destVec.d + radius, destVec.e + radius);
        return this.crumbleBlocksInAABB(world, player, crumbleBox);
    }
    
    private int crumbleBlocksInAABB(final yc world, final qx player, final aoe par1AxisAlignedBB) {
        final int minX = ke.c(par1AxisAlignedBB.a);
        final int minY = ke.c(par1AxisAlignedBB.b);
        final int minZ = ke.c(par1AxisAlignedBB.c);
        final int maxX = ke.c(par1AxisAlignedBB.d);
        final int maxY = ke.c(par1AxisAlignedBB.e);
        final int maxZ = ke.c(par1AxisAlignedBB.f);
        int crumbled = 0;
        for (int dx = minX; dx <= maxX; ++dx) {
            for (int dy = minY; dy <= maxY; ++dy) {
                for (int dz = minZ; dz <= maxZ; ++dz) {
                    crumbled += this.crumbleBlock(world, player, dx, dy, dz);
                }
            }
        }
        return crumbled;
    }
    
    private int crumbleBlock(final yc world, final qx player, final int dx, final int dy, final int dz) {
        int cost = 0;
        final int currentID = world.a(dx, dy, dz);
        if (currentID != 0) {
            final int currentMeta = world.h(dx, dy, dz);
            if (currentID == amq.w.cm && world.t.nextInt(5) == 0) {
                world.e(dx, dy, dz, amq.z.cm);
                world.f(2001, dx, dy, dz, currentID + (currentMeta << 12));
                ++cost;
            }
            if (currentID == amq.bp.cm && currentMeta == 0 && world.t.nextInt(5) == 0) {
                world.d(dx, dy, dz, amq.bp.cm, 2);
                world.f(2001, dx, dy, dz, currentID + (currentMeta << 12));
                ++cost;
            }
            if (currentID == TFBlocks.mazestone.cm && currentMeta == 1 && world.t.nextInt(5) == 0) {
                world.d(dx, dy, dz, TFBlocks.mazestone.cm, 4);
                world.f(2001, dx, dy, dz, currentID + (currentMeta << 12));
                ++cost;
            }
            if (currentID == amq.z.cm && world.t.nextInt(5) == 0) {
                world.e(dx, dy, dz, amq.I.cm);
                world.f(2001, dx, dy, dz, currentID + (currentMeta << 12));
                ++cost;
            }
            if ((currentID == amq.I.cm || currentID == amq.y.cm) && amq.p[currentID].canHarvestBlock(player, currentMeta) && world.t.nextInt(20) == 0) {
                world.e(dx, dy, dz, 0);
                amq.p[currentID].a(world, player, dx, dy, dz, currentMeta);
                world.f(2001, dx, dy, dz, currentID + (currentMeta << 12));
                ++cost;
            }
        }
        return cost;
    }
}
