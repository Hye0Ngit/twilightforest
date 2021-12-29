// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.tileentity;

import twilightforest.client.model.item.BuiltInItemModel;
import twilightforest.TwilightForestMod;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.block.model.IBakedModel;
import twilightforest.client.TFClientEvents;
import twilightforest.TFConfig;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraft.client.Minecraft;
import twilightforest.enums.BossVariant;
import net.minecraft.client.renderer.GlStateManager;
import javax.annotation.Nullable;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.item.ItemStack;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import twilightforest.client.model.entity.ModelTFQuestRam;
import twilightforest.client.model.armor.ModelTFPhantomArmor;
import twilightforest.client.model.entity.ModelTFKnightPhantom2;
import twilightforest.client.model.entity.ModelTFMinoshroom;
import twilightforest.client.model.entity.ModelTFSnowQueen;
import twilightforest.client.model.entity.ModelTFTowerBoss;
import twilightforest.client.model.entity.ModelTFLich;
import twilightforest.client.model.entity.ModelTFNaga;
import net.minecraft.util.ResourceLocation;
import twilightforest.client.model.entity.ModelTFHydraHead;
import twilightforest.tileentity.TileEntityTFTrophy;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;

public class TileEntityTFTrophyRenderer extends TileEntitySpecialRenderer<TileEntityTFTrophy>
{
    private final ModelTFHydraHead hydraHeadModel;
    private static final ResourceLocation textureLocHydra;
    private final ModelTFNaga nagaHeadModel;
    private static final ResourceLocation textureLocNaga;
    private final ModelTFLich lichModel;
    private static final ResourceLocation textureLocLich;
    private final ModelTFTowerBoss urGhastModel;
    private static final ResourceLocation textureLocUrGhast;
    private final ModelTFSnowQueen snowQueenModel;
    private static final ResourceLocation textureLocSnowQueen;
    private final ModelTFMinoshroom minoshroomModel;
    private static final ResourceLocation textureLocMinoshroom;
    private final ModelTFKnightPhantom2 knightPhantomModel;
    private static final ResourceLocation textureLocKnightPhantom;
    private final ModelTFPhantomArmor knightPhantomArmorModel;
    private static final ResourceLocation textureLocKnightPhantomArmor;
    private final ModelTFQuestRam questRamModel;
    private static final ResourceLocation textureLocQuestRam;
    private static final ResourceLocation textureLocQuestRamLines;
    private final ModelResourceLocation itemModelLocation;
    private ItemStack stack;
    private ItemCameraTransforms.TransformType transform;
    
    public TileEntityTFTrophyRenderer() {
        this.hydraHeadModel = new ModelTFHydraHead();
        this.nagaHeadModel = new ModelTFNaga();
        this.lichModel = new ModelTFLich();
        this.urGhastModel = new ModelTFTowerBoss();
        this.snowQueenModel = new ModelTFSnowQueen();
        this.minoshroomModel = new ModelTFMinoshroom();
        this.knightPhantomModel = new ModelTFKnightPhantom2();
        this.knightPhantomArmorModel = new ModelTFPhantomArmor(EntityEquipmentSlot.HEAD, 0.5f);
        this.questRamModel = new ModelTFQuestRam();
        this.stack = ItemStack.field_190927_a;
        this.transform = ItemCameraTransforms.TransformType.NONE;
        this.itemModelLocation = null;
    }
    
    public TileEntityTFTrophyRenderer(final ModelResourceLocation itemModelLocation) {
        this.hydraHeadModel = new ModelTFHydraHead();
        this.nagaHeadModel = new ModelTFNaga();
        this.lichModel = new ModelTFLich();
        this.urGhastModel = new ModelTFTowerBoss();
        this.snowQueenModel = new ModelTFSnowQueen();
        this.minoshroomModel = new ModelTFMinoshroom();
        this.knightPhantomModel = new ModelTFKnightPhantom2();
        this.knightPhantomArmorModel = new ModelTFPhantomArmor(EntityEquipmentSlot.HEAD, 0.5f);
        this.questRamModel = new ModelTFQuestRam();
        this.stack = ItemStack.field_190927_a;
        this.transform = ItemCameraTransforms.TransformType.NONE;
        this.itemModelLocation = itemModelLocation;
        MinecraftForge.EVENT_BUS.register((Object)this);
    }
    
    @SubscribeEvent
    public void onModelBake(final ModelBakeEvent event) {
        event.getModelRegistry().func_82595_a((Object)this.itemModelLocation, (Object)new BakedModel());
    }
    
    public void render(@Nullable final TileEntityTFTrophy trophy, final double x, final double y, final double z, final float partialTime, final int destroyStage, final float alpha) {
        GlStateManager.func_179094_E();
        GlStateManager.func_179129_p();
        if (trophy == null) {
            if (this.transform == ItemCameraTransforms.TransformType.GUI) {
                final String modelName = BossVariant.getVariant(this.stack.func_77960_j()).getTrophyType().getModelName();
                final ModelResourceLocation trophyModelLocation = new ModelResourceLocation("twilightforest:" + modelName, "inventory");
                final IBakedModel trophyModel = Minecraft.func_71410_x().func_175599_af().func_175037_a().func_178083_a().func_174953_a(trophyModelLocation);
                GlStateManager.func_179140_f();
                GlStateManager.func_179109_b(0.5f, 0.5f, -1.5f);
                Minecraft.func_71410_x().func_175599_af().func_180454_a(this.stack, ForgeHooksClient.handleCameraTransforms(trophyModel, this.transform, false));
                GlStateManager.func_179145_e();
                GlStateManager.func_179109_b(-0.5f, 0.0f, 1.5f);
                GlStateManager.func_179114_b(30.0f, 1.0f, 0.0f, 0.0f);
            }
            else if (this.transform == ItemCameraTransforms.TransformType.THIRD_PERSON_LEFT_HAND || this.transform == ItemCameraTransforms.TransformType.THIRD_PERSON_RIGHT_HAND) {
                GlStateManager.func_179152_a(0.5f, 0.5f, 0.5f);
                GlStateManager.func_179114_b(45.0f, 1.0f, 0.0f, 0.0f);
                GlStateManager.func_179114_b(45.0f, 0.0f, 1.0f, 0.0f);
                GlStateManager.func_179109_b(0.40625f, 1.171875f, 0.0f);
            }
            else if (this.transform == ItemCameraTransforms.TransformType.GROUND) {
                GlStateManager.func_179109_b(0.25f, 0.3f, 0.25f);
                GlStateManager.func_179152_a(0.5f, 0.5f, 0.5f);
            }
            else if (this.transform == ItemCameraTransforms.TransformType.HEAD) {
                if (BossVariant.getVariant(this.stack.func_77960_j()) == BossVariant.QUEST_RAM) {
                    GlStateManager.func_179152_a(3.0f, 3.0f, 3.0f);
                    GlStateManager.func_179109_b(-0.33f, -0.13f, -0.33f);
                }
                else {
                    GlStateManager.func_179152_a(2.0f, 2.0f, 2.0f);
                    GlStateManager.func_179109_b(-0.25f, 0.0f, -0.25f);
                }
            }
        }
        float rotation = (trophy != null) ? (trophy.func_145906_b() * 360 / 16.0f) : 0.0f;
        boolean onGround = true;
        if (trophy != null && trophy.func_145832_p() != 1) {
            switch (trophy.func_145832_p() & 0x7) {
                case 2: {
                    onGround = false;
                    break;
                }
                case 3: {
                    onGround = false;
                    rotation = 180.0f;
                    break;
                }
                case 4: {
                    onGround = false;
                    rotation = 270.0f;
                    break;
                }
                default: {
                    onGround = false;
                    rotation = 90.0f;
                    break;
                }
            }
        }
        else if (trophy == null && this.transform == ItemCameraTransforms.TransformType.GUI) {
            rotation = (TFConfig.rotateTrophyHeadsGui ? TFClientEvents.rotationTicker : 135.0f);
        }
        GlStateManager.func_179109_b((float)x + 0.5f, (float)y + 0.5f, (float)z + 0.5f);
        switch (BossVariant.getVariant((trophy != null) ? trophy.func_145904_a() : this.stack.func_77960_j())) {
            case HYDRA: {
                if (trophy == null) {
                    GlStateManager.func_179109_b(0.0f, -0.25f, (this.transform == ItemCameraTransforms.TransformType.HEAD) ? -0.125f : 0.0f);
                }
                this.renderHydraHead(rotation, onGround && trophy != null);
                break;
            }
            case NAGA: {
                this.renderNagaHead(rotation, onGround);
                break;
            }
            case LICH: {
                this.renderLichHead(rotation, onGround);
                break;
            }
            case UR_GHAST: {
                if (trophy == null) {
                    GlStateManager.func_179109_b(0.0f, -0.5f, 0.0f);
                }
                this.renderUrGhastHead(trophy, rotation, onGround, partialTime);
                break;
            }
            case SNOW_QUEEN: {
                this.renderSnowQueenHead(rotation, onGround);
                break;
            }
            case MINOSHROOM: {
                this.renderMinoshroomHead(rotation, onGround);
                break;
            }
            case KNIGHT_PHANTOM: {
                this.renderKnightPhantomHead(rotation, onGround);
                break;
            }
            case QUEST_RAM: {
                this.renderQuestRamHead(rotation, onGround);
                break;
            }
        }
        GlStateManager.func_179089_o();
        GlStateManager.func_179121_F();
    }
    
    private void renderHydraHead(final float rotation, final boolean onGround) {
        GlStateManager.func_179152_a(0.25f, 0.25f, 0.25f);
        this.func_147499_a(TileEntityTFTrophyRenderer.textureLocHydra);
        GlStateManager.func_179152_a(1.0f, -1.0f, -1.0f);
        GlStateManager.func_179114_b(rotation, 0.0f, 1.0f, 0.0f);
        GlStateManager.func_179114_b(180.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.func_179109_b(0.0f, onGround ? 1.0f : -0.0f, 1.5f);
        this.hydraHeadModel.openMouthForTrophy(onGround ? 0.0f : 0.25f);
        this.hydraHeadModel.func_78088_a(null, 0.0f, 0.0f, 0.0f, rotation, 0.0f, 0.0625f);
    }
    
    private void renderNagaHead(final float rotation, final boolean onGround) {
        GlStateManager.func_179109_b(0.0f, -0.125f, 0.0f);
        GlStateManager.func_179152_a(0.25f, 0.25f, 0.25f);
        this.func_147499_a(TileEntityTFTrophyRenderer.textureLocNaga);
        GlStateManager.func_179152_a(1.0f, -1.0f, -1.0f);
        GlStateManager.func_179114_b(rotation, 0.0f, 1.0f, 0.0f);
        GlStateManager.func_179114_b(180.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.func_179109_b(0.0f, onGround ? 1.0f : -0.0f, onGround ? 0.0f : 1.0f);
        this.nagaHeadModel.func_78088_a(null, 0.0f, 0.0f, 0.0f, rotation, 0.0f, 0.0625f);
    }
    
    private void renderLichHead(final float rotation, final boolean onGround) {
        GlStateManager.func_179109_b(0.0f, 1.0f, 0.0f);
        this.func_147499_a(TileEntityTFTrophyRenderer.textureLocLich);
        GlStateManager.func_179152_a(1.0f, -1.0f, -1.0f);
        GlStateManager.func_179114_b(rotation, 0.0f, 1.0f, 0.0f);
        GlStateManager.func_179114_b(180.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.func_179109_b(0.0f, onGround ? 1.75f : 1.5f, onGround ? 0.0f : 0.24f);
        this.lichModel.field_78116_c.func_78785_a(0.0625f);
        this.lichModel.field_178720_f.func_78785_a(0.0625f);
    }
    
    private void renderUrGhastHead(@Nullable final TileEntityTFTrophy trophy, final float rotation, final boolean onGround, final float partialTime) {
        GlStateManager.func_179109_b(0.0f, 1.0f, 0.0f);
        GlStateManager.func_179152_a(0.5f, 0.5f, 0.5f);
        this.func_147499_a(TileEntityTFTrophyRenderer.textureLocUrGhast);
        GlStateManager.func_179152_a(1.0f, -1.0f, -1.0f);
        GlStateManager.func_179114_b(rotation, 0.0f, 1.0f, 0.0f);
        GlStateManager.func_179114_b(180.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.func_179109_b(0.0f, onGround ? 1.0f : 1.0f, onGround ? 0.0f : 0.0f);
        this.urGhastModel.func_78088_a(null, 0.0f, 0.0f, (trophy != null) ? (trophy.ticksExisted + partialTime) : (TFClientEvents.sineTicker + partialTime), 0.0f, 0.0f, 0.0625f);
    }
    
    private void renderSnowQueenHead(final float rotation, final boolean onGround) {
        GlStateManager.func_179109_b(0.0f, 1.0f, 0.0f);
        this.func_147499_a(TileEntityTFTrophyRenderer.textureLocSnowQueen);
        GlStateManager.func_179152_a(1.0f, -1.0f, -1.0f);
        GlStateManager.func_179114_b(rotation, 0.0f, 1.0f, 0.0f);
        GlStateManager.func_179114_b(180.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.func_179109_b(0.0f, onGround ? 1.5f : 1.25f, onGround ? 0.0f : 0.24f);
        this.snowQueenModel.field_78116_c.func_78785_a(0.0625f);
        this.snowQueenModel.field_178720_f.func_78785_a(0.0625f);
    }
    
    private void renderMinoshroomHead(final float rotation, final boolean onGround) {
        GlStateManager.func_179109_b(0.0f, 1.0f, 0.0f);
        this.func_147499_a(TileEntityTFTrophyRenderer.textureLocMinoshroom);
        GlStateManager.func_179152_a(1.0f, -1.0f, -1.0f);
        GlStateManager.func_179114_b(rotation, 0.0f, 1.0f, 0.0f);
        GlStateManager.func_179114_b(180.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.func_179109_b(0.0f, onGround ? 1.875f : 1.625f, onGround ? 0.5625f : 0.8125f);
        this.minoshroomModel.field_78116_c.func_78785_a(0.0625f);
    }
    
    private void renderKnightPhantomHead(final float rotation, final boolean onGround) {
        GlStateManager.func_179109_b(0.0f, 1.0f, 0.0f);
        GlStateManager.func_179152_a(1.0f, -1.0f, -1.0f);
        GlStateManager.func_179114_b(rotation, 0.0f, 1.0f, 0.0f);
        GlStateManager.func_179114_b(180.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.func_179109_b(0.0f, onGround ? 1.5f : 1.25f, onGround ? 0.0f : 0.25f);
        GlStateManager.func_179152_a(0.9375f, 0.9375f, 0.9375f);
        this.func_147499_a(TileEntityTFTrophyRenderer.textureLocKnightPhantomArmor);
        this.knightPhantomArmorModel.field_78116_c.func_78785_a(0.0625f);
        GlStateManager.func_179131_c(1.0f, 1.0f, 1.0f, 0.75f);
        this.func_147499_a(TileEntityTFTrophyRenderer.textureLocKnightPhantom);
        this.knightPhantomModel.field_78116_c.func_78785_a(0.0625f);
    }
    
    private void renderQuestRamHead(final float rotation, final boolean onGround) {
        if (this.transform == ItemCameraTransforms.TransformType.GUI) {
            GlStateManager.func_179152_a(0.55f, 0.55f, 0.55f);
        }
        else if (this.stack.func_190926_b()) {
            GlStateManager.func_179152_a(0.65f, 0.65f, 0.65f);
        }
        else {
            GlStateManager.func_179152_a(0.5f, 0.5f, 0.5f);
        }
        if (this.transform == ItemCameraTransforms.TransformType.FIRST_PERSON_LEFT_HAND || this.transform == ItemCameraTransforms.TransformType.FIRST_PERSON_RIGHT_HAND) {
            GlStateManager.func_179109_b(0.0f, 0.5f, 0.0f);
        }
        this.func_147499_a(TileEntityTFTrophyRenderer.textureLocQuestRam);
        GlStateManager.func_179152_a(1.0f, -1.0f, -1.0f);
        GlStateManager.func_179114_b(rotation, 0.0f, 1.0f, 0.0f);
        GlStateManager.func_179114_b(180.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.func_179109_b(0.0f, onGround ? 1.3f : 1.03f, onGround ? 0.765625f : 1.085f);
        this.questRamModel.head.func_78785_a(0.0625f);
        GlStateManager.func_179140_f();
        this.func_147499_a(TileEntityTFTrophyRenderer.textureLocQuestRamLines);
        final float var4 = 1.0f;
        GlStateManager.func_179147_l();
        GlStateManager.func_179118_c();
        GlStateManager.func_179112_b(770, 1);
        GlStateManager.func_179152_a(1.025f, 1.025f, 1.025f);
        final char var5 = '\uf0f0';
        final int var6 = var5 % 65536;
        final int var7 = var5 / 65536;
        OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, var6 / 1.0f, var7 / 1.0f);
        GlStateManager.func_179131_c(1.0f, 1.0f, 1.0f, var4);
        this.questRamModel.head.func_78785_a(0.0625f);
        GlStateManager.func_179131_c(1.0f, 1.0f, 1.0f, 1.0f);
        OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, 240.0f, 240.0f);
        GlStateManager.func_179112_b(770, 771);
        GlStateManager.func_179141_d();
        GlStateManager.func_179145_e();
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
        textureLocQuestRam = TwilightForestMod.getModelTexture("questram.png");
        textureLocQuestRamLines = TwilightForestMod.getModelTexture("questram_lines.png");
    }
    
    public static class DummyTile extends TileEntityTFTrophy
    {
    }
    
    private class BakedModel extends BuiltInItemModel
    {
        BakedModel() {
            super("minecraft:blocks/soul_sand");
        }
        
        @Override
        protected void setItemStack(final ItemStack stack) {
            TileEntityTFTrophyRenderer.this.stack = stack;
        }
        
        @Override
        protected void setTransform(final ItemCameraTransforms.TransformType transform) {
            TileEntityTFTrophyRenderer.this.transform = transform;
        }
    }
}
