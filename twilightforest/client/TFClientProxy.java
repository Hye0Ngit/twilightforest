// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.particle.EntitySmokeFX;
import net.minecraft.world.World;
import net.minecraft.client.Minecraft;
import twilightforest.client.model.ModelTFKnightlyArmor;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import twilightforest.tileentity.TileEntityTFTrophy;
import twilightforest.tileentity.TileEntityTFMoonworm;
import twilightforest.tileentity.TileEntityTFCicada;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
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
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.item.Item;
import twilightforest.entity.EntityTFNatureBolt;
import twilightforest.entity.EntityTFNagaSegment;
import twilightforest.entity.EntityTFNaga;
import twilightforest.client.model.ModelTFKnightPhantom;
import twilightforest.entity.EntityTFKnightPhantom;
import twilightforest.client.model.ModelTFHelmetCrab;
import twilightforest.entity.EntityTFHelmetCrab;
import twilightforest.client.model.ModelTFGoblinKnightLower;
import twilightforest.entity.EntityTFGoblinKnightLower;
import twilightforest.client.model.ModelTFGoblinKnightUpper;
import twilightforest.entity.EntityTFGoblinKnightUpper;
import twilightforest.client.model.ModelTFSpikeBlock;
import twilightforest.entity.EntityTFSpikeBlock;
import twilightforest.client.model.ModelTFGoblinChain;
import twilightforest.entity.EntityTFGoblinChain;
import twilightforest.client.model.ModelTFBlockGoblin;
import twilightforest.entity.EntityTFBlockGoblin;
import twilightforest.client.model.ModelTFTowerBoss;
import twilightforest.entity.EntityTFUrGhast;
import twilightforest.entity.EntityTFTowerGhast;
import net.minecraft.client.model.ModelSilverfish;
import twilightforest.entity.EntityTFTowerTermite;
import twilightforest.client.model.ModelTFTowerGolem;
import twilightforest.entity.EntityTFTowerGolem;
import twilightforest.client.model.ModelTFGhast;
import twilightforest.entity.EntityTFMiniGhast;
import twilightforest.entity.passive.EntityTFMobileFirefly;
import net.minecraft.client.model.ModelWolf;
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
import twilightforest.entity.passive.EntityTFQuestRam;
import twilightforest.client.model.ModelTFRaven;
import twilightforest.entity.passive.EntityTFRaven;
import twilightforest.client.model.ModelTFBunny;
import twilightforest.entity.passive.EntityTFBunny;
import net.minecraft.client.renderer.entity.RenderLiving;
import twilightforest.client.model.ModelTFSquirrel;
import twilightforest.entity.passive.EntityTFSquirrel;
import twilightforest.client.model.ModelTFTinyBird;
import twilightforest.entity.passive.EntityTFTinyBird;
import twilightforest.client.model.ModelTFLoyalZombie;
import twilightforest.entity.EntityTFLoyalZombie;
import twilightforest.client.model.ModelTFLichMinion;
import twilightforest.entity.EntityTFLichMinion;
import twilightforest.client.model.ModelTFPenguin;
import twilightforest.entity.passive.EntityTFPenguin;
import twilightforest.client.model.ModelTFLich;
import twilightforest.entity.EntityTFLich;
import twilightforest.client.model.ModelTFHydra;
import twilightforest.entity.EntityTFHydra;
import twilightforest.client.model.ModelTFWraith;
import twilightforest.entity.EntityTFWraith;
import twilightforest.client.model.ModelTFSkeletonDruid;
import twilightforest.entity.EntityTFSkeletonDruid;
import twilightforest.entity.passive.EntityTFTinyFirefly;
import twilightforest.entity.EntityTFNagaSegmentOld;
import twilightforest.client.model.ModelTFNaga;
import twilightforest.entity.EntityTFNagaOld;
import net.minecraft.client.renderer.entity.RenderBiped;
import twilightforest.client.model.ModelTFRedcap;
import twilightforest.entity.EntityTFRedcap;
import net.minecraft.client.renderer.entity.RenderCow;
import twilightforest.client.model.ModelTFDeer;
import twilightforest.entity.passive.EntityTFDeer;
import net.minecraft.client.renderer.entity.RenderSheep;
import twilightforest.client.model.ModelTFBighornFur;
import twilightforest.client.model.ModelTFBighorn;
import twilightforest.entity.passive.EntityTFBighorn;
import net.minecraft.client.renderer.entity.Render;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderPig;
import net.minecraft.client.model.ModelPig;
import twilightforest.client.model.ModelTFBoar;
import twilightforest.entity.passive.EntityTFBoar;
import cpw.mods.fml.common.IScheduledTickHandler;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.client.FMLClientHandler;
import net.minecraftforge.common.MinecraftForge;
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
    ModelBiped[] knightlyArmorModel;
    TFClientTicker clientTicker;
    
    @Override
    public void doPreLoadRegistration() {
        MinecraftForge.EVENT_BUS.register((Object)new TFSounds());
    }
    
    @Override
    public void doOnLoadRegistration() {
        final Minecraft mc = FMLClientHandler.instance().getClient();
        TickRegistry.registerScheduledTickHandler((IScheduledTickHandler)(this.clientTicker = new TFClientTicker()), Side.CLIENT);
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFBoar.class, (Render)new RenderPig((ModelBase)new ModelTFBoar(), (ModelBase)new ModelPig(0.5f), 0.7f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFBighorn.class, (Render)new RenderSheep((ModelBase)new ModelTFBighorn(), (ModelBase)new ModelTFBighornFur(), 0.7f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFDeer.class, (Render)new RenderCow((ModelBase)new ModelTFDeer(), 0.7f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFRedcap.class, (Render)new RenderBiped((ModelBiped)new ModelTFRedcap(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFNagaOld.class, (Render)new RenderTFNaga(new ModelTFNaga(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFNagaSegmentOld.class, (Render)new RenderTFNaga(new ModelTFNaga(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFTinyFirefly.class, (Render)new RenderTFTinyFirefly());
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFSkeletonDruid.class, (Render)new RenderBiped((ModelBiped)new ModelTFSkeletonDruid(), 0.5f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFWraith.class, (Render)new RenderTFWraith(new ModelTFWraith(), 0.5f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFHydra.class, (Render)new RenderTFHydra(new ModelTFHydra(), 1.0f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFLich.class, (Render)new RenderTFLich(new ModelTFLich(), 1.0f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFPenguin.class, (Render)new RenderTFBird(new ModelTFPenguin(), 1.0f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFLichMinion.class, (Render)new RenderBiped((ModelBiped)new ModelTFLichMinion(), 1.0f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFLoyalZombie.class, (Render)new RenderBiped((ModelBiped)new ModelTFLoyalZombie(), 1.0f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFTinyBird.class, (Render)new RenderTFBird(new ModelTFTinyBird(), 1.0f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFSquirrel.class, (Render)new RenderLiving((ModelBase)new ModelTFSquirrel(), 1.0f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFBunny.class, (Render)new RenderLiving((ModelBase)new ModelTFBunny(), 1.0f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFRaven.class, (Render)new RenderTFBird(new ModelTFRaven(), 1.0f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFQuestRam.class, (Render)new RenderTFQuestRam());
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFKobold.class, (Render)new RenderBiped((ModelBiped)new ModelTFKobold(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFBoggard.class, (Render)new RenderBiped((ModelBiped)new ModelTFLoyalZombie(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFMosquitoSwarm.class, (Render)new RenderLiving((ModelBase)new ModelTFMosquitoSwarm(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFDeathTome.class, (Render)new RenderLiving((ModelBase)new ModelTFDeathTome(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFMinotaur.class, (Render)new RenderBiped((ModelBiped)new ModelTFMinotaur(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFMinoshroom.class, (Render)new RenderTFMinoshroom(new ModelTFMinoshroom(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFFireBeetle.class, (Render)new RenderLiving((ModelBase)new ModelTFFireBeetle(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFSlimeBeetle.class, (Render)new RenderTFSlimeBeetle(new ModelTFSlimeBeetle(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFPinchBeetle.class, (Render)new RenderLiving((ModelBase)new ModelTFPinchBeetle(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFMistWolf.class, (Render)new RenderTFMistWolf((ModelBase)new ModelWolf(), (ModelBase)new ModelWolf(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFMobileFirefly.class, (Render)new RenderTFTinyFirefly());
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFMiniGhast.class, (Render)new RenderLiving((ModelBase)new ModelTFGhast(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFTowerGolem.class, (Render)new RenderTFTowerGolem(new ModelTFTowerGolem(), 0.5f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFTowerTermite.class, (Render)new RenderLiving((ModelBase)new ModelSilverfish(), 0.3f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFTowerGhast.class, (Render)new RenderTFTowerGhast(new ModelTFGhast(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFUrGhast.class, (Render)new RenderTFTowerGhast(new ModelTFTowerBoss(), 0.625f, 24.0f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFBlockGoblin.class, (Render)new RenderTFBlockGoblin(new ModelTFBlockGoblin(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFGoblinChain.class, (Render)new RenderTFSpikeBlock(new ModelTFGoblinChain(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFSpikeBlock.class, (Render)new RenderTFSpikeBlock(new ModelTFSpikeBlock(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFGoblinKnightUpper.class, (Render)new RenderTFGoblinKnightUpper(new ModelTFGoblinKnightUpper(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFGoblinKnightLower.class, (Render)new RenderBiped((ModelBiped)new ModelTFGoblinKnightLower(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFHelmetCrab.class, (Render)new RenderLiving((ModelBase)new ModelTFHelmetCrab(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFKnightPhantom.class, (Render)new RenderBiped((ModelBiped)new ModelTFKnightPhantom(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFNaga.class, (Render)new RenderTFNaga(new ModelTFNaga(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFNagaSegment.class, (Render)new RenderTFSpikeBlock(new ModelTFNaga(), 0.625f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFNatureBolt.class, (Render)new RenderSnowball(Item.field_77690_S));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFLichBolt.class, (Render)new RenderSnowball(Item.field_77730_bn));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFTwilightWandBolt.class, (Render)new RenderSnowball(Item.field_77730_bn));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFTomeBolt.class, (Render)new RenderSnowball(Item.field_77759_aK));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFHydraMortar.class, (Render)new RenderTFHydraMortar());
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFSlimeProjectile.class, (Render)new RenderSnowball(Item.field_77761_aM));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFMoonwormShot.class, (Render)new RenderTFMoonwormShot());
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFCharmEffect.class, (Render)new RenderTFCharm(TFItems.charmOfLife1.func_77617_a(0)));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFLichBomb.class, (Render)new RenderSnowball(Item.field_77725_bx));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFHydraHead.class, (Render)new RenderTFHydraHead(new ModelTFHydraHead(), 1.0f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityTFHydraNeck.class, (Render)new RenderLiving((ModelBase)new ModelTFHydraNeck(), 1.0f));
        ClientRegistry.bindTileEntitySpecialRenderer((Class)TileEntityTFFirefly.class, (TileEntitySpecialRenderer)new TileEntityTFFireflyRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer((Class)TileEntityTFCicada.class, (TileEntitySpecialRenderer)new TileEntityTFCicadaRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer((Class)TileEntityTFMoonworm.class, (TileEntitySpecialRenderer)new TileEntityTFMoonwormRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer((Class)TileEntityTFTrophy.class, (TileEntitySpecialRenderer)new TileEntityTFTrophyRenderer());
        MinecraftForgeClient.registerItemRenderer(TFItems.magicMap.field_77779_bT, (IItemRenderer)new TFMagicMapRenderer(mc.field_71466_p, mc.field_71474_y, mc.field_71446_o));
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
        (this.knightlyArmorModel = new ModelBiped[4])[0] = new ModelTFKnightlyArmor(0, 0.5f);
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
    public World getClientWorld() {
        return (World)FMLClientHandler.instance().getClient().field_71441_e;
    }
    
    @Override
    public void spawnParticle(final String particleType, final double x, final double y, final double z, final double velX, final double velY, final double velZ) {
        final Minecraft mc = FMLClientHandler.instance().getClient();
        if (mc != null && mc.field_71451_h != null && mc.field_71452_i != null) {
            final double distX = mc.field_71451_h.field_70165_t - x;
            final double distY = mc.field_71451_h.field_70163_u - y;
            final double distZ = mc.field_71451_h.field_70161_v - z;
            EntityFX particle = null;
            final double maxDist = 64.0;
            if (distX * distX + distY * distY + distZ * distZ < maxDist * maxDist) {
                if (particleType.equals("largeflame")) {
                    particle = new EntityTFLargeFlameFX((World)mc.field_71441_e, x, y, z, velX, velY, velZ);
                }
                else if (particleType.equals("hugesmoke")) {
                    particle = (EntityFX)new EntitySmokeFX((World)mc.field_71441_e, x, y, z, velX, velY, velZ, 8.0f);
                }
                else if (particleType.equals("leafrune")) {
                    particle = (EntityFX)new EntityTFLeafRuneFX((World)mc.field_71441_e, x, y, z, velX, velY, velZ);
                }
                else if (particleType.equals("bosstear")) {
                    particle = new EntityTFBossTearFX((World)mc.field_71441_e, x, y, z, velX, velY, velZ, Item.field_77732_bp, mc.field_71446_o);
                }
                else if (particleType.equals("ghasttrap")) {
                    particle = new EntityTFGhastTrapFX((World)mc.field_71441_e, x, y, z, velX, velY, velZ);
                }
                if (particle != null) {
                    particle.field_70169_q = particle.field_70165_t;
                    particle.field_70167_r = particle.field_70163_u;
                    particle.field_70166_s = particle.field_70161_v;
                    this.clientTicker.addParticle(particle);
                }
            }
        }
    }
    
    @Override
    public ModelBiped getKnightlyArmorModel(final int armorSlot) {
        return this.knightlyArmorModel[armorSlot];
    }
}
