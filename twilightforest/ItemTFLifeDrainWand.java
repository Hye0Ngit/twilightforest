// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import java.util.Iterator;
import java.util.List;

public class ItemTFLifeDrainWand extends ItemTF
{
    protected ItemTFLifeDrainWand(final int par1) {
        super(par1);
        this.ch = 1;
        this.e(99);
        this.a(th.j);
    }
    
    public um a(final um par1ItemStack, final xv worldObj, final qx player) {
        if (par1ItemStack.j() < this.m()) {
            player.a(par1ItemStack, this.a(par1ItemStack));
        }
        else {
            player.bO();
        }
        return par1ItemStack;
    }
    
    public static void animateTargetShatter(final xv worldObj, final md target) {
        for (int var1 = 0; var1 < 50; ++var1) {
            final double gaussX = ItemTFLifeDrainWand.d.nextGaussian() * 0.02;
            final double gaussY = ItemTFLifeDrainWand.d.nextGaussian() * 0.02;
            final double gaussZ = ItemTFLifeDrainWand.d.nextGaussian() * 0.02;
            final double gaussFactor = 10.0;
            final int popItem = (getTargetDropItemId(target) > 0) ? getTargetDropItemId(target) : uk.bm.cg;
            worldObj.a("iconcrack_" + popItem, target.t + ItemTFLifeDrainWand.d.nextFloat() * target.N * 2.0f - target.N - gaussX * gaussFactor, target.u + ItemTFLifeDrainWand.d.nextFloat() * target.O - gaussY * gaussFactor, target.v + ItemTFLifeDrainWand.d.nextFloat() * target.N * 2.0f - target.N - gaussZ * gaussFactor, gaussX, gaussY, gaussZ);
        }
    }
    
    public static int getTargetDropItemId(final md target) {
        return uk.bm.cg;
    }
    
    private lq getPlayerLookTarget(final xv worldObj, final qx player) {
        lq pointedEntity = null;
        final double range = 20.0;
        final aob srcVec = worldObj.S().a(player.t, player.u + player.e(), player.v);
        final aob lookVec = player.i(1.0f);
        final aob destVec = srcVec.c(lookVec.c * range, lookVec.d * range, lookVec.e * range);
        final float var9 = 1.0f;
        final List possibleList = worldObj.b((lq)player, player.D.a(lookVec.c * range, lookVec.d * range, lookVec.e * range).b((double)var9, (double)var9, (double)var9));
        double hitDist = 0.0;
        for (final lq possibleEntity : possibleList) {
            if (possibleEntity.L()) {
                final float borderSize = possibleEntity.Y();
                final anw collisionBB = possibleEntity.D.b((double)borderSize, (double)borderSize, (double)borderSize);
                final anz interceptPos = collisionBB.a(srcVec, destVec);
                if (collisionBB.a(srcVec)) {
                    if (0.0 >= hitDist && hitDist != 0.0) {
                        continue;
                    }
                    pointedEntity = possibleEntity;
                    hitDist = 0.0;
                }
                else {
                    if (interceptPos == null) {
                        continue;
                    }
                    final double possibleDist = srcVec.d(interceptPos.f);
                    if (possibleDist >= hitDist && hitDist != 0.0) {
                        continue;
                    }
                    pointedEntity = possibleEntity;
                    hitDist = possibleDist;
                }
            }
        }
        return pointedEntity;
    }
    
    public void onUsingItemTick(final um stack, final qx player, final int count) {
        final xv worldObj = player.p;
        if (stack.j() >= this.m()) {
            player.bO();
            return;
        }
        if (count % 5 == 0) {
            final lq pointedEntity = this.getPlayerLookTarget(worldObj, player);
            if (pointedEntity != null && pointedEntity instanceof md) {
                final md target = (md)pointedEntity;
                if (target.b(ll.d) != null || target.aU() < 1) {
                    if (target.aU() <= 3) {
                        this.makeRedMagicTrail(worldObj, player.t, player.u + player.e(), player.v, target.t, target.u + target.e(), target.v);
                        target.aR();
                        worldObj.a((lq)target, "damage.fallbig", 1.0f, ((ItemTFLifeDrainWand.d.nextFloat() - ItemTFLifeDrainWand.d.nextFloat()) * 0.7f + 1.0f) * 2.0f);
                        animateTargetShatter(worldObj, target);
                        if (!worldObj.J) {
                            target.x();
                            target.a(lh.b((lq)player, (lq)player));
                        }
                        player.bO();
                    }
                    else if (!worldObj.J) {
                        target.a(lh.b((lq)player, (lq)player), 3);
                        if (target.aT() <= player.aT()) {
                            target.w = 0.0;
                            target.x = 0.2;
                            target.y = 0.0;
                        }
                        target.d(new lm(ll.d.H, 20, 2));
                        if (count % 10 == 0) {
                            player.i(1);
                            player.cd().a(1, 0.1f);
                        }
                    }
                }
                else {
                    this.makeRedMagicTrail(worldObj, player.t, player.u + player.e(), player.v, target.t, target.u + target.e(), target.v);
                    worldObj.a((lq)player, "fire.ignite", 1.0f, (worldObj.u.nextFloat() - worldObj.u.nextFloat()) * 0.2f + 1.0f);
                    if (!worldObj.J) {
                        target.a(lh.b((lq)player, (lq)player), 1);
                        if (target.aT() <= player.aT()) {
                            target.w = 0.0;
                            target.x = 0.2;
                            target.y = 0.0;
                        }
                        target.d(new lm(ll.d.H, 20, 2));
                    }
                }
                if (!worldObj.J) {
                    stack.a(1, (md)player);
                }
            }
        }
    }
    
    protected void makeRedMagicTrail(final xv worldObj, final double srcX, final double srcY, final double srcZ, final double destX, final double destY, final double destZ) {
        for (int particles = 32, i = 0; i < particles; ++i) {
            final double trailFactor = i / (particles - 1.0);
            final float f = 1.0f;
            final float f2 = 0.5f;
            final float f3 = 0.5f;
            final double tx = srcX + (destX - srcX) * trailFactor + worldObj.u.nextGaussian() * 0.005;
            final double ty = srcY + (destY - srcY) * trailFactor + worldObj.u.nextGaussian() * 0.005;
            final double tz = srcZ + (destZ - srcZ) * trailFactor + worldObj.u.nextGaussian() * 0.005;
            worldObj.a("mobSpell", tx, ty, tz, (double)f, (double)f2, (double)f3);
        }
    }
    
    public int a(final um par1ItemStack) {
        return 72000;
    }
    
    public vn d_(final um par1ItemStack) {
        return vn.e;
    }
    
    @Override
    public uw e(final um par1ItemStack) {
        return uw.c;
    }
    
    @SideOnly(Side.CLIENT)
    public void a(final um par1ItemStack, final qx par2EntityPlayer, final List par3List, final boolean par4) {
        super.a(par1ItemStack, par2EntityPlayer, par3List, par4);
        par3List.add(par1ItemStack.k() - par1ItemStack.j() + " charges left");
    }
}
