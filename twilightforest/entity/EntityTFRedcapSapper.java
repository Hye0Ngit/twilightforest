// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.ItemStack;
import twilightforest.item.TFItems;
import net.minecraft.entity.ai.EntityAIBase;
import twilightforest.entity.ai.EntityAITFRedcapPlantTNT;
import net.minecraft.world.World;

public class EntityTFRedcapSapper extends EntityTFRedcap
{
    public EntityTFRedcapSapper(final World world) {
        super(world);
        this.field_70714_bg.func_75776_a(4, (EntityAIBase)new EntityAITFRedcapPlantTNT(this));
        this.setTntLeft(3);
        this.func_70062_b(1, new ItemStack(TFItems.ironwoodBoots));
        this.func_70062_b(0, new ItemStack(TFItems.ironwoodPick, 1));
    }
    
    @Override
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(30.0);
    }
    
    public int func_70658_aO() {
        int var1 = super.func_70658_aO() + 2;
        if (var1 > 20) {
            var1 = 20;
        }
        return var1;
    }
    
    @Override
    public ItemStack getPick() {
        return new ItemStack(TFItems.ironwoodPick);
    }
}
