// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.util.text.translation.I18n;
import java.util.Locale;
import twilightforest.enums.StructureVariant;
import net.minecraft.item.ItemStack;
import net.minecraft.block.Block;

public class ItemTFMiniatureStructure extends ItemBlockTFMeta
{
    public ItemTFMiniatureStructure(final Block block) {
        super(block);
        this.setAppend(false);
    }
    
    public String func_77653_i(final ItemStack stack) {
        return I18n.func_74837_a(this.func_77667_c(stack), new Object[] { I18n.func_74838_a("structure." + StructureVariant.values()[stack.func_77960_j() % StructureVariant.values().length].func_176610_l().toLowerCase(Locale.ROOT) + ".name") });
    }
}
