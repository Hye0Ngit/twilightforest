// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import net.minecraft.client.gui.GuiScreen;
import twilightforest.TFConfig;
import net.minecraft.client.gui.GuiDownloadTerrain;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class LoadingScreenListener
{
    private final Minecraft client;
    private int lastDimension;
    
    public LoadingScreenListener() {
        this.client = Minecraft.func_71410_x();
        this.lastDimension = 0;
    }
    
    @SubscribeEvent
    public void onPlayerTick(final TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END && event.player == this.client.field_71439_g) {
            this.lastDimension = event.player.field_71093_bK;
        }
    }
    
    @SubscribeEvent
    public void onOpenGui(final GuiOpenEvent event) {
        if (event.getGui() instanceof GuiDownloadTerrain && this.client.field_71439_g != null) {
            final int tfDimension = TFConfig.dimension.dimensionID;
            if (this.client.field_71439_g.field_71093_bK == tfDimension || this.lastDimension == tfDimension) {
                final GuiTwilightForestLoading guiLoading = new GuiTwilightForestLoading();
                guiLoading.setEntering(this.client.field_71439_g.field_71093_bK == tfDimension);
                event.setGui((GuiScreen)guiLoading);
            }
        }
    }
}
