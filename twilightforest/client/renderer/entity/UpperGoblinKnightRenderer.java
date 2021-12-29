// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.entity.LivingEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import twilightforest.client.model.entity.UpperGoblinKnightModel;
import twilightforest.entity.UpperGoblinKnightEntity;

public class UpperGoblinKnightRenderer extends TFBipedRenderer<UpperGoblinKnightEntity, UpperGoblinKnightModel>
{
    public UpperGoblinKnightRenderer(final EntityRendererManager manager, final UpperGoblinKnightModel model, final float shadowSize) {
        super(manager, model, shadowSize, "doublegoblin.png");
    }
    
    protected void applyRotations(final UpperGoblinKnightEntity upperKnight, final MatrixStack stack, final float ageInTicks, final float rotationYaw, final float partialTicks) {
        super.func_225621_a_((LivingEntity)upperKnight, stack, ageInTicks, rotationYaw, partialTicks);
        if (upperKnight.heavySpearTimer > 0) {
            stack.func_227863_a_(Vector3f.field_229179_b_.func_229187_a_(this.getPitchForAttack(60 - upperKnight.heavySpearTimer + partialTicks)));
        }
    }
    
    private float getPitchForAttack(final float attackTime) {
        if (attackTime <= 10.0f) {
            return attackTime * 3.0f;
        }
        if (attackTime > 10.0f && attackTime <= 30.0f) {
            return 30.0f;
        }
        if (attackTime > 30.0f && attackTime <= 33.0f) {
            return (attackTime - 30.0f) * -25.0f + 30.0f;
        }
        if (attackTime > 33.0f && attackTime <= 50.0f) {
            return -45.0f;
        }
        if (attackTime > 50.0f && attackTime <= 60.0f) {
            return (10.0f - (attackTime - 50.0f)) * -4.5f;
        }
        return 0.0f;
    }
}
