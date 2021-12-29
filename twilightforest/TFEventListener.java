// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import net.minecraftforge.common.loot.IGlobalLootModifier;
import com.google.gson.JsonObject;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import javax.annotation.Nonnull;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.fml.ModList;
import java.util.HashMap;
import twilightforest.network.UpdateShieldPacket;
import net.minecraft.entity.projectile.ThrowableEntity;
import net.minecraft.entity.projectile.DamagingProjectileEntity;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.util.math.EntityRayTraceResult;
import twilightforest.entity.projectile.ITFProjectile;
import net.minecraftforge.event.entity.ProjectileImpactEvent;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import twilightforest.advancements.TFAdvancements;
import net.minecraftforge.event.entity.player.AdvancementEvent;
import net.minecraft.nbt.CompoundNBT;
import twilightforest.block.TFPortalBlock;
import net.minecraft.nbt.INBT;
import net.minecraft.world.IWorld;
import net.minecraftforge.event.world.WorldEvent;
import twilightforest.network.SetSkylightEnabledPacket;
import twilightforest.network.EnforceProgressionStatusPacket;
import net.minecraft.entity.monster.IMob;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import twilightforest.network.AreaProtectionPacket;
import twilightforest.network.TFPacketHandler;
import net.minecraftforge.fml.network.PacketDistributor;
import net.minecraft.util.math.MutableBoundingBox;
import java.util.Optional;
import twilightforest.world.ChunkGeneratorTwilightBase;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.world.gen.feature.structure.StructureStart;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.server.ServerWorld;
import twilightforest.world.TFGenerationSettings;
import net.minecraft.tags.ITag;
import twilightforest.data.BlockTagGenerator;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import twilightforest.block.GiantBlock;
import twilightforest.entity.IHostileMount;
import twilightforest.capabilities.shield.IShieldCapability;
import net.minecraftforge.common.capabilities.Capability;
import twilightforest.capabilities.CapabilityList;
import net.minecraftforge.event.entity.living.LivingEvent;
import java.util.Iterator;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.entity.player.ServerPlayerEntity;
import twilightforest.item.PhantomArmorItem;
import net.minecraft.entity.EntityType;
import twilightforest.entity.CharmEffectEntity;
import twilightforest.entity.TFEntities;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.potion.Effects;
import net.minecraftforge.event.world.BlockEvent;
import java.util.List;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import java.util.Collection;
import net.minecraft.util.NonNullList;
import java.util.ArrayList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import twilightforest.tileentity.KeepsakeCasketTileEntity;
import net.minecraft.state.Property;
import twilightforest.enums.BlockLoggingEnum;
import net.minecraft.block.BlockState;
import twilightforest.util.TFItemStackUtils;
import twilightforest.block.KeepsakeCasketBlock;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraft.world.GameRules;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraft.entity.Entity;
import twilightforest.block.CritterBlock;
import net.minecraft.util.DamageSource;
import net.minecraft.potion.EffectInstance;
import twilightforest.potions.TFPotions;
import net.minecraft.potion.Effect;
import net.minecraft.entity.LivingEntity;
import twilightforest.enchantment.TFEnchantment;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import net.minecraft.inventory.IInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraft.util.IItemProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.block.Blocks;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraft.item.Item;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraftforge.common.ForgeMod;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.inventory.EquipmentSlotType;
import twilightforest.item.TFItems;
import net.minecraftforge.event.ItemAttributeModifierEvent;
import net.minecraft.entity.player.PlayerInventory;
import java.util.UUID;
import java.util.Map;
import com.google.common.collect.ImmutableSet;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "twilightforest")
public class TFEventListener
{
    private static final ImmutableSet<String> SHIELD_DAMAGE_BLACKLIST;
    private static final Map<UUID, PlayerInventory> playerKeepsMap;
    private static boolean isBreakingWithGiantPick;
    private static boolean shouldMakeGiantCobble;
    private static int amountOfCobbleToReplace;
    private static boolean casketExpiration;
    private static final String NBT_TAG_TWILIGHT = "twilightforest_banished";
    private static boolean globalParry;
    
    @SubscribeEvent
    public static void addReach(final ItemAttributeModifierEvent event) {
        final Item item = event.getItemStack().func_77973_b();
        if ((item == TFItems.giant_pickaxe.get() || item == TFItems.giant_sword.get()) && event.getSlotType() == EquipmentSlotType.MAINHAND) {
            event.addModifier((Attribute)ForgeMod.REACH_DISTANCE.get(), new AttributeModifier(TFItems.GIANT_REACH_MODIFIER, "Tool modifier", 2.5, AttributeModifier.Operation.ADDITION));
        }
    }
    
    @SubscribeEvent
    public static void onCrafting(final PlayerEvent.ItemCraftedEvent event) {
        final ItemStack itemStack = event.getCrafting();
        final PlayerEntity player = event.getPlayer();
        if (itemStack.func_77973_b() == Item.func_150898_a(Blocks.field_196662_n) && itemStack.func_190916_E() == 64 && doesCraftMatrixHaveGiantLog(event.getInventory())) {
            ItemHandlerHelper.giveItemToPlayer(player, new ItemStack((IItemProvider)Blocks.field_196662_n, 64));
            ItemHandlerHelper.giveItemToPlayer(player, new ItemStack((IItemProvider)Blocks.field_196662_n, 64));
            ItemHandlerHelper.giveItemToPlayer(player, new ItemStack((IItemProvider)Blocks.field_196662_n, 64));
        }
    }
    
    private static boolean doesCraftMatrixHaveGiantLog(final IInventory inv) {
        final Item giantLogItem = Item.func_150898_a((Block)TFBlocks.giant_log.get());
        for (int i = 0; i < inv.func_70302_i_(); ++i) {
            if (inv.func_70301_a(i).func_77973_b() == giantLogItem) {
                return true;
            }
        }
        return false;
    }
    
    @SubscribeEvent
    public static void entityHurts(final LivingHurtEvent event) {
        final LivingEntity living = event.getEntityLiving();
        final DamageSource damageSource = event.getSource();
        final String damageType = damageSource.func_76355_l();
        final Entity trueSource = damageSource.func_76346_g();
        if (living instanceof PlayerEntity && damageType.equals("mob") && trueSource != null) {
            final PlayerEntity player = (PlayerEntity)living;
            final int fireLevel = TFEnchantment.getFieryAuraLevel(player.field_71071_by, damageSource);
            if (fireLevel > 0 && player.func_70681_au().nextInt(25) < fireLevel) {
                trueSource.func_70015_d(fireLevel / 2);
            }
        }
        if (living instanceof PlayerEntity && damageType.equals("mob") && trueSource instanceof LivingEntity) {
            final PlayerEntity player = (PlayerEntity)living;
            final int chillLevel = TFEnchantment.getChillAuraLevel(player.field_71071_by, damageSource);
            if (chillLevel > 0) {
                ((LivingEntity)trueSource).func_195064_c(new EffectInstance((Effect)TFPotions.frosty.get(), chillLevel * 5 + 5, chillLevel));
            }
        }
        if (damageType.equals("arrow") && trueSource instanceof PlayerEntity) {
            final PlayerEntity player = (PlayerEntity)trueSource;
            if (player.func_184614_ca().func_77973_b() == TFItems.triple_bow.get() || player.func_184592_cb().func_77973_b() == TFItems.triple_bow.get()) {
                living.field_70172_ad = 0;
            }
        }
        if (damageSource != DamageSource.field_76379_h && damageSource != DamageSource.field_76369_e && damageSource != DamageSource.field_220302_v) {
            final ItemStack stack = living.func_184582_a(EquipmentSlotType.HEAD);
            final Block block = Block.func_149634_a(stack.func_77973_b());
            if (block instanceof CritterBlock) {
                final CritterBlock poorBug = (CritterBlock)block;
                living.func_184201_a(EquipmentSlotType.HEAD, poorBug.getSquishResult());
                living.field_70170_p.func_184148_a((PlayerEntity)null, living.func_226277_ct_(), living.func_226278_cu_(), living.func_226281_cx_(), TFSounds.BUG_SQUISH, living.func_184176_by(), 1.0f, 1.0f);
            }
        }
        if (living instanceof PlayerEntity && isRidingUnfriendly(living) && damageSource == DamageSource.field_76368_d) {
            event.setCanceled(true);
        }
    }
    
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void applyDeathItems(final LivingDeathEvent event) {
        final LivingEntity living = event.getEntityLiving();
        if (living.field_70170_p.field_72995_K || !(living instanceof PlayerEntity) || living instanceof FakePlayer) {
            return;
        }
        final PlayerEntity player = (PlayerEntity)living;
        if (charmOfLife(player)) {
            event.setCanceled(true);
        }
        else if (!living.field_70170_p.func_82736_K().func_223586_b(GameRules.field_223600_c)) {
            charmOfKeeping(player);
            keepsakeCasket(player);
        }
    }
    
    private static void keepsakeCasket(final PlayerEntity player) {
        final boolean casketConsumed = TFItemStackUtils.consumeInventoryItem(player, ((KeepsakeCasketBlock)TFBlocks.keepsake_casket.get()).func_199767_j());
        if (casketConsumed) {
            final World world = player.func_130014_f_();
            final BlockPos.Mutable pos = player.func_233580_cy_().func_239590_i_();
            if (pos.func_177956_o() < 2) {
                pos.func_185336_p(2);
            }
            else {
                final int logicalHeight = player.func_130014_f_().func_230315_m_().func_241513_m_();
                if (pos.func_177956_o() > logicalHeight) {
                    pos.func_185336_p(logicalHeight - 1);
                }
            }
            final BlockPos immutablePos = pos.func_185334_h();
            final FluidState fluidState = world.func_204610_c(immutablePos);
            if (world.func_175656_a(immutablePos, (BlockState)((BlockState)((KeepsakeCasketBlock)TFBlocks.keepsake_casket.get()).func_176223_P().func_206870_a((Property)BlockLoggingEnum.MULTILOGGED, (Comparable)BlockLoggingEnum.getFromFluid(fluidState.func_206886_c()))).func_206870_a((Property)KeepsakeCasketBlock.BREAKAGE, (Comparable)TFItemStackUtils.damage))) {
                final TileEntity te = world.func_175625_s(immutablePos);
                if (te instanceof KeepsakeCasketTileEntity) {
                    final KeepsakeCasketTileEntity casket = (KeepsakeCasketTileEntity)te;
                    if (TFConfig.COMMON_CONFIG.casketUUIDLocking.get()) {
                        casket.playeruuid = player.func_146103_bH().getId();
                    }
                    else {
                        casket.playeruuid = null;
                    }
                    String modifiedName;
                    if (player.func_200200_C_().getString().length() > 12) {
                        modifiedName = player.func_200200_C_().getString().substring(0, 12);
                    }
                    else {
                        modifiedName = player.func_200200_C_().getString();
                    }
                    casket.name = player.func_200200_C_().getString();
                    casket.casketname = modifiedName;
                    casket.func_213903_a((ITextComponent)new StringTextComponent(modifiedName + "'s " + ((world.field_73012_v.nextInt(10000) == 0) ? "Costco Casket" : casket.func_145748_c_().getString())));
                    int damage = (int)world.func_180495_p(immutablePos).func_177229_b((Property)KeepsakeCasketBlock.BREAKAGE);
                    if (world.field_73012_v.nextFloat() <= 0.15f) {
                        if (damage >= 2) {
                            player.field_71071_by.func_70436_m();
                            world.func_175656_a(immutablePos, Blocks.field_150350_a.func_176223_P());
                            TFEventListener.casketExpiration = true;
                            TwilightForestMod.LOGGER.debug("{}'s Casket damage value was too high, alerting the player and dropping extra items", (Object)player.func_200200_C_().getString());
                        }
                        else {
                            ++damage;
                            world.func_175656_a(immutablePos, (BlockState)((BlockState)((KeepsakeCasketBlock)TFBlocks.keepsake_casket.get()).func_176223_P().func_206870_a((Property)BlockLoggingEnum.MULTILOGGED, (Comparable)BlockLoggingEnum.getFromFluid(fluidState.func_206886_c()))).func_206870_a((Property)KeepsakeCasketBlock.BREAKAGE, (Comparable)damage));
                            TwilightForestMod.LOGGER.debug("{}'s Casket was randomly damaged, applying new damage", (Object)player.func_200200_C_().getString());
                        }
                    }
                    final int casketCapacity = casket.func_70302_i_();
                    final List<ItemStack> list = new ArrayList<ItemStack>(casketCapacity);
                    final NonNullList<ItemStack> filler = (NonNullList<ItemStack>)NonNullList.func_191197_a(4, (Object)ItemStack.field_190927_a);
                    list.addAll((Collection<? extends ItemStack>)TFItemStackUtils.sortArmorForCasket(player));
                    player.field_71071_by.field_70460_b.clear();
                    list.addAll((Collection<? extends ItemStack>)filler);
                    list.addAll((Collection<? extends ItemStack>)player.field_71071_by.field_184439_c);
                    player.field_71071_by.field_184439_c.clear();
                    list.addAll((Collection<? extends ItemStack>)TFItemStackUtils.sortInvForCasket(player));
                    player.field_71071_by.field_70462_a.clear();
                    casket.func_199721_a((NonNullList<ItemStack>)NonNullList.func_193580_a((Object)ItemStack.field_190927_a, (Object[])list.toArray(new ItemStack[casketCapacity])));
                }
            }
            else {
                TwilightForestMod.LOGGER.error("Could not place Keepsake Casket at " + pos.toString());
            }
        }
    }
    
    @SubscribeEvent
    public static void onCasketBreak(final BlockEvent.BreakEvent event) {
        final Block block = event.getState().func_177230_c();
        final PlayerEntity player = event.getPlayer();
        final TileEntity te = event.getWorld().func_175625_s(event.getPos());
        if (block == TFBlocks.keepsake_casket.get()) {
            UUID checker;
            if (te instanceof KeepsakeCasketTileEntity) {
                final KeepsakeCasketTileEntity casket = (KeepsakeCasketTileEntity)te;
                checker = casket.playeruuid;
            }
            else {
                checker = null;
            }
            if (checker != null && !((KeepsakeCasketTileEntity)te).func_191420_l() && (!player.func_211513_k(3) || !player.func_146103_bH().getId().equals(checker))) {
                event.setCanceled(true);
            }
        }
    }
    
    private static boolean charmOfLife(final PlayerEntity player) {
        final boolean charm2 = TFItemStackUtils.consumeInventoryItem(player, (Item)TFItems.charm_of_life_2.get());
        final boolean charm3 = !charm2 && TFItemStackUtils.consumeInventoryItem(player, (Item)TFItems.charm_of_life_1.get());
        if (charm2 || charm3) {
            if (charm3) {
                player.func_70606_j(8.0f);
                player.func_195064_c(new EffectInstance(Effects.field_76428_l, 100, 0));
            }
            if (charm2) {
                player.func_70606_j((float)player.func_110148_a(Attributes.field_233818_a_).func_111125_b());
                player.func_195064_c(new EffectInstance(Effects.field_76428_l, 600, 3));
                player.func_195064_c(new EffectInstance(Effects.field_76429_m, 600, 0));
                player.func_195064_c(new EffectInstance(Effects.field_76426_n, 600, 0));
            }
            final CharmEffectEntity effect = new CharmEffectEntity(TFEntities.charm_effect, player.field_70170_p, (LivingEntity)player, charm3 ? ((Item)TFItems.charm_of_life_1.get()) : ((Item)TFItems.charm_of_life_2.get()));
            player.field_70170_p.func_217376_c((Entity)effect);
            final CharmEffectEntity effect2 = new CharmEffectEntity(TFEntities.charm_effect, player.field_70170_p, (LivingEntity)player, charm3 ? ((Item)TFItems.charm_of_life_1.get()) : ((Item)TFItems.charm_of_life_2.get()));
            effect2.offset = 3.1415927f;
            player.field_70170_p.func_217376_c((Entity)effect2);
            player.field_70170_p.func_184148_a((PlayerEntity)null, player.func_226277_ct_(), player.func_226278_cu_(), player.func_226281_cx_(), TFSounds.CHARM_LIFE, player.func_184176_by(), 1.0f, 1.0f);
            return true;
        }
        return false;
    }
    
    private static void charmOfKeeping(final PlayerEntity player) {
        dropStoredItems(player);
        final boolean tier3 = TFItemStackUtils.consumeInventoryItem(player, (Item)TFItems.charm_of_keeping_3.get());
        final boolean tier4 = tier3 || TFItemStackUtils.consumeInventoryItem(player, (Item)TFItems.charm_of_keeping_2.get());
        final boolean tier5 = tier4 || TFItemStackUtils.consumeInventoryItem(player, (Item)TFItems.charm_of_keeping_1.get());
        final PlayerInventory keepInventory = new PlayerInventory((PlayerEntity)null);
        final UUID playerUUID = player.func_110124_au();
        if (tier5) {
            keepAllArmor(player, keepInventory);
            keepOffHand(player, keepInventory);
        }
        if (tier3) {
            for (int i = 0; i < player.field_71071_by.field_70462_a.size(); ++i) {
                keepInventory.field_70462_a.set(i, (Object)((ItemStack)player.field_71071_by.field_70462_a.get(i)).func_77946_l());
                player.field_71071_by.field_70462_a.set(i, (Object)ItemStack.field_190927_a);
            }
            keepInventory.func_70437_b(new ItemStack((IItemProvider)TFItems.charm_of_keeping_3.get()));
        }
        else if (tier4) {
            for (int i = 0; i < 9; ++i) {
                keepInventory.field_70462_a.set(i, (Object)((ItemStack)player.field_71071_by.field_70462_a.get(i)).func_77946_l());
                player.field_71071_by.field_70462_a.set(i, (Object)ItemStack.field_190927_a);
            }
            keepInventory.func_70437_b(new ItemStack((IItemProvider)TFItems.charm_of_keeping_2.get()));
        }
        else if (tier5) {
            final int i = player.field_71071_by.field_70461_c;
            if (PlayerInventory.func_184435_e(i)) {
                keepInventory.field_70462_a.set(i, (Object)((ItemStack)player.field_71071_by.field_70462_a.get(i)).func_77946_l());
                player.field_71071_by.field_70462_a.set(i, (Object)ItemStack.field_190927_a);
            }
            keepInventory.func_70437_b(new ItemStack((IItemProvider)TFItems.charm_of_keeping_1.get()));
        }
        for (int i = 0; i < player.field_71071_by.field_70462_a.size(); ++i) {
            final ItemStack stack = (ItemStack)player.field_71071_by.field_70462_a.get(i);
            if (stack.func_77973_b() == TFItems.tower_key.get()) {
                keepInventory.field_70462_a.set(i, (Object)stack.func_77946_l());
                player.field_71071_by.field_70462_a.set(i, (Object)ItemStack.field_190927_a);
            }
            if (stack.func_77973_b() instanceof PhantomArmorItem) {
                keepInventory.field_70462_a.set(i, (Object)stack.func_77946_l());
                player.field_71071_by.field_70462_a.set(i, (Object)ItemStack.field_190927_a);
            }
        }
        for (int i = 0; i < player.field_71071_by.field_70460_b.size(); ++i) {
            final ItemStack armor = (ItemStack)player.field_71071_by.field_70460_b.get(i);
            if (armor.func_77973_b() instanceof PhantomArmorItem) {
                keepInventory.field_70460_b.set(i, (Object)armor.func_77946_l());
                player.field_71071_by.field_70460_b.set(i, (Object)ItemStack.field_190927_a);
            }
        }
        TFEventListener.playerKeepsMap.put(playerUUID, keepInventory);
    }
    
    private static void keepAllArmor(final PlayerEntity player, final PlayerInventory keepInventory) {
        for (int i = 0; i < player.field_71071_by.field_70460_b.size(); ++i) {
            keepInventory.field_70460_b.set(i, (Object)((ItemStack)player.field_71071_by.field_70460_b.get(i)).func_77946_l());
            player.field_71071_by.field_70460_b.set(i, (Object)ItemStack.field_190927_a);
        }
    }
    
    private static void keepOffHand(final PlayerEntity player, final PlayerInventory keepInventory) {
        for (int i = 0; i < player.field_71071_by.field_184439_c.size(); ++i) {
            keepInventory.field_184439_c.set(i, (Object)((ItemStack)player.field_71071_by.field_184439_c.get(i)).func_77946_l());
            player.field_71071_by.field_184439_c.set(i, (Object)ItemStack.field_190927_a);
        }
    }
    
    @SubscribeEvent
    public static void onPlayerRespawn(final PlayerEvent.PlayerRespawnEvent event) {
        if (event.isEndConquered()) {
            updateCapabilities((ServerPlayerEntity)event.getPlayer(), (Entity)event.getPlayer());
        }
        else {
            if (TFEventListener.casketExpiration) {
                event.getPlayer().func_145747_a((ITextComponent)new TranslationTextComponent("block.twilightforest.casket.broken").func_240699_a_(TextFormatting.DARK_RED), event.getPlayer().func_110124_au());
            }
            returnStoredItems(event.getPlayer());
        }
    }
    
    private static void returnStoredItems(final PlayerEntity player) {
        final PlayerInventory keepInventory = TFEventListener.playerKeepsMap.remove(player.func_110124_au());
        if (keepInventory != null) {
            TwilightForestMod.LOGGER.debug("Player {} ({}) respawned and received items held in storage", (Object)player.func_200200_C_().getString(), (Object)player.func_110124_au());
            final NonNullList<ItemStack> displaced = (NonNullList<ItemStack>)NonNullList.func_191196_a();
            for (int i = 0; i < player.field_71071_by.field_70460_b.size(); ++i) {
                final ItemStack kept = (ItemStack)keepInventory.field_70460_b.get(i);
                if (!kept.func_190926_b()) {
                    final ItemStack existing = (ItemStack)player.field_71071_by.field_70460_b.set(i, (Object)kept);
                    if (!existing.func_190926_b()) {
                        displaced.add((Object)existing);
                    }
                }
            }
            for (int i = 0; i < player.field_71071_by.field_184439_c.size(); ++i) {
                final ItemStack kept = (ItemStack)keepInventory.field_184439_c.get(i);
                if (!kept.func_190926_b()) {
                    final ItemStack existing = (ItemStack)player.field_71071_by.field_184439_c.set(i, (Object)kept);
                    if (!existing.func_190926_b()) {
                        displaced.add((Object)existing);
                    }
                }
            }
            for (int i = 0; i < player.field_71071_by.field_70462_a.size(); ++i) {
                final ItemStack kept = (ItemStack)keepInventory.field_70462_a.get(i);
                if (!kept.func_190926_b()) {
                    final ItemStack existing = (ItemStack)player.field_71071_by.field_70462_a.set(i, (Object)kept);
                    if (!existing.func_190926_b()) {
                        displaced.add((Object)existing);
                    }
                }
            }
            for (final ItemStack extra : displaced) {
                ItemHandlerHelper.giveItemToPlayer(player, extra);
            }
            if (!keepInventory.func_70445_o().func_190926_b()) {
                final CharmEffectEntity effect = new CharmEffectEntity(TFEntities.charm_effect, player.field_70170_p, (LivingEntity)player, keepInventory.func_70445_o().func_77973_b());
                player.field_70170_p.func_217376_c((Entity)effect);
                final CharmEffectEntity effect2 = new CharmEffectEntity(TFEntities.charm_effect, player.field_70170_p, (LivingEntity)player, keepInventory.func_70445_o().func_77973_b());
                effect2.offset = 3.1415927f;
                player.field_70170_p.func_217376_c((Entity)effect2);
                player.field_70170_p.func_184148_a((PlayerEntity)null, player.func_226277_ct_(), player.func_226278_cu_(), player.func_226281_cx_(), TFSounds.CHARM_KEEP, player.func_184176_by(), 1.5f, 1.0f);
            }
        }
    }
    
    @SubscribeEvent
    public static void onPlayerLogout(final PlayerEvent.PlayerLoggedOutEvent event) {
        dropStoredItems(event.getPlayer());
    }
    
    private static void dropStoredItems(final PlayerEntity player) {
        final PlayerInventory keepInventory = TFEventListener.playerKeepsMap.remove(player.func_110124_au());
        if (keepInventory != null) {
            TwilightForestMod.LOGGER.warn("Dropping inventory items previously held in reserve for player {} ({})", (Object)player.func_200200_C_().getString(), (Object)player.func_110124_au());
            keepInventory.field_70458_d = player;
            keepInventory.func_70436_m();
        }
    }
    
    @SubscribeEvent
    public static void livingUpdate(final LivingEvent.LivingUpdateEvent event) {
        final LivingEntity living = event.getEntityLiving();
        living.getCapability((Capability)CapabilityList.SHIELDS).ifPresent(IShieldCapability::update);
        if (living instanceof PlayerEntity && living.func_225608_bj_() && isRidingUnfriendly(living)) {
            living.func_226284_e_(false);
        }
    }
    
    public static boolean isRidingUnfriendly(final LivingEntity entity) {
        return entity.func_184218_aH() && entity.func_184187_bx() instanceof IHostileMount;
    }
    
    @SubscribeEvent
    public static void breakBlock(final BlockEvent.BreakEvent event) {
        final PlayerEntity player = event.getPlayer();
        final BlockPos pos = event.getPos();
        final BlockState state = event.getState();
        if (!(event.getWorld() instanceof World) || ((World)event.getWorld()).field_72995_K) {
            return;
        }
        final World world = (World)event.getWorld();
        if (isBlockProtectedFromBreaking(world, pos) && isAreaProtected(world, player, pos)) {
            event.setCanceled(true);
        }
        else if (!TFEventListener.isBreakingWithGiantPick && canHarvestWithGiantPick(player, state)) {
            TFEventListener.isBreakingWithGiantPick = true;
            final Item cobbleItem = Blocks.field_150347_e.func_199767_j();
            boolean allCobble = state.func_177230_c().func_199767_j() == cobbleItem;
            if (allCobble) {
                for (final BlockPos dPos : GiantBlock.getVolume(pos)) {
                    if (dPos.equals((Object)pos)) {
                        continue;
                    }
                    final BlockState stateThere = world.func_180495_p(dPos);
                    if (stateThere.func_177230_c().func_199767_j() != cobbleItem) {
                        allCobble = false;
                        break;
                    }
                }
            }
            if (allCobble && !player.field_71075_bZ.field_75098_d) {
                TFEventListener.shouldMakeGiantCobble = true;
                TFEventListener.amountOfCobbleToReplace = 64;
            }
            else {
                TFEventListener.shouldMakeGiantCobble = false;
                TFEventListener.amountOfCobbleToReplace = 0;
            }
            if (player instanceof ServerPlayerEntity) {
                final ServerPlayerEntity playerMP = (ServerPlayerEntity)player;
                for (final BlockPos dPos2 : GiantBlock.getVolume(pos)) {
                    if (!dPos2.equals((Object)pos) && state == world.func_180495_p(dPos2)) {
                        playerMP.field_71134_c.func_180237_b(dPos2);
                    }
                }
            }
            TFEventListener.isBreakingWithGiantPick = false;
        }
    }
    
    private static boolean canHarvestWithGiantPick(final PlayerEntity player, final BlockState state) {
        final ItemStack heldStack = player.func_184614_ca();
        final Item heldItem = heldStack.func_77973_b();
        return heldItem == TFItems.giant_pickaxe.get() && heldItem.canHarvestBlock(heldStack, state);
    }
    
    @SubscribeEvent
    public static void onPlayerRightClick(final PlayerInteractEvent.RightClickBlock event) {
        final PlayerEntity player = event.getPlayer();
        final World world = player.field_70170_p;
        if (!world.field_72995_K && isBlockProtectedFromInteraction(world, event.getPos()) && isAreaProtected(world, player, event.getPos())) {
            event.setUseBlock(Event.Result.DENY);
        }
    }
    
    private static boolean isBlockProtectedFromInteraction(final World world, final BlockPos pos) {
        final Block block = world.func_180495_p(pos).func_177230_c();
        return block.func_203417_a((ITag)BlockTagGenerator.STRUCTURE_BANNED_INTERACTIONS);
    }
    
    private static boolean isBlockProtectedFromBreaking(final World world, final BlockPos pos) {
        return !world.func_180495_p(pos).func_177230_c().getRegistryName().func_110623_a().contains("grave") || !world.func_180495_p(pos).func_177230_c().func_235332_a_((Block)TFBlocks.keepsake_casket.get());
    }
    
    private static boolean isAreaProtected(final World world, final PlayerEntity player, final BlockPos pos) {
        if (player.field_71075_bZ.field_75098_d || !TFGenerationSettings.isProgressionEnforced(world) || player instanceof FakePlayer) {
            return false;
        }
        final ChunkGeneratorTwilightBase chunkGenerator = TFGenerationSettings.getChunkGenerator(world);
        if (chunkGenerator != null) {
            final Optional<StructureStart<?>> struct = TFGenerationSettings.locateTFStructureInRange((ISeedReader)world, pos, 0);
            if (struct.isPresent()) {
                final StructureStart<?> structure = struct.get();
                if (structure.func_75071_a().func_175898_b((Vector3i)pos)) {
                    final TFFeature nearbyFeature = TFFeature.getFeatureAt(pos.func_177958_n(), pos.func_177952_p(), (ISeedReader)world);
                    if (!nearbyFeature.doesPlayerHaveRequiredAdvancements(player)) {
                        if (nearbyFeature == TFFeature.KNIGHT_STRONGHOLD && pos.func_177956_o() >= 33) {
                            return false;
                        }
                        final MutableBoundingBox bb = structure.func_75071_a();
                        sendAreaProtectionPacket(world, pos, bb);
                        nearbyFeature.trySpawnHintMonster(world, player, pos);
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private static void sendAreaProtectionPacket(final World world, final BlockPos pos, final MutableBoundingBox sbb) {
        final PacketDistributor.TargetPoint targetPoint = new PacketDistributor.TargetPoint((double)pos.func_177958_n(), (double)pos.func_177956_o(), (double)pos.func_177952_p(), 64.0, world.func_234923_W_());
        TFPacketHandler.CHANNEL.send(PacketDistributor.NEAR.with(() -> targetPoint), (Object)new AreaProtectionPacket(sbb, pos));
    }
    
    @SubscribeEvent
    public static void livingAttack(final LivingAttackEvent event) {
        final LivingEntity living = event.getEntityLiving();
        if (!living.field_70170_p.field_72995_K && living instanceof IMob && event.getSource().func_76346_g() instanceof PlayerEntity && isAreaProtected(living.field_70170_p, (PlayerEntity)event.getSource().func_76346_g(), new BlockPos((Vector3i)living.func_233580_cy_()))) {
            event.setCanceled(true);
            return;
        }
        if (!living.field_70170_p.field_72995_K && !TFEventListener.SHIELD_DAMAGE_BLACKLIST.contains((Object)event.getSource().field_76373_n)) {
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
        if (!event.getPlayer().field_70170_p.field_72995_K && event.getPlayer() instanceof ServerPlayerEntity) {
            sendEnforcedProgressionStatus((ServerPlayerEntity)event.getPlayer(), TFGenerationSettings.isProgressionEnforced(event.getPlayer().field_70170_p));
            updateCapabilities((ServerPlayerEntity)event.getPlayer(), (Entity)event.getPlayer());
            banishNewbieToTwilightZone(event.getPlayer());
        }
    }
    
    @SubscribeEvent
    public static void playerPortals(final PlayerEvent.PlayerChangedDimensionEvent event) {
        if (!event.getPlayer().field_70170_p.field_72995_K && event.getPlayer() instanceof ServerPlayerEntity) {
            if (event.getTo().func_240901_a_().toString().equals(TFConfig.COMMON_CONFIG.DIMENSION.twilightForestID.get())) {
                sendEnforcedProgressionStatus((ServerPlayerEntity)event.getPlayer(), TFGenerationSettings.isProgressionEnforced(event.getPlayer().field_70170_p));
            }
            updateCapabilities((ServerPlayerEntity)event.getPlayer(), (Entity)event.getPlayer());
        }
    }
    
    @SubscribeEvent
    public static void onStartTracking(final PlayerEvent.StartTracking event) {
        updateCapabilities((ServerPlayerEntity)event.getPlayer(), event.getTarget());
    }
    
    private static void updateCapabilities(final ServerPlayerEntity player, final Entity entity) {
        entity.getCapability((Capability)CapabilityList.SHIELDS).ifPresent(cap -> {
            if (cap.shieldsLeft() > 0) {
                TFPacketHandler.CHANNEL.send(PacketDistributor.PLAYER.with(() -> player), (Object)new UpdateShieldPacket(entity, cap));
            }
        });
    }
    
    private static void sendEnforcedProgressionStatus(final ServerPlayerEntity player, final boolean isEnforced) {
        TFPacketHandler.CHANNEL.send(PacketDistributor.PLAYER.with(() -> player), (Object)new EnforceProgressionStatusPacket(isEnforced));
    }
    
    private static void sendSkylightEnabled(final ServerPlayerEntity player, final boolean skylightEnabled) {
        TFPacketHandler.CHANNEL.send(PacketDistributor.PLAYER.with(() -> player), (Object)new SetSkylightEnabledPacket(skylightEnabled));
    }
    
    @SubscribeEvent
    public static void onClientConnect(final PlayerEvent.PlayerLoggedInEvent event) {
        final ServerPlayerEntity player = (ServerPlayerEntity)event.getPlayer();
    }
    
    @SubscribeEvent
    public static void worldLoaded(final WorldEvent.Load event) {
        final IWorld world = event.getWorld();
        if (!world.func_201670_d() && world instanceof World && !((GameRules.BooleanValue)((World)world).func_82736_K().func_223585_a((GameRules.RuleKey)TwilightForestMod.ENFORCED_PROGRESSION_RULE)).func_223572_a()) {
            TwilightForestMod.LOGGER.info("Loaded a world with the {} game rule not defined. Defining it.", (Object)TwilightForestMod.ENFORCED_PROGRESSION_RULE);
            ((GameRules.BooleanValue)((World)world).func_82736_K().func_223585_a((GameRules.RuleKey)TwilightForestMod.ENFORCED_PROGRESSION_RULE)).func_223570_a((boolean)TFConfig.COMMON_CONFIG.progressionRuleDefault.get(), ((World)world).func_73046_m());
        }
    }
    
    private static void banishNewbieToTwilightZone(final PlayerEntity player) {
        final CompoundNBT tagCompound = player.getPersistentData();
        final CompoundNBT playerData = tagCompound.func_74775_l("PlayerPersisted");
        final boolean shouldBanishPlayer = (boolean)TFConfig.COMMON_CONFIG.DIMENSION.newPlayersSpawnInTF.get() && !playerData.func_74767_n("twilightforest_banished");
        playerData.func_74757_a("twilightforest_banished", true);
        tagCompound.func_218657_a("PlayerPersisted", (INBT)playerData);
        if (shouldBanishPlayer) {
            TFPortalBlock.attemptSendPlayer((Entity)player, true);
        }
    }
    
    @SubscribeEvent
    public static void onAdvancementGet(final AdvancementEvent event) {
        final PlayerEntity player = event.getPlayer();
        if (player instanceof ServerPlayerEntity) {
            TFAdvancements.ADVANCEMENT_UNLOCKED.trigger((ServerPlayerEntity)player, event.getAdvancement());
        }
    }
    
    @SubscribeEvent
    public static void armorChanged(final LivingEquipmentChangeEvent event) {
        final LivingEntity living = event.getEntityLiving();
        if (!living.field_70170_p.field_72995_K && living instanceof ServerPlayerEntity) {
            TFAdvancements.ARMOR_CHANGED.trigger((ServerPlayerEntity)living, event.getFrom(), event.getTo());
        }
    }
    
    @SubscribeEvent
    public static void arrowParry(final ProjectileImpactEvent.Arrow event) {
        final AbstractArrowEntity projectile = event.getArrow();
        if (!projectile.func_130014_f_().field_72995_K && TFEventListener.globalParry && ((boolean)TFConfig.COMMON_CONFIG.SHIELD_INTERACTIONS.parryNonTwilightAttacks.get() || projectile instanceof ITFProjectile) && event.getRayTraceResult() instanceof EntityRayTraceResult) {
            final Entity entity = ((EntityRayTraceResult)event.getRayTraceResult()).func_216348_a();
            if (event.getEntity() != null && entity instanceof LivingEntity) {
                final LivingEntity entityBlocking = (LivingEntity)entity;
                if (entityBlocking.func_184583_d((DamageSource)new DamageSource("parry_this") {
                    public Vector3d func_188404_v() {
                        return projectile.func_213303_ch();
                    }
                }) && entityBlocking.func_184607_cu().func_77973_b().func_77626_a(entityBlocking.func_184607_cu()) - entityBlocking.func_184605_cv() <= (int)TFConfig.COMMON_CONFIG.SHIELD_INTERACTIONS.shieldParryTicksArrow.get()) {
                    final Vector3d playerVec3 = entityBlocking.func_70040_Z();
                    projectile.func_70186_c(playerVec3.field_72450_a, playerVec3.field_72448_b, playerVec3.field_72449_c, 1.1f, 0.1f);
                    projectile.func_212361_a((Entity)entityBlocking);
                    event.setCanceled(true);
                }
            }
        }
    }
    
    @SubscribeEvent
    public static void fireballParry(final ProjectileImpactEvent.Fireball event) {
        final DamagingProjectileEntity projectile = event.getFireball();
        if (!projectile.func_130014_f_().field_72995_K && TFEventListener.globalParry && ((boolean)TFConfig.COMMON_CONFIG.SHIELD_INTERACTIONS.parryNonTwilightAttacks.get() || projectile instanceof ITFProjectile) && event.getRayTraceResult() instanceof EntityRayTraceResult) {
            final Entity entity = ((EntityRayTraceResult)event.getRayTraceResult()).func_216348_a();
            if (event.getEntity() != null && entity instanceof LivingEntity) {
                final LivingEntity entityBlocking = (LivingEntity)entity;
                if (entityBlocking.func_184583_d((DamageSource)new DamageSource("parry_this") {
                    public Vector3d func_188404_v() {
                        return projectile.func_213303_ch();
                    }
                }) && entityBlocking.func_184607_cu().func_77973_b().func_77626_a(entityBlocking.func_184607_cu()) - entityBlocking.func_184605_cv() <= (int)TFConfig.COMMON_CONFIG.SHIELD_INTERACTIONS.shieldParryTicksFireball.get()) {
                    final Vector3d playerVec3 = entityBlocking.func_70040_Z();
                    projectile.func_213317_d(new Vector3d(playerVec3.field_72450_a, playerVec3.field_72448_b, playerVec3.field_72449_c));
                    projectile.field_70232_b = projectile.func_213322_ci().func_82615_a() * 0.1;
                    projectile.field_70233_c = projectile.func_213322_ci().func_82617_b() * 0.1;
                    projectile.field_70230_d = projectile.func_213322_ci().func_82616_c() * 0.1;
                    projectile.func_212361_a((Entity)entityBlocking);
                    event.setCanceled(true);
                }
            }
        }
    }
    
    @SubscribeEvent
    public static void throwableParry(final ProjectileImpactEvent.Throwable event) {
        final ThrowableEntity projectile = event.getThrowable();
        if (!projectile.func_130014_f_().field_72995_K && TFEventListener.globalParry && ((boolean)TFConfig.COMMON_CONFIG.SHIELD_INTERACTIONS.parryNonTwilightAttacks.get() || projectile instanceof ITFProjectile) && event.getRayTraceResult() instanceof EntityRayTraceResult) {
            final Entity entity = ((EntityRayTraceResult)event.getRayTraceResult()).func_216348_a();
            if (event.getEntity() != null && entity instanceof LivingEntity) {
                final LivingEntity entityBlocking = (LivingEntity)entity;
                if (entityBlocking.func_184583_d((DamageSource)new DamageSource("parry_this") {
                    public Vector3d func_188404_v() {
                        return projectile.func_213303_ch();
                    }
                }) && entityBlocking.func_184607_cu().func_77973_b().func_77626_a(entityBlocking.func_184607_cu()) - entityBlocking.func_184605_cv() <= (int)TFConfig.COMMON_CONFIG.SHIELD_INTERACTIONS.shieldParryTicksThrowable.get()) {
                    final Vector3d playerVec3 = entityBlocking.func_70040_Z();
                    projectile.func_70186_c(playerVec3.field_72450_a, playerVec3.field_72448_b, playerVec3.field_72449_c, 1.1f, 0.1f);
                    projectile.func_212361_a((Entity)entityBlocking);
                    event.setCanceled(true);
                }
            }
        }
    }
    
    static {
        SHIELD_DAMAGE_BLACKLIST = ImmutableSet.of((Object)"inWall", (Object)"cramming", (Object)"drown", (Object)"starve", (Object)"fall", (Object)"flyIntoWall", (Object[])new String[] { "outOfWorld", "fallingBlock" });
        playerKeepsMap = new HashMap<UUID, PlayerInventory>();
        TFEventListener.isBreakingWithGiantPick = false;
        TFEventListener.shouldMakeGiantCobble = false;
        TFEventListener.amountOfCobbleToReplace = 0;
        TFEventListener.casketExpiration = false;
        TFEventListener.globalParry = !ModList.get().isLoaded("parry");
    }
    
    public static class ManipulateDrops extends LootModifier
    {
        protected ManipulateDrops(final ILootCondition[] conditionsIn) {
            super(conditionsIn);
        }
        
        @Nonnull
        protected List<ItemStack> doApply(final List<ItemStack> generatedLoot, final LootContext context) {
            final List<ItemStack> newLoot = new ArrayList<ItemStack>();
            boolean flag = false;
            if (TFEventListener.shouldMakeGiantCobble && generatedLoot.size() > 0 && generatedLoot.get(0).func_77973_b() == Item.func_150898_a(Blocks.field_150347_e)) {
                generatedLoot.remove(0);
                if (TFEventListener.amountOfCobbleToReplace == 64) {
                    newLoot.add(new ItemStack((IItemProvider)TFBlocks.giant_cobblestone.get()));
                    flag = true;
                }
                TFEventListener.amountOfCobbleToReplace--;
                if (TFEventListener.amountOfCobbleToReplace <= 0) {
                    TFEventListener.shouldMakeGiantCobble = false;
                }
            }
            return flag ? newLoot : generatedLoot;
        }
    }
    
    public static class Serializer extends GlobalLootModifierSerializer<ManipulateDrops>
    {
        public ManipulateDrops read(final ResourceLocation name, final JsonObject json, final ILootCondition[] conditionsIn) {
            return new ManipulateDrops(conditionsIn);
        }
        
        public JsonObject write(final ManipulateDrops instance) {
            return null;
        }
    }
}
