// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Iterator;
import java.util.List;

public class ItemTFLifeDrainWand extends ItemTF
{
    protected ItemTFLifeDrainWand(final int par1) {
        super(par1);
        this.cq = 1;
        this.e(99);
        this.a((uy)TFItems.creativeTab);
    }
    
    public wg a(final wg par1ItemStack, final zv worldObj, final sk player) {
        if (par1ItemStack.k() < this.n()) {
            player.a(par1ItemStack, this.c_(par1ItemStack));
        }
        else {
            player.bX();
        }
        return par1ItemStack;
    }
    
    public static void animateTargetShatter(final zv worldObj, final ng target) {
        for (int var1 = 0; var1 < 50; ++var1) {
            final double gaussX = ItemTFLifeDrainWand.e.nextGaussian() * 0.02;
            final double gaussY = ItemTFLifeDrainWand.e.nextGaussian() * 0.02;
            final double gaussZ = ItemTFLifeDrainWand.e.nextGaussian() * 0.02;
            final double gaussFactor = 10.0;
            final int popItem = (getTargetDropItemId(target) > 0) ? getTargetDropItemId(target) : we.bn.cp;
            worldObj.a("iconcrack_" + popItem, target.u + ItemTFLifeDrainWand.e.nextFloat() * target.O * 2.0f - target.O - gaussX * gaussFactor, target.v + ItemTFLifeDrainWand.e.nextFloat() * target.P - gaussY * gaussFactor, target.w + ItemTFLifeDrainWand.e.nextFloat() * target.O * 2.0f - target.O - gaussZ * gaussFactor, gaussX, gaussY, gaussZ);
        }
    }
    
    public static int getTargetDropItemId(final ng target) {
        return we.bn.cp;
    }
    
    private mp getPlayerLookTarget(final zv worldObj, final sk player) {
        mp pointedEntity = null;
        final double range = 20.0;
        final aqw srcVec = worldObj.T().a(player.u, player.v + player.e(), player.w);
        final aqw lookVec = player.i(1.0f);
        final aqw destVec = srcVec.c(lookVec.c * range, lookVec.d * range, lookVec.e * range);
        final float var9 = 1.0f;
        final List possibleList = worldObj.b((mp)player, player.E.a(lookVec.c * range, lookVec.d * range, lookVec.e * range).b((double)var9, (double)var9, (double)var9));
        double hitDist = 0.0;
        for (final mp possibleEntity : possibleList) {
            if (possibleEntity.K()) {
                final float borderSize = possibleEntity.X();
                final aqr collisionBB = possibleEntity.E.b((double)borderSize, (double)borderSize, (double)borderSize);
                final aqu interceptPos = collisionBB.a(srcVec, destVec);
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
    
    public void onUsingItemTick(final wg stack, final sk player, final int count) {
        final zv worldObj = player.q;
        if (stack.k() >= this.n()) {
            player.bX();
            return;
        }
        if (count % 5 == 0) {
            final mp pointedEntity = this.getPlayerLookTarget(worldObj, player);
            if (pointedEntity != null && pointedEntity instanceof ng) {
                final ng target = (ng)pointedEntity;
                if (target.b(mk.d) != null || target.aX() < 1) {
                    if (target.aX() <= 3) {
                        this.makeRedMagicTrail(worldObj, player.u, player.v + player.e(), player.w, target.u, target.v + target.e(), target.w);
                        target.aU();
                        worldObj.a((mp)target, "damage.fallbig", 1.0f, ((ItemTFLifeDrainWand.e.nextFloat() - ItemTFLifeDrainWand.e.nextFloat()) * 0.7f + 1.0f) * 2.0f);
                        animateTargetShatter(worldObj, target);
                        if (!worldObj.I) {
                            target.w();
                            target.a(mg.b((mp)player, (mp)player));
                        }
                        player.bX();
                    }
                    else if (!worldObj.I) {
                        target.a(mg.b((mp)player, (mp)player), 3);
                        if (target.aW() <= player.aW()) {
                            target.x = 0.0;
                            target.y = 0.2;
                            target.z = 0.0;
                        }
                        target.d(new ml(mk.d.H, 20, 2));
                        if (count % 10 == 0) {
                            player.j(1);
                            player.cl().a(1, 0.1f);
                        }
                    }
                }
                else {
                    this.makeRedMagicTrail(worldObj, player.u, player.v + player.e(), player.w, target.u, target.v + target.e(), target.w);
                    worldObj.a((mp)player, "fire.ignite", 1.0f, (worldObj.s.nextFloat() - worldObj.s.nextFloat()) * 0.2f + 1.0f);
                    if (!worldObj.I) {
                        target.a(mg.b((mp)player, (mp)player), 1);
                        if (target.aW() <= player.aW()) {
                            target.x = 0.0;
                            target.y = 0.2;
                            target.z = 0.0;
                        }
                        target.d(new ml(mk.d.H, 20, 2));
                    }
                }
                if (!worldObj.I) {
                    stack.a(1, (ng)player);
                }
            }
        }
    }
    
    protected void makeRedMagicTrail(final zv worldObj, final double srcX, final double srcY, final double srcZ, final double destX, final double destY, final double destZ) {
        for (int particles = 32, i = 0; i < particles; ++i) {
            final double trailFactor = i / (particles - 1.0);
            final float f = 1.0f;
            final float f2 = 0.5f;
            final float f3 = 0.5f;
            final double tx = srcX + (destX - srcX) * trailFactor + worldObj.s.nextGaussian() * 0.005;
            final double ty = srcY + (destY - srcY) * trailFactor + worldObj.s.nextGaussian() * 0.005;
            final double tz = srcZ + (destZ - srcZ) * trailFactor + worldObj.s.nextGaussian() * 0.005;
            worldObj.a("mobSpell", tx, ty, tz, (double)f, (double)f2, (double)f3);
        }
    }
    
    public int c_(final wg par1ItemStack) {
        return 72000;
    }
    
    public xj b_(final wg par1ItemStack) {
        return xj.e;
    }
    
    @Override
    public wr f(final wg par1ItemStack) {
        return wr.c;
    }
    
    @SideOnly(Side.CLIENT)
    public void a(final wg par1ItemStack, final sk par2EntityPlayer, final List par3List, final boolean par4) {
        super.a(par1ItemStack, par2EntityPlayer, par3List, par4);
        par3List.add(par1ItemStack.l() - par1ItemStack.k() + " charges left");
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void a(final ly par1IconRegister) {
        this.ct = par1IconRegister.a("twilightforest:" + this.a().substring(5));
    }
}
