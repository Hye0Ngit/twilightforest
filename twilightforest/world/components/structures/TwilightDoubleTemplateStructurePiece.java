// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures;

import net.minecraft.world.level.block.state.BlockState;
import java.util.Iterator;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import twilightforest.TwilightForestMod;
import net.minecraft.commands.arguments.blocks.BlockStateParser;
import com.mojang.brigadier.StringReader;
import net.minecraft.world.level.block.state.properties.StructureMode;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import java.util.Random;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureManager;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.levelgen.feature.StructurePieceType;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.resources.ResourceLocation;

public abstract class TwilightDoubleTemplateStructurePiece extends TwilightTemplateStructurePiece
{
    protected ResourceLocation templateOverlayLocation;
    protected StructureTemplate templateOverlay;
    protected StructurePlaceSettings placeSettingsOverlay;
    
    public TwilightDoubleTemplateStructurePiece(final StructurePieceType structurePieceType, final CompoundTag compoundTag, final ServerLevel serverLevel, final StructurePlaceSettings rl2SettingsFunction, final StructurePlaceSettings placeSettingsOverlay) {
        super(structurePieceType, compoundTag, serverLevel, rl2SettingsFunction);
        this.templateOverlayLocation = new ResourceLocation(compoundTag.m_128461_("TemplateOverlay"));
        this.templateOverlay = this.structureManager.m_74341_(this.templateOverlayLocation);
        this.placeSettingsOverlay = placeSettingsOverlay;
    }
    
    public TwilightDoubleTemplateStructurePiece(final StructurePieceType type, final int genDepth, final StructureManager structureManager, final ResourceLocation templateLocation, final StructurePlaceSettings placeSettings, final ResourceLocation templateOverlayLocation, final StructurePlaceSettings placeSettingsOverlay, final BlockPos startPosition) {
        super(type, genDepth, structureManager, templateLocation, placeSettings, startPosition);
        this.templateOverlayLocation = templateOverlayLocation;
        this.templateOverlay = this.structureManager.m_74341_(this.templateOverlayLocation);
        this.placeSettingsOverlay = placeSettingsOverlay;
    }
    
    @Override
    protected void m_142347_(final ServerLevel level, final CompoundTag structureTag) {
        super.m_142347_(level, structureTag);
        structureTag.m_128359_("TemplateOverlay", this.templateOverlayLocation.toString());
    }
    
    public boolean m_7832_(final WorldGenLevel worldGenLevel, final StructureFeatureManager structureManager, final ChunkGenerator chunkGenerator, final Random random, final BoundingBox boundingBox, final ChunkPos chunkPos, final BlockPos blockPos) {
        final boolean result = super.m_7832_(worldGenLevel, structureManager, chunkGenerator, random, boundingBox, chunkPos, blockPos);
        if (this.templateOverlay.m_74536_((ServerLevelAccessor)worldGenLevel, this.f_73658_, blockPos, this.placeSettingsOverlay, random, 2)) {
            for (final StructureTemplate.StructureBlockInfo structureBlockInfo : this.templateOverlay.m_74603_(this.f_73658_, this.placeSettingsOverlay, Blocks.f_50677_)) {
                if (structureBlockInfo.f_74677_ != null) {
                    final StructureMode structureMode = StructureMode.valueOf(structureBlockInfo.f_74677_.m_128461_("mode"));
                    if (structureMode != StructureMode.DATA) {
                        continue;
                    }
                    this.m_7756_(structureBlockInfo.f_74677_.m_128461_("metadata"), structureBlockInfo.f_74675_, (ServerLevelAccessor)worldGenLevel, random, boundingBox);
                }
            }
            for (final StructureTemplate.StructureBlockInfo structureBlockInfo : this.templateOverlay.m_74603_(this.f_73658_, this.placeSettingsOverlay, Blocks.f_50678_)) {
                if (structureBlockInfo.f_74677_ != null) {
                    final String s = structureBlockInfo.f_74677_.m_128461_("final_state");
                    final BlockStateParser blockStateParser = new BlockStateParser(new StringReader(s), false);
                    BlockState blockState = Blocks.f_50016_.m_49966_();
                    try {
                        blockStateParser.m_116806_(true);
                        final BlockState parserState = blockStateParser.m_116808_();
                        if (parserState != null) {
                            blockState = parserState;
                        }
                        else {
                            TwilightForestMod.LOGGER.error("Error while parsing blockstate {} in jigsaw block @ {}", (Object)s, (Object)structureBlockInfo.f_74675_);
                        }
                    }
                    catch (CommandSyntaxException commandsyntaxexception) {
                        TwilightForestMod.LOGGER.error("Error while parsing blockstate {} in jigsaw block @ {}", (Object)s, (Object)structureBlockInfo.f_74675_);
                    }
                    worldGenLevel.m_7731_(structureBlockInfo.f_74675_, blockState, 3);
                }
            }
        }
        return result;
    }
}
