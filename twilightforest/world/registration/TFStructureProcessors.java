// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.registration;

import twilightforest.TwilightForestMod;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import com.mojang.serialization.Codec;
import twilightforest.world.components.structures.courtyard.CourtyardTerraceTemplateProcessor;
import twilightforest.world.components.feature.templates.GraveyardFeature;
import twilightforest.world.components.processors.TargetedRotProcessor;
import twilightforest.world.components.processors.BoxCuttingProcessor;
import twilightforest.world.components.processors.SmartGrassProcessor;
import twilightforest.world.components.processors.CobblePlankSwizzler;
import twilightforest.world.components.processors.NagastoneVariants;
import twilightforest.world.components.processors.StoneBricksVariants;
import twilightforest.world.components.processors.SmoothStoneVariants;
import twilightforest.world.components.processors.CobbleVariants;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;

public class TFStructureProcessors
{
    public static final StructureProcessorType<CobbleVariants> COBBLE_VARIANTS;
    public static final StructureProcessorType<SmoothStoneVariants> SMOOTH_STONE_VARIANTS;
    public static final StructureProcessorType<StoneBricksVariants> STONE_BRICK_VARIANTS;
    public static final StructureProcessorType<NagastoneVariants> NAGASTONE_VARIANTS;
    public static final StructureProcessorType<CobblePlankSwizzler> COBBLE_PLANK_SWIZZLER;
    public static final StructureProcessorType<SmartGrassProcessor> SMART_GRASS;
    public static final StructureProcessorType<BoxCuttingProcessor> BOX_CUTTING_PROCESSOR;
    public static final StructureProcessorType<TargetedRotProcessor> TARGETED_ROT;
    public static final StructureProcessorType<GraveyardFeature.WebTemplateProcessor> WEB;
    public static final StructureProcessorType<CourtyardTerraceTemplateProcessor> COURTYARD_TERRACE;
    
    public static <P extends StructureProcessor> StructureProcessorType<P> registerProcessor(final String name, final Codec<P> processor) {
        return (StructureProcessorType<P>)Registry.m_122965_(Registry.f_122891_, TwilightForestMod.prefix(name), (Object)(() -> processor));
    }
    
    static {
        COBBLE_VARIANTS = registerProcessor("cobble_variants", CobbleVariants.CODEC);
        SMOOTH_STONE_VARIANTS = registerProcessor("smooth_stone_variants", SmoothStoneVariants.CODEC);
        STONE_BRICK_VARIANTS = registerProcessor("stone_brick_variants", StoneBricksVariants.CODEC);
        NAGASTONE_VARIANTS = registerProcessor("nagastone_variants", NagastoneVariants.CODEC);
        COBBLE_PLANK_SWIZZLER = registerProcessor("cobble_plank_swizzler", CobblePlankSwizzler.CODEC);
        SMART_GRASS = registerProcessor("smart_grass", SmartGrassProcessor.CODEC);
        BOX_CUTTING_PROCESSOR = registerProcessor("box_cutting", BoxCuttingProcessor.CODEC);
        TARGETED_ROT = registerProcessor("targeted_rot", TargetedRotProcessor.CODEC);
        WEB = registerProcessor("web", GraveyardFeature.WebTemplateProcessor.CODEC);
        COURTYARD_TERRACE = registerProcessor("courtyard_terrace", CourtyardTerraceTemplateProcessor.CODEC);
    }
}
