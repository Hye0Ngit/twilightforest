// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import twilightforest.client.particle.EntityTFGhastTrapFX;
import twilightforest.client.particle.EntityTFBossTearFX;
import twilightforest.client.particle.EntityTFLeafRuneFX;
import twilightforest.client.particle.EntityTFLargeFlameFX;
import twilightforest.client.model.ModelTFKnightlyArmor;
import twilightforest.client.renderer.blocks.RenderBlockTFPedestal;
import twilightforest.client.renderer.blocks.RenderBlockTFMagicLeaves;
import twilightforest.client.renderer.blocks.RenderBlockTFNagastone;
import twilightforest.client.renderer.blocks.RenderBlockTFCritters;
import twilightforest.client.renderer.blocks.RenderBlockTFPlants;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import twilightforest.client.renderer.blocks.RenderBlockTFFireflyJar;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import twilightforest.client.renderer.TFMagicMapRenderer;
import twilightforest.client.renderer.TileEntityTFTrophyRenderer;
import twilightforest.tileentity.TileEntityTFTrophy;
import twilightforest.client.renderer.TileEntityTFMoonwormRenderer;
import twilightforest.tileentity.TileEntityTFMoonworm;
import twilightforest.client.renderer.TileEntityTFCicadaRenderer;
import twilightforest.tileentity.TileEntityTFCicada;
import cpw.mods.fml.client.registry.ClientRegistry;
import twilightforest.client.renderer.TileEntityTFFireflyRenderer;
import twilightforest.tileentity.TileEntityTFFirefly;
import twilightforest.client.model.ModelTFHydraNeck;
import twilightforest.entity.EntityTFHydraNeck;
import twilightforest.client.renderer.entity.RenderTFHydraHead;
import twilightforest.client.model.ModelTFHydraHead;
import twilightforest.entity.EntityTFHydraHead;
import twilightforest.entity.EntityTFLichBomb;
import twilightforest.client.renderer.entity.RenderTFCharm;
import twilightforest.item.TFItems;
import twilightforest.entity.EntityTFCharmEffect;
import twilightforest.client.renderer.entity.RenderTFMoonwormShot;
import twilightforest.entity.EntityTFMoonwormShot;
import twilightforest.entity.EntityTFSlimeProjectile;
import twilightforest.client.renderer.entity.RenderTFHydraMortar;
import twilightforest.entity.EntityTFHydraMortar;
import twilightforest.entity.EntityTFTomeBolt;
import twilightforest.entity.EntityTFTwilightWandBolt;
import twilightforest.entity.EntityTFLichBolt;
import twilightforest.entity.EntityTFNatureBolt;
import twilightforest.client.renderer.entity.RenderTFMazeSlime;
import twilightforest.entity.EntityTFMazeSlime;
import twilightforest.entity.EntityTFRedcapSapper;
import twilightforest.client.renderer.entity.RenderTFHedgeSpider;
import twilightforest.entity.EntityTFHedgeSpider;
import twilightforest.client.renderer.entity.RenderTFTowerBroodling;
import twilightforest.entity.EntityTFTowerBroodling;
import twilightforest.client.renderer.entity.RenderTFKingSpider;
import twilightforest.entity.EntityTFKingSpider;
import twilightforest.client.renderer.entity.RenderTFSwarmSpider;
import twilightforest.entity.EntityTFSwarmSpider;
import twilightforest.client.renderer.entity.RenderTFNagaSegment;
import twilightforest.entity.EntityTFNagaSegment;
import twilightforest.client.renderer.entity.RenderTFNaga;
import twilightforest.client.model.ModelTFNaga;
import twilightforest.entity.EntityTFNaga;
import twilightforest.client.model.ModelTFKnightPhantom;
import twilightforest.entity.EntityTFKnightPhantom;
import twilightforest.client.model.ModelTFHelmetCrab;
import twilightforest.entity.EntityTFHelmetCrab;
import twilightforest.client.model.ModelTFGoblinKnightLower;
import twilightforest.entity.EntityTFGoblinKnightLower;
import twilightforest.client.renderer.entity.RenderTFGoblinKnightUpper;
import twilightforest.client.model.ModelTFGoblinKnightUpper;
import twilightforest.entity.EntityTFGoblinKnightUpper;
import twilightforest.client.model.ModelTFSpikeBlock;
import twilightforest.entity.EntityTFSpikeBlock;
import twilightforest.client.renderer.entity.RenderTFSpikeBlock;
import twilightforest.client.model.ModelTFGoblinChain;
import twilightforest.entity.EntityTFGoblinChain;
import twilightforest.client.renderer.entity.RenderTFBlockGoblin;
import twilightforest.client.model.ModelTFBlockGoblin;
import twilightforest.entity.EntityTFBlockGoblin;
import twilightforest.client.renderer.entity.RenderTFUrGhast;
import twilightforest.client.model.ModelTFTowerBoss;
import twilightforest.entity.EntityTFUrGhast;
import twilightforest.client.renderer.entity.RenderTFTowerGhast;
import twilightforest.entity.EntityTFTowerGhast;
import twilightforest.entity.EntityTFTowerTermite;
import twilightforest.client.renderer.entity.RenderTFTowerGolem;
import twilightforest.client.model.ModelTFTowerGolem;
import twilightforest.entity.EntityTFTowerGolem;
import twilightforest.client.renderer.entity.RenderTFMiniGhast;
import twilightforest.client.model.ModelTFGhast;
import twilightforest.entity.EntityTFMiniGhast;
import twilightforest.entity.passive.EntityTFMobileFirefly;
import twilightforest.client.renderer.entity.RenderTFMistWolf;
import twilightforest.entity.EntityTFMistWolf;
import twilightforest.client.model.ModelTFPinchBeetle;
import twilightforest.entity.EntityTFPinchBeetle;
import twilightforest.client.renderer.entity.RenderTFSlimeBeetle;
import twilightforest.client.model.ModelTFSlimeBeetle;
import twilightforest.entity.EntityTFSlimeBeetle;
import twilightforest.client.model.ModelTFFireBeetle;
import twilightforest.entity.EntityTFFireBeetle;
import twilightforest.client.renderer.entity.RenderTFMinoshroom;
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
import twilightforest.client.renderer.entity.RenderTFQuestRam;
import twilightforest.entity.passive.EntityTFQuestRam;
import twilightforest.client.model.ModelTFRaven;
import twilightforest.entity.passive.EntityTFRaven;
import twilightforest.client.renderer.entity.RenderTFBunny;
import twilightforest.client.model.ModelTFBunny;
import twilightforest.entity.passive.EntityTFBunny;
import twilightforest.client.renderer.entity.RenderTFGenericLiving;
import twilightforest.client.model.ModelTFSquirrel;
import twilightforest.entity.passive.EntityTFSquirrel;
import twilightforest.client.renderer.entity.RenderTFTinyBird;
import twilightforest.client.model.ModelTFTinyBird;
import twilightforest.entity.passive.EntityTFTinyBird;
import twilightforest.client.model.ModelTFLoyalZombie;
import twilightforest.entity.EntityTFLoyalZombie;
import twilightforest.client.model.ModelTFLichMinion;
import twilightforest.entity.EntityTFLichMinion;
import twilightforest.client.renderer.entity.RenderTFBird;
import twilightforest.client.model.ModelTFPenguin;
import twilightforest.entity.passive.EntityTFPenguin;
import twilightforest.client.renderer.entity.RenderTFLich;
import twilightforest.client.model.ModelTFLich;
import twilightforest.entity.EntityTFLich;
import twilightforest.client.renderer.entity.RenderTFHydra;
import twilightforest.client.model.ModelTFHydra;
import twilightforest.entity.EntityTFHydra;
import twilightforest.client.renderer.entity.RenderTFWraith;
import twilightforest.client.model.ModelTFWraith;
import twilightforest.entity.EntityTFWraith;
import twilightforest.client.model.ModelTFSkeletonDruid;
import twilightforest.entity.EntityTFSkeletonDruid;
import twilightforest.client.renderer.entity.RenderTFTinyFirefly;
import twilightforest.entity.passive.EntityTFTinyFirefly;
import twilightforest.client.renderer.entity.RenderTFBiped;
import twilightforest.client.model.ModelTFRedcap;
import twilightforest.entity.EntityTFRedcap;
import twilightforest.client.renderer.entity.RenderTFDeer;
import twilightforest.client.model.ModelTFDeer;
import twilightforest.entity.passive.EntityTFDeer;
import twilightforest.client.renderer.entity.RenderTFBighorn;
import twilightforest.client.model.ModelTFBighornFur;
import twilightforest.client.model.ModelTFBighorn;
import twilightforest.entity.passive.EntityTFBighorn;
import cpw.mods.fml.client.registry.RenderingRegistry;
import twilightforest.client.renderer.entity.RenderTFBoar;
import twilightforest.client.model.ModelTFBoar;
import twilightforest.entity.passive.EntityTFBoar;
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
    int pedestalRenderID;
    bbg[] knightlyArmorModel;
    TFClientTicker clientTicker;
    
    @Override
    public void doPreLoadRegistration() {
        MinecraftForge.EVENT_BUS.register((Object)new TFSounds());
    }
    
    @Override
    public void doOnLoadRegistration() {
        final ats mc = FMLClientHandler.instance().getClient();
        TickRegistry.registerScheduledTickHandler((IScheduledTickHandler)(this.clientTicker = new TFClientTicker()), Side.CLIENT);
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFBoar.class, (bgj)new RenderTFBoar((bbl)new ModelTFBoar(), (bbl)new bbo(0.5f), 0.7f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFBighorn.class, (bgj)new RenderTFBighorn((bbl)new ModelTFBighorn(), (bbl)new ModelTFBighornFur(), 0.7f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFDeer.class, (bgj)new RenderTFDeer((bbl)new ModelTFDeer(), 0.7f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFRedcap.class, (bgj)new RenderTFBiped(new ModelTFRedcap(), 0.625f, "redcap.png"));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFTinyFirefly.class, (bgj)new RenderTFTinyFirefly());
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFSkeletonDruid.class, (bgj)new RenderTFBiped(new ModelTFSkeletonDruid(), 0.5f, "skeletondruid.png"));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFWraith.class, (bgj)new RenderTFWraith(new ModelTFWraith(), 0.5f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFHydra.class, (bgj)new RenderTFHydra(new ModelTFHydra(), 1.0f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFLich.class, (bgj)new RenderTFLich(new ModelTFLich(), 1.0f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFPenguin.class, (bgj)new RenderTFBird(new ModelTFPenguin(), 1.0f, "penguin.png"));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFLichMinion.class, (bgj)new RenderTFBiped((bbg)new ModelTFLichMinion(), 1.0f, "textures/entity/zombie/zombie.png"));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFLoyalZombie.class, (bgj)new RenderTFBiped((bbg)new ModelTFLoyalZombie(), 1.0f, "textures/entity/zombie/zombie.png"));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFTinyBird.class, (bgj)new RenderTFTinyBird(new ModelTFTinyBird(), 1.0f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFSquirrel.class, (bgj)new RenderTFGenericLiving(new ModelTFSquirrel(), 1.0f, "squirrel2.png"));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFBunny.class, (bgj)new RenderTFBunny(new ModelTFBunny(), 1.0f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFRaven.class, (bgj)new RenderTFBird(new ModelTFRaven(), 1.0f, "raven.png"));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFQuestRam.class, (bgj)new RenderTFQuestRam());
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFKobold.class, (bgj)new RenderTFBiped(new ModelTFKobold(), 0.625f, "kobold.png"));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFBoggard.class, (bgj)new RenderTFBiped((bbg)new ModelTFLoyalZombie(), 0.625f, "kobold.png"));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFMosquitoSwarm.class, (bgj)new RenderTFGenericLiving(new ModelTFMosquitoSwarm(), 0.625f, "mosquitoswarm.png"));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFDeathTome.class, (bgj)new RenderTFGenericLiving((bbl)new ModelTFDeathTome(), 0.625f, "textures/entity/enchanting_table_book.png"));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFMinotaur.class, (bgj)new RenderTFBiped(new ModelTFMinotaur(), 0.625f, "minotaur.png"));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFMinoshroom.class, (bgj)new RenderTFMinoshroom(new ModelTFMinoshroom(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFFireBeetle.class, (bgj)new RenderTFGenericLiving(new ModelTFFireBeetle(), 0.625f, "firebeetle.png"));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFSlimeBeetle.class, (bgj)new RenderTFSlimeBeetle(new ModelTFSlimeBeetle(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFPinchBeetle.class, (bgj)new RenderTFGenericLiving(new ModelTFPinchBeetle(), 0.625f, "pinchbeetle.png"));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFMistWolf.class, (bgj)new RenderTFMistWolf((bbl)new bci(), (bbl)new bci(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFMobileFirefly.class, (bgj)new RenderTFTinyFirefly());
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFMiniGhast.class, (bgj)new RenderTFMiniGhast(new ModelTFGhast(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFTowerGolem.class, (bgj)new RenderTFTowerGolem(new ModelTFTowerGolem(), 0.5f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFTowerTermite.class, (bgj)new RenderTFGenericLiving((bbl)new bbu(), 0.3f, "towertermite.png"));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFTowerGhast.class, (bgj)new RenderTFTowerGhast(new ModelTFGhast(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFUrGhast.class, (bgj)new RenderTFUrGhast(new ModelTFTowerBoss(), 0.625f, 24.0f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFBlockGoblin.class, (bgj)new RenderTFBlockGoblin(new ModelTFBlockGoblin(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFGoblinChain.class, (bgj)new RenderTFSpikeBlock(new ModelTFGoblinChain(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFSpikeBlock.class, (bgj)new RenderTFSpikeBlock(new ModelTFSpikeBlock(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFGoblinKnightUpper.class, (bgj)new RenderTFGoblinKnightUpper(new ModelTFGoblinKnightUpper(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFGoblinKnightLower.class, (bgj)new RenderTFBiped(new ModelTFGoblinKnightLower(), 0.625f, "doublegoblin.png"));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFHelmetCrab.class, (bgj)new RenderTFGenericLiving(new ModelTFHelmetCrab(), 0.625f, "helmetcrab.png"));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFKnightPhantom.class, (bgj)new RenderTFBiped(new ModelTFKnightPhantom(), 0.625f, "knightphantom.png"));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFNaga.class, (bgj)new RenderTFNaga(new ModelTFNaga(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFNagaSegment.class, (bgj)new RenderTFNagaSegment(new ModelTFNaga(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFSwarmSpider.class, (bgj)new RenderTFSwarmSpider());
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFKingSpider.class, (bgj)new RenderTFKingSpider());
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFTowerBroodling.class, (bgj)new RenderTFTowerBroodling());
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFHedgeSpider.class, (bgj)new RenderTFHedgeSpider());
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFRedcapSapper.class, (bgj)new RenderTFBiped(new ModelTFRedcap(), 0.625f, "redcapsapper.png"));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFMazeSlime.class, (bgj)new RenderTFMazeSlime((bbl)new bby(16), (bbl)new bby(0), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFNatureBolt.class, (bgj)new bgu(yb.U));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFLichBolt.class, (bgj)new bgu(yb.bp));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFTwilightWandBolt.class, (bgj)new bgu(yb.bp));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFTomeBolt.class, (bgj)new bgu(yb.aM));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFHydraMortar.class, (bgj)new RenderTFHydraMortar());
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFSlimeProjectile.class, (bgj)new bgu(yb.aO));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFMoonwormShot.class, (bgj)new RenderTFMoonwormShot());
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFCharmEffect.class, (bgj)new RenderTFCharm(TFItems.charmOfLife1.b_(0)));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFLichBomb.class, (bgj)new bgu(yb.bz));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFHydraHead.class, (bgj)new RenderTFHydraHead(new ModelTFHydraHead(), 1.0f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFHydraNeck.class, (bgj)new RenderTFGenericLiving(new ModelTFHydraNeck(), 1.0f, "hydra4.png"));
        ClientRegistry.bindTileEntitySpecialRenderer((Class)TileEntityTFFirefly.class, (bjb)new TileEntityTFFireflyRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer((Class)TileEntityTFCicada.class, (bjb)new TileEntityTFCicadaRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer((Class)TileEntityTFMoonworm.class, (bjb)new TileEntityTFMoonwormRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer((Class)TileEntityTFTrophy.class, (bjb)new TileEntityTFTrophyRenderer());
        MinecraftForgeClient.registerItemRenderer(TFItems.magicMap.cv, (IItemRenderer)new TFMagicMapRenderer(mc.u, mc.J()));
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
        this.pedestalRenderID = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler((ISimpleBlockRenderingHandler)new RenderBlockTFPedestal(this.pedestalRenderID));
        (this.knightlyArmorModel = new bbg[4])[0] = new ModelTFKnightlyArmor(0, 0.5f);
        this.knightlyArmorModel[1] = new ModelTFKnightlyArmor(1, 1.0f);
        this.knightlyArmorModel[2] = new ModelTFKnightlyArmor(2, 0.5f);
        this.knightlyArmorModel[3] = new ModelTFKnightlyArmor(3, 0.5f);
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
    public int getPedestalBlockRenderID() {
        return this.pedestalRenderID;
    }
    
    @Override
    public int registerArmorRenderID(final String prefix) {
        return RenderingRegistry.addNewArmourRendererPrefix(prefix);
    }
    
    @Override
    public abv getClientWorld() {
        return (abv)FMLClientHandler.instance().getClient().f;
    }
    
    @Override
    public void spawnParticle(final String particleType, final double x, final double y, final double z, final double velX, final double velY, final double velZ) {
        final ats mc = FMLClientHandler.instance().getClient();
        if (mc != null && mc.i != null && mc.k != null) {
            final double distX = mc.i.u - x;
            final double distY = mc.i.v - y;
            final double distZ = mc.i.w - z;
            bed particle = null;
            final double maxDist = 64.0;
            if (distX * distX + distY * distY + distZ * distZ < maxDist * maxDist) {
                if (particleType.equals("largeflame")) {
                    particle = new EntityTFLargeFlameFX((abv)mc.f, x, y, z, velX, velY, velZ);
                }
                else if (particleType.equals("hugesmoke")) {
                    particle = (bed)new bei((abv)mc.f, x, y, z, velX, velY, velZ, 8.0f);
                }
                else if (particleType.equals("leafrune")) {
                    particle = (bed)new EntityTFLeafRuneFX((abv)mc.f, x, y, z, velX, velY, velZ);
                }
                else if (particleType.equals("bosstear")) {
                    particle = new EntityTFBossTearFX((abv)mc.f, x, y, z, velX, velY, velZ, yb.br);
                }
                else if (particleType.equals("ghasttrap")) {
                    particle = new EntityTFGhastTrapFX((abv)mc.f, x, y, z, velX, velY, velZ);
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
    
    @Override
    public bbg getKnightlyArmorModel(final int armorSlot) {
        return this.knightlyArmorModel[armorSlot];
    }
}
