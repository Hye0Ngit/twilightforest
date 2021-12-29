// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.ActionResult;
import javax.annotation.Nonnull;
import net.minecraft.world.World;
import java.util.UUID;
import net.minecraft.entity.Entity;
import twilightforest.TFSounds;
import twilightforest.TwilightForestMod;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.world.IServerWorld;
import net.minecraft.entity.MobEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import twilightforest.entity.TFEntities;
import java.util.HashMap;
import net.minecraft.entity.EntityType;
import java.util.Map;
import net.minecraft.item.Item;

public class TransformPowderItem extends Item
{
    private final Map<EntityType<?>, EntityType<?>> transformMap;
    
    protected TransformPowderItem(final Item.Properties props) {
        super(props);
        this.transformMap = new HashMap<EntityType<?>, EntityType<?>>();
    }
    
    public void initTransformations() {
        this.addTwoWayTransformation(TFEntities.minotaur, (EntityType<?>)EntityType.field_233592_ba_);
        this.addTwoWayTransformation(TFEntities.deer, (EntityType<?>)EntityType.field_200796_j);
        this.addTwoWayTransformation(TFEntities.bighorn_sheep, (EntityType<?>)EntityType.field_200737_ac);
        this.addTwoWayTransformation(TFEntities.wild_boar, (EntityType<?>)EntityType.field_200784_X);
        this.addTwoWayTransformation(TFEntities.bunny, (EntityType<?>)EntityType.field_200736_ab);
        this.addTwoWayTransformation(TFEntities.tiny_bird, (EntityType<?>)EntityType.field_200783_W);
        this.addTwoWayTransformation(TFEntities.raven, (EntityType<?>)EntityType.field_200791_e);
        this.addTwoWayTransformation(TFEntities.hostile_wolf, (EntityType<?>)EntityType.field_200724_aC);
        this.addTwoWayTransformation(TFEntities.penguin, (EntityType<?>)EntityType.field_200795_i);
        this.addTwoWayTransformation(TFEntities.hedge_spider, (EntityType<?>)EntityType.field_200748_an);
        this.addTwoWayTransformation(TFEntities.swarm_spider, (EntityType<?>)EntityType.field_200794_h);
        this.addTwoWayTransformation(TFEntities.wraith, (EntityType<?>)EntityType.field_200792_f);
        this.addTwoWayTransformation(TFEntities.redcap, (EntityType<?>)EntityType.field_200756_av);
        this.addTwoWayTransformation(TFEntities.skeleton_druid, (EntityType<?>)EntityType.field_200759_ay);
    }
    
    private void addTwoWayTransformation(final EntityType<?> from, final EntityType<?> to) {
        this.transformMap.put(from, to);
        this.transformMap.put(to, from);
    }
    
    public ActionResultType func_111207_a(final ItemStack stack, final PlayerEntity player, final LivingEntity target, final Hand hand) {
        if (!target.func_70089_S()) {
            return ActionResultType.PASS;
        }
        final EntityType<?> type = this.transformMap.get(target.func_200600_R());
        if (type == null) {
            return ActionResultType.PASS;
        }
        final Entity newEntity = type.func_200721_a(player.field_70170_p);
        if (newEntity == null) {
            return ActionResultType.PASS;
        }
        newEntity.func_70012_b(target.func_226277_ct_(), target.func_226278_cu_(), target.func_226281_cx_(), target.field_70177_z, target.field_70125_A);
        if (newEntity instanceof MobEntity && target.field_70170_p instanceof IServerWorld) {
            final IServerWorld world = (IServerWorld)target.field_70170_p;
            ((MobEntity)newEntity).func_213386_a(world, target.field_70170_p.func_175649_E(target.func_233580_cy_()), SpawnReason.CONVERSION, (ILivingEntityData)null, (CompoundNBT)null);
        }
        try {
            final UUID uuid = newEntity.func_110124_au();
            newEntity.func_70020_e(target.func_189511_e(newEntity.func_189511_e(new CompoundNBT())));
            newEntity.func_184221_a(uuid);
        }
        catch (Exception e) {
            TwilightForestMod.LOGGER.warn("Couldn't transform entity NBT data", (Throwable)e);
        }
        target.field_70170_p.func_217376_c(newEntity);
        target.func_70106_y();
        stack.func_190918_g(1);
        if (target instanceof MobEntity) {
            ((MobEntity)target).func_70656_aK();
            ((MobEntity)target).func_70656_aK();
        }
        target.func_184185_a(TFSounds.POWDER_USE, 1.0f + TransformPowderItem.field_77697_d.nextFloat(), TransformPowderItem.field_77697_d.nextFloat() * 0.7f + 0.3f);
        return ActionResultType.SUCCESS;
    }
    
    @Nonnull
    public ActionResult<ItemStack> func_77659_a(final World world, final PlayerEntity player, @Nonnull final Hand hand) {
        if (world.field_72995_K) {
            final AxisAlignedBB area = this.getEffectAABB(player);
            for (int i = 0; i < 30; ++i) {
                world.func_195594_a((IParticleData)ParticleTypes.field_197614_g, area.field_72340_a + world.field_73012_v.nextFloat() * (area.field_72336_d - area.field_72340_a), area.field_72338_b + world.field_73012_v.nextFloat() * (area.field_72337_e - area.field_72338_b), area.field_72339_c + world.field_73012_v.nextFloat() * (area.field_72334_f - area.field_72339_c), 0.0, 0.0, 0.0);
            }
        }
        return (ActionResult<ItemStack>)new ActionResult(ActionResultType.SUCCESS, (Object)player.func_184586_b(hand));
    }
    
    private AxisAlignedBB getEffectAABB(final PlayerEntity player) {
        final double range = 2.0;
        final double radius = 1.0;
        final Vector3d srcVec = new Vector3d(player.func_226277_ct_(), player.func_226278_cu_() + player.func_70047_e(), player.func_226281_cx_());
        final Vector3d lookVec = player.func_70040_Z();
        final Vector3d destVec = srcVec.func_72441_c(lookVec.field_72450_a * range, lookVec.field_72448_b * range, lookVec.field_72449_c * range);
        return new AxisAlignedBB(destVec.field_72450_a - radius, destVec.field_72448_b - radius, destVec.field_72449_c - radius, destVec.field_72450_a + radius, destVec.field_72448_b + radius, destVec.field_72449_c + radius);
    }
}
