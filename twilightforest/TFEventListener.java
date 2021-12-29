// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import net.minecraftforge.event.entity.living.LivingDeathEvent;
import twilightforest.block.TFBlocks;
import net.minecraftforge.event.entity.player.BonemealEvent;
import java.io.File;
import net.minecraftforge.event.world.WorldEvent;
import twilightforest.biomes.TFBiomeBase;
import twilightforest.world.TFWorldChunkManager;
import net.minecraftforge.event.world.ChunkEvent;
import twilightforest.entity.EntityTFCharmEffect;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import java.util.Iterator;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.ForgeSubscribe;
import twilightforest.item.TFItems;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import cpw.mods.fml.common.IPlayerTracker;
import cpw.mods.fml.common.ICraftingHandler;

public class TFEventListener implements ICraftingHandler, IPlayerTracker
{
    protected List suppressDrops;
    protected HashMap playerKeepsMap;
    
    public TFEventListener() {
        this.suppressDrops = new ArrayList();
        this.playerKeepsMap = new HashMap();
    }
    
    @ForgeSubscribe
    public void pickupItem(final EntityItemPickupEvent event) {
        if (event.item.d().c == TFItems.scepterTwilight.cj || event.item.d().c == TFItems.scepterLifeDrain.cj || event.item.d().c == TFItems.scepterZombie.cj) {
            this.checkPlayerForScepterMastery(event.entityPlayer);
        }
    }
    
    private void checkPlayerForScepterMastery(final qx player) {
        boolean scepterTwilight = false;
        boolean scepterLifeDrain = false;
        boolean scepterZombie = false;
        final la inv = (la)player.bJ;
        for (int i = 0; i < inv.k_(); ++i) {
            final ur stack = inv.a(i);
            if (stack != null && stack.c == TFItems.scepterTwilight.cj) {
                scepterTwilight = true;
            }
            if (stack != null && stack.c == TFItems.scepterLifeDrain.cj) {
                scepterLifeDrain = true;
            }
            if (stack != null && stack.c == TFItems.scepterZombie.cj) {
                scepterZombie = true;
            }
        }
        if (scepterTwilight && scepterLifeDrain && scepterZombie) {
            player.a((jl)TFAchievementPage.twilightLichScepters);
        }
    }
    
    public void onCrafting(final qx player, final ur itemStack, final la craftMatrix) {
        if (itemStack.c == TFItems.plateNaga.cj || itemStack.c == TFItems.legsNaga.cj) {
            this.checkPlayerForNagaArmorer(player);
        }
        if (itemStack.c == TFItems.magicMapFocus.cj) {
            player.a((jl)TFAchievementPage.twilightMagicMapFocus);
        }
        if (itemStack.c == TFItems.magicMap.cj) {
            player.a((jl)TFAchievementPage.twilightMagicMap);
        }
        if (itemStack.c == TFItems.mazeMap.cj) {
            player.a((jl)TFAchievementPage.twilightMazeMap);
        }
        if (itemStack.c == TFItems.oreMap.cj) {
            player.a((jl)TFAchievementPage.twilightOreMap);
        }
    }
    
    public void onSmelting(final qx player, final ur item) {
    }
    
    private void checkPlayerForNagaArmorer(final qx player) {
        boolean nagaScale = false;
        boolean legsNaga = false;
        final la inv = (la)player.bJ;
        for (int i = 0; i < inv.k_(); ++i) {
            final ur stack = inv.a(i);
            if (stack != null && stack.c == TFItems.nagaScale.cj) {
                nagaScale = true;
            }
            if (stack != null && stack.c == TFItems.legsNaga.cj) {
                legsNaga = true;
            }
        }
        if (nagaScale && legsNaga) {
            player.a((jl)TFAchievementPage.twilightNagaArmors);
        }
    }
    
    @ForgeSubscribe
    public void entityJoinWorld(final EntityJoinWorldEvent event) {
        if (event.entity instanceof px && !this.suppressDrops.isEmpty()) {
            final px entityItem = (px)event.entity;
            final Iterator supressLoop = this.suppressDrops.iterator();
            while (supressLoop.hasNext()) {
                final ur item = supressLoop.next();
                if (item.a(entityItem.d())) {
                    event.setCanceled(true);
                    supressLoop.remove();
                }
            }
        }
    }
    
    public void supressDrop(final ur istack) {
        this.suppressDrops.add(istack);
        if (this.suppressDrops.size() > 1) {
            System.out.println("Supress list is growing..." + this.suppressDrops);
        }
    }
    
    @ForgeSubscribe
    public void entityHurts(final LivingHurtEvent event) {
        if (event.entityLiving instanceof qx && event.source.q.equals("mob")) {
            final qx player = (qx)event.entityLiving;
            final int fireLevel = TFEnchantment.getReactFireLevel(player.bJ, event.source);
            if (fireLevel > 0 && player.aB().nextInt(25) < fireLevel) {
                event.source.g().c(fireLevel / 2);
            }
        }
        if (event.entityLiving instanceof qx && this.willEntityDie(event)) {
            final qx player = (qx)event.entityLiving;
            boolean charm1 = false;
            final boolean charm2 = player.bJ.d(TFItems.charmOfLife2.cj);
            if (!charm2) {
                charm1 = player.bJ.d(TFItems.charmOfLife1.cj);
            }
            if (charm2 || charm1) {
                event.setResult(Event.Result.DENY);
                event.setCanceled(true);
                event.ammount = 0;
                if (charm1) {
                    player.j(8);
                    player.d(new lm(ll.l.H, 100, 0));
                }
                if (charm2) {
                    player.j(player.aT());
                    player.d(new lm(ll.l.H, 600, 3));
                    player.d(new lm(ll.m.H, 600, 0));
                    player.d(new lm(ll.n.H, 600, 0));
                }
                final EntityTFCharmEffect effect = new EntityTFCharmEffect(player.p, (md)player, charm1 ? TFItems.charmOfLife1.cj : TFItems.charmOfLife2.cj);
                player.p.d((lq)effect);
                final EntityTFCharmEffect effect2 = new EntityTFCharmEffect(player.p, (md)player, charm1 ? TFItems.charmOfLife1.cj : TFItems.charmOfLife2.cj);
                effect2.offset = 3.1415927f;
                player.p.d((lq)effect2);
                player.p.a(player.t + 0.5, player.u + 0.5, player.v + 0.5, "mob.zombie.unfect", 1.5f, 1.0f);
            }
        }
    }
    
    public boolean willEntityDie(final LivingHurtEvent event) {
        float amount = (float)event.ammount;
        final lh source = event.source;
        final md living = event.entityLiving;
        if (!source.c()) {
            final int armor = 25 - living.aW();
            amount = amount * armor / 25.0f;
        }
        if (living.a(ll.m)) {
            final int resistance = 25 - (living.b(ll.m).c() + 1) * 5;
            amount = amount * resistance / 25.0f;
        }
        return Math.ceil(amount) >= living.aU();
    }
    
    @ForgeSubscribe
    public void chunkLoad(final ChunkEvent.Load event) {
        final zz chunk = event.getChunk();
        if (chunk.e.t() instanceof TFWorldChunkManager) {
            final TFWorldChunkManager tfManager = (TFWorldChunkManager)chunk.e.t();
            chunk.a(0, 0, chunk.e.t());
            if (chunk.m()[0] == TFBiomeBase.majorFeature.N) {
                int featureID = chunk.c(0, 0, 0) | chunk.c(0, 1, 0) << 4;
                int featureStatus = chunk.c(0, 2, 0);
                if (featureID == 0) {
                    featureID = TFFeature.generateFeatureFor(chunk.g, chunk.h, chunk.e).featureID;
                    featureStatus = 1;
                    System.out.println("Generating new marker at " + chunk.g + ", " + chunk.h + " for ID " + featureID);
                    chunk.a(0, 0, 0, amq.C.cm);
                    chunk.a(0, 1, 0, amq.C.cm);
                    chunk.a(0, 2, 0, amq.C.cm);
                    chunk.b(0, 0, 0, featureID & 0xF);
                    chunk.b(0, 1, 0, (featureID & 0xF0) << 4);
                    chunk.b(0, 2, 0, 1);
                }
                tfManager.cacheFeatureData(chunk.g, chunk.h, featureID, featureStatus);
            }
            else {
                tfManager.cacheFeatureData(chunk.g, chunk.h, 0, 0);
            }
        }
    }
    
    @ForgeSubscribe
    public void worldSave(final WorldEvent.Save event) {
        final yc world = event.world;
        if (world instanceof in && world.t() instanceof TFWorldChunkManager) {
            final TFWorldChunkManager tfManager = (TFWorldChunkManager)world.t();
            final in worldServer = (in)world;
            final File chunkDir = worldServer.getChunkSaveLocation();
            tfManager.saveFeatureCache(chunkDir);
        }
    }
    
    @ForgeSubscribe
    public void worldLoad(final WorldEvent.Load event) {
        final yc world = event.world;
        if (world instanceof in && world.t() instanceof TFWorldChunkManager) {
            final TFWorldChunkManager tfManager = (TFWorldChunkManager)world.t();
            final in worldServer = (in)world;
            final File chunkDir = worldServer.getChunkSaveLocation();
            tfManager.loadFeatureCache(chunkDir);
        }
    }
    
    @ForgeSubscribe
    public void bonemealUsed(final BonemealEvent event) {
        if (event.ID == TFBlocks.sapling.cm && !event.world.I) {
            ((ama)TFBlocks.sapling).c(event.world, event.X, event.Y, event.Z, event.world.t);
            event.setResult(Event.Result.ALLOW);
        }
    }
    
    @ForgeSubscribe
    public void livingDies(final LivingDeathEvent event) {
        if (event.entityLiving instanceof qx && !event.entityLiving.p.L().b("keepInventory")) {
            final qx player = (qx)event.entityLiving;
            if (player.bJ.d(TFItems.charmOfKeeping3.cj)) {
                System.out.println("Player died with charm of keeping III!  Keep it all!");
                final qw keepInventory = new qw(player);
                this.keepAllArmor(player, keepInventory);
                for (int i = 0; i < player.bJ.a.length; ++i) {
                    keepInventory.a[i] = player.bJ.a[i];
                    player.bJ.a[i] = null;
                }
                this.playerKeepsMap.put(player.bR, keepInventory);
            }
            else if (player.bJ.d(TFItems.charmOfKeeping2.cj)) {
                System.out.println("Player died with charm of keeping II!  Keep armor and hotbar!");
                final qw keepInventory = new qw(player);
                this.keepAllArmor(player, keepInventory);
                for (int i = 0; i < 9; ++i) {
                    keepInventory.a[i] = player.bJ.a[i];
                    player.bJ.a[i] = null;
                }
                this.playerKeepsMap.put(player.bR, keepInventory);
            }
            else if (player.bJ.d(TFItems.charmOfKeeping1.cj)) {
                System.out.println("Player died with charm of keeping I!  Keep armor and current item!");
                final qw keepInventory = new qw(player);
                this.keepAllArmor(player, keepInventory);
                if (player.bJ.g() != null) {
                    keepInventory.a[player.bJ.c] = player.bJ.a[player.bJ.c];
                    player.bJ.a[player.bJ.c] = null;
                }
                this.playerKeepsMap.put(player.bR, keepInventory);
            }
        }
        if (this.playerKeepsMap.size() > 1) {
            System.err.println("Twilight Forest mod is keeping track of a lot of dead player inventories.  Has there been an apocalypse?");
        }
    }
    
    private void keepAllArmor(final qx player, final qw keepInventory) {
        for (int i = 0; i < player.bJ.b.length; ++i) {
            keepInventory.b[i] = player.bJ.b[i];
            player.bJ.b[i] = null;
        }
    }
    
    public void onPlayerRespawn(final qx player) {
        if (this.playerKeepsMap.containsKey(player.bR)) {
            System.out.println("Oh hi, " + player.bR + "!  I have stuff for you!");
            final qw keepInventory = this.playerKeepsMap.get(player.bR);
            for (int i = 0; i < player.bJ.b.length; ++i) {
                player.bJ.b[i] = keepInventory.b[i];
            }
            for (int i = 0; i < player.bJ.a.length; ++i) {
                player.bJ.a[i] = keepInventory.a[i];
            }
            final EntityTFCharmEffect effect = new EntityTFCharmEffect(player.p, (md)player, TFItems.charmOfKeeping3.cj);
            player.p.d((lq)effect);
            final EntityTFCharmEffect effect2 = new EntityTFCharmEffect(player.p, (md)player, TFItems.charmOfKeeping3.cj);
            effect2.offset = 3.1415927f;
            player.p.d((lq)effect2);
            player.p.a(player.t + 0.5, player.u + 0.5, player.v + 0.5, "mob.zombie.unfect", 1.5f, 1.0f);
            this.playerKeepsMap.remove(player.bR);
        }
    }
    
    public void onPlayerLogin(final qx player) {
    }
    
    public void onPlayerLogout(final qx player) {
        if (this.playerKeepsMap.containsKey(player.bR)) {
            System.err.println("Twilight Forest Mod was keeping inventory items in reserve for player " + player.bR + " but they logged out!  Items are being dropped.");
            final qw keepInventory = this.playerKeepsMap.get(player.bR);
            keepInventory.l();
            this.playerKeepsMap.remove(player.bR);
        }
    }
    
    public void onPlayerChangedDimension(final qx player) {
    }
}
