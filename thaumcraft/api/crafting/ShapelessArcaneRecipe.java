// 
// Decompiled by Procyon v0.6-prerelease
// 

package thaumcraft.api.crafting;

import java.util.Iterator;
import java.util.Collection;
import thaumcraft.api.ThaumcraftApiHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.inventory.IInventory;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.Item;
import net.minecraft.block.Block;
import thaumcraft.api.aspects.AspectList;
import java.util.ArrayList;
import net.minecraft.item.ItemStack;

public class ShapelessArcaneRecipe implements IArcaneRecipe
{
    private ItemStack output;
    private ArrayList input;
    public AspectList aspects;
    public String research;
    
    public ShapelessArcaneRecipe(final String research, final Block result, final AspectList aspects, final Object... recipe) {
        this(research, new ItemStack(result), aspects, recipe);
    }
    
    public ShapelessArcaneRecipe(final String research, final Item result, final AspectList aspects, final Object... recipe) {
        this(research, new ItemStack(result), aspects, recipe);
    }
    
    public ShapelessArcaneRecipe(final String research, final ItemStack result, final AspectList aspects, final Object... recipe) {
        this.output = null;
        this.input = new ArrayList();
        this.aspects = null;
        this.output = result.func_77946_l();
        this.research = research;
        this.aspects = aspects;
        for (final Object in : recipe) {
            if (in instanceof ItemStack) {
                this.input.add(((ItemStack)in).func_77946_l());
            }
            else if (in instanceof Item) {
                this.input.add(new ItemStack((Item)in));
            }
            else if (in instanceof Block) {
                this.input.add(new ItemStack((Block)in));
            }
            else {
                if (!(in instanceof String)) {
                    String ret = "Invalid shapeless ore recipe: ";
                    for (final Object tmp : recipe) {
                        ret = ret + tmp + ", ";
                    }
                    ret += this.output;
                    throw new RuntimeException(ret);
                }
                this.input.add(OreDictionary.getOres((String)in));
            }
        }
    }
    
    @Override
    public int getRecipeSize() {
        return this.input.size();
    }
    
    @Override
    public ItemStack getRecipeOutput() {
        return this.output;
    }
    
    @Override
    public ItemStack getCraftingResult(final IInventory var1) {
        return this.output.func_77946_l();
    }
    
    @Override
    public boolean matches(final IInventory var1, final World world, final EntityPlayer player) {
        if (this.research.length() > 0 && !ThaumcraftApiHelper.isResearchComplete(player.func_70005_c_(), this.research)) {
            return false;
        }
        final ArrayList required = new ArrayList(this.input);
        for (int x = 0; x < 9; ++x) {
            final ItemStack slot = var1.func_70301_a(x);
            if (slot != null) {
                boolean inRecipe = false;
                final Iterator req = required.iterator();
                while (req.hasNext()) {
                    boolean match = false;
                    final Object next = req.next();
                    if (next instanceof ItemStack) {
                        match = this.checkItemEquals((ItemStack)next, slot);
                    }
                    else if (next instanceof ArrayList) {
                        for (final ItemStack item : (ArrayList)next) {
                            match = (match || this.checkItemEquals(item, slot));
                        }
                    }
                    if (match) {
                        inRecipe = true;
                        required.remove(next);
                        break;
                    }
                }
                if (!inRecipe) {
                    return false;
                }
            }
        }
        return required.isEmpty();
    }
    
    private boolean checkItemEquals(final ItemStack target, final ItemStack input) {
        return (input != null || target == null) && (input == null || target != null) && target.func_77973_b() == input.func_77973_b() && (!target.func_77942_o() || ThaumcraftApiHelper.areItemStackTagsEqualForCrafting(input, target)) && (target.func_77960_j() == 32767 || target.func_77960_j() == input.func_77960_j());
    }
    
    public ArrayList getInput() {
        return this.input;
    }
    
    @Override
    public AspectList getAspects() {
        return this.aspects;
    }
    
    @Override
    public AspectList getAspects(final IInventory inv) {
        return this.aspects;
    }
    
    @Override
    public String getResearch() {
        return this.research;
    }
}
