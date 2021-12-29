// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.advancements;

import net.minecraft.advancements.CriterionTrigger;
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
    public static final ArmorInventoryChangedTrigger ARMOR_CHANGED;
    public static final DrinkFromFlaskTrigger DRINK_FROM_FLASK;
    public static final KillBugTrigger KILL_BUG;
    public static final HurtBossTrigger HURT_BOSS;
    
    public static void init() {
    }
    
    static {
        ADVANCEMENT_UNLOCKED = (HasAdvancementTrigger)CriteriaTriggers.m_10595_((CriterionTrigger)new HasAdvancementTrigger());
        MADE_TF_PORTAL = (MakePortalTrigger)CriteriaTriggers.m_10595_((CriterionTrigger)new MakePortalTrigger());
        CONSUME_HYDRA_CHOP = (HydraChopTrigger)CriteriaTriggers.m_10595_((CriterionTrigger)new HydraChopTrigger());
        QUEST_RAM_COMPLETED = (QuestRamCompletionTrigger)CriteriaTriggers.m_10595_((CriterionTrigger)new QuestRamCompletionTrigger());
        PLACED_TROPHY_ON_PEDESTAL = (TrophyPedestalTrigger)CriteriaTriggers.m_10595_((CriterionTrigger)new TrophyPedestalTrigger());
        ACTIVATED_GHAST_TRAP = (ActivateGhastTrapTrigger)CriteriaTriggers.m_10595_((CriterionTrigger)new ActivateGhastTrapTrigger());
        STRUCTURE_CLEARED = (StructureClearedTrigger)CriteriaTriggers.m_10595_((CriterionTrigger)new StructureClearedTrigger());
        ARMOR_CHANGED = (ArmorInventoryChangedTrigger)CriteriaTriggers.m_10595_((CriterionTrigger)new ArmorInventoryChangedTrigger());
        DRINK_FROM_FLASK = (DrinkFromFlaskTrigger)CriteriaTriggers.m_10595_((CriterionTrigger)new DrinkFromFlaskTrigger());
        KILL_BUG = (KillBugTrigger)CriteriaTriggers.m_10595_((CriterionTrigger)new KillBugTrigger());
        HURT_BOSS = (HurtBossTrigger)CriteriaTriggers.m_10595_((CriterionTrigger)new HurtBossTrigger());
    }
}
