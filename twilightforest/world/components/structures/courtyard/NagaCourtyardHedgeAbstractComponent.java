// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.courtyard;

import net.minecraft.world.level.levelgen.feature.NoiseEffect;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockRotProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockIgnoreProcessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import twilightforest.world.components.processors.NagastoneVariants;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import java.util.Random;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureManager;
import net.minecraft.world.level.block.Rotation;
import twilightforest.world.registration.TFFeature;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.levelgen.feature.StructurePieceType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.resources.ResourceLocation;
import twilightforest.world.components.structures.TFStructureComponentTemplate;

public abstract class NagaCourtyardHedgeAbstractComponent extends TFStructureComponentTemplate
{
    private final ResourceLocation HEDGE;
    private final ResourceLocation HEDGE_BIG;
    private StructureTemplate templateBig;
    
    public NagaCourtyardHedgeAbstractComponent(final ServerLevel level, final StructurePieceType piece, final CompoundTag nbt, final ResourceLocation hedge, final ResourceLocation hedgeBig) {
        super(level, piece, nbt);
        this.HEDGE = hedge;
        this.HEDGE_BIG = hedgeBig;
    }
    
    public NagaCourtyardHedgeAbstractComponent(final StructurePieceType type, final TFFeature feature, final int i, final int x, final int y, final int z, final Rotation rotation, final ResourceLocation hedge, final ResourceLocation hedgeBig) {
        super(type, feature, i, x, y, z, rotation);
        this.HEDGE = hedge;
        this.HEDGE_BIG = hedgeBig;
    }
    
    @Override
    protected void loadTemplates(final StructureManager templateManager) {
        this.TEMPLATE = templateManager.m_74341_(this.HEDGE);
        this.templateBig = templateManager.m_74341_(this.HEDGE_BIG);
    }
    
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random randomIn, final BoundingBox structureBoundingBox, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        this.placeSettings.m_74381_(structureBoundingBox).m_74394_();
        this.TEMPLATE.m_74536_((ServerLevelAccessor)world, this.rotatedPosition, this.rotatedPosition, this.placeSettings.m_74394_().m_74383_((StructureProcessor)NagastoneVariants.INSTANCE), randomIn, 18);
        this.templateBig.m_74536_((ServerLevelAccessor)world, this.rotatedPosition, this.rotatedPosition, this.placeSettings.m_74383_((StructureProcessor)BlockIgnoreProcessor.f_74047_).m_74383_((StructureProcessor)new BlockRotProcessor(0.5f)), randomIn, 18);
        return true;
    }
    
    @Override
    public NoiseEffect m_142318_() {
        return NoiseEffect.BEARD;
    }
}
