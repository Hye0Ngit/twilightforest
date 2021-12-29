// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures;

import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockIgnoreProcessor;
import net.minecraft.world.level.block.Mirror;
import twilightforest.util.ArrayUtil;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.ChunkPos;
import java.util.Random;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.feature.NoiseEffect;
import net.minecraft.resources.ResourceLocation;
import twilightforest.util.BoundingBoxUtils;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.levelgen.feature.StructurePieceType;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureManager;
import net.minecraft.world.level.levelgen.structure.TemplateStructurePiece;

public abstract class TwilightTemplateStructurePiece extends TemplateStructurePiece
{
    protected StructureManager structureManager;
    private final BlockPos originalPlacement;
    private final BoundingBox originalBox;
    
    public TwilightTemplateStructurePiece(final StructurePieceType structurePieceType, final CompoundTag compoundTag, final ServerLevel serverLevel, final StructurePlaceSettings rl2SettingsFunction) {
        super(structurePieceType, compoundTag, serverLevel, rl -> rl2SettingsFunction);
        this.f_73379_ = this.m_6830_();
        this.f_73378_ = this.m_163587_();
        this.structureManager = serverLevel.m_8875_();
        this.originalPlacement = this.f_73658_;
        this.originalBox = BoundingBoxUtils.clone(this.f_73383_);
    }
    
    public TwilightTemplateStructurePiece(final StructurePieceType type, final int genDepth, final StructureManager structureManager, final ResourceLocation templateLocation, final StructurePlaceSettings placeSettings, final BlockPos startPosition) {
        super(type, genDepth, structureManager, templateLocation, templateLocation.toString(), placeSettings, startPosition);
        this.f_73379_ = this.m_6830_();
        this.f_73378_ = this.m_163587_();
        this.structureManager = structureManager;
        this.originalPlacement = this.f_73658_;
        this.originalBox = BoundingBoxUtils.clone(this.f_73383_);
    }
    
    protected void m_142347_(final ServerLevel level, final CompoundTag structureTag) {
        super.m_142347_(level, structureTag);
        structureTag.m_128405_("rotation", this.f_73657_.m_74404_().ordinal());
        structureTag.m_128405_("mirror", this.f_73657_.m_74401_().ordinal());
    }
    
    public NoiseEffect m_142318_() {
        return NoiseEffect.NONE;
    }
    
    protected boolean placePieceAdjusted(final WorldGenLevel level, final StructureFeatureManager structureFeatureManager, final ChunkGenerator chunkGenerator, final Random random, final BoundingBox boundingBox, final ChunkPos chunkPos, final BlockPos pos, final int dY) {
        this.f_73658_ = this.f_73658_.m_6630_(dY);
        final boolean result = super.m_7832_(level, structureFeatureManager, chunkGenerator, random, boundingBox, chunkPos, pos.m_6630_(dY));
        this.f_73658_ = this.originalPlacement;
        this.f_73383_ = BoundingBoxUtils.clone(this.originalBox);
        this.f_73657_.m_74381_(this.f_73383_);
        return result;
    }
    
    public static StructurePlaceSettings readSettings(final CompoundTag compoundTag) {
        return new StructurePlaceSettings().m_74379_((Rotation)ArrayUtil.wrapped(Rotation.values(), compoundTag.m_128451_("rotation"))).m_74377_((Mirror)ArrayUtil.wrapped(Mirror.values(), compoundTag.m_128451_("mirror"))).m_74383_((StructureProcessor)BlockIgnoreProcessor.f_74046_);
    }
    
    public static StructurePlaceSettings makeSettings(final Rotation rotation) {
        return new StructurePlaceSettings().m_74379_(rotation).m_74383_((StructureProcessor)BlockIgnoreProcessor.f_74046_);
    }
    
    public static StructurePlaceSettings makeSettings(final Rotation rotation, final Mirror mirror) {
        return new StructurePlaceSettings().m_74379_(rotation).m_74377_(mirror).m_74383_((StructureProcessor)BlockIgnoreProcessor.f_74046_);
    }
    
    public static StructurePlaceSettings randomRotation(final Random random) {
        return makeSettings(Rotation.m_55956_(random));
    }
}
