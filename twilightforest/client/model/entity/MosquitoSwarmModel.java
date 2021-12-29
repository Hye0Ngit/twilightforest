// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.model.Model;
import java.util.Random;
import net.minecraft.client.renderer.model.ModelRenderer;
import twilightforest.entity.MosquitoSwarmEntity;
import net.minecraft.client.renderer.entity.model.SegmentedModel;

public class MosquitoSwarmModel extends SegmentedModel<MosquitoSwarmEntity>
{
    ModelRenderer core;
    ModelRenderer node1;
    ModelRenderer node2;
    ModelRenderer node3;
    ModelRenderer node4;
    ModelRenderer node5;
    ModelRenderer node6;
    Random rand;
    
    public MosquitoSwarmModel() {
        this.rand = new Random();
        (this.core = new ModelRenderer((Model)this, this.rand.nextInt(28), this.rand.nextInt(28))).func_228300_a_(-0.5f, 2.0f, -0.5f, 1.0f, 1.0f, 1.0f);
        this.core.func_78793_a(0.0f, -4.0f, 0.0f);
        (this.node1 = new ModelRenderer((Model)this, this.rand.nextInt(28), this.rand.nextInt(28))).func_228300_a_(0.0f, 0.0f, -11.0f, 1.0f, 1.0f, 1.0f);
        this.node1.func_78793_a(-0.5f, -2.0f, -0.5f);
        this.core.func_78792_a(this.node1);
        (this.node2 = new ModelRenderer((Model)this, this.rand.nextInt(28), this.rand.nextInt(28))).func_228300_a_(0.0f, -11.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        this.node2.func_78793_a(-0.5f, -2.0f, -0.5f);
        this.core.func_78792_a(this.node2);
        (this.node3 = new ModelRenderer((Model)this, this.rand.nextInt(28), this.rand.nextInt(28))).func_228300_a_(-11.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        this.node3.func_78793_a(-0.5f, -2.0f, -0.5f);
        this.core.func_78792_a(this.node3);
        (this.node4 = new ModelRenderer((Model)this, this.rand.nextInt(28), this.rand.nextInt(28))).func_228300_a_(0.0f, 0.0f, 11.0f, 1.0f, 1.0f, 1.0f);
        this.node4.func_78793_a(-0.5f, -2.0f, -0.5f);
        this.core.func_78792_a(this.node4);
        (this.node5 = new ModelRenderer((Model)this, this.rand.nextInt(28), this.rand.nextInt(28))).func_228300_a_(0.0f, 11.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        this.node5.func_78793_a(-0.5f, -2.0f, -0.5f);
        this.core.func_78792_a(this.node5);
        (this.node6 = new ModelRenderer((Model)this, this.rand.nextInt(28), this.rand.nextInt(28))).func_228300_a_(11.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        this.node6.func_78793_a(-0.5f, -2.0f, -0.5f);
        this.core.func_78792_a(this.node6);
        this.addBugsToNodes(this.node1);
        this.addBugsToNodes(this.node2);
        this.addBugsToNodes(this.node3);
        this.addBugsToNodes(this.node4);
        this.addBugsToNodes(this.node5);
        this.addBugsToNodes(this.node6);
    }
    
    public Iterable<ModelRenderer> func_225601_a_() {
        return (Iterable<ModelRenderer>)ImmutableList.of((Object)this.core, (Object)this.node1, (Object)this.node2, (Object)this.node3, (Object)this.node4, (Object)this.node5, (Object)this.node6);
    }
    
    public void addBugsToNodes(final ModelRenderer node) {
        for (int bugs = 16, i = 0; i < bugs; ++i) {
            final Vector3d vec = new Vector3d(0.0, 0.0, 0.0);
            final float rotateY = i * (360.0f / bugs) * 3.141593f / 180.0f;
            vec.func_178789_a(rotateY);
            final ModelRenderer bug = new ModelRenderer((Model)this, this.rand.nextInt(28), this.rand.nextInt(28));
            final float bugX = (this.rand.nextFloat() - this.rand.nextFloat()) * 16.0f;
            final float bugY = (this.rand.nextFloat() - this.rand.nextFloat()) * 16.0f;
            final float bugZ = (this.rand.nextFloat() - this.rand.nextFloat()) * 16.0f;
            bug.func_228300_a_(bugX, bugY, bugZ, 1.0f, 1.0f, 1.0f);
            bug.func_78793_a((float)vec.field_72450_a, (float)vec.field_72448_b, (float)vec.field_72449_c);
            bug.field_78796_g = rotateY;
            node.func_78792_a(bug);
        }
    }
    
    public void setRotationAngles(final MosquitoSwarmEntity entity, final float v, final float v1, final float v2, final float v3, final float v4) {
    }
    
    public void setLivingAnimations(final MosquitoSwarmEntity entity, final float limbSwing, final float limbSwingAmount, final float partialTicks) {
        this.core.field_78796_g = (entity.field_70173_aa + partialTicks) / 5.0f;
        this.core.field_78795_f = MathHelper.func_76126_a((entity.field_70173_aa + partialTicks) / 5.0f) / 4.0f;
        this.core.field_78808_h = MathHelper.func_76134_b((entity.field_70173_aa + partialTicks) / 5.0f) / 4.0f;
        this.node1.field_78796_g = (entity.field_70173_aa + partialTicks) / 2.0f;
        this.node1.field_78795_f = MathHelper.func_76126_a((entity.field_70173_aa + partialTicks) / 6.0f) / 2.0f;
        this.node1.field_78808_h = MathHelper.func_76134_b((entity.field_70173_aa + partialTicks) / 5.0f) / 4.0f;
        this.node2.field_78796_g = MathHelper.func_76126_a((entity.field_70173_aa + partialTicks) / 2.0f) / 3.0f;
        this.node2.field_78795_f = (entity.field_70173_aa + partialTicks) / 5.0f;
        this.node2.field_78808_h = MathHelper.func_76134_b((entity.field_70173_aa + partialTicks) / 5.0f) / 4.0f;
        this.node3.field_78796_g = MathHelper.func_76126_a((entity.field_70173_aa + partialTicks) / 7.0f) / 3.0f;
        this.node3.field_78795_f = MathHelper.func_76134_b((entity.field_70173_aa + partialTicks) / 4.0f) / 2.0f;
        this.node3.field_78808_h = (entity.field_70173_aa + partialTicks) / 5.0f;
        this.node4.field_78795_f = (entity.field_70173_aa + partialTicks) / 2.0f;
        this.node4.field_78808_h = MathHelper.func_76126_a((entity.field_70173_aa + partialTicks) / 6.0f) / 2.0f;
        this.node4.field_78796_g = MathHelper.func_76126_a((entity.field_70173_aa + partialTicks) / 5.0f) / 4.0f;
        this.node5.field_78808_h = (entity.field_70173_aa + partialTicks) / 2.0f;
        this.node5.field_78796_g = MathHelper.func_76134_b((entity.field_70173_aa + partialTicks) / 5.0f) / 4.0f;
        this.node5.field_78795_f = MathHelper.func_76134_b((entity.field_70173_aa + partialTicks) / 5.0f) / 4.0f;
        this.node6.field_78808_h = MathHelper.func_76134_b((entity.field_70173_aa + partialTicks) / 7.0f) / 3.0f;
        this.node6.field_78795_f = MathHelper.func_76134_b((entity.field_70173_aa + partialTicks) / 4.0f) / 2.0f;
        this.node6.field_78796_g = (entity.field_70173_aa + partialTicks) / 5.0f;
    }
}
