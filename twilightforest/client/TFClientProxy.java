// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import twilightforest.client.renderer.entity.RenderTFBoar;
import twilightforest.client.model.entity.ModelTFBoar;
import twilightforest.client.renderer.entity.RenderTFBighorn;
import twilightforest.client.model.entity.ModelTFBighornFur;
import twilightforest.client.model.entity.ModelTFBighorn;
import twilightforest.client.renderer.entity.RenderTFDeer;
import twilightforest.client.model.entity.ModelTFDeer;
import twilightforest.client.model.entity.ModelTFSkeletonDruid;
import twilightforest.client.renderer.entity.RenderTFWraith;
import twilightforest.client.model.entity.ModelTFWraith;
import twilightforest.client.renderer.entity.RenderTFHydra;
import twilightforest.client.model.entity.ModelTFHydra;
import twilightforest.client.renderer.entity.RenderTFLich;
import twilightforest.client.model.entity.ModelTFLich;
import twilightforest.client.model.entity.ModelTFPenguin;
import twilightforest.client.model.entity.ModelTFLichMinion;
import twilightforest.client.renderer.entity.RenderTFTinyBird;
import twilightforest.client.model.entity.ModelTFTinyBird;
import twilightforest.client.model.entity.ModelTFSquirrel;
import twilightforest.client.renderer.entity.RenderTFBunny;
import twilightforest.client.model.entity.ModelTFBunny;
import twilightforest.client.renderer.entity.RenderTFBird;
import twilightforest.client.model.entity.ModelTFRaven;
import twilightforest.client.renderer.entity.RenderTFKobold;
import twilightforest.client.model.entity.ModelTFKobold;
import twilightforest.client.model.entity.ModelTFLoyalZombie;
import twilightforest.client.model.entity.ModelTFMosquitoSwarm;
import twilightforest.client.model.entity.ModelTFDeathTome;
import twilightforest.client.model.entity.ModelTFMinotaur;
import twilightforest.client.renderer.entity.RenderTFMinoshroom;
import twilightforest.client.model.entity.ModelTFMinoshroom;
import twilightforest.client.model.entity.ModelTFFireBeetle;
import twilightforest.client.renderer.entity.RenderTFSlimeBeetle;
import twilightforest.client.model.entity.ModelTFSlimeBeetle;
import twilightforest.client.model.entity.ModelTFPinchBeetle;
import twilightforest.client.renderer.entity.RenderTFGhast;
import twilightforest.client.renderer.entity.RenderTFTowerGolem;
import twilightforest.client.model.entity.ModelTFTowerGolem;
import net.minecraft.client.model.ModelSilverfish;
import twilightforest.client.renderer.entity.RenderTFTowerGhast;
import twilightforest.client.model.entity.ModelTFGhast;
import twilightforest.client.renderer.entity.RenderTFUrGhast;
import twilightforest.client.model.entity.ModelTFTowerBoss;
import twilightforest.client.renderer.entity.RenderTFBlockGoblin;
import twilightforest.client.model.entity.ModelTFBlockGoblin;
import twilightforest.client.model.entity.ModelTFGoblinChain;
import twilightforest.client.renderer.entity.RenderTFSpikeBlock;
import twilightforest.client.renderer.entity.RenderTFGoblinKnightUpper;
import twilightforest.client.model.entity.ModelTFGoblinKnightUpper;
import twilightforest.client.model.entity.ModelTFGoblinKnightLower;
import twilightforest.client.model.entity.ModelTFHelmetCrab;
import twilightforest.client.renderer.entity.RenderTFKnightPhantom;
import twilightforest.client.model.entity.ModelTFKnightPhantom2;
import twilightforest.client.renderer.entity.RenderTFNaga;
import twilightforest.client.renderer.entity.RenderTFNagaSegment;
import twilightforest.client.model.entity.ModelTFNaga;
import twilightforest.client.model.entity.ModelTFRedcap;
import twilightforest.client.renderer.entity.RenderTFMazeSlime;
import twilightforest.client.model.entity.ModelTFYeti;
import twilightforest.client.renderer.entity.RenderTFYeti;
import twilightforest.client.model.entity.ModelTFYetiAlpha;
import twilightforest.client.model.entity.ModelTFTroll;
import twilightforest.client.renderer.entity.RenderTFChainBlock;
import twilightforest.client.model.entity.ModelTFSpikeBlock;
import twilightforest.client.renderer.entity.RenderTFAdherent;
import twilightforest.client.model.entity.ModelTFAdherent;
import twilightforest.client.renderer.entity.RenderTFBiped;
import twilightforest.client.model.entity.ModelTFRisingZombie;
import twilightforest.client.renderer.entity.RenderTFCastleGuardian;
import twilightforest.client.model.entity.finalcastle.ModelTFCastleGuardian;
import twilightforest.client.renderer.entity.RenderTFCharm;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.init.Items;
import twilightforest.client.renderer.entity.RenderTFHydraHead;
import twilightforest.client.model.entity.ModelTFHydraHead;
import net.minecraft.client.model.ModelBase;
import twilightforest.client.renderer.entity.RenderTFGenericLiving;
import twilightforest.client.model.entity.ModelTFHydraNeck;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.common.registry.GameRegistry;
import twilightforest.tileentity.critters.TileEntityTFMoonworm;
import twilightforest.tileentity.critters.TileEntityTFFirefly;
import twilightforest.tileentity.critters.TileEntityTFCicada;
import net.minecraft.advancements.Advancement;
import net.minecraft.client.multiplayer.ClientAdvancementManager;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.particle.Particle;
import net.minecraft.world.World;
import net.minecraft.entity.Entity;
import twilightforest.client.particle.TFParticleFactory;
import twilightforest.client.particle.TFParticleType;
import net.minecraft.command.ICommand;
import net.minecraft.command.CommandException;
import twilightforest.compat.ie.IEShaderRegister;
import twilightforest.compat.TFCompat;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraft.server.MinecraftServer;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.CommandBase;
import net.minecraftforge.client.ClientCommandHandler;
import twilightforest.client.shader.ShaderManager;
import net.minecraftforge.client.EnumHelperClient;
import twilightforest.TFSounds;
import twilightforest.client.model.armor.ModelTFFieryArmor;
import twilightforest.client.model.armor.ModelTFArcticArmor;
import twilightforest.client.model.armor.ModelTFYetiArmor;
import twilightforest.client.model.armor.ModelTFPhantomArmor;
import twilightforest.client.model.armor.ModelTFKnightlyArmor;
import twilightforest.client.renderer.tileentity.TileEntityTFTrophyRenderer;
import twilightforest.tileentity.TileEntityTFTrophy;
import twilightforest.client.renderer.tileentity.TileEntityTFMoonwormRenderer;
import twilightforest.tileentity.critters.TileEntityTFMoonwormTicking;
import twilightforest.client.renderer.tileentity.TileEntityTFCicadaRenderer;
import twilightforest.tileentity.critters.TileEntityTFCicadaTicking;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import twilightforest.client.renderer.tileentity.TileEntityTFFireflyRenderer;
import twilightforest.tileentity.critters.TileEntityTFFireflyTicking;
import net.minecraftforge.common.MinecraftForge;
import twilightforest.entity.boss.EntityTFHydraNeck;
import twilightforest.entity.boss.EntityTFHydraHead;
import twilightforest.entity.EntityIceArrow;
import twilightforest.client.renderer.entity.RenderDefaultArrow;
import twilightforest.entity.EntitySeekerArrow;
import twilightforest.client.renderer.entity.RenderTFSlideBlock;
import twilightforest.entity.EntityTFSlideBlock;
import twilightforest.entity.EntityTFIceSnowball;
import twilightforest.client.renderer.entity.RenderTFThrownIce;
import twilightforest.entity.boss.EntityTFIceBomb;
import twilightforest.client.renderer.entity.RenderTFFallingIce;
import twilightforest.entity.boss.EntityTFFallingIce;
import twilightforest.client.renderer.entity.RenderTFThrownWep;
import twilightforest.entity.boss.EntityTFThrownWep;
import twilightforest.entity.boss.EntityTFLichBomb;
import twilightforest.entity.EntityTFCharmEffect;
import twilightforest.client.renderer.entity.RenderTFMoonwormShot;
import twilightforest.entity.EntityTFMoonwormShot;
import twilightforest.entity.EntityTFSlimeProjectile;
import twilightforest.client.renderer.entity.RenderTFHydraMortar;
import twilightforest.entity.boss.EntityTFHydraMortar;
import twilightforest.entity.EntityTFTomeBolt;
import twilightforest.entity.EntityTFTwilightWandBolt;
import twilightforest.entity.boss.EntityTFLichBolt;
import twilightforest.entity.EntityTFNatureBolt;
import twilightforest.entity.finalcastle.EntityTFCastleGuardian;
import twilightforest.entity.EntityTFRisingZombie;
import twilightforest.client.renderer.entity.RenderTFRovingCube;
import twilightforest.entity.EntityTFRovingCube;
import twilightforest.entity.EntityTFAdherent;
import twilightforest.client.renderer.entity.RenderTFHarbingerCube;
import twilightforest.entity.EntityTFHarbingerCube;
import twilightforest.client.renderer.entity.RenderTFCubeOfAnnihilation;
import twilightforest.entity.EntityTFCubeOfAnnihilation;
import twilightforest.entity.EntityTFChainBlock;
import twilightforest.client.renderer.entity.RenderTFIceCrystal;
import twilightforest.entity.boss.EntityTFIceCrystal;
import twilightforest.client.renderer.entity.RenderTFGiant;
import twilightforest.entity.EntityTFGiantMiner;
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
import twilightforest.entity.boss.EntityTFYetiAlpha;
import twilightforest.client.renderer.entity.RenderTFProtectionBox;
import twilightforest.entity.EntityTFProtectionBox;
import twilightforest.entity.EntityTFYeti;
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
import twilightforest.entity.boss.EntityTFNagaSegment;
import twilightforest.entity.boss.EntityTFNaga;
import twilightforest.entity.boss.EntityTFKnightPhantom;
import twilightforest.entity.EntityTFHelmetCrab;
import twilightforest.entity.EntityTFGoblinKnightLower;
import twilightforest.entity.EntityTFGoblinKnightUpper;
import twilightforest.entity.EntityTFSpikeBlock;
import twilightforest.entity.EntityTFGoblinChain;
import twilightforest.entity.EntityTFBlockGoblin;
import twilightforest.entity.boss.EntityTFUrGhast;
import twilightforest.entity.EntityTFTowerGhast;
import twilightforest.entity.EntityTFTowerTermite;
import twilightforest.entity.EntityTFTowerGolem;
import twilightforest.entity.EntityTFMiniGhast;
import twilightforest.client.renderer.entity.RenderTFMobileFirefly;
import twilightforest.entity.passive.EntityTFMobileFirefly;
import twilightforest.client.renderer.entity.RenderTFMistWolf;
import twilightforest.entity.EntityTFMistWolf;
import twilightforest.entity.EntityTFPinchBeetle;
import twilightforest.entity.EntityTFSlimeBeetle;
import twilightforest.entity.EntityTFFireBeetle;
import twilightforest.entity.boss.EntityTFMinoshroom;
import twilightforest.entity.EntityTFMinotaur;
import twilightforest.entity.EntityTFDeathTome;
import twilightforest.entity.EntityTFMosquitoSwarm;
import twilightforest.entity.EntityTFBoggard;
import twilightforest.entity.EntityTFKobold;
import twilightforest.client.renderer.entity.RenderTFQuestRam;
import twilightforest.entity.passive.EntityTFQuestRam;
import twilightforest.entity.passive.EntityTFRaven;
import twilightforest.entity.passive.EntityTFBunny;
import twilightforest.entity.passive.EntityTFSquirrel;
import twilightforest.entity.passive.EntityTFTinyBird;
import twilightforest.entity.EntityTFLoyalZombie;
import twilightforest.entity.boss.EntityTFLichMinion;
import twilightforest.entity.passive.EntityTFPenguin;
import twilightforest.entity.boss.EntityTFLich;
import twilightforest.entity.boss.EntityTFHydra;
import twilightforest.entity.EntityTFWraith;
import twilightforest.entity.EntityTFSkeletonDruid;
import twilightforest.entity.EntityTFRedcap;
import twilightforest.entity.passive.EntityTFDeer;
import twilightforest.entity.passive.EntityTFBighorn;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import twilightforest.entity.passive.EntityTFBoar;
import java.util.EnumMap;
import net.minecraft.client.audio.MusicTicker;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.inventory.EntityEquipmentSlot;
import java.util.Map;
import twilightforest.TFCommonProxy;

public class TFClientProxy extends TFCommonProxy
{
    private final Map<EntityEquipmentSlot, ModelBiped> knightlyArmorModel;
    private final Map<EntityEquipmentSlot, ModelBiped> phantomArmorModel;
    private final Map<EntityEquipmentSlot, ModelBiped> yetiArmorModel;
    private final Map<EntityEquipmentSlot, ModelBiped> arcticArmorModel;
    private final Map<EntityEquipmentSlot, ModelBiped> fieryArmorModel;
    private boolean isDangerOverlayShown;
    public static MusicTicker.MusicType TFMUSICTYPE;
    
    public TFClientProxy() {
        this.knightlyArmorModel = new EnumMap<EntityEquipmentSlot, ModelBiped>(EntityEquipmentSlot.class);
        this.phantomArmorModel = new EnumMap<EntityEquipmentSlot, ModelBiped>(EntityEquipmentSlot.class);
        this.yetiArmorModel = new EnumMap<EntityEquipmentSlot, ModelBiped>(EntityEquipmentSlot.class);
        this.arcticArmorModel = new EnumMap<EntityEquipmentSlot, ModelBiped>(EntityEquipmentSlot.class);
        this.fieryArmorModel = new EnumMap<EntityEquipmentSlot, ModelBiped>(EntityEquipmentSlot.class);
    }
    
    @Override
    public void preInit() {
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFBoar.class, m -> new RenderTFBoar(m, (ModelBase)new ModelTFBoar()));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFBighorn.class, m -> new RenderTFBighorn(m, (ModelBase)new ModelTFBighorn(), (ModelBase)new ModelTFBighornFur(), 0.7f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFDeer.class, m -> new RenderTFDeer(m, (ModelBase)new ModelTFDeer(), 0.7f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFRedcap.class, m -> new RenderTFBiped(m, new ModelTFRedcap(), 0.4f, "redcap.png"));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFSkeletonDruid.class, m -> new RenderTFBiped(m, (ModelBiped)new ModelTFSkeletonDruid(), 0.5f, "skeletondruid.png"));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFWraith.class, m -> new RenderTFWraith(m, new ModelTFWraith(), 0.5f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFHydra.class, m -> new RenderTFHydra(m, new ModelTFHydra(), 4.0f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFLich.class, m -> new RenderTFLich(m, new ModelTFLich(), 0.6f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFPenguin.class, m -> new RenderTFBird(m, new ModelTFPenguin(), 0.375f, "penguin.png"));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFLichMinion.class, m -> new RenderTFBiped(m, (ModelBiped)new ModelTFLichMinion(), 0.5f, "textures/entity/zombie/zombie.png"));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFLoyalZombie.class, m -> new RenderTFBiped(m, (ModelBiped)new ModelTFLoyalZombie(), 0.5f, "textures/entity/zombie/zombie.png"));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFTinyBird.class, m -> new RenderTFTinyBird(m, new ModelTFTinyBird(), 1.0f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFSquirrel.class, m -> new RenderTFGenericLiving(m, new ModelTFSquirrel(), 1.0f, "squirrel2.png"));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFBunny.class, m -> new RenderTFBunny(m, new ModelTFBunny(), 1.0f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFRaven.class, m -> new RenderTFBird(m, new ModelTFRaven(), 1.0f, "raven.png"));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFQuestRam.class, RenderTFQuestRam::new);
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFKobold.class, m -> new RenderTFKobold(m, new ModelTFKobold(), 0.4f, "kobold.png"));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFBoggard.class, m -> new RenderTFBiped(m, (ModelBiped)new ModelTFLoyalZombie(), 0.625f, "kobold.png"));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFMosquitoSwarm.class, m -> new RenderTFGenericLiving(m, new ModelTFMosquitoSwarm(), 0.0f, "mosquitoswarm.png"));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFDeathTome.class, m -> new RenderTFGenericLiving(m, (ModelBase)new ModelTFDeathTome(), 0.3f, "textures/entity/enchanting_table_book.png"));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFMinotaur.class, m -> new RenderTFBiped(m, new ModelTFMinotaur(), 0.625f, "minotaur.png"));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFMinoshroom.class, m -> new RenderTFMinoshroom(m, new ModelTFMinoshroom(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFFireBeetle.class, m -> new RenderTFGenericLiving(m, new ModelTFFireBeetle(), 0.8f, "firebeetle.png"));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFSlimeBeetle.class, m -> new RenderTFSlimeBeetle(m, new ModelTFSlimeBeetle(), 0.6f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFPinchBeetle.class, m -> new RenderTFGenericLiving(m, new ModelTFPinchBeetle(), 0.6f, "pinchbeetle.png"));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFMistWolf.class, RenderTFMistWolf::new);
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFMobileFirefly.class, RenderTFMobileFirefly::new);
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFMiniGhast.class, m -> new RenderTFGhast(m, new ModelTFGhast(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFTowerGolem.class, m -> new RenderTFTowerGolem(m, new ModelTFTowerGolem(), 0.75f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFTowerTermite.class, m -> new RenderTFGenericLiving(m, (ModelBase)new ModelSilverfish(), 0.3f, "towertermite.png"));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFTowerGhast.class, m -> new RenderTFTowerGhast(m, new ModelTFGhast(), 3.0f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFUrGhast.class, m -> new RenderTFUrGhast(m, new ModelTFTowerBoss(), 8.0f, 24.0f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFBlockGoblin.class, m -> new RenderTFBlockGoblin(m, new ModelTFBlockGoblin(), 0.4f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFGoblinChain.class, m -> new RenderTFSpikeBlock(m, new ModelTFGoblinChain()));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFSpikeBlock.class, m -> new RenderTFSpikeBlock(m, new ModelTFSpikeBlock()));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFGoblinKnightUpper.class, m -> new RenderTFGoblinKnightUpper(m, new ModelTFGoblinKnightUpper(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFGoblinKnightLower.class, m -> new RenderTFBiped(m, new ModelTFGoblinKnightLower(), 0.625f, "doublegoblin.png"));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFHelmetCrab.class, m -> new RenderTFGenericLiving(m, new ModelTFHelmetCrab(), 0.625f, "helmetcrab.png"));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFKnightPhantom.class, m -> new RenderTFKnightPhantom(m, new ModelTFKnightPhantom2(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFNaga.class, m -> new RenderTFNaga(m, new ModelTFNaga(), 1.45f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFNagaSegment.class, m -> new RenderTFNagaSegment(m, new ModelTFNaga()));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFSwarmSpider.class, RenderTFSwarmSpider::new);
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFKingSpider.class, RenderTFKingSpider::new);
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFTowerBroodling.class, RenderTFTowerBroodling::new);
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFHedgeSpider.class, RenderTFHedgeSpider::new);
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFRedcapSapper.class, m -> new RenderTFBiped(m, new ModelTFRedcap(), 0.4f, "redcapsapper.png"));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFMazeSlime.class, m -> new RenderTFMazeSlime(m, 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFYeti.class, m -> new RenderTFYeti(m, new ModelTFYeti(), 0.625f, "yeti2.png"));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFProtectionBox.class, RenderTFProtectionBox::new);
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFYetiAlpha.class, m -> new RenderTFYeti(m, new ModelTFYetiAlpha(), 1.75f, "yetialpha.png"));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFWinterWolf.class, RenderTFWinterWolf::new);
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFSnowGuardian.class, RenderTFSnowGuardian::new);
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFIceShooter.class, RenderTFIceShooter::new);
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFIceExploder.class, RenderTFIceExploder::new);
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFSnowQueen.class, RenderTFSnowQueen::new);
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFSnowQueenIceShield.class, RenderTFSnowQueenIceShield::new);
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFTroll.class, m -> new RenderTFBiped(m, new ModelTFTroll(), 0.625f, "troll.png"));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFGiantMiner.class, RenderTFGiant::new);
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFIceCrystal.class, RenderTFIceCrystal::new);
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFChainBlock.class, m -> new RenderTFChainBlock(m, new ModelTFSpikeBlock()));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFCubeOfAnnihilation.class, RenderTFCubeOfAnnihilation::new);
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFHarbingerCube.class, RenderTFHarbingerCube::new);
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFAdherent.class, m -> new RenderTFAdherent(m, new ModelTFAdherent(), 0.625f, "adherent.png"));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFRovingCube.class, RenderTFRovingCube::new);
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFRisingZombie.class, m -> new RenderTFBiped(m, (ModelBiped)new ModelTFRisingZombie(), 0.5f, "textures/entity/zombie/zombie.png"));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFCastleGuardian.class, m -> new RenderTFCastleGuardian(m, new ModelTFCastleGuardian(), 2.0f, "finalcastle/castle_guardian.png"));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFNatureBolt.class, m -> new RenderSnowball(m, Items.field_151014_N, Minecraft.func_71410_x().func_175599_af()));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFLichBolt.class, m -> new RenderSnowball(m, Items.field_151079_bi, Minecraft.func_71410_x().func_175599_af()));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFTwilightWandBolt.class, m -> new RenderSnowball(m, Items.field_151079_bi, Minecraft.func_71410_x().func_175599_af()));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFTomeBolt.class, m -> new RenderSnowball(m, Items.field_151121_aF, Minecraft.func_71410_x().func_175599_af()));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFHydraMortar.class, RenderTFHydraMortar::new);
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFSlimeProjectile.class, m -> new RenderSnowball(m, Items.field_151123_aH, Minecraft.func_71410_x().func_175599_af()));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFMoonwormShot.class, RenderTFMoonwormShot::new);
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFCharmEffect.class, m -> new RenderTFCharm(m, Minecraft.func_71410_x().func_175599_af()));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFLichBomb.class, m -> new RenderSnowball(m, Items.field_151064_bs, Minecraft.func_71410_x().func_175599_af()));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFThrownWep.class, RenderTFThrownWep::new);
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFFallingIce.class, RenderTFFallingIce::new);
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFIceBomb.class, RenderTFThrownIce::new);
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFIceSnowball.class, m -> new RenderSnowball(m, Items.field_151126_ay, Minecraft.func_71410_x().func_175599_af()));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFSlideBlock.class, RenderTFSlideBlock::new);
        RenderingRegistry.registerEntityRenderingHandler((Class)EntitySeekerArrow.class, RenderDefaultArrow::new);
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityIceArrow.class, RenderDefaultArrow::new);
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFHydraHead.class, m -> new RenderTFHydraHead(m, new ModelTFHydraHead(), 1.0f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFHydraNeck.class, m -> new RenderTFGenericLiving(m, new ModelTFHydraNeck(), 1.0f, "hydra4.png"));
    }
    
    @Override
    public void init() {
        MinecraftForge.EVENT_BUS.register((Object)new LoadingScreenListener());
        ClientRegistry.bindTileEntitySpecialRenderer((Class)TileEntityTFFireflyTicking.class, (TileEntitySpecialRenderer)new TileEntityTFFireflyRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer((Class)TileEntityTFCicadaTicking.class, (TileEntitySpecialRenderer)new TileEntityTFCicadaRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer((Class)TileEntityTFMoonwormTicking.class, (TileEntitySpecialRenderer)new TileEntityTFMoonwormRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer((Class)TileEntityTFTrophy.class, (TileEntitySpecialRenderer)new TileEntityTFTrophyRenderer());
        this.knightlyArmorModel.put(EntityEquipmentSlot.HEAD, new ModelTFKnightlyArmor(0.5f));
        this.knightlyArmorModel.put(EntityEquipmentSlot.CHEST, new ModelTFKnightlyArmor(1.0f));
        this.knightlyArmorModel.put(EntityEquipmentSlot.LEGS, new ModelTFKnightlyArmor(0.5f));
        this.knightlyArmorModel.put(EntityEquipmentSlot.FEET, new ModelTFKnightlyArmor(0.5f));
        this.phantomArmorModel.put(EntityEquipmentSlot.HEAD, new ModelTFPhantomArmor(EntityEquipmentSlot.HEAD, 0.5f));
        this.phantomArmorModel.put(EntityEquipmentSlot.CHEST, new ModelTFPhantomArmor(EntityEquipmentSlot.CHEST, 0.5f));
        this.yetiArmorModel.put(EntityEquipmentSlot.HEAD, new ModelTFYetiArmor(EntityEquipmentSlot.HEAD, 0.6f));
        this.yetiArmorModel.put(EntityEquipmentSlot.CHEST, new ModelTFYetiArmor(EntityEquipmentSlot.CHEST, 1.0f));
        this.yetiArmorModel.put(EntityEquipmentSlot.LEGS, new ModelTFYetiArmor(EntityEquipmentSlot.LEGS, 0.4f));
        this.yetiArmorModel.put(EntityEquipmentSlot.FEET, new ModelTFYetiArmor(EntityEquipmentSlot.FEET, 0.55f));
        this.arcticArmorModel.put(EntityEquipmentSlot.HEAD, new ModelTFArcticArmor(0.6f));
        this.arcticArmorModel.put(EntityEquipmentSlot.CHEST, new ModelTFArcticArmor(1.0f));
        this.arcticArmorModel.put(EntityEquipmentSlot.LEGS, new ModelTFArcticArmor(0.4f));
        this.arcticArmorModel.put(EntityEquipmentSlot.FEET, new ModelTFArcticArmor(0.55f));
        this.fieryArmorModel.put(EntityEquipmentSlot.HEAD, new ModelTFFieryArmor(0.5f));
        this.fieryArmorModel.put(EntityEquipmentSlot.CHEST, new ModelTFFieryArmor(1.0f));
        this.fieryArmorModel.put(EntityEquipmentSlot.LEGS, new ModelTFFieryArmor(0.5f));
        this.fieryArmorModel.put(EntityEquipmentSlot.FEET, new ModelTFFieryArmor(0.5f));
        TFClientProxy.TFMUSICTYPE = EnumHelperClient.addMusicType("TFMUSIC", TFSounds.MUSIC, 1200, 12000);
        ShaderManager.initShaders();
        ClientCommandHandler.instance.func_71560_a((ICommand)new CommandBase() {
            public String func_71517_b() {
                return "tfreload";
            }
            
            public String func_71518_a(final ICommandSender sender) {
                return "commands.tffeature.reload";
            }
            
            public void func_184881_a(final MinecraftServer server, final ICommandSender sender, final String[] args) throws CommandException {
                if (FMLCommonHandler.instance().getEffectiveSide().isClient()) {
                    Minecraft.func_71410_x().field_71439_g.func_145747_a((ITextComponent)new TextComponentString("Reloading Twilight Forest Shaders!"));
                    ShaderManager.getShaderReloadListener().func_110549_a(Minecraft.func_71410_x().func_110442_L());
                    if (TFCompat.IMMERSIVEENGINEERING.isActivated()) {
                        IEShaderRegister.initShaders();
                    }
                }
            }
        });
    }
    
    @Override
    public void spawnParticle(final TFParticleType particleType, final double x, final double y, final double z, final double vx, final double vy, final double vz) {
        final Minecraft mc = Minecraft.func_71410_x();
        final Entity entity = mc.func_175606_aa();
        final World world = (World)mc.field_71441_e;
        if (entity != null && mc.field_71452_i != null) {
            int i = mc.field_71474_y.field_74362_aa;
            if (i == 1 && world.field_73012_v.nextInt(3) == 0) {
                i = 2;
            }
            if (i > 1) {
                return;
            }
            final double dx = entity.field_70165_t - x;
            final double dy = entity.field_70163_u - y;
            final double dz = entity.field_70161_v - z;
            if (dx * dx + dy * dy + dz * dz > 1024.0) {
                return;
            }
            final Particle particle = TFParticleFactory.createParticle(particleType, world, x, y, z, vx, vy, vz);
            if (particle != null) {
                mc.field_71452_i.func_78873_a(particle);
            }
        }
    }
    
    @Override
    public ModelBiped getKnightlyArmorModel(final EntityEquipmentSlot armorSlot) {
        return this.knightlyArmorModel.get(armorSlot);
    }
    
    @Override
    public ModelBiped getPhantomArmorModel(final EntityEquipmentSlot armorSlot) {
        return this.phantomArmorModel.get(armorSlot);
    }
    
    @Override
    public ModelBiped getYetiArmorModel(final EntityEquipmentSlot armorSlot) {
        return this.yetiArmorModel.get(armorSlot);
    }
    
    @Override
    public ModelBiped getArcticArmorModel(final EntityEquipmentSlot armorSlot) {
        return this.arcticArmorModel.get(armorSlot);
    }
    
    @Override
    public ModelBiped getFieryArmorModel(final EntityEquipmentSlot armorSlot) {
        return this.fieryArmorModel.get(armorSlot);
    }
    
    public boolean isDangerOverlayShown() {
        return this.isDangerOverlayShown;
    }
    
    public void setDangerOverlayShown(final boolean isDangerOverlayShown) {
        this.isDangerOverlayShown = isDangerOverlayShown;
    }
    
    @Override
    public boolean doesPlayerHaveAdvancement(final EntityPlayer player, final ResourceLocation advId) {
        if (!(player instanceof EntityPlayerSP)) {
            return super.doesPlayerHaveAdvancement(player, advId);
        }
        final ClientAdvancementManager manager = ((EntityPlayerSP)player).field_71174_a.func_191982_f();
        final Advancement adv = manager.func_194229_a().func_192084_a(advId);
        if (adv == null) {
            return false;
        }
        final AdvancementProgress progress = manager.field_192803_d.get(adv);
        return progress != null && progress.func_192105_a();
    }
    
    @Override
    public TileEntityTFCicada getNewCicadaTE() {
        return new TileEntityTFCicadaTicking();
    }
    
    @Override
    public TileEntityTFFirefly getNewFireflyTE() {
        return new TileEntityTFFireflyTicking();
    }
    
    @Override
    public TileEntityTFMoonworm getNewMoonwormTE() {
        return new TileEntityTFMoonwormTicking();
    }
    
    @Override
    public void registerCritterTileEntities() {
        GameRegistry.registerTileEntity((Class)TileEntityTFFireflyTicking.class, TFCommonProxy.prefix("firefly"));
        GameRegistry.registerTileEntity((Class)TileEntityTFCicadaTicking.class, TFCommonProxy.prefix("cicada"));
        GameRegistry.registerTileEntity((Class)TileEntityTFMoonwormTicking.class, TFCommonProxy.prefix("moonworm"));
    }
}
