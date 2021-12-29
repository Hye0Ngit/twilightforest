// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import twilightforest.worldgen.biomes.BiomeKeys;
import java.util.HashMap;
import twilightforest.potions.TFPotions;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.DamageSource;
import java.util.Iterator;
import net.minecraft.util.math.SectionPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.chunk.ChunkStatus;
import twilightforest.structures.start.TFStructure;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.gen.feature.structure.StructureStart;
import java.util.Optional;
import net.minecraft.world.ISeedReader;
import net.minecraft.util.math.BlockPos;
import twilightforest.util.PlayerHelper;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.GameRules;
import twilightforest.TwilightForestMod;
import twilightforest.TFConfig;
import javax.annotation.Nullable;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.server.ServerWorld;
import twilightforest.TFFeature;
import net.minecraft.entity.Entity;
import net.minecraft.world.biome.Biome;
import net.minecraft.util.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.entity.player.PlayerEntity;
import java.util.function.BiConsumer;
import net.minecraft.util.ResourceLocation;
import java.util.Map;

public class TFGenerationSettings
{
    private static final Map<ResourceLocation, ResourceLocation[]> BIOME_ADVANCEMENTS;
    private static final Map<ResourceLocation, BiConsumer<PlayerEntity, World>> BIOME_PROGRESSION_ENFORCEMENT;
    public static final int SEALEVEL = 31;
    public static final int CHUNKHEIGHT = 256;
    public static final int MAXHEIGHT = 256;
    
    private static void registerBiomeAdvancementRestriction(final RegistryKey<Biome> biome, final ResourceLocation... advancements) {
        TFGenerationSettings.BIOME_ADVANCEMENTS.put(biome.func_240901_a_(), advancements);
    }
    
    private static void registerBiomeProgressionEnforcement(final RegistryKey<Biome> biome, final BiConsumer<PlayerEntity, World> exec) {
        TFGenerationSettings.BIOME_PROGRESSION_ENFORCEMENT.put(biome.func_240901_a_(), exec);
    }
    
    public static void enforceBiomeProgression(final PlayerEntity player, final World world) {
        final Biome currentBiome = world.func_226691_t_(player.func_233580_cy_());
        if (isBiomeSafeFor(currentBiome, (Entity)player)) {
            return;
        }
        final BiConsumer<PlayerEntity, World> exec = TFGenerationSettings.BIOME_PROGRESSION_ENFORCEMENT.get(currentBiome.getRegistryName());
        if (exec != null) {
            exec.accept(player, world);
        }
    }
    
    private static void trySpawnHintMonster(final PlayerEntity player, final World world, final TFFeature feature) {
        if (world.field_73012_v.nextInt(4) == 0) {
            feature.trySpawnHintMonster(world, player);
        }
    }
    
    @Nullable
    public static ChunkGeneratorTwilightBase getChunkGenerator(final World world) {
        if (world instanceof ServerWorld) {
            final ChunkGenerator chunkGenerator = ((ServerWorld)world).func_72863_F().field_186029_c;
            return (chunkGenerator instanceof ChunkGeneratorTwilightBase) ? chunkGenerator : null;
        }
        return null;
    }
    
    public static boolean isStrictlyTwilightForest(final World world) {
        return world.func_234923_W_().func_240901_a_().toString().equals(TFConfig.COMMON_CONFIG.DIMENSION.twilightForestID.get());
    }
    
    public static boolean isTwilightChunk(final ServerWorld world) {
        return world.func_72863_F().field_186029_c instanceof ChunkGeneratorTwilightBase;
    }
    
    public static boolean isProgressionEnforced(final World world) {
        return world.func_82736_K().func_223586_b((GameRules.RuleKey)TwilightForestMod.ENFORCED_PROGRESSION_RULE);
    }
    
    public static boolean isBiomeSafeFor(final Biome biome, final Entity entity) {
        final ResourceLocation[] advancements = TFGenerationSettings.BIOME_ADVANCEMENTS.get(entity.field_70170_p.func_201670_d() ? entity.field_70170_p.func_241828_r().func_243612_b(Registry.field_239720_u_).func_177774_c((Object)biome) : biome.getRegistryName());
        return advancements == null || !(entity instanceof PlayerEntity) || PlayerHelper.doesPlayerHaveRequiredAdvancements((PlayerEntity)entity, advancements);
    }
    
    public static void markStructureConquered(final World world, final BlockPos pos, final TFFeature feature) {
        final ChunkGeneratorTwilightBase generator = getChunkGenerator(world);
        if (generator == null || TFFeature.getFeatureAt(pos.func_177958_n(), pos.func_177952_p(), (ISeedReader)world) == feature) {}
    }
    
    public static Optional<StructureStart<?>> locateTFStructureInRange(final ISeedReader world, final BlockPos pos, final int range) {
        final int cx1 = MathHelper.func_76141_d((float)(pos.func_177958_n() - range >> 4));
        final int cx2 = MathHelper.func_76123_f((float)(pos.func_177958_n() + range >> 4));
        final int cz1 = MathHelper.func_76141_d((float)(pos.func_177952_p() - range >> 4));
        final int cz2 = MathHelper.func_76123_f((float)(pos.func_177952_p() + range >> 4));
        final TFFeature featureCheck = TFFeature.getFeatureForRegionPos(pos.func_177958_n(), pos.func_177952_p(), world);
        for (final Structure<?> structureFeature : ForgeRegistries.STRUCTURE_FEATURES) {
            if (!(structureFeature instanceof TFStructure)) {
                continue;
            }
            final TFFeature feature = ((TFStructure)structureFeature).getFeature();
            if (feature != featureCheck) {
                continue;
            }
            for (int x = cx1; x <= cx2; ++x) {
                for (int z = cz1; z <= cz2; ++z) {
                    final Optional<StructureStart<?>> structure = world.func_217348_a(x, z, ChunkStatus.field_222606_b).func_230346_b_((Structure)structureFeature).stream().map(longVal -> SectionPos.func_218156_a(new ChunkPos((long)longVal), 0)).map(sectionPos -> world.func_217354_b(sectionPos.func_218149_a(), sectionPos.func_218148_c()) ? world.func_217348_a(sectionPos.func_218149_a(), sectionPos.func_218148_c(), ChunkStatus.field_222606_b).func_230342_a_(structureFeature) : null).filter(structureStart -> structureStart != null && structureStart.func_75069_d()).findFirst();
                    if (structure.isPresent()) {
                        return structure;
                    }
                }
            }
        }
        return Optional.empty();
    }
    
    static {
        BIOME_ADVANCEMENTS = new HashMap<ResourceLocation, ResourceLocation[]>();
        BIOME_PROGRESSION_ENFORCEMENT = new HashMap<ResourceLocation, BiConsumer<PlayerEntity, World>>();
        registerBiomeAdvancementRestriction(BiomeKeys.DARK_FOREST, TwilightForestMod.prefix("progress_lich"));
        registerBiomeAdvancementRestriction(BiomeKeys.DARK_FOREST_CENTER, TwilightForestMod.prefix("progress_knights"));
        registerBiomeAdvancementRestriction(BiomeKeys.FINAL_PLATEAU, TwilightForestMod.prefix("progress_troll"));
        registerBiomeAdvancementRestriction(BiomeKeys.FIRE_SWAMP, TwilightForestMod.prefix("progress_labyrinth"));
        registerBiomeAdvancementRestriction(BiomeKeys.GLACIER, TwilightForestMod.prefix("progress_yeti"));
        registerBiomeAdvancementRestriction(BiomeKeys.HIGHLANDS, TwilightForestMod.prefix("progress_merge"));
        registerBiomeAdvancementRestriction(BiomeKeys.SNOWY_FOREST, TwilightForestMod.prefix("progress_lich"));
        registerBiomeAdvancementRestriction(BiomeKeys.SWAMP, TwilightForestMod.prefix("progress_lich"));
        registerBiomeAdvancementRestriction(BiomeKeys.THORNLANDS, TwilightForestMod.prefix("progress_troll"));
        registerBiomeProgressionEnforcement(BiomeKeys.DARK_FOREST, (player, world) -> {
            if (!world.field_72995_K && player.field_70173_aa % 60 == 0) {
                player.func_195064_c(new EffectInstance(Effects.field_76440_q, 100, 0));
                trySpawnHintMonster(player, world, TFFeature.KNIGHT_STRONGHOLD);
            }
            return;
        });
        registerBiomeProgressionEnforcement(BiomeKeys.DARK_FOREST_CENTER, (player, world) -> {
            if (!world.field_72995_K && player.field_70173_aa % 60 == 0) {
                player.func_195064_c(new EffectInstance(Effects.field_76440_q, 100, 0));
                trySpawnHintMonster(player, world, TFFeature.DARK_TOWER);
            }
            return;
        });
        registerBiomeProgressionEnforcement(BiomeKeys.FINAL_PLATEAU, (player, world) -> {
            if (!world.field_72995_K && player.field_70173_aa % 5 == 0) {
                player.func_70097_a(DamageSource.field_76376_m, 1.5f);
                world.func_184148_a((PlayerEntity)null, player.func_226277_ct_(), player.func_226278_cu_(), player.func_226281_cx_(), SoundEvents.field_187541_bC, SoundCategory.PLAYERS, 1.0f, 1.0f);
                trySpawnHintMonster(player, world, TFFeature.TROLL_CAVE);
            }
            return;
        });
        registerBiomeProgressionEnforcement(BiomeKeys.FIRE_SWAMP, (player, world) -> {
            if (!world.field_72995_K && player.field_70173_aa % 60 == 0) {
                player.func_70015_d(8);
            }
            trySpawnHintMonster(player, world, TFFeature.HYDRA_LAIR);
            return;
        });
        registerBiomeProgressionEnforcement(BiomeKeys.GLACIER, (player, world) -> {
            if (!world.field_72995_K && player.field_70173_aa % 60 == 0) {
                player.func_195064_c(new EffectInstance((Effect)TFPotions.frosty.get(), 100, 3));
            }
            trySpawnHintMonster(player, world, TFFeature.ICE_TOWER);
            return;
        });
        registerBiomeProgressionEnforcement(BiomeKeys.HIGHLANDS, (player, world) -> {
            if (!world.field_72995_K && player.field_70173_aa % 5 == 0) {
                player.func_70097_a(DamageSource.field_76376_m, 0.5f);
                world.func_184148_a((PlayerEntity)null, player.func_226277_ct_(), player.func_226278_cu_(), player.func_226281_cx_(), SoundEvents.field_187541_bC, SoundCategory.PLAYERS, 1.0f, 1.0f);
                trySpawnHintMonster(player, world, TFFeature.TROLL_CAVE);
            }
            return;
        });
        registerBiomeProgressionEnforcement(BiomeKeys.SNOWY_FOREST, (player, world) -> {
            if (!world.field_72995_K && player.field_70173_aa % 60 == 0) {
                player.func_195064_c(new EffectInstance((Effect)TFPotions.frosty.get(), 100, 2));
                trySpawnHintMonster(player, world, TFFeature.YETI_CAVE);
            }
            return;
        });
        registerBiomeProgressionEnforcement(BiomeKeys.SWAMP, (player, world) -> {
            if (!world.field_72995_K && player.field_70173_aa % 60 == 0) {
                final EffectInstance currentHunger = player.func_70660_b(Effects.field_76438_s);
                final int hungerLevel = (currentHunger != null) ? (currentHunger.func_76458_c() + 1) : 1;
                player.func_195064_c(new EffectInstance(Effects.field_76438_s, 100, hungerLevel));
                trySpawnHintMonster(player, world, TFFeature.LABYRINTH);
            }
            return;
        });
        registerBiomeProgressionEnforcement(BiomeKeys.THORNLANDS, (player, world) -> {
            if (!world.field_72995_K && player.field_70173_aa % 5 == 0) {
                player.func_70097_a(DamageSource.field_76376_m, 1.0f);
                world.func_184148_a((PlayerEntity)null, player.func_226277_ct_(), player.func_226278_cu_(), player.func_226281_cx_(), SoundEvents.field_187541_bC, SoundCategory.PLAYERS, 1.0f, 1.0f);
                trySpawnHintMonster(player, world, TFFeature.TROLL_CAVE);
            }
        });
    }
}
