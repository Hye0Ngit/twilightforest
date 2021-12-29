// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.tileentity;

import twilightforest.block.TFBlocks;
import net.minecraft.world.level.ItemLike;
import twilightforest.TwilightForestMod;
import net.minecraft.world.level.block.entity.BlockEntity;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.RenderType;
import javax.annotation.Nullable;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import twilightforest.block.AbstractTrophyBlock;
import twilightforest.block.TrophyBlock;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.core.Direction;
import twilightforest.block.TrophyWallBlock;
import net.minecraft.client.renderer.MultiBufferSource;
import com.mojang.blaze3d.vertex.PoseStack;
import java.util.function.BooleanSupplier;
import twilightforest.client.model.tileentity.QuestRamTrophyModel;
import twilightforest.client.model.tileentity.legacy.QuestRamTrophyLegacyModel;
import twilightforest.client.model.tileentity.SnowQueenTrophyModel;
import twilightforest.client.model.tileentity.legacy.SnowQueenTrophyLegacyModel;
import twilightforest.client.model.tileentity.AlphaYetiTrophyModel;
import twilightforest.client.model.tileentity.UrGhastTrophyModel;
import twilightforest.client.model.tileentity.KnightPhantomTrophyModel;
import twilightforest.client.model.tileentity.HydraTrophyModel;
import twilightforest.client.model.tileentity.legacy.HydraTrophyLegacyModel;
import twilightforest.client.model.tileentity.MinoshroomTrophyModel;
import twilightforest.client.model.tileentity.legacy.MinoshroomTrophyLegacyModel;
import twilightforest.client.model.tileentity.LichTrophyModel;
import twilightforest.client.model.tileentity.NagaTrophyModel;
import twilightforest.client.model.TFModelLayers;
import com.google.common.collect.ImmutableMap;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import twilightforest.client.model.tileentity.GenericTrophyModel;
import twilightforest.enums.BossVariant;
import java.util.Map;
import twilightforest.block.entity.TrophyBlockEntity;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;

public class TrophyTileEntityRenderer implements BlockEntityRenderer<TrophyBlockEntity>
{
    private final Map<BossVariant, GenericTrophyModel> trophies;
    private static final ResourceLocation textureLocHydra;
    private static final ResourceLocation textureLocNaga;
    private static final ResourceLocation textureLocLich;
    private static final ResourceLocation textureLocUrGhast;
    private static final ResourceLocation textureLocSnowQueen;
    private static final ResourceLocation textureLocMinoshroom;
    private static final ResourceLocation textureLocKnightPhantom;
    private static final ResourceLocation textureLocKnightPhantomArmor;
    private static final ResourceLocation textureLocYeti;
    private static final ResourceLocation textureLocQuestRam;
    private static final ResourceLocation textureLocQuestRamLines;
    public static ItemStack stack;
    
    public TrophyTileEntityRenderer(final BlockEntityRendererProvider.Context renderer) {
        this.trophies = createTrophyRenderers(renderer.m_173585_());
    }
    
    public static Map<BossVariant, GenericTrophyModel> createTrophyRenderers(final EntityModelSet set) {
        final BooleanSupplier legacy = () -> Minecraft.m_91087_().m_91099_().m_10523_().contains("builtin/twilight_forest_legacy_resources");
        final ImmutableMap.Builder<BossVariant, GenericTrophyModel> trophyList = (ImmutableMap.Builder<BossVariant, GenericTrophyModel>)ImmutableMap.builder();
        trophyList.put((Object)BossVariant.NAGA, (Object)new NagaTrophyModel(set.m_171103_(TFModelLayers.NAGA_TROPHY)));
        trophyList.put((Object)BossVariant.LICH, (Object)new LichTrophyModel(set.m_171103_(TFModelLayers.LICH_TROPHY)));
        trophyList.put((Object)BossVariant.MINOSHROOM, (Object)(legacy.getAsBoolean() ? new MinoshroomTrophyLegacyModel(set.m_171103_(TFModelLayers.LEGACY_MINOSHROOM_TROPHY)) : new MinoshroomTrophyModel(set.m_171103_(TFModelLayers.MINOSHROOM_TROPHY))));
        trophyList.put((Object)BossVariant.HYDRA, (Object)(legacy.getAsBoolean() ? new HydraTrophyLegacyModel(set.m_171103_(TFModelLayers.LEGACY_HYDRA_TROPHY)) : new HydraTrophyModel(set.m_171103_(TFModelLayers.HYDRA_TROPHY))));
        trophyList.put((Object)BossVariant.KNIGHT_PHANTOM, (Object)new KnightPhantomTrophyModel(set.m_171103_(TFModelLayers.KNIGHT_PHANTOM_TROPHY)));
        trophyList.put((Object)BossVariant.UR_GHAST, (Object)new UrGhastTrophyModel(set.m_171103_(TFModelLayers.UR_GHAST_TROPHY)));
        trophyList.put((Object)BossVariant.ALPHA_YETI, (Object)new AlphaYetiTrophyModel(set.m_171103_(TFModelLayers.ALPHA_YETI_TROPHY)));
        trophyList.put((Object)BossVariant.SNOW_QUEEN, (Object)(legacy.getAsBoolean() ? new SnowQueenTrophyLegacyModel(set.m_171103_(TFModelLayers.LEGACY_SNOW_QUEEN_TROPHY)) : new SnowQueenTrophyModel(set.m_171103_(TFModelLayers.SNOW_QUEEN_TROPHY))));
        trophyList.put((Object)BossVariant.QUEST_RAM, (Object)(legacy.getAsBoolean() ? new QuestRamTrophyLegacyModel(set.m_171103_(TFModelLayers.LEGACY_QUEST_RAM_TROPHY)) : new QuestRamTrophyModel(set.m_171103_(TFModelLayers.QUEST_RAM_TROPHY))));
        return (Map<BossVariant, GenericTrophyModel>)trophyList.build();
    }
    
    public void render(final TrophyBlockEntity tileEntityIn, final float partialTicks, final PoseStack matrixStackIn, final MultiBufferSource bufferIn, final int combinedLightIn, final int combinedOverlayIn) {
        final float f = tileEntityIn.getAnimationProgress(partialTicks);
        final BlockState blockstate = tileEntityIn.m_58900_();
        final boolean flag = blockstate.m_60734_() instanceof TrophyWallBlock;
        final Direction direction = flag ? ((Direction)blockstate.m_61143_((Property)TrophyWallBlock.FACING)) : null;
        final float f2 = 22.5f * (float)(flag ? ((2 + direction.m_122416_()) * 4) : blockstate.m_61143_((Property)TrophyBlock.ROTATION));
        final BossVariant variant = ((AbstractTrophyBlock)blockstate.m_60734_()).getVariant();
        final GenericTrophyModel trophy = this.trophies.get(variant);
        matrixStackIn.m_85836_();
        if (variant == BossVariant.HYDRA) {
            trophy.openMouthForTrophy(flag ? 0.5f : 0.0f);
        }
        if (variant == BossVariant.UR_GHAST) {
            ((UrGhastTrophyModel)trophy).setTranslate(matrixStackIn, 0.0f, 1.0f, 0.0f);
        }
        render(direction, f2, trophy, variant, f, matrixStackIn, bufferIn, combinedLightIn, ItemTransforms.TransformType.NONE);
        matrixStackIn.m_85849_();
    }
    
    public static void render(@Nullable final Direction directionIn, final float y, final GenericTrophyModel trophy, final BossVariant variant, final float animationProgress, final PoseStack matrixStackIn, final MultiBufferSource buffer, final int combinedLight, final ItemTransforms.TransformType camera) {
        final BooleanSupplier legacy = () -> Minecraft.m_91087_().m_91099_().m_10523_().contains("builtin/twilight_forest_legacy_resources");
        matrixStackIn.m_85836_();
        if (directionIn == null || variant == BossVariant.UR_GHAST) {
            matrixStackIn.m_85837_(0.5, 0.0, 0.5);
        }
        else {
            matrixStackIn.m_85837_((double)(0.5f - directionIn.m_122429_() * 0.249f), 0.25, (double)(0.5f - directionIn.m_122431_() * 0.249f));
        }
        matrixStackIn.m_85841_(-1.0f, -1.0f, 1.0f);
        switch (variant) {
            case HYDRA: {
                matrixStackIn.m_85841_(0.25f, 0.25f, 0.25f);
                matrixStackIn.m_85837_(legacy.getAsBoolean() ? 1.0 : 0.0, legacy.getAsBoolean() ? -1.149999976158142 : -1.0, 0.0);
                if (camera == ItemTransforms.TransformType.GUI) {
                    trophy.openMouthForTrophy(0.35f);
                }
                trophy.setRotations(animationProgress * 4.5f, y, 0.0f);
                final VertexConsumer hydraVertex = buffer.m_6299_(RenderType.m_110458_(TrophyTileEntityRenderer.textureLocHydra));
                trophy.m_7695_(matrixStackIn, hydraVertex, combinedLight, OverlayTexture.f_118083_, 1.0f, 1.0f, 1.0f, 1.0f);
                break;
            }
            case NAGA: {
                matrixStackIn.m_85841_(0.5f, 0.5f, 0.5f);
                matrixStackIn.m_85837_(0.0, 0.25, 0.0);
                trophy.setRotations(animationProgress * 4.5f, y, 0.0f);
                final VertexConsumer nagaVertex = buffer.m_6299_(RenderType.m_110458_(TrophyTileEntityRenderer.textureLocNaga));
                trophy.m_7695_(matrixStackIn, nagaVertex, combinedLight, OverlayTexture.f_118083_, 1.0f, 1.0f, 1.0f, 1.0f);
                break;
            }
            case LICH: {
                matrixStackIn.m_85837_(0.0, 0.25, 0.0);
                trophy.setRotations(animationProgress * 4.5f, y, 0.0f);
                final VertexConsumer lichVertex = buffer.m_6299_(RenderType.m_110458_(TrophyTileEntityRenderer.textureLocLich));
                trophy.m_7695_(matrixStackIn, lichVertex, combinedLight, OverlayTexture.f_118083_, 1.0f, 1.0f, 1.0f, 1.0f);
                break;
            }
            case UR_GHAST: {
                matrixStackIn.m_85841_(0.5f, 0.5f, 0.5f);
                trophy.setRotations(animationProgress * 4.5f, y, 0.0f);
                final VertexConsumer ghastVertex = buffer.m_6299_(RenderType.m_110458_(TrophyTileEntityRenderer.textureLocUrGhast));
                trophy.m_7695_(matrixStackIn, ghastVertex, combinedLight, OverlayTexture.f_118083_, 1.0f, 1.0f, 1.0f, 1.0f);
                break;
            }
            case SNOW_QUEEN: {
                matrixStackIn.m_85837_(0.0, legacy.getAsBoolean() ? 0.25 : 0.0, 0.0);
                trophy.setRotations(animationProgress * 4.5f, y, 0.0f);
                final VertexConsumer waifuVertex = buffer.m_6299_(RenderType.m_110458_(TrophyTileEntityRenderer.textureLocSnowQueen));
                trophy.m_7695_(matrixStackIn, waifuVertex, combinedLight, OverlayTexture.f_118083_, 1.0f, 1.0f, 1.0f, 1.0f);
                break;
            }
            case MINOSHROOM: {
                matrixStackIn.m_85837_(0.0, legacy.getAsBoolean() ? 0.11999999731779099 : 0.06499999761581421, legacy.getAsBoolean() ? 0.5600000023841858 : 0.0);
                trophy.setRotations(animationProgress * 4.5f, y, 0.0f);
                final VertexConsumer minoVertex = buffer.m_6299_(RenderType.m_110458_(TrophyTileEntityRenderer.textureLocMinoshroom));
                trophy.m_7695_(matrixStackIn, minoVertex, combinedLight, OverlayTexture.f_118083_, 1.0f, 1.0f, 1.0f, 1.0f);
                break;
            }
            case KNIGHT_PHANTOM: {
                matrixStackIn.m_85837_(0.0, 0.25, 0.0);
                trophy.setRotations(animationProgress * 4.5f, y, 0.0f);
                final VertexConsumer phantomVertex = buffer.m_6299_(RenderType.m_110458_(TrophyTileEntityRenderer.textureLocKnightPhantom));
                trophy.m_7695_(matrixStackIn, phantomVertex, combinedLight, OverlayTexture.f_118083_, 1.0f, 1.0f, 1.0f, 1.0f);
                matrixStackIn.m_85841_(1.1f, 1.1f, 1.1f);
                matrixStackIn.m_85837_(0.0, 0.05000000074505806, 0.0);
                trophy.setRotations(animationProgress * 4.5f, y, 0.0f);
                final VertexConsumer phantomArmorVertex = buffer.m_6299_(RenderType.m_110458_(TrophyTileEntityRenderer.textureLocKnightPhantomArmor));
                trophy.renderHelmToBuffer(matrixStackIn, phantomArmorVertex, combinedLight, OverlayTexture.f_118083_, 1.0f, 1.0f, 1.0f, 0.0625f);
                break;
            }
            case ALPHA_YETI: {
                matrixStackIn.m_85841_(0.2f, 0.2f, 0.2f);
                matrixStackIn.m_85837_(0.0, -1.5, 0.0);
                trophy.setRotations(animationProgress * 4.5f, y, 0.0f);
                final VertexConsumer yetiVertex = buffer.m_6299_(RenderType.m_110458_(TrophyTileEntityRenderer.textureLocYeti));
                trophy.m_7695_(matrixStackIn, yetiVertex, combinedLight, OverlayTexture.f_118083_, 1.0f, 1.0f, 1.0f, 1.0f);
                break;
            }
            case QUEST_RAM: {
                matrixStackIn.m_85841_(0.7f, 0.7f, 0.7f);
                trophy.setRotations(animationProgress * 4.5f, y, 0.0f);
                final VertexConsumer ramVertex = buffer.m_6299_(RenderType.m_110458_(TrophyTileEntityRenderer.textureLocQuestRam));
                trophy.m_7695_(matrixStackIn, ramVertex, combinedLight, OverlayTexture.f_118083_, 1.0f, 1.0f, 1.0f, 1.0f);
                break;
            }
        }
        matrixStackIn.m_85849_();
    }
    
    static {
        textureLocHydra = TwilightForestMod.getModelTexture("hydra4.png");
        textureLocNaga = TwilightForestMod.getModelTexture("nagahead.png");
        textureLocLich = TwilightForestMod.getModelTexture("twilightlich64.png");
        textureLocUrGhast = TwilightForestMod.getModelTexture("towerboss.png");
        textureLocSnowQueen = TwilightForestMod.getModelTexture("snowqueen.png");
        textureLocMinoshroom = TwilightForestMod.getModelTexture("minoshroomtaur.png");
        textureLocKnightPhantom = TwilightForestMod.getModelTexture("phantomskeleton.png");
        textureLocKnightPhantomArmor = new ResourceLocation("twilightforest:textures/armor/phantom_1.png");
        textureLocYeti = TwilightForestMod.getModelTexture("yetialpha.png");
        textureLocQuestRam = TwilightForestMod.getModelTexture("questram.png");
        textureLocQuestRamLines = TwilightForestMod.getModelTexture("questram_lines.png");
        TrophyTileEntityRenderer.stack = new ItemStack((ItemLike)TFBlocks.NAGA_TROPHY.get());
    }
}
