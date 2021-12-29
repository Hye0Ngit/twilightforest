// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.ArrayList;
import cpw.mods.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.oredict.ShapedOreRecipe;
import java.util.Iterator;
import java.util.Map;

public class ContainerTFUncrafting extends td
{
    public InventoryTFGoblinUncrafting uncraftingMatrix;
    public tl assemblyMatrix;
    public tl combineMatrix;
    public lt tinkerInput;
    public lt tinkerResult;
    private zv worldObj;
    private int posX;
    private int posY;
    private int posZ;
    
    public ContainerTFUncrafting(final si inventory, final zv world, final int x, final int y, final int z) {
        this.uncraftingMatrix = new InventoryTFGoblinUncrafting(this);
        this.assemblyMatrix = new tl((td)this, 3, 3);
        this.combineMatrix = new tl((td)this, 3, 3);
        this.tinkerInput = (lt)new InventoryTFGoblinInput(this);
        this.tinkerResult = (lt)new ud();
        this.worldObj = world;
        this.posX = x;
        this.posY = y;
        this.posZ = z;
        this.a(new uf(this.tinkerInput, 0, 13, 35));
        this.a((uf)new SlotTFGoblinCraftResult(inventory.d, this.tinkerInput, (lt)this.uncraftingMatrix, (lt)this.assemblyMatrix, this.tinkerResult, 0, 147, 35));
        for (int invX = 0; invX < 3; ++invX) {
            for (int invY = 0; invY < 3; ++invY) {
                this.a((uf)new SlotTFGoblinUncrafting(inventory.d, this.tinkerInput, this.uncraftingMatrix, (lt)this.assemblyMatrix, invY + invX * 3, 300000 + invY * 18, 17 + invX * 18));
            }
        }
        for (int invX = 0; invX < 3; ++invX) {
            for (int invY = 0; invY < 3; ++invY) {
                this.a((uf)new SlotTFGoblinAssembly(inventory.d, this.tinkerInput, (lt)this.assemblyMatrix, (lt)this.uncraftingMatrix, invY + invX * 3, 62 + invY * 18, 17 + invX * 18));
            }
        }
        for (int invX = 0; invX < 3; ++invX) {
            for (int invY = 0; invY < 9; ++invY) {
                this.a(new uf((lt)inventory, invY + invX * 9 + 9, 8 + invY * 18, 84 + invX * 18));
            }
        }
        for (int invX = 0; invX < 9; ++invX) {
            this.a(new uf((lt)inventory, invX, 8 + invX * 18, 142));
        }
        this.a((lt)this.assemblyMatrix);
    }
    
    public void a(final lt par1IInventory) {
        if (par1IInventory == this.tinkerInput) {
            final wg inputStack = this.tinkerInput.a(0);
            final yg recipe = this.getRecipeFor(inputStack);
            if (recipe != null) {
                final int recipeWidth = this.getRecipeWidth(recipe);
                final int recipeHeight = this.getRecipeHeight(recipe);
                final wg[] recipeItems = this.getRecipeItems(recipe);
                for (int i = 0; i < this.uncraftingMatrix.j_(); ++i) {
                    this.uncraftingMatrix.a(i, null);
                }
                for (int invY = 0; invY < recipeHeight; ++invY) {
                    for (int invX = 0; invX < recipeWidth; ++invX) {
                        final wg ingredient = wg.b(recipeItems[invX + invY * recipeWidth]);
                        if (ingredient != null && ingredient.a > 1) {
                            ingredient.a = 1;
                        }
                        if (ingredient != null && ingredient.j() == -1) {
                            ingredient.b(0);
                        }
                        this.uncraftingMatrix.a(invX + invY * 3, ingredient);
                    }
                }
                if (inputStack.i()) {
                    for (int damagedParts = this.countDamagedParts(inputStack), j = 0; j < 9 && damagedParts > 0; ++j) {
                        if (this.isDamageableComponent(this.uncraftingMatrix.a(j))) {
                            this.uncraftingMatrix.a(j).a = 0;
                            --damagedParts;
                        }
                    }
                }
                for (int i = 0; i < 9; ++i) {
                    final wg ingredient2 = this.uncraftingMatrix.a(i);
                    if (this.isIngredientProblematic(ingredient2)) {
                        ingredient2.a = 0;
                    }
                }
                this.uncraftingMatrix.numberOfInputItems = recipe.b().a;
                this.uncraftingMatrix.uncraftingCost = this.calculateUncraftingCost();
                this.uncraftingMatrix.recraftingCost = 0;
            }
            else {
                for (int k = 0; k < 9; ++k) {
                    this.uncraftingMatrix.a(k, null);
                }
                this.uncraftingMatrix.numberOfInputItems = 0;
                this.uncraftingMatrix.uncraftingCost = 0;
            }
        }
        if (par1IInventory == this.assemblyMatrix || par1IInventory == this.tinkerInput) {
            if (this.isMatrixEmpty(this.tinkerInput)) {
                this.tinkerResult.a(0, ye.a().a(this.assemblyMatrix, this.worldObj));
                this.uncraftingMatrix.recraftingCost = 0;
            }
            else {
                this.tinkerResult.a(0, (wg)null);
                this.uncraftingMatrix.uncraftingCost = this.calculateUncraftingCost();
                this.uncraftingMatrix.recraftingCost = 0;
            }
        }
        if (par1IInventory != this.combineMatrix && !this.isMatrixEmpty((lt)this.uncraftingMatrix) && !this.isMatrixEmpty((lt)this.assemblyMatrix)) {
            for (int l = 0; l < 9; ++l) {
                if (this.assemblyMatrix.a(l) != null) {
                    this.combineMatrix.a(l, this.assemblyMatrix.a(l));
                }
                else if (this.uncraftingMatrix.a(l) != null && this.uncraftingMatrix.a(l).a > 0) {
                    this.combineMatrix.a(l, this.uncraftingMatrix.a(l));
                }
                else {
                    this.combineMatrix.a(l, (wg)null);
                }
            }
            final wg result = ye.a().a(this.combineMatrix, this.worldObj);
            final wg input = this.tinkerInput.a(0);
            if (result != null && this.isValidMatchForInput(input, result)) {
                bs inputTags = input.q();
                if (inputTags != null) {
                    inputTags = (bs)inputTags.b();
                }
                Map resultInnateEnchantments = null;
                if (result.x()) {
                    resultInnateEnchantments = yv.a(result);
                }
                Map inputEnchantments = null;
                if (input.x()) {
                    inputEnchantments = yv.a(input);
                    for (final Object key : inputEnchantments.keySet()) {
                        final int enchID = (int)key;
                        final int level = inputEnchantments.get(key);
                        final yt ench = yt.b[enchID];
                        if (!ench.a(result)) {
                            inputEnchantments.remove(key);
                        }
                    }
                }
                if (inputTags != null) {
                    inputTags.o("ench");
                    result.d((bs)inputTags.b());
                    if (inputEnchantments != null) {
                        yv.a(inputEnchantments, result);
                    }
                }
                this.tinkerResult.a(0, result);
                this.uncraftingMatrix.uncraftingCost = 0;
                this.uncraftingMatrix.recraftingCost = this.calculateRecraftingCost();
                if (this.uncraftingMatrix.recraftingCost > 0 && !result.t()) {
                    result.c(input.B() + 2);
                }
                if (resultInnateEnchantments != null && resultInnateEnchantments.size() > 0) {
                    for (final Object key : resultInnateEnchantments.keySet()) {
                        final int enchID = (int)key;
                        int level = resultInnateEnchantments.get(key);
                        final yt ench = yt.b[enchID];
                        if (yv.a(enchID, result) > level) {
                            level = yv.a(enchID, result);
                        }
                        if (yv.a(enchID, result) < level) {
                            result.a(ench, level);
                        }
                    }
                }
            }
        }
    }
    
    protected boolean isIngredientProblematic(final wg ingredient) {
        return ingredient != null && (ingredient.b().t() || ingredient.a().contains("itemMatter"));
    }
    
    public yg getRecipeFor(final wg inputStack) {
        if (inputStack != null) {
            for (final yg recipe : ye.a().b()) {
                if ((recipe instanceof yh || recipe instanceof ShapedOreRecipe) && recipe.b().c == inputStack.c && inputStack.a >= recipe.b().a && (!recipe.b().h() || recipe.b().k() == inputStack.k())) {
                    return recipe;
                }
            }
        }
        return null;
    }
    
    public boolean isValidMatchForInput(final wg inputStack, final wg resultStack) {
        if (inputStack.b() instanceof wo && resultStack.b() instanceof wo) {
            return true;
        }
        if (inputStack.b() instanceof wc && resultStack.b() instanceof wc) {
            return true;
        }
        if (inputStack.b() instanceof wz && resultStack.b() instanceof wz) {
            return true;
        }
        if (inputStack.b() instanceof wd && resultStack.b() instanceof wd) {
            return true;
        }
        if (inputStack.b() instanceof xl && resultStack.b() instanceof xl) {
            return true;
        }
        if (inputStack.b() instanceof uq && resultStack.b() instanceof uq) {
            return true;
        }
        if (inputStack.b() instanceof ui && resultStack.b() instanceof ui) {
            final ui inputArmor = (ui)inputStack.b();
            final ui resultArmor = (ui)resultStack.b();
            return inputArmor.b == resultArmor.b;
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
        if (!this.isMatrixEmpty((lt)this.assemblyMatrix)) {
            return 0;
        }
        return this.countDamageableParts((lt)this.uncraftingMatrix);
    }
    
    public int calculateRecraftingCost() {
        if (this.tinkerInput.a(0) == null || !this.tinkerInput.a(0).x() || this.tinkerResult.a(0) == null) {
            return 0;
        }
        final wg input = this.tinkerInput.a(0);
        final wg output = this.tinkerResult.a(0);
        int cost = 0;
        cost += input.B();
        final int enchantCost = this.countTotalEnchantmentCost(input);
        cost += enchantCost;
        final int damagedCost = (1 + this.countDamagedParts(input)) * yv.a(output).size();
        cost += damagedCost;
        final int enchantabilityDifference = input.b().c() - output.b().c();
        cost += enchantabilityDifference;
        cost = Math.max(1, cost);
        return cost;
    }
    
    public int countHighestEnchantmentCost(final wg itemStack) {
        int count = 0;
        for (final yt ench : yt.b) {
            if (ench != null) {
                final int level = yv.a(ench.z, itemStack);
                if (level > count) {
                    count += this.getWeightModifier(ench) * level;
                }
            }
        }
        return count;
    }
    
    public int countTotalEnchantmentCost(final wg itemStack) {
        int count = 0;
        for (final yt ench : yt.b) {
            if (ench != null) {
                final int level = yv.a(ench.z, itemStack);
                if (level > 0) {
                    count += this.getWeightModifier(ench) * level;
                    ++count;
                }
            }
        }
        return count;
    }
    
    public int getWeightModifier(final yt ench) {
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
    
    public wg a(int slotNum, final int mouseButton, final int shiftHeld, final sk par4EntityPlayer) {
        if (slotNum > -999 && par4EntityPlayer.bK.o() == null && this.c.get(slotNum).f == this.assemblyMatrix && !this.c.get(slotNum).d() && this.isMatrixEmpty((lt)this.assemblyMatrix)) {
            slotNum -= 9;
        }
        if (slotNum > -999 && this.c.get(slotNum).f == this.tinkerResult && this.calculateRecraftingCost() > par4EntityPlayer.cf && !par4EntityPlayer.ce.d) {
            return null;
        }
        if (slotNum > -999 && this.c.get(slotNum).f == this.uncraftingMatrix && this.calculateUncraftingCost() > par4EntityPlayer.cf && !par4EntityPlayer.ce.d) {
            return null;
        }
        if (slotNum > -999 && this.c.get(slotNum).f == this.uncraftingMatrix && TwilightForestMod.disableUncrafting) {
            par4EntityPlayer.a("Uncrafting is disabled in the server configuration.");
            return null;
        }
        if (slotNum > -999 && this.c.get(slotNum).f == this.uncraftingMatrix && (this.c.get(slotNum).c() == null || this.c.get(slotNum).c().a == 0)) {
            return null;
        }
        final wg ret = super.a(slotNum, mouseButton, shiftHeld, par4EntityPlayer);
        if (slotNum > -999 && this.c.get(slotNum).f instanceof InventoryTFGoblinInput) {
            this.a(this.tinkerInput);
        }
        return ret;
    }
    
    protected void a(int slotNum, final int mouseButton, final boolean par3, final sk par4EntityPlayer) {
        if (this.c.get(slotNum).f == this.uncraftingMatrix) {
            slotNum += 9;
        }
        this.a(slotNum, mouseButton, 1, par4EntityPlayer);
    }
    
    private boolean isMatrixEmpty(final lt matrix) {
        boolean matrixEmpty = true;
        for (int i = 0; i < matrix.j_(); ++i) {
            if (matrix.a(i) != null) {
                matrixEmpty = false;
            }
        }
        return matrixEmpty;
    }
    
    public boolean isDamageableComponent(final wg itemStack) {
        return itemStack != null && itemStack.b().cp != we.E.cp;
    }
    
    public int countDamageableParts(final lt matrix) {
        int count = 0;
        for (int i = 0; i < matrix.j_(); ++i) {
            if (this.isDamageableComponent(matrix.a(i))) {
                ++count;
            }
        }
        return count;
    }
    
    public int countDamagedParts(final wg input) {
        final int totalMax4 = Math.max(4, this.countDamageableParts((lt)this.uncraftingMatrix));
        final float damage = input.k() / (float)input.l();
        final int damagedParts = (int)Math.ceil(totalMax4 * damage);
        return damagedParts;
    }
    
    public wg b(final sk player, final int slotNum) {
        wg copyItem = null;
        final uf transferSlot = this.c.get(slotNum);
        if (transferSlot != null && transferSlot.d()) {
            final wg transferStack = transferSlot.c();
            copyItem = transferStack.m();
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
                transferSlot.c((wg)null);
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
    
    public void b(final sk par1EntityPlayer) {
        super.b(par1EntityPlayer);
        if (!this.worldObj.I) {
            for (int i = 0; i < 9; ++i) {
                final wg assemblyStack = this.assemblyMatrix.b(i);
                if (assemblyStack != null) {
                    par1EntityPlayer.c(assemblyStack);
                }
            }
            final wg inputStack = this.tinkerInput.b(0);
            if (inputStack != null) {
                par1EntityPlayer.c(inputStack);
            }
        }
    }
    
    public wg[] getRecipeItems(final yg recipe) {
        if (recipe instanceof yh) {
            return this.getRecipeItemsShaped((yh)recipe);
        }
        if (recipe instanceof ShapedOreRecipe) {
            return this.getRecipeItemsOre((ShapedOreRecipe)recipe);
        }
        return null;
    }
    
    public wg[] getRecipeItemsShaped(final yh shaped) {
        try {
            return (wg[])ObfuscationReflectionHelper.getPrivateValue((Class)yh.class, (Object)shaped, 2);
        }
        catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        catch (SecurityException e2) {
            e2.printStackTrace();
        }
        return null;
    }
    
    public wg[] getRecipeItemsOre(final ShapedOreRecipe shaped) {
        try {
            final Object[] objects = (Object[])ObfuscationReflectionHelper.getPrivateValue((Class)ShapedOreRecipe.class, (Object)shaped, 3);
            final wg[] items = new wg[objects.length];
            for (int i = 0; i < objects.length; ++i) {
                if (objects[i] instanceof wg) {
                    items[i] = (wg)objects[i];
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
    
    public int getRecipeWidth(final yg recipe) {
        if (recipe instanceof yh) {
            return this.getRecipeWidthShaped((yh)recipe);
        }
        if (recipe instanceof ShapedOreRecipe) {
            return this.getRecipeWidthOre((ShapedOreRecipe)recipe);
        }
        return -1;
    }
    
    public int getRecipeWidthShaped(final yh shaped) {
        try {
            return (int)ObfuscationReflectionHelper.getPrivateValue((Class)yh.class, (Object)shaped, 0);
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
    
    public int getRecipeHeight(final yg recipe) {
        if (recipe instanceof yh) {
            return this.getRecipeHeightShaped((yh)recipe);
        }
        if (recipe instanceof ShapedOreRecipe) {
            return this.getRecipeHeightOre((ShapedOreRecipe)recipe);
        }
        return -1;
    }
    
    public int getRecipeHeightShaped(final yh shaped) {
        try {
            return (int)ObfuscationReflectionHelper.getPrivateValue((Class)yh.class, (Object)shaped, 1);
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
    
    public boolean a(final sk var1) {
        return true;
    }
}
