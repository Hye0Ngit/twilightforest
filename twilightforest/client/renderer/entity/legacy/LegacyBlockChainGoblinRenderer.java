// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity.legacy;

import twilightforest.TwilightForestMod;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.world.phys.AABB;
import net.minecraft.client.renderer.LevelRenderer;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import twilightforest.client.renderer.entity.BlockChainRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.Mth;
import com.mojang.math.Vector3f;
import net.minecraft.world.entity.Mob;
import net.minecraft.client.renderer.MultiBufferSource;
import com.mojang.blaze3d.vertex.PoseStack;
import twilightforest.client.model.entity.ChainModel;
import twilightforest.client.model.entity.SpikeBlockModel;
import twilightforest.client.model.TFModelLayers;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.Model;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import twilightforest.client.model.entity.legacy.BlockChainGoblinLegacyModel;
import twilightforest.entity.monster.BlockChainGoblin;

public class LegacyBlockChainGoblinRenderer<T extends BlockChainGoblin, M extends BlockChainGoblinLegacyModel<T>> extends HumanoidMobRenderer<T, M>
{
    private static final ResourceLocation textureLoc;
    private final Model model;
    private final Model chainModel;
    
    public LegacyBlockChainGoblinRenderer(final EntityRendererProvider.Context manager, final M goblinModel, final float shadowSize) {
        super(manager, (HumanoidModel)goblinModel, shadowSize);
        this.model = (Model)new SpikeBlockModel(manager.m_174023_(TFModelLayers.CHAIN_BLOCK));
        this.chainModel = (Model)new ChainModel(manager.m_174023_(TFModelLayers.CHAIN));
    }
    
    public void render(final T goblin, final float yaw, final float partialTicks, final PoseStack stack, final MultiBufferSource buffer, final int light) {
        super.m_7392_((Mob)goblin, yaw, partialTicks, stack, buffer, light);
        stack.m_85836_();
        final double blockInX = goblin.block.m_20185_() - goblin.m_20185_();
        final double blockInY = goblin.block.m_20186_() - goblin.m_20186_();
        final double blockInZ = goblin.block.m_20189_() - goblin.m_20189_();
        final VertexConsumer ivertexbuilder = buffer.m_6299_(this.model.m_103119_(LegacyBlockChainGoblinRenderer.textureLoc));
        stack.m_85837_(blockInX, blockInY, blockInZ);
        final float pitch = goblin.f_19860_ + (goblin.m_146909_() - goblin.f_19860_) * partialTicks;
        stack.m_85845_(Vector3f.f_122225_.m_122240_(180.0f - Mth.m_14177_(yaw)));
        stack.m_85845_(Vector3f.f_122223_.m_122240_(pitch));
        stack.m_85841_(-1.0f, -1.0f, 1.0f);
        this.model.m_7695_(stack, ivertexbuilder, light, OverlayTexture.f_118083_, 1.0f, 1.0f, 1.0f, 1.0f);
        stack.m_85849_();
        BlockChainRenderer.renderChain((Entity)goblin, (Entity)goblin.chain1, yaw, partialTicks, stack, buffer, light, this.chainModel);
        BlockChainRenderer.renderChain((Entity)goblin, (Entity)goblin.chain2, yaw, partialTicks, stack, buffer, light, this.chainModel);
        BlockChainRenderer.renderChain((Entity)goblin, (Entity)goblin.chain3, yaw, partialTicks, stack, buffer, light, this.chainModel);
        if (this.f_114476_.m_114377_() && !goblin.block.m_20145_() && !Minecraft.m_91087_().m_91299_()) {
            stack.m_85836_();
            stack.m_85837_(blockInX, blockInY, blockInZ);
            this.renderMultiBoundingBox(stack, buffer.m_6299_(RenderType.m_110504_()), (Entity)goblin.block, 0.25f, 1.0f, 0.0f);
            stack.m_85849_();
        }
    }
    
    private void renderMultiBoundingBox(final PoseStack stack, final VertexConsumer builder, final Entity entity, final float red, final float grean, final float blue) {
        final AABB axisalignedbb = entity.m_142469_().m_82386_(-entity.m_20185_(), -entity.m_20186_(), -entity.m_20189_());
        LevelRenderer.m_109646_(stack, builder, axisalignedbb, red, grean, blue, 1.0f);
    }
    
    public boolean shouldRender(final T entity, final Frustum clippingHelper, final double camX, final double camY, final double camZ) {
        if (super.m_5523_((Mob)entity, clippingHelper, camX, camY, camZ)) {
            return true;
        }
        final Vec3 vec3d = this.getPosition((Entity)entity.block, entity.block.m_20206_() * 0.5, 1.0f);
        final Vec3 vec3d2 = this.getPosition((Entity)entity.block, entity.block.m_20192_(), 1.0f);
        return clippingHelper.m_113029_(new AABB(vec3d2.f_82479_, vec3d2.f_82480_, vec3d2.f_82481_, vec3d.f_82479_, vec3d.f_82480_, vec3d.f_82481_));
    }
    
    private Vec3 getPosition(final Entity entity, final double p_177110_2_, final float p_177110_4_) {
        final double d0 = Mth.m_14139_((double)p_177110_4_, entity.f_19790_, entity.m_20185_());
        final double d2 = Mth.m_14139_((double)p_177110_4_, entity.f_19791_, entity.m_20186_()) + p_177110_2_;
        final double d3 = Mth.m_14139_((double)p_177110_4_, entity.f_19792_, entity.m_20189_());
        return new Vec3(d0, d2, d3);
    }
    
    public ResourceLocation getTextureLocation(final T entity) {
        return LegacyBlockChainGoblinRenderer.textureLoc;
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("blockgoblin.png");
    }
}
