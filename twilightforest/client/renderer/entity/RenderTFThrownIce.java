// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.ResourceLocation;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;
import net.minecraft.util.MathHelper;
import twilightforest.entity.boss.EntityTFIceBomb;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.entity.Render;

public class RenderTFThrownIce extends Render
{
    private final RenderBlocks renderBlocks;
    
    public RenderTFThrownIce() {
        this.renderBlocks = new RenderBlocks();
    }
    
    public void func_76986_a(final Entity var1, final double var2, final double var4, final double var6, final float var8, final float var9) {
        this.doRender((EntityTFIceBomb)var1, var2, var4, var6, var8, var9);
    }
    
    public void doRender(final EntityTFIceBomb entity, final double x, final double y, final double z, final float p_147918_8_, final float p_147918_9_) {
        final World world = entity.field_70170_p;
        final Block block = entity.getBlock();
        final int i = MathHelper.func_76128_c(entity.field_70165_t);
        final int j = MathHelper.func_76128_c(entity.field_70163_u);
        final int k = MathHelper.func_76128_c(entity.field_70161_v);
        if (block != null && block != world.func_147439_a(i, j, k)) {
            GL11.glPushMatrix();
            GL11.glTranslatef((float)x, (float)y, (float)z);
            this.func_110777_b((Entity)entity);
            GL11.glDisable(2896);
            this.renderBlocks.func_147775_a(block);
            this.renderBlocks.func_147749_a(block, world, i, j, k, 0);
            GL11.glEnable(2896);
            GL11.glPopMatrix();
        }
    }
    
    protected ResourceLocation func_110775_a(final Entity var1) {
        return TextureMap.field_110575_b;
    }
}
