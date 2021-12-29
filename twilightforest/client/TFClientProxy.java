// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import net.minecraft.client.Minecraft;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraftforge.client.IItemRenderer;
import twilightforest.TileEntityTFMoonworm;
import twilightforest.TileEntityTFHydraSpawner;
import twilightforest.TileEntityTFLichSpawner;
import twilightforest.TileEntityTFNagaSpawner;
import twilightforest.TileEntityTFCicada;
import cpw.mods.fml.client.registry.ClientRegistry;
import twilightforest.TileEntityTFFirefly;
import cpw.mods.fml.client.TextureFXManager;
import twilightforest.EntityTFHydraNeck;
import twilightforest.EntityTFHydraHead;
import twilightforest.EntityTFLichBomb;
import twilightforest.TFItems;
import twilightforest.EntityTFCharmEffect;
import twilightforest.EntityTFMoonwormShot;
import twilightforest.EntityTFSlimeProjectile;
import twilightforest.EntityTFHydraMortar;
import twilightforest.EntityTFTomeBolt;
import twilightforest.EntityTFTwilightWandBolt;
import twilightforest.EntityTFLichBolt;
import twilightforest.EntityTFNatureBolt;
import twilightforest.EntityTFMistWolf;
import twilightforest.EntityTFPinchBeetle;
import twilightforest.EntityTFSlimeBeetle;
import twilightforest.EntityTFFireBeetle;
import twilightforest.EntityTFMinoshroom;
import twilightforest.EntityTFMinotaur;
import twilightforest.EntityTFDeathTome;
import twilightforest.EntityTFMosquitoSwarm;
import twilightforest.EntityTFBoggard;
import twilightforest.EntityTFKobold;
import twilightforest.EntityTFQuestRam;
import twilightforest.EntityTFRaven;
import twilightforest.EntityTFBunny;
import twilightforest.EntityTFSquirrel;
import twilightforest.EntityTFTinyBird;
import twilightforest.EntityTFLoyalZombie;
import twilightforest.EntityTFLichMinion;
import twilightforest.EntityTFPenguin;
import twilightforest.EntityTFLich;
import twilightforest.EntityTFHydra;
import twilightforest.EntityTFWraith;
import twilightforest.EntityTFSkeletonDruid;
import twilightforest.EntityTFTinyFirefly;
import twilightforest.EntityTFNagaSegment;
import twilightforest.EntityTFNaga;
import twilightforest.EntityTFRedcap;
import twilightforest.EntityTFDeer;
import twilightforest.EntityTFBighorn;
import cpw.mods.fml.client.registry.RenderingRegistry;
import twilightforest.EntityTFBoar;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.common.IScheduledTickHandler;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.common.Side;
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
        MinecraftForgeClient.preloadTexture("/twilightforest/items.png");
        MinecraftForgeClient.preloadTexture("/twilightforest/terrain.png");
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFBoar.class, (bbk)new bcc((awt)new ModelTFBoar(), (awt)new awv(0.5f), 0.7f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFBighorn.class, (bbk)new bce((awt)new ModelTFBighorn(), (awt)new ModelTFBighornFur(), 0.7f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFDeer.class, (bbk)new bbd((awt)new ModelTFDeer(), 0.7f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFRedcap.class, (bbk)new bbr((awp)new ModelTFRedcap(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFNaga.class, (bbk)new RenderTFNaga(new ModelTFNaga(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFNagaSegment.class, (bbk)new RenderTFNaga(new ModelTFNaga(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFTinyFirefly.class, (bbk)new RenderTFTinyFirefly());
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFSkeletonDruid.class, (bbk)new bbr((awp)new ModelTFSkeletonDruid(), 0.5f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFWraith.class, (bbk)new RenderTFWraith(new ModelTFWraith(), 0.5f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFHydra.class, (bbk)new RenderTFHydra(new ModelTFHydra(), 1.0f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFLich.class, (bbk)new RenderTFLich(new ModelTFLich(), 1.0f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFPenguin.class, (bbk)new RenderTFBird(new ModelTFPenguin(), 1.0f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFLichMinion.class, (bbk)new bbr((awp)new ModelTFLichMinion(), 1.0f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFLoyalZombie.class, (bbk)new bbr((awp)new ModelTFLoyalZombie(), 1.0f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFTinyBird.class, (bbk)new RenderTFBird(new ModelTFTinyBird(), 1.0f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFSquirrel.class, (bbk)new bby((awt)new ModelTFSquirrel(), 1.0f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFBunny.class, (bbk)new bby((awt)new ModelTFBunny(), 1.0f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFRaven.class, (bbk)new RenderTFBird(new ModelTFRaven(), 1.0f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFQuestRam.class, (bbk)new RenderTFQuestRam());
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFKobold.class, (bbk)new bbr((awp)new ModelTFKobold(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFBoggard.class, (bbk)new bbr((awp)new ModelTFLoyalZombie(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFMosquitoSwarm.class, (bbk)new bby((awt)new ModelTFMosquitoSwarm(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFDeathTome.class, (bbk)new bby((awt)new ModelTFDeathTome(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFMinotaur.class, (bbk)new bbr((awp)new ModelTFMinotaur(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFMinoshroom.class, (bbk)new RenderTFMinoshroom(new ModelTFMinoshroom(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFFireBeetle.class, (bbk)new bby((awt)new ModelTFFireBeetle(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFSlimeBeetle.class, (bbk)new RenderTFSlimeBeetle(new ModelTFSlimeBeetle(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFPinchBeetle.class, (bbk)new bby((awt)new ModelTFPinchBeetle(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFMistWolf.class, (bbk)new RenderTFMistWolf((awt)new axo(), (awt)new axo(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFNatureBolt.class, (bbk)new bbu(uk.S.b(0)));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFLichBolt.class, (bbk)new bbu(uk.bn.b(0)));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFTwilightWandBolt.class, (bbk)new bbu(uk.bn.b(0)));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFTomeBolt.class, (bbk)new bbu(uk.aK.b(0)));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFHydraMortar.class, (bbk)new RenderTFHydraMortar());
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFSlimeProjectile.class, (bbk)new bbu(uk.aM.b(0)));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFMoonwormShot.class, (bbk)new RenderTFMoonwormShot());
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFCharmEffect.class, (bbk)new RenderTFCharm(TFItems.charmOfLife1.b(0)));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFLichBomb.class, (bbk)new bbu(uk.bx.b(0)));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFHydraHead.class, (bbk)new RenderTFHydraHead(new ModelTFHydraHead(), 1.0f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFHydraNeck.class, (bbk)new bby((awt)new ModelTFHydraNeck(), 1.0f));
        TextureFXManager.instance().addAnimation((bcv)new TextureTFMagicLeavesFX(mc));
        ClientRegistry.bindTileEntitySpecialRenderer((Class)TileEntityTFFirefly.class, (bdm)new TileEntityTFFireflyRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer((Class)TileEntityTFCicada.class, (bdm)new TileEntityTFCicadaRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer((Class)TileEntityTFNagaSpawner.class, (bdm)new bdg());
        ClientRegistry.bindTileEntitySpecialRenderer((Class)TileEntityTFLichSpawner.class, (bdm)new bdg());
        ClientRegistry.bindTileEntitySpecialRenderer((Class)TileEntityTFHydraSpawner.class, (bdm)new bdg());
        ClientRegistry.bindTileEntitySpecialRenderer((Class)TileEntityTFMoonworm.class, (bdm)new TileEntityTFMoonwormRenderer());
        MinecraftForgeClient.registerItemRenderer(TFItems.magicMap.cg, (IItemRenderer)new TFMagicMapRenderer(mc.p, mc.y, mc.o));
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
    public xv getClientWorld() {
        return (xv)FMLClientHandler.instance().getClient().e;
    }
    
    @Override
    public void spawnParticle(final String particleType, final double x, final double y, final double z, final double velX, final double velY, final double velZ) {
        final Minecraft mc = FMLClientHandler.instance().getClient();
        if (mc != null && mc.h != null && mc.i != null) {
            final double distX = mc.h.t - x;
            final double distY = mc.h.u - y;
            final double distZ = mc.h.v - z;
            aze particle = null;
            final double maxDist = 64.0;
            if (distX * distX + distY * distY + distZ * distZ < maxDist * maxDist) {
                if (particleType.equals("largeflame")) {
                    particle = new EntityTFLargeFlameFX((xv)mc.e, x, y, z, velX, velY, velZ);
                }
                else if (particleType.equals("hugesmoke")) {
                    particle = (aze)new azk((xv)mc.e, x, y, z, velX, velY, velZ, 8.0f);
                }
                if (particle != null) {
                    particle.q = particle.t;
                    particle.r = particle.u;
                    particle.s = particle.v;
                    this.clientTicker.addParticle(particle);
                }
            }
        }
    }
}
