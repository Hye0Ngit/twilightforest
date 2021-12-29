// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.tileentity;

import net.minecraft.tileentity.TileEntity;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.util.ResourceLocation;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.world.World;
import it.unimi.dsi.fastutil.floats.Float2FloatFunction;
import net.minecraft.tileentity.TileEntityMerger;
import net.minecraft.world.IBlockDisplayReader;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.Minecraft;
import twilightforest.TwilightForestMod;
import java.util.Locale;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.util.Direction;
import net.minecraft.fluid.Fluids;
import net.minecraft.block.Blocks;
import net.minecraft.state.Property;
import twilightforest.enums.BlockLoggingEnum;
import twilightforest.block.TFBlocks;
import twilightforest.block.KeepsakeCasketBlock;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.tileentity.IChestLid;
import twilightforest.tileentity.KeepsakeCasketTileEntity;

@OnlyIn(Dist.CLIENT)
public class CasketTileEntityRenderer<T extends KeepsakeCasketTileEntity & IChestLid> extends TileEntityRenderer<T>
{
    public ModelRenderer base;
    public ModelRenderer lid;
    
    public CasketTileEntityRenderer(final TileEntityRendererDispatcher rendererDispatcherIn) {
        super(rendererDispatcherIn);
        (this.lid = new ModelRenderer(64, 64, 0, 0)).func_78793_a(0.0f, -6.0f, 6.0f);
        this.lid.func_228302_a_(-8.0f, -8.0f, -13.0f, 16.0f, 10.0f, 14.0f, 0.0f, 0.0f, 0.0f);
        this.lid.func_78784_a(0, 46).func_228302_a_(-8.0f, -10.0f, -13.0f, 16.0f, 2.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        this.lid.func_78784_a(2, 34).func_228302_a_(-7.99f, -10.0f, -12.0f, 0.0f, 2.0f, 14.0f, 0.0f, 0.0f, 0.0f);
        this.lid.func_78784_a(2, 36).func_228302_a_(7.99f, -10.0f, -12.0f, 0.0f, 2.0f, 14.0f, 0.0f, 0.0f, 0.0f);
        (this.base = new ModelRenderer(64, 64, 0, 0)).func_78793_a(0.0f, -0.01f, 0.0f);
        this.base.func_78784_a(1, 28).func_228302_a_(-7.0f, -10.0f, -2.0f, 14.0f, 10.0f, 8.0f, 0.0f, 0.0f, 0.0f);
        this.base.func_78784_a(0, 26).func_228302_a_(-7.0f, -10.0f, -6.0f, 1.0f, 6.0f, 4.0f, 0.0f, 0.0f, 0.0f);
        this.base.func_78784_a(40, 26).func_228302_a_(6.0f, -10.0f, -6.0f, 1.0f, 6.0f, 4.0f, 0.0f, 0.0f, 0.0f);
        this.base.func_78784_a(0, 56).func_228302_a_(-7.0f, -4.0f, -6.0f, 14.0f, 4.0f, 4.0f, 0.0f, 0.0f, 0.0f);
    }
    
    public void render(final T tileEntityIn, final float partialTicks, final MatrixStack matrixStackIn, final IRenderTypeBuffer bufferIn, final int combinedLightIn, final int combinedOverlayIn) {
        final World world = tileEntityIn.func_145831_w();
        final boolean flag = world != null;
        final BlockState blockstate = flag ? tileEntityIn.func_195044_w() : ((KeepsakeCasketBlock)TFBlocks.keepsake_casket.get()).func_176223_P();
        final Block block = blockstate.func_177230_c();
        if (block instanceof KeepsakeCasketBlock) {
            final BlockLoggingEnum type = (BlockLoggingEnum)blockstate.func_177229_b((Property)BlockLoggingEnum.MULTILOGGED);
            final int damage = (int)blockstate.func_177229_b((Property)KeepsakeCasketBlock.BREAKAGE);
            final boolean solid = type.getBlock() != Blocks.field_150350_a && type.getFluid() == Fluids.field_204541_a;
            final float facing = ((Direction)blockstate.func_177229_b((Property)HorizontalBlock.field_185512_D)).func_185119_l();
            if (solid) {
                matrixStackIn.func_227860_a_();
                matrixStackIn.func_227861_a_(0.5, 0.5, 0.5);
                matrixStackIn.func_227863_a_(Vector3f.field_229181_d_.func_229187_a_(-facing));
                matrixStackIn.func_227861_a_(-0.5, -0.5, -0.5);
                final ResourceLocation BLOCK = TwilightForestMod.prefix("block/casket_" + type.getBlock().getRegistryName().func_110623_a().toLowerCase(Locale.ROOT));
                final IBakedModel blockrender = Minecraft.func_71410_x().func_209506_al().getModel(BLOCK);
                final BlockRendererDispatcher render = Minecraft.func_71410_x().func_175602_ab();
                render.func_175019_b().func_228802_a_((IBlockDisplayReader)world, blockrender, type.getBlock().func_176223_P(), tileEntityIn.func_174877_v(), matrixStackIn, bufferIn.getBuffer(RenderType.func_228645_f_()), false, world.field_73012_v, MathHelper.func_180186_a((Vector3i)BlockPos.field_177992_a), OverlayTexture.field_229196_a_);
                matrixStackIn.func_227865_b_();
            }
            matrixStackIn.func_227860_a_();
            matrixStackIn.func_227862_a_(-1.0f, -1.0f, -1.0f);
            matrixStackIn.func_227861_a_(-0.5, 0.0, -0.5);
            matrixStackIn.func_227863_a_(Vector3f.field_229181_d_.func_229187_a_(-facing));
            final TileEntityMerger.ICallbackWrapper<? extends KeepsakeCasketTileEntity> icallbackwrapper = (TileEntityMerger.ICallbackWrapper<? extends KeepsakeCasketTileEntity>)TileEntityMerger.ICallback::func_225537_b_;
            float f1 = ((Float2FloatFunction)icallbackwrapper.apply((TileEntityMerger.ICallback)KeepsakeCasketBlock.getLidRotationCallback(tileEntityIn))).get(partialTicks);
            f1 = 1.0f - f1;
            f1 = 1.0f - f1 * f1 * f1;
            final ResourceLocation CASKET = TwilightForestMod.getModelTexture("casket/keepsake_casket_" + damage + ".png");
            this.renderModels(matrixStackIn, bufferIn.getBuffer(RenderType.func_228640_c_(CASKET)), this.lid, this.base, f1, combinedLightIn, combinedOverlayIn);
            matrixStackIn.func_227865_b_();
        }
    }
    
    private void renderModels(final MatrixStack matrixStackIn, final IVertexBuilder bufferIn, final ModelRenderer lid, final ModelRenderer base, final float lidAngle, final int combinedLightIn, final int combinedOverlayIn) {
        lid.field_78795_f = -(lidAngle * 1.5707964f);
        lid.func_228308_a_(matrixStackIn, bufferIn, combinedLightIn, combinedOverlayIn);
        base.func_228308_a_(matrixStackIn, bufferIn, combinedLightIn, combinedOverlayIn);
    }
}
