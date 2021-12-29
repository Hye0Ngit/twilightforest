// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class ItemBlockTFMeta extends ItemBlock
{
    private boolean appendNumber;
    
    public ItemBlockTFMeta(final Block block) {
        super(block);
        this.func_77627_a(this.appendNumber = true);
    }
    
    public ItemBlockTFMeta setAppend(final boolean doAppend) {
        this.appendNumber = doAppend;
        return this;
    }
    
    public int func_77647_b(final int i) {
        return i;
    }
    
    public String func_77667_c(final ItemStack itemstack) {
        if (this.appendNumber) {
            return super.func_77658_a() + "." + itemstack.func_77960_j();
        }
        return super.func_77658_a();
    }
    
    @SideOnly(Side.CLIENT)
    public void func_77624_a(final ItemStack stack, @Nullable final World world, final List<String> tooltip, final ITooltipFlag flags) {
        super.func_77624_a(stack, world, (List)tooltip, flags);
        if (stack.func_82833_r().contains("[WIP]")) {
            tooltip.add(I18n.func_135052_a("twilightforest.misc.wip0", new Object[0]));
            tooltip.add(I18n.func_135052_a("twilightforest.misc.wip1", new Object[0]));
        }
        if (stack.func_82833_r().contains("[NYI]")) {
            tooltip.add(I18n.func_135052_a("twilightforest.misc.nyi", new Object[0]));
        }
    }
}
