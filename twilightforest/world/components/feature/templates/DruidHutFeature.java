// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.feature.templates;

import twilightforest.TwilightForestMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntity;
import twilightforest.loot.TFTreasure;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.ChestType;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.EntityType;
import twilightforest.entity.TFEntities;
import net.minecraft.world.level.block.entity.SpawnerBlockEntity;
import java.util.Iterator;
import net.minecraft.world.level.block.state.properties.StructureMode;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.WorldGenLevel;
import twilightforest.world.components.processors.StoneBricksVariants;
import twilightforest.world.components.processors.CobbleVariants;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import twilightforest.world.components.processors.CobblePlankSwizzler;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.Util;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import java.util.Random;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureManager;
import com.mojang.serialization.Codec;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class DruidHutFeature extends TemplateFeature<NoneFeatureConfiguration>
{
    public DruidHutFeature(final Codec<NoneFeatureConfiguration> config) {
        super(config);
    }
    
    @Override
    protected StructureTemplate getTemplate(final StructureManager templateManager, final Random random) {
        return templateManager.m_74341_(((HutType)Util.m_137545_((Object[])HutType.values(), random)).resourceLocation);
    }
    
    @Override
    protected void modifySettings(final StructurePlaceSettings settings, final Random random) {
        settings.m_74383_((StructureProcessor)new CobblePlankSwizzler(random)).m_74383_((StructureProcessor)CobbleVariants.INSTANCE).m_74383_((StructureProcessor)StoneBricksVariants.INSTANCE);
    }
    
    @Override
    protected void postPlacement(final WorldGenLevel world, final Random random, final StructureManager templateManager, final Rotation rotation, final Mirror mirror, final StructurePlaceSettings placementSettings, BlockPos placementPos) {
        if (random.nextBoolean()) {
            final StructureTemplate template = templateManager.m_74341_(BasementType.values()[random.nextInt(BasementType.size)].getBasement(random.nextBoolean()));
            if (template == null) {
                return;
            }
            placementPos = placementPos.m_6625_(12).m_5484_(rotation.m_55954_(mirror.m_54848_(Direction.NORTH)), 1).m_5484_(rotation.m_55954_(mirror.m_54848_(Direction.EAST)), 1);
            template.m_74536_((ServerLevelAccessor)world, placementPos, placementPos, placementSettings.m_74394_().m_74383_((StructureProcessor)new CobblePlankSwizzler(random)).m_74383_((StructureProcessor)CobbleVariants.INSTANCE).m_74383_((StructureProcessor)StoneBricksVariants.INSTANCE), random, 20);
            for (final StructureTemplate.StructureBlockInfo info : template.m_74603_(placementPos, placementSettings, Blocks.f_50677_)) {
                if (info.f_74677_ != null && StructureMode.valueOf(info.f_74677_.m_128461_("mode")) == StructureMode.DATA) {
                    this.processMarkers(info, world, rotation, mirror, random);
                }
            }
        }
    }
    
    @Override
    protected void processMarkers(final StructureTemplate.StructureBlockInfo info, final WorldGenLevel world, final Rotation rotation, final Mirror mirror, final Random random) {
        final String s = info.f_74677_.m_128461_("metadata");
        final BlockPos blockPos = info.f_74675_;
        if ("spawner".equals(s)) {
            if (world.m_7471_(blockPos, false) && world.m_7731_(blockPos, Blocks.f_50085_.m_49966_(), 18)) {
                final BlockEntity 7702_;
                final BlockEntity tile = 7702_ = world.m_7702_(blockPos);
                if (7702_ instanceof final SpawnerBlockEntity ms) {
                    ms.m_59801_().m_45462_((EntityType)TFEntities.SKELETON_DRUID);
                }
            }
        }
        else if (s.startsWith("loot")) {
            world.m_7471_(blockPos, false);
            BlockState chest = s.endsWith("T") ? Blocks.f_50325_.m_49966_() : Blocks.f_50087_.m_49966_();
            final String substring = s.substring(5, 6);
            BlockState blockState = switch (substring) {
                case "L" -> (BlockState)chest.m_61124_((Property)ChestBlock.f_51479_, (Comparable)((mirror != Mirror.NONE) ? ChestType.RIGHT : ChestType.LEFT));
                case "R" -> (BlockState)chest.m_61124_((Property)ChestBlock.f_51479_, (Comparable)((mirror != Mirror.NONE) ? ChestType.LEFT : ChestType.RIGHT));
                default -> (BlockState)chest.m_61124_((Property)ChestBlock.f_51479_, (Comparable)ChestType.SINGLE);
            };
            chest = blockState;
            final String substring2 = s.substring(4, 5);
            BlockState blockState2 = switch (substring2) {
                case "W" -> (BlockState)chest.m_61124_((Property)HorizontalDirectionalBlock.f_54117_, (Comparable)rotation.m_55954_(mirror.m_54848_(Direction.WEST)));
                case "E" -> (BlockState)chest.m_61124_((Property)HorizontalDirectionalBlock.f_54117_, (Comparable)rotation.m_55954_(mirror.m_54848_(Direction.EAST)));
                case "S" -> (BlockState)chest.m_61124_((Property)HorizontalDirectionalBlock.f_54117_, (Comparable)rotation.m_55954_(mirror.m_54848_(Direction.SOUTH)));
                default -> (BlockState)chest.m_61124_((Property)HorizontalDirectionalBlock.f_54117_, (Comparable)rotation.m_55954_(mirror.m_54848_(Direction.NORTH)));
            };
            chest = blockState2;
            TFTreasure.BASEMENT.generateLootContainer(world, blockPos, chest, 18);
        }
    }
    
    private enum HutType
    {
        REGULAR(TwilightForestMod.prefix("feature/druid_hut/druid_hut")), 
        SIDEWAYS(TwilightForestMod.prefix("feature/druid_hut/druid_sideways")), 
        DOUBLE_DECK(TwilightForestMod.prefix("feature/druid_hut/druid_doubledeck"));
        
        private final ResourceLocation resourceLocation;
        
        private HutType(final ResourceLocation rl) {
            this.resourceLocation = rl;
        }
    }
    
    private enum BasementType
    {
        STUDY(TwilightForestMod.prefix("feature/druid_hut/basement_study"), TwilightForestMod.prefix("feature/druid_hut/basement_study_trap")), 
        SHELVES(TwilightForestMod.prefix("feature/druid_hut/basement_shelves"), TwilightForestMod.prefix("feature/druid_hut/basement_shelves_trap")), 
        GALLERY(TwilightForestMod.prefix("feature/druid_hut/basement_gallery"), TwilightForestMod.prefix("feature/druid_hut/basement_gallery_trap"));
        
        private final ResourceLocation resourceLocation;
        private final ResourceLocation resourceLocationTrap;
        private static int size;
        
        private BasementType(final ResourceLocation rl, final ResourceLocation rlTrap) {
            this.resourceLocation = rl;
            this.resourceLocationTrap = rlTrap;
            increment();
        }
        
        private static void increment() {
            ++BasementType.size;
        }
        
        private ResourceLocation getBasement(final boolean trapped) {
            return trapped ? this.resourceLocationTrap : this.resourceLocation;
        }
    }
}
