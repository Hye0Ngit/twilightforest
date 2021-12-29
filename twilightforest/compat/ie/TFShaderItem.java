// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.compat.ie;

import net.minecraft.world.level.ItemLike;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import blusunrize.immersiveengineering.api.shader.ShaderLayer;
import blusunrize.immersiveengineering.common.util.Utils;
import twilightforest.TwilightForestMod;
import blusunrize.immersiveengineering.common.util.ItemNBTHelper;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import java.util.Iterator;
import blusunrize.immersiveengineering.api.shader.impl.ShaderCaseItem;
import net.minecraft.client.gui.screens.Screen;
import blusunrize.immersiveengineering.api.client.TextUtils;
import net.minecraft.world.item.TooltipFlag;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraftforge.items.ItemHandlerHelper;
import blusunrize.immersiveengineering.common.blocks.cloth.ShaderBannerBlockEntity;
import net.minecraft.world.level.block.BannerBlock;
import blusunrize.immersiveengineering.common.blocks.cloth.ShaderBannerStandingBlock;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.core.Direction;
import blusunrize.immersiveengineering.common.blocks.cloth.ShaderBannerWallBlock;
import blusunrize.immersiveengineering.common.register.IEBlocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.WallBannerBlock;
import net.minecraft.world.level.block.entity.BannerBlockEntity;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.TranslatableComponent;
import java.util.Locale;
import net.minecraft.network.chat.Component;
import blusunrize.immersiveengineering.api.shader.ShaderRegistry;
import blusunrize.immersiveengineering.api.shader.ShaderCase;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import twilightforest.item.TFItems;
import blusunrize.immersiveengineering.api.shader.IShaderItem;
import net.minecraft.world.item.Item;

public class TFShaderItem extends Item implements IShaderItem
{
    static final String TAG_SHADER = "shader_name";
    
    public TFShaderItem() {
        super(TFItems.defaultBuilder().m_41487_(1));
    }
    
    public ShaderCase getShaderCase(final ItemStack shader, final ResourceLocation shaderType) {
        return ShaderRegistry.getShader(this.getShaderName(shader), shaderType);
    }
    
    public ResourceLocation getShaderName(final ItemStack stack) {
        return getShaderType(stack);
    }
    
    public Component m_7626_(final ItemStack stack) {
        final ResourceLocation rawShaderName = this.getShaderName(stack);
        final String unlocalizedShaderName = "item." + rawShaderName.m_135827_() + ".shader.name." + rawShaderName.m_135815_().replace(' ', '_').toLowerCase(Locale.ROOT);
        final String localizedShaderName = new TranslatableComponent(unlocalizedShaderName).getString();
        if (unlocalizedShaderName.equals(localizedShaderName)) {
            return (Component)new TranslatableComponent(this.m_5671_(stack), new Object[] { rawShaderName.m_135815_() }).m_130946_(" *TRANSLATION FAILURE*").m_130940_(ChatFormatting.DARK_RED);
        }
        return (Component)new TranslatableComponent(this.m_5671_(stack), new Object[] { localizedShaderName });
    }
    
    public InteractionResult m_6225_(final UseOnContext ctx) {
        final Level world = ctx.m_43725_();
        final BlockPos pos = ctx.m_8083_();
        final ResourceLocation name = this.getShaderName(ctx.m_43722_());
        if (ShaderRegistry.shaderRegistry.containsKey(name)) {
            final BlockState blockState = world.m_8055_(pos);
            BlockEntity tile = world.m_7702_(pos);
            if (tile instanceof BannerBlockEntity) {
                final ShaderCase sCase = ShaderRegistry.shaderRegistry.get(name).getCase(new ResourceLocation("immersiveengineering", "banner"));
                if (sCase != null) {
                    final boolean wall = blockState.m_60734_() instanceof WallBannerBlock;
                    if (wall) {
                        world.m_46597_(pos, (BlockState)IEBlocks.Cloth.SHADER_BANNER_WALL.defaultBlockState().m_61124_(ShaderBannerWallBlock.FACING, (Comparable)blockState.m_61143_((Property)WallBannerBlock.f_57916_)));
                    }
                    else {
                        world.m_46597_(pos, (BlockState)IEBlocks.Cloth.SHADER_BANNER.defaultBlockState().m_61124_((Property)ShaderBannerStandingBlock.ROTATION, (Comparable)blockState.m_61143_((Property)BannerBlock.f_49007_)));
                    }
                    final BlockEntity 7702_;
                    tile = (7702_ = world.m_7702_(pos));
                    if (7702_ instanceof final ShaderBannerBlockEntity sb) {
                        sb.shader.setShaderItem(ItemHandlerHelper.copyStackWithSize(ctx.m_43722_(), 1));
                        tile.m_6596_();
                        return InteractionResult.SUCCESS;
                    }
                }
            }
            else {
                final BlockEntity blockEntity = tile;
                if (blockEntity instanceof final ShaderBannerBlockEntity sb2) {
                    sb2.shader.setShaderItem(ItemHandlerHelper.copyStackWithSize(ctx.m_43722_(), 1));
                    sb2.m_6596_();
                    return InteractionResult.SUCCESS;
                }
            }
        }
        return InteractionResult.FAIL;
    }
    
    @OnlyIn(Dist.CLIENT)
    public void m_7373_(final ItemStack stack, @Nullable final Level world, final List<Component> list, final TooltipFlag flag) {
        list.add((Component)new TranslatableComponent("desc.immersiveengineering.info.shader.level").m_7220_((Component)TextUtils.applyFormat((Component)new TranslatableComponent("desc.immersiveengineering.info.shader.rarity." + this.m_41460_(stack).name().toLowerCase(Locale.US)), new ChatFormatting[] { this.m_41460_(stack).f_43022_ })));
        if (ShaderRegistry.shaderRegistry.containsKey(this.getShaderName(stack))) {
            if (!Screen.m_96638_()) {
                list.add((Component)new TranslatableComponent("desc.immersiveengineering.info.shader.applyTo").m_130946_(" ").m_7220_((Component)new TranslatableComponent("desc.immersiveengineering.info.holdShift")));
            }
            else {
                list.add((Component)new TranslatableComponent("desc.immersiveengineering.info.shader.applyTo"));
                for (ShaderCase sCase : ShaderRegistry.shaderRegistry.get(this.getShaderName(stack)).getCases()) {
                    if (!(sCase instanceof ShaderCaseItem)) {
                        list.add((Component)TextUtils.applyFormat((Component)new TranslatableComponent("desc.immersiveengineering.info.shader." + sCase.getShaderType()), new ChatFormatting[] { ChatFormatting.DARK_GRAY }));
                    }
                }
            }
        }
    }
    
    public Rarity m_41460_(final ItemStack stack) {
        return ShaderRegistry.shaderRegistry.containsKey(this.getShaderName(stack)) ? ShaderRegistry.shaderRegistry.get(this.getShaderName(stack)).getRarity() : Rarity.COMMON;
    }
    
    public static ResourceLocation getShaderType(final ItemStack stack) {
        return ItemNBTHelper.hasKey(stack, "shader_name") ? new ResourceLocation(ItemNBTHelper.getString(stack, "shader_name")) : TwilightForestMod.prefix("twilight");
    }
    
    public static int getShaderColors(final ItemStack stack, final int pass) {
        final ResourceLocation name = getShaderType(stack);
        if (ShaderRegistry.shaderRegistry.containsKey(name)) {
            final ShaderCase sCase = ShaderRegistry.shaderRegistry.get(name).getCase(new ResourceLocation("immersiveengineering", "item"));
            if (sCase != null) {
                final ShaderLayer[] layers = sCase.getLayers();
                if (pass < layers.length && layers[pass] != null) {
                    return Utils.intFromRGBA(layers[pass].getColor());
                }
                return -1;
            }
        }
        return -1;
    }
    
    public void m_6787_(final CreativeModeTab group, final NonNullList<ItemStack> items) {
        if (group == TFItems.creativeTab) {
            for (final ShaderRegistry.ShaderRegistryEntry entry : IEShaderRegister.getAllTwilightShaders()) {
                final ItemStack stack = new ItemStack((ItemLike)this);
                ItemNBTHelper.putString(stack, "shader_name", entry.getName().toString());
                items.add((Object)stack);
            }
        }
    }
}
