// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.compat.ie;

import net.minecraft.util.IItemProvider;
import net.minecraft.util.NonNullList;
import net.minecraft.item.ItemGroup;
import blusunrize.immersiveengineering.api.shader.ShaderLayer;
import blusunrize.immersiveengineering.common.util.Utils;
import twilightforest.TwilightForestMod;
import blusunrize.immersiveengineering.common.util.ItemNBTHelper;
import net.minecraft.item.Rarity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import java.util.Iterator;
import blusunrize.immersiveengineering.api.shader.impl.ShaderCaseItem;
import net.minecraft.client.gui.screen.Screen;
import blusunrize.immersiveengineering.api.client.TextUtils;
import net.minecraft.client.util.ITooltipFlag;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.ItemHandlerHelper;
import blusunrize.immersiveengineering.common.blocks.cloth.ShaderBannerTileEntity;
import net.minecraft.block.BannerBlock;
import blusunrize.immersiveengineering.common.blocks.cloth.ShaderBannerStandingBlock;
import net.minecraft.state.Property;
import blusunrize.immersiveengineering.common.blocks.cloth.ShaderBannerWallBlock;
import blusunrize.immersiveengineering.common.blocks.IEBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.WallBannerBlock;
import net.minecraft.tileentity.BannerTileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import java.util.Locale;
import net.minecraft.util.text.ITextComponent;
import blusunrize.immersiveengineering.api.shader.ShaderRegistry;
import blusunrize.immersiveengineering.api.shader.ShaderCase;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemStack;
import twilightforest.item.TFItems;
import blusunrize.immersiveengineering.api.shader.IShaderItem;
import net.minecraft.item.Item;

public class TFShaderItem extends Item implements IShaderItem
{
    static final String TAG_SHADER = "shader_name";
    
    public TFShaderItem() {
        super(TFItems.defaultBuilder().func_200917_a(1));
    }
    
    public ShaderCase getShaderCase(final ItemStack shader, final ItemStack tool, final ResourceLocation shaderType) {
        return ShaderRegistry.getShader(this.getShaderName(shader), shaderType);
    }
    
    public ResourceLocation getShaderName(final ItemStack stack) {
        return getShaderType(stack);
    }
    
    public ITextComponent func_200295_i(final ItemStack stack) {
        final ResourceLocation rawShaderName = this.getShaderName(stack);
        final String unlocalizedShaderName = "item." + rawShaderName.func_110624_b() + ".shader.name." + rawShaderName.func_110623_a().replace(' ', '_').toLowerCase(Locale.ROOT);
        final String localizedShaderName = new TranslationTextComponent(unlocalizedShaderName).getString();
        if (unlocalizedShaderName.equals(localizedShaderName)) {
            return (ITextComponent)new TranslationTextComponent(this.func_77667_c(stack), new Object[] { rawShaderName.func_110623_a() }).func_240702_b_(" *TRANSLATION FAILURE*").func_240699_a_(TextFormatting.DARK_RED);
        }
        return (ITextComponent)new TranslationTextComponent(this.func_77667_c(stack), new Object[] { localizedShaderName });
    }
    
    public ActionResultType func_195939_a(final ItemUseContext ctx) {
        final World world = ctx.func_195991_k();
        final BlockPos pos = ctx.func_195995_a();
        final ResourceLocation name = this.getShaderName(ctx.func_195996_i());
        if (ShaderRegistry.shaderRegistry.containsKey(name)) {
            final BlockState blockState = world.func_180495_p(pos);
            TileEntity tile = world.func_175625_s(pos);
            if (tile instanceof BannerTileEntity) {
                final ShaderCase sCase = ShaderRegistry.shaderRegistry.get(name).getCase(new ResourceLocation("immersiveengineering", "banner"));
                if (sCase != null) {
                    final boolean wall = blockState.func_177230_c() instanceof WallBannerBlock;
                    if (wall) {
                        world.func_175656_a(pos, (BlockState)IEBlocks.Cloth.shaderBannerWall.func_176223_P().func_206870_a(ShaderBannerWallBlock.FACING, blockState.func_177229_b((Property)WallBannerBlock.field_196290_a)));
                    }
                    else {
                        world.func_175656_a(pos, (BlockState)IEBlocks.Cloth.shaderBanner.func_176223_P().func_206870_a((Property)ShaderBannerStandingBlock.ROTATION, blockState.func_177229_b((Property)BannerBlock.field_176448_b)));
                    }
                    tile = world.func_175625_s(pos);
                    if (tile instanceof ShaderBannerTileEntity) {
                        ((ShaderBannerTileEntity)tile).shader.setShaderItem(ItemHandlerHelper.copyStackWithSize(ctx.func_195996_i(), 1));
                        tile.func_70296_d();
                        return ActionResultType.SUCCESS;
                    }
                }
            }
            else if (tile instanceof ShaderBannerTileEntity) {
                ((ShaderBannerTileEntity)tile).shader.setShaderItem(ItemHandlerHelper.copyStackWithSize(ctx.func_195996_i(), 1));
                tile.func_70296_d();
                return ActionResultType.SUCCESS;
            }
        }
        return ActionResultType.FAIL;
    }
    
    @OnlyIn(Dist.CLIENT)
    public void func_77624_a(final ItemStack stack, @Nullable final World world, final List<ITextComponent> list, final ITooltipFlag flag) {
        list.add((ITextComponent)new TranslationTextComponent("desc.immersiveengineering.info.shader.level").func_230529_a_((ITextComponent)TextUtils.applyFormat((ITextComponent)new TranslationTextComponent("desc.immersiveengineering.info.shader.rarity." + this.func_77613_e(stack).name().toLowerCase(Locale.US)), new TextFormatting[] { this.func_77613_e(stack).field_77937_e })));
        if (ShaderRegistry.shaderRegistry.containsKey(this.getShaderName(stack))) {
            if (!Screen.func_231173_s_()) {
                list.add((ITextComponent)new TranslationTextComponent("desc.immersiveengineering.info.shader.applyTo").func_240702_b_(" ").func_230529_a_((ITextComponent)new TranslationTextComponent("desc.immersiveengineering.info.holdShift")));
            }
            else {
                list.add((ITextComponent)new TranslationTextComponent("desc.immersiveengineering.info.shader.applyTo"));
                for (final ShaderCase sCase : ShaderRegistry.shaderRegistry.get(this.getShaderName(stack)).getCases()) {
                    if (!(sCase instanceof ShaderCaseItem)) {
                        list.add((ITextComponent)TextUtils.applyFormat((ITextComponent)new TranslationTextComponent("desc.immersiveengineering.info.shader." + sCase.getShaderType()), new TextFormatting[] { TextFormatting.DARK_GRAY }));
                    }
                }
            }
        }
    }
    
    public Rarity func_77613_e(final ItemStack stack) {
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
    
    public void func_150895_a(final ItemGroup group, final NonNullList<ItemStack> items) {
        if (group == TFItems.creativeTab) {
            for (final ShaderRegistry.ShaderRegistryEntry entry : IEShaderRegister.getAllTwilightShaders()) {
                final ItemStack stack = new ItemStack((IItemProvider)this);
                ItemNBTHelper.putString(stack, "shader_name", entry.getName().toString());
                items.add((Object)stack);
            }
        }
    }
}
