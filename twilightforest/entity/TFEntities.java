// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraftforge.registries.IForgeRegistryEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import java.util.function.Function;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.WorldEntitySpawner;
import net.minecraft.init.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import twilightforest.entity.boss.EntityTFIceBomb;
import twilightforest.entity.boss.EntityTFFallingIce;
import twilightforest.entity.boss.EntityTFThrownWep;
import twilightforest.entity.boss.EntityTFLichBomb;
import twilightforest.entity.boss.EntityTFHydraMortar;
import twilightforest.entity.boss.EntityTFLichBolt;
import twilightforest.entity.boss.EntityTFHydraHead;
import twilightforest.entity.finalcastle.EntityTFCastleGuardian;
import twilightforest.entity.boss.EntityTFIceCrystal;
import twilightforest.entity.boss.EntityTFSnowQueen;
import twilightforest.entity.boss.EntityTFYetiAlpha;
import twilightforest.entity.boss.EntityTFKnightPhantom;
import twilightforest.entity.boss.EntityTFUrGhast;
import twilightforest.entity.passive.EntityTFMobileFirefly;
import twilightforest.entity.boss.EntityTFMinoshroom;
import twilightforest.entity.passive.EntityTFQuestRam;
import twilightforest.entity.passive.EntityTFRaven;
import twilightforest.entity.passive.EntityTFBunny;
import twilightforest.entity.passive.EntityTFSquirrel;
import twilightforest.entity.passive.EntityTFTinyBird;
import twilightforest.entity.boss.EntityTFLichMinion;
import twilightforest.entity.passive.EntityTFPenguin;
import twilightforest.entity.boss.EntityTFLich;
import twilightforest.entity.boss.EntityTFHydra;
import twilightforest.entity.boss.EntityTFNaga;
import twilightforest.entity.passive.EntityTFDeer;
import twilightforest.entity.passive.EntityTFBighorn;
import twilightforest.entity.passive.EntityTFBoar;
import twilightforest.util.TFEntityNames;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.event.RegistryEvent;
import net.minecraft.entity.EntityLiving;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "twilightforest")
public class TFEntities
{
    public static final EntityLiving.SpawnPlacementType ON_ICE;
    
    @SubscribeEvent
    public static void registerEntities(final RegistryEvent.Register<EntityEntry> event) {
        final EntityRegistryHelper helper = new EntityRegistryHelper((IForgeRegistry<EntityEntry>)event.getRegistry());
        helper.registerEntity(TFEntityNames.WILD_BOAR, EntityTFBoar.class, EntityTFBoar::new, 8611131, 16773066);
        helper.registerEntity(TFEntityNames.BIGHORN_SHEEP, EntityTFBighorn.class, EntityTFBighorn::new, 14405295, 14141297);
        helper.registerEntity(TFEntityNames.DEER, EntityTFDeer.class, EntityTFDeer::new, 8080686, 4924445);
        helper.registerEntity(TFEntityNames.REDCAP, EntityTFRedcap.class, EntityTFRedcap::new, 3881580, 11214356);
        helper.registerEntity(TFEntityNames.SWARM_SPIDER, EntityTFSwarmSpider.class, EntityTFSwarmSpider::new, 3277358, 1516830);
        helper.registerEntity(TFEntityNames.NAGA, EntityTFNaga.class, EntityTFNaga::new, 10801942, 1783819, 150, 1, true);
        helper.registerEntity(TFEntityNames.SKELETON_DRUID, EntityTFSkeletonDruid.class, EntityTFSkeletonDruid::new, 10724259, 2767639);
        helper.registerEntity(TFEntityNames.HOSTILE_WOLF, EntityTFHostileWolf.class, EntityTFHostileWolf::new, 14144467, 11214356);
        helper.registerEntity(TFEntityNames.WRAITH, EntityTFWraith.class, EntityTFWraith::new, 5263440, 8618883);
        helper.registerEntity(TFEntityNames.HEDGE_SPIDER, EntityTFHedgeSpider.class, EntityTFHedgeSpider::new, 2318099, 5645907);
        helper.registerEntity(TFEntityNames.HYDRA, EntityTFHydra.class, EntityTFHydra::new, 1321280, 2719851);
        helper.registerEntity(TFEntityNames.LICH, EntityTFLich.class, EntityTFLich::new, 11314313, 3540082);
        helper.registerEntity(TFEntityNames.PENGUIN, EntityTFPenguin.class, EntityTFPenguin::new, 1185051, 16379346);
        helper.registerEntity(TFEntityNames.LICH_MINION, EntityTFLichMinion.class, EntityTFLichMinion::new);
        helper.registerEntity(TFEntityNames.LOYAL_ZOMBIE, EntityTFLoyalZombie.class, EntityTFLoyalZombie::new);
        helper.registerEntity(TFEntityNames.TINY_BIRD, EntityTFTinyBird.class, EntityTFTinyBird::new, 3386077, 1149166);
        helper.registerEntity(TFEntityNames.SQUIRREL, EntityTFSquirrel.class, EntityTFSquirrel::new, 9457426, 15658734);
        helper.registerEntity(TFEntityNames.BUNNY, EntityTFBunny.class, EntityTFBunny::new, 16711406, 13413017);
        helper.registerEntity(TFEntityNames.RAVEN, EntityTFRaven.class, EntityTFRaven::new, 17, 2236979);
        helper.registerEntity(TFEntityNames.QUEST_RAM, EntityTFQuestRam.class, EntityTFQuestRam::new, 16711406, 3386077);
        helper.registerEntity(TFEntityNames.KOBOLD, EntityTFKobold.class, EntityTFKobold::new, 3612822, 9002267);
        helper.registerEntity(TFEntityNames.MOSQUITO_SWARM, EntityTFMosquitoSwarm.class, EntityTFMosquitoSwarm::new, 526596, 2961185);
        helper.registerEntity(TFEntityNames.DEATH_TOME, EntityTFDeathTome.class, EntityTFDeathTome::new, 7818786, 14405054);
        helper.registerEntity(TFEntityNames.MINOTAUR, EntityTFMinotaur.class, EntityTFMinotaur::new, 4141092, 11173222);
        helper.registerEntity(TFEntityNames.MINOSHROOM, EntityTFMinoshroom.class, EntityTFMinoshroom::new, 11014162, 11173222);
        helper.registerEntity(TFEntityNames.FIRE_BEETLE, EntityTFFireBeetle.class, EntityTFFireBeetle::new, 1903360, 13332261);
        helper.registerEntity(TFEntityNames.SLIME_BEETLE, EntityTFSlimeBeetle.class, EntityTFSlimeBeetle::new, 792070, 6334284);
        helper.registerEntity(TFEntityNames.PINCH_BEETLE, EntityTFPinchBeetle.class, EntityTFPinchBeetle::new, 12358439, 2364937);
        helper.registerEntity(TFEntityNames.MAZE_SLIME, EntityTFMazeSlime.class, EntityTFMazeSlime::new, 10724259, 2767639);
        helper.registerEntity(TFEntityNames.REDCAP_SAPPER, EntityTFRedcapSapper.class, EntityTFRedcapSapper::new, 5725473, 11214356);
        helper.registerEntity(TFEntityNames.MIST_WOLF, EntityTFMistWolf.class, EntityTFMistWolf::new, 3806225, 14862474);
        helper.registerEntity(TFEntityNames.KING_SPIDER, EntityTFKingSpider.class, EntityTFKingSpider::new, 2890254, 16760855);
        helper.registerEntity(TFEntityNames.FIREFLY, EntityTFMobileFirefly.class, EntityTFMobileFirefly::new, 10801942, 12250626);
        helper.registerEntity(TFEntityNames.MINI_GHAST, EntityTFMiniGhast.class, EntityTFMiniGhast::new, 12369084, 10961731);
        helper.registerEntity(TFEntityNames.TOWER_GHAST, EntityTFTowerGhast.class, EntityTFTowerGhast::new, 12369084, 12023928);
        helper.registerEntity(TFEntityNames.TOWER_GOLEM, EntityTFTowerGolem.class, EntityTFTowerGolem::new, 7028000, 14867930);
        helper.registerEntity(TFEntityNames.TOWER_TERMITE, EntityTFTowerTermite.class, EntityTFTowerTermite::new, 6105889, 11313210);
        helper.registerEntity(TFEntityNames.TOWER_BROODLING, EntityTFTowerBroodling.class, EntityTFTowerBroodling::new, 3423252, 12250626);
        helper.registerEntity(TFEntityNames.UR_GHAST, EntityTFUrGhast.class, EntityTFUrGhast::new, 12369084, 12023928);
        helper.registerEntity(TFEntityNames.BLOCKCHAIN_GOBLIN, EntityTFBlockGoblin.class, EntityTFBlockGoblin::new, 13887420, 2047999);
        helper.registerEntity(TFEntityNames.GOBLIN_KNIGHT_UPPER, EntityTFGoblinKnightUpper.class, EntityTFGoblinKnightUpper::new);
        helper.registerEntity(TFEntityNames.GOBLIN_KNIGHT_LOWER, EntityTFGoblinKnightLower.class, EntityTFGoblinKnightLower::new, 5660757, 13887420);
        helper.registerEntity(TFEntityNames.HELMET_CRAB, EntityTFHelmetCrab.class, EntityTFHelmetCrab::new, 16486475, 13887420);
        helper.registerEntity(TFEntityNames.KNIGHT_PHANTOM, EntityTFKnightPhantom.class, EntityTFKnightPhantom::new, 10905403, 13887420);
        helper.registerEntity(TFEntityNames.YETI, EntityTFYeti.class, EntityTFYeti::new, 14606046, 4617659);
        helper.registerEntity(TFEntityNames.YETI_ALPHA, EntityTFYetiAlpha.class, EntityTFYetiAlpha::new, 13487565, 2705518);
        helper.registerEntity(TFEntityNames.WINTER_WOLF, EntityTFWinterWolf.class, EntityTFWinterWolf::new, 14672869, 11713738);
        helper.registerEntity(TFEntityNames.SNOW_GUARDIAN, EntityTFSnowGuardian.class, EntityTFSnowGuardian::new, 13887420, 16711422);
        helper.registerEntity(TFEntityNames.STABLE_ICE_CORE, EntityTFIceShooter.class, EntityTFIceShooter::new, 10600435, 7340280);
        helper.registerEntity(TFEntityNames.UNSTABLE_ICE_CORE, EntityTFIceExploder.class, EntityTFIceExploder::new, 10136821, 10162085);
        helper.registerEntity(TFEntityNames.SNOW_QUEEN, EntityTFSnowQueen.class, EntityTFSnowQueen::new, 11645652, 8847470);
        helper.registerEntity(TFEntityNames.TROLL, EntityTFTroll.class, EntityTFTroll::new, 10398095, 11572366);
        helper.registerEntity(TFEntityNames.GIANT_MINER, EntityTFGiantMiner.class, EntityTFGiantMiner::new, 2169682, 10132122);
        helper.registerEntity(TFEntityNames.ARMORED_GIANT, EntityTFArmoredGiant.class, EntityTFArmoredGiant::new, 2331537, 10132122);
        helper.registerEntity(TFEntityNames.ICE_CRYSTAL, EntityTFIceCrystal.class, EntityTFIceCrystal::new, 14477822, 11389691);
        helper.registerEntity(TFEntityNames.HARBINGER_CUBE, EntityTFHarbingerCube.class, EntityTFHarbingerCube::new, 10, 9109504);
        helper.registerEntity(TFEntityNames.ADHERENT, EntityTFAdherent.class, EntityTFAdherent::new, 655360, 139);
        helper.registerEntity(TFEntityNames.ROVING_CUBE, EntityTFRovingCube.class, EntityTFRovingCube::new, 655360, 155);
        helper.registerEntity(TFEntityNames.CASTLE_GUARDIAN, EntityTFCastleGuardian.class, EntityTFCastleGuardian::new, 80, 3, true);
        helper.registerEntity(TFEntityNames.HYDRA_HEAD, EntityTFHydraHead.class, EntityTFHydraHead::new, 150, 3, false);
        helper.registerEntity(TFEntityNames.NATURE_BOLT, EntityTFNatureBolt.class, EntityTFNatureBolt::new, 150, 5, true);
        helper.registerEntity(TFEntityNames.LICH_BOLT, EntityTFLichBolt.class, EntityTFLichBolt::new, 150, 2, true);
        helper.registerEntity(TFEntityNames.WAND_BOLT, EntityTFTwilightWandBolt.class, EntityTFTwilightWandBolt::new, 150, 5, true);
        helper.registerEntity(TFEntityNames.TOME_BOLT, EntityTFTomeBolt.class, EntityTFTomeBolt::new, 150, 5, true);
        helper.registerEntity(TFEntityNames.HYDRA_MORTAR, EntityTFHydraMortar.class, EntityTFHydraMortar::new, 150, 3, true);
        helper.registerEntity(TFEntityNames.LICH_BOMB, EntityTFLichBomb.class, EntityTFLichBomb::new, 150, 3, true);
        helper.registerEntity(TFEntityNames.MOONWORM_SHOT, EntityTFMoonwormShot.class, EntityTFMoonwormShot::new, 150, 3, true);
        helper.registerEntity(TFEntityNames.SLIME_BLOB, EntityTFSlimeProjectile.class, EntityTFSlimeProjectile::new, 150, 3, true);
        helper.registerEntity(TFEntityNames.CHARM_EFFECT, EntityTFCharmEffect.class, EntityTFCharmEffect::new, 80, 3, true);
        helper.registerEntity(TFEntityNames.THROWN_WEP, EntityTFThrownWep.class, EntityTFThrownWep::new, 80, 3, true);
        helper.registerEntity(TFEntityNames.FALLING_ICE, EntityTFFallingIce.class, EntityTFFallingIce::new, 80, 3, true);
        helper.registerEntity(TFEntityNames.THROWN_ICE, EntityTFIceBomb.class, EntityTFIceBomb::new, 80, 2, true);
        helper.registerEntity(TFEntityNames.SEEKER_ARROW, EntitySeekerArrow.class, EntitySeekerArrow::new, 150, 1, true);
        helper.registerEntity(TFEntityNames.ICE_ARROW, EntityIceArrow.class, EntityIceArrow::new, 150, 1, true);
        helper.registerEntity(TFEntityNames.ICE_SNOWBALL, EntityTFIceSnowball.class, EntityTFIceSnowball::new, 150, 3, true);
        helper.registerEntity(TFEntityNames.CHAIN_BLOCK, EntityTFChainBlock.class, EntityTFChainBlock::new, 80, 1, true);
        helper.registerEntity(TFEntityNames.CUBE_OF_ANNIHILATION, EntityTFCubeOfAnnihilation.class, EntityTFCubeOfAnnihilation::new, 80, 1, true);
        helper.registerEntity(TFEntityNames.SLIDER, EntityTFSlideBlock.class, EntityTFSlideBlock::new, 80, 1, true);
        helper.registerEntity(TFEntityNames.BOGGARD, EntityTFBoggard.class, EntityTFBoggard::new);
        helper.registerEntity(TFEntityNames.RISING_ZOMBIE, EntityTFRisingZombie.class, EntityTFRisingZombie::new);
    }
    
    static {
        EntitySpawnPlacementRegistry.setPlacementType((Class)EntityTFPenguin.class, ON_ICE = EnumHelper.addSpawnPlacementType("TF_ON_ICE", (world, pos) -> {
            final IBlockState state = world.func_180495_p(pos.func_177977_b());
            final Block block = state.func_177230_c();
            final Material material = state.func_185904_a();
            return (material == Material.field_151588_w || material == Material.field_151598_x) && block != Blocks.field_150357_h && block != Blocks.field_180401_cv && WorldEntitySpawner.func_185331_a(world.func_180495_p(pos)) && WorldEntitySpawner.func_185331_a(world.func_180495_p(pos.func_177984_a()));
        }));
    }
    
    private static class EntityRegistryHelper
    {
        private final IForgeRegistry<EntityEntry> registry;
        private int id;
        
        EntityRegistryHelper(final IForgeRegistry<EntityEntry> registry) {
            this.id = 0;
            this.registry = registry;
        }
        
        private static String toString(final ResourceLocation registryName) {
            return registryName.func_110624_b() + "." + registryName.func_110623_a();
        }
        
        final <T extends Entity> EntityEntryBuilder<T> builder(final ResourceLocation registryName, final Class<T> entity, final Function<World, T> factory) {
            return (EntityEntryBuilder<T>)EntityEntryBuilder.create().id(registryName, this.id++).name(toString(registryName)).entity((Class)entity).factory((Function)factory);
        }
        
        final <T extends Entity> void registerEntity(final ResourceLocation registryName, final Class<T> entity, final Function<World, T> factory, final int backgroundEggColour, final int foregroundEggColour) {
            this.registerEntity(registryName, entity, factory, backgroundEggColour, foregroundEggColour, 80, 3, true);
        }
        
        final <T extends Entity> void registerEntity(final ResourceLocation registryName, final Class<T> entity, final Function<World, T> factory, final int backgroundEggColour, final int foregroundEggColour, final int trackingRange, final int updateInterval, final boolean sendVelocityUpdates) {
            this.registry.register((IForgeRegistryEntry)this.builder(registryName, entity, factory).tracker(trackingRange, updateInterval, sendVelocityUpdates).egg(backgroundEggColour, foregroundEggColour).build());
        }
        
        final <T extends Entity> void registerEntity(final ResourceLocation registryName, final Class<T> entity, final Function<World, T> factory) {
            this.registerEntity(registryName, entity, factory, 80, 3, true);
        }
        
        final <T extends Entity> void registerEntity(final ResourceLocation registryName, final Class<T> entity, final Function<World, T> factory, final int trackingRange, final int updateInterval, final boolean sendVelocityUpdates) {
            this.registry.register((IForgeRegistryEntry)this.builder(registryName, entity, factory).tracker(trackingRange, updateInterval, sendVelocityUpdates).build());
        }
    }
}
