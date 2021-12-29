// 
// Decompiled by Procyon v0.6-prerelease
// 

package thaumcraft.api.crafting;

import thaumcraft.api.aspects.AspectList;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.inventory.IInventory;

public interface IArcaneRecipe
{
    boolean matches(final IInventory p0, final World p1, final EntityPlayer p2);
    
    ItemStack getCraftingResult(final IInventory p0);
    
    int getRecipeSize();
    
    ItemStack getRecipeOutput();
    
    AspectList getAspects();
    
    AspectList getAspects(final IInventory p0);
    
    String getResearch();
}
