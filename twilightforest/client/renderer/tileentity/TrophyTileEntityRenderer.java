// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.tileentity;

import twilightforest.block.TFBlocks;
import net.minecraft.util.IItemProvider;
import twilightforest.TwilightForestMod;
import net.minecraft.tileentity.TileEntity;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.RenderType;
import javax.annotation.Nullable;
import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import twilightforest.enums.BossVariant;
import twilightforest.block.AbstractTrophyBlock;
import twilightforest.block.TrophyBlock;
import net.minecraft.state.Property;
import net.minecraft.util.Direction;
import twilightforest.block.TrophyWallBlock;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import twilightforest.client.model.tileentity.QuestRamTrophyModel;
import twilightforest.client.model.tileentity.ModelTFYetiAlphaTrophy;
import twilightforest.client.model.tileentity.PhantomArmorTrophyModel;
import twilightforest.client.model.tileentity.KnightPhantomTrophyModel;
import twilightforest.client.model.tileentity.MinoshroomTrophyModel;
import twilightforest.client.model.tileentity.SnowQueenTrophyModel;
import twilightforest.client.model.tileentity.UrGhastTrophyModel;
import twilightforest.client.model.tileentity.LichTrophyModel;
import twilightforest.client.model.tileentity.NagaTrophyModel;
import net.minecraft.util.ResourceLocation;
import twilightforest.client.model.tileentity.HydraTrophyModel;
import twilightforest.tileentity.TrophyTileEntity;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;

public class TrophyTileEntityRenderer extends TileEntityRenderer<TrophyTileEntity>
{
    private static final HydraTrophyModel hydraHead;
    private static final ResourceLocation textureLocHydra;
    private static final NagaTrophyModel nagaHead;
    private static final ResourceLocation textureLocNaga;
    private static final LichTrophyModel lichHead;
    private static final ResourceLocation textureLocLich;
    private static final UrGhastTrophyModel ghastHead;
    private static final ResourceLocation textureLocUrGhast;
    private static final SnowQueenTrophyModel waifuHead;
    private static final ResourceLocation textureLocSnowQueen;
    private static final MinoshroomTrophyModel minoshroomHead;
    private static final ResourceLocation textureLocMinoshroom;
    private static final KnightPhantomTrophyModel phantomHead;
    private static final ResourceLocation textureLocKnightPhantom;
    private static final PhantomArmorTrophyModel phantomArmorModel;
    private static final ResourceLocation textureLocKnightPhantomArmor;
    private static final ModelTFYetiAlphaTrophy yetiHead;
    private static final ResourceLocation textureLocYeti;
    private static final QuestRamTrophyModel ramHead;
    private static final ResourceLocation textureLocQuestRam;
    private static final ResourceLocation textureLocQuestRamLines;
    public static ItemStack stack;
    
    public TrophyTileEntityRenderer(final TileEntityRendererDispatcher rendererDispatcherIn) {
        super(rendererDispatcherIn);
    }
    
    public void render(final TrophyTileEntity tileEntityIn, final float partialTicks, final MatrixStack matrixStackIn, final IRenderTypeBuffer bufferIn, final int combinedLightIn, final int combinedOverlayIn) {
        final float f = tileEntityIn.getAnimationProgress(partialTicks);
        final BlockState blockstate = tileEntityIn.func_195044_w();
        final boolean flag = blockstate.func_177230_c() instanceof TrophyWallBlock;
        final Direction direction = flag ? ((Direction)blockstate.func_177229_b((Property)TrophyWallBlock.FACING)) : null;
        final float f2 = 22.5f * (float)(flag ? ((2 + direction.func_176736_b()) * 4) : blockstate.func_177229_b((Property)TrophyBlock.ROTATION));
        matrixStackIn.func_227860_a_();
        if (((AbstractTrophyBlock)blockstate.func_177230_c()).getVariant() == BossVariant.HYDRA && flag) {
            TrophyTileEntityRenderer.hydraHead.openMouthForTrophy(0.5f);
        }
        else {
            TrophyTileEntityRenderer.hydraHead.openMouthForTrophy(0.0f);
        }
        if (((AbstractTrophyBlock)blockstate.func_177230_c()).getVariant() == BossVariant.UR_GHAST) {
            TrophyTileEntityRenderer.ghastHead.setTranslate(matrixStackIn, 0.0f, 1.0f, 0.0f);
        }
        render(direction, f2, ((AbstractTrophyBlock)blockstate.func_177230_c()).getVariant(), f, matrixStackIn, bufferIn, combinedLightIn, ItemCameraTransforms.TransformType.NONE);
        matrixStackIn.func_227865_b_();
    }
    
    public static void render(@Nullable final Direction directionIn, final float y, final BossVariant variant, final float animationProgress, final MatrixStack matrixStackIn, final IRenderTypeBuffer buffer, final int combinedLight, final ItemCameraTransforms.TransformType camera) {
        matrixStackIn.func_227860_a_();
        if (directionIn == null || variant == BossVariant.UR_GHAST) {
            matrixStackIn.func_227861_a_(0.5, 0.0, 0.5);
        }
        else {
            matrixStackIn.func_227861_a_((double)(0.5f - directionIn.func_82601_c() * 0.25f), 0.25, (double)(0.5f - directionIn.func_82599_e() * 0.25f));
        }
        matrixStackIn.func_227862_a_(-1.0f, -1.0f, 1.0f);
        switch (variant) {
            case HYDRA: {
                matrixStackIn.func_227862_a_(0.25f, 0.25f, 0.25f);
                matrixStackIn.func_227861_a_(0.0, -1.0, 0.0);
                if (camera == ItemCameraTransforms.TransformType.GUI) {
                    TrophyTileEntityRenderer.hydraHead.openMouthForTrophy(0.35f);
                }
                TrophyTileEntityRenderer.hydraHead.setRotations(animationProgress * 4.5f, y, 0.0f);
                final IVertexBuilder hydraVertex = buffer.getBuffer(RenderType.func_228640_c_(TrophyTileEntityRenderer.textureLocHydra));
                TrophyTileEntityRenderer.hydraHead.head.func_228309_a_(matrixStackIn, hydraVertex, combinedLight, OverlayTexture.field_229196_a_, 1.0f, 1.0f, 1.0f, 1.0f);
                break;
            }
            case NAGA: {
                matrixStackIn.func_227862_a_(0.5f, 0.5f, 0.5f);
                matrixStackIn.func_227861_a_(0.0, 0.25, 0.0);
                TrophyTileEntityRenderer.nagaHead.setRotations(animationProgress * 4.5f, y, 0.0f);
                final IVertexBuilder nagaVertex = buffer.getBuffer(RenderType.func_228640_c_(TrophyTileEntityRenderer.textureLocNaga));
                TrophyTileEntityRenderer.nagaHead.head.func_228309_a_(matrixStackIn, nagaVertex, combinedLight, OverlayTexture.field_229196_a_, 1.0f, 1.0f, 1.0f, 1.0f);
                break;
            }
            case LICH: {
                matrixStackIn.func_227861_a_(0.0, 0.25, 0.0);
                TrophyTileEntityRenderer.lichHead.setRotations(animationProgress * 4.5f, y, 0.0f);
                final IVertexBuilder lichVertex = buffer.getBuffer(RenderType.func_228640_c_(TrophyTileEntityRenderer.textureLocLich));
                TrophyTileEntityRenderer.lichHead.head.func_228309_a_(matrixStackIn, lichVertex, combinedLight, OverlayTexture.field_229196_a_, 1.0f, 1.0f, 1.0f, 1.0f);
                break;
            }
            case UR_GHAST: {
                matrixStackIn.func_227862_a_(0.5f, 0.5f, 0.5f);
                TrophyTileEntityRenderer.ghastHead.setRotations(animationProgress * 4.5f, y, 0.0f);
                final IVertexBuilder ghastVertex = buffer.getBuffer(RenderType.func_228640_c_(TrophyTileEntityRenderer.textureLocUrGhast));
                TrophyTileEntityRenderer.ghastHead.body.func_228309_a_(matrixStackIn, ghastVertex, combinedLight, OverlayTexture.field_229196_a_, 1.0f, 1.0f, 1.0f, 1.0f);
                break;
            }
            case SNOW_QUEEN: {
                TrophyTileEntityRenderer.waifuHead.setRotations(animationProgress * 4.5f, y, 0.0f);
                final IVertexBuilder waifuVertex = buffer.getBuffer(RenderType.func_228640_c_(TrophyTileEntityRenderer.textureLocSnowQueen));
                TrophyTileEntityRenderer.waifuHead.head.func_228309_a_(matrixStackIn, waifuVertex, combinedLight, OverlayTexture.field_229196_a_, 1.0f, 1.0f, 1.0f, 1.0f);
                break;
            }
            case MINOSHROOM: {
                matrixStackIn.func_227861_a_(0.0, 0.3100000023841858, 0.0);
                TrophyTileEntityRenderer.minoshroomHead.setRotations(animationProgress * 4.5f, y, 0.0f);
                final IVertexBuilder minoVertex = buffer.getBuffer(RenderType.func_228640_c_(TrophyTileEntityRenderer.textureLocMinoshroom));
                TrophyTileEntityRenderer.minoshroomHead.head.func_228309_a_(matrixStackIn, minoVertex, combinedLight, OverlayTexture.field_229196_a_, 1.0f, 1.0f, 1.0f, 1.0f);
                break;
            }
            case KNIGHT_PHANTOM: {
                matrixStackIn.func_227861_a_(0.0, 0.25, 0.0);
                TrophyTileEntityRenderer.phantomHead.setRotations(animationProgress * 4.5f, y, 0.0f);
                final IVertexBuilder phantomVertex = buffer.getBuffer(RenderType.func_228640_c_(TrophyTileEntityRenderer.textureLocKnightPhantom));
                TrophyTileEntityRenderer.phantomHead.head.func_228309_a_(matrixStackIn, phantomVertex, combinedLight, OverlayTexture.field_229196_a_, 1.0f, 1.0f, 1.0f, 1.0f);
                matrixStackIn.func_227862_a_(1.1f, 1.1f, 1.1f);
                matrixStackIn.func_227861_a_(0.0, 0.05000000074505806, 0.0);
                TrophyTileEntityRenderer.phantomArmorModel.setRotations(animationProgress * 4.5f, y, 0.0f);
                final IVertexBuilder phantomArmorVertex = buffer.getBuffer(RenderType.func_228640_c_(TrophyTileEntityRenderer.textureLocKnightPhantomArmor));
                TrophyTileEntityRenderer.phantomArmorModel.head.func_228309_a_(matrixStackIn, phantomArmorVertex, combinedLight, OverlayTexture.field_229196_a_, 1.0f, 1.0f, 1.0f, 0.0625f);
                break;
            }
            case ALPHA_YETI: {
                matrixStackIn.func_227862_a_(0.2f, 0.2f, 0.2f);
                matrixStackIn.func_227861_a_(0.0, -1.5, 0.0);
                TrophyTileEntityRenderer.yetiHead.setRotations(animationProgress * 4.5f, y, 0.0f);
                final IVertexBuilder yetiVertex = buffer.getBuffer(RenderType.func_228640_c_(TrophyTileEntityRenderer.textureLocYeti));
                TrophyTileEntityRenderer.yetiHead.main.func_228309_a_(matrixStackIn, yetiVertex, combinedLight, OverlayTexture.field_229196_a_, 1.0f, 1.0f, 1.0f, 1.0f);
                break;
            }
            case QUEST_RAM: {
                matrixStackIn.func_227862_a_(0.7f, 0.7f, 0.7f);
                TrophyTileEntityRenderer.ramHead.setRotations(animationProgress * 4.5f, y, 0.0f);
                final IVertexBuilder ramVertex = buffer.getBuffer(RenderType.func_228640_c_(TrophyTileEntityRenderer.textureLocQuestRam));
                TrophyTileEntityRenderer.ramHead.func_225598_a_(matrixStackIn, ramVertex, combinedLight, OverlayTexture.field_229196_a_, 1.0f, 1.0f, 1.0f, 1.0f);
                break;
            }
        }
        matrixStackIn.func_227865_b_();
    }
    
    static {
        hydraHead = new HydraTrophyModel();
        textureLocHydra = TwilightForestMod.getModelTexture("hydra4.png");
        nagaHead = new NagaTrophyModel();
        textureLocNaga = TwilightForestMod.getModelTexture("nagahead.png");
        lichHead = new LichTrophyModel();
        textureLocLich = TwilightForestMod.getModelTexture("twilightlich64.png");
        ghastHead = new UrGhastTrophyModel();
        textureLocUrGhast = TwilightForestMod.getModelTexture("towerboss.png");
        waifuHead = new SnowQueenTrophyModel();
        textureLocSnowQueen = TwilightForestMod.getModelTexture("snowqueen.png");
        minoshroomHead = new MinoshroomTrophyModel();
        textureLocMinoshroom = TwilightForestMod.getModelTexture("minoshroomtaur.png");
        phantomHead = new KnightPhantomTrophyModel();
        textureLocKnightPhantom = TwilightForestMod.getModelTexture("phantomskeleton.png");
        phantomArmorModel = new PhantomArmorTrophyModel();
        textureLocKnightPhantomArmor = new ResourceLocation("twilightforest:textures/armor/phantom_1.png");
        yetiHead = new ModelTFYetiAlphaTrophy();
        textureLocYeti = TwilightForestMod.getModelTexture("yetialpha.png");
        ramHead = new QuestRamTrophyModel();
        textureLocQuestRam = TwilightForestMod.getModelTexture("questram.png");
        textureLocQuestRamLines = TwilightForestMod.getModelTexture("questram_lines.png");
        TrophyTileEntityRenderer.stack = new ItemStack((IItemProvider)TFBlocks.naga_trophy.get());
    }
}
