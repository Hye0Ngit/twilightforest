// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.boss.BossStatus;
import twilightforest.entity.boss.EntityTFSnowQueen;
import org.lwjgl.opengl.GL11;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelBiped;
import twilightforest.client.model.ModelTFSnowQueen;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.entity.RenderBiped;

public class RenderTFSnowQueen extends RenderBiped
{
    private static final ResourceLocation textureLoc;
    
    public RenderTFSnowQueen() {
        super((ModelBiped)new ModelTFSnowQueen(), 0.625f);
    }
    
    protected ResourceLocation func_110775_a(final Entity par1Entity) {
        return RenderTFSnowQueen.textureLoc;
    }
    
    protected void func_77041_b(final EntityLivingBase par1EntityLivingBase, final float par2) {
        final float scale = 1.2f;
        GL11.glScalef(scale, scale, scale);
    }
    
    public void func_76986_a(final Entity entity, final double d, final double d1, final double d2, final float f, final float f1) {
        final EntityTFSnowQueen queen = (EntityTFSnowQueen)entity;
        BossStatus.func_82824_a((IBossDisplayData)queen, false);
        super.func_76986_a(entity, d, d1, d2, f, f1);
        for (int i = 0; i < queen.iceArray.length; ++i) {
            RenderManager.field_78727_a.func_147937_a(queen.iceArray[i], f1);
        }
    }
    
    static {
        textureLoc = new ResourceLocation("twilightforest:textures/model/snowqueen.png");
    }
}
