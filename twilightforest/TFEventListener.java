// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

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
    protected ArrayList suppressDrops;
    protected HashMap playerKeepsMap;
    
    public TFEventListener() {
        this.suppressDrops = new ArrayList();
        this.playerKeepsMap = new HashMap();
    }
    
    @ForgeSubscribe
    public void pickupItem(final EntityItemPickupEvent event) {
        if (event.item.d().c == TFItems.scepterTwilight.cp || event.item.d().c == TFItems.scepterLifeDrain.cp || event.item.d().c == TFItems.scepterZombie.cp) {
            this.checkPlayerForScepterMastery(event.entityPlayer);
        }
    }
    
    private void checkPlayerForScepterMastery(final sk player) {
        boolean scepterTwilight = false;
        boolean scepterLifeDrain = false;
        boolean scepterZombie = false;
        final lt inv = (lt)player.bK;
        for (int i = 0; i < inv.j_(); ++i) {
            final wg stack = inv.a(i);
            if (stack != null && stack.c == TFItems.scepterTwilight.cp) {
                scepterTwilight = true;
            }
            if (stack != null && stack.c == TFItems.scepterLifeDrain.cp) {
                scepterLifeDrain = true;
            }
            if (stack != null && stack.c == TFItems.scepterZombie.cp) {
                scepterZombie = true;
            }
        }
        if (scepterTwilight && scepterLifeDrain && scepterZombie) {
            player.a((ka)TFAchievementPage.twilightLichScepters);
        }
    }
    
    public void onCrafting(final sk player, final wg itemStack, final lt craftMatrix) {
        if (itemStack.c == TFItems.plateNaga.cp || itemStack.c == TFItems.legsNaga.cp) {
            this.checkPlayerForNagaArmorer(player);
        }
        if (itemStack.c == TFItems.magicMapFocus.cp) {
            player.a((ka)TFAchievementPage.twilightMagicMapFocus);
        }
        if (itemStack.c == TFItems.emptyMagicMap.cp) {
            player.a((ka)TFAchievementPage.twilightMagicMap);
        }
        if (itemStack.c == TFItems.emptyMazeMap.cp) {
            player.a((ka)TFAchievementPage.twilightMazeMap);
        }
        if (itemStack.c == TFItems.emptyOreMap.cp) {
            player.a((ka)TFAchievementPage.twilightOreMap);
        }
    }
    
    public void onSmelting(final sk player, final wg item) {
    }
    
    private void checkPlayerForNagaArmorer(final sk player) {
        boolean nagaScale = false;
        boolean legsNaga = false;
        final lt inv = (lt)player.bK;
        for (int i = 0; i < inv.j_(); ++i) {
            final wg stack = inv.a(i);
            if (stack != null && stack.c == TFItems.nagaScale.cp) {
                nagaScale = true;
            }
            if (stack != null && stack.c == TFItems.legsNaga.cp) {
                legsNaga = true;
            }
        }
        if (nagaScale && legsNaga) {
            player.a((ka)TFAchievementPage.twilightNagaArmors);
        }
    }
    
    @ForgeSubscribe
    public void entityJoinWorld(final EntityJoinWorldEvent event) {
        if (event.entity instanceof rb && !this.suppressDrops.isEmpty()) {
            final rb entityItem = (rb)event.entity;
            wg suppressed = null;
            for (final wg suppressItem : this.suppressDrops) {
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
    
    public void supressDrop(final wg istack) {
        this.suppressDrops.add(istack);
        if (this.suppressDrops.size() > 1) {
            System.out.println("Supress list is growing..." + this.suppressDrops);
        }
    }
    
    @ForgeSubscribe
    public void entityHurts(final LivingHurtEvent event) {
        if (event.entityLiving instanceof sk && event.source.o.equals("mob")) {
            final sk player = (sk)event.entityLiving;
            final int fireLevel = TFEnchantment.getReactFireLevel(player.bK, event.source);
            if (fireLevel > 0 && player.aE().nextInt(25) < fireLevel) {
                event.source.i().d(fireLevel / 2);
            }
        }
        if (event.entityLiving instanceof sk && this.willEntityDie(event)) {
            final sk player = (sk)event.entityLiving;
            boolean charm1 = false;
            final boolean charm2 = player.bK.d(TFItems.charmOfLife2.cp);
            if (!charm2) {
                charm1 = player.bK.d(TFItems.charmOfLife1.cp);
            }
            if (charm2 || charm1) {
                event.setResult(Event.Result.DENY);
                event.setCanceled(true);
                event.ammount = 0;
                if (charm1) {
                    player.b(8);
                    player.d(new ml(mk.l.H, 100, 0));
                }
                if (charm2) {
                    player.b(player.aW());
                    player.d(new ml(mk.l.H, 600, 3));
                    player.d(new ml(mk.m.H, 600, 0));
                    player.d(new ml(mk.n.H, 600, 0));
                }
                final EntityTFCharmEffect effect = new EntityTFCharmEffect(player.q, (ng)player, charm1 ? TFItems.charmOfLife1.cp : TFItems.charmOfLife2.cp);
                player.q.d((mp)effect);
                final EntityTFCharmEffect effect2 = new EntityTFCharmEffect(player.q, (ng)player, charm1 ? TFItems.charmOfLife1.cp : TFItems.charmOfLife2.cp);
                effect2.offset = 3.1415927f;
                player.q.d((mp)effect2);
                player.q.a(player.u + 0.5, player.v + 0.5, player.w + 0.5, "mob.zombie.unfect", 1.5f, 1.0f);
            }
        }
    }
    
    public boolean willEntityDie(final LivingHurtEvent event) {
        float amount = (float)event.ammount;
        final mg source = event.source;
        final ng living = event.entityLiving;
        if (!source.e()) {
            final int armor = 25 - living.aZ();
            amount = (amount * armor + living.aU) / 25.0f;
        }
        if (living.a(mk.m)) {
            final int resistance = 25 - (living.b(mk.m).c() + 1) * 5;
            amount = amount * resistance / 25.0f;
        }
        return Math.ceil(amount) >= living.aX();
    }
    
    @ForgeSubscribe
    public void bonemealUsed(final BonemealEvent event) {
        if (event.ID == TFBlocks.sapling.cz && !event.world.I) {
            ((aoe)TFBlocks.sapling).d(event.world, event.X, event.Y, event.Z, event.world.s);
            event.setResult(Event.Result.ALLOW);
        }
    }
    
    @ForgeSubscribe
    public void livingDies(final LivingDeathEvent event) {
        if (event.entityLiving instanceof sk && !event.entityLiving.q.M().b("keepInventory")) {
            final sk player = (sk)event.entityLiving;
            if (player.bK.d(TFItems.charmOfKeeping3.cp)) {
                FMLLog.info("[TwilightForest] Player died with charm of keeping III!  Keep it all!", new Object[0]);
                final si keepInventory = new si((sk)null);
                this.keepAllArmor(player, keepInventory);
                for (int i = 0; i < player.bK.a.length; ++i) {
                    keepInventory.a[i] = player.bK.a[i];
                    player.bK.a[i] = null;
                }
                keepInventory.b(new wg(TFItems.charmOfKeeping3));
                this.playerKeepsMap.put(player.bS, keepInventory);
            }
            else if (player.bK.d(TFItems.charmOfKeeping2.cp)) {
                FMLLog.info("[TwilightForest] Player died with charm of keeping II!  Keep armor and hotbar!", new Object[0]);
                final si keepInventory = new si((sk)null);
                this.keepAllArmor(player, keepInventory);
                for (int i = 0; i < 9; ++i) {
                    keepInventory.a[i] = player.bK.a[i];
                    player.bK.a[i] = null;
                }
                keepInventory.b(new wg(TFItems.charmOfKeeping2));
                this.playerKeepsMap.put(player.bS, keepInventory);
            }
            else if (player.bK.d(TFItems.charmOfKeeping1.cp)) {
                FMLLog.info("[TwilightForest] Player died with charm of keeping I!  Keep armor and current item!", new Object[0]);
                final si keepInventory = new si((sk)null);
                this.keepAllArmor(player, keepInventory);
                if (player.bK.h() != null) {
                    keepInventory.a[player.bK.c] = player.bK.a[player.bK.c];
                    player.bK.a[player.bK.c] = null;
                }
                keepInventory.b(new wg(TFItems.charmOfKeeping1));
                this.playerKeepsMap.put(player.bS, keepInventory);
            }
            if (player.bK.e(TFItems.towerKey.cp)) {
                final si keepInventory = this.retrieveOrMakeKeepInventory(player);
                for (int i = 0; i < player.bK.a.length; ++i) {
                    if (player.bK.a[i] != null && player.bK.a[i].c == TFItems.towerKey.cp) {
                        keepInventory.a[i] = player.bK.a[i];
                        player.bK.a[i] = null;
                    }
                }
                this.playerKeepsMap.put(player.bS, keepInventory);
            }
        }
        if (this.playerKeepsMap.size() > 1) {
            FMLLog.warning("[TwilightForest] Twilight Forest mod is keeping track of a lot of dead player inventories.  Has there been an apocalypse?", new Object[0]);
        }
    }
    
    private si retrieveOrMakeKeepInventory(final sk player) {
        if (this.playerKeepsMap.containsKey(player.bS)) {
            return this.playerKeepsMap.get(player.bS);
        }
        return new si((sk)null);
    }
    
    private void keepAllArmor(final sk player, final si keepInventory) {
        for (int i = 0; i < player.bK.b.length; ++i) {
            keepInventory.b[i] = player.bK.b[i];
            player.bK.b[i] = null;
        }
    }
    
    public void onPlayerRespawn(final sk player) {
        if (this.playerKeepsMap.containsKey(player.bS)) {
            FMLLog.info("[TwilightForest] Player %s respawned and recieved items held in storage", new Object[] { player.bS });
            final si keepInventory = this.playerKeepsMap.get(player.bS);
            for (int i = 0; i < player.bK.b.length; ++i) {
                player.bK.b[i] = keepInventory.b[i];
            }
            for (int i = 0; i < player.bK.a.length; ++i) {
                player.bK.a[i] = keepInventory.a[i];
            }
            if (keepInventory.o() != null) {
                final EntityTFCharmEffect effect = new EntityTFCharmEffect(player.q, (ng)player, keepInventory.o().c);
                player.q.d((mp)effect);
                final EntityTFCharmEffect effect2 = new EntityTFCharmEffect(player.q, (ng)player, keepInventory.o().c);
                effect2.offset = 3.1415927f;
                player.q.d((mp)effect2);
                player.q.a(player.u + 0.5, player.v + 0.5, player.w + 0.5, "mob.zombie.unfect", 1.5f, 1.0f);
            }
            this.playerKeepsMap.remove(player.bS);
        }
    }
    
    public void onPlayerLogin(final sk player) {
    }
    
    public void onPlayerLogout(final sk player) {
        if (this.playerKeepsMap.containsKey(player.bS)) {
            FMLLog.warning("[TwilightForest] Mod was keeping inventory items in reserve for player %s but they logged out!  Items are being dropped.", new Object[] { player.bS });
            final si keepInventory = this.playerKeepsMap.get(player.bS);
            keepInventory.d = player;
            keepInventory.m();
            this.playerKeepsMap.remove(player.bS);
        }
    }
    
    public void onPlayerChangedDimension(final sk player) {
    }
}
