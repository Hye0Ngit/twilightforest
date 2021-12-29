// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model;

import net.minecraft.util.MathHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.Vec3;
import net.minecraft.entity.Entity;
import java.util.Random;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

public class ModelTFMosquitoSwarm extends ModelBase
{
    ModelRenderer core;
    ModelRenderer node1;
    ModelRenderer node2;
    ModelRenderer node3;
    ModelRenderer node4;
    ModelRenderer node5;
    ModelRenderer node6;
    Random rand;
    
    public ModelTFMosquitoSwarm() {
        this.rand = new Random();
        (this.core = new ModelRenderer((ModelBase)this, this.rand.nextInt(28), this.rand.nextInt(28))).func_78789_a(-4.0f, 0.0f, -2.0f, 1, 1, 1);
        this.core.func_78793_a(0.0f, -4.0f, 0.0f);
        (this.node1 = new ModelRenderer((ModelBase)this, this.rand.nextInt(28), this.rand.nextInt(28))).func_78789_a(-5.5f, -5.0f, -13.0f, 1, 1, 1);
        this.node1.func_78793_a(2.0f, -1.0f, -6.0f);
        this.core.func_78792_a(this.node1);
        (this.node2 = new ModelRenderer((ModelBase)this, this.rand.nextInt(28), this.rand.nextInt(28))).func_78789_a(-5.5f, -13.0f, -5.0f, 1, 1, 1);
        this.node2.func_78793_a(0.0f, -7.0f, -1.0f);
        this.core.func_78792_a(this.node2);
        (this.node3 = new ModelRenderer((ModelBase)this, this.rand.nextInt(28), this.rand.nextInt(28))).func_78789_a(-13.0f, -5.0f, -5.0f, 1, 1, 1);
        this.node3.func_78793_a(5.0f, -2.0f, -1.0f);
        this.core.func_78792_a(this.node3);
        (this.node4 = new ModelRenderer((ModelBase)this, this.rand.nextInt(28), this.rand.nextInt(28))).func_78789_a(-5.5f, -5.0f, -13.0f, 1, 1, 1);
        this.node4.func_78793_a(2.0f, -1.0f, -6.0f);
        this.core.func_78792_a(this.node4);
        (this.node5 = new ModelRenderer((ModelBase)this, this.rand.nextInt(28), this.rand.nextInt(28))).func_78789_a(-5.5f, -13.0f, -5.0f, 1, 1, 1);
        this.node5.func_78793_a(0.0f, -7.0f, -1.0f);
        this.core.func_78792_a(this.node5);
        (this.node6 = new ModelRenderer((ModelBase)this, this.rand.nextInt(28), this.rand.nextInt(28))).func_78789_a(-13.0f, -5.0f, -5.0f, 1, 1, 1);
        this.node6.func_78793_a(5.0f, -2.0f, -1.0f);
        this.core.func_78792_a(this.node6);
        this.addBugsToNodes(this.node1);
        this.addBugsToNodes(this.node2);
        this.addBugsToNodes(this.node3);
        this.addBugsToNodes(this.node4);
        this.addBugsToNodes(this.node5);
        this.addBugsToNodes(this.node6);
    }
    
    public void func_78088_a(final Entity par1Entity, final float par2, final float par3, final float par4, final float par5, final float par6, final float par7) {
        this.core.func_78785_a(par7 / 2.0f);
    }
    
    public void addBugsToNodes(final ModelRenderer node) {
        for (int bugs = 16, i = 0; i < bugs; ++i) {
            final Vec3 vec = Vec3.func_72443_a(11.0, 0.0, 0.0);
            final float rotateY = i * (360.0f / bugs) * 3.141593f / 180.0f;
            vec.func_72442_b(rotateY);
            final ModelRenderer bug = new ModelRenderer((ModelBase)this, this.rand.nextInt(28), this.rand.nextInt(28));
            final float bugX = (this.rand.nextFloat() - this.rand.nextFloat()) * 4.0f;
            final float bugY = (this.rand.nextFloat() - this.rand.nextFloat()) * 4.0f;
            final float bugZ = (this.rand.nextFloat() - this.rand.nextFloat()) * 4.0f;
            bug.func_78789_a(bugX, bugY, bugZ, 1, 1, 1);
            bug.func_78793_a((float)vec.field_72450_a, (float)vec.field_72448_b, (float)vec.field_72449_c);
            bug.field_78796_g = rotateY;
            node.func_78792_a(bug);
        }
    }
    
    public void func_78086_a(final EntityLivingBase par1EntityLiving, final float par2, final float par3, final float time) {
        this.core.field_78796_g = (par1EntityLiving.field_70173_aa + time) / 5.0f;
        this.core.field_78795_f = MathHelper.func_76126_a((par1EntityLiving.field_70173_aa + time) / 5.0f) / 4.0f;
        this.core.field_78808_h = MathHelper.func_76134_b((par1EntityLiving.field_70173_aa + time) / 5.0f) / 4.0f;
        this.node1.field_78796_g = (par1EntityLiving.field_70173_aa + time) / 2.0f;
        this.node1.field_78795_f = MathHelper.func_76126_a((par1EntityLiving.field_70173_aa + time) / 6.0f) / 2.0f;
        this.node1.field_78808_h = MathHelper.func_76134_b((par1EntityLiving.field_70173_aa + time) / 5.0f) / 4.0f;
        this.node2.field_78796_g = MathHelper.func_76126_a((par1EntityLiving.field_70173_aa + time) / 2.0f) / 3.0f;
        this.node2.field_78795_f = (par1EntityLiving.field_70173_aa + time) / 5.0f;
        this.node2.field_78808_h = MathHelper.func_76134_b((par1EntityLiving.field_70173_aa + time) / 5.0f) / 4.0f;
        this.node3.field_78796_g = MathHelper.func_76126_a((par1EntityLiving.field_70173_aa + time) / 7.0f) / 3.0f;
        this.node3.field_78795_f = MathHelper.func_76134_b((par1EntityLiving.field_70173_aa + time) / 4.0f) / 2.0f;
        this.node3.field_78808_h = (par1EntityLiving.field_70173_aa + time) / 5.0f;
        this.node4.field_78795_f = (par1EntityLiving.field_70173_aa + time) / 2.0f;
        this.node4.field_78808_h = MathHelper.func_76126_a((par1EntityLiving.field_70173_aa + time) / 6.0f) / 2.0f;
        this.node4.field_78796_g = MathHelper.func_76126_a((par1EntityLiving.field_70173_aa + time) / 5.0f) / 4.0f;
        this.node5.field_78808_h = MathHelper.func_76126_a((par1EntityLiving.field_70173_aa + time) / 2.0f) / 3.0f;
        this.node5.field_78796_g = MathHelper.func_76134_b((par1EntityLiving.field_70173_aa + time) / 5.0f) / 4.0f;
        this.node5.field_78795_f = MathHelper.func_76134_b((par1EntityLiving.field_70173_aa + time) / 5.0f) / 4.0f;
        this.node6.field_78808_h = MathHelper.func_76134_b((par1EntityLiving.field_70173_aa + time) / 7.0f) / 3.0f;
        this.node6.field_78795_f = MathHelper.func_76134_b((par1EntityLiving.field_70173_aa + time) / 4.0f) / 2.0f;
        this.node6.field_78796_g = (par1EntityLiving.field_70173_aa + time) / 5.0f;
    }
}
