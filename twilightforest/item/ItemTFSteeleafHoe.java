// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import twilightforest.client.ModelRegisterCallback;
import net.minecraft.item.ItemHoe;

public class ItemTFSteeleafHoe extends ItemHoe implements ModelRegisterCallback
{
    public ItemTFSteeleafHoe(final Item.ToolMaterial material) {
        super(material);
        this.func_77637_a((CreativeTabs)TFItems.creativeTab);
    }
}
