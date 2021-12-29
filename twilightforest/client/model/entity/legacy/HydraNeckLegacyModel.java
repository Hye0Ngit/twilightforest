// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity.legacy;

import net.minecraft.entity.Entity;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import twilightforest.entity.boss.HydraNeckEntity;
import net.minecraft.client.renderer.entity.model.SegmentedModel;

public class HydraNeckLegacyModel extends SegmentedModel<HydraNeckEntity>
{
    ModelRenderer neck;
    
    public HydraNeckLegacyModel() {
        this.field_78090_t = 512;
        this.field_78089_u = 256;
        this.neck = new ModelRenderer((Model)this);
        this.neck.func_78784_a(128, 136).func_228300_a_(-16.0f, -16.0f, -16.0f, 32.0f, 32.0f, 32.0f);
        this.neck.func_78784_a(128, 200).func_228300_a_(-2.0f, -23.0f, 0.0f, 4.0f, 24.0f, 24.0f);
        this.neck.func_78793_a(0.0f, 0.0f, 0.0f);
    }
    
    public Iterable<ModelRenderer> func_225601_a_() {
        return (Iterable<ModelRenderer>)ImmutableList.of((Object)this.neck);
    }
    
    public void setRotationAngles(final HydraNeckEntity entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch) {
        this.neck.field_78796_g = netHeadYaw / 57.29578f;
        this.neck.field_78795_f = headPitch / 57.29578f;
    }
}
