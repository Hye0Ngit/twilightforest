// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.client.renderer.texture.IIconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.EnumAction;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.EntityLiving;
import net.minecraft.potion.Potion;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.AxisAlignedBB;
import java.util.Iterator;
import java.util.List;
import net.minecraft.util.Vec3;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.init.Items;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;

public class ItemTFScepterLifeDrain extends ItemTF
{
    protected ItemTFScepterLifeDrain() {
        this.field_77777_bU = 1;
        this.func_77656_e(99);
        this.func_77637_a((CreativeTabs)TFItems.creativeTab);
    }
    
    public ItemStack func_77659_a(final ItemStack par1ItemStack, final World worldObj, final EntityPlayer player) {
        if (par1ItemStack.func_77960_j() < this.func_77612_l()) {
            player.func_71008_a(par1ItemStack, this.func_77626_a(par1ItemStack));
        }
        else {
            player.func_71034_by();
        }
        return par1ItemStack;
    }
    
    public static void animateTargetShatter(final World worldObj, final EntityLivingBase target) {
        for (int var1 = 0; var1 < 50; ++var1) {
            final double gaussX = ItemTFScepterLifeDrain.field_77697_d.nextGaussian() * 0.02;
            final double gaussY = ItemTFScepterLifeDrain.field_77697_d.nextGaussian() * 0.02;
            final double gaussZ = ItemTFScepterLifeDrain.field_77697_d.nextGaussian() * 0.02;
            final double gaussFactor = 10.0;
            final Item popItem = (getTargetDropItemId(target) != null) ? getTargetDropItemId(target) : Items.field_151078_bh;
            worldObj.func_72869_a("iconcrack_" + Item.func_150891_b(popItem), target.field_70165_t + ItemTFScepterLifeDrain.field_77697_d.nextFloat() * target.field_70130_N * 2.0f - target.field_70130_N - gaussX * gaussFactor, target.field_70163_u + ItemTFScepterLifeDrain.field_77697_d.nextFloat() * target.field_70131_O - gaussY * gaussFactor, target.field_70161_v + ItemTFScepterLifeDrain.field_77697_d.nextFloat() * target.field_70130_N * 2.0f - target.field_70130_N - gaussZ * gaussFactor, gaussX, gaussY, gaussZ);
        }
    }
    
    public static Item getTargetDropItemId(final EntityLivingBase target) {
        return Items.field_151078_bh;
    }
    
    private Entity getPlayerLookTarget(final World worldObj, final EntityPlayer player) {
        Entity pointedEntity = null;
        final double range = 20.0;
        final Vec3 srcVec = Vec3.func_72443_a(player.field_70165_t, player.field_70163_u + player.func_70047_e(), player.field_70161_v);
        final Vec3 lookVec = player.func_70676_i(1.0f);
        final Vec3 destVec = srcVec.func_72441_c(lookVec.field_72450_a * range, lookVec.field_72448_b * range, lookVec.field_72449_c * range);
        final float var9 = 1.0f;
        final List<Entity> possibleList = worldObj.func_72839_b((Entity)player, player.field_70121_D.func_72321_a(lookVec.field_72450_a * range, lookVec.field_72448_b * range, lookVec.field_72449_c * range).func_72314_b((double)var9, (double)var9, (double)var9));
        double hitDist = 0.0;
        for (final Entity possibleEntity : possibleList) {
            if (possibleEntity.func_70067_L()) {
                final float borderSize = possibleEntity.func_70111_Y();
                final AxisAlignedBB collisionBB = possibleEntity.field_70121_D.func_72314_b((double)borderSize, (double)borderSize, (double)borderSize);
                final MovingObjectPosition interceptPos = collisionBB.func_72327_a(srcVec, destVec);
                if (collisionBB.func_72318_a(srcVec)) {
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
                    final double possibleDist = srcVec.func_72438_d(interceptPos.field_72307_f);
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
    
    public void onUsingTick(final ItemStack stack, final EntityPlayer player, final int count) {
        final World worldObj = player.field_70170_p;
        if (stack.func_77960_j() >= this.func_77612_l()) {
            player.func_71034_by();
            return;
        }
        if (count % 5 == 0) {
            final Entity pointedEntity = this.getPlayerLookTarget(worldObj, player);
            if (pointedEntity != null && pointedEntity instanceof EntityLivingBase) {
                final EntityLivingBase target = (EntityLivingBase)pointedEntity;
                if (target.func_70660_b(Potion.field_76421_d) != null || target.func_110143_aJ() < 1.0f) {
                    if (target.func_110143_aJ() <= 3.0f) {
                        this.makeRedMagicTrail(worldObj, player.field_70165_t, player.field_70163_u + player.func_70047_e(), player.field_70161_v, target.field_70165_t, target.field_70163_u + target.func_70047_e(), target.field_70161_v);
                        if (target instanceof EntityLiving) {
                            ((EntityLiving)target).func_70656_aK();
                        }
                        worldObj.func_72956_a((Entity)target, "game.player.hurt.fall.big", 1.0f, ((ItemTFScepterLifeDrain.field_77697_d.nextFloat() - ItemTFScepterLifeDrain.field_77697_d.nextFloat()) * 0.7f + 1.0f) * 2.0f);
                        animateTargetShatter(worldObj, target);
                        if (!worldObj.field_72995_K) {
                            target.func_70106_y();
                            target.func_70645_a(DamageSource.func_76354_b((Entity)player, (Entity)player));
                        }
                        player.func_71034_by();
                    }
                    else if (!worldObj.field_72995_K) {
                        target.func_70097_a(DamageSource.func_76354_b((Entity)player, (Entity)player), 3.0f);
                        if (this.getMaxHealth(target) <= this.getMaxHealth((EntityLivingBase)player)) {
                            target.field_70159_w = 0.0;
                            target.field_70181_x = 0.2;
                            target.field_70179_y = 0.0;
                        }
                        target.func_70690_d(new PotionEffect(Potion.field_76421_d.field_76415_H, 20, 2));
                        if (count % 10 == 0) {
                            player.func_70691_i(1.0f);
                            player.func_71024_bL().func_75122_a(1, 0.1f);
                        }
                    }
                }
                else {
                    this.makeRedMagicTrail(worldObj, player.field_70165_t, player.field_70163_u + player.func_70047_e(), player.field_70161_v, target.field_70165_t, target.field_70163_u + target.func_70047_e(), target.field_70161_v);
                    worldObj.func_72956_a((Entity)player, "fire.ignite", 1.0f, (worldObj.field_73012_v.nextFloat() - worldObj.field_73012_v.nextFloat()) * 0.2f + 1.0f);
                    if (!worldObj.field_72995_K) {
                        target.func_70097_a(DamageSource.func_76354_b((Entity)player, (Entity)player), 1.0f);
                        if (this.getMaxHealth(target) <= this.getMaxHealth((EntityLivingBase)player)) {
                            target.field_70159_w = 0.0;
                            target.field_70181_x = 0.2;
                            target.field_70179_y = 0.0;
                        }
                        target.func_70690_d(new PotionEffect(Potion.field_76421_d.field_76415_H, 20, 2));
                    }
                }
                if (!worldObj.field_72995_K) {
                    stack.func_77972_a(1, (EntityLivingBase)player);
                }
            }
        }
    }
    
    private float getMaxHealth(final EntityLivingBase target) {
        return (float)target.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111125_b();
    }
    
    protected void makeRedMagicTrail(final World worldObj, final double srcX, final double srcY, final double srcZ, final double destX, final double destY, final double destZ) {
        for (int particles = 32, i = 0; i < particles; ++i) {
            final double trailFactor = i / (particles - 1.0);
            final float f = 1.0f;
            final float f2 = 0.5f;
            final float f3 = 0.5f;
            final double tx = srcX + (destX - srcX) * trailFactor + worldObj.field_73012_v.nextGaussian() * 0.005;
            final double ty = srcY + (destY - srcY) * trailFactor + worldObj.field_73012_v.nextGaussian() * 0.005;
            final double tz = srcZ + (destZ - srcZ) * trailFactor + worldObj.field_73012_v.nextGaussian() * 0.005;
            worldObj.func_72869_a("mobSpell", tx, ty, tz, (double)f, (double)f2, (double)f3);
        }
    }
    
    public int func_77626_a(final ItemStack par1ItemStack) {
        return 72000;
    }
    
    public EnumAction func_77661_b(final ItemStack par1ItemStack) {
        return EnumAction.bow;
    }
    
    @Override
    public EnumRarity func_77613_e(final ItemStack par1ItemStack) {
        return EnumRarity.rare;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_77624_a(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final List par3List, final boolean par4) {
        super.func_77624_a(par1ItemStack, par2EntityPlayer, par3List, par4);
        par3List.add(par1ItemStack.func_77958_k() - par1ItemStack.func_77960_j() + " charges left");
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void func_94581_a(final IIconRegister par1IconRegister) {
        this.field_77791_bV = par1IconRegister.func_94245_a("TwilightForest:" + this.func_77658_a().substring(5));
    }
}
