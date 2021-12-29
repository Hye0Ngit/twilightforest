// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.particle;

import net.minecraftforge.registries.ForgeRegistries;
import com.mojang.serialization.Codec;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.client.particle.ParticleEngine;
import net.minecraft.client.particle.FlameParticle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import twilightforest.client.particle.data.LeafParticleData;
import twilightforest.client.particle.data.PinnedFireflyData;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraft.core.particles.ParticleType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "twilightforest", bus = Mod.EventBusSubscriber.Bus.MOD, value = { Dist.CLIENT })
public class TFParticleType
{
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES;
    public static final RegistryObject<SimpleParticleType> LARGE_FLAME;
    public static final RegistryObject<SimpleParticleType> LEAF_RUNE;
    public static final RegistryObject<SimpleParticleType> BOSS_TEAR;
    public static final RegistryObject<SimpleParticleType> GHAST_TRAP;
    public static final RegistryObject<SimpleParticleType> PROTECTION;
    public static final RegistryObject<SimpleParticleType> SNOW;
    public static final RegistryObject<SimpleParticleType> SNOW_WARNING;
    public static final RegistryObject<SimpleParticleType> SNOW_GUARDIAN;
    public static final RegistryObject<SimpleParticleType> ICE_BEAM;
    public static final RegistryObject<SimpleParticleType> ANNIHILATE;
    public static final RegistryObject<SimpleParticleType> HUGE_SMOKE;
    public static final RegistryObject<SimpleParticleType> FIREFLY;
    public static final RegistryObject<SimpleParticleType> WANDERING_FIREFLY;
    public static final RegistryObject<SimpleParticleType> JAR_WANDERING_FIREFLY;
    public static final RegistryObject<ParticleType<PinnedFireflyData>> FIREFLY_PINNED;
    public static final RegistryObject<ParticleType<LeafParticleData>> FALLEN_LEAF;
    public static final RegistryObject<SimpleParticleType> OMINOUS_FLAME;
    
    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void registerFactories(final ParticleFactoryRegisterEvent event) {
        final ParticleEngine particles = Minecraft.m_91087_().f_91061_;
        particles.m_107378_((ParticleType)TFParticleType.LARGE_FLAME.get(), LargeFlameParticle.Factory::new);
        particles.m_107378_((ParticleType)TFParticleType.LEAF_RUNE.get(), LeafRuneParticle.Factory::new);
        particles.m_107381_((ParticleType)TFParticleType.BOSS_TEAR.get(), (ParticleProvider)new GhastTearParticle.Factory());
        particles.m_107378_((ParticleType)TFParticleType.GHAST_TRAP.get(), GhastTrapParticle.Factory::new);
        particles.m_107378_((ParticleType)TFParticleType.PROTECTION.get(), ProtectionParticle.Factory::new);
        particles.m_107378_((ParticleType)TFParticleType.SNOW.get(), SnowParticle.Factory::new);
        particles.m_107378_((ParticleType)TFParticleType.SNOW_GUARDIAN.get(), SnowGuardianParticle.Factory::new);
        particles.m_107378_((ParticleType)TFParticleType.SNOW_WARNING.get(), SnowWarningParticle.Factory::new);
        particles.m_107378_((ParticleType)TFParticleType.ICE_BEAM.get(), IceBeamParticle.Factory::new);
        particles.m_107378_((ParticleType)TFParticleType.ANNIHILATE.get(), AnnihilateParticle.Factory::new);
        particles.m_107378_((ParticleType)TFParticleType.HUGE_SMOKE.get(), SmokeScaleParticle.Factory::new);
        particles.m_107378_((ParticleType)TFParticleType.FIREFLY.get(), FireflyParticle.Factory::new);
        particles.m_107378_((ParticleType)TFParticleType.WANDERING_FIREFLY.get(), WanderingFireflyParticle.Factory::new);
        particles.m_107378_((ParticleType)TFParticleType.JAR_WANDERING_FIREFLY.get(), WanderingFireflyParticle.FromJarFactory::new);
        particles.m_107378_((ParticleType)TFParticleType.FIREFLY_PINNED.get(), PinnedFireflyParticle.Factory::new);
        particles.m_107378_((ParticleType)TFParticleType.FALLEN_LEAF.get(), LeafParticle.Factory::new);
        particles.m_107378_((ParticleType)TFParticleType.OMINOUS_FLAME.get(), FlameParticle.SmallFlameProvider::new);
    }
    
    static {
        PARTICLE_TYPES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, "twilightforest");
        LARGE_FLAME = TFParticleType.PARTICLE_TYPES.register("large_flame", () -> new SimpleParticleType(false));
        LEAF_RUNE = TFParticleType.PARTICLE_TYPES.register("leaf_rune", () -> new SimpleParticleType(false));
        BOSS_TEAR = TFParticleType.PARTICLE_TYPES.register("boss_tear", () -> new SimpleParticleType(false));
        GHAST_TRAP = TFParticleType.PARTICLE_TYPES.register("ghast_trap", () -> new SimpleParticleType(false));
        PROTECTION = TFParticleType.PARTICLE_TYPES.register("protection", () -> new SimpleParticleType(true));
        SNOW = TFParticleType.PARTICLE_TYPES.register("snow", () -> new SimpleParticleType(false));
        SNOW_WARNING = TFParticleType.PARTICLE_TYPES.register("snow_warning", () -> new SimpleParticleType(false));
        SNOW_GUARDIAN = TFParticleType.PARTICLE_TYPES.register("snow_guardian", () -> new SimpleParticleType(false));
        ICE_BEAM = TFParticleType.PARTICLE_TYPES.register("ice_beam", () -> new SimpleParticleType(false));
        ANNIHILATE = TFParticleType.PARTICLE_TYPES.register("annihilate", () -> new SimpleParticleType(false));
        HUGE_SMOKE = TFParticleType.PARTICLE_TYPES.register("huge_smoke", () -> new SimpleParticleType(false));
        FIREFLY = TFParticleType.PARTICLE_TYPES.register("firefly", () -> new SimpleParticleType(false));
        WANDERING_FIREFLY = TFParticleType.PARTICLE_TYPES.register("wandering_firefly", () -> new SimpleParticleType(false));
        JAR_WANDERING_FIREFLY = TFParticleType.PARTICLE_TYPES.register("jar_wandering_firefly", () -> new SimpleParticleType(false));
        FIREFLY_PINNED = TFParticleType.PARTICLE_TYPES.register("firefly_pinned", () -> {
            new ParticleType<PinnedFireflyData>(false, new PinnedFireflyData.Deserializer()) {
                public Codec<PinnedFireflyData> m_7652_() {
                    return PinnedFireflyData.codecFirefly();
                }
            };
            return;
        });
        FALLEN_LEAF = TFParticleType.PARTICLE_TYPES.register("fallen_leaf", () -> {
            new ParticleType<LeafParticleData>(false, new LeafParticleData.Deserializer()) {
                public Codec<LeafParticleData> m_7652_() {
                    return LeafParticleData.codecLeaf();
                }
            };
            return;
        });
        OMINOUS_FLAME = TFParticleType.PARTICLE_TYPES.register("ominous_flame", () -> new SimpleParticleType(false));
    }
}
