// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.inventory;

import net.minecraft.util.math.BlockPos;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.Items;
import twilightforest.TFConfig;
import net.minecraft.inventory.container.ClickType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.BowItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.PickaxeItem;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.world.GameRules;
import net.minecraft.item.crafting.IRecipeType;
import java.util.List;
import net.minecraft.item.crafting.IRecipe;
import java.util.ArrayList;
import twilightforest.util.TFItemStackUtils;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.ByteNBT;
import java.util.Iterator;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.item.crafting.ICraftingRecipe;
import net.minecraft.enchantment.Enchantment;
import java.util.Map;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.crafting.IShapedRecipe;
import twilightforest.inventory.slot.AssemblySlot;
import twilightforest.inventory.slot.UncraftingSlot;
import twilightforest.inventory.slot.UncraftingResultSlot;
import net.minecraft.inventory.container.Slot;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.inventory.CraftResultInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.inventory.container.Container;

public class UncraftingContainer extends Container
{
    private static final String TAG_MARKER = "TwilightForestMarker";
    private final UncraftingInventory uncraftingMatrix;
    public final CraftingInventory assemblyMatrix;
    private final CraftingInventory combineMatrix;
    public final IInventory tinkerInput;
    private final CraftResultInventory tinkerResult;
    private final IWorldPosCallable positionData;
    private final World world;
    private final PlayerEntity player;
    public int unrecipeInCycle;
    public int ingredientsInCycle;
    public int recipeInCycle;
    
    public static UncraftingContainer fromNetwork(final int id, final PlayerInventory inventory) {
        return new UncraftingContainer(id, inventory, inventory.field_70458_d.field_70170_p, IWorldPosCallable.field_221489_a);
    }
    
    public UncraftingContainer(final int id, final PlayerInventory inventory, final World world, final IWorldPosCallable positionData) {
        super((ContainerType)TFContainers.UNCRAFTING.get(), id);
        this.uncraftingMatrix = new UncraftingInventory();
        this.assemblyMatrix = new CraftingInventory((Container)this, 3, 3);
        this.combineMatrix = new CraftingInventory((Container)this, 3, 3);
        this.tinkerInput = (IInventory)new UncraftingInputInventory(this);
        this.tinkerResult = new CraftResultInventory();
        this.unrecipeInCycle = 0;
        this.ingredientsInCycle = 0;
        this.recipeInCycle = 0;
        this.positionData = positionData;
        this.world = world;
        this.player = inventory.field_70458_d;
        this.func_75146_a(new Slot(this.tinkerInput, 0, 13, 35));
        this.func_75146_a((Slot)new UncraftingResultSlot(inventory.field_70458_d, this.tinkerInput, (IInventory)this.uncraftingMatrix, (IInventory)this.assemblyMatrix, (IInventory)this.tinkerResult, 0, 147, 35));
        for (int invX = 0; invX < 3; ++invX) {
            for (int invY = 0; invY < 3; ++invY) {
                this.func_75146_a((Slot)new UncraftingSlot(inventory.field_70458_d, this.tinkerInput, this.uncraftingMatrix, (IInventory)this.assemblyMatrix, invY + invX * 3, 300000 + invY * 18, 17 + invX * 18));
            }
        }
        for (int invX = 0; invX < 3; ++invX) {
            for (int invY = 0; invY < 3; ++invY) {
                this.func_75146_a((Slot)new AssemblySlot((IInventory)this.assemblyMatrix, invY + invX * 3, 62 + invY * 18, 17 + invX * 18));
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
    
    public void func_75130_a(final IInventory inventory) {
        if (inventory == this.tinkerInput) {
            this.uncraftingMatrix.func_174888_l();
            final ItemStack inputStack = this.tinkerInput.func_70301_a(0);
            final ICraftingRecipe[] recipes = getRecipesFor(inputStack, this.world);
            final int size = recipes.length;
            if (size > 0) {
                final ICraftingRecipe recipe = recipes[Math.floorMod(this.unrecipeInCycle, size)];
                final ItemStack[] recipeItems = this.getIngredients(recipe);
                if (recipe instanceof IShapedRecipe) {
                    final int recipeWidth = ((IShapedRecipe)recipe).getRecipeWidth();
                    for (int recipeHeight = ((IShapedRecipe)recipe).getRecipeHeight(), invY = 0; invY < recipeHeight; ++invY) {
                        for (int invX = 0; invX < recipeWidth; ++invX) {
                            final int index = invX + invY * recipeWidth;
                            if (index < recipeItems.length) {
                                final ItemStack ingredient = normalizeIngredient(recipeItems[index].func_77946_l());
                                this.uncraftingMatrix.func_70299_a(invX + invY * 3, ingredient);
                            }
                        }
                    }
                }
                else {
                    for (int i = 0; i < this.uncraftingMatrix.func_70302_i_(); ++i) {
                        if (i < recipeItems.length) {
                            final ItemStack ingredient2 = normalizeIngredient(recipeItems[i].func_77946_l());
                            this.uncraftingMatrix.func_70299_a(i, ingredient2);
                        }
                    }
                }
                if (inputStack.func_77951_h()) {
                    for (int damagedParts = this.countDamagedParts(inputStack), j = 0; j < 9 && damagedParts > 0; ++j) {
                        final ItemStack stack = this.uncraftingMatrix.func_70301_a(j);
                        if (isDamageableComponent(stack)) {
                            markStack(stack);
                            --damagedParts;
                        }
                    }
                }
                for (int i = 0; i < 9; ++i) {
                    final ItemStack ingredient2 = this.uncraftingMatrix.func_70301_a(i);
                    if (isIngredientProblematic(ingredient2)) {
                        markStack(ingredient2);
                    }
                }
                this.uncraftingMatrix.numberOfInputItems = recipe.func_77571_b().func_190916_E();
                this.uncraftingMatrix.uncraftingCost = this.calculateUncraftingCost();
                this.uncraftingMatrix.recraftingCost = 0;
            }
            else {
                this.uncraftingMatrix.numberOfInputItems = 0;
                this.uncraftingMatrix.uncraftingCost = 0;
            }
        }
        if (inventory == this.assemblyMatrix || inventory == this.tinkerInput) {
            if (this.tinkerInput.func_191420_l()) {
                this.chooseRecipe(this.assemblyMatrix);
                this.uncraftingMatrix.recraftingCost = 0;
            }
            else {
                this.tinkerResult.func_70299_a(0, ItemStack.field_190927_a);
                this.uncraftingMatrix.uncraftingCost = this.calculateUncraftingCost();
                this.uncraftingMatrix.recraftingCost = 0;
            }
        }
        if (inventory != this.combineMatrix && !this.uncraftingMatrix.func_191420_l() && !this.assemblyMatrix.func_191420_l()) {
            for (int k = 0; k < 9; ++k) {
                final ItemStack assembly = this.assemblyMatrix.func_70301_a(k);
                final ItemStack uncrafting = this.uncraftingMatrix.func_70301_a(k);
                if (!assembly.func_190926_b()) {
                    this.combineMatrix.func_70299_a(k, assembly);
                }
                else if (!uncrafting.func_190926_b() && !isMarked(uncrafting)) {
                    this.combineMatrix.func_70299_a(k, uncrafting);
                }
                else {
                    this.combineMatrix.func_70299_a(k, ItemStack.field_190927_a);
                }
            }
            this.chooseRecipe(this.combineMatrix);
            final ItemStack input = this.tinkerInput.func_70301_a(0);
            final ItemStack result = this.tinkerResult.func_70301_a(0);
            if (!result.func_190926_b() && isValidMatchForInput(input, result)) {
                CompoundNBT inputTags = null;
                if (input.func_77978_p() != null) {
                    inputTags = input.func_77978_p().func_74737_b();
                }
                final Map<Enchantment, Integer> resultInnateEnchantments = EnchantmentHelper.func_82781_a(result);
                final Map<Enchantment, Integer> inputEnchantments = EnchantmentHelper.func_82781_a(input);
                inputEnchantments.keySet().removeIf(enchantment -> enchantment == null || !enchantment.func_92089_a(result));
                if (inputTags != null) {
                    inputTags.func_82580_o("ench");
                    result.func_77982_d(inputTags);
                    EnchantmentHelper.func_82782_a((Map)inputEnchantments, result);
                }
                for (final Map.Entry<Enchantment, Integer> entry : resultInnateEnchantments.entrySet()) {
                    final Enchantment ench = entry.getKey();
                    final int level = entry.getValue();
                    if (EnchantmentHelper.func_77506_a(ench, result) < level) {
                        result.func_77966_a(ench, level);
                    }
                }
                this.tinkerResult.func_70299_a(0, result);
                this.uncraftingMatrix.uncraftingCost = 0;
                this.uncraftingMatrix.recraftingCost = this.calculateRecraftingCost();
                if (this.uncraftingMatrix.recraftingCost > 0 && !result.func_82837_s()) {
                    result.func_82841_c(input.func_82838_A() + 2);
                }
            }
        }
    }
    
    public static void markStack(final ItemStack stack) {
        stack.func_77983_a("TwilightForestMarker", (INBT)ByteNBT.func_229671_a_((byte)1));
    }
    
    public static boolean isMarked(final ItemStack stack) {
        final CompoundNBT stackTag = stack.func_77978_p();
        return stackTag != null && stackTag.func_74767_n("TwilightForestMarker");
    }
    
    public static void unmarkStack(final ItemStack stack) {
        TFItemStackUtils.clearInfoTag(stack, "TwilightForestMarker");
    }
    
    private static boolean isIngredientProblematic(final ItemStack ingredient) {
        return !ingredient.func_190926_b() && ingredient.func_77973_b().hasContainerItem(ingredient);
    }
    
    private static ItemStack normalizeIngredient(final ItemStack ingredient) {
        if (ingredient.func_190916_E() > 1) {
            ingredient.func_190920_e(1);
        }
        return ingredient;
    }
    
    private static ICraftingRecipe[] getRecipesFor(final ItemStack inputStack, final World world) {
        final List<ICraftingRecipe> recipes = new ArrayList<ICraftingRecipe>();
        if (!inputStack.func_190926_b()) {
            for (final IRecipe<?> recipe : world.func_199532_z().func_199510_b()) {
                if (recipe instanceof ICraftingRecipe && recipe.func_194133_a(3, 3) && !recipe.func_192400_c().isEmpty() && matches(inputStack, recipe.func_77571_b())) {
                    recipes.add((ICraftingRecipe)recipe);
                }
            }
        }
        return recipes.toArray(new ICraftingRecipe[0]);
    }
    
    private static boolean matches(final ItemStack input, final ItemStack output) {
        return input.func_77973_b() == output.func_77973_b() && input.func_190916_E() >= output.func_190916_E();
    }
    
    private static ICraftingRecipe[] getRecipesFor(final CraftingInventory matrix, final World world) {
        return world.func_199532_z().func_215370_b(IRecipeType.field_222149_a, (IInventory)matrix, world).toArray(new ICraftingRecipe[0]);
    }
    
    private void chooseRecipe(final CraftingInventory inventory) {
        final ICraftingRecipe[] recipes = getRecipesFor(inventory, this.world);
        if (recipes.length == 0) {
            this.tinkerResult.func_70299_a(0, ItemStack.field_190927_a);
            return;
        }
        final ICraftingRecipe recipe = recipes[Math.floorMod(this.recipeInCycle, recipes.length)];
        if (recipe != null && (recipe.func_192399_d() || !this.world.func_82736_K().func_223586_b(GameRules.field_223618_u) || ((ServerPlayerEntity)this.player).func_192037_E().func_193830_f((IRecipe)recipe))) {
            this.tinkerResult.func_193056_a((IRecipe)recipe);
            this.tinkerResult.func_70299_a(0, recipe.func_77572_b((IInventory)inventory));
        }
        else {
            this.tinkerResult.func_70299_a(0, ItemStack.field_190927_a);
        }
    }
    
    private static boolean isValidMatchForInput(final ItemStack inputStack, final ItemStack resultStack) {
        if (inputStack.func_77973_b() instanceof PickaxeItem && resultStack.func_77973_b() instanceof PickaxeItem) {
            return true;
        }
        if (inputStack.func_77973_b() instanceof AxeItem && resultStack.func_77973_b() instanceof AxeItem) {
            return true;
        }
        if (inputStack.func_77973_b() instanceof ShovelItem && resultStack.func_77973_b() instanceof ShovelItem) {
            return true;
        }
        if (inputStack.func_77973_b() instanceof HoeItem && resultStack.func_77973_b() instanceof HoeItem) {
            return true;
        }
        if (inputStack.func_77973_b() instanceof SwordItem && resultStack.func_77973_b() instanceof SwordItem) {
            return true;
        }
        if (inputStack.func_77973_b() instanceof BowItem && resultStack.func_77973_b() instanceof BowItem) {
            return true;
        }
        if (inputStack.func_77973_b() instanceof ArmorItem && resultStack.func_77973_b() instanceof ArmorItem) {
            final ArmorItem inputArmor = (ArmorItem)inputStack.func_77973_b();
            final ArmorItem resultArmor = (ArmorItem)resultStack.func_77973_b();
            return inputArmor.func_185083_B_() == resultArmor.func_185083_B_();
        }
        return false;
    }
    
    public int getUncraftingCost() {
        return this.uncraftingMatrix.uncraftingCost;
    }
    
    public int getRecraftingCost() {
        return this.uncraftingMatrix.recraftingCost;
    }
    
    private int calculateUncraftingCost() {
        return this.assemblyMatrix.func_191420_l() ? countDamageableParts((IInventory)this.uncraftingMatrix) : 0;
    }
    
    private int calculateRecraftingCost() {
        final ItemStack input = this.tinkerInput.func_70301_a(0);
        final ItemStack output = this.tinkerResult.func_70301_a(0);
        if (input.func_190926_b() || !input.func_77948_v() || output.func_190926_b()) {
            return 0;
        }
        int cost = 0;
        cost += input.func_82838_A();
        final int enchantCost = countTotalEnchantmentCost(input);
        cost += enchantCost;
        final int damagedCost = (1 + this.countDamagedParts(input)) * EnchantmentHelper.func_82781_a(output).size();
        cost += damagedCost;
        final int enchantabilityDifference = input.func_77973_b().func_77619_b() - output.func_77973_b().func_77619_b();
        cost += enchantabilityDifference;
        cost = Math.max(1, cost);
        return cost;
    }
    
    private static int countTotalEnchantmentCost(final ItemStack stack) {
        int count = 0;
        for (final Map.Entry<Enchantment, Integer> entry : EnchantmentHelper.func_82781_a(stack).entrySet()) {
            final Enchantment ench = entry.getKey();
            final int level = entry.getValue();
            if (ench != null && level > 0) {
                count += getWeightModifier(ench) * level;
                ++count;
            }
        }
        return count;
    }
    
    private static int getWeightModifier(final Enchantment ench) {
        switch (ench.func_77324_c().func_185270_a()) {
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
    
    public ItemStack func_184996_a(int slotNum, final int mouseButton, final ClickType clickType, final PlayerEntity player) {
        if (slotNum > 0 && this.field_75151_b.get(slotNum).field_75224_c == this.assemblyMatrix && player.field_71071_by.func_70445_o().func_190926_b() && !this.field_75151_b.get(slotNum).func_75216_d() && this.assemblyMatrix.func_191420_l()) {
            slotNum -= 9;
        }
        if (slotNum > 0 && this.field_75151_b.get(slotNum).field_75224_c == this.tinkerResult && this.calculateRecraftingCost() > player.field_71068_ca && !player.field_71075_bZ.field_75098_d) {
            return ItemStack.field_190927_a;
        }
        if (slotNum > 0 && this.field_75151_b.get(slotNum).field_75224_c == this.uncraftingMatrix) {
            if (this.calculateUncraftingCost() > player.field_71068_ca && !player.field_71075_bZ.field_75098_d) {
                return ItemStack.field_190927_a;
            }
            if (TFConfig.COMMON_CONFIG.disableUncrafting.get()) {
                return ItemStack.field_190927_a;
            }
            final ItemStack stackInSlot = this.field_75151_b.get(slotNum).func_75211_c();
            if (stackInSlot.func_190926_b() || isMarked(stackInSlot)) {
                return ItemStack.field_190927_a;
            }
        }
        final ItemStack ret = super.func_184996_a(slotNum, mouseButton, clickType, player);
        if (slotNum > 0 && this.field_75151_b.get(slotNum).field_75224_c == this.tinkerInput) {
            this.func_75130_a(this.tinkerInput);
        }
        return ret;
    }
    
    private static boolean isDamageableComponent(final ItemStack itemStack) {
        return !itemStack.func_190926_b() && itemStack.func_77973_b() != Items.field_151055_y;
    }
    
    private static int countDamageableParts(final IInventory matrix) {
        int count = 0;
        for (int i = 0; i < matrix.func_70302_i_(); ++i) {
            if (isDamageableComponent(matrix.func_70301_a(i))) {
                ++count;
            }
        }
        return count;
    }
    
    private int countDamagedParts(final ItemStack input) {
        final int totalMax4 = Math.max(4, countDamageableParts((IInventory)this.uncraftingMatrix));
        final float damage = input.func_77952_i() / (float)input.func_77958_k();
        return (int)Math.ceil(totalMax4 * damage);
    }
    
    public ItemStack func_82846_b(final PlayerEntity player, final int slotNum) {
        final Slot transferSlot = this.field_75151_b.get(slotNum);
        if (transferSlot == null || !transferSlot.func_75216_d()) {
            return ItemStack.field_190927_a;
        }
        final ItemStack transferStack = transferSlot.func_75211_c();
        final ItemStack copyItem = transferStack.func_77946_l();
        if (slotNum == 0) {
            if (!this.func_75135_a(transferStack, 20, 56, true)) {
                return ItemStack.field_190927_a;
            }
            transferSlot.func_75220_a(transferStack, copyItem);
        }
        else if (slotNum == 1) {
            transferStack.func_77973_b().func_77622_d(transferStack, this.world, player);
            if (!this.func_75135_a(transferStack, 20, 56, true)) {
                return ItemStack.field_190927_a;
            }
            transferSlot.func_75220_a(transferStack, copyItem);
        }
        else if (slotNum >= 20 && slotNum < 47) {
            if (!this.func_75135_a(transferStack, 0, 1, false) && !this.func_75135_a(transferStack, 47, 56, false)) {
                return ItemStack.field_190927_a;
            }
        }
        else if (slotNum >= 47 && slotNum < 56) {
            if (!this.func_75135_a(transferStack, 0, 1, false) && !this.func_75135_a(transferStack, 20, 47, false)) {
                return ItemStack.field_190927_a;
            }
        }
        else if (!this.func_75135_a(transferStack, 20, 56, false)) {
            return ItemStack.field_190927_a;
        }
        if (transferStack.func_190916_E() == 0) {
            transferSlot.func_75215_d(ItemStack.field_190927_a);
        }
        else {
            transferSlot.func_75218_e();
        }
        if (transferStack.func_190916_E() == copyItem.func_190916_E()) {
            return ItemStack.field_190927_a;
        }
        return transferSlot.func_190901_a(player, transferStack);
    }
    
    public void func_75134_a(final PlayerEntity player) {
        super.func_75134_a(player);
        this.positionData.func_221486_a((world, pos) -> {
            this.func_193327_a(player, world, (IInventory)this.assemblyMatrix);
            this.func_193327_a(player, world, this.tinkerInput);
        });
    }
    
    private ItemStack[] getIngredients(final ICraftingRecipe recipe) {
        final ItemStack[] stacks = new ItemStack[recipe.func_192400_c().size()];
        for (int i = 0; i < recipe.func_192400_c().size(); ++i) {
            final ItemStack[] matchingStacks = ((Ingredient)recipe.func_192400_c().get(i)).func_193365_a();
            stacks[i] = ((matchingStacks.length > 0) ? matchingStacks[Math.floorMod(this.ingredientsInCycle, matchingStacks.length)] : ItemStack.field_190927_a);
        }
        return stacks;
    }
    
    public boolean func_75145_c(final PlayerEntity player) {
        return func_216963_a(this.positionData, player, (Block)TFBlocks.uncrafting_table.get());
    }
}
