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

public class ComponentNagaCourtyardPath extends StructureTFComponentTemplate
{
    private static final ResourceLocation PATH;
    
    public ComponentNagaCourtyardPath() {
    }
    
    public ComponentNagaCourtyardPath(final TFFeature feature, final int i, final int x, final int y, final int z) {
        super(feature, i, x, y, z, Rotation.NONE);
    }
    
    @Override
    protected void loadTemplates(final TemplateManager templateManager, final MinecraftServer server) {
        this.TEMPLATE = templateManager.func_186237_a(server, ComponentNagaCourtyardPath.PATH);
    }
    
    public boolean func_74875_a(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
        this.placeSettings.func_186223_a(structureBoundingBox);
        this.TEMPLATE.func_189960_a(world, this.templatePosition, (ITemplateProcessor)new CourtyardWallTemplateProcessor(this.templatePosition, this.placeSettings), this.placeSettings, 18);
        return true;
    }
    
    static {
        PATH = new ResourceLocation("twilightforest", "courtyard/pathway");
    }
}
