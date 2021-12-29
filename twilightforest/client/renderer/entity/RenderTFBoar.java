// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.entity.RenderPig;

public class RenderTFBoar extends RenderPig
{
    private static final ResourceLocation textureLoc;
    
    public RenderTFBoar(final RenderManager manager, final ModelBase model) {
        super(manager);
        this.field_77045_g = model;
    }
    
    protected ResourceLocation func_110775_a(final EntityPig entity) {
        return RenderTFBoar.textureLoc;
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("wildboar.png");
    }
}
