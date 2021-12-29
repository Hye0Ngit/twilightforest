// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import twilightforest.tileentity.KeepsakeCasketTileEntity;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import twilightforest.block.KeepsakeCasketBlock;
import net.minecraft.util.Direction;
import twilightforest.TFConfig;
import net.minecraft.util.math.vector.Vector3f;
import twilightforest.enums.BossVariant;
import net.minecraftforge.client.ForgeHooksClient;
import twilightforest.client.renderer.tileentity.TrophyTileEntityRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.model.ModelResourceLocation;
import twilightforest.TwilightForestMod;
import twilightforest.block.AbstractTrophyBlock;
import net.minecraft.item.BlockItem;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.tileentity.ItemStackTileEntityRenderer;

public class ISTER extends ItemStackTileEntityRenderer
{
    private final ResourceLocation typeId;
    private TileEntity dummy;
    
    public ISTER(final ResourceLocation typeId) {
        this.typeId = typeId;
    }
    
    public void func_239207_a_(final ItemStack stack, final ItemCameraTransforms.TransformType camera, final MatrixStack ms, final IRenderTypeBuffer buffers, final int light, final int overlay) {
        if (this.dummy == null) {
            this.dummy = ((TileEntityType)ForgeRegistries.TILE_ENTITIES.getValue(this.typeId)).func_200968_a();
        }
        final Item item = stack.func_77973_b();
        if (item instanceof BlockItem) {
            final Block block = ((BlockItem)item).func_179223_d();
            if (block instanceof AbstractTrophyBlock) {
                if (camera == ItemCameraTransforms.TransformType.GUI) {
                    final ModelResourceLocation back = new ModelResourceLocation(TwilightForestMod.prefix(((AbstractTrophyBlock)block).getVariant().getTrophyType().getModelName()), "inventory");
                    final IBakedModel modelBack = Minecraft.func_71410_x().func_175599_af().func_175037_a().func_178083_a().func_174953_a(back);
                    ms.func_227860_a_();
                    ms.func_227861_a_(0.5, 0.5, -1.5);
                    Minecraft.func_71410_x().func_175599_af().func_229111_a_(TrophyTileEntityRenderer.stack, ItemCameraTransforms.TransformType.GUI, false, ms, buffers, 240, overlay, ForgeHooksClient.handleCameraTransforms(ms, modelBack, camera, false));
                    ms.func_227865_b_();
                    ms.func_227860_a_();
                    ms.func_227861_a_(0.5, 0.5, 0.5);
                    if (((AbstractTrophyBlock)block).getVariant() == BossVariant.HYDRA || ((AbstractTrophyBlock)block).getVariant() == BossVariant.QUEST_RAM) {
                        ms.func_227862_a_(0.9f, 0.9f, 0.9f);
                    }
                    ms.func_227863_a_(Vector3f.field_229179_b_.func_229187_a_(30.0f));
                    ms.func_227863_a_(Vector3f.field_229180_c_.func_229187_a_(((boolean)TFConfig.CLIENT_CONFIG.rotateTrophyHeadsGui.get()) ? TFClientEvents.rotationTicker : -45.0f));
                    ms.func_227861_a_(-0.5, -0.5, -0.5);
                    ms.func_227861_a_(0.0, 0.25, 0.0);
                    if (((AbstractTrophyBlock)block).getVariant() == BossVariant.UR_GHAST) {
                        ms.func_227861_a_(0.0, 0.5, 0.0);
                    }
                    if (((AbstractTrophyBlock)block).getVariant() == BossVariant.ALPHA_YETI) {
                        ms.func_227861_a_(0.0, -0.15000000596046448, 0.0);
                    }
                    TrophyTileEntityRenderer.render(null, 180.0f, ((AbstractTrophyBlock)block).getVariant(), 0.0f, ms, buffers, light, camera);
                    ms.func_227865_b_();
                }
                else {
                    TrophyTileEntityRenderer.render(null, 180.0f, ((AbstractTrophyBlock)block).getVariant(), 0.0f, ms, buffers, light, camera);
                }
            }
            else if (block instanceof KeepsakeCasketBlock) {
                TileEntityRendererDispatcher.field_147556_a.func_228852_a_((TileEntity)new KeepsakeCasketTileEntity(), ms, buffers, light, overlay);
            }
            else {
                final TileEntityRenderer<TileEntity> renderer = (TileEntityRenderer<TileEntity>)TileEntityRendererDispatcher.field_147556_a.func_147547_b(this.dummy);
                renderer.func_225616_a_((TileEntity)null, 0.0f, ms, buffers, light, overlay);
            }
        }
    }
}
