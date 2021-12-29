// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import twilightforest.item.RegisterItemEvent;
import twilightforest.block.RegisterBlockEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "twilightforest", value = { Side.CLIENT })
public class ModelRegistrationHandler
{
    @SubscribeEvent
    public static void onModelRegistryReady(final ModelRegistryEvent event) {
        RegisterBlockEvent.getBlockModels().forEach(ModelRegisterCallback::registerModel);
        RegisterItemEvent.getItemModels().forEach(ModelRegisterCallback::registerModel);
    }
}
