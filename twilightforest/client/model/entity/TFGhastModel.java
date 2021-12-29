// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.entity.Entity;
import com.google.common.collect.ImmutableList;
import net.minecraft.util.math.MathHelper;
import java.util.Random;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import twilightforest.entity.CarminiteGhastguardEntity;

@OnlyIn(Dist.CLIENT)
public class TFGhastModel<T extends CarminiteGhastguardEntity> extends SegmentedModel<T>
{
    public ModelRenderer body;
    protected ModelRenderer[] tentacles;
    
    public TFGhastModel() {
        this.tentacles = new ModelRenderer[9];
        final byte yOffset = -16;
        (this.body = new ModelRenderer((Model)this, 0, 0)).func_228300_a_(-8.0f, -8.0f, -8.0f, 16.0f, 16.0f, 16.0f);
        final ModelRenderer body = this.body;
        body.field_78797_d += 24 + yOffset;
        final Random rand = new Random(1660L);
        for (int i = 0; i < this.tentacles.length; ++i) {
            this.makeTentacle(yOffset, rand, i);
        }
    }
    
    protected void makeTentacle(final byte yOffset, final Random random, final int i) {
        this.tentacles[i] = new ModelRenderer((Model)this, 0, 0);
        final float xPoint = ((i % 3 - i / 3 % 2 * 0.5f + 0.25f) / 2.0f * 2.0f - 1.0f) * 5.0f;
        final float zPoint = (i / 3 / 2.0f * 2.0f - 1.0f) * 5.0f;
        final int length = random.nextInt(7) + 8;
        this.tentacles[i].func_228300_a_(-1.0f, 0.0f, -1.0f, 2.0f, (float)length, 2.0f);
        this.tentacles[i].field_78800_c = xPoint;
        this.tentacles[i].field_78798_e = zPoint;
        this.tentacles[i].field_78797_d = (float)(23 + yOffset);
        this.body.func_78792_a(this.tentacles[i]);
    }
    
    public void setRotationAngles(final T entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch) {
        for (int i = 0; i < this.tentacles.length; ++i) {
            this.tentacles[i].field_78795_f = 0.2f * MathHelper.func_76126_a(ageInTicks * 0.3f + i) + 0.4f;
        }
        this.body.field_78795_f = headPitch / 57.295776f;
        this.body.field_78796_g = netHeadYaw / 57.295776f;
    }
    
    public Iterable<ModelRenderer> func_225601_a_() {
        return (Iterable<ModelRenderer>)ImmutableList.of((Object)this.body);
    }
}
