// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.tileentity;

import net.minecraftforge.registries.ForgeRegistries;
import com.mojang.datafixers.types.Type;
import java.util.function.Supplier;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import twilightforest.client.renderer.tileentity.CasketTileEntityRenderer;
import net.minecraft.client.renderer.tileentity.SignTileEntityRenderer;
import twilightforest.client.renderer.tileentity.TrophyTileEntityRenderer;
import twilightforest.client.renderer.tileentity.MoonwormTileEntityRenderer;
import twilightforest.client.renderer.tileentity.CicadaTileEntityRenderer;
import java.util.function.Function;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import twilightforest.client.renderer.tileentity.FireflyTileEntityRenderer;
import twilightforest.tileentity.spawner.TowerBossSpawnerTileEntity;
import twilightforest.tileentity.spawner.SnowQueenSpawnerTileEntity;
import twilightforest.tileentity.spawner.NagaSpawnerTileEntity;
import twilightforest.tileentity.spawner.MinoshroomSpawnerTileEntity;
import twilightforest.tileentity.spawner.LichSpawnerTileEntity;
import twilightforest.tileentity.spawner.KnightPhantomSpawnerTileEntity;
import twilightforest.tileentity.spawner.HydraSpawnerTileEntity;
import twilightforest.tileentity.spawner.FinalBossSpawnerTileEntity;
import twilightforest.tileentity.spawner.AlphaYetiSpawnerTileEntity;
import net.minecraftforge.fml.RegistryObject;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.registries.DeferredRegister;

public class TFTileEntities
{
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES;
    public static final RegistryObject<TileEntityType<AntibuilderTileEntity>> ANTIBUILDER;
    public static final RegistryObject<TileEntityType<CinderFurnaceTileEntity>> CINDER_FURNACE;
    public static final RegistryObject<TileEntityType<ActiveCarminiteReactorTileEntity>> CARMINITE_REACTOR;
    public static final RegistryObject<TileEntityType<FireJetTileEntity>> FLAME_JET;
    public static final RegistryObject<TileEntityType<ActiveGhastTrapTileEntity>> GHAST_TRAP;
    public static final RegistryObject<TileEntityType<TFSmokerTileEntity>> SMOKER;
    public static final RegistryObject<TileEntityType<CarminiteBuilderTileEntity>> TOWER_BUILDER;
    public static final RegistryObject<TileEntityType<TrophyTileEntity>> TROPHY;
    public static final RegistryObject<TileEntityType<AlphaYetiSpawnerTileEntity>> ALPHA_YETI_SPAWNER;
    public static final RegistryObject<TileEntityType<FinalBossSpawnerTileEntity>> FINAL_BOSS_SPAWNER;
    public static final RegistryObject<TileEntityType<HydraSpawnerTileEntity>> HYDRA_SPAWNER;
    public static final RegistryObject<TileEntityType<KnightPhantomSpawnerTileEntity>> KNIGHT_PHANTOM_SPAWNER;
    public static final RegistryObject<TileEntityType<LichSpawnerTileEntity>> LICH_SPAWNER;
    public static final RegistryObject<TileEntityType<MinoshroomSpawnerTileEntity>> MINOSHROOM_SPAWNER;
    public static final RegistryObject<TileEntityType<NagaSpawnerTileEntity>> NAGA_SPAWNER;
    public static final RegistryObject<TileEntityType<SnowQueenSpawnerTileEntity>> SNOW_QUEEN_SPAWNER;
    public static final RegistryObject<TileEntityType<TowerBossSpawnerTileEntity>> TOWER_BOSS_SPAWNER;
    public static final RegistryObject<TileEntityType<CicadaTileEntity>> CICADA;
    public static final RegistryObject<TileEntityType<FireflyTileEntity>> FIREFLY;
    public static final RegistryObject<TileEntityType<MoonwormTileEntity>> MOONWORM;
    public static final RegistryObject<TileEntityType<KeepsakeCasketTileEntity>> KEEPSAKE_CASKET;
    public static final RegistryObject<TileEntityType<TFSignTileEntity>> TF_SIGN;
    
    @OnlyIn(Dist.CLIENT)
    public static void registerTileEntityRenders() {
        ClientRegistry.bindTileEntityRenderer((TileEntityType)TFTileEntities.FIREFLY.get(), (Function)FireflyTileEntityRenderer::new);
        ClientRegistry.bindTileEntityRenderer((TileEntityType)TFTileEntities.CICADA.get(), (Function)CicadaTileEntityRenderer::new);
        ClientRegistry.bindTileEntityRenderer((TileEntityType)TFTileEntities.MOONWORM.get(), (Function)MoonwormTileEntityRenderer::new);
        ClientRegistry.bindTileEntityRenderer((TileEntityType)TFTileEntities.TROPHY.get(), (Function)TrophyTileEntityRenderer::new);
        ClientRegistry.bindTileEntityRenderer((TileEntityType)TFTileEntities.TF_SIGN.get(), (Function)SignTileEntityRenderer::new);
        ClientRegistry.bindTileEntityRenderer((TileEntityType)TFTileEntities.KEEPSAKE_CASKET.get(), (Function)CasketTileEntityRenderer::new);
    }
    
    static {
        TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, "twilightforest");
        ANTIBUILDER = TFTileEntities.TILE_ENTITIES.register("antibuilder", () -> TileEntityType.Builder.func_223042_a((Supplier)AntibuilderTileEntity::new, new Block[] { (Block)TFBlocks.antibuilder.get() }).func_206865_a((Type)null));
        CINDER_FURNACE = TFTileEntities.TILE_ENTITIES.register("cinder_furnace", () -> TileEntityType.Builder.func_223042_a((Supplier)CinderFurnaceTileEntity::new, new Block[] { (Block)TFBlocks.cinder_furnace.get() }).func_206865_a((Type)null));
        CARMINITE_REACTOR = TFTileEntities.TILE_ENTITIES.register("carminite_reactor", () -> TileEntityType.Builder.func_223042_a((Supplier)ActiveCarminiteReactorTileEntity::new, new Block[] { (Block)TFBlocks.carminite_reactor.get() }).func_206865_a((Type)null));
        FLAME_JET = TFTileEntities.TILE_ENTITIES.register("flame_jet", () -> TileEntityType.Builder.func_223042_a((Supplier)FireJetTileEntity::new, new Block[] { (Block)TFBlocks.fire_jet.get(), (Block)TFBlocks.encased_fire_jet.get() }).func_206865_a((Type)null));
        GHAST_TRAP = TFTileEntities.TILE_ENTITIES.register("ghast_trap", () -> TileEntityType.Builder.func_223042_a((Supplier)ActiveGhastTrapTileEntity::new, new Block[] { (Block)TFBlocks.ghast_trap.get() }).func_206865_a((Type)null));
        SMOKER = TFTileEntities.TILE_ENTITIES.register("smoker", () -> TileEntityType.Builder.func_223042_a((Supplier)TFSmokerTileEntity::new, new Block[] { (Block)TFBlocks.smoker.get(), (Block)TFBlocks.encased_smoker.get() }).func_206865_a((Type)null));
        TOWER_BUILDER = TFTileEntities.TILE_ENTITIES.register("tower_builder", () -> TileEntityType.Builder.func_223042_a((Supplier)CarminiteBuilderTileEntity::new, new Block[] { (Block)TFBlocks.carminite_builder.get() }).func_206865_a((Type)null));
        TROPHY = TFTileEntities.TILE_ENTITIES.register("trophy", () -> TileEntityType.Builder.func_223042_a((Supplier)TrophyTileEntity::new, new Block[] { (Block)TFBlocks.naga_trophy.get(), (Block)TFBlocks.lich_trophy.get(), (Block)TFBlocks.minoshroom_trophy.get(), (Block)TFBlocks.hydra_trophy.get(), (Block)TFBlocks.knight_phantom_trophy.get(), (Block)TFBlocks.ur_ghast_trophy.get(), (Block)TFBlocks.yeti_trophy.get(), (Block)TFBlocks.snow_queen_trophy.get(), (Block)TFBlocks.quest_ram_trophy.get(), (Block)TFBlocks.naga_wall_trophy.get(), (Block)TFBlocks.lich_wall_trophy.get(), (Block)TFBlocks.minoshroom_wall_trophy.get(), (Block)TFBlocks.hydra_wall_trophy.get(), (Block)TFBlocks.knight_phantom_wall_trophy.get(), (Block)TFBlocks.ur_ghast_wall_trophy.get(), (Block)TFBlocks.yeti_wall_trophy.get(), (Block)TFBlocks.snow_queen_wall_trophy.get(), (Block)TFBlocks.quest_ram_wall_trophy.get() }).func_206865_a((Type)null));
        ALPHA_YETI_SPAWNER = TFTileEntities.TILE_ENTITIES.register("alpha_yeti_spawner", () -> TileEntityType.Builder.func_223042_a((Supplier)AlphaYetiSpawnerTileEntity::new, new Block[] { (Block)TFBlocks.boss_spawner_alpha_yeti.get() }).func_206865_a((Type)null));
        FINAL_BOSS_SPAWNER = TFTileEntities.TILE_ENTITIES.register("final_boss_spawner", () -> TileEntityType.Builder.func_223042_a((Supplier)FinalBossSpawnerTileEntity::new, new Block[] { (Block)TFBlocks.boss_spawner_final_boss.get() }).func_206865_a((Type)null));
        HYDRA_SPAWNER = TFTileEntities.TILE_ENTITIES.register("hydra_boss_spawner", () -> TileEntityType.Builder.func_223042_a((Supplier)HydraSpawnerTileEntity::new, new Block[] { (Block)TFBlocks.boss_spawner_hydra.get() }).func_206865_a((Type)null));
        KNIGHT_PHANTOM_SPAWNER = TFTileEntities.TILE_ENTITIES.register("knight_phantom_spawner", () -> TileEntityType.Builder.func_223042_a((Supplier)KnightPhantomSpawnerTileEntity::new, new Block[] { (Block)TFBlocks.boss_spawner_knight_phantom.get() }).func_206865_a((Type)null));
        LICH_SPAWNER = TFTileEntities.TILE_ENTITIES.register("lich_spawner", () -> TileEntityType.Builder.func_223042_a((Supplier)LichSpawnerTileEntity::new, new Block[] { (Block)TFBlocks.boss_spawner_lich.get() }).func_206865_a((Type)null));
        MINOSHROOM_SPAWNER = TFTileEntities.TILE_ENTITIES.register("minoshroom_spawner", () -> TileEntityType.Builder.func_223042_a((Supplier)MinoshroomSpawnerTileEntity::new, new Block[] { (Block)TFBlocks.boss_spawner_minoshroom.get() }).func_206865_a((Type)null));
        NAGA_SPAWNER = TFTileEntities.TILE_ENTITIES.register("naga_spawner", () -> TileEntityType.Builder.func_223042_a((Supplier)NagaSpawnerTileEntity::new, new Block[] { (Block)TFBlocks.boss_spawner_naga.get() }).func_206865_a((Type)null));
        SNOW_QUEEN_SPAWNER = TFTileEntities.TILE_ENTITIES.register("snow_queen_spawner", () -> TileEntityType.Builder.func_223042_a((Supplier)SnowQueenSpawnerTileEntity::new, new Block[] { (Block)TFBlocks.boss_spawner_snow_queen.get() }).func_206865_a((Type)null));
        TOWER_BOSS_SPAWNER = TFTileEntities.TILE_ENTITIES.register("tower_boss_spawner", () -> TileEntityType.Builder.func_223042_a((Supplier)TowerBossSpawnerTileEntity::new, new Block[] { (Block)TFBlocks.boss_spawner_ur_ghast.get() }).func_206865_a((Type)null));
        CICADA = TFTileEntities.TILE_ENTITIES.register("cicada", () -> TileEntityType.Builder.func_223042_a((Supplier)CicadaTileEntity::new, new Block[] { (Block)TFBlocks.cicada.get() }).func_206865_a((Type)null));
        FIREFLY = TFTileEntities.TILE_ENTITIES.register("firefly", () -> TileEntityType.Builder.func_223042_a((Supplier)FireflyTileEntity::new, new Block[] { (Block)TFBlocks.firefly.get() }).func_206865_a((Type)null));
        MOONWORM = TFTileEntities.TILE_ENTITIES.register("moonworm", () -> TileEntityType.Builder.func_223042_a((Supplier)MoonwormTileEntity::new, new Block[] { (Block)TFBlocks.moonworm.get() }).func_206865_a((Type)null));
        KEEPSAKE_CASKET = TFTileEntities.TILE_ENTITIES.register("keepsake_casket", () -> TileEntityType.Builder.func_223042_a((Supplier)KeepsakeCasketTileEntity::new, new Block[] { (Block)TFBlocks.keepsake_casket.get() }).func_206865_a((Type)null));
        TF_SIGN = TFTileEntities.TILE_ENTITIES.register("tf_sign", () -> TileEntityType.Builder.func_223042_a((Supplier)TFSignTileEntity::new, new Block[] { (Block)TFBlocks.twilight_oak_sign.get(), (Block)TFBlocks.twilight_wall_sign.get(), (Block)TFBlocks.canopy_sign.get(), (Block)TFBlocks.canopy_wall_sign.get(), (Block)TFBlocks.mangrove_sign.get(), (Block)TFBlocks.mangrove_wall_sign.get(), (Block)TFBlocks.darkwood_sign.get(), (Block)TFBlocks.darkwood_wall_sign.get(), (Block)TFBlocks.time_sign.get(), (Block)TFBlocks.time_wall_sign.get(), (Block)TFBlocks.trans_sign.get(), (Block)TFBlocks.trans_wall_sign.get(), (Block)TFBlocks.mine_sign.get(), (Block)TFBlocks.mine_wall_sign.get(), (Block)TFBlocks.sort_sign.get(), (Block)TFBlocks.sort_wall_sign.get() }).func_206865_a((Type)null));
    }
}
