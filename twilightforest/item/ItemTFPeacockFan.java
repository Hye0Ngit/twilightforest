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
        this.a((wv)TFItems.creativeTab);
        this.cw = 1;
        this.e(1024);
    }
    
    public yd a(final yd par1ItemStack, final abv world, final ue player) {
        if (!world.I) {
            if (!player.F) {
                player.c(new ni(nh.j.H, 45, 0));
            }
            else {
                int fanned = 0;
                fanned = this.doFan(world, player);
                if (fanned > 0) {
                    par1ItemStack.a(fanned, (oe)player);
                }
            }
        }
        else {
            if (!player.F && !player.i(nh.j.H)) {
                player.x *= 3.0;
                player.y = 1.5;
                player.z *= 3.0;
                player.T = 0.0f;
            }
            else {
                final asu fanBox = this.getEffectAABB(world, player);
                final asz lookVec = player.Z();
                for (int i = 0; i < 30; ++i) {
                    world.a("cloud", fanBox.a + world.s.nextFloat() * (fanBox.d - fanBox.a), fanBox.b + world.s.nextFloat() * (fanBox.e - fanBox.b), fanBox.c + world.s.nextFloat() * (fanBox.f - fanBox.c), lookVec.c, lookVec.d, lookVec.e);
                }
            }
            world.a(player.u + 0.5, player.v + 0.5, player.w + 0.5, "random.breath", 1.0f + ItemTFPeacockFan.f.nextFloat(), ItemTFPeacockFan.f.nextFloat() * 0.7f + 0.3f, false);
        }
        player.a(par1ItemStack, this.d_(par1ItemStack));
        return par1ItemStack;
    }
    
    public zi c_(final yd par1ItemStack) {
        return zi.d;
    }
    
    public int d_(final yd par1ItemStack) {
        return 20;
    }
    
    public boolean n_() {
        return true;
    }
    
    private int doFan(final abv world, final ue player) {
        final asu fanBox = this.getEffectAABB(world, player);
        this.fanBlocksInAABB(world, player, fanBox);
        this.fanEntitiesInAABB(world, player, fanBox);
        return 1;
    }
    
    private void fanEntitiesInAABB(final abv world, final ue player, final asu fanBox) {
        final asz moveVec = player.Z();
        final List<nm> inBox = world.a((Class)nm.class, fanBox);
        final float force = 2.0f;
        for (final nm entity : inBox) {
            if (entity.L() || entity instanceof sr) {
                entity.x = moveVec.c * force;
                entity.y = moveVec.d * force;
                entity.z = moveVec.e * force;
            }
        }
    }
    
    private asu getEffectAABB(final abv world, final ue player) {
        final double range = 3.0;
        final double radius = 2.0;
        final asz srcVec = world.V().a(player.u, player.v + player.f(), player.w);
        final asz lookVec = player.Z();
        final asz destVec = srcVec.c(lookVec.c * range, lookVec.d * range, lookVec.e * range);
        final asu crumbleBox = asu.a().a(destVec.c - radius, destVec.d - radius, destVec.e - radius, destVec.c + radius, destVec.d + radius, destVec.e + radius);
        return crumbleBox;
    }
    
    private int fanBlocksInAABB(final abv world, final ue player, final asu par1AxisAlignedBB) {
        final int minX = lr.c(par1AxisAlignedBB.a);
        final int minY = lr.c(par1AxisAlignedBB.b);
        final int minZ = lr.c(par1AxisAlignedBB.c);
        final int maxX = lr.c(par1AxisAlignedBB.d);
        final int maxY = lr.c(par1AxisAlignedBB.e);
        final int maxZ = lr.c(par1AxisAlignedBB.f);
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
    
    private int fanBlock(final abv world, final ue player, final int dx, final int dy, final int dz) {
        final int cost = 0;
        final int currentID = world.a(dx, dy, dz);
        if (currentID != 0) {
            final int currentMeta = world.h(dx, dy, dz);
            if (aqw.s[currentID] instanceof anb && aqw.s[currentID].canHarvestBlock(player, currentMeta) && ItemTFPeacockFan.f.nextInt(3) == 0) {
                aqw.s[currentID].a(world, player, dx, dy, dz, currentMeta);
                world.f(dx, dy, dz, 0, 0, 3);
                world.e(2001, dx, dy, dz, currentID + (currentMeta << 12));
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
