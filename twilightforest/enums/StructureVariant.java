// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.enums;

import java.util.Locale;
import net.minecraft.util.IStringSerializable;

public enum StructureVariant implements IStringSerializable
{
    TWILIGHT_PORTAL, 
    HEDGE_MAZE, 
    HOLLOW_HILL, 
    QUEST_GROVE, 
    MUSHROOM_TOWER, 
    NAGA_COURTYARD, 
    LICH_TOWER, 
    MINOTAUR_LABYRINTH, 
    HYDRA_LAIR, 
    GOBLIN_STRONGHOLD, 
    DARK_TOWER, 
    YETI_CAVE, 
    AURORA_PALACE, 
    TROLL_CAVE_AND_CLOUD_CASTLE, 
    FINAL_CASTLE;
    
    public String func_176610_l() {
        return this.name().toLowerCase(Locale.ROOT);
    }
}
