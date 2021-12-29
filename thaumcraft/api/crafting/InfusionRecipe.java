// 
// Decompiled by Procyon v0.6-prerelease
// 

package thaumcraft.api.crafting;

import net.minecraftforge.oredict.OreDictionary;
import java.util.Iterator;
import thaumcraft.api.ThaumcraftApiHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import java.util.ArrayList;
import net.minecraft.item.ItemStack;
import thaumcraft.api.aspects.AspectList;

public class InfusionRecipe
{
    protected AspectList aspects;
    protected String research;
    private ItemStack[] components;
    private ItemStack recipeInput;
    protected Object recipeOutput;
    protected int instability;
    
    public InfusionRecipe(final String research, final Object output, final int inst, final AspectList aspects2, final ItemStack input, final ItemStack[] recipe) {
        this.research = research;
        this.recipeOutput = output;
        this.recipeInput = input;
        this.aspects = aspects2;
        this.components = recipe;
        this.instability = inst;
    }
    
    public boolean matches(final ArrayList<ItemStack> input, final ItemStack central, final World world, final EntityPlayer player) {
        if (this.getRecipeInput() == null) {
            return false;
        }
        if (this.research.length() > 0 && !ThaumcraftApiHelper.isResearchComplete(player.func_70005_c_(), this.research)) {
            return false;
        }
        ItemStack i2 = central.func_77946_l();
        if (this.getRecipeInput().func_77960_j() == 32767) {
            i2.func_77964_b(32767);
        }
        if (!areItemStacksEqual(i2, this.getRecipeInput(), true)) {
            return false;
        }
        final ArrayList<ItemStack> ii = new ArrayList<ItemStack>();
        for (final ItemStack is : input) {
            ii.add(is.func_77946_l());
        }
        for (final ItemStack comp : this.getComponents()) {
            boolean b = false;
            for (int a = 0; a < ii.size(); ++a) {
                i2 = ii.get(a).func_77946_l();
                if (comp.func_77960_j() == 32767) {
                    i2.func_77964_b(32767);
                }
                if (areItemStacksEqual(i2, comp, true)) {
                    ii.remove(a);
                    b = true;
                    break;
                }
            }
            if (!b) {
                return false;
            }
        }
        return ii.size() == 0;
    }
    
    public static boolean areItemStacksEqual(final ItemStack stack0, final ItemStack stack1, final boolean fuzzy) {
        if (stack0 == null && stack1 != null) {
            return false;
        }
        if (stack0 != null && stack1 == null) {
            return false;
        }
        if (stack0 == null && stack1 == null) {
            return true;
        }
        final boolean t1 = ThaumcraftApiHelper.areItemStackTagsEqualForCrafting(stack0, stack1);
        if (!t1) {
            return false;
        }
        if (fuzzy) {
            final Integer od = OreDictionary.getOreID(stack0);
            if (od != -1) {
                final ItemStack[] ores = OreDictionary.getOres(od).toArray(new ItemStack[0]);
                if (ThaumcraftApiHelper.containsMatch(false, new ItemStack[] { stack1 }, ores)) {
                    return true;
                }
            }
        }
        final boolean damage = stack0.func_77960_j() == stack1.func_77960_j() || stack1.func_77960_j() == 32767;
        return stack0.func_77973_b() == stack1.func_77973_b() && damage && stack0.field_77994_a <= stack0.func_77976_d();
    }
    
    public Object getRecipeOutput() {
        return this.getRecipeOutput(this.getRecipeInput());
    }
    
    public AspectList getAspects() {
        return this.getAspects(this.getRecipeInput());
    }
    
    public int getInstability() {
        return this.getInstability(this.getRecipeInput());
    }
    
    public String getResearch() {
        return this.research;
    }
    
    public ItemStack getRecipeInput() {
        return this.recipeInput;
    }
    
    public ItemStack[] getComponents() {
        return this.components;
    }
    
    public Object getRecipeOutput(final ItemStack input) {
        return this.recipeOutput;
    }
    
    public AspectList getAspects(final ItemStack input) {
        return this.aspects;
    }
    
    public int getInstability(final ItemStack input) {
        return this.instability;
    }
}
