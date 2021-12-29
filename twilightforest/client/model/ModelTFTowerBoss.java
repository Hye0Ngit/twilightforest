// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model;

import net.minecraft.util.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelBase;
import java.util.Random;
import net.minecraft.client.model.ModelRenderer;

public class ModelTFTowerBoss extends ModelTFGhast
{
    protected ModelRenderer[][] subTentacles;
    protected ModelRenderer[][] smallTentacles;
    
    public ModelTFTowerBoss() {
        this.smallTentacles = new ModelRenderer[2][3];
        for (int i = 0; i < this.smallTentacles.length; ++i) {
            this.makeSmallTentacle(i);
        }
    }
    
    @Override
    protected void makeTentacle(final byte yOffset, final Random random, final int num) {
        this.tentacles[num] = new ModelRenderer((ModelBase)this, num % 3, 0);
        int length = 5;
        this.tentacles[num].func_78789_a(-1.5f, 0.0f, -1.5f, 3, length, 3);
        if (num == 0) {
            this.tentacles[num].field_78800_c = 4.5f;
            this.tentacles[num].field_78798_e = 4.5f;
            this.tentacles[num].field_78797_d = (float)(23 + yOffset);
        }
        if (num == 1) {
            this.tentacles[num].field_78800_c = -4.5f;
            this.tentacles[num].field_78798_e = 4.5f;
            this.tentacles[num].field_78797_d = (float)(23 + yOffset);
        }
        if (num == 2) {
            this.tentacles[num].field_78800_c = 0.0f;
            this.tentacles[num].field_78798_e = 0.0f;
            this.tentacles[num].field_78797_d = (float)(23 + yOffset);
        }
        if (num == 3) {
            this.tentacles[num].field_78800_c = 5.5f;
            this.tentacles[num].field_78798_e = -4.5f;
            this.tentacles[num].field_78797_d = (float)(23 + yOffset);
        }
        if (num == 4) {
            this.tentacles[num].field_78800_c = -5.5f;
            this.tentacles[num].field_78798_e = -4.5f;
            this.tentacles[num].field_78797_d = (float)(23 + yOffset);
        }
        else if (num == 5) {
            this.tentacles[num].field_78800_c = -7.5f;
            this.tentacles[num].field_78797_d = 3.5f;
            this.tentacles[num].field_78798_e = -1.0f;
            this.tentacles[num].field_78808_h = 0.7853982f;
        }
        else if (num == 6) {
            this.tentacles[num].field_78800_c = -7.5f;
            this.tentacles[num].field_78797_d = -1.5f;
            this.tentacles[num].field_78798_e = 3.5f;
            this.tentacles[num].field_78808_h = 1.0471976f;
        }
        else if (num == 7) {
            this.tentacles[num].field_78800_c = 7.5f;
            this.tentacles[num].field_78797_d = 3.5f;
            this.tentacles[num].field_78798_e = -1.0f;
            this.tentacles[num].field_78808_h = -0.7853982f;
        }
        else if (num == 8) {
            this.tentacles[num].field_78800_c = 7.5f;
            this.tentacles[num].field_78797_d = -1.5f;
            this.tentacles[num].field_78798_e = 3.5f;
            this.tentacles[num].field_78808_h = -1.0471976f;
        }
        if (this.subTentacles == null) {
            this.subTentacles = new ModelRenderer[this.tentacles.length][3];
        }
        for (int i = 0; i < 3; ++i) {
            length = 4;
            (this.subTentacles[num][i] = new ModelRenderer((ModelBase)this, num % 4, i * 5 - 1)).func_78789_a(-1.5f, -0.5f, -1.5f, 3, length, 3);
            this.subTentacles[num][i].field_78800_c = 0.0f;
            this.subTentacles[num][i].field_78798_e = 0.0f;
            this.subTentacles[num][i].field_78797_d = (float)length;
            if (i == 0) {
                this.tentacles[num].func_78792_a(this.subTentacles[num][i]);
            }
            else {
                this.subTentacles[num][i - 1].func_78792_a(this.subTentacles[num][i]);
            }
        }
        this.body.func_78792_a(this.tentacles[num]);
    }
    
    protected void makeSmallTentacle(final int num) {
    }
    
    @Override
    public void func_78087_a(final float par1, final float par2, final float timeAlive, final float yaw, final float pitch, final float par6, final Entity par7Entity) {
        super.func_78087_a(par1, par2, timeAlive, yaw, pitch, par6, par7Entity);
        for (int i = 0; i < this.subTentacles.length; ++i) {
            final float wiggle = Math.min(par2, 0.6f);
            final float time = (timeAlive + i * 9) / 2.0f;
            this.subTentacles[i][0].field_78795_f = (MathHelper.func_76134_b(time * 0.6662f) * 1.0f - 1.0471976f) * wiggle;
            this.subTentacles[i][1].field_78795_f = MathHelper.func_76134_b(time * 0.7774f) * 1.2f * wiggle;
            this.subTentacles[i][2].field_78795_f = MathHelper.func_76134_b(time * 0.8886f + 1.5707964f) * 1.4f * wiggle;
            this.subTentacles[i][0].field_78795_f = 0.2f + MathHelper.func_76134_b(time * 0.3335f) * 0.15f;
            this.subTentacles[i][1].field_78795_f = 0.1f + MathHelper.func_76134_b(time * 0.4445f) * 0.2f;
            this.subTentacles[i][2].field_78795_f = 0.1f + MathHelper.func_76134_b(time * 0.5555f) * 0.25f;
            final float yTwist = 0.4f;
            this.tentacles[i].field_78796_g = yTwist * MathHelper.func_76126_a(time * 0.3f);
        }
    }
}
