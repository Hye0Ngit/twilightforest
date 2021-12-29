// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.potions;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.potion.Potion;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "twilightforest")
public class TFRegisterPotionEvent
{
    @SubscribeEvent
    public static void onRegisterPotions(final RegistryEvent.Register<Potion> event) {
        registerPotion("frosted", new PotionFrosted(true, 5688317).func_76390_b("twilightforest.effect.frosted").func_111184_a(SharedMonsterAttributes.field_111263_d, PotionFrosted.MODIFIER_UUID.toString(), -0.15000000596046448, 2), event);
    }
    
    public static void registerPotion(final String name, final Potion potion, final RegistryEvent.Register<Potion> event) {
        event.getRegistry().register(potion.setRegistryName("twilightforest", name));
    }
}
