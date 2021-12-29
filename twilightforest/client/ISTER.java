// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.SkullBlock;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.CandleBlock;
import net.minecraft.world.level.block.state.BlockState;
import twilightforest.client.renderer.tileentity.SkullCandleTileEntityRenderer;
import net.minecraft.client.model.SkullModelBase;
import net.minecraft.world.level.block.entity.SkullBlockEntity;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.CompoundTag;
import java.util.UUID;
import com.mojang.authlib.GameProfile;
import org.apache.commons.lang3.StringUtils;
import net.minecraft.nbt.NbtUtils;
import twilightforest.block.AbstractSkullCandleBlock;
import twilightforest.block.TwilightChest;
import net.minecraft.core.Direction;
import twilightforest.TFConfig;
import com.mojang.math.Vector3f;
import twilightforest.enums.BossVariant;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraft.client.renderer.texture.OverlayTexture;
import com.mojang.blaze3d.platform.Lighting;
import net.minecraft.client.resources.model.ModelResourceLocation;
import twilightforest.TwilightForestMod;
import twilightforest.client.renderer.tileentity.TrophyTileEntityRenderer;
import twilightforest.client.model.tileentity.GenericTrophyModel;
import twilightforest.block.AbstractTrophyBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.client.renderer.MultiBufferSource;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.world.item.ItemStack;
import net.minecraft.Util;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraftforge.fmllegacy.RegistryObject;
import java.util.HashMap;
import twilightforest.block.TFBlocks;
import twilightforest.block.KeepsakeCasketBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;
import twilightforest.block.entity.TwilightChestEntity;
import net.minecraft.world.level.block.Block;
import java.util.Map;
import twilightforest.block.entity.KeepsakeCasketBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;

public class ISTER extends BlockEntityWithoutLevelRenderer
{
    private final ResourceLocation typeId;
    private BlockEntity dummy;
    private final KeepsakeCasketBlockEntity keepsakeCasketBlockEntity;
    private final Map<Block, TwilightChestEntity> chestEntities;
    
    public ISTER(final ResourceLocation typeId) {
        super(Minecraft.m_91087_().m_167982_(), Minecraft.m_91087_().m_167973_());
        this.keepsakeCasketBlockEntity = new KeepsakeCasketBlockEntity(BlockPos.f_121853_, ((KeepsakeCasketBlock)TFBlocks.KEEPSAKE_CASKET.get()).m_49966_());
        this.chestEntities = (Map)Util.m_137469_((Object)new HashMap(), map -> {
            makeInstance(map, TFBlocks.TWILIGHT_OAK_CHEST);
            makeInstance(map, TFBlocks.CANOPY_CHEST);
            makeInstance(map, TFBlocks.MANGROVE_CHEST);
            makeInstance(map, TFBlocks.DARKWOOD_CHEST);
            makeInstance(map, TFBlocks.TIME_CHEST);
            makeInstance(map, TFBlocks.TRANSFORMATION_CHEST);
            makeInstance(map, TFBlocks.MINING_CHEST);
            makeInstance(map, TFBlocks.SORTING_CHEST);
            return;
        });
        this.typeId = typeId;
    }
    
    public void m_108829_(final ItemStack stack, final ItemTransforms.TransformType camera, final PoseStack ms, final MultiBufferSource buffers, final int light, final int overlay) {
        if (this.dummy == null) {
            this.dummy = ((BlockEntityType)ForgeRegistries.BLOCK_ENTITIES.getValue(this.typeId)).m_155264_(BlockPos.f_121853_, Blocks.f_50016_.m_49966_());
        }
        final Item item = stack.m_41720_();
        if (item instanceof final BlockItem blockItem) {
            final Block block = blockItem.m_40614_();
            if (block instanceof final AbstractTrophyBlock abstractTrophyBlock) {
                final BossVariant variant = abstractTrophyBlock.getVariant();
                final GenericTrophyModel trophy = TrophyTileEntityRenderer.createTrophyRenderers(Minecraft.m_91087_().m_167973_()).get(variant);
                if (camera == ItemTransforms.TransformType.GUI) {
                    final ModelResourceLocation back = new ModelResourceLocation(TwilightForestMod.prefix(((AbstractTrophyBlock)block).getVariant().getTrophyType().getModelName()), "inventory");
                    final BakedModel modelBack = Minecraft.m_91087_().m_91291_().m_115103_().m_109393_().m_119422_(back);
                    Lighting.m_84930_();
                    final MultiBufferSource.BufferSource bufferSource = Minecraft.m_91087_().m_91269_().m_110104_();
                    ms.m_85836_();
                    Lighting.m_84930_();
                    ms.m_85837_(0.5, 0.5, -1.5);
                    Minecraft.m_91087_().m_91291_().m_115143_(TrophyTileEntityRenderer.stack, ItemTransforms.TransformType.GUI, false, ms, (MultiBufferSource)bufferSource, 15728880, OverlayTexture.f_118083_, ForgeHooksClient.handleCameraTransforms(ms, modelBack, camera, false));
                    ms.m_85849_();
                    bufferSource.m_109911_();
                    Lighting.m_84931_();
                    ms.m_85836_();
                    ms.m_85837_(0.5, 0.5, 0.5);
                    if (((AbstractTrophyBlock)block).getVariant() == BossVariant.HYDRA || ((AbstractTrophyBlock)block).getVariant() == BossVariant.QUEST_RAM) {
                        ms.m_85841_(0.9f, 0.9f, 0.9f);
                    }
                    ms.m_85845_(Vector3f.f_122223_.m_122240_(30.0f));
                    ms.m_85845_(Vector3f.f_122224_.m_122240_(((boolean)TFConfig.CLIENT_CONFIG.rotateTrophyHeadsGui.get()) ? TFClientEvents.rotationTicker : -45.0f));
                    if (((AbstractTrophyBlock)block).getVariant() == BossVariant.HYDRA && Minecraft.m_91087_().m_91099_().m_10523_().contains("builtin/twilight_forest_legacy_resources")) {
                        ms.m_85837_(0.25, 0.0, -0.25);
                    }
                    ms.m_85837_(-0.5, -0.5, -0.5);
                    ms.m_85837_(0.0, 0.25, 0.0);
                    if (((AbstractTrophyBlock)block).getVariant() == BossVariant.UR_GHAST) {
                        ms.m_85837_(0.0, 0.5, 0.0);
                    }
                    if (((AbstractTrophyBlock)block).getVariant() == BossVariant.ALPHA_YETI) {
                        ms.m_85837_(0.0, -0.15000000596046448, 0.0);
                    }
                    TrophyTileEntityRenderer.render(null, 180.0f, trophy, variant, 0.0f, ms, buffers, light, camera);
                    ms.m_85849_();
                }
                else {
                    TrophyTileEntityRenderer.render(null, 180.0f, trophy, variant, 0.0f, ms, buffers, light, camera);
                }
            }
            else if (block instanceof KeepsakeCasketBlock) {
                Minecraft.m_91087_().m_167982_().m_112272_((BlockEntity)this.keepsakeCasketBlockEntity, ms, buffers, light, overlay);
            }
            else if (block instanceof TwilightChest) {
                Minecraft.m_91087_().m_167982_().m_112272_((BlockEntity)this.chestEntities.get(block), ms, buffers, light, overlay);
            }
            else if (block instanceof AbstractSkullCandleBlock) {
                GameProfile gameprofile = null;
                if (stack.m_41782_()) {
                    final CompoundTag compoundtag = stack.m_41783_();
                    if (compoundtag.m_128425_("SkullOwner", 10)) {
                        gameprofile = NbtUtils.m_129228_(compoundtag.m_128469_("SkullOwner"));
                    }
                    else if (compoundtag.m_128425_("SkullOwner", 8) && !StringUtils.isBlank((CharSequence)compoundtag.m_128461_("SkullOwner"))) {
                        gameprofile = new GameProfile((UUID)null, compoundtag.m_128461_("SkullOwner"));
                        compoundtag.m_128473_("SkullOwner");
                        SkullBlockEntity.m_155738_(gameprofile, p_172560_ -> compoundtag.m_128365_("SkullOwner", (Tag)NbtUtils.m_129230_(new CompoundTag(), p_172560_)));
                    }
                }
                final SkullBlock.Type type = ((AbstractSkullCandleBlock)block).getType();
                final SkullModelBase base = SkullCandleTileEntityRenderer.createSkullRenderers(Minecraft.m_91087_().m_167973_()).get(type);
                final RenderType renderType = SkullCandleTileEntityRenderer.getRenderType(type, gameprofile);
                SkullCandleTileEntityRenderer.renderSkull(null, 180.0f, 0.0f, ms, buffers, light, base, renderType);
                ms.m_85837_(0.0, 0.5, 0.0);
                final CompoundTag tag = stack.m_41737_("BlockEntityTag");
                if (tag != null && tag.m_128441_("CandleColor") && tag.m_128441_("CandleAmount")) {
                    if (tag.m_128451_("CandleAmount") <= 0) {
                        tag.m_128405_("CandleAmount", 1);
                    }
                    Minecraft.m_91087_().m_91289_().m_110912_((BlockState)AbstractSkullCandleBlock.candleColorToCandle(AbstractSkullCandleBlock.CandleColors.colorFromInt(tag.m_128451_("CandleColor")).m_7912_()).m_49966_().m_61124_((Property)CandleBlock.f_152790_, (Comparable)tag.m_128451_("CandleAmount")), ms, buffers, light, overlay);
                }
            }
            else {
                final BlockEntityRenderer<BlockEntity> renderer = (BlockEntityRenderer<BlockEntity>)Minecraft.m_91087_().m_167982_().m_112265_(this.dummy);
                renderer.m_6922_((BlockEntity)null, 0.0f, ms, buffers, light, overlay);
            }
        }
    }
    
    public static void makeInstance(final Map<Block, TwilightChestEntity> map, final RegistryObject<? extends ChestBlock> registryObject) {
        final ChestBlock block = (ChestBlock)registryObject.get();
        map.put((Block)block, new TwilightChestEntity(BlockPos.f_121853_, block.m_49966_()));
    }
}
