// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.courtyard;

import net.minecraft.world.gen.structure.template.ITemplateProcessor;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.gen.structure.template.TemplateManager;
import net.minecraft.util.Rotation;
import twilightforest.TFFeature;
import net.minecraft.util.ResourceLocation;
import twilightforest.structures.StructureTFComponentTemplate;

public abstract class ComponentNagaCourtyardTerraceAbstract extends StructureTFComponentTemplate
{
    private final ResourceLocation TERRACE;
    
    public ComponentNagaCourtyardTerraceAbstract(final ResourceLocation terrace) {
        this.TERRACE = terrace;
    }
    
    public ComponentNagaCourtyardTerraceAbstract(final TFFeature feature, final int i, final int x, final int y, final int z, final Rotation rotation, final ResourceLocation terrace) {
        super(feature, i, x, y, z, rotation);
        this.TERRACE = terrace;
    }
    
    @Override
    protected void loadTemplates(final TemplateManager templateManager, final MinecraftServer server) {
        this.TEMPLATE = templateManager.func_186237_a(server, this.TERRACE);
    }
    
    public boolean func_74875_a(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
        this.placeSettings.func_186223_a(structureBoundingBox);
        this.TEMPLATE.func_189960_a(world, this.rotatedPosition, (ITemplateProcessor)new CourtyardTerraceTemplateProcessor(this.rotatedPosition, this.placeSettings), this.placeSettings, 18);
        return true;
    }
}
