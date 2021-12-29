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
        this.cw = 1;
        this.e(99);
        this.a((wv)TFItems.creativeTab);
    }
    
    public yd a(final yd par1ItemStack, final abv worldObj, final ue player) {
        if (par1ItemStack.k() < this.o()) {
            player.a(par1ItemStack, this.d_(par1ItemStack));
        }
        else {
            player.bs();
        }
        return par1ItemStack;
    }
    
    public static void animateTargetShatter(final abv worldObj, final oe target) {
        for (int var1 = 0; var1 < 50; ++var1) {
            final double gaussX = ItemTFLifeDrainWand.f.nextGaussian() * 0.02;
            final double gaussY = ItemTFLifeDrainWand.f.nextGaussian() * 0.02;
            final double gaussZ = ItemTFLifeDrainWand.f.nextGaussian() * 0.02;
            final double gaussFactor = 10.0;
            final int popItem = (getTargetDropItemId(target) > 0) ? getTargetDropItemId(target) : yb.bo.cv;
            worldObj.a("iconcrack_" + popItem, target.u + ItemTFLifeDrainWand.f.nextFloat() * target.O * 2.0f - target.O - gaussX * gaussFactor, target.v + ItemTFLifeDrainWand.f.nextFloat() * target.P - gaussY * gaussFactor, target.w + ItemTFLifeDrainWand.f.nextFloat() * target.O * 2.0f - target.O - gaussZ * gaussFactor, gaussX, gaussY, gaussZ);
        }
    }
    
    public static int getTargetDropItemId(final oe target) {
        return yb.bo.cv;
    }
    
    private nm getPlayerLookTarget(final abv worldObj, final ue player) {
        nm pointedEntity = null;
        final double range = 20.0;
        final asz srcVec = worldObj.V().a(player.u, player.v + player.f(), player.w);
        final asz lookVec = player.j(1.0f);
        final asz destVec = srcVec.c(lookVec.c * range, lookVec.d * range, lookVec.e * range);
        final float var9 = 1.0f;
        final List<nm> possibleList = worldObj.b((nm)player, player.E.a(lookVec.c * range, lookVec.d * range, lookVec.e * range).b((double)var9, (double)var9, (double)var9));
        double hitDist = 0.0;
        for (final nm possibleEntity : possibleList) {
            if (possibleEntity.K()) {
                final float borderSize = possibleEntity.Y();
                final asu collisionBB = possibleEntity.E.b((double)borderSize, (double)borderSize, (double)borderSize);
                final asx interceptPos = collisionBB.a(srcVec, destVec);
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
    
    public void onUsingItemTick(final yd stack, final ue player, final int count) {
        final abv worldObj = player.q;
        if (stack.k() >= this.o()) {
            player.bs();
            return;
        }
        if (count % 5 == 0) {
            final nm pointedEntity = this.getPlayerLookTarget(worldObj, player);
            if (pointedEntity != null && pointedEntity instanceof oe) {
                final oe target = (oe)pointedEntity;
                if (target.b(nh.d) != null || target.aM() < 1.0f) {
                    if (target.aM() <= 3.0f) {
                        this.makeRedMagicTrail(worldObj, player.u, player.v + player.f(), player.w, target.u, target.v + target.f(), target.w);
                        if (target instanceof of) {
                            ((of)target).q();
                        }
                        worldObj.a((nm)target, "damage.fallbig", 1.0f, ((ItemTFLifeDrainWand.f.nextFloat() - ItemTFLifeDrainWand.f.nextFloat()) * 0.7f + 1.0f) * 2.0f);
                        animateTargetShatter(worldObj, target);
                        if (!worldObj.I) {
                            target.w();
                            target.a(na.b((nm)player, (nm)player));
                        }
                        player.bs();
                    }
                    else if (!worldObj.I) {
                        target.a(na.b((nm)player, (nm)player), 3.0f);
                        if (this.getMaxHealth(target) <= this.getMaxHealth((oe)player)) {
                            target.x = 0.0;
                            target.y = 0.2;
                            target.z = 0.0;
                        }
                        target.c(new ni(nh.d.H, 20, 2));
                        if (count % 10 == 0) {
                            player.f(1.0f);
                            player.bH().a(1, 0.1f);
                        }
                    }
                }
                else {
                    this.makeRedMagicTrail(worldObj, player.u, player.v + player.f(), player.w, target.u, target.v + target.f(), target.w);
                    worldObj.a((nm)player, "fire.ignite", 1.0f, (worldObj.s.nextFloat() - worldObj.s.nextFloat()) * 0.2f + 1.0f);
                    if (!worldObj.I) {
                        target.a(na.b((nm)player, (nm)player), 1.0f);
                        if (this.getMaxHealth(target) <= this.getMaxHealth((oe)player)) {
                            target.x = 0.0;
                            target.y = 0.2;
                            target.z = 0.0;
                        }
                        target.c(new ni(nh.d.H, 20, 2));
                    }
                }
                if (!worldObj.I) {
                    stack.a(1, (oe)player);
                }
            }
        }
    }
    
    private float getMaxHealth(final oe target) {
        return (float)target.a(to.a).e();
    }
    
    protected void makeRedMagicTrail(final abv worldObj, final double srcX, final double srcY, final double srcZ, final double destX, final double destY, final double destZ) {
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
    
    public int d_(final yd par1ItemStack) {
        return 72000;
    }
    
    public zi c_(final yd par1ItemStack) {
        return zi.e;
    }
    
    @Override
    public yp f(final yd par1ItemStack) {
        return yp.c;
    }
    
    @SideOnly(Side.CLIENT)
    public void a(final yd par1ItemStack, final ue par2EntityPlayer, final List par3List, final boolean par4) {
        super.a(par1ItemStack, par2EntityPlayer, par3List, par4);
        par3List.add(par1ItemStack.l() - par1ItemStack.k() + " charges left");
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void a(final ms par1IconRegister) {
        this.cz = par1IconRegister.a("TwilightForest:" + this.a().substring(5));
    }
}
