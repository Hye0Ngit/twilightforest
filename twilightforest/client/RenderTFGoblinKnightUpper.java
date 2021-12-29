// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import org.lwjgl.opengl.GL11;
import twilightforest.entity.EntityTFGoblinKnightUpper;
import net.minecraft.entity.EntityLiving;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;

public class RenderTFGoblinKnightUpper extends RenderBiped
{
    public RenderTFGoblinKnightUpper(final ModelBiped par1ModelBiped, final float par2) {
        super(par1ModelBiped, par2);
    }
    
    protected void func_77043_a(final EntityLiving par1EntityLiving, final float par2, final float par3, final float par4) {
        this.rotateGoblinKnight((EntityTFGoblinKnightUpper)par1EntityLiving, par2, par3, par4);
    }
    
    protected void rotateGoblinKnight(final EntityTFGoblinKnightUpper upperKnight, final float par2, final float par3, final float par4) {
        super.func_77043_a((EntityLiving)upperKnight, par2, par3, par4);
        if (upperKnight.heavySpearTimer > 0) {
            GL11.glRotatef(this.getPitchForAttack(60 - upperKnight.heavySpearTimer + par4), 1.0f, 0.0f, 0.0f);
        }
    }
    
    public float getPitchForAttack(final float attackTime) {
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
