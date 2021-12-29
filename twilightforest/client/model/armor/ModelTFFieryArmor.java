// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.armor;

import org.lwjgl.opengl.GL11;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.entity.Entity;

public class ModelTFFieryArmor extends ModelTFArmor
{
    public ModelTFFieryArmor(final float expand) {
        super(expand);
    }
    
    public void func_78088_a(final Entity entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch, final float scale) {
        final float prevX = OpenGlHelper.lastBrightnessX;
        final float prevY = OpenGlHelper.lastBrightnessY;
        OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, 240.0f, 240.0f);
        GL11.glMaterial(1032, 5632, RenderHelper.func_74521_a(1.0f, 1.0f, 1.0f, 1.0f));
        super.func_78088_a(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        GL11.glMaterial(1032, 5632, RenderHelper.func_74521_a(0.0f, 0.0f, 0.0f, 1.0f));
        OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, prevX, prevY);
    }
}
