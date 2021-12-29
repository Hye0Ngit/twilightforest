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
import net.minecraft.world.gen.feature.template.TemplateManager;
import net.minecraft.util.ResourceLocation;
import twilightforest.structures.TFStructureComponentTemplate;

public class NagaCourtyardPathComponent extends TFStructureComponentTemplate
{
    private static final ResourceLocation PATH;
    
    public NagaCourtyardPathComponent(final TemplateManager manager, final CompoundNBT nbt) {
        super(manager, NagaCourtyardPieces.TFNCPa, nbt);
    }
    
    public NagaCourtyardPathComponent(final TFFeature feature, final int i, final int x, final int y, final int z) {
        super(NagaCourtyardPieces.TFNCPa, feature, i, x, y, z, Rotation.NONE);
    }
    
    @Override
    protected void loadTemplates(final TemplateManager templateManager) {
        this.TEMPLATE = templateManager.func_200219_b(NagaCourtyardPathComponent.PATH);
    }
    
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random random, final MutableBoundingBox structureBoundingBox, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        this.placeSettings.func_186223_a(structureBoundingBox).func_215222_a((StructureProcessor)new CourtyardWallTemplateProcessor(0.0f));
        this.TEMPLATE.func_237146_a_((IServerWorld)world, this.templatePosition, this.templatePosition, this.placeSettings, random, 18);
        return true;
    }
    
    static {
        PATH = new ResourceLocation("twilightforest", "courtyard/pathway");
    }
}
