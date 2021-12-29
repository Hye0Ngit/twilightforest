// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.world.phys.AABB;
import net.minecraft.client.renderer.LevelRenderer;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.Mth;
import com.mojang.math.Vector3f;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.world.entity.Entity;
import net.minecraft.client.renderer.MultiBufferSource;
import com.mojang.blaze3d.vertex.PoseStack;
import twilightforest.client.model.entity.ChainModel;
import twilightforest.client.model.entity.SpikeBlockModel;
import twilightforest.client.model.TFModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.Model;
import net.minecraft.resources.ResourceLocation;
import twilightforest.entity.ChainBlock;
import net.minecraft.client.renderer.entity.EntityRenderer;

public class BlockChainRenderer extends EntityRenderer<ChainBlock>
{
    private static final ResourceLocation textureLoc;
    private final Model model;
    private final Model chainModel;
    
    public BlockChainRenderer(final EntityRendererProvider.Context manager) {
        super(manager);
        this.model = (Model)new SpikeBlockModel(manager.m_174023_(TFModelLayers.CHAIN_BLOCK));
        this.chainModel = (Model)new ChainModel(manager.m_174023_(TFModelLayers.CHAIN));
    }
    
    public void render(final ChainBlock chainBlock, final float yaw, final float partialTicks, final PoseStack stack, final MultiBufferSource buffer, final int light) {
        super.m_7392_((Entity)chainBlock, yaw, partialTicks, stack, buffer, light);
        stack.m_85836_();
        final VertexConsumer ivertexbuilder = ItemRenderer.m_115222_(buffer, this.model.m_103119_(BlockChainRenderer.textureLoc), false, chainBlock.isFoil());
        final float pitch = chainBlock.f_19860_ + (chainBlock.m_146909_() - chainBlock.f_19860_) * partialTicks;
        stack.m_85845_(Vector3f.f_122225_.m_122240_(180.0f - Mth.m_14177_(yaw)));
        stack.m_85845_(Vector3f.f_122223_.m_122240_(pitch));
        stack.m_85841_(-1.0f, -1.0f, 1.0f);
        this.model.m_7695_(stack, ivertexbuilder, light, OverlayTexture.f_118083_, 1.0f, 1.0f, 1.0f, 1.0f);
        stack.m_85849_();
        renderChain((Entity)chainBlock, (Entity)chainBlock.chain1, yaw, partialTicks, stack, buffer, light, this.chainModel);
        renderChain((Entity)chainBlock, (Entity)chainBlock.chain2, yaw, partialTicks, stack, buffer, light, this.chainModel);
        renderChain((Entity)chainBlock, (Entity)chainBlock.chain3, yaw, partialTicks, stack, buffer, light, this.chainModel);
        renderChain((Entity)chainBlock, (Entity)chainBlock.chain4, yaw, partialTicks, stack, buffer, light, this.chainModel);
        renderChain((Entity)chainBlock, (Entity)chainBlock.chain5, yaw, partialTicks, stack, buffer, light, this.chainModel);
    }
    
    public static void renderChain(final Entity parent, final Entity chain, final float yaw, final float partialTicks, final PoseStack stack, final MultiBufferSource buffer, final int light, final Model chainModel) {
        final double chainInX = Mth.m_14139_((double)partialTicks, chain.f_19790_, chain.m_20185_()) - Mth.m_14139_((double)partialTicks, parent.f_19790_, parent.m_20185_());
        final double chainInY = Mth.m_14139_((double)partialTicks, chain.f_19791_, chain.m_20186_()) - Mth.m_14139_((double)partialTicks, parent.f_19791_, parent.m_20186_());
        final double chainInZ = Mth.m_14139_((double)partialTicks, chain.f_19792_, chain.m_20189_()) - Mth.m_14139_((double)partialTicks, parent.f_19792_, parent.m_20189_());
        stack.m_85836_();
        VertexConsumer vertexConsumer;
        if (parent instanceof final ChainBlock blocc) {
            vertexConsumer = ItemRenderer.m_115222_(buffer, chainModel.m_103119_(BlockChainRenderer.textureLoc), false, blocc.isFoil());
        }
        else {
            vertexConsumer = buffer.m_6299_(chainModel.m_103119_(BlockChainRenderer.textureLoc));
        }
        stack.m_85837_(chainInX, chainInY, chainInZ);
        final float pitch = chain.f_19860_ + (chain.m_146909_() - chain.f_19860_) * partialTicks;
        stack.m_85845_(Vector3f.f_122225_.m_122240_(180.0f - Mth.m_14177_(yaw)));
        stack.m_85845_(Vector3f.f_122223_.m_122240_(pitch));
        stack.m_85841_(-1.0f, -1.0f, 1.0f);
        chainModel.m_7695_(stack, vertexConsumer, light, OverlayTexture.f_118083_, 1.0f, 1.0f, 1.0f, 1.0f);
        stack.m_85849_();
    }
    
    private void renderMultiBoundingBox(final PoseStack stack, final VertexConsumer builder, final Entity entity, final float red, final float grean, final float blue) {
        final AABB axisalignedbb = entity.m_142469_().m_82386_(-entity.m_20185_(), -entity.m_20186_(), -entity.m_20189_());
        LevelRenderer.m_109646_(stack, builder, axisalignedbb, red, grean, blue, 1.0f);
    }
    
    public ResourceLocation getTextureLocation(final ChainBlock entity) {
        return BlockChainRenderer.textureLoc;
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("blockgoblin.png");
    }
}
