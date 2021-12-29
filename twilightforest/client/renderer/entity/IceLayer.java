// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import net.minecraft.entity.Entity;
import net.minecraftforge.client.model.data.IModelData;
import net.minecraftforge.client.model.data.EmptyModelData;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.util.math.vector.Vector3f;
import twilightforest.potions.FrostedPotion;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import java.util.Random;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.entity.LivingEntity;

public class IceLayer<T extends LivingEntity, M extends EntityModel<T>> extends LayerRenderer<T, M>
{
    private final Random random;
    
    public IceLayer(final IEntityRenderer<T, M> renderer) {
        super((IEntityRenderer)renderer);
        this.random = new Random();
    }
    
    public void render(final MatrixStack stack, final IRenderTypeBuffer buffer, final int light, final T entity, final float limbSwing, final float limbSwingAmount, final float partialTicks, final float ageInTicks, final float netHeadYaw, final float headPitch) {
        if (entity.func_110148_a(Attributes.field_233821_d_).func_111127_a(FrostedPotion.MODIFIER_UUID) == null) {
            return;
        }
        this.random.setSeed(entity.func_145782_y() * entity.func_145782_y() * 3121 + entity.func_145782_y() * 45238971);
        for (int numCubes = (int)(entity.func_213302_cg() / 0.4f), i = 0; i < numCubes; ++i) {
            stack.func_227860_a_();
            final float dx = (float)(this.random.nextGaussian() * 0.20000000298023224 * entity.func_213311_cf());
            final float dy = (float)(this.random.nextGaussian() * 0.20000000298023224 * entity.func_213302_cg()) + entity.func_213302_cg() / 2.0f;
            final float dz = (float)(this.random.nextGaussian() * 0.20000000298023224 * entity.func_213311_cf());
            stack.func_227861_a_((double)dx, (double)dy, (double)dz);
            stack.func_227862_a_(0.5f, 0.5f, 0.5f);
            stack.func_227863_a_(Vector3f.field_229179_b_.func_229187_a_(this.random.nextFloat() * 360.0f));
            stack.func_227863_a_(Vector3f.field_229181_d_.func_229187_a_(this.random.nextFloat() * 360.0f));
            stack.func_227863_a_(Vector3f.field_229183_f_.func_229187_a_(this.random.nextFloat() * 360.0f));
            stack.func_227861_a_(-0.5, -0.5, -0.5);
            Minecraft.func_71410_x().func_175602_ab().renderBlock(Blocks.field_150432_aD.func_176223_P(), stack, buffer, light, OverlayTexture.field_229196_a_, (IModelData)EmptyModelData.INSTANCE);
            stack.func_227865_b_();
        }
    }
}
