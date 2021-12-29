// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.world.level.Level;
import twilightforest.block.TFBlocks;
import twilightforest.block.TFPortalBlock;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import twilightforest.TFConfig;
import net.minecraft.core.Registry;
import net.minecraft.client.gui.screens.ReceivingLevelScreen;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class LoadingScreenListener
{
    private final Minecraft client;
    
    public LoadingScreenListener() {
        this.client = Minecraft.m_91087_();
    }
    
    @SubscribeEvent
    public void onOpenGui(final GuiOpenEvent event) {
        if (event.getGui() instanceof ReceivingLevelScreen && this.client.f_91074_ != null) {
            final ResourceKey<Level> tfDimension = (ResourceKey<Level>)ResourceKey.m_135785_(Registry.f_122819_, new ResourceLocation((String)TFConfig.COMMON_CONFIG.DIMENSION.portalDestinationID.get()));
            if (this.client.f_91074_.m_20193_().m_8055_(this.client.f_91074_.m_142538_().m_7495_()) == ((TFPortalBlock)TFBlocks.TWILIGHT_PORTAL.get()).m_49966_() || this.client.f_91074_.m_20193_().m_46472_() == tfDimension) {
                final LoadingScreenGui guiLoading = new LoadingScreenGui();
                guiLoading.setEntering(this.client.f_91074_.m_20193_().m_46472_() == Level.f_46428_);
                event.setGui((Screen)guiLoading);
            }
        }
    }
}
