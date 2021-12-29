// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import com.mojang.math.Vector3f;
import net.minecraft.world.entity.LivingEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import twilightforest.client.model.entity.UpperGoblinKnightModel;
import twilightforest.entity.monster.UpperGoblinKnight;

public class UpperGoblinKnightRenderer extends TFBipedRenderer<UpperGoblinKnight, UpperGoblinKnightModel>
{
    public UpperGoblinKnightRenderer(final EntityRendererProvider.Context manager, final UpperGoblinKnightModel model, final float shadowSize) {
        super(manager, model, shadowSize, "doublegoblin.png");
    }
    
    protected void setupRotations(final UpperGoblinKnight upperKnight, final PoseStack stack, final float ageInTicks, final float rotationYaw, final float partialTicks) {
        super.m_7523_((LivingEntity)upperKnight, stack, ageInTicks, rotationYaw, partialTicks);
        if (upperKnight.heavySpearTimer > 0) {
            stack.m_85845_(Vector3f.f_122223_.m_122240_(this.getPitchForAttack(60 - upperKnight.heavySpearTimer + partialTicks)));
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
