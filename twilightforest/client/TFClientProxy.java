// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import net.minecraft.client.particle.EntityFX;
import twilightforest.client.particle.EntityTFAnnihilateFX;
import twilightforest.client.particle.EntityTFIceBeamFX;
import twilightforest.client.particle.EntityTFSnowGuardianFX;
import twilightforest.client.particle.EntityTFSnowWarningFX;
import twilightforest.client.particle.EntityTFSnowFX;
import twilightforest.client.particle.EntityTFProtectionFX;
import twilightforest.client.particle.EntityTFGhastTrapFX;
import twilightforest.client.particle.EntityTFBossTearFX;
import twilightforest.client.particle.EntityTFLeafRuneFX;
import net.minecraft.client.particle.EntitySmokeFX;
import twilightforest.client.particle.EntityTFLargeFlameFX;
import net.minecraft.world.World;
import net.minecraft.client.Minecraft;
import twilightforest.client.model.ModelTFFieryArmor;
import twilightforest.client.model.ModelTFArcticArmor;
import twilightforest.client.model.ModelTFYetiArmor;
import twilightforest.client.model.ModelTFPhantomArmor;
import twilightforest.client.model.ModelTFKnightlyArmor;
import twilightforest.client.renderer.blocks.RenderBlockTFCastleMagic;
import twilightforest.client.renderer.blocks.RenderBlockTFHugeLilyPad;
import twilightforest.client.renderer.blocks.RenderBlockTFKnightMetal;
import twilightforest.client.renderer.blocks.RenderBlockTFThorns;
import twilightforest.client.renderer.blocks.RenderBlockTFPedestal;
import twilightforest.client.renderer.blocks.RenderBlockTFMagicLeaves;
import twilightforest.client.renderer.blocks.RenderBlockTFNagastone;
import twilightforest.client.renderer.blocks.RenderBlockTFCritters;
import twilightforest.client.renderer.blocks.RenderBlockTFPlants;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import twilightforest.client.renderer.blocks.RenderBlockTFFireflyJar;
import twilightforest.client.renderer.TFIceItemRenderer;
import twilightforest.client.renderer.TFFieryItemRenderer;
import net.minecraft.item.Item;
import twilightforest.block.TFBlocks;
import twilightforest.client.renderer.TFGiantBlockRenderer;
import twilightforest.client.renderer.TFGiantItemRenderer;
import twilightforest.client.renderer.TFMazeMapRenderer;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import twilightforest.client.renderer.TFMagicMapRenderer;
import twilightforest.client.renderer.TileEntityTFTrophyRenderer;
import twilightforest.tileentity.TileEntityTFTrophy;
import twilightforest.client.renderer.TileEntityTFMoonwormRenderer;
import twilightforest.tileentity.TileEntityTFMoonworm;
import twilightforest.client.renderer.TileEntityTFCicadaRenderer;
import twilightforest.tileentity.TileEntityTFCicada;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import cpw.mods.fml.client.registry.ClientRegistry;
import twilightforest.client.renderer.TileEntityTFFireflyRenderer;
import twilightforest.tileentity.TileEntityTFFirefly;
import twilightforest.client.model.ModelTFHydraNeck;
import twilightforest.entity.boss.EntityTFHydraNeck;
import twilightforest.client.renderer.entity.RenderTFHydraHead;
import twilightforest.client.model.ModelTFHydraHead;
import twilightforest.entity.boss.EntityTFHydraHead;
import twilightforest.client.renderer.entity.RenderTFSlideBlock;
import twilightforest.entity.EntityTFSlideBlock;
import twilightforest.entity.EntityTFIceSnowball;
import twilightforest.client.renderer.entity.RenderTFThrownIce;
import twilightforest.entity.boss.EntityTFIceBomb;
import twilightforest.client.renderer.entity.RenderTFFallingIce;
import twilightforest.entity.boss.EntityTFFallingIce;
import twilightforest.entity.boss.EntityTFThrownPick;
import twilightforest.client.renderer.entity.RenderTFThrownAxe;
import twilightforest.entity.boss.EntityTFThrownAxe;
import twilightforest.entity.boss.EntityTFLichBomb;
import twilightforest.client.renderer.entity.RenderTFCharm;
import twilightforest.item.TFItems;
import twilightforest.entity.EntityTFCharmEffect;
import twilightforest.client.renderer.entity.RenderTFMoonwormShot;
import twilightforest.entity.EntityTFMoonwormShot;
import twilightforest.entity.EntityTFSlimeProjectile;
import twilightforest.client.renderer.entity.RenderTFHydraMortar;
import twilightforest.entity.boss.EntityTFHydraMortar;
import twilightforest.entity.EntityTFTomeBolt;
import twilightforest.entity.EntityTFTwilightWandBolt;
import twilightforest.entity.boss.EntityTFLichBolt;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.init.Items;
import twilightforest.entity.EntityTFNatureBolt;
import twilightforest.client.renderer.entity.RenderTFRovingCube;
import twilightforest.entity.EntityTFRovingCube;
import twilightforest.client.renderer.entity.RenderTFAdherent;
import twilightforest.client.model.ModelTFAdherent;
import twilightforest.entity.EntityTFAdherent;
import twilightforest.client.renderer.entity.RenderTFHarbingerCube;
import twilightforest.entity.EntityTFHarbingerCube;
import twilightforest.client.renderer.entity.RenderTFCubeOfAnnihilation;
import twilightforest.entity.EntityTFCubeOfAnnihilation;
import twilightforest.client.renderer.entity.RenderTFChainBlock;
import twilightforest.entity.EntityTFChainBlock;
import twilightforest.client.renderer.entity.RenderTFIceCrystal;
import twilightforest.entity.boss.EntityTFIceCrystal;
import twilightforest.client.renderer.entity.RenderTFGiant;
import twilightforest.entity.EntityTFGiantMiner;
import twilightforest.client.model.ModelTFTroll;
import twilightforest.entity.EntityTFTroll;
import twilightforest.client.renderer.entity.RenderTFSnowQueenIceShield;
import twilightforest.entity.boss.EntityTFSnowQueenIceShield;
import twilightforest.client.renderer.entity.RenderTFSnowQueen;
import twilightforest.entity.boss.EntityTFSnowQueen;
import twilightforest.client.renderer.entity.RenderTFIceExploder;
import twilightforest.entity.EntityTFIceExploder;
import twilightforest.client.renderer.entity.RenderTFIceShooter;
import twilightforest.entity.EntityTFIceShooter;
import twilightforest.client.renderer.entity.RenderTFSnowGuardian;
import twilightforest.entity.EntityTFSnowGuardian;
import twilightforest.client.renderer.entity.RenderTFWinterWolf;
import twilightforest.entity.EntityTFWinterWolf;
import twilightforest.client.model.ModelTFYetiAlpha;
import twilightforest.entity.boss.EntityTFYetiAlpha;
import twilightforest.client.renderer.entity.RenderTFProtectionBox;
import twilightforest.entity.EntityTFProtectionBox;
import twilightforest.client.renderer.entity.RenderTFYeti;
import twilightforest.client.model.ModelTFYeti;
import twilightforest.entity.EntityTFYeti;
import twilightforest.client.renderer.entity.RenderTFMazeSlime;
import net.minecraft.client.model.ModelSlime;
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
import twilightforest.entity.boss.EntityTFNagaSegment;
import twilightforest.client.renderer.entity.RenderTFNaga;
import twilightforest.client.model.ModelTFNaga;
import twilightforest.entity.boss.EntityTFNaga;
import twilightforest.client.renderer.entity.RenderTFKnightPhantom;
import twilightforest.client.model.ModelTFKnightPhantom2;
import twilightforest.entity.boss.EntityTFKnightPhantom;
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
import twilightforest.entity.boss.EntityTFUrGhast;
import twilightforest.client.renderer.entity.RenderTFTowerGhast;
import twilightforest.entity.EntityTFTowerGhast;
import net.minecraft.client.model.ModelSilverfish;
import twilightforest.entity.EntityTFTowerTermite;
import twilightforest.client.renderer.entity.RenderTFTowerGolem;
import twilightforest.client.model.ModelTFTowerGolem;
import twilightforest.entity.EntityTFTowerGolem;
import twilightforest.client.renderer.entity.RenderTFMiniGhast;
import twilightforest.client.model.ModelTFGhast;
import twilightforest.entity.EntityTFMiniGhast;
import twilightforest.entity.passive.EntityTFMobileFirefly;
import twilightforest.client.renderer.entity.RenderTFMistWolf;
import net.minecraft.client.model.ModelWolf;
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
import twilightforest.entity.boss.EntityTFMinoshroom;
import twilightforest.client.model.ModelTFMinotaur;
import twilightforest.entity.EntityTFMinotaur;
import twilightforest.client.model.ModelTFDeathTome;
import twilightforest.entity.EntityTFDeathTome;
import twilightforest.client.model.ModelTFMosquitoSwarm;
import twilightforest.entity.EntityTFMosquitoSwarm;
import twilightforest.entity.EntityTFBoggard;
import twilightforest.client.renderer.entity.RenderTFKobold;
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
import twilightforest.entity.boss.EntityTFLichMinion;
import twilightforest.client.renderer.entity.RenderTFBird;
import twilightforest.client.model.ModelTFPenguin;
import twilightforest.entity.passive.EntityTFPenguin;
import twilightforest.client.renderer.entity.RenderTFLich;
import twilightforest.client.model.ModelTFLich;
import twilightforest.entity.boss.EntityTFLich;
import twilightforest.client.renderer.entity.RenderTFHydra;
import twilightforest.client.model.ModelTFHydra;
import twilightforest.entity.boss.EntityTFHydra;
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
import net.minecraft.client.renderer.entity.Render;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.client.model.ModelBase;
import twilightforest.client.renderer.entity.RenderTFBoar;
import net.minecraft.client.model.ModelPig;
import twilightforest.client.model.ModelTFBoar;
import twilightforest.entity.passive.EntityTFBoar;
import twilightforest.TwilightForestMod;
import twilightforest.TFGenericPacketHandler;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.client.model.ModelBiped;
import twilightforest.TFCommonProxy;

public class TFClientProxy extends TFCommonProxy
{
    int critterRenderID;
    int plantRenderID;
    int blockComplexRenderID;
    int nagastoneRenderID;
    int magicLeavesRenderID;
    int pedestalRenderID;
    int thornsRenderID;
    int knightmetalBlockRenderID;
    int hugeLilyPadBlockRenderID;
    int castleMagicBlockRenderID;
    ModelBiped[] knightlyArmorModel;
    ModelBiped[] phantomArmorModel;
    ModelBiped[] yetiArmorModel;
    ModelBiped[] arcticArmorModel;
    ModelBiped[] fieryArmorModel;
    TFClientTicker clientTicker;
    TFClientEvents clientEvents;
    boolean isDangerOverlayShown;
    
    @Override
    public void doPreLoadRegistration() {
    }
    
    @Override
    public void doOnLoadRegistration() {
        final Minecraft mc = FMLClientHandler.instance().getClient();
        this.clientEvents = new TFClientEvents();
        MinecraftForge.EVENT_BUS.register((Object)this.clientEvents);
        final TFGenericPacketHandler genericPacketHandler = new TFGenericPacketHandler();
        TwilightForestMod.genericChannel.register((Object)genericPacketHandler);
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFBoar.class, (Render)new RenderTFBoar((ModelBase)new ModelTFBoar(), (ModelBase)new ModelPig(0.5f), 0.7f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFBighorn.class, (Render)new RenderTFBighorn((ModelBase)new ModelTFBighorn(), (ModelBase)new ModelTFBighornFur(), 0.7f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFDeer.class, (Render)new RenderTFDeer((ModelBase)new ModelTFDeer(), 0.7f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFRedcap.class, (Render)new RenderTFBiped(new ModelTFRedcap(), 0.625f, "redcap.png"));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFTinyFirefly.class, (Render)new RenderTFTinyFirefly());
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFSkeletonDruid.class, (Render)new RenderTFBiped(new ModelTFSkeletonDruid(), 0.5f, "skeletondruid.png"));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFWraith.class, (Render)new RenderTFWraith(new ModelTFWraith(), 0.5f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFHydra.class, (Render)new RenderTFHydra(new ModelTFHydra(), 1.0f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFLich.class, (Render)new RenderTFLich(new ModelTFLich(), 1.0f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFPenguin.class, (Render)new RenderTFBird(new ModelTFPenguin(), 1.0f, "penguin.png"));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFLichMinion.class, (Render)new RenderTFBiped((ModelBiped)new ModelTFLichMinion(), 1.0f, "textures/entity/zombie/zombie.png"));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFLoyalZombie.class, (Render)new RenderTFBiped((ModelBiped)new ModelTFLoyalZombie(), 1.0f, "textures/entity/zombie/zombie.png"));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFTinyBird.class, (Render)new RenderTFTinyBird(new ModelTFTinyBird(), 1.0f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFSquirrel.class, (Render)new RenderTFGenericLiving(new ModelTFSquirrel(), 1.0f, "squirrel2.png"));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFBunny.class, (Render)new RenderTFBunny(new ModelTFBunny(), 1.0f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFRaven.class, (Render)new RenderTFBird(new ModelTFRaven(), 1.0f, "raven.png"));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFQuestRam.class, (Render)new RenderTFQuestRam());
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFKobold.class, (Render)new RenderTFKobold(new ModelTFKobold(), 0.625f, "kobold.png"));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFBoggard.class, (Render)new RenderTFBiped((ModelBiped)new ModelTFLoyalZombie(), 0.625f, "kobold.png"));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFMosquitoSwarm.class, (Render)new RenderTFGenericLiving(new ModelTFMosquitoSwarm(), 0.625f, "mosquitoswarm.png"));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFDeathTome.class, (Render)new RenderTFGenericLiving((ModelBase)new ModelTFDeathTome(), 0.625f, "textures/entity/enchanting_table_book.png"));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFMinotaur.class, (Render)new RenderTFBiped(new ModelTFMinotaur(), 0.625f, "minotaur.png"));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFMinoshroom.class, (Render)new RenderTFMinoshroom(new ModelTFMinoshroom(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFFireBeetle.class, (Render)new RenderTFGenericLiving(new ModelTFFireBeetle(), 0.625f, "firebeetle.png"));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFSlimeBeetle.class, (Render)new RenderTFSlimeBeetle(new ModelTFSlimeBeetle(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFPinchBeetle.class, (Render)new RenderTFGenericLiving(new ModelTFPinchBeetle(), 0.625f, "pinchbeetle.png"));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFMistWolf.class, (Render)new RenderTFMistWolf((ModelBase)new ModelWolf(), (ModelBase)new ModelWolf(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFMobileFirefly.class, (Render)new RenderTFTinyFirefly());
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFMiniGhast.class, (Render)new RenderTFMiniGhast(new ModelTFGhast(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFTowerGolem.class, (Render)new RenderTFTowerGolem(new ModelTFTowerGolem(), 0.5f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFTowerTermite.class, (Render)new RenderTFGenericLiving((ModelBase)new ModelSilverfish(), 0.3f, "towertermite.png"));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFTowerGhast.class, (Render)new RenderTFTowerGhast(new ModelTFGhast(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFUrGhast.class, (Render)new RenderTFUrGhast(new ModelTFTowerBoss(), 0.625f, 24.0f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFBlockGoblin.class, (Render)new RenderTFBlockGoblin(new ModelTFBlockGoblin(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFGoblinChain.class, (Render)new RenderTFSpikeBlock(new ModelTFGoblinChain(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFSpikeBlock.class, (Render)new RenderTFSpikeBlock(new ModelTFSpikeBlock(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFGoblinKnightUpper.class, (Render)new RenderTFGoblinKnightUpper(new ModelTFGoblinKnightUpper(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFGoblinKnightLower.class, (Render)new RenderTFBiped(new ModelTFGoblinKnightLower(), 0.625f, "doublegoblin.png"));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFHelmetCrab.class, (Render)new RenderTFGenericLiving(new ModelTFHelmetCrab(), 0.625f, "helmetcrab.png"));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFKnightPhantom.class, (Render)new RenderTFKnightPhantom(new ModelTFKnightPhantom2(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFNaga.class, (Render)new RenderTFNaga(new ModelTFNaga(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFNagaSegment.class, (Render)new RenderTFNagaSegment(new ModelTFNaga(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFSwarmSpider.class, (Render)new RenderTFSwarmSpider());
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFKingSpider.class, (Render)new RenderTFKingSpider());
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFTowerBroodling.class, (Render)new RenderTFTowerBroodling());
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFHedgeSpider.class, (Render)new RenderTFHedgeSpider());
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFRedcapSapper.class, (Render)new RenderTFBiped(new ModelTFRedcap(), 0.625f, "redcapsapper.png"));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFMazeSlime.class, (Render)new RenderTFMazeSlime((ModelBase)new ModelSlime(16), (ModelBase)new ModelSlime(0), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFYeti.class, (Render)new RenderTFYeti(new ModelTFYeti(), 0.625f, "yeti2.png"));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFProtectionBox.class, (Render)new RenderTFProtectionBox());
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFYetiAlpha.class, (Render)new RenderTFYeti(new ModelTFYetiAlpha(), 0.625f, "yetialpha.png"));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFWinterWolf.class, (Render)new RenderTFWinterWolf((ModelBase)new ModelWolf(), (ModelBase)new ModelWolf(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFSnowGuardian.class, (Render)new RenderTFSnowGuardian());
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFIceShooter.class, (Render)new RenderTFIceShooter());
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFIceExploder.class, (Render)new RenderTFIceExploder());
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFSnowQueen.class, (Render)new RenderTFSnowQueen());
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFSnowQueenIceShield.class, (Render)new RenderTFSnowQueenIceShield());
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFTroll.class, (Render)new RenderTFBiped(new ModelTFTroll(), 0.625f, "troll.png"));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFGiantMiner.class, (Render)new RenderTFGiant());
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFIceCrystal.class, (Render)new RenderTFIceCrystal());
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFChainBlock.class, (Render)new RenderTFChainBlock(new ModelTFSpikeBlock(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFCubeOfAnnihilation.class, (Render)new RenderTFCubeOfAnnihilation());
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFHarbingerCube.class, (Render)new RenderTFHarbingerCube());
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFAdherent.class, (Render)new RenderTFAdherent(new ModelTFAdherent(), 0.625f, "adherent.png"));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFRovingCube.class, (Render)new RenderTFRovingCube());
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFNatureBolt.class, (Render)new RenderSnowball(Items.field_151014_N));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFLichBolt.class, (Render)new RenderSnowball(Items.field_151079_bi));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFTwilightWandBolt.class, (Render)new RenderSnowball(Items.field_151079_bi));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFTomeBolt.class, (Render)new RenderSnowball(Items.field_151121_aF));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFHydraMortar.class, (Render)new RenderTFHydraMortar());
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFSlimeProjectile.class, (Render)new RenderSnowball(Items.field_151123_aH));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFMoonwormShot.class, (Render)new RenderTFMoonwormShot());
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFCharmEffect.class, (Render)new RenderTFCharm(TFItems.charmOfLife1.func_77617_a(0)));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFLichBomb.class, (Render)new RenderSnowball(Items.field_151064_bs));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFThrownAxe.class, (Render)new RenderTFThrownAxe(TFItems.knightlyAxe));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFThrownPick.class, (Render)new RenderTFThrownAxe(TFItems.knightlyPick));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFFallingIce.class, (Render)new RenderTFFallingIce());
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFIceBomb.class, (Render)new RenderTFThrownIce());
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFIceSnowball.class, (Render)new RenderSnowball(Items.field_151126_ay));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFSlideBlock.class, (Render)new RenderTFSlideBlock());
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFHydraHead.class, (Render)new RenderTFHydraHead(new ModelTFHydraHead(), 1.0f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFHydraNeck.class, (Render)new RenderTFGenericLiving(new ModelTFHydraNeck(), 1.0f, "hydra4.png"));
        ClientRegistry.bindTileEntitySpecialRenderer((Class)TileEntityTFFirefly.class, (TileEntitySpecialRenderer)new TileEntityTFFireflyRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer((Class)TileEntityTFCicada.class, (TileEntitySpecialRenderer)new TileEntityTFCicadaRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer((Class)TileEntityTFMoonworm.class, (TileEntitySpecialRenderer)new TileEntityTFMoonwormRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer((Class)TileEntityTFTrophy.class, (TileEntitySpecialRenderer)new TileEntityTFTrophyRenderer());
        MinecraftForgeClient.registerItemRenderer(TFItems.magicMap, (IItemRenderer)new TFMagicMapRenderer(mc.field_71474_y, mc.func_110434_K()));
        final TFMazeMapRenderer mazeRenderer = new TFMazeMapRenderer(mc.field_71474_y, mc.func_110434_K());
        MinecraftForgeClient.registerItemRenderer(TFItems.mazeMap, (IItemRenderer)mazeRenderer);
        MinecraftForgeClient.registerItemRenderer(TFItems.oreMap, (IItemRenderer)mazeRenderer);
        final TFGiantItemRenderer giantRenderer = new TFGiantItemRenderer(mc.field_71474_y, mc.func_110434_K());
        MinecraftForgeClient.registerItemRenderer(TFItems.giantPick, (IItemRenderer)giantRenderer);
        MinecraftForgeClient.registerItemRenderer(TFItems.giantSword, (IItemRenderer)giantRenderer);
        final TFGiantBlockRenderer giantBlockRenderer = new TFGiantBlockRenderer(mc.field_71474_y, mc.func_110434_K());
        MinecraftForgeClient.registerItemRenderer(Item.func_150898_a(TFBlocks.giantLeaves), (IItemRenderer)giantBlockRenderer);
        MinecraftForgeClient.registerItemRenderer(Item.func_150898_a(TFBlocks.giantCobble), (IItemRenderer)giantBlockRenderer);
        MinecraftForgeClient.registerItemRenderer(Item.func_150898_a(TFBlocks.giantLog), (IItemRenderer)giantBlockRenderer);
        MinecraftForgeClient.registerItemRenderer(Item.func_150898_a(TFBlocks.giantObsidian), (IItemRenderer)giantBlockRenderer);
        final TFFieryItemRenderer fieryRenderer = new TFFieryItemRenderer(mc.field_71474_y, mc.func_110434_K());
        MinecraftForgeClient.registerItemRenderer(TFItems.fieryPick, (IItemRenderer)fieryRenderer);
        MinecraftForgeClient.registerItemRenderer(TFItems.fierySword, (IItemRenderer)fieryRenderer);
        MinecraftForgeClient.registerItemRenderer(TFItems.fieryIngot, (IItemRenderer)fieryRenderer);
        MinecraftForgeClient.registerItemRenderer(TFItems.fieryHelm, (IItemRenderer)fieryRenderer);
        MinecraftForgeClient.registerItemRenderer(TFItems.fieryPlate, (IItemRenderer)fieryRenderer);
        MinecraftForgeClient.registerItemRenderer(TFItems.fieryLegs, (IItemRenderer)fieryRenderer);
        MinecraftForgeClient.registerItemRenderer(TFItems.fieryBoots, (IItemRenderer)fieryRenderer);
        final TFIceItemRenderer iceRenderer = new TFIceItemRenderer(mc.field_71474_y, mc.func_110434_K());
        MinecraftForgeClient.registerItemRenderer(TFItems.iceSword, (IItemRenderer)iceRenderer);
        MinecraftForgeClient.registerItemRenderer(TFItems.glassSword, (IItemRenderer)iceRenderer);
        MinecraftForgeClient.registerItemRenderer(TFItems.iceBow, (IItemRenderer)iceRenderer);
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
        this.thornsRenderID = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler((ISimpleBlockRenderingHandler)new RenderBlockTFThorns(this.thornsRenderID));
        this.knightmetalBlockRenderID = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler((ISimpleBlockRenderingHandler)new RenderBlockTFKnightMetal(this.knightmetalBlockRenderID));
        this.hugeLilyPadBlockRenderID = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler((ISimpleBlockRenderingHandler)new RenderBlockTFHugeLilyPad(this.hugeLilyPadBlockRenderID));
        this.castleMagicBlockRenderID = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler((ISimpleBlockRenderingHandler)new RenderBlockTFCastleMagic(this.castleMagicBlockRenderID));
        (this.knightlyArmorModel = new ModelBiped[4])[0] = new ModelTFKnightlyArmor(0, 0.5f);
        this.knightlyArmorModel[1] = new ModelTFKnightlyArmor(1, 1.0f);
        this.knightlyArmorModel[2] = new ModelTFKnightlyArmor(2, 0.5f);
        this.knightlyArmorModel[3] = new ModelTFKnightlyArmor(3, 0.5f);
        (this.phantomArmorModel = new ModelBiped[2])[0] = new ModelTFPhantomArmor(0, 0.5f);
        this.phantomArmorModel[1] = new ModelTFPhantomArmor(1, 1.0f);
        (this.yetiArmorModel = new ModelBiped[4])[0] = new ModelTFYetiArmor(0, 0.6f);
        this.yetiArmorModel[1] = new ModelTFYetiArmor(1, 1.0f);
        this.yetiArmorModel[2] = new ModelTFYetiArmor(2, 0.4f);
        this.yetiArmorModel[3] = new ModelTFYetiArmor(3, 0.55f);
        (this.arcticArmorModel = new ModelBiped[4])[0] = new ModelTFArcticArmor(0, 0.6f);
        this.arcticArmorModel[1] = new ModelTFArcticArmor(1, 1.0f);
        this.arcticArmorModel[2] = new ModelTFArcticArmor(2, 0.4f);
        this.arcticArmorModel[3] = new ModelTFArcticArmor(3, 0.55f);
        (this.fieryArmorModel = new ModelBiped[4])[0] = new ModelTFFieryArmor(0, 0.5f);
        this.fieryArmorModel[1] = new ModelTFFieryArmor(1, 1.0f);
        this.fieryArmorModel[2] = new ModelTFFieryArmor(2, 0.5f);
        this.fieryArmorModel[3] = new ModelTFFieryArmor(3, 0.5f);
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
    public int getThornsBlockRenderID() {
        return this.thornsRenderID;
    }
    
    @Override
    public int getKnightmetalBlockRenderID() {
        return this.knightmetalBlockRenderID;
    }
    
    @Override
    public int getHugeLilyPadBlockRenderID() {
        return this.hugeLilyPadBlockRenderID;
    }
    
    @Override
    public int getCastleMagicBlockRenderID() {
        return this.castleMagicBlockRenderID;
    }
    
    @Override
    public int registerArmorRenderID(final String prefix) {
        return RenderingRegistry.addNewArmourRendererPrefix(prefix);
    }
    
    @Override
    public World getClientWorld() {
        return (World)FMLClientHandler.instance().getClient().field_71441_e;
    }
    
    @Override
    public void spawnParticle(final World world, final String particleType, final double x, final double y, final double z, final double velX, final double velY, final double velZ) {
        final Minecraft mc = FMLClientHandler.instance().getClient();
        if (mc != null && mc.field_71451_h != null && mc.field_71452_i != null && mc.field_71441_e == world) {
            final double distX = mc.field_71451_h.field_70165_t - x;
            final double distY = mc.field_71451_h.field_70163_u - y;
            final double distZ = mc.field_71451_h.field_70161_v - z;
            EntityFX particle = null;
            final double maxDist = 64.0;
            if (distX * distX + distY * distY + distZ * distZ < maxDist * maxDist) {
                if (particleType.equals("largeflame")) {
                    particle = new EntityTFLargeFlameFX(world, x, y, z, velX, velY, velZ);
                }
                else if (particleType.equals("hugesmoke")) {
                    particle = (EntityFX)new EntitySmokeFX(world, x, y, z, velX, velY, velZ, 8.0f);
                }
                else if (particleType.equals("leafrune")) {
                    particle = (EntityFX)new EntityTFLeafRuneFX(world, x, y, z, velX, velY, velZ);
                }
                else if (particleType.equals("bosstear")) {
                    particle = new EntityTFBossTearFX(world, x, y, z, velX, velY, velZ, Items.field_151073_bk);
                }
                else if (particleType.equals("ghasttrap")) {
                    particle = new EntityTFGhastTrapFX(world, x, y, z, velX, velY, velZ);
                }
                else if (particleType.equals("protection")) {
                    particle = (EntityFX)new EntityTFProtectionFX(world, x, y, z, velX, velY, velZ);
                }
                else if (particleType.equals("snowstuff")) {
                    particle = new EntityTFSnowFX(world, x, y, z, velX, velY, velZ);
                }
                else if (particleType.equals("snowwarning")) {
                    particle = new EntityTFSnowWarningFX(world, x, y, z, velX, velY, velZ, 1.0f);
                }
                else if (particleType.equals("snowguardian")) {
                    particle = new EntityTFSnowGuardianFX(world, x, y, z, velX, velY, velZ, 0.75f);
                }
                else if (particleType.equals("icebeam")) {
                    particle = new EntityTFIceBeamFX(world, x, y, z, velX, velY, velZ, 0.75f);
                }
                else if (particleType.equals("annihilate")) {
                    particle = new EntityTFAnnihilateFX(world, x, y, z, velX, velY, velZ, 0.75f);
                }
                if (particle != null) {
                    particle.field_70169_q = particle.field_70165_t;
                    particle.field_70167_r = particle.field_70163_u;
                    particle.field_70166_s = particle.field_70161_v;
                    mc.field_71452_i.func_78873_a(particle);
                }
            }
        }
    }
    
    @Override
    public ModelBiped getKnightlyArmorModel(final int armorSlot) {
        return this.knightlyArmorModel[armorSlot];
    }
    
    @Override
    public ModelBiped getPhantomArmorModel(final int armorSlot) {
        return this.phantomArmorModel[armorSlot];
    }
    
    @Override
    public ModelBiped getYetiArmorModel(final int armorSlot) {
        return this.yetiArmorModel[armorSlot];
    }
    
    @Override
    public ModelBiped getArcticArmorModel(final int armorSlot) {
        return this.arcticArmorModel[armorSlot];
    }
    
    @Override
    public ModelBiped getFieryArmorModel(final int armorSlot) {
        return this.fieryArmorModel[armorSlot];
    }
    
    public boolean isDangerOverlayShown() {
        return this.isDangerOverlayShown;
    }
    
    public void setDangerOverlayShown(final boolean isDangerOverlayShown) {
        this.isDangerOverlayShown = isDangerOverlayShown;
    }
    
    @Override
    public void doBlockAnnihilateEffect(final World worldObj, final int blockX, final int blockY, final int blockZ) {
        final byte four = 4;
        for (int dx = 0; dx < four; ++dx) {
            for (int dy = 0; dy < four; ++dy) {
                for (int dz = 0; dz < four; ++dz) {
                    final double d0 = blockX + (dx + 0.5) / four;
                    final double d2 = blockY + (dy + 0.5) / four;
                    final double d3 = blockZ + (dz + 0.5) / four;
                    final double gx = worldObj.field_73012_v.nextGaussian() * 0.2;
                    final double gy = worldObj.field_73012_v.nextGaussian() * 0.2;
                    final double gz = worldObj.field_73012_v.nextGaussian() * 0.2;
                    TwilightForestMod.proxy.spawnParticle(worldObj, "annihilate", d0, d2, d3, gx, gy, gz);
                }
            }
        }
    }
}
