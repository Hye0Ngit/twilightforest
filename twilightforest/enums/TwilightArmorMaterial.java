// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.enums;

import twilightforest.TFSounds;
import net.minecraft.sounds.SoundEvents;
import twilightforest.item.TFItems;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.world.item.crafting.Ingredient;
import java.util.function.Supplier;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.ArmorMaterial;

public enum TwilightArmorMaterial implements ArmorMaterial
{
    ARMOR_NAGA("naga_scale", 21, new int[] { 3, 6, 7, 2 }, 15, SoundEvents.f_11675_, 0.5f, () -> Ingredient.m_43929_(new ItemLike[] { (ItemLike)TFItems.NAGA_SCALE.get() })), 
    ARMOR_IRONWOOD("ironwood", 20, new int[] { 2, 5, 7, 2 }, 15, SoundEvents.f_11675_, 0.0f, () -> Ingredient.m_43929_(new ItemLike[] { (ItemLike)TFItems.IRONWOOD_INGOT.get() })), 
    ARMOR_FIERY("fiery", 25, new int[] { 4, 7, 9, 4 }, 10, SoundEvents.f_11675_, 1.5f, () -> Ingredient.m_43929_(new ItemLike[] { (ItemLike)TFItems.FIERY_INGOT.get() })), 
    ARMOR_STEELEAF("steeleaf", 10, new int[] { 3, 6, 8, 3 }, 9, SoundEvents.f_11675_, 0.0f, () -> Ingredient.m_43929_(new ItemLike[] { (ItemLike)TFItems.STEELEAF_INGOT.get() })), 
    ARMOR_KNIGHTLY("knightly", 20, new int[] { 3, 6, 8, 3 }, 8, TFSounds.KNIGHTMETAL_EQUIP, 1.0f, () -> Ingredient.m_43929_(new ItemLike[] { (ItemLike)TFItems.KNIGHTMETAL_INGOT.get() })), 
    ARMOR_PHANTOM("phantom", 30, new int[] { 3, 6, 8, 3 }, 8, SoundEvents.f_11675_, 2.5f, () -> Ingredient.m_43929_(new ItemLike[] { (ItemLike)TFItems.KNIGHTMETAL_INGOT.get() })), 
    ARMOR_YETI("yetiarmor", 20, new int[] { 3, 6, 7, 4 }, 15, SoundEvents.f_11675_, 3.0f, () -> Ingredient.m_43929_(new ItemLike[] { (ItemLike)TFItems.ALPHA_YETI_FUR.get() })), 
    ARMOR_ARCTIC("arcticarmor", 10, new int[] { 2, 5, 7, 2 }, 8, SoundEvents.f_11675_, 2.0f, () -> Ingredient.m_43929_(new ItemLike[] { (ItemLike)TFItems.ARCTIC_FUR.get() }));
    
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
    public String m_6082_() {
        return this.name;
    }
    
    public int m_7366_(final EquipmentSlot slotIn) {
        return TwilightArmorMaterial.MAX_DAMAGE_ARRAY[slotIn.m_20749_()] * this.durability;
    }
    
    public int m_7365_(final EquipmentSlot slotIn) {
        return this.damageReduction[slotIn.m_20749_()];
    }
    
    public int m_6646_() {
        return this.enchantability;
    }
    
    public SoundEvent m_7344_() {
        return this.equipSound;
    }
    
    public float m_6651_() {
        return this.toughness;
    }
    
    public Ingredient m_6230_() {
        return this.repairMaterial.get();
    }
    
    public float m_6649_() {
        return 0.0f;
    }
    
    static {
        MAX_DAMAGE_ARRAY = new int[] { 13, 15, 16, 11 };
    }
}
