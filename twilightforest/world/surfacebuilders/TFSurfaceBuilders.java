// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.surfacebuilders;

import com.mojang.serialization.Codec;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistryEntry;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "twilightforest", bus = Mod.EventBusSubscriber.Bus.MOD)
public class TFSurfaceBuilders
{
    public static final TFDefaultSurfaceBuilder DEFAULT_TF;
    public static final TFHighlandsSurfaceBuilder HIGHLANDS;
    public static final TFPlateauSurfaceBuilder PLATEAU;
    
    @SubscribeEvent
    public static void register(final RegistryEvent.Register<SurfaceBuilder<?>> evt) {
        evt.getRegistry().register((IForgeRegistryEntry)TFSurfaceBuilders.DEFAULT_TF);
        evt.getRegistry().register((IForgeRegistryEntry)TFSurfaceBuilders.HIGHLANDS);
        evt.getRegistry().register((IForgeRegistryEntry)TFSurfaceBuilders.PLATEAU);
    }
    
    static {
        DEFAULT_TF = new TFDefaultSurfaceBuilder((Codec<SurfaceBuilderConfig>)SurfaceBuilderConfig.field_237203_a_);
        HIGHLANDS = new TFHighlandsSurfaceBuilder((Codec<SurfaceBuilderConfig>)SurfaceBuilderConfig.field_237203_a_);
        PLATEAU = new TFPlateauSurfaceBuilder((Codec<SurfaceBuilderConfig>)SurfaceBuilderConfig.field_237203_a_);
        TFSurfaceBuilders.DEFAULT_TF.setRegistryName("twilightforest", "default");
        TFSurfaceBuilders.HIGHLANDS.setRegistryName("twilightforest", "highlands");
        TFSurfaceBuilders.PLATEAU.setRegistryName("twilightforest", "plateau");
    }
}
