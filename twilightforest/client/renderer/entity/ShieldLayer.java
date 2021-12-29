// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import org.apache.commons.lang3.ArrayUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.data.IModelData;
import net.minecraft.block.BlockState;
import net.minecraftforge.client.model.data.EmptyModelData;
import net.minecraft.client.renderer.Atlases;
import net.minecraft.client.Minecraft;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import com.mojang.blaze3d.matrix.MatrixStack;
import twilightforest.capabilities.shield.IShieldCapability;
import net.minecraftforge.common.capabilities.Capability;
import twilightforest.capabilities.CapabilityList;
import twilightforest.entity.boss.LichEntity;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import java.util.Random;
import net.minecraft.util.Direction;
import net.minecraft.client.renderer.model.ModelResourceLocation;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.entity.LivingEntity;

public class ShieldLayer<T extends LivingEntity, M extends EntityModel<T>> extends LayerRenderer<T, M>
{
    public static final ModelResourceLocation LOC;
    private static final Direction[] DIRS;
    private static final Random RAND;
    
    public ShieldLayer(final IEntityRenderer<T, M> renderer) {
        super((IEntityRenderer)renderer);
    }
    
    private int getShieldCount(final T entity) {
        return (entity instanceof LichEntity) ? ((LichEntity)entity).getShieldStrength() : ((int)entity.getCapability((Capability)CapabilityList.SHIELDS).map(IShieldCapability::shieldsLeft).orElse(0));
    }
    
    private void renderShields(final MatrixStack stack, final IRenderTypeBuffer buffer, final T entity, final float partialTicks) {
        final float age = entity.field_70173_aa + partialTicks;
        final float rotateAngleY = age / 5.0f;
        final float rotateAngleX = MathHelper.func_76126_a(age / 5.0f) / 4.0f;
        final float rotateAngleZ = MathHelper.func_76134_b(age / 5.0f) / 4.0f;
        for (int count = this.getShieldCount(entity), c = 0; c < count; ++c) {
            stack.func_227860_a_();
            stack.func_227861_a_(-0.5, 0.5, -0.5);
            stack.func_227862_a_(1.0f, -1.0f, 1.0f);
            stack.func_227861_a_(0.5, 0.5, 0.5);
            stack.func_227863_a_(Vector3f.field_229183_f_.func_229187_a_(rotateAngleZ * 57.295776f));
            stack.func_227863_a_(Vector3f.field_229181_d_.func_229187_a_(rotateAngleY * 57.295776f + c * (360.0f / count)));
            stack.func_227863_a_(Vector3f.field_229179_b_.func_229187_a_(rotateAngleX * 57.295776f));
            stack.func_227861_a_(-0.5, -0.5, -0.5);
            stack.func_227861_a_(0.0, 0.0, -0.699999988079071);
            final IBakedModel model = Minecraft.func_71410_x().func_209506_al().func_174953_a(ShieldLayer.LOC);
            for (final Direction dir : ShieldLayer.DIRS) {
                ShieldLayer.RAND.setSeed(42L);
                Minecraft.func_71410_x().func_175599_af().func_229112_a_(stack, buffer.getBuffer(Atlases.func_228785_j_()), model.getQuads((BlockState)null, dir, ShieldLayer.RAND, (IModelData)EmptyModelData.INSTANCE), ItemStack.field_190927_a, 15728880, OverlayTexture.field_229196_a_);
            }
            stack.func_227865_b_();
        }
    }
    
    public void render(final MatrixStack stack, final IRenderTypeBuffer buffer, final int light, final T living, final float limbSwing, final float limbSwingAmount, final float partialTicks, final float ageInTicks, final float netHeadYaw, final float headPitch) {
        if (this.getShieldCount(living) > 0) {
            this.renderShields(stack, buffer, living, partialTicks);
        }
    }
    
    static {
        LOC = new ModelResourceLocation(new ResourceLocation("twilightforest", "shield"), "inventory");
        DIRS = (Direction[])ArrayUtils.add((Object[])Direction.values(), (Object)null);
        RAND = new Random();
    }
}
