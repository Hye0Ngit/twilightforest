import java.util.Iterator;
import java.util.List;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class ItemTFLifeDrainWand extends ItemTF
{
    protected ItemTFLifeDrainWand(final int par1) {
        super(par1);
        this.bQ = 1;
        this.f(99);
    }
    
    public kp a(final kp par1ItemStack, final ge worldObj, final ih player) {
        if (par1ItemStack.h() < this.f()) {
            player.a(par1ItemStack, this.c(par1ItemStack));
        }
        else {
            player.N();
        }
        return par1ItemStack;
    }
    
    public static void animateTargetShatter(final ge worldObj, final ne target) {
        for (int var1 = 0; var1 < 50; ++var1) {
            final double gaussX = target.bS.nextGaussian() * 0.02;
            final double gaussY = target.bS.nextGaussian() * 0.02;
            final double gaussZ = target.bS.nextGaussian() * 0.02;
            final double gaussFactor = 10.0;
            final int popItem = (target.f() > 0) ? target.f() : id.bl.bP;
            worldObj.a("iconcrack_" + popItem, target.bm + target.bS.nextFloat() * target.bG * 2.0f - target.bG - gaussX * gaussFactor, target.bn + target.bS.nextFloat() * target.bH - gaussY * gaussFactor, target.bo + target.bS.nextFloat() * target.bG * 2.0f - target.bG - gaussZ * gaussFactor, gaussX, gaussY, gaussZ);
        }
    }
    
    private tv getPlayerLookTarget(final ge worldObj, final ih player) {
        tv pointedEntity = null;
        final double range = 20.0;
        final cj srcVec = cj.b(player.bm, player.bn + player.B(), player.bo);
        final cj lookVec = player.f(1.0f);
        final cj destVec = srcVec.c(lookVec.a * range, lookVec.b * range, lookVec.c * range);
        final float var9 = 1.0f;
        final List possibleList = worldObj.b((tv)player, player.bw.a(lookVec.a * range, lookVec.b * range, lookVec.c * range).b((double)var9, (double)var9, (double)var9));
        double hitDist = 0.0;
        for (final tv possibleEntity : possibleList) {
            if (possibleEntity.o_()) {
                final float borderSize = possibleEntity.j_();
                final fp collisionBB = possibleEntity.bw.b((double)borderSize, (double)borderSize, (double)borderSize);
                final wu interceptPos = collisionBB.a(srcVec, destVec);
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
                    final double possibleDist = srcVec.b(interceptPos.f);
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
    
    public void onUsingItemTick(final kp stack, final ih player, final int count) {
        final ge worldObj = player.bi;
        if (stack.h() >= this.f()) {
            player.N();
            return;
        }
        if (count % 5 == 0) {
            final tv pointedEntity = this.getPlayerLookTarget(worldObj, player);
            if (pointedEntity != null && pointedEntity instanceof ne) {
                final ne target = (ne)pointedEntity;
                if (target.b(kf.d) != null || target.ap < 1) {
                    if (target.ap <= 3) {
                        this.makeRedMagicTrail(worldObj, player.bm, player.bn + player.B(), player.bo, target.bm, target.bn + target.B(), target.bo);
                        target.aC();
                        worldObj.a((tv)target, "damage.fallbig", 1.0f, ((target.bS.nextFloat() - target.bS.nextFloat()) * 0.7f + 1.0f) * 2.0f);
                        animateTargetShatter(worldObj, target);
                        if (!worldObj.F) {
                            target.X();
                            target.a(rq.b((tv)player, (tv)player));
                        }
                        player.N();
                    }
                    else if (!worldObj.F) {
                        target.a(rq.b((tv)player, (tv)player), 3);
                        if (target.d() <= player.d()) {
                            target.bp = 0.0;
                            target.bq = 0.2;
                            target.br = 0.0;
                        }
                        target.e(new zv(kf.d.H, 20, 2));
                        if (count % 10 == 0) {
                            player.d(1);
                            player.af().a(1, 0.1f);
                        }
                    }
                }
                else {
                    this.makeRedMagicTrail(worldObj, player.bm, player.bn + player.B(), player.bo, target.bm, target.bn + target.B(), target.bo);
                    worldObj.a((tv)player, "fire.ignite", player.p(), (worldObj.r.nextFloat() - worldObj.r.nextFloat()) * 0.2f + 1.0f);
                    if (!worldObj.F) {
                        target.a(rq.b((tv)player, (tv)player), 1);
                        if (target.d() <= player.d()) {
                            target.bp = 0.0;
                            target.bq = 0.2;
                            target.br = 0.0;
                        }
                        target.e(new zv(kf.d.H, 20, 2));
                    }
                }
                if (!worldObj.F) {
                    stack.a(1, (ne)player);
                }
            }
        }
    }
    
    protected void makeRedMagicTrail(final ge worldObj, final double srcX, final double srcY, final double srcZ, final double destX, final double destY, final double destZ) {
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
    
    public int c(final kp par1ItemStack) {
        return 72000;
    }
    
    public kt d(final kp par1ItemStack) {
        return kt.e;
    }
}
