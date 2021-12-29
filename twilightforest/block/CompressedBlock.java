// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.network.chat.Component;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.damagesource.DamageSource;
import twilightforest.util.TFDamageSources;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ShearsItem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

public class CompressedBlock extends Block
{
    public CompressedBlock(final BlockBehaviour.Properties props) {
        super(props);
    }
    
    @Deprecated
    public float m_7749_(final BlockState state, final BlockGetter worldIn, final BlockPos pos) {
        if (this == TFBlocks.FIERY_BLOCK.get()) {
            return 1.0f;
        }
        return super.m_7749_(state, worldIn, pos);
    }
    
    @Deprecated
    public float m_5880_(final BlockState state, final Player player, final BlockGetter worldIn, final BlockPos pos) {
        return (state.m_60734_() == TFBlocks.ARCTIC_FUR_BLOCK.get() && player.m_21205_().m_41720_() instanceof ShearsItem) ? 0.2f : super.m_5880_(state, player, worldIn, pos);
    }
    
    public void m_141947_(final Level worldIn, final BlockPos pos, final BlockState state, final Entity entityIn) {
        if (!entityIn.m_5825_() && entityIn instanceof LivingEntity && !EnchantmentHelper.m_44938_((LivingEntity)entityIn) && this == TFBlocks.FIERY_BLOCK.get()) {
            entityIn.m_6469_(TFDamageSources.FIERY, 1.0f);
        }
        super.m_141947_(worldIn, pos, state, entityIn);
    }
    
    public void m_142072_(final Level worldIn, final BlockState state, final BlockPos pos, final Entity entityIn, final float fallDistance) {
        if (this == TFBlocks.STEELEAF_BLOCK.get()) {
            entityIn.m_142535_(fallDistance, 0.75f, DamageSource.f_19315_);
        }
        else if (this == TFBlocks.ARCTIC_FUR_BLOCK.get()) {
            entityIn.m_142535_(fallDistance, 0.1f, DamageSource.f_19315_);
        }
    }
    
    public boolean isFireSource(final BlockState state, final LevelReader world, final BlockPos pos, final Direction side) {
        return this == TFBlocks.FIERY_BLOCK.get();
    }
    
    public boolean isStickyBlock(final BlockState state) {
        return this == TFBlocks.CARMINITE_BLOCK.get();
    }
    
    public void m_5871_(final ItemStack stack, @Nullable final BlockGetter worldIn, final List<Component> tooltip, final TooltipFlag flagIn) {
        if (this == TFBlocks.STEELEAF_BLOCK.get()) {
            tooltip.add((Component)new TranslatableComponent("block.steeleaf.tooltip").m_130940_(ChatFormatting.GRAY));
        }
        else if (this == TFBlocks.ARCTIC_FUR_BLOCK.get()) {
            tooltip.add((Component)new TranslatableComponent("block.arctic.tooltip").m_130940_(ChatFormatting.GRAY));
        }
    }
}
