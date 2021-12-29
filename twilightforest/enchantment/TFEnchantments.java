// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.enchantment;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.RegistryObject;
import net.minecraft.enchantment.Enchantment;
import net.minecraftforge.registries.DeferredRegister;

public class TFEnchantments
{
    public static final DeferredRegister<Enchantment> ENCHANTMENTS;
    public static final RegistryObject<Enchantment> FIRE_REACT;
    public static final RegistryObject<Enchantment> CHILL_AURA;
    
    static {
        ENCHANTMENTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, "twilightforest");
        FIRE_REACT = TFEnchantments.ENCHANTMENTS.register("fire_react", () -> new FireReactEnchantment(Enchantment.Rarity.UNCOMMON));
        CHILL_AURA = TFEnchantments.ENCHANTMENTS.register("chill_aura", () -> new ChillAuraEnchantment(Enchantment.Rarity.UNCOMMON));
    }
}
