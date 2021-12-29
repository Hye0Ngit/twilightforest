// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.ArrayList;
import cpw.mods.fml.common.ObfuscationReflectionHelper;
import net.minecraft.item.Item;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemPickaxe;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import java.util.Iterator;
import java.util.Map;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.world.World;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Container;

public class ContainerTFUncrafting extends Container
{
    public InventoryTFGoblinUncrafting uncraftingMatrix;
    public InventoryCrafting assemblyMatrix;
    public InventoryCrafting combineMatrix;
    public IInventory tinkerInput;
    public IInventory tinkerResult;
    private World worldObj;
    private int posX;
    private int posY;
    private int posZ;
    
    public ContainerTFUncrafting(final InventoryPlayer inventory, final World world, final int x, final int y, final int z) {
        this.uncraftingMatrix = new InventoryTFGoblinUncrafting(this);
        this.assemblyMatrix = new InventoryCrafting((Container)this, 3, 3);
        this.combineMatrix = new InventoryCrafting((Container)this, 3, 3);
        this.tinkerInput = (IInventory)new InventoryTFGoblinInput(this);
        this.tinkerResult = (IInventory)new InventoryCraftResult();
        this.worldObj = world;
        this.posX = x;
        this.posY = y;
        this.posZ = z;
        this.func_75146_a(new Slot(this.tinkerInput, 0, 13, 35));
        this.func_75146_a((Slot)new SlotTFGoblinCraftResult(inventory.field_70458_d, this.tinkerInput, (IInventory)this.uncraftingMatrix, (IInventory)this.assemblyMatrix, this.tinkerResult, 0, 147, 35));
        for (int invX = 0; invX < 3; ++invX) {
            for (int invY = 0; invY < 3; ++invY) {
                this.func_75146_a((Slot)new SlotTFGoblinUncrafting(inventory.field_70458_d, this.tinkerInput, this.uncraftingMatrix, (IInventory)this.assemblyMatrix, invY + invX * 3, 300000 + invY * 18, 17 + invX * 18));
            }
        }
        for (int invX = 0; invX < 3; ++invX) {
            for (int invY = 0; invY < 3; ++invY) {
                this.func_75146_a((Slot)new SlotTFGoblinAssembly(inventory.field_70458_d, this.tinkerInput, (IInventory)this.assemblyMatrix, (IInventory)this.uncraftingMatrix, invY + invX * 3, 62 + invY * 18, 17 + invX * 18));
            }
        }
        for (int invX = 0; invX < 3; ++invX) {
            for (int invY = 0; invY < 9; ++invY) {
                this.func_75146_a(new Slot((IInventory)inventory, invY + invX * 9 + 9, 8 + invY * 18, 84 + invX * 18));
            }
        }
        for (int invX = 0; invX < 9; ++invX) {
            this.func_75146_a(new Slot((IInventory)inventory, invX, 8 + invX * 18, 142));
        }
        this.func_75130_a((IInventory)this.assemblyMatrix);
    }
    
    public void func_75130_a(final IInventory par1IInventory) {
        if (par1IInventory == this.tinkerInput) {
            final ItemStack inputStack = this.tinkerInput.func_70301_a(0);
            final IRecipe recipe = this.getRecipeFor(inputStack);
            if (recipe != null) {
                final int recipeWidth = this.getRecipeWidth(recipe);
                final int recipeHeight = this.getRecipeHeight(recipe);
                final ItemStack[] recipeItems = this.getRecipeItems(recipe);
                for (int i = 0; i < this.uncraftingMatrix.func_70302_i_(); ++i) {
                    this.uncraftingMatrix.func_70299_a(i, null);
                }
                for (int invY = 0; invY < recipeHeight; ++invY) {
                    for (int invX = 0; invX < recipeWidth; ++invX) {
                        final ItemStack ingredient = ItemStack.func_77944_b(recipeItems[invX + invY * recipeWidth]);
                        if (ingredient != null && ingredient.field_77994_a > 1) {
                            ingredient.field_77994_a = 1;
                        }
                        if (ingredient != null && (ingredient.func_77952_i() == -1 || ingredient.func_77952_i() == 32767)) {
                            ingredient.func_77964_b(0);
                        }
                        this.uncraftingMatrix.func_70299_a(invX + invY * 3, ingredient);
                    }
                }
                if (inputStack.func_77951_h()) {
                    for (int damagedParts = this.countDamagedParts(inputStack), j = 0; j < 9 && damagedParts > 0; ++j) {
                        if (this.isDamageableComponent(this.uncraftingMatrix.func_70301_a(j))) {
                            this.uncraftingMatrix.func_70301_a(j).field_77994_a = 0;
                            --damagedParts;
                        }
                    }
                }
                for (int i = 0; i < 9; ++i) {
                    final ItemStack ingredient2 = this.uncraftingMatrix.func_70301_a(i);
                    if (this.isIngredientProblematic(ingredient2)) {
                        ingredient2.field_77994_a = 0;
                    }
                }
                this.uncraftingMatrix.numberOfInputItems = recipe.func_77571_b().field_77994_a;
                this.uncraftingMatrix.uncraftingCost = this.calculateUncraftingCost();
                this.uncraftingMatrix.recraftingCost = 0;
            }
            else {
                for (int k = 0; k < 9; ++k) {
                    this.uncraftingMatrix.func_70299_a(k, null);
                }
                this.uncraftingMatrix.numberOfInputItems = 0;
                this.uncraftingMatrix.uncraftingCost = 0;
            }
        }
        if (par1IInventory == this.assemblyMatrix || par1IInventory == this.tinkerInput) {
            if (this.isMatrixEmpty(this.tinkerInput)) {
                this.tinkerResult.func_70299_a(0, CraftingManager.func_77594_a().func_82787_a(this.assemblyMatrix, this.worldObj));
                this.uncraftingMatrix.recraftingCost = 0;
            }
            else {
                this.tinkerResult.func_70299_a(0, (ItemStack)null);
                this.uncraftingMatrix.uncraftingCost = this.calculateUncraftingCost();
                this.uncraftingMatrix.recraftingCost = 0;
            }
        }
        if (par1IInventory != this.combineMatrix && !this.isMatrixEmpty((IInventory)this.uncraftingMatrix) && !this.isMatrixEmpty((IInventory)this.assemblyMatrix)) {
            for (int l = 0; l < 9; ++l) {
                if (this.assemblyMatrix.func_70301_a(l) != null) {
                    this.combineMatrix.func_70299_a(l, this.assemblyMatrix.func_70301_a(l));
                }
                else if (this.uncraftingMatrix.func_70301_a(l) != null && this.uncraftingMatrix.func_70301_a(l).field_77994_a > 0) {
                    this.combineMatrix.func_70299_a(l, this.uncraftingMatrix.func_70301_a(l));
                }
                else {
                    this.combineMatrix.func_70299_a(l, (ItemStack)null);
                }
            }
            final ItemStack result = CraftingManager.func_77594_a().func_82787_a(this.combineMatrix, this.worldObj);
            final ItemStack input = this.tinkerInput.func_70301_a(0);
            if (result != null && this.isValidMatchForInput(input, result)) {
                NBTTagCompound inputTags = input.func_77978_p();
                if (inputTags != null) {
                    inputTags = (NBTTagCompound)inputTags.func_74737_b();
                }
                Map resultInnateEnchantments = null;
                if (result.func_77948_v()) {
                    resultInnateEnchantments = EnchantmentHelper.func_82781_a(result);
                }
                Map inputEnchantments = null;
                if (input.func_77948_v()) {
                    inputEnchantments = EnchantmentHelper.func_82781_a(input);
                    for (final Object key : inputEnchantments.keySet()) {
                        final int enchID = (int)key;
                        final int level = inputEnchantments.get(key);
                        final Enchantment ench = Enchantment.field_77331_b[enchID];
                        if (!ench.func_92089_a(result)) {
                            inputEnchantments.remove(key);
                        }
                    }
                }
                if (inputTags != null) {
                    inputTags.func_82580_o("ench");
                    result.func_77982_d((NBTTagCompound)inputTags.func_74737_b());
                    if (inputEnchantments != null) {
                        EnchantmentHelper.func_82782_a(inputEnchantments, result);
                    }
                }
                this.tinkerResult.func_70299_a(0, result);
                this.uncraftingMatrix.uncraftingCost = 0;
                this.uncraftingMatrix.recraftingCost = this.calculateRecraftingCost();
                if (this.uncraftingMatrix.recraftingCost > 0 && !result.func_82837_s()) {
                    result.func_82841_c(input.func_82838_A() + 2);
                }
                if (resultInnateEnchantments != null && resultInnateEnchantments.size() > 0) {
                    for (final Object key : resultInnateEnchantments.keySet()) {
                        final int enchID = (int)key;
                        int level = resultInnateEnchantments.get(key);
                        final Enchantment ench = Enchantment.field_77331_b[enchID];
                        if (EnchantmentHelper.func_77506_a(enchID, result) > level) {
                            level = EnchantmentHelper.func_77506_a(enchID, result);
                        }
                        if (EnchantmentHelper.func_77506_a(enchID, result) < level) {
                            result.func_77966_a(ench, level);
                        }
                    }
                }
            }
        }
    }
    
    protected boolean isIngredientProblematic(final ItemStack ingredient) {
        return ingredient != null && (ingredient.func_77973_b().func_77634_r() || ingredient.func_77977_a().contains("itemMatter"));
    }
    
    public IRecipe getRecipeFor(final ItemStack inputStack) {
        if (inputStack != null) {
            for (final IRecipe recipe : CraftingManager.func_77594_a().func_77592_b()) {
                if ((recipe instanceof ShapedRecipes || recipe instanceof ShapedOreRecipe) && recipe.func_77571_b().field_77993_c == inputStack.field_77993_c && inputStack.field_77994_a >= recipe.func_77571_b().field_77994_a && (!recipe.func_77571_b().func_77981_g() || recipe.func_77571_b().func_77960_j() == inputStack.func_77960_j())) {
                    return recipe;
                }
            }
        }
        return null;
    }
    
    public boolean isValidMatchForInput(final ItemStack inputStack, final ItemStack resultStack) {
        if (inputStack.func_77973_b() instanceof ItemPickaxe && resultStack.func_77973_b() instanceof ItemPickaxe) {
            return true;
        }
        if (inputStack.func_77973_b() instanceof ItemAxe && resultStack.func_77973_b() instanceof ItemAxe) {
            return true;
        }
        if (inputStack.func_77973_b() instanceof ItemSpade && resultStack.func_77973_b() instanceof ItemSpade) {
            return true;
        }
        if (inputStack.func_77973_b() instanceof ItemHoe && resultStack.func_77973_b() instanceof ItemHoe) {
            return true;
        }
        if (inputStack.func_77973_b() instanceof ItemSword && resultStack.func_77973_b() instanceof ItemSword) {
            return true;
        }
        if (inputStack.func_77973_b() instanceof ItemBow && resultStack.func_77973_b() instanceof ItemBow) {
            return true;
        }
        if (inputStack.func_77973_b() instanceof ItemArmor && resultStack.func_77973_b() instanceof ItemArmor) {
            final ItemArmor inputArmor = (ItemArmor)inputStack.func_77973_b();
            final ItemArmor resultArmor = (ItemArmor)resultStack.func_77973_b();
            return inputArmor.field_77881_a == resultArmor.field_77881_a;
        }
        return false;
    }
    
    public int getUncraftingCost() {
        return this.uncraftingMatrix.uncraftingCost;
    }
    
    public int getRecraftingCost() {
        return this.uncraftingMatrix.recraftingCost;
    }
    
    public int calculateUncraftingCost() {
        if (!this.isMatrixEmpty((IInventory)this.assemblyMatrix)) {
            return 0;
        }
        return this.countDamageableParts((IInventory)this.uncraftingMatrix);
    }
    
    public int calculateRecraftingCost() {
        if (this.tinkerInput.func_70301_a(0) == null || !this.tinkerInput.func_70301_a(0).func_77948_v() || this.tinkerResult.func_70301_a(0) == null) {
            return 0;
        }
        final ItemStack input = this.tinkerInput.func_70301_a(0);
        final ItemStack output = this.tinkerResult.func_70301_a(0);
        int cost = 0;
        cost += input.func_82838_A();
        final int enchantCost = this.countTotalEnchantmentCost(input);
        cost += enchantCost;
        final int damagedCost = (1 + this.countDamagedParts(input)) * EnchantmentHelper.func_82781_a(output).size();
        cost += damagedCost;
        final int enchantabilityDifference = input.func_77973_b().func_77619_b() - output.func_77973_b().func_77619_b();
        cost += enchantabilityDifference;
        cost = Math.max(1, cost);
        return cost;
    }
    
    public int countHighestEnchantmentCost(final ItemStack itemStack) {
        int count = 0;
        for (final Enchantment ench : Enchantment.field_77331_b) {
            if (ench != null) {
                final int level = EnchantmentHelper.func_77506_a(ench.field_77352_x, itemStack);
                if (level > count) {
                    count += this.getWeightModifier(ench) * level;
                }
            }
        }
        return count;
    }
    
    public int countTotalEnchantmentCost(final ItemStack itemStack) {
        int count = 0;
        for (final Enchantment ench : Enchantment.field_77331_b) {
            if (ench != null) {
                final int level = EnchantmentHelper.func_77506_a(ench.field_77352_x, itemStack);
                if (level > 0) {
                    count += this.getWeightModifier(ench) * level;
                    ++count;
                }
            }
        }
        return count;
    }
    
    public int getWeightModifier(final Enchantment ench) {
        switch (ench.func_77324_c()) {
            case 1: {
                return 8;
            }
            case 2: {
                return 4;
            }
            case 3:
            case 4:
            case 5: {
                return 2;
            }
            default: {
                return 1;
            }
        }
    }
    
    public ItemStack func_75144_a(int slotNum, final int mouseButton, final int shiftHeld, final EntityPlayer par4EntityPlayer) {
        if (slotNum > 0 && par4EntityPlayer.field_71071_by.func_70445_o() == null && this.field_75151_b.get(slotNum).field_75224_c == this.assemblyMatrix && !this.field_75151_b.get(slotNum).func_75216_d() && this.isMatrixEmpty((IInventory)this.assemblyMatrix)) {
            slotNum -= 9;
        }
        if (slotNum > 0 && this.field_75151_b.get(slotNum).field_75224_c == this.tinkerResult && this.calculateRecraftingCost() > par4EntityPlayer.field_71068_ca && !par4EntityPlayer.field_71075_bZ.field_75098_d) {
            return null;
        }
        if (slotNum > 0 && this.field_75151_b.get(slotNum).field_75224_c == this.uncraftingMatrix && this.calculateUncraftingCost() > par4EntityPlayer.field_71068_ca && !par4EntityPlayer.field_71075_bZ.field_75098_d) {
            return null;
        }
        if (slotNum > 0 && this.field_75151_b.get(slotNum).field_75224_c == this.uncraftingMatrix && TwilightForestMod.disableUncrafting) {
            par4EntityPlayer.func_70006_a("Uncrafting is disabled in the server configuration.");
            return null;
        }
        if (slotNum > 0 && this.field_75151_b.get(slotNum).field_75224_c == this.uncraftingMatrix && (this.field_75151_b.get(slotNum).func_75211_c() == null || this.field_75151_b.get(slotNum).func_75211_c().field_77994_a == 0)) {
            return null;
        }
        final ItemStack ret = super.func_75144_a(slotNum, mouseButton, shiftHeld, par4EntityPlayer);
        if (slotNum > 0 && this.field_75151_b.get(slotNum).field_75224_c instanceof InventoryTFGoblinInput) {
            this.func_75130_a(this.tinkerInput);
        }
        return ret;
    }
    
    protected void func_75133_b(int slotNum, final int mouseButton, final boolean par3, final EntityPlayer par4EntityPlayer) {
        if (this.field_75151_b.get(slotNum).field_75224_c == this.uncraftingMatrix) {
            slotNum += 9;
        }
        this.func_75144_a(slotNum, mouseButton, 1, par4EntityPlayer);
    }
    
    private boolean isMatrixEmpty(final IInventory matrix) {
        boolean matrixEmpty = true;
        for (int i = 0; i < matrix.func_70302_i_(); ++i) {
            if (matrix.func_70301_a(i) != null) {
                matrixEmpty = false;
            }
        }
        return matrixEmpty;
    }
    
    public boolean isDamageableComponent(final ItemStack itemStack) {
        return itemStack != null && itemStack.func_77973_b().field_77779_bT != Item.field_77669_D.field_77779_bT;
    }
    
    public int countDamageableParts(final IInventory matrix) {
        int count = 0;
        for (int i = 0; i < matrix.func_70302_i_(); ++i) {
            if (this.isDamageableComponent(matrix.func_70301_a(i))) {
                ++count;
            }
        }
        return count;
    }
    
    public int countDamagedParts(final ItemStack input) {
        final int totalMax4 = Math.max(4, this.countDamageableParts((IInventory)this.uncraftingMatrix));
        final float damage = input.func_77960_j() / (float)input.func_77958_k();
        final int damagedParts = (int)Math.ceil(totalMax4 * damage);
        return damagedParts;
    }
    
    public ItemStack func_82846_b(final EntityPlayer player, final int slotNum) {
        ItemStack copyItem = null;
        final Slot transferSlot = this.field_75151_b.get(slotNum);
        if (transferSlot != null && transferSlot.func_75216_d()) {
            final ItemStack transferStack = transferSlot.func_75211_c();
            copyItem = transferStack.func_77946_l();
            if (slotNum == 0 || slotNum == 1) {
                if (!this.func_75135_a(transferStack, 20, 56, true)) {
                    return null;
                }
                transferSlot.func_75220_a(transferStack, copyItem);
            }
            else if (slotNum >= 20 && slotNum < 47) {
                if (!this.func_75135_a(transferStack, 47, 56, false)) {
                    return null;
                }
            }
            else if (slotNum >= 47 && slotNum < 56) {
                if (!this.func_75135_a(transferStack, 20, 47, false)) {
                    return null;
                }
            }
            else if (!this.func_75135_a(transferStack, 20, 56, false)) {
                return null;
            }
            if (transferStack.field_77994_a == 0) {
                transferSlot.func_75215_d((ItemStack)null);
            }
            else {
                transferSlot.func_75218_e();
            }
            if (transferStack.field_77994_a == copyItem.field_77994_a) {
                return null;
            }
            transferSlot.func_82870_a(player, transferStack);
        }
        return copyItem;
    }
    
    public void func_75134_a(final EntityPlayer par1EntityPlayer) {
        super.func_75134_a(par1EntityPlayer);
        if (!this.worldObj.field_72995_K) {
            for (int i = 0; i < 9; ++i) {
                final ItemStack assemblyStack = this.assemblyMatrix.func_70304_b(i);
                if (assemblyStack != null) {
                    par1EntityPlayer.func_71021_b(assemblyStack);
                }
            }
            final ItemStack inputStack = this.tinkerInput.func_70304_b(0);
            if (inputStack != null) {
                par1EntityPlayer.func_71021_b(inputStack);
            }
        }
    }
    
    public ItemStack[] getRecipeItems(final IRecipe recipe) {
        if (recipe instanceof ShapedRecipes) {
            return this.getRecipeItemsShaped((ShapedRecipes)recipe);
        }
        if (recipe instanceof ShapedOreRecipe) {
            return this.getRecipeItemsOre((ShapedOreRecipe)recipe);
        }
        return null;
    }
    
    public ItemStack[] getRecipeItemsShaped(final ShapedRecipes shaped) {
        return shaped.field_77574_d;
    }
    
    public ItemStack[] getRecipeItemsOre(final ShapedOreRecipe shaped) {
        try {
            final Object[] objects = (Object[])ObfuscationReflectionHelper.getPrivateValue((Class)ShapedOreRecipe.class, (Object)shaped, 3);
            final ItemStack[] items = new ItemStack[objects.length];
            for (int i = 0; i < objects.length; ++i) {
                if (objects[i] instanceof ItemStack) {
                    items[i] = (ItemStack)objects[i];
                }
                if (objects[i] instanceof ArrayList && ((ArrayList)objects[i]).size() > 0) {
                    items[i] = ((ArrayList)objects[i]).get(0);
                }
            }
            return items;
        }
        catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        catch (SecurityException e2) {
            e2.printStackTrace();
        }
        return null;
    }
    
    public int getRecipeWidth(final IRecipe recipe) {
        if (recipe instanceof ShapedRecipes) {
            return this.getRecipeWidthShaped((ShapedRecipes)recipe);
        }
        if (recipe instanceof ShapedOreRecipe) {
            return this.getRecipeWidthOre((ShapedOreRecipe)recipe);
        }
        return -1;
    }
    
    public int getRecipeWidthShaped(final ShapedRecipes shaped) {
        return shaped.field_77576_b;
    }
    
    public int getRecipeWidthOre(final ShapedOreRecipe shaped) {
        try {
            return (int)ObfuscationReflectionHelper.getPrivateValue((Class)ShapedOreRecipe.class, (Object)shaped, 4);
        }
        catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        catch (SecurityException e2) {
            e2.printStackTrace();
        }
        return 0;
    }
    
    public int getRecipeHeight(final IRecipe recipe) {
        if (recipe instanceof ShapedRecipes) {
            return this.getRecipeHeightShaped((ShapedRecipes)recipe);
        }
        if (recipe instanceof ShapedOreRecipe) {
            return this.getRecipeHeightOre((ShapedOreRecipe)recipe);
        }
        return -1;
    }
    
    public int getRecipeHeightShaped(final ShapedRecipes shaped) {
        return shaped.field_77577_c;
    }
    
    public int getRecipeHeightOre(final ShapedOreRecipe shaped) {
        try {
            return (int)ObfuscationReflectionHelper.getPrivateValue((Class)ShapedOreRecipe.class, (Object)shaped, 5);
        }
        catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        catch (SecurityException e2) {
            e2.printStackTrace();
        }
        return 0;
    }
    
    public boolean func_75145_c(final EntityPlayer var1) {
        return true;
    }
}
