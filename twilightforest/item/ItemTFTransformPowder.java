// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
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
        this.cq = 64;
        this.a((uy)TFItems.creativeTab);
        this.transformMap = new HashMap();
        this.addTwoWayTransformation(EntityTFMinotaur.class, rw.class);
        this.addTwoWayTransformation(EntityTFDeer.class, qd.class);
        this.addTwoWayTransformation(EntityTFBighorn.class, qi.class);
        this.addTwoWayTransformation(EntityTFBoar.class, qh.class);
        this.addTwoWayTransformation(EntityTFRaven.class, qa.class);
        this.addTwoWayTransformation(EntityTFHostileWolf.class, qo.class);
        this.addTwoWayTransformation(EntityTFPenguin.class, qc.class);
        this.addTwoWayTransformation(EntityTFHedgeSpider.class, sb.class);
        this.addTwoWayTransformation(EntityTFSwarmSpider.class, rn.class);
        this.addTwoWayTransformation(EntityTFWraith.class, rm.class);
        this.addTwoWayTransformation(EntityTFRedcap.class, sg.class);
        this.addTwoWayTransformation(EntityTFSkeletonDruid.class, sc.class);
    }
    
    public void addTwoWayTransformation(final Class class1, final Class class2) {
        this.transformMap.put(class1, class2);
        this.transformMap.put(class2, class1);
    }
    
    public boolean a(final wg par1ItemStack, final ng target) {
        final Class transformClass = this.getMonsterTransform(target.getClass());
        if (transformClass != null) {
            if (target.q.I) {
                target.aU();
                target.aU();
                target.q.a(target.u + 0.5, target.v + 0.5, target.w + 0.5, "mob.zombie.remedy", 1.0f + ItemTFTransformPowder.e.nextFloat(), ItemTFTransformPowder.e.nextFloat() * 0.7f + 0.3f, false);
            }
            else {
                ng newMonster = null;
                try {
                    newMonster = transformClass.getConstructor(zv.class).newInstance(target.q);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
                if (newMonster == null) {
                    return false;
                }
                newMonster.a(target.u, target.v, target.w, target.A, target.B);
                newMonster.bJ();
                target.q.d((mp)newMonster);
                target.w();
            }
            --par1ItemStack.a;
            return true;
        }
        return false;
    }
    
    public wg a(final wg par1ItemStack, final zv world, final sk player) {
        if (world.I) {
            final aqr fanBox = this.getEffectAABB(world, player);
            final aqw lookVec = player.Y();
            for (int i = 0; i < 30; ++i) {
                world.a("magicCrit", fanBox.a + world.s.nextFloat() * (fanBox.d - fanBox.a), fanBox.b + world.s.nextFloat() * (fanBox.e - fanBox.b), fanBox.c + world.s.nextFloat() * (fanBox.f - fanBox.c), 0.0, 0.0, 0.0);
            }
        }
        return par1ItemStack;
    }
    
    private aqr getEffectAABB(final zv world, final sk player) {
        final double range = 2.0;
        final double radius = 1.0;
        final aqw srcVec = world.T().a(player.u, player.v + player.e(), player.w);
        final aqw lookVec = player.Y();
        final aqw destVec = srcVec.c(lookVec.c * range, lookVec.d * range, lookVec.e * range);
        return aqr.a().a(destVec.c - radius, destVec.d - radius, destVec.e - radius, destVec.c + radius, destVec.d + radius, destVec.e + radius);
    }
    
    public Class getMonsterTransform(final Class originalMonster) {
        return this.transformMap.get(originalMonster);
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void a(final ly par1IconRegister) {
        this.ct = par1IconRegister.a("twilightforest:" + this.a().substring(5));
    }
}
