// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.client.renderer.model.ModelRenderer;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;
import twilightforest.entity.RisingZombieEntity;
import net.minecraft.client.renderer.entity.model.ZombieModel;

public class RisingZombieModel extends ZombieModel<RisingZombieEntity>
{
    public RisingZombieModel(final boolean armor) {
        super(0.0f, armor);
    }
    
    public void func_225598_a_(final MatrixStack stack, final IVertexBuilder builder, final int light, final int overlay, final float red, final float green, final float blue, final float scale) {
        stack.func_227860_a_();
        if (this.field_217114_e) {
            stack.func_227860_a_();
            stack.func_227862_a_(0.75f, 0.75f, 0.75f);
            stack.func_227861_a_(0.0, (double)(16.0f * scale), 0.0);
            this.func_225602_a_().forEach(renderer -> renderer.func_228309_a_(stack, builder, light, overlay, red, green, blue, scale));
            stack.func_227865_b_();
            stack.func_227860_a_();
            stack.func_227862_a_(0.5f, 0.5f, 0.5f);
            stack.func_227861_a_(0.0, (double)(24.0f * scale), 0.0);
            this.field_78115_e.func_228309_a_(stack, builder, light, overlay, red, green, blue, scale);
            this.field_178723_h.func_228309_a_(stack, builder, light, overlay, red, green, blue, scale);
            this.field_178724_i.func_228309_a_(stack, builder, light, overlay, red, green, blue, scale);
            this.field_178720_f.func_228309_a_(stack, builder, light, overlay, red, green, blue, scale);
            stack.func_227865_b_();
            this.field_178721_j.func_228309_a_(stack, builder, light, overlay, red, green, blue, scale);
            this.field_178722_k.func_228309_a_(stack, builder, light, overlay, red, green, blue, scale);
        }
        else {
            if (this.field_228270_o_) {
                stack.func_227861_a_(0.0, 0.20000000298023224, 0.0);
            }
            stack.func_227860_a_();
            final float yOff = 1.0f;
            stack.func_227861_a_(0.0, 1.0, 0.0);
            stack.func_227861_a_(0.0, -1.0, 0.0);
            this.func_225602_a_().forEach(renderer -> renderer.func_228309_a_(stack, builder, light, overlay, red, green, blue, scale));
            this.field_78115_e.func_228309_a_(stack, builder, light, overlay, red, green, blue, scale);
            this.field_178723_h.func_228309_a_(stack, builder, light, overlay, red, green, blue, scale);
            this.field_178724_i.func_228309_a_(stack, builder, light, overlay, red, green, blue, scale);
            this.field_178720_f.func_228309_a_(stack, builder, light, overlay, red, green, blue, scale);
            stack.func_227865_b_();
            this.field_178721_j.func_228309_a_(stack, builder, light, overlay, red, green, blue, scale);
            this.field_178722_k.func_228309_a_(stack, builder, light, overlay, red, green, blue, scale);
        }
        stack.func_227865_b_();
    }
}
