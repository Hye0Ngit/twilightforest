// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Vec3;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.monster.EntityWitch;
import twilightforest.entity.EntityTFSkeletonDruid;
import net.minecraft.entity.passive.EntityVillager;
import twilightforest.entity.EntityTFRedcap;
import net.minecraft.entity.monster.EntityBlaze;
import twilightforest.entity.EntityTFWraith;
import net.minecraft.entity.monster.EntityCaveSpider;
import twilightforest.entity.EntityTFSwarmSpider;
import net.minecraft.entity.monster.EntitySpider;
import twilightforest.entity.EntityTFHedgeSpider;
import net.minecraft.entity.passive.EntityChicken;
import twilightforest.entity.passive.EntityTFPenguin;
import net.minecraft.entity.passive.EntityWolf;
import twilightforest.entity.EntityTFHostileWolf;
import net.minecraft.entity.passive.EntityBat;
import twilightforest.entity.passive.EntityTFRaven;
import net.minecraft.entity.passive.EntityPig;
import twilightforest.entity.passive.EntityTFBoar;
import net.minecraft.entity.passive.EntitySheep;
import twilightforest.entity.passive.EntityTFBighorn;
import net.minecraft.entity.passive.EntityCow;
import twilightforest.entity.passive.EntityTFDeer;
import net.minecraft.entity.monster.EntityPigZombie;
import twilightforest.entity.EntityTFMinotaur;
import net.minecraft.creativetab.CreativeTabs;
import java.util.HashMap;

public class ItemTFTransformPowder extends ItemTF
{
    HashMap transformMap;
    
    protected ItemTFTransformPowder(final int par1) {
        super(par1);
        this.field_77777_bU = 64;
        this.func_77637_a((CreativeTabs)TFItems.creativeTab);
        this.transformMap = new HashMap();
        this.addTwoWayTransformation(EntityTFMinotaur.class, EntityPigZombie.class);
        this.addTwoWayTransformation(EntityTFDeer.class, EntityCow.class);
        this.addTwoWayTransformation(EntityTFBighorn.class, EntitySheep.class);
        this.addTwoWayTransformation(EntityTFBoar.class, EntityPig.class);
        this.addTwoWayTransformation(EntityTFRaven.class, EntityBat.class);
        this.addTwoWayTransformation(EntityTFHostileWolf.class, EntityWolf.class);
        this.addTwoWayTransformation(EntityTFPenguin.class, EntityChicken.class);
        this.addTwoWayTransformation(EntityTFHedgeSpider.class, EntitySpider.class);
        this.addTwoWayTransformation(EntityTFSwarmSpider.class, EntityCaveSpider.class);
        this.addTwoWayTransformation(EntityTFWraith.class, EntityBlaze.class);
        this.addTwoWayTransformation(EntityTFRedcap.class, EntityVillager.class);
        this.addTwoWayTransformation(EntityTFSkeletonDruid.class, EntityWitch.class);
    }
    
    public void addTwoWayTransformation(final Class class1, final Class class2) {
        this.transformMap.put(class1, class2);
        this.transformMap.put(class2, class1);
    }
    
    public boolean func_111207_a(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final EntityLivingBase target) {
        final Class transformClass = this.getMonsterTransform(target.getClass());
        if (transformClass != null) {
            if (target.field_70170_p.field_72995_K) {
                if (target instanceof EntityLiving) {
                    ((EntityLiving)target).func_70656_aK();
                    ((EntityLiving)target).func_70656_aK();
                }
                target.field_70170_p.func_72980_b(target.field_70165_t + 0.5, target.field_70163_u + 0.5, target.field_70161_v + 0.5, "mob.zombie.remedy", 1.0f + ItemTFTransformPowder.field_77697_d.nextFloat(), ItemTFTransformPowder.field_77697_d.nextFloat() * 0.7f + 0.3f, false);
            }
            else {
                EntityLivingBase newMonster = null;
                try {
                    newMonster = transformClass.getConstructor(World.class).newInstance(target.field_70170_p);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
                if (newMonster == null) {
                    return false;
                }
                newMonster.func_70080_a(target.field_70165_t, target.field_70163_u, target.field_70161_v, target.field_70177_z, target.field_70125_A);
                target.field_70170_p.func_72838_d((Entity)newMonster);
                target.func_70106_y();
            }
            --par1ItemStack.field_77994_a;
            return true;
        }
        return false;
    }
    
    public ItemStack func_77659_a(final ItemStack par1ItemStack, final World world, final EntityPlayer player) {
        if (world.field_72995_K) {
            final AxisAlignedBB fanBox = this.getEffectAABB(world, player);
            final Vec3 lookVec = player.func_70040_Z();
            for (int i = 0; i < 30; ++i) {
                world.func_72869_a("magicCrit", fanBox.field_72340_a + world.field_73012_v.nextFloat() * (fanBox.field_72336_d - fanBox.field_72340_a), fanBox.field_72338_b + world.field_73012_v.nextFloat() * (fanBox.field_72337_e - fanBox.field_72338_b), fanBox.field_72339_c + world.field_73012_v.nextFloat() * (fanBox.field_72334_f - fanBox.field_72339_c), 0.0, 0.0, 0.0);
            }
        }
        return par1ItemStack;
    }
    
    private AxisAlignedBB getEffectAABB(final World world, final EntityPlayer player) {
        final double range = 2.0;
        final double radius = 1.0;
        final Vec3 srcVec = world.func_82732_R().func_72345_a(player.field_70165_t, player.field_70163_u + player.func_70047_e(), player.field_70161_v);
        final Vec3 lookVec = player.func_70040_Z();
        final Vec3 destVec = srcVec.func_72441_c(lookVec.field_72450_a * range, lookVec.field_72448_b * range, lookVec.field_72449_c * range);
        return AxisAlignedBB.func_72332_a().func_72299_a(destVec.field_72450_a - radius, destVec.field_72448_b - radius, destVec.field_72449_c - radius, destVec.field_72450_a + radius, destVec.field_72448_b + radius, destVec.field_72449_c + radius);
    }
    
    public Class getMonsterTransform(final Class originalMonster) {
        return this.transformMap.get(originalMonster);
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void func_94581_a(final IconRegister par1IconRegister) {
        this.field_77791_bV = par1IconRegister.func_94245_a("TwilightForest:" + this.func_77658_a().substring(5));
    }
}
