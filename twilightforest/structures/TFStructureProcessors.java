// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import twilightforest.worldgen.structures.TFGenGraveyard;
import twilightforest.worldgen.structures.GenDruidHut;
import twilightforest.structures.courtyard.CourtyardWallTemplateProcessor;
import twilightforest.structures.courtyard.CourtyardStairsTemplateProcessor;
import twilightforest.structures.courtyard.CourtyardTerraceTemplateProcessor;
import twilightforest.TwilightForestMod;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.template.StructureProcessor;
import com.mojang.serialization.Codec;
import net.minecraft.world.gen.feature.template.IStructureProcessorType;

public class TFStructureProcessors
{
    public static final IStructureProcessorType<?> COURTYARD_TERRACE;
    public static final IStructureProcessorType<?> COURTYARD_STAIRS;
    public static final IStructureProcessorType<?> COURTYARD_WALL;
    public static final IStructureProcessorType<?> MOSSY_COBBLE;
    public static final IStructureProcessorType<?> HUT;
    public static final IStructureProcessorType<?> WEB;
    
    public static <P extends StructureProcessor> IStructureProcessorType<P> registerProcessor(final String name, final Codec<P> processor) {
        return (IStructureProcessorType<P>)Registry.func_218322_a(Registry.field_218364_E, TwilightForestMod.prefix(name), (Object)(() -> processor));
    }
    
    static {
        COURTYARD_TERRACE = registerProcessor("courtyard_terrace", (com.mojang.serialization.Codec<?>)CourtyardTerraceTemplateProcessor.codecTerraceProcessor);
        COURTYARD_STAIRS = registerProcessor("courtyard_stairs", (com.mojang.serialization.Codec<?>)CourtyardStairsTemplateProcessor.codecStairsProcessor);
        COURTYARD_WALL = registerProcessor("courtyard_wall", (com.mojang.serialization.Codec<?>)CourtyardWallTemplateProcessor.codecWallProcessor);
        MOSSY_COBBLE = registerProcessor("mossy_cobble", (com.mojang.serialization.Codec<?>)MossyCobbleTemplateProcessor.codecMossyProcessor);
        HUT = registerProcessor("hut", (com.mojang.serialization.Codec<?>)GenDruidHut.HutTemplateProcessor.codecHutProcessor);
        WEB = registerProcessor("web", (com.mojang.serialization.Codec<?>)TFGenGraveyard.WebTemplateProcessor.codecWebProcessor);
    }
}
