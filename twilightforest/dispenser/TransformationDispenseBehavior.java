// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.dispenser;

import twilightforest.entity.TFEntities;
import java.util.UUID;
import net.minecraft.entity.Entity;
import java.util.Iterator;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.World;
import twilightforest.TFSounds;
import twilightforest.TwilightForestMod;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.world.IServerWorld;
import net.minecraft.entity.MobEntity;
import net.minecraft.util.EntityPredicates;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.entity.LivingEntity;
import net.minecraft.state.Property;
import net.minecraft.block.DispenserBlock;
import net.minecraft.util.Direction;
import net.minecraft.item.ItemStack;
import net.minecraft.dispenser.IBlockSource;
import java.util.HashMap;
import net.minecraft.entity.EntityType;
import java.util.Map;
import net.minecraft.dispenser.DefaultDispenseItemBehavior;

public class TransformationDispenseBehavior extends DefaultDispenseItemBehavior
{
    boolean fired;
    private final Map<EntityType<?>, EntityType<?>> transformMap;
    
    public TransformationDispenseBehavior() {
        this.fired = false;
        this.transformMap = new HashMap<EntityType<?>, EntityType<?>>();
    }
    
    protected ItemStack func_82487_b(final IBlockSource source, final ItemStack stack) {
        this.initTransformations();
        final World world = (World)source.func_197524_h();
        final Random random = world.func_201674_k();
        final BlockPos blockpos = source.func_180699_d().func_177972_a((Direction)source.func_189992_e().func_177229_b((Property)DispenserBlock.field_176441_a));
        if (!world.field_72995_K) {
            for (final LivingEntity livingentity : world.func_175647_a((Class)LivingEntity.class, new AxisAlignedBB(blockpos), EntityPredicates.field_180132_d)) {
                if (this.transformMap.containsValue(livingentity.func_200600_R())) {
                    final EntityType<?> type = this.transformMap.get(livingentity.func_200600_R());
                    final Entity newEntity = type.func_200721_a(world);
                    if (type == null || newEntity == null) {
                        continue;
                    }
                    newEntity.func_70012_b(livingentity.func_226277_ct_(), livingentity.func_226278_cu_(), livingentity.func_226281_cx_(), livingentity.field_70177_z, livingentity.field_70125_A);
                    if (newEntity instanceof MobEntity && livingentity.field_70170_p instanceof IServerWorld) {
                        final IServerWorld sworld = (IServerWorld)livingentity.field_70170_p;
                        ((MobEntity)newEntity).func_213386_a(sworld, livingentity.field_70170_p.func_175649_E(livingentity.func_233580_cy_()), SpawnReason.CONVERSION, (ILivingEntityData)null, (CompoundNBT)null);
                    }
                    try {
                        final UUID uuid = newEntity.func_110124_au();
                        newEntity.func_70020_e(livingentity.func_189511_e(newEntity.func_189511_e(new CompoundNBT())));
                        newEntity.func_184221_a(uuid);
                    }
                    catch (Exception e) {
                        TwilightForestMod.LOGGER.warn("Couldn't transform entity NBT data", (Throwable)e);
                    }
                    livingentity.field_70170_p.func_217376_c(newEntity);
                    livingentity.func_70106_y();
                    if (livingentity instanceof MobEntity) {
                        ((MobEntity)livingentity).func_70656_aK();
                        ((MobEntity)livingentity).func_70656_aK();
                    }
                    livingentity.func_184185_a(TFSounds.POWDER_USE, 1.0f + random.nextFloat(), random.nextFloat() * 0.7f + 0.3f);
                    stack.func_190918_g(1);
                    this.fired = true;
                }
            }
        }
        return stack;
    }
    
    protected void func_82485_a(final IBlockSource source) {
        if (this.fired) {
            super.func_82485_a(source);
        }
        else {
            source.func_197524_h().func_217379_c(1001, source.func_180699_d(), 0);
        }
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
}
