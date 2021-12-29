// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.particle;

import java.util.EnumMap;
import net.minecraft.init.Items;
import javax.annotation.Nullable;
import net.minecraft.client.particle.Particle;
import net.minecraft.world.World;
import java.util.Map;

public class TFParticleFactory
{
    private static final Map<TFParticleType, IParticleFactory> factories;
    
    @Nullable
    public static Particle createParticle(final TFParticleType particleType, final World world, final double x, final double y, final double z, final double vx, final double vy, final double vz) {
        final IParticleFactory factory = TFParticleFactory.factories.get(particleType);
        return (factory != null) ? factory.createParticle(world, x, y, z, vx, vy, vz) : null;
    }
    
    static {
        (factories = new EnumMap<TFParticleType, IParticleFactory>(TFParticleType.class)).put(TFParticleType.LARGE_FLAME, ParticleLargeFlame::new);
        TFParticleFactory.factories.put(TFParticleType.LEAF_RUNE, ParticleLeafRune::new);
        TFParticleFactory.factories.put(TFParticleType.BOSS_TEAR, (world, x, y, z, vx, vy, vz) -> new ParticleGhastTear(world, x, y, z, vx, vy, vz, Items.field_151073_bk));
        TFParticleFactory.factories.put(TFParticleType.GHAST_TRAP, ParticleGhastTrap::new);
        TFParticleFactory.factories.put(TFParticleType.PROTECTION, ParticleProtection::new);
        TFParticleFactory.factories.put(TFParticleType.SNOW, ParticleSnow::new);
        TFParticleFactory.factories.put(TFParticleType.SNOW_GUARDIAN, (world, x, y, z, vx, vy, vz) -> new ParticleSnowGuardian(world, x, y, z, vx, vy, vz, 0.75f));
        TFParticleFactory.factories.put(TFParticleType.SNOW_WARNING, (world, x, y, z, vx, vy, vz) -> new ParticleSnowWarning(world, x, y, z, vx, vy, vz, 1.0f));
        TFParticleFactory.factories.put(TFParticleType.ICE_BEAM, (world, x, y, z, vx, vy, vz) -> new ParticleIceBeam(world, x, y, z, vx, vy, vz, 0.75f));
        TFParticleFactory.factories.put(TFParticleType.ANNIHILATE, (world, x, y, z, vx, vy, vz) -> new ParticleAnnihilate(world, x, y, z, vx, vy, vz, 0.75f));
        TFParticleFactory.factories.put(TFParticleType.HUGE_SMOKE, (world, x, y, z, vx, vy, vz) -> new ParticleSmokeScale(world, x, y, z, vx, vy, vz, 4.0f + world.field_73012_v.nextFloat()));
        TFParticleFactory.factories.put(TFParticleType.FIREFLY, ParticleFirefly::new);
        TFParticleFactory.factories.put(TFParticleType.FALLEN_LEAF, ParticleLeaf::new);
    }
    
    @FunctionalInterface
    private interface IParticleFactory
    {
        Particle createParticle(final World p0, final double p1, final double p2, final double p3, final double p4, final double p5, final double p6);
    }
}
