// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.world.World;
import twilightforest.world.WorldProviderTwilightForest;
import net.minecraft.client.Minecraft;
import cpw.mods.fml.common.gameevent.TickEvent;

public class TFClientTicker
{
    @SubscribeEvent
    public void clientTick(final TickEvent.ClientTickEvent event) {
        final Minecraft mc = Minecraft.func_71410_x();
        final World world = (World)mc.field_71441_e;
        if (world != null && world.field_73011_w instanceof WorldProviderTwilightForest && mc.field_71456_v != null) {
            mc.field_71456_v.field_73843_a = 0.0f;
        }
    }
}
