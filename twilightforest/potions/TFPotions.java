// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.potions;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.potion.EffectType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraft.potion.Effect;
import net.minecraftforge.registries.DeferredRegister;

public class TFPotions
{
    public static final DeferredRegister<Effect> POTIONS;
    public static final RegistryObject<Effect> frosty;
    
    static {
        POTIONS = DeferredRegister.create(ForgeRegistries.POTIONS, "twilightforest");
        frosty = TFPotions.POTIONS.register("frosted", () -> new FrostedPotion(EffectType.HARMFUL, 5688317));
    }
}
