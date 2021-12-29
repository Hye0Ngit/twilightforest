// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import java.util.HashMap;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.InteractionResultHolder;
import javax.annotation.Nonnull;
import java.util.UUID;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import twilightforest.TFSounds;
import twilightforest.TwilightForestMod;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import twilightforest.entity.TFEntities;
import net.minecraft.world.entity.EntityType;
import java.util.Map;
import net.minecraft.world.item.Item;

public class TransformPowderItem extends Item
{
    public static final Map<EntityType<?>, EntityType<?>> transformMap;
    
    protected TransformPowderItem(final Item.Properties props) {
        super(props);
    }
    
    public void initTransformations() {
        this.addTwoWayTransformation(TFEntities.MINOTAUR, (EntityType<?>)EntityType.f_20531_);
        this.addTwoWayTransformation(TFEntities.DEER, (EntityType<?>)EntityType.f_20557_);
        this.addTwoWayTransformation(TFEntities.BIGHORN_SHEEP, (EntityType<?>)EntityType.f_20520_);
        this.addTwoWayTransformation(TFEntities.BOAR, (EntityType<?>)EntityType.f_20510_);
        this.addTwoWayTransformation(TFEntities.DWARF_RABBIT, (EntityType<?>)EntityType.f_20517_);
        this.addTwoWayTransformation(TFEntities.TINY_BIRD, (EntityType<?>)EntityType.f_20508_);
        this.addTwoWayTransformation(TFEntities.RAVEN, (EntityType<?>)EntityType.f_20549_);
        this.addTwoWayTransformation(TFEntities.HOSTILE_WOLF, (EntityType<?>)EntityType.f_20499_);
        this.addTwoWayTransformation(TFEntities.PENGUIN, (EntityType<?>)EntityType.f_20555_);
        this.addTwoWayTransformation(TFEntities.HEDGE_SPIDER, (EntityType<?>)EntityType.f_20479_);
        this.addTwoWayTransformation(TFEntities.SWARM_SPIDER, (EntityType<?>)EntityType.f_20554_);
        this.addTwoWayTransformation(TFEntities.WRAITH, (EntityType<?>)EntityType.f_20491_);
        this.addTwoWayTransformation(TFEntities.SKELETON_DRUID, (EntityType<?>)EntityType.f_20495_);
        this.addTwoWayTransformation(TFEntities.CARMINITE_GHASTGUARD, (EntityType<?>)EntityType.f_20453_);
        this.addTwoWayTransformation(TFEntities.TOWERWOOD_BORER, (EntityType<?>)EntityType.f_20523_);
        this.addTwoWayTransformation(TFEntities.MAZE_SLIME, (EntityType<?>)EntityType.f_20526_);
    }
    
    private void addTwoWayTransformation(final EntityType<?> from, final EntityType<?> to) {
        TransformPowderItem.transformMap.put(from, to);
        TransformPowderItem.transformMap.put(to, from);
    }
    
    public InteractionResult m_6880_(final ItemStack stack, final Player player, final LivingEntity target, final InteractionHand hand) {
        if (!target.m_6084_()) {
            return InteractionResult.PASS;
        }
        final EntityType<?> type = TransformPowderItem.transformMap.get(target.m_6095_());
        if (type == null) {
            return InteractionResult.PASS;
        }
        final Entity newEntity = type.m_20615_(player.f_19853_);
        if (newEntity == null) {
            return InteractionResult.PASS;
        }
        newEntity.m_7678_(target.m_20185_(), target.m_20186_(), target.m_20189_(), target.m_146908_(), target.m_146909_());
        final Entity entity = newEntity;
        if (entity instanceof final Mob mob) {
            final Level f_19853_ = target.f_19853_;
            if (f_19853_ instanceof final ServerLevelAccessor world) {
                mob.m_6518_(world, target.f_19853_.m_6436_(target.m_142538_()), MobSpawnType.CONVERSION, (SpawnGroupData)null, (CompoundTag)null);
            }
        }
        try {
            final UUID uuid = newEntity.m_142081_();
            newEntity.m_20258_(target.m_20240_(newEntity.m_20240_(new CompoundTag())));
            newEntity.m_20084_(uuid);
        }
        catch (Exception e) {
            TwilightForestMod.LOGGER.warn("Couldn't transform entity NBT data", (Throwable)e);
        }
        target.f_19853_.m_7967_(newEntity);
        target.m_146870_();
        stack.m_41774_(1);
        if (target instanceof final Mob mob2) {
            mob2.m_21373_();
            ((Mob)target).m_21373_();
        }
        target.m_5496_(TFSounds.POWDER_USE, 1.0f + target.f_19853_.f_46441_.nextFloat(), target.f_19853_.f_46441_.nextFloat() * 0.7f + 0.3f);
        return InteractionResult.SUCCESS;
    }
    
    @Nonnull
    public InteractionResultHolder<ItemStack> m_7203_(final Level world, final Player player, @Nonnull final InteractionHand hand) {
        if (world.f_46443_) {
            final AABB area = this.getEffectAABB(player);
            for (int i = 0; i < 30; ++i) {
                world.m_7106_((ParticleOptions)ParticleTypes.f_123797_, area.f_82288_ + world.f_46441_.nextFloat() * (area.f_82291_ - area.f_82288_), area.f_82289_ + world.f_46441_.nextFloat() * (area.f_82292_ - area.f_82289_), area.f_82290_ + world.f_46441_.nextFloat() * (area.f_82293_ - area.f_82290_), 0.0, 0.0, 0.0);
            }
        }
        return (InteractionResultHolder<ItemStack>)new InteractionResultHolder(InteractionResult.SUCCESS, (Object)player.m_21120_(hand));
    }
    
    private AABB getEffectAABB(final Player player) {
        final double range = 2.0;
        final double radius = 1.0;
        final Vec3 srcVec = new Vec3(player.m_20185_(), player.m_20186_() + player.m_20192_(), player.m_20189_());
        final Vec3 lookVec = player.m_20154_();
        final Vec3 destVec = srcVec.m_82520_(lookVec.f_82479_ * range, lookVec.f_82480_ * range, lookVec.f_82481_ * range);
        return new AABB(destVec.f_82479_ - radius, destVec.f_82480_ - radius, destVec.f_82481_ - radius, destVec.f_82479_ + radius, destVec.f_82480_ + radius, destVec.f_82481_ + radius);
    }
    
    static {
        transformMap = new HashMap<EntityType<?>, EntityType<?>>();
    }
}
