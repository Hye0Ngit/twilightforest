// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.enums;

import twilightforest.item.TFItems;
import net.minecraft.block.Blocks;
import net.minecraft.util.IItemProvider;
import net.minecraft.item.crafting.Ingredient;
import java.util.function.Supplier;
import net.minecraft.item.IItemTier;

public enum TwilightItemTier implements IItemTier
{
    TOOL_IRONWOOD(2, 512, 6.5f, 2.0f, 25, () -> Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)TFItems.ironwood_ingot.get() })), 
    TOOL_FIERY(4, 1024, 9.0f, 4.0f, 10, () -> Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)TFItems.fiery_ingot.get() })), 
    TOOL_STEELEAF(3, 131, 8.0f, 3.0f, 9, () -> Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)TFItems.steeleaf_ingot.get() })), 
    TOOL_KNIGHTLY(3, 512, 8.0f, 3.0f, 8, () -> Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)TFItems.knightmetal_ingot.get() })), 
    TOOL_GIANT(1, 1024, 4.0f, 1.0f, 5, () -> Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)TFItems.knightmetal_ingot.get() })), 
    TOOL_ICE(0, 32, 1.0f, 3.5f, 5, () -> Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)Blocks.field_150403_cj })), 
    TOOL_GLASS(0, 1, 1.0f, 36.0f, 30, () -> Ingredient.field_193370_a);
    
    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairMaterial;
    
    private TwilightItemTier(final int harvestLevel, final int maxUses, final float efficiency, final float damage, final int enchantability, final Supplier<Ingredient> repairMaterial) {
        this.harvestLevel = harvestLevel;
        this.maxUses = maxUses;
        this.efficiency = efficiency;
        this.attackDamage = damage;
        this.enchantability = enchantability;
        this.repairMaterial = repairMaterial;
    }
    
    public int func_200925_d() {
        return this.harvestLevel;
    }
    
    public int func_200926_a() {
        return this.maxUses;
    }
    
    public float func_200928_b() {
        return this.efficiency;
    }
    
    public float func_200929_c() {
        return this.attackDamage;
    }
    
    public int func_200927_e() {
        return this.enchantability;
    }
    
    public Ingredient func_200924_f() {
        return this.repairMaterial.get();
    }
}
