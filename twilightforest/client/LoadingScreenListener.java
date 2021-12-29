// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.world.World;
import twilightforest.block.TFBlocks;
import twilightforest.block.TFPortalBlock;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import twilightforest.TFConfig;
import net.minecraft.util.registry.Registry;
import net.minecraft.client.gui.screen.DownloadTerrainScreen;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class LoadingScreenListener
{
    private final Minecraft client;
    
    public LoadingScreenListener() {
        this.client = Minecraft.func_71410_x();
    }
    
    @SubscribeEvent
    public void onOpenGui(final GuiOpenEvent event) {
        if (event.getGui() instanceof DownloadTerrainScreen && this.client.field_71439_g != null) {
            final RegistryKey<World> tfDimension = (RegistryKey<World>)RegistryKey.func_240903_a_(Registry.field_239699_ae_, new ResourceLocation((String)TFConfig.COMMON_CONFIG.DIMENSION.twilightForestID.get()));
            if (this.client.field_71439_g.func_130014_f_().func_180495_p(this.client.field_71439_g.func_233580_cy_().func_177977_b()) == ((TFPortalBlock)TFBlocks.twilight_portal.get()).func_176223_P() || this.client.field_71439_g.func_130014_f_().func_234923_W_() == tfDimension) {
                final LoadingScreenGui guiLoading = new LoadingScreenGui();
                guiLoading.setEntering(this.client.field_71439_g.func_130014_f_().func_234923_W_() == World.field_234918_g_);
                event.setGui((Screen)guiLoading);
            }
        }
    }
}
