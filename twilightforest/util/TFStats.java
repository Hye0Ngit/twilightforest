// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.util;

import net.minecraft.stats.StatFormatter;
import net.minecraft.stats.Stats;
import net.minecraft.core.Registry;
import twilightforest.TwilightForestMod;
import net.minecraft.resources.ResourceLocation;

public class TFStats
{
    public static final ResourceLocation BUGS_SQUISHED;
    public static final ResourceLocation UNCRAFTING_TABLE_INTERACTIONS;
    public static final ResourceLocation TROPHY_PEDESTALS_ACTIVATED;
    public static final ResourceLocation E115_SLICES_EATEN;
    public static final ResourceLocation TORCHBERRIES_HARVESTED;
    public static final ResourceLocation BLOCKS_CRUMBLED;
    public static final ResourceLocation LIFE_CHARMS_ACTIVATED;
    public static final ResourceLocation KEEPING_CHARMS_ACTIVATED;
    public static final ResourceLocation SKULL_CANDLES_MADE;
    public static final ResourceLocation TF_SHIELDS_BROKEN;
    
    public static void init() {
    }
    
    private static ResourceLocation makeTFStat(final String pKey) {
        final ResourceLocation resourcelocation = TwilightForestMod.prefix(pKey);
        Registry.m_122961_(Registry.f_122832_, pKey, (Object)resourcelocation);
        Stats.f_12988_.m_12899_((Object)resourcelocation, StatFormatter.f_12873_);
        return resourcelocation;
    }
    
    static {
        BUGS_SQUISHED = makeTFStat("bugs_squished");
        UNCRAFTING_TABLE_INTERACTIONS = makeTFStat("uncrafting_table_interactions");
        TROPHY_PEDESTALS_ACTIVATED = makeTFStat("trophy_pedestals_activated");
        E115_SLICES_EATEN = makeTFStat("e115_slices_eaten");
        TORCHBERRIES_HARVESTED = makeTFStat("torchberries_harvested");
        BLOCKS_CRUMBLED = makeTFStat("blocks_crumbled");
        LIFE_CHARMS_ACTIVATED = makeTFStat("life_charms_activated");
        KEEPING_CHARMS_ACTIVATED = makeTFStat("keeping_charms_activated");
        SKULL_CANDLES_MADE = makeTFStat("skull_candles_made");
        TF_SHIELDS_BROKEN = makeTFStat("tf_shields_broken");
    }
}
