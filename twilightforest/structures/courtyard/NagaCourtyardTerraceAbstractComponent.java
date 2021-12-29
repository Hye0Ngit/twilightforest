// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.courtyard;

import net.minecraft.world.IServerWorld;
import net.minecraft.world.gen.feature.template.StructureProcessor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import java.util.Random;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.ISeedReader;
import net.minecraft.util.Rotation;
import twilightforest.TFFeature;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraft.world.gen.feature.template.TemplateManager;
import net.minecraft.util.ResourceLocation;
import twilightforest.structures.TFStructureComponentTemplate;

public abstract class NagaCourtyardTerraceAbstractComponent extends TFStructureComponentTemplate
{
    private final ResourceLocation TERRACE;
    
    public NagaCourtyardTerraceAbstractComponent(final TemplateManager manager, final IStructurePieceType piece, final CompoundNBT nbt, final ResourceLocation terrace) {
        super(manager, piece, nbt);
        this.TERRACE = terrace;
    }
    
    public NagaCourtyardTerraceAbstractComponent(final IStructurePieceType type, final TFFeature feature, final int i, final int x, final int y, final int z, final Rotation rotation, final ResourceLocation terrace) {
        super(type, feature, i, x, y, z, rotation);
        this.TERRACE = terrace;
    }
    
    @Override
    protected void loadTemplates(final TemplateManager templateManager) {
        this.TEMPLATE = templateManager.func_200219_b(this.TERRACE);
    }
    
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random random, final MutableBoundingBox structureBoundingBox, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        this.placeSettings.func_186223_a(structureBoundingBox).func_215219_b().func_215222_a((StructureProcessor)new CourtyardTerraceTemplateProcessor(0.0f));
        this.TEMPLATE.func_237146_a_((IServerWorld)world, this.rotatedPosition, this.rotatedPosition, this.placeSettings, random, 18);
        return true;
    }
}
