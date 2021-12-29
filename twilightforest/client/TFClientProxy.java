// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import net.minecraft.client.Minecraft;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraftforge.client.IItemRenderer;
import twilightforest.tileentity.TileEntityTFMoonworm;
import twilightforest.tileentity.TileEntityTFHydraSpawner;
import twilightforest.tileentity.TileEntityTFLichSpawner;
import twilightforest.tileentity.TileEntityTFNagaSpawner;
import twilightforest.tileentity.TileEntityTFCicada;
import cpw.mods.fml.client.registry.ClientRegistry;
import twilightforest.tileentity.TileEntityTFFirefly;
import cpw.mods.fml.client.TextureFXManager;
import twilightforest.entity.EntityTFHydraNeck;
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
import twilightforest.entity.EntityTFMobileFirefly;
import twilightforest.entity.EntityTFMistWolf;
import twilightforest.entity.EntityTFPinchBeetle;
import twilightforest.entity.EntityTFSlimeBeetle;
import twilightforest.entity.EntityTFFireBeetle;
import twilightforest.entity.EntityTFMinoshroom;
import twilightforest.entity.EntityTFMinotaur;
import twilightforest.entity.EntityTFDeathTome;
import twilightforest.entity.EntityTFMosquitoSwarm;
import twilightforest.entity.EntityTFBoggard;
import twilightforest.entity.EntityTFKobold;
import twilightforest.entity.EntityTFQuestRam;
import twilightforest.entity.EntityTFRaven;
import twilightforest.entity.EntityTFBunny;
import twilightforest.entity.EntityTFSquirrel;
import twilightforest.entity.EntityTFTinyBird;
import twilightforest.entity.EntityTFLoyalZombie;
import twilightforest.entity.EntityTFLichMinion;
import twilightforest.entity.EntityTFPenguin;
import twilightforest.entity.EntityTFLich;
import twilightforest.entity.EntityTFHydra;
import twilightforest.entity.EntityTFWraith;
import twilightforest.entity.EntityTFSkeletonDruid;
import twilightforest.entity.EntityTFTinyFirefly;
import twilightforest.entity.EntityTFNagaSegment;
import twilightforest.entity.EntityTFNaga;
import twilightforest.entity.EntityTFRedcap;
import twilightforest.entity.EntityTFDeer;
import twilightforest.entity.EntityTFBighorn;
import cpw.mods.fml.client.registry.RenderingRegistry;
import twilightforest.entity.EntityTFBoar;
import net.minecraftforge.client.MinecraftForgeClient;
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
        MinecraftForgeClient.preloadTexture("/twilightforest/items.png");
        MinecraftForgeClient.preloadTexture("/twilightforest/terrain.png");
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFBoar.class, (bbv)new bcn((axa)new ModelTFBoar(), (axa)new axc(0.5f), 0.7f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFBighorn.class, (bbv)new bcp((axa)new ModelTFBighorn(), (axa)new ModelTFBighornFur(), 0.7f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFDeer.class, (bbv)new bbo((axa)new ModelTFDeer(), 0.7f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFRedcap.class, (bbv)new bcc((aww)new ModelTFRedcap(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFNaga.class, (bbv)new RenderTFNaga(new ModelTFNaga(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFNagaSegment.class, (bbv)new RenderTFNaga(new ModelTFNaga(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFTinyFirefly.class, (bbv)new RenderTFTinyFirefly());
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFSkeletonDruid.class, (bbv)new bcc((aww)new ModelTFSkeletonDruid(), 0.5f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFWraith.class, (bbv)new RenderTFWraith(new ModelTFWraith(), 0.5f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFHydra.class, (bbv)new RenderTFHydra(new ModelTFHydra(), 1.0f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFLich.class, (bbv)new RenderTFLich(new ModelTFLich(), 1.0f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFPenguin.class, (bbv)new RenderTFBird(new ModelTFPenguin(), 1.0f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFLichMinion.class, (bbv)new bcc((aww)new ModelTFLichMinion(), 1.0f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFLoyalZombie.class, (bbv)new bcc((aww)new ModelTFLoyalZombie(), 1.0f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFTinyBird.class, (bbv)new RenderTFBird(new ModelTFTinyBird(), 1.0f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFSquirrel.class, (bbv)new bcj((axa)new ModelTFSquirrel(), 1.0f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFBunny.class, (bbv)new bcj((axa)new ModelTFBunny(), 1.0f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFRaven.class, (bbv)new RenderTFBird(new ModelTFRaven(), 1.0f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFQuestRam.class, (bbv)new RenderTFQuestRam());
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFKobold.class, (bbv)new bcc((aww)new ModelTFKobold(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFBoggard.class, (bbv)new bcc((aww)new ModelTFLoyalZombie(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFMosquitoSwarm.class, (bbv)new bcj((axa)new ModelTFMosquitoSwarm(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFDeathTome.class, (bbv)new bcj((axa)new ModelTFDeathTome(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFMinotaur.class, (bbv)new bcc((aww)new ModelTFMinotaur(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFMinoshroom.class, (bbv)new RenderTFMinoshroom(new ModelTFMinoshroom(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFFireBeetle.class, (bbv)new bcj((axa)new ModelTFFireBeetle(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFSlimeBeetle.class, (bbv)new RenderTFSlimeBeetle(new ModelTFSlimeBeetle(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFPinchBeetle.class, (bbv)new bcj((axa)new ModelTFPinchBeetle(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFMistWolf.class, (bbv)new RenderTFMistWolf((axa)new axw(), (axa)new axw(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFMobileFirefly.class, (bbv)new RenderTFTinyFirefly());
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFNatureBolt.class, (bbv)new bcf(up.S.b(0)));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFLichBolt.class, (bbv)new bcf(up.bn.b(0)));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFTwilightWandBolt.class, (bbv)new bcf(up.bn.b(0)));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFTomeBolt.class, (bbv)new bcf(up.aK.b(0)));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFHydraMortar.class, (bbv)new RenderTFHydraMortar());
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFSlimeProjectile.class, (bbv)new bcf(up.aM.b(0)));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFMoonwormShot.class, (bbv)new RenderTFMoonwormShot());
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFCharmEffect.class, (bbv)new RenderTFCharm(TFItems.charmOfLife1.b(0)));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFLichBomb.class, (bbv)new bcf(up.bx.b(0)));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFHydraHead.class, (bbv)new RenderTFHydraHead(new ModelTFHydraHead(), 1.0f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFHydraNeck.class, (bbv)new bcj((axa)new ModelTFHydraNeck(), 1.0f));
        TextureFXManager.instance().addAnimation((bdg)new TextureTFMagicLeavesFX(mc));
        ClientRegistry.bindTileEntitySpecialRenderer((Class)TileEntityTFFirefly.class, (bdx)new TileEntityTFFireflyRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer((Class)TileEntityTFCicada.class, (bdx)new TileEntityTFCicadaRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer((Class)TileEntityTFNagaSpawner.class, (bdx)new bdr());
        ClientRegistry.bindTileEntitySpecialRenderer((Class)TileEntityTFLichSpawner.class, (bdx)new bdr());
        ClientRegistry.bindTileEntitySpecialRenderer((Class)TileEntityTFHydraSpawner.class, (bdx)new bdr());
        ClientRegistry.bindTileEntitySpecialRenderer((Class)TileEntityTFMoonworm.class, (bdx)new TileEntityTFMoonwormRenderer());
        MinecraftForgeClient.registerItemRenderer(TFItems.magicMap.cj, (IItemRenderer)new TFMagicMapRenderer(mc.p, mc.y, mc.o));
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
    public yc getClientWorld() {
        return (yc)FMLClientHandler.instance().getClient().e;
    }
    
    @Override
    public void spawnParticle(final String particleType, final double x, final double y, final double z, final double velX, final double velY, final double velZ) {
        final Minecraft mc = FMLClientHandler.instance().getClient();
        if (mc != null && mc.h != null && mc.i != null) {
            final double distX = mc.h.t - x;
            final double distY = mc.h.u - y;
            final double distZ = mc.h.v - z;
            azq particle = null;
            final double maxDist = 64.0;
            if (distX * distX + distY * distY + distZ * distZ < maxDist * maxDist) {
                if (particleType.equals("largeflame")) {
                    particle = new EntityTFLargeFlameFX((yc)mc.e, x, y, z, velX, velY, velZ);
                }
                else if (particleType.equals("hugesmoke")) {
                    particle = (azq)new azv((yc)mc.e, x, y, z, velX, velY, velZ, 8.0f);
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
