// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.particle;

import net.minecraftforge.registries.ForgeRegistries;
import com.mojang.serialization.Codec;
import net.minecraft.particles.IParticleData;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.client.particle.ParticleManager;
import net.minecraft.client.particle.IParticleFactory;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import twilightforest.client.particle.data.LeafParticleData;
import twilightforest.client.particle.data.PinnedFireflyData;
import net.minecraft.particles.BasicParticleType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraft.particles.ParticleType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "twilightforest", bus = Mod.EventBusSubscriber.Bus.MOD, value = { Dist.CLIENT })
public class TFParticleType
{
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES;
    public static final RegistryObject<BasicParticleType> LARGE_FLAME;
    public static final RegistryObject<BasicParticleType> LEAF_RUNE;
    public static final RegistryObject<BasicParticleType> BOSS_TEAR;
    public static final RegistryObject<BasicParticleType> GHAST_TRAP;
    public static final RegistryObject<BasicParticleType> PROTECTION;
    public static final RegistryObject<BasicParticleType> SNOW;
    public static final RegistryObject<BasicParticleType> SNOW_WARNING;
    public static final RegistryObject<BasicParticleType> SNOW_GUARDIAN;
    public static final RegistryObject<BasicParticleType> ICE_BEAM;
    public static final RegistryObject<BasicParticleType> ANNIHILATE;
    public static final RegistryObject<BasicParticleType> HUGE_SMOKE;
    public static final RegistryObject<BasicParticleType> FIREFLY;
    public static final RegistryObject<ParticleType<PinnedFireflyData>> FIREFLY_PINNED;
    public static final RegistryObject<ParticleType<LeafParticleData>> FALLEN_LEAF;
    
    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void registerFactories(final ParticleFactoryRegisterEvent event) {
        final ParticleManager particles = Minecraft.func_71410_x().field_71452_i;
        particles.func_215234_a((ParticleType)TFParticleType.LARGE_FLAME.get(), LargeFlameParticle.Factory::new);
        particles.func_215234_a((ParticleType)TFParticleType.LEAF_RUNE.get(), LeafRuneParticle.Factory::new);
        particles.func_199283_a((ParticleType)TFParticleType.BOSS_TEAR.get(), (IParticleFactory)new GhastTearParticle.Factory());
        particles.func_215234_a((ParticleType)TFParticleType.GHAST_TRAP.get(), GhastTrapParticle.Factory::new);
        particles.func_215234_a((ParticleType)TFParticleType.PROTECTION.get(), ProtectionParticle.Factory::new);
        particles.func_215234_a((ParticleType)TFParticleType.SNOW.get(), SnowParticle.Factory::new);
        particles.func_215234_a((ParticleType)TFParticleType.SNOW_GUARDIAN.get(), SnowGuardianParticle.Factory::new);
        particles.func_215234_a((ParticleType)TFParticleType.SNOW_WARNING.get(), SnowWarningParticle.Factory::new);
        particles.func_215234_a((ParticleType)TFParticleType.ICE_BEAM.get(), IceBeamParticle.Factory::new);
        particles.func_215234_a((ParticleType)TFParticleType.ANNIHILATE.get(), AnnihilateParticle.Factory::new);
        particles.func_215234_a((ParticleType)TFParticleType.HUGE_SMOKE.get(), SmokeScaleParticle.Factory::new);
        particles.func_215234_a((ParticleType)TFParticleType.FIREFLY.get(), FireflyParticle.Factory::new);
        particles.func_215234_a((ParticleType)TFParticleType.FIREFLY_PINNED.get(), PinnedFireflyParticle.Factory::new);
        particles.func_215234_a((ParticleType)TFParticleType.FALLEN_LEAF.get(), LeafParticle.Factory::new);
    }
    
    static {
        PARTICLE_TYPES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, "twilightforest");
        LARGE_FLAME = TFParticleType.PARTICLE_TYPES.register("large_flame", () -> new BasicParticleType(false));
        LEAF_RUNE = TFParticleType.PARTICLE_TYPES.register("leaf_rune", () -> new BasicParticleType(false));
        BOSS_TEAR = TFParticleType.PARTICLE_TYPES.register("boss_tear", () -> new BasicParticleType(false));
        GHAST_TRAP = TFParticleType.PARTICLE_TYPES.register("ghast_trap", () -> new BasicParticleType(false));
        PROTECTION = TFParticleType.PARTICLE_TYPES.register("protection", () -> new BasicParticleType(true));
        SNOW = TFParticleType.PARTICLE_TYPES.register("snow", () -> new BasicParticleType(false));
        SNOW_WARNING = TFParticleType.PARTICLE_TYPES.register("snow_warning", () -> new BasicParticleType(false));
        SNOW_GUARDIAN = TFParticleType.PARTICLE_TYPES.register("snow_guardian", () -> new BasicParticleType(false));
        ICE_BEAM = TFParticleType.PARTICLE_TYPES.register("ice_beam", () -> new BasicParticleType(false));
        ANNIHILATE = TFParticleType.PARTICLE_TYPES.register("annihilate", () -> new BasicParticleType(false));
        HUGE_SMOKE = TFParticleType.PARTICLE_TYPES.register("huge_smoke", () -> new BasicParticleType(false));
        FIREFLY = TFParticleType.PARTICLE_TYPES.register("firefly", () -> new BasicParticleType(false));
        FIREFLY_PINNED = TFParticleType.PARTICLE_TYPES.register("firefly_pinned", () -> {
            new ParticleType<PinnedFireflyData>(false, new PinnedFireflyData.Deserializer()) {
                public Codec<PinnedFireflyData> func_230522_e_() {
                    return PinnedFireflyData.codecFirefly();
                }
            };
            return;
        });
        FALLEN_LEAF = TFParticleType.PARTICLE_TYPES.register("fallen_leaf", () -> {
            new ParticleType<LeafParticleData>(false, new LeafParticleData.Deserializer()) {
                public Codec<LeafParticleData> func_230522_e_() {
                    return LeafParticleData.codecLeaf();
                }
            };
            return;
        });
    }
}
