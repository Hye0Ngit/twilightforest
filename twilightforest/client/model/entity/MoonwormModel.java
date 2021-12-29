// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;
import twilightforest.client.BugModelAnimationHelper;
import net.minecraft.util.math.MathHelper;
import javax.annotation.Nullable;
import twilightforest.tileentity.MoonwormTileEntity;
import java.util.function.Function;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.model.Model;

public class MoonwormModel extends Model
{
    ModelRenderer shape1;
    ModelRenderer shape2;
    ModelRenderer shape3;
    ModelRenderer head;
    
    public MoonwormModel() {
        super((Function)RenderType::func_228640_c_);
        this.field_78090_t = 32;
        this.field_78089_u = 32;
        (this.shape1 = new ModelRenderer((Model)this, 0, 4)).func_228300_a_(-1.0f, -1.0f, -1.0f, 4.0f, 2.0f, 2.0f);
        this.shape1.func_78793_a(-1.0f, 7.0f, 3.0f);
        (this.shape2 = new ModelRenderer((Model)this, 0, 8)).func_228300_a_(-1.0f, -1.0f, -1.0f, 2.0f, 2.0f, 4.0f);
        this.shape2.func_78793_a(3.0f, 7.0f, 0.0f);
        (this.shape3 = new ModelRenderer((Model)this, 0, 14)).func_228300_a_(-1.0f, -1.0f, -1.0f, 2.0f, 2.0f, 2.0f);
        this.shape3.func_78793_a(2.0f, 7.0f, -2.0f);
        (this.head = new ModelRenderer((Model)this, 0, 0)).func_228300_a_(-1.0f, -1.0f, -1.0f, 2.0f, 2.0f, 2.0f);
        this.head.func_78793_a(-3.0f, 7.0f, 2.0f);
    }
    
    public void setRotationAngles(@Nullable final MoonwormTileEntity moonworm, final float partialTime) {
        this.head.field_78797_d = 7.0f;
        this.shape1.field_78797_d = 7.0f;
        this.shape2.field_78797_d = 7.0f;
        this.shape3.field_78797_d = 7.0f;
        if (moonworm != null && moonworm.yawDelay == 0) {
            final float time = moonworm.desiredYaw - moonworm.currentYaw - partialTime;
            final ModelRenderer head = this.head;
            head.field_78797_d += Math.min(0.0f, MathHelper.func_76126_a(time / 2.0f));
            final ModelRenderer shape1 = this.shape1;
            shape1.field_78797_d += Math.min(0.0f, MathHelper.func_76126_a(time / 2.0f + 1.0f));
            final ModelRenderer shape2 = this.shape2;
            shape2.field_78797_d += Math.min(0.0f, MathHelper.func_76126_a(time / 2.0f + 2.0f));
            final ModelRenderer shape3 = this.shape3;
            shape3.field_78797_d += Math.min(0.0f, MathHelper.func_76126_a(time / 2.0f + 3.0f));
        }
        else if (moonworm == null && BugModelAnimationHelper.yawWriggleDelay == 0) {
            final float time = BugModelAnimationHelper.desiredRotation - BugModelAnimationHelper.currentRotation - partialTime;
            final ModelRenderer head2 = this.head;
            head2.field_78797_d += Math.min(0.0f, MathHelper.func_76126_a(time / 2.0f));
            final ModelRenderer shape4 = this.shape1;
            shape4.field_78797_d += Math.min(0.0f, MathHelper.func_76126_a(time / 2.0f + 1.0f));
            final ModelRenderer shape5 = this.shape2;
            shape5.field_78797_d += Math.min(0.0f, MathHelper.func_76126_a(time / 2.0f + 2.0f));
            final ModelRenderer shape6 = this.shape3;
            shape6.field_78797_d += Math.min(0.0f, MathHelper.func_76126_a(time / 2.0f + 3.0f));
        }
    }
    
    public void func_225598_a_(final MatrixStack ms, final IVertexBuilder buffer, final int light, final int overlay, final float r, final float g, final float b, final float a) {
        this.shape1.func_228309_a_(ms, buffer, light, overlay, r, g, b, a);
        this.shape2.func_228309_a_(ms, buffer, light, overlay, r, g, b, a);
        this.shape3.func_228309_a_(ms, buffer, light, overlay, r, g, b, a);
        this.head.func_228309_a_(ms, buffer, light, overlay, r, g, b, a);
    }
}
