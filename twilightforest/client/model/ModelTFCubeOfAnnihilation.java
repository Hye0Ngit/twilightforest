// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model;

import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

public class ModelTFCubeOfAnnihilation extends ModelBase
{
    public ModelRenderer box;
    public ModelRenderer boxX;
    public ModelRenderer boxY;
    public ModelRenderer boxZ;
    
    public ModelTFCubeOfAnnihilation() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        (this.box = new ModelRenderer((ModelBase)this, 0, 0)).func_78790_a(-8.0f, -8.0f, -8.0f, 16, 16, 16, 0.0f);
        this.box.func_78793_a(0.0f, 0.0f, 0.0f);
        (this.boxX = new ModelRenderer((ModelBase)this, 0, 32)).func_78790_a(-8.0f, -8.0f, -8.0f, 16, 16, 16, 0.0f);
        this.boxX.func_78793_a(0.0f, 0.0f, 0.0f);
        (this.boxY = new ModelRenderer((ModelBase)this, 0, 32)).func_78790_a(-8.0f, -8.0f, -8.0f, 16, 16, 16, 0.0f);
        this.boxY.func_78793_a(0.0f, 0.0f, 0.0f);
        (this.boxZ = new ModelRenderer((ModelBase)this, 0, 32)).func_78790_a(-8.0f, -8.0f, -8.0f, 16, 16, 16, 0.0f);
        this.boxZ.func_78793_a(0.0f, 0.0f, 0.0f);
    }
    
    public void func_78088_a(final Entity p_78088_1_, final float p_78088_2_, final float p_78088_3_, final float p_78088_4_, final float p_78088_5_, final float p_78088_6_, final float p_78088_7_) {
        this.func_78087_a(p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, p_78088_7_, p_78088_1_);
        this.box.func_78785_a(p_78088_7_);
        this.boxX.func_78785_a(p_78088_7_);
        this.boxY.func_78785_a(p_78088_7_);
        this.boxZ.func_78785_a(p_78088_7_);
    }
    
    public void func_78087_a(final float f, final float f1, final float f2, final float f3, final float time, final float f5, final Entity entity) {
        this.boxX.field_78795_f = (float)Math.sin(entity.field_70173_aa + time) / 5.0f;
        this.boxY.field_78796_g = (float)Math.sin(entity.field_70173_aa + time) / 5.0f;
        this.boxZ.field_78808_h = (float)Math.sin(entity.field_70173_aa + time) / 5.0f;
    }
}
