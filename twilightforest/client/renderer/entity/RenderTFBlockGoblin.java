// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import twilightforest.entity.EntityTFBlockGoblin;
import net.minecraft.client.renderer.entity.RenderBiped;

public class RenderTFBlockGoblin extends RenderBiped<EntityTFBlockGoblin>
{
    private static final ResourceLocation textureLoc;
    
    public RenderTFBlockGoblin(final RenderManager manager, final ModelBiped model, final float shadowSize) {
        super(manager, model, shadowSize);
    }
    
    public void doRender(final EntityTFBlockGoblin goblin, final double x, final double y, final double z, final float yaw, final float partialTicks) {
        super.func_76986_a((EntityLiving)goblin, x, y, z, yaw, partialTicks);
        this.field_76990_c.func_188388_a((Entity)goblin.block, partialTicks, false);
        this.field_76990_c.func_188388_a((Entity)goblin.chain1, partialTicks, false);
        this.field_76990_c.func_188388_a((Entity)goblin.chain2, partialTicks, false);
        this.field_76990_c.func_188388_a((Entity)goblin.chain3, partialTicks, false);
    }
    
    protected ResourceLocation getEntityTexture(final EntityTFBlockGoblin entity) {
        return RenderTFBlockGoblin.textureLoc;
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("blockgoblin.png");
    }
}
