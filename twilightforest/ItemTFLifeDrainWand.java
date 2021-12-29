// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.Iterator;
import java.util.List;

public class ItemTFLifeDrainWand extends ItemTF
{
    protected ItemTFLifeDrainWand(final int par1) {
        super(par1);
        this.bR = 1;
        this.g(99);
    }
    
    public aan a(final aan par1ItemStack, final xd worldObj, final yw player) {
        if (par1ItemStack.i() < this.h()) {
            player.c(par1ItemStack, this.b(par1ItemStack));
        }
        else {
            player.am();
        }
        return par1ItemStack;
    }
    
    public static void animateTargetShatter(final xd worldObj, final acq target) {
        for (int var1 = 0; var1 < 50; ++var1) {
            final double gaussX = ItemTFLifeDrainWand.d.nextGaussian() * 0.02;
            final double gaussY = ItemTFLifeDrainWand.d.nextGaussian() * 0.02;
            final double gaussZ = ItemTFLifeDrainWand.d.nextGaussian() * 0.02;
            final double gaussFactor = 10.0;
            final int popItem = (getTargetDropItemId(target) > 0) ? getTargetDropItemId(target) : yr.bm.bQ;
            worldObj.a("iconcrack_" + popItem, target.o + ItemTFLifeDrainWand.d.nextFloat() * target.I * 2.0f - target.I - gaussX * gaussFactor, target.p + ItemTFLifeDrainWand.d.nextFloat() * target.J - gaussY * gaussFactor, target.q + ItemTFLifeDrainWand.d.nextFloat() * target.I * 2.0f - target.I - gaussZ * gaussFactor, gaussX, gaussY, gaussZ);
        }
    }
    
    public static int getTargetDropItemId(final acq target) {
        return yr.bm.bQ;
    }
    
    private nn getPlayerLookTarget(final xd worldObj, final yw player) {
        nn pointedEntity = null;
        final double range = 20.0;
        final bo srcVec = bo.b(player.o, player.p + player.I(), player.q);
        final bo lookVec = player.k(1.0f);
        final bo destVec = srcVec.c(lookVec.a * range, lookVec.b * range, lookVec.c * range);
        final float var9 = 1.0f;
        final List possibleList = worldObj.b((nn)player, player.y.a(lookVec.a * range, lookVec.b * range, lookVec.c * range).b((double)var9, (double)var9, (double)var9));
        double hitDist = 0.0;
        for (final nn possibleEntity : possibleList) {
            if (possibleEntity.l_()) {
                final float borderSize = possibleEntity.j_();
                final wu collisionBB = possibleEntity.y.b((double)borderSize, (double)borderSize, (double)borderSize);
                final pl interceptPos = collisionBB.a(srcVec, destVec);
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
    
    public void onUsingItemTick(final aan stack, final yw player, final int count) {
        final xd worldObj = player.k;
        if (stack.i() >= this.h()) {
            player.am();
            return;
        }
        if (count % 5 == 0) {
            final nn pointedEntity = this.getPlayerLookTarget(worldObj, player);
            if (pointedEntity != null && pointedEntity instanceof acq) {
                final acq target = (acq)pointedEntity;
                if (target.b(aad.d) != null || target.bb() < 1) {
                    if (target.bb() <= 3) {
                        this.makeRedMagicTrail(worldObj, player.o, player.p + player.I(), player.q, target.o, target.p + target.I(), target.q);
                        target.ba();
                        worldObj.a((nn)target, "damage.fallbig", 1.0f, ((ItemTFLifeDrainWand.d.nextFloat() - ItemTFLifeDrainWand.d.nextFloat()) * 0.7f + 1.0f) * 2.0f);
                        animateTargetShatter(worldObj, target);
                        if (!worldObj.F) {
                            target.A();
                            target.a(md.b((nn)player, (nn)player));
                        }
                        player.am();
                    }
                    else if (!worldObj.F) {
                        target.a(md.b((nn)player, (nn)player), 3);
                        if (target.d() <= player.d()) {
                            target.r = 0.0;
                            target.s = 0.2;
                            target.t = 0.0;
                        }
                        target.b(new alg(aad.d.H, 20, 2));
                        if (count % 10 == 0) {
                            player.k(1);
                            player.aF().a(1, 0.1f);
                        }
                    }
                }
                else {
                    this.makeRedMagicTrail(worldObj, player.o, player.p + player.I(), player.q, target.o, target.p + target.I(), target.q);
                    worldObj.a((nn)player, "fire.ignite", 1.0f, (worldObj.r.nextFloat() - worldObj.r.nextFloat()) * 0.2f + 1.0f);
                    if (!worldObj.F) {
                        target.a(md.b((nn)player, (nn)player), 1);
                        if (target.d() <= player.d()) {
                            target.r = 0.0;
                            target.s = 0.2;
                            target.t = 0.0;
                        }
                        target.b(new alg(aad.d.H, 20, 2));
                    }
                }
                if (!worldObj.F) {
                    stack.a(1, (acq)player);
                }
            }
        }
    }
    
    protected void makeRedMagicTrail(final xd worldObj, final double srcX, final double srcY, final double srcZ, final double destX, final double destY, final double destZ) {
        for (int particles = 32, i = 0; i < particles; ++i) {
            final double trailFactor = i / (particles - 1.0);
            final float f = 1.0f;
            final float f2 = 0.5f;
            final float f3 = 0.5f;
            final double tx = srcX + (destX - srcX) * trailFactor + worldObj.r.nextGaussian() * 0.005;
            final double ty = srcY + (destY - srcY) * trailFactor + worldObj.r.nextGaussian() * 0.005;
            final double tz = srcZ + (destZ - srcZ) * trailFactor + worldObj.r.nextGaussian() * 0.005;
            worldObj.a("mobSpell", tx, ty, tz, (double)f, (double)f2, (double)f3);
        }
    }
    
    public int b(final aan par1ItemStack) {
        return 72000;
    }
    
    public aaq c(final aan par1ItemStack) {
        return aaq.e;
    }
    
    @Override
    public fo f(final aan par1ItemStack) {
        return fo.c;
    }
    
    public void a(final aan par1ItemStack, final List par2List) {
        par2List.add(par1ItemStack.j() - par1ItemStack.i() + " charges left");
    }
}
