// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.monster;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.goal.Goal;
import twilightforest.entity.ai.RedcapPlantTNTGoal;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.item.ItemStack;
import twilightforest.item.TFItems;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;

public class RedcapSapper extends Redcap
{
    public RedcapSapper(final EntityType<? extends RedcapSapper> type, final Level world) {
        super(type, world);
        this.heldPick = new ItemStack((ItemLike)TFItems.IRONWOOD_PICKAXE.get());
        this.heldTNT.m_41764_(3);
    }
    
    @Override
    protected void m_6851_(final DifficultyInstance difficulty) {
        super.m_6851_(difficulty);
        this.m_8061_(EquipmentSlot.FEET, new ItemStack((ItemLike)TFItems.IRONWOOD_BOOTS.get()));
    }
    
    @Override
    protected void m_8099_() {
        super.m_8099_();
        this.f_21345_.m_25352_(4, (Goal)new RedcapPlantTNTGoal(this));
    }
    
    public static AttributeSupplier.Builder registerAttributes() {
        return Redcap.registerAttributes().m_22268_(Attributes.f_22276_, 30.0).m_22268_(Attributes.f_22284_, 2.0);
    }
}
