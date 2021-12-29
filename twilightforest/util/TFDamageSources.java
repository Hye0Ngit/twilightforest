// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.util;

import net.minecraft.util.IndirectEntityDamageSource;
import net.minecraft.entity.Entity;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.DamageSource;

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
    
    public static DamageSource AXING(final LivingEntity mob) {
        return (DamageSource)new EntityDamageSource(tfSource("axing"), (Entity)mob);
    }
    
    public static DamageSource YEETED(final LivingEntity mob) {
        return (DamageSource)new EntityDamageSource(tfSource("yeeted"), (Entity)mob);
    }
    
    public static DamageSource ANT(final LivingEntity mob) {
        return (DamageSource)new EntityDamageSource(tfSource("ant"), (Entity)mob);
    }
    
    public static DamageSource HAUNT(final LivingEntity mob) {
        return (DamageSource)new EntityDamageSource(tfSource("haunt"), (Entity)mob);
    }
    
    public static DamageSource CLAMPED(final LivingEntity mob) {
        return (DamageSource)new EntityDamageSource(tfSource("clamped"), (Entity)mob);
    }
    
    public static DamageSource SCORCHED(final LivingEntity mob) {
        return (DamageSource)new EntityDamageSource(tfSource("scorched"), (Entity)mob);
    }
    
    public static DamageSource FROZEN(final Entity source, final LivingEntity mob) {
        return (DamageSource)new IndirectEntityDamageSource(tfSource("frozen"), source, (Entity)mob);
    }
    
    public static DamageSource SPIKED(final Entity source, final LivingEntity mob) {
        return (DamageSource)new IndirectEntityDamageSource(tfSource("spiked"), source, (Entity)mob);
    }
    
    public static DamageSource LEAF_BRAIN(final Entity source, final LivingEntity mob) {
        return new IndirectEntityDamageSource(tfSource("leafBrain"), source, (Entity)mob).func_76348_h().func_82726_p();
    }
    
    public static DamageSource LOST_WORDS(final Entity source, final LivingEntity mob) {
        return new IndirectEntityDamageSource(tfSource("lostWords"), source, (Entity)mob).func_76348_h().func_82726_p();
    }
    
    public static DamageSource SNOWBALL_FIGHT(final Entity source, final LivingEntity mob) {
        return (DamageSource)new IndirectEntityDamageSource(tfSource("snowballFight"), source, (Entity)mob);
    }
    
    public static String tfSource(final String name) {
        return "twilightforest." + name;
    }
    
    static {
        GHAST_TEAR = new DamageSource(tfSource("ghastTear"));
        HYDRA_BITE = new DamageSource(tfSource("hydraBite"));
        HYDRA_FIRE = new DamageSource(tfSource("hydraFire"));
        LICH_BOLT = new DamageSource(tfSource("lichBolt")).func_76348_h().func_82726_p();
        LICH_BOMB = new DamageSource(tfSource("lichBomb")).func_76348_h().func_82726_p();
        CHILLING_BREATH = new DamageSource(tfSource("chillingBreath"));
        SQUISH = new DamageSource(tfSource("squish"));
        THROWN_AXE = new DamageSource(tfSource("thrownAxe"));
        THROWN_PICKAXE = new DamageSource(tfSource("thrownPickaxe"));
        THORNS = new DamageSource(tfSource("thorns"));
        KNIGHTMETAL = new DamageSource(tfSource("knightmetal"));
        FIERY = new DamageSource(tfSource("fiery"));
        FIRE_JET = new DamageSource(tfSource("fireJet"));
        REACTOR = new DamageSource(tfSource("reactor"));
        SLIDER = new DamageSource(tfSource("slider"));
    }
}
