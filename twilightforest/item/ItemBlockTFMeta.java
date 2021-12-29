// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IIcon;
import net.minecraft.item.ItemStack;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class ItemBlockTFMeta extends ItemBlock
{
    private final Block myBlock;
    
    public ItemBlockTFMeta(final Block block) {
        super(block);
        this.func_77627_a(true);
        this.func_77656_e(0);
        this.myBlock = block;
    }
    
    public int func_77647_b(final int i) {
        return i;
    }
    
    public String func_77667_c(final ItemStack itemstack) {
        final int meta = itemstack.func_77960_j();
        return super.func_77658_a() + "." + meta;
    }
    
    public IIcon func_77617_a(final int par1) {
        return this.myBlock.func_149691_a(2, par1);
    }
    
    @SideOnly(Side.CLIENT)
    public void func_77624_a(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final List par3List, final boolean par4) {
        super.func_77624_a(par1ItemStack, par2EntityPlayer, par3List, par4);
        if (par1ItemStack.func_82833_r().contains("[WIP]")) {
            par3List.add("This block is a work in progress");
            par3List.add("and may have bugs or unintended");
            par3List.add("effects that may damage your world.");
            par3List.add("Use with caution.");
        }
        if (par1ItemStack.func_82833_r().contains("[NYI]")) {
            par3List.add("This block has effects");
            par3List.add("that are not yet implemented.");
        }
    }
}
