// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import org.lwjgl.opengl.GL11;
import twilightforest.entity.EntityTFLichMinion;

public class ModelTFLichMinion extends axx
{
    public void a(final md par1EntityLiving, final float par2, final float par3, final float time) {
        final EntityTFLichMinion minion = (EntityTFLichMinion)par1EntityLiving;
        if (minion.b(ll.g) != null) {
            GL11.glColor3f(0.25f, 2.0f, 0.25f);
        }
        else {
            GL11.glColor3f(0.5f, 1.0f, 0.5f);
        }
    }
    
    public void a(final lq par1Entity, final float par2, final float par3, final float par4, final float par5, final float par6, final float par7) {
        final EntityTFLichMinion minion = (EntityTFLichMinion)par1Entity;
        if (minion.b(ll.g) != null) {
            super.a(par1Entity, par2, par3, par4, par5, par6, par7);
        }
        else {
            super.a(par1Entity, par2, par3, par4, par5, par6, par7);
        }
    }
}
