// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.client.renderer.culling.ClippingHelper;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.client.renderer.WorldRenderer;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.entity.MobEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import com.mojang.blaze3d.matrix.MatrixStack;
import twilightforest.client.model.entity.ChainModel;
import twilightforest.client.model.entity.SpikeBlockModel;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.entity.BipedRenderer;
import twilightforest.client.model.entity.BlockChainGoblinModel;
import twilightforest.entity.BlockChainGoblinEntity;

public class BlockChainGoblinRenderer<T extends BlockChainGoblinEntity, M extends BlockChainGoblinModel<T>> extends BipedRenderer<T, M>
{
    private static final ResourceLocation textureLoc;
    private final Model model;
    private final Model chainModel;
    
    public BlockChainGoblinRenderer(final EntityRendererManager manager, final M model, final float shadowSize) {
        super(manager, (BipedModel)model, shadowSize);
        this.model = (Model)new SpikeBlockModel();
        this.chainModel = (Model)new ChainModel();
    }
    
    public void render(final T goblin, final float yaw, final float partialTicks, final MatrixStack stack, final IRenderTypeBuffer buffer, final int light) {
        super.func_225623_a_((MobEntity)goblin, yaw, partialTicks, stack, buffer, light);
        stack.func_227860_a_();
        final double blockInX = goblin.block.func_226277_ct_() - goblin.func_226277_ct_();
        final double blockInY = goblin.block.func_226278_cu_() - goblin.func_226278_cu_();
        final double blockInZ = goblin.block.func_226281_cx_() - goblin.func_226281_cx_();
        final IVertexBuilder ivertexbuilder = buffer.getBuffer(this.model.func_228282_a_(BlockChainGoblinRenderer.textureLoc));
        stack.func_227861_a_(blockInX, blockInY, blockInZ);
        final float pitch = goblin.field_70127_C + (goblin.field_70125_A - goblin.field_70127_C) * partialTicks;
        stack.func_227863_a_(Vector3f.field_229181_d_.func_229187_a_(180.0f - MathHelper.func_76142_g(yaw)));
        stack.func_227863_a_(Vector3f.field_229179_b_.func_229187_a_(pitch));
        stack.func_227862_a_(-1.0f, -1.0f, 1.0f);
        this.model.func_225598_a_(stack, ivertexbuilder, light, OverlayTexture.field_229196_a_, 1.0f, 1.0f, 1.0f, 1.0f);
        stack.func_227865_b_();
        BlockChainRenderer.renderChain((Entity)goblin, (Entity)goblin.chain1, yaw, partialTicks, stack, buffer, light, this.chainModel);
        BlockChainRenderer.renderChain((Entity)goblin, (Entity)goblin.chain2, yaw, partialTicks, stack, buffer, light, this.chainModel);
        BlockChainRenderer.renderChain((Entity)goblin, (Entity)goblin.chain3, yaw, partialTicks, stack, buffer, light, this.chainModel);
        if (this.field_76990_c.func_178634_b() && !goblin.block.func_82150_aj() && !Minecraft.func_71410_x().func_189648_am()) {
            stack.func_227860_a_();
            stack.func_227861_a_(blockInX, blockInY, blockInZ);
            this.renderMultiBoundingBox(stack, buffer.getBuffer(RenderType.func_228659_m_()), (Entity)goblin.block, 0.25f, 1.0f, 0.0f);
            stack.func_227865_b_();
        }
    }
    
    private void renderMultiBoundingBox(final MatrixStack stack, final IVertexBuilder builder, final Entity entity, final float red, final float grean, final float blue) {
        final AxisAlignedBB axisalignedbb = entity.func_174813_aQ().func_72317_d(-entity.func_226277_ct_(), -entity.func_226278_cu_(), -entity.func_226281_cx_());
        WorldRenderer.func_228430_a_(stack, builder, axisalignedbb, red, grean, blue, 1.0f);
    }
    
    public boolean shouldRender(final T entity, final ClippingHelper clippingHelper, final double camX, final double camY, final double camZ) {
        if (super.func_225626_a_((MobEntity)entity, clippingHelper, camX, camY, camZ)) {
            return true;
        }
        final Vector3d vec3d = this.getPosition((Entity)entity.block, entity.block.func_213302_cg() * 0.5, 1.0f);
        final Vector3d vec3d2 = this.getPosition((Entity)entity.block, entity.block.func_70047_e(), 1.0f);
        return clippingHelper.func_228957_a_(new AxisAlignedBB(vec3d2.field_72450_a, vec3d2.field_72448_b, vec3d2.field_72449_c, vec3d.field_72450_a, vec3d.field_72448_b, vec3d.field_72449_c));
    }
    
    private Vector3d getPosition(final Entity entity, final double p_177110_2_, final float p_177110_4_) {
        final double d0 = MathHelper.func_219803_d((double)p_177110_4_, entity.field_70142_S, entity.func_226277_ct_());
        final double d2 = MathHelper.func_219803_d((double)p_177110_4_, entity.field_70137_T, entity.func_226278_cu_()) + p_177110_2_;
        final double d3 = MathHelper.func_219803_d((double)p_177110_4_, entity.field_70136_U, entity.func_226281_cx_());
        return new Vector3d(d0, d2, d3);
    }
    
    public ResourceLocation getEntityTexture(final T entity) {
        return BlockChainGoblinRenderer.textureLoc;
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("blockgoblin.png");
    }
}
