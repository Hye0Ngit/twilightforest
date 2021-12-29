// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block.entity;

import net.minecraftforge.registries.ForgeRegistries;
import com.mojang.datafixers.types.Type;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import twilightforest.client.renderer.tileentity.SkullCandleTileEntityRenderer;
import twilightforest.client.renderer.tileentity.CasketTileEntityRenderer;
import twilightforest.client.renderer.tileentity.TwilightChestRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import twilightforest.client.renderer.tileentity.TrophyTileEntityRenderer;
import twilightforest.client.renderer.tileentity.MoonwormTileEntityRenderer;
import twilightforest.client.renderer.tileentity.CicadaTileEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import twilightforest.client.renderer.tileentity.FireflyTileEntityRenderer;
import twilightforest.block.entity.spawner.UrGhastSpawnerBlockEntity;
import twilightforest.block.entity.spawner.SnowQueenSpawnerBlockEntity;
import twilightforest.block.entity.spawner.NagaSpawnerBlockEntity;
import twilightforest.block.entity.spawner.MinoshroomSpawnerBlockEntity;
import twilightforest.block.entity.spawner.LichSpawnerBlockEntity;
import twilightforest.block.entity.spawner.KnightPhantomSpawnerBlockEntity;
import twilightforest.block.entity.spawner.HydraSpawnerBlockEntity;
import twilightforest.block.entity.spawner.FinalBossSpawnerBlockEntity;
import twilightforest.block.entity.spawner.AlphaYetiSpawnerBlockEntity;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;

public class TFBlockEntities
{
    public static final DeferredRegister<BlockEntityType<?>> TILE_ENTITIES;
    public static final RegistryObject<BlockEntityType<AntibuilderBlockEntity>> ANTIBUILDER;
    public static final RegistryObject<BlockEntityType<CinderFurnaceBlockEntity>> CINDER_FURNACE;
    public static final RegistryObject<BlockEntityType<CarminiteReactorBlockEntity>> CARMINITE_REACTOR;
    public static final RegistryObject<BlockEntityType<FireJetBlockEntity>> FLAME_JET;
    public static final RegistryObject<BlockEntityType<GhastTrapBlockEntity>> GHAST_TRAP;
    public static final RegistryObject<BlockEntityType<TFSmokerBlockEntity>> SMOKER;
    public static final RegistryObject<BlockEntityType<CarminiteBuilderBlockEntity>> TOWER_BUILDER;
    public static final RegistryObject<BlockEntityType<TrophyBlockEntity>> TROPHY;
    public static final RegistryObject<BlockEntityType<AlphaYetiSpawnerBlockEntity>> ALPHA_YETI_SPAWNER;
    public static final RegistryObject<BlockEntityType<FinalBossSpawnerBlockEntity>> FINAL_BOSS_SPAWNER;
    public static final RegistryObject<BlockEntityType<HydraSpawnerBlockEntity>> HYDRA_SPAWNER;
    public static final RegistryObject<BlockEntityType<KnightPhantomSpawnerBlockEntity>> KNIGHT_PHANTOM_SPAWNER;
    public static final RegistryObject<BlockEntityType<LichSpawnerBlockEntity>> LICH_SPAWNER;
    public static final RegistryObject<BlockEntityType<MinoshroomSpawnerBlockEntity>> MINOSHROOM_SPAWNER;
    public static final RegistryObject<BlockEntityType<NagaSpawnerBlockEntity>> NAGA_SPAWNER;
    public static final RegistryObject<BlockEntityType<SnowQueenSpawnerBlockEntity>> SNOW_QUEEN_SPAWNER;
    public static final RegistryObject<BlockEntityType<UrGhastSpawnerBlockEntity>> UR_GHAST_SPAWNER;
    public static final RegistryObject<BlockEntityType<CicadaBlockEntity>> CICADA;
    public static final RegistryObject<BlockEntityType<FireflyBlockEntity>> FIREFLY;
    public static final RegistryObject<BlockEntityType<MoonwormBlockEntity>> MOONWORM;
    public static final RegistryObject<BlockEntityType<KeepsakeCasketBlockEntity>> KEEPSAKE_CASKET;
    public static final RegistryObject<BlockEntityType<TFSignBlockEntity>> TF_SIGN;
    public static final RegistryObject<BlockEntityType<TwilightChestEntity>> TF_CHEST;
    public static final RegistryObject<BlockEntityType<SkullCandleBlockEntity>> SKULL_CANDLE;
    public static final RegistryObject<BlockEntityType<TomeSpawnerBlockEntity>> TOME_SPAWNER;
    
    @OnlyIn(Dist.CLIENT)
    public static void registerTileEntityRenders() {
        BlockEntityRenderers.m_173590_((BlockEntityType)TFBlockEntities.FIREFLY.get(), FireflyTileEntityRenderer::new);
        BlockEntityRenderers.m_173590_((BlockEntityType)TFBlockEntities.CICADA.get(), CicadaTileEntityRenderer::new);
        BlockEntityRenderers.m_173590_((BlockEntityType)TFBlockEntities.MOONWORM.get(), MoonwormTileEntityRenderer::new);
        BlockEntityRenderers.m_173590_((BlockEntityType)TFBlockEntities.TROPHY.get(), TrophyTileEntityRenderer::new);
        BlockEntityRenderers.m_173590_((BlockEntityType)TFBlockEntities.TF_SIGN.get(), SignRenderer::new);
        BlockEntityRenderers.m_173590_((BlockEntityType)TFBlockEntities.TF_CHEST.get(), TwilightChestRenderer::new);
        BlockEntityRenderers.m_173590_((BlockEntityType)TFBlockEntities.KEEPSAKE_CASKET.get(), CasketTileEntityRenderer::new);
        BlockEntityRenderers.m_173590_((BlockEntityType)TFBlockEntities.SKULL_CANDLE.get(), SkullCandleTileEntityRenderer::new);
    }
    
    static {
        TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, "twilightforest");
        ANTIBUILDER = TFBlockEntities.TILE_ENTITIES.register("antibuilder", () -> BlockEntityType.Builder.m_155273_(AntibuilderBlockEntity::new, new Block[] { (Block)TFBlocks.ANTIBUILDER.get() }).m_58966_((Type)null));
        CINDER_FURNACE = TFBlockEntities.TILE_ENTITIES.register("cinder_furnace", () -> BlockEntityType.Builder.m_155273_(CinderFurnaceBlockEntity::new, new Block[] { (Block)TFBlocks.CINDER_FURNACE.get() }).m_58966_((Type)null));
        CARMINITE_REACTOR = TFBlockEntities.TILE_ENTITIES.register("carminite_reactor", () -> BlockEntityType.Builder.m_155273_(CarminiteReactorBlockEntity::new, new Block[] { (Block)TFBlocks.CARMINITE_REACTOR.get() }).m_58966_((Type)null));
        FLAME_JET = TFBlockEntities.TILE_ENTITIES.register("flame_jet", () -> BlockEntityType.Builder.m_155273_(FireJetBlockEntity::new, new Block[] { (Block)TFBlocks.FIRE_JET.get(), (Block)TFBlocks.ENCASED_FIRE_JET.get() }).m_58966_((Type)null));
        GHAST_TRAP = TFBlockEntities.TILE_ENTITIES.register("ghast_trap", () -> BlockEntityType.Builder.m_155273_(GhastTrapBlockEntity::new, new Block[] { (Block)TFBlocks.GHAST_TRAP.get() }).m_58966_((Type)null));
        SMOKER = TFBlockEntities.TILE_ENTITIES.register("smoker", () -> BlockEntityType.Builder.m_155273_(TFSmokerBlockEntity::new, new Block[] { (Block)TFBlocks.SMOKER.get(), (Block)TFBlocks.ENCASED_SMOKER.get() }).m_58966_((Type)null));
        TOWER_BUILDER = TFBlockEntities.TILE_ENTITIES.register("tower_builder", () -> BlockEntityType.Builder.m_155273_(CarminiteBuilderBlockEntity::new, new Block[] { (Block)TFBlocks.CARMINITE_BUILDER.get() }).m_58966_((Type)null));
        TROPHY = TFBlockEntities.TILE_ENTITIES.register("trophy", () -> BlockEntityType.Builder.m_155273_(TrophyBlockEntity::new, new Block[] { (Block)TFBlocks.NAGA_TROPHY.get(), (Block)TFBlocks.LICH_TROPHY.get(), (Block)TFBlocks.MINOSHROOM_TROPHY.get(), (Block)TFBlocks.HYDRA_TROPHY.get(), (Block)TFBlocks.KNIGHT_PHANTOM_TROPHY.get(), (Block)TFBlocks.UR_GHAST_TROPHY.get(), (Block)TFBlocks.ALPHA_YETI_TROPHY.get(), (Block)TFBlocks.SNOW_QUEEN_TROPHY.get(), (Block)TFBlocks.QUEST_RAM_TROPHY.get(), (Block)TFBlocks.NAGA_WALL_TROPHY.get(), (Block)TFBlocks.LICH_WALL_TROPHY.get(), (Block)TFBlocks.MINOSHROOM_WALL_TROPHY.get(), (Block)TFBlocks.HYDRA_WALL_TROPHY.get(), (Block)TFBlocks.KNIGHT_PHANTOM_WALL_TROPHY.get(), (Block)TFBlocks.UR_GHAST_WALL_TROPHY.get(), (Block)TFBlocks.ALPHA_YETI_WALL_TROPHY.get(), (Block)TFBlocks.SNOW_QUEEN_WALL_TROPHY.get(), (Block)TFBlocks.QUEST_RAM_WALL_TROPHY.get() }).m_58966_((Type)null));
        ALPHA_YETI_SPAWNER = TFBlockEntities.TILE_ENTITIES.register("alpha_yeti_spawner", () -> BlockEntityType.Builder.m_155273_(AlphaYetiSpawnerBlockEntity::new, new Block[] { (Block)TFBlocks.ALPHA_YETI_BOSS_SPAWNER.get() }).m_58966_((Type)null));
        FINAL_BOSS_SPAWNER = TFBlockEntities.TILE_ENTITIES.register("final_boss_spawner", () -> BlockEntityType.Builder.m_155273_(FinalBossSpawnerBlockEntity::new, new Block[] { (Block)TFBlocks.FINAL_BOSS_BOSS_SPAWNER.get() }).m_58966_((Type)null));
        HYDRA_SPAWNER = TFBlockEntities.TILE_ENTITIES.register("hydra_boss_spawner", () -> BlockEntityType.Builder.m_155273_(HydraSpawnerBlockEntity::new, new Block[] { (Block)TFBlocks.HYDRA_BOSS_SPAWNER.get() }).m_58966_((Type)null));
        KNIGHT_PHANTOM_SPAWNER = TFBlockEntities.TILE_ENTITIES.register("knight_phantom_spawner", () -> BlockEntityType.Builder.m_155273_(KnightPhantomSpawnerBlockEntity::new, new Block[] { (Block)TFBlocks.KNIGHT_PHANTOM_BOSS_SPAWNER.get() }).m_58966_((Type)null));
        LICH_SPAWNER = TFBlockEntities.TILE_ENTITIES.register("lich_spawner", () -> BlockEntityType.Builder.m_155273_(LichSpawnerBlockEntity::new, new Block[] { (Block)TFBlocks.LICH_BOSS_SPAWNER.get() }).m_58966_((Type)null));
        MINOSHROOM_SPAWNER = TFBlockEntities.TILE_ENTITIES.register("minoshroom_spawner", () -> BlockEntityType.Builder.m_155273_(MinoshroomSpawnerBlockEntity::new, new Block[] { (Block)TFBlocks.MINOSHROOM_BOSS_SPAWNER.get() }).m_58966_((Type)null));
        NAGA_SPAWNER = TFBlockEntities.TILE_ENTITIES.register("naga_spawner", () -> BlockEntityType.Builder.m_155273_(NagaSpawnerBlockEntity::new, new Block[] { (Block)TFBlocks.NAGA_BOSS_SPAWNER.get() }).m_58966_((Type)null));
        SNOW_QUEEN_SPAWNER = TFBlockEntities.TILE_ENTITIES.register("snow_queen_spawner", () -> BlockEntityType.Builder.m_155273_(SnowQueenSpawnerBlockEntity::new, new Block[] { (Block)TFBlocks.SNOW_QUEEN_BOSS_SPAWNER.get() }).m_58966_((Type)null));
        UR_GHAST_SPAWNER = TFBlockEntities.TILE_ENTITIES.register("tower_boss_spawner", () -> BlockEntityType.Builder.m_155273_(UrGhastSpawnerBlockEntity::new, new Block[] { (Block)TFBlocks.UR_GHAST_BOSS_SPAWNER.get() }).m_58966_((Type)null));
        CICADA = TFBlockEntities.TILE_ENTITIES.register("cicada", () -> BlockEntityType.Builder.m_155273_(CicadaBlockEntity::new, new Block[] { (Block)TFBlocks.CICADA.get() }).m_58966_((Type)null));
        FIREFLY = TFBlockEntities.TILE_ENTITIES.register("firefly", () -> BlockEntityType.Builder.m_155273_(FireflyBlockEntity::new, new Block[] { (Block)TFBlocks.FIREFLY.get() }).m_58966_((Type)null));
        MOONWORM = TFBlockEntities.TILE_ENTITIES.register("moonworm", () -> BlockEntityType.Builder.m_155273_(MoonwormBlockEntity::new, new Block[] { (Block)TFBlocks.MOONWORM.get() }).m_58966_((Type)null));
        KEEPSAKE_CASKET = TFBlockEntities.TILE_ENTITIES.register("keepsake_casket", () -> BlockEntityType.Builder.m_155273_(KeepsakeCasketBlockEntity::new, new Block[] { (Block)TFBlocks.KEEPSAKE_CASKET.get() }).m_58966_((Type)null));
        TF_SIGN = TFBlockEntities.TILE_ENTITIES.register("tf_sign", () -> BlockEntityType.Builder.m_155273_(TFSignBlockEntity::new, new Block[] { (Block)TFBlocks.TWILIGHT_OAK_SIGN.get(), (Block)TFBlocks.TWILIGHT_WALL_SIGN.get(), (Block)TFBlocks.CANOPY_SIGN.get(), (Block)TFBlocks.CANOPY_WALL_SIGN.get(), (Block)TFBlocks.MANGROVE_SIGN.get(), (Block)TFBlocks.MANGROVE_WALL_SIGN.get(), (Block)TFBlocks.DARKWOOD_SIGN.get(), (Block)TFBlocks.DARKWOOD_WALL_SIGN.get(), (Block)TFBlocks.TIME_SIGN.get(), (Block)TFBlocks.TIME_WALL_SIGN.get(), (Block)TFBlocks.TRANSFORMATION_SIGN.get(), (Block)TFBlocks.TRANSFORMATION_WALL_SIGN.get(), (Block)TFBlocks.MINING_SIGN.get(), (Block)TFBlocks.MINING_WALL_SIGN.get(), (Block)TFBlocks.SORTING_SIGN.get(), (Block)TFBlocks.SORTING_WALL_SIGN.get() }).m_58966_((Type)null));
        TF_CHEST = TFBlockEntities.TILE_ENTITIES.register("tf_chest", () -> BlockEntityType.Builder.m_155273_(TwilightChestEntity::new, new Block[] { (Block)TFBlocks.TWILIGHT_OAK_CHEST.get(), (Block)TFBlocks.CANOPY_CHEST.get(), (Block)TFBlocks.MANGROVE_CHEST.get(), (Block)TFBlocks.DARKWOOD_CHEST.get(), (Block)TFBlocks.TIME_CHEST.get(), (Block)TFBlocks.TRANSFORMATION_CHEST.get(), (Block)TFBlocks.MINING_CHEST.get(), (Block)TFBlocks.SORTING_CHEST.get() }).m_58966_((Type)null));
        SKULL_CANDLE = TFBlockEntities.TILE_ENTITIES.register("skull_candle", () -> BlockEntityType.Builder.m_155273_(SkullCandleBlockEntity::new, new Block[] { (Block)TFBlocks.ZOMBIE_SKULL_CANDLE.get(), (Block)TFBlocks.ZOMBIE_WALL_SKULL_CANDLE.get(), (Block)TFBlocks.SKELETON_SKULL_CANDLE.get(), (Block)TFBlocks.SKELETON_WALL_SKULL_CANDLE.get(), (Block)TFBlocks.WITHER_SKELE_SKULL_CANDLE.get(), (Block)TFBlocks.WITHER_SKELE_WALL_SKULL_CANDLE.get(), (Block)TFBlocks.CREEPER_SKULL_CANDLE.get(), (Block)TFBlocks.CREEPER_WALL_SKULL_CANDLE.get(), (Block)TFBlocks.PLAYER_SKULL_CANDLE.get(), (Block)TFBlocks.PLAYER_WALL_SKULL_CANDLE.get() }).m_58966_((Type)null));
        TOME_SPAWNER = TFBlockEntities.TILE_ENTITIES.register("tome_spawner", () -> BlockEntityType.Builder.m_155273_(TomeSpawnerBlockEntity::new, new Block[] { (Block)TFBlocks.DEATH_TOME_SPAWNER.get() }).m_58966_((Type)null));
    }
}
