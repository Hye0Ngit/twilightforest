// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

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

public class KnightmetalPickItem extends PickaxeItem
{
    protected KnightmetalPickItem(final Tier material, final Item.Properties props) {
        super(material, 1, -2.8f, props);
    }
    
    @OnlyIn(Dist.CLIENT)
    public void m_7373_(final ItemStack stack, @Nullable final Level world, final List<Component> list, final TooltipFlag flags) {
        super.m_7373_(stack, world, (List)list, flags);
        list.add((Component)new TranslatableComponent(this.m_5524_() + ".tooltip").m_130940_(ChatFormatting.GRAY));
    }
}
