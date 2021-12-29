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
        this.a((wv)TFItems.creativeTab);
        this.cw = 1;
        this.e(1024);
    }
    
    public yd a(final yd par1ItemStack, final abv world, final ue player) {
        player.a(par1ItemStack, this.d_(par1ItemStack));
        world.a((nm)player, "mob.sheep.say", 1.0f, 0.8f);
        return par1ItemStack;
    }
    
    public void onUsingItemTick(final yd stack, final ue player, final int count) {
        if (count > 10 && count % 5 == 0 && !player.q.I) {
            final int crumbled = this.doCrumble(player.q, player);
            if (crumbled > 0) {
                stack.a(crumbled, (oe)player);
            }
            player.q.a((nm)player, "mob.sheep.say", 1.0f, 0.8f);
        }
    }
    
    public zi c_(final yd par1ItemStack) {
        return zi.e;
    }
    
    public int d_(final yd par1ItemStack) {
        return 72000;
    }
    
    private int doCrumble(final abv world, final ue player) {
        final double range = 3.0;
        final double radius = 2.0;
        final asz srcVec = world.V().a(player.u, player.v + player.f(), player.w);
        final asz lookVec = player.Z();
        final asz destVec = srcVec.c(lookVec.c * range, lookVec.d * range, lookVec.e * range);
        final asu crumbleBox = asu.a().a(destVec.c - radius, destVec.d - radius, destVec.e - radius, destVec.c + radius, destVec.d + radius, destVec.e + radius);
        return this.crumbleBlocksInAABB(world, player, crumbleBox);
    }
    
    private int crumbleBlocksInAABB(final abv world, final ue player, final asu par1AxisAlignedBB) {
        final int minX = lr.c(par1AxisAlignedBB.a);
        final int minY = lr.c(par1AxisAlignedBB.b);
        final int minZ = lr.c(par1AxisAlignedBB.c);
        final int maxX = lr.c(par1AxisAlignedBB.d);
        final int maxY = lr.c(par1AxisAlignedBB.e);
        final int maxZ = lr.c(par1AxisAlignedBB.f);
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
    
    private int crumbleBlock(final abv world, final ue player, final int dx, final int dy, final int dz) {
        int cost = 0;
        final int currentID = world.a(dx, dy, dz);
        if (currentID != 0) {
            final int currentMeta = world.h(dx, dy, dz);
            if (currentID == aqw.y.cF && world.s.nextInt(5) == 0) {
                world.f(dx, dy, dz, aqw.B.cF, 0, 3);
                world.e(2001, dx, dy, dz, currentID + (currentMeta << 12));
                ++cost;
            }
            if (currentID == aqw.br.cF && currentMeta == 0 && world.s.nextInt(5) == 0) {
                world.f(dx, dy, dz, aqw.br.cF, 2, 3);
                world.e(2001, dx, dy, dz, currentID + (currentMeta << 12));
                ++cost;
            }
            if (currentID == TFBlocks.mazestone.cF && currentMeta == 1 && world.s.nextInt(5) == 0) {
                world.f(dx, dy, dz, TFBlocks.mazestone.cF, 4, 3);
                world.e(2001, dx, dy, dz, currentID + (currentMeta << 12));
                ++cost;
            }
            if (currentID == aqw.B.cF && world.s.nextInt(5) == 0) {
                world.f(dx, dy, dz, aqw.K.cF, 0, 3);
                world.e(2001, dx, dy, dz, currentID + (currentMeta << 12));
                ++cost;
            }
            if ((currentID == aqw.K.cF || currentID == aqw.A.cF) && aqw.s[currentID].canHarvestBlock(player, currentMeta) && world.s.nextInt(20) == 0) {
                world.f(dx, dy, dz, 0, 0, 3);
                aqw.s[currentID].a(world, player, dx, dy, dz, currentMeta);
                world.e(2001, dx, dy, dz, currentID + (currentMeta << 12));
                ++cost;
            }
        }
        return cost;
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void a(final ms par1IconRegister) {
        this.cz = par1IconRegister.a("TwilightForest:" + this.a().substring(5));
    }
}
