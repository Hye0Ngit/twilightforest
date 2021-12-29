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
import twilightforest.entity.passive.EntityTFPenguin;
import twilightforest.entity.EntityTFHostileWolf;
import twilightforest.entity.passive.EntityTFRaven;
import twilightforest.entity.passive.EntityTFBoar;
import twilightforest.entity.passive.EntityTFBighorn;
import twilightforest.entity.passive.EntityTFDeer;
import twilightforest.entity.EntityTFMinotaur;
import java.util.HashMap;

public class ItemTFTransformPowder extends ItemTF
{
    HashMap transformMap;
    
    protected ItemTFTransformPowder(final int par1) {
        super(par1);
        this.cw = 64;
        this.a((wv)TFItems.creativeTab);
        this.transformMap = new HashMap();
        this.addTwoWayTransformation(EntityTFMinotaur.class, tm.class);
        this.addTwoWayTransformation(EntityTFDeer.class, rq.class);
        this.addTwoWayTransformation(EntityTFBighorn.class, ry.class);
        this.addTwoWayTransformation(EntityTFBoar.class, rx.class);
        this.addTwoWayTransformation(EntityTFRaven.class, rn.class);
        this.addTwoWayTransformation(EntityTFHostileWolf.class, se.class);
        this.addTwoWayTransformation(EntityTFPenguin.class, rp.class);
        this.addTwoWayTransformation(EntityTFHedgeSpider.class, ts.class);
        this.addTwoWayTransformation(EntityTFSwarmSpider.class, td.class);
        this.addTwoWayTransformation(EntityTFWraith.class, tc.class);
        this.addTwoWayTransformation(EntityTFRedcap.class, ua.class);
        this.addTwoWayTransformation(EntityTFSkeletonDruid.class, tu.class);
    }
    
    public void addTwoWayTransformation(final Class class1, final Class class2) {
        this.transformMap.put(class1, class2);
        this.transformMap.put(class2, class1);
    }
    
    public boolean a(final yd par1ItemStack, final ue par2EntityPlayer, final oe target) {
        final Class transformClass = this.getMonsterTransform(target.getClass());
        if (transformClass != null) {
            if (target.q.I) {
                if (target instanceof of) {
                    ((of)target).q();
                    ((of)target).q();
                }
                target.q.a(target.u + 0.5, target.v + 0.5, target.w + 0.5, "mob.zombie.remedy", 1.0f + ItemTFTransformPowder.f.nextFloat(), ItemTFTransformPowder.f.nextFloat() * 0.7f + 0.3f, false);
            }
            else {
                oe newMonster = null;
                try {
                    newMonster = transformClass.getConstructor(abv.class).newInstance(target.q);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
                if (newMonster == null) {
                    return false;
                }
                newMonster.a(target.u, target.v, target.w, target.A, target.B);
                target.q.d((nm)newMonster);
                target.w();
            }
            --par1ItemStack.b;
            return true;
        }
        return false;
    }
    
    public yd a(final yd par1ItemStack, final abv world, final ue player) {
        if (world.I) {
            final asu fanBox = this.getEffectAABB(world, player);
            final asz lookVec = player.Z();
            for (int i = 0; i < 30; ++i) {
                world.a("magicCrit", fanBox.a + world.s.nextFloat() * (fanBox.d - fanBox.a), fanBox.b + world.s.nextFloat() * (fanBox.e - fanBox.b), fanBox.c + world.s.nextFloat() * (fanBox.f - fanBox.c), 0.0, 0.0, 0.0);
            }
        }
        return par1ItemStack;
    }
    
    private asu getEffectAABB(final abv world, final ue player) {
        final double range = 2.0;
        final double radius = 1.0;
        final asz srcVec = world.V().a(player.u, player.v + player.f(), player.w);
        final asz lookVec = player.Z();
        final asz destVec = srcVec.c(lookVec.c * range, lookVec.d * range, lookVec.e * range);
        return asu.a().a(destVec.c - radius, destVec.d - radius, destVec.e - radius, destVec.c + radius, destVec.d + radius, destVec.e + radius);
    }
    
    public Class getMonsterTransform(final Class originalMonster) {
        return this.transformMap.get(originalMonster);
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void a(final ms par1IconRegister) {
        this.cz = par1IconRegister.a("TwilightForest:" + this.a().substring(5));
    }
}
