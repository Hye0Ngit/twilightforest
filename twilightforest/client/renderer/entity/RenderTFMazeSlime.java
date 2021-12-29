// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.entity.RenderSlime;

public class RenderTFMazeSlime extends RenderSlime
{
    private static final ResourceLocation textureLoc;
    
    public RenderTFMazeSlime(final RenderManager manager, final float shadowSize) {
        super(manager);
        this.field_76989_e = shadowSize;
    }
    
    protected ResourceLocation func_110775_a(final EntitySlime entity) {
        return RenderTFMazeSlime.textureLoc;
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("mazeslime.png");
    }
}
