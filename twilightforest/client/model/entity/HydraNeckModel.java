// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.entity.Entity;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import twilightforest.entity.boss.HydraNeckEntity;
import net.minecraft.client.renderer.entity.model.SegmentedModel;

public class HydraNeckModel extends SegmentedModel<HydraNeckEntity>
{
    ModelRenderer neck;
    
    public HydraNeckModel() {
        this.field_78090_t = 512;
        this.field_78089_u = 256;
        (this.neck = new ModelRenderer((Model)this, 0, 0)).func_78793_a(0.0f, 0.0f, 0.0f);
        this.neck.func_78784_a(260, 0).func_228302_a_(-16.0f, -16.0f, -16.0f, 32.0f, 32.0f, 32.0f, 0.0f, 0.0f, 0.0f);
        this.neck.func_78784_a(0, 0).func_228302_a_(-2.0f, -24.0f, 0.0f, 4.0f, 8.0f, 16.0f, 0.0f, 0.0f, 0.0f);
    }
    
    public Iterable<ModelRenderer> func_225601_a_() {
        return (Iterable<ModelRenderer>)ImmutableList.of((Object)this.neck);
    }
    
    public void setRotationAngles(final HydraNeckEntity entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch) {
        this.neck.field_78796_g = netHeadYaw / 57.29578f;
        this.neck.field_78795_f = headPitch / 57.29578f;
    }
}
