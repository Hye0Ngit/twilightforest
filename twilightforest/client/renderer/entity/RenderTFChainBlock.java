// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.model.ModelBase;
import net.minecraft.util.ResourceLocation;
import twilightforest.entity.EntityTFChainBlock;
import net.minecraft.client.renderer.entity.Render;

public class RenderTFChainBlock extends Render<EntityTFChainBlock>
{
    private static final ResourceLocation textureLoc;
    private final ModelBase model;
    
    public RenderTFChainBlock(final RenderManager manager, final ModelBase modelTFSpikeBlock) {
        super(manager);
        this.model = modelTFSpikeBlock;
    }
    
    public void doRender(final EntityTFChainBlock chainBlock, final double x, final double y, final double z, final float yaw, final float partialTicks) {
        super.func_76986_a((Entity)chainBlock, x, y, z, yaw, partialTicks);
        GlStateManager.func_179094_E();
        GlStateManager.func_179137_b(x, y, z);
        this.func_180548_c((Entity)chainBlock);
        GlStateManager.func_179152_a(-1.0f, -1.0f, 1.0f);
        GlStateManager.func_179114_b(MathHelper.func_76142_g((float)y), 1.0f, 0.0f, 1.0f);
        GlStateManager.func_179114_b(MathHelper.func_76142_g(((float)x + (float)z) * 11.0f), 0.0f, 1.0f, 0.0f);
        this.model.func_78088_a((Entity)chainBlock, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0625f);
        GlStateManager.func_179121_F();
        this.field_76990_c.func_188388_a((Entity)chainBlock.chain1, partialTicks, false);
        this.field_76990_c.func_188388_a((Entity)chainBlock.chain2, partialTicks, false);
        this.field_76990_c.func_188388_a((Entity)chainBlock.chain3, partialTicks, false);
        this.field_76990_c.func_188388_a((Entity)chainBlock.chain4, partialTicks, false);
        this.field_76990_c.func_188388_a((Entity)chainBlock.chain5, partialTicks, false);
    }
    
    protected ResourceLocation getEntityTexture(final EntityTFChainBlock entity) {
        return RenderTFChainBlock.textureLoc;
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("blockgoblin.png");
    }
}
