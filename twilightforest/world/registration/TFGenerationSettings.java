// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.registration;

import twilightforest.world.registration.biomes.BiomeKeys;
import java.util.HashMap;
import twilightforest.potions.TFMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.sounds.SoundSource;
import twilightforest.TFSounds;
import net.minecraft.world.damagesource.DamageSource;
import java.util.Iterator;
import net.minecraft.core.SectionPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.chunk.ChunkStatus;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.util.Mth;
import java.util.Optional;
import net.minecraft.world.level.levelgen.structure.StructureStart;
import twilightforest.world.components.structures.start.TFStructureStart;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.LevelAccessor;
import twilightforest.util.WorldUtil;
import net.minecraft.core.BlockPos;
import twilightforest.util.PlayerHelper;
import net.minecraft.core.Registry;
import net.minecraft.world.level.GameRules;
import twilightforest.TwilightForestMod;
import twilightforest.world.components.chunkgenerators.ChunkGeneratorTwilight;
import net.minecraft.server.level.ServerLevel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.client.Minecraft;
import twilightforest.TFConfig;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import java.util.function.BiConsumer;
import net.minecraft.resources.ResourceLocation;
import java.util.Map;

public class TFGenerationSettings
{
    private static final Map<ResourceLocation, ResourceLocation[]> BIOME_ADVANCEMENTS;
    private static final Map<ResourceLocation, BiConsumer<Player, Level>> BIOME_PROGRESSION_ENFORCEMENT;
    @Deprecated
    public static final int SEALEVEL = 0;
    
    private static void registerBiomeAdvancementRestriction(final ResourceKey<Biome> biome, final ResourceLocation... advancements) {
        TFGenerationSettings.BIOME_ADVANCEMENTS.put(biome.m_135782_(), advancements);
    }
    
    private static void registerBiomeProgressionEnforcement(final ResourceKey<Biome> biome, final BiConsumer<Player, Level> exec) {
        TFGenerationSettings.BIOME_PROGRESSION_ENFORCEMENT.put(biome.m_135782_(), exec);
    }
    
    public static void enforceBiomeProgression(final Player player, final Level world) {
        final Biome currentBiome = world.m_46857_(player.m_142538_());
        if (isBiomeSafeFor(currentBiome, (Entity)player)) {
            return;
        }
        final BiConsumer<Player, Level> exec = TFGenerationSettings.BIOME_PROGRESSION_ENFORCEMENT.get(currentBiome.getRegistryName());
        if (exec != null) {
            exec.accept(player, world);
        }
    }
    
    private static void trySpawnHintMonster(final Player player, final Level world, final TFFeature feature) {
        if (world.f_46441_.nextInt(4) == 0) {
            feature.trySpawnHintMonster(world, player);
        }
    }
    
    public static boolean isTwilightPortalDestination(final Level world) {
        return world.m_46472_().m_135782_().toString().equals(TFConfig.COMMON_CONFIG.DIMENSION.portalDestinationID.get());
    }
    
    @OnlyIn(Dist.CLIENT)
    public static boolean isTwilightWorldOnClient(final Level world) {
        return "twilightforest".equals(Minecraft.m_91087_().f_91073_.m_46472_().m_135782_().m_135827_()) || isTwilightPortalDestination(world);
    }
    
    public static boolean usesTwilightChunkGenerator(final ServerLevel world) {
        return world.m_7726_().f_8328_ instanceof ChunkGeneratorTwilight;
    }
    
    public static boolean isProgressionEnforced(final Level world) {
        return world.m_46469_().m_46207_((GameRules.Key)TwilightForestMod.ENFORCED_PROGRESSION_RULE);
    }
    
    public static boolean isBiomeSafeFor(final Biome biome, final Entity entity) {
        final ResourceLocation[] advancements = TFGenerationSettings.BIOME_ADVANCEMENTS.get(entity.f_19853_.m_5776_() ? entity.f_19853_.m_5962_().m_175515_(Registry.f_122885_).m_7981_((Object)biome) : biome.getRegistryName());
        return advancements == null || !(entity instanceof Player) || PlayerHelper.doesPlayerHaveRequiredAdvancements((Player)entity, advancements);
    }
    
    public static void markStructureConquered(final Level world, final BlockPos pos, final TFFeature feature) {
        final ChunkGeneratorTwilight generator = WorldUtil.getChunkGenerator((LevelAccessor)world);
        if (generator != null && TFFeature.getFeatureAt(pos.m_123341_(), pos.m_123343_(), (WorldGenLevel)world) == feature) {
            locateTFStructureInRange((WorldGenLevel)world, feature, pos, 0).ifPresent(start -> {
                final StructureStart s$temp = start;
                if (s$temp instanceof final TFStructureStart.Start s) {
                    s.setConquered(true);
                }
            });
        }
    }
    
    public static Optional<StructureStart<?>> locateTFStructureInRange(final WorldGenLevel world, final BlockPos pos, final int range) {
        final TFFeature featureCheck = TFFeature.getFeatureForRegionPos(pos.m_123341_(), pos.m_123343_(), world);
        return locateTFStructureInRange(world, featureCheck, pos, range);
    }
    
    public static Optional<StructureStart<?>> locateTFStructureInRange(final WorldGenLevel world, final TFFeature featureCheck, final BlockPos pos, final int range) {
        final int cx1 = Mth.m_14143_((float)(pos.m_123341_() - range >> 4));
        final int cx2 = Mth.m_14167_((float)(pos.m_123341_() + range >> 4));
        final int cz1 = Mth.m_14143_((float)(pos.m_123343_() - range >> 4));
        final int cz2 = Mth.m_14167_((float)(pos.m_123343_() + range >> 4));
        for (final StructureFeature<?> structureFeature : ForgeRegistries.STRUCTURE_FEATURES) {
            if (!(structureFeature instanceof TFStructureStart)) {
                continue;
            }
            final TFFeature feature = ((TFStructureStart)structureFeature).getFeature();
            if (feature != featureCheck) {
                continue;
            }
            for (int x = cx1; x <= cx2; ++x) {
                for (int z = cz1; z <= cz2; ++z) {
                    final Optional<StructureStart<?>> structure = world.m_46819_(x, z, ChunkStatus.f_62315_).m_6705_((StructureFeature)structureFeature).stream().map(longVal -> SectionPos.m_123196_(new ChunkPos((long)longVal), 0)).map(sectionPos -> world.m_7232_(sectionPos.m_123170_(), sectionPos.m_123222_()) ? world.m_46819_(sectionPos.m_123170_(), sectionPos.m_123222_(), ChunkStatus.f_62315_).m_7253_(structureFeature) : null).filter(structureStart -> structureStart != null && structureStart.m_73603_()).findFirst();
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
        BIOME_PROGRESSION_ENFORCEMENT = new HashMap<ResourceLocation, BiConsumer<Player, Level>>();
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
            if (!world.f_46443_ && player.f_19797_ % 60 == 0) {
                player.m_7292_(new MobEffectInstance(MobEffects.f_19610_, 100, 0, false, true));
                trySpawnHintMonster(player, world, TFFeature.KNIGHT_STRONGHOLD);
            }
            return;
        });
        registerBiomeProgressionEnforcement(BiomeKeys.DARK_FOREST_CENTER, (player, world) -> {
            if (!world.f_46443_ && player.f_19797_ % 60 == 0) {
                player.m_7292_(new MobEffectInstance(MobEffects.f_19610_, 100, 0, false, true));
                trySpawnHintMonster(player, world, TFFeature.DARK_TOWER);
            }
            return;
        });
        registerBiomeProgressionEnforcement(BiomeKeys.FINAL_PLATEAU, (player, world) -> {
            if (!world.f_46443_ && player.f_19797_ % 5 == 0) {
                player.m_6469_(DamageSource.f_19319_, 1.5f);
                world.m_6263_((Player)null, player.m_20185_(), player.m_20186_(), player.m_20189_(), TFSounds.ACID_RAIN_BURNS, SoundSource.PLAYERS, 1.0f, 1.0f);
                trySpawnHintMonster(player, world, TFFeature.TROLL_CAVE);
            }
            return;
        });
        registerBiomeProgressionEnforcement(BiomeKeys.FIRE_SWAMP, (player, world) -> {
            if (!world.f_46443_ && player.f_19797_ % 60 == 0) {
                player.m_20254_(8);
            }
            trySpawnHintMonster(player, world, TFFeature.HYDRA_LAIR);
            return;
        });
        registerBiomeProgressionEnforcement(BiomeKeys.GLACIER, (player, world) -> {
            if (!world.f_46443_ && player.f_19797_ % 60 == 0) {
                player.m_7292_(new MobEffectInstance((MobEffect)TFMobEffects.FROSTY.get(), 100, 3, false, true));
            }
            trySpawnHintMonster(player, world, TFFeature.ICE_TOWER);
            return;
        });
        registerBiomeProgressionEnforcement(BiomeKeys.HIGHLANDS, (player, world) -> {
            if (!world.f_46443_ && player.f_19797_ % 5 == 0) {
                player.m_6469_(DamageSource.f_19319_, 0.5f);
                world.m_6263_((Player)null, player.m_20185_(), player.m_20186_(), player.m_20189_(), TFSounds.ACID_RAIN_BURNS, SoundSource.PLAYERS, 1.0f, 1.0f);
                trySpawnHintMonster(player, world, TFFeature.TROLL_CAVE);
            }
            return;
        });
        registerBiomeProgressionEnforcement(BiomeKeys.SNOWY_FOREST, (player, world) -> {
            if (!world.f_46443_ && player.f_19797_ % 60 == 0) {
                player.m_7292_(new MobEffectInstance((MobEffect)TFMobEffects.FROSTY.get(), 100, 2, false, true));
                trySpawnHintMonster(player, world, TFFeature.YETI_CAVE);
            }
            return;
        });
        registerBiomeProgressionEnforcement(BiomeKeys.SWAMP, (player, world) -> {
            if (!world.f_46443_ && player.f_19797_ % 60 == 0) {
                final MobEffectInstance currentHunger = player.m_21124_(MobEffects.f_19612_);
                final int hungerLevel = (currentHunger != null) ? (currentHunger.m_19564_() + 1) : 1;
                player.m_7292_(new MobEffectInstance(MobEffects.f_19612_, 100, hungerLevel, false, true));
                trySpawnHintMonster(player, world, TFFeature.LABYRINTH);
            }
            return;
        });
        registerBiomeProgressionEnforcement(BiomeKeys.THORNLANDS, (player, world) -> {
            if (!world.f_46443_ && player.f_19797_ % 5 == 0) {
                player.m_6469_(DamageSource.f_19319_, 1.0f);
                world.m_6263_((Player)null, player.m_20185_(), player.m_20186_(), player.m_20189_(), TFSounds.ACID_RAIN_BURNS, SoundSource.PLAYERS, 1.0f, 1.0f);
                trySpawnHintMonster(player, world, TFFeature.TROLL_CAVE);
            }
        });
    }
}
