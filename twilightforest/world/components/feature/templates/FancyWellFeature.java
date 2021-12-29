// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.feature.templates;

import twilightforest.TwilightForestMod;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.BarrelBlock;
import net.minecraft.world.level.block.state.BlockState;
import twilightforest.loot.TFTreasure;
import java.util.Iterator;
import net.minecraft.world.level.block.state.properties.StructureMode;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.ServerLevelAccessor;
import twilightforest.world.components.processors.SmartGrassProcessor;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.WorldGenLevel;
import twilightforest.world.components.processors.StoneBricksVariants;
import twilightforest.world.components.processors.CobbleVariants;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import twilightforest.world.components.processors.CobblePlankSwizzler;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import javax.annotation.Nullable;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import java.util.Random;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureManager;
import com.mojang.serialization.Codec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class FancyWellFeature extends TemplateFeature<NoneFeatureConfiguration>
{
    private static final ResourceLocation WELL_TOP;
    private static final ResourceLocation WELL_BOTTOM;
    
    public FancyWellFeature(final Codec<NoneFeatureConfiguration> config) {
        super(config);
    }
    
    @Nullable
    @Override
    protected StructureTemplate getTemplate(final StructureManager templateManager, final Random random) {
        return templateManager.m_74341_(FancyWellFeature.WELL_TOP);
    }
    
    @Override
    protected void modifySettings(final StructurePlaceSettings settings, final Random random) {
        settings.m_74383_((StructureProcessor)new CobblePlankSwizzler(random)).m_74383_((StructureProcessor)CobbleVariants.INSTANCE).m_74383_((StructureProcessor)StoneBricksVariants.INSTANCE);
    }
    
    @Override
    protected void postPlacement(final WorldGenLevel world, final Random random, final StructureManager templateManager, final Rotation rotation, final Mirror mirror, final StructurePlaceSettings placementSettings, BlockPos placementPos) {
        final StructureTemplate template = templateManager.m_74341_(FancyWellFeature.WELL_BOTTOM);
        if (template == null) {
            return;
        }
        placementPos = placementPos.m_6625_(template.m_163801_().m_123342_());
        placementSettings.m_74383_((StructureProcessor)SmartGrassProcessor.INSTANCE);
        template.m_74536_((ServerLevelAccessor)world, placementPos, placementPos, placementSettings, random, 20);
        for (final StructureTemplate.StructureBlockInfo info : template.m_74603_(placementPos, placementSettings, Blocks.f_50677_)) {
            if (info.f_74677_ != null && StructureMode.valueOf(info.f_74677_.m_128461_("mode")) == StructureMode.DATA) {
                this.processMarkers(info, world, rotation, mirror, random);
            }
        }
    }
    
    @Override
    protected void processMarkers(final StructureTemplate.StructureBlockInfo info, final WorldGenLevel world, final Rotation rotation, final Mirror mirror, final Random random) {
        final String s = info.f_74677_.m_128461_("metadata");
        if (!s.startsWith("loot")) {
            return;
        }
        world.m_7471_(info.f_74675_, false);
        if (random.nextBoolean()) {
            TFTreasure.FANCY_WELL.generateLootContainer(world, info.f_74675_, (BlockState)Blocks.f_50618_.m_49966_().m_61124_((Property)BarrelBlock.f_49042_, (Comparable)Direction.UP), 18);
        }
        else {
            world.m_7731_(info.f_74675_, random.nextBoolean() ? Blocks.f_50652_.m_49966_() : Blocks.f_50079_.m_49966_(), 18);
        }
    }
    
    static {
        WELL_TOP = TwilightForestMod.prefix("feature/well/fancy_well_top");
        WELL_BOTTOM = TwilightForestMod.prefix("feature/well/fancy_well_bottom");
    }
}
