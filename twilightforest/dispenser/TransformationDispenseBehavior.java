// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.dispenser;

import java.util.UUID;
import net.minecraft.world.entity.Entity;
import java.util.Iterator;
import net.minecraft.core.BlockPos;
import java.util.Random;
import net.minecraft.world.level.Level;
import twilightforest.TFSounds;
import twilightforest.TwilightForestMod;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockSource;
import twilightforest.item.TransformPowderItem;
import net.minecraft.world.entity.EntityType;
import java.util.Map;
import net.minecraft.core.dispenser.DefaultDispenseItemBehavior;

public class TransformationDispenseBehavior extends DefaultDispenseItemBehavior
{
    boolean fired;
    private final Map<EntityType<?>, EntityType<?>> transformMap;
    
    public TransformationDispenseBehavior() {
        this.fired = false;
        this.transformMap = TransformPowderItem.transformMap;
    }
    
    protected ItemStack m_7498_(final BlockSource source, final ItemStack stack) {
        final Level world = (Level)source.m_7727_();
        final Random random = world.m_5822_();
        final BlockPos blockpos = source.m_7961_().m_142300_((Direction)source.m_6414_().m_61143_((Property)DispenserBlock.f_52659_));
        if (!world.f_46443_) {
            for (final LivingEntity livingentity : world.m_6443_((Class)LivingEntity.class, new AABB(blockpos), EntitySelector.f_20408_)) {
                if (this.transformMap.containsValue(livingentity.m_6095_())) {
                    final EntityType<?> type = this.transformMap.get(livingentity.m_6095_());
                    final Entity newEntity = type.m_20615_(world);
                    if (type == null || newEntity == null) {
                        continue;
                    }
                    newEntity.m_7678_(livingentity.m_20185_(), livingentity.m_20186_(), livingentity.m_20189_(), livingentity.m_146908_(), livingentity.m_146909_());
                    final Entity entity = newEntity;
                    if (entity instanceof final Mob mob) {
                        final Level f_19853_ = livingentity.f_19853_;
                        if (f_19853_ instanceof final ServerLevelAccessor sworld) {
                            mob.m_6518_(sworld, livingentity.f_19853_.m_6436_(livingentity.m_142538_()), MobSpawnType.CONVERSION, (SpawnGroupData)null, (CompoundTag)null);
                        }
                    }
                    try {
                        final UUID uuid = newEntity.m_142081_();
                        newEntity.m_20258_(livingentity.m_20240_(newEntity.m_20240_(new CompoundTag())));
                        newEntity.m_20084_(uuid);
                    }
                    catch (Exception e) {
                        TwilightForestMod.LOGGER.warn("Couldn't transform entity NBT data", (Throwable)e);
                    }
                    livingentity.f_19853_.m_7967_(newEntity);
                    livingentity.m_146870_();
                    if (livingentity instanceof final Mob mob2) {
                        mob2.m_21373_();
                        ((Mob)livingentity).m_21373_();
                    }
                    livingentity.m_5496_(TFSounds.POWDER_USE, 1.0f + random.nextFloat(), random.nextFloat() * 0.7f + 0.3f);
                    stack.m_41774_(1);
                    this.fired = true;
                }
            }
        }
        return stack;
    }
    
    protected void m_6823_(final BlockSource source) {
        if (this.fired) {
            super.m_6823_(source);
        }
        else {
            source.m_7727_().m_46796_(1001, source.m_7961_(), 0);
        }
    }
}
