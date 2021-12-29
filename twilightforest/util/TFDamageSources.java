// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.util;

import net.minecraft.world.damagesource.IndirectEntityDamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.EntityDamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.damagesource.DamageSource;

public class TFDamageSources
{
    public static final DamageSource GHAST_TEAR;
    public static final DamageSource HYDRA_BITE;
    public static final DamageSource HYDRA_FIRE;
    public static final DamageSource LICH_BOLT;
    public static final DamageSource LICH_BOMB;
    public static final DamageSource CHILLING_BREATH;
    public static final DamageSource SQUISH;
    public static final DamageSource THROWN_AXE;
    public static final DamageSource THROWN_PICKAXE;
    public static final DamageSource THORNS;
    public static final DamageSource KNIGHTMETAL;
    public static final DamageSource FIERY;
    public static final DamageSource FIRE_JET;
    public static final DamageSource REACTOR;
    public static final DamageSource SLIDER;
    
    public static DamageSource axing(final LivingEntity mob) {
        return (DamageSource)new EntityDamageSource(tfSource("axing"), (Entity)mob);
    }
    
    public static DamageSource yeeted(final LivingEntity mob) {
        return (DamageSource)new EntityDamageSource(tfSource("yeeted"), (Entity)mob);
    }
    
    public static DamageSource ant(final LivingEntity mob) {
        return (DamageSource)new EntityDamageSource(tfSource("ant"), (Entity)mob);
    }
    
    public static DamageSource haunt(final LivingEntity mob) {
        return (DamageSource)new EntityDamageSource(tfSource("haunt"), (Entity)mob);
    }
    
    public static DamageSource clamped(final LivingEntity mob) {
        return (DamageSource)new EntityDamageSource(tfSource("clamped"), (Entity)mob);
    }
    
    public static DamageSource scorched(final LivingEntity mob) {
        return (DamageSource)new EntityDamageSource(tfSource("scorched"), (Entity)mob);
    }
    
    public static DamageSource frozen(final Entity source, final LivingEntity mob) {
        return (DamageSource)new IndirectEntityDamageSource(tfSource("frozen"), source, (Entity)mob);
    }
    
    public static DamageSource spiked(final Entity source, final LivingEntity mob) {
        return (DamageSource)new IndirectEntityDamageSource(tfSource("spiked"), source, (Entity)mob);
    }
    
    public static DamageSource leafBrain(final Entity source, final LivingEntity mob) {
        return new IndirectEntityDamageSource(tfSource("leafBrain"), source, (Entity)mob).m_19366_().m_19380_().m_19389_();
    }
    
    public static DamageSource lostWords(final Entity source, final LivingEntity mob) {
        return new IndirectEntityDamageSource(tfSource("lostWords"), source, (Entity)mob).m_19366_().m_19380_().m_19389_();
    }
    
    public static DamageSource schooled(final Entity source, final LivingEntity mob) {
        return new IndirectEntityDamageSource(tfSource("schooled"), source, (Entity)mob).m_19366_().m_19380_().m_19389_();
    }
    
    public static DamageSource snowballFight(final Entity source, final LivingEntity mob) {
        return new IndirectEntityDamageSource(tfSource("snowballFight"), source, (Entity)mob).m_19366_();
    }
    
    public static String tfSource(final String name) {
        return "twilightforest." + name;
    }
    
    static {
        GHAST_TEAR = new DamageSource(tfSource("ghastTear"));
        HYDRA_BITE = new DamageSource(tfSource("hydraBite"));
        HYDRA_FIRE = new DamageSource(tfSource("hydraFire"));
        LICH_BOLT = new DamageSource(tfSource("lichBolt")).m_19366_().m_19380_().m_19389_();
        LICH_BOMB = new DamageSource(tfSource("lichBomb")).m_19366_().m_19380_().m_19389_();
        CHILLING_BREATH = new DamageSource(tfSource("chillingBreath"));
        SQUISH = new DamageSource(tfSource("squish"));
        THROWN_AXE = new DamageSource(tfSource("thrownAxe")).m_19366_();
        THROWN_PICKAXE = new DamageSource(tfSource("thrownPickaxe")).m_19366_();
        THORNS = new DamageSource(tfSource("thorns"));
        KNIGHTMETAL = new DamageSource(tfSource("knightmetal"));
        FIERY = new DamageSource(tfSource("fiery"));
        FIRE_JET = new DamageSource(tfSource("fireJet"));
        REACTOR = new DamageSource(tfSource("reactor"));
        SLIDER = new DamageSource(tfSource("slider"));
    }
}
