// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.courtyard;

import twilightforest.structures.MossyCobbleTemplateProcessor;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.gen.feature.template.BlockIgnoreStructureProcessor;
import net.minecraft.world.gen.feature.template.IntegrityProcessor;
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
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.util.ResourceLocation;
import twilightforest.structures.TFStructureComponentTemplate;

public class NagaCourtyardWallAbstractComponent extends TFStructureComponentTemplate
{
    private final ResourceLocation WALL;
    private final ResourceLocation WALL_DECAYED;
    private Template decayTemplate;
    
    public NagaCourtyardWallAbstractComponent(final TemplateManager manager, final IStructurePieceType piece, final CompoundNBT nbt, final ResourceLocation wall, final ResourceLocation wall_decayed) {
        super(manager, piece, nbt);
        this.WALL = wall;
        this.WALL_DECAYED = wall_decayed;
    }
    
    public NagaCourtyardWallAbstractComponent(final IStructurePieceType type, final TFFeature feature, final int i, final int x, final int y, final int z, final Rotation rotation, final ResourceLocation wall, final ResourceLocation wall_decayed) {
        super(type, feature, i, x, y, z, rotation);
        this.WALL = wall;
        this.WALL_DECAYED = wall_decayed;
    }
    
    @Override
    protected void loadTemplates(final TemplateManager templateManager) {
        this.TEMPLATE = templateManager.func_200219_b(this.WALL);
        this.decayTemplate = templateManager.func_200219_b(this.WALL_DECAYED);
    }
    
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random random, final MutableBoundingBox structureBoundingBox, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        this.placeSettings.func_186223_a(structureBoundingBox).func_215219_b();
        this.TEMPLATE.func_237146_a_((IServerWorld)world, this.rotatedPosition, this.rotatedPosition, this.placeSettings.func_215222_a((StructureProcessor)new CourtyardWallTemplateProcessor(0.0f)).func_215222_a((StructureProcessor)new IntegrityProcessor(0.95f)).func_215222_a((StructureProcessor)BlockIgnoreStructureProcessor.field_215205_b), random, 18);
        this.decayTemplate.func_237146_a_((IServerWorld)world, this.rotatedPosition, this.rotatedPosition, this.placeSettings.func_215219_b().func_215222_a((StructureProcessor)new MossyCobbleTemplateProcessor(0.0f)).func_215222_a((StructureProcessor)new IntegrityProcessor(0.1f)), random, 18);
        return true;
    }
}
