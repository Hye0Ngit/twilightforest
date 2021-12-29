// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import net.minecraftforge.fml.common.Loader;
import java.util.HashMap;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.util.math.Vec3d;
import net.minecraft.entity.projectile.EntityArrow;
import twilightforest.entity.ITFProjectile;
import net.minecraftforge.event.entity.ProjectileImpactEvent;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import twilightforest.advancements.TFAdvancements;
import net.minecraftforge.event.entity.player.AdvancementEvent;
import net.minecraft.nbt.NBTTagCompound;
import twilightforest.block.BlockTFPortal;
import net.minecraft.nbt.NBTBase;
import net.minecraftforge.event.GameRuleChangeEvent;
import net.minecraft.world.GameRules;
import net.minecraftforge.event.world.WorldEvent;
import twilightforest.world.WorldProviderTwilightForest;
import net.minecraft.network.NetHandlerPlayServer;
import net.minecraft.network.play.INetHandlerPlayServer;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;
import twilightforest.network.PacketSetSkylightEnabled;
import twilightforest.network.PacketEnforceProgressionStatus;
import twilightforest.network.PacketUpdateShield;
import net.minecraft.entity.monster.IMob;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import twilightforest.network.PacketAreaProtection;
import twilightforest.network.TFPacketHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import twilightforest.world.ChunkGeneratorTFBase;
import twilightforest.world.TFWorld;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import twilightforest.block.BlockTFGiantBlock;
import twilightforest.entity.IHostileMount;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import twilightforest.capabilities.CapabilityList;
import twilightforest.capabilities.shield.IShieldCapability;
import net.minecraftforge.event.entity.living.LivingEvent;
import java.util.Iterator;
import net.minecraft.entity.player.EntityPlayerMP;
import twilightforest.item.ItemTFPhantomArmor;
import twilightforest.compat.Baubles;
import twilightforest.compat.TFCompat;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import twilightforest.entity.EntityTFCharmEffect;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.MobEffects;
import twilightforest.util.TFItemStackUtils;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import twilightforest.block.BlockTFCritter;
import net.minecraft.block.Block;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.init.SoundEvents;
import twilightforest.item.TFItems;
import net.minecraft.potion.PotionEffect;
import twilightforest.potions.TFPotions;
import net.minecraft.entity.EntityLivingBase;
import twilightforest.enchantment.TFEnchantment;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.world.BlockEvent;
import twilightforest.block.TFBlocks;
import net.minecraft.inventory.IInventory;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraft.item.Item;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.entity.player.InventoryPlayer;
import java.util.UUID;
import java.util.Map;
import com.google.common.collect.ImmutableSet;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "twilightforest")
public class TFEventListener
{
    private static final ImmutableSet<String> SHIELD_DAMAGE_BLACKLIST;
    private static final Map<UUID, InventoryPlayer> playerKeepsMap;
    private static final Map<UUID, NonNullList<ItemStack>> playerKeepsMapBaubles;
    private static boolean isBreakingWithGiantPick;
    private static boolean shouldMakeGiantCobble;
    private static int amountOfCobbleToReplace;
    private static final String NBT_TAG_TWILIGHT = "twilightforest_banished";
    private static boolean globalParry;
    
    @SubscribeEvent
    public static void onCrafting(final PlayerEvent.ItemCraftedEvent event) {
        final ItemStack itemStack = event.crafting;
        final EntityPlayer player = event.player;
        if (itemStack.func_77973_b() == Item.func_150898_a(Blocks.field_150344_f) && itemStack.func_190916_E() == 64 && doesCraftMatrixHaveGiantLog(event.craftMatrix)) {
            ItemHandlerHelper.giveItemToPlayer(player, new ItemStack(Blocks.field_150344_f, 64));
            ItemHandlerHelper.giveItemToPlayer(player, new ItemStack(Blocks.field_150344_f, 64));
            ItemHandlerHelper.giveItemToPlayer(player, new ItemStack(Blocks.field_150344_f, 64));
        }
    }
    
    private static boolean doesCraftMatrixHaveGiantLog(final IInventory inv) {
        final Item giantLogItem = Item.func_150898_a(TFBlocks.giant_log);
        for (int i = 0; i < inv.func_70302_i_(); ++i) {
            if (inv.func_70301_a(i).func_77973_b() == giantLogItem) {
                return true;
            }
        }
        return false;
    }
    
    @SubscribeEvent
    public static void harvestDrops(final BlockEvent.HarvestDropsEvent event) {
        if (TFEventListener.shouldMakeGiantCobble && event.getDrops().size() > 0 && event.getDrops().get(0).func_77973_b() == Item.func_150898_a(Blocks.field_150347_e)) {
            event.getDrops().remove(0);
            if (TFEventListener.amountOfCobbleToReplace == 64) {
                event.getDrops().add(new ItemStack(TFBlocks.giant_cobblestone));
            }
            --TFEventListener.amountOfCobbleToReplace;
            if (TFEventListener.amountOfCobbleToReplace <= 0) {
                TFEventListener.shouldMakeGiantCobble = false;
            }
        }
    }
    
    @SubscribeEvent
    public static void entityHurts(final LivingHurtEvent event) {
        final EntityLivingBase living = event.getEntityLiving();
        final DamageSource damageSource = event.getSource();
        final String damageType = damageSource.func_76355_l();
        final Entity trueSource = damageSource.func_76346_g();
        if (living instanceof EntityPlayer && damageType.equals("mob") && trueSource != null) {
            final EntityPlayer player = (EntityPlayer)living;
            final int fireLevel = TFEnchantment.getFieryAuraLevel(player.field_71071_by, damageSource);
            if (fireLevel > 0 && player.func_70681_au().nextInt(25) < fireLevel) {
                trueSource.func_70015_d(fireLevel / 2);
            }
        }
        if (living instanceof EntityPlayer && damageType.equals("mob") && trueSource instanceof EntityLivingBase) {
            final EntityPlayer player = (EntityPlayer)living;
            final int chillLevel = TFEnchantment.getChillAuraLevel(player.field_71071_by, damageSource);
            if (chillLevel > 0) {
                ((EntityLivingBase)trueSource).func_70690_d(new PotionEffect(TFPotions.frosty, chillLevel * 5 + 5, chillLevel));
            }
        }
        if (damageType.equals("arrow") && trueSource instanceof EntityPlayer) {
            final EntityPlayer player = (EntityPlayer)trueSource;
            if (player.func_184614_ca().func_77973_b() == TFItems.triple_bow || player.func_184592_cb().func_77973_b() == TFItems.triple_bow) {
                living.field_70172_ad = 0;
            }
        }
        if (damageType.equals("arrow") && trueSource instanceof EntityPlayer) {
            final EntityPlayer player = (EntityPlayer)trueSource;
            if (player.func_184614_ca().func_77973_b() == TFItems.ender_bow || player.func_184592_cb().func_77973_b() == TFItems.ender_bow) {
                final double sourceX = player.field_70165_t;
                final double sourceY = player.field_70163_u;
                final double sourceZ = player.field_70161_v;
                final float sourceYaw = player.field_70177_z;
                final float sourcePitch = player.field_70125_A;
                player.field_70177_z = living.field_70177_z;
                player.field_70125_A = living.field_70125_A;
                player.func_70634_a(living.field_70165_t, living.field_70163_u, living.field_70161_v);
                player.func_184185_a(SoundEvents.field_187534_aX, 1.0f, 1.0f);
                living.func_70080_a(sourceX, sourceY, sourceZ, sourceYaw, sourcePitch);
                living.func_184185_a(SoundEvents.field_187534_aX, 1.0f, 1.0f);
            }
        }
        final ItemStack stack = living.func_184582_a(EntityEquipmentSlot.HEAD);
        final Block block = Block.func_149634_a(stack.func_77973_b());
        if (block instanceof BlockTFCritter) {
            final BlockTFCritter poorBug = (BlockTFCritter)block;
            living.func_184201_a(EntityEquipmentSlot.HEAD, poorBug.getSquishResult());
            living.field_70170_p.func_184148_a((EntityPlayer)null, living.field_70165_t, living.field_70163_u, living.field_70161_v, poorBug.func_185467_w().func_185845_c(), living.func_184176_by(), 1.0f, 1.0f);
        }
    }
    
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void charmOfLife(final LivingDeathEvent event) {
        final EntityLivingBase living = event.getEntityLiving();
        if (living.field_70170_p.field_72995_K || !(living instanceof EntityPlayer) || living instanceof FakePlayer) {
            return;
        }
        boolean charm1 = false;
        final boolean charm2 = TFItemStackUtils.consumeInventoryItem(living, s -> s.func_77973_b() == TFItems.charm_of_life_2, 1);
        if (!charm2) {
            charm1 = TFItemStackUtils.consumeInventoryItem(living, s -> s.func_77973_b() == TFItems.charm_of_life_1, 1);
        }
        if (charm2 || charm1) {
            if (charm1) {
                living.func_70606_j(8.0f);
                living.func_70690_d(new PotionEffect(MobEffects.field_76428_l, 100, 0));
            }
            if (charm2) {
                living.func_70606_j((float)living.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111125_b());
                living.func_70690_d(new PotionEffect(MobEffects.field_76428_l, 600, 3));
                living.func_70690_d(new PotionEffect(MobEffects.field_76429_m, 600, 0));
                living.func_70690_d(new PotionEffect(MobEffects.field_76426_n, 600, 0));
            }
            final EntityTFCharmEffect effect = new EntityTFCharmEffect(living.field_70170_p, living, charm1 ? TFItems.charm_of_life_1 : TFItems.charm_of_life_2);
            living.field_70170_p.func_72838_d((Entity)effect);
            final EntityTFCharmEffect effect2 = new EntityTFCharmEffect(living.field_70170_p, living, charm1 ? TFItems.charm_of_life_1 : TFItems.charm_of_life_2);
            effect2.offset = 3.1415927f;
            living.field_70170_p.func_72838_d((Entity)effect2);
            living.field_70170_p.func_184148_a((EntityPlayer)null, living.field_70165_t, living.field_70163_u, living.field_70161_v, SoundEvents.field_191263_gW, living.func_184176_by(), 1.0f, 1.0f);
            event.setCanceled(true);
        }
    }
    
    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void charmOfKeeping(final LivingDeathEvent event) {
        final EntityLivingBase living = event.getEntityLiving();
        if (living.field_70170_p.field_72995_K || !(living instanceof EntityPlayer) || living instanceof FakePlayer || living.field_70170_p.func_82736_K().func_82766_b("keepInventory")) {
            return;
        }
        keepItems((EntityPlayer)living);
    }
    
    private static void keepItems(final EntityPlayer player) {
        dropStoredItems(player);
        final boolean tier3 = TFItemStackUtils.consumeInventoryItem((EntityLivingBase)player, s -> s.func_77973_b() == TFItems.charm_of_keeping_3, 1);
        final boolean tier4 = tier3 || TFItemStackUtils.consumeInventoryItem((EntityLivingBase)player, s -> s.func_77973_b() == TFItems.charm_of_keeping_2, 1);
        final boolean tier5 = tier4 || TFItemStackUtils.consumeInventoryItem((EntityLivingBase)player, s -> s.func_77973_b() == TFItems.charm_of_keeping_1, 1);
        final InventoryPlayer keepInventory = new InventoryPlayer((EntityPlayer)null);
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
            keepInventory.func_70437_b(new ItemStack(TFItems.charm_of_keeping_3));
        }
        else if (tier4) {
            for (int i = 0; i < 9; ++i) {
                keepInventory.field_70462_a.set(i, (Object)((ItemStack)player.field_71071_by.field_70462_a.get(i)).func_77946_l());
                player.field_71071_by.field_70462_a.set(i, (Object)ItemStack.field_190927_a);
            }
            keepInventory.func_70437_b(new ItemStack(TFItems.charm_of_keeping_2));
        }
        else if (tier5) {
            final int i = player.field_71071_by.field_70461_c;
            if (InventoryPlayer.func_184435_e(i)) {
                keepInventory.field_70462_a.set(i, (Object)((ItemStack)player.field_71071_by.field_70462_a.get(i)).func_77946_l());
                player.field_71071_by.field_70462_a.set(i, (Object)ItemStack.field_190927_a);
            }
            keepInventory.func_70437_b(new ItemStack(TFItems.charm_of_keeping_1));
        }
        for (int i = 0; i < player.field_71071_by.field_70462_a.size(); ++i) {
            final ItemStack stack = (ItemStack)player.field_71071_by.field_70462_a.get(i);
            if (stack.func_77973_b() == TFItems.tower_key) {
                keepInventory.field_70462_a.set(i, (Object)stack.func_77946_l());
                player.field_71071_by.field_70462_a.set(i, (Object)ItemStack.field_190927_a);
            }
        }
        if (tier5 && TFCompat.BAUBLES.isActivated()) {
            TFEventListener.playerKeepsMapBaubles.put(playerUUID, Baubles.keepBaubles(player));
        }
        for (int i = 0; i < player.field_71071_by.field_70460_b.size(); ++i) {
            final ItemStack armor = (ItemStack)player.field_71071_by.field_70460_b.get(i);
            if (armor.func_77973_b() instanceof ItemTFPhantomArmor) {
                keepInventory.field_70460_b.set(i, (Object)armor.func_77946_l());
                player.field_71071_by.field_70460_b.set(i, (Object)ItemStack.field_190927_a);
            }
        }
        TFEventListener.playerKeepsMap.put(playerUUID, keepInventory);
    }
    
    private static void keepAllArmor(final EntityPlayer player, final InventoryPlayer keepInventory) {
        for (int i = 0; i < player.field_71071_by.field_70460_b.size(); ++i) {
            keepInventory.field_70460_b.set(i, (Object)((ItemStack)player.field_71071_by.field_70460_b.get(i)).func_77946_l());
            player.field_71071_by.field_70460_b.set(i, (Object)ItemStack.field_190927_a);
        }
    }
    
    private static void keepOffHand(final EntityPlayer player, final InventoryPlayer keepInventory) {
        for (int i = 0; i < player.field_71071_by.field_184439_c.size(); ++i) {
            keepInventory.field_184439_c.set(i, (Object)((ItemStack)player.field_71071_by.field_184439_c.get(i)).func_77946_l());
            player.field_71071_by.field_184439_c.set(i, (Object)ItemStack.field_190927_a);
        }
    }
    
    @SubscribeEvent
    public static void onPlayerRespawn(final PlayerEvent.PlayerRespawnEvent event) {
        if (event.isEndConquered()) {
            updateCapabilities((EntityPlayerMP)event.player, (Entity)event.player);
        }
        else {
            returnStoredItems(event.player);
        }
    }
    
    private static void returnStoredItems(final EntityPlayer player) {
        final InventoryPlayer keepInventory = TFEventListener.playerKeepsMap.remove(player.func_110124_au());
        if (keepInventory != null) {
            TwilightForestMod.LOGGER.debug("Player {} respawned and received items held in storage", (Object)player.func_70005_c_());
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
                final EntityTFCharmEffect effect = new EntityTFCharmEffect(player.field_70170_p, (EntityLivingBase)player, keepInventory.func_70445_o().func_77973_b());
                player.field_70170_p.func_72838_d((Entity)effect);
                final EntityTFCharmEffect effect2 = new EntityTFCharmEffect(player.field_70170_p, (EntityLivingBase)player, keepInventory.func_70445_o().func_77973_b());
                effect2.offset = 3.1415927f;
                player.field_70170_p.func_72838_d((Entity)effect2);
                player.field_70170_p.func_184148_a((EntityPlayer)null, player.field_70165_t, player.field_70163_u, player.field_70161_v, SoundEvents.field_187941_ho, player.func_184176_by(), 1.5f, 1.0f);
            }
        }
        if (TFCompat.BAUBLES.isActivated()) {
            final NonNullList<ItemStack> baubles = TFEventListener.playerKeepsMapBaubles.remove(player.func_110124_au());
            if (baubles != null) {
                TwilightForestMod.LOGGER.debug("Player {} respawned and received baubles held in storage", (Object)player.func_70005_c_());
                Baubles.returnBaubles(player, baubles);
            }
        }
    }
    
    @SubscribeEvent
    public static void onPlayerLogout(final PlayerEvent.PlayerLoggedOutEvent event) {
        dropStoredItems(event.player);
    }
    
    private static void dropStoredItems(final EntityPlayer player) {
        final InventoryPlayer keepInventory = TFEventListener.playerKeepsMap.remove(player.func_110124_au());
        if (keepInventory != null) {
            TwilightForestMod.LOGGER.warn("Dropping inventory items previously held in reserve for player {}", (Object)player.func_70005_c_());
            keepInventory.field_70458_d = player;
            keepInventory.func_70436_m();
        }
        if (TFCompat.BAUBLES.isActivated()) {
            final NonNullList<ItemStack> baubles = TFEventListener.playerKeepsMapBaubles.remove(player.func_110124_au());
            if (baubles != null) {
                TwilightForestMod.LOGGER.warn("Dropping baubles previously held in reserve for player {}", (Object)player.func_70005_c_());
                for (final ItemStack itemStack : baubles) {
                    if (!itemStack.func_190926_b()) {
                        player.func_146097_a(itemStack, true, false);
                    }
                }
            }
        }
    }
    
    @SubscribeEvent
    public static void livingUpdate(final LivingEvent.LivingUpdateEvent event) {
        final EntityLivingBase living = event.getEntityLiving();
        final IShieldCapability cap = (IShieldCapability)living.getCapability((Capability)CapabilityList.SHIELDS, (EnumFacing)null);
        if (cap != null) {
            cap.update();
        }
        if (living instanceof EntityPlayer && living.func_70093_af() && isRidingUnfriendly(living)) {
            living.func_70095_a(false);
        }
    }
    
    public static boolean isRidingUnfriendly(final EntityLivingBase entity) {
        return entity.func_184218_aH() && entity.func_184187_bx() instanceof IHostileMount;
    }
    
    @SubscribeEvent
    public static void breakBlock(final BlockEvent.BreakEvent event) {
        final World world = event.getWorld();
        final EntityPlayer player = event.getPlayer();
        final BlockPos pos = event.getPos();
        final IBlockState state = event.getState();
        if (world.field_72995_K) {
            return;
        }
        if (isBlockProtectedFromBreaking(world, pos) && isAreaProtected(world, player, pos)) {
            event.setCanceled(true);
        }
        else if (!TFEventListener.isBreakingWithGiantPick && canHarvestWithGiantPick(player, state)) {
            TFEventListener.isBreakingWithGiantPick = true;
            final Item cobbleItem = Item.func_150898_a(Blocks.field_150347_e);
            boolean allCobble = state.func_177230_c().func_180660_a(state, world.field_73012_v, 0) == cobbleItem;
            if (allCobble) {
                for (final BlockPos dPos : BlockTFGiantBlock.getVolume(pos)) {
                    if (dPos.equals((Object)pos)) {
                        continue;
                    }
                    final IBlockState stateThere = world.func_180495_p(dPos);
                    if (stateThere.func_177230_c().func_180660_a(stateThere, world.field_73012_v, 0) != cobbleItem) {
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
            if (player instanceof EntityPlayerMP) {
                final EntityPlayerMP playerMP = (EntityPlayerMP)player;
                for (final BlockPos dPos2 : BlockTFGiantBlock.getVolume(pos)) {
                    if (!dPos2.equals((Object)pos) && state == world.func_180495_p(dPos2)) {
                        playerMP.field_71134_c.func_180237_b(dPos2);
                    }
                }
            }
            TFEventListener.isBreakingWithGiantPick = false;
        }
    }
    
    private static boolean canHarvestWithGiantPick(final EntityPlayer player, final IBlockState state) {
        final ItemStack heldStack = player.func_184614_ca();
        final Item heldItem = heldStack.func_77973_b();
        return heldItem == TFItems.giant_pickaxe && heldItem.canHarvestBlock(state, heldStack);
    }
    
    @SubscribeEvent
    public static void onPlayerRightClick(final PlayerInteractEvent.RightClickBlock event) {
        final EntityPlayer player = event.getEntityPlayer();
        final World world = player.field_70170_p;
        if (!world.field_72995_K && isBlockProtectedFromInteraction(world, event.getPos()) && isAreaProtected(world, player, event.getPos())) {
            event.setUseBlock(Event.Result.DENY);
        }
    }
    
    private static boolean isBlockProtectedFromInteraction(final World world, final BlockPos pos) {
        final Block block = world.func_180495_p(pos).func_177230_c();
        return block == TFBlocks.tower_device || block == Blocks.field_150486_ae || block == Blocks.field_150447_bR || block == Blocks.field_150430_aB || block == Blocks.field_150471_bO || block == Blocks.field_150442_at;
    }
    
    private static boolean isBlockProtectedFromBreaking(final World world, final BlockPos pos) {
        return !world.func_180495_p(pos).func_177230_c().getRegistryName().func_110623_a().contains("grave");
    }
    
    private static boolean isAreaProtected(final World world, final EntityPlayer player, final BlockPos pos) {
        if (player.field_71075_bZ.field_75098_d || !TFWorld.isProgressionEnforced(world)) {
            return false;
        }
        final ChunkGeneratorTFBase chunkGenerator = TFWorld.getChunkGenerator(world);
        if (chunkGenerator != null && chunkGenerator.isBlockInStructureBB(pos)) {
            final TFFeature nearbyFeature = TFFeature.getFeatureAt(pos.func_177958_n(), pos.func_177952_p(), world);
            if (!nearbyFeature.doesPlayerHaveRequiredAdvancements(player) && chunkGenerator.isBlockProtected(pos)) {
                sendAreaProtectionPacket(world, pos, chunkGenerator.getSBBAt(pos));
                nearbyFeature.trySpawnHintMonster(world, player, pos);
                return true;
            }
        }
        return false;
    }
    
    private static void sendAreaProtectionPacket(final World world, final BlockPos pos, final StructureBoundingBox sbb) {
        final NetworkRegistry.TargetPoint targetPoint = new NetworkRegistry.TargetPoint(world.field_73011_w.getDimension(), (double)pos.func_177958_n(), (double)pos.func_177956_o(), (double)pos.func_177952_p(), 64.0);
        TFPacketHandler.CHANNEL.sendToAllAround((IMessage)new PacketAreaProtection(sbb, pos), targetPoint);
    }
    
    @SubscribeEvent
    public static void livingAttack(final LivingAttackEvent event) {
        final EntityLivingBase living = event.getEntityLiving();
        if (!living.field_70170_p.field_72995_K && living instanceof IMob && event.getSource().func_76346_g() instanceof EntityPlayer && isAreaProtected(living.field_70170_p, (EntityPlayer)event.getSource().func_76346_g(), new BlockPos((Entity)living))) {
            event.setCanceled(true);
            return;
        }
        if (!living.field_70170_p.field_72995_K && !TFEventListener.SHIELD_DAMAGE_BLACKLIST.contains((Object)event.getSource().field_76373_n)) {
            final IShieldCapability cap = (IShieldCapability)living.getCapability((Capability)CapabilityList.SHIELDS, (EnumFacing)null);
            if (cap != null && cap.shieldsLeft() > 0) {
                cap.breakShield();
                event.setCanceled(true);
            }
        }
    }
    
    @SubscribeEvent
    public static void playerLogsIn(final PlayerEvent.PlayerLoggedInEvent event) {
        if (!event.player.field_70170_p.field_72995_K && event.player instanceof EntityPlayerMP) {
            sendEnforcedProgressionStatus((EntityPlayerMP)event.player, TFWorld.isProgressionEnforced(event.player.field_70170_p));
            updateCapabilities((EntityPlayerMP)event.player, (Entity)event.player);
            banishNewbieToTwilightZone(event.player);
        }
    }
    
    @SubscribeEvent
    public static void playerPortals(final PlayerEvent.PlayerChangedDimensionEvent event) {
        if (!event.player.field_70170_p.field_72995_K && event.player instanceof EntityPlayerMP) {
            if (event.toDim == TFConfig.dimension.dimensionID) {
                sendEnforcedProgressionStatus((EntityPlayerMP)event.player, TFWorld.isProgressionEnforced(event.player.field_70170_p));
            }
            updateCapabilities((EntityPlayerMP)event.player, (Entity)event.player);
        }
    }
    
    @SubscribeEvent
    public static void onStartTracking(final net.minecraftforge.event.entity.player.PlayerEvent.StartTracking event) {
        updateCapabilities((EntityPlayerMP)event.getEntityPlayer(), event.getTarget());
    }
    
    private static void updateCapabilities(final EntityPlayerMP player, final Entity entity) {
        final IShieldCapability cap = (IShieldCapability)entity.getCapability((Capability)CapabilityList.SHIELDS, (EnumFacing)null);
        if (cap != null && cap.shieldsLeft() > 0) {
            TFPacketHandler.CHANNEL.sendTo((IMessage)new PacketUpdateShield(entity, cap), player);
        }
    }
    
    private static void sendEnforcedProgressionStatus(final EntityPlayerMP player, final boolean isEnforced) {
        TFPacketHandler.CHANNEL.sendTo((IMessage)new PacketEnforceProgressionStatus(isEnforced), player);
    }
    
    private static void sendSkylightEnabled(final EntityPlayerMP player, final boolean skylightEnabled) {
        TFPacketHandler.CHANNEL.sendTo((IMessage)new PacketSetSkylightEnabled(skylightEnabled), player);
    }
    
    @SubscribeEvent
    public static void onClientConnect(final FMLNetworkEvent.ServerConnectionFromClientEvent event) {
        final INetHandlerPlayServer handler = (INetHandlerPlayServer)event.getHandler();
        if (handler instanceof NetHandlerPlayServer) {
            final EntityPlayerMP player = ((NetHandlerPlayServer)handler).field_147369_b;
            sendSkylightEnabled(player, WorldProviderTwilightForest.isSkylightEnabled(TFWorld.getDimensionData(player.field_70170_p)));
        }
    }
    
    @SubscribeEvent
    public static void onServerDisconnect(final FMLNetworkEvent.ClientDisconnectionFromServerEvent event) {
        WorldProviderTwilightForest.syncFromConfig();
    }
    
    @SubscribeEvent
    public static void worldLoaded(final WorldEvent.Load event) {
        if (!event.getWorld().field_72995_K && !event.getWorld().func_82736_K().func_82765_e("tfEnforcedProgression")) {
            TwilightForestMod.LOGGER.info("Loaded a world with the {} game rule not defined. Defining it.", (Object)"tfEnforcedProgression");
            event.getWorld().func_82736_K().func_180262_a("tfEnforcedProgression", String.valueOf(TFConfig.progressionRuleDefault), GameRules.ValueType.BOOLEAN_VALUE);
        }
    }
    
    @SubscribeEvent
    public static void gameRuleChanged(final GameRuleChangeEvent event) {
        if (event.getRuleName().equals("tfEnforcedProgression")) {
            final boolean isEnforced = event.getRules().func_82766_b("tfEnforcedProgression");
            TFPacketHandler.CHANNEL.sendToAll((IMessage)new PacketEnforceProgressionStatus(isEnforced));
        }
    }
    
    private static void banishNewbieToTwilightZone(final EntityPlayer player) {
        final NBTTagCompound tagCompound = player.getEntityData();
        final NBTTagCompound playerData = tagCompound.func_74775_l("PlayerPersisted");
        final boolean shouldBanishPlayer = TFConfig.dimension.newPlayersSpawnInTF && !playerData.func_74767_n("twilightforest_banished");
        playerData.func_74757_a("twilightforest_banished", true);
        tagCompound.func_74782_a("PlayerPersisted", (NBTBase)playerData);
        if (shouldBanishPlayer) {
            BlockTFPortal.attemptSendPlayer((Entity)player, true);
        }
    }
    
    @SubscribeEvent
    public static void onAdvancementGet(final AdvancementEvent event) {
        final EntityPlayer player = event.getEntityPlayer();
        if (player instanceof EntityPlayerMP) {
            TFAdvancements.ADVANCEMENT_UNLOCKED.trigger((EntityPlayerMP)player, event.getAdvancement());
        }
    }
    
    @SubscribeEvent
    public static void armorChanged(final LivingEquipmentChangeEvent event) {
        final EntityLivingBase living = event.getEntityLiving();
        if (!living.field_70170_p.field_72995_K && living instanceof EntityPlayerMP) {
            TFAdvancements.ARMOR_CHANGED.trigger((EntityPlayerMP)living, event.getFrom(), event.getTo());
        }
    }
    
    @SubscribeEvent
    public static void arrowParry(final ProjectileImpactEvent.Arrow event) {
        final EntityArrow projectile = event.getArrow();
        if (!projectile.func_130014_f_().field_72995_K && TFEventListener.globalParry && (TFConfig.shieldInteractions.parryNonTwilightAttacks || projectile instanceof ITFProjectile)) {
            final Entity entity = event.getRayTraceResult().field_72308_g;
            if (event.getEntity() != null && entity instanceof EntityLivingBase) {
                final EntityLivingBase entityBlocking = (EntityLivingBase)entity;
                if (entityBlocking.func_184583_d((DamageSource)new DamageSource("parry_this") {
                    public Vec3d func_188404_v() {
                        return projectile.func_174791_d();
                    }
                }) && entityBlocking.func_184607_cu().func_77973_b().func_77626_a(entityBlocking.func_184607_cu()) - entityBlocking.func_184605_cv() <= TFConfig.shieldInteractions.shieldParryTicksArrow) {
                    final Vec3d playerVec3 = entityBlocking.func_70040_Z();
                    projectile.func_70186_c(playerVec3.field_72450_a, playerVec3.field_72448_b, playerVec3.field_72449_c, 1.1f, 0.1f);
                    projectile.field_70250_c = (Entity)entityBlocking;
                    event.setCanceled(true);
                }
            }
        }
    }
    
    @SubscribeEvent
    public static void fireballParry(final ProjectileImpactEvent.Fireball event) {
        final EntityFireball projectile = event.getFireball();
        if (!projectile.func_130014_f_().field_72995_K && TFEventListener.globalParry && (TFConfig.shieldInteractions.parryNonTwilightAttacks || projectile instanceof ITFProjectile)) {
            final Entity entity = event.getRayTraceResult().field_72308_g;
            if (event.getEntity() != null && entity instanceof EntityLivingBase) {
                final EntityLivingBase entityBlocking = (EntityLivingBase)entity;
                if (entityBlocking.func_184583_d((DamageSource)new DamageSource("parry_this") {
                    public Vec3d func_188404_v() {
                        return projectile.func_174791_d();
                    }
                }) && entityBlocking.func_184607_cu().func_77973_b().func_77626_a(entityBlocking.func_184607_cu()) - entityBlocking.func_184605_cv() <= TFConfig.shieldInteractions.shieldParryTicksFireball) {
                    final Vec3d playerVec3 = entityBlocking.func_70040_Z();
                    projectile.field_70159_w = playerVec3.field_72450_a;
                    projectile.field_70181_x = playerVec3.field_72448_b;
                    projectile.field_70179_y = playerVec3.field_72449_c;
                    projectile.field_70232_b = projectile.field_70159_w * 0.1;
                    projectile.field_70233_c = projectile.field_70181_x * 0.1;
                    projectile.field_70230_d = projectile.field_70179_y * 0.1;
                    projectile.field_70235_a = entityBlocking;
                    event.setCanceled(true);
                }
            }
        }
    }
    
    @SubscribeEvent
    public static void throwableParry(final ProjectileImpactEvent.Throwable event) {
        final EntityThrowable projectile = event.getThrowable();
        if (!projectile.func_130014_f_().field_72995_K && TFEventListener.globalParry && (TFConfig.shieldInteractions.parryNonTwilightAttacks || projectile instanceof ITFProjectile)) {
            final Entity entity = event.getRayTraceResult().field_72308_g;
            if (event.getEntity() != null && entity instanceof EntityLivingBase) {
                final EntityLivingBase entityBlocking = (EntityLivingBase)entity;
                if (entityBlocking.func_184583_d((DamageSource)new DamageSource("parry_this") {
                    public Vec3d func_188404_v() {
                        return projectile.func_174791_d();
                    }
                }) && entityBlocking.func_184607_cu().func_77973_b().func_77626_a(entityBlocking.func_184607_cu()) - entityBlocking.func_184605_cv() <= TFConfig.shieldInteractions.shieldParryTicksThrowable) {
                    final Vec3d playerVec3 = entityBlocking.func_70040_Z();
                    projectile.func_70186_c(playerVec3.field_72450_a, playerVec3.field_72448_b, playerVec3.field_72449_c, 1.1f, 0.1f);
                    projectile.field_70192_c = entityBlocking;
                    event.setCanceled(true);
                }
            }
        }
    }
    
    static {
        SHIELD_DAMAGE_BLACKLIST = ImmutableSet.of((Object)"inWall", (Object)"cramming", (Object)"drown", (Object)"starve", (Object)"fall", (Object)"flyIntoWall", (Object[])new String[] { "outOfWorld", "fallingBlock" });
        playerKeepsMap = new HashMap<UUID, InventoryPlayer>();
        playerKeepsMapBaubles = new HashMap<UUID, NonNullList<ItemStack>>();
        TFEventListener.isBreakingWithGiantPick = false;
        TFEventListener.shouldMakeGiantCobble = false;
        TFEventListener.amountOfCobbleToReplace = 0;
        TFEventListener.globalParry = !Loader.isModLoaded("parry");
    }
}
