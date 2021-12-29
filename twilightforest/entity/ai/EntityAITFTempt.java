// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import net.minecraft.item.ItemStack;
import java.util.Set;
import java.util.Collections;
import net.minecraft.entity.EntityCreature;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.entity.ai.EntityAITempt;

public class EntityAITFTempt extends EntityAITempt
{
    protected final Ingredient ingredient;
    
    public EntityAITFTempt(final EntityCreature temptedEntity, final double speed, final boolean scaredByPlayerMovement, final Ingredient ingredient) {
        super(temptedEntity, speed, scaredByPlayerMovement, (Set)Collections.emptySet());
        this.ingredient = ingredient;
    }
    
    protected boolean func_188508_a(final ItemStack stack) {
        return this.ingredient.apply(stack);
    }
}
