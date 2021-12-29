// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.entity.Entity;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import twilightforest.entity.CubeOfAnnihilationEntity;
import net.minecraft.client.renderer.entity.model.SegmentedModel;

public class CubeOfAnnihilationModel extends SegmentedModel<CubeOfAnnihilationEntity>
{
    public ModelRenderer box;
    public ModelRenderer boxX;
    public ModelRenderer boxY;
    public ModelRenderer boxZ;
    
    public CubeOfAnnihilationModel() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        (this.box = new ModelRenderer((Model)this, 0, 0)).func_228301_a_(-8.0f, -8.0f, -8.0f, 16.0f, 16.0f, 16.0f, 0.0f);
        this.box.func_78793_a(0.0f, 0.0f, 0.0f);
        (this.boxX = new ModelRenderer((Model)this, 0, 32)).func_228301_a_(-8.0f, -8.0f, -8.0f, 16.0f, 16.0f, 16.0f, 0.0f);
        this.boxX.func_78793_a(0.0f, 0.0f, 0.0f);
        (this.boxY = new ModelRenderer((Model)this, 0, 32)).func_228301_a_(-8.0f, -8.0f, -8.0f, 16.0f, 16.0f, 16.0f, 0.0f);
        this.boxY.func_78793_a(0.0f, 0.0f, 0.0f);
        (this.boxZ = new ModelRenderer((Model)this, 0, 32)).func_228301_a_(-8.0f, -8.0f, -8.0f, 16.0f, 16.0f, 16.0f, 0.0f);
        this.boxZ.func_78793_a(0.0f, 0.0f, 0.0f);
    }
    
    public Iterable<ModelRenderer> func_225601_a_() {
        return (Iterable<ModelRenderer>)ImmutableList.of((Object)this.box, (Object)this.boxX, (Object)this.boxY, (Object)this.boxZ);
    }
    
    public void setRotationAngles(final CubeOfAnnihilationEntity entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch) {
        this.boxX.field_78795_f = (float)Math.sin(entity.field_70173_aa + headPitch) / 5.0f;
        this.boxY.field_78796_g = (float)Math.sin(entity.field_70173_aa + headPitch) / 5.0f;
        this.boxZ.field_78808_h = (float)Math.sin(entity.field_70173_aa + headPitch) / 5.0f;
    }
}
