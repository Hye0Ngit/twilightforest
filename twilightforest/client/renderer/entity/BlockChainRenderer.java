// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.client.renderer.WorldRenderer;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import com.mojang.blaze3d.matrix.MatrixStack;
import twilightforest.client.model.entity.ChainModel;
import twilightforest.client.model.entity.SpikeBlockModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.util.ResourceLocation;
import twilightforest.entity.ChainBlockEntity;
import net.minecraft.client.renderer.entity.EntityRenderer;

public class BlockChainRenderer extends EntityRenderer<ChainBlockEntity>
{
    private static final ResourceLocation textureLoc;
    private final Model model;
    private final Model chainModel;
    
    public BlockChainRenderer(final EntityRendererManager manager) {
        super(manager);
        this.model = (Model)new SpikeBlockModel();
        this.chainModel = (Model)new ChainModel();
    }
    
    public void render(final ChainBlockEntity chainBlock, final float yaw, final float partialTicks, final MatrixStack stack, final IRenderTypeBuffer buffer, final int light) {
        super.func_225623_a_((Entity)chainBlock, yaw, partialTicks, stack, buffer, light);
        stack.func_227860_a_();
        final IVertexBuilder ivertexbuilder = buffer.getBuffer(this.model.func_228282_a_(BlockChainRenderer.textureLoc));
        final float pitch = chainBlock.field_70127_C + (chainBlock.field_70125_A - chainBlock.field_70127_C) * partialTicks;
        stack.func_227863_a_(Vector3f.field_229181_d_.func_229187_a_(180.0f - MathHelper.func_76142_g(yaw)));
        stack.func_227863_a_(Vector3f.field_229179_b_.func_229187_a_(pitch));
        stack.func_227862_a_(-1.0f, -1.0f, 1.0f);
        this.model.func_225598_a_(stack, ivertexbuilder, light, OverlayTexture.field_229196_a_, 1.0f, 1.0f, 1.0f, 1.0f);
        stack.func_227865_b_();
        renderChain((Entity)chainBlock, (Entity)chainBlock.chain1, yaw, partialTicks, stack, buffer, light, this.chainModel);
        renderChain((Entity)chainBlock, (Entity)chainBlock.chain2, yaw, partialTicks, stack, buffer, light, this.chainModel);
        renderChain((Entity)chainBlock, (Entity)chainBlock.chain3, yaw, partialTicks, stack, buffer, light, this.chainModel);
        renderChain((Entity)chainBlock, (Entity)chainBlock.chain4, yaw, partialTicks, stack, buffer, light, this.chainModel);
        renderChain((Entity)chainBlock, (Entity)chainBlock.chain5, yaw, partialTicks, stack, buffer, light, this.chainModel);
    }
    
    static void renderChain(final Entity parent, final Entity chain, final float yaw, final float partialTicks, final MatrixStack stack, final IRenderTypeBuffer buffer, final int light, final Model chainModel) {
        final double chainInX = MathHelper.func_219803_d((double)partialTicks, chain.field_70142_S, chain.func_226277_ct_()) - MathHelper.func_219803_d((double)partialTicks, parent.field_70142_S, parent.func_226277_ct_());
        final double chainInY = MathHelper.func_219803_d((double)partialTicks, chain.field_70137_T, chain.func_226278_cu_()) - MathHelper.func_219803_d((double)partialTicks, parent.field_70137_T, parent.func_226278_cu_());
        final double chainInZ = MathHelper.func_219803_d((double)partialTicks, chain.field_70136_U, chain.func_226281_cx_()) - MathHelper.func_219803_d((double)partialTicks, parent.field_70136_U, parent.func_226281_cx_());
        stack.func_227860_a_();
        final IVertexBuilder ivertexbuilder = buffer.getBuffer(chainModel.func_228282_a_(BlockChainRenderer.textureLoc));
        stack.func_227861_a_(chainInX, chainInY, chainInZ);
        final float pitch = chain.field_70127_C + (chain.field_70125_A - chain.field_70127_C) * partialTicks;
        stack.func_227863_a_(Vector3f.field_229181_d_.func_229187_a_(180.0f - MathHelper.func_76142_g(yaw)));
        stack.func_227863_a_(Vector3f.field_229179_b_.func_229187_a_(pitch));
        stack.func_227862_a_(-1.0f, -1.0f, 1.0f);
        chainModel.func_225598_a_(stack, ivertexbuilder, light, OverlayTexture.field_229196_a_, 1.0f, 1.0f, 1.0f, 1.0f);
        stack.func_227865_b_();
    }
    
    private void renderMultiBoundingBox(final MatrixStack stack, final IVertexBuilder builder, final Entity entity, final float red, final float grean, final float blue) {
        final AxisAlignedBB axisalignedbb = entity.func_174813_aQ().func_72317_d(-entity.func_226277_ct_(), -entity.func_226278_cu_(), -entity.func_226281_cx_());
        WorldRenderer.func_228430_a_(stack, builder, axisalignedbb, red, grean, blue, 1.0f);
    }
    
    public ResourceLocation getEntityTexture(final ChainBlockEntity entity) {
        return BlockChainRenderer.textureLoc;
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("blockgoblin.png");
    }
}
