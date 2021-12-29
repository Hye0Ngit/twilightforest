// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.potions;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.registries.DeferredRegister;

public class TFMobEffects
{
    public static final DeferredRegister<MobEffect> MOB_EFFECTS;
    public static final RegistryObject<MobEffect> FROSTY;
    
    static {
        MOB_EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, "twilightforest");
        FROSTY = TFMobEffects.MOB_EFFECTS.register("frosted", () -> new FrostedEffect(MobEffectCategory.HARMFUL, 5688317));
    }
}
