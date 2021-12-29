// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.util.text.ITextComponent;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.world.IWorldReader;
import twilightforest.util.TFDamageSources;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraft.item.ShearsItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.block.BlockState;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;

public class CompressedBlock extends Block
{
    public CompressedBlock(final AbstractBlock.Properties props) {
        super(props);
    }
    
    @Deprecated
    public float func_220080_a(final BlockState state, final IBlockReader worldIn, final BlockPos pos) {
        if (this == TFBlocks.fiery_block.get()) {
            return 1.0f;
        }
        return super.func_220080_a(state, worldIn, pos);
    }
    
    @Deprecated
    public float func_180647_a(final BlockState state, final PlayerEntity player, final IBlockReader worldIn, final BlockPos pos) {
        return (state.func_177230_c() == TFBlocks.arctic_fur_block.get() && player.func_184614_ca().func_77973_b() instanceof ShearsItem) ? 0.2f : super.func_180647_a(state, player, worldIn, pos);
    }
    
    public void func_176199_a(final World worldIn, final BlockPos pos, final Entity entityIn) {
        if (!entityIn.func_230279_az_() && entityIn instanceof LivingEntity && !EnchantmentHelper.func_189869_j((LivingEntity)entityIn) && this == TFBlocks.fiery_block.get()) {
            entityIn.func_70097_a(TFDamageSources.FIERY, 1.0f);
        }
        super.func_176199_a(worldIn, pos, entityIn);
    }
    
    public void func_180658_a(final World worldIn, final BlockPos pos, final Entity entityIn, final float fallDistance) {
        if (this == TFBlocks.steeleaf_block.get()) {
            entityIn.func_225503_b_(fallDistance, 0.75f);
        }
        else if (this == TFBlocks.arctic_fur_block.get()) {
            entityIn.func_225503_b_(fallDistance, 0.1f);
        }
    }
    
    public boolean isFireSource(final BlockState state, final IWorldReader world, final BlockPos pos, final Direction side) {
        return this == TFBlocks.fiery_block.get();
    }
    
    public boolean isStickyBlock(final BlockState state) {
        return this == TFBlocks.carminite_block.get();
    }
    
    public void func_190948_a(final ItemStack stack, @Nullable final IBlockReader worldIn, final List<ITextComponent> tooltip, final ITooltipFlag flagIn) {
        if (this == TFBlocks.steeleaf_block.get()) {
            tooltip.add((ITextComponent)new TranslationTextComponent("block.steeleaf.tooltip"));
        }
        else if (this == TFBlocks.arctic_fur_block.get()) {
            tooltip.add((ITextComponent)new TranslationTextComponent("block.arctic.tooltip"));
        }
    }
}
