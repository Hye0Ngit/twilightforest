// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.courtyard;

import twilightforest.structures.MossyCobbleTemplateProcessor;
import net.minecraft.world.gen.structure.template.ITemplateProcessor;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.gen.structure.template.TemplateManager;
import net.minecraft.util.Rotation;
import twilightforest.TFFeature;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.util.ResourceLocation;
import twilightforest.structures.StructureTFComponentTemplate;

public class ComponentNagaCourtyardWallAbstract extends StructureTFComponentTemplate
{
    private final ResourceLocation WALL;
    private final ResourceLocation WALL_DECAYED;
    private Template decayTemplate;
    
    public ComponentNagaCourtyardWallAbstract(final ResourceLocation wall, final ResourceLocation wall_decayed) {
        this.WALL = wall;
        this.WALL_DECAYED = wall_decayed;
    }
    
    public ComponentNagaCourtyardWallAbstract(final TFFeature feature, final int i, final int x, final int y, final int z, final Rotation rotation, final ResourceLocation wall, final ResourceLocation wall_decayed) {
        super(feature, i, x, y, z, rotation);
        this.WALL = wall;
        this.WALL_DECAYED = wall_decayed;
    }
    
    @Override
    protected void loadTemplates(final TemplateManager templateManager, final MinecraftServer server) {
        this.TEMPLATE = templateManager.func_186237_a(server, this.WALL);
        this.decayTemplate = templateManager.func_186237_a(server, this.WALL_DECAYED);
    }
    
    public boolean func_74875_a(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
        this.placeSettings.func_186223_a(structureBoundingBox);
        this.TEMPLATE.func_189960_a(world, this.rotatedPosition, (ITemplateProcessor)new CourtyardWallTemplateProcessor(this.rotatedPosition, this.placeSettings), this.placeSettings.func_189946_a(0.9f), 18);
        this.decayTemplate.func_189960_a(world, this.rotatedPosition, (ITemplateProcessor)new MossyCobbleTemplateProcessor(this.rotatedPosition, this.placeSettings), this.placeSettings.func_189946_a(0.1f), 18);
        return true;
    }
}
