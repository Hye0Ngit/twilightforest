// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.Iterator;

public class ContainerTFGoblinCrafting extends dd
{
    public InventoryTFGoblinUncrafting uncraftingMatrix;
    public ade assemblyMatrix;
    public ade combineMatrix;
    public io tinkerInput;
    public io tinkerResult;
    private xd worldObj;
    private int posX;
    private int posY;
    private int posZ;
    
    public ContainerTFGoblinCrafting(final aak inventory, final xd world, final int x, final int y, final int z) {
        this.uncraftingMatrix = new InventoryTFGoblinUncrafting(this);
        this.assemblyMatrix = new ade((dd)this, 3, 3);
        this.combineMatrix = new ade((dd)this, 3, 3);
        this.tinkerInput = (io)new InventoryTFGoblinInput(this);
        this.tinkerResult = (io)new akk();
        this.worldObj = world;
        this.posX = x;
        this.posY = y;
        this.posZ = z;
        this.a(new yu(this.tinkerInput, 0, 13, 35));
        this.a((yu)new SlotTFGoblinCraftResult(inventory.d, this.tinkerInput, (io)this.uncraftingMatrix, (io)this.assemblyMatrix, this.tinkerResult, 0, 147, 35));
        for (int invX = 0; invX < 3; ++invX) {
            for (int invY = 0; invY < 3; ++invY) {
                this.a((yu)new SlotTFGoblinUncrafting(inventory.d, this.tinkerInput, this.uncraftingMatrix, (io)this.assemblyMatrix, invY + invX * 3, 300000 + invY * 18, 17 + invX * 18));
            }
        }
        for (int invX = 0; invX < 3; ++invX) {
            for (int invY = 0; invY < 3; ++invY) {
                this.a((yu)new SlotTFGoblinAssembly(inventory.d, this.tinkerInput, (io)this.assemblyMatrix, (io)this.uncraftingMatrix, invY + invX * 3, 62 + invY * 18, 17 + invX * 18));
            }
        }
        for (int invX = 0; invX < 3; ++invX) {
            for (int invY = 0; invY < 9; ++invY) {
                this.a(new yu((io)inventory, invY + invX * 9 + 9, 8 + invY * 18, 84 + invX * 18));
            }
        }
        for (int invX = 0; invX < 9; ++invX) {
            this.a(new yu((io)inventory, invX, 8 + invX * 18, 142));
        }
        this.a((io)this.assemblyMatrix);
    }
    
    public void a(final io par1IInventory) {
        if (par1IInventory == this.tinkerInput) {
            final aan inputStack = this.tinkerInput.k_(0);
            final aai recipe = this.getRecipeFor(inputStack);
            if (recipe != null) {
                final int recipeWidth = this.getRecipeWidth(recipe);
                final int recipeHeight = this.getRecipeHeight(recipe);
                final aan[] recipeItems = this.getRecipeItems(recipe);
                for (int invY = 0; invY < recipeHeight; ++invY) {
                    for (int invX = 0; invX < recipeWidth; ++invX) {
                        this.uncraftingMatrix.a(invX + invY * 3, aan.b(recipeItems[invX + invY * recipeWidth]));
                    }
                }
                if (inputStack.g()) {
                    final int totalParts = this.countDamageableParts((io)this.uncraftingMatrix);
                    final float damage = inputStack.i() / (float)inputStack.j();
                    for (int damagedParts = (int)Math.ceil(totalParts * damage), i = 0; i < 9 && damagedParts > 0; ++i) {
                        if (this.isDamageableComponent(this.uncraftingMatrix.k_(i))) {
                            this.uncraftingMatrix.k_(i).a = 0;
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
                this.tinkerResult.a(0, fr.a().a(this.assemblyMatrix));
                this.uncraftingMatrix.recraftingCost = 0;
            }
            else {
                this.tinkerResult.a(0, (aan)null);
                this.uncraftingMatrix.uncraftingCost = this.calculateUncraftingCost();
                this.uncraftingMatrix.recraftingCost = 0;
            }
        }
        if (par1IInventory != this.combineMatrix && !this.isMatrixEmpty((io)this.uncraftingMatrix) && !this.isMatrixEmpty((io)this.assemblyMatrix)) {
            for (int k = 0; k < 9; ++k) {
                if (this.assemblyMatrix.k_(k) != null) {
                    this.combineMatrix.a(k, this.assemblyMatrix.k_(k));
                }
                else if (this.uncraftingMatrix.k_(k) != null && this.uncraftingMatrix.k_(k).a > 0) {
                    this.combineMatrix.a(k, this.uncraftingMatrix.k_(k));
                }
                else {
                    this.combineMatrix.a(k, (aan)null);
                }
            }
            final aan result = fr.a().a(this.combineMatrix);
            if (result != null && this.isValidMatchForInput(this.tinkerInput.k_(0), result)) {
                final ady inputEnchantments = this.tinkerInput.k_(0).o();
                if (inputEnchantments != null) {
                    result.d((ady)inputEnchantments.b());
                }
                this.tinkerResult.a(0, result);
                this.uncraftingMatrix.uncraftingCost = 0;
                this.uncraftingMatrix.recraftingCost = this.calculateRecraftingCost();
            }
        }
    }
    
    public aai getRecipeFor(final aan inputStack) {
        if (inputStack != null) {
            for (final wf recipe : fr.a().b()) {
                if (recipe instanceof aai && recipe.b().c == inputStack.c && inputStack.a >= recipe.b().a && (!recipe.b().f() || recipe.b().i() == inputStack.i())) {
                    return (aai)recipe;
                }
            }
        }
        return null;
    }
    
    public boolean isValidMatchForInput(final aan inputStack, final aan resultStack) {
        if (inputStack.a() instanceof au && resultStack.a() instanceof au) {
            return true;
        }
        if (inputStack.a() instanceof nx && resultStack.a() instanceof nx) {
            return true;
        }
        if (inputStack.a() instanceof akd && resultStack.a() instanceof akd) {
            return true;
        }
        if (inputStack.a() instanceof ic && resultStack.a() instanceof ic) {
            return true;
        }
        if (inputStack.a() instanceof lx && resultStack.a() instanceof lx) {
            return true;
        }
        if (inputStack.a() instanceof mm && resultStack.a() instanceof mm) {
            return true;
        }
        if (inputStack.a() instanceof ql && resultStack.a() instanceof ql) {
            final ql inputArmor = (ql)inputStack.a();
            final ql resultArmor = (ql)resultStack.a();
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
        if (!this.isMatrixEmpty((io)this.assemblyMatrix)) {
            return 0;
        }
        return this.countDamageableParts((io)this.uncraftingMatrix);
    }
    
    public int calculateRecraftingCost() {
        if (this.tinkerInput.k_(0) == null || !this.tinkerInput.k_(0).u() || this.tinkerResult.k_(0) == null) {
            return 0;
        }
        final aan input = this.tinkerInput.k_(0);
        final aan result = this.tinkerResult.k_(0);
        final int costHigh = this.countHighestEnchantmentCost(input);
        final int costTotal = this.countTotalEnchantmentCost(input);
        int cost = costHigh;
        cost -= result.a().b();
        if (input.c == result.c) {
            final int totalParts = this.countDamageableParts((io)this.uncraftingMatrix);
            final float damage = input.i() / (float)input.j();
            final int damagedParts = (int)Math.ceil(totalParts * damage);
            final float repairModifier = damagedParts / (float)totalParts;
            System.out.println("Repair modifier is " + repairModifier);
            cost *= (int)repairModifier;
        }
        cost = Math.max(1, cost);
        return cost;
    }
    
    public int countHighestEnchantmentCost(final aan itemStack) {
        int count = 0;
        for (final jt ench : jt.a) {
            if (ench != null) {
                final int level = ais.a(ench.w, itemStack);
                if (level > count) {
                    count = ench.a(level);
                }
            }
        }
        return count;
    }
    
    public int countTotalEnchantmentCost(final aan itemStack) {
        int count = 0;
        for (final jt ench : jt.a) {
            if (ench != null) {
                final int level = ais.a(ench.w, itemStack);
                if (level > 0) {
                    count += ench.a(level);
                }
            }
        }
        return count;
    }
    
    public aan a(int slotNum, final int mouseButton, final boolean shiftHeld, final yw par4EntityPlayer) {
        if (slotNum > -999 && par4EntityPlayer.ap.k() == null && this.e.get(slotNum).b == this.assemblyMatrix && !this.e.get(slotNum).c() && this.isMatrixEmpty((io)this.assemblyMatrix)) {
            slotNum -= 9;
        }
        if (slotNum > -999 && this.e.get(slotNum).b == this.tinkerResult && this.calculateRecraftingCost() > par4EntityPlayer.aU && !par4EntityPlayer.aT.d) {
            return null;
        }
        if (slotNum > -999 && this.e.get(slotNum).b == this.uncraftingMatrix && this.calculateUncraftingCost() > par4EntityPlayer.aU && !par4EntityPlayer.aT.d) {
            return null;
        }
        if (slotNum > -999 && this.e.get(slotNum).b == this.uncraftingMatrix && this.e.get(slotNum).b().a == 0) {
            return null;
        }
        final aan ret = super.a(slotNum, mouseButton, shiftHeld, par4EntityPlayer);
        if (slotNum > -999 && this.e.get(slotNum).b instanceof InventoryTFGoblinInput) {
            this.a(this.tinkerInput);
        }
        return ret;
    }
    
    private boolean isMatrixEmpty(final io matrix) {
        boolean matrixEmpty = true;
        for (int i = 0; i < matrix.a(); ++i) {
            if (matrix.k_(i) != null) {
                matrixEmpty = false;
            }
        }
        return matrixEmpty;
    }
    
    public boolean isDamageableComponent(final aan itemStack) {
        return itemStack != null && itemStack.a().bQ != yr.D.bQ;
    }
    
    public int countDamageableParts(final io matrix) {
        int count = 0;
        for (int i = 0; i < matrix.a(); ++i) {
            if (this.isDamageableComponent(matrix.k_(i))) {
                ++count;
            }
        }
        return count;
    }
    
    public aan a(final int slotNum) {
        aan copyItem = null;
        final yu transferSlot = this.e.get(slotNum);
        if (transferSlot != null && transferSlot.c()) {
            final aan transferStack = transferSlot.b();
            copyItem = transferStack.k();
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
                transferSlot.d((aan)null);
            }
            else {
                transferSlot.d();
            }
            if (transferStack.a == copyItem.a) {
                return null;
            }
            transferSlot.b(transferStack);
        }
        return copyItem;
    }
    
    public void a(final yw par1EntityPlayer) {
        super.a(par1EntityPlayer);
        if (!this.worldObj.F) {
            for (int i = 0; i < 9; ++i) {
                final aan assemblyStack = this.assemblyMatrix.b(i);
                if (assemblyStack != null) {
                    par1EntityPlayer.a(assemblyStack);
                }
            }
            final aan inputStack = this.tinkerInput.b(0);
            if (inputStack != null) {
                par1EntityPlayer.a(inputStack);
            }
        }
    }
    
    public aan[] getRecipeItems(final aai shaped) {
        try {
            return (aan[])ModLoader.getPrivateValue((Class)aai.class, (Object)shaped, 2);
        }
        catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        catch (SecurityException e2) {
            e2.printStackTrace();
        }
        return null;
    }
    
    public int getRecipeWidth(final aai shaped) {
        try {
            return (int)ModLoader.getPrivateValue((Class)aai.class, (Object)shaped, 0);
        }
        catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        catch (SecurityException e2) {
            e2.printStackTrace();
        }
        return 0;
    }
    
    public int getRecipeHeight(final aai shaped) {
        try {
            return (int)ModLoader.getPrivateValue((Class)aai.class, (Object)shaped, 1);
        }
        catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        catch (SecurityException e2) {
            e2.printStackTrace();
        }
        return 0;
    }
    
    public boolean b(final yw var1) {
        return true;
    }
}
