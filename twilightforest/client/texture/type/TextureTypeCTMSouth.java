// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.texture.type;

import team.chisel.ctm.api.texture.ITextureContext;
import net.minecraft.client.renderer.block.model.IBakedModel;
import twilightforest.client.texture.render.CTMLogicSouth;
import team.chisel.ctm.client.model.AbstractCTMBakedModel;
import net.minecraft.client.Minecraft;
import team.chisel.ctm.client.util.CTMLogic;
import javax.annotation.Nonnull;
import team.chisel.ctm.client.texture.ctx.TextureContextCTM;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.state.IBlockState;
import team.chisel.ctm.client.texture.render.TextureCTM;
import team.chisel.ctm.api.texture.ICTMTexture;
import team.chisel.ctm.api.util.TextureInfo;
import team.chisel.ctm.api.texture.TextureType;
import team.chisel.ctm.client.texture.type.TextureTypeCTM;

@TextureType("ctm_tf_south")
public class TextureTypeCTMSouth extends TextureTypeCTM
{
    public ICTMTexture<? extends TextureTypeCTM> makeTexture(final TextureInfo info) {
        return (ICTMTexture<? extends TextureTypeCTM>)new TextureCTM((TextureTypeCTM)this, info);
    }
    
    public TextureContextCTM getBlockRenderContext(final IBlockState state, final IBlockAccess world, final BlockPos pos, final ICTMTexture<?> tex) {
        return new TextureContextCTM(state, world, pos, (TextureCTM)tex) {
            protected CTMLogic createCTM(@Nonnull final IBlockState state) {
                final IBakedModel model = Minecraft.func_71410_x().func_175602_ab().func_184389_a(state);
                if (model instanceof AbstractCTMBakedModel) {
                    return CTMLogicSouth.getInstance().ignoreStates(((AbstractCTMBakedModel)model).getModel().ignoreStates());
                }
                return CTMLogicSouth.getInstance();
            }
        };
    }
}
