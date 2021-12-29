// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.ArrayList;
import cpw.mods.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.oredict.ShapedOreRecipe;
import java.util.Iterator;
import java.util.Map;

public class ContainerTFUncrafting extends ux
{
    public InventoryTFGoblinUncrafting uncraftingMatrix;
    public vj assemblyMatrix;
    public vj combineMatrix;
    public mn tinkerInput;
    public mn tinkerResult;
    private abv worldObj;
    private int posX;
    private int posY;
    private int posZ;
    
    public ContainerTFUncrafting(final uc inventory, final abv world, final int x, final int y, final int z) {
        this.uncraftingMatrix = new InventoryTFGoblinUncrafting(this);
        this.assemblyMatrix = new vj((ux)this, 3, 3);
        this.combineMatrix = new vj((ux)this, 3, 3);
        this.tinkerInput = (mn)new InventoryTFGoblinInput(this);
        this.tinkerResult = (mn)new wb();
        this.worldObj = world;
        this.posX = x;
        this.posY = y;
        this.posZ = z;
        this.a(new wd(this.tinkerInput, 0, 13, 35));
        this.a((wd)new SlotTFGoblinCraftResult(inventory.d, this.tinkerInput, (mn)this.uncraftingMatrix, (mn)this.assemblyMatrix, this.tinkerResult, 0, 147, 35));
        for (int invX = 0; invX < 3; ++invX) {
            for (int invY = 0; invY < 3; ++invY) {
                this.a((wd)new SlotTFGoblinUncrafting(inventory.d, this.tinkerInput, this.uncraftingMatrix, (mn)this.assemblyMatrix, invY + invX * 3, 300000 + invY * 18, 17 + invX * 18));
            }
        }
        for (int invX = 0; invX < 3; ++invX) {
            for (int invY = 0; invY < 3; ++invY) {
                this.a((wd)new SlotTFGoblinAssembly(inventory.d, this.tinkerInput, (mn)this.assemblyMatrix, (mn)this.uncraftingMatrix, invY + invX * 3, 62 + invY * 18, 17 + invX * 18));
            }
        }
        for (int invX = 0; invX < 3; ++invX) {
            for (int invY = 0; invY < 9; ++invY) {
                this.a(new wd((mn)inventory, invY + invX * 9 + 9, 8 + invY * 18, 84 + invX * 18));
            }
        }
        for (int invX = 0; invX < 9; ++invX) {
            this.a(new wd((mn)inventory, invX, 8 + invX * 18, 142));
        }
        this.a((mn)this.assemblyMatrix);
    }
    
    public void a(final mn par1IInventory) {
        if (par1IInventory == this.tinkerInput) {
            final yd inputStack = this.tinkerInput.a(0);
            final aag recipe = this.getRecipeFor(inputStack);
            if (recipe != null) {
                final int recipeWidth = this.getRecipeWidth(recipe);
                final int recipeHeight = this.getRecipeHeight(recipe);
                final yd[] recipeItems = this.getRecipeItems(recipe);
                for (int i = 0; i < this.uncraftingMatrix.j_(); ++i) {
                    this.uncraftingMatrix.a(i, null);
                }
                for (int invY = 0; invY < recipeHeight; ++invY) {
                    for (int invX = 0; invX < recipeWidth; ++invX) {
                        final yd ingredient = yd.b(recipeItems[invX + invY * recipeWidth]);
                        if (ingredient != null && ingredient.b > 1) {
                            ingredient.b = 1;
                        }
                        if (ingredient != null && (ingredient.j() == -1 || ingredient.j() == 32767)) {
                            ingredient.b(0);
                        }
                        this.uncraftingMatrix.a(invX + invY * 3, ingredient);
                    }
                }
                if (inputStack.i()) {
                    for (int damagedParts = this.countDamagedParts(inputStack), j = 0; j < 9 && damagedParts > 0; ++j) {
                        if (this.isDamageableComponent(this.uncraftingMatrix.a(j))) {
                            this.uncraftingMatrix.a(j).b = 0;
                            --damagedParts;
                        }
                    }
                }
                for (int i = 0; i < 9; ++i) {
                    final yd ingredient2 = this.uncraftingMatrix.a(i);
                    if (this.isIngredientProblematic(ingredient2)) {
                        ingredient2.b = 0;
                    }
                }
                this.uncraftingMatrix.numberOfInputItems = recipe.b().b;
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
                this.tinkerResult.a(0, aae.a().a(this.assemblyMatrix, this.worldObj));
                this.uncraftingMatrix.recraftingCost = 0;
            }
            else {
                this.tinkerResult.a(0, (yd)null);
                this.uncraftingMatrix.uncraftingCost = this.calculateUncraftingCost();
                this.uncraftingMatrix.recraftingCost = 0;
            }
        }
        if (par1IInventory != this.combineMatrix && !this.isMatrixEmpty((mn)this.uncraftingMatrix) && !this.isMatrixEmpty((mn)this.assemblyMatrix)) {
            for (int l = 0; l < 9; ++l) {
                if (this.assemblyMatrix.a(l) != null) {
                    this.combineMatrix.a(l, this.assemblyMatrix.a(l));
                }
                else if (this.uncraftingMatrix.a(l) != null && this.uncraftingMatrix.a(l).b > 0) {
                    this.combineMatrix.a(l, this.uncraftingMatrix.a(l));
                }
                else {
                    this.combineMatrix.a(l, (yd)null);
                }
            }
            final yd result = aae.a().a(this.combineMatrix, this.worldObj);
            final yd input = this.tinkerInput.a(0);
            if (result != null && this.isValidMatchForInput(input, result)) {
                bx inputTags = input.q();
                if (inputTags != null) {
                    inputTags = (bx)inputTags.b();
                }
                Map resultInnateEnchantments = null;
                if (result.y()) {
                    resultInnateEnchantments = aav.a(result);
                }
                Map inputEnchantments = null;
                if (input.y()) {
                    inputEnchantments = aav.a(input);
                    for (final Object key : inputEnchantments.keySet()) {
                        final int enchID = (int)key;
                        final int level = inputEnchantments.get(key);
                        final aat ench = aat.b[enchID];
                        if (!ench.a(result)) {
                            inputEnchantments.remove(key);
                        }
                    }
                }
                if (inputTags != null) {
                    inputTags.o("ench");
                    result.d((bx)inputTags.b());
                    if (inputEnchantments != null) {
                        aav.a(inputEnchantments, result);
                    }
                }
                this.tinkerResult.a(0, result);
                this.uncraftingMatrix.uncraftingCost = 0;
                this.uncraftingMatrix.recraftingCost = this.calculateRecraftingCost();
                if (this.uncraftingMatrix.recraftingCost > 0 && !result.u()) {
                    result.c(input.C() + 2);
                }
                if (resultInnateEnchantments != null && resultInnateEnchantments.size() > 0) {
                    for (final Object key : resultInnateEnchantments.keySet()) {
                        final int enchID = (int)key;
                        int level = resultInnateEnchantments.get(key);
                        final aat ench = aat.b[enchID];
                        if (aav.a(enchID, result) > level) {
                            level = aav.a(enchID, result);
                        }
                        if (aav.a(enchID, result) < level) {
                            result.a(ench, level);
                        }
                    }
                }
            }
        }
    }
    
    protected boolean isIngredientProblematic(final yd ingredient) {
        return ingredient != null && (ingredient.b().u() || ingredient.a().contains("itemMatter"));
    }
    
    public aag getRecipeFor(final yd inputStack) {
        if (inputStack != null) {
            for (final aag recipe : aae.a().b()) {
                if ((recipe instanceof aah || recipe instanceof ShapedOreRecipe) && recipe.b().d == inputStack.d && inputStack.b >= recipe.b().b && (!recipe.b().h() || recipe.b().k() == inputStack.k())) {
                    return recipe;
                }
            }
        }
        return null;
    }
    
    public boolean isValidMatchForInput(final yd inputStack, final yd resultStack) {
        if (inputStack.b() instanceof ym && resultStack.b() instanceof ym) {
            return true;
        }
        if (inputStack.b() instanceof xz && resultStack.b() instanceof xz) {
            return true;
        }
        if (inputStack.b() instanceof yx && resultStack.b() instanceof yx) {
            return true;
        }
        if (inputStack.b() instanceof ya && resultStack.b() instanceof ya) {
            return true;
        }
        if (inputStack.b() instanceof zk && resultStack.b() instanceof zk) {
            return true;
        }
        if (inputStack.b() instanceof wo && resultStack.b() instanceof wo) {
            return true;
        }
        if (inputStack.b() instanceof wg && resultStack.b() instanceof wg) {
            final wg inputArmor = (wg)inputStack.b();
            final wg resultArmor = (wg)resultStack.b();
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
        if (!this.isMatrixEmpty((mn)this.assemblyMatrix)) {
            return 0;
        }
        return this.countDamageableParts((mn)this.uncraftingMatrix);
    }
    
    public int calculateRecraftingCost() {
        if (this.tinkerInput.a(0) == null || !this.tinkerInput.a(0).y() || this.tinkerResult.a(0) == null) {
            return 0;
        }
        final yd input = this.tinkerInput.a(0);
        final yd output = this.tinkerResult.a(0);
        int cost = 0;
        cost += input.C();
        final int enchantCost = this.countTotalEnchantmentCost(input);
        cost += enchantCost;
        final int damagedCost = (1 + this.countDamagedParts(input)) * aav.a(output).size();
        cost += damagedCost;
        final int enchantabilityDifference = input.b().c() - output.b().c();
        cost += enchantabilityDifference;
        cost = Math.max(1, cost);
        return cost;
    }
    
    public int countHighestEnchantmentCost(final yd itemStack) {
        int count = 0;
        for (final aat ench : aat.b) {
            if (ench != null) {
                final int level = aav.a(ench.z, itemStack);
                if (level > count) {
                    count += this.getWeightModifier(ench) * level;
                }
            }
        }
        return count;
    }
    
    public int countTotalEnchantmentCost(final yd itemStack) {
        int count = 0;
        for (final aat ench : aat.b) {
            if (ench != null) {
                final int level = aav.a(ench.z, itemStack);
                if (level > 0) {
                    count += this.getWeightModifier(ench) * level;
                    ++count;
                }
            }
        }
        return count;
    }
    
    public int getWeightModifier(final aat ench) {
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
    
    public yd a(int slotNum, final int mouseButton, final int shiftHeld, final ue par4EntityPlayer) {
        if (slotNum > 0 && par4EntityPlayer.bn.o() == null && this.c.get(slotNum).f == this.assemblyMatrix && !this.c.get(slotNum).e() && this.isMatrixEmpty((mn)this.assemblyMatrix)) {
            slotNum -= 9;
        }
        if (slotNum > 0 && this.c.get(slotNum).f == this.tinkerResult && this.calculateRecraftingCost() > par4EntityPlayer.bH && !par4EntityPlayer.bG.d) {
            return null;
        }
        if (slotNum > 0 && this.c.get(slotNum).f == this.uncraftingMatrix && this.calculateUncraftingCost() > par4EntityPlayer.bH && !par4EntityPlayer.bG.d) {
            return null;
        }
        if (slotNum > 0 && this.c.get(slotNum).f == this.uncraftingMatrix && TwilightForestMod.disableUncrafting) {
            return null;
        }
        if (slotNum > 0 && this.c.get(slotNum).f == this.uncraftingMatrix && (this.c.get(slotNum).d() == null || this.c.get(slotNum).d().b == 0)) {
            return null;
        }
        final yd ret = super.a(slotNum, mouseButton, shiftHeld, par4EntityPlayer);
        if (slotNum > 0 && this.c.get(slotNum).f instanceof InventoryTFGoblinInput) {
            this.a(this.tinkerInput);
        }
        return ret;
    }
    
    protected void a(int slotNum, final int mouseButton, final boolean par3, final ue par4EntityPlayer) {
        if (this.c.get(slotNum).f == this.uncraftingMatrix) {
            slotNum += 9;
        }
        this.a(slotNum, mouseButton, 1, par4EntityPlayer);
    }
    
    private boolean isMatrixEmpty(final mn matrix) {
        boolean matrixEmpty = true;
        for (int i = 0; i < matrix.j_(); ++i) {
            if (matrix.a(i) != null) {
                matrixEmpty = false;
            }
        }
        return matrixEmpty;
    }
    
    public boolean isDamageableComponent(final yd itemStack) {
        return itemStack != null && itemStack.b().cv != yb.F.cv;
    }
    
    public int countDamageableParts(final mn matrix) {
        int count = 0;
        for (int i = 0; i < matrix.j_(); ++i) {
            if (this.isDamageableComponent(matrix.a(i))) {
                ++count;
            }
        }
        return count;
    }
    
    public int countDamagedParts(final yd input) {
        final int totalMax4 = Math.max(4, this.countDamageableParts((mn)this.uncraftingMatrix));
        final float damage = input.k() / (float)input.l();
        final int damagedParts = (int)Math.ceil(totalMax4 * damage);
        return damagedParts;
    }
    
    public yd b(final ue player, final int slotNum) {
        yd copyItem = null;
        final wd transferSlot = this.c.get(slotNum);
        if (transferSlot != null && transferSlot.e()) {
            final yd transferStack = transferSlot.d();
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
            if (transferStack.b == 0) {
                transferSlot.c((yd)null);
            }
            else {
                transferSlot.f();
            }
            if (transferStack.b == copyItem.b) {
                return null;
            }
            transferSlot.a(player, transferStack);
        }
        return copyItem;
    }
    
    public void b(final ue par1EntityPlayer) {
        super.b(par1EntityPlayer);
        if (!this.worldObj.I) {
            for (int i = 0; i < 9; ++i) {
                final yd assemblyStack = this.assemblyMatrix.a_(i);
                if (assemblyStack != null) {
                    par1EntityPlayer.b(assemblyStack);
                }
            }
            final yd inputStack = this.tinkerInput.a_(0);
            if (inputStack != null) {
                par1EntityPlayer.b(inputStack);
            }
        }
    }
    
    public yd[] getRecipeItems(final aag recipe) {
        if (recipe instanceof aah) {
            return this.getRecipeItemsShaped((aah)recipe);
        }
        if (recipe instanceof ShapedOreRecipe) {
            return this.getRecipeItemsOre((ShapedOreRecipe)recipe);
        }
        return null;
    }
    
    public yd[] getRecipeItemsShaped(final aah shaped) {
        return shaped.d;
    }
    
    public yd[] getRecipeItemsOre(final ShapedOreRecipe shaped) {
        try {
            final Object[] objects = (Object[])ObfuscationReflectionHelper.getPrivateValue((Class)ShapedOreRecipe.class, (Object)shaped, 3);
            final yd[] items = new yd[objects.length];
            for (int i = 0; i < objects.length; ++i) {
                if (objects[i] instanceof yd) {
                    items[i] = (yd)objects[i];
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
    
    public int getRecipeWidth(final aag recipe) {
        if (recipe instanceof aah) {
            return this.getRecipeWidthShaped((aah)recipe);
        }
        if (recipe instanceof ShapedOreRecipe) {
            return this.getRecipeWidthOre((ShapedOreRecipe)recipe);
        }
        return -1;
    }
    
    public int getRecipeWidthShaped(final aah shaped) {
        return shaped.b;
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
    
    public int getRecipeHeight(final aag recipe) {
        if (recipe instanceof aah) {
            return this.getRecipeHeightShaped((aah)recipe);
        }
        if (recipe instanceof ShapedOreRecipe) {
            return this.getRecipeHeightOre((ShapedOreRecipe)recipe);
        }
        return -1;
    }
    
    public int getRecipeHeightShaped(final aah shaped) {
        return shaped.c;
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
    
    public boolean a(final ue var1) {
        return true;
    }
}
