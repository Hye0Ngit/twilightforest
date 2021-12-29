// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model;

import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;
import net.minecraft.potion.Potion;
import twilightforest.entity.EntityTFLichMinion;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.model.ModelZombie;

public class ModelTFLichMinion extends ModelZombie
{
    public void func_78086_a(final EntityLivingBase par1EntityLiving, final float par2, final float par3, final float time) {
        final EntityTFLichMinion minion = (EntityTFLichMinion)par1EntityLiving;
        if (minion.func_70660_b(Potion.field_76420_g) != null) {
            GL11.glColor3f(0.25f, 2.0f, 0.25f);
        }
        else {
            GL11.glColor3f(0.5f, 1.0f, 0.5f);
        }
    }
    
    public void func_78088_a(final Entity par1Entity, final float par2, final float par3, final float par4, final float par5, final float par6, final float par7) {
        final EntityTFLichMinion minion = (EntityTFLichMinion)par1Entity;
        if (minion.func_70660_b(Potion.field_76420_g) != null) {
            super.func_78088_a(par1Entity, par2, par3, par4, par5, par6, par7);
        }
        else {
            super.func_78088_a(par1Entity, par2, par3, par4, par5, par6, par7);
        }
    }
}
