// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.advancements;

import net.minecraft.advancements.ICriterionTrigger;
import net.minecraft.advancements.CriteriaTriggers;

public class TFAdvancements
{
    public static final HasAdvancementTrigger ADVANCEMENT_UNLOCKED;
    public static final MakePortalTrigger MADE_TF_PORTAL;
    public static final HydraChopTrigger CONSUME_HYDRA_CHOP;
    public static final QuestRamCompletionTrigger QUEST_RAM_COMPLETED;
    public static final TrophyPedestalTrigger PLACED_TROPHY_ON_PEDESTAL;
    public static final ActivateGhastTrapTrigger ACTIVATED_GHAST_TRAP;
    public static final StructureClearedTrigger STRUCTURE_CLEARED;
    public static final ItemUseTrigger ITEM_USE_TRIGGER;
    public static final ArmorInventoryChangedTrigger ARMOR_CHANGED;
    
    public static void init() {
    }
    
    static {
        ADVANCEMENT_UNLOCKED = (HasAdvancementTrigger)CriteriaTriggers.func_192118_a((ICriterionTrigger)new HasAdvancementTrigger());
        MADE_TF_PORTAL = (MakePortalTrigger)CriteriaTriggers.func_192118_a((ICriterionTrigger)new MakePortalTrigger());
        CONSUME_HYDRA_CHOP = (HydraChopTrigger)CriteriaTriggers.func_192118_a((ICriterionTrigger)new HydraChopTrigger());
        QUEST_RAM_COMPLETED = (QuestRamCompletionTrigger)CriteriaTriggers.func_192118_a((ICriterionTrigger)new QuestRamCompletionTrigger());
        PLACED_TROPHY_ON_PEDESTAL = (TrophyPedestalTrigger)CriteriaTriggers.func_192118_a((ICriterionTrigger)new TrophyPedestalTrigger());
        ACTIVATED_GHAST_TRAP = (ActivateGhastTrapTrigger)CriteriaTriggers.func_192118_a((ICriterionTrigger)new ActivateGhastTrapTrigger());
        STRUCTURE_CLEARED = (StructureClearedTrigger)CriteriaTriggers.func_192118_a((ICriterionTrigger)new StructureClearedTrigger());
        ITEM_USE_TRIGGER = (ItemUseTrigger)CriteriaTriggers.func_192118_a((ICriterionTrigger)new ItemUseTrigger());
        ARMOR_CHANGED = (ArmorInventoryChangedTrigger)CriteriaTriggers.func_192118_a((ICriterionTrigger)new ArmorInventoryChangedTrigger());
    }
}
