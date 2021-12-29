// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.enchantment;

import net.minecraftforge.registries.ForgeRegistries;
import twilightforest.item.ChainBlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.registries.DeferredRegister;

public class TFEnchantments
{
    public static final DeferredRegister<Enchantment> ENCHANTMENTS;
    public static final RegistryObject<Enchantment> FIRE_REACT;
    public static final RegistryObject<Enchantment> CHILL_AURA;
    public static final RegistryObject<Enchantment> PRESERVATION;
    public static final RegistryObject<Enchantment> BLOCK_STRENGTH;
    public static final RegistryObject<Enchantment> DESTRUCTION;
    public static final EnchantmentCategory BLOCK_AND_CHAIN;
    
    static {
        ENCHANTMENTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, "twilightforest");
        FIRE_REACT = TFEnchantments.ENCHANTMENTS.register("fire_react", () -> new FireReactEnchantment(Enchantment.Rarity.UNCOMMON));
        CHILL_AURA = TFEnchantments.ENCHANTMENTS.register("chill_aura", () -> new ChillAuraEnchantment(Enchantment.Rarity.UNCOMMON));
        PRESERVATION = TFEnchantments.ENCHANTMENTS.register("preservation", () -> new PreservationEnchantment(Enchantment.Rarity.RARE));
        BLOCK_STRENGTH = TFEnchantments.ENCHANTMENTS.register("block_strength", () -> new BlockStrengthEnchantment(Enchantment.Rarity.RARE));
        DESTRUCTION = TFEnchantments.ENCHANTMENTS.register("destruction", () -> new DestructionEnchantment(Enchantment.Rarity.RARE));
        BLOCK_AND_CHAIN = EnchantmentCategory.create("twilightforest_block_and_chain", item -> item instanceof ChainBlockItem);
    }
}
