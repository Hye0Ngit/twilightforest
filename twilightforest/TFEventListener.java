// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

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
import net.minecraft.world.chunk.Chunk;
import twilightforest.world.TFWorldChunkManager;
import net.minecraftforge.event.world.ChunkEvent;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.EntityLivingBase;
import twilightforest.entity.EntityTFCharmEffect;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.Potion;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.world.World;
import java.util.Iterator;
import java.util.Collection;
import net.minecraft.item.crafting.FurnaceRecipes;
import java.util.ArrayList;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.IInventory;
import net.minecraft.stats.StatBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.ForgeSubscribe;
import twilightforest.item.TFItems;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraft.entity.player.InventoryPlayer;
import java.util.HashMap;
import cpw.mods.fml.common.IPlayerTracker;
import cpw.mods.fml.common.ICraftingHandler;

public class TFEventListener implements ICraftingHandler, IPlayerTracker
{
    protected HashMap<String, InventoryPlayer> playerKeepsMap;
    
    public TFEventListener() {
        this.playerKeepsMap = new HashMap<String, InventoryPlayer>();
    }
    
    @ForgeSubscribe
    public void pickupItem(final EntityItemPickupEvent event) {
        if (event.item.func_92059_d().field_77993_c == TFItems.scepterTwilight.field_77779_bT || event.item.func_92059_d().field_77993_c == TFItems.scepterLifeDrain.field_77779_bT || event.item.func_92059_d().field_77993_c == TFItems.scepterZombie.field_77779_bT) {
            this.checkPlayerForScepterMastery(event.entityPlayer);
        }
    }
    
    private void checkPlayerForScepterMastery(final EntityPlayer player) {
        boolean scepterTwilight = false;
        boolean scepterLifeDrain = false;
        boolean scepterZombie = false;
        final IInventory inv = (IInventory)player.field_71071_by;
        for (int i = 0; i < inv.func_70302_i_(); ++i) {
            final ItemStack stack = inv.func_70301_a(i);
            if (stack != null && stack.field_77993_c == TFItems.scepterTwilight.field_77779_bT) {
                scepterTwilight = true;
            }
            if (stack != null && stack.field_77993_c == TFItems.scepterLifeDrain.field_77779_bT) {
                scepterLifeDrain = true;
            }
            if (stack != null && stack.field_77993_c == TFItems.scepterZombie.field_77779_bT) {
                scepterZombie = true;
            }
        }
        if (scepterTwilight && scepterLifeDrain && scepterZombie) {
            player.func_71029_a((StatBase)TFAchievementPage.twilightLichScepters);
        }
    }
    
    public void onCrafting(final EntityPlayer player, final ItemStack itemStack, final IInventory craftMatrix) {
        if (itemStack.field_77993_c == TFItems.plateNaga.field_77779_bT || itemStack.field_77993_c == TFItems.legsNaga.field_77779_bT) {
            this.checkPlayerForNagaArmorer(player);
        }
        if (itemStack.field_77993_c == TFItems.magicMapFocus.field_77779_bT) {
            player.func_71029_a((StatBase)TFAchievementPage.twilightMagicMapFocus);
        }
        if (itemStack.field_77993_c == TFItems.emptyMagicMap.field_77779_bT) {
            player.func_71029_a((StatBase)TFAchievementPage.twilightMagicMap);
        }
        if (itemStack.field_77993_c == TFItems.emptyMazeMap.field_77779_bT) {
            player.func_71029_a((StatBase)TFAchievementPage.twilightMazeMap);
        }
        if (itemStack.field_77993_c == TFItems.emptyOreMap.field_77779_bT) {
            player.func_71029_a((StatBase)TFAchievementPage.twilightOreMap);
        }
    }
    
    public void onSmelting(final EntityPlayer player, final ItemStack item) {
    }
    
    private void checkPlayerForNagaArmorer(final EntityPlayer player) {
        boolean nagaScale = false;
        boolean legsNaga = false;
        final IInventory inv = (IInventory)player.field_71071_by;
        for (int i = 0; i < inv.func_70302_i_(); ++i) {
            final ItemStack stack = inv.func_70301_a(i);
            if (stack != null && stack.field_77993_c == TFItems.nagaScale.field_77779_bT) {
                nagaScale = true;
            }
            if (stack != null && stack.field_77993_c == TFItems.legsNaga.field_77779_bT) {
                legsNaga = true;
            }
        }
        if (nagaScale && legsNaga) {
            player.func_71029_a((StatBase)TFAchievementPage.twilightNagaArmors);
        }
    }
    
    @ForgeSubscribe
    public void harvestDrops(final BlockEvent.HarvestDropsEvent event) {
        if (event.harvester != null && event.harvester.field_71071_by.func_70448_g() != null && event.harvester.field_71071_by.func_70448_g().func_77987_b(event.block) && event.harvester.field_71071_by.func_70448_g().field_77993_c == TFItems.fieryPick.field_77779_bT) {
            final ArrayList<ItemStack> removeThese = new ArrayList<ItemStack>(1);
            final ArrayList<ItemStack> addThese = new ArrayList<ItemStack>(1);
            for (final ItemStack input : event.drops) {
                final ItemStack result = FurnaceRecipes.func_77602_a().getSmeltingResult(input);
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
        final float floatXP = FurnaceRecipes.func_77602_a().getExperience(smelted);
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
    
    @ForgeSubscribe
    public void entityHurts(final LivingHurtEvent event) {
        if (event.entityLiving instanceof EntityPlayer && event.source.field_76373_n.equals("mob") && event.source.func_76346_g() != null) {
            final EntityPlayer player = (EntityPlayer)event.entityLiving;
            final int fireLevel = TFEnchantment.getReactFireLevel(player.field_71071_by, event.source);
            if (fireLevel > 0 && player.func_70681_au().nextInt(25) < fireLevel) {
                event.source.func_76346_g().func_70015_d(fireLevel / 2);
            }
        }
        if (event.entityLiving instanceof EntityPlayer && this.willEntityDie(event)) {
            final EntityPlayer player = (EntityPlayer)event.entityLiving;
            boolean charm1 = false;
            final boolean charm2 = player.field_71071_by.func_70435_d(TFItems.charmOfLife2.field_77779_bT);
            if (!charm2) {
                charm1 = player.field_71071_by.func_70435_d(TFItems.charmOfLife1.field_77779_bT);
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
                final EntityTFCharmEffect effect = new EntityTFCharmEffect(player.field_70170_p, (EntityLivingBase)player, charm1 ? TFItems.charmOfLife1.field_77779_bT : TFItems.charmOfLife2.field_77779_bT);
                player.field_70170_p.func_72838_d((Entity)effect);
                final EntityTFCharmEffect effect2 = new EntityTFCharmEffect(player.field_70170_p, (EntityLivingBase)player, charm1 ? TFItems.charmOfLife1.field_77779_bT : TFItems.charmOfLife2.field_77779_bT);
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
    
    @ForgeSubscribe
    public void chunkLoad(final ChunkEvent.Load event) {
        final Chunk chunk = event.getChunk();
        if (chunk.field_76637_e.func_72959_q() instanceof TFWorldChunkManager) {}
    }
    
    @ForgeSubscribe
    public void bonemealUsed(final BonemealEvent event) {
        if (event.ID == TFBlocks.sapling.field_71990_ca && !event.world.field_72995_K) {
            ((BlockSapling)TFBlocks.sapling).func_72269_c(event.world, event.X, event.Y, event.Z, event.world.field_73012_v);
            event.setResult(Event.Result.ALLOW);
        }
    }
    
    @ForgeSubscribe
    public void livingDies(final LivingDeathEvent event) {
        if (event.entityLiving instanceof EntityPlayer && !event.entityLiving.field_70170_p.func_82736_K().func_82766_b("keepInventory")) {
            final EntityPlayer player = (EntityPlayer)event.entityLiving;
            if (player.field_71071_by.func_70435_d(TFItems.charmOfKeeping3.field_77779_bT)) {
                FMLLog.info("[TwilightForest] Player died with charm of keeping III!  Keep it all!", new Object[0]);
                final InventoryPlayer keepInventory = new InventoryPlayer((EntityPlayer)null);
                this.keepAllArmor(player, keepInventory);
                for (int i = 0; i < player.field_71071_by.field_70462_a.length; ++i) {
                    keepInventory.field_70462_a[i] = ItemStack.func_77944_b(player.field_71071_by.field_70462_a[i]);
                    player.field_71071_by.field_70462_a[i] = null;
                }
                keepInventory.func_70437_b(new ItemStack(TFItems.charmOfKeeping3));
                this.playerKeepsMap.put(player.field_71092_bJ, keepInventory);
            }
            else if (player.field_71071_by.func_70435_d(TFItems.charmOfKeeping2.field_77779_bT)) {
                FMLLog.info("[TwilightForest] Player died with charm of keeping II!  Keep armor and hotbar!", new Object[0]);
                final InventoryPlayer keepInventory = new InventoryPlayer((EntityPlayer)null);
                this.keepAllArmor(player, keepInventory);
                for (int i = 0; i < 9; ++i) {
                    keepInventory.field_70462_a[i] = ItemStack.func_77944_b(player.field_71071_by.field_70462_a[i]);
                    player.field_71071_by.field_70462_a[i] = null;
                }
                keepInventory.func_70437_b(new ItemStack(TFItems.charmOfKeeping2));
                this.playerKeepsMap.put(player.field_71092_bJ, keepInventory);
            }
            else if (player.field_71071_by.func_70435_d(TFItems.charmOfKeeping1.field_77779_bT)) {
                FMLLog.info("[TwilightForest] Player died with charm of keeping I!  Keep armor and current item!", new Object[0]);
                final InventoryPlayer keepInventory = new InventoryPlayer((EntityPlayer)null);
                this.keepAllArmor(player, keepInventory);
                if (player.field_71071_by.func_70448_g() != null) {
                    keepInventory.field_70462_a[player.field_71071_by.field_70461_c] = ItemStack.func_77944_b(player.field_71071_by.field_70462_a[player.field_71071_by.field_70461_c]);
                    player.field_71071_by.field_70462_a[player.field_71071_by.field_70461_c] = null;
                }
                keepInventory.func_70437_b(new ItemStack(TFItems.charmOfKeeping1));
                this.playerKeepsMap.put(player.field_71092_bJ, keepInventory);
            }
            if (player.field_71071_by.func_70450_e(TFItems.towerKey.field_77779_bT)) {
                final InventoryPlayer keepInventory = this.retrieveOrMakeKeepInventory(player);
                for (int i = 0; i < player.field_71071_by.field_70462_a.length; ++i) {
                    if (player.field_71071_by.field_70462_a[i] != null && player.field_71071_by.field_70462_a[i].field_77993_c == TFItems.towerKey.field_77779_bT) {
                        keepInventory.field_70462_a[i] = ItemStack.func_77944_b(player.field_71071_by.field_70462_a[i]);
                        player.field_71071_by.field_70462_a[i] = null;
                    }
                }
                this.playerKeepsMap.put(player.field_71092_bJ, keepInventory);
            }
        }
        if (this.playerKeepsMap.size() > 1) {
            FMLLog.warning("[TwilightForest] Twilight Forest mod is keeping track of a lot of dead player inventories.  Has there been an apocalypse?", new Object[0]);
        }
    }
    
    private InventoryPlayer retrieveOrMakeKeepInventory(final EntityPlayer player) {
        if (this.playerKeepsMap.containsKey(player.field_71092_bJ)) {
            return this.playerKeepsMap.get(player.field_71092_bJ);
        }
        return new InventoryPlayer((EntityPlayer)null);
    }
    
    private void keepAllArmor(final EntityPlayer player, final InventoryPlayer keepInventory) {
        for (int i = 0; i < player.field_71071_by.field_70460_b.length; ++i) {
            keepInventory.field_70460_b[i] = ItemStack.func_77944_b(player.field_71071_by.field_70460_b[i]);
            player.field_71071_by.field_70460_b[i] = null;
        }
    }
    
    public void onPlayerRespawn(final EntityPlayer player) {
        if (this.playerKeepsMap.containsKey(player.field_71092_bJ)) {
            FMLLog.info("[TwilightForest] Player %s respawned and recieved items held in storage", new Object[] { player.field_71092_bJ });
            final InventoryPlayer keepInventory = this.playerKeepsMap.get(player.field_71092_bJ);
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
                final EntityTFCharmEffect effect = new EntityTFCharmEffect(player.field_70170_p, (EntityLivingBase)player, keepInventory.func_70445_o().field_77993_c);
                player.field_70170_p.func_72838_d((Entity)effect);
                final EntityTFCharmEffect effect2 = new EntityTFCharmEffect(player.field_70170_p, (EntityLivingBase)player, keepInventory.func_70445_o().field_77993_c);
                effect2.offset = 3.1415927f;
                player.field_70170_p.func_72838_d((Entity)effect2);
                player.field_70170_p.func_72908_a(player.field_70165_t + 0.5, player.field_70163_u + 0.5, player.field_70161_v + 0.5, "mob.zombie.unfect", 1.5f, 1.0f);
            }
            this.playerKeepsMap.remove(player.field_71092_bJ);
        }
    }
    
    public void onPlayerLogin(final EntityPlayer player) {
    }
    
    public void onPlayerLogout(final EntityPlayer player) {
        if (this.playerKeepsMap.containsKey(player.field_71092_bJ)) {
            FMLLog.warning("[TwilightForest] Mod was keeping inventory items in reserve for player %s but they logged out!  Items are being dropped.", new Object[] { player.field_71092_bJ });
            final InventoryPlayer keepInventory = this.playerKeepsMap.get(player.field_71092_bJ);
            keepInventory.field_70458_d = player;
            keepInventory.func_70436_m();
            this.playerKeepsMap.remove(player.field_71092_bJ);
        }
    }
    
    public void onPlayerChangedDimension(final EntityPlayer player) {
    }
    
    @ForgeSubscribe
    @SideOnly(Side.CLIENT)
    public boolean preOverlay(final RenderGameOverlayEvent.Pre event) {
        if (event.type == RenderGameOverlayEvent.ElementType.HEALTHMOUNT && this.isRidingUnfriendly((EntityLivingBase)Minecraft.func_71410_x().field_71439_g)) {
            event.setCanceled(true);
            return false;
        }
        return true;
    }
    
    @ForgeSubscribe
    public boolean livingUpdate(final LivingEvent.LivingUpdateEvent event) {
        if (event.entity instanceof EntityPlayer && event.entity.func_70093_af() && this.isRidingUnfriendly(event.entityLiving)) {
            event.entity.func_70095_a(false);
        }
        return true;
    }
    
    private boolean isRidingUnfriendly(final EntityLivingBase entity) {
        return entity.func_70115_ae() && entity.field_70154_o instanceof EntityTFPinchBeetle;
    }
}
