// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import net.minecraft.client.Minecraft;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import twilightforest.tileentity.TileEntityTFTrophy;
import twilightforest.tileentity.TileEntityTFMoonworm;
import twilightforest.tileentity.TileEntityTFCicada;
import cpw.mods.fml.client.registry.ClientRegistry;
import twilightforest.tileentity.TileEntityTFFirefly;
import twilightforest.client.model.ModelTFHydraNeck;
import twilightforest.entity.EntityTFHydraNeck;
import twilightforest.client.model.ModelTFHydraHead;
import twilightforest.entity.EntityTFHydraHead;
import twilightforest.entity.EntityTFLichBomb;
import twilightforest.item.TFItems;
import twilightforest.entity.EntityTFCharmEffect;
import twilightforest.entity.EntityTFMoonwormShot;
import twilightforest.entity.EntityTFSlimeProjectile;
import twilightforest.entity.EntityTFHydraMortar;
import twilightforest.entity.EntityTFTomeBolt;
import twilightforest.entity.EntityTFTwilightWandBolt;
import twilightforest.entity.EntityTFLichBolt;
import twilightforest.entity.EntityTFNatureBolt;
import twilightforest.client.model.ModelTFTowerBoss;
import twilightforest.entity.EntityTFUrGhast;
import twilightforest.entity.EntityTFTowerGhast;
import twilightforest.entity.EntityTFTowerTermite;
import twilightforest.client.model.ModelTFTowerGolem;
import twilightforest.entity.EntityTFTowerGolem;
import twilightforest.client.model.ModelTFGhast;
import twilightforest.entity.EntityTFMiniGhast;
import twilightforest.entity.EntityTFMobileFirefly;
import twilightforest.entity.EntityTFMistWolf;
import twilightforest.client.model.ModelTFPinchBeetle;
import twilightforest.entity.EntityTFPinchBeetle;
import twilightforest.client.model.ModelTFSlimeBeetle;
import twilightforest.entity.EntityTFSlimeBeetle;
import twilightforest.client.model.ModelTFFireBeetle;
import twilightforest.entity.EntityTFFireBeetle;
import twilightforest.client.model.ModelTFMinoshroom;
import twilightforest.entity.EntityTFMinoshroom;
import twilightforest.client.model.ModelTFMinotaur;
import twilightforest.entity.EntityTFMinotaur;
import twilightforest.client.model.ModelTFDeathTome;
import twilightforest.entity.EntityTFDeathTome;
import twilightforest.client.model.ModelTFMosquitoSwarm;
import twilightforest.entity.EntityTFMosquitoSwarm;
import twilightforest.entity.EntityTFBoggard;
import twilightforest.client.model.ModelTFKobold;
import twilightforest.entity.EntityTFKobold;
import twilightforest.entity.EntityTFQuestRam;
import twilightforest.client.model.ModelTFRaven;
import twilightforest.entity.EntityTFRaven;
import twilightforest.client.model.ModelTFBunny;
import twilightforest.entity.EntityTFBunny;
import twilightforest.client.model.ModelTFSquirrel;
import twilightforest.entity.EntityTFSquirrel;
import twilightforest.client.model.ModelTFTinyBird;
import twilightforest.entity.EntityTFTinyBird;
import twilightforest.client.model.ModelTFLoyalZombie;
import twilightforest.entity.EntityTFLoyalZombie;
import twilightforest.client.model.ModelTFLichMinion;
import twilightforest.entity.EntityTFLichMinion;
import twilightforest.client.model.ModelTFPenguin;
import twilightforest.entity.EntityTFPenguin;
import twilightforest.client.model.ModelTFLich;
import twilightforest.entity.EntityTFLich;
import twilightforest.client.model.ModelTFHydra;
import twilightforest.entity.EntityTFHydra;
import twilightforest.client.model.ModelTFWraith;
import twilightforest.entity.EntityTFWraith;
import twilightforest.client.model.ModelTFSkeletonDruid;
import twilightforest.entity.EntityTFSkeletonDruid;
import twilightforest.entity.EntityTFTinyFirefly;
import twilightforest.entity.EntityTFNagaSegment;
import twilightforest.client.model.ModelTFNaga;
import twilightforest.entity.EntityTFNaga;
import twilightforest.client.model.ModelTFRedcap;
import twilightforest.entity.EntityTFRedcap;
import twilightforest.client.model.ModelTFDeer;
import twilightforest.entity.EntityTFDeer;
import twilightforest.client.model.ModelTFBighornFur;
import twilightforest.client.model.ModelTFBighorn;
import twilightforest.entity.EntityTFBighorn;
import cpw.mods.fml.client.registry.RenderingRegistry;
import twilightforest.client.model.ModelTFBoar;
import twilightforest.entity.EntityTFBoar;
import cpw.mods.fml.common.IScheduledTickHandler;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.client.FMLClientHandler;
import net.minecraftforge.common.MinecraftForge;
import twilightforest.TFCommonProxy;

public class TFClientProxy extends TFCommonProxy
{
    int critterRenderID;
    int plantRenderID;
    int blockComplexRenderID;
    int nagastoneRenderID;
    int magicLeavesRenderID;
    TFClientTicker clientTicker;
    
    @Override
    public void doPreLoadRegistration() {
        MinecraftForge.EVENT_BUS.register((Object)new TFSounds());
    }
    
    @Override
    public void doOnLoadRegistration() {
        final Minecraft mc = FMLClientHandler.instance().getClient();
        TickRegistry.registerScheduledTickHandler((IScheduledTickHandler)(this.clientTicker = new TFClientTicker()), Side.CLIENT);
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFBoar.class, (bgt)new bhm((bbx)new ModelTFBoar(), (bbx)new bbz(0.5f), 0.7f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFBighorn.class, (bgt)new bho((bbx)new ModelTFBighorn(), (bbx)new ModelTFBighornFur(), 0.7f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFDeer.class, (bgt)new bgm((bbx)new ModelTFDeer(), 0.7f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFRedcap.class, (bgt)new bha((bbt)new ModelTFRedcap(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFNaga.class, (bgt)new RenderTFNaga(new ModelTFNaga(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFNagaSegment.class, (bgt)new RenderTFNaga(new ModelTFNaga(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFTinyFirefly.class, (bgt)new RenderTFTinyFirefly());
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFSkeletonDruid.class, (bgt)new bha((bbt)new ModelTFSkeletonDruid(), 0.5f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFWraith.class, (bgt)new RenderTFWraith(new ModelTFWraith(), 0.5f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFHydra.class, (bgt)new RenderTFHydra(new ModelTFHydra(), 1.0f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFLich.class, (bgt)new RenderTFLich(new ModelTFLich(), 1.0f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFPenguin.class, (bgt)new RenderTFBird(new ModelTFPenguin(), 1.0f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFLichMinion.class, (bgt)new bha((bbt)new ModelTFLichMinion(), 1.0f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFLoyalZombie.class, (bgt)new bha((bbt)new ModelTFLoyalZombie(), 1.0f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFTinyBird.class, (bgt)new RenderTFBird(new ModelTFTinyBird(), 1.0f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFSquirrel.class, (bgt)new bhi((bbx)new ModelTFSquirrel(), 1.0f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFBunny.class, (bgt)new bhi((bbx)new ModelTFBunny(), 1.0f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFRaven.class, (bgt)new RenderTFBird(new ModelTFRaven(), 1.0f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFQuestRam.class, (bgt)new RenderTFQuestRam());
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFKobold.class, (bgt)new bha((bbt)new ModelTFKobold(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFBoggard.class, (bgt)new bha((bbt)new ModelTFLoyalZombie(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFMosquitoSwarm.class, (bgt)new bhi((bbx)new ModelTFMosquitoSwarm(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFDeathTome.class, (bgt)new bhi((bbx)new ModelTFDeathTome(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFMinotaur.class, (bgt)new bha((bbt)new ModelTFMinotaur(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFMinoshroom.class, (bgt)new RenderTFMinoshroom(new ModelTFMinoshroom(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFFireBeetle.class, (bgt)new bhi((bbx)new ModelTFFireBeetle(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFSlimeBeetle.class, (bgt)new RenderTFSlimeBeetle(new ModelTFSlimeBeetle(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFPinchBeetle.class, (bgt)new bhi((bbx)new ModelTFPinchBeetle(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFMistWolf.class, (bgt)new RenderTFMistWolf((bbx)new bct(), (bbx)new bct(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFMobileFirefly.class, (bgt)new RenderTFTinyFirefly());
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFMiniGhast.class, (bgt)new bhi((bbx)new ModelTFGhast(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFTowerGolem.class, (bgt)new RenderTFTowerGolem(new ModelTFTowerGolem(), 0.5f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFTowerTermite.class, (bgt)new bhi((bbx)new bcf(), 0.3f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFTowerGhast.class, (bgt)new RenderTFTowerGhast(new ModelTFGhast(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFUrGhast.class, (bgt)new RenderTFTowerGhast(new ModelTFTowerBoss(), 0.625f, 24.0f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFNatureBolt.class, (bgt)new bhd(we.T));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFLichBolt.class, (bgt)new bhd(we.bo));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFTwilightWandBolt.class, (bgt)new bhd(we.bo));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFTomeBolt.class, (bgt)new bhd(we.aL));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFHydraMortar.class, (bgt)new RenderTFHydraMortar());
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFSlimeProjectile.class, (bgt)new bhd(we.aN));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFMoonwormShot.class, (bgt)new RenderTFMoonwormShot());
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFCharmEffect.class, (bgt)new RenderTFCharm(TFItems.charmOfLife1.a_(0)));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFLichBomb.class, (bgt)new bhd(we.by));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFHydraHead.class, (bgt)new RenderTFHydraHead(new ModelTFHydraHead(), 1.0f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFHydraNeck.class, (bgt)new bhi((bbx)new ModelTFHydraNeck(), 1.0f));
        ClientRegistry.bindTileEntitySpecialRenderer((Class)TileEntityTFFirefly.class, (biy)new TileEntityTFFireflyRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer((Class)TileEntityTFCicada.class, (biy)new TileEntityTFCicadaRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer((Class)TileEntityTFMoonworm.class, (biy)new TileEntityTFMoonwormRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer((Class)TileEntityTFTrophy.class, (biy)new TileEntityTFTrophyRenderer());
        MinecraftForgeClient.registerItemRenderer(TFItems.magicMap.cp, (IItemRenderer)new TFMagicMapRenderer(mc.q, mc.z, mc.p));
        this.blockComplexRenderID = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler((ISimpleBlockRenderingHandler)new RenderBlockTFFireflyJar(this.blockComplexRenderID));
        this.plantRenderID = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler((ISimpleBlockRenderingHandler)new RenderBlockTFPlants(this.plantRenderID));
        this.critterRenderID = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler((ISimpleBlockRenderingHandler)new RenderBlockTFCritters(this.critterRenderID));
        this.nagastoneRenderID = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler((ISimpleBlockRenderingHandler)new RenderBlockTFNagastone(this.nagastoneRenderID));
        this.magicLeavesRenderID = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler((ISimpleBlockRenderingHandler)new RenderBlockTFMagicLeaves(this.magicLeavesRenderID));
    }
    
    @Override
    public int getCritterBlockRenderID() {
        return this.critterRenderID;
    }
    
    @Override
    public int getPlantBlockRenderID() {
        return this.plantRenderID;
    }
    
    @Override
    public int getComplexBlockRenderID() {
        return this.blockComplexRenderID;
    }
    
    @Override
    public int getNagastoneBlockRenderID() {
        return this.nagastoneRenderID;
    }
    
    @Override
    public int getMagicLeavesBlockRenderID() {
        return this.magicLeavesRenderID;
    }
    
    @Override
    public int registerArmorRenderID(final String prefix) {
        return RenderingRegistry.addNewArmourRendererPrefix(prefix);
    }
    
    @Override
    public zv getClientWorld() {
        return (zv)FMLClientHandler.instance().getClient().e;
    }
    
    @Override
    public void spawnParticle(final String particleType, final double x, final double y, final double z, final double velX, final double velY, final double velZ) {
        final Minecraft mc = FMLClientHandler.instance().getClient();
        if (mc != null && mc.h != null && mc.j != null) {
            final double distX = mc.h.u - x;
            final double distY = mc.h.v - y;
            final double distZ = mc.h.w - z;
            ben particle = null;
            final double maxDist = 64.0;
            if (distX * distX + distY * distY + distZ * distZ < maxDist * maxDist) {
                if (particleType.equals("largeflame")) {
                    particle = new EntityTFLargeFlameFX((zv)mc.e, x, y, z, velX, velY, velZ);
                }
                else if (particleType.equals("hugesmoke")) {
                    particle = (ben)new bes((zv)mc.e, x, y, z, velX, velY, velZ, 8.0f);
                }
                else if (particleType.equals("leafrune")) {
                    particle = (ben)new EntityTFLeafRuneFX((zv)mc.e, x, y, z, velX, velY, velZ);
                }
                else if (particleType.equals("bosstear")) {
                    particle = new EntityTFBossTearFX((zv)mc.e, x, y, z, velX, velY, velZ, we.bq, mc.p);
                }
                else if (particleType.equals("ghasttrap")) {
                    particle = new EntityTFGhastTrapFX((zv)mc.e, x, y, z, velX, velY, velZ);
                }
                if (particle != null) {
                    particle.r = particle.u;
                    particle.s = particle.v;
                    particle.t = particle.w;
                    this.clientTicker.addParticle(particle);
                }
            }
        }
    }
}
