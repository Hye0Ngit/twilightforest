// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.potion.Effects;
import twilightforest.entity.boss.LichMinionEntity;
import net.minecraft.client.renderer.entity.model.ZombieModel;

public class LichMinionModel extends ZombieModel<LichMinionEntity>
{
    private boolean hasStrength;
    
    public LichMinionModel(final boolean isArmor) {
        super(0.0f, isArmor);
    }
    
    public void setLivingAnimations(final LichMinionEntity entity, final float limbSwing, final float limbSwingAmount, final float partialTicks) {
        this.hasStrength = (entity.func_70660_b(Effects.field_76420_g) != null);
    }
    
    public void func_225598_a_(final MatrixStack stack, final IVertexBuilder builder, final int light, final int overlay, final float red, final float green, final float blue, final float scale) {
        if (this.hasStrength) {
            super.func_225598_a_(stack, builder, light, overlay, red * 0.25f, green, blue * 0.25f, scale);
        }
        else {
            super.func_225598_a_(stack, builder, light, overlay, red * 0.5f, green, blue * 0.5f, scale);
        }
    }
}
