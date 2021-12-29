// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import net.minecraftforge.common.loot.IGlobalLootModifier;
import com.google.gson.JsonObject;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import javax.annotation.Nonnull;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.fml.ModList;
import java.util.HashMap;
import twilightforest.network.UpdateShieldPacket;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.phys.EntityHitResult;
import twilightforest.entity.projectile.ITFProjectile;
import net.minecraftforge.event.entity.ProjectileImpactEvent;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import twilightforest.advancements.TFAdvancements;
import net.minecraftforge.event.entity.player.AdvancementEvent;
import net.minecraft.nbt.CompoundTag;
import twilightforest.block.TFPortalBlock;
import twilightforest.network.EnforceProgressionStatusPacket;
import twilightforest.entity.monster.Kobold;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import twilightforest.network.AreaProtectionPacket;
import twilightforest.network.TFPacketHandler;
import net.minecraftforge.fmllegacy.network.PacketDistributor;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import java.util.Optional;
import twilightforest.world.components.chunkgenerators.ChunkGeneratorTwilight;
import twilightforest.world.registration.TFFeature;
import net.minecraft.core.Vec3i;
import net.minecraft.world.level.levelgen.structure.StructureStart;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.server.level.ServerLevel;
import twilightforest.util.WorldUtil;
import twilightforest.world.registration.TFGenerationSettings;
import twilightforest.data.BlockTagGenerator;
import net.minecraftforge.eventbus.api.Event;
import net.minecraft.world.level.LevelAccessor;
import twilightforest.block.GiantBlock;
import net.minecraftforge.event.entity.EntityMountEvent;
import twilightforest.entity.IHostileMount;
import twilightforest.capabilities.shield.IShieldCapability;
import net.minecraftforge.common.capabilities.Capability;
import twilightforest.capabilities.CapabilityList;
import net.minecraftforge.event.entity.living.LivingEvent;
import java.util.Iterator;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.TranslatableComponent;
import twilightforest.item.PhantomArmorItem;
import twilightforest.entity.CharmEffect;
import twilightforest.entity.TFEntities;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.effect.MobEffects;
import net.minecraftforge.event.world.BlockEvent;
import java.util.List;
import net.minecraft.world.level.material.FluidState;
import java.util.Collection;
import net.minecraft.core.NonNullList;
import java.util.ArrayList;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import twilightforest.block.entity.KeepsakeCasketBlockEntity;
import twilightforest.enums.BlockLoggingEnum;
import twilightforest.util.TFItemStackUtils;
import twilightforest.block.KeepsakeCasketBlock;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraft.world.level.GameRules;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraft.core.Direction;
import twilightforest.block.WallSkullCandleBlock;
import com.mojang.authlib.GameProfile;
import net.minecraft.world.level.block.entity.BlockEntity;
import twilightforest.block.entity.SkullCandleBlockEntity;
import twilightforest.block.SkullCandleBlock;
import net.minecraft.world.level.block.state.properties.Property;
import twilightforest.block.AbstractLightableBlock;
import twilightforest.block.AbstractSkullCandleBlock;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.entity.SkullBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import twilightforest.util.TFStats;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.block.WallSkullBlock;
import net.minecraft.world.level.block.SkullBlock;
import net.minecraft.world.level.block.AbstractSkullBlock;
import net.minecraft.tags.Tag;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import twilightforest.potions.TFMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.LivingEntity;
import twilightforest.enchantment.TFEnchantment;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraft.world.entity.Entity;
import twilightforest.entity.passive.Bighorn;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import twilightforest.entity.passive.TinyBird;
import twilightforest.entity.passive.Squirrel;
import net.minecraft.world.entity.ai.goal.Goal;
import java.util.function.Predicate;
import net.minecraft.world.entity.ai.goal.target.NonTameRandomTargetGoal;
import twilightforest.entity.passive.DwarfRabbit;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraftforge.common.ForgeMod;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.EquipmentSlot;
import twilightforest.item.TFItems;
import net.minecraftforge.event.ItemAttributeModifierEvent;
import net.minecraft.world.entity.player.Inventory;
import java.util.UUID;
import java.util.Map;
import com.google.common.collect.ImmutableSet;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "twilightforest")
public class TFEventListener
{
    private static final ImmutableSet<String> SHIELD_DAMAGE_BLACKLIST;
    private static final Map<UUID, Inventory> playerKeepsMap;
    private static boolean isBreakingWithGiantPick;
    private static boolean shouldMakeGiantCobble;
    private static int amountOfCobbleToReplace;
    private static boolean casketExpiration;
    public static volatile boolean allowDismount;
    private static final String NBT_TAG_TWILIGHT = "twilightforest_banished";
    private static boolean globalParry;
    
    @SubscribeEvent
    public static void addReach(final ItemAttributeModifierEvent event) {
        final Item item = event.getItemStack().m_41720_();
        if ((item == TFItems.GIANT_PICKAXE.get() || item == TFItems.GIANT_SWORD.get()) && event.getSlotType() == EquipmentSlot.MAINHAND) {
            event.addModifier((Attribute)ForgeMod.REACH_DISTANCE.get(), new AttributeModifier(TFItems.GIANT_REACH_MODIFIER, "Tool modifier", 2.5, AttributeModifier.Operation.ADDITION));
        }
    }
    
    @SubscribeEvent
    public static void addPrey(final EntityJoinWorldEvent event) {
        final Entity entity = event.getEntity();
        final EntityType<?> type = (EntityType<?>)entity.m_6095_();
        final Entity entity2 = entity;
        if (entity2 instanceof final Mob mob) {
            if (type == EntityType.f_20553_) {
                mob.f_21346_.m_25352_(1, (Goal)new NonTameRandomTargetGoal((TamableAnimal)entity, (Class)DwarfRabbit.class, false, (Predicate)null));
                mob.f_21346_.m_25352_(1, (Goal)new NonTameRandomTargetGoal((TamableAnimal)entity, (Class)Squirrel.class, false, (Predicate)null));
                mob.f_21346_.m_25352_(1, (Goal)new NonTameRandomTargetGoal((TamableAnimal)entity, (Class)TinyBird.class, false, (Predicate)null));
            }
            else if (type == EntityType.f_20505_) {
                mob.f_21346_.m_25352_(1, (Goal)new NearestAttackableTargetGoal(mob, (Class)DwarfRabbit.class, false));
                mob.f_21346_.m_25352_(1, (Goal)new NearestAttackableTargetGoal(mob, (Class)Squirrel.class, false));
                mob.f_21346_.m_25352_(1, (Goal)new NearestAttackableTargetGoal(mob, (Class)TinyBird.class, false));
            }
            else if (type == EntityType.f_20452_) {
                mob.f_21346_.m_25352_(6, (Goal)new NearestAttackableTargetGoal(mob, (Class)DwarfRabbit.class, false));
                mob.f_21346_.m_25352_(6, (Goal)new NearestAttackableTargetGoal(mob, (Class)Squirrel.class, false));
            }
            else if (type == EntityType.f_20499_) {
                mob.f_21346_.m_25352_(7, (Goal)new NonTameRandomTargetGoal((TamableAnimal)entity, (Class)DwarfRabbit.class, false, (Predicate)null));
                mob.f_21346_.m_25352_(7, (Goal)new NonTameRandomTargetGoal((TamableAnimal)entity, (Class)Squirrel.class, false, (Predicate)null));
                mob.f_21346_.m_25352_(7, (Goal)new NonTameRandomTargetGoal((TamableAnimal)entity, (Class)Bighorn.class, false, (Predicate)null));
            }
        }
    }
    
    @SubscribeEvent
    public static void onCrafting(final PlayerEvent.ItemCraftedEvent event) {
        final ItemStack itemStack = event.getCrafting();
        final Player player = event.getPlayer();
        if (itemStack.m_41720_() == Item.m_41439_(Blocks.f_50705_) && itemStack.m_41613_() == 64 && doesCraftMatrixHaveGiantLog(event.getInventory())) {
            ItemHandlerHelper.giveItemToPlayer(player, new ItemStack((ItemLike)Blocks.f_50705_, 64));
            ItemHandlerHelper.giveItemToPlayer(player, new ItemStack((ItemLike)Blocks.f_50705_, 64));
            ItemHandlerHelper.giveItemToPlayer(player, new ItemStack((ItemLike)Blocks.f_50705_, 64));
        }
    }
    
    private static boolean doesCraftMatrixHaveGiantLog(final Container inv) {
        final Item giantLogItem = Item.m_41439_((Block)TFBlocks.GIANT_LOG.get());
        for (int i = 0; i < inv.m_6643_(); ++i) {
            if (inv.m_8020_(i).m_41720_() == giantLogItem) {
                return true;
            }
        }
        return false;
    }
    
    @SubscribeEvent
    public static void entityHurts(final LivingHurtEvent event) {
        final LivingEntity living = event.getEntityLiving();
        final DamageSource damageSource = event.getSource();
        final String damageType = damageSource.m_19385_();
        final Entity trueSource = damageSource.m_7639_();
        if (living instanceof Player && (damageType.equals("mob") || damageType.equals("player")) && trueSource != null) {
            final Player player = (Player)living;
            final int fireLevel = TFEnchantment.getFieryAuraLevel(player.m_150109_(), damageSource);
            if (fireLevel > 0 && player.m_21187_().nextInt(25) < fireLevel) {
                trueSource.m_20254_(fireLevel / 2);
            }
        }
        if (living instanceof Player && (damageType.equals("mob") || damageType.equals("player")) && trueSource instanceof LivingEntity) {
            final Player player = (Player)living;
            final int chillLevel = TFEnchantment.getChillAuraLevel(player.m_150109_(), damageSource);
            if (chillLevel > 0) {
                ((LivingEntity)trueSource).m_7292_(new MobEffectInstance((MobEffect)TFMobEffects.FROSTY.get(), chillLevel * 5 + 5, chillLevel));
            }
        }
        if (damageType.equals("arrow") && trueSource instanceof Player) {
            final Player player = (Player)trueSource;
            if (player.m_21205_().m_41720_() == TFItems.TRIPLE_BOW.get() || player.m_21206_().m_41720_() == TFItems.TRIPLE_BOW.get()) {
                living.f_19802_ = 0;
            }
        }
        if (living instanceof Player && isRidingUnfriendly(living) && damageSource == DamageSource.f_19310_) {
            event.setCanceled(true);
        }
    }
    
    @SubscribeEvent
    public static void createSkullCandle(final PlayerInteractEvent.RightClickBlock event) {
        final ItemStack stack = event.getItemStack();
        final Level world = event.getWorld();
        final BlockPos pos = event.getPos();
        final BlockState state = world.m_8055_(pos);
        if (!(boolean)TFConfig.COMMON_CONFIG.disableSkullCandles.get() && stack.m_150922_((Tag)ItemTags.f_144319_) && stack.m_41720_().getRegistryName().m_135827_().equals("minecraft") && !event.getPlayer().m_6144_() && state.m_60734_() instanceof AbstractSkullBlock && state.m_60734_().getRegistryName().m_135827_().equals("minecraft")) {
            final SkullBlock.Types type = (SkullBlock.Types)((AbstractSkullBlock)state.m_60734_()).m_48754_();
            final boolean wall = state.m_60734_() instanceof WallSkullBlock;
            switch (type) {
                case SKELETON: {
                    if (wall) {
                        makeWallSkull(event, (Block)TFBlocks.SKELETON_WALL_SKULL_CANDLE.get());
                        break;
                    }
                    makeFloorSkull(event, (Block)TFBlocks.SKELETON_SKULL_CANDLE.get());
                    break;
                }
                case WITHER_SKELETON: {
                    if (wall) {
                        makeWallSkull(event, (Block)TFBlocks.WITHER_SKELE_WALL_SKULL_CANDLE.get());
                        break;
                    }
                    makeFloorSkull(event, (Block)TFBlocks.WITHER_SKELE_SKULL_CANDLE.get());
                    break;
                }
                case PLAYER: {
                    if (wall) {
                        makeWallSkull(event, (Block)TFBlocks.PLAYER_WALL_SKULL_CANDLE.get());
                        break;
                    }
                    makeFloorSkull(event, (Block)TFBlocks.PLAYER_SKULL_CANDLE.get());
                    break;
                }
                case ZOMBIE: {
                    if (wall) {
                        makeWallSkull(event, (Block)TFBlocks.ZOMBIE_WALL_SKULL_CANDLE.get());
                        break;
                    }
                    makeFloorSkull(event, (Block)TFBlocks.ZOMBIE_SKULL_CANDLE.get());
                    break;
                }
                case CREEPER: {
                    if (wall) {
                        makeWallSkull(event, (Block)TFBlocks.CREEPER_WALL_SKULL_CANDLE.get());
                        break;
                    }
                    makeFloorSkull(event, (Block)TFBlocks.CREEPER_SKULL_CANDLE.get());
                    break;
                }
                default: {
                    return;
                }
            }
            if (!event.getPlayer().m_150110_().f_35937_) {
                stack.m_41774_(1);
            }
            event.getPlayer().m_6674_(event.getHand());
            if (event.getPlayer() instanceof ServerPlayer) {
                event.getPlayer().m_36220_(TFStats.SKULL_CANDLES_MADE);
            }
            event.setCanceled(true);
        }
    }
    
    private static void makeFloorSkull(final PlayerInteractEvent.RightClickBlock event, final Block newBlock) {
        GameProfile profile = null;
        final BlockEntity 7702_ = event.getWorld().m_7702_(event.getPos());
        if (7702_ instanceof final SkullBlockEntity skull) {
            profile = skull.m_59779_();
        }
        event.getWorld().m_5594_((Player)null, event.getPos(), SoundEvents.f_144101_, SoundSource.BLOCKS, 1.0f, 1.0f);
        event.getWorld().m_46597_(event.getPos(), (BlockState)((BlockState)newBlock.m_49966_().m_61124_((Property)AbstractSkullCandleBlock.LIGHTING, (Comparable)AbstractLightableBlock.Lighting.NONE)).m_61124_((Property)SkullCandleBlock.ROTATION, (Comparable)event.getWorld().m_8055_(event.getPos()).m_61143_((Property)SkullBlock.f_56314_)));
        event.getWorld().m_151523_((BlockEntity)new SkullCandleBlockEntity(event.getPos(), (BlockState)((BlockState)newBlock.m_49966_().m_61124_((Property)AbstractSkullCandleBlock.LIGHTING, (Comparable)AbstractLightableBlock.Lighting.NONE)).m_61124_((Property)SkullCandleBlock.ROTATION, (Comparable)event.getWorld().m_8055_(event.getPos()).m_61143_((Property)SkullBlock.f_56314_)), AbstractSkullCandleBlock.candleToCandleColor(event.getItemStack().m_41720_()).getValue(), 1));
        final BlockEntity 7702_2 = event.getWorld().m_7702_(event.getPos());
        if (7702_2 instanceof final SkullCandleBlockEntity sc) {
            sc.m_59769_(profile);
        }
    }
    
    private static void makeWallSkull(final PlayerInteractEvent.RightClickBlock event, final Block newBlock) {
        GameProfile profile = null;
        final BlockEntity 7702_ = event.getWorld().m_7702_(event.getPos());
        if (7702_ instanceof final SkullBlockEntity skull) {
            profile = skull.m_59779_();
        }
        event.getWorld().m_5594_((Player)null, event.getPos(), SoundEvents.f_144101_, SoundSource.BLOCKS, 1.0f, 1.0f);
        event.getWorld().m_46597_(event.getPos(), (BlockState)((BlockState)newBlock.m_49966_().m_61124_((Property)AbstractSkullCandleBlock.LIGHTING, (Comparable)AbstractLightableBlock.Lighting.NONE)).m_61124_((Property)WallSkullCandleBlock.FACING, (Comparable)event.getWorld().m_8055_(event.getPos()).m_61143_((Property)WallSkullBlock.f_58097_)));
        event.getWorld().m_151523_((BlockEntity)new SkullCandleBlockEntity(event.getPos(), (BlockState)((BlockState)newBlock.m_49966_().m_61124_((Property)AbstractSkullCandleBlock.LIGHTING, (Comparable)AbstractLightableBlock.Lighting.NONE)).m_61124_((Property)WallSkullCandleBlock.FACING, (Comparable)event.getWorld().m_8055_(event.getPos()).m_61143_((Property)WallSkullBlock.f_58097_)), AbstractSkullCandleBlock.candleToCandleColor(event.getItemStack().m_41720_()).getValue(), 1));
        final BlockEntity 7702_2 = event.getWorld().m_7702_(event.getPos());
        if (7702_2 instanceof final SkullCandleBlockEntity sc) {
            sc.m_59769_(profile);
        }
    }
    
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void applyDeathItems(final LivingDeathEvent event) {
        final LivingEntity living = event.getEntityLiving();
        if (!living.f_19853_.f_46443_) {
            final LivingEntity livingEntity = living;
            if (livingEntity instanceof final Player player) {
                if (!(living instanceof FakePlayer) && !player.m_7500_()) {
                    if (charmOfLife(player)) {
                        event.setCanceled(true);
                    }
                    else if (!living.f_19853_.m_46469_().m_46207_(GameRules.f_46133_)) {
                        charmOfKeeping(player);
                        keepsakeCasket(player);
                    }
                }
            }
        }
    }
    
    private static void keepsakeCasket(final Player player) {
        final boolean casketConsumed = TFItemStackUtils.consumeInventoryItem(player, ((KeepsakeCasketBlock)TFBlocks.KEEPSAKE_CASKET.get()).m_5456_());
        if (casketConsumed) {
            final Level world = player.m_20193_();
            final BlockPos.MutableBlockPos pos = player.m_142538_().m_122032_();
            if (pos.m_123342_() < 2) {
                pos.m_142448_(2);
            }
            else {
                final int logicalHeight = player.m_20193_().m_6042_().m_63964_();
                if (pos.m_123342_() > logicalHeight) {
                    pos.m_142448_(logicalHeight - 1);
                }
            }
            final BlockPos immutablePos = pos.m_7949_();
            final FluidState fluidState = world.m_6425_(immutablePos);
            if (world.m_46597_(immutablePos, (BlockState)((BlockState)((KeepsakeCasketBlock)TFBlocks.KEEPSAKE_CASKET.get()).m_49966_().m_61124_((Property)BlockLoggingEnum.MULTILOGGED, (Comparable)BlockLoggingEnum.getFromFluid(fluidState.m_76152_()))).m_61124_((Property)KeepsakeCasketBlock.BREAKAGE, (Comparable)TFItemStackUtils.damage))) {
                final BlockEntity te = world.m_7702_(immutablePos);
                if (te instanceof final KeepsakeCasketBlockEntity casket) {
                    if (TFConfig.COMMON_CONFIG.casketUUIDLocking.get()) {
                        casket.playeruuid = player.m_36316_().getId();
                    }
                    else {
                        casket.playeruuid = null;
                    }
                    String modifiedName;
                    if (player.m_7755_().getString().length() > 12) {
                        modifiedName = player.m_7755_().getString().substring(0, 12);
                    }
                    else {
                        modifiedName = player.m_7755_().getString();
                    }
                    casket.f_58622_ = player.m_7755_().getString();
                    casket.casketname = modifiedName;
                    casket.m_58638_((Component)new TextComponent(modifiedName + "'s " + ((world.f_46441_.nextInt(10000) == 0) ? "Costco Casket" : casket.m_5446_().getString())));
                    int damage = (int)world.m_8055_(immutablePos).m_61143_((Property)KeepsakeCasketBlock.BREAKAGE);
                    if (world.f_46441_.nextFloat() <= 0.15f) {
                        if (damage >= 2) {
                            player.m_150109_().m_36071_();
                            world.m_46597_(immutablePos, Blocks.f_50016_.m_49966_());
                            TFEventListener.casketExpiration = true;
                            TwilightForestMod.LOGGER.debug("{}'s Casket damage value was too high, alerting the player and dropping extra items", (Object)player.m_7755_().getString());
                        }
                        else {
                            ++damage;
                            world.m_46597_(immutablePos, (BlockState)((BlockState)((KeepsakeCasketBlock)TFBlocks.KEEPSAKE_CASKET.get()).m_49966_().m_61124_((Property)BlockLoggingEnum.MULTILOGGED, (Comparable)BlockLoggingEnum.getFromFluid(fluidState.m_76152_()))).m_61124_((Property)KeepsakeCasketBlock.BREAKAGE, (Comparable)damage));
                            TwilightForestMod.LOGGER.debug("{}'s Casket was randomly damaged, applying new damage", (Object)player.m_7755_().getString());
                        }
                    }
                    final int casketCapacity = casket.m_6643_();
                    final List<ItemStack> list = new ArrayList<ItemStack>(casketCapacity);
                    final NonNullList<ItemStack> filler = (NonNullList<ItemStack>)NonNullList.m_122780_(4, (Object)ItemStack.f_41583_);
                    list.addAll((Collection<? extends ItemStack>)TFItemStackUtils.sortArmorForCasket(player));
                    player.m_150109_().f_35975_.clear();
                    list.addAll((Collection<? extends ItemStack>)filler);
                    list.addAll((Collection<? extends ItemStack>)player.m_150109_().f_35976_);
                    player.m_150109_().f_35976_.clear();
                    list.addAll((Collection<? extends ItemStack>)TFItemStackUtils.sortInvForCasket(player));
                    player.m_150109_().f_35974_.clear();
                    casket.m_6520_((NonNullList<ItemStack>)NonNullList.m_122783_((Object)ItemStack.f_41583_, (Object[])list.toArray(new ItemStack[casketCapacity])));
                }
            }
            else {
                TwilightForestMod.LOGGER.error("Could not place Keepsake Casket at " + pos.toString());
            }
        }
    }
    
    @SubscribeEvent
    public static void onCasketBreak(final BlockEvent.BreakEvent event) {
        final Block block = event.getState().m_60734_();
        final Player player = event.getPlayer();
        final BlockEntity te = event.getWorld().m_7702_(event.getPos());
        if (block == TFBlocks.KEEPSAKE_CASKET.get()) {
            UUID checker;
            if (te instanceof final KeepsakeCasketBlockEntity casket) {
                checker = casket.playeruuid;
            }
            else {
                checker = null;
            }
            if (checker != null && !((KeepsakeCasketBlockEntity)te).m_7983_() && (!player.m_20310_(3) || !player.m_36316_().getId().equals(checker))) {
                event.setCanceled(true);
            }
        }
    }
    
    private static boolean charmOfLife(final Player player) {
        final boolean charm2 = TFItemStackUtils.consumeInventoryItem(player, (Item)TFItems.CHARM_OF_LIFE_2.get());
        final boolean charm3 = !charm2 && TFItemStackUtils.consumeInventoryItem(player, (Item)TFItems.CHARM_OF_LIFE_1.get());
        if (charm2 || charm3) {
            if (charm3) {
                player.m_21153_(8.0f);
                player.m_7292_(new MobEffectInstance(MobEffects.f_19605_, 100, 0));
            }
            if (charm2) {
                player.m_21153_((float)player.m_21051_(Attributes.f_22276_).m_22115_());
                player.m_7292_(new MobEffectInstance(MobEffects.f_19605_, 600, 3));
                player.m_7292_(new MobEffectInstance(MobEffects.f_19606_, 600, 0));
                player.m_7292_(new MobEffectInstance(MobEffects.f_19607_, 600, 0));
            }
            final CharmEffect effect = new CharmEffect(TFEntities.CHARM_EFFECT, player.f_19853_, (LivingEntity)player, charm3 ? ((Item)TFItems.CHARM_OF_LIFE_1.get()) : ((Item)TFItems.CHARM_OF_LIFE_2.get()));
            player.f_19853_.m_7967_((Entity)effect);
            final CharmEffect effect2 = new CharmEffect(TFEntities.CHARM_EFFECT, player.f_19853_, (LivingEntity)player, charm3 ? ((Item)TFItems.CHARM_OF_LIFE_1.get()) : ((Item)TFItems.CHARM_OF_LIFE_2.get()));
            effect2.offset = 3.1415927f;
            player.f_19853_.m_7967_((Entity)effect2);
            player.f_19853_.m_6263_((Player)null, player.m_20185_(), player.m_20186_(), player.m_20189_(), TFSounds.CHARM_LIFE, player.m_5720_(), 1.0f, 1.0f);
            if (player instanceof ServerPlayer) {
                player.m_36220_(TFStats.LIFE_CHARMS_ACTIVATED);
            }
            return true;
        }
        return false;
    }
    
    private static void charmOfKeeping(final Player player) {
        dropStoredItems(player);
        final boolean tier3 = TFItemStackUtils.consumeInventoryItem(player, (Item)TFItems.CHARM_OF_KEEPING_3.get());
        final boolean tier4 = tier3 || TFItemStackUtils.consumeInventoryItem(player, (Item)TFItems.CHARM_OF_KEEPING_2.get());
        final boolean tier5 = tier4 || TFItemStackUtils.consumeInventoryItem(player, (Item)TFItems.CHARM_OF_KEEPING_1.get());
        final Inventory keepInventory = new Inventory((Player)null);
        final UUID playerUUID = player.m_142081_();
        if (tier5) {
            keepAllArmor(player, keepInventory);
            keepOffHand(player, keepInventory);
        }
        if (tier3) {
            for (int i = 0; i < player.m_150109_().f_35974_.size(); ++i) {
                keepInventory.f_35974_.set(i, (Object)((ItemStack)player.m_150109_().f_35974_.get(i)).m_41777_());
                player.m_150109_().f_35974_.set(i, (Object)ItemStack.f_41583_);
            }
            keepInventory.m_36012_(new ItemStack((ItemLike)TFItems.CHARM_OF_KEEPING_3.get()));
        }
        else if (tier4) {
            for (int i = 0; i < 9; ++i) {
                keepInventory.f_35974_.set(i, (Object)((ItemStack)player.m_150109_().f_35974_.get(i)).m_41777_());
                player.m_150109_().f_35974_.set(i, (Object)ItemStack.f_41583_);
            }
            keepInventory.m_36012_(new ItemStack((ItemLike)TFItems.CHARM_OF_KEEPING_2.get()));
        }
        else if (tier5) {
            final int i = player.m_150109_().f_35977_;
            if (Inventory.m_36045_(i)) {
                keepInventory.f_35974_.set(i, (Object)((ItemStack)player.m_150109_().f_35974_.get(i)).m_41777_());
                player.m_150109_().f_35974_.set(i, (Object)ItemStack.f_41583_);
            }
            keepInventory.m_36012_(new ItemStack((ItemLike)TFItems.CHARM_OF_KEEPING_1.get()));
        }
        for (int i = 0; i < player.m_150109_().f_35974_.size(); ++i) {
            final ItemStack stack = (ItemStack)player.m_150109_().f_35974_.get(i);
            if (stack.m_41720_() == TFItems.TOWER_KEY.get()) {
                keepInventory.f_35974_.set(i, (Object)stack.m_41777_());
                player.m_150109_().f_35974_.set(i, (Object)ItemStack.f_41583_);
            }
            if (stack.m_41720_() instanceof PhantomArmorItem) {
                keepInventory.f_35974_.set(i, (Object)stack.m_41777_());
                player.m_150109_().f_35974_.set(i, (Object)ItemStack.f_41583_);
            }
        }
        for (int i = 0; i < player.m_150109_().f_35975_.size(); ++i) {
            final ItemStack armor = (ItemStack)player.m_150109_().f_35975_.get(i);
            if (armor.m_41720_() instanceof PhantomArmorItem) {
                keepInventory.f_35975_.set(i, (Object)armor.m_41777_());
                player.m_150109_().f_35975_.set(i, (Object)ItemStack.f_41583_);
            }
        }
        TFEventListener.playerKeepsMap.put(playerUUID, keepInventory);
    }
    
    private static void keepAllArmor(final Player player, final Inventory keepInventory) {
        for (int i = 0; i < player.m_150109_().f_35975_.size(); ++i) {
            keepInventory.f_35975_.set(i, (Object)((ItemStack)player.m_150109_().f_35975_.get(i)).m_41777_());
            player.m_150109_().f_35975_.set(i, (Object)ItemStack.f_41583_);
        }
    }
    
    private static void keepOffHand(final Player player, final Inventory keepInventory) {
        for (int i = 0; i < player.m_150109_().f_35976_.size(); ++i) {
            keepInventory.f_35976_.set(i, (Object)((ItemStack)player.m_150109_().f_35976_.get(i)).m_41777_());
            player.m_150109_().f_35976_.set(i, (Object)ItemStack.f_41583_);
        }
    }
    
    @SubscribeEvent
    public static void onPlayerRespawn(final PlayerEvent.PlayerRespawnEvent event) {
        if (event.isEndConquered()) {
            updateCapabilities((ServerPlayer)event.getPlayer(), (Entity)event.getPlayer());
        }
        else {
            if (TFEventListener.casketExpiration) {
                event.getPlayer().m_6352_((Component)new TranslatableComponent("block.twilightforest.casket.broken").m_130940_(ChatFormatting.DARK_RED), event.getPlayer().m_142081_());
            }
            returnStoredItems(event.getPlayer());
        }
    }
    
    private static void returnStoredItems(final Player player) {
        final Inventory keepInventory = TFEventListener.playerKeepsMap.remove(player.m_142081_());
        if (keepInventory != null) {
            TwilightForestMod.LOGGER.debug("Player {} ({}) respawned and received items held in storage", (Object)player.m_7755_().getString(), (Object)player.m_142081_());
            final NonNullList<ItemStack> displaced = (NonNullList<ItemStack>)NonNullList.m_122779_();
            for (int i = 0; i < player.m_150109_().f_35975_.size(); ++i) {
                final ItemStack kept = (ItemStack)keepInventory.f_35975_.get(i);
                if (!kept.m_41619_()) {
                    final ItemStack existing = (ItemStack)player.m_150109_().f_35975_.set(i, (Object)kept);
                    if (!existing.m_41619_()) {
                        displaced.add((Object)existing);
                    }
                }
            }
            for (int i = 0; i < player.m_150109_().f_35976_.size(); ++i) {
                final ItemStack kept = (ItemStack)keepInventory.f_35976_.get(i);
                if (!kept.m_41619_()) {
                    final ItemStack existing = (ItemStack)player.m_150109_().f_35976_.set(i, (Object)kept);
                    if (!existing.m_41619_()) {
                        displaced.add((Object)existing);
                    }
                }
            }
            for (int i = 0; i < player.m_150109_().f_35974_.size(); ++i) {
                final ItemStack kept = (ItemStack)keepInventory.f_35974_.get(i);
                if (!kept.m_41619_()) {
                    final ItemStack existing = (ItemStack)player.m_150109_().f_35974_.set(i, (Object)kept);
                    if (!existing.m_41619_()) {
                        displaced.add((Object)existing);
                    }
                }
            }
            for (final ItemStack extra : displaced) {
                ItemHandlerHelper.giveItemToPlayer(player, extra);
            }
            if (!keepInventory.m_36056_().m_41619_()) {
                final CharmEffect effect = new CharmEffect(TFEntities.CHARM_EFFECT, player.f_19853_, (LivingEntity)player, keepInventory.m_36056_().m_41720_());
                player.f_19853_.m_7967_((Entity)effect);
                final CharmEffect effect2 = new CharmEffect(TFEntities.CHARM_EFFECT, player.f_19853_, (LivingEntity)player, keepInventory.m_36056_().m_41720_());
                effect2.offset = 3.1415927f;
                player.f_19853_.m_7967_((Entity)effect2);
                player.f_19853_.m_6263_((Player)null, player.m_20185_(), player.m_20186_(), player.m_20189_(), TFSounds.CHARM_KEEP, player.m_5720_(), 1.5f, 1.0f);
                keepInventory.m_36056_().m_41774_(1);
                if (player instanceof ServerPlayer) {
                    player.m_36220_(TFStats.KEEPING_CHARMS_ACTIVATED);
                }
            }
        }
    }
    
    @SubscribeEvent
    public static void onPlayerLogout(final PlayerEvent.PlayerLoggedOutEvent event) {
        dropStoredItems(event.getPlayer());
    }
    
    private static void dropStoredItems(final Player player) {
        final Inventory keepInventory = TFEventListener.playerKeepsMap.remove(player.m_142081_());
        if (keepInventory != null) {
            TwilightForestMod.LOGGER.warn("Dropping inventory items previously held in reserve for player {} ({})", (Object)player.m_7755_().getString(), (Object)player.m_142081_());
            keepInventory.f_35978_ = player;
            keepInventory.m_36071_();
        }
    }
    
    @SubscribeEvent
    public static void livingUpdate(final LivingEvent.LivingUpdateEvent event) {
        event.getEntityLiving().getCapability((Capability)CapabilityList.SHIELDS).ifPresent(IShieldCapability::update);
        if (event.getEntityLiving() instanceof IHostileMount) {
            event.getEntityLiving().m_20197_().forEach(e -> e.m_20260_(false));
        }
    }
    
    @SubscribeEvent
    public static void preventMountDismount(final EntityMountEvent event) {
        if (!event.getEntityBeingMounted().f_19853_.m_5776_() && !event.isMounting() && event.getEntityBeingMounted().m_6084_()) {
            final Entity entityMounting = event.getEntityMounting();
            if (entityMounting instanceof final LivingEntity living) {
                if (isRidingUnfriendly(living) && !TFEventListener.allowDismount) {
                    event.setCanceled(true);
                }
            }
        }
    }
    
    public static boolean isRidingUnfriendly(final LivingEntity entity) {
        return entity.m_20159_() && entity.m_20202_() instanceof IHostileMount;
    }
    
    @SubscribeEvent
    public static void breakBlock(final BlockEvent.BreakEvent event) {
        final Player player = event.getPlayer();
        final BlockPos pos = event.getPos();
        final BlockState state = event.getState();
        final LevelAccessor world2 = event.getWorld();
        if (world2 instanceof final Level world) {
            if (!((Level)event.getWorld()).f_46443_) {
                if (isBlockProtectedFromBreaking(world, pos) && isAreaProtected(world, player, pos)) {
                    event.setCanceled(true);
                }
                else if (!TFEventListener.isBreakingWithGiantPick && canHarvestWithGiantPick(player, state)) {
                    TFEventListener.isBreakingWithGiantPick = true;
                    final Item cobbleItem = Blocks.f_50652_.m_5456_();
                    boolean allCobble = state.m_60734_().m_5456_() == cobbleItem;
                    if (allCobble) {
                        for (final BlockPos dPos : GiantBlock.getVolume(pos)) {
                            if (dPos.equals((Object)pos)) {
                                continue;
                            }
                            final BlockState stateThere = world.m_8055_(dPos);
                            if (stateThere.m_60734_().m_5456_() != cobbleItem) {
                                allCobble = false;
                                break;
                            }
                        }
                    }
                    if (allCobble && !player.m_150110_().f_35937_) {
                        TFEventListener.shouldMakeGiantCobble = true;
                        TFEventListener.amountOfCobbleToReplace = 64;
                    }
                    else {
                        TFEventListener.shouldMakeGiantCobble = false;
                        TFEventListener.amountOfCobbleToReplace = 0;
                    }
                    final Player player2 = player;
                    if (player2 instanceof final ServerPlayer playerMP) {
                        for (final BlockPos dPos2 : GiantBlock.getVolume(pos)) {
                            if (!dPos2.equals((Object)pos) && state.m_60734_() == world.m_8055_(dPos2).m_60734_()) {
                                playerMP.f_8941_.m_9280_(dPos2);
                            }
                        }
                    }
                    TFEventListener.isBreakingWithGiantPick = false;
                }
            }
        }
    }
    
    private static boolean canHarvestWithGiantPick(final Player player, final BlockState state) {
        final ItemStack heldStack = player.m_21205_();
        final Item heldItem = heldStack.m_41720_();
        return heldItem == TFItems.GIANT_PICKAXE.get() && heldItem.m_8096_(state);
    }
    
    @SubscribeEvent
    public static void onPlayerRightClick(final PlayerInteractEvent.RightClickBlock event) {
        final Player player = event.getPlayer();
        final Level world = player.f_19853_;
        if (!world.f_46443_ && isBlockProtectedFromInteraction(world, event.getPos()) && isAreaProtected(world, player, event.getPos())) {
            event.setUseBlock(Event.Result.DENY);
        }
    }
    
    private static boolean isBlockProtectedFromInteraction(final Level world, final BlockPos pos) {
        return world.m_8055_(pos).m_60620_((Tag)BlockTagGenerator.STRUCTURE_BANNED_INTERACTIONS);
    }
    
    private static boolean isBlockProtectedFromBreaking(final Level world, final BlockPos pos) {
        return !world.m_8055_(pos).m_60734_().getRegistryName().m_135815_().contains("grave") || !world.m_8055_(pos).m_60713_((Block)TFBlocks.KEEPSAKE_CASKET.get());
    }
    
    private static boolean isAreaProtected(final Level world, final Player player, final BlockPos pos) {
        if (player.m_150110_().f_35937_ || !TFGenerationSettings.isProgressionEnforced(world) || player instanceof FakePlayer) {
            return false;
        }
        final ChunkGeneratorTwilight chunkGenerator = WorldUtil.getChunkGenerator((LevelAccessor)world);
        if (chunkGenerator != null) {
            final Optional<StructureStart<?>> struct = TFGenerationSettings.locateTFStructureInRange((WorldGenLevel)world, pos, 0);
            if (struct.isPresent()) {
                final StructureStart<?> structure = struct.get();
                if (structure.m_73601_().m_71051_((Vec3i)pos)) {
                    final TFFeature nearbyFeature = TFFeature.getFeatureAt(pos.m_123341_(), pos.m_123343_(), (WorldGenLevel)world);
                    if (!nearbyFeature.doesPlayerHaveRequiredAdvancements(player)) {
                        if (nearbyFeature == TFFeature.KNIGHT_STRONGHOLD && pos.m_123342_() >= 0) {
                            return false;
                        }
                        final BoundingBox bb = structure.m_73601_();
                        sendAreaProtectionPacket(world, pos, bb);
                        nearbyFeature.trySpawnHintMonster(world, player, pos);
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private static void sendAreaProtectionPacket(final Level world, final BlockPos pos, final BoundingBox sbb) {
        final PacketDistributor.TargetPoint targetPoint = new PacketDistributor.TargetPoint((double)pos.m_123341_(), (double)pos.m_123342_(), (double)pos.m_123343_(), 64.0, world.m_46472_());
        TFPacketHandler.CHANNEL.send(PacketDistributor.NEAR.with(() -> targetPoint), (Object)new AreaProtectionPacket(sbb, pos));
    }
    
    @SubscribeEvent
    public static void livingAttack(final LivingAttackEvent event) {
        final LivingEntity living = event.getEntityLiving();
        if (!living.f_19853_.f_46443_ && living instanceof Enemy && event.getSource().m_7639_() instanceof Player && !(living instanceof Kobold) && isAreaProtected(living.f_19853_, (Player)event.getSource().m_7639_(), new BlockPos((Vec3i)living.m_142538_()))) {
            event.setCanceled(true);
            return;
        }
        if (!living.f_19853_.f_46443_ && !TFEventListener.SHIELD_DAMAGE_BLACKLIST.contains((Object)event.getSource().f_19326_)) {
            living.getCapability((Capability)CapabilityList.SHIELDS).ifPresent(cap -> {
                if (cap.shieldsLeft() > 0) {
                    cap.breakShield();
                    event.setCanceled(true);
                }
            });
        }
    }
    
    @SubscribeEvent
    public static void playerLogsIn(final PlayerEvent.PlayerLoggedInEvent event) {
        if (!event.getPlayer().f_19853_.f_46443_ && event.getPlayer() instanceof ServerPlayer) {
            sendEnforcedProgressionStatus((ServerPlayer)event.getPlayer(), TFGenerationSettings.isProgressionEnforced(event.getPlayer().f_19853_));
            updateCapabilities((ServerPlayer)event.getPlayer(), (Entity)event.getPlayer());
            banishNewbieToTwilightZone(event.getPlayer());
        }
    }
    
    @SubscribeEvent
    public static void playerPortals(final PlayerEvent.PlayerChangedDimensionEvent event) {
        if (!event.getPlayer().f_19853_.f_46443_) {
            final Player player2 = event.getPlayer();
            if (player2 instanceof final ServerPlayer player) {
                if (TFGenerationSettings.usesTwilightChunkGenerator(player.m_9236_())) {
                    sendEnforcedProgressionStatus((ServerPlayer)event.getPlayer(), TFGenerationSettings.isProgressionEnforced((Level)player.m_9236_()));
                }
                updateCapabilities(player, (Entity)event.getPlayer());
            }
        }
    }
    
    @SubscribeEvent
    public static void onStartTracking(final PlayerEvent.StartTracking event) {
        updateCapabilities((ServerPlayer)event.getPlayer(), event.getTarget());
    }
    
    private static void updateCapabilities(final ServerPlayer clientTarget, final Entity shielded) {
        shielded.getCapability((Capability)CapabilityList.SHIELDS).ifPresent(cap -> {
            if (cap.shieldsLeft() > 0) {
                TFPacketHandler.CHANNEL.send(PacketDistributor.PLAYER.with(() -> clientTarget), (Object)new UpdateShieldPacket(shielded, cap));
            }
        });
    }
    
    private static void sendEnforcedProgressionStatus(final ServerPlayer player, final boolean isEnforced) {
        TFPacketHandler.CHANNEL.send(PacketDistributor.PLAYER.with(() -> player), (Object)new EnforceProgressionStatusPacket(isEnforced));
    }
    
    private static void banishNewbieToTwilightZone(final Player player) {
        final CompoundTag tagCompound = player.getPersistentData();
        final CompoundTag playerData = tagCompound.m_128469_("PlayerPersisted");
        final boolean shouldBanishPlayer = (boolean)TFConfig.COMMON_CONFIG.DIMENSION.newPlayersSpawnInTF.get() && !playerData.m_128471_("twilightforest_banished");
        playerData.m_128379_("twilightforest_banished", true);
        tagCompound.m_128365_("PlayerPersisted", (net.minecraft.nbt.Tag)playerData);
        if (shouldBanishPlayer) {
            TFPortalBlock.attemptSendEntity((Entity)player, true, (boolean)TFConfig.COMMON_CONFIG.DIMENSION.portalForNewPlayerSpawn.get());
        }
    }
    
    @SubscribeEvent
    public static void onAdvancementGet(final AdvancementEvent event) {
        final Player player = event.getPlayer();
        if (player instanceof final ServerPlayer serverPlayer) {
            TFAdvancements.ADVANCEMENT_UNLOCKED.trigger(serverPlayer, event.getAdvancement());
        }
    }
    
    @SubscribeEvent
    public static void armorChanged(final LivingEquipmentChangeEvent event) {
        final LivingEntity living = event.getEntityLiving();
        if (!living.f_19853_.f_46443_ && living instanceof ServerPlayer) {
            TFAdvancements.ARMOR_CHANGED.trigger((ServerPlayer)living, event.getFrom(), event.getTo());
        }
    }
    
    @SubscribeEvent
    public static void throwableParry(final ProjectileImpactEvent event) {
        final Projectile projectile = event.getProjectile();
        if (!projectile.m_20193_().f_46443_ && TFEventListener.globalParry && ((boolean)TFConfig.COMMON_CONFIG.SHIELD_INTERACTIONS.parryNonTwilightAttacks.get() || projectile instanceof ITFProjectile) && event.getRayTraceResult() instanceof EntityHitResult) {
            final Entity entity = ((EntityHitResult)event.getRayTraceResult()).m_82443_();
            if (event.getEntity() != null) {
                final Entity entity2 = entity;
                if (entity2 instanceof final LivingEntity entityBlocking) {
                    if (entityBlocking.m_21275_((DamageSource)new DamageSource("parry_this") {
                        public Vec3 m_7270_() {
                            return projectile.m_20182_();
                        }
                    }) && entityBlocking.m_21211_().m_41720_().m_8105_(entityBlocking.m_21211_()) - entityBlocking.m_21212_() <= (int)TFConfig.COMMON_CONFIG.SHIELD_INTERACTIONS.shieldParryTicksThrowable.get()) {
                        final Vec3 playerVec3 = entityBlocking.m_20154_();
                        projectile.m_6686_(playerVec3.f_82479_, playerVec3.f_82480_, playerVec3.f_82481_, 1.1f, 0.1f);
                        projectile.m_5602_((Entity)entityBlocking);
                        event.setCanceled(true);
                    }
                }
            }
        }
    }
    
    static {
        SHIELD_DAMAGE_BLACKLIST = ImmutableSet.of((Object)"inWall", (Object)"cramming", (Object)"drown", (Object)"starve", (Object)"fall", (Object)"flyIntoWall", (Object[])new String[] { "outOfWorld", "fallingBlock" });
        playerKeepsMap = new HashMap<UUID, Inventory>();
        TFEventListener.isBreakingWithGiantPick = false;
        TFEventListener.shouldMakeGiantCobble = false;
        TFEventListener.amountOfCobbleToReplace = 0;
        TFEventListener.casketExpiration = false;
        TFEventListener.allowDismount = false;
        TFEventListener.globalParry = !ModList.get().isLoaded("parry");
    }
    
    public static class ManipulateDrops extends LootModifier
    {
        protected ManipulateDrops(final LootItemCondition[] conditionsIn) {
            super(conditionsIn);
        }
        
        @Nonnull
        protected List<ItemStack> doApply(final List<ItemStack> generatedLoot, final LootContext context) {
            final List<ItemStack> newLoot = new ArrayList<ItemStack>();
            boolean flag = false;
            if (TFEventListener.shouldMakeGiantCobble && generatedLoot.size() > 0 && generatedLoot.get(0).m_41720_() == Item.m_41439_(Blocks.f_50652_)) {
                generatedLoot.remove(0);
                if (TFEventListener.amountOfCobbleToReplace == 64) {
                    newLoot.add(new ItemStack((ItemLike)TFBlocks.GIANT_COBBLESTONE.get()));
                    flag = true;
                }
                --TFEventListener.amountOfCobbleToReplace;
                if (TFEventListener.amountOfCobbleToReplace <= 0) {
                    TFEventListener.shouldMakeGiantCobble = false;
                }
            }
            return flag ? newLoot : generatedLoot;
        }
    }
    
    public static class Serializer extends GlobalLootModifierSerializer<ManipulateDrops>
    {
        public ManipulateDrops read(final ResourceLocation name, final JsonObject json, final LootItemCondition[] conditionsIn) {
            return new ManipulateDrops(conditionsIn);
        }
        
        public JsonObject write(final ManipulateDrops instance) {
            return null;
        }
    }
}
