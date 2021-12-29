// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.feature.templates;

import twilightforest.TwilightForestMod;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import twilightforest.world.components.processors.CobbleVariants;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import javax.annotation.Nullable;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import java.util.Random;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureManager;
import com.mojang.serialization.Codec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class StoneCircleFeature extends TemplateFeature<NoneFeatureConfiguration>
{
    private static final ResourceLocation STONE_CIRCLE;
    
    public StoneCircleFeature(final Codec<NoneFeatureConfiguration> config) {
        super(config);
    }
    
    @Nullable
    @Override
    protected StructureTemplate getTemplate(final StructureManager templateManager, final Random random) {
        return templateManager.m_74341_(StoneCircleFeature.STONE_CIRCLE);
    }
    
    @Override
    protected void modifySettings(final StructurePlaceSettings settings, final Random random) {
        settings.m_74383_((StructureProcessor)CobbleVariants.INSTANCE);
    }
    
    static {
        STONE_CIRCLE = TwilightForestMod.prefix("feature/ruins/stone_circle");
    }
}
