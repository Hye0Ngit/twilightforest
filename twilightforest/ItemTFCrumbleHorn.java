// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class ItemTFCrumbleHorn extends ItemTF
{
    private static final int CHANCE_HARVEST = 20;
    private static final int CHANCE_CRUMBLE = 5;
    
    protected ItemTFCrumbleHorn(final int par1) {
        super(par1);
        this.a(th.i);
        this.ch = 1;
        this.e(1024);
    }
    
    public um a(final um par1ItemStack, final xv world, final qx player) {
        player.a(par1ItemStack, this.a(par1ItemStack));
        world.a((lq)player, "mob.sheep.say", 1.0f, 0.8f);
        return par1ItemStack;
    }
    
    public void onUsingItemTick(final um stack, final qx player, final int count) {
        if (count > 10 && count % 5 == 0 && !player.p.J) {
            final int crumbled = this.doCrumble(player.p, player);
            if (crumbled > 0) {
                stack.a(crumbled, (md)player);
            }
            player.p.a((lq)player, "mob.sheep.say", 1.0f, 0.8f);
        }
    }
    
    public vn d_(final um par1ItemStack) {
        return vn.e;
    }
    
    public int a(final um par1ItemStack) {
        return 72000;
    }
    
    private int doCrumble(final xv world, final qx player) {
        final double range = 3.0;
        final double radius = 2.0;
        final aob srcVec = world.S().a(player.t, player.u + player.e(), player.v);
        final aob lookVec = player.Z();
        final aob destVec = srcVec.c(lookVec.c * range, lookVec.d * range, lookVec.e * range);
        final anw crumbleBox = anw.a().a(destVec.c - radius, destVec.d - radius, destVec.e - radius, destVec.c + radius, destVec.d + radius, destVec.e + radius);
        return this.crumbleBlocksInAABB(world, player, crumbleBox);
    }
    
    private int crumbleBlocksInAABB(final xv world, final qx player, final anw par1AxisAlignedBB) {
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
    
    private int crumbleBlock(final xv world, final qx player, final int dx, final int dy, final int dz) {
        int cost = 0;
        final int currentID = world.a(dx, dy, dz);
        if (currentID != 0) {
            final int currentMeta = world.h(dx, dy, dz);
            if (currentID == amj.w.cm && world.u.nextInt(5) == 0) {
                world.e(dx, dy, dz, amj.z.cm);
                world.f(2001, dx, dy, dz, currentID + (currentMeta << 12));
                ++cost;
            }
            if (currentID == amj.bp.cm && currentMeta == 0 && world.u.nextInt(5) == 0) {
                world.d(dx, dy, dz, amj.bp.cm, 2);
                world.f(2001, dx, dy, dz, currentID + (currentMeta << 12));
                ++cost;
            }
            if (currentID == TFBlocks.mazestone.cm && currentMeta == 1 && world.u.nextInt(5) == 0) {
                world.d(dx, dy, dz, TFBlocks.mazestone.cm, 4);
                world.f(2001, dx, dy, dz, currentID + (currentMeta << 12));
                ++cost;
            }
            if (currentID == amj.z.cm && world.u.nextInt(5) == 0) {
                world.e(dx, dy, dz, amj.I.cm);
                world.f(2001, dx, dy, dz, currentID + (currentMeta << 12));
                ++cost;
            }
            if ((currentID == amj.I.cm || currentID == amj.y.cm) && amj.p[currentID].canHarvestBlock(player, currentMeta) && world.u.nextInt(20) == 0) {
                world.e(dx, dy, dz, 0);
                amj.p[currentID].a(world, player, dx, dy, dz, currentMeta);
                world.f(2001, dx, dy, dz, currentID + (currentMeta << 12));
                ++cost;
            }
        }
        return cost;
    }
}
