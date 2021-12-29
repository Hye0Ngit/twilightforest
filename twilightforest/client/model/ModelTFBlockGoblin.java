// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model;

import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBiped;

public class ModelTFBlockGoblin extends ModelBiped
{
    public ModelRenderer helmet;
    ModelRenderer block;
    ModelRenderer[] spikes;
    
    public ModelTFBlockGoblin() {
        this.spikes = new ModelRenderer[27];
        (this.field_78116_c = new ModelRenderer((ModelBase)this, 0, 0)).func_78790_a(0.0f, 0.0f, 0.0f, 0, 0, 0, 0.0f);
        this.field_78116_c.func_78793_a(0.0f, 11.0f, 0.0f);
        (this.field_78114_d = new ModelRenderer((ModelBase)this, 0, 0)).func_78790_a(0.0f, 0.0f, 0.0f, 0, 0, 0, 0.5f);
        this.field_78114_d.func_78793_a(0.0f, 11.0f, 0.0f);
        (this.helmet = new ModelRenderer((ModelBase)this, 24, 0)).func_78789_a(-2.5f, -9.0f, -2.5f, 5, 9, 5);
        this.helmet.field_78796_g = 0.7853982f;
        this.field_78114_d.func_78792_a(this.helmet);
        (this.field_78115_e = new ModelRenderer((ModelBase)this, 0, 21)).func_78790_a(-3.5f, 0.0f, -2.0f, 7, 7, 4, 0.0f);
        this.field_78115_e.func_78793_a(0.0f, 11.0f, 0.0f);
        (this.field_78112_f = new ModelRenderer((ModelBase)this, 52, 0)).func_78790_a(-3.0f, -1.0f, -2.0f, 3, 12, 3, 0.0f);
        this.field_78112_f.func_78793_a(-3.5f, 12.0f, 0.0f);
        (this.field_78113_g = new ModelRenderer((ModelBase)this, 52, 0)).func_78790_a(0.0f, -1.0f, -1.5f, 3, 12, 3, 0.0f);
        this.field_78113_g.func_78793_a(3.5f, 12.0f, 0.0f);
        (this.field_78123_h = new ModelRenderer((ModelBase)this, 0, 12)).func_78790_a(-1.5f, 0.0f, -1.5f, 3, 6, 3, 0.0f);
        this.field_78123_h.func_78793_a(-2.0f, 18.0f, 0.0f);
        (this.field_78124_i = new ModelRenderer((ModelBase)this, 0, 12)).func_78790_a(-1.5f, 0.0f, -1.5f, 3, 6, 3, 0.0f);
        this.field_78124_i.func_78793_a(2.0f, 18.0f, 0.0f);
        (this.block = new ModelRenderer((ModelBase)this, 32, 16)).func_78790_a(-4.0f, -8.0f, -4.0f, 8, 8, 8, 0.0f);
        this.block.func_78793_a(6.0f, 0.0f, 0.0f);
        for (int i = 0; i < this.spikes.length; ++i) {
            (this.spikes[i] = new ModelRenderer((ModelBase)this, 56, 16)).func_78790_a(-1.0f, -1.0f, -1.0f, 2, 2, 2, 0.0f);
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
    
    public void func_78088_a(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.func_78088_a(entity, f, f1, f2, f3, f4, f5);
    }
    
    public void func_78087_a(final float f, final float f1, final float f2, final float yaw, final float pitch, final float time, final Entity entity) {
        this.field_78118_o = false;
        super.func_78087_a(f, f1, f2, yaw, pitch, time, entity);
        this.field_78116_c.field_78797_d = 11.0f;
        this.field_78114_d.field_78797_d = 11.0f;
        this.field_78115_e.field_78797_d = 11.0f;
        this.field_78123_h.field_78797_d = 18.0f;
        this.field_78124_i.field_78797_d = 18.0f;
        this.field_78112_f.func_78793_a(-3.5f, 12.0f, 0.0f);
        final ModelRenderer field_78112_f = this.field_78112_f;
        field_78112_f.field_78795_f += (float)3.141592653589793;
        this.field_78113_g.func_78793_a(3.5f, 12.0f, 0.0f);
        final ModelRenderer field_78113_g = this.field_78113_g;
        field_78113_g.field_78795_f += (float)3.141592653589793;
        final float angle = f2 / 4.0f;
        final float length = 0.0f;
        this.block.field_78800_c = (float)Math.sin(angle) * length;
        this.block.field_78798_e = (float)(-Math.cos(angle)) * length;
        this.block.field_78796_g = -angle;
    }
}
