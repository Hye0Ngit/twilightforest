// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import org.apache.commons.lang3.ArrayUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.model.data.IModelData;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.data.EmptyModelData;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.Minecraft;
import com.mojang.math.Vector3f;
import net.minecraft.util.Mth;
import net.minecraft.client.renderer.MultiBufferSource;
import com.mojang.blaze3d.vertex.PoseStack;
import twilightforest.capabilities.shield.IShieldCapability;
import net.minecraftforge.common.capabilities.Capability;
import twilightforest.capabilities.CapabilityList;
import twilightforest.entity.boss.Lich;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import java.util.Random;
import net.minecraft.core.Direction;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.world.entity.LivingEntity;

public class ShieldLayer<T extends LivingEntity, M extends EntityModel<T>> extends RenderLayer<T, M>
{
    public static final ModelResourceLocation LOC;
    private static final Direction[] DIRS;
    private static final Random RAND;
    
    public ShieldLayer(final RenderLayerParent<T, M> renderer) {
        super((RenderLayerParent)renderer);
    }
    
    private int getShieldCount(final T entity) {
        return (entity instanceof Lich) ? ((Lich)entity).getShieldStrength() : ((int)entity.getCapability((Capability)CapabilityList.SHIELDS).map(IShieldCapability::shieldsLeft).orElse(0));
    }
    
    private void renderShields(final PoseStack stack, final MultiBufferSource buffer, final T entity, final float partialTicks) {
        final float age = entity.f_19797_ + partialTicks;
        final float rotateAngleY = age / 5.0f;
        final float rotateAngleX = Mth.m_14031_(age / 5.0f) / 4.0f;
        final float rotateAngleZ = Mth.m_14089_(age / 5.0f) / 4.0f;
        for (int count = this.getShieldCount(entity), c = 0; c < count; ++c) {
            stack.m_85836_();
            stack.m_85837_(-0.5, 0.5, -0.5);
            stack.m_85841_(1.0f, -1.0f, 1.0f);
            stack.m_85837_(0.5, 0.5, 0.5);
            stack.m_85845_(Vector3f.f_122227_.m_122240_(rotateAngleZ * 57.295776f));
            stack.m_85845_(Vector3f.f_122225_.m_122240_(rotateAngleY * 57.295776f + c * (360.0f / count)));
            stack.m_85845_(Vector3f.f_122223_.m_122240_(rotateAngleX * 57.295776f));
            stack.m_85837_(-0.5, -0.5, -0.5);
            stack.m_85837_(0.0, 0.0, -0.699999988079071);
            final BakedModel model = Minecraft.m_91087_().m_91304_().m_119422_(ShieldLayer.LOC);
            for (final Direction dir : ShieldLayer.DIRS) {
                ShieldLayer.RAND.setSeed(42L);
                Minecraft.m_91087_().m_91291_().m_115162_(stack, buffer.m_6299_(Sheets.m_110792_()), model.getQuads((BlockState)null, dir, ShieldLayer.RAND, (IModelData)EmptyModelData.INSTANCE), ItemStack.f_41583_, 15728880, OverlayTexture.f_118083_);
            }
            stack.m_85849_();
        }
    }
    
    public void render(final PoseStack stack, final MultiBufferSource buffer, final int light, final T living, final float limbSwing, final float limbSwingAmount, final float partialTicks, final float ageInTicks, final float netHeadYaw, final float headPitch) {
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
