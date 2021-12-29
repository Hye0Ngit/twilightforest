// 
// Decompiled by Procyon v0.6-prerelease
// 

package thaumcraft.api;

import net.minecraft.block.Block;
import cpw.mods.fml.common.FMLLog;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemApi
{
    public static ItemStack getItem(final String itemString, final int meta) {
        ItemStack item = null;
        try {
            final String itemClass = "thaumcraft.common.config.ConfigItems";
            final Object obj = Class.forName(itemClass).getField(itemString).get(null);
            if (obj instanceof Item) {
                item = new ItemStack((Item)obj, 1, meta);
            }
            else if (obj instanceof ItemStack) {
                item = (ItemStack)obj;
            }
        }
        catch (Exception ex) {
            FMLLog.warning("[Thaumcraft] Could not retrieve item identified by: " + itemString, new Object[0]);
        }
        return item;
    }
    
    public static ItemStack getBlock(final String itemString, final int meta) {
        ItemStack item = null;
        try {
            final String itemClass = "thaumcraft.common.config.ConfigBlocks";
            final Object obj = Class.forName(itemClass).getField(itemString).get(null);
            if (obj instanceof Block) {
                item = new ItemStack((Block)obj, 1, meta);
            }
            else if (obj instanceof ItemStack) {
                item = (ItemStack)obj;
            }
        }
        catch (Exception ex) {
            FMLLog.warning("[Thaumcraft] Could not retrieve block identified by: " + itemString, new Object[0]);
        }
        return item;
    }
}
