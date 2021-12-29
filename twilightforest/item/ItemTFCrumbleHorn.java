// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import twilightforest.block.TFBlocks;

public class ItemTFCrumbleHorn extends ItemTF
{
    private static final int CHANCE_HARVEST = 20;
    private static final int CHANCE_CRUMBLE = 5;
    
    protected ItemTFCrumbleHorn(final int par1) {
        super(par1);
        this.a((uy)TFItems.creativeTab);
        this.cq = 1;
        this.e(1024);
    }
    
    public wg a(final wg par1ItemStack, final zv world, final sk player) {
        player.a(par1ItemStack, this.c_(par1ItemStack));
        world.a((mp)player, "mob.sheep.say", 1.0f, 0.8f);
        return par1ItemStack;
    }
    
    public void onUsingItemTick(final wg stack, final sk player, final int count) {
        if (count > 10 && count % 5 == 0 && !player.q.I) {
            final int crumbled = this.doCrumble(player.q, player);
            if (crumbled > 0) {
                stack.a(crumbled, (ng)player);
            }
            player.q.a((mp)player, "mob.sheep.say", 1.0f, 0.8f);
        }
    }
    
    public xj b_(final wg par1ItemStack) {
        return xj.e;
    }
    
    public int c_(final wg par1ItemStack) {
        return 72000;
    }
    
    private int doCrumble(final zv world, final sk player) {
        final double range = 3.0;
        final double radius = 2.0;
        final aqw srcVec = world.T().a(player.u, player.v + player.e(), player.w);
        final aqw lookVec = player.Y();
        final aqw destVec = srcVec.c(lookVec.c * range, lookVec.d * range, lookVec.e * range);
        final aqr crumbleBox = aqr.a().a(destVec.c - radius, destVec.d - radius, destVec.e - radius, destVec.c + radius, destVec.d + radius, destVec.e + radius);
        return this.crumbleBlocksInAABB(world, player, crumbleBox);
    }
    
    private int crumbleBlocksInAABB(final zv world, final sk player, final aqr par1AxisAlignedBB) {
        final int minX = kx.c(par1AxisAlignedBB.a);
        final int minY = kx.c(par1AxisAlignedBB.b);
        final int minZ = kx.c(par1AxisAlignedBB.c);
        final int maxX = kx.c(par1AxisAlignedBB.d);
        final int maxY = kx.c(par1AxisAlignedBB.e);
        final int maxZ = kx.c(par1AxisAlignedBB.f);
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
    
    private int crumbleBlock(final zv world, final sk player, final int dx, final int dy, final int dz) {
        int cost = 0;
        final int currentID = world.a(dx, dy, dz);
        if (currentID != 0) {
            final int currentMeta = world.h(dx, dy, dz);
            if (currentID == aou.x.cz && world.s.nextInt(5) == 0) {
                world.f(dx, dy, dz, aou.A.cz, 0, 3);
                world.e(2001, dx, dy, dz, currentID + (currentMeta << 12));
                ++cost;
            }
            if (currentID == aou.bq.cz && currentMeta == 0 && world.s.nextInt(5) == 0) {
                world.f(dx, dy, dz, aou.bq.cz, 2, 3);
                world.e(2001, dx, dy, dz, currentID + (currentMeta << 12));
                ++cost;
            }
            if (currentID == TFBlocks.mazestone.cz && currentMeta == 1 && world.s.nextInt(5) == 0) {
                world.f(dx, dy, dz, TFBlocks.mazestone.cz, 4, 3);
                world.e(2001, dx, dy, dz, currentID + (currentMeta << 12));
                ++cost;
            }
            if (currentID == aou.A.cz && world.s.nextInt(5) == 0) {
                world.f(dx, dy, dz, aou.J.cz, 0, 3);
                world.e(2001, dx, dy, dz, currentID + (currentMeta << 12));
                ++cost;
            }
            if ((currentID == aou.J.cz || currentID == aou.z.cz) && aou.r[currentID].canHarvestBlock(player, currentMeta) && world.s.nextInt(20) == 0) {
                world.f(dx, dy, dz, 0, 0, 3);
                aou.r[currentID].a(world, player, dx, dy, dz, currentMeta);
                world.e(2001, dx, dy, dz, currentID + (currentMeta << 12));
                ++cost;
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
