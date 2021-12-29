// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraftforge.common.ToolActions;
import net.minecraftforge.common.ToolAction;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import twilightforest.data.ItemTagGenerator;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.network.chat.Component;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ShieldItem;

public class KnightmetalShieldItem extends ShieldItem
{
    public KnightmetalShieldItem(final Item.Properties props) {
        super(props);
    }
    
    @OnlyIn(Dist.CLIENT)
    public void m_7373_(final ItemStack stack, @Nullable final Level worldIn, final List<Component> tooltip, final TooltipFlag flagIn) {
    }
    
    public boolean m_6832_(final ItemStack toRepair, final ItemStack repair) {
        return repair.m_150922_((Tag)ItemTagGenerator.KNIGHTMETAL_INGOTS) || (!repair.m_150922_((Tag)ItemTags.f_13168_) && super.m_6832_(toRepair, repair));
    }
    
    public boolean canPerformAction(final ItemStack stack, final ToolAction toolAction) {
        return ToolActions.DEFAULT_SHIELD_ACTIONS.contains(toolAction) || super.canPerformAction(stack, toolAction);
    }
}
