// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import twilightforest.entity.boss.EntityTFYetiAlpha;
import twilightforest.entity.boss.EntityTFUrGhast;
import twilightforest.entity.boss.EntityTFSnowQueen;
import twilightforest.entity.boss.EntityTFNaga;
import twilightforest.entity.boss.EntityTFMinoshroom;
import twilightforest.entity.boss.EntityTFLich;
import twilightforest.entity.boss.EntityTFKnightPhantom;
import twilightforest.entity.boss.EntityTFHydra;
import twilightforest.entity.EntityTFDeathTome;
import twilightforest.entity.EntityTFTowerTermite;
import twilightforest.entity.EntityTFMiniGhast;
import twilightforest.entity.EntityTFTowerGhast;
import twilightforest.entity.EntityTFSkeletonDruid;
import twilightforest.entity.EntityTFWinterWolf;
import twilightforest.entity.EntityTFHostileWolf;
import twilightforest.entity.EntityTFTowerBroodling;
import twilightforest.entity.EntityTFSwarmSpider;
import twilightforest.entity.EntityTFHedgeSpider;
import twilightforest.entity.EntityTFKingSpider;
import twilightforest.entity.EntityTFMinotaur;
import net.minecraft.init.SoundEvents;
import twilightforest.entity.EntityTFLoyalZombie;
import twilightforest.entity.EntityTFSnowGuardian;
import twilightforest.entity.EntityTFIceShooter;
import twilightforest.entity.EntityTFIceExploder;
import twilightforest.entity.EntityTFMosquitoSwarm;
import twilightforest.entity.EntityTFWraith;
import twilightforest.entity.EntityTFBoggard;
import twilightforest.entity.EntityTFBlockGoblin;
import twilightforest.entity.EntityTFRedcapSapper;
import twilightforest.entity.EntityTFRedcap;
import net.minecraft.entity.passive.EntityParrot;
import twilightforest.entity.EntityTFKobold;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistryEntry;
import net.minecraftforge.event.RegistryEvent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "twilightforest")
public final class TFSounds
{
    public static final SoundEvent KOBOLD_DEATH;
    public static final SoundEvent KOBOLD_AMBIENT;
    public static final SoundEvent KOBOLD_HURT;
    public static final SoundEvent KOBOLD_PARROT;
    public static final SoundEvent CICADA;
    public static final SoundEvent NAGA_HISS;
    public static final SoundEvent NAGA_HURT;
    public static final SoundEvent NAGA_RATTLE;
    public static final SoundEvent NAGA_PARROT;
    public static final SoundEvent RAVEN_CAW;
    public static final SoundEvent RAVEN_SQUAWK;
    public static final SoundEvent REDCAP_DEATH;
    public static final SoundEvent REDCAP_AMBIENT;
    public static final SoundEvent REDCAP_HURT;
    public static final SoundEvent REDCAP_PARROT;
    public static final SoundEvent TINYBIRD_CHIRP;
    public static final SoundEvent TINYBIRD_HURT;
    public static final SoundEvent TINYBIRD_SONG;
    public static final SoundEvent URGHAST_TRAP_ACTIVE;
    public static final SoundEvent URGHAST_TRAP_ON;
    public static final SoundEvent URGHAST_TRAP_SPINDOWN;
    public static final SoundEvent URGHAST_TRAP_WARMUP;
    public static final SoundEvent WRAITH;
    public static final SoundEvent WRAITH_PARROT;
    public static final SoundEvent HYDRA_HURT;
    public static final SoundEvent HYDRA_DEATH;
    public static final SoundEvent HYDRA_GROWL;
    public static final SoundEvent HYDRA_ROAR;
    public static final SoundEvent HYDRA_WARN;
    public static final SoundEvent HYDRA_PARROT;
    public static final SoundEvent MOSQUITO;
    public static final SoundEvent MOSQUITO_PARROT;
    public static final SoundEvent ICE_AMBIENT;
    public static final SoundEvent ICE_HURT;
    public static final SoundEvent ICE_DEATH;
    public static final SoundEvent ICE_PARROT;
    public static final SoundEvent MINOTAUR_PARROT;
    public static final SoundEvent ALPHAYETI_ALERT;
    public static final SoundEvent ALPHAYETI_DIE;
    public static final SoundEvent ALPHAYETI_GRAB;
    public static final SoundEvent ALPHAYETI_GROWL;
    public static final SoundEvent ALPHAYETI_HURT;
    public static final SoundEvent ALPHAYETI_PANT;
    public static final SoundEvent ALPHAYETI_ROAR;
    public static final SoundEvent ALPHAYETI_THROW;
    public static final SoundEvent ALPHAYETI_PARROT;
    public static final SoundEvent DEER_DEATH;
    public static final SoundEvent DEER_HURT;
    public static final SoundEvent DEER_IDLE;
    public static final SoundEvent MISTWOLF_TARGET;
    public static final SoundEvent MISTWOLF_HURT;
    public static final SoundEvent MISTWOLF_IDLE;
    public static final SoundEvent MISTWOLF_PARROT;
    public static final SoundEvent TOME_DEATH;
    public static final SoundEvent TOME_HURT;
    public static final SoundEvent TOME_IDLE;
    public static final SoundEvent TOME_PARROT;
    public static final SoundEvent SLIDER;
    public static final SoundEvent MUSIC;
    
    private static SoundEvent createEvent(final String sound) {
        final ResourceLocation name = TwilightForestMod.prefix(sound);
        return (SoundEvent)new SoundEvent(name).setRegistryName(name);
    }
    
    @SubscribeEvent
    public static void registerSounds(final RegistryEvent.Register<SoundEvent> event) {
        event.getRegistry().registerAll((IForgeRegistryEntry[])new SoundEvent[] { TFSounds.KOBOLD_DEATH, TFSounds.KOBOLD_AMBIENT, TFSounds.KOBOLD_HURT, TFSounds.KOBOLD_PARROT, TFSounds.CICADA, TFSounds.NAGA_HISS, TFSounds.NAGA_HURT, TFSounds.NAGA_RATTLE, TFSounds.NAGA_PARROT, TFSounds.RAVEN_CAW, TFSounds.RAVEN_SQUAWK, TFSounds.REDCAP_DEATH, TFSounds.REDCAP_AMBIENT, TFSounds.REDCAP_HURT, TFSounds.REDCAP_PARROT, TFSounds.TINYBIRD_CHIRP, TFSounds.TINYBIRD_HURT, TFSounds.TINYBIRD_SONG, TFSounds.URGHAST_TRAP_ACTIVE, TFSounds.URGHAST_TRAP_ON, TFSounds.URGHAST_TRAP_SPINDOWN, TFSounds.URGHAST_TRAP_WARMUP, TFSounds.WRAITH, TFSounds.WRAITH_PARROT, TFSounds.HYDRA_DEATH, TFSounds.HYDRA_GROWL, TFSounds.HYDRA_HURT, TFSounds.HYDRA_ROAR, TFSounds.HYDRA_WARN, TFSounds.HYDRA_PARROT, TFSounds.MOSQUITO, TFSounds.MOSQUITO_PARROT, TFSounds.ICE_AMBIENT, TFSounds.ICE_DEATH, TFSounds.ICE_HURT, TFSounds.ICE_PARROT, TFSounds.MINOTAUR_PARROT, TFSounds.ALPHAYETI_ALERT, TFSounds.ALPHAYETI_DIE, TFSounds.ALPHAYETI_GRAB, TFSounds.ALPHAYETI_GROWL, TFSounds.ALPHAYETI_HURT, TFSounds.ALPHAYETI_PANT, TFSounds.ALPHAYETI_ROAR, TFSounds.ALPHAYETI_THROW, TFSounds.ALPHAYETI_PARROT, TFSounds.DEER_DEATH, TFSounds.DEER_HURT, TFSounds.DEER_IDLE, TFSounds.MISTWOLF_TARGET, TFSounds.MISTWOLF_HURT, TFSounds.MISTWOLF_IDLE, TFSounds.MISTWOLF_PARROT, TFSounds.TOME_DEATH, TFSounds.TOME_HURT, TFSounds.TOME_IDLE, TFSounds.TOME_PARROT, TFSounds.SLIDER, TFSounds.MUSIC });
        registerParrotSounds();
    }
    
    private static void registerParrotSounds() {
        EntityParrot.registerMimicSound((Class)EntityTFKobold.class, TFSounds.KOBOLD_PARROT);
        EntityParrot.registerMimicSound((Class)EntityTFRedcap.class, TFSounds.REDCAP_PARROT);
        EntityParrot.registerMimicSound((Class)EntityTFRedcapSapper.class, TFSounds.REDCAP_PARROT);
        EntityParrot.registerMimicSound((Class)EntityTFBlockGoblin.class, TFSounds.REDCAP_PARROT);
        EntityParrot.registerMimicSound((Class)EntityTFBoggard.class, TFSounds.REDCAP_PARROT);
        EntityParrot.registerMimicSound((Class)EntityTFWraith.class, TFSounds.WRAITH_PARROT);
        EntityParrot.registerMimicSound((Class)EntityTFMosquitoSwarm.class, TFSounds.MOSQUITO_PARROT);
        EntityParrot.registerMimicSound((Class)EntityTFIceExploder.class, TFSounds.ICE_PARROT);
        EntityParrot.registerMimicSound((Class)EntityTFIceShooter.class, TFSounds.ICE_PARROT);
        EntityParrot.registerMimicSound((Class)EntityTFSnowGuardian.class, TFSounds.ICE_PARROT);
        EntityParrot.registerMimicSound((Class)EntityTFLoyalZombie.class, SoundEvents.field_193821_fk);
        EntityParrot.registerMimicSound((Class)EntityTFMinotaur.class, TFSounds.MINOTAUR_PARROT);
        EntityParrot.registerMimicSound((Class)EntityTFKingSpider.class, SoundEvents.field_193813_fc);
        EntityParrot.registerMimicSound((Class)EntityTFHedgeSpider.class, SoundEvents.field_193813_fc);
        EntityParrot.registerMimicSound((Class)EntityTFSwarmSpider.class, SoundEvents.field_193813_fc);
        EntityParrot.registerMimicSound((Class)EntityTFTowerBroodling.class, SoundEvents.field_193813_fc);
        EntityParrot.registerMimicSound((Class)EntityTFHostileWolf.class, TFSounds.MISTWOLF_PARROT);
        EntityParrot.registerMimicSound((Class)EntityTFWinterWolf.class, TFSounds.MISTWOLF_PARROT);
        EntityParrot.registerMimicSound((Class)EntityTFSkeletonDruid.class, SoundEvents.field_193811_fa);
        EntityParrot.registerMimicSound((Class)EntityTFTowerGhast.class, SoundEvents.field_193798_eT);
        EntityParrot.registerMimicSound((Class)EntityTFMiniGhast.class, SoundEvents.field_193798_eT);
        EntityParrot.registerMimicSound((Class)EntityTFTowerTermite.class, SoundEvents.field_193804_eZ);
        EntityParrot.registerMimicSound((Class)EntityTFDeathTome.class, TFSounds.TOME_PARROT);
        EntityParrot.registerMimicSound((Class)EntityTFHydra.class, TFSounds.HYDRA_PARROT);
        EntityParrot.registerMimicSound((Class)EntityTFKnightPhantom.class, TFSounds.WRAITH_PARROT);
        EntityParrot.registerMimicSound((Class)EntityTFLich.class, SoundEvents.field_193791_eM);
        EntityParrot.registerMimicSound((Class)EntityTFMinoshroom.class, TFSounds.MINOTAUR_PARROT);
        EntityParrot.registerMimicSound((Class)EntityTFNaga.class, TFSounds.NAGA_PARROT);
        EntityParrot.registerMimicSound((Class)EntityTFSnowQueen.class, TFSounds.ICE_PARROT);
        EntityParrot.registerMimicSound((Class)EntityTFUrGhast.class, SoundEvents.field_193798_eT);
        EntityParrot.registerMimicSound((Class)EntityTFYetiAlpha.class, TFSounds.ALPHAYETI_PARROT);
    }
    
    private TFSounds() {
    }
    
    static {
        KOBOLD_DEATH = createEvent("mob.kobold.die");
        KOBOLD_AMBIENT = createEvent("mob.kobold.kobold");
        KOBOLD_HURT = createEvent("mob.kobold.hurt");
        KOBOLD_PARROT = createEvent("mob.kobold.parrot");
        CICADA = createEvent("mob.cicada");
        NAGA_HISS = createEvent("mob.naga.hiss");
        NAGA_HURT = createEvent("mob.naga.hurt");
        NAGA_RATTLE = createEvent("mob.naga.rattle");
        NAGA_PARROT = createEvent("mob.naga.parrot");
        RAVEN_CAW = createEvent("mob.raven.caw");
        RAVEN_SQUAWK = createEvent("mob.raven.squawk");
        REDCAP_DEATH = createEvent("mob.redcap.die");
        REDCAP_AMBIENT = createEvent("mob.redcap.redcap");
        REDCAP_HURT = createEvent("mob.redcap.hurt");
        REDCAP_PARROT = createEvent("mob.redcap.parrot");
        TINYBIRD_CHIRP = createEvent("mob.tinybird.chirp");
        TINYBIRD_HURT = createEvent("mob.tinybird.hurt");
        TINYBIRD_SONG = createEvent("mob.tinybird.song");
        URGHAST_TRAP_ACTIVE = createEvent("mob.urghast.trapactive");
        URGHAST_TRAP_ON = createEvent("mob.urghast.trapon");
        URGHAST_TRAP_SPINDOWN = createEvent("mob.urghast.trapspindown");
        URGHAST_TRAP_WARMUP = createEvent("mob.urghast.trapwarmup");
        WRAITH = createEvent("mob.wraith.wraith");
        WRAITH_PARROT = createEvent("mob.wraith.parrot");
        HYDRA_HURT = createEvent("mob.hydra.hurt");
        HYDRA_DEATH = createEvent("mob.hydra.death");
        HYDRA_GROWL = createEvent("mob.hydra.growl");
        HYDRA_ROAR = createEvent("mob.hydra.roar");
        HYDRA_WARN = createEvent("mob.hydra.warn");
        HYDRA_PARROT = createEvent("mob.hydra.parrot");
        MOSQUITO = createEvent("mob.mosquito.mosquito");
        MOSQUITO_PARROT = createEvent("mob.mosquito.parrot");
        ICE_AMBIENT = createEvent("mob.ice.noise");
        ICE_HURT = createEvent("mob.ice.hurt");
        ICE_DEATH = createEvent("mob.ice.death");
        ICE_PARROT = createEvent("mob.ice.parrot");
        MINOTAUR_PARROT = createEvent("mob.minotaur.parrot");
        ALPHAYETI_ALERT = createEvent("mob.alphayeti.alert");
        ALPHAYETI_DIE = createEvent("mob.alphayeti.die");
        ALPHAYETI_GRAB = createEvent("mob.alphayeti.grab");
        ALPHAYETI_GROWL = createEvent("mob.alphayeti.growl");
        ALPHAYETI_HURT = createEvent("mob.alphayeti.hurt");
        ALPHAYETI_PANT = createEvent("mob.alphayeti.pant");
        ALPHAYETI_ROAR = createEvent("mob.alphayeti.roar");
        ALPHAYETI_THROW = createEvent("mob.alphayeti.throw");
        ALPHAYETI_PARROT = createEvent("mob.alphayeti.parrot");
        DEER_DEATH = createEvent("mob.deer.death");
        DEER_HURT = createEvent("mob.deer.hurt");
        DEER_IDLE = createEvent("mob.deer.idle");
        MISTWOLF_TARGET = createEvent("mob.mistwolf.target");
        MISTWOLF_HURT = createEvent("mob.mistwolf.hurt");
        MISTWOLF_IDLE = createEvent("mob.mistwolf.idle");
        MISTWOLF_PARROT = createEvent("mob.mistwolf.parrot");
        TOME_DEATH = createEvent("mob.tome.death");
        TOME_HURT = createEvent("mob.tome.hurt");
        TOME_IDLE = createEvent("mob.tome.idle");
        TOME_PARROT = createEvent("mob.tome.parrot");
        SLIDER = createEvent("random.slider");
        MUSIC = createEvent("music.bg");
    }
}
