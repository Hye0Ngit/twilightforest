// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.HashMap;

public class ItemTFTransformPowder extends ItemTF
{
    HashMap transformMap;
    
    protected ItemTFTransformPowder(final int par1) {
        super(par1);
        this.ch = 64;
        this.a(th.i);
        this.transformMap = new HashMap();
        this.addTwoWayTransformation(EntityTFMinotaur.class, qk.class);
        this.addTwoWayTransformation(EntityTFDeer.class, oz.class);
        this.addTwoWayTransformation(EntityTFBighorn.class, pe.class);
        this.addTwoWayTransformation(EntityTFBoar.class, pd.class);
        this.addTwoWayTransformation(EntityTFRaven.class, ow.class);
        this.addTwoWayTransformation(EntityTFHostileWolf.class, pk.class);
        this.addTwoWayTransformation(EntityTFPenguin.class, oy.class);
        this.addTwoWayTransformation(EntityTFHedgeSpider.class, qp.class);
        this.addTwoWayTransformation(EntityTFSwarmSpider.class, qb.class);
        this.addTwoWayTransformation(EntityTFWraith.class, qa.class);
        this.addTwoWayTransformation(EntityTFRedcap.class, qu.class);
        this.addTwoWayTransformation(EntityTFSkeletonDruid.class, qq.class);
    }
    
    public void addTwoWayTransformation(final Class class1, final Class class2) {
        this.transformMap.put(class1, class2);
        this.transformMap.put(class2, class1);
    }
    
    public boolean a(final um par1ItemStack, final md target) {
        final Class transformClass = this.getMonsterTransform(target.getClass());
        if (transformClass != null) {
            if (target.p.J) {
                target.aR();
                target.aR();
                target.p.b(target.t + 0.5, target.u + 0.5, target.v + 0.5, "mob.zombie.remedy", 1.0f + ItemTFTransformPowder.d.nextFloat(), ItemTFTransformPowder.d.nextFloat() * 0.7f + 0.3f);
            }
            else {
                md newMonster = null;
                try {
                    newMonster = transformClass.getConstructor(xv.class).newInstance(target.p);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
                if (newMonster == null) {
                    return false;
                }
                newMonster.a(target.t, target.u, target.v, target.z, target.A);
                newMonster.bG();
                target.p.d((lq)newMonster);
                target.x();
            }
            --par1ItemStack.a;
            return true;
        }
        return false;
    }
    
    public um a(final um par1ItemStack, final xv world, final qx player) {
        if (world.J) {
            final anw fanBox = this.getEffectAABB(world, player);
            final aob lookVec = player.Z();
            for (int i = 0; i < 30; ++i) {
                world.a("magicCrit", fanBox.a + world.u.nextFloat() * (fanBox.d - fanBox.a), fanBox.b + world.u.nextFloat() * (fanBox.e - fanBox.b), fanBox.c + world.u.nextFloat() * (fanBox.f - fanBox.c), 0.0, 0.0, 0.0);
            }
        }
        return par1ItemStack;
    }
    
    private anw getEffectAABB(final xv world, final qx player) {
        final double range = 2.0;
        final double radius = 1.0;
        final aob srcVec = world.S().a(player.t, player.u + player.e(), player.v);
        final aob lookVec = player.Z();
        final aob destVec = srcVec.c(lookVec.c * range, lookVec.d * range, lookVec.e * range);
        return anw.a().a(destVec.c - radius, destVec.d - radius, destVec.e - radius, destVec.c + radius, destVec.d + radius, destVec.e + radius);
    }
    
    public Class getMonsterTransform(final Class originalMonster) {
        return this.transformMap.get(originalMonster);
    }
}
