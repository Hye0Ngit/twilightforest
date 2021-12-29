// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.enums;

import net.minecraft.util.SoundEvents;
import twilightforest.item.TFItems;
import net.minecraft.util.IItemProvider;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.item.crafting.Ingredient;
import java.util.function.Supplier;
import net.minecraft.util.SoundEvent;
import net.minecraft.item.IArmorMaterial;

public enum TwilightArmorMaterial implements IArmorMaterial
{
    ARMOR_NAGA("naga_scale", 21, new int[] { 3, 6, 7, 2 }, 15, SoundEvents.field_187719_p, 0.5f, () -> Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)TFItems.naga_scale.get() })), 
    ARMOR_IRONWOOD("ironwood", 20, new int[] { 2, 5, 7, 2 }, 15, SoundEvents.field_187719_p, 0.0f, () -> Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)TFItems.ironwood_ingot.get() })), 
    ARMOR_FIERY("fiery", 25, new int[] { 4, 7, 9, 4 }, 10, SoundEvents.field_187719_p, 1.5f, () -> Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)TFItems.fiery_ingot.get() })), 
    ARMOR_STEELEAF("steeleaf", 10, new int[] { 3, 6, 8, 3 }, 9, SoundEvents.field_187719_p, 0.0f, () -> Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)TFItems.steeleaf_ingot.get() })), 
    ARMOR_KNIGHTLY("knightly", 20, new int[] { 3, 6, 8, 3 }, 8, SoundEvents.field_187719_p, 1.0f, () -> Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)TFItems.knightmetal_ingot.get() })), 
    ARMOR_PHANTOM("phantom", 30, new int[] { 3, 6, 8, 3 }, 8, SoundEvents.field_187719_p, 2.5f, () -> Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)TFItems.knightmetal_ingot.get() })), 
    ARMOR_YETI("yetiarmor", 20, new int[] { 3, 6, 7, 4 }, 15, SoundEvents.field_187719_p, 3.0f, () -> Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)TFItems.alpha_fur.get() })), 
    ARMOR_ARCTIC("arcticarmor", 10, new int[] { 2, 5, 7, 2 }, 8, SoundEvents.field_187719_p, 2.0f, () -> Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)TFItems.arctic_fur.get() }));
    
    private static final int[] MAX_DAMAGE_ARRAY;
    private final String name;
    private final int durability;
    private final int[] damageReduction;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final float toughness;
    private final Supplier<Ingredient> repairMaterial;
    
    private TwilightArmorMaterial(final String name, final int durability, final int[] damageReduction, final int enchantability, final SoundEvent sound, final float toughness, final Supplier<Ingredient> repairMaterial) {
        this.name = name;
        this.durability = durability;
        this.damageReduction = damageReduction;
        this.enchantability = enchantability;
        this.equipSound = sound;
        this.toughness = toughness;
        this.repairMaterial = repairMaterial;
    }
    
    @OnlyIn(Dist.CLIENT)
    public String func_200897_d() {
        return this.name;
    }
    
    public int func_200896_a(final EquipmentSlotType slotIn) {
        return TwilightArmorMaterial.MAX_DAMAGE_ARRAY[slotIn.func_188454_b()] * this.durability;
    }
    
    public int func_200902_b(final EquipmentSlotType slotIn) {
        return this.damageReduction[slotIn.func_188454_b()];
    }
    
    public int func_200900_a() {
        return this.enchantability;
    }
    
    public SoundEvent func_200899_b() {
        return this.equipSound;
    }
    
    public float func_200901_e() {
        return this.toughness;
    }
    
    public Ingredient func_200898_c() {
        return this.repairMaterial.get();
    }
    
    public float func_230304_f_() {
        return 0.0f;
    }
    
    static {
        MAX_DAMAGE_ARRAY = new int[] { 13, 15, 16, 11 };
    }
}
