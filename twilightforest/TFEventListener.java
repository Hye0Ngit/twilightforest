// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import twilightforest.entity.EntityTFPinchBeetle;
import net.minecraftforge.event.entity.living.LivingEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import cpw.mods.fml.common.FMLLog;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import twilightforest.block.TFBlocks;
import net.minecraftforge.event.entity.player.BonemealEvent;
import twilightforest.entity.EntityTFCharmEffect;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import java.util.Iterator;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.ForgeSubscribe;
import twilightforest.item.TFItems;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import java.util.HashMap;
import java.util.ArrayList;
import cpw.mods.fml.common.IPlayerTracker;
import cpw.mods.fml.common.ICraftingHandler;

public class TFEventListener implements ICraftingHandler, IPlayerTracker
{
    protected ArrayList<yd> suppressDrops;
    protected HashMap<String, uc> playerKeepsMap;
    
    public TFEventListener() {
        this.suppressDrops = new ArrayList<yd>();
        this.playerKeepsMap = new HashMap<String, uc>();
    }
    
    @ForgeSubscribe
    public void pickupItem(final EntityItemPickupEvent event) {
        if (event.item.d().d == TFItems.scepterTwilight.cv || event.item.d().d == TFItems.scepterLifeDrain.cv || event.item.d().d == TFItems.scepterZombie.cv) {
            this.checkPlayerForScepterMastery(event.entityPlayer);
        }
    }
    
    private void checkPlayerForScepterMastery(final ue player) {
        boolean scepterTwilight = false;
        boolean scepterLifeDrain = false;
        boolean scepterZombie = false;
        final mn inv = (mn)player.bn;
        for (int i = 0; i < inv.j_(); ++i) {
            final yd stack = inv.a(i);
            if (stack != null && stack.d == TFItems.scepterTwilight.cv) {
                scepterTwilight = true;
            }
            if (stack != null && stack.d == TFItems.scepterLifeDrain.cv) {
                scepterLifeDrain = true;
            }
            if (stack != null && stack.d == TFItems.scepterZombie.cv) {
                scepterZombie = true;
            }
        }
        if (scepterTwilight && scepterLifeDrain && scepterZombie) {
            player.a((kt)TFAchievementPage.twilightLichScepters);
        }
    }
    
    public void onCrafting(final ue player, final yd itemStack, final mn craftMatrix) {
        if (itemStack.d == TFItems.plateNaga.cv || itemStack.d == TFItems.legsNaga.cv) {
            this.checkPlayerForNagaArmorer(player);
        }
        if (itemStack.d == TFItems.magicMapFocus.cv) {
            player.a((kt)TFAchievementPage.twilightMagicMapFocus);
        }
        if (itemStack.d == TFItems.emptyMagicMap.cv) {
            player.a((kt)TFAchievementPage.twilightMagicMap);
        }
        if (itemStack.d == TFItems.emptyMazeMap.cv) {
            player.a((kt)TFAchievementPage.twilightMazeMap);
        }
        if (itemStack.d == TFItems.emptyOreMap.cv) {
            player.a((kt)TFAchievementPage.twilightOreMap);
        }
    }
    
    public void onSmelting(final ue player, final yd item) {
    }
    
    private void checkPlayerForNagaArmorer(final ue player) {
        boolean nagaScale = false;
        boolean legsNaga = false;
        final mn inv = (mn)player.bn;
        for (int i = 0; i < inv.j_(); ++i) {
            final yd stack = inv.a(i);
            if (stack != null && stack.d == TFItems.nagaScale.cv) {
                nagaScale = true;
            }
            if (stack != null && stack.d == TFItems.legsNaga.cv) {
                legsNaga = true;
            }
        }
        if (nagaScale && legsNaga) {
            player.a((kt)TFAchievementPage.twilightNagaArmors);
        }
    }
    
    @ForgeSubscribe
    public void entityJoinWorld(final EntityJoinWorldEvent event) {
        if (event.entity instanceof sr && !this.suppressDrops.isEmpty()) {
            final sr entityItem = (sr)event.entity;
            yd suppressed = null;
            for (final yd suppressItem : this.suppressDrops) {
                if (suppressItem.a(entityItem.d())) {
                    event.setCanceled(true);
                    suppressed = suppressItem;
                }
            }
            if (suppressed != null) {
                this.suppressDrops.remove(suppressed);
            }
        }
    }
    
    public void supressDrop(final yd istack) {
        this.suppressDrops.add(istack);
        if (this.suppressDrops.size() > 1) {
            System.out.println("Supress list is growing..." + this.suppressDrops);
        }
    }
    
    @ForgeSubscribe
    public void entityHurts(final LivingHurtEvent event) {
        if (event.entityLiving instanceof ue && event.source.o.equals("mob")) {
            final ue player = (ue)event.entityLiving;
            final int fireLevel = TFEnchantment.getReactFireLevel(player.bn, event.source);
            if (fireLevel > 0 && player.aC().nextInt(25) < fireLevel) {
                event.source.i().d(fireLevel / 2);
            }
        }
        if (event.entityLiving instanceof ue && this.willEntityDie(event)) {
            final ue player = (ue)event.entityLiving;
            boolean charm1 = false;
            final boolean charm2 = player.bn.d(TFItems.charmOfLife2.cv);
            if (!charm2) {
                charm1 = player.bn.d(TFItems.charmOfLife1.cv);
            }
            if (charm2 || charm1) {
                event.setResult(Event.Result.DENY);
                event.setCanceled(true);
                event.ammount = 0.0f;
                if (charm1) {
                    player.g(8.0f);
                    player.c(new ni(nh.l.H, 100, 0));
                }
                if (charm2) {
                    player.g((float)player.a(to.a).e());
                    player.c(new ni(nh.l.H, 600, 3));
                    player.c(new ni(nh.m.H, 600, 0));
                    player.c(new ni(nh.n.H, 600, 0));
                }
                final EntityTFCharmEffect effect = new EntityTFCharmEffect(player.q, (oe)player, charm1 ? TFItems.charmOfLife1.cv : TFItems.charmOfLife2.cv);
                player.q.d((nm)effect);
                final EntityTFCharmEffect effect2 = new EntityTFCharmEffect(player.q, (oe)player, charm1 ? TFItems.charmOfLife1.cv : TFItems.charmOfLife2.cv);
                effect2.offset = 3.1415927f;
                player.q.d((nm)effect2);
                player.q.a(player.u + 0.5, player.v + 0.5, player.w + 0.5, "mob.zombie.unfect", 1.5f, 1.0f);
            }
        }
    }
    
    public boolean willEntityDie(final LivingHurtEvent event) {
        float amount = event.ammount;
        final na source = event.source;
        final oe living = event.entityLiving;
        if (!source.e()) {
            final int armor = 25 - living.aP();
            amount = amount * armor / 25.0f;
        }
        if (living.a(nh.m)) {
            final int resistance = 25 - (living.b(nh.m).c() + 1) * 5;
            amount = amount * resistance / 25.0f;
        }
        return Math.ceil(amount) >= living.aM();
    }
    
    @ForgeSubscribe
    public void bonemealUsed(final BonemealEvent event) {
        if (event.ID == TFBlocks.sapling.cF && !event.world.I) {
            ((aqf)TFBlocks.sapling).d(event.world, event.X, event.Y, event.Z, event.world.s);
            event.setResult(Event.Result.ALLOW);
        }
    }
    
    @ForgeSubscribe
    public void livingDies(final LivingDeathEvent event) {
        if (event.entityLiving instanceof ue && !event.entityLiving.q.O().b("keepInventory")) {
            final ue player = (ue)event.entityLiving;
            if (player.bn.d(TFItems.charmOfKeeping3.cv)) {
                FMLLog.info("[TwilightForest] Player died with charm of keeping III!  Keep it all!", new Object[0]);
                final uc keepInventory = new uc((ue)null);
                this.keepAllArmor(player, keepInventory);
                for (int i = 0; i < player.bn.a.length; ++i) {
                    keepInventory.a[i] = player.bn.a[i];
                    player.bn.a[i] = null;
                }
                keepInventory.b(new yd(TFItems.charmOfKeeping3));
                this.playerKeepsMap.put(player.bu, keepInventory);
            }
            else if (player.bn.d(TFItems.charmOfKeeping2.cv)) {
                FMLLog.info("[TwilightForest] Player died with charm of keeping II!  Keep armor and hotbar!", new Object[0]);
                final uc keepInventory = new uc((ue)null);
                this.keepAllArmor(player, keepInventory);
                for (int i = 0; i < 9; ++i) {
                    keepInventory.a[i] = player.bn.a[i];
                    player.bn.a[i] = null;
                }
                keepInventory.b(new yd(TFItems.charmOfKeeping2));
                this.playerKeepsMap.put(player.bu, keepInventory);
            }
            else if (player.bn.d(TFItems.charmOfKeeping1.cv)) {
                FMLLog.info("[TwilightForest] Player died with charm of keeping I!  Keep armor and current item!", new Object[0]);
                final uc keepInventory = new uc((ue)null);
                this.keepAllArmor(player, keepInventory);
                if (player.bn.h() != null) {
                    keepInventory.a[player.bn.c] = player.bn.a[player.bn.c];
                    player.bn.a[player.bn.c] = null;
                }
                keepInventory.b(new yd(TFItems.charmOfKeeping1));
                this.playerKeepsMap.put(player.bu, keepInventory);
            }
            if (player.bn.e(TFItems.towerKey.cv)) {
                final uc keepInventory = this.retrieveOrMakeKeepInventory(player);
                for (int i = 0; i < player.bn.a.length; ++i) {
                    if (player.bn.a[i] != null && player.bn.a[i].d == TFItems.towerKey.cv) {
                        keepInventory.a[i] = player.bn.a[i];
                        player.bn.a[i] = null;
                    }
                }
                this.playerKeepsMap.put(player.bu, keepInventory);
            }
        }
        if (this.playerKeepsMap.size() > 1) {
            FMLLog.warning("[TwilightForest] Twilight Forest mod is keeping track of a lot of dead player inventories.  Has there been an apocalypse?", new Object[0]);
        }
    }
    
    private uc retrieveOrMakeKeepInventory(final ue player) {
        if (this.playerKeepsMap.containsKey(player.bu)) {
            return this.playerKeepsMap.get(player.bu);
        }
        return new uc((ue)null);
    }
    
    private void keepAllArmor(final ue player, final uc keepInventory) {
        for (int i = 0; i < player.bn.b.length; ++i) {
            keepInventory.b[i] = player.bn.b[i];
            player.bn.b[i] = null;
        }
    }
    
    public void onPlayerRespawn(final ue player) {
        if (this.playerKeepsMap.containsKey(player.bu)) {
            FMLLog.info("[TwilightForest] Player %s respawned and recieved items held in storage", new Object[] { player.bu });
            final uc keepInventory = this.playerKeepsMap.get(player.bu);
            for (int i = 0; i < player.bn.b.length; ++i) {
                player.bn.b[i] = keepInventory.b[i];
            }
            for (int i = 0; i < player.bn.a.length; ++i) {
                player.bn.a[i] = keepInventory.a[i];
            }
            if (keepInventory.o() != null) {
                final EntityTFCharmEffect effect = new EntityTFCharmEffect(player.q, (oe)player, keepInventory.o().d);
                player.q.d((nm)effect);
                final EntityTFCharmEffect effect2 = new EntityTFCharmEffect(player.q, (oe)player, keepInventory.o().d);
                effect2.offset = 3.1415927f;
                player.q.d((nm)effect2);
                player.q.a(player.u + 0.5, player.v + 0.5, player.w + 0.5, "mob.zombie.unfect", 1.5f, 1.0f);
            }
            this.playerKeepsMap.remove(player.bu);
        }
    }
    
    public void onPlayerLogin(final ue player) {
    }
    
    public void onPlayerLogout(final ue player) {
        if (this.playerKeepsMap.containsKey(player.bu)) {
            FMLLog.warning("[TwilightForest] Mod was keeping inventory items in reserve for player %s but they logged out!  Items are being dropped.", new Object[] { player.bu });
            final uc keepInventory = this.playerKeepsMap.get(player.bu);
            keepInventory.d = player;
            keepInventory.m();
            this.playerKeepsMap.remove(player.bu);
        }
    }
    
    public void onPlayerChangedDimension(final ue player) {
    }
    
    @ForgeSubscribe
    @SideOnly(Side.CLIENT)
    public boolean preOverlay(final RenderGameOverlayEvent.Pre event) {
        if (event.type == RenderGameOverlayEvent.ElementType.HEALTHMOUNT && this.isRidingUnfriendly((oe)ats.w().h)) {
            event.setCanceled(true);
            return false;
        }
        return true;
    }
    
    @ForgeSubscribe
    public boolean livingUpdate(final LivingEvent.LivingUpdateEvent event) {
        if (event.entity instanceof ue && event.entity.ag() && this.isRidingUnfriendly(event.entityLiving)) {
            event.entity.b(false);
        }
        return true;
    }
    
    private boolean isRidingUnfriendly(final oe entity) {
        return entity.af() && entity.o instanceof EntityTFPinchBeetle;
    }
}
