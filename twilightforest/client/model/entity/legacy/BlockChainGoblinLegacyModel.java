// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity.legacy;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.BipedModel;
import twilightforest.entity.BlockChainGoblinEntity;

public class BlockChainGoblinLegacyModel<T extends BlockChainGoblinEntity> extends BipedModel<T>
{
    public ModelRenderer helmet;
    ModelRenderer block;
    ModelRenderer[] spikes;
    
    public BlockChainGoblinLegacyModel() {
        super(0.0f);
        this.spikes = new ModelRenderer[27];
        (this.field_78116_c = new ModelRenderer((Model)this, 0, 0)).func_228301_a_(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        this.field_78116_c.func_78793_a(0.0f, 11.0f, 0.0f);
        (this.field_178720_f = new ModelRenderer((Model)this, 0, 0)).func_228301_a_(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.5f);
        this.field_178720_f.func_78793_a(0.0f, 11.0f, 0.0f);
        (this.helmet = new ModelRenderer((Model)this, 24, 0)).func_228300_a_(-2.5f, -9.0f, -2.5f, 5.0f, 9.0f, 5.0f);
        this.helmet.field_78796_g = 0.7853982f;
        this.field_178720_f.func_78792_a(this.helmet);
        (this.field_78115_e = new ModelRenderer((Model)this, 0, 21)).func_228301_a_(-3.5f, 0.0f, -2.0f, 7.0f, 7.0f, 4.0f, 0.0f);
        this.field_78115_e.func_78793_a(0.0f, 11.0f, 0.0f);
        (this.field_178723_h = new ModelRenderer((Model)this, 52, 0)).func_228301_a_(-3.0f, -1.0f, -2.0f, 3.0f, 12.0f, 3.0f, 0.0f);
        this.field_178723_h.func_78793_a(-3.5f, 12.0f, 0.0f);
        (this.field_178724_i = new ModelRenderer((Model)this, 52, 0)).func_228301_a_(0.0f, -1.0f, -1.5f, 3.0f, 12.0f, 3.0f, 0.0f);
        this.field_178724_i.func_78793_a(3.5f, 12.0f, 0.0f);
        (this.field_178721_j = new ModelRenderer((Model)this, 0, 12)).func_228301_a_(-1.5f, 0.0f, -1.5f, 3.0f, 6.0f, 3.0f, 0.0f);
        this.field_178721_j.func_78793_a(-2.0f, 18.0f, 0.0f);
        (this.field_178722_k = new ModelRenderer((Model)this, 0, 12)).func_228301_a_(-1.5f, 0.0f, -1.5f, 3.0f, 6.0f, 3.0f, 0.0f);
        this.field_178722_k.func_78793_a(2.0f, 18.0f, 0.0f);
        (this.block = new ModelRenderer((Model)this, 32, 16)).func_228301_a_(-4.0f, -8.0f, -4.0f, 8.0f, 8.0f, 8.0f, 0.0f);
        this.block.func_78793_a(6.0f, 0.0f, 0.0f);
        for (int i = 0; i < this.spikes.length; ++i) {
            (this.spikes[i] = new ModelRenderer((Model)this, 56, 16)).func_228301_a_(-1.0f, -1.0f, -1.0f, 2.0f, 2.0f, 2.0f, 0.0f);
            this.block.func_78792_a(this.spikes[i]);
        }
        this.spikes[2].field_78800_c = 4.0f;
        this.spikes[3].field_78800_c = 4.0f;
        this.spikes[4].field_78800_c = 4.0f;
        this.spikes[11].field_78800_c = 4.0f;
        this.spikes[12].field_78800_c = 5.0f;
        this.spikes[13].field_78800_c = 4.0f;
        this.spikes[20].field_78800_c = 4.0f;
        this.spikes[21].field_78800_c = 4.0f;
        this.spikes[22].field_78800_c = 4.0f;
        this.spikes[6].field_78800_c = -4.0f;
        this.spikes[7].field_78800_c = -4.0f;
        this.spikes[8].field_78800_c = -4.0f;
        this.spikes[15].field_78800_c = -4.0f;
        this.spikes[16].field_78800_c = -5.0f;
        this.spikes[17].field_78800_c = -4.0f;
        this.spikes[24].field_78800_c = -4.0f;
        this.spikes[25].field_78800_c = -4.0f;
        this.spikes[26].field_78800_c = -4.0f;
        this.spikes[0].field_78797_d = -9.0f;
        this.spikes[1].field_78797_d = -8.0f;
        this.spikes[2].field_78797_d = -8.0f;
        this.spikes[3].field_78797_d = -8.0f;
        this.spikes[4].field_78797_d = -8.0f;
        this.spikes[5].field_78797_d = -8.0f;
        this.spikes[6].field_78797_d = -8.0f;
        this.spikes[7].field_78797_d = -8.0f;
        this.spikes[8].field_78797_d = -8.0f;
        this.spikes[9].field_78797_d = -4.0f;
        this.spikes[10].field_78797_d = -4.0f;
        this.spikes[11].field_78797_d = -4.0f;
        this.spikes[12].field_78797_d = -4.0f;
        this.spikes[13].field_78797_d = -4.0f;
        this.spikes[14].field_78797_d = -4.0f;
        this.spikes[15].field_78797_d = -4.0f;
        this.spikes[16].field_78797_d = -4.0f;
        this.spikes[17].field_78797_d = -4.0f;
        this.spikes[18].field_78797_d = 1.0f;
        this.spikes[1].field_78798_e = 4.0f;
        this.spikes[2].field_78798_e = 4.0f;
        this.spikes[8].field_78798_e = 4.0f;
        this.spikes[10].field_78798_e = 4.0f;
        this.spikes[11].field_78798_e = 5.0f;
        this.spikes[17].field_78798_e = 4.0f;
        this.spikes[19].field_78798_e = 4.0f;
        this.spikes[20].field_78798_e = 4.0f;
        this.spikes[26].field_78798_e = 4.0f;
        this.spikes[4].field_78798_e = -4.0f;
        this.spikes[5].field_78798_e = -4.0f;
        this.spikes[6].field_78798_e = -4.0f;
        this.spikes[13].field_78798_e = -4.0f;
        this.spikes[14].field_78798_e = -5.0f;
        this.spikes[15].field_78798_e = -4.0f;
        this.spikes[22].field_78798_e = -4.0f;
        this.spikes[23].field_78798_e = -4.0f;
        this.spikes[24].field_78798_e = -4.0f;
        final float fourtyFive = 0.7853982f;
        this.spikes[1].field_78795_f = fourtyFive;
        this.spikes[5].field_78795_f = fourtyFive;
        this.spikes[19].field_78795_f = fourtyFive;
        this.spikes[23].field_78795_f = fourtyFive;
        this.spikes[11].field_78796_g = fourtyFive;
        this.spikes[13].field_78796_g = fourtyFive;
        this.spikes[15].field_78796_g = fourtyFive;
        this.spikes[17].field_78796_g = fourtyFive;
        this.spikes[3].field_78808_h = fourtyFive;
        this.spikes[7].field_78808_h = fourtyFive;
        this.spikes[21].field_78808_h = fourtyFive;
        this.spikes[25].field_78808_h = fourtyFive;
        this.spikes[2].field_78795_f = -0.95993114f;
        this.spikes[2].field_78796_g = fourtyFive;
        this.spikes[24].field_78795_f = -0.95993114f;
        this.spikes[24].field_78796_g = fourtyFive;
        this.spikes[4].field_78795_f = -0.6108653f;
        this.spikes[4].field_78796_g = -fourtyFive;
        this.spikes[26].field_78795_f = -0.6108653f;
        this.spikes[26].field_78796_g = -fourtyFive;
        this.spikes[6].field_78796_g = fourtyFive;
        this.spikes[6].field_78795_f = -0.6108653f;
        this.spikes[20].field_78796_g = fourtyFive;
        this.spikes[20].field_78795_f = -0.6108653f;
        this.spikes[8].field_78795_f = -0.95993114f;
        this.spikes[8].field_78796_g = -fourtyFive;
        this.spikes[22].field_78795_f = -0.95993114f;
        this.spikes[22].field_78796_g = -fourtyFive;
    }
    
    public void setRotationAngles(final T entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch) {
        super.func_225597_a_((LivingEntity)entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        this.field_78116_c.field_78797_d = 11.0f;
        this.field_178720_f.field_78797_d = 11.0f;
        this.field_78115_e.field_78797_d = 11.0f;
        this.field_178721_j.field_78797_d = 18.0f;
        this.field_178722_k.field_78797_d = 18.0f;
        this.field_178723_h.func_78793_a(-3.5f, 12.0f, 0.0f);
        final ModelRenderer field_178723_h = this.field_178723_h;
        field_178723_h.field_78795_f += (float)3.141592653589793;
        this.field_178724_i.func_78793_a(3.5f, 12.0f, 0.0f);
        final ModelRenderer field_178724_i = this.field_178724_i;
        field_178724_i.field_78795_f += (float)3.141592653589793;
        final float angle = ageInTicks / 4.0f;
        final float length = 0.0f;
        this.block.field_78800_c = (float)Math.sin(angle) * length;
        this.block.field_78798_e = (float)(-Math.cos(angle)) * length;
        this.block.field_78796_g = -angle;
    }
}
