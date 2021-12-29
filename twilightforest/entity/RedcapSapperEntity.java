// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.goal.Goal;
import twilightforest.entity.ai.RedcapPlantTNTGoal;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.item.ItemStack;
import twilightforest.item.TFItems;
import net.minecraft.util.IItemProvider;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;

public class RedcapSapperEntity extends RedcapEntity
{
    public RedcapSapperEntity(final EntityType<? extends RedcapSapperEntity> type, final World world) {
        super(type, world);
        this.heldPick = new ItemStack((IItemProvider)TFItems.ironwood_pickaxe.get());
        this.heldTNT.func_190920_e(3);
    }
    
    @Override
    protected void func_180481_a(final DifficultyInstance difficulty) {
        super.func_180481_a(difficulty);
        this.func_184201_a(EquipmentSlotType.FEET, new ItemStack((IItemProvider)TFItems.ironwood_boots.get()));
    }
    
    @Override
    protected void func_184651_r() {
        super.func_184651_r();
        this.field_70714_bg.func_75776_a(4, (Goal)new RedcapPlantTNTGoal(this));
    }
    
    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        return RedcapEntity.registerAttributes().func_233815_a_(Attributes.field_233818_a_, 30.0).func_233815_a_(Attributes.field_233826_i_, 2.0);
    }
}
