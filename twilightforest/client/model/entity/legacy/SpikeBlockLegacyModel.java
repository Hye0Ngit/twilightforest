// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity.legacy;

import net.minecraft.entity.Entity;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import twilightforest.entity.SpikeBlockEntity;
import net.minecraft.client.renderer.entity.model.SegmentedModel;

public class SpikeBlockLegacyModel extends SegmentedModel<SpikeBlockEntity>
{
    ModelRenderer block;
    ModelRenderer[] spikes;
    
    public SpikeBlockLegacyModel() {
        this.spikes = new ModelRenderer[27];
        (this.block = new ModelRenderer((Model)this, 32, 16)).func_228301_a_(-4.0f, -8.0f, -4.0f, 8.0f, 8.0f, 8.0f, 0.0f);
        this.block.func_78793_a(0.0f, 0.0f, 0.0f);
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
    
    public void setRotationAngles(final SpikeBlockEntity entity, final float v, final float v1, final float v2, final float v3, final float v4) {
    }
    
    public Iterable<ModelRenderer> func_225601_a_() {
        return (Iterable<ModelRenderer>)ImmutableList.of((Object)this.block);
    }
}
