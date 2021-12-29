// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ActionResult;
import javax.annotation.Nonnull;
import net.minecraft.world.World;
import java.util.UUID;
import net.minecraft.init.SoundEvents;
import twilightforest.TwilightForestMod;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.util.EnumHand;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import twilightforest.util.VanillaEntityNames;
import twilightforest.util.TFEntityNames;
import net.minecraft.creativetab.CreativeTabs;
import java.util.HashMap;
import net.minecraft.util.ResourceLocation;
import java.util.Map;

public class ItemTFTransformPowder extends ItemTF
{
    private final Map<ResourceLocation, ResourceLocation> transformMap;
    
    protected ItemTFTransformPowder() {
        this.transformMap = new HashMap<ResourceLocation, ResourceLocation>();
        this.field_77777_bU = 64;
        this.func_77637_a((CreativeTabs)TFItems.creativeTab);
        this.addTwoWayTransformation(TFEntityNames.MINOTAUR, VanillaEntityNames.ZOMBIE_PIGMAN);
        this.addTwoWayTransformation(TFEntityNames.DEER, VanillaEntityNames.COW);
        this.addTwoWayTransformation(TFEntityNames.BIGHORN_SHEEP, VanillaEntityNames.SHEEP);
        this.addTwoWayTransformation(TFEntityNames.WILD_BOAR, VanillaEntityNames.PIG);
        this.addTwoWayTransformation(TFEntityNames.BUNNY, VanillaEntityNames.RABBIT);
        this.addTwoWayTransformation(TFEntityNames.TINY_BIRD, VanillaEntityNames.PARROT);
        this.addTwoWayTransformation(TFEntityNames.RAVEN, VanillaEntityNames.BAT);
        this.addTwoWayTransformation(TFEntityNames.HOSTILE_WOLF, VanillaEntityNames.WOLF);
        this.addTwoWayTransformation(TFEntityNames.PENGUIN, VanillaEntityNames.CHICKEN);
        this.addTwoWayTransformation(TFEntityNames.HEDGE_SPIDER, VanillaEntityNames.SPIDER);
        this.addTwoWayTransformation(TFEntityNames.SWARM_SPIDER, VanillaEntityNames.CAVE_SPIDER);
        this.addTwoWayTransformation(TFEntityNames.WRAITH, VanillaEntityNames.BLAZE);
        this.addTwoWayTransformation(TFEntityNames.REDCAP, VanillaEntityNames.VILLAGER);
        this.addTwoWayTransformation(TFEntityNames.SKELETON_DRUID, VanillaEntityNames.WITCH);
    }
    
    private void addTwoWayTransformation(final ResourceLocation from, final ResourceLocation to) {
        this.transformMap.put(from, to);
        this.transformMap.put(to, from);
    }
    
    public boolean func_111207_a(final ItemStack stack, final EntityPlayer player, final EntityLivingBase target, final EnumHand hand) {
        if (target.field_70128_L) {
            return false;
        }
        final ResourceLocation location = this.transformMap.get(EntityList.func_191301_a((Entity)target));
        if (location == null) {
            return false;
        }
        if (target.field_70170_p.field_72995_K) {
            return EntityList.func_180125_b(location);
        }
        final Entity newEntity = EntityList.func_188429_b(location, target.field_70170_p);
        if (newEntity == null) {
            return false;
        }
        newEntity.func_70012_b(target.field_70165_t, target.field_70163_u, target.field_70161_v, target.field_70177_z, target.field_70125_A);
        if (newEntity instanceof EntityLiving) {
            ((EntityLiving)newEntity).func_180482_a(target.field_70170_p.func_175649_E(new BlockPos((Entity)target)), (IEntityLivingData)null);
        }
        try {
            final UUID uuid = newEntity.func_110124_au();
            newEntity.func_70020_e(target.func_189511_e(newEntity.func_189511_e(new NBTTagCompound())));
            newEntity.func_184221_a(uuid);
        }
        catch (Exception e) {
            TwilightForestMod.LOGGER.warn("Couldn't transform entity NBT data: {}", (Throwable)e);
        }
        target.field_70170_p.func_72838_d(newEntity);
        target.func_70106_y();
        stack.func_190918_g(1);
        if (target instanceof EntityLiving) {
            ((EntityLiving)target).func_70656_aK();
            ((EntityLiving)target).func_70656_aK();
        }
        target.func_184185_a(SoundEvents.field_187942_hp, 1.0f + ItemTFTransformPowder.field_77697_d.nextFloat(), ItemTFTransformPowder.field_77697_d.nextFloat() * 0.7f + 0.3f);
        return true;
    }
    
    @Nonnull
    public ActionResult<ItemStack> func_77659_a(final World world, final EntityPlayer player, @Nonnull final EnumHand hand) {
        if (world.field_72995_K) {
            final AxisAlignedBB fanBox = this.getEffectAABB(player);
            for (int i = 0; i < 30; ++i) {
                world.func_175688_a(EnumParticleTypes.CRIT_MAGIC, fanBox.field_72340_a + world.field_73012_v.nextFloat() * (fanBox.field_72336_d - fanBox.field_72340_a), fanBox.field_72338_b + world.field_73012_v.nextFloat() * (fanBox.field_72337_e - fanBox.field_72338_b), fanBox.field_72339_c + world.field_73012_v.nextFloat() * (fanBox.field_72334_f - fanBox.field_72339_c), 0.0, 0.0, 0.0, new int[0]);
            }
        }
        return (ActionResult<ItemStack>)ActionResult.newResult(EnumActionResult.SUCCESS, (Object)player.func_184586_b(hand));
    }
    
    private AxisAlignedBB getEffectAABB(final EntityPlayer player) {
        final double range = 2.0;
        final double radius = 1.0;
        final Vec3d srcVec = new Vec3d(player.field_70165_t, player.field_70163_u + player.func_70047_e(), player.field_70161_v);
        final Vec3d lookVec = player.func_70040_Z();
        final Vec3d destVec = srcVec.func_72441_c(lookVec.field_72450_a * range, lookVec.field_72448_b * range, lookVec.field_72449_c * range);
        return new AxisAlignedBB(destVec.field_72450_a - radius, destVec.field_72448_b - radius, destVec.field_72449_c - radius, destVec.field_72450_a + radius, destVec.field_72448_b + radius, destVec.field_72449_c + radius);
    }
}
