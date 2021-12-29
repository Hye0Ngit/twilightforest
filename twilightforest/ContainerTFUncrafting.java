// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.ArrayList;
import cpw.mods.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.oredict.ShapedOreRecipe;
import java.util.Iterator;
import java.util.Map;

public class ContainerTFUncrafting extends rq
{
    public InventoryTFGoblinUncrafting uncraftingMatrix;
    public ry assemblyMatrix;
    public ry combineMatrix;
    public la tinkerInput;
    public la tinkerResult;
    private yc worldObj;
    private int posX;
    private int posY;
    private int posZ;
    
    public ContainerTFUncrafting(final qw inventory, final yc world, final int x, final int y, final int z) {
        this.uncraftingMatrix = new InventoryTFGoblinUncrafting(this);
        this.assemblyMatrix = new ry((rq)this, 3, 3);
        this.combineMatrix = new ry((rq)this, 3, 3);
        this.tinkerInput = (la)new InventoryTFGoblinInput(this);
        this.tinkerResult = (la)new sp();
        this.worldObj = world;
        this.posX = x;
        this.posY = y;
        this.posZ = z;
        this.a(new sr(this.tinkerInput, 0, 13, 35));
        this.a((sr)new SlotTFGoblinCraftResult(inventory.d, this.tinkerInput, (la)this.uncraftingMatrix, (la)this.assemblyMatrix, this.tinkerResult, 0, 147, 35));
        for (int invX = 0; invX < 3; ++invX) {
            for (int invY = 0; invY < 3; ++invY) {
                this.a((sr)new SlotTFGoblinUncrafting(inventory.d, this.tinkerInput, this.uncraftingMatrix, (la)this.assemblyMatrix, invY + invX * 3, 300000 + invY * 18, 17 + invX * 18));
            }
        }
        for (int invX = 0; invX < 3; ++invX) {
            for (int invY = 0; invY < 3; ++invY) {
                this.a((sr)new SlotTFGoblinAssembly(inventory.d, this.tinkerInput, (la)this.assemblyMatrix, (la)this.uncraftingMatrix, invY + invX * 3, 62 + invY * 18, 17 + invX * 18));
            }
        }
        for (int invX = 0; invX < 3; ++invX) {
            for (int invY = 0; invY < 9; ++invY) {
                this.a(new sr((la)inventory, invY + invX * 9 + 9, 8 + invY * 18, 84 + invX * 18));
            }
        }
        for (int invX = 0; invX < 9; ++invX) {
            this.a(new sr((la)inventory, invX, 8 + invX * 18, 142));
        }
        this.a((la)this.assemblyMatrix);
    }
    
    public void a(final la par1IInventory) {
        if (par1IInventory == this.tinkerInput) {
            final ur inputStack = this.tinkerInput.a(0);
            final wp recipe = this.getRecipeFor(inputStack);
            if (recipe != null) {
                final int recipeWidth = this.getRecipeWidth(recipe);
                final int recipeHeight = this.getRecipeHeight(recipe);
                final ur[] recipeItems = this.getRecipeItems(recipe);
                for (int invY = 0; invY < recipeHeight; ++invY) {
                    for (int invX = 0; invX < recipeWidth; ++invX) {
                        final ur ingredient = ur.b(recipeItems[invX + invY * recipeWidth]);
                        if (ingredient != null && ingredient.a > 1) {
                            ingredient.a = 1;
                        }
                        if (ingredient != null && ingredient.i() == -1) {
                            ingredient.b(0);
                        }
                        this.uncraftingMatrix.a(invX + invY * 3, ingredient);
                    }
                }
                if (inputStack.h()) {
                    for (int damagedParts = this.countDamagedParts(inputStack), i = 0; i < 9 && damagedParts > 0; ++i) {
                        if (this.isDamageableComponent(this.uncraftingMatrix.a(i))) {
                            this.uncraftingMatrix.a(i).a = 0;
                            --damagedParts;
                        }
                    }
                }
                this.uncraftingMatrix.numberOfInputItems = recipe.b().a;
                this.uncraftingMatrix.uncraftingCost = this.calculateUncraftingCost();
                this.uncraftingMatrix.recraftingCost = 0;
            }
            else {
                for (int j = 0; j < 9; ++j) {
                    this.uncraftingMatrix.a(j, null);
                }
                this.uncraftingMatrix.numberOfInputItems = 0;
                this.uncraftingMatrix.uncraftingCost = 0;
            }
        }
        if (par1IInventory == this.assemblyMatrix || par1IInventory == this.tinkerInput) {
            if (this.isMatrixEmpty(this.tinkerInput)) {
                this.tinkerResult.a(0, wn.a().a(this.assemblyMatrix, this.worldObj));
                this.uncraftingMatrix.recraftingCost = 0;
            }
            else {
                this.tinkerResult.a(0, (ur)null);
                this.uncraftingMatrix.uncraftingCost = this.calculateUncraftingCost();
                this.uncraftingMatrix.recraftingCost = 0;
            }
        }
        if (par1IInventory != this.combineMatrix && !this.isMatrixEmpty((la)this.uncraftingMatrix) && !this.isMatrixEmpty((la)this.assemblyMatrix)) {
            for (int k = 0; k < 9; ++k) {
                if (this.assemblyMatrix.a(k) != null) {
                    this.combineMatrix.a(k, this.assemblyMatrix.a(k));
                }
                else if (this.uncraftingMatrix.a(k) != null && this.uncraftingMatrix.a(k).a > 0) {
                    this.combineMatrix.a(k, this.uncraftingMatrix.a(k));
                }
                else {
                    this.combineMatrix.a(k, (ur)null);
                }
            }
            final ur result = wn.a().a(this.combineMatrix, this.worldObj);
            final ur input = this.tinkerInput.a(0);
            if (result != null && this.isValidMatchForInput(input, result)) {
                final bq inputEnchantments = input.p();
                Map resultInnateEnchantments = null;
                if (result.w()) {
                    resultInnateEnchantments = xe.a(result);
                }
                if (inputEnchantments != null) {
                    result.d((bq)inputEnchantments.b());
                }
                this.tinkerResult.a(0, result);
                this.uncraftingMatrix.uncraftingCost = 0;
                this.uncraftingMatrix.recraftingCost = this.calculateRecraftingCost();
                if (this.uncraftingMatrix.recraftingCost > 0 && !result.s()) {
                    result.c(input.A() + 2);
                }
                if (resultInnateEnchantments != null && resultInnateEnchantments.size() > 0) {
                    for (final Object key : resultInnateEnchantments.keySet()) {
                        final int enchID = (int)key;
                        int level = resultInnateEnchantments.get(key);
                        final xc ench = xc.b[enchID];
                        if (xe.a(enchID, result) > level) {
                            level = xe.a(enchID, result);
                        }
                        if (xe.a(enchID, result) < level) {
                            result.a(ench, level);
                        }
                    }
                }
            }
        }
    }
    
    public wp getRecipeFor(final ur inputStack) {
        if (inputStack != null) {
            for (final wp recipe : wn.a().b()) {
                if ((recipe instanceof wq || recipe instanceof ShapedOreRecipe) && recipe.b().c == inputStack.c && inputStack.a >= recipe.b().a && (!recipe.b().g() || recipe.b().j() == inputStack.j())) {
                    return recipe;
                }
            }
        }
        return null;
    }
    
    public boolean isValidMatchForInput(final ur inputStack, final ur resultStack) {
        if (inputStack.b() instanceof uy && resultStack.b() instanceof uy) {
            return true;
        }
        if (inputStack.b() instanceof un && resultStack.b() instanceof un) {
            return true;
        }
        if (inputStack.b() instanceof vj && resultStack.b() instanceof vj) {
            return true;
        }
        if (inputStack.b() instanceof uo && resultStack.b() instanceof uo) {
            return true;
        }
        if (inputStack.b() instanceof vu && resultStack.b() instanceof vu) {
            return true;
        }
        if (inputStack.b() instanceof tb && resultStack.b() instanceof tb) {
            return true;
        }
        if (inputStack.b() instanceof su && resultStack.b() instanceof su) {
            final su inputArmor = (su)inputStack.b();
            final su resultArmor = (su)resultStack.b();
            return inputArmor.a == resultArmor.a;
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
        if (!this.isMatrixEmpty((la)this.assemblyMatrix)) {
            return 0;
        }
        return this.countDamageableParts((la)this.uncraftingMatrix);
    }
    
    public int calculateRecraftingCost() {
        if (this.tinkerInput.a(0) == null || !this.tinkerInput.a(0).w() || this.tinkerResult.a(0) == null) {
            return 0;
        }
        final ur input = this.tinkerInput.a(0);
        final ur output = this.tinkerResult.a(0);
        int cost = 0;
        cost += input.A();
        final int enchantCost = this.countTotalEnchantmentCost(input);
        cost += enchantCost;
        final int damagedCost = (1 + this.countDamagedParts(input)) * xe.a(output).size();
        cost += damagedCost;
        final int enchantabilityDifference = input.b().c() - output.b().c();
        cost += enchantabilityDifference;
        cost = Math.max(1, cost);
        return cost;
    }
    
    public int countHighestEnchantmentCost(final ur itemStack) {
        int count = 0;
        for (final xc ench : xc.b) {
            if (ench != null) {
                final int level = xe.a(ench.z, itemStack);
                if (level > count) {
                    count += this.getWeightModifier(ench) * level;
                }
            }
        }
        return count;
    }
    
    public int countTotalEnchantmentCost(final ur itemStack) {
        int count = 0;
        for (final xc ench : xc.b) {
            if (ench != null) {
                final int level = xe.a(ench.z, itemStack);
                if (level > 0) {
                    count += this.getWeightModifier(ench) * level;
                    ++count;
                }
            }
        }
        return count;
    }
    
    public int getWeightModifier(final xc ench) {
        switch (ench.c()) {
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
    
    public ur a(int slotNum, final int mouseButton, final int shiftHeld, final qx par4EntityPlayer) {
        if (slotNum > -999 && par4EntityPlayer.bJ.n() == null && this.c.get(slotNum).f == this.assemblyMatrix && !this.c.get(slotNum).d() && this.isMatrixEmpty((la)this.assemblyMatrix)) {
            slotNum -= 9;
        }
        if (slotNum > -999 && this.c.get(slotNum).f == this.tinkerResult && this.calculateRecraftingCost() > par4EntityPlayer.ce && !par4EntityPlayer.cd.d) {
            return null;
        }
        if (slotNum > -999 && this.c.get(slotNum).f == this.uncraftingMatrix && this.calculateUncraftingCost() > par4EntityPlayer.ce && !par4EntityPlayer.cd.d) {
            return null;
        }
        if (slotNum > -999 && this.c.get(slotNum).f == this.uncraftingMatrix && (this.c.get(slotNum).c() == null || this.c.get(slotNum).c().a == 0)) {
            return null;
        }
        final ur ret = super.a(slotNum, mouseButton, shiftHeld, par4EntityPlayer);
        if (slotNum > -999 && this.c.get(slotNum).f instanceof InventoryTFGoblinInput) {
            this.a(this.tinkerInput);
        }
        return ret;
    }
    
    protected void a(int slotNum, final int mouseButton, final boolean par3, final qx par4EntityPlayer) {
        if (this.c.get(slotNum).f == this.uncraftingMatrix) {
            slotNum += 9;
        }
        this.a(slotNum, mouseButton, 1, par4EntityPlayer);
    }
    
    private boolean isMatrixEmpty(final la matrix) {
        boolean matrixEmpty = true;
        for (int i = 0; i < matrix.k_(); ++i) {
            if (matrix.a(i) != null) {
                matrixEmpty = false;
            }
        }
        return matrixEmpty;
    }
    
    public boolean isDamageableComponent(final ur itemStack) {
        return itemStack != null && itemStack.b().cj != up.D.cj;
    }
    
    public int countDamageableParts(final la matrix) {
        int count = 0;
        for (int i = 0; i < matrix.k_(); ++i) {
            if (this.isDamageableComponent(matrix.a(i))) {
                ++count;
            }
        }
        return count;
    }
    
    public int countDamagedParts(final ur input) {
        final int totalMax4 = Math.max(4, this.countDamageableParts((la)this.uncraftingMatrix));
        final float damage = input.j() / (float)input.k();
        final int damagedParts = (int)Math.ceil(totalMax4 * damage);
        return damagedParts;
    }
    
    public ur b(final qx player, final int slotNum) {
        ur copyItem = null;
        final sr transferSlot = this.c.get(slotNum);
        if (transferSlot != null && transferSlot.d()) {
            final ur transferStack = transferSlot.c();
            copyItem = transferStack.l();
            if (slotNum == 0 || slotNum == 1) {
                if (!this.a(transferStack, 20, 56, true)) {
                    return null;
                }
                transferSlot.a(transferStack, copyItem);
            }
            else if (slotNum >= 20 && slotNum < 47) {
                if (!this.a(transferStack, 47, 56, false)) {
                    return null;
                }
            }
            else if (slotNum >= 47 && slotNum < 56) {
                if (!this.a(transferStack, 20, 47, false)) {
                    return null;
                }
            }
            else if (!this.a(transferStack, 20, 56, false)) {
                return null;
            }
            if (transferStack.a == 0) {
                transferSlot.c((ur)null);
            }
            else {
                transferSlot.e();
            }
            if (transferStack.a == copyItem.a) {
                return null;
            }
            transferSlot.a(player, transferStack);
        }
        return copyItem;
    }
    
    public void b(final qx par1EntityPlayer) {
        super.b(par1EntityPlayer);
        if (!this.worldObj.I) {
            for (int i = 0; i < 9; ++i) {
                final ur assemblyStack = this.assemblyMatrix.a_(i);
                if (assemblyStack != null) {
                    par1EntityPlayer.c(assemblyStack);
                }
            }
            final ur inputStack = this.tinkerInput.a_(0);
            if (inputStack != null) {
                par1EntityPlayer.c(inputStack);
            }
        }
    }
    
    public ur[] getRecipeItems(final wp recipe) {
        if (recipe instanceof wq) {
            return this.getRecipeItemsShaped((wq)recipe);
        }
        if (recipe instanceof ShapedOreRecipe) {
            return this.getRecipeItemsOre((ShapedOreRecipe)recipe);
        }
        return null;
    }
    
    public ur[] getRecipeItemsShaped(final wq shaped) {
        try {
            return (ur[])ObfuscationReflectionHelper.getPrivateValue((Class)wq.class, (Object)shaped, 2);
        }
        catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        catch (SecurityException e2) {
            e2.printStackTrace();
        }
        return null;
    }
    
    public ur[] getRecipeItemsOre(final ShapedOreRecipe shaped) {
        try {
            final Object[] objects = (Object[])ObfuscationReflectionHelper.getPrivateValue((Class)ShapedOreRecipe.class, (Object)shaped, 3);
            final ur[] items = new ur[objects.length];
            for (int i = 0; i < objects.length; ++i) {
                if (objects[i] instanceof ur) {
                    items[i] = (ur)objects[i];
                }
                if (objects[i] instanceof ArrayList) {
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
    
    public int getRecipeWidth(final wp recipe) {
        if (recipe instanceof wq) {
            return this.getRecipeWidthShaped((wq)recipe);
        }
        if (recipe instanceof ShapedOreRecipe) {
            return this.getRecipeWidthOre((ShapedOreRecipe)recipe);
        }
        return -1;
    }
    
    public int getRecipeWidthShaped(final wq shaped) {
        try {
            return (int)ObfuscationReflectionHelper.getPrivateValue((Class)wq.class, (Object)shaped, 0);
        }
        catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        catch (SecurityException e2) {
            e2.printStackTrace();
        }
        return 0;
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
    
    public int getRecipeHeight(final wp recipe) {
        if (recipe instanceof wq) {
            return this.getRecipeHeightShaped((wq)recipe);
        }
        if (recipe instanceof ShapedOreRecipe) {
            return this.getRecipeHeightOre((ShapedOreRecipe)recipe);
        }
        return -1;
    }
    
    public int getRecipeHeightShaped(final wq shaped) {
        try {
            return (int)ObfuscationReflectionHelper.getPrivateValue((Class)wq.class, (Object)shaped, 1);
        }
        catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        catch (SecurityException e2) {
            e2.printStackTrace();
        }
        return 0;
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
    
    public boolean a(final qx var1) {
        return true;
    }
}
