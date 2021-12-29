// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model;

import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

public class ModelTFSpikeBlock extends ModelBase
{
    ModelRenderer block;
    ModelRenderer[] spikes;
    
    public ModelTFSpikeBlock() {
        this.spikes = new ModelRenderer[27];
        (this.block = new ModelRenderer((ModelBase)this, 32, 16)).func_78790_a(-4.0f, -8.0f, -4.0f, 8, 8, 8, 0.0f);
        this.block.func_78793_a(0.0f, 0.0f, 0.0f);
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
        this.block.func_78785_a(f5);
    }
}
