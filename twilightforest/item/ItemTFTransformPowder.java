// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import twilightforest.entity.EntityTFSkeletonDruid;
import twilightforest.entity.EntityTFRedcap;
import twilightforest.entity.EntityTFWraith;
import twilightforest.entity.EntityTFSwarmSpider;
import twilightforest.entity.EntityTFHedgeSpider;
import twilightforest.entity.EntityTFPenguin;
import twilightforest.entity.EntityTFHostileWolf;
import twilightforest.entity.EntityTFRaven;
import twilightforest.entity.EntityTFBoar;
import twilightforest.entity.EntityTFBighorn;
import twilightforest.entity.EntityTFDeer;
import twilightforest.entity.EntityTFMinotaur;
import java.util.HashMap;

public class ItemTFTransformPowder extends ItemTF
{
    HashMap transformMap;
    
    protected ItemTFTransformPowder(final int par1) {
        super(par1);
        this.ck = 64;
        this.a((tj)TFItems.creativeTab);
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
    
    public boolean a(final ur par1ItemStack, final md target) {
        final Class transformClass = this.getMonsterTransform(target.getClass());
        if (transformClass != null) {
            if (target.p.I) {
                target.aR();
                target.aR();
                target.p.a(target.t + 0.5, target.u + 0.5, target.v + 0.5, "mob.zombie.remedy", 1.0f + ItemTFTransformPowder.d.nextFloat(), ItemTFTransformPowder.d.nextFloat() * 0.7f + 0.3f, false);
            }
            else {
                md newMonster = null;
                try {
                    newMonster = transformClass.getConstructor(yc.class).newInstance(target.p);
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
    
    public ur a(final ur par1ItemStack, final yc world, final qx player) {
        if (world.I) {
            final aoe fanBox = this.getEffectAABB(world, player);
            final aoj lookVec = player.Z();
            for (int i = 0; i < 30; ++i) {
                world.a("magicCrit", fanBox.a + world.t.nextFloat() * (fanBox.d - fanBox.a), fanBox.b + world.t.nextFloat() * (fanBox.e - fanBox.b), fanBox.c + world.t.nextFloat() * (fanBox.f - fanBox.c), 0.0, 0.0, 0.0);
            }
        }
        return par1ItemStack;
    }
    
    private aoe getEffectAABB(final yc world, final qx player) {
        final double range = 2.0;
        final double radius = 1.0;
        final aoj srcVec = world.S().a(player.t, player.u + player.e(), player.v);
        final aoj lookVec = player.Z();
        final aoj destVec = srcVec.c(lookVec.c * range, lookVec.d * range, lookVec.e * range);
        return aoe.a().a(destVec.c - radius, destVec.d - radius, destVec.e - radius, destVec.c + radius, destVec.d + radius, destVec.e + radius);
    }
    
    public Class getMonsterTransform(final Class originalMonster) {
        return this.transformMap.get(originalMonster);
    }
}
