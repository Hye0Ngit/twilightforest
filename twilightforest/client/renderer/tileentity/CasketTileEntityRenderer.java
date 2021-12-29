// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.tileentity;

import net.minecraft.world.level.block.entity.BlockEntity;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;
import net.minecraft.client.renderer.RenderType;
import twilightforest.TwilightForestMod;
import it.unimi.dsi.fastutil.floats.Float2FloatFunction;
import net.minecraft.world.level.block.DoubleBlockCombiner;
import com.mojang.math.Vector3f;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.properties.Property;
import twilightforest.block.TFBlocks;
import twilightforest.block.KeepsakeCasketBlock;
import net.minecraft.client.renderer.MultiBufferSource;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import twilightforest.client.model.TFModelLayers;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.world.level.block.entity.LidBlockEntity;
import twilightforest.block.entity.KeepsakeCasketBlockEntity;

@OnlyIn(Dist.CLIENT)
public class CasketTileEntityRenderer<T extends KeepsakeCasketBlockEntity & LidBlockEntity> implements BlockEntityRenderer<T>
{
    public ModelPart base;
    public ModelPart lid;
    
    public CasketTileEntityRenderer(final BlockEntityRendererProvider.Context renderer) {
        final ModelPart root = renderer.m_173582_(TFModelLayers.KEEPSAKE_CASKET);
        this.base = root.m_171324_("base");
        this.lid = root.m_171324_("lid");
    }
    
    public static LayerDefinition create() {
        final MeshDefinition meshdefinition = new MeshDefinition();
        final PartDefinition partdefinition = meshdefinition.m_171576_();
        partdefinition.m_171599_("lid", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171481_(-8.0f, -8.0f, -13.0f, 16.0f, 10.0f, 14.0f).m_171514_(0, 46).m_171481_(-8.0f, -10.0f, -13.0f, 16.0f, 2.0f, 0.0f).m_171514_(2, 34).m_171481_(-7.99f, -10.0f, -12.0f, 0.0f, 2.0f, 14.0f).m_171514_(2, 36).m_171481_(7.99f, -10.0f, -12.0f, 0.0f, 2.0f, 14.0f), PartPose.m_171419_(0.0f, -6.0f, 6.0f));
        partdefinition.m_171599_("base", CubeListBuilder.m_171558_().m_171514_(1, 28).m_171481_(-7.0f, -10.0f, -2.0f, 14.0f, 10.0f, 8.0f).m_171514_(0, 26).m_171481_(-7.0f, -10.0f, -6.0f, 1.0f, 6.0f, 4.0f).m_171514_(40, 26).m_171481_(6.0f, -10.0f, -6.0f, 1.0f, 6.0f, 4.0f).m_171514_(0, 56).m_171481_(-7.0f, -4.0f, -6.0f, 14.0f, 4.0f, 4.0f), PartPose.m_171419_(0.0f, -0.01f, 0.0f));
        return LayerDefinition.m_171565_(meshdefinition, 64, 64);
    }
    
    public void render(final T tileEntityIn, final float partialTicks, final PoseStack matrixStackIn, final MultiBufferSource bufferIn, final int combinedLightIn, final int combinedOverlayIn) {
        final Level world = tileEntityIn.m_58904_();
        final boolean flag = world != null;
        final BlockState blockstate = flag ? tileEntityIn.m_58900_() : ((KeepsakeCasketBlock)TFBlocks.KEEPSAKE_CASKET.get()).m_49966_();
        final Block block = blockstate.m_60734_();
        if (block instanceof KeepsakeCasketBlock) {
            final int damage = (int)blockstate.m_61143_((Property)KeepsakeCasketBlock.BREAKAGE);
            final Direction facing = (Direction)blockstate.m_61143_((Property)HorizontalDirectionalBlock.f_54117_);
            matrixStackIn.m_85836_();
            matrixStackIn.m_85837_(0.5, 0.0, 0.5);
            matrixStackIn.m_85845_(facing.m_122406_());
            matrixStackIn.m_85845_(Vector3f.f_122223_.m_122240_(90.0f));
            final DoubleBlockCombiner.NeighborCombineResult<? extends KeepsakeCasketBlockEntity> icallbackwrapper = (DoubleBlockCombiner.NeighborCombineResult<? extends KeepsakeCasketBlockEntity>)DoubleBlockCombiner.Combiner::m_6502_;
            float f1 = ((Float2FloatFunction)icallbackwrapper.m_5649_((DoubleBlockCombiner.Combiner)KeepsakeCasketBlock.getLidRotationCallback(tileEntityIn))).get(partialTicks);
            f1 = 1.0f - f1;
            f1 = 1.0f - f1 * f1 * f1;
            final ResourceLocation CASKET = TwilightForestMod.getModelTexture("casket/keepsake_casket_" + damage + ".png");
            this.renderModels(matrixStackIn, bufferIn.m_6299_(RenderType.m_110458_(CASKET)), this.lid, this.base, f1, combinedLightIn, combinedOverlayIn);
            matrixStackIn.m_85849_();
        }
    }
    
    private void renderModels(final PoseStack matrixStackIn, final VertexConsumer bufferIn, final ModelPart lid, final ModelPart base, final float lidAngle, final int combinedLightIn, final int combinedOverlayIn) {
        lid.f_104203_ = -(lidAngle * 1.5707964f);
        lid.m_104301_(matrixStackIn, bufferIn, combinedLightIn, combinedOverlayIn);
        base.m_104301_(matrixStackIn, bufferIn, combinedLightIn, combinedOverlayIn);
    }
}
