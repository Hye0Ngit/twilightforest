// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.registration;

import com.mojang.serialization.Codec;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderBaseConfiguration;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistryEntry;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilder;
import net.minecraftforge.event.RegistryEvent;
import twilightforest.world.components.surfacebuilders.HighlandsSurfaceBuilder;
import twilightforest.world.components.surfacebuilders.GlacierSurfaceBuilder;
import twilightforest.world.components.surfacebuilders.FillingSurfaceBuilder;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "twilightforest", bus = Mod.EventBusSubscriber.Bus.MOD)
public class TwilightSurfaceBuilders
{
    public static final FillingSurfaceBuilder DEADROCK_FILLING;
    public static final GlacierSurfaceBuilder GLACIER;
    public static final HighlandsSurfaceBuilder HIGHLANDS;
    
    @SubscribeEvent
    public static void register(final RegistryEvent.Register<SurfaceBuilder<?>> evt) {
        evt.getRegistry().register((IForgeRegistryEntry)TwilightSurfaceBuilders.DEADROCK_FILLING);
        evt.getRegistry().register((IForgeRegistryEntry)TwilightSurfaceBuilders.GLACIER);
        evt.getRegistry().register((IForgeRegistryEntry)TwilightSurfaceBuilders.HIGHLANDS);
    }
    
    static {
        DEADROCK_FILLING = new FillingSurfaceBuilder(FillingSurfaceBuilder.FillingSurfaceBuilderConfig.CODEC);
        GLACIER = new GlacierSurfaceBuilder(GlacierSurfaceBuilder.GlacierSurfaceConfig.CODEC);
        HIGHLANDS = new HighlandsSurfaceBuilder((Codec<SurfaceBuilderBaseConfiguration>)SurfaceBuilderBaseConfiguration.f_75241_);
        TwilightSurfaceBuilders.DEADROCK_FILLING.setRegistryName("twilightforest", "plateau");
        TwilightSurfaceBuilders.GLACIER.setRegistryName("twilightforest", "glacier");
        TwilightSurfaceBuilders.HIGHLANDS.setRegistryName("twilightforest", "highlands");
    }
}
