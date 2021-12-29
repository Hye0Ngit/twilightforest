// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import net.minecraft.util.IChatComponent;
import net.minecraft.util.ChatComponentText;
import twilightforest.biomes.TFBiomeBase;
import net.minecraft.util.MathHelper;
import net.minecraft.entity.monster.IMob;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import cpw.mods.fml.common.network.internal.FMLProxyPacket;
import cpw.mods.fml.common.network.NetworkRegistry;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import twilightforest.world.ChunkProviderTwilightForest;
import twilightforest.world.TFWorldChunkManager;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import twilightforest.world.WorldProviderTwilightForest;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import twilightforest.entity.EntityTFYeti;
import twilightforest.entity.EntityTFPinchBeetle;
import net.minecraftforge.event.entity.living.LivingEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import cpw.mods.fml.common.FMLLog;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraft.block.BlockSapling;
import twilightforest.block.TFBlocks;
import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraft.util.DamageSource;
import twilightforest.entity.EntityTFCharmEffect;
import net.minecraft.entity.SharedMonsterAttributes;
import cpw.mods.fml.common.eventhandler.Event;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.Potion;
import net.minecraft.entity.EntityLivingBase;
import twilightforest.enchantment.TFEnchantment;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.world.World;
import java.util.Iterator;
import java.util.Collection;
import net.minecraft.item.crafting.FurnaceRecipes;
import java.util.ArrayList;
import net.minecraftforge.event.world.BlockEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.IInventory;
import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.item.Item;
import net.minecraft.stats.StatBase;
import twilightforest.item.TFItems;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraft.entity.player.InventoryPlayer;
import java.util.HashMap;

public class TFEventListener
{
    protected HashMap<String, InventoryPlayer> playerKeepsMap;
    
    public TFEventListener() {
        this.playerKeepsMap = new HashMap<String, InventoryPlayer>();
    }
    
    @SubscribeEvent
    public void pickupItem(final EntityItemPickupEvent event) {
        final Item item = event.item.func_92059_d().func_77973_b();
        if (item == TFItems.scepterTwilight || item == TFItems.scepterLifeDrain || item == TFItems.scepterZombie) {
            this.checkPlayerForScepterMastery(event.entityPlayer);
            event.entityPlayer.func_71029_a((StatBase)TFAchievementPage.twilightProgressLich);
        }
        if (item == TFItems.nagaScale) {
            event.entityPlayer.func_71029_a((StatBase)TFAchievementPage.twilightProgressNaga);
        }
        if (item == TFItems.trophy && event.item.func_92059_d().func_77960_j() == 0) {
            event.entityPlayer.func_71029_a((StatBase)TFAchievementPage.twilightKillHydra);
        }
        if (item == TFItems.trophy && event.item.func_92059_d().func_77960_j() == 1) {
            event.entityPlayer.func_71029_a((StatBase)TFAchievementPage.twilightKillNaga);
        }
        if (item == TFItems.trophy && event.item.func_92059_d().func_77960_j() == 2) {
            event.entityPlayer.func_71029_a((StatBase)TFAchievementPage.twilightKillLich);
        }
        if (item == TFItems.trophy && event.item.func_92059_d().func_77960_j() == 3) {
            event.entityPlayer.func_71029_a((StatBase)TFAchievementPage.twilightProgressUrghast);
        }
        if (item == TFItems.mazebreakerPick) {
            event.entityPlayer.func_71029_a((StatBase)TFAchievementPage.twilightMazebreaker);
        }
        if (item == TFItems.meefStroganoff || item == TFItems.minotaurAxe) {
            event.entityPlayer.func_71029_a((StatBase)TFAchievementPage.twilightProgressLabyrinth);
        }
        if (item == TFItems.fieryBlood) {
            event.entityPlayer.func_71029_a((StatBase)TFAchievementPage.twilightProgressHydra);
        }
        if (item == TFItems.phantomHelm || item == TFItems.phantomPlate) {
            event.entityPlayer.func_71029_a((StatBase)TFAchievementPage.twilightProgressKnights);
        }
        if (item == TFItems.fieryTears) {
            event.entityPlayer.func_71029_a((StatBase)TFAchievementPage.twilightProgressUrghast);
        }
        if (item == TFItems.alphaFur || item == TFItems.yetiBoots || item == TFItems.yetiHelm || item == TFItems.yetiPlate || item == TFItems.yetiLegs) {
            event.entityPlayer.func_71029_a((StatBase)TFAchievementPage.twilightProgressYeti);
        }
    }
    
    private void checkPlayerForScepterMastery(final EntityPlayer player) {
        boolean scepterTwilight = false;
        boolean scepterLifeDrain = false;
        boolean scepterZombie = false;
        final IInventory inv = (IInventory)player.field_71071_by;
        for (int i = 0; i < inv.func_70302_i_(); ++i) {
            final ItemStack stack = inv.func_70301_a(i);
            if (stack != null && stack.func_77973_b() == TFItems.scepterTwilight) {
                scepterTwilight = true;
            }
            if (stack != null && stack.func_77973_b() == TFItems.scepterLifeDrain) {
                scepterLifeDrain = true;
            }
            if (stack != null && stack.func_77973_b() == TFItems.scepterZombie) {
                scepterZombie = true;
            }
        }
        if (scepterTwilight && scepterLifeDrain && scepterZombie) {
            player.func_71029_a((StatBase)TFAchievementPage.twilightLichScepters);
        }
    }
    
    @SubscribeEvent
    public void onCrafting(final PlayerEvent.ItemCraftedEvent event) {
        final ItemStack itemStack = event.crafting;
        final EntityPlayer player = event.player;
        if (itemStack.func_77973_b() == TFItems.plateNaga || itemStack.func_77973_b() == TFItems.legsNaga) {
            this.checkPlayerForNagaArmorer(player);
        }
        if (itemStack.func_77973_b() == TFItems.magicMapFocus) {
            player.func_71029_a((StatBase)TFAchievementPage.twilightMagicMapFocus);
        }
        if (itemStack.func_77973_b() == TFItems.emptyMagicMap) {
            player.func_71029_a((StatBase)TFAchievementPage.twilightMagicMap);
        }
        if (itemStack.func_77973_b() == TFItems.emptyMazeMap) {
            player.func_71029_a((StatBase)TFAchievementPage.twilightMazeMap);
        }
        if (itemStack.func_77973_b() == TFItems.emptyOreMap) {
            player.func_71029_a((StatBase)TFAchievementPage.twilightOreMap);
        }
    }
    
    private void checkPlayerForNagaArmorer(final EntityPlayer player) {
        boolean nagaScale = false;
        boolean legsNaga = false;
        final IInventory inv = (IInventory)player.field_71071_by;
        for (int i = 0; i < inv.func_70302_i_(); ++i) {
            final ItemStack stack = inv.func_70301_a(i);
            if (stack != null && stack.func_77973_b() == TFItems.nagaScale) {
                nagaScale = true;
            }
            if (stack != null && stack.func_77973_b() == TFItems.legsNaga) {
                legsNaga = true;
            }
        }
        if (nagaScale && legsNaga) {
            player.func_71029_a((StatBase)TFAchievementPage.twilightNagaArmors);
        }
    }
    
    @SubscribeEvent
    public void harvestDrops(final BlockEvent.HarvestDropsEvent event) {
        if (event.harvester != null && event.harvester.field_71071_by.func_70448_g() != null && event.harvester.field_71071_by.func_70448_g().func_77973_b().func_150897_b(event.block) && event.harvester.field_71071_by.func_70448_g().func_77973_b() == TFItems.fieryPick) {
            final ArrayList<ItemStack> removeThese = new ArrayList<ItemStack>(1);
            final ArrayList<ItemStack> addThese = new ArrayList<ItemStack>(1);
            for (final ItemStack input : event.drops) {
                final ItemStack result = FurnaceRecipes.func_77602_a().func_151395_a(input);
                if (result != null) {
                    addThese.add(new ItemStack(result.func_77973_b(), input.field_77994_a));
                    removeThese.add(input);
                    this.spawnSpeltXP(result, event.world, event.x, event.y, event.z);
                }
            }
            event.drops.removeAll(removeThese);
            event.drops.addAll(addThese);
        }
    }
    
    private void spawnSpeltXP(final ItemStack smelted, final World world, final int x, final int y, final int z) {
        final float floatXP = FurnaceRecipes.func_77602_a().func_151398_b(smelted);
        int smeltXP = (int)floatXP;
        if (floatXP > smeltXP && world.field_73012_v.nextFloat() < floatXP - smeltXP) {
            ++smeltXP;
        }
        while (smeltXP > 0) {
            final int splitXP = EntityXPOrb.func_70527_a(smeltXP);
            smeltXP -= splitXP;
            world.func_72838_d((Entity)new EntityXPOrb(world, x + 0.5, y + 0.5, z + 0.5, splitXP));
        }
    }
    
    @SubscribeEvent
    public void entityHurts(final LivingHurtEvent event) {
        if (event.entityLiving instanceof EntityPlayer && event.source.field_76373_n.equals("mob") && event.source.func_76346_g() != null) {
            final EntityPlayer player = (EntityPlayer)event.entityLiving;
            final int fireLevel = TFEnchantment.getReactFireLevel(player.field_71071_by, event.source);
            if (fireLevel > 0 && player.func_70681_au().nextInt(25) < fireLevel) {
                event.source.func_76346_g().func_70015_d(fireLevel / 2);
            }
        }
        if (event.entityLiving instanceof EntityPlayer && event.source.field_76373_n.equals("mob") && event.source.func_76346_g() != null && event.source.func_76346_g() instanceof EntityLivingBase) {
            final EntityPlayer player = (EntityPlayer)event.entityLiving;
            final int chillLevel = TFEnchantment.getChillAuraLevel(player.field_71071_by, event.source);
            if (chillLevel > 0) {
                ((EntityLivingBase)event.source.func_76346_g()).func_70690_d(new PotionEffect(Potion.field_76421_d.field_76415_H, chillLevel * 5 + 5, chillLevel));
            }
        }
        if (event.entityLiving instanceof EntityPlayer && this.willEntityDie(event)) {
            final EntityPlayer player = (EntityPlayer)event.entityLiving;
            boolean charm1 = false;
            final boolean charm2 = player.field_71071_by.func_146026_a(TFItems.charmOfLife2);
            if (!charm2) {
                charm1 = player.field_71071_by.func_146026_a(TFItems.charmOfLife1);
            }
            if (charm2 || charm1) {
                event.setResult(Event.Result.DENY);
                event.setCanceled(true);
                event.ammount = 0.0f;
                if (charm1) {
                    player.func_70606_j(8.0f);
                    player.func_70690_d(new PotionEffect(Potion.field_76428_l.field_76415_H, 100, 0));
                }
                if (charm2) {
                    player.func_70606_j((float)player.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111125_b());
                    player.func_70690_d(new PotionEffect(Potion.field_76428_l.field_76415_H, 600, 3));
                    player.func_70690_d(new PotionEffect(Potion.field_76429_m.field_76415_H, 600, 0));
                    player.func_70690_d(new PotionEffect(Potion.field_76426_n.field_76415_H, 600, 0));
                }
                final EntityTFCharmEffect effect = new EntityTFCharmEffect(player.field_70170_p, (EntityLivingBase)player, charm1 ? TFItems.charmOfLife1 : TFItems.charmOfLife2);
                player.field_70170_p.func_72838_d((Entity)effect);
                final EntityTFCharmEffect effect2 = new EntityTFCharmEffect(player.field_70170_p, (EntityLivingBase)player, charm1 ? TFItems.charmOfLife1 : TFItems.charmOfLife2);
                effect2.offset = 3.1415927f;
                player.field_70170_p.func_72838_d((Entity)effect2);
                player.field_70170_p.func_72908_a(player.field_70165_t + 0.5, player.field_70163_u + 0.5, player.field_70161_v + 0.5, "mob.zombie.unfect", 1.5f, 1.0f);
            }
        }
    }
    
    public boolean willEntityDie(final LivingHurtEvent event) {
        float amount = event.ammount;
        final DamageSource source = event.source;
        final EntityLivingBase living = event.entityLiving;
        if (!source.func_76363_c()) {
            final int armor = 25 - living.func_70658_aO();
            amount = amount * armor / 25.0f;
        }
        if (living.func_70644_a(Potion.field_76429_m)) {
            final int resistance = 25 - (living.func_70660_b(Potion.field_76429_m).func_76458_c() + 1) * 5;
            amount = amount * resistance / 25.0f;
        }
        return Math.ceil(amount) >= living.func_110143_aJ();
    }
    
    @SubscribeEvent
    public void bonemealUsed(final BonemealEvent event) {
        if (event.block == TFBlocks.sapling && !event.world.field_72995_K) {
            ((BlockSapling)TFBlocks.sapling).func_149878_d(event.world, event.x, event.y, event.z, event.world.field_73012_v);
            event.setResult(Event.Result.ALLOW);
        }
    }
    
    @SubscribeEvent
    public void livingDies(final LivingDeathEvent event) {
        if (event.entityLiving instanceof EntityPlayer && !event.entityLiving.field_70170_p.func_82736_K().func_82766_b("keepInventory")) {
            final EntityPlayer player = (EntityPlayer)event.entityLiving;
            if (player.field_71071_by.func_146026_a(TFItems.charmOfKeeping3)) {
                FMLLog.info("[TwilightForest] Player died with charm of keeping III!  Keep it all!", new Object[0]);
                final InventoryPlayer keepInventory = new InventoryPlayer((EntityPlayer)null);
                this.keepAllArmor(player, keepInventory);
                for (int i = 0; i < player.field_71071_by.field_70462_a.length; ++i) {
                    keepInventory.field_70462_a[i] = ItemStack.func_77944_b(player.field_71071_by.field_70462_a[i]);
                    player.field_71071_by.field_70462_a[i] = null;
                }
                keepInventory.func_70437_b(new ItemStack(TFItems.charmOfKeeping3));
                this.playerKeepsMap.put(player.func_70005_c_(), keepInventory);
            }
            else if (player.field_71071_by.func_146026_a(TFItems.charmOfKeeping2)) {
                FMLLog.info("[TwilightForest] Player died with charm of keeping II!  Keep armor and hotbar!", new Object[0]);
                final InventoryPlayer keepInventory = new InventoryPlayer((EntityPlayer)null);
                this.keepAllArmor(player, keepInventory);
                for (int i = 0; i < 9; ++i) {
                    keepInventory.field_70462_a[i] = ItemStack.func_77944_b(player.field_71071_by.field_70462_a[i]);
                    player.field_71071_by.field_70462_a[i] = null;
                }
                keepInventory.func_70437_b(new ItemStack(TFItems.charmOfKeeping2));
                this.playerKeepsMap.put(player.func_70005_c_(), keepInventory);
            }
            else if (player.field_71071_by.func_146026_a(TFItems.charmOfKeeping1)) {
                FMLLog.info("[TwilightForest] Player died with charm of keeping I!  Keep armor and current item!", new Object[0]);
                final InventoryPlayer keepInventory = new InventoryPlayer((EntityPlayer)null);
                this.keepAllArmor(player, keepInventory);
                if (player.field_71071_by.func_70448_g() != null) {
                    keepInventory.field_70462_a[player.field_71071_by.field_70461_c] = ItemStack.func_77944_b(player.field_71071_by.field_70462_a[player.field_71071_by.field_70461_c]);
                    player.field_71071_by.field_70462_a[player.field_71071_by.field_70461_c] = null;
                }
                keepInventory.func_70437_b(new ItemStack(TFItems.charmOfKeeping1));
                this.playerKeepsMap.put(player.func_70005_c_(), keepInventory);
            }
            if (player.field_71071_by.func_146028_b(TFItems.towerKey)) {
                final InventoryPlayer keepInventory = this.retrieveOrMakeKeepInventory(player);
                for (int i = 0; i < player.field_71071_by.field_70462_a.length; ++i) {
                    if (player.field_71071_by.field_70462_a[i] != null && player.field_71071_by.field_70462_a[i].func_77973_b() == TFItems.towerKey) {
                        keepInventory.field_70462_a[i] = ItemStack.func_77944_b(player.field_71071_by.field_70462_a[i]);
                        player.field_71071_by.field_70462_a[i] = null;
                    }
                }
                this.playerKeepsMap.put(player.func_70005_c_(), keepInventory);
            }
        }
        if (this.playerKeepsMap.size() > 1) {
            FMLLog.warning("[TwilightForest] Twilight Forest mod is keeping track of a lot of dead player inventories.  Has there been an apocalypse?", new Object[0]);
        }
    }
    
    private InventoryPlayer retrieveOrMakeKeepInventory(final EntityPlayer player) {
        if (this.playerKeepsMap.containsKey(player.func_70005_c_())) {
            return this.playerKeepsMap.get(player.func_70005_c_());
        }
        return new InventoryPlayer((EntityPlayer)null);
    }
    
    private void keepAllArmor(final EntityPlayer player, final InventoryPlayer keepInventory) {
        for (int i = 0; i < player.field_71071_by.field_70460_b.length; ++i) {
            keepInventory.field_70460_b[i] = ItemStack.func_77944_b(player.field_71071_by.field_70460_b[i]);
            player.field_71071_by.field_70460_b[i] = null;
        }
    }
    
    @SubscribeEvent
    public void onPlayerRespawn(final PlayerEvent.PlayerRespawnEvent event) {
        final EntityPlayer player = event.player;
        if (this.playerKeepsMap.containsKey(player.func_70005_c_())) {
            FMLLog.info("[TwilightForest] Player %s respawned and recieved items held in storage", new Object[] { player.func_70005_c_() });
            final InventoryPlayer keepInventory = this.playerKeepsMap.get(player.func_70005_c_());
            for (int i = 0; i < player.field_71071_by.field_70460_b.length; ++i) {
                if (keepInventory.field_70460_b[i] != null) {
                    player.field_71071_by.field_70460_b[i] = keepInventory.field_70460_b[i];
                }
            }
            for (int i = 0; i < player.field_71071_by.field_70462_a.length; ++i) {
                if (keepInventory.field_70462_a[i] != null) {
                    player.field_71071_by.field_70462_a[i] = keepInventory.field_70462_a[i];
                }
            }
            if (keepInventory.func_70445_o() != null) {
                final EntityTFCharmEffect effect = new EntityTFCharmEffect(player.field_70170_p, (EntityLivingBase)player, keepInventory.func_70445_o().func_77973_b());
                player.field_70170_p.func_72838_d((Entity)effect);
                final EntityTFCharmEffect effect2 = new EntityTFCharmEffect(player.field_70170_p, (EntityLivingBase)player, keepInventory.func_70445_o().func_77973_b());
                effect2.offset = 3.1415927f;
                player.field_70170_p.func_72838_d((Entity)effect2);
                player.field_70170_p.func_72908_a(player.field_70165_t + 0.5, player.field_70163_u + 0.5, player.field_70161_v + 0.5, "mob.zombie.unfect", 1.5f, 1.0f);
            }
            this.playerKeepsMap.remove(player.func_70005_c_());
        }
    }
    
    @SubscribeEvent
    public void onPlayerLogout(final PlayerEvent.PlayerLoggedOutEvent event) {
        final EntityPlayer player = event.player;
        if (this.playerKeepsMap.containsKey(player.func_70005_c_())) {
            FMLLog.warning("[TwilightForest] Mod was keeping inventory items in reserve for player %s but they logged out!  Items are being dropped.", new Object[] { player.func_70005_c_() });
            final InventoryPlayer keepInventory = this.playerKeepsMap.get(player.func_70005_c_());
            keepInventory.field_70458_d = player;
            keepInventory.func_70436_m();
            this.playerKeepsMap.remove(player.func_70005_c_());
        }
    }
    
    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public boolean preOverlay(final RenderGameOverlayEvent.Pre event) {
        if (event.type == RenderGameOverlayEvent.ElementType.HEALTHMOUNT && this.isRidingUnfriendly((EntityLivingBase)Minecraft.func_71410_x().field_71439_g)) {
            event.setCanceled(true);
            return false;
        }
        return true;
    }
    
    @SubscribeEvent
    public boolean livingUpdate(final LivingEvent.LivingUpdateEvent event) {
        if (event.entity instanceof EntityPlayer && event.entity.func_70093_af() && this.isRidingUnfriendly(event.entityLiving)) {
            event.entity.func_70095_a(false);
        }
        return true;
    }
    
    private boolean isRidingUnfriendly(final EntityLivingBase entity) {
        return entity.func_70115_ae() && (entity.field_70154_o instanceof EntityTFPinchBeetle || entity.field_70154_o instanceof EntityTFYeti);
    }
    
    @SubscribeEvent
    public void breakBlock(final BlockEvent.BreakEvent event) {
        if (!event.getPlayer().field_71075_bZ.field_75098_d && this.isAreaProtected(event.world, event.getPlayer(), event.x, event.y, event.z)) {
            event.setCanceled(true);
        }
    }
    
    @SubscribeEvent
    public void rightClickBlock(final PlayerInteractEvent event) {
        if (event.action == PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK && event.entityPlayer.field_70170_p.field_73011_w instanceof WorldProviderTwilightForest && !event.entityPlayer.field_71075_bZ.field_75098_d) {
            final World world = event.entityPlayer.field_70170_p;
            final EntityPlayer player = event.entityPlayer;
            final int x = event.x;
            final int y = event.y;
            final int z = event.z;
            if (!world.field_72995_K && this.isBlockProtectedType(world, x, y, z) && this.isAreaProtected(world, player, x, y, z)) {
                event.useBlock = Event.Result.DENY;
            }
        }
        final ItemStack currentItem = event.entityPlayer.field_71071_by.func_70448_g();
        if (currentItem != null && (currentItem.func_77973_b() == TFItems.fierySword || currentItem.func_77973_b() == TFItems.fieryPick) && this.checkPlayerForFieryArmor(event.entityPlayer)) {
            event.entityPlayer.func_71029_a((StatBase)TFAchievementPage.twilightFierySet);
        }
    }
    
    private boolean isBlockProtectedType(final World world, final int x, final int y, final int z) {
        final Block block = world.func_147439_a(x, y, z);
        return block == TFBlocks.towerDevice || block == Blocks.field_150486_ae || block == Blocks.field_150447_bR || block == Blocks.field_150430_aB || block == Blocks.field_150471_bO || block == Blocks.field_150442_at;
    }
    
    private boolean checkPlayerForFieryArmor(final EntityPlayer entityPlayer) {
        final ItemStack[] armor = entityPlayer.field_71071_by.field_70460_b;
        return (armor[0] != null && armor[0].func_77973_b() == TFItems.fieryBoots) || (armor[1] != null && armor[1].func_77973_b() == TFItems.fieryLegs) || (armor[2] != null && armor[2].func_77973_b() == TFItems.fieryPlate) || (armor[3] != null && armor[3].func_77973_b() == TFItems.fieryHelm);
    }
    
    private boolean isAreaProtected(final World world, final EntityPlayer player, final int x, final int y, final int z) {
        if (TwilightForestMod.enforcedProgression && world.field_73011_w instanceof WorldProviderTwilightForest) {
            final ChunkProviderTwilightForest chunkProvider = ((WorldProviderTwilightForest)world.field_73011_w).getChunkProvider();
            if (chunkProvider != null && chunkProvider.isBlockInStructureBB(x, y, z)) {
                final TFFeature nearbyFeature = ((TFWorldChunkManager)world.field_73011_w.field_76578_c).getFeatureAt(x, z, world);
                if (!nearbyFeature.doesPlayerHaveRequiredAchievement(player) && chunkProvider.isBlockProtected(x, y, z)) {
                    final StructureBoundingBox sbb = chunkProvider.getSBBAt(x, y, z);
                    this.sendAreaProtectionPacket(world, x, y, z, sbb);
                    return true;
                }
            }
        }
        return false;
    }
    
    private void sendAreaProtectionPacket(final World world, final int x, final int y, final int z, final StructureBoundingBox sbb) {
        final FMLProxyPacket message = TFGenericPacketHandler.makeAreaProtectionPacket(sbb, x, y, z);
        final NetworkRegistry.TargetPoint targetPoint = new NetworkRegistry.TargetPoint(world.field_73011_w.field_76574_g, (double)x, 64.0, (double)z, 64.0);
        TwilightForestMod.genericChannel.sendToAllAround(message, targetPoint);
    }
    
    @SubscribeEvent
    public void livingAttack(final LivingAttackEvent event) {
        if (event.entityLiving instanceof IMob && event.source.func_76346_g() instanceof EntityPlayer && !((EntityPlayer)event.source.func_76346_g()).field_71075_bZ.field_75098_d && event.entityLiving.field_70170_p.field_73011_w instanceof WorldProviderTwilightForest && TwilightForestMod.enforcedProgression) {
            final ChunkProviderTwilightForest chunkProvider = ((WorldProviderTwilightForest)event.entityLiving.field_70170_p.field_73011_w).getChunkProvider();
            final int mx = MathHelper.func_76128_c(event.entityLiving.field_70165_t);
            final int my = MathHelper.func_76128_c(event.entityLiving.field_70163_u);
            final int mz = MathHelper.func_76128_c(event.entityLiving.field_70161_v);
            if (chunkProvider != null && chunkProvider.isBlockInStructureBB(mx, my, mz) && chunkProvider.isBlockProtected(mx, my, mz)) {
                final TFFeature nearbyFeature = ((TFWorldChunkManager)event.entityLiving.field_70170_p.field_73011_w.field_76578_c).getFeatureAt(mx, mz, event.entityLiving.field_70170_p);
                if (!nearbyFeature.doesPlayerHaveRequiredAchievement((EntityPlayer)event.source.func_76346_g())) {
                    event.setResult(Event.Result.DENY);
                    event.setCanceled(true);
                    for (int i = 0; i < 20; ++i) {
                        TwilightForestMod.proxy.spawnParticle(event.entityLiving.field_70170_p, "protection", event.entityLiving.field_70165_t, event.entityLiving.field_70163_u, event.entityLiving.field_70161_v, 0.0, 0.0, 0.0);
                    }
                }
            }
        }
    }
    
    @SubscribeEvent
    public void playerLogsIn(final PlayerEvent.PlayerLoggedInEvent event) {
        TwilightForestMod.hasBiomeIdConflicts = TFBiomeBase.areThereBiomeIdConflicts();
        if (TwilightForestMod.hasBiomeIdConflicts) {
            event.player.func_145747_a((IChatComponent)new ChatComponentText("[TwilightForest] Biome ID conflict detected.  Fix by editing the config file."));
        }
    }
}
