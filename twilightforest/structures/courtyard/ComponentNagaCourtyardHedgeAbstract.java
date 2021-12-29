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
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.util.ResourceLocation;
import twilightforest.structures.StructureTFComponentTemplate;

public abstract class ComponentNagaCourtyardHedgeAbstract extends StructureTFComponentTemplate
{
    private final ResourceLocation HEDGE;
    private final ResourceLocation HEDGE_BIG;
    private Template templateBig;
    
    public ComponentNagaCourtyardHedgeAbstract(final ResourceLocation hedge, final ResourceLocation hedgeBig) {
        this.HEDGE = hedge;
        this.HEDGE_BIG = hedgeBig;
    }
    
    public ComponentNagaCourtyardHedgeAbstract(final TFFeature feature, final int i, final int x, final int y, final int z, final Rotation rotation, final ResourceLocation hedge, final ResourceLocation hedgeBig) {
        super(feature, i, x, y, z, rotation);
        this.HEDGE = hedge;
        this.HEDGE_BIG = hedgeBig;
    }
    
    @Override
    protected void loadTemplates(final TemplateManager templateManager, final MinecraftServer server) {
        this.TEMPLATE = templateManager.func_186237_a(server, this.HEDGE);
        this.templateBig = templateManager.func_186237_a(server, this.HEDGE_BIG);
    }
    
    public boolean func_74875_a(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
        this.placeSettings.func_186223_a(structureBoundingBox);
        this.TEMPLATE.func_189960_a(world, this.rotatedPosition, (ITemplateProcessor)new CourtyardStairsTemplateProcessor(this.rotatedPosition, this.placeSettings), this.placeSettings, 18);
        this.templateBig.func_189962_a(world, this.rotatedPosition, this.placeSettings.func_186217_a().func_189946_a(0.5f), 18);
        return true;
    }
}
