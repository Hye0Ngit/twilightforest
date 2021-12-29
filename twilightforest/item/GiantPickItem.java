// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import twilightforest.block.GiantBlock;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.network.chat.Component;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.PickaxeItem;

public class GiantPickItem extends PickaxeItem
{
    protected GiantPickItem(final Tier material, final Item.Properties props) {
        super(material, 8, -3.5f, props);
    }
    
    @OnlyIn(Dist.CLIENT)
    public void m_7373_(final ItemStack stack, @Nullable final Level world, final List<Component> tooltip, final TooltipFlag flags) {
        super.m_7373_(stack, world, (List)tooltip, flags);
        tooltip.add((Component)new TranslatableComponent(this.m_5524_() + ".tooltip").m_130940_(ChatFormatting.GRAY));
    }
    
    public float m_8102_(final ItemStack stack, final BlockState state) {
        float destroySpeed = super.m_8102_(stack, state);
        destroySpeed *= ((state.m_60734_() == TFBlocks.GIANT_OBSIDIAN.get()) ? 64.0f : 1.0f);
        return (state.m_60734_() instanceof GiantBlock) ? (destroySpeed * 64.0f) : destroySpeed;
    }
}
